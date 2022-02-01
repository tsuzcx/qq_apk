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
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
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
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131708158);
  }
  
  public PicMultiMsgProcessor(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(MultiMsgRequest paramMultiMsgRequest, MessageRecord paramMessageRecord, ArrayList<PicFowardInfo> paramArrayList, ArrayList<MessageRecord> paramArrayList1, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMultiMsgRequest = ((IPicBus)QRoute.api(IPicBus.class)).createForwardPicInfo(7, (MessageForPic)paramMessageRecord, paramInt1, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if (paramMultiMsgRequest != null)
      {
        paramArrayList.add(paramMultiMsgRequest);
        paramArrayList1.add(paramMessageRecord);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
      }
    }
    else if ((paramMessageRecord instanceof MessageForMixedMsg))
    {
      paramMultiMsgRequest = ((IPicBus)QRoute.api(IPicBus.class)).createForwardPicInfos(7, (MessageForMixedMsg)paramMessageRecord, paramInt1, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if (paramMultiMsgRequest != null)
      {
        paramArrayList.addAll(paramMultiMsgRequest);
        paramArrayList1.add(paramMessageRecord);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]createForwardPicInfos from MessageForMixedMsg failed");
      }
    }
    else
    {
      Object localObject;
      if (paramMessageRecord.msgtype == -1036)
      {
        paramMultiMsgRequest = ((MessageForLongMsg)paramMessageRecord).longMsgFragmentList.iterator();
        while (paramMultiMsgRequest.hasNext())
        {
          localObject = (MessageRecord)paramMultiMsgRequest.next();
          if ((localObject instanceof MessageForMixedMsg))
          {
            localObject = ((IPicBus)QRoute.api(IPicBus.class)).createForwardPicInfos(7, (MessageForMixedMsg)localObject, paramInt1, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            if (localObject != null)
            {
              paramArrayList.addAll((Collection)localObject);
              paramArrayList1.add(paramMessageRecord);
            }
          }
        }
      }
      if ((paramMessageRecord instanceof MessageForStructing))
      {
        paramMultiMsgRequest = ((MessageForStructing)paramMessageRecord).structingMsg;
        if ((paramMultiMsgRequest != null) && ((paramMultiMsgRequest instanceof StructMsgForImageShare)))
        {
          paramMultiMsgRequest = (StructMsgForImageShare)paramMultiMsgRequest;
          localObject = paramMultiMsgRequest.getFirstImageElement();
          if (localObject != null)
          {
            if (((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null)
            {
              if (((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
                ((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = paramMultiMsgRequest;
              }
              ((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((StructMsgItemImage)localObject).a();
            }
            paramMultiMsgRequest = ((IPicBus)QRoute.api(IPicBus.class)).createForwardPicInfo(7, ((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic, paramInt2, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            if (paramMultiMsgRequest != null)
            {
              paramArrayList.add(paramMultiMsgRequest);
              paramArrayList1.add(paramMessageRecord);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
            }
          }
        }
      }
      else if ((paramMessageRecord instanceof MessageForReplyText))
      {
        paramMessageRecord = ((MessageForReplyText)paramMessageRecord).getSourceMessage();
        if ((paramMessageRecord != null) && (((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForStructing)) || (paramMessageRecord.msgtype == -1036)))
        {
          if (QLog.isColorLevel()) {
            QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg] MessageForReplyText add to list");
          }
          if (paramMultiMsgRequest.b == 2) {
            paramInt1 = 0;
          } else {
            paramInt1 = paramMessageRecord.istroop;
          }
          a(paramMultiMsgRequest, paramMessageRecord, paramArrayList, paramArrayList1, paramInt1, paramMessageRecord.selfuin, paramMessageRecord.frienduin, paramMessageRecord.istroop);
        }
      }
    }
  }
  
  private void a(HashMap<String, ArrayList<MessageRecord>> paramHashMap, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, ArrayList<PicFowardInfo> paramArrayList1, int paramInt, MultiMsgRequest paramMultiMsgRequest, IMultiMsgRichUploadCallback paramIMultiMsgRichUploadCallback)
  {
    PicReq localPicReq = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(8, 7);
    localPicReq.a(paramArrayList1);
    localPicReq.a(new PicMultiMsgProcessor.1(this, paramArrayList, paramHashMap, paramMessageRecord, paramIMultiMsgRichUploadCallback, paramMultiMsgRequest));
    ((IPicBus)QRoute.api(IPicBus.class)).launch(localPicReq);
  }
  
  public void a(MultiMsgRequest paramMultiMsgRequest, HashMap<String, ArrayList<MessageRecord>> paramHashMap, IMultiMsgRichUploadCallback paramIMultiMsgRichUploadCallback)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i;
    if (paramMultiMsgRequest.b == 2) {
      i = 0;
    } else {
      i = paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    Object localObject1 = paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    int j = paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    Iterator localIterator1 = paramHashMap.keySet().iterator();
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ArrayList)paramHashMap.get((String)localIterator1.next())).iterator();
      Object localObject2 = localObject1;
      int k = j;
      for (;;)
      {
        j = k;
        localObject1 = localObject2;
        if (!localIterator2.hasNext()) {
          break;
        }
        a(paramMultiMsgRequest, (MessageRecord)localIterator2.next(), localArrayList1, localArrayList2, i, str, localObject2, k);
      }
    }
    if ((localArrayList1.size() > 0) && (localArrayList2.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[requestSendMultiMsg]Upload pictures, count is [");
        ((StringBuilder)localObject1).append(localArrayList1.size());
        ((StringBuilder)localObject1).append("], goto requestUploadPics");
        QLog.d("PicMultiMsgProcessor", 2, ((StringBuilder)localObject1).toString());
      }
      a(paramHashMap, paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, localArrayList2, localArrayList1, paramMultiMsgRequest.b, paramMultiMsgRequest, paramIMultiMsgRichUploadCallback);
      return;
    }
    paramIMultiMsgRichUploadCallback.a(0, 1, paramMultiMsgRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.PicMultiMsgProcessor
 * JD-Core Version:    0.7.0.1
 */