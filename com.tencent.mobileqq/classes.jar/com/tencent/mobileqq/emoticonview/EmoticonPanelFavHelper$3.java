package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqManagerProxy;
import com.tencent.qphone.base.util.QLog;

class EmoticonPanelFavHelper$3
  implements Runnable
{
  EmoticonPanelFavHelper$3(EmoticonPanelFavHelper paramEmoticonPanelFavHelper) {}
  
  public void run()
  {
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = this.this$0.mPanelController.app;
    if (localQQEmoticonMainPanelApp != null)
    {
      ((VipComicMqqManagerProxy)localQQEmoticonMainPanelApp.getManager(QQManagerFactory.MQQ_COMIC_MANAGER)).uploadInitComicEmoStructMsgInfo();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelFavHelper", 2, "vipComicMqqManager.uploadInitComicEmoStructMsgInfo");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.3
 * JD-Core Version:    0.7.0.1
 */