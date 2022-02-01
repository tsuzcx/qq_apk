package com.tencent.mobileqq.kandian.biz.reddot;

import com.tencent.mobileqq.kandian.repo.diandian.IEntranceButtonDataSource;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;

class ColorBandVideoEntranceButton$10
  extends ReadInJoyObserver
{
  ColorBandVideoEntranceButton$10(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton) {}
  
  public void a(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    this.a.setDataSource(paramIEntranceButtonDataSource);
    Object localObject = this.a;
    ((ColorBandVideoEntranceButton)localObject).a(ColorBandVideoEntranceButton.a((ColorBandVideoEntranceButton)localObject));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onHandle0x6cfResp reddot,data=");
    ((StringBuilder)localObject).append(paramIEntranceButtonDataSource);
    QLog.d("ColorBandVideoEntranceButton", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reddot.ColorBandVideoEntranceButton.10
 * JD-Core Version:    0.7.0.1
 */