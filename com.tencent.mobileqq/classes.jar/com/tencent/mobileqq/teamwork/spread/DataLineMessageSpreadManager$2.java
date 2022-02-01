package com.tencent.mobileqq.teamwork.spread;

import ansr;
import aont;
import aoxv;
import arnj;
import bcrg;
import bdla;
import beed;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DataLineMessageSpreadManager$2
  implements Runnable
{
  public DataLineMessageSpreadManager$2(beed parambeed, DataLineMsgRecord paramDataLineMsgRecord, String paramString1, arnj paramarnj, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject2 = beed.a(this.this$0).getMessageFacade().getDatalineMessageManager(beed.a(this.this$0)).a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DataLineMessageSpreadManager", 1, "cant find cache msg,uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.uniseq);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      Object localObject1 = this.jdField_a_of_type_JavaLangString;
      if ((this.jdField_a_of_type_JavaLangString.contains("%s")) && (this.jdField_a_of_type_Arnj != null)) {}
      DataLineMsgRecord localDataLineMsgRecord;
      for (;;)
      {
        try
        {
          localObject3 = String.format(this.jdField_a_of_type_JavaLangString, new Object[] { this.jdField_a_of_type_Arnj.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Arnj.jdField_a_of_type_JavaLangString });
          localObject1 = localObject3;
          localHashMap.put("tim_aio_file_tips", localObject3);
          localObject1 = localObject3;
          localHashMap.put("tim_aio_file_link", String.format(this.b, new Object[] { this.jdField_a_of_type_Arnj.jdField_a_of_type_JavaLangString }));
          localObject1 = localObject3;
        }
        catch (Exception localException)
        {
          Object localObject3;
          Long localLong;
          QLog.e("DataLineMessageSpreadManager", 2, localException.toString());
          continue;
        }
        localHashMap.put("tim_aio_file_msg_uiniseq", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid));
        localHashMap.put("tim_aio_tips_type", this.c);
        if (this.jdField_a_of_type_Arnj != null)
        {
          localHashMap.put("tim_aio_tips_template_id", String.valueOf(this.jdField_a_of_type_Arnj.jdField_a_of_type_Int));
          localHashMap.put("tim_aio_tips_template_type", String.valueOf(this.jdField_a_of_type_Arnj.b));
          localHashMap.put("tim_aio_tips_keyword", String.valueOf(this.jdField_a_of_type_Arnj.jdField_a_of_type_JavaLangString));
          localHashMap.put("tim_aio_tips_type", String.valueOf(this.jdField_a_of_type_Arnj.b));
        }
        localObject3 = (ansr)beed.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        localLong = ((ansr)localObject3).a(0, beed.a(this.this$0));
        localDataLineMsgRecord = new DataLineMsgRecord();
        localDataLineMsgRecord.msgId = localLong.longValue();
        localDataLineMsgRecord.sessionid = localLong.longValue();
        localDataLineMsgRecord.msgtype = -5041;
        localDataLineMsgRecord.time = bcrg.a();
        localDataLineMsgRecord.selfuin = beed.a(this.this$0).getCurrentAccountUin();
        localDataLineMsgRecord.frienduin = ((DataLineMsgRecord)localObject2).frienduin;
        localDataLineMsgRecord.senderuin = beed.a(this.this$0).getCurrentAccountUin();
        localDataLineMsgRecord.msg = ((String)localObject1);
        localDataLineMsgRecord.isread = true;
        localDataLineMsgRecord.issend = 0;
        localDataLineMsgRecord.msgseq = ((DataLineMsgRecord)localObject2).shmsgseq;
        localDataLineMsgRecord.shmsgseq = ((DataLineMsgRecord)localObject2).shmsgseq;
        localDataLineMsgRecord.msgUid = ((DataLineMsgRecord)localObject2).msgUid;
        localDataLineMsgRecord.time = bcrg.a();
        if ((localHashMap == null) || (localHashMap.size() <= 0)) {
          break;
        }
        localObject1 = localHashMap.keySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        localDataLineMsgRecord.saveExtInfoToExtStr((String)localObject2, (String)localHashMap.get(localObject2));
        continue;
        localHashMap.put("tim_aio_file_tips", this.jdField_a_of_type_JavaLangString);
        localHashMap.put("tim_aio_file_link", this.b);
      }
      localDataLineMsgRecord.extraflag |= 0xFFFF7FFF;
      bdla.b(beed.a(this.this$0), "dc00898", "", "", "0X80098F7", "0X80098F7", 0, 0, "", "", "", "");
      beed.a(this.this$0).getDataLineMsgProxy(beed.a(this.this$0)).b(localDataLineMsgRecord);
      localException.a(11, true, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager.2
 * JD-Core Version:    0.7.0.1
 */