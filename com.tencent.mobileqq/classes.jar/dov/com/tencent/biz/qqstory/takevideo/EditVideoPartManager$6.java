package dov.com.tencent.biz.qqstory.takevideo;

class EditVideoPartManager$6
  implements Runnable
{
  EditVideoPartManager$6(EditVideoPartManager paramEditVideoPartManager) {}
  
  public void run()
  {
    if (EditVideoPartManager.b(this.this$0)) {
      return;
    }
    if (EditVideoPartManager.a(this.this$0) < 50.0F) {
      EditVideoPartManager.a(this.this$0, EditVideoPartManager.a(this.this$0) + EditVideoPartManager.b(this.this$0));
    }
    while (EditVideoPartManager.a(this.this$0) > 99.0F)
    {
      EditVideoPartManager.a(this.this$0, 99.0F);
      EditVideoPartManager.a(this.this$0, (int)EditVideoPartManager.a(this.this$0));
      return;
      EditVideoPartManager.c(this.this$0);
    }
    EditVideoPartManager.a(this.this$0, (int)EditVideoPartManager.a(this.this$0));
    EditVideoPartManager.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.6
 * JD-Core Version:    0.7.0.1
 */