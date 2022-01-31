package com.tencent.qqmini.sdk.minigame.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import behq;
import berz;
import besr;
import betc;
import bexx;
import bfgl;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;

public class GameNavigationBar
  extends RelativeLayout
{
  private int jdField_a_of_type_Int = -16777216;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private CapsuleButton jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int b = -1;
  
  public GameNavigationBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GameNavigationBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GameNavigationBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton.a(this.b);
    }
  }
  
  private void c()
  {
    if ("custom".equals(this.jdField_a_of_type_JavaLangString)) {
      a(0);
    }
  }
  
  private void d()
  {
    if ((getContext() != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getContext());
      localObject = new ViewGroup.LayoutParams(-1, -2);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClipChildren(false);
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton = new CapsuleButton(getContext());
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton.setId(2131364687);
      localObject = new RelativeLayout.LayoutParams(bfgl.a(getContext(), 80.0F), bfgl.a(getContext(), 30.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
      ((RelativeLayout.LayoutParams)localObject).topMargin = (bfgl.a(getContext(), 9.0F) + bfgl.d(getContext()));
      ((RelativeLayout.LayoutParams)localObject).rightMargin = bfgl.a(getContext(), 12.5F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton, (ViewGroup.LayoutParams)localObject);
      addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_Int);
      b();
      this.jdField_a_of_type_Boolean = true;
    }
    while (!betc.a())
    {
      Object localObject;
      return;
    }
    betc.a("GameNavigationBar", "[init] context null");
  }
  
  public CapsuleButton a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton;
  }
  
  public GameNavigationBar a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_Int);
    }
    return this;
  }
  
  public GameNavigationBar a(besr parambesr)
  {
    if (parambesr != null)
    {
      parambesr = parambesr.a;
      if (parambesr != null)
      {
        if (!TextUtils.isEmpty(parambesr.jdField_a_of_type_JavaLangString)) {
          a(parambesr.jdField_a_of_type_JavaLangString);
        }
        a(parambesr.jdField_a_of_type_Int);
        if (!TextUtils.isEmpty(parambesr.c)) {
          b(parambesr.c);
        }
      }
    }
    return this;
  }
  
  public GameNavigationBar a(String paramString)
  {
    if ("black".equals(paramString)) {
      this.b = -16777216;
    }
    for (;;)
    {
      b();
      return this;
      if ("white".equals(paramString)) {
        this.b = -1;
      }
    }
  }
  
  public void a()
  {
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton.getLayoutParams()).topMargin = bfgl.a(getContext(), 9.0F);
  }
  
  public void a(behq parambehq)
  {
    parambehq = new bexx(parambehq);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton.a(parambehq);
  }
  
  public GameNavigationBar b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    c();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.widget.GameNavigationBar
 * JD-Core Version:    0.7.0.1
 */