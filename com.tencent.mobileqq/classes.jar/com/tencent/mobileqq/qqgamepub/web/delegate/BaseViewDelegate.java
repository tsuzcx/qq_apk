package com.tencent.mobileqq.qqgamepub.web.delegate;

import android.view.View;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.base.IPresenter;

public abstract class BaseViewDelegate<P extends IPresenter>
{
  protected P a;
  protected View b;
  
  public BaseViewDelegate(P paramP, View paramView)
  {
    this.a = paramP;
    this.b = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.delegate.BaseViewDelegate
 * JD-Core Version:    0.7.0.1
 */