package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_MISC.MISC.StGetFriendPlayListV2Req;
import NS_MINI_APP_MISC.MISC.StGetFriendPlayListV2Rsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class GetFriendPlayListV2Request
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.GetFriendPlayListV2Request";
  private MISC.StGetFriendPlayListV2Req req = new MISC.StGetFriendPlayListV2Req();
  
  public GetFriendPlayListV2Request(COMM.StCommonExt paramStCommonExt, String paramString, int paramInt)
  {
    this.req.friendUin.set(paramString);
    this.req.pageSize.set(paramInt);
    if (paramStCommonExt != null) {
      this.req.ext.set(paramStCommonExt);
    }
    QLog.d("ProtoBufRequest", 1, new Object[] { "MiniAppSummaryCard GetFriendPlayListV2Request friendUin:", paramString, " pageSize:", Integer.valueOf(paramInt) });
  }
  
  public static MISC.StGetFriendPlayListV2Rsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new MISC.StGetFriendPlayListV2Rsp();
    try
    {
      ((MISC.StGetFriendPlayListV2Rsp)localObject).mergeFrom(decode(paramArrayOfByte));
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetFriendPlayListV2Request
 * JD-Core Version:    0.7.0.1
 */