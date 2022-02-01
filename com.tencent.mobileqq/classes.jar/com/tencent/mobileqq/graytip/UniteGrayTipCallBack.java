package com.tencent.mobileqq.graytip;

import com.tencent.qphone.base.util.QLog;

public class UniteGrayTipCallBack
{
  public void a(MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageForUniteGrayTip", 2, "onPreAddedMsg");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipCallBack
 * JD-Core Version:    0.7.0.1
 */