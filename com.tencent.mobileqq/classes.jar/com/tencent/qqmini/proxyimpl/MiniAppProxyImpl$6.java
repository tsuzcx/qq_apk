package com.tencent.qqmini.proxyimpl;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import beil;
import beim;
import besl;

class MiniAppProxyImpl$6
  implements beim
{
  MiniAppProxyImpl$6(MiniAppProxyImpl paramMiniAppProxyImpl) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 9527) {
      return false;
    }
    beil.a().b(this);
    besl.a("MiniAppProxyImpl", "set isMiniMsgTabShow false");
    MiniAppProxyImpl.access$802(this.this$0, false);
    if (paramInt2 != -1)
    {
      besl.c("MiniAppProxyImpl", "onShareActivityResult, resultCode not Activity.RESULT_OK, but " + paramInt2);
      return true;
    }
    paramInt1 = paramIntent.getIntExtra("clickID", -1);
    String str = "";
    switch (paramInt1)
    {
    default: 
      paramIntent = str;
    }
    for (;;)
    {
      MiniAppProxyImpl.access$300(this.this$0, paramIntent);
      return true;
      MiniAppProxyImpl.access$600(this.this$0).sendEmptyMessage(2);
      paramIntent = str;
      continue;
      MiniAppProxyImpl.access$600(this.this$0).sendEmptyMessage(6);
      paramIntent = str;
      continue;
      MiniAppProxyImpl.access$600(this.this$0).sendEmptyMessage(7);
      paramIntent = "share_WX";
      continue;
      MiniAppProxyImpl.access$600(this.this$0).sendEmptyMessage(8);
      paramIntent = "share_Moments";
      continue;
      Message localMessage = new Message();
      localMessage.what = 13;
      localMessage.setData(paramIntent.getExtras());
      MiniAppProxyImpl.access$600(this.this$0).sendMessage(localMessage);
      paramIntent = str;
      continue;
      MiniAppProxyImpl.access$600(this.this$0).sendEmptyMessage(3);
      paramIntent = str;
      continue;
      MiniAppProxyImpl.access$600(this.this$0).sendEmptyMessage(4);
      paramIntent = "about";
      continue;
      MiniAppProxyImpl.access$600(this.this$0).sendEmptyMessage(5);
      paramIntent = str;
      continue;
      paramIntent = "cancel";
      continue;
      paramIntent = "cancel_system";
      continue;
      MiniAppProxyImpl.access$600(this.this$0).sendEmptyMessage(9);
      paramIntent = str;
      continue;
      MiniAppProxyImpl.access$600(this.this$0).sendEmptyMessage(11);
      paramIntent = str;
      continue;
      MiniAppProxyImpl.access$600(this.this$0).sendEmptyMessage(10);
      paramIntent = "back_home";
      continue;
      MiniAppProxyImpl.access$600(this.this$0).sendEmptyMessage(12);
      paramIntent = str;
      continue;
      MiniAppProxyImpl.access$600(this.this$0).sendEmptyMessage(14);
      paramIntent = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.6
 * JD-Core Version:    0.7.0.1
 */