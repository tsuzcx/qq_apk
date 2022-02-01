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
  private static final String TAG = "YTCommonInitializer";
  private static final SharedLibraryInfo YT_COMMON = new SharedLibraryInfo("YTCommon");
  private static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("YTCommon") };
  private int authMode = 0;
  
  private String getErrorMessage(int paramInt)
  {
    String str;
    if (paramInt != -1407)
    {
      if (paramInt != -1405)
      {
        if (paramInt != -1301)
        {
          if (paramInt != -1005)
          {
            if (paramInt != -1001)
            {
              if (paramInt != 0)
              {
                if (paramInt != 3013)
                {
                  if (paramInt != 4001)
                  {
                    if (paramInt != 4003)
                    {
                      if (paramInt != -1402)
                      {
                        if (paramInt != -1401)
                        {
                          if (paramInt != 1002)
                          {
                            if (paramInt != 1003)
                            {
                              if (paramInt != 3003)
                              {
                                if (paramInt != 3004) {
                                  switch (paramInt)
                                  {
                                  default: 
                                    switch (paramInt)
                                    {
                                    default: 
                                      str = "内部错误";
                                      break;
                                    case 3019: 
                                      str = "license版本不匹配";
                                      break;
                                    case 3018: 
                                      str = "证书已过期";
                                      break;
                                    case 3017: 
                                      str = "证书已经过期(累计时间)";
                                      break;
                                    case 3016: 
                                      str = "package name为空";
                                      break;
                                    case 3015: 
                                      str = "package name不匹配";
                                    }
                                    break;
                                  case 2004: 
                                    str = "没有写权限";
                                    break;
                                  case 2003: 
                                    str = "证书保存失败";
                                    break;
                                  case 2002: 
                                    str = "证书下载失败";
                                    break;
                                  }
                                } else {
                                  str = "授权文件解析失败.";
                                }
                              }
                              else {
                                str = "证书文件为空";
                              }
                            }
                            else {
                              str = "网络初始化错误";
                            }
                          }
                          else {
                            str = "网络连接失败";
                          }
                        }
                        else {
                          str = "该设备续期次数超过限制";
                        }
                      }
                      else {
                        str = "授权时间无效";
                      }
                    }
                    else {
                      str = "没有权限获取序列号.";
                    }
                  }
                  else {
                    str = "设备序列号无效";
                  }
                }
                else {
                  str = "设备信息不匹配";
                }
              }
              else {
                str = "授权成功";
              }
            }
            else {
              str = "请求字段中参数错误";
            }
          }
          else {
            str = "设备时间和服务器不符";
          }
        }
        else {
          str = "序列号信息为空";
        }
      }
      else {
        str = "appid没有匹配到设备";
      }
    }
    else {
      str = "授权已过期";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  private boolean initAuth()
  {
    int i = this.authMode;
    boolean bool2 = false;
    if (i == 0)
    {
      if (TextUtils.isEmpty(AEModule.getLicense()))
      {
        logForInitAuth(AEModule.getContext(), "com_tencent_2118.lic", 0);
        i = YTCommonInterface.initAuth(AEModule.getContext(), "com_tencent_2118.lic", 0);
      }
      else
      {
        logForInitAuth(AEModule.getContext(), AEModule.getLicense(), AEModule.getLicenseInitType());
        i = YTCommonInterface.initAuth(AEModule.getContext(), AEModule.getLicense(), AEModule.getLicenseInitType());
      }
    }
    else {
      i = YTCommonInterface.initAuthForQQ(AEModule.getContext());
    }
    String str = getErrorMessage(i);
    LogUtils.i("AEKitFeature", str);
    if (i == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    AEOpenRenderConfig.checkStrictMode(bool1, str);
    boolean bool1 = bool2;
    if (i == 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean initCommonSoInAssets()
  {
    this.isInited = systemLoadLibrarySafely(YT_COMMON.fileName);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("YTCommon so init result: ");
    localStringBuilder.append(this.isInited);
    LogUtils.i(str, localStringBuilder.toString());
    return this.isInited;
  }
  
  private void logForInitAuth(Context paramContext, String paramString, int paramInt)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isContextNull::");
    boolean bool;
    if (paramContext == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append(",license::");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",licenseInitType::");
    localStringBuilder.append(paramInt);
    LogUtils.i(str, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.YTCommonInitializer
 * JD-Core Version:    0.7.0.1
 */