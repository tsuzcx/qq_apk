package com.tencent.mobileqq.nearby.now.utils;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.nearby.now.view.widget.FitXImageView;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.mobileqq.utils.ViewUtils;

public class StoryRelayoutUtil
{
  public static float a = 600.0F;
  public static float b = 1334.0F;
  public static float c = -1.0F;
  
  public static boolean a(View paramView, Rect paramRect)
  {
    return ((paramView.getTag(2131446400) instanceof Integer)) && (((Integer)paramView.getTag(2131446400)).intValue() == paramRect.height());
  }
  
  public static boolean a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramVideoViewHolder.c.setVisibility(8);
    paramVideoViewHolder.e.setVisibility(8);
    ViewGroup.LayoutParams localLayoutParams = paramVideoViewHolder.b.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    paramVideoViewHolder.b.setLayoutParams(localLayoutParams);
    return true;
  }
  
  public static boolean a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, float paramFloat1, float paramFloat2)
  {
    if (paramVideoViewHolder.e != null)
    {
      if (paramVideoViewHolder.d == null) {
        return false;
      }
      if (!(paramVideoViewHolder.e.getContext() instanceof Activity)) {
        return false;
      }
      if (paramFloat2 != 0.0F)
      {
        if (paramFloat1 == 0.0F) {
          return false;
        }
        if ((paramVideoViewHolder.h != null) && (paramVideoViewHolder.h.b == VideoData.a))
        {
          a(paramVideoViewHolder);
          return false;
        }
        Object localObject = paramVideoViewHolder.c.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams = paramVideoViewHolder.d.getLayoutParams();
        View localView = ((Activity)paramVideoViewHolder.e.getContext()).getWindow().getDecorView();
        Rect localRect = new Rect();
        localView.getWindowVisibleDisplayFrame(localRect);
        float f2 = localRect.height();
        float f1 = UITools.a(paramVideoViewHolder.e.getContext());
        c = f2 / 2.0F;
        int i;
        if (f1 / f2 < paramFloat1 / paramFloat2)
        {
          paramFloat1 = paramFloat2 * (f1 / paramFloat1);
          i = (int)f1;
          ((ViewGroup.LayoutParams)localObject).width = i;
          ((ViewGroup.LayoutParams)localObject).height = ((int)paramFloat1);
          paramFloat2 = c;
          if (paramFloat1 <= paramFloat2)
          {
            localLayoutParams.width = i;
            localLayoutParams.height = ((int)paramFloat2);
            ((ViewGroup.LayoutParams)localObject).width = i;
            ((ViewGroup.LayoutParams)localObject).height = ((int)paramFloat2);
            paramVideoViewHolder.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
            paramVideoViewHolder.d.setLayoutParams(localLayoutParams);
            paramVideoViewHolder.d.getRootView().setBackgroundColor(Color.parseColor("#000000"));
            paramVideoViewHolder.d.requestLayout();
            paramVideoViewHolder.c.requestLayout();
          }
          else
          {
            paramVideoViewHolder.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
            paramVideoViewHolder.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
            paramVideoViewHolder.d.requestLayout();
            paramVideoViewHolder.c.requestLayout();
          }
        }
        else
        {
          i = (int)f1;
          ((ViewGroup.LayoutParams)localObject).width = i;
          int j = (int)f2;
          ((ViewGroup.LayoutParams)localObject).height = j;
          paramVideoViewHolder.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramVideoViewHolder.c.requestLayout();
          localLayoutParams.width = i;
          localLayoutParams.height = j;
          paramVideoViewHolder.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramVideoViewHolder.d.requestLayout();
        }
        localObject = (ImageView)paramVideoViewHolder.c.findViewById(2131436334);
        paramVideoViewHolder = (ImageView)paramVideoViewHolder.c.findViewById(2131432065);
        ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
        paramVideoViewHolder.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, float paramFloat1, float paramFloat2, VideoData paramVideoData, IShortVideoCommentsView paramIShortVideoCommentsView)
  {
    if ((paramVideoViewHolder.e != null) && (paramVideoViewHolder.d != null))
    {
      if (paramIShortVideoCommentsView == null) {
        return false;
      }
      if (!(paramVideoViewHolder.e.getContext() instanceof Activity)) {
        return false;
      }
      if ((paramVideoViewHolder.h != null) && (paramVideoViewHolder.h.b == VideoData.a))
      {
        a(paramVideoViewHolder);
        return false;
      }
      paramVideoData = paramVideoViewHolder.e.getLayoutParams();
      paramIShortVideoCommentsView = paramVideoViewHolder.d.getLayoutParams();
      View localView = ((Activity)paramVideoViewHolder.e.getContext()).getWindow().getDecorView();
      Rect localRect = new Rect();
      localView.getWindowVisibleDisplayFrame(localRect);
      float f2 = localRect.height();
      float f1 = UITools.a(paramVideoViewHolder.e.getContext());
      c = f2 / 2.0F;
      int i;
      if (f1 / f2 < paramFloat2 / paramFloat1)
      {
        paramFloat1 *= f1 / paramFloat2;
        i = (int)f1;
        paramVideoData.width = i;
        paramVideoData.height = ((int)paramFloat1);
        paramFloat2 = c;
        if (paramFloat1 <= paramFloat2)
        {
          paramIShortVideoCommentsView.width = i;
          paramIShortVideoCommentsView.height = ((int)paramFloat2);
          paramVideoData.width = i;
          paramVideoData.height = ((int)paramFloat2);
          paramVideoViewHolder.e.setLayoutParams(paramVideoData);
          paramVideoViewHolder.d.setLayoutParams(paramIShortVideoCommentsView);
          paramVideoViewHolder.d.getRootView().setBackgroundColor(Color.parseColor("#000000"));
          paramVideoViewHolder.d.requestLayout();
          paramVideoViewHolder.e.requestLayout();
        }
        else
        {
          paramVideoViewHolder.d.setLayoutParams(paramVideoData);
          paramVideoViewHolder.e.setLayoutParams(paramVideoData);
          paramVideoViewHolder.d.requestLayout();
          paramVideoViewHolder.e.requestLayout();
        }
      }
      else
      {
        i = (int)f1;
        paramVideoData.width = i;
        int j = (int)f2;
        paramVideoData.height = j;
        paramVideoViewHolder.e.setLayoutParams(paramVideoData);
        paramVideoViewHolder.e.requestLayout();
        paramIShortVideoCommentsView.width = i;
        paramIShortVideoCommentsView.height = j;
        paramVideoViewHolder.d.setLayoutParams(paramVideoData);
        paramVideoViewHolder.d.requestLayout();
        paramVideoViewHolder.e.requestLayout();
      }
      paramVideoViewHolder.c.setBackgroundDrawable(new ColorDrawable(-16777216));
    }
    return false;
  }
  
  public static boolean a(FitXImageView paramFitXImageView, int paramInt1, int paramInt2)
  {
    if (paramFitXImageView == null) {
      return false;
    }
    if ((paramFitXImageView.getContext() instanceof Activity)) {
      i = ViewUtils.getStatusBarHeight((Activity)paramFitXImageView.getContext());
    } else {
      i = 0;
    }
    float f1 = UITools.b(paramFitXImageView.getContext()) - i;
    float f2 = UITools.a(paramFitXImageView.getContext());
    float f3 = f2 / paramInt1;
    f3 = paramInt2 * f3;
    paramInt1 = (int)UITools.a(paramFitXImageView.getContext(), 60.0F);
    paramInt2 = (int)UITools.a(paramFitXImageView.getContext(), 72.0F);
    float f4 = paramInt1 + f3 + paramInt2 + 10.0F;
    paramInt2 = (int)UITools.a(paramFitXImageView.getContext(), 50.0F);
    int i = (int)f1;
    Object localObject = paramFitXImageView.getLayoutParams();
    float f5 = i - paramInt2;
    if (f4 >= f5)
    {
      if (f3 < f1)
      {
        ((ViewGroup.LayoutParams)localObject).height = ((int)f3);
        ((ViewGroup.LayoutParams)localObject).width = ((int)f2);
        paramFitXImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramFitXImageView.requestLayout();
        return false;
      }
      ((ViewGroup.LayoutParams)localObject).width = ((int)f2);
      ((ViewGroup.LayoutParams)localObject).height = i;
      paramFitXImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramFitXImageView.requestLayout();
      return false;
    }
    if (f4 < f5)
    {
      if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
      } else {
        localObject = new ViewGroup.MarginLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = paramInt1;
      ((ViewGroup.MarginLayoutParams)localObject).height = ((int)f3);
      ((ViewGroup.MarginLayoutParams)localObject).width = ((int)f2);
      paramFitXImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramFitXImageView.requestLayout();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.StoryRelayoutUtil
 * JD-Core Version:    0.7.0.1
 */