package com.tencent.mobileqq.qassistant.core;

import android.text.TextUtils;
import bakx;
import bakz;
import balb;
import balf;
import ball;
import bamr;
import bamu;
import bana;

public class VoiceMainPresenter$1
  implements Runnable
{
  public VoiceMainPresenter$1(bakz parambakz, String paramString) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.a)) && (bakz.a(this.this$0) != null) && (bakz.a(this.this$0) != null)) {
      switch (bakz.a(this.this$0).a())
      {
      }
    }
    do
    {
      return;
      if (bamu.a(this.a))
      {
        bakz.a(this.this$0).a(true, false);
        return;
      }
      if ((bakz.a(this.this$0).a() != null) && (bakz.a(this.this$0).a().a != null) && (bakz.a(this.this$0).a().a.a == 115))
      {
        bakz.a(this.this$0).e();
        return;
      }
      if (bamu.b(this.a))
      {
        this.this$0.p(bamr.a(ball.a(1), false));
        return;
      }
    } while (!bamu.c(this.a));
    bakz.a(this.this$0).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.VoiceMainPresenter.1
 * JD-Core Version:    0.7.0.1
 */