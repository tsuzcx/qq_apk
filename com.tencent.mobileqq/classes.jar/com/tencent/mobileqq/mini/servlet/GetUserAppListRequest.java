package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetUserAppListReq;
import NS_MINI_INTERFACE.INTERFACE.StGetUserAppListRsp;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;

public class GetUserAppListRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.GetUserAppList";
  private INTERFACE.StGetUserAppListReq req = new INTERFACE.StGetUserAppListReq();
  
  public GetUserAppListRequest(COMM.StCommonExt paramStCommonExt, long paramLong1, long paramLong2)
  {
    this.req.uin.set(paramLong1);
    this.req.num.set(paramLong2);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    QLog.d("ProtoBufRequest", 1, new Object[] { "MiniAppSummaryCard GetFriendPlayListV2Request uin:", Long.valueOf(paramLong1), " num:", Long.valueOf(paramLong2) });
  }
  
  public static INTERFACE.StGetUserAppListRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StGetUserAppListRsp();
    try
    {
      ((INTERFACE.StGetUserAppListRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("ProtoBufRequest", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetUserAppListRequest
 * JD-Core Version:    0.7.0.1
 */