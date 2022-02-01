package com.tencent.mobileqq.qqexpand.feed;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendCampusVerifyTipsView;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendCampusVerifyTipsView.OnClickListener;

public class FeedCampusVerifyHolder
  extends RecyclerView.ViewHolder
{
  private final ExtendFriendCampusVerifyTipsView a;
  
  public FeedCampusVerifyHolder(View paramView, ExtendFriendCampusVerifyTipsView.OnClickListener paramOnClickListener)
  {
    super(paramView);
    this.a = ((ExtendFriendCampusVerifyTipsView)paramView);
    this.a.setOnClickListener(paramOnClickListener);
  }
  
  public void a(StrangerInfo paramStrangerInfo, int paramInt)
  {
    if ((paramStrangerInfo instanceof FeedCampusVerifyInfo))
    {
      paramStrangerInfo = (FeedCampusVerifyInfo)paramStrangerInfo;
      this.a.setTipsType(paramStrangerInfo.a);
      this.a.setPadding(0, paramInt, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.FeedCampusVerifyHolder
 * JD-Core Version:    0.7.0.1
 */