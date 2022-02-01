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
    paramMultiCardFragment = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
    if (paramMultiCardFragment != null) {
      paramMultiCardFragment.a(paramMultiCardCustomViewDelegateListener);
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout;
    if (localObject != null)
    {
      ((MultiCardRootLayout)localObject).a(false);
      this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getScaleX();
      this.jdField_b_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getScaleY();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = ((MultiCardCustomLayout)localObject).getLayoutParams();
      localObject = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getLocationOnScreen((int[])localObject);
      this.jdField_b_of_type_Int = localObject[0];
      this.c = localObject[1];
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.a(true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.findViewById(2131371609);
      if (localObject != null)
      {
        this.jdField_a_of_type_Int = ((View)localObject).getVisibility();
        ((View)localObject).setVisibility(8);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout;
    if (localObject != null)
    {
      MultiCardCustomLayout localMultiCardCustomLayout = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout;
      if (localMultiCardCustomLayout != null) {
        ((MultiCardRootLayout)localObject).removeView(localMultiCardCustomLayout);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
    if (localObject != null) {
      ((MultiCardCustomViewDelegate)localObject).b(0);
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null))
    {
      if ((((MultiCardCustomLayout)localObject).getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout);
      }
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.a(false);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setScaleX(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setScaleY(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.a(true);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.addView(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout, 0);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
    if (localObject != null) {
      ((MultiCardCustomViewDelegate)localObject).b(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.ZoomParam
 * JD-Core Version:    0.7.0.1
 */