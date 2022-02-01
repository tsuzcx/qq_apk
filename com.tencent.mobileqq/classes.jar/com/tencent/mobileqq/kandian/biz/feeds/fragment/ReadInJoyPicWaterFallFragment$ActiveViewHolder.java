package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class ReadInJoyPicWaterFallFragment$ActiveViewHolder
  extends ReadInJoyPicWaterFallFragment.BaseViewHolder
{
  ImageView a;
  URLImageView b;
  
  ReadInJoyPicWaterFallFragment$ActiveViewHolder(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, View paramView)
  {
    super(paramReadInJoyPicWaterFallFragment, paramView);
    this.e = ((URLImageView)paramView.findViewById(2131431432));
    this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.b = ((URLImageView)paramView.findViewById(2131428286));
    this.b.setImageDrawable(new ColorDrawable(Color.parseColor("#7f000000")));
    AIOUtils.b(3.0F, paramReadInJoyPicWaterFallFragment.getResources());
    this.a = ((ImageView)paramView.findViewById(2131427601));
    this.f = ((TextView)paramView.findViewById(2131447463));
    paramView.setOnClickListener(new ReadInJoyPicWaterFallFragment.ActiveViewHolder.1(this, paramReadInJoyPicWaterFallFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.ActiveViewHolder
 * JD-Core Version:    0.7.0.1
 */