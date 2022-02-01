package com.tencent.mobileqq.richmedia.ordersend;

import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class OrderMediaMsgManager$1
  extends MessageObserver
{
  OrderMediaMsgManager$1(OrderMediaMsgManager paramOrderMediaMsgManager) {}
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramList != null) && (!paramList.isEmpty()) && ((paramList.get(0) instanceof MessageForShortVideo))) {
      AIOGalleryMsgRevokeMgr.a((MessageRecord)paramList.get(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager.1
 * JD-Core Version:    0.7.0.1
 */