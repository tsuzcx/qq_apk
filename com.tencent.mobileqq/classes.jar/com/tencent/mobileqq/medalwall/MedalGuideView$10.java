package com.tencent.mobileqq.medalwall;

import axqw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

final class MedalGuideView$10
  implements Runnable
{
  MedalGuideView$10(int paramInt) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    axqw.b(localQQAppInterface, "dc00898", "", "", "0X80088EA", "0X80088EA", this.a, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalGuideView.10
 * JD-Core Version:    0.7.0.1
 */