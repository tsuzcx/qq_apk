package com.tencent.mobileqq.filemanager.excitingtransfer;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qfile.IExcitingC2CDownloadConfig;
import com.tencent.mobileqq.config.business.qfile.IExcitingC2CUploadConfig;
import com.tencent.mobileqq.config.business.qfile.IExcitingGroupDownloadConfig;
import com.tencent.mobileqq.config.business.qfile.IExcitingGroupUploadConfig;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcitingTransferAdapter
{
  private static ExcitingTransferAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingTransferAdapter;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public static ExcitingTransferAdapter a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingTransferAdapter == null) {
        jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingTransferAdapter = new ExcitingTransferAdapter();
      }
      ExcitingTransferAdapter localExcitingTransferAdapter = jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingTransferAdapter;
      return localExcitingTransferAdapter;
    }
    finally {}
  }
  
  public long a()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingC2CUploadConfig() != null) {
      return localIQFileConfigManager.getExcitingC2CUploadConfig().a();
    }
    return 20971520L;
  }
  
  public ExcitingTransferDownloadConfig a()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingC2CDownloadConfig() != null) {
      return localIQFileConfigManager.getExcitingC2CDownloadConfig().a();
    }
    return new ExcitingTransferDownloadConfig();
  }
  
  public ExcitingTransferUploadChnConfigInfo a()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingC2CUploadConfig() != null) {
      return localIQFileConfigManager.getExcitingC2CUploadConfig().a();
    }
    return new ExcitingTransferUploadChnConfigInfo();
  }
  
  public List<ExcitingTransferHostInfo> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ConfigManager.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine());
    if (localObject1 != null)
    {
      Object localObject2 = ((ConfigManager)localObject1).getIpList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), paramBoolean);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          EndPoint localEndPoint = (EndPoint)((Iterator)localObject2).next();
          if ((localEndPoint != null) && (!TextUtils.isEmpty(localEndPoint.host))) {
            if (paramBoolean) {
              localArrayList.add(new ExcitingTransferHostInfo("[" + localEndPoint.host + "]", localEndPoint.port));
            } else {
              localArrayList.add(new ExcitingTransferHostInfo(localEndPoint.host, localEndPoint.port));
            }
          }
        }
      }
      if (localArrayList.size() == 0)
      {
        localObject1 = ((ConfigManager)localObject1).getNextSrvAddr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBoolean);
        if ((localObject1 != null) && (!TextUtils.isEmpty(((EndPoint)localObject1).host)))
        {
          if (!paramBoolean) {
            break label328;
          }
          if (!IPAddressUtil.isIPv6LiteralAddress(((EndPoint)localObject1).host)) {
            break label304;
          }
          localArrayList.add(new ExcitingTransferHostInfo("[" + ((EndPoint)localObject1).host + "]", ((EndPoint)localObject1).port));
        }
      }
    }
    return localArrayList;
    label304:
    localArrayList.add(new ExcitingTransferHostInfo(((EndPoint)localObject1).host, ((EndPoint)localObject1).port));
    return localArrayList;
    label328:
    localArrayList.add(new ExcitingTransferHostInfo(((EndPoint)localObject1).host, ((EndPoint)localObject1).port));
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public boolean a()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingC2CUploadConfig() != null) {
      return localIQFileConfigManager.getExcitingC2CUploadConfig().a();
    }
    return false;
  }
  
  public long b()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingC2CDownloadConfig() != null) {
      return localIQFileConfigManager.getExcitingC2CDownloadConfig().a();
    }
    return 20971520L;
  }
  
  public ExcitingTransferDownloadConfig b()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingGroupDownloadConfig() != null) {
      return localIQFileConfigManager.getExcitingGroupDownloadConfig().a();
    }
    return new ExcitingTransferDownloadConfig();
  }
  
  public ExcitingTransferUploadChnConfigInfo b()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingGroupUploadConfig() != null) {
      return localIQFileConfigManager.getExcitingGroupUploadConfig().a();
    }
    return new ExcitingTransferUploadChnConfigInfo();
  }
  
  public boolean b()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingC2CDownloadConfig() != null) {
      return localIQFileConfigManager.getExcitingC2CDownloadConfig().a();
    }
    return false;
  }
  
  public long c()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingGroupUploadConfig() != null) {
      return localIQFileConfigManager.getExcitingGroupUploadConfig().a();
    }
    return 20971520L;
  }
  
  public boolean c()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingGroupUploadConfig() != null) {
      return localIQFileConfigManager.getExcitingGroupUploadConfig().a();
    }
    return false;
  }
  
  public long d()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingGroupDownloadConfig() != null) {
      return localIQFileConfigManager.getExcitingGroupDownloadConfig().a();
    }
    return 20971520L;
  }
  
  public boolean d()
  {
    IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
    if (localIQFileConfigManager.getExcitingGroupDownloadConfig() != null) {
      return localIQFileConfigManager.getExcitingGroupDownloadConfig().a();
    }
    return false;
  }
  
  public long e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
  }
  
  @Deprecated
  public boolean e()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.ExcitingTransferAdapter
 * JD-Core Version:    0.7.0.1
 */