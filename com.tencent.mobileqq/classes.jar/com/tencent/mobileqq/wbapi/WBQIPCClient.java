package com.tencent.mobileqq.wbapi;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.appcommon.Common;
import com.tencent.qphone.base.util.QLog;

public class WBQIPCClient
{
  public static void a(Runnable paramRunnable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("installWBSdk process=");
    localStringBuilder.append(Common.x());
    QLog.d("OpenSdkQIPCClient", 1, localStringBuilder.toString());
    QIPCClientHelper.getInstance().callServer("weibo_qipc_module", "action_install_weibo_sdk", new Bundle(), new WBQIPCClient.1(paramRunnable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.wbapi.WBQIPCClient
 * JD-Core Version:    0.7.0.1
 */