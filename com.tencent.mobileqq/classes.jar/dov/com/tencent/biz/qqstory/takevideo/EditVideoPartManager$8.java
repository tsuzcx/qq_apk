package dov.com.tencent.biz.qqstory.takevideo;

import android.content.Intent;

class EditVideoPartManager$8
  implements Runnable
{
  EditVideoPartManager$8(EditVideoPartManager paramEditVideoPartManager, Intent paramIntent) {}
  
  public void run()
  {
    if (this.this$0.a.a() != 102)
    {
      String str = this.a.getStringExtra("key_video_save_path");
      EditVideoPartManager.a(this.this$0, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.8
 * JD-Core Version:    0.7.0.1
 */