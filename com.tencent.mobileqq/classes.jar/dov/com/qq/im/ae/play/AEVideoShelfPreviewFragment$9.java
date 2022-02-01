package dov.com.qq.im.ae.play;

class AEVideoShelfPreviewFragment$9
  implements Runnable
{
  AEVideoShelfPreviewFragment$9(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment, int paramInt) {}
  
  public void run()
  {
    AEVideoShelfPreviewFragment.access$702(this.this$0, this.val$progress * 0.9D);
    double d = (AEVideoShelfPreviewFragment.access$700(this.this$0) - AEVideoShelfPreviewFragment.access$1000(this.this$0)) * 90.0D / (90.0D - AEVideoShelfPreviewFragment.access$1000(this.this$0));
    AEVideoShelfPreviewFragment.access$800(this.this$0, (int)d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfPreviewFragment.9
 * JD-Core Version:    0.7.0.1
 */