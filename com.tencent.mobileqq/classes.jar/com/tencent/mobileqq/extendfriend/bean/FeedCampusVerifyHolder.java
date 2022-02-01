package com.tencent.mobileqq.extendfriend.bean;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView.OnClickListener;

public class FeedCampusVerifyHolder
  extends RecyclerView.ViewHolder
{
  private ExtendFriendCampusVerifyTipsView a;
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.FeedCampusVerifyHolder
 * JD-Core Version:    0.7.0.1
 */