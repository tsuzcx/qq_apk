package com.tencent.mobileqq.qqfeatureswitch.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.featuretoggle.Toggle;
import com.tencent.featuretoggle.ToggleConfig;
import com.tencent.mobileqq.qqfeatureswitch.FeatureSDKReporter;
import com.tencent.mobileqq.qqfeatureswitch.FeatureSwitch;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqfeatureswitch.ISwitchModel;
import com.tencent.mobileqq.qqfeatureswitch.OnUpdateListener;
import com.tencent.mobileqq.qqfeatureswitch.ToggleReleaseModel;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class FeatureRuntimeServiceImpl
  implements IFeatureRuntimeService
{
  private static final String ANDROID_QQ_MODULE_ID = "268";
  private static final String QQ_PRODUCT_ID = "e59599c0-b795-4136-925d-3a59ce7d09d5";
  private static final String QQ_PRODUCT_NAME_EN = "QQ";
  private static final String TAG = "FeatureRuntimeServiceImpl";
  protected static boolean sHasInitSdk;
  private static List<OnUpdateListener> sListeners;
  private static Stack<String> sUserIdStack;
  protected ISwitchModel mModel = generateModel();
  
  private void initSdkFirst()
  {
    if (!sHasInitSdk) {
      initSdk(BaseApplication.getContext());
    }
  }
  
  private void setUserId(String paramString)
  {
    try
    {
      if (sUserIdStack == null) {
        sUserIdStack = new Stack();
      }
      sUserIdStack.push(paramString);
      if (sUserIdStack.size() == 1)
      {
        QLog.d("FeatureRuntimeServiceImpl", 1, new Object[] { "set user id : ", MobileQQ.getShortUinStr(paramString) });
        Toggle.a(paramString, true);
      }
      return;
    }
    finally {}
  }
  
  protected ISwitchModel generateModel()
  {
    return new ToggleReleaseModel();
  }
  
  public FeatureSwitch getFeatureSwitch(String paramString)
  {
    initSdkFirst();
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("FeatureRuntimeServiceImpl", 1, "getFeatureSwitch, name is empty");
      return null;
    }
    FeatureSwitch localFeatureSwitch = this.mModel.a(paramString, true);
    FeatureSDKReporter.a(paramString, localFeatureSwitch);
    return localFeatureSwitch;
  }
  
  public Map<String, FeatureSwitch> getSwitchList()
  {
    initSdkFirst();
    return this.mModel.a();
  }
  
  public void initSdk(Context paramContext)
  {
    if (paramContext == null) {}
    try
    {
      QLog.e("FeatureRuntimeServiceImpl", 1, "initTABSdk, context is null");
      return;
    }
    finally {}
    if (sHasInitSdk)
    {
      QLog.d("FeatureRuntimeServiceImpl", 1, "duplicate init");
      return;
    }
    QLog.d("FeatureRuntimeServiceImpl", 1, "start init");
    ToggleConfig localToggleConfig = new ToggleConfig("e59599c0-b795-4136-925d-3a59ce7d09d5", "268", "QQ");
    localToggleConfig.a(false);
    localToggleConfig.a(1800L);
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    localToggleConfig.d(UserAction.getQimeiNew());
    if (((AppRuntime)localObject).isLogin()) {
      localObject = ((AppRuntime)localObject).getCurrentAccountUin();
    }
    for (;;)
    {
      localToggleConfig.c((String)localObject);
      localToggleConfig.a(3);
      localToggleConfig.b(true);
      Toggle.a(paramContext, localToggleConfig);
      Toggle.a(new FeatureRuntimeServiceImpl.ToggleUpdateListener());
      sHasInitSdk = true;
      return;
      localObject = "";
    }
  }
  
  public boolean isFeatureSwitchEnable(String paramString)
  {
    return isFeatureSwitchEnable(paramString, true);
  }
  
  public boolean isFeatureSwitchEnable(String paramString, boolean paramBoolean)
  {
    initSdkFirst();
    FeatureSDKReporter.a(paramString, getFeatureSwitch(paramString));
    return this.mModel.a(paramString, paramBoolean);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    QLog.d("FeatureRuntimeServiceImpl", 1, "onCreate");
    if (sHasInitSdk)
    {
      QLog.d("FeatureRuntimeServiceImpl", 1, "start switch userId");
      setUserId(paramAppRuntime.getAccount());
    }
  }
  
  public void onDestroy()
  {
    QLog.d("FeatureRuntimeServiceImpl", 1, "onDestroy");
    resetSwitchState();
    List localList = sListeners;
    if (localList != null) {
      localList.clear();
    }
    if (sHasInitSdk)
    {
      QLog.d("FeatureRuntimeServiceImpl", 1, "logout, reset userId");
      setUserId("");
    }
  }
  
  public void registerFeatureUpdateListener(OnUpdateListener paramOnUpdateListener)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("FeatureRuntimeServiceImpl", 2, "registerFeatureUpdateListener");
      }
      initSdkFirst();
      if (paramOnUpdateListener == null)
      {
        QLog.e("FeatureRuntimeServiceImpl", 1, "registerFeatureUpdateListener, callback is null");
        return;
      }
      if (sListeners == null) {
        sListeners = new ArrayList();
      }
      if (sListeners.contains(paramOnUpdateListener))
      {
        QLog.d("FeatureRuntimeServiceImpl", 1, "listener has register");
        return;
      }
      sListeners.add(paramOnUpdateListener);
      return;
    }
    finally {}
  }
  
  public void resetSwitchState()
  {
    this.mModel.a();
  }
  
  public void setSwitchState(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      QLog.e("FeatureRuntimeServiceImpl", 1, "setSwitchState, name is null");
      return;
    }
    this.mModel.a(paramString, paramBoolean);
  }
  
  public void unregisterFeatureUpdateListener(OnUpdateListener paramOnUpdateListener)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("FeatureRuntimeServiceImpl", 2, "unregisterFeatureUpdateListener");
      }
      initSdkFirst();
      if (paramOnUpdateListener == null)
      {
        QLog.e("FeatureRuntimeServiceImpl", 1, "unregisterFeatureUpdateListener, listener is null");
        return;
      }
      if ((sListeners != null) && (sListeners.contains(paramOnUpdateListener)))
      {
        sListeners.remove(paramOnUpdateListener);
        return;
      }
      QLog.e("FeatureRuntimeServiceImpl", 1, "unregisterFeatureUpdateListener, listener not register");
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqfeatureswitch.impl.FeatureRuntimeServiceImpl
 * JD-Core Version:    0.7.0.1
 */