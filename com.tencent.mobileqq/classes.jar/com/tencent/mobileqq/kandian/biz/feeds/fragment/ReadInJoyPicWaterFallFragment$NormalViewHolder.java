package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.view.widget.HeadImageWithRing;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.widget.presseffect.PressEffectSelectorDrawable;

class ReadInJoyPicWaterFallFragment$NormalViewHolder
  extends ReadInJoyPicWaterFallFragment.BaseViewHolder
{
  ReadInJoyNickNameTextView a;
  HeadImageWithRing b;
  TextView c;
  TextView i;
  TextView j;
  ImageView k;
  View l;
  View m;
  ImageView n;
  TextView o;
  View p;
  ImageView q;
  
  ReadInJoyPicWaterFallFragment$NormalViewHolder(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, View paramView)
  {
    super(paramReadInJoyPicWaterFallFragment, paramView);
    this.f = ((TextView)paramView.findViewById(2131447463));
    this.p = paramView.findViewById(2131447120);
    this.p.setBackgroundDrawable(new PressEffectSelectorDrawable(Color.parseColor("#D9D9D8"), 0));
    this.e = ((URLImageView)paramView.findViewById(2131431432));
    this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.m = paramView.findViewById(2131439415);
    this.n = ((ImageView)paramView.findViewById(2131439413));
    this.q = ((ImageView)paramView.findViewById(2131439399));
    this.o = ((TextView)paramView.findViewById(2131439419));
    this.a = ((ReadInJoyNickNameTextView)paramView.findViewById(2131439303));
    this.b = ((HeadImageWithRing)paramView.findViewById(2131436046));
    this.b.setAttrs(AIOUtils.b(0.5F, paramReadInJoyPicWaterFallFragment.getResources()), Color.parseColor("#0c000000"));
    this.b.setDrawRing(true);
    this.b.setCorner(AIOUtils.b(12.0F, paramReadInJoyPicWaterFallFragment.getResources()) / 2);
    this.c = ((TextView)paramView.findViewById(2131437184));
    this.i = ((TextView)paramView.findViewById(2131448641));
    this.j = ((TextView)paramView.findViewById(2131447776));
    this.l = paramView.findViewById(2131447767);
    this.l.setBackgroundDrawable(new PressEffectSelectorDrawable(Color.parseColor("#D9D9D8"), 0));
    this.k = ((ImageView)paramView.findViewById(2131447766));
    paramView.setOnClickListener(new ReadInJoyPicWaterFallFragment.NormalViewHolder.1(this, paramReadInJoyPicWaterFallFragment));
    this.q.setOnClickListener(new ReadInJoyPicWaterFallFragment.NormalViewHolder.2(this, paramReadInJoyPicWaterFallFragment));
    this.l.setOnClickListener(new ReadInJoyPicWaterFallFragment.NormalViewHolder.3(this, paramReadInJoyPicWaterFallFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.NormalViewHolder
 * JD-Core Version:    0.7.0.1
 */