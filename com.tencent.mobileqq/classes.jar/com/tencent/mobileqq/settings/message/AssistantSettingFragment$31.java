package com.tencent.mobileqq.settings.message;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$31
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$31(AssistantSettingFragment paramAssistantSettingFragment, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sticker_switch_");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean).commit();
    boolean bool;
    if ((paramBoolean) && (EmojiStickerManager.a())) {
      bool = true;
    } else {
      bool = false;
    }
    EmojiStickerManager.f = bool;
    ReportClickEventHelper.a(AssistantSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment), "0X800B880", EmojiStickerManager.f);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.31
 * JD-Core Version:    0.7.0.1
 */