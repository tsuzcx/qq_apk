package com.tencent.mobileqq.wxmini.impl.ui;

import android.util.Log;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.LaunchWxaAppResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "wxaAppID", "", "versionType", "", "timestamp", "", "result", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppResult;", "kotlin.jvm.PlatformType", "onLaunchResult"}, k=3, mv={1, 1, 16})
final class DemoWxaListActivity$startApp$1
  implements LaunchWxaAppResultListener
{
  DemoWxaListActivity$startApp$1(DemoWxaListActivity paramDemoWxaListActivity) {}
  
  public final void onLaunchResult(@Nullable String paramString, int paramInt, long paramLong, LaunchWxaAppResult paramLaunchWxaAppResult)
  {
    DemoWxaListActivity.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchWxaApp onLaunchResult appId:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" versionType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" timestamp:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" result:");
    localStringBuilder.append(paramLaunchWxaAppResult);
    Log.i("DemoWxaListActivity", localStringBuilder.toString());
    if (LaunchWxaAppResult.FailMiniGameNotSupported == paramLaunchWxaAppResult) {
      this.a.runOnUiThread((Runnable)new DemoWxaListActivity.startApp.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.DemoWxaListActivity.startApp.1
 * JD-Core Version:    0.7.0.1
 */