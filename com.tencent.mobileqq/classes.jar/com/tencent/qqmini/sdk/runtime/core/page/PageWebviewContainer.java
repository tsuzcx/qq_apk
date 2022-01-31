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
import begz;
import bejs;
import bejw;
import bejy;
import bekg;
import beki;
import belg;
import beml;
import bequ;
import berl;
import besa;
import besl;
import bfbf;
import bfbp;
import bfbq;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

public class PageWebviewContainer
  extends FrameLayout
  implements SwipeRefreshLayout.OnRefreshListener, beml
{
  private SwipeRefreshLayout jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout;
  private begz jdField_a_of_type_Begz;
  private bfbf jdField_a_of_type_Bfbf;
  private AbsAppBrandPage jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage;
  private NativeViewContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer;
  private String jdField_a_of_type_JavaLangString = besa.d;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public PageWebviewContainer(begz parambegz, AbsAppBrandPage paramAbsAppBrandPage)
  {
    super(parambegz.a());
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage = paramAbsAppBrandPage;
    this.jdField_a_of_type_Begz = parambegz;
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer = new NativeViewContainer(parambegz.a(), this);
    ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer, 4);
    this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout = new SwipeRefreshLayout(getContext());
    this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout.setOnRefreshListener(this);
    addView(this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout, new FrameLayout.LayoutParams(-1, -1));
  }
  
  private bejy a()
  {
    if ((this.jdField_a_of_type_Begz != null) && (this.jdField_a_of_type_Begz.a() != null)) {
      return (bejy)this.jdField_a_of_type_Begz.a().apkgInfo;
    }
    return null;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Bfbf.a().b();
  }
  
  public Activity a()
  {
    if (this.jdField_a_of_type_Begz != null) {
      return this.jdField_a_of_type_Begz.a();
    }
    return null;
  }
  
  public bfbf a()
  {
    return this.jdField_a_of_type_Bfbf;
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
  
  public String a(bejs parambejs)
  {
    besl.a("PageWebviewContainer", "event = " + parambejs.jdField_a_of_type_JavaLangString + ", params = " + parambejs.jdField_b_of_type_JavaLangString);
    if ("startPullDownRefresh".equals(parambejs.jdField_a_of_type_JavaLangString)) {
      beki.a(new PageWebviewContainer.3(this, parambejs));
    }
    for (;;)
    {
      return null;
      if ("stopPullDownRefresh".equals(parambejs.jdField_a_of_type_JavaLangString))
      {
        beki.a(new PageWebviewContainer.4(this, parambejs));
      }
      else if ("disableScrollBounce".equals(parambejs.jdField_a_of_type_JavaLangString))
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(parambejs.jdField_b_of_type_JavaLangString);
          if (!localJSONObject.has("disable")) {
            break label182;
          }
          beki.a(new PageWebviewContainer.5(this, localJSONObject.optBoolean("disable", false), parambejs));
        }
        catch (Exception localException)
        {
          besl.d("PageWebviewContainer", "EVENT_DISABLE_SROLL_BOUNCE error," + localException);
          parambejs.a("params error");
        }
        continue;
        label182:
        besl.d("PageWebviewContainer", "EVENT_DISABLE_SROLL_BOUNCE params error.");
        parambejs.a("params error");
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bfbf != null) {
      this.jdField_a_of_type_Bfbf.c();
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
  
  public void a(belg parambelg)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a() != null)) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a().a(parambelg);
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
        this.jdField_a_of_type_Bfbf.a().setVerticalScrollBarEnabled(false);
        this.jdField_a_of_type_Bfbf.a().setHorizontalScrollBarEnabled(false);
        if ((this.jdField_a_of_type_Bfbf.a().getView() != null) && (this.jdField_a_of_type_Bfbf.a().getView().getViewTreeObserver() != null) && (this.jdField_a_of_type_Bfbf.a().getView().getViewTreeObserver().isAlive())) {
          this.jdField_a_of_type_Bfbf.a().getView().getViewTreeObserver().addOnScrollChangedListener(new bfbq(this));
        }
      }
      if ((this.jdField_a_of_type_Begz != null) && (this.jdField_a_of_type_Begz.a() != null) && (!this.jdField_a_of_type_Begz.a().isFinishing()))
      {
        if (!besa.c.equals(this.jdField_a_of_type_JavaLangString)) {
          break label352;
        }
        i = 4;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Begz.a().setRequestedOrientation(i);
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
      if (!besa.e.equals(this.jdField_a_of_type_JavaLangString)) {
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
    if (this.jdField_a_of_type_Bfbf != null) {
      this.jdField_a_of_type_Bfbf.a(paramString1, paramString2, a());
    }
  }
  
  public void b(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.jdField_a_of_type_Bfbf != null)
    {
      paramString = bekg.b(paramString, paramJSONObject);
      if (paramString == null) {
        break label32;
      }
    }
    label32:
    for (paramString = paramString.toString();; paramString = "")
    {
      this.jdField_a_of_type_Bfbf.a(paramInt, paramString);
      return;
    }
  }
  
  public void onRefresh()
  {
    if (this.jdField_a_of_type_Begz != null) {
      this.jdField_a_of_type_Begz.a(bejw.a("onPullDownRefresh", new JSONObject().toString(), a()));
    }
  }
  
  public void setBrandPageWebview(bfbf parambfbf)
  {
    if (parambfbf != null)
    {
      this.jdField_a_of_type_Bfbf = parambfbf;
      if (this.jdField_a_of_type_Bfbf.a() != null)
      {
        this.jdField_a_of_type_Bfbf.a().addView(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer, new FrameLayout.LayoutParams(-1, -1));
        this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout.addView(this.jdField_a_of_type_Bfbf.a(), new ViewGroup.LayoutParams(-1, -1));
        this.jdField_a_of_type_Bfbf.a().setOnWebviewScrollListener(new bfbp(this));
      }
    }
  }
  
  public void setCurInputId(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a() != null)) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a().setCurShowingInputId(paramInt);
    }
  }
  
  public void setSoftKeyboardStateListener(belg parambelg)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a() != null)) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a().setSoftKeyboardStateListener(parambelg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer
 * JD-Core Version:    0.7.0.1
 */