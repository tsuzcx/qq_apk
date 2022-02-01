package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetReactiveFriendListReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetReactiveFriendListRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class GetReactiveFriendListRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_cloudstorage.GetReactiveFriendList";
  public static final String TAG = "GetReactiveFriendListRequest";
  private static final String unikey = "GetReactiveFriendListRequest";
  private CloudStorage.StGetReactiveFriendListReq req = new CloudStorage.StGetReactiveFriendListReq();
  
  public GetReactiveFriendListRequest(COMM.StCommonExt paramStCommonExt, String paramString)
  {
    if (paramStCommonExt != null) {
      this.req.ext.set(paramStCommonExt);
    }
    this.req.appid.set(paramString);
  }
  
  public static CloudStorage.StGetReactiveFriendListRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new CloudStorage.StGetReactiveFriendListRsp();
    try
    {
      ((CloudStorage.StGetReactiveFriendListRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("GetReactiveFriendListRequest", 2, ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetReactiveFriendListRequest
 * JD-Core Version:    0.7.0.1
 */