package com.tencent.mobileqq.filemanager.data.search.selector;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FileSelectorSearchResultPresenter$2
  implements View.OnClickListener
{
  FileSelectorSearchResultPresenter$2(FileSelectorSearchResultPresenter paramFileSelectorSearchResultPresenter, ISearchResultModel paramISearchResultModel) {}
  
  public void onClick(View paramView)
  {
    FileSelectorSearchResultModel localFileSelectorSearchResultModel = (FileSelectorSearchResultModel)this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel;
    localFileSelectorSearchResultModel.a(paramView);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131366794);
    if (localCheckBox.getVisibility() == 0) {
      localCheckBox.setChecked(localFileSelectorSearchResultModel.b());
    }
    if (FileSelectorSearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchResultPresenter) != null) {
      FileSelectorSearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchResultPresenter).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchResultPresenter.2
 * JD-Core Version:    0.7.0.1
 */