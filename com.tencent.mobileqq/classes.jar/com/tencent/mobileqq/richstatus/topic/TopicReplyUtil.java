package com.tencent.mobileqq.richstatus.topic;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ReplyHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class TopicReplyUtil
{
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131714830);
  }
  
  private static void a(BaseChatPie paramBaseChatPie, long paramLong, String paramString)
  {
    MessageForText localMessageForText = new MessageForText();
    localMessageForText.selfuin = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageForText.frienduin = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    localMessageForText.istroop = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    localMessageForText.senderuin = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (paramLong == 0L) {
      paramLong = NetConnInfoCenter.getServerTime();
    }
    localMessageForText.time = paramLong;
    localMessageForText.msg = paramString;
    localMessageForText.uniseq = 0L;
    localMessageForText.msgUid = -1L;
    localMessageForText.shmsgseq = 1L;
    localMessageForText.sb = paramString;
    ((ReplyHelper)paramBaseChatPie.a(119)).a(localMessageForText, 0, 0L, null);
  }
  
  public static final boolean a(BaseChatPie paramBaseChatPie, Intent paramIntent)
  {
    paramIntent.getStringExtra("key_aio_reply_time");
    String str = paramIntent.getStringExtra("key_aio_reply_content");
    paramIntent.getIntExtra("key_aio_reply_type", 0);
    if (!TextUtils.isEmpty(str)) {
      return !TextUtils.isEmpty(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  public static final boolean b(BaseChatPie paramBaseChatPie, Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("key_aio_reply_time");
    String str1 = paramIntent.getStringExtra("key_aio_reply_content");
    int i = paramIntent.getIntExtra("key_aio_reply_type", 0);
    long l1;
    if (!TextUtils.isEmpty(str1))
    {
      if (TextUtils.isEmpty(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        return false;
      }
      l1 = 0L;
    }
    try
    {
      long l2 = Long.valueOf(str2).longValue();
      l1 = l2;
    }
    catch (Exception paramIntent)
    {
      label62:
      break label62;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TopicReplyUtil", 2, String.format("checkAIOReplyNInsert [%s, %d, %s]", new Object[] { paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Long.valueOf(l1), str1 }));
    }
    paramIntent = str1;
    if (i == 0)
    {
      paramIntent = new StringBuilder();
      paramIntent.append(jdField_a_of_type_JavaLangString);
      paramIntent.append(str1);
      paramIntent = paramIntent.toString();
    }
    a(paramBaseChatPie, l1, paramIntent);
    return true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.topic.TopicReplyUtil
 * JD-Core Version:    0.7.0.1
 */