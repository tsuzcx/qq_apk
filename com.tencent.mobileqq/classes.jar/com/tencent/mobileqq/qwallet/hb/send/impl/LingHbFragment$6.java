package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mobileqq.qwallet.hb.grap.draw.impl.ChooseItemView;
import com.tencent.qphone.base.util.QLog;

class LingHbFragment$6
  implements View.OnFocusChangeListener
{
  LingHbFragment$6(LingHbFragment paramLingHbFragment) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      LingHbFragment.a(this.a).a(this.a.c.getText().toString(), false);
    } else {
      LingHbFragment.a(this.a).a();
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onFocusChange:");
      paramView.append(paramBoolean);
      QLog.i("LingHbFragment", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.LingHbFragment.6
 * JD-Core Version:    0.7.0.1
 */