package com.tencent.qqmini.sdk.runtime.core.page;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bdcz;
import bdfs;
import bdfx;
import bdgi;
import bdgj;
import bdgp;
import bdih;
import bdij;
import bdmk;
import bdml;
import bdmy;
import bdna;
import bdni;
import bdnl;
import bdnw;
import bdux;
import bdvf;
import bdvj;
import bdvk;
import bdvm;
import bdwu;
import bdyn;
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
  implements bdij, bdvm
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bdcz jdField_a_of_type_Bdcz;
  private NavigationBar jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar;
  private TabBar jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar;
  private AppBrandPageContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer;
  private PageWebviewContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer;
  private String jdField_a_of_type_JavaLangString;
  private Map<String, PageWebviewContainer> jdField_a_of_type_JavaUtilMap;
  private PageWebviewContainer jdField_b_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer;
  private String jdField_b_of_type_JavaLangString = "default";
  
  public AppBrandPage(bdcz parambdcz, AppBrandPageContainer paramAppBrandPageContainer)
  {
    super(parambdcz.a());
    this.jdField_a_of_type_Bdcz = parambdcz;
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer = paramAppBrandPageContainer;
    c();
  }
  
  private bdfx a()
  {
    if ((this.jdField_a_of_type_Bdcz != null) && (this.jdField_a_of_type_Bdcz.a() != null)) {
      return (bdfx)this.jdField_a_of_type_Bdcz.a().apkgInfo;
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
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer = new PageWebviewContainer(this.jdField_a_of_type_Bdcz, this);
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.setContentDescription("PageWebviewContainer");
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("centerLayout");
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-1);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar = new NavigationBar(getContext());
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.setContentDescription("NavigationBar");
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.setId(2131304604);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar = new TabBar(getContext());
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.setContentDescription("TabBar");
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.setId(2131304606);
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
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, bdyn.b(getContext())));
    }
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public bdux a()
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
    bdux localbdux = a();
    if (localbdux != null) {
      return localbdux.a();
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
  
  public String a(bdfs parambdfs)
  {
    bdnw.a("AppBrandPage", "event = " + parambdfs.jdField_a_of_type_JavaLangString + ", params = " + parambdfs.jdField_b_of_type_JavaLangString);
    if ("showTabBar".equals(parambdfs.jdField_a_of_type_JavaLangString)) {}
    Object localObject4;
    String str2;
    do
    {
      try
      {
        bdgi.a(new AppBrandPage.2(this, new JSONObject(parambdfs.jdField_b_of_type_JavaLangString).optBoolean("animation", false), parambdfs));
        return null;
      }
      catch (Throwable localThrowable1)
      {
        bdnw.d("AppBrandPage", "API_SHOW_TABBAR error.", localThrowable1);
        parambdfs.a("native exception");
        return null;
      }
      if ("hideTabBar".equals(parambdfs.jdField_a_of_type_JavaLangString)) {
        try
        {
          bdgi.a(new AppBrandPage.3(this, new JSONObject(parambdfs.jdField_b_of_type_JavaLangString).optBoolean("animation", false), parambdfs));
          return null;
        }
        catch (Throwable localThrowable2)
        {
          bdnw.d("AppBrandPage", "API_HIDE_TABBAR error.", localThrowable2);
          parambdfs.a("native exception");
          return null;
        }
      }
      Object localObject1;
      if ("setTabBarItem".equals(parambdfs.jdField_a_of_type_JavaLangString))
      {
        int i;
        try
        {
          localObject4 = new JSONObject(parambdfs.jdField_b_of_type_JavaLangString);
          i = ((JSONObject)localObject4).optInt("index", -1);
          if ((i < 0) || (i > 3))
          {
            parambdfs.a("invalid index");
            return null;
          }
        }
        catch (Throwable localThrowable3)
        {
          bdnw.d("AppBrandPage", "API_SET_TABBAR_ITEM error.", localThrowable3);
          parambdfs.a("native exception");
          return null;
        }
        localObject1 = ((JSONObject)localObject4).optString("text");
        str2 = ((JSONObject)localObject4).optString("iconPath");
        localObject4 = ((JSONObject)localObject4).optString("selectedIconPath");
        bdgi.a(new AppBrandPage.4(this, i, (String)localObject1, bdgp.a(this.jdField_a_of_type_Bdcz.a().apkgInfo.g(str2)), bdgp.a(this.jdField_a_of_type_Bdcz.a().apkgInfo.g((String)localObject4))));
        parambdfs.a();
        return null;
      }
      if ("setTabBarStyle".equals(parambdfs.jdField_a_of_type_JavaLangString)) {
        try
        {
          localObject1 = new JSONObject(parambdfs.jdField_b_of_type_JavaLangString);
          bdgi.a(new AppBrandPage.5(this, ((JSONObject)localObject1).optString("color"), ((JSONObject)localObject1).optString("selectedColor"), ((JSONObject)localObject1).optString("backgroundColor"), ((JSONObject)localObject1).optString("borderStyle", "black")));
          parambdfs.a();
          return null;
        }
        catch (Throwable localThrowable4)
        {
          bdnw.d("AppBrandPage", "API_SET_TABBAR_STYLE error.", localThrowable4);
          parambdfs.a("native exception");
          return null;
        }
      }
      if ("setTabBarBadge".equals(parambdfs.jdField_a_of_type_JavaLangString)) {
        try
        {
          JSONObject localJSONObject = new JSONObject(parambdfs.jdField_b_of_type_JavaLangString);
          bdgi.a(new AppBrandPage.6(this, localJSONObject.optString("type"), localJSONObject.optInt("index", -1), localJSONObject.optString("text")));
          parambdfs.a();
          return null;
        }
        catch (Throwable localThrowable5)
        {
          bdnw.d("AppBrandPage", "API_SET_TABBAR_BADGE error.", localThrowable5);
          parambdfs.a("native exception");
          return null;
        }
      }
      if ("removeTabBarBadge".equals(parambdfs.jdField_a_of_type_JavaLangString)) {
        try
        {
          bdgi.a(new AppBrandPage.7(this, new JSONObject(parambdfs.jdField_b_of_type_JavaLangString).optInt("index", -1)));
          parambdfs.a();
          return null;
        }
        catch (Throwable localThrowable6)
        {
          bdnw.d("AppBrandPage", "API_SET_TABBAR_BADGE error.", localThrowable6);
          parambdfs.a("native exception");
          return null;
        }
      }
      if ("showTabBarRedDot".equals(parambdfs.jdField_a_of_type_JavaLangString)) {
        try
        {
          bdgi.a(new AppBrandPage.8(this, new JSONObject(parambdfs.jdField_b_of_type_JavaLangString).optInt("index", -1)));
          parambdfs.a();
          return null;
        }
        catch (Throwable localThrowable7)
        {
          bdnw.d("AppBrandPage", "API_SET_TABBAR_BADGE error.", localThrowable7);
          parambdfs.a("native exception");
          return null;
        }
      }
      if ("hideTabBarRedDot".equals(parambdfs.jdField_a_of_type_JavaLangString)) {
        try
        {
          bdgi.a(new AppBrandPage.9(this, new JSONObject(parambdfs.jdField_b_of_type_JavaLangString).optInt("index", -1)));
          parambdfs.a();
          return null;
        }
        catch (Throwable localThrowable8)
        {
          bdnw.d("AppBrandPage", "API_SET_TABBAR_BADGE error.", localThrowable8);
          parambdfs.a("native exception");
          return null;
        }
      }
      if ("setNavigationBarTitle".equals(parambdfs.jdField_a_of_type_JavaLangString))
      {
        try
        {
          String str1 = new JSONObject(parambdfs.jdField_b_of_type_JavaLangString).optString("title");
          if (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar != null)
          {
            bdgi.a(new AppBrandPage.10(this, str1, parambdfs));
            return null;
          }
        }
        catch (Throwable localThrowable9)
        {
          bdnw.d("AppBrandPage", "SET_NAV_BAR_TITLE error.", localThrowable9);
          parambdfs.a("native exception");
          return null;
        }
        parambdfs.a("native view error");
        return null;
      }
      if ("showNavigationBarLoading".equals(parambdfs.jdField_a_of_type_JavaLangString))
      {
        bdgi.a(new AppBrandPage.11(this, parambdfs));
        return null;
      }
      if ("hideNavigationBarLoading".equals(parambdfs.jdField_a_of_type_JavaLangString))
      {
        bdgi.a(new AppBrandPage.12(this, parambdfs));
        return null;
      }
    } while (!"setNavigationBarColor".equals(parambdfs.jdField_a_of_type_JavaLangString));
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(parambdfs.jdField_b_of_type_JavaLangString);
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
          bdgi.a(new AppBrandPage.13(this, str2, (String)localObject2, (String)localObject4, l, parambdfs));
          return null;
        }
      }
      catch (Throwable localThrowable10)
      {
        bdnw.d("AppBrandPage", "SET_NAV_BAR_BG_COLOR error.", localThrowable10);
        parambdfs.a("native exception");
        return null;
      }
      parambdfs.a("native view error");
      return null;
      label1013:
      Object localObject3 = null;
    }
  }
  
  public void a()
  {
    bdgi.a(new AppBrandPage.1(this));
  }
  
  public void a(NavigationBar paramNavigationBar)
  {
    if ((this.jdField_a_of_type_Bdcz != null) && (this.jdField_a_of_type_Bdcz.a() != null) && (!this.jdField_a_of_type_Bdcz.a().isFinishing())) {
      this.jdField_a_of_type_Bdcz.a().onBackPressed();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    }
    paramString = new RelativeLayout.LayoutParams(-1, -1);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, NavigationBar.a(this.jdField_a_of_type_Bdcz.a()));
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, TabBar.a(this.jdField_a_of_type_Bdcz.a()));
    if ((this.jdField_a_of_type_Bdcz != null) && (a() != null) && (a().a() != null) && (a().a().a != null) && (!a().a().a.a))
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
  
  public void a(String paramString1, String paramString2, bdvf parambdvf)
  {
    Object localObject2 = null;
    boolean bool2 = true;
    boolean bool1;
    int i;
    Object localObject1;
    if ((!TextUtils.isEmpty(paramString1)) && (this.jdField_a_of_type_Bdcz != null) && (a() != null))
    {
      if (paramString1.equals(this.jdField_a_of_type_JavaLangString)) {
        break label569;
      }
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_Bdcz.a(bdwu.a(this.jdField_a_of_type_JavaLangString));
      bool1 = a().a(paramString1);
      if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(bdgj.a(paramString1))))
      {
        i = 1;
        if (i == 0) {
          break label419;
        }
        localObject1 = (PageWebviewContainer)this.jdField_a_of_type_JavaUtilMap.get(bdgj.a(paramString1));
        if ((localObject1 != null) && (((PageWebviewContainer)localObject1).getParent() != null)) {
          ((FrameLayout)((PageWebviewContainer)localObject1).getParent()).removeView((View)localObject1);
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
        this.jdField_b_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer = ((PageWebviewContainer)localObject1);
        parambdvf.b(paramString2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer.c());
      }
    }
    else
    {
      label187:
      if ((this.jdField_a_of_type_Bdcz == null) || (a() == null) || (a().a() == null)) {
        break label614;
      }
      parambdvf = a().a().a(paramString1).a.a.c;
      paramString2 = a().a().a(paramString1).a;
    }
    for (;;)
    {
      if (!this.jdField_b_of_type_JavaLangString.equals(parambdvf)) {
        this.jdField_b_of_type_JavaLangString = parambdvf;
      }
      a(parambdvf);
      i = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer.b();
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.a(this);
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.a(paramString2, this.jdField_a_of_type_Bdcz.a());
      paramString2 = this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar;
      if (i > 1)
      {
        bool1 = true;
        label318:
        paramString2.a(bool1);
        this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.a().a(new bdih(this.jdField_a_of_type_Bdcz));
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
        bdnw.b("AppBrandPage", bool1);
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
          localObject1 = new PageWebviewContainer(this.jdField_a_of_type_Bdcz, this);
          this.jdField_b_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer = ((PageWebviewContainer)localObject1);
        }
        localObject3 = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer.a().a().a(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer);
        ((bdux)localObject3).a(parambdvf);
        ((bdux)localObject3).a(a());
        ((bdux)localObject3).a(paramString1, paramString2);
        ((PageWebviewContainer)localObject1).setBrandPageWebview((bdux)localObject3);
        ((PageWebviewContainer)localObject1).a(paramString1);
        if (((PageWebviewContainer)localObject1).getParent() == null) {
          this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
        }
        if (!bool1) {
          break label187;
        }
        this.jdField_a_of_type_JavaUtilMap.put(bdgj.a(paramString1), localObject1);
        break label187;
        parambdvf.b(paramString2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer.c());
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
      parambdvf = localObject2;
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
    if ((this.jdField_a_of_type_Bdcz != null) && (a() != null)) {
      return a().b(this.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage
 * JD-Core Version:    0.7.0.1
 */