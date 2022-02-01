package com.tencent.mobileqq.filemanager.data.search.selector;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FileSelectorSearchResultPresenter$1
  implements View.OnClickListener
{
  FileSelectorSearchResultPresenter$1(FileSelectorSearchResultPresenter paramFileSelectorSearchResultPresenter, ISearchResultModel paramISearchResultModel) {}
  
  public void onClick(View paramView)
  {
    ((FileSelectorSearchResultModel)this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchResultPresenter.1
 * JD-Core Version:    0.7.0.1
 */