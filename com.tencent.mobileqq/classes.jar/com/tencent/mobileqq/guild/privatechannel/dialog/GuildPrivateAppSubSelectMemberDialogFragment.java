package com.tencent.mobileqq.guild.privatechannel.dialog;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment;
import com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.UserInfoUIData;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;

public class GuildPrivateAppSubSelectMemberDialogFragment
  extends BaseDialogFragment
{
  protected IGProGuildInfo h;
  protected GuildPrivateMemberListAdapter.UserInfoUIData[] i;
  protected String[] j;
  protected GuildPrivateAppSubSelectMemberDialogFragment.OnMemberSelectCallback k;
  
  public static GuildPrivateAppSubSelectMemberDialogFragment a(CreateSubChannelInfo paramCreateSubChannelInfo, AppInterface paramAppInterface, String[] paramArrayOfString, GuildPrivateMemberListAdapter.UserInfoUIData[] paramArrayOfUserInfoUIData, GuildPrivateAppSubSelectMemberDialogFragment.OnMemberSelectCallback paramOnMemberSelectCallback)
  {
    GuildPrivateAppSubSelectMemberDialogFragment localGuildPrivateAppSubSelectMemberDialogFragment = new GuildPrivateAppSubSelectMemberDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_guild_guild_info", ((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).getGuildInfo(paramCreateSubChannelInfo.a));
    if (paramArrayOfString != null) {
      localBundle.putStringArray("selected_list", paramArrayOfString);
    }
    if (paramArrayOfUserInfoUIData != null) {
      localBundle.putSerializable("select_member_info_list", paramArrayOfUserInfoUIData);
    }
    localBundle.putParcelable("extra_key_subchannel_info", paramCreateSubChannelInfo);
    localGuildPrivateAppSubSelectMemberDialogFragment.setArguments(localBundle);
    localGuildPrivateAppSubSelectMemberDialogFragment.b(paramOnMemberSelectCallback);
    return localGuildPrivateAppSubSelectMemberDialogFragment;
  }
  
  protected Fragment a(CreateSubChannelInfo paramCreateSubChannelInfo)
  {
    paramCreateSubChannelInfo = GuildPrivateSubSelectMemberFragment.a(paramCreateSubChannelInfo, this.h, this.j, this.i, this.k);
    paramCreateSubChannelInfo.a(this);
    return paramCreateSubChannelInfo;
  }
  
  public void b(GuildPrivateAppSubSelectMemberDialogFragment.OnMemberSelectCallback paramOnMemberSelectCallback)
  {
    this.k = paramOnMemberSelectCallback;
  }
  
  protected boolean f()
  {
    return true;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    this.h = ((IGProGuildInfo)paramBundle.getSerializable("extra_guild_guild_info"));
    this.i = ((GuildPrivateMemberListAdapter.UserInfoUIData[])paramBundle.getSerializable("select_member_info_list"));
    this.j = paramBundle.getStringArray("selected_list");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.dialog.GuildPrivateAppSubSelectMemberDialogFragment
 * JD-Core Version:    0.7.0.1
 */