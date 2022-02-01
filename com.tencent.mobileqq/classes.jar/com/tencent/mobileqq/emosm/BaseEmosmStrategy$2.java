package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.emosm.favroaming.FavEmoSendControl;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

class BaseEmosmStrategy$2
  implements Runnable
{
  BaseEmosmStrategy$2(BaseEmosmStrategy paramBaseEmosmStrategy, ArrayList paramArrayList) {}
  
  public void run()
  {
    FavEmoSendControl.a(this.a);
    ReportController.b(null, "dc00898", "", "", "0X800A6E1", "0X800A6E1", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.BaseEmosmStrategy.2
 * JD-Core Version:    0.7.0.1
 */