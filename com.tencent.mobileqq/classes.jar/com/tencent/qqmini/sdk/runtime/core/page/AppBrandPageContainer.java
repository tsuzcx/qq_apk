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
import bdcz;
import bdep;
import bdfs;
import bdfv;
import bdfx;
import bdgj;
import bdhc;
import bdhd;
import bdja;
import bdnw;
import bduk;
import bdut;
import bduu;
import bduv;
import bdux;
import bdvc;
import bdvj;
import bdzf;
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
  implements bdja, bdvc
{
  public int a;
  private bdcz jdField_a_of_type_Bdcz;
  private bdfx jdField_a_of_type_Bdfx;
  private bdhc jdField_a_of_type_Bdhc;
  bduk jdField_a_of_type_Bduk;
  private bdvj jdField_a_of_type_Bdvj;
  private LinkedList<AppBrandPage> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private List<bdhd> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private int b = -1;
  
  public AppBrandPageContainer(bdcz parambdcz, bduk parambduk)
  {
    super(parambdcz.a());
    this.jdField_a_of_type_Bdcz = parambdcz;
    this.jdField_a_of_type_Bduk = parambduk;
    this.jdField_a_of_type_Bdhc = new bdhc(this);
    this.jdField_a_of_type_Bdvj = new bdvj(parambdcz);
    this.jdField_a_of_type_Bdhc.a(new bdut(this));
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Bdfx != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Bdfx.a(paramString, this.jdField_a_of_type_Bdcz.a()))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Bdfx.c(paramString)) {
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
      localObject2 = this.jdField_a_of_type_Bdvj.a(this.jdField_a_of_type_Bdcz, this);
    }
    return localObject2;
  }
  
  private String b(bdfs parambdfs)
  {
    if ("setEnableDebug".equals(parambdfs.jdField_a_of_type_JavaLangString)) {
      try
      {
        boolean bool = new JSONObject(parambdfs.b).optBoolean("enableDebug");
        if (bool != Boolean.valueOf(bdzf.a().getBoolean(this.jdField_a_of_type_Bdcz.a().appId + "_debug", false)).booleanValue()) {
          this.jdField_a_of_type_Bdcz.a().runOnUiThread(new AppBrandPageContainer.4(this, bool));
        } else {
          parambdfs.a();
        }
      }
      catch (JSONException localJSONException)
      {
        parambdfs.b();
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
      this.jdField_a_of_type_Bdcz.a(bdfv.a("onTabItemTap", localJSONObject.toString(), c()));
      return;
    }
    catch (Throwable paramString1)
    {
      bdnw.d("AppBrandPageContainer", "onTabItemClick error,", paramString1);
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    WeakReference localWeakReference = new WeakReference(this);
    bdep.a().a(this.jdField_a_of_type_Bdcz.a(), paramString1, new bduv(this, paramString1, localWeakReference, paramString2));
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
  
  public bdvj a()
  {
    return this.jdField_a_of_type_Bdvj;
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
  
  public String a(bdfs parambdfs)
  {
    Object localObject2 = null;
    Object localObject1;
    if (parambdfs.jdField_a_of_type_Int == 3) {
      localObject1 = b(parambdfs);
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
          if (parambdfs.jdField_a_of_type_Int == 0) {
            return ((AppBrandPage)localObject3).a(parambdfs);
          }
          localObject3 = ((AppBrandPage)localObject3).a();
          localObject1 = localObject2;
        } while (localObject3 == null);
        if (parambdfs.jdField_a_of_type_Int == 1) {
          return ((PageWebviewContainer)localObject3).a(parambdfs);
        }
        localObject3 = ((PageWebviewContainer)localObject3).a();
        localObject1 = localObject2;
      } while (localObject3 == null);
      localObject1 = localObject2;
    } while (parambdfs.jdField_a_of_type_Int != 2);
    return ((NativeViewContainer)localObject3).a(parambdfs);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bduk != null) {
      this.jdField_a_of_type_Bduk.a("onAppEnterBackground", null, 0);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    b(paramString1);
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
  
  public void a(bdhd parambdhd)
  {
    if ((parambdhd == null) || (this.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(parambdhd);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    String str1;
    if ((paramBoolean) && (this.jdField_a_of_type_Bduk != null) && (this.jdField_a_of_type_Bduk.a()) && (!TextUtils.isEmpty(paramMiniAppInfo.launchParam.c)))
    {
      paramBoolean = true;
      str1 = paramMiniAppInfo.launchParam.c;
      this.jdField_a_of_type_Bduk.a(paramMiniAppInfo.launchParam.c);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bduk != null) && (this.jdField_a_of_type_Bduk.a()))
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
          paramMiniAppInfo = bdgj.a(str2, paramMiniAppInfo);
        }
      }
      try
      {
        paramMiniAppInfo.put("reLaunch", paramBoolean);
        bdnw.b("AppBrandPageContainer", "appLaunchInfo : " + paramMiniAppInfo.toString());
        this.jdField_a_of_type_Bduk.a("onAppEnterForeground", paramMiniAppInfo.toString(), 0);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          bdnw.d("AppBrandPageContainer", "appLaunchInfo error.", localThrowable);
        }
      }
      Object localObject = null;
      paramBoolean = false;
    }
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_Bdvj != null) {
      this.jdField_a_of_type_Bdvj.a(this.jdField_a_of_type_Bdcz, this);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Int > 10)
    {
      Toast.makeText(getContext(), "打开页面超过上限，请返回", 0).show();
      bdnw.d("AppBrandPageContainer", "打开WebView数量超过上限");
      return;
    }
    if (!a(paramString))
    {
      b(paramString, "navigateTo");
      return;
    }
    AppBrandPage localAppBrandPage = this.jdField_a_of_type_Bdvj.a(this.jdField_a_of_type_Bdcz, this);
    localAppBrandPage.setVisibility(4);
    this.jdField_a_of_type_JavaUtilLinkedList.push(localAppBrandPage);
    localAppBrandPage.a(paramString, "navigateTo", this.jdField_a_of_type_Bduk);
    addView(localAppBrandPage, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!a(paramString1))
    {
      b(paramString1, paramString2);
      return;
    }
    AppBrandPage localAppBrandPage = this.jdField_a_of_type_Bdvj.a(this.jdField_a_of_type_Bdcz, this);
    this.jdField_a_of_type_JavaUtilLinkedList.push(localAppBrandPage);
    localAppBrandPage.a(paramString1, paramString2, this.jdField_a_of_type_Bduk);
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
      if ((localAppBrandPage != null) && ((!paramBoolean) || (this.jdField_a_of_type_Bdfx == null) || (!this.jdField_a_of_type_Bdfx.a(localAppBrandPage.a()))))
      {
        localAppBrandPage.b();
        removeView(localAppBrandPage);
        localIterator.remove();
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    int j = b();
    if ((j < 2) || (paramInt < 1)) {
      return false;
    }
    int i = paramInt;
    if (paramInt >= j) {
      i = j - 1;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    paramInt = 0;
    for (;;)
    {
      if ((paramInt >= i) || (this.jdField_a_of_type_JavaUtilLinkedList.size() < 1))
      {
        localObject = (AppBrandPage)this.jdField_a_of_type_JavaUtilLinkedList.peek();
        if (localObject != null) {
          this.jdField_a_of_type_Bduk.b("navigateBack", ((AppBrandPage)localObject).a(), ((AppBrandPage)localObject).b());
        }
        return true;
      }
      if (((Iterator)localObject).hasNext())
      {
        AppBrandPage localAppBrandPage = (AppBrandPage)((Iterator)localObject).next();
        Animation localAnimation = AnimationUtils.loadAnimation(MiniAppEnv.g().getContext(), 2130772086);
        localAnimation.setDuration(200L);
        localAnimation.setAnimationListener(new bduu(this, localAppBrandPage));
        localAppBrandPage.startAnimation(localAnimation);
        ((Iterator)localObject).remove();
      }
      paramInt += 1;
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
  
  public void b(String paramString)
  {
    a(true);
    AppBrandPage localAppBrandPage = b();
    localAppBrandPage.setVisibility(4);
    this.jdField_a_of_type_JavaUtilLinkedList.push(localAppBrandPage);
    localAppBrandPage.a(paramString, "switchTab", this.jdField_a_of_type_Bduk);
    localAppBrandPage.setVisibility(0);
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
    if (this.jdField_a_of_type_Bdvj != null)
    {
      this.jdField_a_of_type_Bdvj.a();
      this.jdField_a_of_type_Bdvj = null;
    }
  }
  
  public void c(String paramString)
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
    AppBrandPage localAppBrandPage = this.jdField_a_of_type_Bdvj.a(this.jdField_a_of_type_Bdcz, this);
    if (!localAppBrandPage.b()) {
      localAppBrandPage.setVisibility(4);
    }
    this.jdField_a_of_type_JavaUtilLinkedList.push(localAppBrandPage);
    localAppBrandPage.a(paramString, "redirectTo", this.jdField_a_of_type_Bduk);
    addView(localAppBrandPage, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public int d()
  {
    return this.b;
  }
  
  public void d()
  {
    this.b = -1;
  }
  
  public void setApkgInfo(bdfx parambdfx)
  {
    this.jdField_a_of_type_Bdfx = parambdfx;
  }
  
  public void setCurShowingInputId(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setSoftKeyboardStateListener(bdhd parambdhd)
  {
    if (parambdhd == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(parambdhd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer
 * JD-Core Version:    0.7.0.1
 */