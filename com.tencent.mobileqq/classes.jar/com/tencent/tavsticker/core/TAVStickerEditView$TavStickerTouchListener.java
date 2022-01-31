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
    if (TAVStickerEditView.access$200(this.this$0) != null) {
      TAVStickerEditView.access$200(this.this$0).onTouchBegin(TAVStickerEditView.access$300(this.this$0), paramMotionEvent);
    }
    this.downPoint.set(paramMotionEvent.getX(), paramMotionEvent.getY());
    TAVStickerEditView.access$402(this.this$0, TAVStickerEditView.access$500(this.this$0));
    TAVStickerEditView.access$602(this.this$0, TAVStickerEditView.access$700(this.this$0));
    this.lastDownRotate = TAVStickerEditView.access$800(this.this$0);
    this.lastDownScale = TAVStickerEditView.access$900(this.this$0);
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
      if (TAVStickerEditViewEventType.isHandleDoubleZoomRotate(this.this$0.mEventType))
      {
        TLog.d(TAVStickerEditView.TAG, "双指缩放旋转");
        this.operationMode = TAVStickerOperationMode.OP_DOUBLE_ZOOM_ROTATE;
        onHandleScaleAndRotate(paramMotionEvent.getX(1) - paramMotionEvent.getX(0), paramMotionEvent.getY(1) - paramMotionEvent.getY(0));
      }
    }
    for (;;)
    {
      if (this.operationMode != TAVStickerOperationMode.OP_NONE) {
        TAVStickerEditView.access$1100(this.this$0, this.operationMode);
      }
      return;
      if (1 == paramMotionEvent.getPointerCount())
      {
        if ((Math.abs(f2 - this.downPoint.x) > 16.0F) || (Math.abs(f1 - this.downPoint.y) > 16.0F)) {
          this.isClickSticker = false;
        }
        if (this.operationMode == TAVStickerOperationMode.OP_SINGLE_ZOOM_ROTATE)
        {
          if (TAVStickerEditViewEventType.isHandleSingleZoomRotate(this.this$0.mEventType))
          {
            TLog.d(TAVStickerEditView.TAG, "单指缩放旋转");
            onHandleScaleAndRotate(this.centerPoint.x - paramMotionEvent.getX(), this.centerPoint.y - paramMotionEvent.getY());
          }
        }
        else if (TAVStickerEditViewEventType.isHandleDrag(this.this$0.mEventType))
        {
          TLog.d(TAVStickerEditView.TAG, "单指移动");
          if (!this.isClickSticker) {
            this.operationMode = TAVStickerOperationMode.OP_DRAG;
          }
          f2 = f2 + TAVStickerEditView.access$400(this.this$0) - this.downPoint.x;
          f1 = f1 + TAVStickerEditView.access$600(this.this$0) - this.downPoint.y;
          paramMotionEvent = this.this$0.positionInterceptor(f2, f1);
          TLog.d(TAVStickerEditView.TAG, "handleActionMove -> curPositionX : " + f2 + ", realX : " + paramMotionEvent.x + ", curPositionY : " + f1 + ", realY : " + paramMotionEvent.y);
          TAVStickerEditView.access$1000(this.this$0, paramMotionEvent.x, paramMotionEvent.y);
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
    TAVStickerEditView.access$402(this.this$0, TAVStickerEditView.access$500(this.this$0));
    TAVStickerEditView.access$602(this.this$0, TAVStickerEditView.access$700(this.this$0));
    this.lastDownRotate = TAVStickerEditView.access$800(this.this$0);
    this.lastDownScale = TAVStickerEditView.access$900(this.this$0);
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
    if ((TAVStickerEditView.access$200(this.this$0) != null) && (checkClickInterval(paramMotionEvent)) && (this.isClickSticker) && (TAVStickerEditViewEventType.isHandleClick(this.this$0.mEventType))) {
      TAVStickerEditView.access$200(this.this$0).onStickerClick(TAVStickerEditView.access$300(this.this$0), paramMotionEvent);
    }
    if (TAVStickerEditView.access$200(this.this$0) != null) {
      TAVStickerEditView.access$200(this.this$0).onTouchEnd(TAVStickerEditView.access$300(this.this$0), paramMotionEvent);
    }
  }
  
  private float handleScaleLimit(float paramFloat)
  {
    float f = paramFloat;
    if (TAVStickerEditView.access$1200(this.this$0) > 0.0F)
    {
      f = paramFloat;
      if (paramFloat < TAVStickerEditView.access$1200(this.this$0)) {
        f = TAVStickerEditView.access$1200(this.this$0);
      }
    }
    paramFloat = f;
    if (TAVStickerEditView.access$1300(this.this$0) > 0.0F)
    {
      paramFloat = f;
      if (f > TAVStickerEditView.access$1300(this.this$0)) {
        paramFloat = TAVStickerEditView.access$1300(this.this$0);
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
      if ((TAVStickerEditView.access$100(this.this$0) == null) || (!TAVStickerEditView.access$100(this.this$0).contains(f1, f2))) {
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
      TAVStickerEditView.access$1400(this.this$0, f2);
      if (this.twoPointDownDistance > 0.0F)
      {
        paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
        paramFloat2 = this.lastDownScale;
        paramFloat1 = handleScaleLimit(paramFloat1 / this.twoPointDownDistance * paramFloat2);
        paramFloat2 = this.this$0.scaleInterceptor(paramFloat1);
        TLog.d(TAVStickerEditView.TAG, "onHandleScaleAndRotate -> curScale : " + paramFloat1 + ", displayScale : " + paramFloat2);
        TAVStickerEditView.access$1500(this.this$0, paramFloat2);
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
    if ((!TAVStickerEditView.access$300(this.this$0).isEditable()) || (this.this$0.mEventType == 0)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerEditView.TavStickerTouchListener
 * JD-Core Version:    0.7.0.1
 */