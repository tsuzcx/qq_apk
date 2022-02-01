package com.tencent.mobileqq.guild.navigatebar;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.navigatebar.AioAgent.Message;
import com.tencent.mobileqq.troop.navigatebar.BaseAioMsgNavigateBarDelegate;
import com.tencent.mobileqq.troop.navigatebar.BaseAioMsgNavigateBarDelegate.Entity;
import java.util.List;

public class GuildAioMsgNavigateReply
  extends BaseAioMsgNavigateBarDelegate
{
  public GuildAioMsgNavigateReply(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramBaseSessionInfo);
    this.c = 22;
  }
  
  @Nullable
  public BaseAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramList = this.d.getMessageFacade().c(this.f.b, this.f.a, paramLong1);
    if ((paramList != null) && (a(paramList, paramLong2, paramLong3))) {
      return new BaseAioMsgNavigateBarDelegate.Entity(true, this.e.getString(2131895469), AioAgent.Message.a(paramInt1, paramList.shmsgseq, paramInt2), paramList.senderuin);
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString) {}
  
  public void b(int paramInt, Object paramObject, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.navigatebar.GuildAioMsgNavigateReply
 * JD-Core Version:    0.7.0.1
 */