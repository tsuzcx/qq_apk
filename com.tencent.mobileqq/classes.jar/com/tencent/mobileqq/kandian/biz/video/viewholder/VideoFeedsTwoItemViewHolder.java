package com.tencent.mobileqq.kandian.biz.video.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.RoundAngleFrameLayout;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public class VideoFeedsTwoItemViewHolder
  extends ViewHolder
{
  public ReadInJoyHeadImageView A;
  public KandianUrlImageView B;
  public ReadInJoyNickNameTextView C;
  public AbsBaseArticleInfo D;
  public AbsBaseArticleInfo E;
  public View a;
  public View b;
  public View c;
  public TextView d;
  public TextView e;
  public KandianUrlImageView f;
  public KandianUrlImageView g;
  public RoundAngleFrameLayout h;
  public KandianUrlImageView i;
  public ImageView j;
  public TextView k;
  public TextView l;
  public ViewGroup m;
  public TextView n;
  public View o;
  public ReadInJoyHeadImageView p;
  public KandianUrlImageView q;
  public ReadInJoyNickNameTextView r;
  public RoundAngleFrameLayout s;
  public KandianUrlImageView t;
  public ImageView u;
  public TextView v;
  public TextView w;
  public ViewGroup x;
  public TextView y;
  public View z;
  
  public VideoFeedsTwoItemViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    super(paramContext, paramVideoHandler);
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.N).inflate(2131626432, paramViewGroup, false);
    this.a = paramViewGroup.findViewById(2131445137);
    this.b = paramViewGroup.findViewById(2131437107);
    this.c = paramViewGroup.findViewById(2131444826);
    this.d = ((TextView)paramViewGroup.findViewById(2131437093));
    this.e = ((TextView)paramViewGroup.findViewById(2131444816));
    this.h = ((RoundAngleFrameLayout)paramViewGroup.findViewById(2131437098));
    this.i = ((KandianUrlImageView)paramViewGroup.findViewById(2131437113));
    this.j = ((ImageView)paramViewGroup.findViewById(2131437115));
    this.k = ((TextView)paramViewGroup.findViewById(2131437119));
    this.l = ((TextView)paramViewGroup.findViewById(2131437117));
    this.m = ((ViewGroup)paramViewGroup.findViewById(2131437108));
    this.n = ((TextView)paramViewGroup.findViewById(2131437118));
    this.o = paramViewGroup.findViewById(2131437079);
    this.p = ((ReadInJoyHeadImageView)paramViewGroup.findViewById(2131437080));
    this.q = ((KandianUrlImageView)paramViewGroup.findViewById(2131437129));
    this.r = ((ReadInJoyNickNameTextView)paramViewGroup.findViewById(2131437081));
    this.f = ((KandianUrlImageView)paramViewGroup.findViewById(2131437097));
    this.s = ((RoundAngleFrameLayout)paramViewGroup.findViewById(2131444821));
    this.t = ((KandianUrlImageView)paramViewGroup.findViewById(2131444832));
    this.u = ((ImageView)paramViewGroup.findViewById(2131444834));
    this.v = ((TextView)paramViewGroup.findViewById(2131444838));
    this.w = ((TextView)paramViewGroup.findViewById(2131444836));
    this.x = ((ViewGroup)paramViewGroup.findViewById(2131444827));
    this.y = ((TextView)paramViewGroup.findViewById(2131444837));
    this.z = paramViewGroup.findViewById(2131444794);
    this.A = ((ReadInJoyHeadImageView)paramViewGroup.findViewById(2131444795));
    this.B = ((KandianUrlImageView)paramViewGroup.findViewById(2131444851));
    this.C = ((ReadInJoyNickNameTextView)paramViewGroup.findViewById(2131444796));
    this.g = ((KandianUrlImageView)paramViewGroup.findViewById(2131444820));
    paramViewGroup.setTag(this);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsTwoItemViewHolder
 * JD-Core Version:    0.7.0.1
 */