package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TroopAioMsgNavigateCalendar
  extends BaseAioMsgNavigateBarDelegate
{
  private String a;
  
  public TroopAioMsgNavigateCalendar(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramBaseSessionInfo);
    this.c = 21;
  }
  
  @Nullable
  public BaseAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramObject = this.d.getMessageFacade().b(this.f.b, this.f.a, paramLong1);
    if ((paramObject != null) && (a(paramObject, paramLong2, paramLong3)))
    {
      if ((StructMsgForGeneralShare)StructMsgFactory.a(paramObject.msgData) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "showNavigateBarIfNeeded() :calendarMsg getStructMsg is null");
        }
        paramList = this.e.getString(2131895053);
      }
      else
      {
        paramList = StructMsgForGeneralShare.remindBrief;
      }
      AioAgent.Message localMessage = AioAgent.Message.a(paramInt1, paramLong1, paramInt2);
      paramObject = paramObject.senderuin;
      this.a = StructMsgForGeneralShare.eventType;
      ReportController.b(this.d, "dc00899", "Grp_calendar", "", "notice", "exp", 0, 0, this.f.b, this.a, "", "");
      return new BaseAioMsgNavigateBarDelegate.Entity(true, paramList, localMessage, paramObject);
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString) {}
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    ReportController.b(this.d, "dc00899", "Grp_calendar", "", "notice", "Clk", 0, 0, this.f.b, this.a, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateCalendar
 * JD-Core Version:    0.7.0.1
 */