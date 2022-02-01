package com.tencent.mobileqq.multiaio;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.widget.ListView;

class MultiAIOItemFragment$8
  implements View.OnLayoutChangeListener
{
  MultiAIOItemFragment$8(MultiAIOItemFragment paramMultiAIOItemFragment, ListView paramListView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((this.a.getWidth() > 0) && (this.a.getHeight() > 0))
    {
      this.a.removeOnLayoutChangeListener(this);
      MultiAIOItemFragment.a(this.b, this.a.getWidth(), this.a.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOItemFragment.8
 * JD-Core Version:    0.7.0.1
 */