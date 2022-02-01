package com.tencent.mobileqq.guild.activity.aio.helper;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.SelectToBottomHelper;
import com.tencent.mobileqq.guild.widget.GuildLiveSelectTouchBarView;
import com.tencent.mobileqq.widget.SelectTouchBarView;

public class GuildLiveSelectToBottomHelper
  extends SelectToBottomHelper
{
  public GuildLiveSelectToBottomHelper(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  protected SelectTouchBarView a(Context paramContext)
  {
    return new GuildLiveSelectTouchBarView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.activity.aio.helper.GuildLiveSelectToBottomHelper
 * JD-Core Version:    0.7.0.1
 */