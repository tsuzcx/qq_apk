package dov.com.tencent.biz.qqstory.takevideo;

import bjyd;

public class EditVideoSave$5
  implements Runnable
{
  public EditVideoSave$5(bjyd parambjyd) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    bjyd localbjyd;
    if (this.this$0.jdField_a_of_type_Float < 50.0F) {
      localbjyd = this.this$0;
    }
    for (localbjyd.jdField_a_of_type_Float += this.this$0.b; this.this$0.jdField_a_of_type_Float > 99.0F; localbjyd.jdField_a_of_type_Float += 1.0F)
    {
      this.this$0.jdField_a_of_type_Float = 99.0F;
      this.this$0.a((int)this.this$0.jdField_a_of_type_Float);
      return;
      localbjyd = this.this$0;
    }
    this.this$0.a((int)this.this$0.jdField_a_of_type_Float);
    this.this$0.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.5
 * JD-Core Version:    0.7.0.1
 */