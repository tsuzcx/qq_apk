package com.tencent.mobileqq.kandian.base.video.player.data;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.video.VideoDeviceInfoHelper;
import com.tencent.mobileqq.kandian.base.video.player.VideoFormat;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.utils.HardwareUtil;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class ReadInJoyVideoReportData
  extends AbsReadInJoyVideoReportData
  implements VideoFormat
{
  private static ReadInJoyVideoReportData.BucketKeyFetcher aA;
  public static Map<String, String> az = new HashMap();
  
  private static int a(String paramString1, String paramString2)
  {
    int i;
    long l;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append('-');
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
      paramString1 = MessageDigest.getInstance("MD5").digest(paramString1.getBytes("UTF-8"));
      paramString1[7] = ((byte)(paramString1[7] & 0xFFFFFFF0));
      i = 0;
      l = 0L;
    }
    catch (Exception paramString1)
    {
      label80:
      break label80;
    }
    return (int)((l >>> 4) % 100L);
    return -1;
    while (i < 8)
    {
      l = l << 8 | paramString1[i] & 0xFF;
      i += 1;
    }
  }
  
  public static void a(ReadInJoyVideoReportData.BucketKeyFetcher paramBucketKeyFetcher)
  {
    aA = paramBucketKeyFetcher;
  }
  
  private void a(HashMap<String, String> paramHashMap)
  {
    String str = RIJQQAppInterfaceUtil.d();
    int j = 0;
    if ((str != null) && (!str.equals(c)))
    {
      a = 0;
      b = null;
      c = str;
    }
    Object localObject;
    if (a <= 0)
    {
      localObject = aA;
      if (localObject != null) {
        a = ((ReadInJoyVideoReportData.BucketKeyFetcher)localObject).a();
      }
      if (a <= 0) {
        return;
      }
      b = new int[5];
      i = 0;
      while (i < 5)
      {
        b[i] = -1;
        localObject = aA;
        if (localObject != null) {
          localObject = ((ReadInJoyVideoReportData.BucketKeyFetcher)localObject).a(i);
        } else {
          localObject = null;
        }
        if (localObject != null) {
          b[i] = a(str, (String)localObject);
        }
        i += 1;
      }
    }
    int i = j;
    if (a > 0)
    {
      paramHashMap.put("param_config_ver", String.valueOf(a));
      i = j;
    }
    while (i < 5)
    {
      if (b[i] >= 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("param_bucket");
        ((StringBuilder)localObject).append(i + 1);
        paramHashMap.put(((StringBuilder)localObject).toString(), String.valueOf(b[i]));
      }
      i += 1;
    }
  }
  
  private HashMap<String, String> c()
  {
    HashMap localHashMap = new HashMap(az);
    try
    {
      a(localHashMap);
      label16:
      localHashMap.put("param_uin", RIJQQAppInterfaceUtil.d());
      localHashMap.put("param_vid", this.f);
      localHashMap.put("param_busiType", String.valueOf(this.g));
      localHashMap.put("param_sceneType", String.valueOf(this.t));
      localHashMap.put("param_vid2UrlTime", String.valueOf(this.x));
      localHashMap.put("param_vid2UrlErrorCode", String.valueOf(this.y));
      localHashMap.put("param_isHitCache", String.valueOf(this.H));
      localHashMap.put("param_jumpFromScene", String.valueOf(this.J));
      localHashMap.put("param_index", String.valueOf(this.K));
      localHashMap.put("param_videoBitRate", String.valueOf(this.L));
      localHashMap.put("param_downloadedDuration", String.valueOf(this.N));
      localHashMap.put("param_totalDuration", String.valueOf(this.Q));
      localHashMap.put("param_videoCodeFormat", String.valueOf(this.T));
      localHashMap.put("param_fileBitRate", d());
      localHashMap.put("param_preloadStatus", String.valueOf(this.V));
      String str;
      if (this.e == null) {
        str = "";
      } else {
        str = this.e;
      }
      localHashMap.put("param_rowKey", str);
      localHashMap.put("param_version", "8.8.17.5770");
      localHashMap.put("param_subversion", "8.8.17");
      localHashMap.put("param_bandwidth", String.valueOf(this.an));
      localHashMap.put("param_isSeamlessPlay", String.valueOf(this.at));
      localHashMap.put("param_loop_count", String.valueOf(this.i));
      return localHashMap;
    }
    catch (Exception localException)
    {
      break label16;
    }
  }
  
  private String d()
  {
    if (((this.g == 2) || (this.g == 6)) && (!TextUtils.isEmpty(this.f))) {
      return this.U;
    }
    if ((this.M != 0L) && (this.Q != 0L)) {
      return String.valueOf(this.M * 8L / (this.Q * 1024L));
    }
    return "0";
  }
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = c();
    localHashMap.put("param_articleID", String.valueOf(this.d));
    localHashMap.put("param_success", String.valueOf(this.j).toLowerCase());
    localHashMap.put("param_playDuration", String.valueOf(this.h));
    localHashMap.put("param_prepareDuration", String.valueOf(this.o));
    localHashMap.put("param_bufferTime", String.valueOf(this.q));
    localHashMap.put("param_errCode", this.k);
    localHashMap.put("param_playCompleteRate", String.valueOf(this.r));
    localHashMap.put("param_bufferCount", String.valueOf(this.s));
    localHashMap.put("param_httpDNSTime", String.valueOf(this.u));
    localHashMap.put("param_httpRedirectTime", String.valueOf(this.v));
    localHashMap.put("param_cacheFrameTime", String.valueOf(this.w));
    localHashMap.put("param_firstRecvTime", String.valueOf(this.z));
    localHashMap.put("param_mp4HeaderTime", String.valueOf(this.A));
    localHashMap.put("param_httpConnectTime", String.valueOf(this.B));
    localHashMap.put("param_secondBufferTime", String.valueOf(this.E));
    localHashMap.put("param_secondBufferCount", String.valueOf(this.F));
    localHashMap.put("param_videoFormat", String.valueOf(this.G));
    localHashMap.put("param_errDetailInfo", this.l);
    localHashMap.put("param_scrollInterval", String.valueOf(this.I));
    localHashMap.put("param_fileSize", String.valueOf(this.M));
    localHashMap.put("param_width", String.valueOf(this.R));
    localHashMap.put("param_height", String.valueOf(this.S));
    if (this.g == 2)
    {
      localHashMap.put("param_skipFramesErrorCount", String.valueOf(this.W));
      localHashMap.put("param_device_info", VideoDeviceInfoHelper.a());
    }
    localHashMap.put("param_DeviceOS", String.valueOf(Build.VERSION.SDK_INT));
    if (this.g == 2)
    {
      localHashMap.put("param_isHWCodecFailed", String.valueOf(this.aa));
      localHashMap.put("param_isHWCodec", String.valueOf(this.Z));
      localHashMap.put("param_HWCodecErrorCode", String.valueOf(this.ab));
    }
    localHashMap.put("param_connectQualityReport", this.ac);
    localHashMap.put("param_ABRReportInfo", this.ag);
    if (this.g == 2)
    {
      localHashMap.put("param_videoUrlDomain", this.ad);
      localHashMap.put("param_ipAddressCnt", String.valueOf(this.ae));
      localHashMap.put("param_ipAddressList", this.af);
      localHashMap.put("param_skipFramesTotalCount", String.valueOf(this.X));
      localHashMap.put("param_skipFramesFinalCount", String.valueOf(this.Y));
    }
    localHashMap.put("param_isChangeHWBackup", String.valueOf(this.ai));
    localHashMap.put("param_continuousPlay", String.valueOf(this.ak));
    localHashMap.put("param_hasHWBackup", String.valueOf(this.aj));
    localHashMap.put("param_isPreOutputFirstFrame", String.valueOf(this.al));
    localHashMap.put("param_preparePerformanceJson", this.am);
    localHashMap.put("param_http_buffer_range_tag", this.ao);
    localHashMap.put("param_hardwareLevel", String.valueOf(HardwareUtil.judgeDeviceLevel(BaseApplication.getContext())));
    localHashMap.put("param_deviceInfoJson", HardwareUtil.getDeviceInfoJson());
    localHashMap.put("param_videoCodecEnable", String.valueOf(this.ap));
    localHashMap.put("param_videoCodecReused", String.valueOf(this.aq));
    localHashMap.put("param_videoTotalCodecDuration", String.valueOf(this.ar));
    localHashMap.put("param_videoCodecJson", String.valueOf(this.as));
    localHashMap.put("param_isSuperPlayer", String.valueOf(PlayerHelper.a.a()));
    localHashMap.put("param_renderDuration", String.valueOf(this.au));
    localHashMap.put("param_realRenderDuration", String.valueOf(this.av));
    localHashMap.put("param_codecErrorCodeList", this.aw);
    localHashMap.put("param_codecErrorMsgList", this.ax);
    localHashMap.put("param_videoFrameCheckCode", String.valueOf(this.ay));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("视频性能上报 map = ");
      localStringBuilder.append(localHashMap.toString());
      QLog.d("ReadinjoyVideoReportData", 2, localStringBuilder.toString());
    }
    return localHashMap;
  }
  
  public HashMap<String, String> b()
  {
    return c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData
 * JD-Core Version:    0.7.0.1
 */