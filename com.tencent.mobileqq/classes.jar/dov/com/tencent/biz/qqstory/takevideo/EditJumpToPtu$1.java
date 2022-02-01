package dov.com.tencent.biz.qqstory.takevideo;

import boru;
import borv;
import bose;
import ykq;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(boru paramboru) {}
  
  public void run()
  {
    boru.a(this.this$0, bose.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.a(boru.a(this.this$0)))
    {
      this.this$0.a.sendEmptyMessage(1);
      return;
    }
    boru.a(this.this$0, null);
    ykq.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.a.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */