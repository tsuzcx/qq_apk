package dov.com.tencent.biz.qqstory.takevideo;

import boul;

public class EditVideoStoryButton$3
  implements Runnable
{
  public EditVideoStoryButton$3(boul paramboul) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    boul localboul;
    if (this.this$0.jdField_a_of_type_Float < 50.0F) {
      localboul = this.this$0;
    }
    for (localboul.jdField_a_of_type_Float += this.this$0.b; this.this$0.jdField_a_of_type_Float > 99.0F; localboul.jdField_a_of_type_Float += 1.0F)
    {
      this.this$0.jdField_a_of_type_Float = 99.0F;
      this.this$0.a((int)this.this$0.jdField_a_of_type_Float);
      return;
      localboul = this.this$0;
    }
    this.this$0.a((int)this.this$0.jdField_a_of_type_Float);
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.3
 * JD-Core Version:    0.7.0.1
 */