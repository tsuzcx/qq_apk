package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StInteractiveTemplate;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashMap;
import org.json.JSONObject;

public class ModifyFriendInteractiveStorageRequest
  extends ProtoBufRequest
{
  private static final String TAG = "ModifyFriendInteractiveStorageRequest";
  private CloudStorage.StModifyFriendInteractiveStorageReq req;
  
  public ModifyFriendInteractiveStorageRequest(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, HashMap<String, String> paramHashMap, boolean paramBoolean, CloudStorage.StInteractiveTemplate paramStInteractiveTemplate) {}
  
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
      paramJSONObject.put("response", localStModifyFriendInteractiveStorageRsp);
      paramJSONObject.put("resultCode", 0);
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("ModifyFriendInteractiveStorageRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.ModifyFriendInteractiveStorageRequest
 * JD-Core Version:    0.7.0.1
 */