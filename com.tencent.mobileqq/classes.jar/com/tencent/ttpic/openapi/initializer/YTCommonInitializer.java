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
  private static final SharedLibraryInfo YT_COMMON = new SharedLibraryInfo("YTCommon");
  private static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("YTCommon") };
  private int authMode = 0;
  
  private String getErrorMessage(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "内部错误";
    }
    for (;;)
    {
      return "[" + paramInt + "]" + str;
      str = "授权成功";
      continue;
      str = "网络连接失败";
      continue;
      str = "网络初始化错误";
      continue;
      str = "证书下载失败";
      continue;
      str = "证书保存失败";
      continue;
      str = "没有写权限";
      continue;
      str = "证书文件为空";
      continue;
      str = "授权文件解析失败.";
      continue;
      str = "设备信息不匹配";
      continue;
      str = "package name不匹配";
      continue;
      str = "package name为空";
      continue;
      str = "证书已经过期(累计时间)";
      continue;
      str = "证书已过期";
      continue;
      str = "license版本不匹配";
      continue;
      str = "设备序列号无效";
      continue;
      str = "没有权限获取序列号.";
      continue;
      str = "请求字段中参数错误";
      continue;
      str = "设备时间和服务器不符";
      continue;
      str = "序列号信息为空";
      continue;
      str = "该设备续期次数超过限制";
      continue;
      str = "授权时间无效";
      continue;
      str = "appid没有匹配到设备";
      continue;
      str = "授权已过期";
    }
  }
  
  private boolean initAuth()
  {
    int i;
    String str;
    if (this.authMode == 0) {
      if (TextUtils.isEmpty(AEModule.getLicense()))
      {
        logForInitAuth(AEModule.getContext(), "com_tencent_2118.lic", 0);
        i = YTCommonInterface.initAuth(AEModule.getContext(), "com_tencent_2118.lic", 0);
        str = getErrorMessage(i);
        LogUtils.i("AEKitFeature", str);
        if (i != 0) {
          break label104;
        }
      }
    }
    label104:
    for (boolean bool = true;; bool = false)
    {
      AEOpenRenderConfig.checkStrictMode(bool, str);
      if (i != 0) {
        break label109;
      }
      return true;
      logForInitAuth(AEModule.getContext(), AEModule.getLicense(), AEModule.getLicenseInitType());
      i = YTCommonInterface.initAuth(AEModule.getContext(), AEModule.getLicense(), AEModule.getLicenseInitType());
      break;
      i = YTCommonInterface.initAuthForQQ(AEModule.getContext());
      break;
    }
    label109:
    return false;
  }
  
  private boolean initCommonSoInAssets()
  {
    this.isInited = systemLoadLibrarySafely(YT_COMMON.fileName);
    LogUtils.i(TAG, "YTCommon so init result: " + this.isInited);
    return this.isInited;
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
    return (initCommonSoInAssets()) && (initAuth());
  }
  
  public boolean isResourceReady()
  {
    return true;
  }
  
  public boolean isSoReadyInDirectory(String paramString)
  {
    return true;
  }
  
  public void setAuthMode(int paramInt)
  {
    this.authMode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.YTCommonInitializer
 * JD-Core Version:    0.7.0.1
 */