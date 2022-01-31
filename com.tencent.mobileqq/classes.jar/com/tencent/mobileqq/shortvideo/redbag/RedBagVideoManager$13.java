package com.tencent.mobileqq.shortvideo.redbag;

import android.os.Bundle;
import axjs;
import axkd;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;

public class RedBagVideoManager$13
  implements Runnable
{
  public RedBagVideoManager$13(axjs paramaxjs) {}
  
  public void run()
  {
    if (axjs.a(this.this$0) != null)
    {
      axjs.a(this.this$0).h = 1;
      long l = axjs.a(this.this$0).a;
      String str = axjs.a(this.this$0).e;
      int i = axjs.a(this.this$0).g;
      Bundle localBundle = new Bundle();
      localBundle.putLong("VALUE_MSG_UINSEQ", l);
      localBundle.putString("VALUE_MSG_FRIENDUIN", str);
      localBundle.putInt("VALUE_MSG_ISTROOP", i);
      localBundle.putString("VALUE_MSG_VIDEO_ID", axjs.a(this.this$0).c);
      axkd.a().a("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.13
 * JD-Core Version:    0.7.0.1
 */