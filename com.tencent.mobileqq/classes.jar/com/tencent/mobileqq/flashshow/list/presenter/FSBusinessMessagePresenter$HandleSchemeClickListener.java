package com.tencent.mobileqq.flashshow.list.presenter;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FSBusinessMessagePresenter$HandleSchemeClickListener
  implements View.OnClickListener
{
  private final String b;
  private final int c;
  
  public FSBusinessMessagePresenter$HandleSchemeClickListener(FSBusinessMessagePresenter paramFSBusinessMessagePresenter, String paramString, int paramInt)
  {
    this.b = paramString;
    this.c = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      FSNativeLauncher.a(paramView.getContext(), this.b);
      if (this.a.d != null) {
        this.a.b();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSBusinessMessagePresenter.HandleSchemeClickListener
 * JD-Core Version:    0.7.0.1
 */