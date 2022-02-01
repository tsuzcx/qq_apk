package dov.com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;

class EditJumpToPtu$1
  implements Runnable
{
  EditJumpToPtu$1(EditJumpToPtu paramEditJumpToPtu) {}
  
  public void run()
  {
    EditJumpToPtu.a(this.this$0, EditPicConstants.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.a(EditJumpToPtu.a(this.this$0)))
    {
      this.this$0.a.sendEmptyMessage(1);
      return;
    }
    EditJumpToPtu.a(this.this$0, null);
    SLog.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.a.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */