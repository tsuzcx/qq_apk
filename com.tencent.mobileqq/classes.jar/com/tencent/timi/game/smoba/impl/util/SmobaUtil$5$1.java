package com.tencent.timi.game.smoba.impl.util;

import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import com.tencent.timi.game.utils.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

class SmobaUtil$5$1
  implements IUserSmobaInfoService.BindSmobaAccountCallback
{
  SmobaUtil$5$1(SmobaUtil.5 param5) {}
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkIsGangupAvaliable - ");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append(", showChangeAccountTipsDialog#bindCancel");
    Logger.c("SmobaUtil", localStringBuilder.toString());
    SmobaUtil.a(this.a.b, this.a.c);
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkIsGangupAvaliable - ");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append(", showChangeAccountTipsDialog#bindFailed - ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramString);
    Logger.c("SmobaUtil", localStringBuilder.toString());
    SmobaUtil.a(this.a.b, this.a.c);
  }
  
  public void a(@NotNull GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    SmobaUtil.a(this.a.a, this.a.d, this.a.e, this.a.b);
  }
  
  public void b()
  {
    Logger.a("SmobaUtil", "checkIsGangupAvaliable - onDialogShow");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.SmobaUtil.5.1
 * JD-Core Version:    0.7.0.1
 */