package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongMicView;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongVolumeView;

class RedPacketKSongFragment$12
  implements Runnable
{
  RedPacketKSongFragment$12(RedPacketKSongFragment paramRedPacketKSongFragment, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.this$0.d()) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(R.string.co));
      RedPacketKSongFragment.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      this.this$0.o();
    }
    else
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(R.string.cq));
      this.this$0.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongVolumeView.setVisibility(8);
      this.this$0.b();
      this.this$0.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongMicView.b();
    }
    RedPacketKSongFragment.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKSongFragment.12
 * JD-Core Version:    0.7.0.1
 */