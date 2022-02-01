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
    if (this.a.a.y != null)
    {
      if (!this.a.a.y.isShowing()) {
        this.a.a.y.show();
      }
      return;
    }
    this.a.a.y = DialogUtil.a(this.a.a, 230);
    this.a.a.y.setMessage(this.a.a.getActivity().getResources().getString(2131917517));
    BindGroupActivity.4.1.1 local1 = new BindGroupActivity.4.1.1(this);
    this.a.a.y.setPositiveButton(2131888010, local1);
    if (!this.a.a.y.isShowing()) {
      this.a.a.y.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity.4.1
 * JD-Core Version:    0.7.0.1
 */