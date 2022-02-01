package com.tencent.mobileqq.guild.channel.create.dialog;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.fragment.QQGuildSubChannelCreateMainFragment;

public class QQGuildSubChannelCreateMainDialogFragment
  extends BaseDialogFragment
{
  public static QQGuildSubChannelCreateMainDialogFragment b(CreateSubChannelInfo paramCreateSubChannelInfo)
  {
    QQGuildSubChannelCreateMainDialogFragment localQQGuildSubChannelCreateMainDialogFragment = new QQGuildSubChannelCreateMainDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extra_key_subchannel_info", paramCreateSubChannelInfo);
    localQQGuildSubChannelCreateMainDialogFragment.setArguments(localBundle);
    return localQQGuildSubChannelCreateMainDialogFragment;
  }
  
  protected Fragment a(CreateSubChannelInfo paramCreateSubChannelInfo)
  {
    paramCreateSubChannelInfo = QQGuildSubChannelCreateMainFragment.a(paramCreateSubChannelInfo);
    paramCreateSubChannelInfo.a(this);
    return paramCreateSubChannelInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.dialog.QQGuildSubChannelCreateMainDialogFragment
 * JD-Core Version:    0.7.0.1
 */