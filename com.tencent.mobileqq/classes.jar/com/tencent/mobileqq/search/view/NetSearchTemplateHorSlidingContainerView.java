package com.tencent.mobileqq.search.view;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBaseView;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorSlidingContainerItem;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

public class NetSearchTemplateHorSlidingContainerView
  extends NetSearchTemplateBaseView
  implements HorizontalListView.OnScrollStateChangedListener
{
  public NetSearchTemplateHorSlidingContainerItem a;
  public HorizontalListView a;
  
  public NetSearchTemplateHorSlidingContainerView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((LinearLayout)a(paramInt)).findViewById(2131377081));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnTouchListener(new NetSearchTemplateHorSlidingContainerView.1(this));
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097) {
      this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateHorSlidingContainerItem.b = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getCurrentX();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateHorSlidingContainerView
 * JD-Core Version:    0.7.0.1
 */