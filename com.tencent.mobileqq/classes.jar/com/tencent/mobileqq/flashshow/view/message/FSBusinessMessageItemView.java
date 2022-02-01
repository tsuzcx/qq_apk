package com.tencent.mobileqq.flashshow.view.message;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.flashshow.list.presenter.FSBaseMessagePresenter;
import com.tencent.mobileqq.flashshow.list.presenter.FSBusinessMessagePresenter;
import feedcloud.FeedCloudMeta.StNotice;

public class FSBusinessMessageItemView
  extends FSBaseMessageItemView
{
  public FSBusinessMessageItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramStNotice, paramInt);
    }
  }
  
  public int getLayoutId()
  {
    return 2131624817;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = new FSBusinessMessagePresenter(getViewType());
    this.a.a(paramContext, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.message.FSBusinessMessageItemView
 * JD-Core Version:    0.7.0.1
 */