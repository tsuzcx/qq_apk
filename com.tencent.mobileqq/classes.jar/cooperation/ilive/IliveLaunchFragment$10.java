package cooperation.ilive;

import android.widget.TextView;

class IliveLaunchFragment$10
  implements Runnable
{
  IliveLaunchFragment$10(IliveLaunchFragment paramIliveLaunchFragment, int paramInt, String paramString) {}
  
  public void run()
  {
    if (IliveLaunchFragment.access$600(this.this$0) != null)
    {
      TextView localTextView = IliveLaunchFragment.access$600(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("直播加载失败\ncode = ");
      localStringBuilder.append(this.a);
      localTextView.setText(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.IliveLaunchFragment.10
 * JD-Core Version:    0.7.0.1
 */