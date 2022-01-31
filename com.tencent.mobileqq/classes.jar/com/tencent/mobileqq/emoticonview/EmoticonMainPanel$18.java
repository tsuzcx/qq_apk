package com.tencent.mobileqq.emoticonview;

import andn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class EmoticonMainPanel$18
  implements Runnable
{
  EmoticonMainPanel$18(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      ((andn)this.this$0.a.getManager(141)).a();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "vipComicMqqManager.uploadInitComicEmoStructMsgInfo");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.18
 * JD-Core Version:    0.7.0.1
 */