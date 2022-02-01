package com.tencent.mobileqq.settings.message;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$34
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$34(AssistantSettingFragment paramAssistantSettingFragment, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sticker_switch_");
    localStringBuilder.append(this.b);
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean).commit();
    boolean bool;
    if ((paramBoolean) && (EmojiStickerManager.d())) {
      bool = true;
    } else {
      bool = false;
    }
    EmojiStickerManager.n = bool;
    ReportClickEventHelper.a(AssistantSettingFragment.c(this.c), "0X800B880", EmojiStickerManager.n);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.34
 * JD-Core Version:    0.7.0.1
 */