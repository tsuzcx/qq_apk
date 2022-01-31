package dov.com.tencent.biz.qqstory.takevideo;

import bigz;

public class EditVideoStoryButton$3
  implements Runnable
{
  public EditVideoStoryButton$3(bigz parambigz) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    bigz localbigz;
    if (this.this$0.jdField_a_of_type_Float < 50.0F) {
      localbigz = this.this$0;
    }
    for (localbigz.jdField_a_of_type_Float += this.this$0.b; this.this$0.jdField_a_of_type_Float > 99.0F; localbigz.jdField_a_of_type_Float += 1.0F)
    {
      this.this$0.jdField_a_of_type_Float = 99.0F;
      this.this$0.a((int)this.this$0.jdField_a_of_type_Float);
      return;
      localbigz = this.this$0;
    }
    this.this$0.a((int)this.this$0.jdField_a_of_type_Float);
    this.this$0.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.3
 * JD-Core Version:    0.7.0.1
 */