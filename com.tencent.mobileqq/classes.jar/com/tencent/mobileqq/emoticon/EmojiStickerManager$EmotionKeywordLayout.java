package com.tencent.mobileqq.emoticon;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import aocn;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
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
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c != null))
      {
        if ((!this.b) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c instanceof TopGestureLayout)))
        {
          Object localObject = ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c).getGestureDetector();
          if ((localObject instanceof aocn))
          {
            localObject = (aocn)localObject;
            ((aocn)localObject).a = paramMotionEvent.getRawX();
            ((aocn)localObject).b = paramMotionEvent.getRawY();
            this.b = true;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.onTouchEvent(paramMotionEvent);
        return true;
        if (QLog.isColorLevel()) {
          QLog.i("EmojiStickerManager", 2, "EmotionKeywordLayout.onTouchEvent ACTION_UP");
        }
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bg();
          this.jdField_a_of_type_Boolean = false;
          this.b = false;
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.onTouchEvent(paramMotionEvent);
          return true;
        }
        this.jdField_a_of_type_Boolean = false;
        this.b = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiStickerManager.EmotionKeywordLayout
 * JD-Core Version:    0.7.0.1
 */