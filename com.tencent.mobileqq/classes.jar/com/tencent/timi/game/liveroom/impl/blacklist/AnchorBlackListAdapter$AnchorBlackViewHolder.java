package com.tencent.timi.game.liveroom.impl.blacklist;

import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.qqlive.data.user.LimitUserInfo;
import com.tencent.timi.game.ui.widget.CommonButton;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public class AnchorBlackListAdapter$AnchorBlackViewHolder
  extends BaseViewHolder<LimitUserInfo>
{
  public RoundCornerImageView a = (RoundCornerImageView)getView(2131428319);
  public TextView b = (TextView)getView(2131428320);
  public CommonButton c = (CommonButton)getView(2131428318);
  
  public AnchorBlackListAdapter$AnchorBlackViewHolder(AnchorBlackListAdapter paramAnchorBlackListAdapter, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.a.setRadius(AnchorBlackListAdapter.b(paramAnchorBlackListAdapter), AnchorBlackListAdapter.b(paramAnchorBlackListAdapter), AnchorBlackListAdapter.b(paramAnchorBlackListAdapter), AnchorBlackListAdapter.b(paramAnchorBlackListAdapter));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.blacklist.AnchorBlackListAdapter.AnchorBlackViewHolder
 * JD-Core Version:    0.7.0.1
 */