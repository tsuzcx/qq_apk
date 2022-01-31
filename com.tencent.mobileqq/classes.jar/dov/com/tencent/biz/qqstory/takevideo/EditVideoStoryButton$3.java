package dov.com.tencent.biz.qqstory.takevideo;

import bjyl;

public class EditVideoStoryButton$3
  implements Runnable
{
  public EditVideoStoryButton$3(bjyl parambjyl) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    bjyl localbjyl;
    if (this.this$0.jdField_a_of_type_Float < 50.0F) {
      localbjyl = this.this$0;
    }
    for (localbjyl.jdField_a_of_type_Float += this.this$0.b; this.this$0.jdField_a_of_type_Float > 99.0F; localbjyl.jdField_a_of_type_Float += 1.0F)
    {
      this.this$0.jdField_a_of_type_Float = 99.0F;
      this.this$0.a((int)this.this$0.jdField_a_of_type_Float);
      return;
      localbjyl = this.this$0;
    }
    this.this$0.a((int)this.this$0.jdField_a_of_type_Float);
    this.this$0.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.3
 * JD-Core Version:    0.7.0.1
 */