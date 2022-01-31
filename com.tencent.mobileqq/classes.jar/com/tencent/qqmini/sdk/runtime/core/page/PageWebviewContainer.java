package com.tencent.qqmini.sdk.runtime.core.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
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
import bgho;
import bgid;
import bgil;
import bgjw;
import bgki;
import bgkk;
import bgln;
import bgms;
import bhbi;
import bhbt;
import bhbu;
import bhbw;
import bhbx;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PageInfo;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class PageWebviewContainer
  extends FrameLayout
  implements SwipeRefreshLayout.OnRefreshListener, bgms
{
  public int a;
  private SwipeRefreshLayout jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout;
  private bgho jdField_a_of_type_Bgho;
  private bhbi jdField_a_of_type_Bhbi;
  private AbsAppBrandPage jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage;
  private NativeViewContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer;
  private String jdField_a_of_type_JavaLangString = WindowInfo.ORIENTATION_PORTRAIT;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public PageWebviewContainer(bgho parambgho, AbsAppBrandPage paramAbsAppBrandPage)
  {
    super(parambgho.a());
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage = paramAbsAppBrandPage;
    this.jdField_a_of_type_Bgho = parambgho;
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer = new NativeViewContainer(parambgho.a(), this);
    ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer, 4);
    this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout = new SwipeRefreshLayout(getContext());
    this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout.setOnRefreshListener(this);
    addView(this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout, new FrameLayout.LayoutParams(-1, -1));
    a(this.jdField_a_of_type_Int);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Bhbi.a().b();
  }
  
  public Activity a()
  {
    if (this.jdField_a_of_type_Bgho != null) {
      return this.jdField_a_of_type_Bgho.a();
    }
    return null;
  }
  
  public bgjw a()
  {
    if ((this.jdField_a_of_type_Bgho != null) && (this.jdField_a_of_type_Bgho.a() != null)) {
      return (bgjw)this.jdField_a_of_type_Bgho.a().apkgInfo;
    }
    return null;
  }
  
  public bhbi a()
  {
    return this.jdField_a_of_type_Bhbi;
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
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(bgid parambgid)
  {
    QMLog.d("PageWebviewContainer", "event = " + parambgid.jdField_a_of_type_JavaLangString + ", params = " + parambgid.b);
    if ("startPullDownRefresh".equals(parambgid.jdField_a_of_type_JavaLangString)) {
      bgkk.a(new PageWebviewContainer.3(this, parambgid));
    }
    for (;;)
    {
      return null;
      if ("stopPullDownRefresh".equals(parambgid.jdField_a_of_type_JavaLangString))
      {
        bgkk.a(new PageWebviewContainer.4(this, parambgid));
      }
      else if ("disableScrollBounce".equals(parambgid.jdField_a_of_type_JavaLangString))
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(parambgid.b);
          if (!localJSONObject.has("disable")) {
            break label187;
          }
          bgkk.a(new PageWebviewContainer.5(this, localJSONObject.optBoolean("disable", false), parambgid));
        }
        catch (Exception localException1)
        {
          QMLog.e("PageWebviewContainer", "EVENT_DISABLE_SROLL_BOUNCE error," + localException1);
          parambgid.a("params error");
        }
        continue;
        label187:
        QMLog.e("PageWebviewContainer", "EVENT_DISABLE_SROLL_BOUNCE params error.");
        parambgid.a("params error");
      }
      else if ("openDocument".equals(parambgid.jdField_a_of_type_JavaLangString))
      {
        try
        {
          bgkk.a(new PageWebviewContainer.6(this, new JSONObject(parambgid.b).optString("filePath"), parambgid));
        }
        catch (JSONException parambgid)
        {
          parambgid.printStackTrace();
        }
      }
      else if ("scrollWebviewTo".equals(parambgid.jdField_a_of_type_JavaLangString))
      {
        try
        {
          Object localObject = new JSONObject(parambgid.b);
          long l = ((JSONObject)localObject).optLong("duration", 300L);
          float f = DisplayUtil.getDensity(this.jdField_a_of_type_Bgho.a());
          int i = (int)(((JSONObject)localObject).optInt("scrollTop") * f + 0.5F);
          localObject = a();
          if (localObject != null)
          {
            ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { ((PageWebview)localObject).getView().getScrollY(), i }).setDuration(l);
            ((ValueAnimator)localValueAnimator).addUpdateListener(new bhbw(this, (PageWebview)localObject));
            localValueAnimator.addListener(new bhbx(this, parambgid));
            localValueAnimator.start();
          }
        }
        catch (Exception localException2)
        {
          QMLog.e("PageWebviewContainer", localException2.getMessage(), localException2);
          parambgid.b();
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bhbi != null) {
      this.jdField_a_of_type_Bhbi.c();
    }
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.removeAllViews();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(paramInt);
    if (paramInt == -1)
    {
      this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout.setColorSchemeColors(new int[] { -16777216 });
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout.setColorSchemeColors(new int[] { -1 });
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Bhbi != null) {
      this.jdField_a_of_type_Bhbi.a(paramInt, paramString);
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
  
  public void a(bgln parambgln)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a() != null)) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a().a(parambgln);
    }
  }
  
  public void a(String paramString)
  {
    int i = 0;
    Boolean localBoolean;
    boolean bool;
    if (a() != null)
    {
      localBoolean = a().a().globalPageInfo.windowInfo.enablePullDownRefresh;
      if (localBoolean != null) {
        break label325;
      }
      bool = false;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_JavaLangString = a().a().globalPageInfo.windowInfo.pageOrientation;
      paramString = a().a().getPageInfo(paramString);
      if (paramString != null)
      {
        localBoolean = paramString.windowInfo.enablePullDownRefresh;
        if (localBoolean != null) {
          break label334;
        }
        bool = this.jdField_a_of_type_Boolean;
        label94:
        this.jdField_a_of_type_Boolean = bool;
        localBoolean = paramString.windowInfo.disableScroll;
        if (localBoolean != null) {
          break label343;
        }
        bool = this.b;
        label118:
        this.b = bool;
        paramString = paramString.windowInfo.pageOrientation;
        if (!TextUtils.isEmpty(paramString)) {
          this.jdField_a_of_type_JavaLangString = paramString;
        }
      }
      if (this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout != null) {
        this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout.setEnabled(this.jdField_a_of_type_Boolean);
      }
      if (this.b)
      {
        this.jdField_a_of_type_Bhbi.a().setVerticalScrollBarEnabled(false);
        this.jdField_a_of_type_Bhbi.a().setHorizontalScrollBarEnabled(false);
        if ((this.jdField_a_of_type_Bhbi.a().getView() != null) && (this.jdField_a_of_type_Bhbi.a().getView().getViewTreeObserver() != null) && (this.jdField_a_of_type_Bhbi.a().getView().getViewTreeObserver().isAlive())) {
          this.jdField_a_of_type_Bhbi.a().getView().getViewTreeObserver().addOnScrollChangedListener(new bhbu(this));
        }
      }
      if ((this.jdField_a_of_type_Bgho != null) && (this.jdField_a_of_type_Bgho.a() != null) && (!this.jdField_a_of_type_Bgho.a().isFinishing()))
      {
        if (!WindowInfo.ORIENTATION_AUTO.equals(this.jdField_a_of_type_JavaLangString)) {
          break label352;
        }
        i = 4;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bgho.a().setRequestedOrientation(i);
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
      if (!WindowInfo.ORIENTATION_LANDSCAPE.equals(this.jdField_a_of_type_JavaLangString)) {
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
    c(paramString, paramJSONObject, paramInt);
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
    if (this.jdField_a_of_type_Bhbi != null) {
      this.jdField_a_of_type_Bhbi.a(paramString1, paramString2, a());
    }
  }
  
  public void b(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.jdField_a_of_type_Bhbi != null)
    {
      paramString = bgki.a(paramString, paramJSONObject);
      if (paramString == null) {
        break label32;
      }
    }
    label32:
    for (paramString = paramString.toString();; paramString = "")
    {
      this.jdField_a_of_type_Bhbi.a(paramInt, paramString);
      return;
    }
  }
  
  public void c(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.jdField_a_of_type_Bhbi != null)
    {
      paramString = bgki.b(paramString, paramJSONObject);
      if (paramString == null) {
        break label32;
      }
    }
    label32:
    for (paramString = paramString.toString();; paramString = "")
    {
      this.jdField_a_of_type_Bhbi.a(paramInt, paramString);
      return;
    }
  }
  
  public void onRefresh()
  {
    if (this.jdField_a_of_type_Bgho != null) {
      this.jdField_a_of_type_Bgho.a(bgil.a("onPullDownRefresh", new JSONObject().toString(), a()));
    }
  }
  
  public void setBrandPageWebview(bhbi parambhbi)
  {
    if (parambhbi != null)
    {
      this.jdField_a_of_type_Bhbi = parambhbi;
      if (this.jdField_a_of_type_Bhbi.a() != null)
      {
        this.jdField_a_of_type_Bhbi.a().addView(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer, new FrameLayout.LayoutParams(-1, -1));
        this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout.addView(this.jdField_a_of_type_Bhbi.a(), new ViewGroup.LayoutParams(-1, -1));
        this.jdField_a_of_type_Bhbi.a().setOnWebviewScrollListener(new bhbt(this));
      }
    }
  }
  
  public void setCurInputId(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a() != null)) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a().setCurShowingInputId(paramInt);
    }
  }
  
  public void setSoftKeyboardStateListener(bgln parambgln)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a() != null)) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a().setSoftKeyboardStateListener(parambgln);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer
 * JD-Core Version:    0.7.0.1
 */