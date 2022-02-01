package com.tencent.qcircle.weseevideo.editor.sticker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.autotemplate.filter.GaosiBlurFilter;
import com.tencent.autotemplate.filter.ScaleTextureFilter;
import com.tencent.qcircle.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.qcircle.weseevideo.composition.effectnode.WSOverLayBlurManager;
import com.tencent.qcircle.weseevideo.composition.effectnode.WSOverLayBlurManager.SourceImageObserver;
import com.tencent.qcircle.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.ciimage.TAVGLUtils;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGView;

class BlurStickerEditView
  extends WsStickerEditView
  implements WSOverLayBlurManager.SourceImageObserver
{
  private static final String TAG = "BlurStickerEditView";
  private volatile Bitmap bgBitmap;
  private Paint blurBgPaint = new Paint();
  private Paint blurTextPaint = new Paint();
  private CIImage curCIImage;
  private GaosiBlurFilter hBlurFilter = new GaosiBlurFilter(true, 10);
  CountDownLatch latch = new CountDownLatch(0);
  ReentrantLock lock = new ReentrantLock();
  private Handler playerThreadHandler;
  private ScaleTextureFilter scaleBigTextureFilter = new ScaleTextureFilter();
  private ScaleTextureFilter scaleSmallTextureFilter = new ScaleTextureFilter();
  private String textPngPath;
  private HashMap<String, TextureInfo> textureMap = new HashMap();
  private String texturePngPath;
  private GaosiBlurFilter vBlurFilter = new GaosiBlurFilter(false, 10);
  private float xScale = -1.0F;
  private float xScaleMax = 0.0F;
  private float xScaleMin = 0.0F;
  private float yScale = -1.0F;
  private float yScaleMax = 0.0F;
  private float yScaleMin = 0.0F;
  
  public BlurStickerEditView(Context paramContext, TAVSticker paramTAVSticker, StickerEditViewIconConfig paramStickerEditViewIconConfig)
  {
    super(paramContext, paramTAVSticker, paramStickerEditViewIconConfig);
    initBlurBgPaint();
    this.pagView.setVisibility(4);
    this.eventType = 13;
  }
  
  private void drawBlurBgTexture(Canvas paramCanvas)
  {
    try
    {
      localObject = getStickerRectF();
      if (this.bgBitmap != null)
      {
        BitmapShader localBitmapShader = new BitmapShader(this.bgBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.blurBgPaint.setShader(localBitmapShader);
        paramCanvas.drawRoundRect((RectF)localObject, this.STICKER_CORNER_RADIUS, this.STICKER_CORNER_RADIUS, this.blurBgPaint);
        if (this.playerThreadHandler != null) {
          this.playerThreadHandler.post(new BlurStickerEditView.1(this));
        }
      }
      else
      {
        Log.e("BlurStickerEditView", "drawBlurBgTexture: 模糊纹理为空！");
        paramCanvas = WSOverLayBlurManager.getSourceCIImage();
        localObject = WSOverLayBlurManager.getRenderInfo();
        if (this.playerThreadHandler != null)
        {
          this.playerThreadHandler.post(new BlurStickerEditView.2(this, paramCanvas, (RenderInfo)localObject));
          return;
        }
      }
    }
    catch (Exception paramCanvas)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateBgPaint: ");
      ((StringBuilder)localObject).append(paramCanvas.toString());
      Log.e("BlurStickerEditView", ((StringBuilder)localObject).toString());
    }
  }
  
  private TextureInfo extractTextureInfoFromCIImage(CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    return paramRenderInfo.getCiContext().convertImageToTexture(paramCIImage, getCacheTextureInfo((int)paramCIImage.getSize().width, (int)paramCIImage.getSize().height));
  }
  
  private TextureInfo getCacheTextureInfo(int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramInt2);
    String str = ((StringBuilder)localObject1).toString();
    if (this.textureMap.containsKey(str)) {
      localObject1 = (TextureInfo)this.textureMap.get(str);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = CIContext.newTextureInfo(paramInt1, paramInt2);
      this.textureMap.put(str, localObject2);
    }
    return localObject2;
  }
  
  @NotNull
  private RectF getStickerRectF()
  {
    RectF localRectF = new RectF();
    localRectF.left = (this.centerX - TAVStickerExKt.getStickerScaleX(this.sticker) * this.stickerBorderRect.width() / 2.0F);
    localRectF.right = (this.centerX + TAVStickerExKt.getStickerScaleX(this.sticker) * this.stickerBorderRect.width() / 2.0F);
    localRectF.top = (this.centerY - TAVStickerExKt.getStickerScaleY(this.sticker) * this.stickerBorderRect.height() / 2.0F);
    localRectF.bottom = (this.centerY + TAVStickerExKt.getStickerScaleY(this.sticker) * this.stickerBorderRect.height() / 2.0F);
    return localRectF;
  }
  
  private float handleScaleXLimit(float paramFloat)
  {
    float f2 = this.xScaleMin;
    float f1 = paramFloat;
    if (f2 > 0.0F)
    {
      f1 = paramFloat;
      if (paramFloat < f2) {
        f1 = f2;
      }
    }
    f2 = this.xScaleMax;
    paramFloat = f1;
    if (f2 > 0.0F)
    {
      paramFloat = f1;
      if (f1 > f2) {
        paramFloat = f2;
      }
    }
    return paramFloat;
  }
  
  private float handleScaleYLimit(float paramFloat)
  {
    float f2 = this.yScaleMin;
    float f1 = paramFloat;
    if (f2 > 0.0F)
    {
      f1 = paramFloat;
      if (paramFloat < f2) {
        f1 = f2;
      }
    }
    f2 = this.yScaleMax;
    paramFloat = f1;
    if (f2 > 0.0F)
    {
      paramFloat = f1;
      if (f1 > f2) {
        paramFloat = f2;
      }
    }
    return paramFloat;
  }
  
  private void initBlurBgPaint()
  {
    this.blurBgPaint = new Paint();
    this.blurBgPaint.setAntiAlias(true);
    this.blurTextPaint = new Paint();
    this.blurTextPaint.setAntiAlias(true);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Object localObject = getOriginalVertexPoints();
    if (localObject != null) {
      this.stickerBorderRect.set(localObject[0].x, localObject[0].y, localObject[2].x, localObject[3].y);
    }
    localObject = this.texturePngPath;
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      drawBlurBgTexture(paramCanvas);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void drawBorder(Canvas paramCanvas)
  {
    PointF[] arrayOfPointF = getOriginalVertexPoints();
    if (arrayOfPointF == null) {
      return;
    }
    if (arrayOfPointF.length >= 4)
    {
      paramCanvas.save();
      this.stickerMatrix.reset();
      this.stickerMatrix.postTranslate(this.centerX - this.originalCenterX, this.centerY - this.originalCenterY);
      this.stickerMatrix.postRotate(getSticker().getRotate(), this.centerX, this.centerY);
      if (this.sticker.getExtraBundle().getBoolean("key_sticker_lock_ratio")) {
        this.stickerMatrix.postScale(this.sticker.getScale(), this.sticker.getScale(), this.centerX, this.centerY);
      } else {
        this.stickerMatrix.postScale(TAVStickerExKt.getStickerScaleX(this.sticker), TAVStickerExKt.getStickerScaleY(this.sticker), this.centerX, this.centerY);
      }
      paramCanvas.concat(this.stickerMatrix);
      this.stickerBorderRect.set(arrayOfPointF[0].x, arrayOfPointF[0].y, arrayOfPointF[2].x, arrayOfPointF[3].y);
      Path localPath = new Path();
      this.borderPaint.setStrokeJoin(Paint.Join.ROUND);
      localPath.moveTo(arrayOfPointF[0].x, arrayOfPointF[0].y);
      localPath.lineTo(arrayOfPointF[1].x, arrayOfPointF[1].y);
      localPath.moveTo(arrayOfPointF[2].x, arrayOfPointF[2].y);
      localPath.lineTo(arrayOfPointF[3].x, arrayOfPointF[3].y);
      this.borderPaint.setStrokeWidth(this.DEFAULT_BORDER_STROKE_WIDTH / this.yScale);
      paramCanvas.drawPath(localPath, this.borderPaint);
      localPath = new Path();
      localPath.moveTo(arrayOfPointF[1].x, arrayOfPointF[1].y);
      localPath.lineTo(arrayOfPointF[2].x, arrayOfPointF[2].y);
      localPath.moveTo(arrayOfPointF[3].x, arrayOfPointF[3].y);
      localPath.lineTo(arrayOfPointF[0].x, arrayOfPointF[0].y);
      this.borderPaint.setStrokeWidth(this.DEFAULT_BORDER_STROKE_WIDTH / this.xScale);
      paramCanvas.drawPath(localPath, this.borderPaint);
      paramCanvas.restore();
    }
  }
  
  protected void drawDeleteBtn(Canvas paramCanvas)
  {
    Object localObject = getOriginalVertexPoints();
    if (localObject == null) {
      return;
    }
    paramCanvas.save();
    if ((localObject != null) && (localObject.length >= 4))
    {
      float f1 = localObject[0].x;
      float f2 = localObject[0].y;
      paramCanvas.concat(this.stickerMatrix);
      paramCanvas.scale(this.OPERATION_BUTTON_SCALE / TAVStickerExKt.getStickerScaleX(this.sticker), this.OPERATION_BUTTON_SCALE / TAVStickerExKt.getStickerScaleY(this.sticker), f1, f2);
      localObject = new Rect(0, 0, this.bmpDelete.getWidth(), this.bmpDelete.getHeight());
      this.deleteBtnRect = new RectF(f1 - this.bmpDelete.getWidth(), f2 - this.bmpDelete.getHeight(), f1 + this.bmpDelete.getWidth(), f2 + this.bmpDelete.getHeight());
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      paramCanvas.drawBitmap(this.bmpDelete, (Rect)localObject, this.deleteBtnRect, null);
    }
    paramCanvas.getMatrix().mapRect(this.deleteBtnRect);
    paramCanvas.restore();
  }
  
  protected void drawZoomBtn(Canvas paramCanvas)
  {
    Object localObject = getOriginalVertexPoints();
    if (localObject == null) {
      return;
    }
    paramCanvas.save();
    if ((localObject != null) && (localObject.length >= 4))
    {
      float f1 = localObject[2].x;
      float f2 = localObject[2].y;
      paramCanvas.concat(this.stickerMatrix);
      paramCanvas.scale(this.OPERATION_BUTTON_SCALE / TAVStickerExKt.getStickerScaleX(this.sticker), this.OPERATION_BUTTON_SCALE / TAVStickerExKt.getStickerScaleY(this.sticker), f1, f2);
      localObject = new Rect(0, 0, this.bmpZoom.getWidth(), this.bmpZoom.getHeight());
      this.zoomBtnRect = new RectF(f1 - this.bmpZoom.getWidth(), f2 - this.bmpZoom.getHeight(), f1 + this.bmpZoom.getWidth(), f2 + this.bmpZoom.getHeight());
      setSingleZoomRotateRect(this.zoomBtnRect);
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      paramCanvas.drawBitmap(this.bmpZoom, (Rect)localObject, this.zoomBtnRect, null);
    }
    paramCanvas.getMatrix().mapRect(this.zoomBtnRect);
    paramCanvas.restore();
  }
  
  protected View.OnTouchListener getStickerTouchListener()
  {
    return new BlurStickerEditView.TavStickerTouchListener(this);
  }
  
  protected void initScaleData()
  {
    this.xScale = TAVStickerExKt.getStickerScaleX(this.sticker);
    this.yScale = TAVStickerExKt.getStickerScaleY(this.sticker);
    float f3 = TAVStickerExKt.getStickerScaleMaxX(this.sticker);
    float f2 = TAVStickerExKt.getStickerScaleMaxY(this.sticker);
    float f4 = TAVStickerExKt.getStickerScaleMinX(this.sticker);
    float f5 = TAVStickerExKt.getSticerScaleMinY(this.sticker);
    float f1 = f3;
    if (f3 <= 0.0F) {
      f1 = this.moveRegionWidth * 1.0F / this.stickerWidth;
    }
    this.xScaleMax = f1;
    f1 = f2;
    if (f2 <= 0.0F) {
      f1 = this.moveRegionHeight * 1.0F / this.stickerHeight;
    }
    this.yScaleMax = f1;
    this.yScaleMin = Math.max(f4, 0.0F);
    this.xScaleMin = Math.max(f5, 0.0F);
    f1 = this.xScaleMax;
    if ((f1 > 0.0F) && (this.xScale > f1)) {
      this.xScale = f1;
    }
    f1 = this.yScaleMax;
    if ((f1 > 0.0F) && (this.yScale > f1)) {
      this.yScale = f1;
    }
    f1 = this.xScale;
    f2 = this.xScaleMin;
    if (f1 < f2) {
      this.xScale = f2;
    }
    f1 = this.yScale;
    f2 = this.yScaleMin;
    if (f1 < f2) {
      this.yScale = f2;
    }
    TAVStickerExKt.setStickerScaleY(this.sticker, this.yScale);
    TAVStickerExKt.setStickerScaleX(this.sticker, this.xScale);
    super.initScaleData();
  }
  
  protected void initStickerData()
  {
    this.xScale = this.sticker.getExtraBundle().getFloat("key_sticker_scale_x", 1.0F);
    this.yScale = this.sticker.getExtraBundle().getFloat("key_sticker_scale_y", 1.0F);
    this.texturePngPath = TAVStickerExKt.getStickerTexturePngPath(getSticker());
    this.textPngPath = TAVStickerExKt.getStickerTextPngPath(getSticker());
    super.initStickerData();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    CIImage localCIImage = this.curCIImage;
    if (localCIImage != null) {
      localCIImage.release();
    }
  }
  
  public void onSourceImageUpdated(CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    try
    {
      if (this.curCIImage != null) {
        this.curCIImage.release();
      }
      paramCIImage = extractTextureInfoFromCIImage(paramCIImage, paramRenderInfo);
      int i = paramCIImage.preferRotation;
      this.scaleSmallTextureFilter.release();
      this.hBlurFilter.release();
      this.vBlurFilter.release();
      paramCIImage = new CIImage(WSOverLayBlurManager.getBlurredTextureInfo(paramCIImage, getWidth(), getHeight(), i, 10, 0.25F, this.hBlurFilter, this.vBlurFilter, this.scaleSmallTextureFilter, this.scaleBigTextureFilter).clone());
      paramCIImage.applyPreferRotation(0);
      paramCIImage.applyFillInFrame(new CGRect(new PointF(0.0F, 0.0F), new CGSize(getWidth(), getHeight())), TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
      paramCIImage.applyFlip(false, true);
      this.curCIImage = paramCIImage;
      if (this.playerThreadHandler == null) {
        this.playerThreadHandler = new Handler();
      }
      paramRenderInfo = new StringBuilder();
      paramRenderInfo.append("Thread Name1: ");
      paramRenderInfo.append(Thread.currentThread().getName());
      Log.d("BlurStickerEditView", paramRenderInfo.toString());
      if (this.lock.tryLock())
      {
        this.bgBitmap = TAVGLUtils.saveBitmap(paramCIImage);
        postInvalidate();
        return;
      }
    }
    catch (Exception paramCIImage)
    {
      paramCIImage.printStackTrace();
    }
  }
  
  public void setMode(TAVStickerMode paramTAVStickerMode)
  {
    super.setMode(paramTAVStickerMode);
    if ((paramTAVStickerMode != TAVStickerMode.ACTIVE) && (getParent() != null)) {
      ((ViewGroup)getParent()).removeView(this);
    }
  }
  
  protected void setScale(float paramFloat)
  {
    if (TAVStickerExKt.isLockRatio(this.sticker))
    {
      super.setScale(paramFloat);
      return;
    }
    paramFloat = this.xScale;
    if ((paramFloat != -1.0F) && (this.yScale != -1.0F))
    {
      this.xScale = handleScaleXLimit(paramFloat);
      this.yScale = handleScaleYLimit(this.yScale);
      this.pagView.setScaleX(this.xScale);
      this.pagView.setScaleY(this.yScale);
      TAVStickerExKt.setStickerScaleX(this.sticker, this.xScale);
      TAVStickerExKt.setStickerScaleY(this.sticker, this.yScale);
      return;
    }
    this.pagView.setScaleX(TAVStickerExKt.getStickerScaleX(this.sticker));
    this.pagView.setScaleY(TAVStickerExKt.getStickerScaleY(this.sticker));
    this.xScale = TAVStickerExKt.getStickerScaleX(this.sticker);
    this.yScale = TAVStickerExKt.getStickerScaleY(this.sticker);
  }
  
  protected void updateBorderPaint()
  {
    if (0.0F != getSticker().getScale()) {
      this.borderPaint.setStrokeWidth(Math.min(this.DEFAULT_BORDER_STROKE_WIDTH / this.xScale, this.DEFAULT_BORDER_STROKE_WIDTH / this.yScale));
    }
  }
  
  protected void updateStickerOnAdjustLocation(float paramFloat1, float paramFloat2)
  {
    this.sticker.setCenterX(paramFloat1).setCenterY(paramFloat2);
    if (!TAVStickerExKt.isLockRatio(this.sticker))
    {
      if (this.xScale != -1.0F) {
        this.sticker.getExtraBundle().putFloat("key_sticker_scale_x", this.xScale);
      } else {
        this.xScale = TAVStickerExKt.getStickerScaleX(this.sticker);
      }
      if (this.yScale != -1.0F) {
        this.sticker.getExtraBundle().putFloat("key_sticker_scale_y", this.yScale);
      } else {
        this.yScale = TAVStickerExKt.getStickerScaleY(this.sticker);
      }
    }
    else
    {
      this.sticker.setScale(this.scale);
    }
    if (TAVStickerExKt.isRotateEnable(this.sticker)) {
      this.sticker.setRotate(this.rotate);
    }
  }
  
  protected void updateVertexPoints()
  {
    Object localObject = TAVStickerUtil.computeRectanglePoints(this.pagView.getMatrix(), this.stickerWidth, this.stickerHeight);
    this.vertexPoints[0] = localObject[0];
    this.vertexPoints[1] = localObject[1];
    this.vertexPoints[2] = localObject[2];
    this.vertexPoints[3] = localObject[3];
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateVertexPoints: ");
    ((StringBuilder)localObject).append(this.vertexPoints[0].toString());
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(this.vertexPoints[1].toString());
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(this.vertexPoints[2].toString());
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(this.vertexPoints[3].toString());
    Log.d("btn_pos", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.BlurStickerEditView
 * JD-Core Version:    0.7.0.1
 */