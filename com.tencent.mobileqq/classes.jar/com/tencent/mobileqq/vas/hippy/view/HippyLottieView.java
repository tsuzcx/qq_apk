package com.tencent.mobileqq.vas.hippy.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;

public class HippyLottieView
  extends FrameLayout
  implements HippyViewBase
{
  private int jdField_a_of_type_Int;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  private int c;
  private int d;
  
  public HippyLottieView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(getContext()).inflate(2131563017, this);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)findViewById(2131370482));
  }
  
  public void a()
  {
    QLog.d("HippyLottieView", 1, "HippyLottieView postDraw");
    measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void a(HippyMap paramHippyMap)
  {
    QLog.d("HippyLottieView", 1, "HippyLottieView init");
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) {
      a();
    }
  }
  
  public void b()
  {
    QLog.d("HippyLottieView", 1, "HippyLottieView destory");
    DiniFlyAnimationView localDiniFlyAnimationView = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if (localDiniFlyAnimationView != null) {
      localDiniFlyAnimationView.destroyDrawingCache();
    }
  }
  
  public void c()
  {
    QLog.d("HippyLottieView", 1, "HippyLottieView play");
    f();
    DiniFlyAnimationView localDiniFlyAnimationView = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if (localDiniFlyAnimationView != null) {
      localDiniFlyAnimationView.playAnimation();
    }
  }
  
  public void d()
  {
    QLog.d("HippyLottieView", 1, "HippyLottieView resume");
    DiniFlyAnimationView localDiniFlyAnimationView = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if (localDiniFlyAnimationView != null) {
      localDiniFlyAnimationView.resumeAnimation();
    }
  }
  
  public void e()
  {
    QLog.d("HippyLottieView", 1, "HippyLottieView pause");
    DiniFlyAnimationView localDiniFlyAnimationView = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if (localDiniFlyAnimationView != null) {
      localDiniFlyAnimationView.pauseAnimation();
    }
  }
  
  public void f()
  {
    DiniFlyAnimationView localDiniFlyAnimationView = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if (localDiniFlyAnimationView != null)
    {
      localDiniFlyAnimationView.setAnimationFromUrl(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setMinFrame(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setMaxFrame(this.b);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setRepeatCount(this.c);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setSpeed(this.d);
    }
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildAt(0) != null) {
      getChildAt(0).layout(0, 0, getWidth(), getHeight());
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getChildAt(0) != null) {
      getChildAt(0).measure(paramInt1, paramInt2);
    }
  }
  
  public void setEndFrame(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setFitFullScreenXY()
  {
    DiniFlyAnimationView localDiniFlyAnimationView = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if (localDiniFlyAnimationView != null) {
      localDiniFlyAnimationView.setFitFullScreenXY();
    }
  }
  
  public void setFrame(int paramInt)
  {
    QLog.d("HippyLottieView", 1, "HippyLottieView setFrame");
    DiniFlyAnimationView localDiniFlyAnimationView = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if (localDiniFlyAnimationView != null) {
      localDiniFlyAnimationView.setFrame(paramInt);
    }
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
  
  public void setRepeatCount(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setSpeed(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setSrc(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setStartFrame(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.HippyLottieView
 * JD-Core Version:    0.7.0.1
 */