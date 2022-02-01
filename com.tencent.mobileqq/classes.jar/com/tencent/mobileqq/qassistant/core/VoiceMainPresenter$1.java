package com.tencent.mobileqq.qassistant.core;

import android.text.TextUtils;
import azfg;
import azfi;
import azfk;
import azfo;
import azfu;
import azgj;
import azgm;
import azgs;

public class VoiceMainPresenter$1
  implements Runnable
{
  public VoiceMainPresenter$1(azfi paramazfi, String paramString) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.a)) && (azfi.a(this.this$0) != null) && (azfi.a(this.this$0) != null)) {
      switch (azfi.a(this.this$0).a())
      {
      }
    }
    do
    {
      return;
      if (azgm.a(this.a))
      {
        azfi.a(this.this$0).a(true, false);
        return;
      }
      if ((azfi.a(this.this$0).a() != null) && (azfi.a(this.this$0).a().a != null) && (azfi.a(this.this$0).a().a.a == 115))
      {
        azfi.a(this.this$0).e();
        return;
      }
      if (azgm.b(this.a))
      {
        this.this$0.n(azgj.a(azfu.a(1), false));
        return;
      }
    } while (!azgm.c(this.a));
    azfi.a(this.this$0).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.VoiceMainPresenter.1
 * JD-Core Version:    0.7.0.1
 */