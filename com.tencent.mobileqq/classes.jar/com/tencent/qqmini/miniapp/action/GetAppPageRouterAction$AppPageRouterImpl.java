package com.tencent.qqmini.miniapp.action;

import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.IAppPageRouter;
import java.lang.ref.WeakReference;

class GetAppPageRouterAction$AppPageRouterImpl
  implements IAppPageRouter
{
  private final WeakReference<IAppBrandPageContainer> a;
  
  GetAppPageRouterAction$AppPageRouterImpl(IAppBrandPageContainer paramIAppBrandPageContainer)
  {
    this.a = new WeakReference(paramIAppBrandPageContainer);
  }
  
  public boolean navigateBack(int paramInt)
  {
    IAppBrandPageContainer localIAppBrandPageContainer = (IAppBrandPageContainer)this.a.get();
    if (localIAppBrandPageContainer != null) {
      return localIAppBrandPageContainer.navigateBack(paramInt, -1);
    }
    return false;
  }
  
  public void navigateTo(String paramString)
  {
    IAppBrandPageContainer localIAppBrandPageContainer = (IAppBrandPageContainer)this.a.get();
    if (localIAppBrandPageContainer != null) {
      localIAppBrandPageContainer.navigateTo(paramString, -1);
    }
  }
  
  public void reLaunch(String paramString)
  {
    IAppBrandPageContainer localIAppBrandPageContainer = (IAppBrandPageContainer)this.a.get();
    if (localIAppBrandPageContainer != null)
    {
      localIAppBrandPageContainer.cleanup(false);
      localIAppBrandPageContainer.launch(paramString, "reLaunch");
    }
  }
  
  public void redirectTo(String paramString)
  {
    IAppBrandPageContainer localIAppBrandPageContainer = (IAppBrandPageContainer)this.a.get();
    if (localIAppBrandPageContainer != null) {
      localIAppBrandPageContainer.redirectTo(paramString, -1);
    }
  }
  
  public void switchTab(String paramString)
  {
    IAppBrandPageContainer localIAppBrandPageContainer = (IAppBrandPageContainer)this.a.get();
    if (localIAppBrandPageContainer != null) {
      localIAppBrandPageContainer.switchTab(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.action.GetAppPageRouterAction.AppPageRouterImpl
 * JD-Core Version:    0.7.0.1
 */