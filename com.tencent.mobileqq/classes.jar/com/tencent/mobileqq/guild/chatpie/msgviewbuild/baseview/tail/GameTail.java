package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.tail;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.ChatMessage;

public class GameTail
  implements IMsgTail
{
  private LinearLayout a;
  private TextView b;
  private Context c;
  
  public GameTail(Context paramContext)
  {
    this.c = paramContext;
  }
  
  private void b()
  {
    if (this.a == null)
    {
      this.a = ((LinearLayout)LayoutInflater.from(this.c).inflate(2131624977, null));
      this.b = ((TextView)this.a.findViewById(2131434027));
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return false;
    }
    return TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("GUILD_MSG_GAME_TYPE")) ^ true;
  }
  
  public View b(ChatMessage paramChatMessage)
  {
    b();
    if (paramChatMessage != null)
    {
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("GUILD_MSG_GAME_TYPE");
      this.b.setText(paramChatMessage);
      this.a.setVisibility(0);
    }
    else
    {
      this.a.setVisibility(8);
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.tail.GameTail
 * JD-Core Version:    0.7.0.1
 */