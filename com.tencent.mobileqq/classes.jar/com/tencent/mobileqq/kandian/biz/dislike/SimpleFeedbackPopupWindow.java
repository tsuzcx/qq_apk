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
  private int jdField_a_of_type_Int;
  private SimpleFeedbackPopupWindow.Callback jdField_a_of_type_ComTencentMobileqqKandianBizDislikeSimpleFeedbackPopupWindow$Callback;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  protected boolean b = false;
  
  public SimpleFeedbackPopupWindow(Activity paramActivity, SimpleFeedbackPopupWindow.Callback paramCallback)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeSimpleFeedbackPopupWindow$Callback = paramCallback;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560249, null);
    paramLayoutInflater.setLayoutParams(new FrameLayout.LayoutParams(-1, AIOUtils.b(60.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())));
    ImageView localImageView = (ImageView)paramLayoutInflater.findViewById(2131369083);
    localImageView.setImageResource(2130841732);
    ((TextView)paramLayoutInflater.findViewById(2131369159)).setVisibility(8);
    ((TextView)paramLayoutInflater.findViewById(2131369163)).setText(HardCodeUtil.a(2131714036));
    paramLayoutInflater.findViewById(2131369143).setVisibility(8);
    paramLayoutInflater.findViewById(2131377256).setVisibility(8);
    paramLayoutInflater.setOnClickListener(new SimpleFeedbackPopupWindow.1(this));
    localImageView.setOnClickListener(new SimpleFeedbackPopupWindow.2(this));
    return paramLayoutInflater;
  }
  
  public void a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_Int = paramInt;
    if (!this.b)
    {
      a();
      this.b = true;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.SimpleFeedbackPopupWindow
 * JD-Core Version:    0.7.0.1
 */