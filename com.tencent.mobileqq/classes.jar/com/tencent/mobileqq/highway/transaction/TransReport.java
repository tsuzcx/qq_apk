package com.tencent.mobileqq.highway.transaction;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TransReport
{
  public static final String rep_BDH_Cache_Diff = "param_BDH_Cache_Diff";
  public static final String rep_BDH_LongVideo_First_Range = "param_BDH_LongVideo_First_Range";
  public static final String rep_BDH_LongVideo_Has_ReUpload = "param_BDH_LongVideo_HasReUpload";
  public static final String rep_BDH_Reason = "param_BDH_Reason";
  public static final String rep_Ip_ConnCost = "param_Ip_ConnCost";
  public static final String rep_Ip_Index = "param_ip_index";
  public static final String rep_Net_Detect = "NetDetect";
  public static final String rep_bdhTrans = "rep_bdhTrans";
  public static final String rep_confMaxConn = "param_conf_connNum";
  public static final String rep_confSegNum = "param_conf_segNum";
  public static final String rep_confSegSize = "param_conf_segSize";
  public static final String rep_connNUm = "connNum:";
  public static final String rep_dwFlow_Xg = "dwFlow_Xg";
  public static final String rep_dwFlow_wifi = "dwFlow_WiFi";
  public static final String rep_finLost = "param_fin_lost";
  public static final String rep_has_ipv6_list = "param_hasV6List";
  public static final String rep_has_net = "hasNet";
  public static final String rep_heart_resp = "param_heart_resp";
  public static final String rep_ip = "ip";
  public static final String rep_ip_type = "param_ipType";
  public static final String rep_ipv6_first = "param_ipv6First";
  public static final String rep_isPreConnExist = "PreConn:";
  public static final String rep_is_ipv6 = "param_is_ipv6";
  public static final String rep_net_type = "net:";
  public static final String rep_port = "port";
  public static final String rep_progress = "progress";
  public static final String rep_proto = "proto";
  public static final String rep_retry_code = "param_retry_code";
  public static final String rep_retry_max = "param_max_retry_times";
  public static final String rep_retry_seg_count = "param_retry_seg_count";
  public static final String rep_retry_total = "param_total_retry_times";
  public static final String rep_segsPerConn = "segspercnt";
  public static final String rep_slice_num = "sn:";
  public static final String rep_time_cache = "tc_p:";
  public static final String rep_time_ht = "tc_h:";
  public static final String rep_time_send = "tc_s:";
  public static final String rep_upFlow_Xg = "upFlow_Xg";
  public static final String rep_upFlow_wifi = "upFlow_WiFi";
  public boolean bCacheDiff = false;
  public boolean bFINLost = false;
  public boolean bHasNet = false;
  public long confConnNum;
  public long confSegNum;
  public long confSegSize;
  public int connErrCode;
  public int connNum;
  public long[] dataFlow;
  public String detectResult;
  public String failReason;
  public int firstRange = 0;
  public boolean hasReUpload = false;
  public String ipAddr = "";
  public long ipConnCost = 0L;
  public int ipIndex = -1;
  public boolean isConnected = false;
  public boolean isIpv6;
  public HashMap<Integer, AtomicInteger> mDataFlowOfChannel = new HashMap();
  public boolean mHasIpv6List;
  public boolean mIPv6Fast;
  public boolean mIsPreConnExist = false;
  public int mRetryCode;
  public int mRetryTimes_SegsMax = 0;
  public int mRetryTimes_SegsNum = 0;
  public int mRetryTimes_SegsTotal = 0;
  public int mTransferedSize = -1;
  public int netType;
  public String port = "";
  public String protoType;
  public int sliceNum = 0;
  public int timeCost_Cache = 0;
  public int timeCost_Ht = 0;
  public int timeCost_Send = 0;
  
  public HashMap<String, String> getReportInfo()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setFailReason(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("BDH");
    localStringBuilder.append("_E_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_N_");
    localStringBuilder.append(this.connErrCode);
    localStringBuilder.append("_D_");
    localStringBuilder.append(paramString);
    this.failReason = localStringBuilder.toString();
  }
  
  public void updateRetryInfo(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if (paramInt > this.mRetryTimes_SegsMax) {
      this.mRetryTimes_SegsMax = paramInt;
    }
    this.mRetryTimes_SegsNum += 1;
    this.mRetryTimes_SegsTotal += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.transaction.TransReport
 * JD-Core Version:    0.7.0.1
 */