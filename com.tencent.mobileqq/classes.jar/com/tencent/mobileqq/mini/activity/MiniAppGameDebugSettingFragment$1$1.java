package com.tencent.mobileqq.mini.activity;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.smtt.sdk.QbSdk;

class MiniAppGameDebugSettingFragment$1$1
  implements Runnable
{
  MiniAppGameDebugSettingFragment$1$1(MiniAppGameDebugSettingFragment.1 param1) {}
  
  public void run()
  {
    QbSdk.reset(this.this$1.this$0.getActivity());
    ThreadManagerV2.getUIHandlerV2().post(new MiniAppGameDebugSettingFragment.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.1.1
 * JD-Core Version:    0.7.0.1
 */