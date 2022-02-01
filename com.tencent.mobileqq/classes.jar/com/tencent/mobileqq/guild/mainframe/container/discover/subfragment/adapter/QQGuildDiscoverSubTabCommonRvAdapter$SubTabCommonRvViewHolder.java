package com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.adapter;

import android.animation.AnimatorInflater;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.guild.mainframe.container.discover.handler.DiscoverGuildBean;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.widget.ShadowFrameLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.RoundRectImageView;

class QQGuildDiscoverSubTabCommonRvAdapter$SubTabCommonRvViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public RoundRectImageView a;
  public TextView b;
  public TextView c;
  public ImageView d;
  public ShadowFrameLayout e;
  
  @RequiresApi(api=21)
  public QQGuildDiscoverSubTabCommonRvAdapter$SubTabCommonRvViewHolder(QQGuildDiscoverSubTabCommonRvAdapter paramQQGuildDiscoverSubTabCommonRvAdapter, View paramView)
  {
    super(paramView);
    QQGuildUtil.a(paramView, "em_sgrp_discover_card", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    this.a = ((RoundRectImageView)paramView.findViewById(2131435293));
    this.b = ((TextView)paramView.findViewById(2131435295));
    this.c = ((TextView)paramView.findViewById(2131435294));
    this.d = ((ImageView)paramView.findViewById(2131435296));
    this.e = ((ShadowFrameLayout)paramView.findViewById(2131434599));
    paramView.setOnClickListener(this);
    paramView.setStateListAnimator(AnimatorInflater.loadStateListAnimator(QQGuildDiscoverSubTabCommonRvAdapter.a(paramQQGuildDiscoverSubTabCommonRvAdapter), 2130903043));
  }
  
  public void onClick(View paramView)
  {
    if (QQGuildDiscoverSubTabCommonRvAdapter.b(this.f) != null) {
      QQGuildDiscoverSubTabCommonRvAdapter.b(this.f).a(getLayoutPosition(), this.itemView, this.a, (DiscoverGuildBean)this.itemView.getTag());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.adapter.QQGuildDiscoverSubTabCommonRvAdapter.SubTabCommonRvViewHolder
 * JD-Core Version:    0.7.0.1
 */