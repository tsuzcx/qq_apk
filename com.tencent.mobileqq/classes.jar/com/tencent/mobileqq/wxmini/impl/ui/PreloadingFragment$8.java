package com.tencent.mobileqq.wxmini.impl.ui;

import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.LaunchWxaAppResultListener;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

class PreloadingFragment$8
  implements LaunchWxaAppResultListener
{
  PreloadingFragment$8(PreloadingFragment paramPreloadingFragment, int paramInt) {}
  
  public void onLaunchResult(@Nullable String paramString, int paramInt, long paramLong, LaunchWxaAppResult paramLaunchWxaAppResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchByQRRawData appid:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" versionType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" timestamp:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" result:");
    localStringBuilder.append(paramLaunchWxaAppResult);
    QLog.d("wxmini.PreloadingFragment", 1, localStringBuilder.toString());
    PreloadingFragment.a(this.b, paramString, this.a);
    PreloadingFragment.b(this.b, paramString, this.a);
    PreloadingFragment.d(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.PreloadingFragment.8
 * JD-Core Version:    0.7.0.1
 */