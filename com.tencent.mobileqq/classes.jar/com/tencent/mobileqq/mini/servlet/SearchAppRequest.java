package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_STORE_APP_SEARCH.MiniAppSearch.StSearchAppReq;
import NS_STORE_APP_SEARCH.MiniAppSearch.StSearchAppRsp;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class SearchAppRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.store_app_search.SearchApp";
  private static final String TAG = "SearchAppRequest";
  private MiniAppSearch.StSearchAppReq req = new MiniAppSearch.StSearchAppReq();
  
  public SearchAppRequest(COMM.StCommonExt paramStCommonExt, String paramString)
  {
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    this.req.query.set(paramString);
    this.req.from.set(1);
  }
  
  public static MiniAppSearch.StSearchAppRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new MiniAppSearch.StSearchAppRsp();
    try
    {
      ((MiniAppSearch.StSearchAppRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResponse fail.");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.e("SearchAppRequest", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.SearchAppRequest
 * JD-Core Version:    0.7.0.1
 */