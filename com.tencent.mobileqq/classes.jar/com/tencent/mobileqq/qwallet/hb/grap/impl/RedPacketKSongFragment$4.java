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
    localRedPacketKSongFragment.b = false;
    localRedPacketKSongFragment.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView.a();
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.a.getResources().getDrawable(R.drawable.ac));
    this.a.c.setText(HardCodeUtil.a(R.string.ch));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKSongFragment.4
 * JD-Core Version:    0.7.0.1
 */