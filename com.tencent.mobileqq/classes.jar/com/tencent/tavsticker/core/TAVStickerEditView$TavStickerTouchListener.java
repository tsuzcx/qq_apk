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
    paramMotionEvent = this.this$0;
    paramMotionEvent.positionX = paramMotionEvent.getPositionX();
    paramMotionEvent = this.this$0;
    paramMotionEvent.positionY = paramMotionEvent.getPositionY();
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
    if (2 == paramMotionEvent.getPointerCount())
    {
      if (TAVStickerEditViewEventType.isHandleDoubleZoomRotate(this.this$0.eventType))
      {
        TLog.d(TAVStickerEditView.TAG, "双指缩放旋转");
        this.operationMode = TAVStickerOperationMode.OP_DOUBLE_ZOOM_ROTATE;
        onHandleScaleAndRotate(paramMotionEvent.getX(1) - paramMotionEvent.getX(0), paramMotionEvent.getY(1) - paramMotionEvent.getY(0));
      }
    }
    else if (1 == paramMotionEvent.getPointerCount())
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
        f2 = this.this$0.positionX + f2 - this.downPoint.x;
        f1 = this.this$0.positionY + f1 - this.downPoint.y;
        paramMotionEvent = this.this$0.positionInterceptor(f2, f1);
        String str = TAVStickerEditView.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleActionMove -> curPositionX : ");
        localStringBuilder.append(f2);
        localStringBuilder.append(", realX : ");
        localStringBuilder.append(paramMotionEvent.x);
        localStringBuilder.append(", curPositionY : ");
        localStringBuilder.append(f1);
        localStringBuilder.append(", realY : ");
        localStringBuilder.append(paramMotionEvent.y);
        TLog.d(str, localStringBuilder.toString());
        this.this$0.setPosition(paramMotionEvent.x, paramMotionEvent.y);
      }
    }
    if (this.operationMode != TAVStickerOperationMode.OP_NONE) {
      this.this$0.adjustLocation(this.operationMode);
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
    TAVStickerEditView localTAVStickerEditView = this.this$0;
    localTAVStickerEditView.positionX = localTAVStickerEditView.getPositionX();
    localTAVStickerEditView = this.this$0;
    localTAVStickerEditView.positionY = localTAVStickerEditView.getPositionY();
    this.lastDownRotate = this.this$0.rotate;
    this.lastDownScale = this.this$0.scale;
    if (paramMotionEvent.getPointerId(this.actionIndex) == 0)
    {
      this.downPoint.set(paramMotionEvent.getX(1), paramMotionEvent.getY(1));
      return;
    }
    if (1 == paramMotionEvent.getPointerId(this.actionIndex)) {
      this.downPoint.set(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
    }
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
  
  private void isTouchInSticker(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool = true;
    if (((i & 0xFF) == 0) || (1 == (paramMotionEvent.getAction() & 0xFF)))
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.isTouchInStickerRect = TAVStickerUtil.inQuadrangle(this.this$0.vertexPoints[0], this.this$0.vertexPoints[1], this.this$0.vertexPoints[2], this.this$0.vertexPoints[3], new PointF(f1, f2));
      if ((this.this$0.singleZoomRotateRect == null) || (!this.this$0.singleZoomRotateRect.contains(f1, f2))) {
        bool = false;
      }
      this.isTouchInSingleZoomRotateRect = bool;
    }
  }
  
  private void onHandleScaleAndRotate(float paramFloat1, float paramFloat2)
  {
    this.isClickSticker = false;
    float f2 = TAVStickerUtil.getRotation(paramFloat1, paramFloat2) - this.twoPointDownRotate + this.lastDownRotate;
    float f1;
    if (f2 < 0.0F)
    {
      f1 = f2 + 360.0F;
    }
    else
    {
      f1 = f2;
      if (f2 > 360.0F) {
        f1 = f2 - 360.0F;
      }
    }
    f2 = this.this$0.rotateInterceptor(f1);
    String str = TAVStickerEditView.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onHandleScaleAndRotate -> rotation : ");
    localStringBuilder.append(f1);
    localStringBuilder.append(", displayRotation : ");
    localStringBuilder.append(f2);
    TLog.d(str, localStringBuilder.toString());
    this.this$0.setRotate(f2);
    if (this.twoPointDownDistance > 0.0F)
    {
      paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
      paramFloat1 = handleScaleLimit(this.lastDownScale * (paramFloat1 / this.twoPointDownDistance));
      paramFloat2 = this.this$0.scaleInterceptor(paramFloat1);
      str = TAVStickerEditView.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHandleScaleAndRotate -> curScale : ");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append(", displayScale : ");
      localStringBuilder.append(paramFloat2);
      TLog.d(str, localStringBuilder.toString());
      this.this$0.setScale(paramFloat2);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.actionIndex = paramMotionEvent.getActionIndex();
    if ((this.this$0.sticker.isEditable()) && (this.this$0.eventType != 0))
    {
      isTouchInSticker(paramMotionEvent);
      this.this$0.bringToFront();
      this.this$0.setMode(TAVStickerMode.ACTIVE);
      int i = paramMotionEvent.getAction() & 0xFF;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 5)
            {
              if (i != 6) {
                return true;
              }
              handleActionPointerUp(paramMotionEvent);
              return true;
            }
            handleActionPointerDown(paramMotionEvent);
            return true;
          }
          handleActionMove(paramMotionEvent);
          return true;
        }
        handleActionUp(paramMotionEvent);
        return true;
      }
      handleActionDown(paramMotionEvent);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerEditView.TavStickerTouchListener
 * JD-Core Version:    0.7.0.1
 */