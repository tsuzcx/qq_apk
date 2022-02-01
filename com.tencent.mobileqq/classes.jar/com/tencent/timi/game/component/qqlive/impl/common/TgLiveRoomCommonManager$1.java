package com.tencent.timi.game.component.qqlive.impl.common;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;

class TgLiveRoomCommonManager$1
  implements IQQLiveLoginCallback
{
  TgLiveRoomCommonManager$1(TgLiveRoomCommonManager paramTgLiveRoomCommonManager, IResultListener paramIResultListener) {}
  
  public void onFailed(int paramInt, String paramString)
  {
    TgLiveRoomCommonManager.a(this.b).getLoginModule().unregisterLoginStateCallback(this);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initLiveSDK login fail - ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramString);
    Logger.c("TgLiveTag_TgLiveRoomCommonManager", 1, ((StringBuilder)localObject).toString());
    TgLiveRoomCommonManager.a(this.b, false);
    TgLiveRoomCommonManager.b(this.b, false);
    TgLiveRoomCommonManager.b(this.b).postValue(Boolean.valueOf(false));
    TgLiveRoomCommonManager.d(this.b);
    localObject = this.a;
    if (localObject != null) {
      ((IResultListener)localObject).a(paramInt, paramString);
    }
  }
  
  public void onSuccess(LoginInfo paramLoginInfo)
  {
    TgLiveRoomCommonManager.a(this.b).getLoginModule().unregisterLoginStateCallback(this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initLiveSDK login success - ");
    localStringBuilder.append(paramLoginInfo);
    Logger.a("TgLiveTag_TgLiveRoomCommonManager", 1, localStringBuilder.toString());
    TgLiveRoomCommonManager.a(this.b, false);
    TgLiveRoomCommonManager.b(this.b, true);
    TgLiveRoomCommonManager.b(this.b).postValue(Boolean.valueOf(true));
    paramLoginInfo = this.a;
    if (paramLoginInfo != null) {
      paramLoginInfo.a(Boolean.valueOf(TgLiveRoomCommonManager.c(this.b)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomCommonManager.1
 * JD-Core Version:    0.7.0.1
 */