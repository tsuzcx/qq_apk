package com.tencent.mobileqq.dating;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.statistics.ReportController;

class HotChatFlashPicActivity$6
  implements Runnable
{
  HotChatFlashPicActivity$6(HotChatFlashPicActivity paramHotChatFlashPicActivity) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    localObject = ((HotChatFlashPicActivity)localObject).getSharedPreferences(HotChatFlashPicActivity.f((HotChatFlashPicActivity)localObject), 4).edit();
    if (HotChatFlashPicActivity.b(this.this$0)) {
      ((SharedPreferences.Editor)localObject).putInt("HOTCHAT_FLASHPIC_SHOT", HotChatFlashPicActivity.a(this.this$0));
    } else {
      ((SharedPreferences.Editor)localObject).putInt("commen_flashpic_shot", HotChatFlashPicActivity.a(this.this$0));
    }
    if (HotChatFlashPicActivity.a(this.this$0) == 1)
    {
      ReportController.b(this.this$0.app, "CliOper", "", "", "0X800597A", "0X800597A", 0, 0, "", "", "", "");
    }
    else if (HotChatFlashPicActivity.a(this.this$0) >= 2)
    {
      if (!HotChatFlashPicActivity.b(this.this$0)) {
        ((SharedPreferences.Editor)localObject).putLong("commen_flashpic_shot_deadlineday", HotChatFlashPicActivity.b(this.this$0) + 518400000L);
      }
      ReportController.b(this.this$0.app, "CliOper", "", "", "0X800597B", "0X800597B", 0, 0, "", "", "", "");
    }
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.dating.HotChatFlashPicActivity.6
 * JD-Core Version:    0.7.0.1
 */