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
  private boolean isTouchMove = false;
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
    else
    {
      this.touchScaleSensitivityLow = 0.122F;
      this.touchMoveSensitivityLow = 0.01F;
      this.touchMoveScaleRate = (this.touchScaleSensitivityLow / this.touchMoveSensitivityLow);
      this.currentTouchSensitivity = 0.08F;
    }
    if (this.showType == 1)
    {
      if (this.modeType == 0)
      {
        this.mCurrentScale = 0.4142652F;
        return;
      }
      this.mCurrentScale = 0.5228754F;
      return;
    }
    this.mCurrentScale = 1.0F;
  }
  
  private void onTouchMove(float paramFloat1, float paramFloat2)
  {
    PanoramaTouchListener localPanoramaTouchListener = this.panoramaTouchListener;
    if (localPanoramaTouchListener != null) {
      localPanoramaTouchListener.onTouchMove(paramFloat1, paramFloat2);
    }
    this.rotateX += paramFloat1;
    this.rotateY += paramFloat2;
    paramFloat1 = this.rotateX;
    if (paramFloat1 > 90.0F)
    {
      this.rotateX = 90.0F;
      return;
    }
    if (paramFloat1 < -90.0F) {
      this.rotateX = -90.0F;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.parent;
    int j = 1;
    if (paramView != null) {
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    boolean bool = this.scaleGestureDetector.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getActionMasked() == 6) {
      this.isTouchMove = true;
    }
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    float f3;
    int k;
    int i;
    if ((!this.scaleGestureDetector.isInProgress()) && (paramMotionEvent.getPointerCount() == 1) && (!this.isTouchMove))
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.downX = f2;
        this.downY = f1;
        paramView = this.timer;
        if (paramView != null) {
          paramView.cancel();
        }
        paramView = this.timerTask;
        if (paramView != null) {
          paramView.cancel();
        }
      }
      else if (paramMotionEvent.getAction() == 2)
      {
        f3 = this.mPreviousX;
        float f4 = this.mPreviousY;
        if (this.panoramaType != 4)
        {
          float f6 = f1 - this.downY;
          f5 = f2 - this.downX;
          k = ViewConfiguration.get(this.context).getScaledTouchSlop() * 2;
          i = k;
          if (k < 40) {
            i = 40;
          }
          float f7 = f6 / f5;
          if ((f7 >= 1.0F) || (f7 <= -1.0F))
          {
            f6 = Math.abs(f6);
            f7 = i;
            if ((f6 <= f7) && (Math.abs(f5) <= f7))
            {
              this.parent.getParent().requestDisallowInterceptTouchEvent(false);
              return true;
            }
          }
        }
        float f5 = this.currentTouchSensitivity;
        onTouchMove((f1 - f4) * f5, (f2 - f3) * f5);
      }
      this.mPreviousY = f1;
      this.mPreviousX = f2;
    }
    if (paramMotionEvent.getAction() == 1)
    {
      this.isTouchMove = false;
      i = ViewConfiguration.get(this.context).getScaledTouchSlop();
      f2 = Math.abs(f2 - this.downX);
      f3 = i;
      if ((f2 <= f3) && (Math.abs(f1 - this.downY) <= f3))
      {
        paramView = this.panoramaTouchListener;
        if (paramView != null) {
          paramView.onClickListener();
        }
      }
      this.mVelocityTracker.computeCurrentVelocity(10);
      k = (int)this.mVelocityTracker.getXVelocity();
      int m = (int)this.mVelocityTracker.getYVelocity();
      if (k > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (m <= 0) {
        j = 0;
      }
      this.timer = new Timer();
      this.timerTask = new TouchController.1(this, i, new int[] { k, m }, j);
      this.timer.schedule(this.timerTask, 0L, 15L);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.panorama.controller.TouchController
 * JD-Core Version:    0.7.0.1
 */