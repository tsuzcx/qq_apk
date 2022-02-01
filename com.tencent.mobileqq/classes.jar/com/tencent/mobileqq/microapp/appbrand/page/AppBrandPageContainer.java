package com.tencent.mobileqq.microapp.appbrand.page;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.b.h;
import com.tencent.mobileqq.microapp.widget.TabBarView.b;
import com.tencent.mobileqq.widget.QQProgressDialog;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bringToFront page=");
      localStringBuilder.append(paramAbsAppBrandPage);
      localStringBuilder.append(",viewAnim=");
      localStringBuilder.append(paramBoolean);
      QLog.d("AppBrandPageContainer", 4, localStringBuilder.toString());
    }
    if (paramAbsAppBrandPage == null) {
      return;
    }
    this.pageLinkedList.remove(paramAbsAppBrandPage);
    this.pageLinkedList.push(paramAbsAppBrandPage);
    requestLayout();
    invalidate();
    paramAbsAppBrandPage.onPageForeground();
  }
  
  private void executeDownSubPack(String paramString1, String paramString2)
  {
    WeakReference localWeakReference = new WeakReference(this);
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(getContext());
    localQQProgressDialog.a("正在加载模块...");
    localQQProgressDialog.setCancelable(false);
    localQQProgressDialog.show();
    this.appBrandRuntime.c.a(paramString1, new AppBrandPageContainer.1(this, localWeakReference, paramString2, paramString1, localQQProgressDialog));
  }
  
  private boolean isUrlResReady(String paramString)
  {
    return this.appBrandRuntime.c.c(paramString);
  }
  
  public final void cleanup(boolean paramBoolean)
  {
    Object localObject = this.pageLinkedList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)((Iterator)localObject).next();
      if ((!paramBoolean) || (!localAbsAppBrandPage.isTabPage()))
      {
        h.a().a(localAbsAppBrandPage.getCurrentPageWebview(), BaseApplicationImpl.sApplication);
        localAbsAppBrandPage.cleanup();
        ((Iterator)localObject).remove();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cleanup keepTabPage=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",pageLinkedList size=");
      ((StringBuilder)localObject).append(this.pageLinkedList.size());
      QLog.d("AppBrandPageContainer", 4, ((StringBuilder)localObject).toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrentPage page=");
      localStringBuilder.append(localAbsAppBrandPage);
      localStringBuilder.append(",this=");
      localStringBuilder.append(this);
      QLog.d("AppBrandPageContainer", 4, localStringBuilder.toString());
    }
    return localAbsAppBrandPage;
  }
  
  public PageWebview getCurrentPageWebview()
  {
    AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)this.pageLinkedList.peek();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrentPageWebview page=");
      localStringBuilder.append(localAbsAppBrandPage);
      QLog.d("AppBrandPageContainer", 4, localStringBuilder.toString());
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
    Object localObject = this.pageLinkedList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localAbsAppBrandPage = (AbsAppBrandPage)((Iterator)localObject).next();
      if (localAbsAppBrandPage.getWebView(paramInt) != null) {
        break label40;
      }
    }
    AbsAppBrandPage localAbsAppBrandPage = null;
    label40:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getPageByWebViewId webviewId=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",page=");
      ((StringBuilder)localObject).append(localAbsAppBrandPage);
      QLog.d("AppBrandPageContainer", 4, ((StringBuilder)localObject).toString());
    }
    return localAbsAppBrandPage;
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("launch type=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",url=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",currPageCount=");
      ((StringBuilder)localObject).append(getPageCount());
      QLog.d("AppBrandPageContainer", 4, ((StringBuilder)localObject).toString());
    }
    if (!isUrlResReady(paramString1))
    {
      executeDownSubPack(paramString1, paramString2);
      return;
    }
    Object localObject = new AppBrandPage(getContext(), this);
    this.pageLinkedList.push(localObject);
    ((AppBrandPage)localObject).onCreate();
    ((AppBrandPage)localObject).loadUrl(paramString1, paramString2);
  }
  
  public void navigateBack(int paramInt, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("navigateBack delta=");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",viewAnim=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("AppBrandPageContainer", 4, ((StringBuilder)localObject1).toString());
    }
    int j = getPageCount();
    if (j >= 2)
    {
      if (paramInt < 1) {
        return;
      }
      int i = paramInt;
      if (paramInt >= j) {
        i = j - 1;
      }
      localObject1 = this.pageLinkedList.iterator();
      paramInt = 0;
      while ((paramInt < i) && (this.pageLinkedList.size() >= 1))
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AbsAppBrandPage)((Iterator)localObject1).next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("navigateBack clearPage=");
          localStringBuilder.append(localObject2);
          QLog.d("AppBrandPageContainer", 4, localStringBuilder.toString());
          h.a().a(((AbsAppBrandPage)localObject2).getCurrentPageWebview(), BaseApplicationImpl.sApplication);
          ((AbsAppBrandPage)localObject2).cleanup();
          ((Iterator)localObject1).remove();
        }
        paramInt += 1;
      }
      localObject1 = (AbsAppBrandPage)this.pageLinkedList.peek();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("navigateBack backPage=");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("AppBrandPageContainer", 4, ((StringBuilder)localObject2).toString());
      if (localObject1 != null)
      {
        ((AbsAppBrandPage)localObject1).onPageForeground();
        ((AbsAppBrandPage)localObject1).onAppRoute("navigateBack", ((AbsAppBrandPage)localObject1).getUrl());
      }
    }
  }
  
  public void navigateTo(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("navigateTo url=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AppBrandPageContainer", 4, ((StringBuilder)localObject).toString());
    }
    if (!isUrlResReady(paramString))
    {
      executeDownSubPack(paramString, "navigateTo");
      return;
    }
    Object localObject = new AppBrandPage(getContext(), this);
    this.pageLinkedList.push(localObject);
    ((AppBrandPage)localObject).onCreate();
    ((AppBrandPage)localObject).loadUrl(paramString, "navigateTo");
  }
  
  public void onTabItemClick(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTabItemClick pagePath=");
      localStringBuilder.append(paramString);
      QLog.d("AppBrandPageContainer", 4, localStringBuilder.toString());
    }
    swichTab(paramString);
  }
  
  public void redirectTo(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("redirectTo url=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AppBrandPageContainer", 4, ((StringBuilder)localObject).toString());
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
    else
    {
      localObject = new AppBrandPage(getContext(), this);
      this.pageLinkedList.push(localObject);
    }
    ((AbsAppBrandPage)localObject).onCreate();
    ((AbsAppBrandPage)localObject).loadUrl(paramString, "redirectTo");
  }
  
  public void swichTab(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("swichTab url=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AppBrandPageContainer", 4, ((StringBuilder)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer
 * JD-Core Version:    0.7.0.1
 */