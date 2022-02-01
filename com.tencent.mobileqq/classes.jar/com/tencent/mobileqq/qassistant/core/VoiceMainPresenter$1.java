package com.tencent.mobileqq.qassistant.core;

import android.text.TextUtils;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantCore;
import com.tencent.mobileqq.qassistant.util.CommandUtils;
import com.tencent.mobileqq.qassistant.util.VoiceDataUtils;
import com.tencent.mobileqq.qassistant.util.VoiceTextUtils;
import com.tencent.mobileqq.qassistant.view.VoiceView;

class VoiceMainPresenter$1
  implements Runnable
{
  VoiceMainPresenter$1(VoiceMainPresenter paramVoiceMainPresenter, String paramString) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.a)) && (VoiceMainPresenter.a(this.this$0) != null) && (VoiceMainPresenter.b(this.this$0) != null))
    {
      int i = VoiceMainPresenter.a(this.this$0).e();
      if (i != 2)
      {
        if (i != 4) {
          return;
        }
        VoiceMainPresenter.a(this.this$0, this.a);
        return;
      }
      if (VoiceTextUtils.a(this.a))
      {
        VoiceMainPresenter.b(this.this$0).quiteVoicePanel(true, false);
        return;
      }
      if (VoiceTextUtils.b(this.a))
      {
        this.this$0.p(CommandUtils.a(VoiceDataUtils.a(1), false));
        return;
      }
      if (VoiceTextUtils.c(this.a))
      {
        VoiceMainPresenter.b(this.this$0).resendVoice();
        return;
      }
      VoiceMainPresenter.a(this.this$0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.VoiceMainPresenter.1
 * JD-Core Version:    0.7.0.1
 */