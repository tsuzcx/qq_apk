package com.tencent.qqmini.sdk.core.proxy.service;

import android.content.Intent;
import bejc;
import bejd;
import besz;
import bfgc;

class MiniAppProxyDefault$1
  implements bejd
{
  MiniAppProxyDefault$1(MiniAppProxyDefault paramMiniAppProxyDefault, besz parambesz) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (9527 != paramInt1) {
      return false;
    }
    bejc.a().b(this);
    paramInt1 = paramIntent.getIntExtra("more_item_id", -1);
    paramIntent = this.this$0.getMoreItemSelectedListener();
    if (paramIntent != null) {
      paramIntent.onMoreItemSelected(this.val$miniRuntime, paramInt1);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.MiniAppProxyDefault.1
 * JD-Core Version:    0.7.0.1
 */