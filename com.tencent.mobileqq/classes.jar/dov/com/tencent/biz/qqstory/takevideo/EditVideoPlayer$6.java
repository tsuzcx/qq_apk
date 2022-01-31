package dov.com.tencent.biz.qqstory.takevideo;

import bjxv;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import ved;

public class EditVideoPlayer$6
  implements Runnable
{
  public EditVideoPlayer$6(bjxv parambjxv, int paramInt) {}
  
  public void run()
  {
    ved.a("Q.qqstory.record.EditVideoPlayer", "setPlayMode %d", Integer.valueOf(this.a));
    VideoSourceHelper.nativeSetPlayMode(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */