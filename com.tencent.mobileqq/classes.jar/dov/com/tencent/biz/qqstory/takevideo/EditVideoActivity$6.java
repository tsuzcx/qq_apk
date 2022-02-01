package dov.com.tencent.biz.qqstory.takevideo;

import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;

class EditVideoActivity$6
  implements Runnable
{
  EditVideoActivity$6(EditVideoActivity paramEditVideoActivity) {}
  
  public void run()
  {
    CaptureUtil.b();
    VideoFilterTools.a().a(this.this$0.getApplicationContext(), this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity.6
 * JD-Core Version:    0.7.0.1
 */