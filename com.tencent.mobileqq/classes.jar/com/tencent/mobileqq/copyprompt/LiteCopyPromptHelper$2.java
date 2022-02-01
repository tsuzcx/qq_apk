package com.tencent.mobileqq.copyprompt;

import android.os.Handler;
import com.tencent.biz.SoftKeyboardObserver;
import com.tencent.biz.SoftKeyboardObserver.OnSoftKeyboardToggledListener;

class LiteCopyPromptHelper$2
  implements SoftKeyboardObserver.OnSoftKeyboardToggledListener
{
  LiteCopyPromptHelper$2(LiteCopyPromptHelper paramLiteCopyPromptHelper) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!paramBoolean)
    {
      LiteCopyPromptHelper.a(this.a).removeCallbacks(LiteCopyPromptHelper.a(this.a));
      LiteCopyPromptHelper.a(this.a).run();
      if (LiteCopyPromptHelper.a(this.a) != null) {
        LiteCopyPromptHelper.a(this.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper.2
 * JD-Core Version:    0.7.0.1
 */