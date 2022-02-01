package com.tencent.mobileqq.wxmini.impl.ui;

import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.LaunchWxaAppResultListener;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

class PreloadingFragment$7$1
  implements LaunchWxaAppResultListener
{
  PreloadingFragment$7$1(PreloadingFragment.7 param7) {}
  
  public void onLaunchResult(@Nullable String paramString, int paramInt, long paramLong, LaunchWxaAppResult paramLaunchWxaAppResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchWeixinMiniAppByMiniCode appid:");
    localStringBuilder.append(paramString);
    localStringBuilder.append("  result:");
    localStringBuilder.append(paramLaunchWxaAppResult);
    QLog.i("wxmini.PreloadingFragment", 1, localStringBuilder.toString());
    PreloadingFragment.a(this.a.d, paramString, this.a.b);
    PreloadingFragment.b(this.a.d, paramString, this.a.b);
    PreloadingFragment.d(this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.PreloadingFragment.7.1
 * JD-Core Version:    0.7.0.1
 */