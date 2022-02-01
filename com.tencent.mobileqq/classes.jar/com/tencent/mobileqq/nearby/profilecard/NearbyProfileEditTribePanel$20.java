package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.BounceScrollView;

class NearbyProfileEditTribePanel$20
  implements Runnable
{
  NearbyProfileEditTribePanel$20(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel, View paramView1, View paramView2) {}
  
  public void run()
  {
    int i = this.a.getMeasuredHeight();
    int j = this.this$0.a.getScrollY();
    Object localObject = this.b;
    if (!(localObject instanceof ViewGroup)) {
      localObject = ((View)localObject).getParent();
    }
    localObject = (View)localObject;
    if (localObject != null)
    {
      int k = ((View)localObject).getBottom();
      int m = this.this$0.a.getMeasuredHeight();
      this.this$0.a.smoothScrollBy(0, k + i - m - j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.20
 * JD-Core Version:    0.7.0.1
 */