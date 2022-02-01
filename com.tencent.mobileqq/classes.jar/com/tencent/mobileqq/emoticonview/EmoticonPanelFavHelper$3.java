package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqManagerServiceProxy;
import com.tencent.qphone.base.util.QLog;

class EmoticonPanelFavHelper$3
  implements Runnable
{
  EmoticonPanelFavHelper$3(EmoticonPanelFavHelper paramEmoticonPanelFavHelper) {}
  
  public void run()
  {
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = ((EmoticonPanelController)this.this$0.mPanelController).app;
    if (localQQEmoticonMainPanelApp != null)
    {
      ((VipComicMqqManagerServiceProxy)localQQEmoticonMainPanelApp.getRuntimeService(IVipComicMqqManagerService.class)).uploadInitComicEmoStructMsgInfo();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelFavHelper", 2, "vipComicMqqManager.uploadInitComicEmoStructMsgInfo");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.3
 * JD-Core Version:    0.7.0.1
 */