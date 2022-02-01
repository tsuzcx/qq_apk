package com.tencent.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.GreatMoveCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.HeartBreakCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.HeartCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.ZanCombolEffectView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;

public class FitSystemWindowsRelativeLayout
  extends RelativeLayout
  implements Handler.Callback
{
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new FitSystemWindowsRelativeLayout.1(this);
  View jdField_a_of_type_AndroidViewView = new View(getContext());
  GreatMoveCombolEffectView jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView = null;
  HeartBreakCombolEffectView jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView = null;
  HeartCombolEffectView jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView = null;
  SixCombolEffectView jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView = null;
  ZanCombolEffectView jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView = null;
  DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = null;
  private FitSystemWindowsRelativeLayout.DispatchTouchEventListener jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$DispatchTouchEventListener;
  private FitSystemWindowsRelativeLayout.OnInterceptTouchEventListener jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$OnInterceptTouchEventListener;
  boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[4];
  
  public FitSystemWindowsRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  @TargetApi(11)
  public FitSystemWindowsRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FitSystemWindowsRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private QQAppInterface a()
  {
    Object localObject = getContext();
    if ((localObject instanceof BaseActivity)) {
      return ((BaseActivity)localObject).app;
    }
    localObject = BaseActivity.sTopActivity;
    if (localObject != null) {
      return ((BaseActivity)localObject).app;
    }
    localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      return (QQAppInterface)localObject;
    }
    return null;
  }
  
  private void a(View paramView)
  {
    boolean bool = paramView instanceof ViewGroup;
    int i = 0;
    if (bool) {
      while (i < getChildCount())
      {
        a(((ViewGroup)paramView).getChildAt(i));
        i += 1;
      }
    }
    if ((paramView instanceof ImageView))
    {
      Object localObject2 = ((ImageView)paramView).getDrawable();
      if (localObject2 == null) {
        return;
      }
      Object localObject1 = null;
      if ((localObject2 instanceof DrawableContainer))
      {
        localObject2 = ((Drawable)localObject2).getCurrent();
        if ((localObject2 instanceof BitmapDrawable)) {
          localObject1 = ((BitmapDrawable)localObject2).getBitmap();
        }
      }
      else if ((localObject2 instanceof BitmapDrawable))
      {
        localObject1 = ((BitmapDrawable)localObject2).getBitmap();
      }
      if (localObject1 == null) {
        return;
      }
      if (((Bitmap)localObject1).isRecycled())
      {
        localObject1 = new StringBuilder("catch bitmap recycled:");
        localObject2 = a(paramView, 0);
        if (localObject2[0] != 0)
        {
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(paramView.getResources().getResourceEntryName(localObject2[0]));
          ((StringBuilder)localObject1).append(" id = ");
          ((StringBuilder)localObject1).append(localObject2[0]);
          ((StringBuilder)localObject1).append(" level = ");
          ((StringBuilder)localObject1).append(localObject2[1]);
          ((StringBuilder)localObject1).append(" isRecycled");
          paramView = new StringBuilder();
          paramView.append("BITMAP_RECYCLED ");
          paramView.append(localObject1);
          CaughtExceptionReport.a(new Throwable(paramView.toString()));
          QLog.d("placeholder", 1, ((StringBuilder)localObject1).toString());
        }
      }
    }
  }
  
  @SuppressLint({"ResourceType"})
  private int[] a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return new int[] { 0, paramInt };
    }
    if (paramInt >= 3) {
      return new int[] { 0, paramInt };
    }
    if ((paramView.getId() != 0) && (paramView.getId() != -1)) {
      return new int[] { paramView.getId(), paramInt };
    }
    return a((View)paramView.getParent(), paramInt + 1);
  }
  
  public GreatMoveCombolEffectView a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView = new GreatMoveCombolEffectView(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView, localLayoutParams);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView;
  }
  
  public SixCombolEffectView a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView = new SixCombolEffectView(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.topMargin = ScreenUtil.dip2px(50.0F);
      localLayoutParams.addRule(8, 2131370119);
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131364485);
      localViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView);
      localViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView, localLayoutParams);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (RuntimeException paramCanvas)
    {
      try
      {
        a(this);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("placeholder", 1, localThrowable, new Object[0]);
      }
      throw paramCanvas;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dispatchTouchEvent() called with: ev = [");
      ((StringBuilder)localObject).append(paramMotionEvent);
      ((StringBuilder)localObject).append("]");
      QLog.d("placeholder", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = false;
    Object localObject = this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$DispatchTouchEventListener;
    if (localObject != null) {
      bool = ((FitSystemWindowsRelativeLayout.DispatchTouchEventListener)localObject).a(paramMotionEvent);
    }
    if (bool) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.jdField_a_of_type_ArrayOfInt[0] = paramRect.left;
      this.jdField_a_of_type_ArrayOfInt[1] = paramRect.top;
      this.jdField_a_of_type_ArrayOfInt[2] = paramRect.right;
      paramRect.left = 0;
      paramRect.top = 0;
      paramRect.right = 0;
    }
    return super.fitSystemWindows(paramRect);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    switch (paramMessage.what)
    {
    case 8: 
    case 11: 
    default: 
      return false;
    case 21: 
      clearAnimation();
      return false;
    case 20: 
      if (QLog.isColorLevel()) {
        QLog.i("placeholder", 2, "HIDE_PLACEHOLDER");
      }
      removeView(this.jdField_a_of_type_AndroidViewView);
      return false;
    case 19: 
      if (QLog.isColorLevel()) {
        QLog.i("placeholder", 2, "SHOW_PLACEHOLDER");
      }
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      removeView(this.jdField_a_of_type_AndroidViewView);
      paramMessage = new RelativeLayout.LayoutParams(-1, -1);
      addView(this.jdField_a_of_type_AndroidViewView, paramMessage);
      return false;
    case 18: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView != null)
      {
        ((ViewGroup)findViewById(2131364485)).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView.c();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView = null;
        return false;
      }
      break;
    case 16: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView = new SixCombolEffectView(getContext());
        paramMessage = new RelativeLayout.LayoutParams(-1, -1);
        paramMessage.addRule(8, 2131370119);
        paramMessage.topMargin = ScreenUtil.dip2px(50.0F);
        ((ViewGroup)findViewById(2131364485)).addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView, paramMessage);
        return false;
      }
      break;
    case 15: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView;
      if (paramMessage != null)
      {
        removeView(paramMessage);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView.b();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView = null;
        return false;
      }
      break;
    case 14: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView;
      if (paramMessage != null)
      {
        paramMessage.a();
        return false;
      }
      break;
    case 13: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView = new HeartBreakCombolEffectView(getContext());
        paramMessage = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView, paramMessage);
        return false;
      }
      break;
    case 12: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView;
      if (paramMessage != null)
      {
        paramMessage.b();
        removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView = null;
        return false;
      }
      break;
    case 10: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView = new GreatMoveCombolEffectView(getContext());
        paramMessage = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView, paramMessage);
        return false;
      }
      break;
    case 9: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
      if ((paramMessage != null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = false;
        removeView(paramMessage);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = null;
        return false;
      }
      break;
    case 7: 
      localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
      if (localObject == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = new DiniFlyAnimationView(getContext());
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setFitFullScreenXY();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new FitSystemWindowsRelativeLayout.2(this));
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      else if (((DiniFlyAnimationView)localObject).isAnimating())
      {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.endAnimation();
      }
      if (1 == paramMessage.arg2) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleX(1.0F);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleX(-1.0F);
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        addView(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
      }
      PokeItemHelper.a(a(), getContext(), this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, null, paramMessage.arg1, "fullscreen");
      return false;
    case 6: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView;
      if (paramMessage != null)
      {
        removeView(paramMessage);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView = null;
        return false;
      }
      break;
    case 5: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView;
      if (paramMessage != null)
      {
        paramMessage.a(new Integer[] { Integer.valueOf(2130839099), Integer.valueOf(2130839100), Integer.valueOf(2130839101), Integer.valueOf(2130839102), Integer.valueOf(2130839103), Integer.valueOf(2130839104) });
        return false;
      }
      break;
    case 4: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView = new ZanCombolEffectView(getContext());
        paramMessage = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView.a(getResources().getDisplayMetrics().widthPixels, AIOUtils.b(40.0F, getResources()), 0.0F, 150.0F, AIOUtils.b(100.0F, getResources()), AIOUtils.b(3.0F, getResources()), AIOUtils.b(800.0F, getResources()), getResources().getDisplayMetrics().heightPixels, PokeItemHelper.a(a()));
        addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView, paramMessage);
        return false;
      }
      break;
    case 3: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView;
      if (paramMessage != null)
      {
        removeView(paramMessage);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView = null;
        return false;
      }
      break;
    case 2: 
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView;
      if (localObject != null)
      {
        ((HeartCombolEffectView)localObject).a(((Boolean)paramMessage.obj).booleanValue());
        return false;
      }
      break;
    case 1: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView = new HeartCombolEffectView(getContext(), PokeItemHelper.a(a()));
        paramMessage = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView, paramMessage);
      }
      break;
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    FitSystemWindowsRelativeLayout.OnInterceptTouchEventListener localOnInterceptTouchEventListener = this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$OnInterceptTouchEventListener;
    boolean bool;
    if (localOnInterceptTouchEventListener != null) {
      bool = localOnInterceptTouchEventListener.a(paramMotionEvent);
    } else {
      bool = false;
    }
    if (bool) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setDispatchTouchEventListener(FitSystemWindowsRelativeLayout.DispatchTouchEventListener paramDispatchTouchEventListener)
  {
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$DispatchTouchEventListener = paramDispatchTouchEventListener;
  }
  
  public void setOnInterceptTouchEventListener(FitSystemWindowsRelativeLayout.OnInterceptTouchEventListener paramOnInterceptTouchEventListener)
  {
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$OnInterceptTouchEventListener = paramOnInterceptTouchEventListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.FitSystemWindowsRelativeLayout
 * JD-Core Version:    0.7.0.1
 */