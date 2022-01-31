package dov.com.tencent.biz.qqstory.takevideo;

import bmek;
import bmel;
import bmew;
import wsv;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(bmek parambmek) {}
  
  public void run()
  {
    bmek.a(this.this$0, bmew.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.a(bmek.a(this.this$0)))
    {
      this.this$0.a.sendEmptyMessage(1);
      return;
    }
    bmek.a(this.this$0, null);
    wsv.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.a.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */