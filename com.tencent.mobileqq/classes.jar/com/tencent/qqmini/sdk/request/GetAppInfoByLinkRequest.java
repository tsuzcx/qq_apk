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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GetAppInfoByLinkRequest Exception:");
      localStringBuilder.append(paramString);
      QMLog.d("ProtoBufRequest", localStringBuilder.toString());
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
    Object localObject1;
    Object localObject2;
    if (getContentType() == 0)
    {
      localObject1 = new INTERFACE.StGetAppInfoByLinkRsp();
      try
      {
        ((INTERFACE.StGetAppInfoByLinkRsp)localObject1).mergeFrom(paramArrayOfByte);
        if (((INTERFACE.StGetAppInfoByLinkRsp)localObject1).appInfo != null)
        {
          paramArrayOfByte = MiniAppInfo.from(((INTERFACE.StGetAppInfoByLinkRsp)localObject1).appInfo);
          paramArrayOfByte.link = this.req.link.get();
          paramArrayOfByte.linkType = this.req.linkType.get();
          localObject2 = ((INTERFACE.StGetAppInfoByLinkRsp)localObject1).shareTicket.get();
          paramJSONObject.put("mini_app_info_data", paramArrayOfByte);
          paramJSONObject.put("mini_app_info_data_pb", ((INTERFACE.StApiAppInfo)((INTERFACE.StGetAppInfoByLinkRsp)localObject1).appInfo.get()).toByteArray());
          paramJSONObject.put("shareTicket", localObject2);
          if (((INTERFACE.StGetAppInfoByLinkRsp)localObject1).appInfo.type.get() != 3) {
            return paramJSONObject;
          }
          savaMiniAppInfo(paramArrayOfByte);
          return paramJSONObject;
        }
        QMLog.d("ProtoBufRequest", "onResponse fail.rsp = null");
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("onResponse fail.");
        paramJSONObject.append(paramArrayOfByte);
        QMLog.d("ProtoBufRequest", paramJSONObject.toString());
        return null;
      }
    }
    else
    {
      try
      {
        paramArrayOfByte = new JSONObject(new String(paramArrayOfByte));
        localObject1 = paramArrayOfByte.optJSONObject("appInfo");
        localObject2 = MiniAppInfo.createMiniAppInfo((JSONObject)localObject1);
        ((MiniAppInfo)localObject2).link = this.mJSONObject.optString("link");
        ((MiniAppInfo)localObject2).linkType = this.mJSONObject.optInt("linkType");
        paramJSONObject.put("mini_app_info_data", localObject2);
        paramJSONObject.put("mini_app_info_data_json", localObject1);
        paramJSONObject.put("shareTicket", paramArrayOfByte.optString("shareTicket"));
        if (((MiniAppInfo)localObject2).verType == 3) {
          savaMiniAppInfo((MiniAppInfo)localObject2);
        }
        return paramJSONObject;
      }
      catch (Exception paramArrayOfByte)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("onResponse fail.");
        paramJSONObject.append(paramArrayOfByte);
        QMLog.d("ProtoBufRequest", paramJSONObject.toString());
        return null;
      }
    }
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetAppInfoByLinkRequest
 * JD-Core Version:    0.7.0.1
 */