package dov.com.tencent.biz.qqstory.takevideo;

class EditVideoStoryButton$4
  implements Runnable
{
  EditVideoStoryButton$4(EditVideoStoryButton paramEditVideoStoryButton) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    EditVideoStoryButton localEditVideoStoryButton;
    if (this.this$0.jdField_a_of_type_Float < 50.0F) {
      localEditVideoStoryButton = this.this$0;
    }
    for (localEditVideoStoryButton.jdField_a_of_type_Float += this.this$0.b; this.this$0.jdField_a_of_type_Float > 99.0F; localEditVideoStoryButton.jdField_a_of_type_Float += 1.0F)
    {
      this.this$0.jdField_a_of_type_Float = 99.0F;
      this.this$0.a((int)this.this$0.jdField_a_of_type_Float);
      return;
      localEditVideoStoryButton = this.this$0;
    }
    this.this$0.a((int)this.this$0.jdField_a_of_type_Float);
    this.this$0.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.4
 * JD-Core Version:    0.7.0.1
 */