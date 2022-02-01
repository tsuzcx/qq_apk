package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.MultiMsgPicsUploadAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.RichMsg.PicRec;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb.ResvAttr;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichText;

class MultiMsgManager$3
  extends UiCallBack.MultiMsgPicsUploadAdapter
{
  MultiMsgManager$3(MultiMsgManager paramMultiMsgManager, int paramInt1, MessageRecord paramMessageRecord, ArrayList paramArrayList, QQAppInterface paramQQAppInterface, String paramString, int paramInt2, HashMap paramHashMap) {}
  
  private boolean a(MessageForPic paramMessageForPic, PicResult paramPicResult)
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    Object localObject1 = paramPicResult.jdField_a_of_type_JavaLangObject;
    boolean bool2 = false;
    boolean bool1;
    if (localObject1 != null)
    {
      bool1 = paramPicResult.jdField_a_of_type_JavaLangObject instanceof im_msg_body.NotOnlineImage;
      localObject1 = "";
      Object localObject2;
      if (bool1)
      {
        localElem.not_online_image.set((im_msg_body.NotOnlineImage)paramPicResult.jdField_a_of_type_JavaLangObject);
        if (paramMessageForPic.picExtraData != null)
        {
          localObject2 = paramMessageForPic.picExtraData.getOfflineImageResvAttr();
          localElem.not_online_image.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((NotOnlineImageExtPb.ResvAttr)((NotOnlineImageExtPb.ResvAttr)localObject2).get()).toByteArray()), true);
        }
        if ((paramPicResult.b) || (this.jdField_a_of_type_Int == 5))
        {
          if (localElem.not_online_image.res_id.has()) {
            localObject1 = localElem.not_online_image.res_id.get().toStringUtf8();
          } else if (localElem.not_online_image.download_path.has()) {
            localObject1 = localElem.not_online_image.download_path.get().toStringUtf8();
          }
          paramMessageForPic.uuid = ((String)localObject1);
          if (this.jdField_a_of_type_Int != 5)
          {
            paramMessageForPic.path = ((String)localObject1);
            paramMessageForPic.md5 = FileUtils.calcMd5(MultiMsgManager.jdField_a_of_type_JavaLangString);
          }
          paramMessageForPic.thumbMsgUrl = localElem.not_online_image.str_thumb_url.get();
          paramMessageForPic.thumbHeight = localElem.not_online_image.uint32_thumb_height.get();
          paramMessageForPic.thumbWidth = localElem.not_online_image.uint32_thumb_width.get();
          paramMessageForPic.msgData = paramMessageForPic.getSerialPB().toByteArray();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(" pic resp uuid = ");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(" picMsgMD5 = ");
            ((StringBuilder)localObject2).append(paramMessageForPic.md5);
            ((StringBuilder)localObject2).append(" hasCode = ");
            ((StringBuilder)localObject2).append(paramMessageForPic.hashCode());
            QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
      do
      {
        i = 1;
        break label605;
        if (!(paramPicResult.jdField_a_of_type_JavaLangObject instanceof im_msg_body.CustomFace)) {
          break;
        }
        localElem.custom_face.set((im_msg_body.CustomFace)paramPicResult.jdField_a_of_type_JavaLangObject);
        if (paramMessageForPic.picExtraData != null)
        {
          localObject2 = paramMessageForPic.picExtraData.getCustomFaceResvAttr();
          localElem.custom_face.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((CustomFaceExtPb.ResvAttr)((CustomFaceExtPb.ResvAttr)localObject2).get()).toByteArray()), true);
        }
        if ((paramPicResult.b) || (this.jdField_a_of_type_Int == 5))
        {
          if (localElem.custom_face.str_file_path.has()) {
            localObject1 = localElem.custom_face.str_file_path.get();
          }
          paramMessageForPic.uuid = ((String)localObject1);
          if (this.jdField_a_of_type_Int != 5)
          {
            paramMessageForPic.path = ((String)localObject1);
            paramMessageForPic.md5 = FileUtils.calcMd5(MultiMsgManager.jdField_a_of_type_JavaLangString);
          }
          paramMessageForPic.msgData = paramMessageForPic.getSerialPB().toByteArray();
        }
      } while ((localElem.custom_face.uint32_file_id.get() != 0) || (this.jdField_a_of_type_Int != 5) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 0));
      if (QLog.isColorLevel())
      {
        QLog.d("MultiMsg_TAG", 2, "updateMessageForPic but custom_face's file id is 0");
        break label603;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("WTF, picResult.mExtraObj is ");
          ((StringBuilder)localObject1).append(paramPicResult.jdField_a_of_type_JavaLangObject.getClass().getSimpleName());
          QLog.e("MultiMsg_TAG", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    label603:
    int i = 0;
    label605:
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "updateMessageForPic success");
      }
      localRichText.elems.add(localElem);
      if (paramPicResult.jdField_a_of_type_Int == 0)
      {
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.e("MultiMsg_TAG", 2, "[requestUploadPics] Bad picture element");
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.e("MultiMsg_TAG", 2, "updateMessageForPic failed, add empty element");
        bool1 = bool2;
      }
    }
    paramMessageForPic.richText = localRichText;
    return bool1;
  }
  
  private boolean a(ArrayList<PicResult> paramArrayList)
  {
    int m = 0;
    int k = 0;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = true; m < this.jdField_a_of_type_JavaUtilArrayList.size(); bool1 = bool2)
    {
      Object localObject2 = (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(m);
      int j = k;
      if (i < paramArrayList.size()) {
        if (!((PicResult)paramArrayList.get(i)).b)
        {
          j = k;
          if (this.jdField_a_of_type_Int != 5) {}
        }
        else
        {
          j = 1;
        }
      }
      Object localObject1;
      if ((localObject2 instanceof MessageForPic))
      {
        if ((i >= paramArrayList.size()) && (QLog.isColorLevel())) {
          QLog.e("MultiMsg_TAG", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
        }
        localObject1 = (MessageForPic)localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateMessageForPic for MessageForPic, MsgIndex[");
          ((StringBuilder)localObject2).append(m);
          ((StringBuilder)localObject2).append("], resultIndex[");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append("]");
          QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject2).toString());
        }
        if (!a((MessageForPic)localObject1, (PicResult)paramArrayList.get(i))) {
          bool1 = false;
        }
        k = i + 1;
        bool2 = bool1;
      }
      do
      {
        i = j;
        j = k;
        k = i;
        break label1040;
        bool2 = localObject2 instanceof MessageForMixedMsg;
        localObject1 = ", resultIndex[";
        if (!bool2) {
          break;
        }
        localObject1 = (MessageForMixedMsg)localObject2;
        k = i;
        bool2 = bool1;
      } while (((MessageForMixedMsg)localObject1).msgElemList == null);
      k = 0;
      Object localObject3;
      while (k < ((MessageForMixedMsg)localObject1).msgElemList.size())
      {
        localObject2 = (MessageRecord)((MessageForMixedMsg)localObject1).msgElemList.get(k);
        if ((localObject2 instanceof MessageForPic))
        {
          if ((i >= paramArrayList.size()) && (QLog.isColorLevel())) {
            QLog.e("MultiMsg_TAG", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
          }
          localObject2 = (MessageForPic)localObject2;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("updateMessageForPic for MessageForMixedMsg, MsgIndex[");
            ((StringBuilder)localObject3).append(m);
            ((StringBuilder)localObject3).append("], subMsgIndex[");
            ((StringBuilder)localObject3).append(k);
            ((StringBuilder)localObject3).append(", resultIndex[");
            ((StringBuilder)localObject3).append(i);
            ((StringBuilder)localObject3).append("]");
            QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject3).toString());
          }
          if (!a((MessageForPic)localObject2, (PicResult)paramArrayList.get(i))) {
            bool1 = false;
          }
          i += 1;
        }
        k += 1;
      }
      k = j;
      j = i;
      bool2 = bool1;
      break label1040;
      int n = j;
      Object localObject4;
      Object localObject5;
      if (((MessageRecord)localObject2).msgtype == -1036)
      {
        localObject2 = ((MessageForLongMsg)localObject2).longMsgFragmentList.iterator();
        for (;;)
        {
          j = i;
          bool2 = bool1;
          k = n;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
          if ((localObject3 instanceof MessageForMixedMsg))
          {
            localObject3 = (MessageForMixedMsg)localObject3;
            if (((MessageForMixedMsg)localObject3).msgElemList != null)
            {
              j = 0;
              while (j < ((MessageForMixedMsg)localObject3).msgElemList.size())
              {
                localObject4 = (MessageRecord)((MessageForMixedMsg)localObject3).msgElemList.get(j);
                if ((localObject4 instanceof MessageForPic))
                {
                  if ((i >= paramArrayList.size()) && (QLog.isColorLevel())) {
                    QLog.e("MultiMsg_TAG", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
                  }
                  localObject4 = (MessageForPic)localObject4;
                  if (QLog.isColorLevel())
                  {
                    localObject5 = new StringBuilder();
                    ((StringBuilder)localObject5).append("updateMessageForPic for MessageForMixedMsg, MsgIndex[");
                    ((StringBuilder)localObject5).append(m);
                    ((StringBuilder)localObject5).append("], subMsgIndex[");
                    ((StringBuilder)localObject5).append(j);
                    ((StringBuilder)localObject5).append((String)localObject1);
                    ((StringBuilder)localObject5).append(i);
                    ((StringBuilder)localObject5).append("]");
                    QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject5).toString());
                  }
                  if (!a((MessageForPic)localObject4, (PicResult)paramArrayList.get(i))) {
                    bool1 = false;
                  }
                  i += 1;
                }
                j += 1;
              }
            }
          }
        }
      }
      j = i;
      bool2 = bool1;
      k = n;
      if ((localObject2 instanceof MessageForStructing))
      {
        localObject5 = (MessageForStructing)localObject2;
        localObject1 = ((MessageForStructing)localObject5).structingMsg;
        j = i;
        bool2 = bool1;
        k = n;
        if (localObject1 != null)
        {
          j = i;
          bool2 = bool1;
          k = n;
          if ((localObject1 instanceof StructMsgForImageShare))
          {
            localObject3 = ((StructMsgForImageShare)localObject1).getFirstImageElement();
            j = i;
            bool2 = bool1;
            k = n;
            if (localObject3 != null)
            {
              j = i;
              bool2 = bool1;
              k = n;
              if (((StructMsgItemImage)localObject3).a != null)
              {
                localObject4 = ((StructMsgItemImage)localObject3).a;
                if (QLog.isColorLevel())
                {
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("updateMessageForPic for MessageForPic, MsgIndex[");
                  localStringBuilder.append(m);
                  localStringBuilder.append("], resultIndex[");
                  localStringBuilder.append(i);
                  localStringBuilder.append("]");
                  QLog.d("MultiMsg_TAG", 2, localStringBuilder.toString());
                }
                if (((MessageForStructing)localObject5).isHotPicsStruct())
                {
                  localObject5 = new PicMessageExtraData();
                  ((PicMessageExtraData)localObject5).imageBizType = 2;
                  ((MessageForPic)localObject4).picExtraData = ((PicMessageExtraData)localObject5);
                }
                if (!a((MessageForPic)localObject4, (PicResult)paramArrayList.get(i)))
                {
                  bool1 = false;
                }
                else
                {
                  ((StructMsgItemImage)localObject3).ad = ((MessageForPic)localObject4).uuid;
                  ((StructMsgItemImage)localObject3).ae = ((MessageForPic)localObject4).md5;
                  ((StructMsgItemImage)localObject3).ac = ((MessageForPic)localObject4).path;
                  ((MessageRecord)localObject2).msgData = ((AbsStructMsg)localObject1).getBytes();
                }
                j = i + 1;
                k = n;
                bool2 = bool1;
              }
            }
          }
        }
      }
      label1040:
      m += 1;
      i = j;
    }
    if (k != 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isReMultiMsg) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800662B", "0X800662B", 0, 1, 0, "", "", "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg_TAG", 2, "requestUploadPics isPicMsgModify");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(this.jdField_a_of_type_JavaUtilArrayList, null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isReMultiMsg) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800662A", "0X800662A", 0, 1, 0, "", "", "", "");
    }
    return bool1;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, ArrayList<PicResult> paramArrayList)
  {
    boolean bool;
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onForwardMultiMsgPicsUpload success[");
        localStringBuilder.append(paramArrayList.size());
        localStringBuilder.append("]");
        QLog.d("MultiMsg_TAG", 2, localStringBuilder.toString());
      }
      bool = a(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "updateMsgRecords done, goto onPackAndSendMsg");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg_TAG", 2, "onForwardMultiMsgPicsUpload failed");
      }
      bool = false;
    }
    if (this.jdField_a_of_type_Int == 5) {
      MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, 1);
    } else {
      MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, 1);
    }
    if ((this.jdField_a_of_type_Int != 5) && (MultiMsgManager.c(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager) == 0))
    {
      MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_JavaUtilArrayList, bool, this.jdField_a_of_type_Int);
      return;
    }
    if ((this.jdField_a_of_type_Int == 5) && (MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq)))
    {
      if (bool)
      {
        MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_JavaUtilArrayList, true, this.jdField_a_of_type_Int);
        return;
      }
      MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager.3
 * JD-Core Version:    0.7.0.1
 */