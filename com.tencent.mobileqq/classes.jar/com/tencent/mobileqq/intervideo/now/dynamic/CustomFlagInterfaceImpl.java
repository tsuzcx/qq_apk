package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.intervideo.nowproxy.CustomInterfaceLogic;
import com.tencent.qqinterface.CustomFlagInterface;

public class CustomFlagInterfaceImpl
  implements CustomFlagInterface
{
  public boolean isCustomBeaconReport()
  {
    return CustomInterfaceLogic.getsInstance().isBeaconReportCustomizedBySdk();
  }
  
  public boolean isCustomCGIReq()
  {
    return CustomInterfaceLogic.getsInstance().isCGIReqCustomizedBySdk();
  }
  
  public boolean isCustomCS()
  {
    return false;
  }
  
  public boolean isCustomCoverImg()
  {
    return CustomInterfaceLogic.getsInstance().isCustomCoverImg();
  }
  
  public boolean isCustomDownload()
  {
    return CustomInterfaceLogic.getsInstance().isDownLoadCustomizedBySdk();
  }
  
  public boolean isCustomLog()
  {
    return CustomInterfaceLogic.getsInstance().isLogCusomizedBySdk();
  }
  
  public boolean isCustomReport()
  {
    return CustomInterfaceLogic.getsInstance().isReportCustomizedBySDK();
  }
  
  public boolean isCustomWebview()
  {
    return CustomInterfaceLogic.getsInstance().isWebviewCusomizedBySdk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.CustomFlagInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */