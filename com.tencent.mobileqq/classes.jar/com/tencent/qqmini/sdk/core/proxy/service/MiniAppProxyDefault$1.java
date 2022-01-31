package com.tencent.qqmini.sdk.core.proxy.service;

import android.content.Intent;
import bdcz;
import bdel;
import bdem;
import bdfu;
import bdfw;

class MiniAppProxyDefault$1
  implements bdem
{
  MiniAppProxyDefault$1(MiniAppProxyDefault paramMiniAppProxyDefault, bdcz parambdcz) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (9527 == paramInt1)
    {
      bdel.a().b(this);
      switch (paramIntent.getIntExtra("clickID", -1))
      {
      }
      for (;;)
      {
        return true;
        this.val$miniAppContext.a(bdfu.a(2));
        continue;
        this.val$miniAppContext.a(bdfu.a(6));
        continue;
        this.val$miniAppContext.a(bdfu.a(7));
        continue;
        this.val$miniAppContext.a(bdfu.a(8));
        continue;
        this.val$miniAppContext.a(bdfw.a(2));
        continue;
        MiniAppProxyDefault.access$002(((Boolean)this.val$miniAppContext.a(bdfw.a(1))).booleanValue());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.MiniAppProxyDefault.1
 * JD-Core Version:    0.7.0.1
 */