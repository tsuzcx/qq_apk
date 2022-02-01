package com.tencent.mobileqq.ptt.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.ptt.api.IPttOptimizeParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class PttOptimizeParamsImpl
  implements IPttOptimizeParams
{
  public static final long FLAG_ACTIVATE_NET = 4L;
  public static final long FLAG_DIRECT_URL_DW = 1L;
  public static final long FLAG_HTTP_SIDEWAY = 8L;
  public static final long FLAG_REUSE_IP = 16L;
  public static final long FLAG_SSCM = 2L;
  private static final String TAG = "PttOptimizeParams";
  private int fixScheduleTryCount = 3;
  protected boolean sOptimizeCfgInit = false;
  protected int sPreSendSwitch = 1;
  private int supportActivateNet = 1;
  private int supportDirectDownload = 1;
  private int supportHttpSideWay = 1;
  private int supportSSCM = 1;
  private int tryCount = 9;
  private int tryTime = 480000;
  
  public boolean doesSupportActivateNet(AppRuntime paramAppRuntime)
  {
    boolean bool = false;
    initOptimizeCfg(paramAppRuntime, false);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("doesSupportActivateNet:");
      paramAppRuntime.append(this.supportActivateNet);
      QLog.d("PttOptimizeParams", 2, paramAppRuntime.toString());
    }
    if (this.supportActivateNet == 1) {
      bool = true;
    }
    return bool;
  }
  
  public boolean doesSupportDirectDownload(AppRuntime paramAppRuntime)
  {
    boolean bool = false;
    initOptimizeCfg(paramAppRuntime, false);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("doesSupportDirectDownload:");
      paramAppRuntime.append(this.supportDirectDownload);
      QLog.d("PttOptimizeParams", 2, paramAppRuntime.toString());
    }
    if (this.supportDirectDownload == 1) {
      bool = true;
    }
    return bool;
  }
  
  public boolean doesSupportHttpSideWay(AppRuntime paramAppRuntime)
  {
    boolean bool = false;
    initOptimizeCfg(paramAppRuntime, false);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("doesSupportHttpSideWay:");
      paramAppRuntime.append(this.supportHttpSideWay);
      QLog.d("PttOptimizeParams", 2, paramAppRuntime.toString());
    }
    if (this.supportHttpSideWay == 1) {
      bool = true;
    }
    return bool;
  }
  
  public boolean doesSupportSSCM(AppRuntime paramAppRuntime)
  {
    boolean bool = false;
    initOptimizeCfg(paramAppRuntime, false);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("doesSupportSSCM:");
      paramAppRuntime.append(this.supportSSCM);
      QLog.d("PttOptimizeParams", 2, paramAppRuntime.toString());
    }
    if (this.supportSSCM == 1) {
      bool = true;
    }
    return bool;
  }
  
  public int getFixScheduleTryCount_dpc(AppRuntime paramAppRuntime)
  {
    initOptimizeCfg(paramAppRuntime, false);
    return this.fixScheduleTryCount;
  }
  
  public long getOptString(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (doesSupportDirectDownload(paramAppRuntime)) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    long l1 = l2;
    if (doesSupportSSCM(paramAppRuntime)) {
      l1 = l2 | 0x2;
    }
    long l2 = l1;
    if (doesSupportActivateNet(paramAppRuntime)) {
      l2 = l1 | 0x4;
    }
    l1 = l2;
    if (doesSupportHttpSideWay(paramAppRuntime)) {
      l1 = l2 | 0x8;
    }
    l2 = l1;
    if (paramBoolean) {
      l2 = l1 | 0x10;
    }
    return l2;
  }
  
  public int getPreSend_dpc(AppRuntime paramAppRuntime)
  {
    initOptimizeCfg(paramAppRuntime, false);
    return this.sPreSendSwitch;
  }
  
  protected String getSavedPttOptimizeCfg(AppRuntime paramAppRuntime)
  {
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordParams_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString("ptt_optimize_cfg_v2", null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSavedPttOptimizeCfg: ");
      ((StringBuilder)localObject).append(paramAppRuntime);
      QLog.d("PttOptimizeParams", 2, ((StringBuilder)localObject).toString());
    }
    return paramAppRuntime;
  }
  
  public int getTryCount_dpc(AppRuntime paramAppRuntime)
  {
    initOptimizeCfg(paramAppRuntime, false);
    return this.tryCount;
  }
  
  public int getTryTime_dpc(AppRuntime paramAppRuntime)
  {
    initOptimizeCfg(paramAppRuntime, false);
    return this.tryTime;
  }
  
  public void initOptimizeCfg(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    try
    {
      boolean bool = this.sOptimizeCfgInit;
      if ((bool) && (!paramBoolean)) {
        return;
      }
      this.sOptimizeCfgInit = true;
      try
      {
        localObject = getSavedPttOptimizeCfg(paramAppRuntime);
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("initPttOptimizeCfgStr: ");
          localStringBuilder.append((String)localObject);
          QLog.d("PttOptimizeParams", 2, localStringBuilder.toString());
        }
        if (localObject != null)
        {
          localObject = ((String)localObject).split("\\|");
          this.supportDirectDownload = Integer.valueOf(localObject[0]).intValue();
          this.supportSSCM = Integer.valueOf(localObject[1]).intValue();
          this.tryTime = Integer.valueOf(localObject[2]).intValue();
          this.tryCount = Integer.valueOf(localObject[3]).intValue();
          this.fixScheduleTryCount = Integer.valueOf(localObject[4]).intValue();
          this.supportActivateNet = Integer.valueOf(localObject[5]).intValue();
          this.supportHttpSideWay = Integer.valueOf(localObject[6]).intValue();
          this.sPreSendSwitch = Integer.valueOf(localObject[7]).intValue();
        }
        localObject = paramAppRuntime.getCurrentAccountUin();
        if (this.supportDirectDownload == 0) {
          if (((String)localObject).endsWith("1")) {
            this.supportDirectDownload = 2;
          } else {
            this.supportDirectDownload = 1;
          }
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("initDirectDownloadCfgStr: ");
          localStringBuilder.append(this.supportDirectDownload);
          QLog.d("PttOptimizeParams", 2, localStringBuilder.toString());
        }
        if (this.supportSSCM == 0) {
          if (((String)localObject).endsWith("2")) {
            this.supportSSCM = 2;
          } else {
            this.supportSSCM = 1;
          }
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("initSSCMCfgStr: ");
          localStringBuilder.append(this.supportSSCM);
          QLog.d("PttOptimizeParams", 2, localStringBuilder.toString());
        }
        if (this.supportActivateNet == 0) {
          if (((String)localObject).endsWith("3")) {
            this.supportActivateNet = 2;
          } else {
            this.supportActivateNet = 1;
          }
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("initActivateNet: ");
          localStringBuilder.append(this.supportActivateNet);
          QLog.d("PttOptimizeParams", 2, localStringBuilder.toString());
        }
        if (this.supportHttpSideWay == 0) {
          if (paramAppRuntime.getCurrentAccountUin().endsWith("5")) {
            this.supportHttpSideWay = 2;
          } else {
            this.supportHttpSideWay = 1;
          }
        }
        if (QLog.isColorLevel())
        {
          paramAppRuntime = new StringBuilder();
          paramAppRuntime.append("initHttpSideWay: ");
          paramAppRuntime.append(this.supportHttpSideWay);
          QLog.d("PttOptimizeParams", 2, paramAppRuntime.toString());
        }
        if (this.sPreSendSwitch == 0) {
          if (((String)localObject).endsWith("4")) {
            this.sPreSendSwitch = 2;
          } else {
            this.sPreSendSwitch = 1;
          }
        }
        if (QLog.isColorLevel())
        {
          paramAppRuntime = new StringBuilder();
          paramAppRuntime.append("sPreSendSwitch: ");
          paramAppRuntime.append(this.sPreSendSwitch);
          QLog.d("PttOptimizeParams", 2, paramAppRuntime.toString());
        }
      }
      catch (Exception paramAppRuntime)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initOptimizeCfg exception: ");
          ((StringBuilder)localObject).append(paramAppRuntime);
          QLog.d("PttOptimizeParams", 2, ((StringBuilder)localObject).toString());
        }
        this.supportDirectDownload = 1;
        this.supportSSCM = 1;
        this.tryTime = 480000;
        this.tryCount = 9;
        this.fixScheduleTryCount = 3;
        this.supportActivateNet = 1;
        this.supportHttpSideWay = 1;
        this.sPreSendSwitch = 1;
      }
      return;
    }
    finally {}
  }
  
  public void savePttOptimizeCfg(AppRuntime paramAppRuntime, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordParams_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putString("ptt_optimize_cfg_v2", paramString).commit();
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("savePttOptimizeCfg: ");
      paramAppRuntime.append(paramString);
      QLog.d("PttOptimizeParams", 2, paramAppRuntime.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.api.impl.PttOptimizeParamsImpl
 * JD-Core Version:    0.7.0.1
 */