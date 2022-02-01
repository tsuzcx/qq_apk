package dov.com.tencent.biz.qqstory.takevideo;

class EditVideoSave$5
  implements Runnable
{
  EditVideoSave$5(EditVideoSave paramEditVideoSave) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    EditVideoSave localEditVideoSave;
    if (this.this$0.jdField_a_of_type_Float < 50.0F) {
      localEditVideoSave = this.this$0;
    }
    for (localEditVideoSave.jdField_a_of_type_Float += this.this$0.b; this.this$0.jdField_a_of_type_Float > 99.0F; localEditVideoSave.jdField_a_of_type_Float += 1.0F)
    {
      this.this$0.jdField_a_of_type_Float = 99.0F;
      this.this$0.a((int)this.this$0.jdField_a_of_type_Float);
      return;
      localEditVideoSave = this.this$0;
    }
    this.this$0.a((int)this.this$0.jdField_a_of_type_Float);
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.5
 * JD-Core Version:    0.7.0.1
 */