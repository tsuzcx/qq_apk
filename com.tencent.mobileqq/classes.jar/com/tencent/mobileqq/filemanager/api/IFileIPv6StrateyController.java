package com.tencent.mobileqq.filemanager.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.DomainInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPListInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IFileIPv6StrateyController
  extends QRouteApi
{
  public abstract int debugGetLocalConfigIPv6Strategy();
  
  public abstract boolean debugIsLocalConfigEnableC2CIPv6();
  
  public abstract boolean debugIsLocalConfigEnableDatalineIPv6();
  
  public abstract boolean debugIsLocalConfigEnableDiscIPv6();
  
  public abstract boolean debugIsLocalConfigEnableGroupIPv6();
  
  public abstract boolean debugIsUseLocalConfig();
  
  public abstract void debugSetLocalConfigEnableC2CIPv6(boolean paramBoolean);
  
  public abstract void debugSetLocalConfigEnableDatalineIPv6(boolean paramBoolean);
  
  public abstract void debugSetLocalConfigEnableDiscIPv6(boolean paramBoolean);
  
  public abstract void debugSetLocalConfigEnableGroupIPv6(boolean paramBoolean);
  
  public abstract void debugSetLocalConfigIPv6Strategy(int paramInt);
  
  public abstract void debugSetUseLocalConfig(boolean paramBoolean);
  
  public abstract List<ExcitingTransferHostInfo> getIPV6listForExcitingUpload(BaseQQAppInterface paramBaseQQAppInterface, int paramInt);
  
  public abstract List<String> getIPV6listForMediaPlatfrom(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, List<String> paramList);
  
  public abstract FileIPv6StrateyController.IPListInfo getIPlistForV6Domain(BaseQQAppInterface paramBaseQQAppInterface, FileIPv6StrateyController.DomainInfo paramDomainInfo, int paramInt);
  
  public abstract boolean isConfigEnableIPV6(BaseQQAppInterface paramBaseQQAppInterface, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController
 * JD-Core Version:    0.7.0.1
 */