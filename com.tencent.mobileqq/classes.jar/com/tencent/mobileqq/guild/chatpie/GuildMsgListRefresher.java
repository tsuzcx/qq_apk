package com.tencent.mobileqq.guild.chatpie;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.qphone.base.util.QLog;

public class GuildMsgListRefresher
  extends MsgListRefresher
{
  public GuildMsgListRefresher(@NonNull AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    StringBuilder localStringBuilder;
    if (bool)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("instantUpdate: ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" / ");
      localStringBuilder.append(paramBoolean2);
      QLog.d("GuildMsgListRefresher", 2, localStringBuilder.toString());
    }
    bool = c();
    int j = 0;
    if (bool)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("instantUpdate: blockRefreshJumpBottom TRUE ");
      localStringBuilder.append(false);
      localStringBuilder.append(" / ");
      localStringBuilder.append(false);
      QLog.d("GuildMsgListRefresher", 1, localStringBuilder.toString());
      paramBoolean1 = false;
      paramBoolean2 = false;
    }
    if (((GuildChatContext)this.a).W())
    {
      i = j;
      if (paramBoolean1) {
        i = 32;
      }
      a(i | 0x20000);
      return;
    }
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        i = 3;
      }
    }
    else {
      i = 0;
    }
    a(0x20000 | i);
  }
  
  protected int c(int paramInt)
  {
    if ((((GuildChatContext)this.a).W()) && (paramInt == 0)) {
      return 0;
    }
    return super.c(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildMsgListRefresher
 * JD-Core Version:    0.7.0.1
 */