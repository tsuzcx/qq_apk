package com.tencent.mobileqq.transfile.report;

import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.highway.ipv6.Ipv6Flags;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.mobileqq.transfile.StepInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class RMServMonitorReport
{
  public static final String REPORT_NAME_NM_PICDOWN = "actRichMediaNetMonitor_picDown";
  public static final String REPORT_NAME_NM_PICUP = "actRichMediaNetMonitor_picUp";
  public static final String REPORT_NAME_NM_PTTDOWN = "actRichMediaNetMonitor_pttDown";
  public static final String REPORT_NAME_NM_PTTUP = "actRichMediaNetMonitor_pttUp";
  public static final String REPORT_NAME_NM_VIDEODOWN = "actRichMediaNetMonitor_videoDown";
  public static final String REPORT_NAME_NM_VIDEOUP = "actRichMediaNetMonitor_videoUp";
  private static final String TAG = "RMServMonitorReport";
  public static final int VALUE_IP_TYPE_DOMAIN = 3;
  public static final int VALUE_IP_TYPE_IPV4 = 1;
  public static final int VALUE_IP_TYPE_IPV6 = 2;
  private ArrayList<String> failIpReported = new ArrayList();
  public String mBusiType = "";
  public String mChatType = "";
  public String mChatUin = "";
  public String mConnCost;
  public String mErrDesc = "";
  public String mFailCode = "";
  public long mFileSize;
  public String mHttpErrCode = "";
  public int mIPPolicy;
  public int mIPStackType;
  public int mIpType;
  public boolean mIsHttps;
  private boolean mIsSuccess;
  public String mMD5 = "";
  public int mMSFConnIpType;
  public String mReason = "";
  public String mServerIp = "";
  public String mServerPort = "";
  public long mTimeCost;
  public String mUUID = "";
  public String mUrl = "";
  
  private HashMap<String, String> buildReportInfo()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void realReport(String paramString, HashMap<String, String> paramHashMap)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramString, this.mIsSuccess, this.mTimeCost, this.mFileSize, paramHashMap, "");
    boolean bool = QLog.isColorLevel();
    String str = "null";
    Object localObject2;
    Object localObject1;
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report , reportName = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", mServerIp = ");
      localObject2 = this.mServerIp;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "null";
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" , mTimeCost = ");
      localStringBuilder.append(this.mTimeCost);
      QLog.d("RMServMonitorReport", 2, localStringBuilder.toString());
    }
    if (this.mIpType == 2)
    {
      localObject1 = StatisticCollector.getInstance(BaseApplication.getContext());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("_ipv6");
      ((StatisticCollector)localObject1).collectPerformance(null, ((StringBuilder)localObject2).toString(), this.mIsSuccess, this.mTimeCost, this.mFileSize, paramHashMap, "");
      if (QLog.isColorLevel())
      {
        paramHashMap = new StringBuilder();
        paramHashMap.append("report , reportName = ");
        paramHashMap.append(paramString);
        paramHashMap.append("_ipv6, mServerIp = ");
        paramString = this.mServerIp;
        if (paramString == null) {
          paramString = str;
        }
        paramHashMap.append(paramString);
        paramHashMap.append(" , mTimeCost = ");
        paramHashMap.append(this.mTimeCost);
        QLog.d("RMServMonitorReport", 2, paramHashMap.toString());
      }
    }
  }
  
  private void setCommonParams()
  {
    this.mIPStackType = NetConnInfoCenter.getActiveNetIpFamily(true);
    this.mMSFConnIpType = MsfServiceSdk.get().getConnectedIPFamily();
    this.mIpType = getIpType(this.mServerIp);
  }
  
  public void doReport(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      String str = this.mServerIp;
      if (str != null)
      {
        if (this.failIpReported.contains(str)) {
          return;
        }
        this.failIpReported.add(this.mServerIp);
      }
    }
    this.mIsSuccess = paramBoolean;
    setCommonParams();
    realReport(paramString, buildReportInfo());
  }
  
  public void doReportForServerMonitor(String paramString1, boolean paramBoolean1, String paramString2, String paramString3, int paramInt, String paramString4, boolean paramBoolean2, StepInfo paramStepInfo)
  {
    if (this.mReason == null) {
      this.mReason = paramString2;
    }
    if (this.mErrDesc == null) {
      this.mErrDesc = paramString3;
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramInt);
    paramString2.append("");
    this.mChatType = paramString2.toString();
    paramString2 = new StringBuilder();
    paramString2.append(paramString4);
    paramString2.append("");
    this.mChatUin = paramString2.toString();
    if (paramBoolean2) {
      this.mIPPolicy = Ipv6Config.getFlags().mBdhStrategy;
    } else {
      this.mIPPolicy = Ipv6Config.getFlags().mRMDownStrategy;
    }
    if ((paramStepInfo != null) && (paramStepInfo.startTime > 0L)) {
      this.mTimeCost = ((System.nanoTime() - paramStepInfo.startTime) / 1000000L);
    }
    doReport(paramString1, paramBoolean1);
  }
  
  protected int getIpType(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.replaceAll("[\\[\\]]", "");
      if (paramString != null)
      {
        if (IPAddressUtil.isIPv6LiteralAddress(paramString)) {
          return 2;
        }
        if (IPAddressUtil.isIPv4LiteralAddress(paramString)) {
          return 1;
        }
      }
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.report.RMServMonitorReport
 * JD-Core Version:    0.7.0.1
 */