package com.tencent.richmediabrowser.view.recyclerview;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.richmediabrowser.api.decorator.IDecoratorPresenter;
import com.tencent.richmediabrowser.core.IBasePresenterBuilder;
import com.tencent.richmediabrowser.core.IBaseViewBuilder;
import com.tencent.richmediabrowser.view.BrowserBaseView;

public class BrowserAdapter$BrowserViewHolder
  extends RecyclerView.ViewHolder
{
  public IDecoratorPresenter decoratorPresenter;
  public IBaseViewBuilder itemView;
  public IBasePresenterBuilder presenterBuilder;
  
  public BrowserAdapter$BrowserViewHolder(BrowserAdapter paramBrowserAdapter, BrowserBaseView paramBrowserBaseView, IDecoratorPresenter paramIDecoratorPresenter, IBasePresenterBuilder paramIBasePresenterBuilder)
  {
    super(paramBrowserBaseView.mBrowserItemView);
    this.itemView = paramBrowserBaseView;
    this.decoratorPresenter = paramIDecoratorPresenter;
    this.presenterBuilder = paramIBasePresenterBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.recyclerview.BrowserAdapter.BrowserViewHolder
 * JD-Core Version:    0.7.0.1
 */