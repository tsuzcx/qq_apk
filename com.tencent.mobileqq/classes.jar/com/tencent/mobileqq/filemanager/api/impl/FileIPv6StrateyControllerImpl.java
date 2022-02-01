package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.DomainInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPListInfo;
import com.tencent.mobileqq.filemanager.core.QQFileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import java.util.List;

public class FileIPv6StrateyControllerImpl
  implements IFileIPv6StrateyController
{
  private QQFileIPv6StrateyController controller = new QQFileIPv6StrateyController();
  
  public FileIPv6StrateyControllerImpl()
  {
    this.controller.a();
  }
  
  public int debugGetLocalConfigIPv6Strategy()
  {
    return this.controller.h();
  }
  
  public boolean debugIsLocalConfigEnableC2CIPv6()
  {
    return this.controller.d();
  }
  
  public boolean debugIsLocalConfigEnableDatalineIPv6()
  {
    return this.controller.g();
  }
  
  public boolean debugIsLocalConfigEnableDiscIPv6()
  {
    return this.controller.f();
  }
  
  public boolean debugIsLocalConfigEnableGroupIPv6()
  {
    return this.controller.e();
  }
  
  public boolean debugIsUseLocalConfig()
  {
    return this.controller.c();
  }
  
  public void debugSetLocalConfigEnableC2CIPv6(boolean paramBoolean)
  {
    this.controller.b(paramBoolean);
  }
  
  public void debugSetLocalConfigEnableDatalineIPv6(boolean paramBoolean)
  {
    this.controller.e(paramBoolean);
  }
  
  public void debugSetLocalConfigEnableDiscIPv6(boolean paramBoolean)
  {
    this.controller.d(paramBoolean);
  }
  
  public void debugSetLocalConfigEnableGroupIPv6(boolean paramBoolean)
  {
    this.controller.c(paramBoolean);
  }
  
  public void debugSetLocalConfigIPv6Strategy(int paramInt)
  {
    this.controller.a(paramInt);
  }
  
  public void debugSetUseLocalConfig(boolean paramBoolean)
  {
    this.controller.a(paramBoolean);
  }
  
  public List<ExcitingTransferHostInfo> getIPV6listForExcitingUpload(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    return this.controller.a(paramBaseQQAppInterface, paramInt);
  }
  
  public List<String> getIPV6listForMediaPlatfrom(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, List<String> paramList)
  {
    return this.controller.a(paramBaseQQAppInterface, paramInt, paramList);
  }
  
  public FileIPv6StrateyController.IPListInfo getIPlistForV6Domain(BaseQQAppInterface paramBaseQQAppInterface, FileIPv6StrateyController.DomainInfo paramDomainInfo, int paramInt)
  {
    return this.controller.a(paramBaseQQAppInterface, paramDomainInfo, paramInt);
  }
  
  public boolean isConfigEnableIPV6(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    return this.controller.b(paramBaseQQAppInterface, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.FileIPv6StrateyControllerImpl
 * JD-Core Version:    0.7.0.1
 */