package com.tencent.mobileqq.profilecommon.processor;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.api.IProfileHandlerApi;
import com.tencent.mobileqq.profilecommon.handler.ProfileCommonHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x587.oidb_0x587.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

public abstract class AbsProfileCommonProcessor
  implements IProfileDetailCallback, IProfileDetailPushCallback
{
  protected AppRuntime appRuntime;
  protected ProfileCommonHandler handler;
  
  public AbsProfileCommonProcessor(AppRuntime paramAppRuntime)
  {
    this.appRuntime = paramAppRuntime;
    this.handler = getProfileCommonHandler(paramAppRuntime);
  }
  
  private ProfileCommonHandler getProfileCommonHandler(AppRuntime paramAppRuntime)
  {
    String str = ((IProfileHandlerApi)QRoute.api(IProfileHandlerApi.class)).getProfileCommonHandler();
    return (ProfileCommonHandler)((AppInterface)paramAppRuntime).getBusinessHandler(str);
  }
  
  private void sendPbReq(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg.extraData.putString("processor_key", getProcessorKey());
    this.handler.sendPbReq(paramToServiceMsg);
  }
  
  public abstract String getProcessorKey();
  
  protected final void getProfileDetail(oidb_0x5eb.ReqBody paramReqBody, int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramReqBody = this.handler.makeOIDBPkg("OidbSvc.0x5eb_common", 1515, paramInt, paramReqBody.toByteArray());
    paramReqBody.extraData.putAll(localBundle);
    sendPbReq(paramReqBody);
  }
  
  protected final void getProfileDetail(oidb_0x5eb.ReqBody paramReqBody, Bundle paramBundle)
  {
    getProfileDetail(paramReqBody, 22, paramBundle);
  }
  
  public boolean interceptProfileModifyPush(int paramInt)
  {
    return false;
  }
  
  public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb.ReqBody paramReqBody)
  {
    return false;
  }
  
  public void onGetProfileDetailResponse(Bundle paramBundle, boolean paramBoolean, oidb_0x5eb.UdcUinData paramUdcUinData) {}
  
  public void onProcessProfileModifyPush(int paramInt, ByteStringMicro paramByteStringMicro) {}
  
  public void onProcessProfileModifyPushBegin(long paramLong) {}
  
  public void onProcessProfileModifyPushEnd() {}
  
  public void onSetProfileDetailResponse(Bundle paramBundle, boolean paramBoolean) {}
  
  protected final void setProfileDetail(oidb_0x587.ReqBody paramReqBody, int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramReqBody = this.handler.makeOIDBPkg("OidbSvc.0x587_common", 1415, paramInt, paramReqBody.toByteArray());
    paramReqBody.extraData.putAll(localBundle);
    sendPbReq(paramReqBody);
  }
  
  protected final void setProfileDetail(oidb_0x587.ReqBody paramReqBody, Bundle paramBundle)
  {
    setProfileDetail(paramReqBody, 74, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
 * JD-Core Version:    0.7.0.1
 */