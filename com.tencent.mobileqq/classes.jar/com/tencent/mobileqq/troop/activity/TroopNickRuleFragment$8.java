package com.tencent.mobileqq.troop.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.troop.widget.PresetWordFlowLayout;

class TroopNickRuleFragment$8
  implements TextWatcher
{
  TroopNickRuleFragment$8(TroopNickRuleFragment paramTroopNickRuleFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(TroopNickRuleFragment.c(this.a).getText().toString()))
    {
      TroopNickRuleFragment.c(this.a).setHint("");
      paramInt1 = 0;
    }
    else
    {
      TroopNickRuleFragment.c(this.a).setHint(2131917614);
      paramInt1 = 1;
    }
    if ((this.a.k.getChildCount() > 0) && (TroopNickRuleFragment.d(this.a)))
    {
      paramCharSequence = (PresetWordsListAdapter.ViewHolder)this.a.k.getChildAt(0).getTag();
      if (paramCharSequence != null)
      {
        TextView localTextView = paramCharSequence.b;
        if (paramInt1 != 0) {
          paramCharSequence = this.a.getString(2131917614);
        } else {
          paramCharSequence = TroopNickRuleFragment.c(this.a).getText();
        }
        localTextView.setText(paramCharSequence);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopNickRuleFragment.8
 * JD-Core Version:    0.7.0.1
 */