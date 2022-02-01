package com.tencent.open.agent;

import android.app.Activity;
import android.content.res.Resources;
import bhlq;
import bhpc;
import bjky;
import bjkz;

public class BindGroupActivity$4$1
  implements Runnable
{
  public BindGroupActivity$4$1(bjky parambjky) {}
  
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
      this.a.a.a = bhlq.a(this.a.a, 230);
      this.a.a.a.setMessage(this.a.a.getActivity().getResources().getString(2131718921));
      bjkz localbjkz = new bjkz(this);
      this.a.a.a.setPositiveButton(2131690912, localbjkz);
    } while (this.a.a.a.isShowing());
    this.a.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity.4.1
 * JD-Core Version:    0.7.0.1
 */