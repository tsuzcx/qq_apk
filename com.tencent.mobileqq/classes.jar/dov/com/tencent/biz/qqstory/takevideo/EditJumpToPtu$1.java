package dov.com.tencent.biz.qqstory.takevideo;

import bibm;
import bibn;
import biby;
import urk;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(bibm parambibm) {}
  
  public void run()
  {
    bibm.a(this.this$0, biby.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.a(bibm.a(this.this$0)))
    {
      this.this$0.a.sendEmptyMessage(1);
      return;
    }
    bibm.a(this.this$0, null);
    urk.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.a.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */