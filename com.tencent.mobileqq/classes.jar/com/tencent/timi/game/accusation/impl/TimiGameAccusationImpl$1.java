package com.tencent.timi.game.accusation.impl;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.teamlist.util.TimiNetErrorDisplayUtil;
import com.tencent.timi.game.utils.Logger;
import trpc.yes.common.SafeOuterClass.QQGetUserSafeSercetRsp;

final class TimiGameAccusationImpl$1
  implements RequestListener<SafeOuterClass.QQGetUserSafeSercetRsp>
{
  TimiGameAccusationImpl$1(AccusationParams paramAccusationParams) {}
  
  public void a(SafeOuterClass.QQGetUserSafeSercetRsp paramQQGetUserSafeSercetRsp, FromServiceMsg paramFromServiceMsg)
  {
    TimiGameAccusationImpl.a(paramQQGetUserSafeSercetRsp.aes_decrypt_key.get());
    this.a.d = paramQQGetUserSafeSercetRsp.uin_key.get();
    if (Env.b())
    {
      paramQQGetUserSafeSercetRsp = new StringBuilder();
      paramQQGetUserSafeSercetRsp.append("举报密钥&加密Uin获取成功 eviluin:");
      paramQQGetUserSafeSercetRsp.append(this.a.d);
      paramQQGetUserSafeSercetRsp.append("decypt key:");
      paramQQGetUserSafeSercetRsp.append(TimiGameAccusationImpl.a());
      Logger.b("TimiGameAccusationImpl", paramQQGetUserSafeSercetRsp.toString());
    }
    TimiGameAccusationImpl.b(this.a);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, @Nullable SafeOuterClass.QQGetUserSafeSercetRsp paramQQGetUserSafeSercetRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    TimiGameAccusationImpl.a(false);
    if (Env.b()) {
      Logger.b("TimiGameAccusationImpl", "举报密钥&加密Uin失败");
    }
    TimiNetErrorDisplayUtil.a("TimiGameAccusationImpl", paramInt2, paramInt3, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.accusation.impl.TimiGameAccusationImpl.1
 * JD-Core Version:    0.7.0.1
 */