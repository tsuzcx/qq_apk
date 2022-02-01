package com.tencent.mobileqq.emoticon;

import ahmw;
import ahng;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.emoticonview.StickerGestureDetector;
import com.tencent.qphone.base.util.QLog;

public class EmojiStickerManager$EmotionKeywordLayout
  extends RelativeLayout
{
  BaseChatPie a;
  public boolean a;
  public boolean b;
  
  public EmojiStickerManager$EmotionKeywordLayout(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = getTag();
    if ((localObject instanceof ahng))
    {
      localObject = ((ahng)localObject).a();
      if ((localObject != null) && (((ahmw)localObject).c())) {
        ((ahmw)localObject).a(System.currentTimeMillis());
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = getTag();
    if ((localObject instanceof ahng))
    {
      localObject = ((ahng)localObject).a();
      if ((localObject != null) && (((ahmw)localObject).c())) {
        ((ahmw)localObject).b(System.currentTimeMillis());
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "EmotionKeywordLayout.onTouchEvent ACTION_DOWN");
      }
      this.b = false;
      this.jdField_a_of_type_Boolean = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "EmotionKeywordLayout.onTouchEvent ACTION_MOVE");
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView != null))
      {
        if ((!this.b) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView instanceof TopGestureLayout)))
        {
          Object localObject = ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView).getGestureDetector();
          if ((localObject instanceof StickerGestureDetector))
          {
            localObject = (StickerGestureDetector)localObject;
            ((StickerGestureDetector)localObject).lastX = paramMotionEvent.getRawX();
            ((StickerGestureDetector)localObject).lastY = paramMotionEvent.getRawY();
            this.b = true;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.onTouchEvent(paramMotionEvent);
        return true;
        if (QLog.isColorLevel()) {
          QLog.i("EmojiStickerManager", 2, "EmotionKeywordLayout.onTouchEvent ACTION_UP");
        }
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.onEmotionKeywordDimiss();
          this.jdField_a_of_type_Boolean = false;
          this.b = false;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.onTouchEvent(paramMotionEvent);
          return true;
        }
        this.jdField_a_of_type_Boolean = false;
        this.b = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiStickerManager.EmotionKeywordLayout
 * JD-Core Version:    0.7.0.1
 */