package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
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
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716140);
  }
  
  public VideoMultiMsgProcessor(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(HashMap<String, ArrayList<MessageRecord>> paramHashMap, ArrayList<MessageForShortVideo> paramArrayList, ArrayList<ShortVideoForwardInfo> paramArrayList1, ShortVideoReq paramShortVideoReq, MultiMsgRequest paramMultiMsgRequest, IMultiMsgRichUploadCallback paramIMultiMsgRichUploadCallback)
  {
    ShortVideoReq localShortVideoReq = paramShortVideoReq;
    if (paramShortVideoReq == null) {
      localShortVideoReq = ShortVideoBusiManager.a(5, 5);
    }
    localShortVideoReq.a(paramArrayList1);
    localShortVideoReq.a(new VideoMultiMsgProcessor.1(this, paramArrayList, paramHashMap, paramIMultiMsgRichUploadCallback, paramMultiMsgRequest));
    ShortVideoBusiManager.a(localShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(MultiMsgRequest paramMultiMsgRequest, HashMap<String, ArrayList<MessageRecord>> paramHashMap, IMultiMsgRichUploadCallback paramIMultiMsgRichUploadCallback)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = null;
    Iterator localIterator1 = paramHashMap.keySet().iterator();
    Object localObject1;
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ArrayList)paramHashMap.get((String)localIterator1.next())).iterator();
      localObject1 = localObject2;
      do
      {
        localObject2 = localObject1;
        if (!localIterator2.hasNext()) {
          break;
        }
        localObject2 = (MessageRecord)localIterator2.next();
      } while ((!(localObject2 instanceof MessageForShortVideo)) && ((!(localObject2 instanceof MessageForReplyText)) || (((MessageForReplyText)localObject2).getSourceMessage() == null) || (!(((MessageForReplyText)localObject2).getSourceMessage() instanceof MessageForShortVideo))));
      if ((localObject2 instanceof MessageForReplyText))
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoMultiMsgProcessor", 2, "[requestSendMultiMsg]MessageForReplyText source");
        }
        localObject2 = ((MessageForReplyText)localObject2).getSourceMessage();
        ((MessageRecord)localObject2).createMessageUniseq();
        localObject2 = (MessageForShortVideo)localObject2;
        label179:
        ((MessageForShortVideo)localObject2).videoFileName = ShortVideoUtils.findVideoPathIfExists((MessageForShortVideo)localObject2);
        if (localObject1 != null) {
          break label343;
        }
        localObject1 = ShortVideoBusiManager.a(5, 5);
      }
    }
    label343:
    for (;;)
    {
      ShortVideoForwardInfo localShortVideoForwardInfo = ShortVideoBusiManager.a(5, localObject2, (ShortVideoReq)localObject1);
      if (localShortVideoForwardInfo != null)
      {
        localArrayList1.add(localShortVideoForwardInfo);
        localArrayList2.add(localObject2);
        break;
        localObject2 = (MessageForShortVideo)localObject2;
        break label179;
      }
      if (QLog.isColorLevel()) {
        QLog.e("VideoMultiMsgProcessor", 2, "[requestSendMultiMsg]createShortVideoForwardInfo failed");
      }
      break;
      if ((localArrayList1.size() > 0) && (localArrayList2.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoMultiMsgProcessor", 2, "[requestSendMultiMsg]Upload videos, count is [" + localArrayList1.size() + "], goto requestUploadVideos");
        }
        a(paramHashMap, localArrayList2, localArrayList1, (ShortVideoReq)localObject2, paramMultiMsgRequest, paramIMultiMsgRichUploadCallback);
        return;
      }
      paramIMultiMsgRichUploadCallback.a(0, 8, paramMultiMsgRequest);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.VideoMultiMsgProcessor
 * JD-Core Version:    0.7.0.1
 */