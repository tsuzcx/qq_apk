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
    TextView localTextView;
    if (!TextUtils.isEmpty(TroopNickRuleFragment.a(this.a).getText().toString()))
    {
      TroopNickRuleFragment.a(this.a).setHint("");
      paramInt1 = 0;
      if ((this.a.a.getChildCount() > 0) && (TroopNickRuleFragment.a(this.a)))
      {
        paramCharSequence = (PresetWordsListAdapter.ViewHolder)this.a.a.getChildAt(0).getTag();
        if (paramCharSequence != null)
        {
          localTextView = paramCharSequence.a;
          if (paramInt1 == 0) {
            break label122;
          }
        }
      }
    }
    label122:
    for (paramCharSequence = this.a.getString(2131720271);; paramCharSequence = TroopNickRuleFragment.a(this.a).getText())
    {
      localTextView.setText(paramCharSequence);
      return;
      TroopNickRuleFragment.a(this.a).setHint(2131720271);
      paramInt1 = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopNickRuleFragment.8
 * JD-Core Version:    0.7.0.1
 */