package com.tencent.mobileqq.shortvideo.redbag;

import android.os.Bundle;
import bdcy;
import bddj;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;

public class RedBagVideoManager$13
  implements Runnable
{
  public RedBagVideoManager$13(bdcy parambdcy) {}
  
  public void run()
  {
    if (bdcy.a(this.this$0) != null)
    {
      bdcy.a(this.this$0).h = 1;
      long l = bdcy.a(this.this$0).a;
      String str = bdcy.a(this.this$0).e;
      int i = bdcy.a(this.this$0).g;
      Bundle localBundle = new Bundle();
      localBundle.putLong("VALUE_MSG_UINSEQ", l);
      localBundle.putString("VALUE_MSG_FRIENDUIN", str);
      localBundle.putInt("VALUE_MSG_ISTROOP", i);
      localBundle.putString("VALUE_MSG_VIDEO_ID", bdcy.a(this.this$0).c);
      bddj.a().a("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.13
 * JD-Core Version:    0.7.0.1
 */