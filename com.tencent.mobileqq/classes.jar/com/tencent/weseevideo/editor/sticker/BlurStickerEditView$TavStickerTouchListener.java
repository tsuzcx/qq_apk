package com.tencent.weseevideo.editor.sticker;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerEditViewEventType;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import com.tencent.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.weseevideo.editor.sticker.view.WsStickerEditView.OnStickerEditButtonClickListener;
import org.libpag.PAGView;

public class BlurStickerEditView$TavStickerTouchListener
  implements View.OnTouchListener
{
  private static final int CLICK_DURATION = 200;
  private static final int SINGLE_POINT = 1;
  private static final int TOUCH_SLOP = 16;
  private static final int TWO_POINT = 2;
  private int actionIndex = 0;
  private PointF centerPoint = new PointF();
  private PointF downPoint = new PointF();
  private boolean isClickDelete = false;
  private boolean isClickSticker = false;
  private boolean isTouchInSingleZoomRotateRect = false;
  private boolean isTouchInStickerRect = false;
  private float lastDownRotate = 0.0F;
  private float lastDownScale = 1.0F;
  private float lastDownScaleX = 1.0F;
  private float lastDownScaleY = 1.0F;
  private TAVStickerOperationMode operationMode = TAVStickerOperationMode.OP_NONE;
  private float twoPointDownDistance = 0.0F;
  private float twoPointDownRotate = 0.0F;
  private float xDistanceOnDown = 0.0F;
  private float yDistanceOnDown = 0.0F;
  
  protected BlurStickerEditView$TavStickerTouchListener(BlurStickerEditView paramBlurStickerEditView) {}
  
  private boolean checkClickInterval(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() < 200L;
  }
  
  private void handleActionDown(MotionEvent paramMotionEvent)
  {
    this.downPoint.set(paramMotionEvent.getX(), paramMotionEvent.getY());
    if ((BlurStickerEditView.access$600(this.this$0, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (StickerDrawingOperationMask.isDrawLeftTop(BlurStickerEditView.access$700(this.this$0))))
    {
      this.isClickDelete = true;
      this.isClickSticker = true;
      return;
    }
    paramMotionEvent = this.this$0;
    BlurStickerEditView.access$802(paramMotionEvent, BlurStickerEditView.access$900(paramMotionEvent));
    paramMotionEvent = this.this$0;
    BlurStickerEditView.access$1002(paramMotionEvent, BlurStickerEditView.access$1100(paramMotionEvent));
    this.lastDownRotate = BlurStickerEditView.access$1200(this.this$0);
    if (TAVStickerExKt.isLockRatio(BlurStickerEditView.access$1300(this.this$0)))
    {
      this.lastDownScale = BlurStickerEditView.access$1400(this.this$0);
    }
    else
    {
      this.lastDownScaleX = BlurStickerEditView.access$1500(this.this$0);
      this.lastDownScaleY = BlurStickerEditView.access$1600(this.this$0);
    }
    this.lastDownScale = BlurStickerEditView.access$1700(this.this$0);
    this.isClickSticker = true;
    if (this.isTouchInSingleZoomRotateRect)
    {
      this.operationMode = TAVStickerOperationMode.OP_SINGLE_ZOOM_ROTATE;
      this.centerPoint = TAVStickerUtil.getMiddlePoint(BlurStickerEditView.access$1800(this.this$0)[0], BlurStickerEditView.access$1900(this.this$0)[2]);
      this.twoPointDownRotate = TAVStickerUtil.getRotation(this.centerPoint, this.downPoint);
      this.twoPointDownDistance = TAVStickerUtil.getDistance(this.centerPoint, this.downPoint);
      this.xDistanceOnDown = Math.abs(this.downPoint.x - this.centerPoint.x);
      this.yDistanceOnDown = Math.abs(this.downPoint.y - this.centerPoint.y);
    }
  }
  
  private void handleActionMove(MotionEvent paramMotionEvent)
  {
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    if ((Math.abs(f2 - this.downPoint.x) > 16.0F) || (Math.abs(f1 - this.downPoint.y) > 16.0F)) {
      this.isClickDelete = false;
    }
    if (2 == paramMotionEvent.getPointerCount())
    {
      if (TAVStickerEditViewEventType.isHandleDoubleZoomRotate(BlurStickerEditView.access$2800(this.this$0)))
      {
        TLog.d("BlurStickerEditView", "双指缩放旋转");
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
        if (TAVStickerEditViewEventType.isHandleSingleZoomRotate(BlurStickerEditView.access$2900(this.this$0)))
        {
          TLog.d("BlurStickerEditView", "单指缩放旋转");
          onHandleScaleAndRotate(this.centerPoint.x - paramMotionEvent.getX(), this.centerPoint.y - paramMotionEvent.getY());
        }
      }
      else if (TAVStickerEditViewEventType.isHandleDrag(BlurStickerEditView.access$3000(this.this$0)))
      {
        Log.d("BlurStickerEditView", "单指移动");
        if (!this.isClickSticker) {
          this.operationMode = TAVStickerOperationMode.OP_DRAG;
        }
        f2 = BlurStickerEditView.access$3100(this.this$0) + f2 - this.downPoint.x;
        f1 = BlurStickerEditView.access$3200(this.this$0) + f1 - this.downPoint.y;
        paramMotionEvent = this.this$0.positionInterceptor(f2, f1);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleActionMove -> curPositionX : ");
        localStringBuilder.append(f2);
        localStringBuilder.append(", realX : ");
        localStringBuilder.append(paramMotionEvent.x);
        localStringBuilder.append(", curPositionY : ");
        localStringBuilder.append(f1);
        localStringBuilder.append(", realY : ");
        localStringBuilder.append(paramMotionEvent.y);
        TLog.d("BlurStickerEditView", localStringBuilder.toString());
        BlurStickerEditView.access$3300(this.this$0, paramMotionEvent.x, paramMotionEvent.y);
      }
    }
    if (this.operationMode != TAVStickerOperationMode.OP_NONE) {
      BlurStickerEditView.access$3400(this.this$0, this.operationMode);
    }
  }
  
  private void handleActionPointerDown(MotionEvent paramMotionEvent)
  {
    this.operationMode = TAVStickerOperationMode.OP_NONE;
    this.centerPoint = TAVStickerUtil.getMiddlePoint(BlurStickerEditView.access$2000(this.this$0)[0], BlurStickerEditView.access$2100(this.this$0)[2]);
    this.twoPointDownRotate = TAVStickerUtil.getRotation(paramMotionEvent);
    this.twoPointDownDistance = TAVStickerUtil.getDistance(new PointF(paramMotionEvent.getX(this.actionIndex), paramMotionEvent.getY(this.actionIndex)), this.downPoint);
  }
  
  private void handleActionPointerUp(MotionEvent paramMotionEvent)
  {
    this.operationMode = TAVStickerOperationMode.OP_NONE;
    BlurStickerEditView localBlurStickerEditView = this.this$0;
    BlurStickerEditView.access$2202(localBlurStickerEditView, BlurStickerEditView.access$2300(localBlurStickerEditView));
    localBlurStickerEditView = this.this$0;
    BlurStickerEditView.access$2402(localBlurStickerEditView, BlurStickerEditView.access$2500(localBlurStickerEditView));
    this.lastDownRotate = BlurStickerEditView.access$2600(this.this$0);
    this.lastDownScale = BlurStickerEditView.access$2700(this.this$0);
    this.lastDownScaleX = BlurStickerEditView.access$1500(this.this$0);
    this.lastDownScaleY = BlurStickerEditView.access$1600(this.this$0);
    if (paramMotionEvent.getPointerId(this.actionIndex) == 0)
    {
      this.downPoint.set(paramMotionEvent.getX(1), paramMotionEvent.getY(1));
      return;
    }
    if (1 == paramMotionEvent.getPointerId(this.actionIndex)) {
      this.downPoint.set(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
    }
  }
  
  private boolean handleActionUp(MotionEvent paramMotionEvent)
  {
    this.operationMode = TAVStickerOperationMode.OP_NONE;
    if (this.isClickDelete)
    {
      if (BlurStickerEditView.access$3500(this.this$0) != null) {
        BlurStickerEditView.access$3600(this.this$0).onDeleteClick(this.this$0.getSticker());
      }
      return true;
    }
    return false;
  }
  
  private float handleScaleLimit(float paramFloat)
  {
    float f = paramFloat;
    if (BlurStickerEditView.access$3700(this.this$0) > 0.0F)
    {
      f = paramFloat;
      if (paramFloat < BlurStickerEditView.access$3800(this.this$0)) {
        f = BlurStickerEditView.access$3900(this.this$0);
      }
    }
    paramFloat = f;
    if (BlurStickerEditView.access$4000(this.this$0) > 0.0F)
    {
      paramFloat = f;
      if (f > BlurStickerEditView.access$4100(this.this$0)) {
        paramFloat = BlurStickerEditView.access$4200(this.this$0);
      }
    }
    return paramFloat;
  }
  
  private boolean isTouchInSticker(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool2 = true;
    if ((i & 0xFF) == 0)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.isTouchInStickerRect = TAVStickerUtil.inQuadrangle(BlurStickerEditView.access$000(this.this$0)[0], BlurStickerEditView.access$100(this.this$0)[1], BlurStickerEditView.access$200(this.this$0)[2], BlurStickerEditView.access$300(this.this$0)[3], new PointF(f1, f2));
      if ((BlurStickerEditView.access$400(this.this$0) != null) && (BlurStickerEditView.access$500(this.this$0).contains(f1, f2))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.isTouchInSingleZoomRotateRect = bool1;
    }
    boolean bool1 = bool2;
    if (!this.isTouchInStickerRect)
    {
      if (this.isTouchInSingleZoomRotateRect) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private void onHandleScaleAndRotate(float paramFloat1, float paramFloat2)
  {
    this.isClickSticker = false;
    float f2;
    float f1;
    StringBuilder localStringBuilder;
    if (TAVStickerExKt.isRotateEnable(BlurStickerEditView.access$4300(this.this$0)))
    {
      f2 = TAVStickerUtil.getRotation(paramFloat1, paramFloat2) - this.twoPointDownRotate + this.lastDownRotate;
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
      f2 = BlurStickerEditView.access$4400(this.this$0, f1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHandleScaleAndRotate -> rotation : ");
      localStringBuilder.append(f1);
      localStringBuilder.append(", displayRotation : ");
      localStringBuilder.append(f2);
      TLog.d("BlurStickerEditView", localStringBuilder.toString());
    }
    if (this.twoPointDownDistance > 0.0F)
    {
      if (TAVStickerExKt.isLockRatio(BlurStickerEditView.access$4500(this.this$0)))
      {
        paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
        paramFloat1 = handleScaleLimit(this.lastDownScale * (paramFloat1 / this.twoPointDownDistance));
        paramFloat2 = BlurStickerEditView.access$4600(this.this$0, paramFloat1);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onHandleScaleAndRotate -> curScale : ");
        localStringBuilder.append(paramFloat1);
        localStringBuilder.append(", displayScale : ");
        localStringBuilder.append(paramFloat2);
        TLog.d("BlurStickerEditView", localStringBuilder.toString());
        this.this$0.setScale(paramFloat2);
        return;
      }
      f2 = Math.abs(paramFloat1);
      f1 = Math.abs(paramFloat2);
      paramFloat1 = this.lastDownScaleX;
      f2 /= this.xDistanceOnDown;
      paramFloat2 = this.lastDownScaleY;
      f1 /= this.yDistanceOnDown;
      paramFloat1 = BlurStickerEditView.access$4700(this.this$0, paramFloat1 * f2);
      paramFloat2 = BlurStickerEditView.access$4800(this.this$0, paramFloat2 * f1);
      setXScale(paramFloat1);
      setYScale(paramFloat2);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.actionIndex = paramMotionEvent.getActionIndex();
    if ((BlurStickerEditView.access$5300(this.this$0).isEditable()) && (BlurStickerEditView.access$5400(this.this$0) != 0))
    {
      isTouchInSticker(paramMotionEvent);
      this.this$0.bringToFront();
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
        return handleActionUp(paramMotionEvent);
      }
      handleActionDown(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  protected void setXScale(float paramFloat)
  {
    if (BlurStickerEditView.access$4900(this.this$0) != null)
    {
      BlurStickerEditView.access$5000(this.this$0).setScaleX(paramFloat);
      BlurStickerEditView.access$1502(this.this$0, paramFloat);
    }
  }
  
  protected void setYScale(float paramFloat)
  {
    if (BlurStickerEditView.access$5100(this.this$0) != null)
    {
      BlurStickerEditView.access$5200(this.this$0).setScaleY(paramFloat);
      BlurStickerEditView.access$1602(this.this$0, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.BlurStickerEditView.TavStickerTouchListener
 * JD-Core Version:    0.7.0.1
 */