package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecDataUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.ApolloStickerRecView;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.IStickerPresenter;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.IStickerView;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.emoticonview.IStickerGestureDetector;
import com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class EmotionKeywordLayout
  extends RelativeLayout
{
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  BaseAIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext;
  public boolean a;
  public boolean b = false;
  
  public EmotionKeywordLayout(Context paramContext, BaseAIOContext paramBaseAIOContext, ViewGroup paramViewGroup)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext = paramBaseAIOContext;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = getTag();
    if ((localObject instanceof IStickerView))
    {
      localObject = (IStickerView)localObject;
      IStickerRecEmoticon localIStickerRecEmoticon = (IStickerRecEmoticon)((IStickerView)localObject).a().a();
      if ((localIStickerRecEmoticon != null) && (localIStickerRecEmoticon.c())) {
        localIStickerRecEmoticon.a(System.currentTimeMillis());
      }
      if (((localObject instanceof ApolloStickerRecView)) && (StickerRecDataUtils.a(localIStickerRecEmoticon))) {
        ((ApolloStickerRecView)localObject).b();
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = getTag();
    if ((localObject instanceof IStickerView))
    {
      localObject = (IStickerView)localObject;
      IStickerRecEmoticon localIStickerRecEmoticon = (IStickerRecEmoticon)((IStickerView)localObject).a().a();
      if ((localIStickerRecEmoticon != null) && (localIStickerRecEmoticon.c())) {
        localIStickerRecEmoticon.b(System.currentTimeMillis());
      }
      if (((localObject instanceof ApolloStickerRecView)) && (StickerRecDataUtils.a(localIStickerRecEmoticon))) {
        ((ApolloStickerRecView)localObject).a();
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.i("EmotionKeywordLayout", 2, "EmotionKeywordLayout.onTouchEvent ACTION_MOVE");
          }
          if (this.jdField_a_of_type_Boolean)
          {
            Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
            if (localObject != null)
            {
              if ((!this.b) && ((localObject instanceof TopGestureLayout)))
              {
                localObject = ((TopGestureLayout)localObject).getGestureDetector();
                if ((localObject instanceof IStickerGestureDetector))
                {
                  localObject = (IStickerGestureDetector)localObject;
                  ((IStickerGestureDetector)localObject).setLastX(paramMotionEvent.getRawX());
                  ((IStickerGestureDetector)localObject).setLastY(paramMotionEvent.getRawY());
                  this.b = true;
                }
              }
              this.jdField_a_of_type_AndroidViewViewGroup.onTouchEvent(paramMotionEvent);
              return true;
            }
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmotionKeywordLayout", 2, "EmotionKeywordLayout.onTouchEvent ACTION_UP");
        }
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
        {
          ((IRecommendEmotionService)QRoute.api(IRecommendEmotionService.class)).onEmotionKeywordDimiss(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext);
          this.jdField_a_of_type_Boolean = false;
          this.b = false;
          this.jdField_a_of_type_AndroidViewViewGroup.onTouchEvent(paramMotionEvent);
          return true;
        }
        this.jdField_a_of_type_Boolean = false;
        this.b = false;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmotionKeywordLayout", 2, "EmotionKeywordLayout.onTouchEvent ACTION_DOWN");
      }
      this.b = false;
      this.jdField_a_of_type_Boolean = false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionKeywordLayout
 * JD-Core Version:    0.7.0.1
 */