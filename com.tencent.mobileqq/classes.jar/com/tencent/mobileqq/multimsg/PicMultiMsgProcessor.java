package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PicMultiMsgProcessor
  extends BaseMultiMsgProcessor
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131708140);
  }
  
  public PicMultiMsgProcessor(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(MultiMsgRequest paramMultiMsgRequest, MessageRecord paramMessageRecord, ArrayList<PicFowardInfo> paramArrayList, ArrayList<MessageRecord> paramArrayList1, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMultiMsgRequest = PicBusiManager.a(7, (MessageForPic)paramMessageRecord, paramInt1, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if (paramMultiMsgRequest != null) {
        paramArrayList.add(paramMultiMsgRequest);
      }
    }
    label47:
    label224:
    do
    {
      do
      {
        do
        {
          Object localObject;
          do
          {
            do
            {
              paramArrayList1.add(paramMessageRecord);
              break label47;
              break label47;
              break label47;
              break label47;
              for (;;)
              {
                return;
                if (QLog.isColorLevel())
                {
                  QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
                  return;
                  if ((paramMessageRecord instanceof MessageForMixedMsg))
                  {
                    paramMultiMsgRequest = PicBusiManager.a(7, (MessageForMixedMsg)paramMessageRecord, paramInt1, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    if (paramMultiMsgRequest != null)
                    {
                      paramArrayList.addAll(paramMultiMsgRequest);
                      paramArrayList1.add(paramMessageRecord);
                      return;
                    }
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]createForwardPicInfos from MessageForMixedMsg failed");
                    return;
                  }
                  if (paramMessageRecord.msgtype != -1036) {
                    break label224;
                  }
                  paramMultiMsgRequest = ((MessageForLongMsg)paramMessageRecord).longMsgFragmentList.iterator();
                  while (paramMultiMsgRequest.hasNext())
                  {
                    localObject = (MessageRecord)paramMultiMsgRequest.next();
                    if ((localObject instanceof MessageForMixedMsg))
                    {
                      localObject = PicBusiManager.a(7, (MessageForMixedMsg)localObject, paramInt1, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                      if (localObject != null)
                      {
                        paramArrayList.addAll((Collection)localObject);
                        paramArrayList1.add(paramMessageRecord);
                      }
                    }
                  }
                }
              }
              if (!(paramMessageRecord instanceof MessageForStructing)) {
                break;
              }
              paramMultiMsgRequest = ((MessageForStructing)paramMessageRecord).structingMsg;
            } while ((paramMultiMsgRequest == null) || (!(paramMultiMsgRequest instanceof StructMsgForImageShare)));
            localObject = ((StructMsgForImageShare)paramMultiMsgRequest).getFirstImageElement();
          } while (localObject == null);
          if (((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null)
          {
            if (((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
              ((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)paramMultiMsgRequest);
            }
            ((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((StructMsgItemImage)localObject).a();
          }
          paramMultiMsgRequest = PicBusiManager.a(7, ((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic, paramInt2, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          if (paramMultiMsgRequest != null)
          {
            paramArrayList.add(paramMultiMsgRequest);
            paramArrayList1.add(paramMessageRecord);
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
        return;
      } while (!(paramMessageRecord instanceof MessageForReplyText));
      paramMessageRecord = ((MessageForReplyText)paramMessageRecord).getSourceMessage();
    } while ((paramMessageRecord == null) || ((!(paramMessageRecord instanceof MessageForPic)) && (!(paramMessageRecord instanceof MessageForMixedMsg)) && (!(paramMessageRecord instanceof MessageForStructing)) && (paramMessageRecord.msgtype != -1036)));
    if (QLog.isColorLevel()) {
      QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg] MessageForReplyText add to list");
    }
    if (paramMultiMsgRequest.b == 2) {}
    for (paramInt1 = 0;; paramInt1 = paramMessageRecord.istroop)
    {
      a(paramMultiMsgRequest, paramMessageRecord, paramArrayList, paramArrayList1, paramInt1, paramMessageRecord.selfuin, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      return;
    }
  }
  
  private void a(HashMap<String, ArrayList<MessageRecord>> paramHashMap, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, ArrayList<PicFowardInfo> paramArrayList1, int paramInt, MultiMsgRequest paramMultiMsgRequest, IMultiMsgRichUploadCallback paramIMultiMsgRichUploadCallback)
  {
    PicReq localPicReq = PicBusiManager.a(8, 7);
    localPicReq.a(paramArrayList1);
    localPicReq.a(new PicMultiMsgProcessor.1(this, paramArrayList, paramHashMap, paramMessageRecord, paramIMultiMsgRichUploadCallback, paramMultiMsgRequest));
    PicBusiManager.a(localPicReq);
  }
  
  public void a(MultiMsgRequest paramMultiMsgRequest, HashMap<String, ArrayList<MessageRecord>> paramHashMap, IMultiMsgRichUploadCallback paramIMultiMsgRichUploadCallback)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramMultiMsgRequest.b == 2) {}
    for (int i = 0;; i = paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
    {
      String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      String str2 = paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      int j = paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      Iterator localIterator1 = paramHashMap.keySet().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)paramHashMap.get((String)localIterator1.next())).iterator();
        while (localIterator2.hasNext()) {
          a(paramMultiMsgRequest, (MessageRecord)localIterator2.next(), localArrayList1, localArrayList2, i, str1, str2, j);
        }
      }
    }
    if ((localArrayList1.size() > 0) && (localArrayList2.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]Upload pictures, count is [" + localArrayList1.size() + "], goto requestUploadPics");
      }
      a(paramHashMap, paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, localArrayList2, localArrayList1, paramMultiMsgRequest.b, paramMultiMsgRequest, paramIMultiMsgRichUploadCallback);
      return;
    }
    paramIMultiMsgRichUploadCallback.a(0, 1, paramMultiMsgRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.PicMultiMsgProcessor
 * JD-Core Version:    0.7.0.1
 */