package com.tencent.mobileqq.weiyun.api.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunGrayTipHelper;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import mqq.app.MobileQQ;

class WeiyunResponseHandlerImpl$TimeOutHandler
  extends Handler
{
  public WeiyunResponseHandlerImpl$TimeOutHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      WeiyunResponseHandlerImpl.access$002(0);
      return;
    }
    if (paramMessage.what == 1)
    {
      WeiyunResponseHandlerImpl localWeiyunResponseHandlerImpl = (WeiyunResponseHandlerImpl)QRoute.api(IWeiyunResponseHandler.class);
      if ((localWeiyunResponseHandlerImpl.isAllRequestFinished()) && (!TextUtils.isEmpty(WeiyunResponseHandlerImpl.access$100())) && (!TextUtils.isEmpty(WeiyunResponseHandlerImpl.access$200())))
      {
        String str1 = WeiyunResponseHandlerImpl.access$100();
        String str2 = WeiyunResponseHandlerImpl.access$200();
        int i = WeiyunResponseHandlerImpl.access$300();
        int j = WeiyunResponseHandlerImpl.access$400();
        String str3 = localWeiyunResponseHandlerImpl.getErrorMsg(MobileQQ.sMobileQQ);
        Process.setThreadPriority(10);
        paramMessage = (AppInterface)paramMessage.obj;
        ((IWeiyunGrayTipHelper)QRoute.api(IWeiyunGrayTipHelper.class)).insertAIOGrayTips(paramMessage, str1, str2, i, j, str3);
        localWeiyunResponseHandlerImpl.reset();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.WeiyunResponseHandlerImpl.TimeOutHandler
 * JD-Core Version:    0.7.0.1
 */