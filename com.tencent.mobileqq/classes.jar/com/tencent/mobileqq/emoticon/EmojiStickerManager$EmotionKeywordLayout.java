package com.tencent.mobileqq.emoticon;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.ViewHolder;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecDataUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticonview.StickerGestureDetector;
import com.tencent.qphone.base.util.QLog;

public class EmojiStickerManager$EmotionKeywordLayout
  extends RelativeLayout
{
  BaseChatPie a;
  public boolean a;
  public boolean b = false;
  
  public EmojiStickerManager$EmotionKeywordLayout(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = getTag();
    if ((localObject instanceof StickerRecBarAdapter.ViewHolder))
    {
      localObject = (StickerRecBarAdapter.ViewHolder)localObject;
      IStickerRecEmoticon localIStickerRecEmoticon = ((StickerRecBarAdapter.ViewHolder)localObject).a();
      if ((localIStickerRecEmoticon != null) && (localIStickerRecEmoticon.c())) {
        localIStickerRecEmoticon.a(System.currentTimeMillis());
      }
      if (StickerRecDataUtils.a(localIStickerRecEmoticon)) {
        ((StickerRecBarAdapter.ViewHolder)localObject).d();
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = getTag();
    if ((localObject instanceof StickerRecBarAdapter.ViewHolder))
    {
      localObject = (StickerRecBarAdapter.ViewHolder)localObject;
      IStickerRecEmoticon localIStickerRecEmoticon = ((StickerRecBarAdapter.ViewHolder)localObject).a();
      if ((localIStickerRecEmoticon != null) && (localIStickerRecEmoticon.c())) {
        localIStickerRecEmoticon.b(System.currentTimeMillis());
      }
      if (StickerRecDataUtils.a(localIStickerRecEmoticon)) {
        ((StickerRecBarAdapter.ViewHolder)localObject).c();
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
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c != null))
      {
        Object localObject;
        if ((!this.b) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c instanceof TopGestureLayout)))
        {
          localObject = ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c).getGestureDetector();
          if ((localObject instanceof StickerGestureDetector))
          {
            localObject = (StickerGestureDetector)localObject;
            ((StickerGestureDetector)localObject).lastX = paramMotionEvent.getRawX();
            ((StickerGestureDetector)localObject).lastY = paramMotionEvent.getRawY();
            this.b = true;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.onTouchEvent(paramMotionEvent);
        return true;
        if (QLog.isColorLevel()) {
          QLog.i("EmojiStickerManager", 2, "EmotionKeywordLayout.onTouchEvent ACTION_UP");
        }
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c != null))
        {
          localObject = (AIOEmoticonUIHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(105);
          if (localObject != null) {
            ((AIOEmoticonUIHelper)localObject).m();
          }
          this.jdField_a_of_type_Boolean = false;
          this.b = false;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.onTouchEvent(paramMotionEvent);
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