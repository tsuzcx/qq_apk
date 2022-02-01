package com.tencent.mobileqq.filemanager.excitingtransfer;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.business.qfile.IQFileExcitingC2CDownloadConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileExcitingC2CUploadConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileExcitingGroupDownloadConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileExcitingGroupUploadConfigBean;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class ExcitingTransferAdapter
{
  private AppRuntime a;
  
  public List<ExcitingTransferHostInfo> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ((AppInterface)this.a).getHwEngine();
    localObject1 = ConfigManager.getInstance(this.a.getApp().getBaseContext(), (HwEngine)localObject1);
    if (localObject1 != null)
    {
      Object localObject2 = ((ConfigManager)localObject1).getIpList(this.a.getApp().getBaseContext(), paramBoolean);
      Object localObject3;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (EndPoint)((Iterator)localObject2).next();
          if ((localObject3 != null) && (!TextUtils.isEmpty(((EndPoint)localObject3).host))) {
            if (paramBoolean)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("[");
              localStringBuilder.append(((EndPoint)localObject3).host);
              localStringBuilder.append("]");
              localArrayList.add(new ExcitingTransferHostInfo(localStringBuilder.toString(), ((EndPoint)localObject3).port));
            }
            else
            {
              localArrayList.add(new ExcitingTransferHostInfo(((EndPoint)localObject3).host, ((EndPoint)localObject3).port));
            }
          }
        }
      }
      if (localArrayList.size() == 0)
      {
        localObject2 = this.a.getApp().getBaseContext();
        localObject3 = this.a;
        localObject1 = ((ConfigManager)localObject1).getNextSrvAddr((Context)localObject2, (AppRuntime)localObject3, ((AppRuntime)localObject3).getCurrentAccountUin(), paramBoolean);
        if ((localObject1 != null) && (!TextUtils.isEmpty(((EndPoint)localObject1).host)))
        {
          if (paramBoolean)
          {
            if (IPAddressUtil.isIPv6LiteralAddress(((EndPoint)localObject1).host))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("[");
              ((StringBuilder)localObject2).append(((EndPoint)localObject1).host);
              ((StringBuilder)localObject2).append("]");
              localArrayList.add(new ExcitingTransferHostInfo(((StringBuilder)localObject2).toString(), ((EndPoint)localObject1).port));
              return localArrayList;
            }
            localArrayList.add(new ExcitingTransferHostInfo(((EndPoint)localObject1).host, ((EndPoint)localObject1).port));
            return localArrayList;
          }
          localArrayList.add(new ExcitingTransferHostInfo(((EndPoint)localObject1).host, ((EndPoint)localObject1).port));
        }
      }
    }
    return localArrayList;
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  public boolean a()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingC2CUploadConfig() != null) {
      return localIQFileConfigManager.getExcitingC2CUploadConfig().b();
    }
    return false;
  }
  
  public long b()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingC2CUploadConfig() != null) {
      return localIQFileConfigManager.getExcitingC2CUploadConfig().a();
    }
    return 20971520L;
  }
  
  public ExcitingTransferUploadChnConfigInfo c()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingC2CUploadConfig() != null) {
      return localIQFileConfigManager.getExcitingC2CUploadConfig().c();
    }
    return new ExcitingTransferUploadChnConfigInfo();
  }
  
  public boolean d()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingC2CDownloadConfig() != null) {
      return localIQFileConfigManager.getExcitingC2CDownloadConfig().b();
    }
    return false;
  }
  
  public long e()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingC2CDownloadConfig() != null) {
      return localIQFileConfigManager.getExcitingC2CDownloadConfig().a();
    }
    return 20971520L;
  }
  
  public ExcitingTransferDownloadConfig f()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingC2CDownloadConfig() != null) {
      return localIQFileConfigManager.getExcitingC2CDownloadConfig().c();
    }
    return new ExcitingTransferDownloadConfig();
  }
  
  public boolean g()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingGroupUploadConfig() != null) {
      return localIQFileConfigManager.getExcitingGroupUploadConfig().b();
    }
    return false;
  }
  
  public long h()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingGroupUploadConfig() != null) {
      return localIQFileConfigManager.getExcitingGroupUploadConfig().a();
    }
    return 20971520L;
  }
  
  public ExcitingTransferUploadChnConfigInfo i()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingGroupUploadConfig() != null) {
      return localIQFileConfigManager.getExcitingGroupUploadConfig().c();
    }
    return new ExcitingTransferUploadChnConfigInfo();
  }
  
  public boolean j()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingGroupDownloadConfig() != null) {
      return localIQFileConfigManager.getExcitingGroupDownloadConfig().b();
    }
    return false;
  }
  
  public long k()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingGroupDownloadConfig() != null) {
      return localIQFileConfigManager.getExcitingGroupDownloadConfig().a();
    }
    return 20971520L;
  }
  
  public ExcitingTransferDownloadConfig l()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingGroupDownloadConfig() != null) {
      return localIQFileConfigManager.getExcitingGroupDownloadConfig().c();
    }
    return new ExcitingTransferDownloadConfig();
  }
  
  @Deprecated
  public boolean m()
  {
    return false;
  }
  
  public void n()
  {
    this.a = null;
  }
  
  public long o()
  {
    AppRuntime localAppRuntime = this.a;
    if (localAppRuntime == null) {
      return 0L;
    }
    return localAppRuntime.getLongAccountUin();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.ExcitingTransferAdapter
 * JD-Core Version:    0.7.0.1
 */