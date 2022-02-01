package com.tencent.mobileqq.qqlive.api.impl.common;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.common.IQQLiveUserCard;
import com.tencent.mobileqq.qqlive.api.impl.IQQLiveBaseModule;
import com.tencent.mobileqq.qqlive.callback.common.IQQLiveUserCardInfoCallback;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.sso.QQLiveCallbackObserver;
import com.tencent.trpcprotocol.ilive.personalCardInfo.personalCardInfo.nano.GetUserinfoCardInfoReq;
import com.tencent.trpcprotocol.qlive.config_center_svr.config_center_svr.nano.VerifyGiftReq;

public class QQLiveUserCardImpl
  extends IQQLiveBaseModule
  implements IQQLiveUserCard
{
  private static final String TAG = "QQLiveUserCardImpl";
  
  public void destroy() {}
  
  public void getUserCardInfo(long paramLong, IQQLiveUserCardInfoCallback paramIQQLiveUserCardInfoCallback)
  {
    if ((this.sdkImpl != null) && (this.sdkImpl.getExtModule("sso_module") != null))
    {
      IQQLiveSsoModule localIQQLiveSsoModule = (IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module");
      GetUserinfoCardInfoReq localGetUserinfoCardInfoReq = new GetUserinfoCardInfoReq();
      localGetUserinfoCardInfoReq.a = paramLong;
      localIQQLiveSsoModule.a("trpc.qlive.personal_card_info.PersonalCardInfo", "GetUserinfoCardInfo", VerifyGiftReq.toByteArray(localGetUserinfoCardInfoReq), new QQLiveCallbackObserver(new QQLiveUserCardImpl.1(this, paramIQQLiveUserCardInfoCallback)));
    }
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.common.QQLiveUserCardImpl
 * JD-Core Version:    0.7.0.1
 */