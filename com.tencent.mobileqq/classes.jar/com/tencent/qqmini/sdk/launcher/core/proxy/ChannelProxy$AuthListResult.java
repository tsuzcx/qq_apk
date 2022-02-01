package com.tencent.qqmini.sdk.launcher.core.proxy;

import com.tencent.qqmini.sdk.launcher.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.launcher.core.auth.UserSettingInfo;
import java.util.List;

public abstract interface ChannelProxy$AuthListResult
{
  public abstract void onReceiveResult(boolean paramBoolean, List<UserAuthInfo> paramList, List<UserSettingInfo> paramList1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.AuthListResult
 * JD-Core Version:    0.7.0.1
 */