package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_STORE_APP_SEARCH.MiniAppSearch.StGetHotSearchAppsReq;
import NS_STORE_APP_SEARCH.MiniAppSearch.StGetHotSearchAppsRsp;
import com.tencent.qphone.base.util.QLog;

public class GetHotSearchAppsRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.store_app_search.GetHotSearchApps";
  private static final String TAG = "GetHotSearchAppsRequest";
  private MiniAppSearch.StGetHotSearchAppsReq req = new MiniAppSearch.StGetHotSearchAppsReq();
  
  public GetHotSearchAppsRequest(COMM.StCommonExt paramStCommonExt)
  {
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static MiniAppSearch.StGetHotSearchAppsRsp onResponse(byte[] paramArrayOfByte)
  {
    MiniAppSearch.StGetHotSearchAppsRsp localStGetHotSearchAppsRsp = new MiniAppSearch.StGetHotSearchAppsRsp();
    try
    {
      localStGetHotSearchAppsRsp.mergeFrom(decode(paramArrayOfByte));
      return localStGetHotSearchAppsRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GetHotSearchAppsRequest", 2, "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetHotSearchAppsRequest
 * JD-Core Version:    0.7.0.1
 */