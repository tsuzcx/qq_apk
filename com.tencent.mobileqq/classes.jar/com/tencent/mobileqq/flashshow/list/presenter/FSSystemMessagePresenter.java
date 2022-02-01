package com.tencent.mobileqq.flashshow.list.presenter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import feedcloud.FeedCloudMeta.StNotice;

public class FSSystemMessagePresenter
  extends FSDefaultMessagePresenter
{
  public FSSystemMessagePresenter(int paramInt)
  {
    super(paramInt);
  }
  
  public void b(Context paramContext, View paramView)
  {
    super.b(paramContext, paramView);
    this.u = new FSSystemMessagePresenter.1(this, paramContext);
  }
  
  public void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    super.b(paramStNotice, paramInt);
  }
  
  protected View.OnClickListener i()
  {
    return this.u;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSSystemMessagePresenter
 * JD-Core Version:    0.7.0.1
 */