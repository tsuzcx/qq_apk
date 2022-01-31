package dov.com.tencent.biz.qqstory.takevideo;

import bjsj;
import bjsk;
import bjsv;
import veg;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(bjsj parambjsj) {}
  
  public void run()
  {
    bjsj.a(this.this$0, bjsv.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.a(bjsj.a(this.this$0)))
    {
      this.this$0.a.sendEmptyMessage(1);
      return;
    }
    bjsj.a(this.this$0, null);
    veg.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.a.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */