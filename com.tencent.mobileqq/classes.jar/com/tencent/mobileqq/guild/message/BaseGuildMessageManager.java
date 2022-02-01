package com.tencent.mobileqq.guild.message;

import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;
import mqq.app.AppRuntime;

public abstract class BaseGuildMessageManager
  extends BaseMessageManager
{
  public BaseGuildMessageManager(AppRuntime paramAppRuntime, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramMsgPool);
  }
  
  public abstract void a(int paramInt, String paramString, long paramLong, List<ChatMessage> paramList);
  
  public abstract void a(String paramString, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean, RefreshMessageContext paramRefreshMessageContext);
  
  public abstract void a(String paramString, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean1, RefreshMessageContext paramRefreshMessageContext, int paramInt2, boolean paramBoolean2);
  
  public abstract void b(List<ChatMessage> paramList);
  
  public abstract boolean e(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.BaseGuildMessageManager
 * JD-Core Version:    0.7.0.1
 */