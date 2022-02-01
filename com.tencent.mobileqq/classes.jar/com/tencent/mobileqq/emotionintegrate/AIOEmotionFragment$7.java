package com.tencent.mobileqq.emotionintegrate;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

class AIOEmotionFragment$7
  implements View.OnTouchListener
{
  AIOEmotionFragment$7(AIOEmotionFragment paramAIOEmotionFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.a.b.setBackgroundColor(Color.parseColor("#F7F7F7"));
      EmojiHomeUiPlugin.openEmojiDetailPage(this.a.getBaseActivity(), this.a.a().getAccount(), 8, this.a.a.epId, false, false);
      this.a.a("0X800997F");
    }
    else if (paramMotionEvent.getAction() == 0)
    {
      this.a.b.setBackgroundColor(Color.parseColor("#DEDEDE"));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.7
 * JD-Core Version:    0.7.0.1
 */