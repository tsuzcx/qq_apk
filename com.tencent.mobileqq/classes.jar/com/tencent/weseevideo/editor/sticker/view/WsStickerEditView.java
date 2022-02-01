package com.tencent.weseevideo.editor.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View.OnTouchListener;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavsticker.core.ITAVStickerEventListener;
import com.tencent.tavsticker.core.TAVStickerEditView;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import com.tencent.tavsticker.utils.ViewUtils;
import com.tencent.weseevideo.editor.sticker.StickerDrawingOperationMask;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGView;

public class WsStickerEditView
  extends TAVStickerEditView
{
  String ADJUST_TIME_TEXT = "调整时长";
  int CLICK_DURATION = 200;
  protected float DEFAULT_BORDER_STROKE_WIDTH = ViewUtils.dip2px(1.5F);
  protected float OPERATION_BUTTON_SCALE = 0.5F;
  protected float STICKER_CORNER_RADIUS = ViewUtils.dip2px(3.0F);
  private final String TAG = WsStickerEditView.class.getSimpleName();
  int TOUCH_SLOP = 16;
  private RectF adjustTimeBtnRect = new RectF();
  private Bitmap bmpAdjustTimeRange;
  protected Bitmap bmpDelete;
  protected Bitmap bmpEdit;
  protected Bitmap bmpZoom;
  protected Paint borderPaint = new Paint();
  protected Paint btnPaint = new Paint();
  private int btnTextColor = Color.parseColor("#1E1E22");
  private Paint btnTextPaint = new Paint();
  private int clickPadding = ViewUtils.dip2px(5.0F);
  protected RectF deleteBtnRect = new RectF();
  protected int drawMask = 63;
  protected RectF editBtnRect = new RectF();
  boolean isStickerSelected = false;
  private WsStickerEditView.OnBtnTouchListener onBtnTouchListener = null;
  private TAVStickerOperationMode operationMode = TAVStickerOperationMode.OP_NONE;
  protected RectF stickerBorderRect = new RectF();
  protected WsStickerEditView.OnStickerEditButtonClickListener stickerEditButtonClickListener = null;
  private StickerEditViewIconConfig stickerEditViewIconConfig;
  protected Matrix stickerMatrix = new Matrix();
  protected RectF zoomBtnRect = new RectF();
  
  public WsStickerEditView(Context paramContext, TAVSticker paramTAVSticker, StickerEditViewIconConfig paramStickerEditViewIconConfig)
  {
    super(paramContext, paramTAVSticker);
    this.stickerEditViewIconConfig = paramStickerEditViewIconConfig;
    init();
  }
  
  private void drawAdjustTimeBtn(Canvas paramCanvas)
  {
    Object localObject = getOriginalVertexPoints();
    if (localObject == null) {
      return;
    }
    paramCanvas.save();
    if ((localObject != null) && (localObject.length >= 4))
    {
      float f1 = localObject[3].x;
      float f2 = localObject[3].y;
      paramCanvas.concat(this.stickerMatrix);
      paramCanvas.scale(this.OPERATION_BUTTON_SCALE / getSticker().getScale(), this.OPERATION_BUTTON_SCALE / getSticker().getScale(), f1, f2);
      localObject = new Rect(0, 0, this.bmpAdjustTimeRange.getWidth(), this.bmpAdjustTimeRange.getHeight());
      this.adjustTimeBtnRect = new RectF(f1 - this.bmpAdjustTimeRange.getWidth(), f2 - this.bmpAdjustTimeRange.getHeight(), f1 + this.bmpAdjustTimeRange.getWidth(), f2 + this.bmpAdjustTimeRange.getHeight());
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      paramCanvas.drawBitmap(this.bmpAdjustTimeRange, (Rect)localObject, this.adjustTimeBtnRect, null);
    }
    paramCanvas.getMatrix().mapRect(this.adjustTimeBtnRect);
    paramCanvas.restore();
  }
  
  private void drawEditBtn(Canvas paramCanvas)
  {
    Object localObject = getOriginalVertexPoints();
    if (localObject == null) {
      return;
    }
    paramCanvas.save();
    if ((localObject != null) && (localObject.length >= 4))
    {
      float f1 = localObject[1].x;
      float f2 = localObject[1].y;
      paramCanvas.concat(this.stickerMatrix);
      paramCanvas.scale(this.OPERATION_BUTTON_SCALE / getSticker().getScale(), this.OPERATION_BUTTON_SCALE / getSticker().getScale(), f1, f2);
      localObject = new Rect(0, 0, this.bmpEdit.getWidth(), this.bmpEdit.getHeight());
      this.editBtnRect = new RectF(f1 - this.bmpEdit.getWidth(), f2 - this.bmpEdit.getHeight(), f1 + this.bmpEdit.getWidth(), f2 + this.bmpEdit.getHeight());
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      paramCanvas.drawBitmap(this.bmpEdit, (Rect)localObject, this.editBtnRect, null);
    }
    paramCanvas.getMatrix().mapRect(this.editBtnRect);
    paramCanvas.restore();
  }
  
  private void initStickerEventListener()
  {
    super.setOnStickerEventListener(new WsStickerEditView.2(this));
  }
  
  private boolean isTouchAdjustTimeBtn(int paramInt1, int paramInt2)
  {
    if ((this.adjustTimeBtnRect.left < this.adjustTimeBtnRect.right) && (this.adjustTimeBtnRect.top < this.adjustTimeBtnRect.bottom))
    {
      float f = paramInt1;
      if ((f >= this.adjustTimeBtnRect.left - this.clickPadding) && (f < this.adjustTimeBtnRect.right + this.clickPadding))
      {
        f = paramInt2;
        if ((f >= this.adjustTimeBtnRect.top - this.clickPadding) && (f < this.adjustTimeBtnRect.bottom + this.clickPadding)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean isTouchEditBtn(float paramFloat1, float paramFloat2)
  {
    return this.editBtnRect.contains(paramFloat1, paramFloat2);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (TAVStickerMode.ACTIVE != this.mode) {
      return;
    }
    if (paramCanvas != null)
    {
      if (StickerDrawingOperationMask.isDrawBorder(this.drawMask)) {
        drawBorder(paramCanvas);
      }
      if ((StickerDrawingOperationMask.isDrawLeftTop(this.drawMask)) && (BitmapUtil.isValidBitmap(this.bmpDelete))) {
        drawDeleteBtn(paramCanvas);
      }
      if ((StickerDrawingOperationMask.isDrawRightBottom(this.drawMask)) && (BitmapUtil.isValidBitmap(this.bmpZoom))) {
        drawZoomBtn(paramCanvas);
      }
      if ((StickerDrawingOperationMask.isDrawLeftBottom(this.drawMask)) && (BitmapUtil.isValidBitmap(this.bmpAdjustTimeRange))) {
        drawAdjustTimeBtn(paramCanvas);
      }
    }
  }
  
  protected void drawBorder(Canvas paramCanvas)
  {
    Object localObject = getOriginalVertexPoints();
    if (localObject == null) {
      return;
    }
    if ((localObject != null) && (localObject.length >= 4))
    {
      paramCanvas.save();
      this.stickerMatrix.reset();
      this.stickerMatrix.postTranslate(this.centerX - this.originalCenterX, this.centerY - this.originalCenterY);
      this.stickerMatrix.postRotate(getSticker().getRotate(), this.centerX, this.centerY);
      this.stickerMatrix.postScale(getSticker().getScale(), getSticker().getScale(), this.centerX, this.centerY);
      paramCanvas.concat(this.stickerMatrix);
      this.stickerBorderRect.set(localObject[0].x, localObject[0].y, localObject[2].x, localObject[3].y);
      updateBorderPaint();
      localObject = this.stickerBorderRect;
      float f = this.STICKER_CORNER_RADIUS;
      paramCanvas.drawRoundRect((RectF)localObject, f, f, this.borderPaint);
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
      paramCanvas.scale(this.OPERATION_BUTTON_SCALE / getSticker().getScale(), this.OPERATION_BUTTON_SCALE / getSticker().getScale(), f1, f2);
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
      paramCanvas.scale(this.OPERATION_BUTTON_SCALE / getSticker().getScale(), this.OPERATION_BUTTON_SCALE / getSticker().getScale(), f1, f2);
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
    return new WsStickerEditView.OnBtnTouchListener(this, null);
  }
  
  protected void init()
  {
    if (this.pagView != null) {
      this.pagView.addPAGFlushListener(new WsStickerEditView.1(this));
    }
    StickerEditViewIconConfig localStickerEditViewIconConfig = this.stickerEditViewIconConfig;
    if ((localStickerEditViewIconConfig != null) && (localStickerEditViewIconConfig.getDeleteIconResId() != -1)) {
      this.bmpDelete = BitmapFactory.decodeResource(getResources(), this.stickerEditViewIconConfig.getDeleteIconResId());
    }
    localStickerEditViewIconConfig = this.stickerEditViewIconConfig;
    if ((localStickerEditViewIconConfig != null) && (localStickerEditViewIconConfig.getZoomIconResId() != -1)) {
      this.bmpZoom = BitmapFactory.decodeResource(getResources(), this.stickerEditViewIconConfig.getZoomIconResId());
    }
    localStickerEditViewIconConfig = this.stickerEditViewIconConfig;
    if ((localStickerEditViewIconConfig != null) && (localStickerEditViewIconConfig.getEditIconResId() != -1)) {
      this.bmpEdit = BitmapFactory.decodeResource(getResources(), this.stickerEditViewIconConfig.getEditIconResId());
    }
    localStickerEditViewIconConfig = this.stickerEditViewIconConfig;
    if ((localStickerEditViewIconConfig != null) && (localStickerEditViewIconConfig.getAdjustTimeRangeIconResId() != -1)) {
      this.bmpAdjustTimeRange = BitmapFactory.decodeResource(getResources(), this.stickerEditViewIconConfig.getAdjustTimeRangeIconResId());
    }
    this.btnPaint.setAntiAlias(true);
    this.btnPaint.setColor(-1);
    this.btnPaint.setStrokeWidth(1.0F);
    this.borderPaint.setAntiAlias(true);
    this.borderPaint.setColor(-1);
    this.borderPaint.setStrokeWidth(this.DEFAULT_BORDER_STROKE_WIDTH);
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.borderPaint.setShadowLayer(0.5F, 0.5F, 0.5F, -7829368);
    this.btnTextPaint.setAntiAlias(true);
    this.btnTextPaint.setColor(this.btnTextColor);
    this.btnTextPaint.setTextSize(ViewUtils.dip2px(24.0F));
    this.btnTextPaint.setTextAlign(Paint.Align.CENTER);
    this.btnTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
    addOnTouchListener(getStickerTouchListener());
    initStickerEventListener();
    if (getSticker().getMode() == TAVStickerMode.ACTIVE) {
      this.isStickerSelected = true;
    }
  }
  
  public boolean isDrawGuideLine()
  {
    return StickerDrawingOperationMask.isDrawGuideLine(this.drawMask);
  }
  
  protected boolean isTouchDeleteBtn(int paramInt1, int paramInt2)
  {
    return this.deleteBtnRect.contains(paramInt1, paramInt2);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.operationMode = TAVStickerOperationMode.OP_NONE;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.isStickerSelected = false;
    this.operationMode = TAVStickerOperationMode.OP_NONE;
  }
  
  @NotNull
  public PointF positionInterceptor(float paramFloat1, float paramFloat2)
  {
    PointF localPointF = new PointF(paramFloat1, paramFloat2);
    if (Math.abs(paramFloat1 + this.stickerWidth / 2.0F - getWidth() / 2.0F) < WsStickerContentView.DRAG_ADSORPTION_THRESHOLD) {
      localPointF.x = (getWidth() / 2.0F - this.stickerWidth / 2.0F);
    }
    if (Math.abs(paramFloat2 + this.stickerHeight / 2.0F - getHeight() / 2.0F) < WsStickerContentView.DRAG_ADSORPTION_THRESHOLD) {
      localPointF.y = (getHeight() / 2.0F - this.stickerHeight / 2.0F);
    }
    return localPointF;
  }
  
  protected float rotateInterceptor(float paramFloat)
  {
    if (Math.abs(paramFloat - 0.0F) < 2.0F) {
      return 0.0F;
    }
    if (Math.abs(paramFloat - 45.0F) <= 2.0F) {
      return 45.0F;
    }
    if (Math.abs(paramFloat - 90.0F) <= 2.0F) {
      return 90.0F;
    }
    if (Math.abs(paramFloat - 135.0F) <= 2.0F) {
      return 135.0F;
    }
    if (Math.abs(paramFloat - 180.0F) <= 2.0F) {
      return 180.0F;
    }
    if (Math.abs(paramFloat - 225.0F) <= 2.0F) {
      return 225.0F;
    }
    if (Math.abs(paramFloat - 270.0F) <= 2.0F) {
      return 270.0F;
    }
    if (Math.abs(paramFloat - 315.0F) <= 2.0F) {
      return 315.0F;
    }
    if (Math.abs(paramFloat - 360.0F) <= 2.0F) {
      return 0.0F;
    }
    return paramFloat;
  }
  
  public void setDrawingOperationMask(int paramInt)
  {
    this.drawMask = paramInt;
    postInvalidate();
  }
  
  public void setMode(TAVStickerMode paramTAVStickerMode)
  {
    boolean bool;
    if ((paramTAVStickerMode == TAVStickerMode.ACTIVE) && (this.mode != TAVStickerMode.INACTIVE)) {
      bool = true;
    } else {
      bool = false;
    }
    this.isStickerSelected = bool;
    super.setMode(paramTAVStickerMode);
    if (paramTAVStickerMode == TAVStickerMode.ACTIVE) {
      bringToFront();
    }
  }
  
  public void setOnStickerEditButtonClickListener(WsStickerEditView.OnStickerEditButtonClickListener paramOnStickerEditButtonClickListener)
  {
    this.stickerEditButtonClickListener = paramOnStickerEditButtonClickListener;
  }
  
  public void setOnStickerEventListener(ITAVStickerEventListener paramITAVStickerEventListener) {}
  
  protected void updateBorderPaint()
  {
    float f = getSticker().getScale();
    if (0.0F != f) {
      this.borderPaint.setStrokeWidth(this.DEFAULT_BORDER_STROKE_WIDTH / f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.view.WsStickerEditView
 * JD-Core Version:    0.7.0.1
 */