package cooperation.qzone.zipanimate;

class ZipAnimationDrawable$ZipAnimationState$1$1
  implements Runnable
{
  ZipAnimationDrawable$ZipAnimationState$1$1(ZipAnimationDrawable.ZipAnimationState.1 param1) {}
  
  public void run()
  {
    if (this.this$2.this$1.this$0.mListener != null) {
      this.this$2.this$1.this$0.mListener.onDrawableLoaded();
    }
    if (ZipAnimationDrawable.access$300(this.this$2.this$1.this$0)) {
      this.this$2.this$1.this$0.restartAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipAnimationDrawable.ZipAnimationState.1.1
 * JD-Core Version:    0.7.0.1
 */