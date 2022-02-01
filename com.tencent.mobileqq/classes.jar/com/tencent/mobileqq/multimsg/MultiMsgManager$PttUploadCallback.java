package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class MultiMsgManager$PttUploadCallback
  implements UpCallBack
{
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private MultiMsgManager jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<MessageRecord> jdField_a_of_type_JavaUtilArrayList;
  private int b;
  
  private MultiMsgManager$PttUploadCallback(MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, MultiMsgManager paramMultiMsgManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager = paramMultiMsgManager;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    if (paramRichText != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mPttUpCallBack attachRichText2Msg with ");
        localStringBuilder.append(paramRichText.toString());
        QLog.d("MultiMsg_TAG", 2, localStringBuilder.toString());
      }
      if (((this.jdField_a_of_type_JavaUtilArrayList.get(0) instanceof MessageForRichText)) && (((MessageForRichText)this.jdField_a_of_type_JavaUtilArrayList.get(0)).richText == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "PttUploadCallback.attachRichText2Msg return but mr.richtext is null");
        }
        ((MessageForRichText)this.jdField_a_of_type_JavaUtilArrayList.get(0)).richText = paramRichText;
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList.get(0) instanceof MessageForPtt))
      {
        if (((MessageForPtt)this.jdField_a_of_type_JavaUtilArrayList.get(0)).fileSize < 0L)
        {
          QLog.d("MultiMsg_TAG", 1, "PttUploadCallback attachRichText2Msg with fileSize < 0");
          if (QLog.isColorLevel())
          {
            QLog.d("MultiMsg_TAG", 2, "start print stack trace ---------");
            paramRichText = Thread.currentThread().getStackTrace();
            int j = paramRichText.length;
            int i = 0;
            while (i < j)
            {
              QLog.d("MultiMsg_TAG", 2, new Object[] { paramRichText[i] });
              i += 1;
            }
          }
          ((MessageForPtt)this.jdField_a_of_type_JavaUtilArrayList.get(0)).fileSize = 1L;
        }
      }
      else {
        QLog.d("MultiMsg_TAG", 1, "PttUploadCallback attachRichText2Msg but not message for ptt");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(this.jdField_a_of_type_JavaUtilArrayList, null);
      MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, new HashMap(), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_JavaUtilArrayList, true, this.b);
      return null;
    }
    QLog.d("MultiMsg_TAG", 1, "mPttUpCallBack attachRichText2Msg with null");
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mPttUpCallBack updateMsg with ");
      localStringBuilder.append(paramSendResult.toString());
      QLog.d("MultiMsg_TAG", 2, localStringBuilder.toString());
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult.jdField_a_of_type_Int != 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mPttUpCallBack onSend fail with ");
        localStringBuilder.append(paramSendResult.toString());
        QLog.d("MultiMsg_TAG", 2, localStringBuilder.toString());
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList.get(0) instanceof MessageForPtt))
      {
        if (((MessageForPtt)this.jdField_a_of_type_JavaUtilArrayList.get(0)).fileSize < 0L)
        {
          QLog.d("MultiMsg_TAG", 1, "PttUploadCallback onSend with fileSize < 0");
          if (QLog.isColorLevel())
          {
            QLog.d("MultiMsg_TAG", 2, "start print stack trace ---------");
            paramSendResult = Thread.currentThread().getStackTrace();
            int j = paramSendResult.length;
            int i = 0;
            while (i < j)
            {
              QLog.d("MultiMsg_TAG", 2, new Object[] { paramSendResult[i] });
              i += 1;
            }
          }
        }
      }
      else {
        QLog.d("MultiMsg_TAG", 1, "PttUploadCallback onSend but no message for ptt");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(this.jdField_a_of_type_JavaUtilArrayList, null);
      MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      return;
    }
    QLog.d("MultiMsg_TAG", 1, "mPttUpCallBack onSend result ok");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager.PttUploadCallback
 * JD-Core Version:    0.7.0.1
 */