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
import bglv;
import bgmk;
import bgms;
import bgod;
import bgop;
import bgor;
import bgpu;
import bgqz;
import bhfp;
import bhga;
import bhgb;
import bhgd;
import bhge;
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
  implements SwipeRefreshLayout.OnRefreshListener, bgqz
{
  public int a;
  private SwipeRefreshLayout jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout;
  private bglv jdField_a_of_type_Bglv;
  private bhfp jdField_a_of_type_Bhfp;
  private AbsAppBrandPage jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage;
  private NativeViewContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer;
  private String jdField_a_of_type_JavaLangString = WindowInfo.ORIENTATION_PORTRAIT;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public PageWebviewContainer(bglv parambglv, AbsAppBrandPage paramAbsAppBrandPage)
  {
    super(parambglv.a());
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage = paramAbsAppBrandPage;
    this.jdField_a_of_type_Bglv = parambglv;
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer = new NativeViewContainer(parambglv.a(), this);
    ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer, 4);
    this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout = new SwipeRefreshLayout(getContext());
    this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout.setOnRefreshListener(this);
    addView(this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout, new FrameLayout.LayoutParams(-1, -1));
    a(this.jdField_a_of_type_Int);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Bhfp.a().b();
  }
  
  public Activity a()
  {
    if (this.jdField_a_of_type_Bglv != null) {
      return this.jdField_a_of_type_Bglv.a();
    }
    return null;
  }
  
  public bgod a()
  {
    if ((this.jdField_a_of_type_Bglv != null) && (this.jdField_a_of_type_Bglv.a() != null)) {
      return (bgod)this.jdField_a_of_type_Bglv.a().apkgInfo;
    }
    return null;
  }
  
  public bhfp a()
  {
    return this.jdField_a_of_type_Bhfp;
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
  
  public String a(bgmk parambgmk)
  {
    QMLog.d("PageWebviewContainer", "event = " + parambgmk.jdField_a_of_type_JavaLangString + ", params = " + parambgmk.b);
    if ("startPullDownRefresh".equals(parambgmk.jdField_a_of_type_JavaLangString)) {
      bgor.a(new PageWebviewContainer.3(this, parambgmk));
    }
    for (;;)
    {
      return null;
      if ("stopPullDownRefresh".equals(parambgmk.jdField_a_of_type_JavaLangString))
      {
        bgor.a(new PageWebviewContainer.4(this, parambgmk));
      }
      else if ("disableScrollBounce".equals(parambgmk.jdField_a_of_type_JavaLangString))
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(parambgmk.b);
          if (!localJSONObject.has("disable")) {
            break label187;
          }
          bgor.a(new PageWebviewContainer.5(this, localJSONObject.optBoolean("disable", false), parambgmk));
        }
        catch (Exception localException1)
        {
          QMLog.e("PageWebviewContainer", "EVENT_DISABLE_SROLL_BOUNCE error," + localException1);
          parambgmk.a("params error");
        }
        continue;
        label187:
        QMLog.e("PageWebviewContainer", "EVENT_DISABLE_SROLL_BOUNCE params error.");
        parambgmk.a("params error");
      }
      else if ("openDocument".equals(parambgmk.jdField_a_of_type_JavaLangString))
      {
        try
        {
          bgor.a(new PageWebviewContainer.6(this, new JSONObject(parambgmk.b).optString("filePath"), parambgmk));
        }
        catch (JSONException parambgmk)
        {
          parambgmk.printStackTrace();
        }
      }
      else if ("scrollWebviewTo".equals(parambgmk.jdField_a_of_type_JavaLangString))
      {
        try
        {
          Object localObject = new JSONObject(parambgmk.b);
          long l = ((JSONObject)localObject).optLong("duration", 300L);
          float f = DisplayUtil.getDensity(this.jdField_a_of_type_Bglv.a());
          int i = (int)(((JSONObject)localObject).optInt("scrollTop") * f + 0.5F);
          localObject = a();
          if (localObject != null)
          {
            ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { ((PageWebview)localObject).getView().getScrollY(), i }).setDuration(l);
            ((ValueAnimator)localValueAnimator).addUpdateListener(new bhgd(this, (PageWebview)localObject));
            localValueAnimator.addListener(new bhge(this, parambgmk));
            localValueAnimator.start();
          }
        }
        catch (Exception localException2)
        {
          QMLog.e("PageWebviewContainer", localException2.getMessage(), localException2);
          parambgmk.b();
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bhfp != null) {
      this.jdField_a_of_type_Bhfp.c();
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
    if (this.jdField_a_of_type_Bhfp != null) {
      this.jdField_a_of_type_Bhfp.a(paramInt, paramString);
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
  
  public void a(bgpu parambgpu)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a() != null)) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a().a(parambgpu);
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
        this.jdField_a_of_type_Bhfp.a().setVerticalScrollBarEnabled(false);
        this.jdField_a_of_type_Bhfp.a().setHorizontalScrollBarEnabled(false);
        if ((this.jdField_a_of_type_Bhfp.a().getView() != null) && (this.jdField_a_of_type_Bhfp.a().getView().getViewTreeObserver() != null) && (this.jdField_a_of_type_Bhfp.a().getView().getViewTreeObserver().isAlive())) {
          this.jdField_a_of_type_Bhfp.a().getView().getViewTreeObserver().addOnScrollChangedListener(new bhgb(this));
        }
      }
      if ((this.jdField_a_of_type_Bglv != null) && (this.jdField_a_of_type_Bglv.a() != null) && (!this.jdField_a_of_type_Bglv.a().isFinishing()))
      {
        if (!WindowInfo.ORIENTATION_AUTO.equals(this.jdField_a_of_type_JavaLangString)) {
          break label352;
        }
        i = 4;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bglv.a().setRequestedOrientation(i);
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
    if (this.jdField_a_of_type_Bhfp != null) {
      this.jdField_a_of_type_Bhfp.a(paramString1, paramString2, a());
    }
  }
  
  public void b(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.jdField_a_of_type_Bhfp != null)
    {
      paramString = bgop.a(paramString, paramJSONObject);
      if (paramString == null) {
        break label32;
      }
    }
    label32:
    for (paramString = paramString.toString();; paramString = "")
    {
      this.jdField_a_of_type_Bhfp.a(paramInt, paramString);
      return;
    }
  }
  
  public void c(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.jdField_a_of_type_Bhfp != null)
    {
      paramString = bgop.b(paramString, paramJSONObject);
      if (paramString == null) {
        break label32;
      }
    }
    label32:
    for (paramString = paramString.toString();; paramString = "")
    {
      this.jdField_a_of_type_Bhfp.a(paramInt, paramString);
      return;
    }
  }
  
  public void onRefresh()
  {
    if (this.jdField_a_of_type_Bglv != null) {
      this.jdField_a_of_type_Bglv.a(bgms.a("onPullDownRefresh", new JSONObject().toString(), a()));
    }
  }
  
  public void setBrandPageWebview(bhfp parambhfp)
  {
    if (parambhfp != null)
    {
      this.jdField_a_of_type_Bhfp = parambhfp;
      if (this.jdField_a_of_type_Bhfp.a() != null)
      {
        this.jdField_a_of_type_Bhfp.a().addView(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer, new FrameLayout.LayoutParams(-1, -1));
        this.jdField_a_of_type_AndroidSupportV4WidgetSwipeRefreshLayout.addView(this.jdField_a_of_type_Bhfp.a(), new ViewGroup.LayoutParams(-1, -1));
        this.jdField_a_of_type_Bhfp.a().setOnWebviewScrollListener(new bhga(this));
      }
    }
  }
  
  public void setCurInputId(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a() != null)) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a().setCurShowingInputId(paramInt);
    }
  }
  
  public void setSoftKeyboardStateListener(bgpu parambgpu)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a() != null)) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAbsAppBrandPage.a().setSoftKeyboardStateListener(parambgpu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer
 * JD-Core Version:    0.7.0.1
 */