package dov.com.tencent.biz.qqstory.takevideo;

class EditPicSave$4
  implements Runnable
{
  EditPicSave$4(EditPicSave paramEditPicSave) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    EditPicSave localEditPicSave = this.this$0;
    localEditPicSave.jdField_a_of_type_Int += this.this$0.b;
    if (this.this$0.jdField_a_of_type_Int > 99)
    {
      this.this$0.jdField_a_of_type_Int = 99;
      this.this$0.a(this.this$0.jdField_a_of_type_Int);
      return;
    }
    this.this$0.a(this.this$0.jdField_a_of_type_Int);
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.4
 * JD-Core Version:    0.7.0.1
 */