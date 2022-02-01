package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.string;

class RedPacketKuaKuaFragment$4$1$1$1
  implements Runnable
{
  RedPacketKuaKuaFragment$4$1$1$1(RedPacketKuaKuaFragment.4.1.1 param1, Drawable paramDrawable, ImageView paramImageView) {}
  
  public void run()
  {
    ((Animatable)this.a).stop();
    this.b.setVisibility(8);
    RedPacketKuaKuaFragment.f(this.c.b.a.a).removeCallbacks(RedPacketKuaKuaFragment.e(this.c.b.a.a));
    RedPacketKuaKuaFragment.f(this.c.b.a.a).postDelayed(RedPacketKuaKuaFragment.e(this.c.b.a.a), RedPacketKuaKuaFragment.g(this.c.b.a.a) * 1000L);
    this.c.b.a.a.a(HardCodeUtil.a(R.string.bo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKuaKuaFragment.4.1.1.1
 * JD-Core Version:    0.7.0.1
 */