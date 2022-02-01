package com.tencent.mobileqq.richstatus;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class SignatureHistoryFragment$15
  implements View.OnClickListener
{
  SignatureHistoryFragment$15(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public void onClick(View paramView)
  {
    String str = (String)paramView.getTag();
    if (SignatureHistoryFragment.b(this.a).contains(str))
    {
      SignatureHistoryFragment.b(this.a).remove(str);
      ((CheckBox)paramView).setChecked(false);
    }
    else if (SignatureHistoryFragment.b(this.a).size() >= 200)
    {
      this.a.a(1, 2131719147);
      ((CheckBox)paramView).setChecked(false);
    }
    else
    {
      SignatureHistoryFragment.b(this.a).add(str);
      ((CheckBox)paramView).setChecked(true);
    }
    SignatureHistoryFragment.b(this.a, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.15
 * JD-Core Version:    0.7.0.1
 */