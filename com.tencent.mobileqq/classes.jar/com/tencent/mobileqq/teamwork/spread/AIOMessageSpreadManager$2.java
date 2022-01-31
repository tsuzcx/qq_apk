package com.tencent.mobileqq.teamwork.spread;

import ammo;
import aoig;
import axgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AIOMessageSpreadManager$2
  implements Runnable
{
  public AIOMessageSpreadManager$2(axgr paramaxgr, ChatMessage paramChatMessage, String paramString1, ammo paramammo, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject1 = axgr.a(this.this$0).a().a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AIOMessageSpreadManager", 1, "cant find cache msg,uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    }
    HashMap localHashMap = new HashMap();
    localObject1 = this.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_JavaLangString.contains("%s")) && (this.jdField_a_of_type_Ammo != null)) {}
    for (;;)
    {
      try
      {
        String str = String.format(this.jdField_a_of_type_JavaLangString, new Object[] { this.jdField_a_of_type_Ammo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ammo.jdField_a_of_type_JavaLangString });
        localObject1 = str;
        localHashMap.put("tim_aio_file_tips", str);
        localObject1 = str;
        localHashMap.put("tim_aio_file_link", String.format(this.b, new Object[] { this.jdField_a_of_type_Ammo.jdField_a_of_type_JavaLangString }));
        localObject1 = str;
      }
      catch (Exception localException)
      {
        long l;
        QLog.e("AIOMessageSpreadManager", 2, localException.toString());
        continue;
      }
      localHashMap.put("tim_aio_file_msg_uiniseq", String.valueOf(((MessageRecord)localObject2).uniseq));
      localHashMap.put("tim_aio_tips_type", this.c);
      if (this.jdField_a_of_type_Ammo != null)
      {
        localHashMap.put("tim_aio_tips_template_id", String.valueOf(this.jdField_a_of_type_Ammo.jdField_a_of_type_Int));
        localHashMap.put("tim_aio_tips_template_type", String.valueOf(this.jdField_a_of_type_Ammo.b));
        localHashMap.put("tim_aio_tips_keyword", String.valueOf(this.jdField_a_of_type_Ammo.jdField_a_of_type_JavaLangString));
        localHashMap.put("tim_aio_tips_type", String.valueOf(this.jdField_a_of_type_Ammo.b));
      }
      l = axgr.a(this.this$0).a().a(((MessageRecord)localObject2).frienduin, axgr.a(this.this$0).getCurrentAccountUin(), ((MessageRecord)localObject2).istroop, -3016, localHashMap, (String)localObject1, ((MessageRecord)localObject2).msgUid, ((MessageRecord)localObject2).shmsgseq, ((MessageRecord)localObject2).time);
      if (QLog.isDebugVersion()) {
        QLog.i("AIOMessageSpreadManager", 1, "insertGaryTips:" + l + "findMsg:" + localObject2.hashCode());
      }
      ((MessageRecord)localObject2).saveExtInfoToExtStr("tim_aio_gary_uniseq", String.valueOf(l));
      axgr.a(this.this$0).a().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, "extStr", ((MessageRecord)localObject2).getExtInfoString());
      axgr.a(this.this$0).a().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, "extLong", Integer.valueOf(((MessageRecord)localObject2).extLong));
      return;
      localHashMap.put("tim_aio_file_tips", this.jdField_a_of_type_JavaLangString);
      localHashMap.put("tim_aio_file_link", this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.2
 * JD-Core Version:    0.7.0.1
 */