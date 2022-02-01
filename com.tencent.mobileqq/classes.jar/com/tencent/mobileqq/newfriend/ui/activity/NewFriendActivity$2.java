package com.tencent.mobileqq.newfriend.ui.activity;

import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

final class NewFriendActivity$2
  implements Runnable
{
  NewFriendActivity$2(AppRuntime paramAppRuntime, String paramString) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = this.a;
    String str = this.b;
    ReportController.b(localAppRuntime, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.activity.NewFriendActivity.2
 * JD-Core Version:    0.7.0.1
 */