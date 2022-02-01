package com.tencent.mobileqq.search;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.TitleHeaderItem;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HotWordSearchEntryModel$2
  implements View.OnClickListener
{
  HotWordSearchEntryModel$2(HotWordSearchEntryModel paramHotWordSearchEntryModel, HotWordSearchEntryDataModel.TitleHeaderItem paramTitleHeaderItem) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem.d))
    {
      SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem.d);
      SearchUtils.a("hot_list", "clk_title", new String[] { String.valueOf(1), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel.jdField_a_of_type_Int) });
    }
    else
    {
      SearchUtils.a("hot_list", "clk_title", new String[] { String.valueOf(2), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSearchHotWordSearchEntryModel.jdField_a_of_type_Int) });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.HotWordSearchEntryModel.2
 * JD-Core Version:    0.7.0.1
 */