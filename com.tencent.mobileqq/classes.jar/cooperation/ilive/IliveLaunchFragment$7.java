package cooperation.ilive;

import android.widget.ProgressBar;
import android.widget.TextView;

class IliveLaunchFragment$7
  implements Runnable
{
  IliveLaunchFragment$7(IliveLaunchFragment paramIliveLaunchFragment, float paramFloat) {}
  
  public void run()
  {
    if (IliveLaunchFragment.access$700(this.this$0) != null) {
      IliveLaunchFragment.access$700(this.this$0).setProgress((int)this.a);
    }
    if (IliveLaunchFragment.access$600(this.this$0) != null)
    {
      if (this.a == 100.0F) {
        IliveLaunchFragment.access$600(this.this$0).setText("直播加载中...");
      }
    }
    else {
      return;
    }
    IliveLaunchFragment.access$600(this.this$0).setText("直播加载中：" + (int)this.a + "%");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.IliveLaunchFragment.7
 * JD-Core Version:    0.7.0.1
 */