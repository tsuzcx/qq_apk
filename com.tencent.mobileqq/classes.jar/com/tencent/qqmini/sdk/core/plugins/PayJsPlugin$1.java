package com.tencent.qqmini.sdk.core.plugins;

import android.content.Intent;
import beil;
import beim;
import beka;

class PayJsPlugin$1
  implements beim
{
  PayJsPlugin$1(PayJsPlugin paramPayJsPlugin, beka parambeka) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 3001)
    {
      if (paramInt2 == 0) {
        PayJsPlugin.access$000(this.this$0, this.val$req, null);
      }
      beil.a().b(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.PayJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */