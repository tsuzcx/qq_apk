package com.tencent.mobileqq.qqexpand.widget;

import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;

class ExtendFriendCardOnHeadIconClick$3
  implements Runnable
{
  ExtendFriendCardOnHeadIconClick$3(ExtendFriendCardOnHeadIconClick paramExtendFriendCardOnHeadIconClick, TranslateAnimation paramTranslateAnimation) {}
  
  public void run()
  {
    ExtendFriendCardOnHeadIconClick.h(this.this$0).setVisibility(0);
    Object localObject = (FrameLayout)ExtendFriendCardOnHeadIconClick.h(this.this$0).findViewById(1912930341);
    ((FrameLayout)localObject).setVisibility(0);
    ((FrameLayout)localObject).startAnimation(this.a);
    if (ExtendFriendCardOnHeadIconClick.i(this.this$0))
    {
      localObject = this.this$0;
      ExtendFriendCardOnHeadIconClick.a((ExtendFriendCardOnHeadIconClick)localObject, "expose", "data_page", "view", ExtendFriendCardOnHeadIconClick.c((ExtendFriendCardOnHeadIconClick)localObject));
      return;
    }
    localObject = this.this$0;
    ExtendFriendCardOnHeadIconClick.a((ExtendFriendCardOnHeadIconClick)localObject, "expose", "data_cpage", "view", ExtendFriendCardOnHeadIconClick.c((ExtendFriendCardOnHeadIconClick)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendCardOnHeadIconClick.3
 * JD-Core Version:    0.7.0.1
 */