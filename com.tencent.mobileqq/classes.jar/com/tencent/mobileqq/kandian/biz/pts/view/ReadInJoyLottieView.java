package com.tencent.mobileqq.kandian.biz.pts.view;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.base.view.ReadInJoyLottieDrawable;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyLottieView
  extends ViewBase
{
  ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new ReadInJoyLottieView.1(this);
  private ReadInJoyLottieDrawable jdField_a_of_type_ComTencentMobileqqKandianBaseViewReadInJoyLottieDrawable;
  private NativeReadInjoyImageView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView;
  private boolean jdField_a_of_type_Boolean = false;
  
  public ReadInJoyLottieView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView = new NativeReadInjoyImageView(paramVafContext.getContext());
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.getViewTreeObserver() != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public void a()
  {
    ReadInJoyLottieDrawable localReadInJoyLottieDrawable = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewReadInJoyLottieDrawable;
    if (localReadInJoyLottieDrawable != null) {
      localReadInJoyLottieDrawable.resumeAnimation();
    }
  }
  
  public void b()
  {
    ReadInJoyLottieDrawable localReadInJoyLottieDrawable = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewReadInJoyLottieDrawable;
    if (localReadInJoyLottieDrawable != null) {
      localReadInJoyLottieDrawable.pauseAnimation();
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setBackgroundColor(this.mBackground);
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    if (paramInt != 1169) {
      return super.setAttribute(paramInt, paramString);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewReadInJoyLottieDrawable = ReadInJoyLottieDrawable.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewReadInJoyLottieDrawable);
      return true;
    }
    catch (Exception paramString)
    {
      QLog.d("ReadInJoyLottieView", 1, paramString.getMessage());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyLottieView
 * JD-Core Version:    0.7.0.1
 */