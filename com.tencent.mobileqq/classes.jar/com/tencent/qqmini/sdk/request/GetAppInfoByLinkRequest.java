package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByLinkReq;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByLinkRsp;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import org.json.JSONObject;

public class GetAppInfoByLinkRequest
  extends ProtoBufRequest
{
  private static final String unikey = "GetAppInfoByLink";
  private JSONObject mJSONObject = new JSONObject();
  private INTERFACE.StGetAppInfoByLinkReq req = new INTERFACE.StGetAppInfoByLinkReq();
  
  public GetAppInfoByLinkRequest(String paramString, int paramInt)
  {
    if (getContentType() == 0)
    {
      this.req.link.set(paramString);
      this.req.linkType.set(paramInt);
      return;
    }
    try
    {
      this.mJSONObject.put("link", paramString);
      this.mJSONObject.put("linkType", paramInt);
      return;
    }
    catch (Exception paramString)
    {
      QMLog.d("ProtoBufRequest", "GetAppInfoByLinkRequest Exception:" + paramString);
    }
  }
  
  private void savaMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    if (!ProcessUtil.isMainProcess(AppLoaderFactory.g().getContext())) {
      return;
    }
    ThreadManager.executeOnDiskIOThreadPool(new GetAppInfoByLinkRequest.1(this, paramMiniAppInfo));
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
    return "GetAppInfoByLink";
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
    return "mini_app_info";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      Object localObject1;
      Object localObject2;
      if (getContentType() == 0)
      {
        localObject1 = new INTERFACE.StGetAppInfoByLinkRsp();
        try
        {
          ((INTERFACE.StGetAppInfoByLinkRsp)localObject1).mergeFrom(paramArrayOfByte);
          if ((localObject1 != null) && (((INTERFACE.StGetAppInfoByLinkRsp)localObject1).appInfo != null))
          {
            localObject2 = MiniAppInfo.from(((INTERFACE.StGetAppInfoByLinkRsp)localObject1).appInfo);
            ((MiniAppInfo)localObject2).link = this.req.link.get();
            ((MiniAppInfo)localObject2).linkType = this.req.linkType.get();
            paramArrayOfByte = ((INTERFACE.StGetAppInfoByLinkRsp)localObject1).shareTicket.get();
            paramJSONObject.put("mini_app_info_data", localObject2);
            paramJSONObject.put("mini_app_info_data_pb", ((INTERFACE.StApiAppInfo)((INTERFACE.StGetAppInfoByLinkRsp)localObject1).appInfo.get()).toByteArray());
            paramJSONObject.put("shareTicket", paramArrayOfByte);
            paramArrayOfByte = paramJSONObject;
            if (((INTERFACE.StGetAppInfoByLinkRsp)localObject1).appInfo.type.get() != 3) {
              continue;
            }
            savaMiniAppInfo((MiniAppInfo)localObject2);
            return paramJSONObject;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          QMLog.d("ProtoBufRequest", "onResponse fail." + paramArrayOfByte);
          return null;
        }
        QMLog.d("ProtoBufRequest", "onResponse fail.rsp = null");
        return null;
      }
      else
      {
        try
        {
          paramArrayOfByte = new JSONObject(new String(paramArrayOfByte));
          localObject2 = paramArrayOfByte.optJSONObject("appInfo");
          localObject1 = MiniAppInfo.createMiniAppInfo((JSONObject)localObject2);
          ((MiniAppInfo)localObject1).link = this.mJSONObject.optString("link");
          ((MiniAppInfo)localObject1).linkType = this.mJSONObject.optInt("linkType");
          paramJSONObject.put("mini_app_info_data", localObject1);
          paramJSONObject.put("mini_app_info_data_json", localObject2);
          paramJSONObject.put("shareTicket", paramArrayOfByte.optString("shareTicket"));
          paramArrayOfByte = paramJSONObject;
          if (((MiniAppInfo)localObject1).verType == 3)
          {
            savaMiniAppInfo((MiniAppInfo)localObject1);
            return paramJSONObject;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          QMLog.d("ProtoBufRequest", "onResponse fail." + paramArrayOfByte);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetAppInfoByLinkRequest
 * JD-Core Version:    0.7.0.1
 */