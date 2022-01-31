package com.tencent.qqmini.sdk.runtime.core.page;

import android.app.Activity;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import behq;
import bekj;
import bekn;
import bekp;
import bekx;
import bekz;
import belx;
import benc;
import berl;
import besc;
import besr;
import betc;
import bfbw;
import bfcg;
import bfch;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

public class PageWebviewContainer
  extends FrameLayout
  implements SwipeRefreshLayout.OnRefreshListener, benc
{
  private SwipeRefreshLayout jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout;
  private behq jdField_a_of_type_Behq;
  private bfbw jdField_a_of_type_Bfbw;
  private AbsAppBrandPage jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage;
  private NativeViewContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer;
  private String jdField_a_of_type_JavaLangString = besr.d;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public PageWebviewContainer(behq parambehq, AbsAppBrandPage paramAbsAppBrandPage)
  {
    super(parambehq.a());
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage = paramAbsAppBrandPage;
    this.jdField_a_of_type_Behq = parambehq;
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer = new NativeViewContainer(parambehq.a(), this);
    ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer, 4);
    this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout = new SwipeRefreshLayout(getContext());
    this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout.setOnRefreshListener(this);
    addView(this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout, new FrameLayout.LayoutParams(-1, -1));
  }
  
  private bekp a()
  {
    if ((this.jdField_a_of_type_Behq != null) && (this.jdField_a_of_type_Behq.a() != null)) {
      return (bekp)this.jdField_a_of_type_Behq.a().apkgInfo;
    }
    return null;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Bfbw.a().b();
  }
  
  public Activity a()
  {
    if (this.jdField_a_of_type_Behq != null) {
      return this.jdField_a_of_type_Behq.a();
    }
    return null;
  }
  
  public bfbw a()
  {
    return this.jdField_a_of_type_Bfbw;
  }
  
  public NativeViewContainer a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer;
  }
  
  public PageWebview a()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) {
      return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a();
    }
    return null;
  }
  
  public String a(bekj parambekj)
  {
    betc.a("PageWebviewContainer", "event = " + parambekj.jdField_a_of_type_JavaLangString + ", params = " + parambekj.jdField_b_of_type_JavaLangString);
    if ("startPullDownRefresh".equals(parambekj.jdField_a_of_type_JavaLangString)) {
      bekz.a(new PageWebviewContainer.3(this, parambekj));
    }
    for (;;)
    {
      return null;
      if ("stopPullDownRefresh".equals(parambekj.jdField_a_of_type_JavaLangString))
      {
        bekz.a(new PageWebviewContainer.4(this, parambekj));
      }
      else if ("disableScrollBounce".equals(parambekj.jdField_a_of_type_JavaLangString))
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(parambekj.jdField_b_of_type_JavaLangString);
          if (!localJSONObject.has("disable")) {
            break label182;
          }
          bekz.a(new PageWebviewContainer.5(this, localJSONObject.optBoolean("disable", false), parambekj));
        }
        catch (Exception localException)
        {
          betc.d("PageWebviewContainer", "EVENT_DISABLE_SROLL_BOUNCE error," + localException);
          parambekj.a("params error");
        }
        continue;
        label182:
        betc.d("PageWebviewContainer", "EVENT_DISABLE_SROLL_BOUNCE params error.");
        parambekj.a("params error");
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bfbw != null) {
      this.jdField_a_of_type_Bfbw.c();
    }
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.removeAllViews();
    }
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.addView(paramView);
    }
  }
  
  public void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.addView(paramView, paramLayoutParams);
    }
  }
  
  public void a(belx parambelx)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a() != null)) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a().a(parambelx);
    }
  }
  
  public void a(String paramString)
  {
    int i = 0;
    Boolean localBoolean;
    boolean bool;
    if (a() != null)
    {
      localBoolean = a().a().a.a.a;
      if (localBoolean != null) {
        break label325;
      }
      bool = false;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_JavaLangString = a().a().a.a.jdField_b_of_type_JavaLangString;
      paramString = a().a().a(paramString);
      if (paramString != null)
      {
        localBoolean = paramString.a.a;
        if (localBoolean != null) {
          break label334;
        }
        bool = this.jdField_a_of_type_Boolean;
        label94:
        this.jdField_a_of_type_Boolean = bool;
        localBoolean = paramString.a.jdField_b_of_type_JavaLangBoolean;
        if (localBoolean != null) {
          break label343;
        }
        bool = this.b;
        label118:
        this.b = bool;
        paramString = paramString.a.jdField_b_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramString)) {
          this.jdField_a_of_type_JavaLangString = paramString;
        }
      }
      if (this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout != null) {
        this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout.setEnabled(this.jdField_a_of_type_Boolean);
      }
      if (this.b)
      {
        this.jdField_a_of_type_Bfbw.a().setVerticalScrollBarEnabled(false);
        this.jdField_a_of_type_Bfbw.a().setHorizontalScrollBarEnabled(false);
        if ((this.jdField_a_of_type_Bfbw.a().getView() != null) && (this.jdField_a_of_type_Bfbw.a().getView().getViewTreeObserver() != null) && (this.jdField_a_of_type_Bfbw.a().getView().getViewTreeObserver().isAlive())) {
          this.jdField_a_of_type_Bfbw.a().getView().getViewTreeObserver().addOnScrollChangedListener(new bfch(this));
        }
      }
      if ((this.jdField_a_of_type_Behq != null) && (this.jdField_a_of_type_Behq.a() != null) && (!this.jdField_a_of_type_Behq.a().isFinishing()))
      {
        if (!besr.c.equals(this.jdField_a_of_type_JavaLangString)) {
          break label352;
        }
        i = 4;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Behq.a().setRequestedOrientation(i);
      return;
      label325:
      bool = localBoolean.booleanValue();
      break;
      label334:
      bool = localBoolean.booleanValue();
      break label94;
      label343:
      bool = localBoolean.booleanValue();
      break label118;
      label352:
      if (!besr.e.equals(this.jdField_a_of_type_JavaLangString)) {
        i = 1;
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    b(paramString1, paramString2);
  }
  
  public void a(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    b(paramString, paramJSONObject, paramInt);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) {
      return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a();
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) {
      return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a();
    }
    return 0;
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Bfbw != null) {
      this.jdField_a_of_type_Bfbw.a(paramString1, paramString2, a());
    }
  }
  
  public void b(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.jdField_a_of_type_Bfbw != null)
    {
      paramString = bekx.b(paramString, paramJSONObject);
      if (paramString == null) {
        break label32;
      }
    }
    label32:
    for (paramString = paramString.toString();; paramString = "")
    {
      this.jdField_a_of_type_Bfbw.a(paramInt, paramString);
      return;
    }
  }
  
  public void onRefresh()
  {
    if (this.jdField_a_of_type_Behq != null) {
      this.jdField_a_of_type_Behq.a(bekn.a("onPullDownRefresh", new JSONObject().toString(), a()));
    }
  }
  
  public void setBrandPageWebview(bfbw parambfbw)
  {
    if (parambfbw != null)
    {
      this.jdField_a_of_type_Bfbw = parambfbw;
      if (this.jdField_a_of_type_Bfbw.a() != null)
      {
        this.jdField_a_of_type_Bfbw.a().addView(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer, new FrameLayout.LayoutParams(-1, -1));
        this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout.addView(this.jdField_a_of_type_Bfbw.a(), new ViewGroup.LayoutParams(-1, -1));
        this.jdField_a_of_type_Bfbw.a().setOnWebviewScrollListener(new bfcg(this));
      }
    }
  }
  
  public void setCurInputId(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a() != null)) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a().setCurShowingInputId(paramInt);
    }
  }
  
  public void setSoftKeyboardStateListener(belx parambelx)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a() != null)) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a().setSoftKeyboardStateListener(parambelx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer
 * JD-Core Version:    0.7.0.1
 */