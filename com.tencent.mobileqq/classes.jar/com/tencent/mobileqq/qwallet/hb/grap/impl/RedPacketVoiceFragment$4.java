package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.RecordMicView;

class RedPacketVoiceFragment$4
  implements Runnable
{
  RedPacketVoiceFragment$4(RedPacketVoiceFragment paramRedPacketVoiceFragment, int paramInt, String paramString) {}
  
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
        ((RedPacketVoiceFragment)localObject).a(((RedPacketVoiceFragment)localObject).getQBaseActivity());
        localObject = str;
      }
    }
    this.this$0.b.setText((CharSequence)localObject);
    this.this$0.c.c();
    this.this$0.d.setVisibility(8);
    RedPacketVoiceFragment.d(this.this$0);
    if (RedPacketVoiceFragment.c(this.this$0) != null) {
      RedPacketVoiceFragment.c(this.this$0).removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketVoiceFragment.4
 * JD-Core Version:    0.7.0.1
 */