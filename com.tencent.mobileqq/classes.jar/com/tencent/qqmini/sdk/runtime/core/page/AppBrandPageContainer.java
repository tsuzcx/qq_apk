package com.tencent.qqmini.sdk.runtime.core.page;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import bglv;
import bgmk;
import bgms;
import bgno;
import bgod;
import bgof;
import bgoh;
import bgor;
import bgos;
import bgpt;
import bgpu;
import bgqz;
import bgsc;
import bhez;
import bhfl;
import bhfm;
import bhfn;
import bhfp;
import bhfv;
import bhgf;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.core.widget.NavigationBar;
import com.tencent.qqmini.sdk.core.widget.TabBar;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.plugin.EmbeddedWidgetClientFactory;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.utils.StorageUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandPageContainer
  extends FrameLayout
  implements bgsc, bhfv
{
  public int a;
  private bglv jdField_a_of_type_Bglv;
  private bgod jdField_a_of_type_Bgod;
  private bgpt jdField_a_of_type_Bgpt;
  bhez jdField_a_of_type_Bhez;
  private bhgf jdField_a_of_type_Bhgf;
  private LinkedList<AppBrandPage> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private List<bgpu> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private int b = -1;
  
  public AppBrandPageContainer(bglv parambglv, bhez parambhez)
  {
    super(parambglv.a());
    this.jdField_a_of_type_Bglv = parambglv;
    this.jdField_a_of_type_Bhez = parambhez;
    this.jdField_a_of_type_Bgpt = new bgpt(this);
    this.jdField_a_of_type_Bhgf = new bhgf(parambglv);
    this.jdField_a_of_type_Bgpt.a(new bhfl(this));
  }
  
  private NativeViewContainer a()
  {
    PageWebviewContainer localPageWebviewContainer = a();
    if (localPageWebviewContainer == null) {
      return null;
    }
    return localPageWebviewContainer.a();
  }
  
  private PageWebviewContainer a()
  {
    AppBrandPage localAppBrandPage = a();
    if (localAppBrandPage == null) {
      return null;
    }
    return localAppBrandPage.a();
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Bgod != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Bgod.isUrlResReady(paramString, this.jdField_a_of_type_Bglv.a()))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Bgod.c(paramString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private AppBrandPage b()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilLinkedList != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
      {
        localObject2 = (AppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.poll();
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          ((AppBrandPage)localObject2).d();
          localObject1 = localObject2;
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.jdField_a_of_type_Bhgf.a(this.jdField_a_of_type_Bglv, this);
    }
    return localObject2;
  }
  
  private String b(bgmk parambgmk)
  {
    if ("setEnableDebug".equals(parambgmk.jdField_a_of_type_JavaLangString)) {
      try
      {
        boolean bool = new JSONObject(parambgmk.b).optBoolean("enableDebug");
        if (bool != Boolean.valueOf(StorageUtil.getPreference().getBoolean(this.jdField_a_of_type_Bglv.a().appId + "_debug", false)).booleanValue()) {
          this.jdField_a_of_type_Bglv.a().runOnUiThread(new AppBrandPageContainer.4(this, bool));
        } else {
          parambgmk.a();
        }
      }
      catch (JSONException localJSONException)
      {
        parambgmk.b();
      }
    } else if ("setBackgroundTextStyle".equals(parambgmk.jdField_a_of_type_JavaLangString)) {
      bgor.a(new AppBrandPageContainer.5(this, parambgmk));
    } else if ("setBackgroundColor".equals(parambgmk.jdField_a_of_type_JavaLangString)) {
      bgor.a(new AppBrandPageContainer.6(this, parambgmk));
    }
    return null;
  }
  
  private void b(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("index", paramInt);
      localJSONObject.put("pagePath", paramString1);
      localJSONObject.put("text", paramString2);
      this.jdField_a_of_type_Bglv.a(bgms.a("onTabItemTap", localJSONObject.toString(), e()));
      return;
    }
    catch (Throwable paramString1)
    {
      QMLog.e("minisdk-start-AppBrandPageContainer", "onTabItemClick error,", paramString1);
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    WeakReference localWeakReference = new WeakReference(this);
    bgno.a().a(this.jdField_a_of_type_Bglv.a(), paramString1, new bhfn(this, paramString1, localWeakReference, paramString2));
  }
  
  public int a()
  {
    Object localObject = (AppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).a();
      if (localObject != null) {
        return ((TabBar)localObject).getVisibility();
      }
      return 8;
    }
    return 8;
  }
  
  public View a()
  {
    return this;
  }
  
  public bgof a(int paramInt)
  {
    bgoh localbgoh = new bgoh();
    Object localObject = (AbsAppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.peek();
    if ((bgof.a(paramInt)) && (localObject != null) && (((AbsAppBrandPage)localObject).a() != null)) {
      localbgoh.a(((AbsAppBrandPage)localObject).a().b());
    }
    if (bgof.b(paramInt)) {
      if (localObject == null) {
        break label114;
      }
    }
    label114:
    for (localObject = ((AbsAppBrandPage)localObject).a();; localObject = null)
    {
      localbgoh.a((String)localObject);
      if (bgof.c(paramInt)) {
        localbgoh.b(a().getWidth());
      }
      if (bgof.d(paramInt)) {
        localbgoh.b(a().getHeight());
      }
      return localbgoh.a();
    }
  }
  
  public bgqz a()
  {
    return a();
  }
  
  public bhgf a()
  {
    return this.jdField_a_of_type_Bhgf;
  }
  
  public CapsuleButton a()
  {
    AppBrandPage localAppBrandPage = a();
    if (localAppBrandPage != null) {
      return localAppBrandPage.a();
    }
    return null;
  }
  
  public CoverView a(int paramInt)
  {
    NativeViewContainer localNativeViewContainer = a();
    if (localNativeViewContainer != null) {
      return localNativeViewContainer.a(paramInt);
    }
    return null;
  }
  
  public AppBrandPage a()
  {
    if (d() > 0) {
      return (AppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.peek();
    }
    return null;
  }
  
  public EmbeddedWidgetClientFactory a()
  {
    AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.peek();
    if ((localAbsAppBrandPage != null) && (localAbsAppBrandPage.a() != null)) {
      return localAbsAppBrandPage.a().a();
    }
    return null;
  }
  
  public String a()
  {
    PageWebviewContainer localPageWebviewContainer = a();
    if (localPageWebviewContainer != null) {
      return localPageWebviewContainer.a();
    }
    return "";
  }
  
  public String a(bgmk parambgmk)
  {
    Object localObject2 = null;
    Object localObject1;
    if (parambgmk.jdField_a_of_type_Int == 3) {
      localObject1 = b(parambgmk);
    }
    Object localObject3;
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject1;
            localObject3 = a();
            localObject1 = localObject2;
          } while (localObject3 == null);
          if (parambgmk.jdField_a_of_type_Int == 0) {
            return ((AppBrandPage)localObject3).a(parambgmk);
          }
          localObject3 = ((AppBrandPage)localObject3).a();
          localObject1 = localObject2;
        } while (localObject3 == null);
        if (parambgmk.jdField_a_of_type_Int == 1) {
          return ((PageWebviewContainer)localObject3).a(parambgmk);
        }
        localObject3 = ((PageWebviewContainer)localObject3).a();
        localObject1 = localObject2;
      } while (localObject3 == null);
      localObject1 = localObject2;
    } while (parambgmk.jdField_a_of_type_Int != 2);
    return ((NativeViewContainer)localObject3).a(parambgmk);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bhez != null) {
      this.jdField_a_of_type_Bhez.a("onAppEnterBackground", null, 0);
    }
  }
  
  public void a(int paramInt)
  {
    NativeViewContainer localNativeViewContainer = a();
    if (localNativeViewContainer != null) {
      localNativeViewContainer.e(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, CoverView paramCoverView, boolean paramBoolean)
  {
    NativeViewContainer localNativeViewContainer = a();
    if (localNativeViewContainer != null) {
      localNativeViewContainer.a(paramInt1, paramInt2, paramCoverView, paramBoolean);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    a(paramString1);
    b(paramInt, paramString1, paramString2);
  }
  
  public void a(Activity paramActivity) {}
  
  public void a(View paramView)
  {
    if (paramView != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)paramView.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
    }
  }
  
  public void a(bgpu parambgpu)
  {
    if ((parambgpu == null) || (this.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(parambgpu);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    String str1;
    if ((paramBoolean) && (this.jdField_a_of_type_Bhez != null) && (this.jdField_a_of_type_Bhez.a()) && (!TextUtils.isEmpty(paramMiniAppInfo.launchParam.entryPath)))
    {
      paramBoolean = true;
      str1 = paramMiniAppInfo.launchParam.entryPath;
      this.jdField_a_of_type_Bhez.a(paramMiniAppInfo.launchParam.entryPath);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bhez != null) && (this.jdField_a_of_type_Bhez.a()))
      {
        String str2 = str1;
        if (TextUtils.isEmpty(str1))
        {
          str2 = str1;
          if (a() != null) {
            str2 = a().a();
          }
        }
        if (!TextUtils.isEmpty(str2)) {
          paramMiniAppInfo = bgos.a(str2, paramMiniAppInfo);
        }
      }
      try
      {
        paramMiniAppInfo.put("reLaunch", paramBoolean);
        QMLog.i("minisdk-start-AppBrandPageContainer", "appLaunchInfo : " + paramMiniAppInfo.toString());
        this.jdField_a_of_type_Bhez.a("onAppEnterForeground", paramMiniAppInfo.toString(), 0);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QMLog.e("minisdk-start-AppBrandPageContainer", "appLaunchInfo error.", localThrowable);
        }
      }
      Object localObject = null;
      paramBoolean = false;
    }
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_Bhgf != null) {
      this.jdField_a_of_type_Bhgf.a(this.jdField_a_of_type_Bglv, this);
    }
  }
  
  public void a(String paramString)
  {
    QMLog.i("minisdk-start-AppBrandPageContainer", "switchTab url : " + paramString);
    a(true);
    AppBrandPage localAppBrandPage = b();
    this.jdField_a_of_type_JavaUtilLinkedList.push(localAppBrandPage);
    localAppBrandPage.a(paramString, "switchTab", this.jdField_a_of_type_Bhez);
  }
  
  public void a(String paramString, int paramInt)
  {
    QMLog.i("minisdk-start-AppBrandPageContainer", "navigateTo url : " + paramString);
    if (this.jdField_a_of_type_Int > 10)
    {
      Toast.makeText(getContext(), "打开页面超过上限，请返回", 0).show();
      QMLog.e("minisdk-start-AppBrandPageContainer", "打开WebView数量超过上限");
      return;
    }
    if (!a(paramString))
    {
      b(paramString, "navigateTo");
      return;
    }
    AppBrandPage localAppBrandPage = (AppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.peek();
    if (localAppBrandPage != null) {
      localAppBrandPage.d();
    }
    localAppBrandPage = this.jdField_a_of_type_Bhgf.a(this.jdField_a_of_type_Bglv, this);
    localAppBrandPage.setVisibility(4);
    this.jdField_a_of_type_JavaUtilLinkedList.push(localAppBrandPage);
    localAppBrandPage.a(paramString, "navigateTo", this.jdField_a_of_type_Bhez);
    addView(localAppBrandPage, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void a(String paramString1, String paramString2)
  {
    QMLog.i("minisdk-start-AppBrandPageContainer", "launch url : " + paramString1 + "; type : " + paramString2);
    if (!a(paramString1))
    {
      b(paramString1, paramString2);
      return;
    }
    AppBrandPage localAppBrandPage = this.jdField_a_of_type_Bhgf.a(this.jdField_a_of_type_Bglv, this);
    this.jdField_a_of_type_JavaUtilLinkedList.push(localAppBrandPage);
    localAppBrandPage.a(paramString1, paramString2, this.jdField_a_of_type_Bhez);
    addView(localAppBrandPage, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    Object localObject;
    if (paramArrayOfInt.length == 0)
    {
      paramArrayOfInt = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (paramArrayOfInt.hasNext())
      {
        localObject = (AppBrandPage)paramArrayOfInt.next();
        if ((localObject != null) && (((AppBrandPage)localObject).a() != null)) {
          ((AppBrandPage)localObject).a().b(paramString1, paramString2, ((AppBrandPage)localObject).b());
        }
      }
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      localObject = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AppBrandPage localAppBrandPage = (AppBrandPage)((Iterator)localObject).next();
        if ((localAppBrandPage.a() != null) && (k == localAppBrandPage.b())) {
          localAppBrandPage.a().b(paramString1, paramString2, k);
        }
      }
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    while (localIterator.hasNext())
    {
      AppBrandPage localAppBrandPage = (AppBrandPage)localIterator.next();
      if ((localAppBrandPage != null) && ((!paramBoolean) || (this.jdField_a_of_type_Bgod == null) || (!this.jdField_a_of_type_Bgod.a(localAppBrandPage.a()))))
      {
        localAppBrandPage.d();
        localAppBrandPage.b();
        removeView(localAppBrandPage);
        localIterator.remove();
      }
    }
  }
  
  public boolean a()
  {
    MiniAppInfo localMiniAppInfo;
    if (this.jdField_a_of_type_Bglv != null)
    {
      localMiniAppInfo = this.jdField_a_of_type_Bglv.a();
      if (DebugUtil.getDebugEnabled(localMiniAppInfo)) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      DebugUtil.setDebugEnabled(localMiniAppInfo, bool);
      return bool;
      localMiniAppInfo = null;
      break;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    QMLog.i("minisdk-start-AppBrandPageContainer", "navigateBack delta : " + paramInt1);
    int i = d();
    if ((i < 2) || (paramInt1 < 1)) {
      return false;
    }
    paramInt2 = paramInt1;
    if (paramInt1 >= i) {
      paramInt2 = i - 1;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    paramInt1 = 0;
    for (;;)
    {
      if ((paramInt1 >= paramInt2) || (this.jdField_a_of_type_JavaUtilLinkedList.size() < 1))
      {
        localObject = (AppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.peek();
        if (localObject != null)
        {
          ((AppBrandPage)localObject).a(true);
          this.jdField_a_of_type_Bhez.b("navigateBack", ((AppBrandPage)localObject).a(), ((AppBrandPage)localObject).b());
        }
        return true;
      }
      if (((Iterator)localObject).hasNext())
      {
        AppBrandPage localAppBrandPage = (AppBrandPage)((Iterator)localObject).next();
        if (localAppBrandPage != null)
        {
          Animation localAnimation = AnimationUtils.loadAnimation(AppLoaderFactory.g().getMiniAppEnv().getContext(), 2130772086);
          localAnimation.setDuration(200L);
          localAnimation.setAnimationListener(new bhfm(this, localAppBrandPage));
          localAppBrandPage.startAnimation(localAnimation);
          localAppBrandPage.d();
          ((Iterator)localObject).remove();
        }
      }
      paramInt1 += 1;
    }
  }
  
  public boolean a(View paramView)
  {
    if (paramView == null) {}
    NativeViewContainer localNativeViewContainer;
    do
    {
      return false;
      localNativeViewContainer = a();
    } while (localNativeViewContainer == null);
    localNativeViewContainer.removeView(paramView);
    return true;
  }
  
  public boolean a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramView == null) {}
    NativeViewContainer localNativeViewContainer;
    do
    {
      return false;
      localNativeViewContainer = a();
    } while (localNativeViewContainer == null);
    if (paramLayoutParams != null) {
      localNativeViewContainer.addView(paramView, paramLayoutParams);
    }
    for (;;)
    {
      return true;
      localNativeViewContainer.addView(paramView);
    }
  }
  
  public int b()
  {
    Object localObject = (AppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).a();
      if (localObject != null) {
        return ((NavigationBar)localObject).getVisibility();
      }
      return 8;
    }
    return 8;
  }
  
  public String b()
  {
    Object localObject = (AppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).a();
      if (localObject != null) {
        return ((NavigationBar)localObject).a();
      }
      return "default";
    }
    return "default";
  }
  
  public void b() {}
  
  public void b(String paramString, int paramInt)
  {
    QMLog.i("minisdk-start-AppBrandPageContainer", "redirectTo url : " + paramString);
    if (!a(paramString))
    {
      b(paramString, "redirectTo");
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0))
    {
      localAppBrandPage = (AppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.poll();
      if (localAppBrandPage != null)
      {
        localAppBrandPage.d();
        localAppBrandPage.b();
        removeView(localAppBrandPage);
      }
    }
    AppBrandPage localAppBrandPage = this.jdField_a_of_type_Bhgf.a(this.jdField_a_of_type_Bglv, this);
    if (!localAppBrandPage.c()) {
      localAppBrandPage.setVisibility(4);
    }
    this.jdField_a_of_type_JavaUtilLinkedList.push(localAppBrandPage);
    localAppBrandPage.a(paramString, "redirectTo", this.jdField_a_of_type_Bhez);
    addView(localAppBrandPage, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    Object localObject = (AppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).a();
      if (localObject != null) {
        return ((NavigationBar)localObject).a();
      }
      return -1;
    }
    return -1;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bhgf != null)
    {
      this.jdField_a_of_type_Bhgf.a();
      this.jdField_a_of_type_Bhgf = null;
    }
  }
  
  public boolean c()
  {
    AppBrandPage localAppBrandPage = a();
    if (localAppBrandPage != null) {
      return localAppBrandPage.b();
    }
    return false;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
      return this.jdField_a_of_type_JavaUtilLinkedList.size();
    }
    return 0;
  }
  
  public void d()
  {
    this.b = -1;
  }
  
  public int e()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.peek() != null)) {
      return ((AppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.peek()).b();
    }
    return -1;
  }
  
  public int f()
  {
    return this.b;
  }
  
  public void setApkgInfo(bgod parambgod)
  {
    this.jdField_a_of_type_Bgod = parambgod;
  }
  
  public void setCurShowingInputId(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setNaviBarStyle(String paramString)
  {
    Object localObject = (AppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).a();
      if (localObject != null) {
        ((NavigationBar)localObject).a(paramString);
      }
    }
  }
  
  public void setNaviVisibility(int paramInt)
  {
    Object localObject = (AppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).a();
      if (localObject != null) {
        ((NavigationBar)localObject).setVisibility(paramInt);
      }
    }
  }
  
  public void setSoftKeyboardStateListener(bgpu parambgpu)
  {
    if (parambgpu == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(parambgpu);
  }
  
  public void setTabBarVisibility(int paramInt)
  {
    Object localObject = (AppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).a();
      if (localObject != null) {
        ((TabBar)localObject).setVisibility(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer
 * JD-Core Version:    0.7.0.1
 */