package com.tencent.weseevideo.editor.sticker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnTouchListener;
import com.tencent.tavcut.R.drawable;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import com.tencent.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.weseevideo.editor.sticker.view.WsStickerEditView;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGView;

class BlurStickerEditView
  extends WsStickerEditView
{
  private static final String TAG = "BlurStickerEditView";
  private Paint blurBgPaint = new Paint();
  private Paint blurTextPaint = new Paint();
  private String textPngPath;
  private String texturePngPath;
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
      Object localObject2 = BitmapFactory.decodeFile(this.texturePngPath);
      Object localObject3 = BitmapFactory.decodeFile(this.textPngPath);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = BitmapFactory.decodeResource(getResources(), R.drawable.blur_texture);
      }
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = BitmapFactory.decodeResource(getResources(), R.drawable.blur_text);
      }
      localObject3 = getStickerRectF();
      Log.d("btn_pos", "drawBlurBgTexture: rectF = " + ((RectF)localObject3).toShortString());
      if (localObject1 != null)
      {
        localObject1 = new BitmapShader((Bitmap)localObject1, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.blurBgPaint.setShader((Shader)localObject1);
        paramCanvas.drawRoundRect((RectF)localObject3, this.STICKER_CORNER_RADIUS, this.STICKER_CORNER_RADIUS, this.blurBgPaint);
      }
      if (localObject2 != null)
      {
        localObject1 = new RectF();
        float f = ((Bitmap)localObject2).getHeight() * 1.0F / ((Bitmap)localObject2).getWidth();
        if (((RectF)localObject3).height() * 1.0F / ((RectF)localObject3).width() > f)
        {
          f *= ((RectF)localObject3).width();
          ((RectF)localObject1).left = ((RectF)localObject3).left;
          ((RectF)localObject1).right = ((RectF)localObject3).right;
          ((RectF)localObject1).top = (((RectF)localObject3).centerY() - f / 2.0F);
          ((RectF)localObject1).bottom = (((RectF)localObject3).centerY() + f / 2.0F);
        }
        for (;;)
        {
          paramCanvas.drawBitmap((Bitmap)localObject2, null, (RectF)localObject1, this.blurTextPaint);
          return;
          f = ((RectF)localObject3).height() / f;
          ((RectF)localObject1).top = ((RectF)localObject3).top;
          ((RectF)localObject1).bottom = ((RectF)localObject3).bottom;
          ((RectF)localObject1).left = (((RectF)localObject3).centerX() - f / 2.0F);
          ((RectF)localObject1).right = (((RectF)localObject3).centerX() + f / 2.0F);
        }
      }
      return;
    }
    catch (Exception paramCanvas)
    {
      Log.e("BlurStickerEditView", "updateBgPaint: " + paramCanvas.toString());
    }
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
  
  private void initBlurBgPaint()
  {
    this.blurBgPaint = new Paint();
    this.blurBgPaint.setAntiAlias(true);
    this.blurBgPaint.setColor(this.sticker.getStrokeColor());
    this.blurTextPaint = new Paint();
    this.blurTextPaint.setAntiAlias(true);
  }
  
  public void drawBorder(Canvas paramCanvas)
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
      if (!this.sticker.getExtraBundle().getBoolean("key_sticker_lock_ratio")) {
        break label217;
      }
      this.stickerMatrix.postScale(this.sticker.getScale(), this.sticker.getScale(), this.centerX, this.centerY);
    }
    for (;;)
    {
      paramCanvas.concat(this.stickerMatrix);
      this.stickerBorderRect.set(arrayOfPointF[0].x, arrayOfPointF[0].y, arrayOfPointF[2].x, arrayOfPointF[3].y);
      updateBorderPaint();
      paramCanvas.drawRoundRect(this.stickerBorderRect, this.STICKER_CORNER_RADIUS, this.STICKER_CORNER_RADIUS, this.borderPaint);
      paramCanvas.restore();
      if ((paramCanvas == null) || (this.texturePngPath == null) || (this.texturePngPath.length() <= 0)) {
        break;
      }
      drawBlurBgTexture(paramCanvas);
      return;
      label217:
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
      Log.d("btn_pos", "drawDeleteBtn: y = " + f2);
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
    float f3 = this.sticker.getExtraBundle().getFloat("key_sticker_scale_max_x", 0.0F);
    float f2 = this.sticker.getExtraBundle().getFloat("key_sticker_scale_max_y", 0.0F);
    float f4 = this.sticker.getExtraBundle().getFloat("key_sticker_scale_min_x", 0.0F);
    float f5 = this.sticker.getExtraBundle().getFloat("key_sticker_scale_min_y", 0.0F);
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
  
  public void setScale(float paramFloat)
  {
    if (TAVStickerExKt.isLockRatio(this.sticker))
    {
      super.setScale(paramFloat);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.BlurStickerEditView
 * JD-Core Version:    0.7.0.1
 */