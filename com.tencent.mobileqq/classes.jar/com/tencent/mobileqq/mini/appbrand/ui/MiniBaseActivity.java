package com.tencent.mobileqq.mini.appbrand.ui;

import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResultCallback;

public class MiniBaseActivity
  extends BaseActivity
{
  private EIPCResultCallback mEIPCResultCallback = new MiniBaseActivity.1(this);
  
  protected void doRefreshMiniBadge(Bundle paramBundle) {}
  
  protected void onProcessBackground(Bundle paramBundle)
  {
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_proc_backgound", paramBundle, this.mEIPCResultCallback);
  }
  
  protected void onProcessForeGround(Bundle paramBundle)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onProcessForeGround");
      localStringBuilder.append(paramBundle.toString());
      QLog.i("MiniMsgIPCServer", 4, localStringBuilder.toString());
    }
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_proc_foregound", paramBundle, this.mEIPCResultCallback);
  }
  
  protected void onRefreshMiniBadge(Bundle paramBundle)
  {
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_refresh_mini_badge", paramBundle, this.mEIPCResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.MiniBaseActivity
 * JD-Core Version:    0.7.0.1
 */