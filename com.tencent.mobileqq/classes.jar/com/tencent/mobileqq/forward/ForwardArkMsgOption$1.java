package com.tencent.mobileqq.forward;

import android.app.Activity;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.CheckShareUrlResult;

class ForwardArkMsgOption$1
  implements ArkAppModuleReg.CheckShareUrlResult
{
  ForwardArkMsgOption$1(ForwardArkMsgOption paramForwardArkMsgOption) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardArkMsgOption.1
 * JD-Core Version:    0.7.0.1
 */