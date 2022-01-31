package com.tencent.mobileqq.mini.appbrand;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import java.util.ArrayList;

class AppBrandRuntime$5
  implements Runnable
{
  AppBrandRuntime$5(AppBrandRuntime paramAppBrandRuntime) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.this$0.apkgInfo.appId);
    MiniAppCmdUtil.getInstance().getBatchQueryAppInfo(null, localArrayList, new AppBrandRuntime.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.5
 * JD-Core Version:    0.7.0.1
 */