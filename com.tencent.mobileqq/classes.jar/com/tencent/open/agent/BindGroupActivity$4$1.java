package com.tencent.open.agent;

import android.app.Activity;
import android.content.res.Resources;
import bbcv;
import bbgg;
import bcyv;
import bcyw;

public class BindGroupActivity$4$1
  implements Runnable
{
  public BindGroupActivity$4$1(bcyv parambcyv) {}
  
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
      this.a.a.a = bbcv.a(this.a.a, 230);
      this.a.a.a.setMessage(this.a.a.getActivity().getResources().getString(2131720473));
      bcyw localbcyw = new bcyw(this);
      this.a.a.a.setPositiveButton(2131691035, localbcyw);
    } while (this.a.a.a.isShowing());
    this.a.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity.4.1
 * JD-Core Version:    0.7.0.1
 */