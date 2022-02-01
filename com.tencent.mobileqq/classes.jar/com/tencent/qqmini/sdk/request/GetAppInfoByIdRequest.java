package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdReq;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdRsp;
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

public class GetAppInfoByIdRequest
  extends ProtoBufRequest
{
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_APP_INFO_DATA = "mini_app_info_data";
  public static final String KEY_ENV_VERSION = "key_env_version";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_FIRST_PATH = "key_first_path";
  private static final String TAG = "GetAppInfoByIdRequest";
  private JSONObject mJSONObject = new JSONObject();
  private INTERFACE.StGetAppInfoByIdReq req;
  
  public GetAppInfoByIdRequest(COMM.StCommonExt paramStCommonExt, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    if (getContentType() == 0)
    {
      this.req = new INTERFACE.StGetAppInfoByIdReq();
      this.req.appid.set(paramString1);
      this.req.needVersionInfo.set(paramInt1);
      this.req.checkDevRight.set(paramInt2);
      this.req.firstPath.set(paramString2);
      this.req.envVersion.set(paramString3);
      paramString2 = this.req.fromAppid;
      paramString1 = paramString4;
      if (paramString4 == null) {
        paramString1 = "";
      }
      paramString2.set(paramString1);
      if (paramStCommonExt != null) {
        this.req.extInfo.set(paramStCommonExt);
      }
      return;
    }
    try
    {
      this.mJSONObject.put("appid", paramString1);
      this.mJSONObject.put("needVersionInfo", paramInt1);
      this.mJSONObject.put("checkDevRight", paramInt2);
      this.mJSONObject.put("firstPath", paramString2);
      this.mJSONObject.put("envVersion", paramString3);
      paramString1 = this.mJSONObject;
      paramStCommonExt = paramString4;
      if (paramString4 == null) {
        paramStCommonExt = "";
      }
      paramString1.put("fromAppid", paramStCommonExt);
      return;
    }
    catch (Exception paramStCommonExt)
    {
      QMLog.d("GetAppInfoByIdRequest", "GetAppInfoByIdRequest Exception:" + paramStCommonExt);
    }
  }
  
  private void savaMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    if (!ProcessUtil.isMainProcess(AppLoaderFactory.g().getContext())) {
      return;
    }
    ThreadManager.executeOnDiskIOThreadPool(new GetAppInfoByIdRequest.1(this, paramMiniAppInfo));
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
    return "GetAppInfoById";
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
      Object localObject;
      if (getContentType() == 0)
      {
        localObject = new INTERFACE.StGetAppInfoByIdRsp();
        try
        {
          ((INTERFACE.StGetAppInfoByIdRsp)localObject).mergeFrom(paramArrayOfByte);
          if (localObject != null)
          {
            MiniAppInfo localMiniAppInfo = MiniAppInfo.from(((INTERFACE.StGetAppInfoByIdRsp)localObject).appInfo);
            localMiniAppInfo.firstPath = this.req.firstPath.get();
            paramJSONObject.put("mini_app_info_data", localMiniAppInfo);
            paramArrayOfByte = paramJSONObject;
            if (((INTERFACE.StGetAppInfoByIdRsp)localObject).appInfo.type.get() != 3) {
              continue;
            }
            savaMiniAppInfo(localMiniAppInfo);
            return paramJSONObject;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          QMLog.d("GetAppInfoByIdRequest", "onResponse fail." + paramArrayOfByte);
          return null;
        }
        QMLog.d("GetAppInfoByIdRequest", "onResponse fail.rsp = null");
        return null;
      }
      else
      {
        try
        {
          localObject = MiniAppInfo.createMiniAppInfo(new JSONObject(new String(paramArrayOfByte)).optJSONObject("appInfo"));
          ((MiniAppInfo)localObject).firstPath = this.mJSONObject.optString("firstPath");
          paramJSONObject.put("mini_app_info_data", localObject);
          paramArrayOfByte = paramJSONObject;
          if (((MiniAppInfo)localObject).verType == 3)
          {
            savaMiniAppInfo((MiniAppInfo)localObject);
            return paramJSONObject;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          QMLog.d("GetAppInfoByIdRequest", "onResponse fail." + paramArrayOfByte);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetAppInfoByIdRequest
 * JD-Core Version:    0.7.0.1
 */