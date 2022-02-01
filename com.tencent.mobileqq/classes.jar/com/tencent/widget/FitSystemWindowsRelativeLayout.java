package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
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
      localLayoutParams.addRule(8, 2131370460);
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131364598);
      localViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView);
      localViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView, localLayoutParams);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("placeholder", 2, "dispatchTouchEvent() called with: ev = [" + paramMotionEvent + "]");
    }
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$DispatchTouchEventListener != null) {
      bool = this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$DispatchTouchEventListener.a(paramMotionEvent);
    }
    if (bool) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean fitSystemWindows(Rect paramRect)
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
    switch (paramMessage.what)
    {
    case 8: 
    case 11: 
    case 17: 
    default: 
    case 7: 
    case 9: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 10: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 18: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  return false;
                                  if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null)
                                  {
                                    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = new DiniFlyAnimationView(getContext());
                                    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setFitFullScreenXY();
                                    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new FitSystemWindowsRelativeLayout.2(this));
                                    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
                                    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setLayoutParams(localLayoutParams);
                                    if (1 != paramMessage.arg2) {
                                      break label248;
                                    }
                                    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleX(1.0F);
                                  }
                                  for (;;)
                                  {
                                    if (!this.jdField_a_of_type_Boolean)
                                    {
                                      this.jdField_a_of_type_Boolean = true;
                                      addView(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
                                    }
                                    PokeItemHelper.a(a(), getContext(), this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, null, paramMessage.arg1, "fullscreen");
                                    return false;
                                    if (!this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()) {
                                      break;
                                    }
                                    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.endAnimation();
                                    break;
                                    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleX(-1.0F);
                                  }
                                } while ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null) || (!this.jdField_a_of_type_Boolean));
                                this.jdField_a_of_type_Boolean = false;
                                removeView(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
                                this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = null;
                                return false;
                              } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView != null);
                              this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView = new HeartCombolEffectView(getContext(), PokeItemHelper.a(a()));
                              paramMessage = new RelativeLayout.LayoutParams(-1, -1);
                              addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView, paramMessage);
                              return false;
                            } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView == null);
                            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView.a(((Boolean)paramMessage.obj).booleanValue());
                            return false;
                          } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView == null);
                          removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView);
                          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartCombolEffectView = null;
                          return false;
                        } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView != null);
                        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView = new ZanCombolEffectView(getContext());
                        paramMessage = new RelativeLayout.LayoutParams(-1, -1);
                        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView.a(getResources().getDisplayMetrics().widthPixels, AIOUtils.a(40.0F, getResources()), 0.0F, 150.0F, AIOUtils.a(100.0F, getResources()), AIOUtils.a(3.0F, getResources()), AIOUtils.a(800.0F, getResources()), getResources().getDisplayMetrics().heightPixels, PokeItemHelper.a(a()));
                        addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView, paramMessage);
                        return false;
                      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView == null);
                      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView.a(new Integer[] { Integer.valueOf(2130839245), Integer.valueOf(2130839246), Integer.valueOf(2130839247), Integer.valueOf(2130839248), Integer.valueOf(2130839249), Integer.valueOf(2130839250) });
                      return false;
                    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView == null);
                    removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView);
                    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView = null;
                    return false;
                  } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView != null);
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView = new GreatMoveCombolEffectView(getContext());
                  paramMessage = new RelativeLayout.LayoutParams(-1, -1);
                  addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView, paramMessage);
                  return false;
                } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView == null);
                this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView.b();
                removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView);
                this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView = null;
                return false;
              } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView != null);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView = new HeartBreakCombolEffectView(getContext());
              paramMessage = new RelativeLayout.LayoutParams(-1, -1);
              addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView, paramMessage);
              return false;
            } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView == null);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView.a();
            return false;
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView == null);
          removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView.b();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView = null;
          return false;
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView != null);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView = new SixCombolEffectView(getContext());
        paramMessage = new RelativeLayout.LayoutParams(-1, -1);
        paramMessage.addRule(8, 2131370460);
        paramMessage.topMargin = ScreenUtil.dip2px(50.0F);
        ((ViewGroup)findViewById(2131364598)).addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView, paramMessage);
        return false;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView == null);
      ((ViewGroup)findViewById(2131364598)).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView = null;
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
    case 20: 
      label248:
      if (QLog.isColorLevel()) {
        QLog.i("placeholder", 2, "HIDE_PLACEHOLDER");
      }
      removeView(this.jdField_a_of_type_AndroidViewView);
      return false;
    }
    clearAnimation();
    return false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$OnInterceptTouchEventListener != null) {
      bool = this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$OnInterceptTouchEventListener.a(paramMotionEvent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.FitSystemWindowsRelativeLayout
 * JD-Core Version:    0.7.0.1
 */