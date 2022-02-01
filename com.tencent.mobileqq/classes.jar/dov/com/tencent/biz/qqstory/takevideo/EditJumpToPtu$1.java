package dov.com.tencent.biz.qqstory.takevideo;

import bqbx;
import bqby;
import bqcj;
import yuk;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(bqbx parambqbx) {}
  
  public void run()
  {
    bqbx.a(this.this$0, bqcj.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.a(bqbx.a(this.this$0)))
    {
      this.this$0.a.sendEmptyMessage(1);
      return;
    }
    bqbx.a(this.this$0, null);
    yuk.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.a.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */