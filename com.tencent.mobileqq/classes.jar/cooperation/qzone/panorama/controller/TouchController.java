package cooperation.qzone.panorama.controller;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import cooperation.qzone.panorama.callback.PanoramaTouchListener;
import cooperation.qzone.panorama.util.PanoramaConfig.Builder;
import java.util.Timer;
import java.util.TimerTask;

public class TouchController
  implements View.OnTouchListener
{
  private static final int DEFAULT_TOUCH_SLOP = 40;
  private static final int FLING_SCROLL_PERIOD = 15;
  private static final int FLING_SCROLL_SPEED = 3;
  private static final String TAG = "TouchController";
  public static final float TOUCH_SCALE_SENSITIVITY_MAX_CYLINDER = 1.0F;
  public static final float TOUCH_SCALE_SENSITIVITY_MAX_SPHERE = 1.5F;
  public static final float TOUCH_SCALE_SENSITIVITY_MIN_CYLINDER = 0.122F;
  public static final float TOUCH_SCALE_SENSITIVITY_MIN_SPHERE = 0.35F;
  private Context context;
  private float currentTouchSensitivity;
  private float downX;
  private float downY;
  private boolean isTouchMove;
  private float mCurrentScale = 1.0F;
  private float mPreviousX;
  private float mPreviousY;
  private VelocityTracker mVelocityTracker;
  private int modeType;
  private ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener = new TouchController.2(this);
  private PanoramaTouchListener panoramaTouchListener;
  private int panoramaType;
  private View parent;
  private float rotateX;
  private float rotateY;
  private ScaleGestureDetector scaleGestureDetector;
  private int showType;
  private Timer timer;
  private TimerTask timerTask;
  private float touchMoveScaleRate;
  private float touchMoveSensitivityLow;
  private float touchScaleSensitivityLow;
  
  public TouchController(View paramView, Context paramContext, PanoramaTouchListener paramPanoramaTouchListener, PanoramaConfig.Builder paramBuilder)
  {
    this.panoramaTouchListener = paramPanoramaTouchListener;
    this.context = paramContext;
    this.modeType = paramBuilder.getModeType();
    this.showType = paramBuilder.getShowType();
    this.panoramaType = paramBuilder.getPanoramaType();
    this.parent = paramView;
    this.scaleGestureDetector = new ScaleGestureDetector(paramContext, this.onScaleGestureListener);
    if (this.modeType == 0)
    {
      this.touchScaleSensitivityLow = 0.35F;
      this.touchMoveSensitivityLow = 0.057F;
      this.touchMoveScaleRate = (this.touchScaleSensitivityLow / this.touchMoveSensitivityLow);
      this.currentTouchSensitivity = 0.162F;
    }
    while (this.showType == 1) {
      if (this.modeType == 0)
      {
        this.mCurrentScale = 0.4142652F;
        return;
        this.touchScaleSensitivityLow = 0.122F;
        this.touchMoveSensitivityLow = 0.01F;
        this.touchMoveScaleRate = (this.touchScaleSensitivityLow / this.touchMoveSensitivityLow);
        this.currentTouchSensitivity = 0.08F;
      }
      else
      {
        this.mCurrentScale = 0.5228754F;
        return;
      }
    }
    this.mCurrentScale = 1.0F;
  }
  
  private void onTouchMove(float paramFloat1, float paramFloat2)
  {
    if (this.panoramaTouchListener != null) {
      this.panoramaTouchListener.onTouchMove(paramFloat1, paramFloat2);
    }
    this.rotateX += paramFloat1;
    this.rotateY += paramFloat2;
    if (this.rotateX > 90.0F) {
      this.rotateX = 90.0F;
    }
    while (this.rotateX >= -90.0F) {
      return;
    }
    this.rotateX = -90.0F;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = 40;
    int j = 1;
    if (this.parent != null) {
      this.parent.getParent().requestDisallowInterceptTouchEvent(true);
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    boolean bool = this.scaleGestureDetector.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getActionMasked() == 6) {
      this.isTouchMove = true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((!this.scaleGestureDetector.isInProgress()) && (paramMotionEvent.getPointerCount() == 1) && (!this.isTouchMove))
    {
      if (paramMotionEvent.getAction() != 0) {
        break label341;
      }
      this.downX = f1;
      this.downY = f2;
      if (this.timer != null) {
        this.timer.cancel();
      }
      if (this.timerTask != null) {
        this.timerTask.cancel();
      }
    }
    int k;
    label278:
    label283:
    label341:
    while (paramMotionEvent.getAction() != 2)
    {
      this.mPreviousY = f2;
      this.mPreviousX = f1;
      if (paramMotionEvent.getAction() == 1)
      {
        this.isTouchMove = false;
        i = ViewConfiguration.get(this.context).getScaledTouchSlop();
        if ((Math.abs(f1 - this.downX) <= i) && (Math.abs(f2 - this.downY) <= i) && (this.panoramaTouchListener != null)) {
          this.panoramaTouchListener.onClickListener();
        }
        this.mVelocityTracker.computeCurrentVelocity(10);
        k = (int)this.mVelocityTracker.getXVelocity();
        int m = (int)this.mVelocityTracker.getYVelocity();
        if (k <= 0) {
          break;
        }
        i = 1;
        if (m <= 0) {
          break label500;
        }
        this.timer = new Timer();
        this.timerTask = new TouchController.1(this, i, new int[] { k, m }, j);
        this.timer.schedule(this.timerTask, 0L, 15L);
      }
      return bool;
    }
    float f3 = this.mPreviousX;
    float f4 = this.mPreviousY;
    float f5;
    float f6;
    if (this.panoramaType != 4)
    {
      f5 = f2 - this.downY;
      f6 = f1 - this.downX;
      k = ViewConfiguration.get(this.context).getScaledTouchSlop() * 2;
      if (k >= 40) {
        break label506;
      }
    }
    for (;;)
    {
      if (((f5 / f6 >= 1.0F) || (f5 / f6 <= -1.0F)) && (Math.abs(f5) <= i) && (Math.abs(f6) <= i))
      {
        this.parent.getParent().requestDisallowInterceptTouchEvent(false);
        return true;
      }
      onTouchMove(this.currentTouchSensitivity * (f2 - f4), this.currentTouchSensitivity * (f1 - f3));
      break;
      i = 0;
      break label278;
      label500:
      j = 0;
      break label283;
      label506:
      i = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.panorama.controller.TouchController
 * JD-Core Version:    0.7.0.1
 */