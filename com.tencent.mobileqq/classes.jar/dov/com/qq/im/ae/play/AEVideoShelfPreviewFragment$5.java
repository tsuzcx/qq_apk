package dov.com.qq.im.ae.play;

import birt;
import bjzs;
import java.util.Timer;

class AEVideoShelfPreviewFragment$5
  implements Runnable
{
  AEVideoShelfPreviewFragment$5(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment, long paramLong) {}
  
  public void run()
  {
    if ((int)AEVideoShelfPreviewFragment.a(this.this$0) < 100)
    {
      AEVideoShelfPreviewFragment.a(this.this$0, 100);
      new Timer().schedule(new AEVideoShelfPreviewFragment.5.1(this), 0L);
    }
    for (;;)
    {
      AEVideoShelfPreviewFragment.a(this.this$0, 0.0D);
      AEVideoShelfPreviewFragment.b(this.this$0, 0.0D);
      if (AEVideoShelfPreviewFragment.a(this.this$0))
      {
        AEVideoShelfPreviewFragment.a(this.this$0, false);
        AEVideoShelfPreviewFragment.a(this.this$0.getActivity(), false);
      }
      bjzs.a(this.this$0.getActivity(), AEVideoShelfPreviewFragment.a(this.this$0), this.this$0.a(), birt.b(this.this$0.getActivity()), "caller_aecamera");
      return;
      AEVideoShelfPreviewFragment.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfPreviewFragment.5
 * JD-Core Version:    0.7.0.1
 */