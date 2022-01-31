package com.tencent.qqmini.sdk.core.plugins;

import android.content.Intent;
import bgnk;
import bgnl;
import bgok;

class PayJsPlugin$1
  implements bgnl
{
  PayJsPlugin$1(PayJsPlugin paramPayJsPlugin, bgok parambgok) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 3001)
    {
      if (paramInt2 == 0) {
        PayJsPlugin.access$000(this.this$0, this.val$req, null);
      }
      bgnk.a().b(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.PayJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */