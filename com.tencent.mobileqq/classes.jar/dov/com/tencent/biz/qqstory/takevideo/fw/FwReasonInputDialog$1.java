package dov.com.tencent.biz.qqstory.takevideo.fw;

import com.tencent.biz.qqstory.storyHome.detail.model.cmment.KeyboardAndEmojiManager;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.KeyboardAndEmojiManager.KeyboardAndEmojiStateChangeListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;

class FwReasonInputDialog$1
  implements KeyboardAndEmojiManager.KeyboardAndEmojiStateChangeListener
{
  public void b(boolean paramBoolean)
  {
    if (FwReasonInputDialog.a(this.a).b())
    {
      StoryReportor.a("video_edit", "repost_comment", 0, 0, new String[] { "", "", "", FwReasonInputDialog.a(this.a).a.a("vip_forward_vid") });
      return;
    }
    StoryReportor.a("video_edit", "repost_emoji", 0, 0, new String[] { "", "", "", FwReasonInputDialog.a(this.a).a.a("vip_forward_vid") });
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c(boolean paramBoolean)
  {
    if ((!FwReasonInputDialog.a(this.a).a()) && (!FwReasonInputDialog.a(this.a).c())) {
      this.a.dismiss();
    }
  }
  
  public void d()
  {
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.fw.FwReasonInputDialog.1
 * JD-Core Version:    0.7.0.1
 */