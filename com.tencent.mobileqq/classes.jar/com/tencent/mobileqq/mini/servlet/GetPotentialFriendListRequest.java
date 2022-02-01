package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetPotentialFriendListReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetPotentialFriendListRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class GetPotentialFriendListRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_cloudstorage.GetPotentialFriendList";
  public static final String TAG = "GetPotentialFriendListRequest";
  private static final String unikey = "GetPotentialFriendListRequest";
  private CloudStorage.StGetPotentialFriendListReq req = new CloudStorage.StGetPotentialFriendListReq();
  
  public GetPotentialFriendListRequest(COMM.StCommonExt paramStCommonExt, String paramString)
  {
    if (paramStCommonExt != null) {
      this.req.ext.set(paramStCommonExt);
    }
    this.req.appid.set(paramString);
  }
  
  public static CloudStorage.StGetPotentialFriendListRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new CloudStorage.StGetPotentialFriendListRsp();
    try
    {
      ((CloudStorage.StGetPotentialFriendListRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("GetPotentialFriendListRequest", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetPotentialFriendListRequest
 * JD-Core Version:    0.7.0.1
 */