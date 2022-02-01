package com.tencent.mobileqq.settings.message;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$30
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$30(AssistantSettingFragment paramAssistantSettingFragment, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sticker_switch_" + this.jdField_a_of_type_JavaLangString, paramBoolean).commit();
    if ((paramBoolean) && (EmojiStickerManager.a())) {}
    for (boolean bool = true;; bool = false)
    {
      EmojiStickerManager.f = bool;
      ReportClickEventHelper.a(AssistantSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment), "0X800B880", EmojiStickerManager.f);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.30
 * JD-Core Version:    0.7.0.1
 */