package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongMicView;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongVolumeView;

class RedPacketKSongFragment$13
  implements Runnable
{
  RedPacketKSongFragment$13(RedPacketKSongFragment paramRedPacketKSongFragment, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.this$0.p()) {
      return;
    }
    String str = this.this$0.getResources().getString(R.string.u);
    int i = this.a;
    Object localObject;
    if (i == 2)
    {
      localObject = this.b;
    }
    else
    {
      localObject = str;
      if (i == 3)
      {
        localObject = this.this$0;
        ((RedPacketKSongFragment)localObject).a(((RedPacketKSongFragment)localObject).getQBaseActivity());
        localObject = str;
      }
    }
    this.this$0.g.setText((CharSequence)localObject);
    this.this$0.g.setText(HardCodeUtil.a(R.string.cB));
    this.this$0.p.setVisibility(8);
    this.this$0.d();
    this.this$0.h.b();
    RedPacketKSongFragment.d(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKSongFragment.13
 * JD-Core Version:    0.7.0.1
 */