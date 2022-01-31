package com.tencent.mobileqq.gamecenter.web.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import aqac;
import aqad;
import com.tencent.biz.ui.TouchWebView;
import vms;

public abstract class BaseNestScrollWebView
  extends TouchWebView
{
  public int a;
  private aqac jdField_a_of_type_Aqac;
  private aqad jdField_a_of_type_Aqad;
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
  
  public void a(aqac paramaqac)
  {
    this.jdField_a_of_type_Aqac = paramaqac;
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
    if (((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) && (this.jdField_a_of_type_Aqad != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Aqad.a(this);
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
    if ((this.jdField_a_of_type_Aqac != null) && (!this.jdField_a_of_type_Aqac.a())) {
      this.jdField_a_of_type_Aqac.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_Aqac != null) && (!this.jdField_a_of_type_Aqac.a())) {
      this.jdField_a_of_type_Aqac.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void setLoadingView(aqad paramaqad)
  {
    if (((paramaqad == null) || (!this.jdField_a_of_type_Boolean)) && (this.jdField_a_of_type_Aqad != null)) {
      this.jdField_a_of_type_Aqad.b(this);
    }
    if (this.jdField_a_of_type_Aqad == null) {
      this.jdField_a_of_type_Aqad = paramaqad;
    }
    if (this.jdField_a_of_type_Aqad != null) {
      this.jdField_a_of_type_Aqad.a(this);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void setPaddingTop(int paramInt)
  {
    String str = "if (document.body && document.body.style) {document.body.style.paddingTop='" + vms.a(getContext(), paramInt) + "px';} void 0";
    loadUrl("javascript:" + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.view.BaseNestScrollWebView
 * JD-Core Version:    0.7.0.1
 */