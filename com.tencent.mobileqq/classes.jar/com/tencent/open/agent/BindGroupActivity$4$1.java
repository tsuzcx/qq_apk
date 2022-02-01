package com.tencent.open.agent;

import android.app.Activity;
import android.content.res.Resources;
import bhdj;
import bjbj;
import bjbk;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class BindGroupActivity$4$1
  implements Runnable
{
  public BindGroupActivity$4$1(bjbj parambjbj) {}
  
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
      this.a.a.a = bhdj.a(this.a.a, 230);
      this.a.a.a.setMessage(this.a.a.getActivity().getResources().getString(2131719601));
      bjbk localbjbk = new bjbk(this);
      this.a.a.a.setPositiveButton(2131691037, localbjbk);
    } while (this.a.a.a.isShowing());
    this.a.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity.4.1
 * JD-Core Version:    0.7.0.1
 */