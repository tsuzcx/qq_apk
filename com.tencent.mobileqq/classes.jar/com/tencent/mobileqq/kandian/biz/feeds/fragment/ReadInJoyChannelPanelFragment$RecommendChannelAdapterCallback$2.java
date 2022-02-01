package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView;

class ReadInJoyChannelPanelFragment$RecommendChannelAdapterCallback$2
  implements ViewTreeObserver.OnPreDrawListener
{
  ReadInJoyChannelPanelFragment$RecommendChannelAdapterCallback$2(ReadInJoyChannelPanelFragment.RecommendChannelAdapterCallback paramRecommendChannelAdapterCallback, int[] paramArrayOfInt) {}
  
  public boolean onPreDraw()
  {
    View localView = ReadInJoyChannelPanelFragment.a(this.b.a).getChildAt(ReadInJoyChannelPanelFragment.a(this.b.a).getChildCount() - 1);
    Object localObject = new int[2];
    localView.getLocationOnScreen((int[])localObject);
    localObject = this.b.a.a(this.a, (int[])localObject);
    ReadInJoyChannelPanelFragment.a(localObject[0], 0.0F, localObject[1], 0.0F, localView);
    ReadInJoyChannelPanelFragment.a(this.b.a).getViewTreeObserver().removeOnPreDrawListener(ReadInJoyChannelPanelFragment.j(this.b.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyChannelPanelFragment.RecommendChannelAdapterCallback.2
 * JD-Core Version:    0.7.0.1
 */