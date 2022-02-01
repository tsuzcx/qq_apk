package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;

class EditJumpToPtu$2
  implements Runnable
{
  EditJumpToPtu$2(EditJumpToPtu paramEditJumpToPtu, String paramString) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.a(this.a);
    if (localBitmap != null) {
      VideoFilterTools.a().a(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditJumpToPtu.2
 * JD-Core Version:    0.7.0.1
 */