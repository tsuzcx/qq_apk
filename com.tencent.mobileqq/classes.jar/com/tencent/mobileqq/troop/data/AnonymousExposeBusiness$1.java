package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.askanonymously.AskAnonymousUtil;

class AnonymousExposeBusiness$1
  implements Runnable
{
  AnonymousExposeBusiness$1(AnonymousExposeBusiness paramAnonymousExposeBusiness, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (AskAnonymousUtil.a(this.a)) {
      ReportController.b(null, "dc00899", "Grp_AIO", "", "ask_tab", "exp_askark", 0, 0, this.a.frienduin, "0", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.AnonymousExposeBusiness.1
 * JD-Core Version:    0.7.0.1
 */