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
  private static ReadInJoyVideoReportData.BucketKeyFetcher a;
  public static Map<String, String> a;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
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
  
  private String a()
  {
    if (((this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 6)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      return this.jdField_f_of_type_JavaLangString;
    }
    if ((this.jdField_q_of_type_Long != 0L) && (this.jdField_s_of_type_Long != 0L)) {
      return String.valueOf(this.jdField_q_of_type_Long * 8L / (this.jdField_s_of_type_Long * 1024L));
    }
    return "0";
  }
  
  public static void a(ReadInJoyVideoReportData.BucketKeyFetcher paramBucketKeyFetcher)
  {
    jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData$BucketKeyFetcher = paramBucketKeyFetcher;
  }
  
  private void a(HashMap<String, String> paramHashMap)
  {
    String str = RIJQQAppInterfaceUtil.a();
    int j = 0;
    if ((str != null) && (!str.equals(jdField_a_of_type_JavaLangString)))
    {
      jdField_a_of_type_Int = 0;
      jdField_a_of_type_ArrayOfInt = null;
      jdField_a_of_type_JavaLangString = str;
    }
    Object localObject;
    if (jdField_a_of_type_Int <= 0)
    {
      localObject = jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData$BucketKeyFetcher;
      if (localObject != null) {
        jdField_a_of_type_Int = ((ReadInJoyVideoReportData.BucketKeyFetcher)localObject).a();
      }
      if (jdField_a_of_type_Int <= 0) {
        return;
      }
      jdField_a_of_type_ArrayOfInt = new int[5];
      i = 0;
      while (i < 5)
      {
        jdField_a_of_type_ArrayOfInt[i] = -1;
        localObject = jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataReadInJoyVideoReportData$BucketKeyFetcher;
        if (localObject != null) {
          localObject = ((ReadInJoyVideoReportData.BucketKeyFetcher)localObject).a(i);
        } else {
          localObject = null;
        }
        if (localObject != null) {
          jdField_a_of_type_ArrayOfInt[i] = a(str, (String)localObject);
        }
        i += 1;
      }
    }
    int i = j;
    if (jdField_a_of_type_Int > 0)
    {
      paramHashMap.put("param_config_ver", String.valueOf(jdField_a_of_type_Int));
      i = j;
    }
    while (i < 5)
    {
      if (jdField_a_of_type_ArrayOfInt[i] >= 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("param_bucket");
        ((StringBuilder)localObject).append(i + 1);
        paramHashMap.put(((StringBuilder)localObject).toString(), String.valueOf(jdField_a_of_type_ArrayOfInt[i]));
      }
      i += 1;
    }
  }
  
  private HashMap<String, String> c()
  {
    HashMap localHashMap = new HashMap(jdField_a_of_type_JavaUtilMap);
    try
    {
      a(localHashMap);
      label16:
      localHashMap.put("param_uin", RIJQQAppInterfaceUtil.a());
      localHashMap.put("param_vid", this.jdField_c_of_type_JavaLangString);
      localHashMap.put("param_busiType", String.valueOf(this.jdField_b_of_type_Int));
      localHashMap.put("param_sceneType", String.valueOf(this.jdField_e_of_type_Int));
      localHashMap.put("param_vid2UrlTime", String.valueOf(this.jdField_j_of_type_Long));
      localHashMap.put("param_vid2UrlErrorCode", String.valueOf(this.jdField_f_of_type_Int));
      localHashMap.put("param_isHitCache", String.valueOf(this.jdField_c_of_type_Boolean));
      localHashMap.put("param_jumpFromScene", String.valueOf(this.jdField_j_of_type_Int));
      localHashMap.put("param_index", String.valueOf(this.jdField_k_of_type_Int));
      localHashMap.put("param_videoBitRate", String.valueOf(this.jdField_p_of_type_Long));
      localHashMap.put("param_downloadedDuration", String.valueOf(this.jdField_r_of_type_Long));
      localHashMap.put("param_totalDuration", String.valueOf(this.jdField_s_of_type_Long));
      localHashMap.put("param_videoCodeFormat", String.valueOf(this.jdField_d_of_type_Boolean));
      localHashMap.put("param_fileBitRate", a());
      localHashMap.put("param_preloadStatus", String.valueOf(this.jdField_p_of_type_Int));
      String str;
      if (this.jdField_b_of_type_JavaLangString == null) {
        str = "";
      } else {
        str = this.jdField_b_of_type_JavaLangString;
      }
      localHashMap.put("param_rowKey", str);
      localHashMap.put("param_version", "8.7.0.5295");
      localHashMap.put("param_subversion", "8.7.0");
      localHashMap.put("param_bandwidth", String.valueOf(this.jdField_t_of_type_Long));
      localHashMap.put("param_isSeamlessPlay", String.valueOf(this.jdField_l_of_type_Boolean));
      localHashMap.put("param_loop_count", String.valueOf(this.jdField_c_of_type_Int));
      return localHashMap;
    }
    catch (Exception localException)
    {
      break label16;
    }
  }
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = c();
    localHashMap.put("param_articleID", String.valueOf(this.jdField_a_of_type_JavaLangLong));
    localHashMap.put("param_success", String.valueOf(this.jdField_a_of_type_Boolean).toLowerCase());
    localHashMap.put("param_playDuration", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("param_prepareDuration", String.valueOf(this.jdField_d_of_type_Long));
    localHashMap.put("param_bufferTime", String.valueOf(this.jdField_f_of_type_Long));
    localHashMap.put("param_errCode", this.jdField_d_of_type_JavaLangString);
    localHashMap.put("param_playCompleteRate", String.valueOf(this.jdField_a_of_type_Float));
    localHashMap.put("param_bufferCount", String.valueOf(this.jdField_d_of_type_Int));
    localHashMap.put("param_httpDNSTime", String.valueOf(this.jdField_g_of_type_Long));
    localHashMap.put("param_httpRedirectTime", String.valueOf(this.jdField_h_of_type_Long));
    localHashMap.put("param_cacheFrameTime", String.valueOf(this.jdField_i_of_type_Long));
    localHashMap.put("param_firstRecvTime", String.valueOf(this.jdField_k_of_type_Long));
    localHashMap.put("param_mp4HeaderTime", String.valueOf(this.jdField_l_of_type_Long));
    localHashMap.put("param_httpConnectTime", String.valueOf(this.jdField_m_of_type_Long));
    localHashMap.put("param_secondBufferTime", String.valueOf(this.jdField_n_of_type_Long));
    localHashMap.put("param_secondBufferCount", String.valueOf(this.jdField_h_of_type_Int));
    localHashMap.put("param_videoFormat", String.valueOf(this.jdField_i_of_type_Int));
    localHashMap.put("param_errDetailInfo", this.jdField_e_of_type_JavaLangString);
    localHashMap.put("param_scrollInterval", String.valueOf(this.jdField_o_of_type_Long));
    localHashMap.put("param_fileSize", String.valueOf(this.jdField_q_of_type_Long));
    localHashMap.put("param_width", String.valueOf(this.jdField_n_of_type_Int));
    localHashMap.put("param_height", String.valueOf(this.jdField_o_of_type_Int));
    if (this.jdField_b_of_type_Int == 2)
    {
      localHashMap.put("param_skipFramesErrorCount", String.valueOf(this.jdField_q_of_type_Int));
      localHashMap.put("param_device_info", VideoDeviceInfoHelper.a());
    }
    localHashMap.put("param_DeviceOS", String.valueOf(Build.VERSION.SDK_INT));
    if (this.jdField_b_of_type_Int == 2)
    {
      localHashMap.put("param_isHWCodecFailed", String.valueOf(this.jdField_f_of_type_Boolean));
      localHashMap.put("param_isHWCodec", String.valueOf(this.jdField_e_of_type_Boolean));
      localHashMap.put("param_HWCodecErrorCode", String.valueOf(this.jdField_g_of_type_JavaLangString));
    }
    localHashMap.put("param_connectQualityReport", this.jdField_h_of_type_JavaLangString);
    localHashMap.put("param_ABRReportInfo", this.jdField_k_of_type_JavaLangString);
    if (this.jdField_b_of_type_Int == 2)
    {
      localHashMap.put("param_videoUrlDomain", this.jdField_i_of_type_JavaLangString);
      localHashMap.put("param_ipAddressCnt", String.valueOf(this.jdField_t_of_type_Int));
      localHashMap.put("param_ipAddressList", this.jdField_j_of_type_JavaLangString);
      localHashMap.put("param_skipFramesTotalCount", String.valueOf(this.jdField_r_of_type_Int));
      localHashMap.put("param_skipFramesFinalCount", String.valueOf(this.jdField_s_of_type_Int));
    }
    localHashMap.put("param_isChangeHWBackup", String.valueOf(this.jdField_g_of_type_Boolean));
    localHashMap.put("param_continuousPlay", String.valueOf(this.jdField_u_of_type_Int));
    localHashMap.put("param_hasHWBackup", String.valueOf(this.jdField_h_of_type_Boolean));
    localHashMap.put("param_isPreOutputFirstFrame", String.valueOf(this.jdField_i_of_type_Boolean));
    localHashMap.put("param_preparePerformanceJson", this.jdField_m_of_type_JavaLangString);
    localHashMap.put("param_http_buffer_range_tag", this.jdField_n_of_type_JavaLangString);
    localHashMap.put("param_hardwareLevel", String.valueOf(HardwareUtil.judgeDeviceLevel(BaseApplication.getContext())));
    localHashMap.put("param_deviceInfoJson", HardwareUtil.getDeviceInfoJson());
    localHashMap.put("param_videoCodecEnable", String.valueOf(this.jdField_j_of_type_Boolean));
    localHashMap.put("param_videoCodecReused", String.valueOf(this.jdField_k_of_type_Boolean));
    localHashMap.put("param_videoTotalCodecDuration", String.valueOf(this.jdField_u_of_type_Long));
    localHashMap.put("param_videoCodecJson", String.valueOf(this.jdField_o_of_type_JavaLangString));
    localHashMap.put("param_isSuperPlayer", String.valueOf(PlayerHelper.a.a()));
    localHashMap.put("param_renderDuration", String.valueOf(this.jdField_v_of_type_Long));
    localHashMap.put("param_realRenderDuration", String.valueOf(this.w));
    localHashMap.put("param_codecErrorCodeList", this.jdField_p_of_type_JavaLangString);
    localHashMap.put("param_codecErrorMsgList", this.jdField_q_of_type_JavaLangString);
    localHashMap.put("param_videoFrameCheckCode", String.valueOf(this.jdField_v_of_type_Int));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData
 * JD-Core Version:    0.7.0.1
 */