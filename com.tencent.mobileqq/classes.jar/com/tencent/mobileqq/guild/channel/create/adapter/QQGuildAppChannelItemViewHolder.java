package com.tencent.mobileqq.guild.channel.create.adapter;

import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.widget.ShadowFrameLayout;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.RoundRectImageView;
import java.util.HashMap;
import java.util.Map;

public class QQGuildAppChannelItemViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public RoundRectImageView a;
  public TextView b;
  public TextView c;
  public ImageView d;
  public ShadowFrameLayout e;
  public IAppInfo f;
  QQGuildAppChannelRvAdapter g;
  
  public QQGuildAppChannelItemViewHolder(View paramView, QQGuildAppChannelRvAdapter paramQQGuildAppChannelRvAdapter)
  {
    super(paramView);
    this.g = paramQQGuildAppChannelRvAdapter;
    this.a = ((RoundRectImageView)paramView.findViewById(2131428619));
    this.b = ((TextView)paramView.findViewById(2131428633));
    this.c = ((TextView)paramView.findViewById(2131428614));
    this.d = ((ImageView)paramView.findViewById(2131428637));
    this.e = ((ShadowFrameLayout)paramView.findViewById(2131428606));
    QQGuildUtil.a(paramView, "em_sgrp_select_sub_channel", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
  }
  
  @RequiresApi(api=21)
  public void a(IAppInfo paramIAppInfo)
  {
    this.f = paramIAppInfo;
    this.a.setCornerRadiusAndMode(ViewUtils.dpToPx(4.0F), 1);
    paramIAppInfo = URLDrawable.URLDrawableOptions.obtain();
    paramIAppInfo.mRequestWidth = ViewUtils.dip2px(52.0F);
    paramIAppInfo.mRequestHeight = ViewUtils.dip2px(52.0F);
    paramIAppInfo = URLDrawable.getDrawable(this.f.b(), paramIAppInfo);
    this.a.setImageDrawable(paramIAppInfo);
    if (!TextUtils.isEmpty(this.f.c())) {
      this.b.setText(this.f.c());
    } else {
      this.b.setText("");
    }
    if (!TextUtils.isEmpty(this.f.d())) {
      this.c.setText(this.f.d());
    } else {
      this.c.setText("");
    }
    this.d.setOnClickListener(this);
    this.itemView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i == this.itemView.getId())
    {
      localObject = this.g;
      if ((localObject != null) && (((QQGuildAppChannelRvAdapter)localObject).a != null))
      {
        localObject = new HashMap();
        ((Map)localObject).put("sgrp_sub_appchannel_id", Long.valueOf(this.f.a()));
        VideoReport.reportEvent("clck", this.itemView, (Map)localObject);
        this.g.a.a(this.f);
      }
    }
    else if (i == 2131428637)
    {
      localObject = this.g;
      if ((localObject != null) && (((QQGuildAppChannelRvAdapter)localObject).a != null)) {
        this.g.a.b(this.f);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.adapter.QQGuildAppChannelItemViewHolder
 * JD-Core Version:    0.7.0.1
 */