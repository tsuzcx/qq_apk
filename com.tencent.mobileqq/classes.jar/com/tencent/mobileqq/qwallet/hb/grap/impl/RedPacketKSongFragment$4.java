package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSHelper.KLAdapter;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongView;

class RedPacketKSongFragment$4
  extends KSHelper.KLAdapter
{
  RedPacketKSongFragment$4(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void a()
  {
    super.a();
    RedPacketKSongFragment localRedPacketKSongFragment = this.a;
    localRedPacketKSongFragment.v = false;
    localRedPacketKSongFragment.n.a();
    this.a.l.setImageDrawable(this.a.getResources().getDrawable(R.drawable.ad));
    this.a.m.setText(HardCodeUtil.a(R.string.ck));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKSongFragment.4
 * JD-Core Version:    0.7.0.1
 */