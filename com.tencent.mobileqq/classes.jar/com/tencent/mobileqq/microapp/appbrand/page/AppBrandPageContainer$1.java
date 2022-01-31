package com.tencent.mobileqq.microapp.appbrand.page;

import bety;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.apkg.g.d;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class AppBrandPageContainer$1
  implements g.d
{
  AppBrandPageContainer$1(AppBrandPageContainer paramAppBrandPageContainer, WeakReference paramWeakReference, String paramString1, String paramString2, bety parambety) {}
  
  public void onInitApkgInfo(int paramInt, f paramf)
  {
    ThreadManager.getUIHandler().post(new AppBrandPageContainer.1.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer.1
 * JD-Core Version:    0.7.0.1
 */