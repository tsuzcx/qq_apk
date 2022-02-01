package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.content.Context;
import android.view.View.OnLayoutChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.utils.ViewUtils;

public class NativeMiddleBodyView$RadiusView
  extends RelativeLayout
{
  final int jdField_a_of_type_Int = ViewUtils.a(8.0F);
  String jdField_a_of_type_JavaLangString = null;
  String b = null;
  String c = null;
  String d = null;
  
  public NativeMiddleBodyView$RadiusView(Context paramContext)
  {
    super(paramContext);
  }
  
  public View.OnLayoutChangeListener a()
  {
    return new NativeMiddleBodyView.RadiusView.1(this);
  }
  
  public void setBottomLeftRadius(String paramString)
  {
    this.b = paramString;
    NativeReadInjoyImageView localNativeReadInjoyImageView = new NativeReadInjoyImageView(getContext());
    localNativeReadInjoyImageView.setIsCacheIcon(true);
    localNativeReadInjoyImageView.setIsClosedoAlphaAniamation(true);
    int i = this.jdField_a_of_type_Int;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(12);
    addView(localNativeReadInjoyImageView, localLayoutParams);
    localNativeReadInjoyImageView.setImageSrc(paramString);
  }
  
  public void setBottomRightRadius(String paramString)
  {
    this.d = paramString;
    NativeReadInjoyImageView localNativeReadInjoyImageView = new NativeReadInjoyImageView(getContext());
    localNativeReadInjoyImageView.setIsCacheIcon(true);
    localNativeReadInjoyImageView.setIsClosedoAlphaAniamation(true);
    int i = this.jdField_a_of_type_Int;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(11);
    addView(localNativeReadInjoyImageView, localLayoutParams);
    localNativeReadInjoyImageView.setImageSrc(paramString);
  }
  
  public void setLeftTopRadius(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    NativeReadInjoyImageView localNativeReadInjoyImageView = new NativeReadInjoyImageView(getContext());
    localNativeReadInjoyImageView.setIsCacheIcon(true);
    localNativeReadInjoyImageView.setIsClosedoAlphaAniamation(true);
    int i = this.jdField_a_of_type_Int;
    addView(localNativeReadInjoyImageView, new RelativeLayout.LayoutParams(i, i));
    localNativeReadInjoyImageView.setImageSrc(paramString);
  }
  
  public void setRightTopRadius(String paramString)
  {
    this.c = paramString;
    NativeReadInjoyImageView localNativeReadInjoyImageView = new NativeReadInjoyImageView(getContext());
    localNativeReadInjoyImageView.setIsCacheIcon(true);
    localNativeReadInjoyImageView.setIsClosedoAlphaAniamation(true);
    int i = this.jdField_a_of_type_Int;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(11);
    addView(localNativeReadInjoyImageView, localLayoutParams);
    localNativeReadInjoyImageView.setImageSrc(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeMiddleBodyView.RadiusView
 * JD-Core Version:    0.7.0.1
 */