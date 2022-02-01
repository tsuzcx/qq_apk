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
      if (paramViewHolder.a != null)
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
      paramViewHolder.j = paramInt;
      if (paramViewHolder.a != null) {
        paramViewHolder.a.setOnClickListener(new NowQQLiveRecommendAnchorHandler.1(paramBaseActivity, paramRecommendAnchorInfo, paramInt));
      }
      if (paramViewHolder.d != null) {
        paramViewHolder.d.setText(paramRecommendAnchorInfo.e);
      }
      Object localObject;
      if (paramViewHolder.b != null)
      {
        paramInt = paramViewHolder.b.getWidth() / 2;
        int i = paramViewHolder.b.getHeight() / 2;
        localObject = (IImageLoader)QRoute.api(IImageLoader.class);
        RoundedRectImageView localRoundedRectImageView = paramViewHolder.b;
        String str = paramRecommendAnchorInfo.d;
        Drawable localDrawable = paramBaseActivity.getResources().getDrawable(2130842342);
        ColorDrawable localColorDrawable = new ColorDrawable(13553358);
        if (paramInt == 0) {
          paramInt = 300;
        }
        if (i == 0) {
          i = 350;
        }
        ((IImageLoader)localObject).displayImage(localRoundedRectImageView, str, localDrawable, localColorDrawable, paramInt, i, null, false);
      }
      if (paramViewHolder.c != null) {
        ((IImageLoader)QRoute.api(IImageLoader.class)).displayImage(paramViewHolder.c, paramRecommendAnchorInfo.q, paramBaseActivity.getResources().getDrawable(2130842334), new ColorDrawable(13553358), 30, 30, null, true);
      }
      if (paramViewHolder.h != null)
      {
        paramBaseActivity = paramViewHolder.h;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramRecommendAnchorInfo.i);
        paramBaseActivity.setText(((StringBuilder)localObject).toString());
      }
      if (paramViewHolder.i != null)
      {
        paramBaseActivity = paramRecommendAnchorInfo.b();
        if ((paramBaseActivity != null) && (paramBaseActivity.length() > 0))
        {
          paramViewHolder.i.setText(paramBaseActivity);
          paramViewHolder.i.setVisibility(0);
        }
        else
        {
          paramViewHolder.i.setVisibility(8);
        }
      }
      if (paramViewHolder.g != null)
      {
        paramViewHolder.g.setAnimationRes(2130842337);
        paramViewHolder.g.a();
      }
      NowQQLiveDataReport.c(paramRecommendAnchorInfo.h);
    }
  }
  
  private static void b(BaseActivity paramBaseActivity, NoDataViewHolder paramNoDataViewHolder)
  {
    if (paramBaseActivity != null) {
      localObject = paramBaseActivity.getResources().getString(2131915622);
    } else {
      localObject = "暂无数据，请刷新页面";
    }
    Object localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new UnderlineSpan(), 6, 8, 33);
    ((SpannableString)localObject).setSpan(new ScaleXSpan(1.1F), 6, 8, 33);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#00CAFC")), 6, 8, 33);
    try
    {
      paramNoDataViewHolder.a.setTextColor(Color.parseColor("#878B99"));
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse color error: ");
      localStringBuilder.append(localIllegalArgumentException.toString());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramNoDataViewHolder.c != null) {
      paramNoDataViewHolder.c.setVisibility(0);
    }
    if (paramNoDataViewHolder.b != null)
    {
      paramNoDataViewHolder.b.clearAnimation();
      paramNoDataViewHolder.b.setVisibility(8);
    }
    paramNoDataViewHolder.a.setText((CharSequence)localObject);
    paramNoDataViewHolder.a.setOnClickListener(new NowQQLiveRecommendAnchorHandler.2(paramBaseActivity, paramNoDataViewHolder));
  }
  
  private static void c(BaseActivity paramBaseActivity, NoDataViewHolder paramNoDataViewHolder)
  {
    if (paramNoDataViewHolder.c != null) {
      paramNoDataViewHolder.c.setVisibility(4);
    }
    Object localObject;
    if (paramNoDataViewHolder.b != null)
    {
      localObject = AnimationUtils.loadAnimation(paramBaseActivity, 2130772199);
      ((Animation)localObject).setInterpolator(new LinearInterpolator());
      paramNoDataViewHolder.b.startAnimation((Animation)localObject);
      paramNoDataViewHolder.b.setVisibility(0);
    }
    if (paramBaseActivity != null) {
      paramBaseActivity = paramBaseActivity.getResources().getString(2131915621);
    } else {
      paramBaseActivity = "加载中";
    }
    paramNoDataViewHolder.a.setText(paramBaseActivity);
    paramNoDataViewHolder.a.setOnClickListener(null);
    try
    {
      paramNoDataViewHolder.a.setTextColor(Color.parseColor("#00CAFC"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.recommend.NowQQLiveRecommendAnchorHandler
 * JD-Core Version:    0.7.0.1
 */