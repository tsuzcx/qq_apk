package com.tencent.timi.game.smoba.impl.util;

import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.AuthToGetSmobaInfoCallback;
import com.tencent.timi.game.smoba.api.SmobaCheckCallback;
import com.tencent.timi.game.utils.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.AgreeSmobaAuthRsp;

final class SmobaUtil$2
  implements IUserSmobaInfoService.AuthToGetSmobaInfoCallback
{
  SmobaUtil$2(SmobaCheckCallback paramSmobaCheckCallback) {}
  
  public void a()
  {
    Logger.a("SmobaUtil", "showAuthHintDialog - authCancel");
    SmobaUtil.a(this.a, "授权取消");
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showAuthHintDialog - authFailed, ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" - ");
    ((StringBuilder)localObject).append(paramString);
    Logger.a("SmobaUtil", ((StringBuilder)localObject).toString());
    localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("授权失败，");
    localStringBuilder.append(paramString);
    SmobaUtil.a((SmobaCheckCallback)localObject, localStringBuilder.toString());
  }
  
  public void a(@NotNull GameDataServerOuterClass.AgreeSmobaAuthRsp paramAgreeSmobaAuthRsp)
  {
    Logger.a("SmobaUtil", "showAuthHintDialog - authSucceed");
  }
  
  public void b()
  {
    Logger.a("SmobaUtil", "showAuthHintDialog - onDialogShow");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.SmobaUtil.2
 * JD-Core Version:    0.7.0.1
 */