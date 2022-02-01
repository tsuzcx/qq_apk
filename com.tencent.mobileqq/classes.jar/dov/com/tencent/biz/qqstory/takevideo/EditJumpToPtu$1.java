package dov.com.tencent.biz.qqstory.takevideo;

import bncc;
import bncd;
import bncm;
import xvv;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(bncc parambncc) {}
  
  public void run()
  {
    bncc.a(this.this$0, bncm.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.a(bncc.a(this.this$0)))
    {
      this.this$0.a.sendEmptyMessage(1);
      return;
    }
    bncc.a(this.this$0, null);
    xvv.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.a.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */