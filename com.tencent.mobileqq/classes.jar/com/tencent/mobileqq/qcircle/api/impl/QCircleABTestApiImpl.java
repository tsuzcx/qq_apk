package com.tencent.mobileqq.qcircle.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class QCircleABTestApiImpl
  implements IQCircleABTestApi
{
  private static final String TAG = "QCircleABTestApi";
  private ExpEntityInfo mCurrentExpInfo = null;
  
  public Map<String, String> getParams()
  {
    ExpEntityInfo localExpEntityInfo = this.mCurrentExpInfo;
    if (localExpEntityInfo == null) {
      return null;
    }
    return localExpEntityInfo.a();
  }
  
  public void initSDK(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      ABTestController.a().a(paramContext, paramString);
    }
  }
  
  public boolean isContrast()
  {
    ExpEntityInfo localExpEntityInfo = this.mCurrentExpInfo;
    return (localExpEntityInfo != null) && (localExpEntityInfo.b());
  }
  
  public boolean isExpHit(String paramString)
  {
    ExpEntityInfo localExpEntityInfo = this.mCurrentExpInfo;
    return (localExpEntityInfo != null) && (localExpEntityInfo.c(paramString));
  }
  
  public boolean isExpOnline()
  {
    ExpEntityInfo localExpEntityInfo = this.mCurrentExpInfo;
    return (localExpEntityInfo != null) && (localExpEntityInfo.c());
  }
  
  public boolean isExperiment()
  {
    ExpEntityInfo localExpEntityInfo = this.mCurrentExpInfo;
    return (localExpEntityInfo != null) && (localExpEntityInfo.a());
  }
  
  public IQCircleABTestApi loadExperiment(String paramString)
  {
    this.mCurrentExpInfo = ABTestController.a().a(paramString);
    Object localObject = this.mCurrentExpInfo;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((ExpEntityInfo)localObject).a();
    }
    QLog.d("QCircleABTestApi", 1, new Object[] { "[loadExperiment] expTagName: ", paramString, " | expInfo: ", localObject });
    return this;
  }
  
  public void registerExpConfigInfo(String paramString)
  {
    ABTestController.a().a(paramString);
  }
  
  public void release()
  {
    ABTestController.a().a();
  }
  
  public void reportEvent(int paramInt, String paramString)
  {
    ExpEntityInfo localExpEntityInfo = this.mCurrentExpInfo;
    if (localExpEntityInfo == null) {
      return;
    }
    localExpEntityInfo.a(paramInt, paramString);
  }
  
  public void reportExpExposure()
  {
    ExpEntityInfo localExpEntityInfo = this.mCurrentExpInfo;
    if (localExpEntityInfo == null) {
      return;
    }
    localExpEntityInfo.a();
  }
  
  public void reportExposure(String paramString)
  {
    ExpEntityInfo localExpEntityInfo = this.mCurrentExpInfo;
    if (localExpEntityInfo == null) {
      return;
    }
    localExpEntityInfo.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleABTestApiImpl
 * JD-Core Version:    0.7.0.1
 */