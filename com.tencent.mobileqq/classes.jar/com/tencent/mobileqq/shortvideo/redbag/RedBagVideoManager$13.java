package com.tencent.mobileqq.shortvideo.redbag;

import android.os.Bundle;
import azey;
import azfj;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;

public class RedBagVideoManager$13
  implements Runnable
{
  public RedBagVideoManager$13(azey paramazey) {}
  
  public void run()
  {
    if (azey.a(this.this$0) != null)
    {
      azey.a(this.this$0).h = 1;
      long l = azey.a(this.this$0).a;
      String str = azey.a(this.this$0).e;
      int i = azey.a(this.this$0).g;
      Bundle localBundle = new Bundle();
      localBundle.putLong("VALUE_MSG_UINSEQ", l);
      localBundle.putString("VALUE_MSG_FRIENDUIN", str);
      localBundle.putInt("VALUE_MSG_ISTROOP", i);
      localBundle.putString("VALUE_MSG_VIDEO_ID", azey.a(this.this$0).c);
      azfj.a().a("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.13
 * JD-Core Version:    0.7.0.1
 */