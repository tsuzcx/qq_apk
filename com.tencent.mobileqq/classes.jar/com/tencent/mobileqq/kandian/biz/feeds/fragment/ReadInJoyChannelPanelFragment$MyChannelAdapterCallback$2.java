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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyStaticGridView.getChildAt(0);
    Object localObject2 = new int[2];
    ((View)localObject1).getLocationOnScreen((int[])localObject2);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment$MyChannelAdapterCallback.a.a(this.jdField_a_of_type_ArrayOfInt, (int[])localObject2);
    ReadInJoyChannelPanelFragment.a(localObject2[0], 0.0F, localObject2[1], 0.0F, (View)localObject1);
    localObject1 = (ViewTreeObserver.OnPreDrawListener)this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyStaticGridView.getTag(2131376044);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyStaticGridView.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyStaticGridView.setTag(2131376044, null);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyChannelPanelFragment.MyChannelAdapterCallback.2
 * JD-Core Version:    0.7.0.1
 */