package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserInteractiveStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserInteractiveStorageRsp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class GetUserInteractiveStorageRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_cloudstorage.GetUserInteractiveStorage";
  public static final String TAG = "GetUserInteractiveStorageRequest";
  private static final String unikey = "GetUserInteractiveStorageRequest";
  private CloudStorage.StGetUserInteractiveStorageReq req = new CloudStorage.StGetUserInteractiveStorageReq();
  
  public GetUserInteractiveStorageRequest(COMM.StCommonExt paramStCommonExt, String paramString, String[] paramArrayOfString)
  {
    if (paramStCommonExt != null) {
      this.req.ext.set(paramStCommonExt);
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramStCommonExt = paramArrayOfString[i];
      this.req.keyList.add(paramStCommonExt);
      i += 1;
    }
    this.req.appid.set(paramString);
  }
  
  public static CloudStorage.StGetUserInteractiveStorageRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new CloudStorage.StGetUserInteractiveStorageRsp();
    try
    {
      ((CloudStorage.StGetUserInteractiveStorageRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("GetUserInteractiveStorageRequest", 2, ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetUserInteractiveStorageRequest
 * JD-Core Version:    0.7.0.1
 */