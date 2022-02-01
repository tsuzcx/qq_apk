package com.tencent.mobileqq.multimsg;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.receipt.ReceiptUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

class MultiMsgManager$2
  implements Runnable
{
  MultiMsgManager$2(MultiMsgManager paramMultiMsgManager, ArrayList paramArrayList, int paramInt1, HashMap paramHashMap, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, String paramString, int paramInt2, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject3 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    MultiMsgManager.a(System.currentTimeMillis());
    if (this.jdField_a_of_type_Int == 5) {
      MultiMsgManager.a(this.this$0);
    } else {
      MultiMsgManager.a(this.this$0, 0);
    }
    if (this.jdField_a_of_type_Int != 2) {
      this.this$0.a(this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    boolean bool;
    if (this.jdField_a_of_type_Int != 5) {
      bool = true;
    } else {
      bool = false;
    }
    ArrayList localArrayList3 = ((MultiMsgProxy)localObject1).a((MessageRecord)localObject2, (ArrayList)localObject3, null, true, bool);
    if (this.jdField_a_of_type_Int == 5) {
      ReceiptUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    localObject1 = null;
    int i;
    if (localArrayList3 == null)
    {
      if (this.jdField_a_of_type_Int == 2)
      {
        ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(8031, false, Integer.valueOf(3));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extraflag = 32768;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
      localObject1 = this.jdField_a_of_type_JavaLangString;
      i = this.b;
      long l = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.a(this.b), false, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
      return;
    }
    ArrayList localArrayList5 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    if (this.jdField_a_of_type_Int == 2) {
      j = 0;
    } else {
      j = this.b;
    }
    Object localObject5 = localArrayList3.iterator();
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = (MessageRecord)((Iterator)localObject5).next();
      Object localObject7;
      if ((localObject6 instanceof MessageForPic))
      {
        localObject2 = ((IPicBus)QRoute.api(IPicBus.class)).createForwardPicInfo(7, (MessageForPic)localObject6, j, (String)localObject4, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        if (localObject2 != null) {
          if (this.jdField_a_of_type_Int == 5)
          {
            localObject7 = this.jdField_a_of_type_AndroidOsBundle;
            if (localObject7 != null) {
              i = ((Bundle)localObject7).getInt("ReceiptMsgManager.EXTRA_KEY_PHOTO_SIZE_SPEC", 0);
            }
          }
        }
      }
      try
      {
        i = Integer.valueOf(ReceiptMsgManager.b((MessageRecord)localObject6)).intValue();
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label493:
        int k;
        break label493;
      }
      i = 0;
      ((PicFowardInfo)localObject2).jdField_a_of_type_Int = i;
      localObject6 = ((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
      if (i == 2) {
        i = 1;
      } else {
        i = 0;
      }
      ((PicUploadInfo)localObject6).l = i;
      localArrayList5.add(localObject2);
      localObject2 = localObject1;
      break label1126;
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.e("MultiMsg_TAG", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
        localObject2 = localObject1;
        break label1126;
        if ((localObject6 instanceof MessageForMixedMsg))
        {
          localObject2 = ((IPicBus)QRoute.api(IPicBus.class)).createForwardPicInfos(7, (MessageForMixedMsg)localObject6, j, (String)localObject4, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          if (localObject2 != null)
          {
            localArrayList5.addAll((Collection)localObject2);
            localObject2 = localObject1;
          }
          else
          {
            localObject2 = localObject1;
            if (QLog.isColorLevel())
            {
              QLog.e("MultiMsg_TAG", 2, "[requestSendMultiMsg]createForwardPicInfos from MessageForMixedMsg failed");
              localObject2 = localObject1;
            }
          }
        }
        else
        {
          if (((MessageRecord)localObject6).msgtype == -1036)
          {
            localObject6 = ((MessageForLongMsg)localObject6).longMsgFragmentList.iterator();
            for (;;)
            {
              localObject2 = localObject1;
              if (!((Iterator)localObject6).hasNext()) {
                break;
              }
              localObject2 = (MessageRecord)((Iterator)localObject6).next();
              if ((localObject2 instanceof MessageForMixedMsg))
              {
                localObject2 = ((IPicBus)QRoute.api(IPicBus.class)).createForwardPicInfos(7, (MessageForMixedMsg)localObject2, j, (String)localObject4, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                if (localObject2 != null) {
                  localArrayList5.addAll((Collection)localObject2);
                }
              }
            }
          }
          if ((localObject6 instanceof MessageForStructing))
          {
            localObject6 = ((MessageForStructing)localObject6).structingMsg;
            localObject2 = localObject1;
            if (localObject6 != null)
            {
              localObject2 = localObject1;
              if ((localObject6 instanceof StructMsgForImageShare))
              {
                localObject6 = (StructMsgForImageShare)localObject6;
                localObject7 = ((StructMsgForImageShare)localObject6).getFirstImageElement();
                localObject2 = localObject1;
                if (localObject7 != null)
                {
                  if (((StructMsgItemImage)localObject7).jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null)
                  {
                    if (((StructMsgItemImage)localObject7).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
                      ((StructMsgItemImage)localObject7).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localObject6);
                    }
                    ((StructMsgItemImage)localObject7).jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((StructMsgItemImage)localObject7).a();
                  }
                  localObject2 = ((IPicBus)QRoute.api(IPicBus.class)).createForwardPicInfo(7, ((StructMsgItemImage)localObject7).jdField_a_of_type_ComTencentMobileqqDataMessageForPic, this.b, (String)localObject4, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                  if (localObject2 != null)
                  {
                    localArrayList5.add(localObject2);
                    localObject2 = localObject1;
                  }
                  else
                  {
                    localObject2 = localObject1;
                    if (QLog.isColorLevel())
                    {
                      QLog.e("MultiMsg_TAG", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
                      localObject2 = localObject1;
                    }
                  }
                }
              }
            }
          }
          else if ((localObject6 instanceof MessageForShortVideo))
          {
            localObject2 = (MessageForShortVideo)localObject6;
            ((MessageForShortVideo)localObject2).videoFileName = ShortVideoUtils.findVideoPathIfExists((MessageForShortVideo)localObject2);
            if (localObject1 == null) {
              localObject1 = SVBusiUtil.a(5, 5);
            }
            localObject2 = ShortVideoBusiManager.a(5, localObject6, (ShortVideoReq)localObject1);
            if (localObject2 != null)
            {
              localArrayList4.add(localObject2);
              localObject2 = localObject1;
            }
            else
            {
              localObject2 = localObject1;
              if (QLog.isColorLevel())
              {
                QLog.e("MultiMsg_TAG", 2, "[requestSendMultiMsg]createShortVideoForwardInfo failed");
                localObject2 = localObject1;
              }
            }
          }
          else if (((localObject6 instanceof MessageForPtt)) && (this.jdField_a_of_type_Int == 5))
          {
            localArrayList1.add((MessageForPtt)localObject6);
            localObject2 = localObject1;
          }
          else if ((localObject6 instanceof MessageForFile))
          {
            localArrayList2.add(localObject6);
            localObject2 = localObject1;
          }
          else
          {
            localObject2 = localObject1;
            if ((localObject6 instanceof MessageForTroopFile))
            {
              localArrayList2.add(localObject6);
              localObject2 = localObject1;
            }
          }
        }
      }
      label1126:
      localObject1 = localObject2;
    }
    localObject2 = (ChatMessage)((ArrayList)localObject3).get(0);
    if (localObject2 != null) {
      i = ((ChatMessage)localObject2).istroop;
    } else {
      i = 0;
    }
    if (i == 0) {
      i = 1;
    } else if (i == 3000) {
      i = 2;
    } else if (i == 1) {
      i = 3;
    } else {
      i = 4;
    }
    int j = 1;
    k = this.b;
    if (k != 0) {
      if (k == 3000) {
        j = 2;
      } else if (k == 1) {
        j = 3;
      } else {
        j = 4;
      }
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(i);
    ((StringBuilder)localObject4).append("");
    localObject4 = ((StringBuilder)localObject4).toString();
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append(j);
    ((StringBuilder)localObject5).append("");
    localObject5 = ((StringBuilder)localObject5).toString();
    Object localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append("");
    ((StringBuilder)localObject6).append(((ArrayList)localObject3).size());
    localObject3 = ((StringBuilder)localObject6).toString();
    localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append("");
    ((StringBuilder)localObject6).append(localArrayList5.size());
    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8004660", "0X8004660", 0, 0, (String)localObject4, (String)localObject5, (String)localObject3, ((StringBuilder)localObject6).toString());
    if ((localArrayList5.size() == 0) && (localArrayList4.size() == 0) && (localArrayList1.size() == 0) && (localArrayList2.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "[requestSendMultiMsg]There's not any picture messages, goto onPackAndSendMsg");
      }
      MultiMsgManager.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, localArrayList3, true, this.jdField_a_of_type_Int);
      return;
    }
    if (localArrayList5.size() > 0)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[requestSendMultiMsg]Upload pictures, count is [");
        ((StringBuilder)localObject2).append(localArrayList5.size());
        ((StringBuilder)localObject2).append("], goto requestUploadPics");
        QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject2).toString());
      }
      if (this.jdField_a_of_type_Int == 5) {
        MultiMsgManager.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, 1);
      } else {
        MultiMsgManager.a(this.this$0, 1);
      }
      MultiMsgManager.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localArrayList3, localArrayList5, this.jdField_a_of_type_Int);
    }
    if (localArrayList4.size() > 0)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[requestSendMultiMsg]Upload videos, count is [");
        ((StringBuilder)localObject2).append(localArrayList4.size());
        ((StringBuilder)localObject2).append("], goto requestUploadVideos");
        QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject2).toString());
      }
      MultiMsgManager.a(this.this$0, 2);
      MultiMsgManager.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localArrayList3, localArrayList4, (ShortVideoReq)localObject1, this.jdField_a_of_type_Int);
    }
    if (localArrayList1.size() > 0)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[requestSendMultiMsg]Upload ptts, count is [");
        ((StringBuilder)localObject1).append(localArrayList1.size());
        ((StringBuilder)localObject1).append("], goto requestUploadPtts");
        QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject1).toString());
      }
      MultiMsgManager.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localArrayList3, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
    }
    if ((localArrayList2.size() > 0) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[requestSendMultiMsg]Upload files, count is [");
      ((StringBuilder)localObject1).append(localArrayList2.size());
      ((StringBuilder)localObject1).append("], goto requestUploadFiles");
      QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager.2
 * JD-Core Version:    0.7.0.1
 */