package com.tencent.mobileqq.kandian.biz.reddot;

import com.tencent.mobileqq.kandian.repo.diandian.EntranceIconInfo;
import com.tencent.qphone.base.util.QLog;

class ColorBandVideoEntranceButton$13
  implements Runnable
{
  ColorBandVideoEntranceButton$13(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton) {}
  
  public void run()
  {
    try
    {
      if (ColorBandVideoEntranceButton.b(this.this$0, ColorBandVideoEntranceButton.f(this.this$0)))
      {
        EntranceIconInfo localEntranceIconInfo = (EntranceIconInfo)ColorBandVideoEntranceButton.f(this.this$0);
        ColorBandVideoEntranceButton.a(this.this$0, localEntranceIconInfo);
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNicknamePopupAttributes error : e = ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("ColorBandVideoEntranceButton", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reddot.ColorBandVideoEntranceButton.13
 * JD-Core Version:    0.7.0.1
 */