package com.tencent.ttpic.openapi.initializer;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YTCommonInitializer
  extends Feature
{
  private static final String TAG = YTCommonInitializer.class.getSimpleName();
  private static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("nnpack"), new SharedLibraryInfo("YTCommon") };
  
  private boolean initAuth()
  {
    int i;
    if (TextUtils.isEmpty(AEModule.getLicense()))
    {
      logForInitAuth(AEModule.getContext(), "com_tencent_2118.lic", 0);
      i = YTCommonInterface.initAuth(AEModule.getContext(), "com_tencent_2118.lic", 0);
      if (i != 0) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      AEOpenRenderConfig.checkStrictMode(bool, "youtu auth failed");
      if (i != 0) {
        break label81;
      }
      return true;
      logForInitAuth(AEModule.getContext(), AEModule.getLicense(), AEModule.getLicenseInitType());
      i = YTCommonInterface.initAuth(AEModule.getContext(), AEModule.getLicense(), AEModule.getLicenseInitType());
      break;
    }
    label81:
    return false;
  }
  
  private void logForInitAuth(Context paramContext, String paramString, int paramInt)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("isContextNull::");
    if (paramContext == null) {}
    for (boolean bool = true;; bool = false)
    {
      LogUtils.i(str, bool + ",license::" + paramString + ",licenseInitType::" + paramInt);
      return;
    }
  }
  
  protected boolean destroyImpl()
  {
    return false;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return new ArrayList();
  }
  
  public String getName()
  {
    return "YTCommon";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  protected boolean initImpl()
  {
    return (loadAllSoFiles()) && (initAuth());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.YTCommonInitializer
 * JD-Core Version:    0.7.0.1
 */