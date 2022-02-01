package com.tencent.mobileqq.mini.servlet;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetGroupCloudStorageReq;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public class GetGroupCloudStorageRequest
  extends ProtoBufRequest
{
  private CloudStorage.StGetGroupCloudStorageReq req = new CloudStorage.StGetGroupCloudStorageReq();
  
  public GetGroupCloudStorageRequest(String[] paramArrayOfString, String paramString1, String paramString2)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      this.req.keyList.add(str);
      i += 1;
    }
    this.req.appid.set(paramString2);
    this.req.shareTicket.set(paramString1);
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetGroupCloudStorageRequest
 * JD-Core Version:    0.7.0.1
 */