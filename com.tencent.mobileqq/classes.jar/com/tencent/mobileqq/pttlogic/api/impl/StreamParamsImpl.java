package com.tencent.mobileqq.pttlogic.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.pttlogic.api.IStreamParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class StreamParamsImpl
  implements IStreamParams
{
  private static final int BUFFER_SIZE = 800;
  private static final String TAG = "StreamParams";
  private boolean sSliceCfgInit;
  private int[] sSliceSizeCfg = new int[6];
  private boolean sSupportCfgInit;
  private boolean sSupportStream = true;
  
  private String getSavedStreamCfg(AppRuntime paramAppRuntime)
  {
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordParams_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString("StreamCfg", null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSavedStreamCfg: ");
      ((StringBuilder)localObject).append(paramAppRuntime);
      QLog.d("StreamParams", 2, ((StringBuilder)localObject).toString());
    }
    return paramAppRuntime;
  }
  
  private String getSavedStreamSliceCfg(AppRuntime paramAppRuntime)
  {
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordParams_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString("StreamSliceCfg", null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSavedStreamSliceCfg: ");
      ((StringBuilder)localObject).append(paramAppRuntime);
      QLog.d("StreamParams", 2, ((StringBuilder)localObject).toString());
    }
    return paramAppRuntime;
  }
  
  public boolean doesSupportStreamPtt(AppRuntime paramAppRuntime)
  {
    initSupportCfg(paramAppRuntime, false);
    return this.sSupportStream;
  }
  
  public int getSliceSize(AppRuntime paramAppRuntime, int paramInt1, int paramInt2)
  {
    if (paramAppRuntime != null)
    {
      if (paramInt1 == 0) {
        return 800;
      }
      initSliceCfg(paramAppRuntime, false);
      paramAppRuntime = this.sSliceSizeCfg;
      if ((paramInt2 >= 0) && (paramInt2 < paramAppRuntime.length)) {
        paramInt1 = paramAppRuntime[paramInt2];
      } else {
        paramInt1 = 0;
      }
      paramInt2 = paramInt1;
      if (paramInt1 == 0) {
        paramInt2 = 800;
      }
      return paramInt2;
    }
    return 800;
  }
  
  public void initSliceCfg(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if ((this.sSliceCfgInit) && (!paramBoolean)) {
      return;
    }
    this.sSliceCfgInit = true;
    try
    {
      paramAppRuntime = getSavedStreamSliceCfg(paramAppRuntime);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initSliceCfg: ");
        ((StringBuilder)localObject).append(paramAppRuntime);
        QLog.d("StreamParams", 2, ((StringBuilder)localObject).toString());
      }
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.split("\\|");
        int i = 0;
        while (i < paramAppRuntime.length)
        {
          if (paramAppRuntime[i].startsWith("1-"))
          {
            localObject = paramAppRuntime[i].split("-");
            int j = Integer.parseInt(localObject[1]);
            int k = Integer.parseInt(localObject[2]);
            this.sSliceSizeCfg[j] = k;
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramAppRuntime) {}
  }
  
  public void initSupportCfg(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if ((this.sSupportCfgInit) && (!paramBoolean)) {
      return;
    }
    this.sSupportCfgInit = true;
    try
    {
      paramAppRuntime = getSavedStreamCfg(paramAppRuntime);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initSupportCfg :");
        localStringBuilder.append(paramAppRuntime);
        QLog.d("StreamParams", 2, localStringBuilder.toString());
      }
      if ((paramAppRuntime != null) && (paramAppRuntime.length() != 0))
      {
        paramAppRuntime = paramAppRuntime.split("\\|");
        if ((paramAppRuntime != null) && (paramAppRuntime.length >= 1)) {
          this.sSupportStream = "1".equals(paramAppRuntime[0]);
        }
      }
    }
    catch (Exception paramAppRuntime)
    {
      label106:
      break label106;
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("init params: ");
      paramAppRuntime.append(this.sSupportStream);
      QLog.d("StreamParams", 2, paramAppRuntime.toString());
    }
  }
  
  public void release()
  {
    this.sSupportCfgInit = false;
    this.sSupportStream = true;
    this.sSliceCfgInit = false;
    this.sSliceSizeCfg = new int[6];
  }
  
  public void saveStreamCfg(AppRuntime paramAppRuntime, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordParams_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putString("StreamCfg", paramString).commit();
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("saveStreamCfg: ");
      paramAppRuntime.append(paramString);
      QLog.d("StreamParams", 2, paramAppRuntime.toString());
    }
  }
  
  public void saveStreamSliceCfg(AppRuntime paramAppRuntime, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordParams_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putString("StreamSliceCfg", paramString).commit();
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("saveStreamSliceCfg: ");
      paramAppRuntime.append(paramString);
      QLog.d("StreamParams", 2, paramAppRuntime.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pttlogic.api.impl.StreamParamsImpl
 * JD-Core Version:    0.7.0.1
 */