package com.tencent.mobileqq.qwallet.hb.grap.impl;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSHelper.KLAdapter;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongMicView;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl;

class RedPacketKSongFragment$3
  extends KSHelper.KLAdapter
{
  RedPacketKSongFragment$3(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void a()
  {
    super.a();
    this.a.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongMicView.a();
    this.a.a(HardCodeUtil.a(R.string.cx));
    if (this.a.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.stopRecord();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKSongFragment.3
 * JD-Core Version:    0.7.0.1
 */