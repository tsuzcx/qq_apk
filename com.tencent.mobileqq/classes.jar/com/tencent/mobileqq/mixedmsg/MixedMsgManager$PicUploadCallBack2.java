package com.tencent.mobileqq.mixedmsg;

import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

public class MixedMsgManager$PicUploadCallBack2
  implements UpCallBack
{
  protected MessageForMixedMsg a;
  protected String a;
  protected ArrayList<AtTroopMemberInfo> a;
  protected Map<String, List<Integer>> a;
  
  public MixedMsgManager$PicUploadCallBack2(MessageForMixedMsg paramMessageForMixedMsg, Map<String, List<Integer>> paramMap, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg = paramMap;
    this.jdField_a_of_type_JavaLangString = paramArrayList;
    this.jdField_a_of_type_JavaUtilMap = paramString;
    Object localObject;
    this.jdField_a_of_type_JavaUtilArrayList = localObject;
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg)
  {
    if ((paramMessageForMixedMsg.msgElemList.get(0) instanceof MessageForText))
    {
      localObject = (MessageForText)paramMessageForMixedMsg.msgElemList.get(0);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (((MessageForText)localObject).atInfoList == null)) {
        ((MessageForText)localObject).atInfoList = this.jdField_a_of_type_JavaUtilArrayList;
      }
    }
    if (paramMessageForMixedMsg.istroop == 1)
    {
      localObject = paramMessageForMixedMsg.msgElemList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        AnonymousChatHelper.a().a(localMessageRecord);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager;
    MixedMsgManager.a((MixedMsgManager)localObject, ((MixedMsgManager)localObject).a, paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg, true);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    Object localObject1 = (List)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString);
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return null;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Integer)((Iterator)localObject1).next();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.getSubMessage(((Integer)localObject2).intValue());
        if ((localObject2 instanceof MessageForPic)) {
          ((MessageForPic)localObject2).richText = paramRichText;
        }
      }
    }
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = new ErrorMessage(paramSendResult.jdField_b_of_type_Int, paramSendResult.jdField_a_of_type_JavaLangString);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("reqUploadMultiPics UiCallBack success result = ");
      ((StringBuilder)localObject2).append(paramSendResult);
      ((StringBuilder)localObject2).append(", error = ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("MixedMsgManager", 2, ((StringBuilder)localObject2).toString());
    }
    StringBuilder localStringBuilder;
    if (paramSendResult.jdField_b_of_type_Int != 0)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("send Msg fail: ");
      localStringBuilder.append(paramSendResult);
      MixedMsgManager.a((MixedMsgManager)localObject1, (MessageForMixedMsg)localObject2, false, localStringBuilder.toString());
      return;
    }
    Object localObject1 = (List)this.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_JavaLangString);
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Integer)((Iterator)localObject1).next();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.getSubMessage(((Integer)localObject2).intValue());
        if ((localObject2 instanceof MessageForPic))
        {
          localObject2 = (MessageForPic)localObject2;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onSend, pre MessageForPic:");
            localStringBuilder.append(((MessageForPic)localObject2).toLogString());
            QLog.d("MixedMsgManager", 2, localStringBuilder.toString());
          }
          ((MessageForPic)localObject2).md5 = paramSendResult.d;
          ((MessageForPic)localObject2).uuid = paramSendResult.c;
          ((MessageForPic)localObject2).size = paramSendResult.jdField_a_of_type_Long;
          ((MessageForPic)localObject2).groupFileID = paramSendResult.jdField_b_of_type_Long;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onSend, end MessageForPic:");
            localStringBuilder.append(((MessageForPic)localObject2).toLogString());
            QLog.d("MixedMsgManager", 2, localStringBuilder.toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.prewrite();
        }
      }
      if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MixedMsgManager", 2, "onSend, mMsgMap isEmpty, packAndSend..");
        }
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgManager.PicUploadCallBack2
 * JD-Core Version:    0.7.0.1
 */