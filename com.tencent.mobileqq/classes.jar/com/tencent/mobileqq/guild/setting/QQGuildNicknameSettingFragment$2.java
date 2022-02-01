package com.tencent.mobileqq.guild.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;

class QQGuildNicknameSettingFragment$2
  implements View.OnClickListener
{
  QQGuildNicknameSettingFragment$2(QQGuildNicknameSettingFragment paramQQGuildNicknameSettingFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.o != null) {
      InputMethodUtil.b(this.a.o);
    }
    String str = this.a.o.getText().toString();
    QQGuildNicknameSettingFragment.a(this.a, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildNicknameSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */