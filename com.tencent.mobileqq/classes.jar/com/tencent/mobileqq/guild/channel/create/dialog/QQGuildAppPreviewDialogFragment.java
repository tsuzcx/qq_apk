package com.tencent.mobileqq.guild.channel.create.dialog;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.fragment.QQGuildAppPreviewFragment;

public class QQGuildAppPreviewDialogFragment
  extends BaseDialogFragment
{
  public static QQGuildAppPreviewDialogFragment b(CreateSubChannelInfo paramCreateSubChannelInfo)
  {
    QQGuildAppPreviewDialogFragment localQQGuildAppPreviewDialogFragment = new QQGuildAppPreviewDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extra_key_subchannel_info", paramCreateSubChannelInfo);
    localQQGuildAppPreviewDialogFragment.setArguments(localBundle);
    return localQQGuildAppPreviewDialogFragment;
  }
  
  protected Fragment a(CreateSubChannelInfo paramCreateSubChannelInfo)
  {
    paramCreateSubChannelInfo = QQGuildAppPreviewFragment.a(paramCreateSubChannelInfo);
    paramCreateSubChannelInfo.a(this);
    return paramCreateSubChannelInfo;
  }
  
  protected boolean f()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.dialog.QQGuildAppPreviewDialogFragment
 * JD-Core Version:    0.7.0.1
 */