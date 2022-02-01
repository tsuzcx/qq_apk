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
  public TextView a;
  public KandianUrlImageView a;
  public AbsBaseArticleInfo a;
  public TextView b;
  public KandianUrlImageView b;
  public AbsBaseArticleInfo b;
  public TextView c;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  public TextView h;
  
  public WeishiGridTwoItemViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    super(paramContext, paramVideoHandler);
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560391, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367807));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131369969));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131369974));
    this.c = ((TextView)paramViewGroup.findViewById(2131369944));
    this.d = ((TextView)paramViewGroup.findViewById(2131369968));
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367809));
    this.e = ((TextView)paramViewGroup.findViewById(2131376583));
    this.f = ((TextView)paramViewGroup.findViewById(2131376589));
    this.g = ((TextView)paramViewGroup.findViewById(2131376563));
    this.h = ((TextView)paramViewGroup.findViewById(2131376582));
    paramViewGroup.setTag(this);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.viewholder.WeishiGridTwoItemViewHolder
 * JD-Core Version:    0.7.0.1
 */