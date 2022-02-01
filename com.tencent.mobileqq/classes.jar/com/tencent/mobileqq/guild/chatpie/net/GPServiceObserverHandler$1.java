package com.tencent.mobileqq.guild.chatpie.net;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.GuildPieAdapter;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class GPServiceObserverHandler$1
  extends GPServiceObserver
{
  GPServiceObserverHandler$1(GPServiceObserverHandler paramGPServiceObserverHandler) {}
  
  protected void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUserNickUpdate tinyId:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" nickName:");
      localStringBuilder.append(paramString2);
      QLog.i("GPServiceObserverHandler", 2, localStringBuilder.toString());
    }
    ((GuildPieAdapter)this.a.a.n().V).a(paramString1, 10001);
  }
  
  protected void a(String paramString1, String paramString2, IGProClientIdentityInfo paramIGProClientIdentityInfo)
  {
    if (paramIGProClientIdentityInfo == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("onGuildMemberClientIdentityUpdate tinyId:");
      paramString1.append(paramString2);
      paramString1.append(" clientIdentity:");
      paramString1.append(paramIGProClientIdentityInfo);
      QLog.i("GPServiceObserverHandler", 2, paramString1.toString());
    }
    ((GuildPieAdapter)this.a.a.n().V).a(paramString2, 10002);
  }
  
  protected void a(String paramString, List<String> paramList)
  {
    if (this.a.a.S().equals(paramString))
    {
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String)paramString.next();
        if (this.a.a.T().equals(paramList)) {
          this.a.a.b(1);
        }
      }
    }
  }
  
  protected void c(String paramString)
  {
    super.c(paramString);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.a.a.S()))) {
      this.a.a.b(1);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRemoveGuild guildId:");
      localStringBuilder.append(paramString);
      QLog.i("GPServiceObserverHandler", 2, localStringBuilder.toString());
    }
  }
  
  protected void c(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("onGuildMemberNameUpdate tinyId:");
      paramString1.append(paramString2);
      paramString1.append(" nickName:");
      paramString1.append(paramString3);
      QLog.i("GPServiceObserverHandler", 2, paramString1.toString());
    }
    ((GuildPieAdapter)this.a.a.n().V).a(paramString2, 10001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.net.GPServiceObserverHandler.1
 * JD-Core Version:    0.7.0.1
 */