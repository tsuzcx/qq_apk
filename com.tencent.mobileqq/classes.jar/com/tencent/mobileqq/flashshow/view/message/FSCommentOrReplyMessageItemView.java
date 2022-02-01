package com.tencent.mobileqq.flashshow.view.message;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.flashshow.list.presenter.FSBaseMessagePresenter;
import com.tencent.mobileqq.flashshow.list.presenter.FSReplyMessagePresenter;
import feedcloud.FeedCloudMeta.StNotice;

public class FSCommentOrReplyMessageItemView
  extends FSBaseMessageItemView
{
  private RecyclerView b;
  
  public FSCommentOrReplyMessageItemView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, Integer.valueOf(paramInt));
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if ((this.a instanceof FSReplyMessagePresenter))
    {
      ((FSReplyMessagePresenter)this.a).a(this.b);
      this.a.a(paramStNotice, paramInt);
    }
  }
  
  public int getLayoutId()
  {
    return 2131624818;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = new FSReplyMessagePresenter(getViewType());
    this.a.a(paramContext, paramView);
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.b = paramRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.message.FSCommentOrReplyMessageItemView
 * JD-Core Version:    0.7.0.1
 */