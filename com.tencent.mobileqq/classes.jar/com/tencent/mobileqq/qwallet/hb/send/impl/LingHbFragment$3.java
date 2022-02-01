package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class LingHbFragment$3
  implements View.OnClickListener
{
  LingHbFragment$3(LingHbFragment paramLingHbFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getText().toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("choice: ");
      localStringBuilder.append(paramView);
      QLog.i("LingHbFragment", 2, localStringBuilder.toString());
      this.a.l.setText(paramView);
      this.a.a.post(new LingHbFragment.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.LingHbFragment.3
 * JD-Core Version:    0.7.0.1
 */