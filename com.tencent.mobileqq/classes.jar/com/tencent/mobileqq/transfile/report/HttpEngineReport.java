package com.tencent.mobileqq.transfile.report;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URL;
import java.util.HashMap;

public class HttpEngineReport
{
  public static final String KEY_ERR_DESC = "param_errorDesc";
  public static final String KEY_FAIL_CODE = "param_FailCode";
  public static final String KEY_IN_QUEUE_COST = "param_inQueueCost";
  public static final String KEY_IS_HTTPS = "param_isHttps";
  public static final String KEY_TIME_COST = "param_time_cost";
  public static final String KEY_URL = "param_url";
  public static final String REPORT_NAME_HTTP_ENGINE_TRANS = "actHttpEngineTrans";
  private static final String TAG = "HttpEngineReport";
  public int mErrCode;
  public String mErrDesc;
  public String mHost = "";
  public int mHttpCode;
  public int mHttpMethod;
  public long mInQueueCost;
  public boolean mIsHttps;
  boolean mIsInnerDns;
  private boolean mIsSuccess;
  boolean mIsSync;
  public long mTimeCost;
  public long mTotalBlockLen;
  public int mTryTime;
  public String mUrl = "";
  
  public HttpEngineReport(HttpNetReq paramHttpNetReq, NetResp paramNetResp)
  {
    boolean bool = false;
    this.mTryTime = 0;
    if (paramNetResp.mResult == 0) {
      bool = true;
    }
    this.mIsSuccess = bool;
    this.mTimeCost = paramNetResp.reqCost;
    this.mInQueueCost = paramNetResp.inQueueCost;
    this.mUrl = paramHttpNetReq.mReqUrl;
    String str = this.mUrl;
    if (str != null) {}
    try
    {
      this.mHost = new URL(str).getHost();
      label88:
      this.mIsHttps = paramHttpNetReq.mIsHttps;
      this.mHttpMethod = paramHttpNetReq.mHttpMethod;
      this.mErrCode = paramNetResp.mErrCode;
      this.mErrDesc = paramNetResp.mErrDesc;
      this.mHttpCode = paramNetResp.mHttpCode;
      this.mTryTime = paramNetResp.mTryTime;
      this.mTotalBlockLen = paramNetResp.mTotalBlockLen;
      this.mIsSync = paramHttpNetReq.mIsSync;
      this.mIsInnerDns = paramHttpNetReq.mHaveIpConnect;
      return;
    }
    catch (Exception localException)
    {
      break label88;
    }
  }
  
  private HashMap<String, String> buildReportInfo()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void doReport()
  {
    HashMap localHashMap = buildReportInfo();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actHttpEngineTrans", this.mIsSuccess, this.mTimeCost, this.mTotalBlockLen, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.report.HttpEngineReport
 * JD-Core Version:    0.7.0.1
 */