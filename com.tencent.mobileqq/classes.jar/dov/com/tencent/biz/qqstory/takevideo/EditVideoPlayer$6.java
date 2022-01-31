package dov.com.tencent.biz.qqstory.takevideo;

import bmjf;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import wsv;

public class EditVideoPlayer$6
  implements Runnable
{
  public EditVideoPlayer$6(bmjf parambmjf, int paramInt) {}
  
  public void run()
  {
    wsv.a("Q.qqstory.record.EditVideoPlayer", "setPlayMode %d", Integer.valueOf(this.a));
    VideoSourceHelper.nativeSetPlayMode(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */