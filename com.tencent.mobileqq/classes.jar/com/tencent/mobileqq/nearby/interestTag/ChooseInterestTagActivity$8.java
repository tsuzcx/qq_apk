package com.tencent.mobileqq.nearby.interestTag;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV;
import com.tencent.util.InputMethodUtil;

class ChooseInterestTagActivity$8
  implements View.OnKeyListener
{
  ChooseInterestTagActivity$8(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0))
    {
      if (ChooseInterestTagActivity.access$2700(this.a).getText() == null) {
        paramView = "";
      } else {
        paramView = ChooseInterestTagActivity.access$2700(this.a).getText().toString();
      }
      if (TextUtils.isEmpty(paramView))
      {
        ChooseInterestTagActivity.access$500(this.a).fullScroll(66);
        paramView = this.a;
        ChooseInterestTagActivity.access$2900(paramView, ChooseInterestTagActivity.access$2800(paramView) + 1);
      }
    }
    else if ((paramInt == 66) && (paramKeyEvent.getAction() == 0))
    {
      InputMethodUtil.b(ChooseInterestTagActivity.access$2700(this.a));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.8
 * JD-Core Version:    0.7.0.1
 */