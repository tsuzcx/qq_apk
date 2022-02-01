package com.tencent.mobileqq.qqexpand.feed;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.fragment.SquareItemClickListener;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendFeedView;
import cooperation.vip.widget.VipGeneralGdtShowView;

public class ExtendFriendAdvInfoHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public ExtendFriendFeedView a;
  public VipGeneralGdtShowView b;
  SquareItemClickListener c;
  
  public ExtendFriendAdvInfoHolder(View paramView, Context paramContext, SquareItemClickListener paramSquareItemClickListener, VipGeneralGdtShowView paramVipGeneralGdtShowView)
  {
    super(paramView);
    this.a = ((ExtendFriendFeedView)paramView);
    this.b = paramVipGeneralGdtShowView;
    this.c = paramSquareItemClickListener;
    paramView = this.b;
    if (paramView != null) {
      paramView.a(paramView.a(), new ExtendFriendAdvInfoHolder.1(this));
    }
  }
  
  public void a(ExtendFriendAdvInfoHolder paramExtendFriendAdvInfoHolder, StrangerInfo paramStrangerInfo, int paramInt)
  {
    if ((this.a != null) && (paramStrangerInfo != null))
    {
      int i = paramExtendFriendAdvInfoHolder.getPosition();
      paramExtendFriendAdvInfoHolder.a.setFeedBgParams(i, paramStrangerInfo.mVoiceUrl, paramInt, false);
    }
    if ((this.b != null) && (paramStrangerInfo != null) && (paramStrangerInfo.mAlumbasicdata != null)) {
      paramExtendFriendAdvInfoHolder.b.a(paramStrangerInfo.mAlumbasicdata, paramExtendFriendAdvInfoHolder.getAdapterPosition());
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.ExtendFriendAdvInfoHolder
 * JD-Core Version:    0.7.0.1
 */