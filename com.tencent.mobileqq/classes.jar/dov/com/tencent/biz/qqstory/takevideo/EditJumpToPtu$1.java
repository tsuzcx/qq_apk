package dov.com.tencent.biz.qqstory.takevideo;

import bjta;
import bjtb;
import bjtm;
import ved;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(bjta parambjta) {}
  
  public void run()
  {
    bjta.a(this.this$0, bjtm.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.a(bjta.a(this.this$0)))
    {
      this.this$0.a.sendEmptyMessage(1);
      return;
    }
    bjta.a(this.this$0, null);
    ved.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.a.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */