package com.tencent.mobileqq.troop.activity;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TroopNickRuleFragment$7
  implements InputFilter
{
  Pattern a = Pattern.compile("[🀀-🏿]|[🐀-🟿]|[☀-⟿]", 66);
  
  TroopNickRuleFragment$7(TroopNickRuleFragment paramTroopNickRuleFragment) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (this.a.matcher(paramCharSequence).find()) {
      return "";
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopNickRuleFragment.7
 * JD-Core Version:    0.7.0.1
 */