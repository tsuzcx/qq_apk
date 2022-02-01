package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class VideoMultiMsgProcessor
  extends BaseMultiMsgProcessor
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716063);
  }
  
  public VideoMultiMsgProcessor(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(HashMap<String, ArrayList<MessageRecord>> paramHashMap, ArrayList<MessageForShortVideo> paramArrayList, ArrayList<ShortVideoForwardInfo> paramArrayList1, ShortVideoReq paramShortVideoReq, MultiMsgRequest paramMultiMsgRequest, IMultiMsgRichUploadCallback paramIMultiMsgRichUploadCallback)
  {
    ShortVideoReq localShortVideoReq = paramShortVideoReq;
    if (paramShortVideoReq == null) {
      localShortVideoReq = SVBusiUtil.a(5, 5);
    }
    localShortVideoReq.a(paramArrayList1);
    localShortVideoReq.a(new VideoMultiMsgProcessor.1(this, paramArrayList, paramHashMap, paramIMultiMsgRichUploadCallback, paramMultiMsgRequest));
    ShortVideoBusiManager.a(localShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(MultiMsgRequest paramMultiMsgRequest, HashMap<String, ArrayList<MessageRecord>> paramHashMap, IMultiMsgRichUploadCallback paramIMultiMsgRichUploadCallback)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator1 = paramHashMap.keySet().iterator();
    Object localObject2 = null;
    Object localObject1;
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ArrayList)paramHashMap.get((String)localIterator1.next())).iterator();
      localObject1 = localObject2;
      for (;;)
      {
        localObject2 = localObject1;
        if (!localIterator2.hasNext()) {
          break;
        }
        localObject2 = (MessageRecord)localIterator2.next();
        Object localObject3;
        if (!(localObject2 instanceof MessageForShortVideo))
        {
          if ((localObject2 instanceof MessageForReplyText))
          {
            localObject3 = (MessageForReplyText)localObject2;
            if ((((MessageForReplyText)localObject3).getSourceMessage() == null) || (!(((MessageForReplyText)localObject3).getSourceMessage() instanceof MessageForShortVideo))) {}
          }
        }
        else
        {
          if ((localObject2 instanceof MessageForReplyText))
          {
            if (QLog.isColorLevel()) {
              QLog.e("VideoMultiMsgProcessor", 2, "[requestSendMultiMsg]MessageForReplyText source");
            }
            localObject2 = ((MessageForReplyText)localObject2).getSourceMessage();
            ((MessageRecord)localObject2).createMessageUniseq();
            localObject2 = (MessageForShortVideo)localObject2;
          }
          else
          {
            localObject2 = (MessageForShortVideo)localObject2;
          }
          ((MessageForShortVideo)localObject2).videoFileName = ShortVideoUtils.findVideoPathIfExists((MessageForShortVideo)localObject2);
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = SVBusiUtil.a(5, 5);
          }
          localObject1 = ShortVideoBusiManager.a(5, localObject2, (ShortVideoReq)localObject3);
          if (localObject1 != null)
          {
            localArrayList1.add(localObject1);
            localArrayList2.add(localObject2);
            localObject1 = localObject3;
          }
          else
          {
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              QLog.e("VideoMultiMsgProcessor", 2, "[requestSendMultiMsg]createShortVideoForwardInfo failed");
              localObject1 = localObject3;
            }
          }
        }
      }
    }
    if ((localArrayList1.size() > 0) && (localArrayList2.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[requestSendMultiMsg]Upload videos, count is [");
        ((StringBuilder)localObject1).append(localArrayList1.size());
        ((StringBuilder)localObject1).append("], goto requestUploadVideos");
        QLog.d("VideoMultiMsgProcessor", 2, ((StringBuilder)localObject1).toString());
      }
      a(paramHashMap, localArrayList2, localArrayList1, (ShortVideoReq)localObject2, paramMultiMsgRequest, paramIMultiMsgRichUploadCallback);
      return;
    }
    paramIMultiMsgRichUploadCallback.a(0, 8, paramMultiMsgRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.VideoMultiMsgProcessor
 * JD-Core Version:    0.7.0.1
 */