package com.tencent.mobileqq.flashshow.report.dc;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.flashshow.report.FSNativeSessionManager;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.business.base.MobileInfoUtil;
import cooperation.qzone.QUA;
import cooperation.qzone.util.NetworkState;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import qqcircle.QQCircleReport.SingleDcData;

public class FSReportHelper
{
  public static FeedCloudCommon.BytesEntry a(String paramString, byte[] paramArrayOfByte)
  {
    FeedCloudCommon.BytesEntry localBytesEntry = new FeedCloudCommon.BytesEntry();
    if (paramString != null) {
      localBytesEntry.key.set(paramString);
    }
    if (paramArrayOfByte != null) {
      localBytesEntry.value.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    return localBytesEntry;
  }
  
  public static FeedCloudCommon.Entry a(String paramString1, String paramString2)
  {
    FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
    if (paramString1 != null) {
      localEntry.key.set(paramString1);
    }
    if (paramString2 != null) {
      localEntry.value.set(paramString2);
    }
    return localEntry;
  }
  
  public static FeedCloudCommon.Entry a(Map.Entry<String, String> paramEntry)
  {
    FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
    if (paramEntry.getKey() != null) {
      localEntry.key.set((String)paramEntry.getKey());
    }
    if (paramEntry.getValue() != null) {
      localEntry.value.set((String)paramEntry.getValue());
    }
    return localEntry;
  }
  
  public static List<FeedCloudCommon.Entry> a()
  {
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { a("uin", FSTransUtils.a()), a("network_type", b()), a("app_version", ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getReportVersionName()), a("qua", QUA.getQUA3()), a("platform", "android"), a("report_from", "1"), a("os_version", Build.VERSION.RELEASE), a("mobile_type", Build.MODEL), a("respond_type", MobileInfoUtil.getResolution()), a("device_info", Build.DEVICE), a("sessionid", FSNativeSessionManager.a().b()), a("imei", MobileInfoUtil.getImei()), a("src_app", "KuaiShan") }));
  }
  
  public static List<FeedCloudCommon.Entry> a(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramMap == null) {
      return localArrayList;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      localArrayList.add(a((Map.Entry)paramMap.next()));
    }
    return localArrayList;
  }
  
  public static List<FeedCloudCommon.BytesEntry> a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfByte1 != null) {
      localArrayList.add(a("FeedReportInfo", paramArrayOfByte1));
    }
    if (paramArrayOfByte2 != null) {
      localArrayList.add(a("MsgReportInfo", paramArrayOfByte2));
    }
    if (paramArrayOfByte3 != null) {
      localArrayList.add(a("CommExtReportInfo", paramArrayOfByte3));
    }
    return localArrayList;
  }
  
  public static QQCircleReport.SingleDcData a(int paramInt, List<FeedCloudCommon.Entry> paramList1, List<FeedCloudCommon.Entry> paramList2, List<FeedCloudCommon.BytesEntry> paramList)
  {
    QQCircleReport.SingleDcData localSingleDcData = new QQCircleReport.SingleDcData();
    localSingleDcData.dcid.set(paramInt);
    if ((paramList1 != null) && (!paramList1.isEmpty())) {
      localSingleDcData.report_data.addAll(paramList1);
    }
    if ((paramList2 != null) && (!paramList2.isEmpty())) {
      localSingleDcData.extinfo.addAll(paramList2);
    }
    if ((paramList != null) && (!paramList.isEmpty())) {
      localSingleDcData.byteExtinfo.addAll(paramList);
    }
    return localSingleDcData;
  }
  
  public static String b()
  {
    int j = NetworkState.getNetworkType();
    int i = j;
    if (j == 0) {
      i = 9;
    }
    return String.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.dc.FSReportHelper
 * JD-Core Version:    0.7.0.1
 */