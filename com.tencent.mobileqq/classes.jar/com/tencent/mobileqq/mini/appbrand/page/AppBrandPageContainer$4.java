package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.WebviewPool;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class AppBrandPageContainer$4
  implements Runnable
{
  AppBrandPageContainer$4(AppBrandPageContainer paramAppBrandPageContainer) {}
  
  public void run()
  {
    int i = 0;
    int j = 1;
    QLog.i("AppBrandPageContainer", 1, "custom_event_PAGE_EVENT __DOMReady AppBrandPageContainer");
    if (AppBrandPageContainer.access$200(this.this$0) != null)
    {
      this.this$0.appBrandRuntime.webviewPool.recyclePageWebview(AppBrandPageContainer.access$200(this.this$0).getCurrentPageWebview(), BaseApplicationImpl.sApplication);
      AppBrandPageContainer.access$200(this.this$0).cleanup();
      this.this$0.pageLinkedList.remove(AppBrandPageContainer.access$200(this.this$0));
      AppBrandPageContainer.access$202(this.this$0, null);
    }
    Object localObject;
    if ((this.this$0.appBrandRuntime != null) && (this.this$0.appBrandRuntime.getCurPage() != null) && (this.this$0.appBrandRuntime.getCurPage().getNavBar() != null))
    {
      localObject = this.this$0.appBrandRuntime.getCurPage().getNavBar();
      if (this.this$0.pageLinkedList.size() <= 1) {
        break label203;
      }
    }
    label203:
    for (boolean bool = true;; bool = false)
    {
      ((NavigationBar)localObject).setEnableBackIcon(bool);
      localObject = this.this$0.appBrandRuntime.getCurPage();
      if (this.this$0.pageLinkedList.size() == 1) {
        i = 1;
      }
      if (i != 0) {
        j = 2;
      }
      ((AbsAppBrandPage)localObject).setScrollDirection(j);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer.4
 * JD-Core Version:    0.7.0.1
 */