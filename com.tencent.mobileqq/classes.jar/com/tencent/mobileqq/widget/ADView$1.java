package com.tencent.mobileqq.widget;

import android.view.View;
import android.widget.LinearLayout;

class ADView$1
  implements WorkSpaceView.OnScreenChangeListener
{
  ADView$1(ADView paramADView, LinearLayout paramLinearLayout) {}
  
  public void a(int paramInt)
  {
    int j = this.a.getChildCount();
    int i = 0;
    View localView;
    while (i < j)
    {
      localView = this.a.getChildAt(i);
      if (localView != null) {
        localView.setEnabled(false);
      }
      i += 1;
    }
    if (this.b.E) {
      if (paramInt != -1) {}
    }
    do
    {
      i = j - 1;
      break;
      i = paramInt;
      if (paramInt != j) {
        break;
      }
      if (paramInt == -1)
      {
        i = 0;
        break;
      }
      i = paramInt;
    } while (paramInt == j);
    if ((i > -1) && (i < j))
    {
      localView = this.a.getChildAt(i);
      if (localView != null) {
        localView.setEnabled(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ADView.1
 * JD-Core Version:    0.7.0.1
 */