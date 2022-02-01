package cooperation.ilive;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

class IliveLaunchFragment$6
  implements Runnable
{
  IliveLaunchFragment$6(IliveLaunchFragment paramIliveLaunchFragment) {}
  
  public void run()
  {
    Object localObject = this.this$0.getBaseActivity();
    if (localObject == null) {
      return;
    }
    IliveLaunchFragment.access$500(this.this$0, (Activity)localObject);
    localObject = LayoutInflater.from((Context)localObject).inflate(2131628346, null);
    IliveLaunchFragment.access$602(this.this$0, (TextView)((View)localObject).findViewById(2131448894));
    IliveLaunchFragment.access$702(this.this$0, (ProgressBar)((View)localObject).findViewById(2131439915));
    IliveLaunchFragment.access$800(this.this$0).addView((View)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.IliveLaunchFragment.6
 * JD-Core Version:    0.7.0.1
 */