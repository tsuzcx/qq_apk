package com.tencent.mobileqq.microapp.appbrand.page;

import bisl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.apkg.g.a;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class AppBrandPageContainer$1
  implements g.a
{
  AppBrandPageContainer$1(AppBrandPageContainer paramAppBrandPageContainer, WeakReference paramWeakReference, String paramString1, String paramString2, bisl parambisl) {}
  
  public void onInitApkgInfo$76ec3a73(int paramInt, c paramc)
  {
    ThreadManager.getUIHandler().post(new AppBrandPageContainer.1.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer.1
 * JD-Core Version:    0.7.0.1
 */