package com.tencent.qzonehub.api.impl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneRuntimeService;
import com.tencent.qzonehub.api.contentbox.IMQMsg;
import com.tencent.qzonehub.model.QZoneMsgEntityNew;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.contentbox.QZoneMsgManager;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class QzoneRuntimeServiceImpl
  implements IQzoneRuntimeService
{
  private volatile Boolean isContentBoxEnable = null;
  private QZoneMsgManager msgManager = null;
  private AppRuntime runtime;
  
  private void initMsgManager()
  {
    if (this.msgManager == null) {
      this.msgManager = new QZoneMsgManager(this.runtime);
    }
  }
  
  public boolean isEnableQZoneContextBox()
  {
    AppRuntime localAppRuntime = this.runtime;
    if (localAppRuntime == null) {
      return false;
    }
    long l = localAppRuntime.getLongAccountUin();
    for (;;)
    {
      try
      {
        if (this.isContentBoxEnable == null)
        {
          bool = true;
          if ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, l) & 0x80) != 0) {
            this.isContentBoxEnable = Boolean.valueOf(bool);
          }
        }
        else
        {
          bool = this.isContentBoxEnable.booleanValue();
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QZoneMsgManager.enableQZoneContextBox", 2, localThrowable, new Object[0]);
        return false;
      }
      boolean bool = false;
    }
  }
  
  public void likeFeed(String paramString, int paramInt, boolean paramBoolean, long paramLong)
  {
    QZoneMsgManager localQZoneMsgManager = this.msgManager;
    if (localQZoneMsgManager != null) {
      localQZoneMsgManager.likeFeed(paramString, paramInt, paramBoolean, paramLong);
    }
  }
  
  public ArrayList<QZoneMsgEntityNew> loadMsgFromDB()
  {
    QZoneMsgManager localQZoneMsgManager = this.msgManager;
    if (localQZoneMsgManager != null) {
      return localQZoneMsgManager.loadMsgFromDB();
    }
    return new ArrayList();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.runtime = paramAppRuntime;
    initMsgManager();
  }
  
  public void onDestroy()
  {
    this.runtime = null;
    QZoneMsgManager localQZoneMsgManager = this.msgManager;
    if (localQZoneMsgManager != null) {
      localQZoneMsgManager.onDestroy();
    }
    this.msgManager = null;
  }
  
  public void preloadContentBox()
  {
    QZoneMsgManager localQZoneMsgManager = this.msgManager;
    if (localQZoneMsgManager != null) {
      localQZoneMsgManager.preLoadQZoneMsg();
    }
  }
  
  public void refreshQzoneMsg()
  {
    QZoneMsgManager localQZoneMsgManager = this.msgManager;
    if (localQZoneMsgManager != null) {
      localQZoneMsgManager.refreshQZoneMsg();
    }
  }
  
  public void saveMsgToDB(IMQMsg paramIMQMsg)
  {
    QZoneMsgManager localQZoneMsgManager = this.msgManager;
    if (localQZoneMsgManager != null) {
      localQZoneMsgManager.saveMsgToDB(paramIMQMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzoneRuntimeServiceImpl
 * JD-Core Version:    0.7.0.1
 */