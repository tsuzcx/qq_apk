package com.tencent.weseevideo.editor.sticker;

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
import com.tencent.autotemplate.filter.GaosiBlurFilter;
import com.tencent.autotemplate.filter.ScaleTextureFilter;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.ciimage.TAVGLUtils;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import com.tencent.weseevideo.composition.effectnode.WSOverLayBlurManager;
import com.tencent.weseevideo.composition.effectnode.WSOverLayBlurManager.SourceImageObserver;
import com.tencent.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.weseevideo.editor.sticker.view.WsStickerEditView;
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
  }
  
  private void drawBlurBgTexture(Canvas paramCanvas)
  {
    try
    {
      Object localObject = getStickerRectF();
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
        paramCanvas = WSOverLayBlurManager.getInstance().getSourceCIImage();
        localObject = WSOverLayBlurManager.getInstance().getRenderInfo();
        if (this.playerThreadHandler != null)
        {
          this.playerThreadHandler.post(new BlurStickerEditView.2(this, paramCanvas, (RenderInfo)localObject));
          return;
        }
      }
    }
    catch (Exception paramCanvas)
    {
      Log.e("BlurStickerEditView", "updateBgPaint: " + paramCanvas.toString());
    }
  }
  
  private TextureInfo extractTextureInfoFromCIImage(CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    return paramRenderInfo.getCiContext().convertImageToTexture(paramCIImage, getCacheTextureInfo((int)paramCIImage.getSize().width, (int)paramCIImage.getSize().height));
  }
  
  private TextureInfo getCacheTextureInfo(int paramInt1, int paramInt2)
  {
    String str = paramInt1 + "_" + paramInt2;
    TextureInfo localTextureInfo1 = null;
    if (this.textureMap.containsKey(str)) {
      localTextureInfo1 = (TextureInfo)this.textureMap.get(str);
    }
    TextureInfo localTextureInfo2 = localTextureInfo1;
    if (localTextureInfo1 == null)
    {
      localTextureInfo2 = CIContext.newTextureInfo(paramInt1, paramInt2);
      this.textureMap.put(str, localTextureInfo2);
    }
    return localTextureInfo2;
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
    float f = paramFloat;
    if (this.xScaleMin > 0.0F)
    {
      f = paramFloat;
      if (paramFloat < this.xScaleMin) {
        f = this.xScaleMin;
      }
    }
    paramFloat = f;
    if (this.xScaleMax > 0.0F)
    {
      paramFloat = f;
      if (f > this.xScaleMax) {
        paramFloat = this.xScaleMax;
      }
    }
    return paramFloat;
  }
  
  private float handleScaleYLimit(float paramFloat)
  {
    float f = paramFloat;
    if (this.yScaleMin > 0.0F)
    {
      f = paramFloat;
      if (paramFloat < this.yScaleMin) {
        f = this.yScaleMin;
      }
    }
    paramFloat = f;
    if (this.yScaleMax > 0.0F)
    {
      paramFloat = f;
      if (f > this.yScaleMax) {
        paramFloat = this.yScaleMax;
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
  
  public void drawBorder(Canvas paramCanvas)
  {
    PointF[] arrayOfPointF = getOriginalVertexPoints();
    if (arrayOfPointF == null) {}
    do
    {
      return;
      if ((this.texturePngPath != null) && (this.texturePngPath.length() > 0)) {
        drawBlurBgTexture(paramCanvas);
      }
    } while (arrayOfPointF.length < 4);
    paramCanvas.save();
    this.stickerMatrix.reset();
    this.stickerMatrix.postTranslate(this.centerX - this.originalCenterX, this.centerY - this.originalCenterY);
    this.stickerMatrix.postRotate(getSticker().getRotate(), this.centerX, this.centerY);
    if (this.sticker.getExtraBundle().getBoolean("key_sticker_lock_ratio")) {
      this.stickerMatrix.postScale(this.sticker.getScale(), this.sticker.getScale(), this.centerX, this.centerY);
    }
    for (;;)
    {
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
      return;
      this.stickerMatrix.postScale(TAVStickerExKt.getStickerScaleX(this.sticker), TAVStickerExKt.getStickerScaleY(this.sticker), this.centerX, this.centerY);
    }
  }
  
  public void drawDeleteBtn(Canvas paramCanvas)
  {
    paramCanvas.save();
    Object localObject = this.vertexPoints;
    if ((localObject != null) && (localObject.length >= 4))
    {
      float f1 = localObject[0].x;
      float f2 = localObject[0].y;
      f2 = getStickerRectF().top;
      paramCanvas.rotate(getSticker().getRotate(), f1, f2);
      paramCanvas.scale(this.OPERATION_BUTTON_SCALE, this.OPERATION_BUTTON_SCALE, f1, f2);
      localObject = new Rect(0, 0, this.bmpDelete.getWidth(), this.bmpDelete.getHeight());
      this.deleteBtnRect = new RectF(f1 - this.bmpDelete.getWidth(), f2 - this.bmpDelete.getHeight(), f1 + this.bmpDelete.getWidth(), f2 + this.bmpDelete.getHeight());
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      paramCanvas.drawBitmap(this.bmpDelete, (Rect)localObject, this.deleteBtnRect, null);
    }
    paramCanvas.getMatrix().mapRect(this.deleteBtnRect);
    paramCanvas.restore();
  }
  
  public View.OnTouchListener getStickerTouchListener()
  {
    return new BlurStickerEditView.TavStickerTouchListener(this);
  }
  
  public void initScaleData()
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
    if (f2 <= 0.0F) {}
    for (f1 = this.moveRegionHeight * 1.0F / this.stickerHeight;; f1 = f2)
    {
      this.yScaleMax = f1;
      this.yScaleMin = Math.max(f4, 0.0F);
      this.xScaleMin = Math.max(f5, 0.0F);
      if ((this.xScaleMax > 0.0F) && (this.xScale > this.xScaleMax)) {
        this.xScale = this.xScaleMax;
      }
      if ((this.yScaleMax > 0.0F) && (this.yScale > this.yScaleMax)) {
        this.yScale = this.yScaleMax;
      }
      if (this.xScale < this.xScaleMin) {
        this.xScale = this.xScaleMin;
      }
      if (this.yScale < this.yScaleMin) {
        this.yScale = this.yScaleMin;
      }
      TAVStickerExKt.setStickerScaleY(this.sticker, this.yScale);
      TAVStickerExKt.setStickerScaleX(this.sticker, this.xScale);
      super.initScaleData();
      return;
    }
  }
  
  public void initStickerData()
  {
    this.xScale = this.sticker.getExtraBundle().getFloat("key_sticker_scale_x", 1.0F);
    this.yScale = this.sticker.getExtraBundle().getFloat("key_sticker_scale_y", 1.0F);
    this.texturePngPath = TAVStickerExKt.getStickerTexturePngPath(getSticker());
    this.textPngPath = TAVStickerExKt.getStickerTextPngPath(getSticker());
    super.initStickerData();
  }
  
  public void onSourceImageUpdated(CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    paramCIImage = extractTextureInfoFromCIImage(paramCIImage, paramRenderInfo);
    int i = paramCIImage.preferRotation;
    paramCIImage = new CIImage(WSOverLayBlurManager.getInstance().getBlurredTextureInfo(paramCIImage, getWidth(), getHeight(), i, 10, 0.25F, this.hBlurFilter, this.vBlurFilter, this.scaleSmallTextureFilter, this.scaleBigTextureFilter).clone());
    paramCIImage.applyPreferRotation(0);
    paramCIImage.applyFillInFrame(new CGRect(new PointF(0.0F, 0.0F), new CGSize(getWidth(), getHeight())), TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    paramCIImage.applyFlip(false, true);
    paramCIImage = extractTextureInfoFromCIImage(paramCIImage, paramRenderInfo);
    if (this.playerThreadHandler == null) {
      this.playerThreadHandler = new Handler();
    }
    Log.d("BlurStickerEditView", "Thread Name1: " + Thread.currentThread().getName());
    if (this.lock.tryLock())
    {
      this.bgBitmap = TAVGLUtils.saveBitmap(paramCIImage);
      postInvalidate();
    }
  }
  
  public void setScale(float paramFloat)
  {
    if (TAVStickerExKt.isLockRatio(this.sticker))
    {
      super.setScale(paramFloat);
      return;
    }
    if ((this.xScale != -1.0F) && (this.yScale != -1.0F))
    {
      this.xScale = handleScaleXLimit(this.xScale);
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
  
  public void updateBorderPaint()
  {
    if (0.0F != getSticker().getScale()) {
      this.borderPaint.setStrokeWidth(Math.min(this.DEFAULT_BORDER_STROKE_WIDTH / this.xScale, this.DEFAULT_BORDER_STROKE_WIDTH / this.yScale));
    }
  }
  
  public void updateStickerOnAdjustLocation(float paramFloat1, float paramFloat2)
  {
    this.sticker.setCenterX(paramFloat1).setCenterY(paramFloat2);
    if (!TAVStickerExKt.isLockRatio(this.sticker)) {
      if (this.xScale != -1.0F)
      {
        this.sticker.getExtraBundle().putFloat("key_sticker_scale_x", this.xScale);
        if (this.yScale == -1.0F) {
          break label114;
        }
        this.sticker.getExtraBundle().putFloat("key_sticker_scale_y", this.yScale);
      }
    }
    for (;;)
    {
      if (TAVStickerExKt.isRotateEnable(this.sticker)) {
        this.sticker.setRotate(this.rotate);
      }
      return;
      this.xScale = TAVStickerExKt.getStickerScaleX(this.sticker);
      break;
      label114:
      this.yScale = TAVStickerExKt.getStickerScaleY(this.sticker);
      continue;
      this.sticker.setScale(this.scale);
    }
  }
  
  public void updateVertexPoints()
  {
    PointF[] arrayOfPointF = TAVStickerUtil.computeRectanglePoints(this.pagView.getMatrix(), this.stickerWidth, this.stickerHeight);
    this.vertexPoints[0] = arrayOfPointF[0];
    this.vertexPoints[1] = arrayOfPointF[1];
    this.vertexPoints[2] = arrayOfPointF[2];
    this.vertexPoints[3] = arrayOfPointF[3];
    Log.d("btn_pos", "updateVertexPoints: " + this.vertexPoints[0].toString() + " " + this.vertexPoints[1].toString() + " " + this.vertexPoints[2].toString() + " " + this.vertexPoints[3].toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.BlurStickerEditView
 * JD-Core Version:    0.7.0.1
 */