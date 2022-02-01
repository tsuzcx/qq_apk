package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyStaticGridView;

class ReadInJoyChannelPanelFragment$MyChannelAdapterCallback$2
  implements ViewTreeObserver.OnPreDrawListener
{
  ReadInJoyChannelPanelFragment$MyChannelAdapterCallback$2(ReadInJoyChannelPanelFragment.MyChannelAdapterCallback paramMyChannelAdapterCallback, ReadInJoyStaticGridView paramReadInJoyStaticGridView, int[] paramArrayOfInt) {}
  
  public boolean onPreDraw()
  {
    Object localObject1 = this.a.getChildAt(0);
    Object localObject2 = new int[2];
    ((View)localObject1).getLocationOnScreen((int[])localObject2);
    localObject2 = this.c.a.a(this.b, (int[])localObject2);
    ReadInJoyChannelPanelFragment.a(localObject2[0], 0.0F, localObject2[1], 0.0F, (View)localObject1);
    localObject1 = (ViewTreeObserver.OnPreDrawListener)this.a.getTag(2131444244);
    this.a.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)localObject1);
    this.a.setTag(2131444244, null);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyChannelPanelFragment.MyChannelAdapterCallback.2
 * JD-Core Version:    0.7.0.1
 */