package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;

class ForwardSdkShareOption$3
  implements Runnable
{
  ForwardSdkShareOption$3(ForwardSdkShareOption paramForwardSdkShareOption, AbsStructMsg paramAbsStructMsg, String paramString, int paramInt) {}
  
  public void run()
  {
    StructMsgForImageShare.sendAndUploadImageShare(this.this$0.q, (StructMsgForImageShare)this.a, this.b, this.c, null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.3
 * JD-Core Version:    0.7.0.1
 */