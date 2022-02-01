package com.tencent.mobileqq.guild.setting;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQGuildNicknameSettingFragment$1
  implements View.OnClickListener
{
  QQGuildNicknameSettingFragment$1(QQGuildNicknameSettingFragment paramQQGuildNicknameSettingFragment) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.o.getText() != null) && (this.a.o.getText().length() > 0)) {
      this.a.o.setText("");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildNicknameSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */