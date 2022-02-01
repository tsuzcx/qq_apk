package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.CGILoader;

class ForwardSdkBaseOption$7
  implements Runnable
{
  ForwardSdkBaseOption$7(ForwardSdkBaseOption paramForwardSdkBaseOption, String paramString) {}
  
  public void run()
  {
    String str = CGILoader.a(this.this$0.s.getApplicationContext(), this.this$0.q.getCurrentUin(), this.a);
    if (!TextUtils.isEmpty(str))
    {
      this.this$0.t.putString("video_url", str);
      this.this$0.t.putBoolean("video_url_load", true);
    }
    this.this$0.aD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.7
 * JD-Core Version:    0.7.0.1
 */