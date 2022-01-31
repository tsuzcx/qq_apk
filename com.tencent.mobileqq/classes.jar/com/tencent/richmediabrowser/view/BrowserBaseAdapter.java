package com.tencent.richmediabrowser.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.view.progress.AbstractProgressView;

public class BrowserBaseAdapter
  extends BaseAdapter
{
  BasePresenter basePresenter;
  private AbstractProgressView progressView;
  
  private AbstractProgressView getProgressView(int paramInt)
  {
    if ((this.basePresenter != null) && (this.basePresenter.baseModel != null) && (paramInt == this.basePresenter.baseModel.getSelectedIndex())) {
      return this.progressView;
    }
    return null;
  }
  
  public BasePresenter getBasePresenter()
  {
    return this.basePresenter;
  }
  
  public int getCount()
  {
    if ((this.basePresenter == null) || (this.basePresenter.baseModel == null)) {
      return 0;
    }
    return this.basePresenter.baseModel.getCount();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.basePresenter == null) || (this.basePresenter.baseModel == null)) {
      return null;
    }
    return this.basePresenter.baseModel.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public void onLoadFinish(int paramInt, boolean paramBoolean)
  {
    AbstractProgressView localAbstractProgressView = getProgressView(paramInt);
    if (localAbstractProgressView != null) {
      localAbstractProgressView.stop();
    }
  }
  
  public void onLoadProgressUpdate(int paramInt1, int paramInt2)
  {
    AbstractProgressView localAbstractProgressView = getProgressView(paramInt1);
    if ((localAbstractProgressView != null) && (localAbstractProgressView.isShow())) {
      localAbstractProgressView.start(paramInt2);
    }
  }
  
  public void onLoadProgressUpdate(View paramView, int paramInt) {}
  
  public void onLoadStart(int paramInt1, int paramInt2)
  {
    AbstractProgressView localAbstractProgressView = getProgressView(paramInt1);
    if (localAbstractProgressView != null) {
      localAbstractProgressView.start(paramInt2);
    }
  }
  
  public void setPresenter(BasePresenter paramBasePresenter)
  {
    this.basePresenter = paramBasePresenter;
  }
  
  public void setProgressView(AbstractProgressView paramAbstractProgressView)
  {
    this.progressView = paramAbstractProgressView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.BrowserBaseAdapter
 * JD-Core Version:    0.7.0.1
 */