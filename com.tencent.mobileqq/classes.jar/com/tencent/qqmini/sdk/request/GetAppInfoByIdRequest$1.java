package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdReq;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdRsp;
import bdtf;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class GetAppInfoByIdRequest$1
  implements Runnable
{
  public GetAppInfoByIdRequest$1(bdtf parambdtf, INTERFACE.StGetAppInfoByIdRsp paramStGetAppInfoByIdRsp) {}
  
  public void run()
  {
    MiniAppInfo.saveMiniAppByIdEntity(bdtf.a(this.this$0).firstPath.get(), this.a.appInfo);
    MiniAppInfo.saveMiniAppInfoEntity(this.a.appInfo);
    MiniAppInfo.saveMiniAppShowInfoEntity(this.a.appInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetAppInfoByIdRequest.1
 * JD-Core Version:    0.7.0.1
 */