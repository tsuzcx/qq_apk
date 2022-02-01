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
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new CloudStorage.StGetReactiveFriendListRsp();
        ((CloudStorage.StGetReactiveFriendListRsp)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((CloudStorage.StGetReactiveFriendListRsp)localObject).list.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
        {
          localObject = new JSONArray();
          i = 0;
          int j = paramArrayOfByte.size();
          if (i < j) {
            try
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.putOpt("avatarUrl", ((CloudStorage.FriendInfo)paramArrayOfByte.get(i)).avatarUrl.get());
              localJSONObject.putOpt("nickname", ((CloudStorage.FriendInfo)paramArrayOfByte.get(i)).nickname.get());
              localJSONObject.putOpt("openid", ((CloudStorage.FriendInfo)paramArrayOfByte.get(i)).openid.get());
              ((JSONArray)localObject).put(localJSONObject);
            }
            catch (Throwable localThrowable)
            {
              QMLog.i("GetReactiveFriendListRequest", "", localThrowable);
            }
          } else {
            paramJSONObject.putOpt("key_result_data", localObject);
          }
        }
        else
        {
          return paramJSONObject;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("onResponse fail.");
        paramJSONObject.append(paramArrayOfByte);
        QMLog.e("GetReactiveFriendListRequest", paramJSONObject.toString());
        return null;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetReactiveFriendListRequest
 * JD-Core Version:    0.7.0.1
 */