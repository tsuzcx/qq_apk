package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment;
import com.tencent.mobileqq.guild.mainframe.helper.JoinGuildParam;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;

public class JoinGuildVoiceChannelWindow
  extends BaseDialogFragment
{
  protected JoinGuildParam g;
  protected IGProGuildInfo h;
  protected IGProChannelInfo i;
  protected boolean j;
  
  public static JoinGuildVoiceChannelWindow a(JoinGuildParam paramJoinGuildParam, IGProGuildInfo paramIGProGuildInfo, IGProChannelInfo paramIGProChannelInfo, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_guild_guild_info", paramIGProGuildInfo);
    localBundle.putSerializable("extra_guild_channel_info", paramIGProChannelInfo);
    localBundle.putSerializable("extra_key_join_guild_params", paramJoinGuildParam);
    localBundle.putBoolean("extra_key_is_need_join_guild", paramBoolean);
    paramJoinGuildParam = new JoinGuildVoiceChannelWindow();
    paramJoinGuildParam.setArguments(localBundle);
    return paramJoinGuildParam;
  }
  
  protected Fragment a(CreateSubChannelInfo paramCreateSubChannelInfo)
  {
    paramCreateSubChannelInfo = JoinGuildVoiceChannelFrag.d.a(this.g, this.h, this.i, this.j);
    paramCreateSubChannelInfo.a(this);
    return paramCreateSubChannelInfo;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    this.g = ((JoinGuildParam)paramBundle.getSerializable("extra_key_join_guild_params"));
    this.h = ((IGProGuildInfo)paramBundle.getSerializable("extra_guild_guild_info"));
    this.i = ((IGProChannelInfo)paramBundle.getSerializable("extra_guild_channel_info"));
    this.j = ((Boolean)paramBundle.getSerializable("extra_key_is_need_join_guild")).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.jump.JoinGuildVoiceChannelWindow
 * JD-Core Version:    0.7.0.1
 */