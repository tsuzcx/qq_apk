package com.tencent.mobileqq.qqgamepub.mvp.view.buisness;

import android.app.Activity;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter;
import com.tencent.mobileqq.qqgamepub.mvp.view.base.IView;

public abstract interface IQQGameHippyBaseView<P extends QQGameHippyBasePresenter>
  extends IView<P>
{
  public abstract HippyQQPreloadEngine c();
  
  public abstract Activity d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.view.buisness.IQQGameHippyBaseView
 * JD-Core Version:    0.7.0.1
 */