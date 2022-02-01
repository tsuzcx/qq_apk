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
  public int mTryTime = 0;
  public String mUrl = "";
  
  public HttpEngineReport(HttpNetReq paramHttpNetReq, NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 0) {
      bool = true;
    }
    this.mIsSuccess = bool;
    this.mTimeCost = paramNetResp.reqCost;
    this.mInQueueCost = paramNetResp.inQueueCost;
    this.mUrl = paramHttpNetReq.mReqUrl;
    if (this.mUrl != null) {}
    try
    {
      this.mHost = new URL(this.mUrl).getHost();
      label86:
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
      break label86;
    }
  }
  
  private HashMap<String, String> buildReportInfo()
  {
    int j = 1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("isSuccess", String.valueOf(this.mIsSuccess));
    localHashMap.put("param_time_cost", String.valueOf(this.mTimeCost));
    localHashMap.put("param_inQueueCost", "" + this.mInQueueCost);
    localHashMap.put("param_url", this.mUrl);
    localHashMap.put("param_Host", this.mHost);
    if (this.mIsHttps)
    {
      i = 1;
      localHashMap.put("param_isHttps", String.valueOf(i));
      localHashMap.put("param_method", String.valueOf(this.mHttpMethod));
      localHashMap.put("param_FailCode", String.valueOf(this.mErrCode));
      localHashMap.put("param_errorDesc", this.mErrDesc);
      localHashMap.put("param_HttpCode", String.valueOf(this.mHttpCode));
      localHashMap.put("param_tryTimes", String.valueOf(this.mTryTime));
      localHashMap.put("param_fileTransSize", String.valueOf(this.mTotalBlockLen));
      if (!this.mIsSync) {
        break label237;
      }
      i = 1;
      label199:
      localHashMap.put("param_IsSync", String.valueOf(i));
      if (!this.mIsInnerDns) {
        break label242;
      }
    }
    label237:
    label242:
    for (int i = j;; i = 0)
    {
      localHashMap.put("param_IsInnerDns", String.valueOf(i));
      return localHashMap;
      i = 0;
      break;
      i = 0;
      break label199;
    }
  }
  
  public void doReport()
  {
    HashMap localHashMap = buildReportInfo();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actHttpEngineTrans", this.mIsSuccess, this.mTimeCost, this.mTotalBlockLen, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.report.HttpEngineReport
 * JD-Core Version:    0.7.0.1
 */