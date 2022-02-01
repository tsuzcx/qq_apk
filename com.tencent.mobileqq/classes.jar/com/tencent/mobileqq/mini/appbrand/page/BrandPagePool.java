package com.tencent.mobileqq.mini.appbrand.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BrandPagePool
{
  private static BrandPagePool instance;
  private static byte[] lock = new byte[0];
  final ConcurrentLinkedQueue<AppBrandPage> mBrandPageList = new ConcurrentLinkedQueue();
  private View mLoadingRootView;
  
  public static BrandPagePool g()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new BrandPagePool();
      }
      return instance;
    }
  }
  
  public void cleanup()
  {
    this.mBrandPageList.clear();
  }
  
  public AppBrandPage createBrandPage(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    return new AppBrandPage(paramContext, paramAppBrandRuntime);
  }
  
  public View getLoadingRootView()
  {
    View localView2 = this.mLoadingRootView;
    this.mLoadingRootView = null;
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131559375, null);
    }
    return localView1;
  }
  
  public AppBrandPage obtainBrandPage(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppBrandPage localAppBrandPage2 = (AppBrandPage)this.mBrandPageList.poll();
    AppBrandPage localAppBrandPage1 = localAppBrandPage2;
    if (localAppBrandPage2 == null) {
      localAppBrandPage1 = createBrandPage(paramContext, paramAppBrandRuntime);
    }
    return localAppBrandPage1;
  }
  
  public void preloadBrandPage(Context paramContext)
  {
    if ((this.mBrandPageList.size() > 0) || (paramContext == null)) {
      return;
    }
    paramContext = createBrandPage(paramContext, null);
    this.mBrandPageList.add(paramContext);
  }
  
  public void preloadBrandPage(AppBrandRuntime paramAppBrandRuntime)
  {
    if ((this.mBrandPageList.size() > 0) || (paramAppBrandRuntime == null) || (paramAppBrandRuntime.activity == null)) {
      return;
    }
    ThreadManager.excute(new BrandPagePool.1(this, paramAppBrandRuntime), 16, null, false);
  }
  
  public void preloadLoadingUI()
  {
    if (this.mLoadingRootView != null) {
      return;
    }
    this.mLoadingRootView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131559375, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.BrandPagePool
 * JD-Core Version:    0.7.0.1
 */