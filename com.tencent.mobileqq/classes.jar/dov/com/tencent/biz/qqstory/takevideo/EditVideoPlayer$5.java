package dov.com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;

class EditVideoPlayer$5
  implements Runnable
{
  EditVideoPlayer$5(EditVideoPlayer paramEditVideoPlayer, int paramInt) {}
  
  public void run()
  {
    SLog.a("Q.qqstory.record.EditVideoPlayer", "setPlayMode %d", Integer.valueOf(this.a));
    VideoSourceHelper.nativeSetPlayMode(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.5
 * JD-Core Version:    0.7.0.1
 */