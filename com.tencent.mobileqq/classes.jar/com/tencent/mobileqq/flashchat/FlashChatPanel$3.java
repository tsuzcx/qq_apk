package com.tencent.mobileqq.flashchat;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.widget.QQViewPager;

class FlashChatPanel$3
  extends PagerAdapter
{
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    ((QQViewPager)paramViewGroup).removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return 2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    FlashChatTextEffectView localFlashChatTextEffectView;
    if (paramInt == 0) {
      localFlashChatTextEffectView = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView[0];
    } else if (paramInt == 1) {
      localFlashChatTextEffectView = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView[1];
    } else {
      localFlashChatTextEffectView = null;
    }
    if (localFlashChatTextEffectView != null)
    {
      ViewParent localViewParent = this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getParent();
      if (localViewParent != null) {
        ((ViewGroup)localViewParent).removeView(localFlashChatTextEffectView);
      }
      paramViewGroup.addView(localFlashChatTextEffectView);
      localFlashChatTextEffectView.requestLayout();
    }
    return localFlashChatTextEffectView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatPanel.3
 * JD-Core Version:    0.7.0.1
 */