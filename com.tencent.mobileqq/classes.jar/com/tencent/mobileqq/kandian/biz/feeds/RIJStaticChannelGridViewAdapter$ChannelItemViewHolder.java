package com.tencent.mobileqq.kandian.biz.feeds;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianUrlRoundCornerImageView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.AutoFitTextView;
import com.tencent.mobileqq.widget.AutoFitTextView.OnGetMaxWidthCallback;

public class RIJStaticChannelGridViewAdapter$ChannelItemViewHolder
  implements AutoFitTextView.OnGetMaxWidthCallback
{
  LinearLayout a;
  AutoFitTextView b;
  ImageView c;
  TextView d;
  KanDianUrlRoundCornerImageView e;
  private final Context f;
  
  public RIJStaticChannelGridViewAdapter$ChannelItemViewHolder(Context paramContext)
  {
    this.f = paramContext;
  }
  
  public int a()
  {
    return this.a.getWidth() - DisplayUtil.a(this.f, 10.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.RIJStaticChannelGridViewAdapter.ChannelItemViewHolder
 * JD-Core Version:    0.7.0.1
 */