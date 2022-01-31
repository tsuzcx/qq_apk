package com.tencent.mobileqq.emoticonview;

import appr;
import apvd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class EmoticonPanelFavHelper$3
  implements Runnable
{
  public EmoticonPanelFavHelper$3(apvd paramapvd) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = this.this$0.a.a;
    if (localQQAppInterface != null)
    {
      ((appr)localQQAppInterface.getManager(141)).a();
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