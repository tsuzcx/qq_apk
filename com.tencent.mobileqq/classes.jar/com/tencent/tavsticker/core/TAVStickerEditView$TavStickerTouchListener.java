package com.tencent.tavsticker.core;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerEditViewEventType;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import com.tencent.tavsticker.utils.TAVStickerUtil;

class TAVStickerEditView$TavStickerTouchListener
  implements View.OnTouchListener
{
  private static final int CLICK_DURATION = 200;
  private static final int SINGLE_POINT = 1;
  private static final int TOUCH_SLOP = 16;
  private static final int TWO_POINT = 2;
  private int actionIndex = 0;
  private PointF centerPoint = new PointF();
  private PointF downPoint = new PointF();
  private boolean isClickSticker = false;
  private boolean isTouchInSingleZoomRotateRect = false;
  private boolean isTouchInStickerRect = false;
  private float lastDownRotate = 0.0F;
  private float lastDownScale = 1.0F;
  private TAVStickerOperationMode operationMode = TAVStickerOperationMode.OP_NONE;
  private float twoPointDownDistance = 0.0F;
  private float twoPointDownRotate = 0.0F;
  
  private TAVStickerEditView$TavStickerTouchListener(TAVStickerEditView paramTAVStickerEditView) {}
  
  private boolean checkClickInterval(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() < 200L;
  }
  
  private void handleActionDown(MotionEvent paramMotionEvent)
  {
    if (this.this$0.stickerEventListener != null) {
      this.this$0.stickerEventListener.onTouchBegin(this.this$0.sticker, paramMotionEvent);
    }
    this.downPoint.set(paramMotionEvent.getX(), paramMotionEvent.getY());
    this.this$0.positionX = this.this$0.getPositionX();
    this.this$0.positionY = this.this$0.getPositionY();
    this.lastDownRotate = this.this$0.rotate;
    this.lastDownScale = this.this$0.scale;
    this.isClickSticker = true;
    if (this.isTouchInSingleZoomRotateRect)
    {
      this.operationMode = TAVStickerOperationMode.OP_SINGLE_ZOOM_ROTATE;
      this.centerPoint = TAVStickerUtil.getMiddlePoint(this.this$0.vertexPoints[0], this.this$0.vertexPoints[2]);
      this.twoPointDownRotate = TAVStickerUtil.getRotation(this.centerPoint, this.downPoint);
      this.twoPointDownDistance = TAVStickerUtil.getDistance(this.centerPoint, this.downPoint);
    }
  }
  
  private void handleActionMove(MotionEvent paramMotionEvent)
  {
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    if (2 == paramMotionEvent.getPointerCount()) {
      if (TAVStickerEditViewEventType.isHandleDoubleZoomRotate(this.this$0.eventType))
      {
        TLog.d(TAVStickerEditView.TAG, "双指缩放旋转");
        this.operationMode = TAVStickerOperationMode.OP_DOUBLE_ZOOM_ROTATE;
        onHandleScaleAndRotate(paramMotionEvent.getX(1) - paramMotionEvent.getX(0), paramMotionEvent.getY(1) - paramMotionEvent.getY(0));
      }
    }
    for (;;)
    {
      if (this.operationMode != TAVStickerOperationMode.OP_NONE) {
        this.this$0.adjustLocation(this.operationMode);
      }
      return;
      if (1 == paramMotionEvent.getPointerCount())
      {
        if ((Math.abs(f2 - this.downPoint.x) > 16.0F) || (Math.abs(f1 - this.downPoint.y) > 16.0F)) {
          this.isClickSticker = false;
        }
        if (this.operationMode == TAVStickerOperationMode.OP_SINGLE_ZOOM_ROTATE)
        {
          if (TAVStickerEditViewEventType.isHandleSingleZoomRotate(this.this$0.eventType))
          {
            TLog.d(TAVStickerEditView.TAG, "单指缩放旋转");
            onHandleScaleAndRotate(this.centerPoint.x - paramMotionEvent.getX(), this.centerPoint.y - paramMotionEvent.getY());
          }
        }
        else if (TAVStickerEditViewEventType.isHandleDrag(this.this$0.eventType))
        {
          TLog.d(TAVStickerEditView.TAG, "单指移动");
          if (!this.isClickSticker) {
            this.operationMode = TAVStickerOperationMode.OP_DRAG;
          }
          f2 = f2 + this.this$0.positionX - this.downPoint.x;
          f1 = f1 + this.this$0.positionY - this.downPoint.y;
          paramMotionEvent = this.this$0.positionInterceptor(f2, f1);
          TLog.d(TAVStickerEditView.TAG, "handleActionMove -> curPositionX : " + f2 + ", realX : " + paramMotionEvent.x + ", curPositionY : " + f1 + ", realY : " + paramMotionEvent.y);
          this.this$0.setPosition(paramMotionEvent.x, paramMotionEvent.y);
        }
      }
    }
  }
  
  private void handleActionPointerDown(MotionEvent paramMotionEvent)
  {
    this.operationMode = TAVStickerOperationMode.OP_NONE;
    this.centerPoint = TAVStickerUtil.getMiddlePoint(this.this$0.vertexPoints[0], this.this$0.vertexPoints[2]);
    this.twoPointDownRotate = TAVStickerUtil.getRotation(paramMotionEvent);
    this.twoPointDownDistance = TAVStickerUtil.getDistance(new PointF(paramMotionEvent.getX(this.actionIndex), paramMotionEvent.getY(this.actionIndex)), this.downPoint);
  }
  
  private void handleActionPointerUp(MotionEvent paramMotionEvent)
  {
    this.operationMode = TAVStickerOperationMode.OP_NONE;
    this.this$0.positionX = this.this$0.getPositionX();
    this.this$0.positionY = this.this$0.getPositionY();
    this.lastDownRotate = this.this$0.rotate;
    this.lastDownScale = this.this$0.scale;
    if (paramMotionEvent.getPointerId(this.actionIndex) == 0) {
      this.downPoint.set(paramMotionEvent.getX(1), paramMotionEvent.getY(1));
    }
    while (1 != paramMotionEvent.getPointerId(this.actionIndex)) {
      return;
    }
    this.downPoint.set(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
  }
  
  private void handleActionUp(MotionEvent paramMotionEvent)
  {
    this.operationMode = TAVStickerOperationMode.OP_NONE;
    if ((this.this$0.stickerEventListener != null) && (checkClickInterval(paramMotionEvent)) && (this.isClickSticker) && (TAVStickerEditViewEventType.isHandleClick(this.this$0.eventType))) {
      this.this$0.stickerEventListener.onStickerClick(this.this$0.sticker, paramMotionEvent);
    }
    if (this.this$0.stickerEventListener != null) {
      this.this$0.stickerEventListener.onTouchEnd(this.this$0.sticker, paramMotionEvent);
    }
  }
  
  private float handleScaleLimit(float paramFloat)
  {
    float f = paramFloat;
    if (this.this$0.scaleMin > 0.0F)
    {
      f = paramFloat;
      if (paramFloat < this.this$0.scaleMin) {
        f = this.this$0.scaleMin;
      }
    }
    paramFloat = f;
    if (this.this$0.scaleMax > 0.0F)
    {
      paramFloat = f;
      if (f > this.this$0.scaleMax) {
        paramFloat = this.this$0.scaleMax;
      }
    }
    return paramFloat;
  }
  
  private boolean isTouchInSticker(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if ((paramMotionEvent.getAction() & 0xFF) == 0)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.isTouchInStickerRect = TAVStickerUtil.inQuadrangle(this.this$0.vertexPoints[0], this.this$0.vertexPoints[1], this.this$0.vertexPoints[2], this.this$0.vertexPoints[3], new PointF(f1, f2));
      if ((this.this$0.singleZoomRotateRect == null) || (!this.this$0.singleZoomRotateRect.contains(f1, f2))) {
        break label134;
      }
    }
    label134:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.isTouchInSingleZoomRotateRect = bool1;
      if (!this.isTouchInStickerRect)
      {
        bool1 = bool2;
        if (!this.isTouchInSingleZoomRotateRect) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  private void onHandleScaleAndRotate(float paramFloat1, float paramFloat2)
  {
    this.isClickSticker = false;
    float f2 = TAVStickerUtil.getRotation(paramFloat1, paramFloat2) - this.twoPointDownRotate + this.lastDownRotate;
    float f1;
    if (f2 < 0.0F) {
      f1 = f2 + 360.0F;
    }
    for (;;)
    {
      f2 = this.this$0.rotateInterceptor(f1);
      TLog.d(TAVStickerEditView.TAG, "onHandleScaleAndRotate -> rotation : " + f1 + ", displayRotation : " + f2);
      this.this$0.setRotate(f2);
      if (this.twoPointDownDistance > 0.0F)
      {
        paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
        paramFloat2 = this.lastDownScale;
        paramFloat1 = handleScaleLimit(paramFloat1 / this.twoPointDownDistance * paramFloat2);
        paramFloat2 = this.this$0.scaleInterceptor(paramFloat1);
        TLog.d(TAVStickerEditView.TAG, "onHandleScaleAndRotate -> curScale : " + paramFloat1 + ", displayScale : " + paramFloat2);
        this.this$0.setScale(paramFloat2);
      }
      return;
      f1 = f2;
      if (f2 > 360.0F) {
        f1 = f2 - 360.0F;
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.actionIndex = paramMotionEvent.getActionIndex();
    if ((!this.this$0.sticker.isEditable()) || (this.this$0.eventType == 0)) {
      return false;
    }
    if (isTouchInSticker(paramMotionEvent))
    {
      this.this$0.bringToFront();
      this.this$0.setMode(TAVStickerMode.ACTIVE);
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      for (;;)
      {
        return true;
        handleActionDown(paramMotionEvent);
        continue;
        handleActionPointerDown(paramMotionEvent);
        continue;
        handleActionMove(paramMotionEvent);
        continue;
        handleActionPointerUp(paramMotionEvent);
        continue;
        handleActionUp(paramMotionEvent);
      }
    }
    TLog.d(TAVStickerEditView.TAG, "onTouch -> not touch in sticker rect.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerEditView.TavStickerTouchListener
 * JD-Core Version:    0.7.0.1
 */