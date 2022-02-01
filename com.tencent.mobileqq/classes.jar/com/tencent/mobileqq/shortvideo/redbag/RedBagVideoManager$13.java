package com.tencent.mobileqq.shortvideo.redbag;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;

class RedBagVideoManager$13
  implements Runnable
{
  RedBagVideoManager$13(RedBagVideoManager paramRedBagVideoManager) {}
  
  public void run()
  {
    if (RedBagVideoManager.a(this.this$0) != null)
    {
      RedBagVideoManager.a(this.this$0).h = 1;
      long l = RedBagVideoManager.a(this.this$0).a;
      String str = RedBagVideoManager.a(this.this$0).e;
      int i = RedBagVideoManager.a(this.this$0).g;
      Bundle localBundle = new Bundle();
      localBundle.putLong("VALUE_MSG_UINSEQ", l);
      localBundle.putString("VALUE_MSG_FRIENDUIN", str);
      localBundle.putInt("VALUE_MSG_ISTROOP", i);
      localBundle.putString("VALUE_MSG_VIDEO_ID", RedBagVideoManager.a(this.this$0).c);
      VideoPlayIPCClient.a().a("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.13
 * JD-Core Version:    0.7.0.1
 */