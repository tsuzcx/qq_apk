package com.tencent.mobileqq.emotionintegrate;

import android.content.Intent;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

class AIOEmotionFragment$5
  implements View.OnTouchListener
{
  AIOEmotionFragment$5(AIOEmotionFragment paramAIOEmotionFragment, int paramInt, MessageForPic paramMessageForPic) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.c.a("0X800A7E7");
      this.c.m.setBackgroundColor(Color.parseColor("#F7F7F7"));
      if (this.a == 1)
      {
        this.c.a("0X800A7E9");
        EmojiHomeUiPlugin.openEmojiDetailPage(this.c.getBaseActivity(), this.c.c().getAccount(), 8, this.b.picExtraData.emojiPkgId, false, false);
      }
      else
      {
        this.c.a("0X800A7E8");
        paramView = new Intent(this.c.getBaseActivity(), QQBrowserActivity.class);
        paramView.putExtra("url", this.b.picExtraData.webUrl);
        this.c.getBaseActivity().startActivity(paramView);
      }
    }
    else if (paramMotionEvent.getAction() == 0)
    {
      this.c.m.setBackgroundColor(Color.parseColor("#DEDEDE"));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.5
 * JD-Core Version:    0.7.0.1
 */