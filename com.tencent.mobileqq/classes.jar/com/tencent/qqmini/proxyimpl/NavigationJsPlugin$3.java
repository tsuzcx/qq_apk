package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

class NavigationJsPlugin$3
  implements Runnable
{
  NavigationJsPlugin$3(NavigationJsPlugin paramNavigationJsPlugin, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    MiniAppInfo.saveMiniAppShowInfoEntity(this.val$miniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */