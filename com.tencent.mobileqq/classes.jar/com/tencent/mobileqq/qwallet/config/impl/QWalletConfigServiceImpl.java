package com.tencent.mobileqq.qwallet.config.impl;

import Wallet.ReqWalletConfig;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.config.ConfigInfo;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService.ConfigListener;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService.ConfigUpdateListener;
import com.tencent.mobileqq.qwallet.config.JSONParseUtils;
import com.tencent.mobileqq.qwallet.impl.QWalletCommonServlet;
import com.tencent.mobileqq.qwallet.ipc.impl.ComIPCUtilsImpl;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletConfigServiceImpl
  implements IQWalletConfigService
{
  private static final String TAG = "QWalletConfigServiceImpl";
  private BaseQQAppInterface mApp;
  private QWalletConfig mConfig;
  private volatile long mLastNonRspReq = -1L;
  private int mLastReqOccation = -1;
  
  public static void registerUpdateListenerComm(String paramString, IQWalletConfigService.ConfigUpdateListener paramConfigUpdateListener)
  {
    AppRuntime localAppRuntime = QWalletHelperImpl.getAppRuntime();
    if ((localAppRuntime instanceof BaseQQAppInterface))
    {
      ((IQWalletConfigService)localAppRuntime.getRuntimeService(IQWalletConfigService.class, "")).registerUpdateListener(paramString, paramConfigUpdateListener);
      return;
    }
    ComIPCUtilsImpl.registIPCUpdateListener(paramString, paramConfigUpdateListener);
  }
  
  public static void unRegisterUpdateListenerComm(String paramString, IQWalletConfigService.ConfigUpdateListener paramConfigUpdateListener)
  {
    AppRuntime localAppRuntime = QWalletHelperImpl.getAppRuntime();
    if ((localAppRuntime instanceof BaseQQAppInterface))
    {
      ((IQWalletConfigService)localAppRuntime.getRuntimeService(IQWalletConfigService.class, "")).unRegisterUpdateListener(paramString, paramConfigUpdateListener);
      return;
    }
    ComIPCUtilsImpl.unRegistIPCUpdateListener(paramString, paramConfigUpdateListener);
  }
  
  public void getAllConfig(int paramInt)
  {
    this.mLastReqOccation = paramInt;
    HashMap localHashMap = new HashMap();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("");
    localHashMap.put("req_when", ((StringBuilder)localObject).toString());
    try
    {
      localObject = ((IQWalletRedService)this.mApp.getRuntimeService(IQWalletRedService.class)).getNotShowListStr();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localHashMap.put("redPoint", localObject);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    getConfig(0L, null, null, localHashMap);
  }
  
  public JSONArray getArray(String paramString, String... paramVarArgs)
  {
    return JSONParseUtils.a(getConfigObj(paramString), paramVarArgs);
  }
  
  public String getConfig(String paramString)
  {
    return this.mConfig.getConfig(paramString);
  }
  
  public void getConfig(long paramLong, IQWalletConfigService.ConfigListener paramConfigListener, String paramString, Map<String, String> paramMap)
  {
    boolean bool = isVersionUpdate();
    long l2 = 0L;
    if (bool)
    {
      this.mConfig.seriesNo = 0L;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("replace install:");
      ((StringBuilder)localObject).append(AppSetting.a());
      QLog.i("QWalletConfigServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    long l1;
    if (paramLong == 0L) {
      l1 = this.mConfig.seriesNo;
    } else {
      l1 = 0L;
    }
    Object localObject = this.mApp;
    if (localObject != null) {
      l2 = ((BaseQQAppInterface)localObject).getLongAccountUin();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Android|");
    ((StringBuilder)localObject).append(DeviceInfoUtil.e());
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(DeviceInfoUtil.i());
    localObject = ReqWalletConfig.createReq(paramLong, l2, l1, paramString, paramMap, ((StringBuilder)localObject).toString(), DeviceInfoUtil.c(), NetworkUtil.getSystemNetwork(MobileQQ.sMobileQQ));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("realGetConfig:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("|");
      localStringBuilder.append(paramConfigListener);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString);
      localStringBuilder.append("|");
      localStringBuilder.append(paramMap);
      localStringBuilder.append("|");
      localStringBuilder.append(localObject);
      QLog.d("QWalletConfigServiceImpl", 2, localStringBuilder.toString());
    }
    QWalletCommonServlet.a((JceStruct)localObject, new QWalletConfigServiceImpl.2(this, paramLong, paramConfigListener, new WeakReference(this)));
  }
  
  public void getConfig(long paramLong, IQWalletConfigService.ConfigListener paramConfigListener, Map<String, String> paramMap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConfig:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("|");
      localStringBuilder.append(paramMap);
      localStringBuilder.append("|");
      localStringBuilder.append(this.mConfig);
      QLog.d("QWalletConfigServiceImpl", 2, localStringBuilder.toString());
    }
    if (paramLong == 0L) {
      return;
    }
    if (this.mConfig.isValidToReq(paramLong))
    {
      getConfig(paramLong, paramConfigListener, null, paramMap);
      return;
    }
    this.mConfig.notifyListener(paramConfigListener);
  }
  
  public JSONArray getConfigArray(String paramString)
  {
    paramString = this.mConfig.getParsedConfig(paramString);
    if ((paramString instanceof JSONArray)) {
      return (JSONArray)paramString;
    }
    return null;
  }
  
  public ConfigInfo getConfigInfo(String paramString)
  {
    return this.mConfig.getConfigInfo(paramString);
  }
  
  public JSONObject getConfigObj(String paramString)
  {
    paramString = this.mConfig.getParsedConfig(paramString);
    if ((paramString instanceof JSONObject)) {
      return (JSONObject)paramString;
    }
    return null;
  }
  
  public int getInt(String paramString, int paramInt, String... paramVarArgs)
  {
    return JSONParseUtils.a(getConfigObj(paramString), paramInt, paramVarArgs);
  }
  
  public long getLastReqTime()
  {
    return this.mConfig.lastReqTime;
  }
  
  public JSONObject getObj(String paramString, String... paramVarArgs)
  {
    return JSONParseUtils.a(getConfigObj(paramString), paramVarArgs);
  }
  
  public int getQWalletSettingConfigVersion(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("qwallet_setting_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public String getString(String paramString1, String paramString2, String... paramVarArgs)
  {
    return JSONParseUtils.a(getConfigObj(paramString1), paramString2, paramVarArgs);
  }
  
  public String getValueInModule(String paramString1, String paramString2)
  {
    paramString1 = getConfig(paramString1);
    if (!TextUtils.isEmpty(paramString1)) {
      try
      {
        paramString1 = new JSONObject(paramString1);
        if (paramString1.has(paramString2))
        {
          paramString1 = paramString1.optString(paramString2);
          return paramString1;
        }
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return null;
  }
  
  public void handleQWalletSettingCofig(ConfigurationService.Config paramConfig)
  {
    String str = this.mApp.getCurrentAccountUin();
    BaseQQAppInterface localBaseQQAppInterface = this.mApp;
    ThreadManager.getSubThreadHandler().post(new QWalletConfigServiceImpl.4(this, localBaseQQAppInterface, str, paramConfig));
  }
  
  public boolean isPublicAccountSupportPay(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = getValueInModule("pub_acc", "pay_puin_list");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = new JSONArray((String)localObject);
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(((JSONArray)localObject).get(i));
            boolean bool = paramString.equals(localStringBuilder.toString());
            if (bool) {
              return true;
            }
            i += 1;
          }
          return false;
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public boolean isVersionUpdate()
  {
    return this.mConfig.isVersionUpdate();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletConfigServiceImpl", 2, "QWalletConfigServiceImpl init");
    }
    this.mApp = ((BaseQQAppInterface)paramAppRuntime);
    this.mConfig = QWalletConfig.readConfig(this.mApp);
  }
  
  public void onDestroy()
  {
    this.mConfig.onDestroy();
  }
  
  public void registerUpdateListener(String paramString, IQWalletConfigService.ConfigUpdateListener paramConfigUpdateListener)
  {
    this.mConfig.addUpdateListener(paramString, paramConfigUpdateListener);
  }
  
  public void setConfigSession(Map<String, String> paramMap)
  {
    if (paramMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigServiceImpl", 2, "setConfig params is null");
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Android|");
    ((StringBuilder)localObject).append(DeviceInfoUtil.e());
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(DeviceInfoUtil.i());
    localObject = ((StringBuilder)localObject).toString();
    String str = DeviceInfoUtil.c();
    int i = NetworkUtil.getSystemNetwork(MobileQQ.sMobileQQ);
    paramMap = ReqWalletConfig.createReq(0L, this.mApp.getLongAccountUin(), this.mConfig.seriesNo, null, paramMap, (String)localObject, str, i);
    QWalletCommonServlet.a(paramMap, 1, new QWalletConfigServiceImpl.3(this));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setConfig:");
      ((StringBuilder)localObject).append(paramMap);
      QLog.d("QWalletConfigServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void tryGetConfig(int paramInt)
  {
    int i = this.mConfig.getValidReqOcca(paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryGetConfig:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("|");
      localStringBuilder.append(i);
      localStringBuilder.append("|");
      localStringBuilder.append(this.mConfig);
      QLog.d("QWalletConfigServiceImpl", 2, localStringBuilder.toString());
    }
    if (i != -1)
    {
      if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.mLastNonRspReq) > 60000L)
      {
        getAllConfig(i);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigServiceImpl", 2, "tryGetConfig too frequently to req");
      }
    }
  }
  
  public void tryGetConfigAgain()
  {
    ThreadManager.executeOnSubThread(new QWalletConfigServiceImpl.1(this, new WeakReference(this)));
  }
  
  public void unRegisterUpdateListener(String paramString, IQWalletConfigService.ConfigUpdateListener paramConfigUpdateListener)
  {
    this.mConfig.removeUpdateListener(paramString, paramConfigUpdateListener);
  }
  
  public void updateQWalletSettingConfigVersion(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("qwallet_setting_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.config.impl.QWalletConfigServiceImpl
 * JD-Core Version:    0.7.0.1
 */