package com.tencent.qqmini.sdk.runtime.core.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bgho;
import bgid;
import bgjw;
import bgkk;
import bgkl;
import bgkx;
import bgmr;
import bgmt;
import bgnf;
import bgnw;
import bhad;
import bhbc;
import bhbd;
import bhbi;
import bhbr;
import bhby;
import bhbz;
import bhcb;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.core.widget.NavigationBar;
import com.tencent.qqmini.sdk.core.widget.TabBar;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.NavigationBarInfo;
import com.tencent.qqmini.sdk.launcher.model.PageInfo;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class AppBrandPage
  extends AbsAppBrandPage
  implements bgmt, bhcb
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bgho jdField_a_of_type_Bgho;
  private bgnf jdField_a_of_type_Bgnf;
  private bgnw jdField_a_of_type_Bgnw;
  private NavigationBar jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar;
  private TabBar jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar;
  private AppBrandPageContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer;
  private PageWebviewContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer;
  private String jdField_a_of_type_JavaLangString;
  private Map<String, PageWebviewContainer> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private PageWebviewContainer jdField_b_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer;
  private String jdField_b_of_type_JavaLangString = "default";
  
  public AppBrandPage(bgho parambgho, AppBrandPageContainer paramAppBrandPageContainer)
  {
    super(parambgho.a());
    this.jdField_a_of_type_Bgho = parambgho;
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer = paramAppBrandPageContainer;
    e();
  }
  
  private bgjw a()
  {
    if ((this.jdField_a_of_type_Bgho != null) && (this.jdField_a_of_type_Bgho.a() != null)) {
      return (bgjw)this.jdField_a_of_type_Bgho.a().apkgInfo;
    }
    return null;
  }
  
  private void c(String paramString)
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
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer = new PageWebviewContainer(this.jdField_a_of_type_Bgho, this);
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer.setContentDescription("PageWebviewContainer");
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("centerLayout");
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-1);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar = new NavigationBar(getContext());
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.setContentDescription("NavigationBar");
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.setId(2131370585);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar = new TabBar(getContext());
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.setContentDescription("TabBar");
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.setId(2131370587);
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
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, DisplayUtil.getRealHeight(getContext())));
    }
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public bhbi a()
  {
    if (a() != null) {
      return a().a();
    }
    return null;
  }
  
  public CapsuleButton a()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar != null) {
      return this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.a();
    }
    return null;
  }
  
  public NavigationBar a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar;
  }
  
  public TabBar a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar;
  }
  
  public AppBrandPageContainer a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer;
  }
  
  public PageWebview a()
  {
    bhbi localbhbi = a();
    if (localbhbi != null) {
      return localbhbi.a();
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
  
  public String a(bgid parambgid)
  {
    QMLog.d("AppBrandPage", "event = " + parambgid.jdField_a_of_type_JavaLangString + ", params = " + parambgid.jdField_b_of_type_JavaLangString);
    if ("showTabBar".equals(parambgid.jdField_a_of_type_JavaLangString)) {
      try
      {
        bgkk.a(new AppBrandPage.2(this, new JSONObject(parambgid.jdField_b_of_type_JavaLangString).optBoolean("animation", false), parambgid));
        return null;
      }
      catch (Throwable localThrowable1)
      {
        QMLog.e("AppBrandPage", "API_SHOW_TABBAR error.", localThrowable1);
        parambgid.a("native exception");
        return null;
      }
    }
    if ("hideTabBar".equals(parambgid.jdField_a_of_type_JavaLangString)) {
      try
      {
        bgkk.a(new AppBrandPage.3(this, new JSONObject(parambgid.jdField_b_of_type_JavaLangString).optBoolean("animation", false), parambgid));
        return null;
      }
      catch (Throwable localThrowable2)
      {
        QMLog.e("AppBrandPage", "API_HIDE_TABBAR error.", localThrowable2);
        parambgid.a("native exception");
        return null;
      }
    }
    Object localObject6;
    int i;
    Object localObject1;
    Object localObject5;
    if ("setTabBarItem".equals(parambgid.jdField_a_of_type_JavaLangString))
    {
      try
      {
        localObject6 = new JSONObject(parambgid.jdField_b_of_type_JavaLangString);
        i = ((JSONObject)localObject6).optInt("index", -1);
        if ((i < 0) || (i > 3))
        {
          parambgid.a("invalid index");
          return null;
        }
      }
      catch (Throwable localThrowable3)
      {
        QMLog.e("AppBrandPage", "API_SET_TABBAR_ITEM error.", localThrowable3);
        parambgid.a("native exception");
        return null;
      }
      localObject1 = ((JSONObject)localObject6).optString("text");
      localObject5 = ((JSONObject)localObject6).optString("iconPath");
      localObject6 = ((JSONObject)localObject6).optString("selectedIconPath");
      bgkk.a(new AppBrandPage.4(this, i, (String)localObject1, bgkx.a(this.jdField_a_of_type_Bgho.a().apkgInfo.getChildFileAbsolutePath((String)localObject5)), bgkx.a(this.jdField_a_of_type_Bgho.a().apkgInfo.getChildFileAbsolutePath((String)localObject6))));
      parambgid.a();
      return null;
    }
    if ("setTabBarStyle".equals(parambgid.jdField_a_of_type_JavaLangString)) {
      try
      {
        localObject1 = new JSONObject(parambgid.jdField_b_of_type_JavaLangString);
        bgkk.a(new AppBrandPage.5(this, ((JSONObject)localObject1).optString("color"), ((JSONObject)localObject1).optString("selectedColor"), ((JSONObject)localObject1).optString("backgroundColor"), ((JSONObject)localObject1).optString("borderStyle", "black")));
        parambgid.a();
        return null;
      }
      catch (Throwable localThrowable4)
      {
        QMLog.e("AppBrandPage", "API_SET_TABBAR_STYLE error.", localThrowable4);
        parambgid.a("native exception");
        return null;
      }
    }
    if ("setTabBarBadge".equals(parambgid.jdField_a_of_type_JavaLangString)) {
      try
      {
        JSONObject localJSONObject = new JSONObject(parambgid.jdField_b_of_type_JavaLangString);
        bgkk.a(new AppBrandPage.6(this, localJSONObject.optString("type"), localJSONObject.optInt("index", -1), localJSONObject.optString("text")));
        parambgid.a();
        return null;
      }
      catch (Throwable localThrowable5)
      {
        QMLog.e("AppBrandPage", "API_SET_TABBAR_BADGE error.", localThrowable5);
        parambgid.a("native exception");
        return null;
      }
    }
    if ("removeTabBarBadge".equals(parambgid.jdField_a_of_type_JavaLangString)) {
      try
      {
        bgkk.a(new AppBrandPage.7(this, new JSONObject(parambgid.jdField_b_of_type_JavaLangString).optInt("index", -1)));
        parambgid.a();
        return null;
      }
      catch (Throwable localThrowable6)
      {
        QMLog.e("AppBrandPage", "API_SET_TABBAR_BADGE error.", localThrowable6);
        parambgid.a("native exception");
        return null;
      }
    }
    if ("showTabBarRedDot".equals(parambgid.jdField_a_of_type_JavaLangString)) {
      try
      {
        bgkk.a(new AppBrandPage.8(this, new JSONObject(parambgid.jdField_b_of_type_JavaLangString).optInt("index", -1)));
        parambgid.a();
        return null;
      }
      catch (Throwable localThrowable7)
      {
        QMLog.e("AppBrandPage", "API_SET_TABBAR_BADGE error.", localThrowable7);
        parambgid.a("native exception");
        return null;
      }
    }
    if ("hideTabBarRedDot".equals(parambgid.jdField_a_of_type_JavaLangString)) {
      try
      {
        bgkk.a(new AppBrandPage.9(this, new JSONObject(parambgid.jdField_b_of_type_JavaLangString).optInt("index", -1)));
        parambgid.a();
        return null;
      }
      catch (Throwable localThrowable8)
      {
        QMLog.e("AppBrandPage", "API_SET_TABBAR_BADGE error.", localThrowable8);
        parambgid.a("native exception");
        return null;
      }
    }
    if ("setNavigationBarTitle".equals(parambgid.jdField_a_of_type_JavaLangString))
    {
      try
      {
        String str = new JSONObject(parambgid.jdField_b_of_type_JavaLangString).optString("title");
        if (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar != null)
        {
          bgkk.a(new AppBrandPage.10(this, str, parambgid));
          return null;
        }
      }
      catch (Throwable localThrowable9)
      {
        QMLog.e("AppBrandPage", "SET_NAV_BAR_TITLE error.", localThrowable9);
        parambgid.a("native exception");
        return null;
      }
      parambgid.a("native view error");
      return null;
    }
    if ("showNavigationBarLoading".equals(parambgid.jdField_a_of_type_JavaLangString))
    {
      bgkk.a(new AppBrandPage.11(this, parambgid));
      return null;
    }
    if ("hideNavigationBarLoading".equals(parambgid.jdField_a_of_type_JavaLangString))
    {
      bgkk.a(new AppBrandPage.12(this, parambgid));
      return null;
    }
    if ("setNavigationBarColor".equals(parambgid.jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      for (;;)
      {
        long l;
        try
        {
          Object localObject2 = new JSONObject(parambgid.jdField_b_of_type_JavaLangString);
          localObject5 = ((JSONObject)localObject2).optString("frontColor");
          localObject6 = ((JSONObject)localObject2).optString("backgroundColor");
          localObject2 = ((JSONObject)localObject2).optJSONObject("animation");
          l = 0L;
          if (localObject2 == null) {
            break label1191;
          }
          l = ((JSONObject)localObject2).optLong("duration");
          localObject2 = ((JSONObject)localObject2).optString("timingFunc");
          if (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar != null)
          {
            bgkk.a(new AppBrandPage.13(this, (String)localObject5, (String)localObject2, (String)localObject6, l, parambgid));
            return null;
          }
        }
        catch (Throwable localThrowable10)
        {
          QMLog.e("AppBrandPage", "SET_NAV_BAR_BG_COLOR error.", localThrowable10);
          parambgid.a("native exception");
          return null;
        }
        parambgid.a("native view error");
        return null;
        if (!"scrollWebviewTo".equals(parambgid.jdField_a_of_type_JavaLangString)) {
          break;
        }
        try
        {
          Object localObject3 = new JSONObject(parambgid.jdField_b_of_type_JavaLangString);
          l = ((JSONObject)localObject3).optLong("duration", 300L);
          float f = DisplayUtil.getDensity(getContext());
          i = (int)(((JSONObject)localObject3).optInt("scrollTop") * f + 0.5F);
          localObject3 = a();
          if (localObject3 == null) {
            break;
          }
          localObject5 = ValueAnimator.ofInt(new int[] { ((PageWebview)localObject3).getView().getScrollY(), i }).setDuration(l);
          ((ValueAnimator)localObject5).addUpdateListener(new bhbc(this, (PageWebview)localObject3));
          ((Animator)localObject5).addListener(new bhbd(this, parambgid));
          ((Animator)localObject5).start();
          return null;
        }
        catch (Exception localException)
        {
          QMLog.e("AppBrandPage", localException.getMessage(), localException);
          parambgid.b();
          return null;
        }
      }
      label1191:
      Object localObject4 = null;
    }
  }
  
  public void a()
  {
    bgkk.a(new AppBrandPage.1(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      QMLog.d("AppBrandPage", "No need to notifyChangePullDownRefreshStyle. tab page cache is null");
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((PageWebviewContainer)((Map.Entry)localIterator.next()).getValue()).a(paramInt);
      }
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt2, boolean paramBoolean)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("AppBrandPage", "showToastView toastView=" + this.jdField_a_of_type_Bgnw);
    }
    if ((paramInt1 == 1) || ((paramInt1 == 0) && ("loading".equals(paramString1))))
    {
      if (this.jdField_a_of_type_Bgnw == null) {
        this.jdField_a_of_type_Bgnw = new bgnw(getContext(), this);
      }
      this.jdField_a_of_type_Bgnw.a(paramInt1, paramString1, paramString2, paramCharSequence, paramInt2, paramBoolean);
      return;
    }
    for (;;)
    {
      bgnf localbgnf;
      try
      {
        localbgnf = new bgnf(getContext());
        if (!TextUtils.isEmpty(paramString2))
        {
          localbgnf.a(new BitmapDrawable(paramString2));
          localbgnf.a(paramCharSequence);
          localbgnf.c(paramInt2);
          localbgnf.a();
          this.jdField_a_of_type_Bgnf = localbgnf;
          return;
        }
      }
      catch (Throwable paramString1)
      {
        QMLog.e("AppBrandPage", "showToastView error.", paramString1);
        return;
      }
      if ("none".equals(paramString1)) {
        localbgnf.b(-1);
      } else {
        localbgnf.a(bgnw.a(paramString1));
      }
    }
  }
  
  public void a(NavigationBar paramNavigationBar)
  {
    if ((this.jdField_a_of_type_Bgho != null) && (this.jdField_a_of_type_Bgho.a() != null) && (!this.jdField_a_of_type_Bgho.a().isFinishing())) {
      this.jdField_a_of_type_Bgho.a().onBackPressed();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    }
    paramString = new RelativeLayout.LayoutParams(-1, -1);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, NavigationBar.a(this.jdField_a_of_type_Bgho.a()));
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, TabBar.a(this.jdField_a_of_type_Bgho.a()));
    if ((this.jdField_a_of_type_Bgho != null) && (a() != null) && (a().a() != null) && (a().a().tabBarInfo != null) && (!a().a().tabBarInfo.custom))
    {
      if (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.a()) {
        this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar.setInfo(a().a().tabBarInfo);
      if ("top".equals(a().a().tabBarInfo.position)) {
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
  
  public void a(String paramString1, String paramString2, bhbr parambhbr)
  {
    Object localObject2 = null;
    boolean bool2 = true;
    boolean bool1;
    int i;
    Object localObject1;
    if ((!TextUtils.isEmpty(paramString1)) && (this.jdField_a_of_type_Bgho != null) && (a() != null))
    {
      if (paramString1.equals(this.jdField_a_of_type_JavaLangString)) {
        break label650;
      }
      this.jdField_a_of_type_JavaLangString = paramString1;
      bool1 = a().a(paramString1);
      if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(bgkl.a(paramString1))))
      {
        i = 1;
        if (i != 0) {
          localObject1 = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label390;
          }
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          PageWebviewContainer localPageWebviewContainer = (PageWebviewContainer)((Map.Entry)localObject3).getValue();
          if (((String)((Map.Entry)localObject3).getKey()).equals(paramString1))
          {
            if (localPageWebviewContainer.getParent() == null) {
              this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localPageWebviewContainer, new FrameLayout.LayoutParams(-1, -1));
            }
            localPageWebviewContainer.setVisibility(0);
            this.jdField_b_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer = localPageWebviewContainer;
            parambhbr.b(paramString2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer.e());
            continue;
            i = 0;
            break;
          }
          localPageWebviewContainer.setVisibility(8);
        }
      }
      this.jdField_a_of_type_Bgho.a(bhad.a(this.jdField_a_of_type_JavaLangString));
      Object localObject3 = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer;
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer = null;
      this.jdField_b_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer = ((PageWebviewContainer)localObject3);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new PageWebviewContainer(this.jdField_a_of_type_Bgho, this);
        this.jdField_b_of_type_ComTencentQqminiSdkRuntimeCorePagePageWebviewContainer = ((PageWebviewContainer)localObject1);
      }
      localObject3 = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer.a().a().a(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer);
      ((bhbi)localObject3).a(parambhbr);
      ((bhbi)localObject3).a(a());
      ((bhbi)localObject3).a(paramString1, paramString2);
      ((PageWebviewContainer)localObject1).setBrandPageWebview((bhbi)localObject3);
      ((PageWebviewContainer)localObject1).a(paramString1);
      if (((PageWebviewContainer)localObject1).getParent() == null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      }
      if (bool1) {
        this.jdField_a_of_type_JavaUtilMap.put(bgkl.a(paramString1), localObject1);
      }
    }
    label390:
    if ((this.jdField_a_of_type_Bgho != null) && (a() != null) && (a().a() != null))
    {
      localObject1 = a().a().getPageInfo(paramString1).windowInfo.navigationBarInfo.style;
      parambhbr = a().a().getPageInfo(paramString1).windowInfo;
      if ((a().a().tabBarInfo != null) && (!a().a().tabBarInfo.custom)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((!this.jdField_b_of_type_JavaLangString.equals(localObject1)) || (this.jdField_a_of_type_Boolean != bool1))
      {
        a((String)localObject1);
        this.jdField_a_of_type_Boolean = bool1;
        this.jdField_b_of_type_JavaLangString = ((String)localObject1);
      }
      i = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer.d();
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.a(this);
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.a(parambhbr, this.jdField_a_of_type_Bgho.a());
      parambhbr = this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar;
      if (i > 1)
      {
        bool1 = true;
        label572:
        parambhbr.a(bool1);
        this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetNavigationBar.a().a(new bgmr(this.jdField_a_of_type_Bgho));
        if (i != 1) {
          break label706;
        }
        i = 1;
        label610:
        if (i != 0) {
          break label712;
        }
        bool1 = true;
        label618:
        setSwipeBackEnable(bool1);
        c(paramString1);
        if ("appLaunch".equals(paramString2)) {
          break label718;
        }
      }
      label650:
      label706:
      label712:
      label718:
      for (bool1 = bool2;; bool1 = false)
      {
        a(bool1);
        return;
        parambhbr.b(paramString2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer.e());
        if (!"appLaunch".equals(paramString2)) {}
        for (bool1 = true;; bool1 = false)
        {
          a(bool1);
          return;
        }
        bool1 = false;
        break;
        bool1 = false;
        break label572;
        i = 0;
        break label610;
        bool1 = false;
        break label618;
      }
      bool1 = false;
      parambhbr = null;
      localObject1 = localObject2;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (a() != null) {
      a().a(paramBoolean);
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
  
  public void b(String paramString)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("AppBrandPage", "updateToastMsg toastView=" + this.jdField_a_of_type_Bgnw);
    }
    if (this.jdField_a_of_type_Bgnw == null) {
      return;
    }
    this.jdField_a_of_type_Bgnw.a(paramString);
  }
  
  public boolean b()
  {
    if (a() != null) {
      return a().a(this.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  public void c()
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("AppBrandPage", "hideToastView toastView=" + this.jdField_a_of_type_Bgnw);
    }
    if (this.jdField_a_of_type_Bgnw != null)
    {
      this.jdField_a_of_type_Bgnw.a();
      this.jdField_a_of_type_Bgnw = null;
    }
    if (this.jdField_a_of_type_Bgnf != null)
    {
      this.jdField_a_of_type_Bgnf.a();
      this.jdField_a_of_type_Bgnf = null;
    }
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_Bgho != null) && (a() != null)) {
      return a().b(this.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  public void d()
  {
    if (a() != null) {
      a().onPause();
    }
  }
  
  public boolean d()
  {
    return ((this.jdField_a_of_type_Bgnw != null) && (this.jdField_a_of_type_Bgnw.a())) || (this.jdField_a_of_type_Bgnf != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage
 * JD-Core Version:    0.7.0.1
 */