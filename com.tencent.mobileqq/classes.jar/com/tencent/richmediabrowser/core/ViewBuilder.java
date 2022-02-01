package com.tencent.richmediabrowser.core;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.view.BrowserBaseView;

public class ViewBuilder
  implements IViewBuilder
{
  private BasePresenter basePresenter;
  private Activity mActivity;
  private int mType;
  private BrowserBaseView view;
  
  public ViewBuilder(Activity paramActivity, int paramInt, BasePresenter paramBasePresenter)
  {
    this.mActivity = paramActivity;
    this.mType = paramInt;
    this.basePresenter = paramBasePresenter;
  }
  
  public void buildComplete()
  {
    if (this.view != null) {
      this.view.buildComplete();
    }
  }
  
  public void buildInit()
  {
    this.view = new MVPFactory().createView(this.mActivity, this.mType, this.basePresenter);
  }
  
  public void buildParams(Intent paramIntent)
  {
    if (this.view != null) {
      this.view.buildParams(paramIntent);
    }
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    if (this.view != null) {
      this.view.buildView(paramViewGroup);
    }
  }
  
  public BrowserBaseView getView()
  {
    return this.view;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.ViewBuilder
 * JD-Core Version:    0.7.0.1
 */