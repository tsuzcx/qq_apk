package com.tencent.open.agent;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class BindGroupActivity$4$1
  implements Runnable
{
  BindGroupActivity$4$1(BindGroupActivity.4 param4) {}
  
  public void run()
  {
    if (this.a.a.a != null) {
      if (!this.a.a.a.isShowing()) {
        this.a.a.a.show();
      }
    }
    do
    {
      return;
      this.a.a.a = DialogUtil.a(this.a.a, 230);
      this.a.a.a.setMessage(this.a.a.getActivity().getResources().getString(2131720179));
      BindGroupActivity.4.1.1 local1 = new BindGroupActivity.4.1.1(this);
      this.a.a.a.setPositiveButton(2131691144, local1);
    } while (this.a.a.a.isShowing());
    this.a.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity.4.1
 * JD-Core Version:    0.7.0.1
 */