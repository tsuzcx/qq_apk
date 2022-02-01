package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StAddressInfo;
import NS_MINI_INTERFACE.INTERFACE.StApiUserInfo;
import NS_MINI_INTERFACE.INTERFACE.StBatchGetUserInfoReq;
import NS_MINI_INTERFACE.INTERFACE.StBatchGetUserInfoRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class BatchGetUserInfoRequest
  extends ProtoBufRequest
{
  private static final String TAG = "BatchGetUserInfoRequest";
  private INTERFACE.StBatchGetUserInfoReq req = new INTERFACE.StBatchGetUserInfoReq();
  
  public BatchGetUserInfoRequest(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    this.req.appid.set(paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      this.req.lang.set(paramString2);
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramString1 = paramArrayOfString[i];
      this.req.openIds.add(paramString1);
      i += 1;
    }
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "BatchGetUserInfo";
  }
  
  protected String getModule()
  {
    return "mini_user_info";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    Object localObject = new INTERFACE.StBatchGetUserInfoRsp();
    ((INTERFACE.StBatchGetUserInfoRsp)localObject).mergeFrom(paramArrayOfByte);
    if ((localObject != null) && (((INTERFACE.StBatchGetUserInfoRsp)localObject).user != null))
    {
      localObject = ((INTERFACE.StBatchGetUserInfoRsp)localObject).user.get();
      paramArrayOfByte = new JSONArray();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        INTERFACE.StApiUserInfo localStApiUserInfo = (INTERFACE.StApiUserInfo)((Iterator)localObject).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("nickName", localStApiUserInfo.nick.get());
        localJSONObject.put("avatarUrl", localStApiUserInfo.avatar.get());
        localJSONObject.put("gender", localStApiUserInfo.gender.get());
        localJSONObject.put("language", localStApiUserInfo.language.get());
        localJSONObject.put("country", localStApiUserInfo.address.country.get());
        localJSONObject.put("province", localStApiUserInfo.address.province.get());
        localJSONObject.put("city", localStApiUserInfo.address.city.get());
        localJSONObject.put("openId", localStApiUserInfo.openid.get());
        paramArrayOfByte.put(localJSONObject);
      }
      paramJSONObject.put("data", paramArrayOfByte);
      return paramJSONObject;
    }
    QMLog.d("BatchGetUserInfoRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.BatchGetUserInfoRequest
 * JD-Core Version:    0.7.0.1
 */