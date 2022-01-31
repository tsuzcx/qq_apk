package com.tencent.open.agent;

import android.app.Activity;
import android.content.res.Resources;
import babr;
import bafb;
import bbuv;
import bbuw;

public class BindGroupActivity$4$1
  implements Runnable
{
  public BindGroupActivity$4$1(bbuv parambbuv) {}
  
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
      this.a.a.a = babr.a(this.a.a, 230);
      this.a.a.a.setMessage(this.a.a.getActivity().getResources().getString(2131654577));
      bbuw localbbuw = new bbuw(this);
      this.a.a.a.setPositiveButton(2131625463, localbbuw);
    } while (this.a.a.a.isShowing());
    this.a.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity.4.1
 * JD-Core Version:    0.7.0.1
 */