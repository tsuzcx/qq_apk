package com.tencent.qqmini.sdk.request;

import NS_MINI_CLOUDSTORAGE.CloudStorage.FriendInfo;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetReactiveFriendListReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetReactiveFriendListRsp;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetReactiveFriendListRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_cloudstorage.GetReactiveFriendList";
  public static final String KEY_RESULT_DATA = "key_result_data";
  public static final String TAG = "GetReactiveFriendListRequest";
  private CloudStorage.StGetReactiveFriendListReq req = new CloudStorage.StGetReactiveFriendListReq();
  
  public GetReactiveFriendListRequest(String paramString)
  {
    this.req.appid.set(paramString);
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetReactiveFriendList";
  }
  
  public String getCmdString()
  {
    return "LightAppSvc.mini_app_cloudstorage.GetReactiveFriendList";
  }
  
  protected String getModule()
  {
    return "mini_app_cloudstorage";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      try
      {
        Object localObject = new CloudStorage.StGetReactiveFriendListRsp();
        ((CloudStorage.StGetReactiveFriendListRsp)localObject).mergeFrom(paramArrayOfByte);
        localObject = ((CloudStorage.StGetReactiveFriendListRsp)localObject).list.get();
        paramArrayOfByte = paramJSONObject;
        if (localObject != null)
        {
          paramArrayOfByte = paramJSONObject;
          if (((List)localObject).size() > 0)
          {
            paramArrayOfByte = new JSONArray();
            int i = 0;
            for (;;)
            {
              int j = ((List)localObject).size();
              if (i < j) {
                try
                {
                  JSONObject localJSONObject = new JSONObject();
                  localJSONObject.putOpt("avatarUrl", ((CloudStorage.FriendInfo)((List)localObject).get(i)).avatarUrl.get());
                  localJSONObject.putOpt("nickname", ((CloudStorage.FriendInfo)((List)localObject).get(i)).nickname.get());
                  localJSONObject.putOpt("openid", ((CloudStorage.FriendInfo)((List)localObject).get(i)).openid.get());
                  paramArrayOfByte.put(localJSONObject);
                  i += 1;
                }
                catch (Throwable localThrowable)
                {
                  for (;;)
                  {
                    QMLog.i("GetReactiveFriendListRequest", "", localThrowable);
                  }
                }
              }
            }
            paramJSONObject.putOpt("key_result_data", paramArrayOfByte);
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QMLog.e("GetReactiveFriendListRequest", "onResponse fail." + paramArrayOfByte);
        return null;
      }
    }
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetReactiveFriendListRequest
 * JD-Core Version:    0.7.0.1
 */