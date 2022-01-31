package com.tencent.mobileqq.mini.servlet;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserCloudStorageReq;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public class GetCloudStorageRequest
  extends ProtoBufRequest
{
  private CloudStorage.StGetUserCloudStorageReq req = new CloudStorage.StGetUserCloudStorageReq();
  
  public GetCloudStorageRequest(String[] paramArrayOfString, String paramString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      this.req.keyList.add(str);
      i += 1;
    }
    this.req.appid.set(paramString);
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetCloudStorageRequest
 * JD-Core Version:    0.7.0.1
 */