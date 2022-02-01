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
    localBundle.putString("miniAppShareAppid", this.jdField_a_of_type_AndroidOsBundle.getString("miniAppShareAppid"));
    localBundle.putString("miniAppShareTemplateId", this.jdField_a_of_type_AndroidOsBundle.getString("miniAppShareTemplateId"));
    localBundle.putInt("miniAppShareUpdatableMsgFrom", this.jdField_a_of_type_AndroidOsBundle.getInt("miniAppShareUpdatableMsgFrom"));
    localBundle.putString("miniAppShareEvent", this.jdField_a_of_type_AndroidOsBundle.getString("miniAppShareEvent"));
    localBundle.putInt("miniAppShareCallbackId", this.jdField_a_of_type_AndroidOsBundle.getInt("miniAppShareCallbackId"));
    localBundle.putInt("miniAppShareSubScene", this.jdField_a_of_type_AndroidOsBundle.getInt("miniAppShareSubScene"));
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_create_updatable_msg_callback", localBundle, null);
  }
  
  private void b(int paramInt, String paramString)
  {
    paramString = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), new int[] { 2 }).putExtra("uintype", paramInt).putExtra("uin", paramString);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e("ForwardMiniAppUpdatableMsgOption", 2, "buildForwardDialog, error, extra is null");
      this.jdField_a_of_type_AndroidAppActivity.finish();
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
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("endForwardCallback, isCompleted:");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("ForwardMiniAppUpdatableMsgOption", 2, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("miniAppShareIsComplete", false);
    ((Bundle)localObject).putString("miniAppShareAppid", this.jdField_a_of_type_AndroidOsBundle.getString("miniAppShareAppid"));
    ((Bundle)localObject).putString("miniAppShareTemplateId", this.jdField_a_of_type_AndroidOsBundle.getString("miniAppShareTemplateId"));
    ((Bundle)localObject).putInt("miniAppShareUpdatableMsgFrom", this.jdField_a_of_type_AndroidOsBundle.getInt("miniAppShareUpdatableMsgFrom"));
    ((Bundle)localObject).putString("miniAppShareEvent", this.jdField_a_of_type_AndroidOsBundle.getString("miniAppShareEvent"));
    ((Bundle)localObject).putInt("miniAppShareCallbackId", this.jdField_a_of_type_AndroidOsBundle.getInt("miniAppShareCallbackId"));
    ((Bundle)localObject).putInt("miniAppShareSubScene", this.jdField_a_of_type_AndroidOsBundle.getInt("miniAppShareSubScene"));
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_create_updatable_msg_callback", (Bundle)localObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMiniAppUpdatableMsgOption
 * JD-Core Version:    0.7.0.1
 */