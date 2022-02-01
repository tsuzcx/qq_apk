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
    if (this.this$0.d()) {
      return;
    }
    String str = this.this$0.getResources().getString(R.string.u);
    int i = this.jdField_a_of_type_Int;
    Object localObject;
    if (i == 2)
    {
      localObject = this.jdField_a_of_type_JavaLangString;
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
    this.this$0.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplRecordMicView.c();
    this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    RedPacketVoiceFragment.a(this.this$0);
    if (RedPacketVoiceFragment.a(this.this$0) != null) {
      RedPacketVoiceFragment.a(this.this$0).removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketVoiceFragment.4
 * JD-Core Version:    0.7.0.1
 */