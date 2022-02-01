package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import Wallet.GetMiniAppReq;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.microapp.ext.ManagerProxy;
import com.tencent.mobileqq.microapp.sdk.BaseLibInfo;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.microapp.sdk.OnUpdateListener;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class ApkgConfigManager
  implements Manager
{
  private static final String BASE_LIB_KEY_DEFAULT = "6VVmps6FEskvzUw+4t4BXEDUccolfE5bYliLLouIQUNUnYhBn/oSsktnohg3uFs0PDC+VDjsB2x7hkQ/G2m8OeCrSAYDQZwwmf1JZ+HYizxIj/i8SMs3ySNoCxiZc8s70BWR6wbjgRPt6p8+k3E5cS0Arcd+RwprVYpyDPuBiZg=";
  private static final String BASE_LIB_URL_DEFAULT = "https://i.gtimg.cn/channel/imglib/201811/upload_a84c998c33a7341a621a217cb90b7612.zip";
  private static final String BASE_LIB_VERSION_DEFAULT = "2.3.1";
  private static final String TAG = "ApkgConfigManager";
  private BaseLibInfo baseLibInfo;
  private QQAppInterface mApp;
  private a mConfig;
  
  public ApkgConfigManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApkgConfigManager", 2, "ApkgConfigManager init");
    }
    this.mApp = paramQQAppInterface;
    this.mConfig = a.a(paramQQAppInterface);
  }
  
  public static boolean isCanNavigate(MiniAppConfig paramMiniAppConfig1, MiniAppConfig paramMiniAppConfig2)
  {
    if ((paramMiniAppConfig1 != null) && (paramMiniAppConfig1.config != null) && (paramMiniAppConfig2 != null) && (paramMiniAppConfig2.config != null))
    {
      if (LaunchParam.isCollectionPage(paramMiniAppConfig2.config.mini_appid)) {
        return true;
      }
      return QWalletTools.isStringEquals(paramMiniAppConfig1.config.union_id, paramMiniAppConfig2.config.union_id);
    }
    return false;
  }
  
  public BaseLibInfo getBaseLibInfo()
  {
    if (this.baseLibInfo == null)
    {
      Object localObject1 = ManagerProxy.getQWalletConfigManager(this.mApp);
      String str = "";
      Object localObject2;
      if (localObject1 != null)
      {
        str = ((QWalletConfigManager)localObject1).getString("miniapp", "", new String[] { "base_lib_url" });
        localObject2 = ((QWalletConfigManager)localObject1).getString("miniapp", "", new String[] { "base_lib_key" });
        localObject1 = ((QWalletConfigManager)localObject1).getString("miniapp", "", new String[] { "base_lib_version" });
      }
      else
      {
        localObject1 = "";
        localObject2 = localObject1;
      }
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
        this.baseLibInfo = new BaseLibInfo(str, (String)localObject2, (String)localObject1);
      } else {
        this.baseLibInfo = new BaseLibInfo("https://i.gtimg.cn/channel/imglib/201811/upload_a84c998c33a7341a621a217cb90b7612.zip", "6VVmps6FEskvzUw+4t4BXEDUccolfE5bYliLLouIQUNUnYhBn/oSsktnohg3uFs0PDC+VDjsB2x7hkQ/G2m8OeCrSAYDQZwwmf1JZ+HYizxIj/i8SMs3ySNoCxiZc8s70BWR6wbjgRPt6p8+k3E5cS0Arcd+RwprVYpyDPuBiZg=", "2.3.1");
      }
    }
    return this.baseLibInfo;
  }
  
  public MiniAppConfig getConfig(LaunchParam paramLaunchParam)
  {
    paramLaunchParam = this.mConfig.b(paramLaunchParam);
    if (paramLaunchParam != null) {
      return new MiniAppConfig(paramLaunchParam, getBaseLibInfo());
    }
    return null;
  }
  
  public MiniAppConfig getConfig(String paramString)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.miniAppId = paramString;
    return getConfig(localLaunchParam);
  }
  
  public void getNewestConfig(LaunchParam paramLaunchParam, int paramInt, ApkgConfigManager.a parama)
  {
    GetMiniAppReq localGetMiniAppReq = new GetMiniAppReq(paramLaunchParam.miniAppId, paramInt, paramLaunchParam.getReqAction(), paramLaunchParam.extraKey);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNewestConfig GetMiniAppReq|");
      localStringBuilder.append(localGetMiniAppReq);
      QLog.d("ApkgConfigManager", 2, localStringBuilder.toString());
    }
    QWalletCommonServlet.sendRequest(localGetMiniAppReq, new c(this, parama, paramLaunchParam));
  }
  
  public void onDestroy() {}
  
  public void tryUpdate(LaunchParam paramLaunchParam, int paramInt, OnUpdateListener paramOnUpdateListener)
  {
    if (paramInt == -1) {
      return;
    }
    getNewestConfig(paramLaunchParam, paramInt, new d(this, paramInt, paramOnUpdateListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.ApkgConfigManager
 * JD-Core Version:    0.7.0.1
 */