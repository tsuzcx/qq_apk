package com.tencent.mobileqq.kandian.base.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.widget.pull2refresh.PullToRefreshListener;
import org.jetbrains.annotations.Nullable;

public abstract class AbsPullToRefreshViewFix
  extends LinearLayout
  implements Handler.Callback
{
  private float jdField_a_of_type_Float = -1.0F;
  protected int a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected View a;
  private PullToRefreshListener jdField_a_of_type_ComTencentWidgetPull2refreshPullToRefreshListener;
  protected boolean a;
  private float jdField_b_of_type_Float = -1.0F;
  private int jdField_b_of_type_Int = 0;
  protected View b;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean;
  private int e;
  private int f = 10;
  private int g;
  
  public AbsPullToRefreshViewFix(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    b();
  }
  
  public AbsPullToRefreshViewFix(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    b();
  }
  
  @TargetApi(11)
  public AbsPullToRefreshViewFix(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    b();
  }
  
  private float a(int paramInt, float paramFloat)
  {
    int i = this.jdField_c_of_type_Int;
    if (paramInt > -i)
    {
      f1 = paramFloat;
      if (paramInt - paramFloat < -i) {
        f1 = paramInt + i;
      }
      return f1;
    }
    float f1 = paramFloat;
    if (paramInt < -i)
    {
      f1 = paramFloat;
      if (paramInt - paramFloat > -i) {
        f1 = paramInt + i;
      }
    }
    return f1;
  }
  
  @Nullable
  private Boolean a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      a(true);
      getParent().requestDisallowInterceptTouchEvent(true);
      return Boolean.valueOf(super.dispatchTouchEvent(paramMotionEvent));
    }
    if (Math.abs(paramFloat1) / Math.abs(paramFloat2) >= 2.0F)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      if (!bool)
      {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
      else
      {
        this.jdField_b_of_type_Boolean = true;
        a(true);
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      return Boolean.valueOf(bool);
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("moveHeaderTo:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",duration=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(",getHeaderCurPos()=");
    ((StringBuilder)localObject).append(b());
    a(((StringBuilder)localObject).toString());
    if (paramInt1 == b()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(1, paramInt1, paramInt2));
  }
  
  private void a(MotionEvent paramMotionEvent, float paramFloat, int paramInt)
  {
    if ((a()) && (paramFloat < 0.0F))
    {
      c((int)paramFloat / 2);
      d(true);
      return;
    }
    if (paramMotionEvent.getPointerCount() > 1)
    {
      d(true);
      return;
    }
    if (Math.abs(paramFloat) > 0.0F)
    {
      c((int)a(paramInt, paramFloat));
      d(true);
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    b(paramView);
    this.jdField_d_of_type_Int = a();
    this.jdField_c_of_type_Int = paramView.getMeasuredHeight();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.jdField_c_of_type_Int);
    localLayoutParams.topMargin = (-this.jdField_c_of_type_Int);
    super.addView(paramView, localLayoutParams);
  }
  
  private void a(String paramString)
  {
    Log.d("AbsPullToRefreshView2", paramString);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat2) - Math.abs(paramFloat1) <= 0.0F;
  }
  
  private int b()
  {
    return ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).topMargin;
  }
  
  private void b()
  {
    super.setOrientation(1);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidViewView = a();
    this.jdField_b_of_type_AndroidViewView = b();
    this.g = UIUtils.a(getContext(), 15.0F);
    this.e = ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity();
    a(this.jdField_a_of_type_AndroidViewView);
    setWillNotDraw(false);
    this.jdField_a_of_type_Int = (ViewConfiguration.get(getContext()).getScaledTouchSlop() / 8);
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshPullToRefreshListener;
    if (localObject == null) {
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return;
            }
            int i = 100 - Math.abs((int)(b() * 1.0F / -this.jdField_c_of_type_Int * 100.0F));
            paramInt = i;
            if (i < 0) {
              paramInt = 0;
            }
            if (!this.jdField_a_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentWidgetPull2refreshPullToRefreshListener.onNotCompleteVisable(this.jdField_a_of_type_AndroidViewView, paramInt);
            }
          }
          else if (!this.jdField_a_of_type_Boolean)
          {
            ((PullToRefreshListener)localObject).onViewCompleteVisable(this.jdField_a_of_type_AndroidViewView);
          }
        }
        else
        {
          if (this.jdField_a_of_type_Boolean)
          {
            ((PullToRefreshListener)localObject).onRefreshCompleted(this.jdField_a_of_type_AndroidViewView, false);
            localObject = this.jdField_a_of_type_AndroidOsHandler;
            ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(0), 1000L);
          }
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        }
      }
      else
      {
        if (this.jdField_a_of_type_Boolean)
        {
          ((PullToRefreshListener)localObject).onRefreshCompleted(this.jdField_a_of_type_AndroidViewView, true);
          localObject = this.jdField_a_of_type_AndroidOsHandler;
          ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(0), 0L);
        }
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      }
    }
    else if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      ((PullToRefreshListener)localObject).onViewCompleteVisableAndReleased(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  private void b(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
    }
    int j = ViewGroup.getChildMeasureSpec(0, 0, localLayoutParams1.width);
    int i = localLayoutParams1.height;
    if (i > 0) {
      i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    } else {
      i = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    paramView.measure(j, i);
  }
  
  private boolean b(float paramFloat1, float paramFloat2)
  {
    return (Math.abs(paramFloat1) >= this.jdField_a_of_type_Int) || (Math.abs(paramFloat2) >= this.jdField_a_of_type_Int);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
  }
  
  private void c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("moveHeaderSmoothlyBy dy=");
    localStringBuilder.append(paramInt);
    a(localStringBuilder.toString());
    if (Math.abs(paramInt) > this.g * 2) {
      return;
    }
    d(paramInt);
  }
  
  private boolean c()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      getParent().requestDisallowInterceptTouchEvent(false);
      return false;
    }
    return true;
  }
  
  private void d()
  {
    int i = b();
    int j = this.jdField_d_of_type_Int;
    int k = this.jdField_c_of_type_Int;
    if (i > j - k)
    {
      a(4);
      return;
    }
    if (i > -k)
    {
      a(5);
      return;
    }
    if (i < -k) {
      a(6);
    }
  }
  
  private void d(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("moveHeaderBy dy=");
    ((StringBuilder)localObject).append(paramInt);
    a(((StringBuilder)localObject).toString());
    if (paramInt == 0) {
      return;
    }
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin -= paramInt;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    invalidate();
  }
  
  private void d(boolean paramBoolean)
  {
    c(paramBoolean);
    getParent().requestDisallowInterceptTouchEvent(true);
  }
  
  private void e()
  {
    int i = this.jdField_b_of_type_Int;
    if (i == 4)
    {
      a(1);
      return;
    }
    if (i == 5)
    {
      a(0);
      return;
    }
    if (i == 6)
    {
      a(0);
      return;
    }
    if (b() != -this.jdField_c_of_type_Int)
    {
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      localHandler.sendMessage(localHandler.obtainMessage(3));
    }
  }
  
  protected int a()
  {
    return UIUtils.a(getContext(), 60.0F);
  }
  
  protected abstract View a();
  
  protected void a()
  {
    Handler localHandler;
    if (a())
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      a(this.jdField_d_of_type_Int / 2 - this.jdField_c_of_type_Int, 100);
      localHandler = this.jdField_a_of_type_AndroidOsHandler;
      localHandler.sendMessageDelayed(localHandler.obtainMessage(3), 100L);
      return;
    }
    if (b())
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      a(-this.jdField_c_of_type_Int - this.jdField_d_of_type_Int, 100);
      localHandler = this.jdField_a_of_type_AndroidOsHandler;
      localHandler.sendMessageDelayed(localHandler.obtainMessage(3), 100L);
    }
  }
  
  protected void a(int paramInt)
  {
    if ((this.jdField_b_of_type_Int == paramInt) && (paramInt != 5)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("change to state:");
    localStringBuilder.append(paramInt);
    a(localStringBuilder.toString());
    this.jdField_b_of_type_Int = paramInt;
    paramInt = this.jdField_b_of_type_Int;
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        a(this.jdField_d_of_type_Int - this.jdField_c_of_type_Int, 200);
      }
    }
    else
    {
      a(-this.jdField_c_of_type_Int, 200);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    }
    b(this.jdField_b_of_type_Int);
  }
  
  protected void a(PullToRefreshListener paramPullToRefreshListener)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPullToRefreshListener = paramPullToRefreshListener;
  }
  
  protected void a(boolean paramBoolean) {}
  
  protected abstract boolean a();
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected abstract View b();
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(2);
      return;
    }
    a(3);
  }
  
  protected abstract boolean b();
  
  protected abstract void c(boolean paramBoolean);
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    Object localObject;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label491;
          }
        }
        else
        {
          float f1 = this.jdField_b_of_type_Float - paramMotionEvent.getX();
          float f2 = this.jdField_a_of_type_Float - paramMotionEvent.getY();
          if (!this.jdField_c_of_type_Boolean)
          {
            if ((Math.abs(f1) <= this.jdField_a_of_type_Int) && (Math.abs(f2) <= this.jdField_a_of_type_Int)) {
              return super.dispatchTouchEvent(paramMotionEvent);
            }
            this.jdField_c_of_type_Boolean = true;
          }
          i = b();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("dispatchTouchEvent: move getY=");
          ((StringBuilder)localObject).append(paramMotionEvent.getY());
          ((StringBuilder)localObject).append(",isScroll2Top()()=");
          ((StringBuilder)localObject).append(a());
          ((StringBuilder)localObject).append(",mHeaderHeight=");
          ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
          ((StringBuilder)localObject).append(",currentHeaderPos=");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(",dy=");
          ((StringBuilder)localObject).append(f2);
          ((StringBuilder)localObject).append(",dx=");
          ((StringBuilder)localObject).append(f1);
          a(((StringBuilder)localObject).toString());
          this.jdField_b_of_type_Float = paramMotionEvent.getX();
          this.jdField_a_of_type_Float = paramMotionEvent.getY();
          if (!b(f1, f2)) {
            break label491;
          }
          if (a(f1, f2))
          {
            if (this.jdField_d_of_type_Boolean)
            {
              localObject = a(paramMotionEvent, f1, f2);
              if (localObject != null) {
                return ((Boolean)localObject).booleanValue();
              }
            }
            else
            {
              if (!c()) {
                break label491;
              }
              return true;
            }
          }
          else if (this.jdField_b_of_type_Boolean) {
            return true;
          }
          a(paramMotionEvent, f2, i);
          d();
          break label491;
        }
      }
      this.jdField_b_of_type_Boolean = false;
      a(false);
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dispatchTouchEvent: *******up****** mState=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      a(((StringBuilder)localObject).toString());
      getParent().requestDisallowInterceptTouchEvent(false);
      this.jdField_a_of_type_Float = -1.0F;
      this.jdField_b_of_type_Float = -1.0F;
      e();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dispatchTouchEvent: ------down------ getY=");
      ((StringBuilder)localObject).append(paramMotionEvent.getY());
      a(((StringBuilder)localObject).toString());
      c();
      this.jdField_b_of_type_Float = paramMotionEvent.getX();
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_b_of_type_Boolean = false;
      a(false);
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = a(paramMotionEvent);
    }
    label491:
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
          a(-this.jdField_c_of_type_Int, 100);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
          return true;
        }
        a(3);
        return true;
      }
      i = paramMessage.arg1;
      int j = paramMessage.arg2;
      int m = b();
      int k = this.f;
      m = (i - m) * k / j;
      j -= k;
      if ((j > 0) && ((m != 0) || (b() - i <= 0)))
      {
        d(-m);
        paramMessage = this.jdField_a_of_type_AndroidOsHandler;
        paramMessage.sendMessageDelayed(paramMessage.obtainMessage(1, i, j), this.f);
        return true;
      }
      d(b() - i);
      return true;
    }
    a(0);
    return true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = b() + this.jdField_c_of_type_Int;
    if (i > 0)
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, getWidth(), i);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
    super.onDraw(paramCanvas);
  }
  
  public void setPullHeaderBgDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.AbsPullToRefreshViewFix
 * JD-Core Version:    0.7.0.1
 */