package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class BaseTroopFocusAioMsgNavigateBar
  extends BaseTroopAioMsgMultiNavigateBarDelegate
{
  public BaseTroopFocusAioMsgNavigateBar(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramBaseSessionInfo);
  }
  
  @Nullable
  public BaseTroopAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    TroopAioAgent.Message localMessage = TroopAioAgent.Message.a(paramInt1, paramLong1, paramInt2);
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, paramLong1);
    boolean bool1 = ListUtils.a(paramList);
    Object localObject1 = "";
    boolean bool2 = false;
    Object localObject2;
    if (!bool1)
    {
      localObject2 = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt1 == 17) {
        paramInt1 = 2131694358;
      } else {
        paramInt1 = 2131699495;
      }
      if (paramList.size() > 99) {
        paramObject = "99+";
      } else {
        paramObject = Integer.valueOf(paramList.size());
      }
      localObject2 = ((Context)localObject2).getString(paramInt1, new Object[] { paramObject });
      paramObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramObject != null)
      {
        paramObject = paramObject.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
        if ((paramObject != null) && (paramObject.hasOrgs()))
        {
          paramInt1 = 1;
          break label175;
        }
      }
      paramInt1 = 0;
      label175:
      paramObject = localObject2;
      if (paramInt1 != 0) {
        if (paramList.size() == 1)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "focus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          paramObject = localObject2;
        }
        else
        {
          paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramList.size());
          localStringBuilder.append("");
          ReportController.b(paramObject, "P_CliOper", "Grp_work", "", "use", "msg_owner", 0, 0, str, localStringBuilder.toString(), "", "");
          paramObject = localObject2;
        }
      }
    }
    else
    {
      paramObject = this.jdField_a_of_type_AndroidContentContext.getString(2131719200);
    }
    paramList = paramObject;
    if (MessageForQQWalletMsg.isRedPacketMsg(localMessageRecord))
    {
      paramList = (MessageForQQWalletMsg)localMessageRecord;
      if ((paramList.messageType != 7) && (paramList.messageType != 8))
      {
        paramList = this.jdField_a_of_type_AndroidContentContext.getString(2131718742);
        localMessage.a = true;
      }
      else
      {
        paramList = this.jdField_a_of_type_AndroidContentContext.getString(2131718758);
        localMessage.b = true;
      }
    }
    if ((localMessageRecord != null) && (a(localMessageRecord, paramLong2, paramLong3)))
    {
      paramObject = localMessageRecord.senderuin;
      bool1 = true;
    }
    else
    {
      bool1 = false;
      paramObject = localObject1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(".troop.special_msg.special_attention");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("需要定位的第一条消息是否已经拉到本地：");
      if (localMessageRecord != null) {
        bool2 = true;
      }
      ((StringBuilder)localObject2).append(bool2);
      ((StringBuilder)localObject2).append(", isShow = ");
      ((StringBuilder)localObject2).append(bool1);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (bool1) {
      return new BaseTroopAioMsgNavigateBarDelegate.Entity(true, paramList, localMessage, paramObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.BaseTroopFocusAioMsgNavigateBar
 * JD-Core Version:    0.7.0.1
 */