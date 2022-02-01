package com.tencent.mobileqq.shortvideo.redbag;

import android.os.Bundle;
import bckg;
import bckr;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;

public class RedBagVideoManager$13
  implements Runnable
{
  public RedBagVideoManager$13(bckg parambckg) {}
  
  public void run()
  {
    if (bckg.a(this.this$0) != null)
    {
      bckg.a(this.this$0).h = 1;
      long l = bckg.a(this.this$0).a;
      String str = bckg.a(this.this$0).e;
      int i = bckg.a(this.this$0).g;
      Bundle localBundle = new Bundle();
      localBundle.putLong("VALUE_MSG_UINSEQ", l);
      localBundle.putString("VALUE_MSG_FRIENDUIN", str);
      localBundle.putInt("VALUE_MSG_ISTROOP", i);
      localBundle.putString("VALUE_MSG_VIDEO_ID", bckg.a(this.this$0).c);
      bckr.a().a("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.13
 * JD-Core Version:    0.7.0.1
 */