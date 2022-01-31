package com.tencent.mobileqq.microapp.appbrand.page;

import android.content.Context;
import android.widget.FrameLayout;
import bcpq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.utils.p;
import com.tencent.mobileqq.microapp.widget.TabBarView.b;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public final class AppBrandPageContainer
  extends FrameLayout
  implements TabBarView.b
{
  public static final String TAG = "AppBrandPageContainer";
  public a appBrandRuntime;
  public FrameLayout fullScreenLayout;
  public LinkedList pageLinkedList = new LinkedList();
  public int refreshStyleColor = -1;
  
  public AppBrandPageContainer(Context paramContext, a parama)
  {
    super(paramContext);
    this.appBrandRuntime = parama;
    setBackgroundColor(-1);
  }
  
  private void bringToFront(AbsAppBrandPage paramAbsAppBrandPage, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPageContainer", 4, "bringToFront page=" + paramAbsAppBrandPage + ",viewAnim=" + paramBoolean);
    }
    if (paramAbsAppBrandPage == null) {
      return;
    }
    this.pageLinkedList.remove(paramAbsAppBrandPage);
    this.pageLinkedList.push(paramAbsAppBrandPage);
    paramAbsAppBrandPage.bringToFront();
    requestLayout();
    invalidate();
    paramAbsAppBrandPage.onPageForeground();
  }
  
  private void executeDownSubPack(String paramString1, String paramString2)
  {
    WeakReference localWeakReference = new WeakReference(this);
    bcpq localbcpq = new bcpq(getContext());
    localbcpq.a("正在加载模块...");
    localbcpq.setCancelable(false);
    localbcpq.show();
    this.appBrandRuntime.c.a(paramString1, new AppBrandPageContainer.1(this, localWeakReference, paramString2, paramString1, localbcpq));
  }
  
  private boolean isUrlResReady(String paramString)
  {
    return this.appBrandRuntime.c.c(paramString);
  }
  
  public final void cleanup(boolean paramBoolean)
  {
    Iterator localIterator = this.pageLinkedList.iterator();
    while (localIterator.hasNext())
    {
      AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)localIterator.next();
      if ((!paramBoolean) || (!localAbsAppBrandPage.isTabPage()))
      {
        p.a().a(localAbsAppBrandPage.getCurrentPageWebview(), BaseApplicationImpl.sApplication);
        localAbsAppBrandPage.cleanup();
        localIterator.remove();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPageContainer", 4, "cleanup keepTabPage=" + paramBoolean + ",pageLinkedList size=" + this.pageLinkedList.size());
    }
  }
  
  public PageWebview findPageWebView(int paramInt)
  {
    Iterator localIterator = this.pageLinkedList.iterator();
    while (localIterator.hasNext())
    {
      PageWebview localPageWebview = ((AbsAppBrandPage)localIterator.next()).getWebView(paramInt);
      if (localPageWebview != null) {
        return localPageWebview;
      }
    }
    return null;
  }
  
  public AbsAppBrandPage getCurrentPage()
  {
    AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)this.pageLinkedList.peek();
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPageContainer", 4, "getCurrentPage page=" + localAbsAppBrandPage + ",this=" + this);
    }
    return localAbsAppBrandPage;
  }
  
  public PageWebview getCurrentPageWebview()
  {
    AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)this.pageLinkedList.peek();
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPageContainer", 4, "getCurrentPageWebview page=" + localAbsAppBrandPage);
    }
    if (localAbsAppBrandPage != null) {
      return localAbsAppBrandPage.getCurrentPageWebview();
    }
    return null;
  }
  
  public WebviewContainer getCurrentWebviewContainer()
  {
    AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)this.pageLinkedList.peek();
    if (localAbsAppBrandPage != null) {
      return localAbsAppBrandPage.getCurrentWebviewContainer();
    }
    return null;
  }
  
  public AbsAppBrandPage getPageByWebViewId(int paramInt)
  {
    Iterator localIterator = this.pageLinkedList.iterator();
    AbsAppBrandPage localAbsAppBrandPage;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localAbsAppBrandPage = (AbsAppBrandPage)localIterator.next();
    } while (localAbsAppBrandPage.getWebView(paramInt) == null);
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppBrandPageContainer", 4, "getPageByWebViewId webviewId=" + paramInt + ",page=" + localAbsAppBrandPage);
      }
      return localAbsAppBrandPage;
      localAbsAppBrandPage = null;
    }
  }
  
  public final int getPageCount()
  {
    return this.pageLinkedList.size();
  }
  
  public boolean handleBackPressed()
  {
    WebviewContainer localWebviewContainer = getCurrentWebviewContainer();
    return (localWebviewContainer != null) && (localWebviewContainer.handleBackPressed());
  }
  
  public void launch(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPageContainer", 4, "launch type=" + paramString2 + ",url=" + paramString1 + ",currPageCount=" + getPageCount());
    }
    if (!isUrlResReady(paramString1))
    {
      executeDownSubPack(paramString1, paramString2);
      return;
    }
    AppBrandPage localAppBrandPage = new AppBrandPage(getContext(), this);
    this.pageLinkedList.push(localAppBrandPage);
    localAppBrandPage.onCreate();
    localAppBrandPage.loadUrl(paramString1, paramString2);
  }
  
  public void navigateBack(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPageContainer", 4, "navigateBack delta=" + paramInt + ",viewAnim=" + paramBoolean);
    }
    int j = getPageCount();
    if ((j < 2) || (paramInt < 1)) {
      return;
    }
    int i = paramInt;
    if (paramInt >= j) {
      i = j - 1;
    }
    Object localObject = this.pageLinkedList.iterator();
    paramInt = 0;
    for (;;)
    {
      if ((paramInt >= i) || (this.pageLinkedList.size() < 1))
      {
        localObject = (AbsAppBrandPage)this.pageLinkedList.peek();
        QLog.d("AppBrandPageContainer", 4, "navigateBack backPage=" + localObject);
        if (localObject == null) {
          break;
        }
        ((AbsAppBrandPage)localObject).onPageForeground();
        ((AbsAppBrandPage)localObject).onAppRoute("navigateBack", ((AbsAppBrandPage)localObject).getUrl());
        return;
      }
      if (((Iterator)localObject).hasNext())
      {
        AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)((Iterator)localObject).next();
        QLog.d("AppBrandPageContainer", 4, "navigateBack clearPage=" + localAbsAppBrandPage);
        p.a().a(localAbsAppBrandPage.getCurrentPageWebview(), BaseApplicationImpl.sApplication);
        localAbsAppBrandPage.setVisibility(8);
        localAbsAppBrandPage.cleanup();
        ((Iterator)localObject).remove();
      }
      paramInt += 1;
    }
  }
  
  public void navigateTo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPageContainer", 4, "navigateTo url=" + paramString);
    }
    if (!isUrlResReady(paramString))
    {
      executeDownSubPack(paramString, "navigateTo");
      return;
    }
    AppBrandPage localAppBrandPage = new AppBrandPage(getContext(), this);
    this.pageLinkedList.push(localAppBrandPage);
    localAppBrandPage.onCreate();
    localAppBrandPage.loadUrl(paramString, "navigateTo");
  }
  
  public void onTabItemClick(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPageContainer", 4, "onTabItemClick pagePath=" + paramString);
    }
    swichTab(paramString);
  }
  
  public void redirectTo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPageContainer", 4, "redirectTo url=" + paramString);
    }
    if (!isUrlResReady(paramString))
    {
      executeDownSubPack(paramString, "redirectTo");
      return;
    }
    Object localObject = (AbsAppBrandPage)this.pageLinkedList.peek();
    if (localObject != null)
    {
      ((AbsAppBrandPage)localObject).cleanup();
      bringToFront((AbsAppBrandPage)localObject, false);
    }
    for (;;)
    {
      ((AbsAppBrandPage)localObject).onCreate();
      ((AbsAppBrandPage)localObject).loadUrl(paramString, "redirectTo");
      return;
      localObject = new AppBrandPage(getContext(), this);
      this.pageLinkedList.push(localObject);
    }
  }
  
  public void swichTab(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPageContainer", 4, "swichTab url=" + paramString);
    }
    cleanup(true);
    AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)this.pageLinkedList.peek();
    Object localObject = localAbsAppBrandPage;
    if (localAbsAppBrandPage == null)
    {
      localObject = new AppBrandPage(getContext(), this);
      ((AbsAppBrandPage)localObject).onCreate();
      this.pageLinkedList.push(localObject);
    }
    ((AbsAppBrandPage)localObject).loadUrl(paramString, "switchTab");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer
 * JD-Core Version:    0.7.0.1
 */