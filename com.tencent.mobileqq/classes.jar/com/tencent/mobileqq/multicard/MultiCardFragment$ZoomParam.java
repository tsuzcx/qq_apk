package com.tencent.mobileqq.multicard;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

class MultiCardFragment$ZoomParam
{
  public float a;
  public int a;
  public ViewGroup.LayoutParams a;
  public MultiCardCustomLayout a;
  public MultiCardCustomViewDelegate a;
  public MultiCardRootLayout a;
  public float b;
  public int b;
  public int c;
  
  public MultiCardFragment$ZoomParam(MultiCardFragment paramMultiCardFragment, MultiCardRootLayout paramMultiCardRootLayout, MultiCardCustomLayout paramMultiCardCustomLayout, MultiCardCustomViewDelegate paramMultiCardCustomViewDelegate, MultiCardCustomViewDelegate.MultiCardCustomViewDelegateListener paramMultiCardCustomViewDelegateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout = paramMultiCardRootLayout;
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout = paramMultiCardCustomLayout;
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate = paramMultiCardCustomViewDelegate;
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a(paramMultiCardCustomViewDelegateListener);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.a(false);
      this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getScaleX();
      this.jdField_b_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getScaleY();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getLayoutParams();
      Object localObject = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getLocationOnScreen((int[])localObject);
      this.jdField_b_of_type_Int = localObject[0];
      this.c = localObject[1];
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.a(true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.findViewById(2131372003);
      if (localObject != null)
      {
        this.jdField_a_of_type_Int = ((View)localObject).getVisibility();
        ((View)localObject).setVisibility(8);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout != null)) {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.b(0);
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout);
      }
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.a(false);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setScaleX(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setScaleY(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.a(true);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.addView(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout, 0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.b(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.ZoomParam
 * JD-Core Version:    0.7.0.1
 */