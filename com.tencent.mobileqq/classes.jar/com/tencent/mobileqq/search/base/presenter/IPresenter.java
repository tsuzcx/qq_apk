package com.tencent.mobileqq.search.base.presenter;

import com.tencent.mobileqq.search.base.view.IView;
import com.tencent.mobileqq.search.model.IModel;

public abstract interface IPresenter<M extends IModel, V extends IView>
{
  public abstract void a(M paramM, V paramV);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.presenter.IPresenter
 * JD-Core Version:    0.7.0.1
 */