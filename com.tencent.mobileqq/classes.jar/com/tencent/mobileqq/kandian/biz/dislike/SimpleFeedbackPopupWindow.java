package com.tencent.mobileqq.kandian.biz.dislike;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBasePopupWindow;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public class SimpleFeedbackPopupWindow
  extends ReadInJoyBasePopupWindow
{
  protected boolean g = false;
  private SimpleFeedbackPopupWindow.Callback h;
  private AbsBaseArticleInfo i;
  private int j;
  
  public SimpleFeedbackPopupWindow(Activity paramActivity, SimpleFeedbackPopupWindow.Callback paramCallback)
  {
    super(paramActivity);
    this.h = paramCallback;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131626296, null);
    paramLayoutInflater.setLayoutParams(new FrameLayout.LayoutParams(-1, AIOUtils.b(60.0F, this.a.getResources())));
    ImageView localImageView = (ImageView)paramLayoutInflater.findViewById(2131436047);
    localImageView.setImageResource(2130842649);
    ((TextView)paramLayoutInflater.findViewById(2131436132)).setVisibility(8);
    ((TextView)paramLayoutInflater.findViewById(2131436136)).setText(HardCodeUtil.a(2131911567));
    paramLayoutInflater.findViewById(2131436114).setVisibility(8);
    paramLayoutInflater.findViewById(2131445643).setVisibility(8);
    paramLayoutInflater.setOnClickListener(new SimpleFeedbackPopupWindow.1(this));
    localImageView.setOnClickListener(new SimpleFeedbackPopupWindow.2(this));
    return paramLayoutInflater;
  }
  
  public void a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    this.i = paramAbsBaseArticleInfo;
    this.j = paramInt;
    if (!this.g)
    {
      a();
      this.g = true;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.SimpleFeedbackPopupWindow
 * JD-Core Version:    0.7.0.1
 */