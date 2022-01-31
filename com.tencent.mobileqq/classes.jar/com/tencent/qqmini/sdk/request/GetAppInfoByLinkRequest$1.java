package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByLinkReq;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByLinkRsp;
import bdtg;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class GetAppInfoByLinkRequest$1
  implements Runnable
{
  public GetAppInfoByLinkRequest$1(bdtg parambdtg, INTERFACE.StGetAppInfoByLinkRsp paramStGetAppInfoByLinkRsp) {}
  
  public void run()
  {
    MiniAppInfo.saveMiniAppByLinkEntity(bdtg.a(this.this$0).link.get(), bdtg.a(this.this$0).linkType.get(), this.a.shareTicket.get(), this.a.appInfo);
    MiniAppInfo.saveMiniAppInfoEntity(this.a.appInfo);
    MiniAppInfo.saveMiniAppShowInfoEntity(this.a.appInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetAppInfoByLinkRequest.1
 * JD-Core Version:    0.7.0.1
 */