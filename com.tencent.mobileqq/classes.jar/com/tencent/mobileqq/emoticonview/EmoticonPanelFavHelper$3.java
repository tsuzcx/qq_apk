package com.tencent.mobileqq.emoticonview;

import asgo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

class EmoticonPanelFavHelper$3
  implements Runnable
{
  EmoticonPanelFavHelper$3(EmoticonPanelFavHelper paramEmoticonPanelFavHelper) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = this.this$0.mPanelController.app;
    if (localQQAppInterface != null)
    {
      ((asgo)localQQAppInterface.getManager(QQManagerFactory.MQQ_COMIC_MANAGER)).a();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelFavHelper", 2, "vipComicMqqManager.uploadInitComicEmoStructMsgInfo");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.3
 * JD-Core Version:    0.7.0.1
 */