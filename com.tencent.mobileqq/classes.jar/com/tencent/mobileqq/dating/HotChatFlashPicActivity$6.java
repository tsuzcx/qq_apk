package com.tencent.mobileqq.dating;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bcef;

class HotChatFlashPicActivity$6
  implements Runnable
{
  HotChatFlashPicActivity$6(HotChatFlashPicActivity paramHotChatFlashPicActivity) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.this$0.getSharedPreferences(HotChatFlashPicActivity.f(this.this$0), 4).edit();
    if (HotChatFlashPicActivity.b(this.this$0))
    {
      localEditor.putInt("HOTCHAT_FLASHPIC_SHOT", HotChatFlashPicActivity.a(this.this$0));
      if (HotChatFlashPicActivity.a(this.this$0) != 1) {
        break label115;
      }
      bcef.b(this.this$0.app, "CliOper", "", "", "0X800597A", "0X800597A", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      localEditor.commit();
      return;
      localEditor.putInt("commen_flashpic_shot", HotChatFlashPicActivity.a(this.this$0));
      break;
      label115:
      if (HotChatFlashPicActivity.a(this.this$0) == 2)
      {
        if (!HotChatFlashPicActivity.b(this.this$0)) {
          localEditor.putLong("commen_flashpic_shot_deadlineday", HotChatFlashPicActivity.b(this.this$0) + 518400000L);
        }
        bcef.b(this.this$0.app, "CliOper", "", "", "0X800597B", "0X800597B", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.HotChatFlashPicActivity.6
 * JD-Core Version:    0.7.0.1
 */