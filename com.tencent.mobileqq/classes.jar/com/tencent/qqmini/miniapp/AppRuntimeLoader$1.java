package com.tencent.qqmini.miniapp;

import android.content.Context;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.Creator;

final class AppRuntimeLoader$1
  implements BaseRuntimeLoader.Creator<AppRuntimeLoader>
{
  public AppRuntimeLoader create(Context paramContext, Bundle paramBundle)
  {
    return new AppRuntimeLoader(paramContext);
  }
  
  public void doPrepareEngine(Bundle paramBundle) {}
  
  public boolean isEnginePrepared(Bundle paramBundle)
  {
    return true;
  }
  
  public boolean support(MiniAppInfo paramMiniAppInfo)
  {
    return (paramMiniAppInfo != null) && (paramMiniAppInfo.isEngineTypeMiniApp());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.AppRuntimeLoader.1
 * JD-Core Version:    0.7.0.1
 */