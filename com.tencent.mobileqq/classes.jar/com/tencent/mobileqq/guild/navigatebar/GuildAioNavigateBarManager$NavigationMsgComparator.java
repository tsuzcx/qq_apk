package com.tencent.mobileqq.guild.navigatebar;

import com.tencent.mobileqq.troop.navigatebar.NavConstants;
import java.util.Comparator;

public class GuildAioNavigateBarManager$NavigationMsgComparator
  implements Comparator<GuildMessageNavigateInfo>
{
  public int a(GuildMessageNavigateInfo paramGuildMessageNavigateInfo1, GuildMessageNavigateInfo paramGuildMessageNavigateInfo2)
  {
    if (paramGuildMessageNavigateInfo1.type == paramGuildMessageNavigateInfo2.type)
    {
      int i = 0;
      if (paramGuildMessageNavigateInfo1.msgseq > paramGuildMessageNavigateInfo2.msgseq) {
        return -1;
      }
      if (paramGuildMessageNavigateInfo1.msgseq < paramGuildMessageNavigateInfo2.msgseq) {
        i = 1;
      }
      return i;
    }
    return -(NavConstants.a(paramGuildMessageNavigateInfo1.type) - NavConstants.a(paramGuildMessageNavigateInfo2.type));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.navigatebar.GuildAioNavigateBarManager.NavigationMsgComparator
 * JD-Core Version:    0.7.0.1
 */