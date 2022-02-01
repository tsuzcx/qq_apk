package com.tencent.replacemonitor.replace.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import java.util.Map;

class b
  implements com.tencent.replacemonitor.replace.b
{
  b(a parama) {}
  
  public void a(int paramInt1, int paramInt2, long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ReplaceMonitorImpl >>onGetMonitorInfoSuccess reqId = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" appType = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" fileSize = ");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(" apkMd5 = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" runMd5FileSize = ");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append(" cpChannelId = ");
    ((StringBuilder)localObject).append(paramString2);
    ab.c("WashMonitor", ((StringBuilder)localObject).toString());
    localObject = (Long)a.a(this.a).get(Integer.valueOf(paramInt1));
    long l;
    if (localObject != null) {
      l = ((Long)localObject).longValue();
    } else {
      l = 0L;
    }
    localObject = com.tencent.replacemonitor.replace.b.a.a().a(l);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReplaceMonitorImpl >>onGetMonitorInfoSuccess task = ");
    localStringBuilder.append(localObject);
    ab.c("WashMonitor", localStringBuilder.toString());
    if (localObject != null)
    {
      if (((MonitorTask)localObject).fileSize <= 0L) {
        ((MonitorTask)localObject).fileSize = paramLong1;
      }
      if (TextUtils.isEmpty(((MonitorTask)localObject).fileMd5)) {
        ((MonitorTask)localObject).fileMd5 = paramString1;
      }
      if (TextUtils.isEmpty(((MonitorTask)localObject).cpChannelId)) {
        ((MonitorTask)localObject).cpChannelId = paramString2;
      }
      ((MonitorTask)localObject).appType = paramInt2;
      com.tencent.replacemonitor.replace.b.a.a().a((MonitorTask)localObject);
    }
    if (paramLong2 > 0L)
    {
      com.tencent.replacemonitor.a.a = paramLong2;
      paramString1 = GlobalUtil.getInstance().getContext();
      if (paramString1 != null) {
        paramString1.getSharedPreferences("replace_monitor_spf", 0).edit().putLong("md5_check_max_file_size", paramLong2).apply();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReplaceMonitorImpl >>onGetMonitorInfoFailed reqId = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" errorCode = ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" errorMsg = ");
    localStringBuilder.append(paramString);
    ab.d("WashMonitor", localStringBuilder.toString());
    paramString = (Long)a.a(this.a).get(Integer.valueOf(paramInt1));
    long l;
    if (paramString != null) {
      l = paramString.longValue();
    } else {
      l = 0L;
    }
    paramString = com.tencent.replacemonitor.replace.b.a.a().a(l);
    if (paramString != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ReplaceMonitorImpl >>onGetMonitorInfoFailed task.packageName = ");
      localStringBuilder.append(paramString.packageName);
      localStringBuilder.append(" apkId = ");
      localStringBuilder.append(paramString.yybApkId);
      localStringBuilder.append(" appId = ");
      localStringBuilder.append(paramString.yybAppId);
      ab.d("WashMonitor", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.c.b
 * JD-Core Version:    0.7.0.1
 */