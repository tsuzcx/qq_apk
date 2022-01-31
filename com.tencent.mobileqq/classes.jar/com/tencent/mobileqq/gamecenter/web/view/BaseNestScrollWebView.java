package com.tencent.mobileqq.gamecenter.web.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import aspd;
import aspe;
import com.tencent.biz.ui.TouchWebView;
import xsm;

public abstract class BaseNestScrollWebView
  extends TouchWebView
{
  public int a;
  private aspd jdField_a_of_type_Aspd;
  private aspe jdField_a_of_type_Aspe;
  public boolean a;
  
  public BaseNestScrollWebView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public BaseNestScrollWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(aspd paramaspd)
  {
    this.jdField_a_of_type_Aspd = paramaspd;
  }
  
  public boolean a()
  {
    if (canGoBack())
    {
      goBack();
      return true;
    }
    return false;
  }
  
  public void loadUrl(String paramString)
  {
    super.loadUrl(paramString);
    if (((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) && (this.jdField_a_of_type_Aspe != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Aspe.a(this);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4) {
      bool = a();
    }
    if (bool) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_Aspd != null) && (!this.jdField_a_of_type_Aspd.a())) {
      this.jdField_a_of_type_Aspd.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_Aspd != null) && (!this.jdField_a_of_type_Aspd.a())) {
      this.jdField_a_of_type_Aspd.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void setLoadingView(aspe paramaspe)
  {
    if (((paramaspe == null) || (!this.jdField_a_of_type_Boolean)) && (this.jdField_a_of_type_Aspe != null)) {
      this.jdField_a_of_type_Aspe.b(this);
    }
    if (this.jdField_a_of_type_Aspe == null) {
      this.jdField_a_of_type_Aspe = paramaspe;
    }
    if (this.jdField_a_of_type_Aspe != null) {
      this.jdField_a_of_type_Aspe.a(this);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void setPaddingTop(int paramInt)
  {
    String str = "if (document.body && document.body.style) {document.body.style.paddingTop='" + xsm.a(getContext(), paramInt) + "px';} void 0";
    loadUrl("javascript:" + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.view.BaseNestScrollWebView
 * JD-Core Version:    0.7.0.1
 */