package com.tencent.viola.ui.view.vloading;

class VARotateDrawable$1
  implements Runnable
{
  VARotateDrawable$1(VARotateDrawable paramVARotateDrawable) {}
  
  public void run()
  {
    VARotateDrawable.access$002(this.this$0, VARotateDrawable.access$000(this.this$0) + this.this$0.frameRotateDeg);
    if (VARotateDrawable.access$000(this.this$0) > 360.0F - this.this$0.frameRotateDeg) {
      VARotateDrawable.access$002(this.this$0, 0.0F);
    }
    this.this$0.invalidateSelf();
    VARotateDrawable.access$100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.vloading.VARotateDrawable.1
 * JD-Core Version:    0.7.0.1
 */