package com.tencent.mobileqq.guild.setting;

import android.widget.TextView;
import com.tencent.mobileqq.guild.util.QQGuildTextUtils.CharacterCountInfo;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText.ITextEditEventListener;
import java.util.Locale;

class QQGuildDescriptionEditFragment$3
  implements CharacterCountEditText.ITextEditEventListener
{
  QQGuildDescriptionEditFragment$3(QQGuildDescriptionEditFragment paramQQGuildDescriptionEditFragment) {}
  
  public void a(QQGuildTextUtils.CharacterCountInfo paramCharacterCountInfo)
  {
    this.a.o.setText(String.format(Locale.getDefault(), "%d/%d", new Object[] { Integer.valueOf(paramCharacterCountInfo.a()), Integer.valueOf(25) }));
  }
  
  public void b(QQGuildTextUtils.CharacterCountInfo paramCharacterCountInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildDescriptionEditFragment.3
 * JD-Core Version:    0.7.0.1
 */