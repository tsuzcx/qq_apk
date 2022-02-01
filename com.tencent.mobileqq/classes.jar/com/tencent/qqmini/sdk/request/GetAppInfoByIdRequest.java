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
import org.json.JSONObject;

public class GetAppInfoByIdRequest
  extends ProtoBufRequest
{
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_APP_INFO_DATA = "mini_app_info_data";
  public static final String KEY_APP_INFO_DATA_PB = "mini_app_info_data_pb";
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
    }
    else
    {
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
        paramString1 = new StringBuilder();
        paramString1.append("GetAppInfoByIdRequest Exception:");
        paramString1.append(paramStCommonExt);
        QMLog.d("GetAppInfoByIdRequest", paramString1.toString());
      }
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected String getModule()
  {
    return "mini_app_info";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject;
    if (getContentType() == 0)
    {
      localObject = new INTERFACE.StGetAppInfoByIdRsp();
      try
      {
        ((INTERFACE.StGetAppInfoByIdRsp)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((INTERFACE.StGetAppInfoByIdRsp)localObject).appInfo;
        MiniAppInfo localMiniAppInfo = MiniAppInfo.from(paramArrayOfByte);
        localMiniAppInfo.firstPath = this.req.firstPath.get();
        paramJSONObject.put("mini_app_info_data", localMiniAppInfo);
        paramJSONObject.put("mini_app_info_data_pb", ((INTERFACE.StApiAppInfo)paramArrayOfByte.get()).toByteArray());
        if (((INTERFACE.StGetAppInfoByIdRsp)localObject).appInfo.type.get() == 3) {
          savaMiniAppInfo(localMiniAppInfo);
        }
        return paramJSONObject;
      }
      catch (Exception paramArrayOfByte)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("onResponse fail.");
        paramJSONObject.append(paramArrayOfByte);
        QMLog.d("GetAppInfoByIdRequest", paramJSONObject.toString());
        return null;
      }
    }
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte)).optJSONObject("appInfo");
      localObject = MiniAppInfo.createMiniAppInfo(paramArrayOfByte);
      ((MiniAppInfo)localObject).firstPath = this.mJSONObject.optString("firstPath");
      paramJSONObject.put("mini_app_info_data", localObject);
      paramJSONObject.put("mini_app_info_data_json", paramArrayOfByte);
      if (((MiniAppInfo)localObject).verType == 3) {
        savaMiniAppInfo((MiniAppInfo)localObject);
      }
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("GetAppInfoByIdRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetAppInfoByIdRequest
 * JD-Core Version:    0.7.0.1
 */