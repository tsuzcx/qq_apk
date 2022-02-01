package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StCurrChannelInfo;
import NS_MINI_INTERFACE.INTERFACE.StUseUserAppReq;
import NS_MINI_INTERFACE.INTERFACE.StUseUserAppRsp;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
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
    }
    else
    {
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
        paramString1 = new StringBuilder();
        paramString1.append("UseUserAppRequest Exception:");
        paramString1.append(paramStCommonExt);
        QMLog.d("UseUserAppRequest", paramString1.toString());
      }
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected String getModule()
  {
    return "mini_app_userapp";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (getContentType() == 0)
    {
      INTERFACE.StUseUserAppRsp localStUseUserAppRsp = new INTERFACE.StUseUserAppRsp();
      try
      {
        localStUseUserAppRsp.mergeFrom(paramArrayOfByte);
        if (localStUseUserAppRsp.extInfo != null)
        {
          paramJSONObject.put("ext", localStUseUserAppRsp.extInfo.get());
          return paramJSONObject;
        }
        QMLog.d("UseUserAppRequest", "onResponse fail.extInfo = null");
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("onResponse fail.");
        paramJSONObject.append(paramArrayOfByte);
        QMLog.d("UseUserAppRequest", paramJSONObject.toString());
        return null;
      }
    }
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.UseUserAppRequest
 * JD-Core Version:    0.7.0.1
 */