package com.tencent.qqmini.sdk.core.plugins;

import android.content.Intent;
import bejc;
import bejd;
import bekr;

class DataJsPlugin$13
  implements bejd
{
  DataJsPlugin$13(DataJsPlugin paramDataJsPlugin, bekr parambekr) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 9)
    {
      if (paramInt2 == 0) {
        this.val$req.a();
      }
      for (;;)
      {
        bejc.a().b(this);
        return true;
        this.val$req.b();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */