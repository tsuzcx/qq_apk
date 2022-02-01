package com.tencent.mobileqq.ptt;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.ptt.preop.PreDownloadParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.LightDpcConfig;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.RecordParams;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.util.WeakReference;

public class PttConfigController
  implements DPCObserver, Manager
{
  private WeakReference<QQAppInterface> a;
  
  public PttConfigController(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.SilkCfg.name(), "null");
    if (!"null".equalsIgnoreCase(str))
    {
      RecordParams.a(paramQQAppInterface, str);
      RecordParams.a(paramQQAppInterface, true);
      str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.StreamCfg.name(), "null");
      if ("null".equalsIgnoreCase(str)) {
        break label196;
      }
      StreamParams.a(paramQQAppInterface, str);
      StreamParams.a(paramQQAppInterface, true);
    }
    for (;;)
    {
      paramQQAppInterface = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "").split("\\|");
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
      ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(this);
      return;
      RecordParams.a(paramQQAppInterface, false);
      break;
      label196:
      StreamParams.a(paramQQAppInterface, false);
    }
  }
  
  private QQAppInterface a()
  {
    if ((this.a == null) || (this.a.isEnqueued())) {
      return null;
    }
    return (QQAppInterface)this.a.get();
  }
  
  public void a(String paramString)
  {
    QQAppInterface localQQAppInterface = a();
    NetworkCenter.getInstance();
    if (localQQAppInterface != null)
    {
      StreamParams.b(localQQAppInterface, paramString);
      StreamParams.b(localQQAppInterface, true);
    }
  }
  
  public void b(String paramString)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      PttOptimizeParams.a(localQQAppInterface, paramString);
      PttOptimizeParams.a(localQQAppInterface, true);
    }
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    NetworkCenter.getInstance();
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      PreDownloadParams.a(localQQAppInterface, paramString);
      PreDownloadParams.a(localQQAppInterface, true);
    }
  }
  
  public void onDestroy()
  {
    this.a = null;
    PreDownloadParams.a();
    ((IDPCApi)QRoute.api(IDPCApi.class)).removeObserver(this);
    RecordParams.a();
    StreamParams.a();
  }
  
  public void onDpcPullFinished(boolean paramBoolean)
  {
    Object localObject = a();
    if ((localObject != null) && (paramBoolean))
    {
      RecordParams.a((AppRuntime)localObject, ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.SilkCfg.name(), ""));
      RecordParams.a((AppRuntime)localObject, true);
      StreamParams.a((QQAppInterface)localObject, ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.StreamCfg.name(), ""));
      StreamParams.a((QQAppInterface)localObject, true);
      localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "").split("\\|");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.PttConfigController
 * JD-Core Version:    0.7.0.1
 */