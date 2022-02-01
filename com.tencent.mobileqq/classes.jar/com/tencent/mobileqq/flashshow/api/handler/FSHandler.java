package com.tencent.mobileqq.flashshow.api.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.flashshow.api.helper.FSObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.MobileQQ;

public class FSHandler
  extends BusinessHandler
{
  private static final String TAG = "FSEeveeRedPoint";
  
  protected FSHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public static FSHandler getFSHandler()
  {
    if ((MobileQQ.sMobileQQ.waitAppRuntime(null) instanceof AppInterface)) {
      return (FSHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(FSHandler.class.getName());
    }
    return null;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return FSObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void updateRedPoint()
  {
    notifyUI(1000, true, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.handler.FSHandler
 * JD-Core Version:    0.7.0.1
 */