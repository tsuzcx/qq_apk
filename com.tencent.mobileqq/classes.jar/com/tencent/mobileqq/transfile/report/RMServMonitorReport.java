package com.tencent.mobileqq.transfile.report;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.IPAddressUtil;
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
    HashMap localHashMap = new HashMap();
    localHashMap.put("isSuccess", String.valueOf(this.mIsSuccess));
    localHashMap.put("server_ip", this.mServerIp);
    localHashMap.put("server_port", this.mServerPort);
    localHashMap.put("param_FailCode", this.mFailCode);
    localHashMap.put("param_reason", this.mReason);
    localHashMap.put("param_errorDesc", this.mErrDesc);
    localHashMap.put("chatType", this.mChatType);
    localHashMap.put("chatUin", this.mChatUin);
    localHashMap.put("file_url", this.mUrl);
    localHashMap.put("http_errorCode", this.mHttpErrCode);
    localHashMap.put("md5", this.mMD5);
    localHashMap.put("uuid", this.mUUID);
    localHashMap.put("business_type", this.mBusiType);
    localHashMap.put("param_time_cost", String.valueOf(this.mTimeCost));
    localHashMap.put("filesize", String.valueOf(this.mFileSize));
    localHashMap.put("param_Ipv6Policy", String.valueOf(this.mIPPolicy));
    localHashMap.put("msfConnIPType", String.valueOf(this.mMSFConnIpType));
    localHashMap.put("ipStackType", String.valueOf(this.mIPStackType));
    localHashMap.put("param_ipType", String.valueOf(this.mIpType));
    if (this.mIsHttps) {}
    for (int i = 1;; i = 0)
    {
      localHashMap.put("param_isHttps", String.valueOf(i));
      localHashMap.put("param_Ip_ConnCost", this.mConnCost);
      return localHashMap;
    }
  }
  
  private void realReport(String paramString, HashMap<String, String> paramHashMap)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramString, this.mIsSuccess, this.mTimeCost, this.mFileSize, paramHashMap, "");
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("report , reportName = ").append(paramString).append(", mServerIp = ");
      if (this.mServerIp == null)
      {
        str = "null";
        QLog.d("RMServMonitorReport", 2, str + " , mTimeCost = " + this.mTimeCost);
      }
    }
    else if (this.mIpType == 2)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramString + "_ipv6", this.mIsSuccess, this.mTimeCost, this.mFileSize, paramHashMap, "");
      if (QLog.isColorLevel())
      {
        paramHashMap = new StringBuilder().append("report , reportName = ").append(paramString).append("_ipv6, mServerIp = ");
        if (this.mServerIp != null) {
          break label217;
        }
      }
    }
    label217:
    for (paramString = "null";; paramString = this.mServerIp)
    {
      QLog.d("RMServMonitorReport", 2, paramString + " , mTimeCost = " + this.mTimeCost);
      return;
      str = this.mServerIp;
      break;
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
    if ((!paramBoolean) && (this.mServerIp != null))
    {
      if (this.failIpReported.contains(this.mServerIp)) {
        return;
      }
      this.failIpReported.add(this.mServerIp);
    }
    this.mIsSuccess = paramBoolean;
    setCommonParams();
    realReport(paramString, buildReportInfo());
  }
  
  protected int getIpType(String paramString)
  {
    int j = 3;
    int i = j;
    if (paramString != null)
    {
      paramString = paramString.replaceAll("[\\[\\]]", "");
      i = j;
      if (paramString != null)
      {
        if (!IPAddressUtil.isIPv6LiteralAddress(paramString)) {
          break label35;
        }
        i = 2;
      }
    }
    label35:
    do
    {
      return i;
      i = j;
    } while (!IPAddressUtil.isIPv4LiteralAddress(paramString));
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.report.RMServMonitorReport
 * JD-Core Version:    0.7.0.1
 */