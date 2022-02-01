package com.tencent.mobileqq.richstatus;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.vas.font.api.FontLoadCallback;

class SignatureHistoryFragment$16
  implements FontLoadCallback
{
  SignatureHistoryFragment$16(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public void onFontLoaded()
  {
    Message localMessage = SignatureHistoryFragment.a(this.a).obtainMessage(1);
    SignatureHistoryFragment.a(this.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.16
 * JD-Core Version:    0.7.0.1
 */