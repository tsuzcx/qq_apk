package com.tencent.qqmini.sdk.request;

import beze;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class GetAppInfoByLinkRequest$1
  implements Runnable
{
  public GetAppInfoByLinkRequest$1(beze parambeze, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).notifyMiniAppInfo(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetAppInfoByLinkRequest.1
 * JD-Core Version:    0.7.0.1
 */