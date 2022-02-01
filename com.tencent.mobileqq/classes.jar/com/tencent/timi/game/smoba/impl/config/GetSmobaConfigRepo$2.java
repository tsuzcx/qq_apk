package com.tencent.timi.game.smoba.impl.config;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.utils.Logger;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaConfigRsp;

class GetSmobaConfigRepo$2
  implements RequestListener<GameDataServerOuterClass.GetSmobaConfigRsp>
{
  GetSmobaConfigRepo$2(GetSmobaConfigRepo paramGetSmobaConfigRepo) {}
  
  public void a(GameDataServerOuterClass.GetSmobaConfigRsp paramGetSmobaConfigRsp, FromServiceMsg paramFromServiceMsg)
  {
    GetSmobaConfigRepo.a(this.a, paramGetSmobaConfigRsp);
    paramGetSmobaConfigRsp = Base64Util.encodeToString(paramGetSmobaConfigRsp.toByteArray(), 0);
    SharePreferenceUtils.a(BaseApplication.getContext(), "GetSmobaConfigRepo", paramGetSmobaConfigRsp);
    Logger.b("GetSmobaConfigRepo_", "smobaConfigRsp数据Server");
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, @Nullable GameDataServerOuterClass.GetSmobaConfigRsp paramGetSmobaConfigRsp, @Nullable FromServiceMsg paramFromServiceMsg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.config.GetSmobaConfigRepo.2
 * JD-Core Version:    0.7.0.1
 */