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
import bdcz;
import bdfs;
import bdfv;
import bdfx;
import bdgg;
import bdgi;
import bdhd;
import bdii;
import bdml;
import bdna;
import bdnl;
import bdnw;
import bdux;
import bdvh;
import bdvi;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

public class PageWebviewContainer
  extends FrameLayout
  implements SwipeRefreshLayout.OnRefreshListener, bdii
{
  private SwipeRefreshLayout jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout;
  private bdcz jdField_a_of_type_Bdcz;
  private bdux jdField_a_of_type_Bdux;
  private AbsAppBrandPage jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage;
  private NativeViewContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer;
  private String jdField_a_of_type_JavaLangString = bdnl.d;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public PageWebviewContainer(bdcz parambdcz, AbsAppBrandPage paramAbsAppBrandPage)
  {
    super(parambdcz.a());
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage = paramAbsAppBrandPage;
    this.jdField_a_of_type_Bdcz = parambdcz;
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer = new NativeViewContainer(parambdcz.a(), this);
    ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer, 4);
    this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout = new SwipeRefreshLayout(getContext());
    this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout.setOnRefreshListener(this);
    addView(this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout, new FrameLayout.LayoutParams(-1, -1));
  }
  
  private bdfx a()
  {
    if ((this.jdField_a_of_type_Bdcz != null) && (this.jdField_a_of_type_Bdcz.a() != null)) {
      return (bdfx)this.jdField_a_of_type_Bdcz.a().apkgInfo;
    }
    return null;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Bdux.a().b();
  }
  
  public Activity a()
  {
    if (this.jdField_a_of_type_Bdcz != null) {
      return this.jdField_a_of_type_Bdcz.a();
    }
    return null;
  }
  
  public bdux a()
  {
    return this.jdField_a_of_type_Bdux;
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
  
  public String a(bdfs parambdfs)
  {
    bdnw.a("PageWebviewContainer", "event = " + parambdfs.jdField_a_of_type_JavaLangString + ", params = " + parambdfs.jdField_b_of_type_JavaLangString);
    if ("startPullDownRefresh".equals(parambdfs.jdField_a_of_type_JavaLangString)) {
      bdgi.a(new PageWebviewContainer.3(this, parambdfs));
    }
    for (;;)
    {
      return null;
      if ("stopPullDownRefresh".equals(parambdfs.jdField_a_of_type_JavaLangString))
      {
        bdgi.a(new PageWebviewContainer.4(this, parambdfs));
      }
      else if ("disableScrollBounce".equals(parambdfs.jdField_a_of_type_JavaLangString))
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(parambdfs.jdField_b_of_type_JavaLangString);
          if (!localJSONObject.has("disable")) {
            break label182;
          }
          bdgi.a(new PageWebviewContainer.5(this, localJSONObject.optBoolean("disable", false), parambdfs));
        }
        catch (Exception localException)
        {
          bdnw.d("PageWebviewContainer", "EVENT_DISABLE_SROLL_BOUNCE error," + localException);
          parambdfs.a("params error");
        }
        continue;
        label182:
        bdnw.d("PageWebviewContainer", "EVENT_DISABLE_SROLL_BOUNCE params error.");
        parambdfs.a("params error");
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bdux != null) {
      this.jdField_a_of_type_Bdux.c();
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
  
  public void a(bdhd parambdhd)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a() != null)) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a().a(parambdhd);
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
        this.jdField_a_of_type_Bdux.a().setVerticalScrollBarEnabled(false);
        this.jdField_a_of_type_Bdux.a().setHorizontalScrollBarEnabled(false);
        if ((this.jdField_a_of_type_Bdux.a().getView() != null) && (this.jdField_a_of_type_Bdux.a().getView().getViewTreeObserver() != null) && (this.jdField_a_of_type_Bdux.a().getView().getViewTreeObserver().isAlive())) {
          this.jdField_a_of_type_Bdux.a().getView().getViewTreeObserver().addOnScrollChangedListener(new bdvi(this));
        }
      }
      if ((this.jdField_a_of_type_Bdcz != null) && (this.jdField_a_of_type_Bdcz.a() != null) && (!this.jdField_a_of_type_Bdcz.a().isFinishing()))
      {
        if (!bdnl.c.equals(this.jdField_a_of_type_JavaLangString)) {
          break label352;
        }
        i = 4;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdcz.a().setRequestedOrientation(i);
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
      if (!bdnl.e.equals(this.jdField_a_of_type_JavaLangString)) {
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
    if (this.jdField_a_of_type_Bdux != null) {
      this.jdField_a_of_type_Bdux.a(paramString1, paramString2, a());
    }
  }
  
  public void b(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.jdField_a_of_type_Bdux != null)
    {
      paramString = bdgg.b(paramString, paramJSONObject);
      if (paramString == null) {
        break label32;
      }
    }
    label32:
    for (paramString = paramString.toString();; paramString = "")
    {
      this.jdField_a_of_type_Bdux.a(paramInt, paramString);
      return;
    }
  }
  
  public void onRefresh()
  {
    if (this.jdField_a_of_type_Bdcz != null) {
      this.jdField_a_of_type_Bdcz.a(bdfv.a("onPullDownRefresh", new JSONObject().toString(), a()));
    }
  }
  
  public void setBrandPageWebview(bdux parambdux)
  {
    if (parambdux != null)
    {
      this.jdField_a_of_type_Bdux = parambdux;
      if (this.jdField_a_of_type_Bdux.a() != null)
      {
        this.jdField_a_of_type_Bdux.a().addView(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer, new FrameLayout.LayoutParams(-1, -1));
        this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout.addView(this.jdField_a_of_type_Bdux.a(), new ViewGroup.LayoutParams(-1, -1));
        this.jdField_a_of_type_Bdux.a().setOnWebviewScrollListener(new bdvh(this));
      }
    }
  }
  
  public void setCurInputId(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a() != null)) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a().setCurShowingInputId(paramInt);
    }
  }
  
  public void setSoftKeyboardStateListener(bdhd parambdhd)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a() != null)) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a().setSoftKeyboardStateListener(parambdhd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer
 * JD-Core Version:    0.7.0.1
 */