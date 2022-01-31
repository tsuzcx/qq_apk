package com.tencent.mobileqq.mini.share;

import bbmy;
import com.tencent.qphone.base.util.QLog;

class MiniProgramOpenSdkUtil$3$1$1
  implements Runnable
{
  MiniProgramOpenSdkUtil$3$1$1(MiniProgramOpenSdkUtil.3.1 param1) {}
  
  public void run()
  {
    QLog.e("MiniProgramOpenSdkUtil", 1, "performUploadArkShareImage failed, NotEmptyPicUri = " + this.this$1.this$0.val$finalNotEmptyPicUri);
    bbmy.a(this.this$1.this$0.val$context, 1, 2131653595, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil.3.1.1
 * JD-Core Version:    0.7.0.1
 */