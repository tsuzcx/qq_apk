package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StCurrChannelInfo;
import NS_MINI_INTERFACE.INTERFACE.StUseUserAppReq;
import NS_MINI_INTERFACE.INTERFACE.StUseUserAppRsp;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import org.json.JSONObject;

public class UseUserAppRequest
  extends ProtoBufRequest
{
  public static final String TAG = "UseUserAppRequest";
  private JSONObject mJSONObject = new JSONObject();
  private INTERFACE.StUseUserAppReq req;
  
  public UseUserAppRequest(COMM.StCommonExt paramStCommonExt, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (getContentType() == 0)
    {
      this.req = new INTERFACE.StUseUserAppReq();
      this.req.appId.set(paramString1);
      this.req.verType.set(paramInt1);
      this.req.source.set(paramInt2);
      paramString1 = new INTERFACE.StCurrChannelInfo();
      paramString1.refer.set(paramString2);
      paramString1.via.set(paramString3);
      this.req.channelInfo.set(paramString1);
      if (paramStCommonExt != null) {
        this.req.extInfo.set(paramStCommonExt);
      }
      return;
    }
    try
    {
      this.mJSONObject.put("appId", paramString1);
      this.mJSONObject.put("verType", paramInt1);
      this.mJSONObject.put("source", paramInt2);
      paramStCommonExt = new JSONObject();
      paramStCommonExt.put("refer", paramString2);
      paramStCommonExt.put("via", paramString3);
      this.mJSONObject.put("channelInfo", paramStCommonExt);
      return;
    }
    catch (Exception paramStCommonExt)
    {
      QMLog.d("UseUserAppRequest", "UseUserAppRequest Exception:" + paramStCommonExt);
    }
  }
  
  public byte[] getBusiBuf()
  {
    if (getContentType() == 0) {
      return this.req.toByteArray();
    }
    return this.mJSONObject.toString().getBytes();
  }
  
  protected String getCmdName()
  {
    return "UseUserApp";
  }
  
  public int getContentType()
  {
    if (QUAUtil.isAlienApp()) {
      return 1;
    }
    return 0;
  }
  
  protected String getModule()
  {
    return "mini_app_userapp";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      localObject = null;
    }
    do
    {
      return localObject;
      localObject = paramJSONObject;
    } while (getContentType() != 0);
    Object localObject = new INTERFACE.StUseUserAppRsp();
    try
    {
      ((INTERFACE.StUseUserAppRsp)localObject).mergeFrom(paramArrayOfByte);
      if (localObject == null) {
        break label94;
      }
      if (((INTERFACE.StUseUserAppRsp)localObject).extInfo != null)
      {
        paramJSONObject.put("ext", ((INTERFACE.StUseUserAppRsp)localObject).extInfo.get());
        return paramJSONObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("UseUserAppRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    QMLog.d("UseUserAppRequest", "onResponse fail.extInfo = null");
    return null;
    label94:
    QMLog.d("UseUserAppRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.UseUserAppRequest
 * JD-Core Version:    0.7.0.1
 */