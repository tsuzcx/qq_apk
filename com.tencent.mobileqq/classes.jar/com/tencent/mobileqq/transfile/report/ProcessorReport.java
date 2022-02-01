package com.tencent.mobileqq.transfile.report;

import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.highway.ipv6.Ipv6Flags;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.StepInfo;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ProcessorReport
{
  public static ConcurrentHashMap<String, Integer> sReportMap = new ConcurrentHashMap();
  public int errCode = 9001;
  public String errDesc = "";
  public long mEndTime;
  public boolean mIsOldDbRec = false;
  public HashMap<String, String> mReportInfo = new HashMap();
  public int mReportedFlag = 0;
  public boolean mSendByQuickHttp = false;
  public long mStartTime;
  public StepInfo mStepDirectDown = new StepInfo();
  public StepInfo mStepMsg = new StepInfo();
  public StepInfo mStepTrans = new StepInfo();
  public StepInfo mStepUrl = new StepInfo();
  public String reason = "";
  
  public static boolean adjustErrorCode(int paramInt, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return true;
    }
    if ((paramInt != -9530) && (paramInt != -9532) && (paramInt != -9533) && (paramInt != -9531))
    {
      if ((paramInt != -9528) && (paramInt != -9529)) {
        return false;
      }
      paramHashMap.put("param_reason", getServerReason("P", paramInt));
      paramHashMap.put("param_FailCode", Integer.toString(-9527));
      return true;
    }
    paramHashMap.put("param_reason", getServerReason("Q", paramInt));
    paramHashMap.put("param_FailCode", Integer.toString(-9527));
    return true;
  }
  
  public static String getClientReason(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("C_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String getExceptionMessage(Exception paramException)
  {
    if (paramException == null) {
      return "Exception e is null";
    }
    Object localObject1 = paramException.getMessage();
    Object localObject2 = paramException.getStackTrace();
    if (localObject2 != null)
    {
      localObject1 = new StringBuilder(":");
      int j = localObject2.length;
      int i = j;
      if (j > 8) {
        i = 8;
      }
      ((StringBuilder)localObject1).append("\n");
      j = 0;
      while (j < i)
      {
        ((StringBuilder)localObject1).append(localObject2[j].toString());
        ((StringBuilder)localObject1).append("\n");
        j += 1;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramException.toString());
      ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    return localObject1;
  }
  
  public static String getHttpCmdReason(int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("S_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public static String getHttpDataReason(int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("H_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public static String getMsgReason(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("M_");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public static String getServerReason(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public static String getUrlReason(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("T_");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public void copyRespCommon(StepInfo paramStepInfo, RichProto.RichProtoResp.RespCommon paramRespCommon)
  {
    if ((paramStepInfo != null) && (paramRespCommon != null))
    {
      paramStepInfo.logFinishTime();
      paramStepInfo.successTryCount = paramRespCommon.successCount;
      paramStepInfo.failTryCount = paramRespCommon.failCount;
      if (paramRespCommon.result == 0)
      {
        paramStepInfo.result = 1;
        return;
      }
      paramStepInfo.result = 0;
      setError(paramRespCommon.errCode, paramRespCommon.errStr, paramRespCommon.reason, paramStepInfo);
    }
  }
  
  public void copyStaticsInfoFromNetResp(StepInfo paramStepInfo, NetResp paramNetResp, boolean paramBoolean)
  {
    if (paramStepInfo != null)
    {
      if (paramNetResp == null) {
        return;
      }
      this.mReportInfo.put("param_Server", paramNetResp.mRespProperties.get("serverip"));
      if (paramBoolean)
      {
        this.mReportInfo.put("serverip", paramNetResp.mRespProperties.get("serverip"));
        paramStepInfo.successTryCount += 1;
        paramStepInfo.failTryCount += paramNetResp.mTryTime - 1;
        paramStepInfo.logFinishTime();
        paramStepInfo.result = 1;
        this.mReportInfo.remove("param_url");
        this.mReportInfo.remove("param_rspHeader");
        return;
      }
      this.mReportInfo.put("serverip", paramNetResp.mRespProperties.get("firstserverip"));
      paramStepInfo.failTryCount += paramNetResp.mTryTime;
      String str;
      if (paramNetResp.mErrCode == -9527) {
        str = (String)paramNetResp.mRespProperties.get("netresp_param_reason");
      } else {
        str = null;
      }
      setError(paramNetResp.mErrCode, paramNetResp.mErrDesc, str, paramStepInfo);
      this.mReportInfo.put("param_url", paramNetResp.mRespProperties.get("param_url"));
      this.mReportInfo.put("param_rspHeader", paramNetResp.mRespProperties.get("param_rspHeader"));
      if ((paramNetResp.mErrCode == -9527) && ("H_404_-124".equals(str))) {
        this.mReportInfo.put("param_reqHeader", paramNetResp.mRespProperties.get("param_reqHeader"));
      }
      paramStepInfo.result = 0;
    }
  }
  
  public void copyStatisInfo(StepInfo paramStepInfo, boolean paramBoolean1, boolean paramBoolean2, StatictisInfo paramStatictisInfo)
  {
    if (paramStatictisInfo == null) {
      return;
    }
    paramStepInfo.logFinishTime();
    if (paramBoolean2)
    {
      paramStepInfo.failTryCount = (paramStatictisInfo.c - 1);
      paramStepInfo.successTryCount = 1;
      paramStepInfo.result = 1;
      return;
    }
    int i;
    String str;
    if (paramStatictisInfo.b == 2900)
    {
      i = -9527;
      if (!paramBoolean1) {
        str = getMsgReason(paramStatictisInfo.jdField_a_of_type_Long);
      } else {
        str = getUrlReason(paramStatictisInfo.jdField_a_of_type_Long);
      }
    }
    else if ((paramStatictisInfo.b != 1002) && (paramStatictisInfo.b != 1013))
    {
      if (!paramBoolean1) {
        i = 9351;
      } else {
        i = 9044;
      }
      str = paramStatictisInfo.jdField_a_of_type_JavaLangString;
    }
    else
    {
      if (!paramBoolean1) {
        i = 9350;
      } else {
        i = 9311;
      }
      str = paramStatictisInfo.jdField_a_of_type_JavaLangString;
    }
    setError(i, "", str, paramStepInfo);
    paramStepInfo.failTryCount = paramStatictisInfo.c;
    paramStepInfo.successTryCount = 0;
    paramStepInfo.result = 0;
  }
  
  public void reportForIpv6(boolean paramBoolean1, long paramLong, boolean paramBoolean2, String paramString)
  {
    this.mReportInfo.put("ipStackType", String.valueOf(NetConnInfoCenter.getActiveNetIpFamily(false)));
    this.mReportInfo.put("msfConnIPType", String.valueOf(MsfServiceSdk.get().getConnectedIPFamily()));
    if (paramBoolean2) {
      this.mReportInfo.put("param_Ipv6Policy", String.valueOf(Ipv6Config.getFlags().mBdhStrategy));
    } else {
      this.mReportInfo.put("param_Ipv6Policy", String.valueOf(Ipv6Config.getFlags().mRMDownStrategy));
    }
    if ((this.mReportInfo.get("param_is_ipv6") != null) && (((String)this.mReportInfo.get("param_is_ipv6")).equals(String.valueOf(1))))
    {
      StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_ipv6");
      localStatisticCollector.collectPerformance(null, localStringBuilder.toString(), paramBoolean1, paramLong, 0L, this.mReportInfo, "");
    }
  }
  
  public void setError(int paramInt, String paramString)
  {
    setError(paramInt, paramString, null, null);
  }
  
  public void setError(int paramInt, String paramString1, String paramString2, StepInfo paramStepInfo)
  {
    this.errCode = paramInt;
    this.errDesc = paramString1;
    if ((paramString2 != null) && (!"".equals(paramString2))) {
      this.mReportInfo.put("param_reason", paramString2);
    }
    if (paramStepInfo != null)
    {
      paramStepInfo.logFinishTime();
      paramStepInfo.result = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.report.ProcessorReport
 * JD-Core Version:    0.7.0.1
 */