package com.tencent.mobileqq.qwallet.config.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService.ConfigUpdateListener;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigServiceProxy;
import com.tencent.mobileqq.qwallet.ipc.impl.ComIPCUtilsImpl;
import com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCConnector;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.HashMap;

public class QWalletConfigServiceProxyImpl
  implements IQWalletConfigServiceProxy
{
  public static final String KEY_DEF_VALUE = "def_value";
  public static final String KEY_MODULE = "module";
  public static final String KEY_OPER_TYPE = "oper_type";
  public static final String KEY_PARAMS_VALUE = "params_value";
  public static final String KEY_RES_GET_VALUE = "res_get_value";
  public static final String KEY_SUB_KEYS = "sub_keys";
  public static final int OPER_TYPE_GET_CONFIG = 2;
  public static final int OPER_TYPE_GET_INT = 0;
  public static final int OPER_TYPE_GET_STR = 1;
  
  public QWalletConfigServiceProxyImpl()
  {
    QWalletIPCConnector.a().a();
  }
  
  public String getConfig(String paramString)
  {
    QWalletIPCConnector.a().a();
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 2);
    localBundle.putString("module", paramString);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "getConfig", localBundle);
    if ((paramString != null) && (paramString.isSuccess()) && (paramString.data != null)) {
      return paramString.data.getString("res_get_value");
    }
    return "";
  }
  
  public int getInt(String paramString, int paramInt, String... paramVarArgs)
  {
    QWalletIPCConnector.a().a();
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 0);
    localBundle.putString("module", paramString);
    localBundle.putInt("def_value", paramInt);
    localBundle.putStringArray("sub_keys", paramVarArgs);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "getConfig", localBundle);
    if ((paramString != null) && (paramString.isSuccess()) && (paramString.data != null)) {
      return paramString.data.getInt("res_get_value");
    }
    return paramInt;
  }
  
  public String getString(String paramString1, String paramString2, String... paramVarArgs)
  {
    QWalletIPCConnector.a().a();
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 1);
    localBundle.putString("module", paramString1);
    localBundle.putString("def_value", paramString2);
    localBundle.putStringArray("sub_keys", paramVarArgs);
    paramString1 = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "getConfig", localBundle);
    if ((paramString1 != null) && (paramString1.isSuccess()) && (paramString1.data != null)) {
      return paramString1.data.getString("res_get_value");
    }
    return paramString2;
  }
  
  public void registerUpdateListenerComm(String paramString, IQWalletConfigService.ConfigUpdateListener paramConfigUpdateListener)
  {
    ComIPCUtilsImpl.registIPCUpdateListener(paramString, paramConfigUpdateListener);
  }
  
  public void setConfigSession(HashMap<String, String> paramHashMap)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("params_value", paramHashMap);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "setConfigSession", localBundle, null);
  }
  
  public void unRegisterUpdateListenerComm(String paramString, IQWalletConfigService.ConfigUpdateListener paramConfigUpdateListener)
  {
    ComIPCUtilsImpl.unRegistIPCUpdateListener(paramString, paramConfigUpdateListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.config.impl.QWalletConfigServiceProxyImpl
 * JD-Core Version:    0.7.0.1
 */