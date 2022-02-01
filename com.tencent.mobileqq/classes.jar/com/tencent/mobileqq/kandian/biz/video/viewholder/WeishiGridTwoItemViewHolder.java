package com.tencent.mobileqq.kandian.biz.video.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public class WeishiGridTwoItemViewHolder
  extends ViewHolder
{
  public KandianUrlImageView a;
  public TextView b;
  public TextView c;
  public TextView d;
  public TextView e;
  public KandianUrlImageView f;
  public TextView g;
  public TextView h;
  public TextView i;
  public TextView j;
  public AbsBaseArticleInfo k;
  public AbsBaseArticleInfo l;
  
  public WeishiGridTwoItemViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    super(paramContext, paramVideoHandler);
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.N).inflate(2131626437, paramViewGroup, false);
    this.a = ((KandianUrlImageView)paramViewGroup.findViewById(2131434382));
    this.b = ((TextView)paramViewGroup.findViewById(2131437119));
    this.c = ((TextView)paramViewGroup.findViewById(2131437125));
    this.d = ((TextView)paramViewGroup.findViewById(2131437093));
    this.e = ((TextView)paramViewGroup.findViewById(2131437118));
    this.f = ((KandianUrlImageView)paramViewGroup.findViewById(2131434384));
    this.g = ((TextView)paramViewGroup.findViewById(2131444838));
    this.h = ((TextView)paramViewGroup.findViewById(2131444845));
    this.i = ((TextView)paramViewGroup.findViewById(2131444816));
    this.j = ((TextView)paramViewGroup.findViewById(2131444837));
    paramViewGroup.setTag(this);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.viewholder.WeishiGridTwoItemViewHolder
 * JD-Core Version:    0.7.0.1
 */