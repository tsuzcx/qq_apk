package com.tencent.mobileqq.guild.vas.adapter;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GroupGiftItem;
import java.util.List;
import mqq.util.WeakReference;

class GiftListPageItemAdapter$ViewHolder
  extends RecyclerView.ViewHolder
{
  private ImageView b;
  private TextView c;
  private TextView d;
  private Button e;
  private RelativeLayout f;
  private TextView g;
  private ImageView h;
  private giftList.GroupGiftItem i;
  
  public GiftListPageItemAdapter$ViewHolder(GiftListPageItemAdapter paramGiftListPageItemAdapter, View paramView)
  {
    super(paramView);
    if ((paramView instanceof ViewGroup))
    {
      this.d = ((TextView)paramView.findViewById(2131447060));
      this.b = ((ImageView)paramView.findViewById(2131435563));
      this.c = ((TextView)paramView.findViewById(2131447143));
      this.e = ((Button)paramView.findViewById(2131430161));
      this.f = ((RelativeLayout)paramView.findViewById(2131436927));
      this.g = ((TextView)paramView.findViewById(2131447214));
      this.h = ((ImageView)paramView.findViewById(2131435564));
    }
    a();
  }
  
  private void a()
  {
    try
    {
      GiftListPageItemAdapter.ViewHolder.3 local3 = new GiftListPageItemAdapter.ViewHolder.3(this);
      VideoReport.setElementId(this.itemView, "em_sgrp_gift_list");
      VideoReport.setElementDynamicParams(this.itemView, local3);
      VideoReport.setElementId(this.e, "em_yes_gift_pannel_send");
      VideoReport.setElementDynamicParams(this.e, local3);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt)
  {
    giftList.GroupGiftItem localGroupGiftItem = (giftList.GroupGiftItem)GiftListPageItemAdapter.a(this.a).get(paramInt);
    this.d.setText(localGroupGiftItem.GiftName.get());
    if (localGroupGiftItem.Thumbnail.has())
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.b.getResources().getDrawable(2130852434);
      localObject = URLDrawable.getDrawable(localGroupGiftItem.Thumbnail.get(), (URLDrawable.URLDrawableOptions)localObject);
      this.b.setImageDrawable((Drawable)localObject);
    }
    Object localObject = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localGroupGiftItem.Price.get());
    localStringBuilder.append("");
    ((TextView)localObject).setText(localStringBuilder.toString());
    localObject = this.g;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(localGroupGiftItem.Price.get());
    localStringBuilder.append("");
    ((TextView)localObject).setText(localStringBuilder.toString());
    if (localGroupGiftItem.BackgroundImage.has())
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      localObject = URLDrawable.getDrawable(localGroupGiftItem.BackgroundImage.get(), (URLDrawable.URLDrawableOptions)localObject);
      this.h.setImageDrawable((Drawable)localObject);
    }
    if (paramInt == GiftListPageItemAdapter.a)
    {
      this.f.setVisibility(0);
      this.b.setScaleX(1.0F / GiftListPageItemAdapter.b(this.a));
      this.b.setScaleY(1.0F / GiftListPageItemAdapter.b(this.a));
      GiftListPageItemAdapter.a(new WeakReference(this.itemView));
      this.d.setAlpha(0.0F);
    }
    else
    {
      this.f.setVisibility(8);
      this.b.setScaleX(1.0F);
      this.b.setScaleY(1.0F);
      this.d.setAlpha(1.0F);
    }
    this.itemView.setOnClickListener(new GiftListPageItemAdapter.ViewHolder.1(this, paramInt, localGroupGiftItem));
    this.e.setOnClickListener(new GiftListPageItemAdapter.ViewHolder.2(this, localGroupGiftItem));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.adapter.GiftListPageItemAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */