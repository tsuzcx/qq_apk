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
  final int a = ViewUtils.dip2px(8.0F);
  String b = null;
  String c = null;
  String d = null;
  String e = null;
  
  public NativeMiddleBodyView$RadiusView(Context paramContext)
  {
    super(paramContext);
  }
  
  public View.OnLayoutChangeListener getLayoutChangeListener()
  {
    return new NativeMiddleBodyView.RadiusView.1(this);
  }
  
  public void setBottomLeftRadius(String paramString)
  {
    this.c = paramString;
    NativeReadInjoyImageView localNativeReadInjoyImageView = new NativeReadInjoyImageView(getContext());
    localNativeReadInjoyImageView.setIsCacheIcon(true);
    localNativeReadInjoyImageView.setIsClosedoAlphaAniamation(true);
    int i = this.a;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(12);
    addView(localNativeReadInjoyImageView, localLayoutParams);
    localNativeReadInjoyImageView.setImageSrc(paramString);
  }
  
  public void setBottomRightRadius(String paramString)
  {
    this.e = paramString;
    NativeReadInjoyImageView localNativeReadInjoyImageView = new NativeReadInjoyImageView(getContext());
    localNativeReadInjoyImageView.setIsCacheIcon(true);
    localNativeReadInjoyImageView.setIsClosedoAlphaAniamation(true);
    int i = this.a;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(11);
    addView(localNativeReadInjoyImageView, localLayoutParams);
    localNativeReadInjoyImageView.setImageSrc(paramString);
  }
  
  public void setLeftTopRadius(String paramString)
  {
    this.b = paramString;
    NativeReadInjoyImageView localNativeReadInjoyImageView = new NativeReadInjoyImageView(getContext());
    localNativeReadInjoyImageView.setIsCacheIcon(true);
    localNativeReadInjoyImageView.setIsClosedoAlphaAniamation(true);
    int i = this.a;
    addView(localNativeReadInjoyImageView, new RelativeLayout.LayoutParams(i, i));
    localNativeReadInjoyImageView.setImageSrc(paramString);
  }
  
  public void setRightTopRadius(String paramString)
  {
    this.d = paramString;
    NativeReadInjoyImageView localNativeReadInjoyImageView = new NativeReadInjoyImageView(getContext());
    localNativeReadInjoyImageView.setIsCacheIcon(true);
    localNativeReadInjoyImageView.setIsClosedoAlphaAniamation(true);
    int i = this.a;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(11);
    addView(localNativeReadInjoyImageView, localLayoutParams);
    localNativeReadInjoyImageView.setImageSrc(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeMiddleBodyView.RadiusView
 * JD-Core Version:    0.7.0.1
 */