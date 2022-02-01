package com.tencent.mobileqq.guild.chatpie.net;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.message.GuildMessageObserver;
import com.tencent.mobileqq.widget.QQToast;

class GuildMessageObserverHandler$1
  extends GuildMessageObserver
{
  GuildMessageObserverHandler$1(GuildMessageObserverHandler paramGuildMessageObserverHandler) {}
  
  protected void a(String paramString)
  {
    super.a(paramString);
    GuildMessageObserverHandler.a(this.a, paramString);
  }
  
  protected void a(String paramString, long paramLong)
  {
    super.a(paramString, paramLong);
    GuildMessageObserverHandler.a(this.a, paramString);
  }
  
  protected void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    super.a(paramString1, paramLong, paramInt1, paramInt2, paramString2);
    if (!TextUtils.isEmpty(paramString2)) {
      QQToast.makeText(this.a.a.b().getApplicationContext(), 1, paramString2, 1).show();
    }
    GuildMessageObserverHandler.a(this.a, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.net.GuildMessageObserverHandler.1
 * JD-Core Version:    0.7.0.1
 */