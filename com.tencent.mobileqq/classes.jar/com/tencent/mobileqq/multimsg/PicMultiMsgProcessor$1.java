package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.MultiMsgPicsUploadAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
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

class PicMultiMsgProcessor$1
  extends UiCallBack.MultiMsgPicsUploadAdapter
{
  ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = null;
  
  PicMultiMsgProcessor$1(PicMultiMsgProcessor paramPicMultiMsgProcessor, ArrayList paramArrayList, HashMap paramHashMap, MessageRecord paramMessageRecord, IMultiMsgRichUploadCallback paramIMultiMsgRichUploadCallback, MultiMsgRequest paramMultiMsgRequest) {}
  
  private int a(MessageForPic paramMessageForPic, PicResult paramPicResult)
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    Object localObject1 = paramPicResult.jdField_a_of_type_JavaLangObject;
    int j = 0;
    int k = 1;
    if (localObject1 != null)
    {
      boolean bool = paramPicResult.jdField_a_of_type_JavaLangObject instanceof im_msg_body.NotOnlineImage;
      localObject1 = "";
      Object localObject2;
      if (bool)
      {
        localElem.not_online_image.set((im_msg_body.NotOnlineImage)paramPicResult.jdField_a_of_type_JavaLangObject);
        if (paramMessageForPic.picExtraData != null)
        {
          localObject2 = paramMessageForPic.picExtraData.getOfflineImageResvAttr();
          localElem.not_online_image.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((NotOnlineImageExtPb.ResvAttr)((NotOnlineImageExtPb.ResvAttr)localObject2).get()).toByteArray()), true);
        }
        i = k;
        if (!paramPicResult.b) {
          break label543;
        }
        if (localElem.not_online_image.res_id.has()) {
          localObject1 = localElem.not_online_image.res_id.get().toStringUtf8();
        } else if (localElem.not_online_image.download_path.has()) {
          localObject1 = localElem.not_online_image.download_path.get().toStringUtf8();
        }
        paramMessageForPic.uuid = ((String)localObject1);
        paramMessageForPic.path = ((String)localObject1);
        paramMessageForPic.md5 = FileUtils.calcMd5(MultiMsgManager.a);
        paramMessageForPic.thumbMsgUrl = localElem.not_online_image.str_thumb_url.get();
        paramMessageForPic.thumbHeight = localElem.not_online_image.uint32_thumb_height.get();
        paramMessageForPic.thumbWidth = localElem.not_online_image.uint32_thumb_width.get();
        paramMessageForPic.msgData = paramMessageForPic.getSerialPB().toByteArray();
        i = k;
        if (!QLog.isColorLevel()) {
          break label543;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" pic resp uuid = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" picMsgMD5 = ");
        ((StringBuilder)localObject2).append(paramMessageForPic.md5);
        ((StringBuilder)localObject2).append(" hasCode = ");
        ((StringBuilder)localObject2).append(paramMessageForPic.hashCode());
        QLog.d("PicMultiMsgProcessor", 2, ((StringBuilder)localObject2).toString());
        i = k;
        break label543;
      }
      if ((paramPicResult.jdField_a_of_type_JavaLangObject instanceof im_msg_body.CustomFace))
      {
        localElem.custom_face.set((im_msg_body.CustomFace)paramPicResult.jdField_a_of_type_JavaLangObject);
        if (paramMessageForPic.picExtraData != null)
        {
          localObject2 = paramMessageForPic.picExtraData.getCustomFaceResvAttr();
          localElem.custom_face.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((CustomFaceExtPb.ResvAttr)((CustomFaceExtPb.ResvAttr)localObject2).get()).toByteArray()), true);
        }
        i = k;
        if (!paramPicResult.b) {
          break label543;
        }
        if (localElem.custom_face.str_file_path.has()) {
          localObject1 = localElem.custom_face.str_file_path.get();
        }
        paramMessageForPic.uuid = ((String)localObject1);
        paramMessageForPic.path = ((String)localObject1);
        paramMessageForPic.md5 = FileUtils.calcMd5(MultiMsgManager.a);
        paramMessageForPic.msgData = paramMessageForPic.getSerialPB().toByteArray();
        i = k;
        break label543;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("WTF, picResult.mExtraObj is ");
        ((StringBuilder)localObject1).append(paramPicResult.jdField_a_of_type_JavaLangObject.getClass().getSimpleName());
        QLog.e("PicMultiMsgProcessor", 2, ((StringBuilder)localObject1).toString());
      }
    }
    int i = 0;
    label543:
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicMultiMsgProcessor", 2, "updateMessageForPic success");
      }
      localRichText.elems.add(localElem);
      if (paramPicResult.jdField_a_of_type_Int != 0)
      {
        if (paramPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo != null) {
          i = paramPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_Int;
        } else {
          i = -1;
        }
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.e("PicMultiMsgProcessor", 2, "[requestUploadPics] Bad picture element");
          j = i;
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicMultiMsgProcessor", 2, "updateMessageForPic failed, add empty element");
      }
      j = -1;
    }
    paramMessageForPic.richText = localRichText;
    return j;
  }
  
  private boolean a(ArrayList<PicResult> paramArrayList)
  {
    Object localObject1 = this;
    int n = 0;
    int k = 0;
    int i = 0;
    boolean bool1 = false;
    while (n < ((1)localObject1).b.size())
    {
      Object localObject3 = (MessageRecord)((1)localObject1).b.get(n);
      int j = k;
      if (i < paramArrayList.size())
      {
        j = k;
        if (((PicResult)paramArrayList.get(i)).b) {
          j = 1;
        }
      }
      Object localObject2;
      boolean bool2;
      if (!(localObject3 instanceof MessageForPic))
      {
        boolean bool3 = localObject3 instanceof MessageForReplyText;
        if (bool3)
        {
          localObject2 = (MessageForReplyText)localObject3;
          if ((((MessageForReplyText)localObject2).getSourceMessage() != null) && ((((MessageForReplyText)localObject2).getSourceMessage() instanceof MessageForPic))) {}
        }
        else
        {
          bool2 = localObject3 instanceof MessageForMixedMsg;
          localObject2 = ", resultIndex[";
          k = j;
          Object localObject4;
          if (!bool2) {
            if (bool3)
            {
              localObject4 = (MessageForReplyText)localObject3;
              if ((((MessageForReplyText)localObject4).getSourceMessage() != null) && ((((MessageForReplyText)localObject4).getSourceMessage() instanceof MessageForMixedMsg))) {}
            }
            else
            {
              m = ((MessageRecord)localObject3).msgtype;
              if (m != -1036) {
                if (bool3)
                {
                  localObject2 = (MessageForReplyText)localObject3;
                  if ((((MessageForReplyText)localObject2).getSourceMessage() != null) && (((MessageForReplyText)localObject2).getSourceMessage().msgtype == -1036)) {}
                }
                else
                {
                  if (!(localObject3 instanceof MessageForStructing))
                  {
                    if (bool3)
                    {
                      localObject2 = (MessageForReplyText)localObject3;
                      if ((((MessageForReplyText)localObject2).getSourceMessage() == null) || (!(((MessageForReplyText)localObject2).getSourceMessage() instanceof MessageForMixedMsg))) {}
                    }
                  }
                  else
                  {
                    if (bool3)
                    {
                      localObject2 = (MessageForStructing)((MessageForReplyText)localObject3).getSourceMessage();
                      localObject3 = ((MessageForStructing)localObject2).structingMsg;
                    }
                    else
                    {
                      localObject2 = (MessageForStructing)localObject3;
                      localObject3 = ((MessageForStructing)localObject2).structingMsg;
                    }
                    if ((localObject3 != null) && ((localObject3 instanceof StructMsgForImageShare)))
                    {
                      localObject3 = ((StructMsgForImageShare)localObject3).getFirstImageElement();
                      if ((localObject3 != null) && (((StructMsgItemImage)localObject3).a != null))
                      {
                        localObject3 = ((StructMsgItemImage)localObject3).a;
                        if (QLog.isColorLevel())
                        {
                          localObject4 = new StringBuilder();
                          ((StringBuilder)localObject4).append("updateMessageForPic for MessageForPic, MsgIndex[");
                          ((StringBuilder)localObject4).append(n);
                          ((StringBuilder)localObject4).append("], resultIndex[");
                          ((StringBuilder)localObject4).append(i);
                          ((StringBuilder)localObject4).append("]");
                          QLog.d("PicMultiMsgProcessor", 2, ((StringBuilder)localObject4).toString());
                        }
                        if (((MessageForStructing)localObject2).isHotPicsStruct())
                        {
                          localObject2 = new PicMessageExtraData();
                          ((PicMessageExtraData)localObject2).imageBizType = 2;
                          ((MessageForPic)localObject3).picExtraData = ((PicMessageExtraData)localObject2);
                        }
                        k = ((1)localObject1).a((MessageForPic)localObject3, (PicResult)paramArrayList.get(i));
                        if (k != 0)
                        {
                          ((1)localObject1).b(k);
                          if (((1)localObject1).jdField_a_of_type_ComTencentMobileqqMultimsgPicMultiMsgProcessor.a(k)) {
                            bool1 = true;
                          }
                        }
                        i += 1;
                      }
                    }
                  }
                  k = j;
                  break label1676;
                }
              }
              if (bool3) {
                localObject2 = (MessageForLongMsg)((MessageForReplyText)localObject3).getSourceMessage();
              } else {
                localObject2 = (MessageForLongMsg)localObject3;
              }
              localObject2 = ((MessageForLongMsg)localObject2).longMsgFragmentList.iterator();
              for (bool2 = bool1;; bool2 = bool1)
              {
                m = i;
                j = k;
                bool1 = bool2;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                localObject3 = (MessageRecord)((Iterator)localObject2).next();
                if ((localObject3 instanceof MessageForMixedMsg))
                {
                  localObject3 = (MessageForMixedMsg)localObject3;
                  if (((MessageForMixedMsg)localObject3).msgElemList != null)
                  {
                    j = i;
                    bool1 = bool2;
                    m = 0;
                    i = k;
                    k = m;
                    while (k < ((MessageForMixedMsg)localObject3).msgElemList.size())
                    {
                      localObject4 = (MessageRecord)((MessageForMixedMsg)localObject3).msgElemList.get(k);
                      if ((localObject4 instanceof MessageForPic))
                      {
                        if ((j >= paramArrayList.size()) && (QLog.isColorLevel())) {
                          QLog.e("PicMultiMsgProcessor", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
                        }
                        localObject4 = (MessageForPic)localObject4;
                        if (QLog.isColorLevel())
                        {
                          StringBuilder localStringBuilder = new StringBuilder();
                          localStringBuilder.append("updateMessageForPic for MessageForMixedMsg, MsgIndex[");
                          localStringBuilder.append(n);
                          localStringBuilder.append("], subMsgIndex[");
                          localStringBuilder.append(k);
                          localStringBuilder.append(", resultIndex[");
                          localStringBuilder.append(j);
                          localStringBuilder.append("]");
                          QLog.d("PicMultiMsgProcessor", 2, localStringBuilder.toString());
                        }
                        m = ((1)localObject1).a((MessageForPic)localObject4, (PicResult)paramArrayList.get(j));
                        if (m != 0)
                        {
                          ((1)localObject1).b(m);
                          if (((1)localObject1).jdField_a_of_type_ComTencentMobileqqMultimsgPicMultiMsgProcessor.a(m))
                          {
                            bool1 = true;
                          }
                          else
                          {
                            localObject1 = ((1)localObject1).jdField_a_of_type_ComTencentMobileqqMultimsgPicMultiMsgProcessor.a.getMultiMessageProxy().a((MessageRecord)localObject4, HardCodeUtil.a(2131708157), false);
                            ((MessageForMixedMsg)localObject3).msgElemList.set(k, localObject1);
                            if (QLog.isColorLevel()) {
                              QLog.e("PicMultiMsgProcessor", 2, String.format("updateMessageForLongMsg errCode:%d, uniseq:%d", new Object[] { Integer.valueOf(m), Long.valueOf(((MessageRecord)localObject1).uniseq) }));
                            }
                            i = 1;
                          }
                        }
                        j += 1;
                      }
                      k += 1;
                      localObject1 = this;
                    }
                    localObject1 = localObject2;
                    k = i;
                    break label962;
                  }
                }
                localObject1 = localObject2;
                bool1 = bool2;
                j = i;
                label962:
                localObject2 = this;
                localObject3 = localObject1;
                localObject1 = localObject2;
                i = j;
                localObject2 = localObject3;
              }
            }
          }
          bool2 = bool1;
          if (bool3) {
            localObject1 = (MessageForMixedMsg)((MessageForReplyText)localObject3).getSourceMessage();
          } else {
            localObject1 = (MessageForMixedMsg)localObject3;
          }
          int m = i;
          j = k;
          bool1 = bool2;
          if (((MessageForMixedMsg)localObject1).msgElemList != null)
          {
            j = i;
            i = k;
            k = 0;
            bool1 = bool2;
            while (k < ((MessageForMixedMsg)localObject1).msgElemList.size())
            {
              localObject3 = (MessageRecord)((MessageForMixedMsg)localObject1).msgElemList.get(k);
              if ((localObject3 instanceof MessageForPic))
              {
                if ((j >= paramArrayList.size()) && (QLog.isColorLevel())) {
                  QLog.e("PicMultiMsgProcessor", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
                }
                localObject3 = (MessageForPic)localObject3;
                if (QLog.isColorLevel())
                {
                  localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append("updateMessageForPic for MessageForMixedMsg, MsgIndex[");
                  ((StringBuilder)localObject4).append(n);
                  ((StringBuilder)localObject4).append("], subMsgIndex[");
                  ((StringBuilder)localObject4).append(k);
                  ((StringBuilder)localObject4).append((String)localObject2);
                  ((StringBuilder)localObject4).append(j);
                  ((StringBuilder)localObject4).append("]");
                  QLog.d("PicMultiMsgProcessor", 2, ((StringBuilder)localObject4).toString());
                }
                m = a((MessageForPic)localObject3, (PicResult)paramArrayList.get(j));
                if (m != 0)
                {
                  b(m);
                  if (this.jdField_a_of_type_ComTencentMobileqqMultimsgPicMultiMsgProcessor.a(m))
                  {
                    bool1 = true;
                  }
                  else
                  {
                    localObject3 = this.jdField_a_of_type_ComTencentMobileqqMultimsgPicMultiMsgProcessor.a.getMultiMessageProxy().a((MessageRecord)localObject3, HardCodeUtil.a(2131708156), false);
                    ((MessageForMixedMsg)localObject1).msgElemList.set(k, localObject3);
                    if (QLog.isColorLevel()) {
                      QLog.e("PicMultiMsgProcessor", 2, String.format("updateMessageForMixedMsg errCode:%d, uniseq:%d", new Object[] { Integer.valueOf(m), Long.valueOf(((MessageRecord)localObject3).uniseq) }));
                    }
                    i = 1;
                  }
                }
                j += 1;
              }
              k += 1;
            }
            m = j;
            j = i;
          }
          localObject1 = this;
          i = m;
          break label1673;
        }
      }
      if ((i >= paramArrayList.size()) && (QLog.isColorLevel())) {
        QLog.e("PicMultiMsgProcessor", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
      }
      if ((localObject3 instanceof MessageForReplyText)) {
        localObject2 = (MessageForPic)((MessageForReplyText)localObject3).getSourceMessage();
      } else {
        localObject2 = (MessageForPic)localObject3;
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("updateMessageForPic for MessageForPic, MsgIndex[");
        ((StringBuilder)localObject3).append(n);
        ((StringBuilder)localObject3).append("], resultIndex[");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("]");
        QLog.d("PicMultiMsgProcessor", 2, ((StringBuilder)localObject3).toString());
      }
      k = ((1)localObject1).a((MessageForPic)localObject2, (PicResult)paramArrayList.get(i));
      if (k != 0)
      {
        ((1)localObject1).b(k);
        if (((1)localObject1).jdField_a_of_type_ComTencentMobileqqMultimsgPicMultiMsgProcessor.a(k))
        {
          bool1 = true;
        }
        else
        {
          localObject3 = ((1)localObject1).jdField_a_of_type_ComTencentMobileqqMultimsgPicMultiMsgProcessor.a.getMultiMessageProxy().a((MessageRecord)localObject2, PicMultiMsgProcessor.a(), false);
          ((MessageRecord)localObject3).setId(((MessageForPic)localObject2).getId());
          ((MessageRecord)localObject3).setStatus(((MessageForPic)localObject2).getStatus());
          ((1)localObject1).b.set(n, localObject3);
          bool2 = ((1)localObject1).jdField_a_of_type_ComTencentMobileqqMultimsgPicMultiMsgProcessor.a.getMultiMessageProxy().a(((1)localObject1).jdField_a_of_type_JavaUtilHashMap, (MessageRecord)localObject3);
          if (QLog.isColorLevel())
          {
            j = 1;
            QLog.e("PicMultiMsgProcessor", 2, String.format("updateMessageForPic errCode:%d, update:%s, uniseq:%d", new Object[] { Integer.valueOf(k), Boolean.valueOf(bool2), Long.valueOf(((MessageRecord)localObject3).uniseq) }));
          }
          else
          {
            j = 1;
          }
        }
      }
      i += 1;
      label1673:
      k = j;
      label1676:
      n += 1;
    }
    if (k != 0)
    {
      if (((1)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isReMultiMsg) {
        ReportController.b(((1)localObject1).jdField_a_of_type_ComTencentMobileqqMultimsgPicMultiMsgProcessor.a, "CliOper", "", "", "0X800662B", "0X800662B", 0, 1, 0, "", "", "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.e("PicMultiMsgProcessor", 2, "requestUploadPics isPicMsgModify");
      }
      ((1)localObject1).jdField_a_of_type_ComTencentMobileqqMultimsgPicMultiMsgProcessor.a.getProxyManager().a().a(((1)localObject1).b, null);
    }
    if (((1)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isReMultiMsg) {
      ReportController.b(((1)localObject1).jdField_a_of_type_ComTencentMobileqqMultimsgPicMultiMsgProcessor.a, "CliOper", "", "", "0X800662A", "0X800662A", 0, 1, 0, "", "", "", "");
    }
    return bool1;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, ArrayList<PicResult> paramArrayList)
  {
    boolean bool1;
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onForwardMultiMsgPicsUpload success[");
        ((StringBuilder)localObject1).append(paramArrayList.size());
        ((StringBuilder)localObject1).append("]");
        QLog.d("PicMultiMsgProcessor", 2, ((StringBuilder)localObject1).toString());
      }
      boolean bool2 = a(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("PicMultiMsgProcessor", 2, "updateMsgRecords done, goto onPackAndSendMsg");
      }
      Object localObject1 = new HashMap();
      ((HashMap)localObject1).put("totalCount", String.valueOf(paramArrayList.size()));
      Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject2 != null)
      {
        ((HashMap)localObject1).put("errCount", String.valueOf(((ArrayList)localObject2).size()));
        ((HashMap)localObject1).put("errCodeStr", Arrays.asList(new ArrayList[] { this.jdField_a_of_type_JavaUtilArrayList }).toString());
        ((HashMap)localObject1).put("errCode", String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.get(0)));
      }
      else
      {
        ((HashMap)localObject1).put("errCount", "0");
        ((HashMap)localObject1).put("errCode", "0");
      }
      localObject2 = StatisticCollector.getInstance(BaseApplication.getContext());
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((StatisticCollector)localObject2).collectPerformance(null, "MultiMsgPicSendResult", bool1, 0L, paramArrayList.size(), (HashMap)localObject1, null);
      bool1 = bool2;
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicMultiMsgProcessor", 2, "onForwardMultiMsgPicsUpload failed");
      }
      paramArrayList = StatisticCollector.getInstance(BaseApplication.getContext());
      if (paramInt == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramArrayList.collectPerformance(null, "MultiMsgPicSendFail", bool1, 0L, 0L, null, null);
      bool1 = true;
    }
    if (bool1)
    {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgIMultiMsgRichUploadCallback.a(1, 1, this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMultimsgIMultiMsgRichUploadCallback.a(0, 1, this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.PicMultiMsgProcessor.1
 * JD-Core Version:    0.7.0.1
 */