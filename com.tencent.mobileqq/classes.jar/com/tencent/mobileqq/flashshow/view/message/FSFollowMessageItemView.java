package com.tencent.mobileqq.flashshow.view.message;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.flashshow.list.presenter.FSBaseMessagePresenter;
import com.tencent.mobileqq.flashshow.list.presenter.FSFollowMessagePresenter;
import feedcloud.FeedCloudMeta.StNotice;

public class FSFollowMessageItemView
  extends FSBaseMessageItemView
{
  public FSFollowMessageItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FSFollowMessageItemView(@NonNull Context paramContext, int paramInt)
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
    return 2131624820;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = new FSFollowMessagePresenter(getViewType());
    this.a.a(paramContext, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.message.FSFollowMessageItemView
 * JD-Core Version:    0.7.0.1
 */