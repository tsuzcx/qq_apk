package dov.com.tencent.biz.qqstory.takevideo;

import bqha;

public class EditVideoSave$5
  implements Runnable
{
  public EditVideoSave$5(bqha parambqha) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    bqha localbqha;
    if (this.this$0.jdField_a_of_type_Float < 50.0F) {
      localbqha = this.this$0;
    }
    for (localbqha.jdField_a_of_type_Float += this.this$0.b; this.this$0.jdField_a_of_type_Float > 99.0F; localbqha.jdField_a_of_type_Float += 1.0F)
    {
      this.this$0.jdField_a_of_type_Float = 99.0F;
      this.this$0.a((int)this.this$0.jdField_a_of_type_Float);
      return;
      localbqha = this.this$0;
    }
    this.this$0.a((int)this.this$0.jdField_a_of_type_Float);
    this.this$0.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.5
 * JD-Core Version:    0.7.0.1
 */