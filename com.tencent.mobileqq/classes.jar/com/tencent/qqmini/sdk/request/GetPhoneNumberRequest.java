package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StGetPhoneNumberReq;
import NS_MINI_INTERFACE.INTERFACE.StGetPhoneNumberRsp;
import NS_MINI_INTERFACE.INTERFACE.StPhoneNumber;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetPhoneNumberRequest
  extends ProtoBufRequest
{
  private INTERFACE.StGetPhoneNumberReq a = new INTERFACE.StGetPhoneNumberReq();
  
  public GetPhoneNumberRequest(String paramString)
  {
    this.a.appId.set(paramString);
  }
  
  protected byte[] getBusiBuf()
  {
    return this.a.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "AddPhoneNumber";
  }
  
  protected String getModule()
  {
    return "mini_user_info";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StGetPhoneNumberRsp localStGetPhoneNumberRsp = new INTERFACE.StGetPhoneNumberRsp();
    try
    {
      localStGetPhoneNumberRsp.mergeFrom(paramArrayOfByte);
      Object localObject = localStGetPhoneNumberRsp.phoneLists.get();
      paramArrayOfByte = new JSONArray();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          INTERFACE.StPhoneNumber localStPhoneNumber = (INTERFACE.StPhoneNumber)((Iterator)localObject).next();
          if (localStPhoneNumber != null)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("phoneType", localStPhoneNumber.phoneType.get());
            localJSONObject.put("purePhoneNumber", localStPhoneNumber.purePhoneNumber.get());
            localJSONObject.put("countryCode", localStPhoneNumber.countryCode.get());
            localJSONObject.put("iv", localStPhoneNumber.iv.get());
            localJSONObject.put("encryptedData", localStPhoneNumber.encryptedData.get());
            paramArrayOfByte.put(localJSONObject);
          }
        }
      }
      paramJSONObject.put("countryCode", localStGetPhoneNumberRsp.countryCode.get());
      paramJSONObject.put("purePhoneNumber", localStGetPhoneNumberRsp.purePhoneNumber.get());
      paramJSONObject.put("iv", localStGetPhoneNumberRsp.iv.get());
      paramJSONObject.put("encryptedData", localStGetPhoneNumberRsp.encryptedData.get());
      paramJSONObject.put("cloudID", "");
      paramJSONObject.put("phoneLists", paramArrayOfByte);
      paramJSONObject.put("errMsg", "ok");
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("getPhoneNumberRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetPhoneNumberRequest
 * JD-Core Version:    0.7.0.1
 */