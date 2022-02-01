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
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TroopAioMsgNavigateCalendar
  extends BaseTroopAioMsgNavigateBarDelegate
{
  private String b;
  
  public TroopAioMsgNavigateCalendar(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramBaseSessionInfo);
    this.jdField_a_of_type_Int = 21;
  }
  
  @Nullable
  public BaseTroopAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, paramLong1);
    if ((paramObject != null) && (a(paramObject, paramLong2, paramLong3)))
    {
      if ((StructMsgForGeneralShare)StructMsgFactory.a(paramObject.msgData) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showNavigateBarIfNeeded() :calendarMsg getStructMsg is null");
        }
        paramList = this.jdField_a_of_type_AndroidContentContext.getString(2131697280);
      }
      else
      {
        paramList = StructMsgForGeneralShare.remindBrief;
      }
      TroopAioAgent.Message localMessage = TroopAioAgent.Message.a(paramInt1, paramLong1, paramInt2);
      paramObject = paramObject.senderuin;
      this.b = StructMsgForGeneralShare.eventType;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_calendar", "", "notice", "exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.b, "", "");
      return new BaseTroopAioMsgNavigateBarDelegate.Entity(true, paramList, localMessage, paramObject);
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString) {}
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_calendar", "", "notice", "Clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.b, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateCalendar
 * JD-Core Version:    0.7.0.1
 */