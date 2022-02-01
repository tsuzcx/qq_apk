package com.tencent.mobileqq.emoticonview;

import arce;
import com.tencent.mobileqq.app.QQAppInterface;
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
      ((arce)localQQAppInterface.getManager(141)).a();
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