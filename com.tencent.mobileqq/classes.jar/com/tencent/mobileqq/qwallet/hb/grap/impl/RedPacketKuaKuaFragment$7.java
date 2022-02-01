package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.EditText;

class RedPacketKuaKuaFragment$7
  implements Runnable
{
  RedPacketKuaKuaFragment$7(RedPacketKuaKuaFragment paramRedPacketKuaKuaFragment) {}
  
  public void run()
  {
    if ((!this.this$0.f()) && (!TextUtils.isEmpty(RedPacketKuaKuaFragment.j(this.this$0).getText().toString()))) {
      RedPacketKuaKuaFragment.f(this.this$0).sendEmptyMessage(10000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKuaKuaFragment.7
 * JD-Core Version:    0.7.0.1
 */