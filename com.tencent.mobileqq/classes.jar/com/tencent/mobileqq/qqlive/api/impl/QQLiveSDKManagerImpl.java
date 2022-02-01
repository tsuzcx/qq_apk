package com.tencent.mobileqq.qqlive.api.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QQLiveSDKManagerImpl
  implements IQQLiveSDKManager
{
  private static final String TAG = "QQLiveAnchor_SDK_Manager";
  private ConcurrentHashMap<String, IQQLiveSDK> sdkImpls = new ConcurrentHashMap();
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_SDK_Manager", 1, "sdk manager destroy");
    }
    Object localObject = this.sdkImpls;
    if ((localObject != null) && (!((ConcurrentHashMap)localObject).isEmpty()))
    {
      localObject = this.sdkImpls.entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IQQLiveSDK)((Map.Entry)((Iterator)localObject).next()).getValue()).destroy();
      }
    }
    this.sdkImpls.clear();
  }
  
  public void destroySDKImpl(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("destroy sdk for appId:");
      localStringBuilder.append(paramString);
      QLog.d("QQLiveAnchor_SDK_Manager", 1, localStringBuilder.toString());
    }
    paramString = (IQQLiveSDK)this.sdkImpls.remove(paramString);
    if (paramString != null) {
      paramString.destroy();
    }
  }
  
  public IQQLiveSDK getSDKImpl(String paramString)
  {
    if (!QQVideoPlaySDKManager.isSDKReady()) {
      QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), new QQLiveSDKManagerImpl.1(this));
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    IQQLiveSDK localIQQLiveSDK = (IQQLiveSDK)this.sdkImpls.get(paramString);
    Object localObject = localIQQLiveSDK;
    if (localIQQLiveSDK == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("create sdk for appId:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("QQLiveAnchor_SDK_Manager", 1, ((StringBuilder)localObject).toString());
      }
      localObject = new QQLiveSDKImpl(paramString);
      this.sdkImpls.put(paramString, localObject);
    }
    return localObject;
  }
  
  public void openDemo(Context paramContext)
  {
    try
    {
      Class localClass = Class.forName("com.tencent.qqlive.sdk.demo.TestActivity");
      if (localClass != null)
      {
        paramContext.startActivity(new Intent(paramContext, localClass));
        return;
      }
    }
    catch (Throwable paramContext)
    {
      QLog.e("QQLiveAnchor_SDK_Manager", 1, "find class error", paramContext);
    }
  }
  
  public IQQLiveSDK removeSDKImpl(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("remove sdk for appId:");
      localStringBuilder.append(paramString);
      QLog.d("QQLiveAnchor_SDK_Manager", 1, localStringBuilder.toString());
    }
    return (IQQLiveSDK)this.sdkImpls.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.QQLiveSDKManagerImpl
 * JD-Core Version:    0.7.0.1
 */