package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class ShengpiziHbFragment$3
  implements View.OnClickListener
{
  ShengpiziHbFragment$3(ShengpiziHbFragment paramShengpiziHbFragment, TextView paramTextView) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      this.b.p = this.a.getText();
      this.b.q = ((TextView)paramView).getText().toString();
      paramView = new StringBuilder();
      paramView.append("choice: ");
      paramView.append(this.b.q);
      QLog.i("ShengPiZiHbFragment", 2, paramView.toString());
      ShengpiziHbFragment.e(this.b).setText(this.b.q);
      this.b.a.post(new ShengpiziHbFragment.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ShengpiziHbFragment.3
 * JD-Core Version:    0.7.0.1
 */