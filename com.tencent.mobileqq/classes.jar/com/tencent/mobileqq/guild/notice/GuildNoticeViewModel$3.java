package com.tencent.mobileqq.guild.notice;

import androidx.arch.core.util.Function;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice;
import java.util.List;

class GuildNoticeViewModel$3
  implements Function<List<GuildNotice>, Boolean>
{
  GuildNoticeViewModel$3(GuildNoticeViewModel paramGuildNoticeViewModel) {}
  
  public Boolean a(List<GuildNotice> paramList)
  {
    return Boolean.valueOf(paramList.isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.notice.GuildNoticeViewModel.3
 * JD-Core Version:    0.7.0.1
 */