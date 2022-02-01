package com.tencent.qqmini.sdk.manager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class BannerAdViolationManager
{
  private static final String TAG = "BannerAdViolationManage";
  private static Map<Long, Long> exposureTimestampMap = new HashMap();
  
  private static View.OnClickListener getOnClickListenerReflected(View paramView)
  {
    Object localObject2 = null;
    if (paramView == null) {
      return null;
    }
    Object localObject1;
    try
    {
      Field localField = View.class.getDeclaredField("mListenerInfo");
      localObject1 = localObject2;
      if (localField != null)
      {
        localField.setAccessible(true);
        paramView = localField.get(paramView);
        localField = paramView.getClass().getDeclaredField("mOnClickListener");
        localObject1 = localObject2;
        if (localField != null)
        {
          localObject1 = localObject2;
          if (paramView != null)
          {
            localField.setAccessible(true);
            localObject1 = (View.OnClickListener)localField.get(paramView);
          }
        }
      }
    }
    catch (Throwable paramView)
    {
      QMLog.e("BannerAdViolationManage", "getOnClickListenerReflected", paramView);
      localObject1 = localObject2;
    }
    paramView = new StringBuilder();
    paramView.append("getOnClickListenerReflected: listener = ");
    paramView.append(localObject1);
    QMLog.d("BannerAdViolationManage", paramView.toString());
    return localObject1;
  }
  
  private static void handleViolationReport(String paramString, long paramLong1, int paramInt, long paramLong2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleViolationReport() called with: miniAppId = [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("], aid = [");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append("], clickArea = [");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], expoClickInterval = [");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append("]");
    QMLog.d("BannerAdViolationManage", ((StringBuilder)localObject).toString());
    if ((paramInt > 0) && (paramInt < 11) && (paramLong2 > 0L))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append('|');
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append('|');
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append('|');
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append('|');
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append('|');
      ((StringBuilder)localObject).append("Android");
      ((StringBuilder)localObject).append('|');
      ((StringBuilder)localObject).append("");
      paramString = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleViolationReport: report one record ");
      ((StringBuilder)localObject).append(paramString);
      QMLog.d("BannerAdViolationManage", ((StringBuilder)localObject).toString());
      localObject = new Bundle();
      ((Bundle)localObject).putStringArray("data", new String[] { paramString });
      ((Bundle)localObject).putString("log_key", "dc05439");
      AppBrandCmdProxy.g().sendCmd("cmd_dc_report_log_key_data", (Bundle)localObject, null);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("invalid report record clickArea = ");
    paramString.append(paramInt);
    paramString.append(", expoClickInterval = ");
    paramString.append(paramLong2);
    QMLog.w("BannerAdViolationManage", paramString.toString());
  }
  
  public static void scheduleViolationDetectTask(String paramString, long paramLong, View paramView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("scheduleViolationDetectTask() called with: miniAppId = [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("], aid = [");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("], view = [");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append("]");
    QMLog.d("BannerAdViolationManage", ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramView == null) {
        return;
      }
      exposureTimestampMap.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
      localObject = new float[2];
      paramView.setOnTouchListener(new BannerAdViolationManager.1((float[])localObject));
      paramView.setOnClickListener(new BannerAdViolationManager.2(getOnClickListenerReflected(paramView), paramLong, paramView, (float[])localObject, paramString));
      QMLog.d("BannerAdViolationManage", "scheduleViolationDetectTask: end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BannerAdViolationManager
 * JD-Core Version:    0.7.0.1
 */