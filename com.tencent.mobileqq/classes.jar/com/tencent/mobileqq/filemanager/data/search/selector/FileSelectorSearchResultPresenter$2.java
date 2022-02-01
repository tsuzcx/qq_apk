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
    FileSelectorSearchResultModel localFileSelectorSearchResultModel = (FileSelectorSearchResultModel)this.a;
    localFileSelectorSearchResultModel.a(paramView);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131433116);
    if (localCheckBox.getVisibility() == 0) {
      localCheckBox.setChecked(localFileSelectorSearchResultModel.m());
    }
    if (FileSelectorSearchResultPresenter.a(this.b) != null) {
      FileSelectorSearchResultPresenter.a(this.b).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchResultPresenter.2
 * JD-Core Version:    0.7.0.1
 */