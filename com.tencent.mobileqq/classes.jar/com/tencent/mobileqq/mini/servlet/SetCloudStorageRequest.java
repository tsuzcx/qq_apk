package com.tencent.mobileqq.mini.servlet;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StKVData;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StSetUserCloudStorageReq;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SetCloudStorageRequest
  extends ProtoBufRequest
{
  private CloudStorage.StSetUserCloudStorageReq req = new CloudStorage.StSetUserCloudStorageReq();
  
  public SetCloudStorageRequest(HashMap<String, String> paramHashMap, String paramString)
  {
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      CloudStorage.StKVData localStKVData = new CloudStorage.StKVData();
      localStKVData.key.set((String)localEntry.getKey());
      localStKVData.value.set((String)localEntry.getValue());
      this.req.KVDataList.add(localStKVData);
    }
    this.req.appid.set(paramString);
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.SetCloudStorageRequest
 * JD-Core Version:    0.7.0.1
 */