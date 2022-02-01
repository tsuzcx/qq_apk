package com.tencent.mobileqq.vas;

import android.os.Bundle;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;

class ColorRingManager$1
  extends DownloadListener
{
  ColorRingManager$1(ColorRingManager paramColorRingManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDone, status=");
      ((StringBuilder)localObject).append(paramDownloadTask.a());
      QLog.d("ColorRingManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramDownloadTask.a();
    int i = ((Bundle)localObject).getInt("callId");
    int j = ((Bundle)localObject).getInt("resourceType");
    boolean bool1;
    if (paramDownloadTask.a() == 3) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      bool2 = ((Bundle)localObject).getBoolean("isExists", false);
      String str = ((Bundle)localObject).getString("path");
      if (!bool2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(".tmp");
        bool1 = FileUtils.rename(localStringBuilder.toString(), str);
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("ColorRingManager", 2, "rename failure.");
          bool2 = bool1;
        }
      }
    }
    if ((this.a.a != null) && (paramDownloadTask.a().getBoolean("isIPC")))
    {
      paramDownloadTask = new Bundle();
      paramDownloadTask.putString("status", "onDone");
      paramDownloadTask.putInt("fcStatus", 3);
      paramDownloadTask.putInt("id", i);
      paramDownloadTask.putInt("callId", i);
      paramDownloadTask.putInt("srcType", ((Bundle)localObject).getInt("srcType"));
      paramDownloadTask.putBoolean("result", bool2);
      paramDownloadTask.putInt("resourceType", ((Bundle)localObject).getInt("resourceType"));
      paramDownloadTask.putString("colorType", ((Bundle)localObject).getString("colorType"));
      paramDownloadTask.putBoolean("result_boo", bool2);
      paramDownloadTask.putInt("resourceType", j);
      this.a.a.a(paramDownloadTask);
    }
    ColorRingManager.a(this.a, (Bundle)localObject, i, j, bool2);
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onProgress, loaded=");
      ((StringBuilder)localObject).append(paramDownloadTask.b);
      ((StringBuilder)localObject).append("percent=");
      ((StringBuilder)localObject).append(paramDownloadTask.a);
      QLog.d("ColorRingManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramDownloadTask.a().getBoolean("isIPC")) && (this.a.a != null))
    {
      localObject = paramDownloadTask.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("status", "onProgress");
      localBundle.putInt("fcStatus", 2);
      localBundle.putInt("id", ((Bundle)localObject).getInt("callId"));
      localBundle.putInt("callId", ((Bundle)localObject).getInt("callId"));
      localBundle.putInt("srcType", ((Bundle)localObject).getInt("srcType"));
      localBundle.putInt("progress", (int)paramDownloadTask.a);
      localBundle.putInt("resourceType", ((Bundle)localObject).getInt("resourceType"));
      localBundle.putString("colorType", ((Bundle)localObject).getString("colorType"));
      this.a.a.a(localBundle);
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStart, loaded=");
      ((StringBuilder)localObject).append(paramDownloadTask.b);
      ((StringBuilder)localObject).append("percent=");
      ((StringBuilder)localObject).append(paramDownloadTask.a);
      QLog.d("ColorRingManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramDownloadTask.a().getBoolean("isIPC")) && (this.a.a != null))
    {
      paramDownloadTask = paramDownloadTask.a();
      localObject = new Bundle();
      ((Bundle)localObject).putString("status", "onStart");
      ((Bundle)localObject).putInt("id", paramDownloadTask.getInt("callId"));
      ((Bundle)localObject).putInt("fcStatus", 1);
      ((Bundle)localObject).putInt("callId", paramDownloadTask.getInt("callId"));
      ((Bundle)localObject).putInt("srcType", paramDownloadTask.getInt("srcType"));
      ((Bundle)localObject).putInt("resourceType", paramDownloadTask.getInt("resourceType"));
      ((Bundle)localObject).putString("colorType", paramDownloadTask.getString("colorType"));
      this.a.a.a((Bundle)localObject);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorRingManager.1
 * JD-Core Version:    0.7.0.1
 */