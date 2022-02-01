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
    View localView = ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment$RecommendChannelAdapterCallback.a).getChildAt(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment$RecommendChannelAdapterCallback.a).getChildCount() - 1);
    Object localObject = new int[2];
    localView.getLocationOnScreen((int[])localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment$RecommendChannelAdapterCallback.a.a(this.jdField_a_of_type_ArrayOfInt, (int[])localObject);
    ReadInJoyChannelPanelFragment.a(localObject[0], 0.0F, localObject[1], 0.0F, localView);
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment$RecommendChannelAdapterCallback.a).getViewTreeObserver().removeOnPreDrawListener(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyChannelPanelFragment$RecommendChannelAdapterCallback.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyChannelPanelFragment.RecommendChannelAdapterCallback.2
 * JD-Core Version:    0.7.0.1
 */