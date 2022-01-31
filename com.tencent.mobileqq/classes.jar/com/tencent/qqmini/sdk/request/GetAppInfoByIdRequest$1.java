package com.tencent.qqmini.sdk.request;

import bezd;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class GetAppInfoByIdRequest$1
  implements Runnable
{
  public GetAppInfoByIdRequest$1(bezd parambezd, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).notifyMiniAppInfo(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetAppInfoByIdRequest.1
 * JD-Core Version:    0.7.0.1
 */