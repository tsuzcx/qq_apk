package dov.com.tencent.biz.qqstory.takevideo;

import bpac;
import bpad;
import bpao;
import yqp;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(bpac parambpac) {}
  
  public void run()
  {
    bpac.a(this.this$0, bpao.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.a(bpac.a(this.this$0)))
    {
      this.this$0.a.sendEmptyMessage(1);
      return;
    }
    bpac.a(this.this$0, null);
    yqp.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.a.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */