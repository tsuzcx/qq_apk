package cooperation.ilive;

import android.widget.ProgressBar;
import android.widget.TextView;

class IliveLaunchFragment$9
  implements Runnable
{
  IliveLaunchFragment$9(IliveLaunchFragment paramIliveLaunchFragment, float paramFloat) {}
  
  public void run()
  {
    if (IliveLaunchFragment.access$700(this.this$0) != null) {
      IliveLaunchFragment.access$700(this.this$0).setProgress((int)this.a);
    }
    if (IliveLaunchFragment.access$600(this.this$0) != null)
    {
      if (this.a == 100.0F)
      {
        IliveLaunchFragment.access$600(this.this$0).setText("直播加载中...");
        return;
      }
      TextView localTextView = IliveLaunchFragment.access$600(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("直播加载中：");
      localStringBuilder.append((int)this.a);
      localStringBuilder.append("%");
      localTextView.setText(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.IliveLaunchFragment.9
 * JD-Core Version:    0.7.0.1
 */