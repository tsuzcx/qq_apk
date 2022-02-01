package com.tencent.qqmini.sdk.launcher.core.proxy;

public class PayProxy$PayResponse
{
  public static final int PAYCHANEL_ACCT_QBQD = 11;
  public static final int PAYCHANEL_ACCT_QDQB = 0;
  public static final int PAYCHANEL_GOLDCOUPONS = 10;
  public static final int PAYCHANEL_HF = 9;
  public static final int PAYCHANEL_MCARD = 5;
  public static final int PAYCHANEL_QQCARD = 4;
  public static final int PAYCHANEL_TENPAY_BANK = 2;
  public static final int PAYCHANEL_TENPAY_CFT = 1;
  public static final int PAYCHANEL_TENPAY_KJ = 3;
  public static final int PAYCHANEL_UNKOWN = -1;
  public static final int PAYCHANEL_WECHAT = 8;
  public static final int PAYCHANEL_YB = 7;
  public static final int PAYPROVIDESTATE_SUCC = 0;
  public static final int PAYPROVIDESTATE_UNKOWN = -1;
  public static final int PAYRESULT_ALREADY_OWNED = 1159;
  public static final int PAYRESULT_CANCEL = 2;
  public static final int PAYRESULT_ERROR = -1;
  public static final int PAYRESULT_PARAMERROR = 3;
  public static final int PAYRESULT_PENDING = 101;
  public static final int PAYRESULT_SUCC = 0;
  public static final int PAYRESULT_UNKOWN = 100;
  public static final int PAYSTATE_PAYCANCEL = 1;
  public static final int PAYSTATE_PAYERROR = 2;
  public static final int PAYSTATE_PAYSUCC = 0;
  public static final int PAYSTATE_PAYUNKOWN = -1;
  public String extendInfo = null;
  public int payChannel = -1;
  public String payReserve1 = null;
  public String payReserve2 = null;
  public String payReserve3 = null;
  public int payState = -1;
  public int provideState = -1;
  public int realSaveNum = 0;
  public int resultCode = -1;
  public int resultInerCode = 0;
  public String resultMsg = null;
  
  public PayProxy$PayResponse(PayProxy paramPayProxy) {}
  
  public String getExtendInfo()
  {
    return this.extendInfo;
  }
  
  public int getPayChannel()
  {
    return this.payChannel;
  }
  
  public String getPayReserve1()
  {
    return this.payReserve1;
  }
  
  public String getPayReserve2()
  {
    return this.payReserve2;
  }
  
  public String getPayReserve3()
  {
    return this.payReserve3;
  }
  
  public int getPayState()
  {
    return this.payState;
  }
  
  public int getProvideState()
  {
    return this.provideState;
  }
  
  public int getRealSaveNum()
  {
    return this.realSaveNum;
  }
  
  public int getResultCode()
  {
    return this.resultCode;
  }
  
  public int getResultInerCode()
  {
    return this.resultInerCode;
  }
  
  public String getResultMsg()
  {
    return this.resultMsg;
  }
  
  public void reset()
  {
    this.realSaveNum = 0;
    this.resultCode = -1;
    this.resultInerCode = 0;
    this.payChannel = -1;
    this.payState = -1;
    this.provideState = -1;
    this.resultMsg = "";
    this.extendInfo = "";
    this.payReserve1 = "";
    this.payReserve2 = "";
    this.payReserve3 = "";
  }
  
  public void setExtendInfo(String paramString)
  {
    this.extendInfo = paramString;
  }
  
  public void setPayChannel(int paramInt)
  {
    this.payChannel = paramInt;
  }
  
  public void setPayReserve1(String paramString)
  {
    this.payReserve1 = paramString;
  }
  
  public void setPayReserve2(String paramString)
  {
    this.payReserve2 = paramString;
  }
  
  public void setPayReserve3(String paramString)
  {
    this.payReserve3 = paramString;
  }
  
  public void setPayState(int paramInt)
  {
    this.payState = paramInt;
  }
  
  public void setProvideState(int paramInt)
  {
    this.provideState = paramInt;
  }
  
  public void setRealSaveNum(int paramInt)
  {
    this.realSaveNum = paramInt;
  }
  
  public void setResultCode(int paramInt)
  {
    this.resultCode = paramInt;
  }
  
  public void setResultInerCode(int paramInt)
  {
    this.resultInerCode = paramInt;
  }
  
  public void setResultMsg(String paramString)
  {
    this.resultMsg = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.PayResponse
 * JD-Core Version:    0.7.0.1
 */