package com.tencent.mobileqq.qassistant.core;

import android.text.TextUtils;
import com.tencent.mobileqq.qassistant.data.VoiceDataUtils;
import com.tencent.mobileqq.qassistant.util.CommandUtils;
import com.tencent.mobileqq.qassistant.util.VoiceTextUtils;
import com.tencent.mobileqq.qassistant.view.VoiceView;

class VoiceMainPresenter$1
  implements Runnable
{
  VoiceMainPresenter$1(VoiceMainPresenter paramVoiceMainPresenter, String paramString) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.a)) && (VoiceMainPresenter.a(this.this$0) != null) && (VoiceMainPresenter.a(this.this$0) != null)) {}
    switch (VoiceMainPresenter.a(this.this$0).a())
    {
    case 3: 
    default: 
      return;
    case 2: 
      if (VoiceTextUtils.a(this.a))
      {
        VoiceMainPresenter.a(this.this$0).a(true, false);
        return;
      }
      if (VoiceTextUtils.b(this.a))
      {
        this.this$0.p(CommandUtils.a(VoiceDataUtils.a(1), false));
        return;
      }
      if (VoiceTextUtils.c(this.a))
      {
        VoiceMainPresenter.a(this.this$0).d();
        return;
      }
      VoiceMainPresenter.a(this.this$0, this.a);
      return;
    }
    VoiceMainPresenter.a(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.VoiceMainPresenter.1
 * JD-Core Version:    0.7.0.1
 */