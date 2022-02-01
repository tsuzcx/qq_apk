package com.tencent.mobileqq.data;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout.ArkSearchReportCallback;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppHandler;
import java.lang.ref.WeakReference;

class ArkBabyqCardInfo$2
  implements ArkAppRootLayout.ArkSearchReportCallback
{
  ArkBabyqCardInfo$2(ArkBabyqCardInfo paramArkBabyqCardInfo) {}
  
  public void a()
  {
    if ((this.a.mBabyQReplyMsg != null) && (this.a.mBabyQReplyMsg.get() != null))
    {
      Object localObject = (MessageForArkBabyqReply)this.a.mBabyQReplyMsg.get();
      localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (localObject != null) {
        localObject = (ArkAppHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.ARKAPP_HANDLER);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ArkBabyqCardInfo.2
 * JD-Core Version:    0.7.0.1
 */