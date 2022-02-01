package com.tencent.mobileqq.transfile;

import java.util.HashMap;

public class NetResp
{
  public static final String KEY_FIRST_USE_IP = "firstserverip";
  public static final String KEY_RAW_REQ_HTTP_HEADER = "param_reqHeader";
  public static final String KEY_RAW_RESP_HTTP_HEADER = "param_rspHeader";
  public static final String KEY_REASON = "netresp_param_reason";
  public static final String KEY_USE_SERVER_IP = "serverip";
  public static final String KEY_USE_URL = "param_url";
  public static final int RESULT_DOWNLOADING = 3;
  public static final int RESULT_FAIL = 1;
  public static final int RESULT_NOT_SET = 2;
  public static final int RESULT_OK = 0;
  public long inQueueCost;
  public long mConsumeTime;
  public int mErrCode;
  public String mErrDesc;
  public int mHttpCode;
  long mLastReqStartTime;
  public int mRedirectCount;
  public long mRedirectTime;
  public NetReq mReq;
  public byte[] mRespData;
  public HashMap<String, String> mRespProperties = new HashMap();
  public int mResult = 2;
  public long mTotalBlockLen;
  public long mTotalFileLen;
  public int mTryTime;
  public long mWrittenBlockLen;
  public long reqCost;
  
  public NetResp(NetReq paramNetReq)
  {
    this.mReq = paramNetReq;
    this.mLastReqStartTime = System.currentTimeMillis();
  }
  
  public void reset()
  {
    this.mResult = 2;
    this.mErrCode = 0;
    this.mErrDesc = "";
    this.mHttpCode = 0;
    this.mTotalFileLen = 0L;
    this.mTotalBlockLen = 0L;
    this.mWrittenBlockLen = 0L;
    this.mConsumeTime = 0L;
    this.mTryTime = 0;
    this.mRespData = null;
    this.mRespProperties.clear();
  }
  
  public void setResult(int paramInt1, int paramInt2, String paramString, HashMap<String, String> paramHashMap)
  {
    this.mResult = paramInt1;
    this.mErrCode = paramInt2;
    this.mErrDesc = paramString;
    if (paramHashMap != null) {
      this.mRespProperties.putAll(paramHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NetResp
 * JD-Core Version:    0.7.0.1
 */