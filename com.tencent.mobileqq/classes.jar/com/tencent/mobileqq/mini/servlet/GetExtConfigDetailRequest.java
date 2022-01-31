package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StExtConfigInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetExtConfigDetailReq;
import NS_MINI_INTERFACE.INTERFACE.StGetExtConfigDetailRsp;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GetExtConfigDetailRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_info.GetExtConfigDetail";
  private static final String TAG = "GetExtConfigDetailRequest";
  private INTERFACE.StGetExtConfigDetailReq req = new INTERFACE.StGetExtConfigDetailReq();
  
  public GetExtConfigDetailRequest(COMM.StCommonExt paramStCommonExt, List<INTERFACE.StExtConfigInfo> paramList)
  {
    this.req.extInfo = paramStCommonExt;
    this.req.configs.set(paramList);
  }
  
  public static INTERFACE.StGetExtConfigDetailRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StGetExtConfigDetailRsp localStGetExtConfigDetailRsp = new INTERFACE.StGetExtConfigDetailRsp();
    try
    {
      localStGetExtConfigDetailRsp.mergeFrom(decode(paramArrayOfByte));
      return localStGetExtConfigDetailRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("GetExtConfigDetailRequest", 1, "onResponse fail.", paramArrayOfByte);
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetExtConfigDetailRequest
 * JD-Core Version:    0.7.0.1
 */