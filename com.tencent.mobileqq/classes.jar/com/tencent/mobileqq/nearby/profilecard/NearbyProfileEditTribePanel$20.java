package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.ViewGroup;
import avkg;
import com.tencent.mobileqq.widget.BounceScrollView;

public class NearbyProfileEditTribePanel$20
  implements Runnable
{
  public NearbyProfileEditTribePanel$20(avkg paramavkg, View paramView1, View paramView2) {}
  
  public void run()
  {
    int i = this.a.getMeasuredHeight();
    int j = this.this$0.a.getScrollY();
    if ((this.b instanceof ViewGroup)) {}
    for (Object localObject = this.b;; localObject = this.b.getParent())
    {
      localObject = (View)localObject;
      if (localObject != null)
      {
        int k = ((View)localObject).getBottom();
        int m = this.this$0.a.getMeasuredHeight();
        this.this$0.a.smoothScrollBy(0, k + i - m - j);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.20
 * JD-Core Version:    0.7.0.1
 */