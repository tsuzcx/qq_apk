package dov.com.qq.im.ae.view;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import blfn;
import java.util.List;

class TabLayout$2
  implements Runnable
{
  TabLayout$2(TabLayout paramTabLayout) {}
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)TabLayout.a(this.this$0).getLayoutParams();
    localLayoutParams.setMargins(((blfn)TabLayout.a(this.this$0).get(0)).getRight() / 2 - TabLayout.a(this.this$0).getWidth() / 2, 0, 0, 0);
    TabLayout.a(this.this$0).setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.view.TabLayout.2
 * JD-Core Version:    0.7.0.1
 */