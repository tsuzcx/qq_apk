package com.tencent.mobileqq.guild.chatpie;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class GuildLiveMsgListRefresher
  extends GuildMsgListRefresher
{
  public GuildLiveMsgListRefresher(@NonNull @NotNull AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  protected void a(List<ChatMessage> paramList, ListUI paramListUI)
  {
    super.a(paramList, paramListUI);
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    ((GuildLiveListUI)paramListUI).y().c((List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildLiveMsgListRefresher
 * JD-Core Version:    0.7.0.1
 */