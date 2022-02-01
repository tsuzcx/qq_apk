package com.tencent.mobileqq.guild.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.guild.util.QQGuildTextUtils;
import com.tencent.mobileqq.guild.util.QQGuildTextUtils.CharacterCountInfo;
import com.tencent.qphone.base.util.QLog;

class CharacterCountEditText$2
  implements TextWatcher
{
  private QQGuildTextUtils.CharacterCountInfo b;
  private boolean c = false;
  private int d = 0;
  private int e = 0;
  
  CharacterCountEditText$2(CharacterCountEditText paramCharacterCountEditText) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("afterTextChanged : ");
      localStringBuilder.append(paramEditable.toString());
      localStringBuilder.append(", s hash: ");
      localStringBuilder.append(paramEditable.hashCode());
      QLog.d("CharacterCountEditText", 4, new Object[] { localStringBuilder.toString(), "shouldLimit: ", Boolean.valueOf(this.c) });
      if (this.c)
      {
        QLog.d("CharacterCountEditText", 4, new Object[] { "afterText, start: ", Integer.valueOf(this.d), " end: ", Integer.valueOf(this.e) });
        QLog.d("CharacterCountEditText", 4, new Object[] { "afterText, ", paramEditable.subSequence(0, this.d), " + ", paramEditable.subSequence(this.e, paramEditable.length()) });
      }
    }
    if (this.c)
    {
      paramEditable.replace(this.d, this.e, "");
      this.c = false;
      this.b = QQGuildTextUtils.a(paramEditable);
    }
    if (CharacterCountEditText.b(this.a) != null) {
      CharacterCountEditText.b(this.a).a(this.b);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = QQGuildTextUtils.a(paramCharSequence);
    if (this.b.a() <= CharacterCountEditText.a(this.a))
    {
      this.c = false;
      return;
    }
    paramInt2 = paramInt3 + paramInt1;
    QQGuildTextUtils.CharacterCountInfo localCharacterCountInfo = QQGuildTextUtils.a(paramCharSequence.subSequence(paramInt1, paramInt2));
    float f = CharacterCountEditText.a(this.a) - (this.b.b() - localCharacterCountInfo.b());
    if (f >= 0.0F)
    {
      this.d = QQGuildTextUtils.a(paramCharSequence, paramInt1, f);
      this.e = paramInt2;
    }
    else
    {
      this.d = QQGuildTextUtils.a(paramCharSequence, 0, CharacterCountEditText.a(this.a));
      this.e = paramCharSequence.length();
    }
    this.c = true;
    if (CharacterCountEditText.b(this.a) != null) {
      CharacterCountEditText.b(this.a).b(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.CharacterCountEditText.2
 * JD-Core Version:    0.7.0.1
 */