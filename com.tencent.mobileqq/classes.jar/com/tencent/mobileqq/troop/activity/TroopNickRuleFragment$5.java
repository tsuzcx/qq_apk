package com.tencent.mobileqq.troop.activity;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mobileqq.util.ColorUtils;

class TroopNickRuleFragment$5
  implements TextWatcher
{
  TroopNickRuleFragment$5(TroopNickRuleFragment paramTroopNickRuleFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.q == null) {
      return;
    }
    paramInt1 = paramCharSequence.length();
    paramCharSequence = new StringBuilder();
    paramCharSequence.append(TroopNickRuleFragment.j - paramInt1);
    paramCharSequence.append("/");
    paramCharSequence.append(TroopNickRuleFragment.j);
    paramCharSequence.append("字");
    paramCharSequence = paramCharSequence.toString();
    if (paramInt1 >= TroopNickRuleFragment.j) {
      this.a.q.setTextColor(this.a.getResources().getColor(2131167862));
    } else {
      this.a.q.setTextColor(ColorUtils.a("#878B99"));
    }
    this.a.q.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopNickRuleFragment.5
 * JD-Core Version:    0.7.0.1
 */