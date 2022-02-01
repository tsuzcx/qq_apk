package com.tencent.mobileqq.richmedia.ordersend;

import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class MediaMsgController$1
  extends MessageObserver
{
  MediaMsgController$1(MediaMsgController paramMediaMsgController, BaseMessageObserver paramBaseMessageObserver, MessageRecord paramMessageRecord) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 5006)
    {
      BaseMessageObserver localBaseMessageObserver = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver;
      if (localBaseMessageObserver == null)
      {
        paramObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        long l;
        if (paramObject != null) {
          l = paramObject.uniseq;
        } else {
          l = 0L;
        }
        QLog.d("MediaMsgController", 1, new Object[] { "observer is null! uniseq:", Long.valueOf(l), " ,isSuccess:", Boolean.valueOf(paramBoolean) });
        return;
      }
      localBaseMessageObserver.onUpdate(paramInt, paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.MediaMsgController.1
 * JD-Core Version:    0.7.0.1
 */