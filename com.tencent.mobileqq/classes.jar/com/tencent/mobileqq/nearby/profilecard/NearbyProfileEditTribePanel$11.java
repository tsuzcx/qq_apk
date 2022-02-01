package com.tencent.mobileqq.nearby.profilecard;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.EditText;
import com.tencent.mobileqq.widget.BounceScrollView;

class NearbyProfileEditTribePanel$11
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  NearbyProfileEditTribePanel$11(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new Rect();
    this.a.A.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = this.a.A.getWindow().getDecorView().getRootView().getHeight() - ((Rect)localObject).bottom;
    if (i <= 0) {
      return;
    }
    int j = this.a.z.getScrollY();
    localObject = this.a.A.getCurrentFocus();
    if ((localObject != null) && ((localObject instanceof EditText)) && (((View)localObject).getParent() != null))
    {
      int k = ((ViewGroup)((View)localObject).getParent()).getBottom();
      int m = this.a.z.getMeasuredHeight();
      this.a.z.smoothScrollBy(0, k + i - m - j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.11
 * JD-Core Version:    0.7.0.1
 */