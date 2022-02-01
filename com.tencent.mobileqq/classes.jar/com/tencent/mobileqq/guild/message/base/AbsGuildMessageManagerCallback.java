package com.tencent.mobileqq.guild.message.base;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageManager.AddMessageContext;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.navigatebar.BaseAioNavigateBarManager;
import com.tencent.mobileqq.troop.navigatebar.BaseInfoManager;
import mqq.app.AppRuntime;

public abstract class AbsGuildMessageManagerCallback
  implements IGuildMessageCallback
{
  public abstract BaseAioNavigateBarManager a(AppInterface paramAppInterface);
  
  public abstract BaseInfoManager a(BaseMessageManager.AddMessageContext paramAddMessageContext);
  
  public abstract String a(MessageRecord paramMessageRecord);
  
  public abstract void a(AppRuntime paramAppRuntime, String paramString, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord, boolean paramBoolean);
  
  public abstract boolean a(AppRuntime paramAppRuntime, String paramString, long paramLong1, long paramLong2, boolean paramBoolean, Bundle paramBundle, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.base.AbsGuildMessageManagerCallback
 * JD-Core Version:    0.7.0.1
 */