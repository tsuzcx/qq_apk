package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter.RecyclerHolder;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragCallBack;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.Iterator;

class SwipeUpAndDragListener$FlingHandler
  extends SwipeUpAndDragListener.GestureHandler
{
  public SwipeUpAndDragListener$FlingHandler(SwipeUpAndDragListener paramSwipeUpAndDragListener, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramSwipeUpAndDragListener, paramContext, paramViewGroup);
  }
  
  private boolean a(int paramInt)
  {
    Object localObject1 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.getWidth() - (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_e_of_type_Float * 2.0F + 0.5F), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.getHeight() - (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_e_of_type_Float * 2.0F + 0.5F) * 2);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = (this.jdField_c_of_type_ArrayOfInt[0] + (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_e_of_type_Float * 2.0F + 0.5F));
    this.jdField_a_of_type_AndroidViewViewGroup.getLocationInWindow(this.jdField_b_of_type_ArrayOfInt);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = (this.jdField_c_of_type_ArrayOfInt[1] - this.jdField_b_of_type_ArrayOfInt[1] - this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.c + (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_e_of_type_Float * 2.0F + 0.5F));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getParent() != null) {
      return false;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.d);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentWidgetRoundRectImageView, (ViewGroup.LayoutParams)localObject1);
    float f = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.getWidth() - (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_e_of_type_Float * 4.0F), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.getHeight() - (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_e_of_type_Float * 4.0F));
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("f scale = ");
    ((StringBuilder)localObject2).append(f);
    Logger.a("PhotoListPanel", "startFlingAnim", ((StringBuilder)localObject2).toString());
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ArrayOfInt[0];
    int k = (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_e_of_type_Float * 65.0F + 0.5F + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.getWidth() * f + 0.5F);
    int m = this.jdField_c_of_type_ArrayOfInt[0];
    paramInt = this.jdField_a_of_type_AndroidViewViewGroup.getHeight();
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ArrayOfInt[1];
    int i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getHeight();
    int i2 = (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_e_of_type_Float * 13.0F + 0.5F + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.getHeight() * f + 0.5F);
    int i3 = this.jdField_c_of_type_ArrayOfInt[1];
    int n = ((RelativeLayout.LayoutParams)localObject1).topMargin - (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_e_of_type_Float * 30.0F);
    i = paramInt + i - i1 - i2 - i3 + n;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_e_of_type_Int);
    paramInt = ((LocalMediaInfo)localObject1).mediaHeight;
    paramInt = ((LocalMediaInfo)localObject1).mediaWidth;
    paramInt = i;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.getItemViewType(this.g) == 1) {
      paramInt = i - (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_e_of_type_Float * 70.0F + 0.5F);
    }
    localObject1 = new AnimationSet(false);
    localObject2 = new ScaleAnimation(1.0F, f, 1.0F, f);
    ((ScaleAnimation)localObject2).setStartOffset(200L);
    ((ScaleAnimation)localObject2).setDuration(300L);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    localObject2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -n);
    ((TranslateAnimation)localObject2).setStartOffset(0L);
    ((TranslateAnimation)localObject2).setDuration(200L);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    localObject2 = new AnimationSet(false);
    ((AnimationSet)localObject2).setStartOffset(200L);
    ((AnimationSet)localObject2).setDuration(300L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, j - k - m, 0.0F, 0.0F);
    localTranslateAnimation.setInterpolator(new LinearInterpolator());
    ((AnimationSet)localObject2).addAnimation(localTranslateAnimation);
    localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, paramInt);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    ((AnimationSet)localObject2).addAnimation(localTranslateAnimation);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    localObject2 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject2).setStartOffset(400L);
    ((AlphaAnimation)localObject2).setDuration(200L);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.startAnimation((Animation)localObject1);
    ((AnimationSet)localObject1).setAnimationListener(new SwipeUpAndDragListener.FlingHandler.1(this));
    return true;
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    return true;
  }
  
  boolean b(MotionEvent paramMotionEvent)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handler = ");
    ((StringBuilder)localObject1).append(this);
    Logger.a("PhotoListPanel", "handleUp", ((StringBuilder)localObject1).toString());
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = f2 - this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.b;
    float f4 = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_Float;
    int i = paramMotionEvent.getPointerId(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    float f5 = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(i);
    paramMotionEvent = new StringBuilder();
    paramMotionEvent.append("@@handleUp,x = ");
    paramMotionEvent.append(f1);
    paramMotionEvent.append(",y = ");
    paramMotionEvent.append(f2);
    paramMotionEvent.append(",delY = ");
    paramMotionEvent.append(f3);
    paramMotionEvent.append(",velocityY = ");
    paramMotionEvent.append(f5);
    paramMotionEvent.append(",SWIPE_THRESHOLD = ");
    paramMotionEvent.append(SwipeUpAndDragListener.b());
    Logger.a("PhotoListPanel", "FlingHandler", paramMotionEvent.toString());
    if ((-f3 > SwipeUpAndDragListener.b()) && (Math.abs(f5) > 100.0F) && (SystemClock.elapsedRealtime() - this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_Long < 500L) && ((this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l == 1) || (this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l == 0)) && (Math.abs(f3) > Math.abs(f1 - f4)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a.size() == 0)
      {
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("handler = ");
        paramMotionEvent.append(this);
        paramMotionEvent.append("mInfos is null!!!!!! targetPosition=");
        paramMotionEvent.append(this.g);
        Logger.a("PhotoListPanel", "handleUp", paramMotionEvent.toString());
        return false;
      }
      bool = false;
      this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean = true;
      if (!a(this.g))
      {
        Logger.a("PhotoListPanel", "handleUp", "handler  animLayout already hasparent= ");
        return false;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.getItemViewType(this.g);
      paramMotionEvent = new ArrayList();
      paramMotionEvent.add(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(this.g).path);
      ReportController.b(null, "dc00898", "", "", "0X800A7B0", "0X800A7B0", this.g + 1, 0, "1", "", "", "");
      int j = PhotoUtils.getTypeforReport2(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(this.g + 1);
      ReportController.b(null, "dc00898", "", "", "0X800A914", "0X800A914", j, 0, ((StringBuilder)localObject1).toString(), "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragCallBack != null)
      {
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragCallBack;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(this.g).path;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.c == 2) {
          bool = true;
        }
        paramMotionEvent.a((String)localObject1, bool);
        return true;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (QFileAssistantUtils.a(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString))
      {
        paramMotionEvent = paramMotionEvent.iterator();
        while (paramMotionEvent.hasNext())
        {
          localObject2 = (String)paramMotionEvent.next();
          this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a((String)localObject2, ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString, ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString, ((SessionInfo)localObject1).jdField_a_of_type_Int, true);
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
      j = this.g;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("");
      ((PhotoListPanel)localObject1).a(j, paramMotionEvent, false, true, "0X8005E0D", "1", ((StringBuilder)localObject2).toString(), false);
      return true;
    }
    boolean bool = false;
    paramMotionEvent = new StringBuilder();
    paramMotionEvent.append("@handleUp,return false. velocityY = ");
    paramMotionEvent.append(f5);
    paramMotionEvent.append(",dely = ");
    paramMotionEvent.append(f2 - this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.b);
    Logger.a("PhotoListPanel", "FlingHandler", paramMotionEvent.toString());
    if ((SystemClock.elapsedRealtime() - this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_Long >= 200L) || (Math.abs(f2 - this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.b) >= this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.d) || (Math.abs(f1 - this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_Float) >= this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.d)) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SwipeUpAndDragListener.FlingHandler
 * JD-Core Version:    0.7.0.1
 */