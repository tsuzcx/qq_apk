package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.Map;

class GuildShortVideoItemBuilder$4
  implements Runnable
{
  GuildShortVideoItemBuilder$4(GuildShortVideoItemBuilder paramGuildShortVideoItemBuilder, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a))
    {
      if (GuildShortVideoItemBuilder.c().size() == 0) {
        RMVideoStateMgr.c(this.a);
      }
      FileUtils.deleteDirectory(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildShortVideoItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */