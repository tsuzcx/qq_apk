package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;

public class ForwardMiniAppUpdatableMsgOption
  extends ForwardBaseOption
{
  public ForwardMiniAppUpdatableMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  private void a(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("miniAppShareIsComplete", true);
    localBundle.putInt("uintype", paramInt);
    localBundle.putString("uin", paramString);
    localBundle.putString("miniAppShareAppid", this.t.getString("miniAppShareAppid"));
    localBundle.putString("miniAppShareTemplateId", this.t.getString("miniAppShareTemplateId"));
    localBundle.putInt("miniAppShareUpdatableMsgFrom", this.t.getInt("miniAppShareUpdatableMsgFrom"));
    localBundle.putString("miniAppShareEvent", this.t.getString("miniAppShareEvent"));
    localBundle.putInt("miniAppShareCallbackId", this.t.getInt("miniAppShareCallbackId"));
    localBundle.putInt("miniAppShareSubScene", this.t.getInt("miniAppShareSubScene"));
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_create_updatable_msg_callback", localBundle, null);
  }
  
  private void b(int paramInt, String paramString)
  {
    paramString = AIOUtils.a(new Intent(this.s, SplashActivity.class), new int[] { 2 }).putExtra("uintype", paramInt).putExtra("uin", paramString);
    this.s.startActivity(paramString);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e("ForwardMiniAppUpdatableMsgOption", 2, "buildForwardDialog, error, extra is null");
      this.s.finish();
      return;
    }
    paramInt = paramBundle.getInt("uintype");
    String str = paramBundle.getString("uin");
    paramBundle = paramBundle.getString("uinname");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buildForwardDialog, name:");
    localStringBuilder.append(paramBundle);
    localStringBuilder.append(", uinType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", uin:");
    localStringBuilder.append(str);
    QLog.d("ForwardMiniAppUpdatableMsgOption", 2, localStringBuilder.toString());
    a(paramInt, str);
    b(paramInt, str);
    this.s.finish();
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("endForwardCallback, isCompleted:");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("ForwardMiniAppUpdatableMsgOption", 2, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("miniAppShareIsComplete", false);
    ((Bundle)localObject).putString("miniAppShareAppid", this.t.getString("miniAppShareAppid"));
    ((Bundle)localObject).putString("miniAppShareTemplateId", this.t.getString("miniAppShareTemplateId"));
    ((Bundle)localObject).putInt("miniAppShareUpdatableMsgFrom", this.t.getInt("miniAppShareUpdatableMsgFrom"));
    ((Bundle)localObject).putString("miniAppShareEvent", this.t.getString("miniAppShareEvent"));
    ((Bundle)localObject).putInt("miniAppShareCallbackId", this.t.getInt("miniAppShareCallbackId"));
    ((Bundle)localObject).putInt("miniAppShareSubScene", this.t.getInt("miniAppShareSubScene"));
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_create_updatable_msg_callback", (Bundle)localObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMiniAppUpdatableMsgOption
 * JD-Core Version:    0.7.0.1
 */