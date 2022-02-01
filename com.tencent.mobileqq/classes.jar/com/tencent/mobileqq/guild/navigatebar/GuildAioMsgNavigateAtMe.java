package com.tencent.mobileqq.guild.navigatebar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.navigatebar.AioAgent.Message;
import com.tencent.mobileqq.troop.navigatebar.BaseAioMsgNavigateBarDelegate;
import com.tencent.mobileqq.troop.navigatebar.BaseAioMsgNavigateBarDelegate.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GuildAioMsgNavigateAtMe
  extends BaseAioMsgNavigateBarDelegate
{
  final String a = "GuildAioMsgNavigateAtMe";
  
  public GuildAioMsgNavigateAtMe(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramBaseSessionInfo);
    this.c = 23;
  }
  
  @Nullable
  public BaseAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramList = this.d.getMessageFacade().b(this.f.b, this.f.a, paramLong1);
    if ((paramList != null) && (a(paramList, paramLong2, paramLong3)))
    {
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append(" getShowEntity  若 mr != null 开始构造 bar mr = ");
        paramObject.append(paramList.shmsgseq);
        paramObject.append("\n firstMsgSeq = ");
        paramObject.append(paramLong2);
        paramObject.append("lastReadSeq = ");
        paramObject.append(paramLong3);
        QLog.d("GuildAioMsgNavigateAtMe", 2, paramObject.toString());
      }
      return new BaseAioMsgNavigateBarDelegate.Entity(true, this.e.getString(2131890241), AioAgent.Message.a(paramInt1, paramLong1, paramInt2), paramList.senderuin);
    }
    return null;
  }
  
  public void a(int paramInt1, AioAgent.Message paramMessage, String paramString, int paramInt2, TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    super.a(paramInt1, paramMessage, paramString, paramInt2, paramTextView1, paramTextView2, paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("GuildAioMsgNavigateAtMe", 2, "onClickMultiNavBar ");
    }
  }
  
  public void a(int paramInt, Object paramObject, String paramString) {}
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildAioMsgNavigateAtMe", 2, "onClick ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.navigatebar.GuildAioMsgNavigateAtMe
 * JD-Core Version:    0.7.0.1
 */