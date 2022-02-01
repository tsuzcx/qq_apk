package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StInteractiveTemplate;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StKVData;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class ModifyFriendInteractiveStorageRequest
  extends ProtoBufRequest
{
  private static final String TAG = "ModifyFriendInteractiveStorageRequest";
  private CloudStorage.StModifyFriendInteractiveStorageReq req = new CloudStorage.StModifyFriendInteractiveStorageReq();
  
  public ModifyFriendInteractiveStorageRequest(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, HashMap<String, String> paramHashMap, boolean paramBoolean, CloudStorage.StInteractiveTemplate paramStInteractiveTemplate)
  {
    if (paramStCommonExt != null) {
      this.req.ext.set(paramStCommonExt);
    }
    this.req.appid.set(paramString1);
    this.req.toUser.set(paramString2);
    this.req.shareId.set(paramString3);
    this.req.opNum.set(paramInt);
    this.req.operation.set(paramString4);
    paramStCommonExt = this.req.quiet;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramStCommonExt.set(paramInt);
      this.req.desc.set(paramStInteractiveTemplate);
      paramStCommonExt = paramHashMap.entrySet().iterator();
      while (paramStCommonExt.hasNext())
      {
        paramString1 = (Map.Entry)paramStCommonExt.next();
        paramString2 = new CloudStorage.StKVData();
        paramString2.key.set((String)paramString1.getKey());
        paramString2.value.set((String)paramString1.getValue());
        this.req.KVDataList.add(paramString2);
      }
    }
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "ModifyFriendInteractiveStorage";
  }
  
  protected String getModule()
  {
    return "mini_app_cloudstorage";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    CloudStorage.StModifyFriendInteractiveStorageRsp localStModifyFriendInteractiveStorageRsp = new CloudStorage.StModifyFriendInteractiveStorageRsp();
    try
    {
      localStModifyFriendInteractiveStorageRsp.mergeFrom(paramArrayOfByte);
      if (localStModifyFriendInteractiveStorageRsp != null)
      {
        paramJSONObject.put("response", localStModifyFriendInteractiveStorageRsp);
        paramJSONObject.put("resultCode", 0);
        return paramJSONObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("ModifyFriendInteractiveStorageRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    QMLog.d("ModifyFriendInteractiveStorageRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.ModifyFriendInteractiveStorageRequest
 * JD-Core Version:    0.7.0.1
 */