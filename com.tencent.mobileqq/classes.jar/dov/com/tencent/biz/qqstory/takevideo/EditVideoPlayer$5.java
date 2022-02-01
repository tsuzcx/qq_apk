package dov.com.tencent.biz.qqstory.takevideo;

import boub;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import ykq;

public class EditVideoPlayer$5
  implements Runnable
{
  public EditVideoPlayer$5(boub paramboub, int paramInt) {}
  
  public void run()
  {
    ykq.a("Q.qqstory.record.EditVideoPlayer", "setPlayMode %d", Integer.valueOf(this.a));
    VideoSourceHelper.nativeSetPlayMode(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.5
 * JD-Core Version:    0.7.0.1
 */