package com.tencent.mobileqq.emoticonview.sender;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;

final class CustomEmotionSenderUtil$1
  implements Runnable
{
  CustomEmotionSenderUtil$1(String paramString, BaseSessionInfo paramBaseSessionInfo, BaseQQAppInterface paramBaseQQAppInterface) {}
  
  public void run()
  {
    try
    {
      IEmosmService localIEmosmService = (IEmosmService)QRoute.api(IEmosmService.class);
      String str = this.val$url;
      int i = this.val$sessionInfo.a;
      BaseQQAppInterface localBaseQQAppInterface = this.val$app;
      localIEmosmService.reportSendPicSource(new String[] { str }, i, false, false, -1, localBaseQQAppInterface);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.CustomEmotionSenderUtil.1
 * JD-Core Version:    0.7.0.1
 */