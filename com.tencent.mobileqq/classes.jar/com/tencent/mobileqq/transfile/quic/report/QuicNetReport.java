package com.tencent.mobileqq.transfile.quic.report;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tencent.im.andromeda.andromeda.NetInfo;

public final class QuicNetReport
{
  public static final int BUINESS_QUIC_SHORT_VIDEO_TYPE = 1;
  public static final String KEY_QUIC_CONN_COST = "param_quic_conn_cost";
  public static final String KEY_QUIC_CONTENT_LENGTH = "param_quic_content_length";
  public static final String KEY_QUIC_DOWNLOAD = "parameter_quic";
  public static final String KEY_QUIC_DOWNLOAD_STATUS = "parameter_quic_status";
  public static final String KEY_QUIC_ERR_CODE = "param_quic_err_code";
  public static final String KEY_QUIC_ERR_MESSAGE = "param_quic_err_message";
  public static final String KEY_QUIC_ESTIMATED_BANDWIDTH = "param_quic_estimated_bandwidth";
  public static final String KEY_QUIC_FAIL_REASON = "param_quic_fail_reason";
  public static final String KEY_QUIC_FIRST_PACKAGE_COST = "param_quic_first_package_cost";
  public static final String KEY_QUIC_HTTP_STATUS = "param_quic_http_status";
  public static final String KEY_QUIC_IN_QUEUE_COST = "param_quic_inQueueCost";
  public static final String KEY_QUIC_IS_IPV6 = "param_quic_is_ipv6";
  public static final String KEY_QUIC_LOST_RATE = "param_quic_lost_rate";
  public static final String KEY_QUIC_NET_TYPE = "param_quic_net_type";
  public static final String KEY_QUIC_REMOTE_ADDRESS = "param_quic_remote_address";
  public static final String KEY_QUIC_REMOTE_PORT = "param_quic_remote_port";
  public static final String KEY_QUIC_RTT_MEAN = "param_quic_rtt_mean";
  public static final String KEY_QUIC_SHORT_VIDEO = "param_quic_short_video";
  public static final String KEY_QUIC_SRTT_US = "param_quic_srtt_us";
  public static final String KEY_QUIC_TIME_OUT = "param_quic_time_out";
  public static final String KEY_QUIC_TOTAL_SIZE = "param_quic_total_size";
  public static final String KEY_QUIC_TOTAL_TIME = "param_quic_total_time";
  public static final String KEY_QUIC_TYPE_VIDEO = "param_quic_type_video";
  private static final int OFFSET_VERSION_REPORT = 2000000;
  public static final String QUIC = "quic";
  public static final int REASON_FAIL_CANCELED = 9;
  public static final int REASON_FAIL_CONTENT = 5;
  public static final int REASON_FAIL_DOWNLOADING = 8;
  public static final int REASON_FAIL_EXCEPTION = 4;
  public static final int REASON_FAIL_LOAD_SO = 7;
  public static final int REASON_FAIL_NETWORK = 3;
  public static final int REASON_FAIL_NETWORK_UNAVAILABLE = 6;
  private static final int REASON_FAIL_NONE = 0;
  public static final int REASON_FAIL_SO_LOAD_FAIL = 10;
  public static final int REASON_FAIL_STORAGE = 2;
  public static final int REASON_FAIL_UNKNOWN = 1;
  private static final String REPORT_TAG = "actShortVideoQuicDownload";
  public static final String RTT_HOST = "sns.cdn.qq.com";
  public int businessId;
  public String channel = "quic";
  public long contentLength = 0L;
  public String contentType = "";
  public long endTime = 0L;
  public int errCode = 0;
  public String errMsg = "";
  public String extra;
  public int failReason = 0;
  public long fileSize = 0L;
  public long firstPackageCost = 0L;
  public String header = "";
  public Map<String, String> headers = new LinkedHashMap();
  public int httpStatus = 0;
  public int id = 0;
  public String ip;
  public boolean isHttpRetryed;
  public boolean isIpv6;
  public QuicNetReport.Stats lastStats;
  public int port = 443;
  public String rttHost;
  public String savePath = "";
  public int slice = 1;
  public byte[] srvMessage;
  public long startTime = 0L;
  public QuicNetReport.Stats stats;
  public boolean success;
  public long tConn = 0L;
  public String tempPath = "";
  public int timeOut;
  public long totaltime = 0L;
  public String url = "";
  public String uuid = "";
  public long waitCost = 0L;
  
  public static QuicNetReport.Stats convertJsontoStats(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    QuicNetReport.Stats localStats;
    for (;;)
    {
      return paramString;
      localStats = new QuicNetReport.Stats();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("srtt_us")) {
          localStats.mSrttUs = localJSONObject.optInt("srtt_us");
        }
        if (localJSONObject.has("estimated_bandwidth")) {
          localStats.mEstimatedBandwidth = localJSONObject.optInt("estimated_bandwidth");
        }
        if (localJSONObject.has("rtt_mean")) {
          localStats.mRttMean = localJSONObject.optInt("rtt_mean");
        }
        if (localJSONObject.has("lost_rate")) {
          localStats.mLostRate = localJSONObject.optInt("lost_rate");
        }
        paramString = localStats;
        if (localJSONObject.has("byte_recv"))
        {
          localStats.mByteRecv = localJSONObject.optInt("byte_recv");
          return localStats;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return localStats;
  }
  
  private int getNetType()
  {
    switch (NetworkUtil.b(MobileQQ.getContext()))
    {
    case 5: 
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 3;
    case 3: 
      return 4;
    case 4: 
      return 5;
    }
    return 7;
  }
  
  public byte[] getReportMsg()
  {
    andromeda.NetInfo localNetInfo = new andromeda.NetInfo();
    localNetInfo.nettype.set(getNetType());
    if (this.lastStats != null)
    {
      localNetInfo.lastrtt.set(this.lastStats.mSrttUs);
      localNetInfo.lastspeed.set(this.lastStats.mEstimatedBandwidth);
      localNetInfo.lastrtt_mean.set(this.lastStats.mRttMean);
      localNetInfo.lastlost_rate.set(this.lastStats.mLostRate);
      localNetInfo.lastbyte_recv.set(this.lastStats.mByteRecv);
      if ((this.lastStats.mSrvMessage != null) && (this.lastStats.mSrvMessage.length > 0)) {
        localNetInfo.last_srvmessage.set(ByteStringMicro.copyFrom(this.lastStats.mSrvMessage));
      }
    }
    localNetInfo.bussinessid.set(this.businessId);
    try
    {
      int i = Integer.parseInt("8.5.5".replace(".", ""));
      localNetInfo.clientversion.set(i + 2000000);
      localNetInfo.optype.set(1);
      return localNetInfo.toByteArray();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("quic", 2, localException, new Object[0]);
      }
    }
  }
  
  protected void report(boolean paramBoolean, long paramLong, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("quic", 4, "reportBeaconEvent result: " + paramBoolean + " duration: " + paramLong);
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actShortVideoQuicDownload", paramBoolean, paramLong, this.fileSize, paramHashMap, "");
  }
  
  public void reportBeaconEvent(boolean paramBoolean1, boolean paramBoolean2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_quic_inQueueCost", String.valueOf(this.waitCost));
    localHashMap.put("param_quic_net_type", String.valueOf(getNetType()));
    localHashMap.put("param_quic_total_time", String.valueOf(this.totaltime));
    localHashMap.put("param_quic_total_size", String.valueOf(this.fileSize));
    localHashMap.put("param_quic_err_code", String.valueOf(this.errCode));
    localHashMap.put("param_quic_fail_reason", String.valueOf(this.failReason));
    localHashMap.put("param_quic_content_length", String.valueOf(this.contentLength));
    localHashMap.put("param_quic_remote_address", this.ip);
    localHashMap.put("param_quic_remote_port", String.valueOf(this.port));
    localHashMap.put("param_quic_first_package_cost", String.valueOf(this.firstPackageCost));
    localHashMap.put("param_quic_err_message", this.errMsg);
    localHashMap.put("param_quic_time_out", String.valueOf(this.timeOut));
    localHashMap.put("param_quic_http_status", String.valueOf(this.httpStatus));
    localHashMap.put("param_quic_conn_cost", String.valueOf(this.tConn));
    String str;
    if (this.isIpv6)
    {
      str = "1";
      localHashMap.put("param_quic_is_ipv6", str);
      if (!paramBoolean1) {
        break label393;
      }
      str = "1";
      label244:
      localHashMap.put("param_quic_short_video", str);
      if (!paramBoolean2) {
        break label401;
      }
      str = "1";
      label263:
      localHashMap.put("param_quic_type_video", str);
      if (this.stats != null)
      {
        localHashMap.put("param_quic_estimated_bandwidth", String.valueOf(this.stats.mEstimatedBandwidth));
        localHashMap.put("param_quic_srtt_us", String.valueOf(this.stats.mSrttUs));
        localHashMap.put("param_quic_rtt_mean", String.valueOf(this.stats.mRttMean));
        localHashMap.put("param_quic_lost_rate", String.valueOf(this.stats.mLostRate));
      }
      paramBoolean1 = this.success;
      if (this.totaltime <= 0L) {
        break label409;
      }
    }
    label393:
    label401:
    label409:
    for (long l = this.totaltime + this.waitCost;; l = this.totaltime)
    {
      report(paramBoolean1, l, localHashMap);
      return;
      str = "0";
      break;
      str = "0";
      break label244;
      str = "0";
      break label263;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.report.QuicNetReport
 * JD-Core Version:    0.7.0.1
 */