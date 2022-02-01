package com.tencent.mobileqq.guild.channel.create.dialog;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.fragment.QQGuildSubChannelCreateFragment;

public class QQGuildAppSubChannelCreateDialogFragment
  extends BaseDialogFragment
{
  public static QQGuildAppSubChannelCreateDialogFragment b(CreateSubChannelInfo paramCreateSubChannelInfo)
  {
    QQGuildAppSubChannelCreateDialogFragment localQQGuildAppSubChannelCreateDialogFragment = new QQGuildAppSubChannelCreateDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extra_key_subchannel_info", paramCreateSubChannelInfo);
    localQQGuildAppSubChannelCreateDialogFragment.setArguments(localBundle);
    return localQQGuildAppSubChannelCreateDialogFragment;
  }
  
  protected Fragment a(CreateSubChannelInfo paramCreateSubChannelInfo)
  {
    paramCreateSubChannelInfo = QQGuildSubChannelCreateFragment.a(paramCreateSubChannelInfo);
    paramCreateSubChannelInfo.a(this);
    return paramCreateSubChannelInfo;
  }
  
  protected boolean f()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.dialog.QQGuildAppSubChannelCreateDialogFragment
 * JD-Core Version:    0.7.0.1
 */