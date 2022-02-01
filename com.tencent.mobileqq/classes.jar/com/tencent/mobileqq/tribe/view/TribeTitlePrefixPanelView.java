package com.tencent.mobileqq.tribe.view;

import android.content.Context;
import android.widget.ListView;
import java.util.List;

public class TribeTitlePrefixPanelView
{
  private static String jdField_a_of_type_JavaLangString = "TribeTitlePrefixPanelView";
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private TribeTitlePrefixPanelView.TitlePrefixAdapter jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixAdapter;
  
  public TribeTitlePrefixPanelView(Context paramContext, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixAdapter = new TribeTitlePrefixPanelView.TitlePrefixAdapter(paramContext);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixAdapter);
  }
  
  public void a(TribeTitlePrefixPanelView.PrefixSelectedListener paramPrefixSelectedListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixAdapter.a(paramPrefixSelectedListener);
    }
  }
  
  public void a(List<TribeTitlePrefixPanelView.TitlePrefixItem> paramList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixAdapter.a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView
 * JD-Core Version:    0.7.0.1
 */