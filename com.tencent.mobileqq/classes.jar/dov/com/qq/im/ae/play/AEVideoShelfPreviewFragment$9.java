package dov.com.qq.im.ae.play;

class AEVideoShelfPreviewFragment$9
  implements Runnable
{
  AEVideoShelfPreviewFragment$9(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment, int paramInt) {}
  
  public void run()
  {
    AEVideoShelfPreviewFragment.a(this.this$0, this.a * 0.9D);
    double d = (AEVideoShelfPreviewFragment.a(this.this$0) - AEVideoShelfPreviewFragment.b(this.this$0)) * 90.0D / (90.0D - AEVideoShelfPreviewFragment.b(this.this$0));
    AEVideoShelfPreviewFragment.a(this.this$0, (int)d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfPreviewFragment.9
 * JD-Core Version:    0.7.0.1
 */