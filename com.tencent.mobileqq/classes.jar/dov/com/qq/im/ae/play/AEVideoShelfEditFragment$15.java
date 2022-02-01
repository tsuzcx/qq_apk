package dov.com.qq.im.ae.play;

import java.util.Timer;

class AEVideoShelfEditFragment$15
  implements Runnable
{
  AEVideoShelfEditFragment$15(AEVideoShelfEditFragment paramAEVideoShelfEditFragment, long paramLong) {}
  
  public void run()
  {
    if ((int)AEVideoShelfEditFragment.access$2700(this.this$0) < 100)
    {
      AEVideoShelfEditFragment.access$2800(this.this$0, 100);
      new Timer().schedule(new AEVideoShelfEditFragment.15.1(this), 500L);
    }
    for (;;)
    {
      AEVideoShelfEditFragment.keepScreenOn(this.this$0.getActivity(), false);
      return;
      AEVideoShelfEditFragment.access$2900(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfEditFragment.15
 * JD-Core Version:    0.7.0.1
 */