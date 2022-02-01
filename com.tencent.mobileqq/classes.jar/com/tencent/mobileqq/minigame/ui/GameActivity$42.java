package com.tencent.mobileqq.minigame.ui;

import bbuu;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.minigame.jsapi.widgets.KeyboardLayout;

class GameActivity$42
  implements bbuu
{
  GameActivity$42(GameActivity paramGameActivity) {}
  
  public void onSoftKeyboardClosed()
  {
    if ((GameActivity.access$5500(this.this$0) != null) && (GameActivity.access$5500(this.this$0).getVisibility() == 0)) {
      GameActivity.access$5500(this.this$0).setVisibility(8);
    }
    DisplayUtil.setActivityFullScreen(this.this$0);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    if ((GameActivity.access$5500(this.this$0) != null) && (GameActivity.access$5500(this.this$0).getVisibility() == 0)) {
      GameActivity.access$5500(this.this$0).setPaddingBottom(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.42
 * JD-Core Version:    0.7.0.1
 */