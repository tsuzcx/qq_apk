package com.tencent.mobileqq.tribe.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class TribeTitlePrefixPanelView$ClickListenerImp
  implements View.OnClickListener
{
  private TribeTitlePrefixPanelView.PrefixSelectedListener jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$PrefixSelectedListener;
  private TribeTitlePrefixPanelView.TitlePrefixAdapter jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixAdapter;
  
  public TribeTitlePrefixPanelView$ClickListenerImp(TribeTitlePrefixPanelView.TitlePrefixAdapter paramTitlePrefixAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixAdapter = paramTitlePrefixAdapter;
  }
  
  public void a(TribeTitlePrefixPanelView.PrefixSelectedListener paramPrefixSelectedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$PrefixSelectedListener = paramPrefixSelectedListener;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    TribeTitlePrefixPanelView.TitlePrefixAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixAdapter, i);
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$PrefixSelectedListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$PrefixSelectedListener.a((TribeTitlePrefixPanelView.TitlePrefixItem)TribeTitlePrefixPanelView.TitlePrefixAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixAdapter).get(i));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView.ClickListenerImp
 * JD-Core Version:    0.7.0.1
 */