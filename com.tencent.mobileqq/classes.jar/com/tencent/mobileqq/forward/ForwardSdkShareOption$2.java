package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;

class ForwardSdkShareOption$2
  implements Runnable
{
  ForwardSdkShareOption$2(ForwardSdkShareOption paramForwardSdkShareOption, AbsStructMsg paramAbsStructMsg, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    ForwardStatisticsReporter.a("KEY_STAGE_2_UPLOAD_IMAGE");
    StructMsgForImageShare.sendAndUploadImageShare(this.this$0.q, (StructMsgForImageShare)this.a, this.b, this.c, null, 0, new ForwardSdkShareOption.2.1(this), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.2
 * JD-Core Version:    0.7.0.1
 */