package com.tencent.mobileqq.guild.util;

import com.tencent.mobileqq.guild.data.QQGuildDTConstant;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.util.livedata.LiveDataExtKt;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.HashMap;

public class GuildLiveDtUtil
{
  private HashMap<String, Object> a = new HashMap();
  
  public GuildLiveDtUtil(IGProChannelInfo paramIGProChannelInfo, IGProGuildInfo paramIGProGuildInfo)
  {
    if (paramIGProChannelInfo != null)
    {
      if (paramIGProGuildInfo == null) {
        return;
      }
      boolean bool = ((Boolean)LiveDataExtKt.a(QQGuildLiveRoomUiData.a().b(), Boolean.valueOf(false))).booleanValue();
      int j = 1;
      int i;
      if (bool) {
        i = 1;
      } else {
        i = 2;
      }
      if (paramIGProChannelInfo.getLiveRoomId() > 0L) {
        j = 2;
      }
      this.a.put("sgrp_stream_status", Integer.valueOf(j));
      this.a.put("sgrp_stream_aio_type", Integer.valueOf(i));
      this.a.put("sgrp_user_type", Integer.valueOf(QQGuildDTConstant.a(paramIGProGuildInfo.getUserType())));
      this.a.put("sgrp_sub_channel_id", paramIGProChannelInfo.getChannelUin());
      this.a.put("sgrp_channel_id", paramIGProGuildInfo.getGuildID());
      this.a.put("sgrp_sub_channel_limit", Integer.toString(paramIGProChannelInfo.getTalkPermission()));
      this.a.put("sgrp_channel_name", paramIGProChannelInfo.getChannelName());
      this.a.put("sgrp_sub_channel_type", Integer.valueOf(3));
      this.a.put("sgrp_channel_groupname", paramIGProChannelInfo.getCategoryName());
    }
  }
  
  public HashMap<String, Object> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.GuildLiveDtUtil
 * JD-Core Version:    0.7.0.1
 */