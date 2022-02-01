package com.tencent.mobileqq.forward;

import android.os.Bundle;
import com.tencent.mobileqq.ark.secure.CheckShareUrlResult;
import com.tencent.qphone.base.util.QLog;

class ForwardArkH5StructOption$1
  implements CheckShareUrlResult
{
  ForwardArkH5StructOption$1(ForwardArkH5StructOption paramForwardArkH5StructOption) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 1, new Object[] { "ShareArkFromH5 checkUrlFromNormal CheckShareUrl = ", Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.a.a.putBoolean("forward_ark_from_h5_success", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardArkH5StructOption.1
 * JD-Core Version:    0.7.0.1
 */