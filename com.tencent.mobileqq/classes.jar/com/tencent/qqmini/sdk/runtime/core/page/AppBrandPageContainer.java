package com.tencent.qqmini.sdk.runtime.core.page;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import begz;
import beip;
import bejs;
import bejw;
import bejy;
import bekj;
import belf;
import belg;
import bend;
import besl;
import bfas;
import bfbb;
import bfbc;
import bfbd;
import bfbf;
import bfbk;
import bfbr;
import bfgv;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
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
  implements bend, bfbk
{
  public int a;
  private begz jdField_a_of_type_Begz;
  private bejy jdField_a_of_type_Bejy;
  private belf jdField_a_of_type_Belf;
  bfas jdField_a_of_type_Bfas;
  private bfbr jdField_a_of_type_Bfbr;
  private LinkedList<AppBrandPage> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private List<belg> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private int b = -1;
  
  public AppBrandPageContainer(begz parambegz, bfas parambfas)
  {
    super(parambegz.a());
    this.jdField_a_of_type_Begz = parambegz;
    this.jdField_a_of_type_Bfas = parambfas;
    this.jdField_a_of_type_Belf = new belf(this);
    this.jdField_a_of_type_Bfbr = new bfbr(parambegz);
    this.jdField_a_of_type_Belf.a(new bfbb(this));
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Bejy != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Bejy.a(paramString, this.jdField_a_of_type_Begz.a()))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Bejy.c(paramString)) {
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
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
        localObject1 = (AppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.poll();
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.jdField_a_of_type_Bfbr.a(this.jdField_a_of_type_Begz, this);
    }
    return localObject2;
  }
  
  private String b(bejs parambejs)
  {
    if ("setEnableDebug".equals(parambejs.jdField_a_of_type_JavaLangString)) {
      try
      {
        boolean bool = new JSONObject(parambejs.b).optBoolean("enableDebug");
        if (bool != Boolean.valueOf(bfgv.a().getBoolean(this.jdField_a_of_type_Begz.a().appId + "_debug", false)).booleanValue()) {
          this.jdField_a_of_type_Begz.a().runOnUiThread(new AppBrandPageContainer.4(this, bool));
        } else {
          parambejs.a();
        }
      }
      catch (JSONException localJSONException)
      {
        parambejs.b();
      }
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
      this.jdField_a_of_type_Begz.a(bejw.a("onTabItemTap", localJSONObject.toString(), c()));
      return;
    }
    catch (Throwable paramString1)
    {
      besl.d("AppBrandPageContainer", "onTabItemClick error,", paramString1);
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    WeakReference localWeakReference = new WeakReference(this);
    beip.a().a(this.jdField_a_of_type_Begz.a(), paramString1, new bfbd(this, paramString1, localWeakReference, paramString2));
  }
  
  public int a()
  {
    AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.peek();
    if ((localAbsAppBrandPage != null) && (localAbsAppBrandPage.a() != null)) {
      return localAbsAppBrandPage.a().b();
    }
    return 0;
  }
  
  public View a()
  {
    return this;
  }
  
  public bfbr a()
  {
    return this.jdField_a_of_type_Bfbr;
  }
  
  public AppBrandPage a()
  {
    if (b() > 0) {
      return (AppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.peek();
    }
    return null;
  }
  
  public String a()
  {
    AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.peek();
    if (localAbsAppBrandPage != null) {
      return localAbsAppBrandPage.a();
    }
    return null;
  }
  
  public String a(bejs parambejs)
  {
    Object localObject2 = null;
    Object localObject1;
    if (parambejs.jdField_a_of_type_Int == 3) {
      localObject1 = b(parambejs);
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
          if (parambejs.jdField_a_of_type_Int == 0) {
            return ((AppBrandPage)localObject3).a(parambejs);
          }
          localObject3 = ((AppBrandPage)localObject3).a();
          localObject1 = localObject2;
        } while (localObject3 == null);
        if (parambejs.jdField_a_of_type_Int == 1) {
          return ((PageWebviewContainer)localObject3).a(parambejs);
        }
        localObject3 = ((PageWebviewContainer)localObject3).a();
        localObject1 = localObject2;
      } while (localObject3 == null);
      localObject1 = localObject2;
    } while (parambejs.jdField_a_of_type_Int != 2);
    return ((NativeViewContainer)localObject3).a(parambejs);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bfas != null) {
      this.jdField_a_of_type_Bfas.a("onAppEnterBackground", null, 0);
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
  
  public void a(belg parambelg)
  {
    if ((parambelg == null) || (this.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(parambelg);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    String str1;
    if ((paramBoolean) && (this.jdField_a_of_type_Bfas != null) && (this.jdField_a_of_type_Bfas.a()) && (!TextUtils.isEmpty(paramMiniAppInfo.launchParam.c)))
    {
      paramBoolean = true;
      str1 = paramMiniAppInfo.launchParam.c;
      this.jdField_a_of_type_Bfas.a(paramMiniAppInfo.launchParam.c);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bfas != null) && (this.jdField_a_of_type_Bfas.a()))
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
          paramMiniAppInfo = bekj.a(str2, paramMiniAppInfo);
        }
      }
      try
      {
        paramMiniAppInfo.put("reLaunch", paramBoolean);
        besl.b("AppBrandPageContainer", "appLaunchInfo : " + paramMiniAppInfo.toString());
        this.jdField_a_of_type_Bfas.a("onAppEnterForeground", paramMiniAppInfo.toString(), 0);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          besl.d("AppBrandPageContainer", "appLaunchInfo error.", localThrowable);
        }
      }
      Object localObject = null;
      paramBoolean = false;
    }
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_Bfbr != null) {
      this.jdField_a_of_type_Bfbr.a(this.jdField_a_of_type_Begz, this);
    }
  }
  
  public void a(String paramString)
  {
    a(true);
    AppBrandPage localAppBrandPage = b();
    localAppBrandPage.setVisibility(4);
    this.jdField_a_of_type_JavaUtilLinkedList.push(localAppBrandPage);
    localAppBrandPage.a(paramString, "switchTab", this.jdField_a_of_type_Bfas);
    localAppBrandPage.setVisibility(0);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Int > 10)
    {
      Toast.makeText(getContext(), "打开页面超过上限，请返回", 0).show();
      besl.d("AppBrandPageContainer", "打开WebView数量超过上限");
      return;
    }
    if (!a(paramString))
    {
      b(paramString, "navigateTo");
      return;
    }
    AppBrandPage localAppBrandPage = this.jdField_a_of_type_Bfbr.a(this.jdField_a_of_type_Begz, this);
    localAppBrandPage.setVisibility(4);
    this.jdField_a_of_type_JavaUtilLinkedList.push(localAppBrandPage);
    localAppBrandPage.a(paramString, "navigateTo", this.jdField_a_of_type_Bfas);
    addView(localAppBrandPage, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!a(paramString1))
    {
      b(paramString1, paramString2);
      return;
    }
    AppBrandPage localAppBrandPage = this.jdField_a_of_type_Bfbr.a(this.jdField_a_of_type_Begz, this);
    this.jdField_a_of_type_JavaUtilLinkedList.push(localAppBrandPage);
    localAppBrandPage.a(paramString1, paramString2, this.jdField_a_of_type_Bfas);
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
      if ((localAppBrandPage != null) && ((!paramBoolean) || (this.jdField_a_of_type_Bejy == null) || (!this.jdField_a_of_type_Bejy.a(localAppBrandPage.a()))))
      {
        localAppBrandPage.b();
        removeView(localAppBrandPage);
        localIterator.remove();
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    int i = b();
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
        if (localObject != null) {
          this.jdField_a_of_type_Bfas.b("navigateBack", ((AppBrandPage)localObject).a(), ((AppBrandPage)localObject).b());
        }
        return true;
      }
      if (((Iterator)localObject).hasNext())
      {
        AppBrandPage localAppBrandPage = (AppBrandPage)((Iterator)localObject).next();
        Animation localAnimation = AnimationUtils.loadAnimation(MiniAppEnv.g().getContext(), 2130772086);
        localAnimation.setDuration(200L);
        localAnimation.setAnimationListener(new bfbc(this, localAppBrandPage));
        localAppBrandPage.startAnimation(localAnimation);
        ((Iterator)localObject).remove();
      }
      paramInt1 += 1;
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
      return this.jdField_a_of_type_JavaUtilLinkedList.size();
    }
    return 0;
  }
  
  public void b() {}
  
  public void b(String paramString, int paramInt)
  {
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
        localAppBrandPage.b();
        removeView(localAppBrandPage);
      }
    }
    AppBrandPage localAppBrandPage = this.jdField_a_of_type_Bfbr.a(this.jdField_a_of_type_Begz, this);
    if (!localAppBrandPage.b()) {
      localAppBrandPage.setVisibility(4);
    }
    this.jdField_a_of_type_JavaUtilLinkedList.push(localAppBrandPage);
    localAppBrandPage.a(paramString, "redirectTo", this.jdField_a_of_type_Bfas);
    addView(localAppBrandPage, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.peek() != null)) {
      return ((AppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.peek()).b();
    }
    return -1;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bfbr != null)
    {
      this.jdField_a_of_type_Bfbr.a();
      this.jdField_a_of_type_Bfbr = null;
    }
  }
  
  public int d()
  {
    return this.b;
  }
  
  public void d()
  {
    this.b = -1;
  }
  
  public void setApkgInfo(bejy parambejy)
  {
    this.jdField_a_of_type_Bejy = parambejy;
  }
  
  public void setCurShowingInputId(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setSoftKeyboardStateListener(belg parambelg)
  {
    if (parambelg == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(parambelg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer
 * JD-Core Version:    0.7.0.1
 */