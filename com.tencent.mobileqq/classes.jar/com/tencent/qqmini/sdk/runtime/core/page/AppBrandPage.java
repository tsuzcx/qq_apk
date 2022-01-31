package com.tencent.qqmini.sdk.runtime.core.page;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import behq;
import bekj;
import bekp;
import bekz;
import bela;
import beli;
import benb;
import bend;
import berk;
import berl;
import berz;
import besc;
import besn;
import besr;
import betc;
import bfbw;
import bfce;
import bfci;
import bfcj;
import bfcl;
import bfdz;
import bfgl;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.core.widget.NavigationBar;
import com.tencent.qqmini.sdk.core.widget.TabBar;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class AppBrandPage
  extends AbsAppBrandPage
  implements bend, bfcl
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private behq jdField_a_of_type_Behq;
  private NavigationBar jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar;
  private TabBar jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar;
  private AppBrandPageContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer;
  private PageWebviewContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer;
  private String jdField_a_of_type_JavaLangString;
  private Map<String, PageWebviewContainer> jdField_a_of_type_JavaUtilMap;
  private PageWebviewContainer jdField_b_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer;
  private String jdField_b_of_type_JavaLangString = "default";
  
  public AppBrandPage(behq parambehq, AppBrandPageContainer paramAppBrandPageContainer)
  {
    super(parambehq.a());
    this.jdField_a_of_type_Behq = parambehq;
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer = paramAppBrandPageContainer;
    c();
  }
  
  private bekp a()
  {
    if ((this.jdField_a_of_type_Behq != null) && (this.jdField_a_of_type_Behq.a() != null)) {
      return (bekp)this.jdField_a_of_type_Behq.a().apkgInfo;
    }
    return null;
  }
  
  private void b(String paramString)
  {
    if (a().a(paramString))
    {
      if (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.a()) {
        this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.setTabSelected(paramString);
    }
    while (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.setVisibility(8);
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer = new PageWebviewContainer(this.jdField_a_of_type_Behq, this);
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.setContentDescription("PageWebviewContainer");
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("centerLayout");
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-1);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar = new NavigationBar(getContext());
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.setContentDescription("NavigationBar");
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.setId(2131370288);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar = new TabBar(getContext());
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.setContentDescription("TabBar");
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.setId(2131370290);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.setOnTabItemClickListener(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer);
    a(this.jdField_b_of_type_JavaLangString);
    setSwipeBackCallback(this);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar != null) {
      return this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.getHeight();
    }
    return 0;
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getContext());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription("rootview");
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, bfgl.b(getContext())));
    }
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public bfbw a()
  {
    if (a() != null) {
      return a().a();
    }
    return null;
  }
  
  public AppBrandPageContainer a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer;
  }
  
  public PageWebview a()
  {
    bfbw localbfbw = a();
    if (localbfbw != null) {
      return localbfbw.a();
    }
    return null;
  }
  
  public PageWebviewContainer a()
  {
    return this.jdField_b_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(bekj parambekj)
  {
    betc.a("AppBrandPage", "event = " + parambekj.jdField_a_of_type_JavaLangString + ", params = " + parambekj.jdField_b_of_type_JavaLangString);
    if ("showTabBar".equals(parambekj.jdField_a_of_type_JavaLangString)) {}
    Object localObject4;
    String str2;
    do
    {
      try
      {
        bekz.a(new AppBrandPage.2(this, new JSONObject(parambekj.jdField_b_of_type_JavaLangString).optBoolean("animation", false), parambekj));
        return null;
      }
      catch (Throwable localThrowable1)
      {
        betc.d("AppBrandPage", "API_SHOW_TABBAR error.", localThrowable1);
        parambekj.a("native exception");
        return null;
      }
      if ("hideTabBar".equals(parambekj.jdField_a_of_type_JavaLangString)) {
        try
        {
          bekz.a(new AppBrandPage.3(this, new JSONObject(parambekj.jdField_b_of_type_JavaLangString).optBoolean("animation", false), parambekj));
          return null;
        }
        catch (Throwable localThrowable2)
        {
          betc.d("AppBrandPage", "API_HIDE_TABBAR error.", localThrowable2);
          parambekj.a("native exception");
          return null;
        }
      }
      Object localObject1;
      if ("setTabBarItem".equals(parambekj.jdField_a_of_type_JavaLangString))
      {
        int i;
        try
        {
          localObject4 = new JSONObject(parambekj.jdField_b_of_type_JavaLangString);
          i = ((JSONObject)localObject4).optInt("index", -1);
          if ((i < 0) || (i > 3))
          {
            parambekj.a("invalid index");
            return null;
          }
        }
        catch (Throwable localThrowable3)
        {
          betc.d("AppBrandPage", "API_SET_TABBAR_ITEM error.", localThrowable3);
          parambekj.a("native exception");
          return null;
        }
        localObject1 = ((JSONObject)localObject4).optString("text");
        str2 = ((JSONObject)localObject4).optString("iconPath");
        localObject4 = ((JSONObject)localObject4).optString("selectedIconPath");
        bekz.a(new AppBrandPage.4(this, i, (String)localObject1, beli.a(this.jdField_a_of_type_Behq.a().apkgInfo.g(str2)), beli.a(this.jdField_a_of_type_Behq.a().apkgInfo.g((String)localObject4))));
        parambekj.a();
        return null;
      }
      if ("setTabBarStyle".equals(parambekj.jdField_a_of_type_JavaLangString)) {
        try
        {
          localObject1 = new JSONObject(parambekj.jdField_b_of_type_JavaLangString);
          bekz.a(new AppBrandPage.5(this, ((JSONObject)localObject1).optString("color"), ((JSONObject)localObject1).optString("selectedColor"), ((JSONObject)localObject1).optString("backgroundColor"), ((JSONObject)localObject1).optString("borderStyle", "black")));
          parambekj.a();
          return null;
        }
        catch (Throwable localThrowable4)
        {
          betc.d("AppBrandPage", "API_SET_TABBAR_STYLE error.", localThrowable4);
          parambekj.a("native exception");
          return null;
        }
      }
      if ("setTabBarBadge".equals(parambekj.jdField_a_of_type_JavaLangString)) {
        try
        {
          JSONObject localJSONObject = new JSONObject(parambekj.jdField_b_of_type_JavaLangString);
          bekz.a(new AppBrandPage.6(this, localJSONObject.optString("type"), localJSONObject.optInt("index", -1), localJSONObject.optString("text")));
          parambekj.a();
          return null;
        }
        catch (Throwable localThrowable5)
        {
          betc.d("AppBrandPage", "API_SET_TABBAR_BADGE error.", localThrowable5);
          parambekj.a("native exception");
          return null;
        }
      }
      if ("removeTabBarBadge".equals(parambekj.jdField_a_of_type_JavaLangString)) {
        try
        {
          bekz.a(new AppBrandPage.7(this, new JSONObject(parambekj.jdField_b_of_type_JavaLangString).optInt("index", -1)));
          parambekj.a();
          return null;
        }
        catch (Throwable localThrowable6)
        {
          betc.d("AppBrandPage", "API_SET_TABBAR_BADGE error.", localThrowable6);
          parambekj.a("native exception");
          return null;
        }
      }
      if ("showTabBarRedDot".equals(parambekj.jdField_a_of_type_JavaLangString)) {
        try
        {
          bekz.a(new AppBrandPage.8(this, new JSONObject(parambekj.jdField_b_of_type_JavaLangString).optInt("index", -1)));
          parambekj.a();
          return null;
        }
        catch (Throwable localThrowable7)
        {
          betc.d("AppBrandPage", "API_SET_TABBAR_BADGE error.", localThrowable7);
          parambekj.a("native exception");
          return null;
        }
      }
      if ("hideTabBarRedDot".equals(parambekj.jdField_a_of_type_JavaLangString)) {
        try
        {
          bekz.a(new AppBrandPage.9(this, new JSONObject(parambekj.jdField_b_of_type_JavaLangString).optInt("index", -1)));
          parambekj.a();
          return null;
        }
        catch (Throwable localThrowable8)
        {
          betc.d("AppBrandPage", "API_SET_TABBAR_BADGE error.", localThrowable8);
          parambekj.a("native exception");
          return null;
        }
      }
      if ("setNavigationBarTitle".equals(parambekj.jdField_a_of_type_JavaLangString))
      {
        try
        {
          String str1 = new JSONObject(parambekj.jdField_b_of_type_JavaLangString).optString("title");
          if (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar != null)
          {
            bekz.a(new AppBrandPage.10(this, str1, parambekj));
            return null;
          }
        }
        catch (Throwable localThrowable9)
        {
          betc.d("AppBrandPage", "SET_NAV_BAR_TITLE error.", localThrowable9);
          parambekj.a("native exception");
          return null;
        }
        parambekj.a("native view error");
        return null;
      }
      if ("showNavigationBarLoading".equals(parambekj.jdField_a_of_type_JavaLangString))
      {
        bekz.a(new AppBrandPage.11(this, parambekj));
        return null;
      }
      if ("hideNavigationBarLoading".equals(parambekj.jdField_a_of_type_JavaLangString))
      {
        bekz.a(new AppBrandPage.12(this, parambekj));
        return null;
      }
    } while (!"setNavigationBarColor".equals(parambekj.jdField_a_of_type_JavaLangString));
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(parambekj.jdField_b_of_type_JavaLangString);
        str2 = ((JSONObject)localObject2).optString("frontColor");
        localObject4 = ((JSONObject)localObject2).optString("backgroundColor");
        localObject2 = ((JSONObject)localObject2).optJSONObject("animation");
        long l = 0L;
        if (localObject2 == null) {
          break label1013;
        }
        l = ((JSONObject)localObject2).optLong("duration");
        localObject2 = ((JSONObject)localObject2).optString("timingFunc");
        if (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar != null)
        {
          bekz.a(new AppBrandPage.13(this, str2, (String)localObject2, (String)localObject4, l, parambekj));
          return null;
        }
      }
      catch (Throwable localThrowable10)
      {
        betc.d("AppBrandPage", "SET_NAV_BAR_BG_COLOR error.", localThrowable10);
        parambekj.a("native exception");
        return null;
      }
      parambekj.a("native view error");
      return null;
      label1013:
      Object localObject3 = null;
    }
  }
  
  public void a()
  {
    bekz.a(new AppBrandPage.1(this));
  }
  
  public void a(NavigationBar paramNavigationBar)
  {
    if ((this.jdField_a_of_type_Behq != null) && (this.jdField_a_of_type_Behq.a() != null) && (!this.jdField_a_of_type_Behq.a().isFinishing())) {
      this.jdField_a_of_type_Behq.a().onBackPressed();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    }
    paramString = new RelativeLayout.LayoutParams(-1, -1);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, NavigationBar.a(this.jdField_a_of_type_Behq.a()));
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, TabBar.a(this.jdField_a_of_type_Behq.a()));
    if ((this.jdField_a_of_type_Behq != null) && (a() != null) && (a().a() != null) && (a().a().a != null) && (!a().a().a.a))
    {
      if (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.a()) {
        this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.setInfo(a().a().a);
      if ("top".equals(a().a().a.jdField_b_of_type_JavaLangString)) {
        if ("default".equals(this.jdField_b_of_type_JavaLangString))
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar);
          paramString.addRule(3, this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.getId());
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(paramString);
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.setLayoutParams(localLayoutParams2);
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.setLayoutParams(localLayoutParams1);
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.a(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.a().setVisibility(0);
      return;
      if ("custom".equals(this.jdField_b_of_type_JavaLangString))
      {
        addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        addView(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar);
        addView(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar);
        continue;
        if ("default".equals(this.jdField_b_of_type_JavaLangString))
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar);
          paramString.addRule(3, this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.getId());
          paramString.addRule(2, this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.getId());
          localLayoutParams2.addRule(12, -1);
        }
        else if ("custom".equals(this.jdField_b_of_type_JavaLangString))
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar);
          paramString.addRule(2, this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.getId());
          localLayoutParams2.addRule(12, -1);
          continue;
          if ("default".equals(this.jdField_b_of_type_JavaLangString))
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
            paramString.addRule(12);
            paramString.addRule(3, this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.getId());
          }
          else if ("custom".equals(this.jdField_b_of_type_JavaLangString))
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar);
          }
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, bfce parambfce)
  {
    Object localObject2 = null;
    boolean bool2 = true;
    boolean bool1;
    int i;
    Object localObject1;
    if ((!TextUtils.isEmpty(paramString1)) && (this.jdField_a_of_type_Behq != null) && (a() != null))
    {
      if (paramString1.equals(this.jdField_a_of_type_JavaLangString)) {
        break label569;
      }
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_Behq.a(bfdz.a(this.jdField_a_of_type_JavaLangString));
      bool1 = a().a(paramString1);
      if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(bela.a(paramString1))))
      {
        i = 1;
        if (i == 0) {
          break label419;
        }
        localObject1 = (PageWebviewContainer)this.jdField_a_of_type_JavaUtilMap.get(bela.a(paramString1));
        if ((localObject1 != null) && (((PageWebviewContainer)localObject1).getParent() != null)) {
          ((FrameLayout)((PageWebviewContainer)localObject1).getParent()).removeView((View)localObject1);
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
        this.jdField_b_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer = ((PageWebviewContainer)localObject1);
        parambfce.b(paramString2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer.c());
      }
    }
    else
    {
      label187:
      if ((this.jdField_a_of_type_Behq == null) || (a() == null) || (a().a() == null)) {
        break label614;
      }
      parambfce = a().a().a(paramString1).a.a.c;
      paramString2 = a().a().a(paramString1).a;
    }
    for (;;)
    {
      if (!this.jdField_b_of_type_JavaLangString.equals(parambfce)) {
        this.jdField_b_of_type_JavaLangString = parambfce;
      }
      a(parambfce);
      i = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer.b();
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.a(this);
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.a(paramString2, this.jdField_a_of_type_Behq.a());
      paramString2 = this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar;
      if (i > 1)
      {
        bool1 = true;
        label318:
        paramString2.a(bool1);
        this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.a().a(new benb(this.jdField_a_of_type_Behq));
        if (i != 1) {
          break label596;
        }
        i = 1;
        label356:
        paramString2 = new StringBuilder().append("setSwipeBackEnable : ");
        if (i != 0) {
          break label602;
        }
        bool1 = true;
        label378:
        betc.b("AppBrandPage", bool1);
        if (i != 0) {
          break label608;
        }
      }
      label419:
      label569:
      label596:
      label602:
      label608:
      for (bool1 = bool2;; bool1 = false)
      {
        setSwipeBackEnable(bool1);
        b(paramString1);
        return;
        i = 0;
        break;
        Object localObject3 = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer;
        this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer = null;
        this.jdField_b_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer = ((PageWebviewContainer)localObject3);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = new PageWebviewContainer(this.jdField_a_of_type_Behq, this);
          this.jdField_b_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer = ((PageWebviewContainer)localObject1);
        }
        localObject3 = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer.a().a().a(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer);
        ((bfbw)localObject3).a(parambfce);
        ((bfbw)localObject3).a(a());
        ((bfbw)localObject3).a(paramString1, paramString2);
        ((PageWebviewContainer)localObject1).setBrandPageWebview((bfbw)localObject3);
        ((PageWebviewContainer)localObject1).a(paramString1);
        if (((PageWebviewContainer)localObject1).getParent() == null) {
          this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
        }
        if (!bool1) {
          break label187;
        }
        this.jdField_a_of_type_JavaUtilMap.put(bela.a(paramString1), localObject1);
        break label187;
        parambfce.b(paramString2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer.c());
        break label187;
        bool1 = false;
        break label318;
        i = 0;
        break label356;
        bool1 = false;
        break label378;
      }
      label614:
      paramString2 = null;
      parambfce = localObject2;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      return this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.equals("custom");
    }
    return false;
  }
  
  public int b()
  {
    if (a() != null) {
      return a().a();
    }
    return -1;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      ((PageWebviewContainer)((Map.Entry)localIterator.next()).getValue()).a();
      localIterator.remove();
    }
    if (this.jdField_b_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer != null)
    {
      this.jdField_b_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.a();
      this.jdField_b_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer = null;
    }
    removeAllViews();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Behq != null) && (a() != null)) {
      return a().b(this.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage
 * JD-Core Version:    0.7.0.1
 */