package com.tencent.mobileqq.qqlive.sso;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

public abstract class QQLiveBusinessObserver
  implements BusinessObserver
{
  private static final String TAG = "IQQLiveBusinessObserver";
  private String appID = "";
  
  public String getAppId()
  {
    return this.appID;
  }
  
  public abstract void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData);
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    paramObject = (QQLiveRspData)paramObject;
    if ((getAppId() != null) && (!getAppId().equals(paramObject.g())))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(paramObject.h());
        localStringBuilder.append("-checkAppId] reqAppId:");
        localStringBuilder.append(paramObject.g());
        localStringBuilder.append(", sdkAppId:");
        localStringBuilder.append(getAppId());
        QLog.d("IQQLiveBusinessObserver", 2, localStringBuilder.toString());
      }
    }
    else {
      onReceive(paramInt, paramBoolean, paramObject);
    }
  }
  
  public void setAppId(String paramString)
  {
    this.appID = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver
 * JD-Core Version:    0.7.0.1
 */