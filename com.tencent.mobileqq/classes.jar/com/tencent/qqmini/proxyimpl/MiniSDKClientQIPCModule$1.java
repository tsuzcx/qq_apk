package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class MiniSDKClientQIPCModule$1
  extends CmdCallback.Stub
{
  MiniSDKClientQIPCModule$1(MiniSDKClientQIPCModule paramMiniSDKClientQIPCModule, BaseRuntime paramBaseRuntime, String paramString1, String paramString2, String paramString3, int paramInt, RequestEvent paramRequestEvent) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("shareJson");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleDirectShareSucCallback shareJsonString after = ");
    localStringBuilder.append(paramBundle);
    QLog.d("MiniSDKClientQIPCModule", 1, localStringBuilder.toString());
    MiniSDKClientQIPCModule.a(this.g, this.a, this.b, this.c, this.d, paramBundle, this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.1
 * JD-Core Version:    0.7.0.1
 */