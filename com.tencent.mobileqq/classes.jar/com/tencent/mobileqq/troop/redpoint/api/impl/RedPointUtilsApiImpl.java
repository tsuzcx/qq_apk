package com.tencent.mobileqq.troop.redpoint.api.impl;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.troop.redpoint.RedPointListener;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointInfoService;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

public class RedPointUtilsApiImpl
  implements IRedPointUtilsApi
{
  public static final String TAG = "RedPointUtils";
  
  public void addRedPointListener(AppRuntime paramAppRuntime, RedPointListener paramRedPointListener)
  {
    if ((paramAppRuntime != null) && (paramRedPointListener != null)) {
      ((IRedPointInfoService)paramAppRuntime.getRuntimeService(IRedPointInfoService.class, "")).addRedPointListener(paramRedPointListener);
    }
  }
  
  public void cleanRedPointInfoById(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cleanRedPointInfoById : uin = ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(", uinType = ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(", redId = ");
        localStringBuilder.append(paramInt);
        QLog.d("RedPointUtils", 2, localStringBuilder.toString());
      }
      ((IRedPointInfoService)paramAppRuntime.getRuntimeService(IRedPointInfoService.class, "")).cleanRedPointInfoById(paramString1, paramString2, paramInt);
    }
  }
  
  public void cleanRedPointInfoByIds(AppRuntime paramAppRuntime, String paramString1, String paramString2, List<Integer> paramList)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cleanRedPointInfoByIds : uin = ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(", uinType = ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(", redPointIdList = ");
        localStringBuilder.append(paramList.toString());
        QLog.d("RedPointUtils", 2, localStringBuilder.toString());
      }
      ((IRedPointInfoService)paramAppRuntime.getRuntimeService(IRedPointInfoService.class, "")).cleanRedPointInfoByIds(paramString1, paramString2, paramList);
    }
  }
  
  public void notifyRedPointViewClick(AppRuntime paramAppRuntime, String paramString1, String paramString2, View paramView)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notifyRedPointViewClick uin = ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(", uinType = ");
        localStringBuilder.append(paramString2);
        QLog.d("RedPointUtils", 2, localStringBuilder.toString());
      }
      ((IRedPointInfoService)paramAppRuntime.getRuntimeService(IRedPointInfoService.class, "")).notifyRedPointViewClick(paramString1, paramString2, paramView);
    }
  }
  
  public void removeRedPointListener(AppRuntime paramAppRuntime, RedPointListener paramRedPointListener)
  {
    if ((paramAppRuntime != null) && (paramRedPointListener != null)) {
      ((IRedPointInfoService)paramAppRuntime.getRuntimeService(IRedPointInfoService.class, "")).removeRedPointListener(paramRedPointListener);
    }
  }
  
  public void updateRedPointInfo(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateRedPointInfo : uin = ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(", uinType = ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(", redId = ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(", unReadNum = ");
        localStringBuilder.append(paramInt2);
        QLog.d("RedPointUtils", 2, localStringBuilder.toString());
      }
      ((IRedPointInfoService)paramAppRuntime.getRuntimeService(IRedPointInfoService.class, "")).updateRedPointInfo(paramString1, paramString2, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.api.impl.RedPointUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */