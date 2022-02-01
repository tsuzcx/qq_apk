package com.tencent.mobileqq.now.recommend;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ScaleXSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.now.VideoCardHolder;
import com.tencent.mobileqq.now.focusanchor.commonwidget.FrameAnimationView;
import com.tencent.mobileqq.now.roport.NowQQLiveDataReport;
import com.tencent.mobileqq.now.widget.RoundedRectImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class NowQQLiveRecommendAnchorHandler
{
  private static final String a = "NowQQLiveRecommendAnchorHandler";
  
  public static void a(BaseActivity paramBaseActivity, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof NoDataViewHolder))
    {
      paramViewHolder = (NoDataViewHolder)paramViewHolder;
      if (paramViewHolder.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        if (paramInt == 3)
        {
          c(paramBaseActivity, paramViewHolder);
          return;
        }
        b(paramBaseActivity, paramViewHolder);
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, RecyclerView.ViewHolder paramViewHolder, RecommendAnchorInfo paramRecommendAnchorInfo, int paramInt)
  {
    if ((paramBaseActivity != null) && (!paramBaseActivity.isFinishing()) && (paramViewHolder != null))
    {
      if (paramRecommendAnchorInfo == null) {
        return;
      }
      paramViewHolder = (VideoCardHolder)paramViewHolder;
      paramViewHolder.jdField_a_of_type_Int = paramInt;
      if (paramViewHolder.jdField_a_of_type_AndroidViewView != null) {
        paramViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(new NowQQLiveRecommendAnchorHandler.1(paramBaseActivity, paramRecommendAnchorInfo, paramInt));
      }
      if (paramViewHolder.jdField_a_of_type_AndroidWidgetTextView != null) {
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramRecommendAnchorInfo.jdField_c_of_type_JavaLangString);
      }
      Object localObject;
      if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowWidgetRoundedRectImageView != null)
      {
        paramInt = paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowWidgetRoundedRectImageView.getWidth() / 2;
        int i = paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowWidgetRoundedRectImageView.getHeight() / 2;
        localObject = (IImageLoader)QRoute.api(IImageLoader.class);
        RoundedRectImageView localRoundedRectImageView = paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowWidgetRoundedRectImageView;
        String str = paramRecommendAnchorInfo.b;
        Drawable localDrawable = paramBaseActivity.getResources().getDrawable(2130841500);
        ColorDrawable localColorDrawable = new ColorDrawable(13553358);
        if (paramInt == 0) {
          paramInt = 300;
        }
        if (i == 0) {
          i = 350;
        }
        ((IImageLoader)localObject).displayImage(localRoundedRectImageView, str, localDrawable, localColorDrawable, paramInt, i, null, false);
      }
      if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowWidgetCircleImageView != null) {
        ((IImageLoader)QRoute.api(IImageLoader.class)).displayImage(paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowWidgetCircleImageView, paramRecommendAnchorInfo.j, paramBaseActivity.getResources().getDrawable(2130841492), new ColorDrawable(13553358), 30, 30, null, true);
      }
      if (paramViewHolder.b != null)
      {
        paramBaseActivity = paramViewHolder.b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramRecommendAnchorInfo.jdField_c_of_type_Int);
        paramBaseActivity.setText(((StringBuilder)localObject).toString());
      }
      if (paramViewHolder.c != null)
      {
        paramBaseActivity = paramRecommendAnchorInfo.b();
        if ((paramBaseActivity != null) && (paramBaseActivity.length() > 0))
        {
          paramViewHolder.c.setText(paramBaseActivity);
          paramViewHolder.c.setVisibility(0);
        }
        else
        {
          paramViewHolder.c.setVisibility(8);
        }
      }
      if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView != null)
      {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView.setAnimationRes(2130841495);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView.a();
      }
      NowQQLiveDataReport.c(paramRecommendAnchorInfo.f);
    }
  }
  
  private static void b(BaseActivity paramBaseActivity, NoDataViewHolder paramNoDataViewHolder)
  {
    if (paramBaseActivity != null) {
      localObject = paramBaseActivity.getResources().getString(2131718144);
    } else {
      localObject = "暂无数据，请刷新页面";
    }
    Object localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new UnderlineSpan(), 6, 8, 33);
    ((SpannableString)localObject).setSpan(new ScaleXSpan(1.1F), 6, 8, 33);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#00CAFC")), 6, 8, 33);
    try
    {
      paramNoDataViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#878B99"));
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse color error: ");
      localStringBuilder.append(localIllegalArgumentException.toString());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramNoDataViewHolder.b != null) {
      paramNoDataViewHolder.b.setVisibility(0);
    }
    if (paramNoDataViewHolder.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      paramNoDataViewHolder.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      paramNoDataViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    paramNoDataViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    paramNoDataViewHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new NowQQLiveRecommendAnchorHandler.2(paramBaseActivity, paramNoDataViewHolder));
  }
  
  private static void c(BaseActivity paramBaseActivity, NoDataViewHolder paramNoDataViewHolder)
  {
    if (paramNoDataViewHolder.b != null) {
      paramNoDataViewHolder.b.setVisibility(4);
    }
    Object localObject;
    if (paramNoDataViewHolder.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = AnimationUtils.loadAnimation(paramBaseActivity, 2130772150);
      ((Animation)localObject).setInterpolator(new LinearInterpolator());
      paramNoDataViewHolder.jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
      paramNoDataViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if (paramBaseActivity != null) {
      paramBaseActivity = paramBaseActivity.getResources().getString(2131718143);
    } else {
      paramBaseActivity = "加载中";
    }
    paramNoDataViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseActivity);
    paramNoDataViewHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    try
    {
      paramNoDataViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00CAFC"));
      return;
    }
    catch (IllegalArgumentException paramBaseActivity)
    {
      paramNoDataViewHolder = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse color error: ");
      ((StringBuilder)localObject).append(paramBaseActivity.toString());
      QLog.d(paramNoDataViewHolder, 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.recommend.NowQQLiveRecommendAnchorHandler
 * JD-Core Version:    0.7.0.1
 */