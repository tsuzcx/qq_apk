package com.tencent.mobileqq.shortvideo.redbag;

import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;

class RedBagVideoManager$UpdateTask
  extends AsyncTask<String, Integer, Boolean>
{
  RedBagVideoManager$UpdateTask(RedBagVideoManager paramRedBagVideoManager) {}
  
  protected Boolean a(String... paramVarArgs)
  {
    if (RedBagVideoManager.a(this.a) != null)
    {
      RedBagVideoManager.a(this.a).h = 1;
      long l = RedBagVideoManager.a(this.a).a;
      paramVarArgs = RedBagVideoManager.a(this.a).e;
      int i = RedBagVideoManager.a(this.a).g;
      Bundle localBundle = new Bundle();
      localBundle.putLong("VALUE_MSG_UINSEQ", l);
      localBundle.putString("VALUE_MSG_FRIENDUIN", paramVarArgs);
      localBundle.putInt("VALUE_MSG_ISTROOP", i);
      localBundle.putString("VALUE_MSG_VIDEO_ID", RedBagVideoManager.a(this.a).c);
      VideoPlayIPCClient.a().a("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", localBundle);
    }
    return Boolean.valueOf(true);
  }
  
  protected void a(Boolean paramBoolean)
  {
    this.a.b(RedBagVideoManager.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.UpdateTask
 * JD-Core Version:    0.7.0.1
 */