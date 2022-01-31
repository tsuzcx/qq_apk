package dov.com.tencent.biz.qqstory.takevideo;

import bjts;

public class EditPicSave$4
  implements Runnable
{
  public EditPicSave$4(bjts parambjts) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    bjts localbjts = this.this$0;
    localbjts.jdField_a_of_type_Int += this.this$0.b;
    if (this.this$0.jdField_a_of_type_Int > 99)
    {
      this.this$0.jdField_a_of_type_Int = 99;
      this.this$0.a(this.this$0.jdField_a_of_type_Int);
      return;
    }
    this.this$0.a(this.this$0.jdField_a_of_type_Int);
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.4
 * JD-Core Version:    0.7.0.1
 */