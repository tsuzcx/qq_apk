package com.tencent.mobileqq.ptt;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DPCObserver;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import com.tencent.mobileqq.ptt.preop.PreDownloadParams;
import com.tencent.mobileqq.statistics.LightDpcConfig;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.RecordParams;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class PttConfigController
  implements DeviceProfileManager.DPCObserver, Manager
{
  private QQAppInterface a;
  
  public PttConfigController(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    String str = DeviceProfileManager.a(paramQQAppInterface).a(DeviceProfileManager.DpcNames.SilkCfg.name(), "null");
    if (!"null".equalsIgnoreCase(str))
    {
      RecordParams.a(paramQQAppInterface, str);
      RecordParams.a(paramQQAppInterface, true);
      str = DeviceProfileManager.a(paramQQAppInterface).a(DeviceProfileManager.DpcNames.StreamCfg.name(), "null");
      if ("null".equalsIgnoreCase(str)) {
        break label161;
      }
      StreamParams.a(paramQQAppInterface, str);
      StreamParams.a(paramQQAppInterface, true);
    }
    for (;;)
    {
      paramQQAppInterface = DeviceProfileManager.a(paramQQAppInterface).a(DeviceProfileManager.DpcNames.aio_config.name(), "").split("\\|");
      if (paramQQAppInterface.length > 13)
      {
        boolean bool = "1".equals(paramQQAppInterface[12]);
        SyncService.b(BaseApplicationImpl.sApplication, bool);
        if (paramQQAppInterface.length > 14)
        {
          bool = "1".equals(paramQQAppInterface[13]);
          LightDpcConfig.a(BaseApplicationImpl.sApplication, bool);
        }
      }
      DeviceProfileManager.a(this);
      return;
      RecordParams.a(paramQQAppInterface, false);
      break;
      label161:
      StreamParams.a(paramQQAppInterface, false);
    }
  }
  
  public void a(String paramString)
  {
    QQAppInterface localQQAppInterface = this.a;
    NetworkCenter.a();
    if (localQQAppInterface != null)
    {
      StreamParams.b(localQQAppInterface, paramString);
      StreamParams.b(localQQAppInterface, true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.a;
    if ((localObject != null) && (paramBoolean))
    {
      RecordParams.a((QQAppInterface)localObject, DeviceProfileManager.a((AppRuntime)localObject).a(DeviceProfileManager.DpcNames.SilkCfg.name(), ""));
      RecordParams.a((QQAppInterface)localObject, true);
      StreamParams.a((QQAppInterface)localObject, DeviceProfileManager.a((AppRuntime)localObject).a(DeviceProfileManager.DpcNames.StreamCfg.name(), ""));
      StreamParams.a((QQAppInterface)localObject, true);
      localObject = DeviceProfileManager.a((AppRuntime)localObject).a(DeviceProfileManager.DpcNames.aio_config.name(), "").split("\\|");
      if (localObject.length > 13)
      {
        paramBoolean = "1".equals(localObject[12]);
        SyncService.b(BaseApplicationImpl.sApplication, paramBoolean);
        if (localObject.length > 14)
        {
          paramBoolean = "1".equals(localObject[13]);
          LightDpcConfig.a(BaseApplicationImpl.sApplication, paramBoolean);
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      PttOptimizeParams.a(localQQAppInterface, paramString);
      PttOptimizeParams.a(localQQAppInterface, true);
    }
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    NetworkCenter.a();
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      PreDownloadParams.a(localQQAppInterface, paramString);
      PreDownloadParams.a(localQQAppInterface, true);
    }
  }
  
  public void onDestroy()
  {
    PreDownloadParams.a();
    DeviceProfileManager.b(this);
    RecordParams.a();
    StreamParams.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.PttConfigController
 * JD-Core Version:    0.7.0.1
 */