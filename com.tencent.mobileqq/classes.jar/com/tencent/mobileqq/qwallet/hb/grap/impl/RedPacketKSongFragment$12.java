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
    if (this.this$0.p()) {
      return;
    }
    if (this.a)
    {
      this.this$0.g.setText(HardCodeUtil.a(R.string.cr));
      RedPacketKSongFragment.a(this.this$0, this.b);
      this.this$0.u();
    }
    else
    {
      this.this$0.g.setText(HardCodeUtil.a(R.string.ct));
      this.this$0.p.setVisibility(8);
      this.this$0.d();
      this.this$0.h.b();
    }
    RedPacketKSongFragment.d(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKSongFragment.12
 * JD-Core Version:    0.7.0.1
 */