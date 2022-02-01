package dov.com.qq.im.ae.view;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import java.util.List;

class TabLayout$2
  implements Runnable
{
  TabLayout$2(TabLayout paramTabLayout, int paramInt) {}
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)TabLayout.a(this.this$0).getLayoutParams();
    if (TabLayout.a(this.this$0).size() > this.a)
    {
      float f = ((TabLayout.TabView)TabLayout.a(this.this$0).get(this.a)).getX();
      localLayoutParams.setMargins((int)(((TabLayout.TabView)TabLayout.a(this.this$0).get(this.a)).getWidth() / 2.0F + f - TabLayout.a(this.this$0).getWidth() / 2.0F), 0, 0, 0);
    }
    for (;;)
    {
      TabLayout.a(this.this$0).setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.setMargins(((TabLayout.TabView)TabLayout.a(this.this$0).get(0)).getRight() / 2 - TabLayout.a(this.this$0).getWidth() / 2, 0, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.view.TabLayout.2
 * JD-Core Version:    0.7.0.1
 */