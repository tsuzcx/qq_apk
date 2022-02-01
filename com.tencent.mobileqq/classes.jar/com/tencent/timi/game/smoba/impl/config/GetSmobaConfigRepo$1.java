package com.tencent.timi.game.smoba.impl.config;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.utils.Logger;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaConfigRsp;

class GetSmobaConfigRepo$1
  implements Runnable
{
  GetSmobaConfigRepo$1(GetSmobaConfigRepo paramGetSmobaConfigRepo) {}
  
  public void run()
  {
    Object localObject = SharePreferenceUtils.a(BaseApplication.getContext(), "GetSmobaConfigRepo");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = (GameDataServerOuterClass.GetSmobaConfigRsp)GameDataServerOuterClass.GetSmobaConfigRsp.mergeFrom(new GameDataServerOuterClass.GetSmobaConfigRsp(), Base64Util.decode((String)localObject, 0));
      GetSmobaConfigRepo.a(this.this$0, (GameDataServerOuterClass.GetSmobaConfigRsp)localObject);
      Logger.b("GetSmobaConfigRepo_", "smobaConfigRsp数据DB");
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      label52:
      break label52;
    }
    Logger.c("GetSmobaConfigRepo_", "smobaConfigRsp数据不匹配PB协议");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.config.GetSmobaConfigRepo.1
 * JD-Core Version:    0.7.0.1
 */