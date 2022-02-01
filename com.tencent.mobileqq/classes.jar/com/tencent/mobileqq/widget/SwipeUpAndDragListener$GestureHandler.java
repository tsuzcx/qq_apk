package com.tencent.mobileqq.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter.RecyclerHolder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RoundRectImageView;
import mqq.os.MqqHandler;

class SwipeUpAndDragListener$GestureHandler
{
  Context jdField_a_of_type_AndroidContentContext;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  PhotoListPanel.PhotoPanelAdapter.RecyclerHolder jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder;
  RoundRectImageView jdField_a_of_type_ComTencentWidgetRoundRectImageView;
  Runnable jdField_a_of_type_JavaLangRunnable;
  AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  Runnable jdField_b_of_type_JavaLangRunnable;
  int[] jdField_b_of_type_ArrayOfInt;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  int[] jdField_c_of_type_ArrayOfInt;
  RelativeLayout.LayoutParams jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  RelativeLayout.LayoutParams e;
  int g;
  
  public SwipeUpAndDragListener$GestureHandler(SwipeUpAndDragListener paramSwipeUpAndDragListener, Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_b_of_type_ArrayOfInt = new int[2];
    this.jdField_c_of_type_ArrayOfInt = new int[2];
    paramViewGroup.getLocationInWindow(this.jdField_b_of_type_ArrayOfInt);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(paramContext);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(17170445);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new SwipeUpAndDragListener.GestureHandler.1(this, paramSwipeUpAndDragListener));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = paramSwipeUpAndDragListener.c;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(paramContext);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(637534208);
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView = new RoundRectImageView(paramContext);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new SwipeUpAndDragListener.GestureHandler.2(this, paramSwipeUpAndDragListener);
    this.jdField_a_of_type_JavaLangRunnable = new SwipeUpAndDragListener.GestureHandler.3(this, paramSwipeUpAndDragListener);
    this.jdField_b_of_type_JavaLangRunnable = new SwipeUpAndDragListener.GestureHandler.4(this, paramSwipeUpAndDragListener);
  }
  
  boolean a()
  {
    RelativeLayout localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    return (localRelativeLayout != null) && (this.jdField_a_of_type_AndroidViewViewGroup.indexOfChild(localRelativeLayout) != -1);
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  boolean a(PhotoListPanel.PhotoPanelAdapter.RecyclerHolder paramRecyclerHolder, int paramInt)
  {
    SwipeUpAndDragListener localSwipeUpAndDragListener = this.jdField_b_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener;
    localSwipeUpAndDragListener.jdField_a_of_type_Boolean = true;
    localSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().setMotionEventSplittingEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder = paramRecyclerHolder;
    this.g = paramInt;
    paramRecyclerHolder.itemView.getLocationInWindow(this.jdField_c_of_type_ArrayOfInt);
    paramRecyclerHolder = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.a.getDrawable();
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setImageDrawable(paramRecyclerHolder);
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return true;
  }
  
  void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handler = ");
    localStringBuilder.append(this);
    QLog.d("PhotoListPanel", 1, new Object[] { "clear", localStringBuilder.toString() });
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null)
    {
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 50L);
      return;
    }
    ThreadManager.getUIHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
  }
  
  boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  boolean c(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SwipeUpAndDragListener.GestureHandler
 * JD-Core Version:    0.7.0.1
 */