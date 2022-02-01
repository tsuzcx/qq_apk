package com.tencent.widget.pull2refresh;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LoadingMoreHelper$1
  implements View.OnClickListener
{
  LoadingMoreHelper$1(LoadingMoreHelper paramLoadingMoreHelper) {}
  
  public void onClick(View paramView)
  {
    this.this$0.setLoadMore(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.LoadingMoreHelper.1
 * JD-Core Version:    0.7.0.1
 */