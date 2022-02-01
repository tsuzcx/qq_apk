package com.tencent.mobileqq.guild.audio;

import com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi.TRTCRequestFocusCallback;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class TRTCFocusManager$2
  implements Runnable
{
  TRTCFocusManager$2(TRTCFocusManager paramTRTCFocusManager, IGuildTRTCFocusApi.TRTCRequestFocusCallback paramTRTCRequestFocusCallback) {}
  
  public void run()
  {
    if (TRTCFocusManager.b(this.this$0) != 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("illegal state,now state is ");
      ((StringBuilder)localObject).append(TRTCFocusManager.b(this.this$0));
      QLog.d("TRTCFocusManager", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (this.a != TRTCFocusManager.c(this.this$0))
    {
      QLog.d("TRTCFocusManager", 1, "requestingFocusCallback has changed,just return");
      return;
    }
    TRTCFocusManager.a(this.this$0, 2);
    Object localObject = this.this$0;
    TRTCFocusManager.a((TRTCFocusManager)localObject, new WeakReference(TRTCFocusManager.d((TRTCFocusManager)localObject)));
    TRTCFocusManager.a(this.this$0, null);
    TRTCFocusManager.a(this.this$0, null);
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.TRTCFocusManager.2
 * JD-Core Version:    0.7.0.1
 */