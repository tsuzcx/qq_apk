package com.tencent.mobileqq.teamwork.spread;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigBean.TeamworkKeyWords;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class DataLineMessageSpreadManager$2
  implements Runnable
{
  DataLineMessageSpreadManager$2(DataLineMessageSpreadManager paramDataLineMessageSpreadManager, DataLineMsgRecord paramDataLineMsgRecord, String paramString1, TencentDocDataLineTipsConfigBean.TeamworkKeyWords paramTeamworkKeyWords, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject1 = DataLineMessageSpreadManager.a(this.this$0).getMessageFacade().a(DataLineMessageSpreadManager.a(this.this$0)).a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("cant find cache msg,uniseq:");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.uniseq);
        QLog.e("DataLineMessageSpreadManager", 1, ((StringBuilder)localObject1).toString());
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
    }
    HashMap localHashMap = new HashMap();
    localObject1 = this.jdField_a_of_type_JavaLangString;
    if (((String)localObject1).contains("%s"))
    {
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocDataLineTipsConfigBean$TeamworkKeyWords;
      if (localObject3 != null) {
        try
        {
          localObject3 = String.format(this.jdField_a_of_type_JavaLangString, new Object[] { ((TencentDocDataLineTipsConfigBean.TeamworkKeyWords)localObject3).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocDataLineTipsConfigBean$TeamworkKeyWords.jdField_a_of_type_JavaLangString });
          localObject1 = localObject3;
          localHashMap.put("tim_aio_file_tips", localObject3);
          localObject1 = localObject3;
          localHashMap.put("tim_aio_file_link", String.format(this.b, new Object[] { this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocDataLineTipsConfigBean$TeamworkKeyWords.jdField_a_of_type_JavaLangString }));
          localObject1 = localObject3;
        }
        catch (Exception localException)
        {
          QLog.e("DataLineMessageSpreadManager", 2, localException.toString());
        }
      }
    }
    localHashMap.put("tim_aio_file_tips", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("tim_aio_file_link", this.b);
    localHashMap.put("tim_aio_file_msg_uiniseq", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid));
    localHashMap.put("tim_aio_tips_type", this.c);
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocDataLineTipsConfigBean$TeamworkKeyWords;
    if (localObject4 != null)
    {
      localHashMap.put("tim_aio_tips_template_id", String.valueOf(((TencentDocDataLineTipsConfigBean.TeamworkKeyWords)localObject4).jdField_a_of_type_Int));
      localHashMap.put("tim_aio_tips_template_type", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocDataLineTipsConfigBean$TeamworkKeyWords.b));
      localHashMap.put("tim_aio_tips_keyword", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocDataLineTipsConfigBean$TeamworkKeyWords.jdField_a_of_type_JavaLangString));
      localHashMap.put("tim_aio_tips_type", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocDataLineTipsConfigBean$TeamworkKeyWords.b));
    }
    localObject4 = (DataLineHandler)DataLineMessageSpreadManager.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    Long localLong = ((DataLineHandler)localObject4).a(0, DataLineMessageSpreadManager.a(this.this$0));
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgId = localLong.longValue();
    localDataLineMsgRecord.sessionid = localLong.longValue();
    localDataLineMsgRecord.msgtype = -5041;
    localDataLineMsgRecord.time = MessageCache.a();
    localDataLineMsgRecord.selfuin = DataLineMessageSpreadManager.a(this.this$0).getCurrentAccountUin();
    localDataLineMsgRecord.frienduin = ((DataLineMsgRecord)localObject2).frienduin;
    localDataLineMsgRecord.senderuin = DataLineMessageSpreadManager.a(this.this$0).getCurrentAccountUin();
    localDataLineMsgRecord.msg = ((String)localObject1);
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issend = 0;
    localDataLineMsgRecord.msgseq = ((DataLineMsgRecord)localObject2).shmsgseq;
    localDataLineMsgRecord.shmsgseq = ((DataLineMsgRecord)localObject2).shmsgseq;
    localDataLineMsgRecord.msgUid = ((DataLineMsgRecord)localObject2).msgUid;
    localDataLineMsgRecord.time = MessageCache.a();
    if (localHashMap.size() > 0)
    {
      localObject1 = localHashMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localDataLineMsgRecord.saveExtInfoToExtStr((String)localObject2, (String)localHashMap.get(localObject2));
      }
    }
    localDataLineMsgRecord.extraflag |= 0xFFFF7FFF;
    ReportController.b(DataLineMessageSpreadManager.a(this.this$0), "dc00898", "", "", "0X80098F7", "0X80098F7", 0, 0, "", "", "", "");
    DataLineMessageSpreadManager.a(this.this$0).getDataLineMsgProxy(DataLineMessageSpreadManager.a(this.this$0)).b(localDataLineMsgRecord);
    ((DataLineHandler)localObject4).a(11, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager.2
 * JD-Core Version:    0.7.0.1
 */