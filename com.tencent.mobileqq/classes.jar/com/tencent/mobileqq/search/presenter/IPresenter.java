package com.tencent.mobileqq.search.presenter;

import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.view.IView;

public abstract interface IPresenter<M extends IModel, V extends IView>
{
  public abstract void a(M paramM, V paramV);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.IPresenter
 * JD-Core Version:    0.7.0.1
 */