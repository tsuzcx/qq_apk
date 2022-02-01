package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

class NavigationProxyImpl$1
  implements Runnable
{
  NavigationProxyImpl$1(NavigationProxyImpl paramNavigationProxyImpl, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    MiniAppInfo.saveMiniAppShowInfoEntity(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */