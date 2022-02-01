package com.tencent.timi.game.smoba.impl.util;

import android.app.Activity;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import com.tencent.timi.game.smoba.api.SmobaCheckCallback;
import com.tencent.timi.game.smoba.api.SmobaGangupCheckParam;
import com.tencent.timi.game.utils.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

final class SmobaUtil$3
  implements IUserSmobaInfoService.BindSmobaAccountCallback
{
  SmobaUtil$3(SmobaCheckCallback paramSmobaCheckCallback, Activity paramActivity, SmobaGangupCheckParam paramSmobaGangupCheckParam, boolean paramBoolean) {}
  
  public void a()
  {
    Logger.a("SmobaUtil", "showAuthHintDialog - bindCancel");
    SmobaUtil.a(this.a, "绑定帐号取消");
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showAuthHintDialog - bindFailed, ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" - ");
    ((StringBuilder)localObject).append(paramString);
    Logger.a("SmobaUtil", ((StringBuilder)localObject).toString());
    localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("绑定帐号失败，");
    localStringBuilder.append(paramString);
    SmobaUtil.a((SmobaCheckCallback)localObject, localStringBuilder.toString());
  }
  
  public void a(@NotNull GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    Logger.a("SmobaUtil", "showAuthHintDialog - bindSucceed");
    SmobaUtil.a(this.b, this.c, this.d, this.a);
  }
  
  public void b()
  {
    Logger.a("SmobaUtil", "showAuthHintDialog - onDialogShow");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.SmobaUtil.3
 * JD-Core Version:    0.7.0.1
 */