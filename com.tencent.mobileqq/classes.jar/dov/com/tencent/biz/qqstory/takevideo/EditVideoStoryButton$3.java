package dov.com.tencent.biz.qqstory.takevideo;

import bmjv;

public class EditVideoStoryButton$3
  implements Runnable
{
  public EditVideoStoryButton$3(bmjv parambmjv) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    bmjv localbmjv;
    if (this.this$0.jdField_a_of_type_Float < 50.0F) {
      localbmjv = this.this$0;
    }
    for (localbmjv.jdField_a_of_type_Float += this.this$0.b; this.this$0.jdField_a_of_type_Float > 99.0F; localbmjv.jdField_a_of_type_Float += 1.0F)
    {
      this.this$0.jdField_a_of_type_Float = 99.0F;
      this.this$0.a((int)this.this$0.jdField_a_of_type_Float);
      return;
      localbmjv = this.this$0;
    }
    this.this$0.a((int)this.this$0.jdField_a_of_type_Float);
    this.this$0.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.3
 * JD-Core Version:    0.7.0.1
 */