package dov.com.tencent.biz.qqstory.takevideo;

import bqhi;

public class EditVideoStoryButton$3
  implements Runnable
{
  public EditVideoStoryButton$3(bqhi parambqhi) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    bqhi localbqhi;
    if (this.this$0.jdField_a_of_type_Float < 50.0F) {
      localbqhi = this.this$0;
    }
    for (localbqhi.jdField_a_of_type_Float += this.this$0.b; this.this$0.jdField_a_of_type_Float > 99.0F; localbqhi.jdField_a_of_type_Float += 1.0F)
    {
      this.this$0.jdField_a_of_type_Float = 99.0F;
      this.this$0.a((int)this.this$0.jdField_a_of_type_Float);
      return;
      localbqhi = this.this$0;
    }
    this.this$0.a((int)this.this$0.jdField_a_of_type_Float);
    this.this$0.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.3
 * JD-Core Version:    0.7.0.1
 */