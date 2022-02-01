package com.tencent.mobileqq.copyprompt;

import android.os.Handler;
import com.tencent.biz.SoftKeyboardObserver;
import com.tencent.biz.SoftKeyboardObserver.OnSoftKeyboardToggledListener;

class CopyPromptHelper$2
  implements SoftKeyboardObserver.OnSoftKeyboardToggledListener
{
  CopyPromptHelper$2(CopyPromptHelper paramCopyPromptHelper) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!paramBoolean)
    {
      CopyPromptHelper.a(this.a).removeCallbacks(CopyPromptHelper.a(this.a));
      CopyPromptHelper.a(this.a).run();
      if (CopyPromptHelper.a(this.a) != null) {
        CopyPromptHelper.a(this.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.CopyPromptHelper.2
 * JD-Core Version:    0.7.0.1
 */