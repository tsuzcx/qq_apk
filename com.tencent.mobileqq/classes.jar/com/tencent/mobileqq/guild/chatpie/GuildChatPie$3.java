package com.tencent.mobileqq.guild.chatpie;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

class GuildChatPie$3
  implements Runnable
{
  GuildChatPie$3(GuildChatPie paramGuildChatPie, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      String str = this.this$0.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set left text from update unread: ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", isThemeDefault: ");
      localStringBuilder.append(this.this$0.aL);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    GuildChatPie.a(this.this$0).setVisibility(8);
    if (TextUtils.isEmpty(this.b)) {
      GuildChatPie.b(this.this$0).setVisibility(8);
    } else {
      GuildChatPie.c(this.this$0).setVisibility(0);
    }
    try
    {
      if (Long.parseLong(this.b) < 10L) {
        GuildChatPie.d(this.this$0).setBackgroundResource(2130841048);
      } else {
        GuildChatPie.e(this.this$0).setBackgroundResource(2130841049);
      }
    }
    catch (Exception localException)
    {
      label158:
      break label158;
    }
    GuildChatPie.f(this.this$0).setText(this.b);
    if (ChatActivityConstants.b) {
      this.this$0.p.setLeftContentDescription(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildChatPie.3
 * JD-Core Version:    0.7.0.1
 */