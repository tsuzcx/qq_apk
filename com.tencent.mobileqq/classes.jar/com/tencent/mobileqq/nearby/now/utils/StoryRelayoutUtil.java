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
    return ((paramView.getTag(2131377914) instanceof Integer)) && (((Integer)paramView.getTag(2131377914)).intValue() == paramRect.height());
  }
  
  public static boolean a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(8);
    ViewGroup.LayoutParams localLayoutParams = paramVideoViewHolder.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    paramVideoViewHolder.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
    return true;
  }
  
  public static boolean a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, float paramFloat1, float paramFloat2)
  {
    if (paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView != null)
    {
      if (paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView == null) {
        return false;
      }
      if (!(paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext() instanceof Activity)) {
        return false;
      }
      if (paramFloat2 != 0.0F)
      {
        if (paramFloat1 == 0.0F) {
          return false;
        }
        if ((paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData != null) && (paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.b == VideoData.a))
        {
          a(paramVideoViewHolder);
          return false;
        }
        Object localObject = paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams = paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.getLayoutParams();
        View localView = ((Activity)paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext()).getWindow().getDecorView();
        Rect localRect = new Rect();
        localView.getWindowVisibleDisplayFrame(localRect);
        float f2 = localRect.height();
        float f1 = UITools.a(paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext());
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
            paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
            paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams(localLayoutParams);
            paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.getRootView().setBackgroundColor(Color.parseColor("#000000"));
            paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
            paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
          }
          else
          {
            paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
            paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
            paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
          }
        }
        else
        {
          i = (int)f1;
          ((ViewGroup.LayoutParams)localObject).width = i;
          int j = (int)f2;
          ((ViewGroup.LayoutParams)localObject).height = j;
          paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
          localLayoutParams.width = i;
          localLayoutParams.height = j;
          paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
        }
        localObject = (ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369331);
        paramVideoViewHolder = (ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365808);
        ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
        paramVideoViewHolder.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, float paramFloat1, float paramFloat2, VideoData paramVideoData, IShortVideoCommentsView paramIShortVideoCommentsView)
  {
    if ((paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView != null) && (paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null))
    {
      if (paramIShortVideoCommentsView == null) {
        return false;
      }
      if (!(paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext() instanceof Activity)) {
        return false;
      }
      if ((paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData != null) && (paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.b == VideoData.a))
      {
        a(paramVideoViewHolder);
        return false;
      }
      paramVideoData = paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getLayoutParams();
      paramIShortVideoCommentsView = paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.getLayoutParams();
      View localView = ((Activity)paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext()).getWindow().getDecorView();
      Rect localRect = new Rect();
      localView.getWindowVisibleDisplayFrame(localRect);
      float f2 = localRect.height();
      float f1 = UITools.a(paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext());
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
          paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setLayoutParams(paramVideoData);
          paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams(paramIShortVideoCommentsView);
          paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.getRootView().setBackgroundColor(Color.parseColor("#000000"));
          paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
          paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
        }
        else
        {
          paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams(paramVideoData);
          paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setLayoutParams(paramVideoData);
          paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
          paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
        }
      }
      else
      {
        i = (int)f1;
        paramVideoData.width = i;
        int j = (int)f2;
        paramVideoData.height = j;
        paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setLayoutParams(paramVideoData);
        paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
        paramIShortVideoCommentsView.width = i;
        paramIShortVideoCommentsView.height = j;
        paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setLayoutParams(paramVideoData);
        paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.requestLayout();
        paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
      }
      paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(new ColorDrawable(-16777216));
    }
    return false;
  }
  
  public static boolean a(FitXImageView paramFitXImageView, int paramInt1, int paramInt2)
  {
    if (paramFitXImageView == null) {
      return false;
    }
    if ((paramFitXImageView.getContext() instanceof Activity)) {
      i = ViewUtils.a((Activity)paramFitXImageView.getContext());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.StoryRelayoutUtil
 * JD-Core Version:    0.7.0.1
 */