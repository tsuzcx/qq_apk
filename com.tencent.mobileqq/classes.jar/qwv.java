import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.utils.HardwareUtil;
import java.util.HashMap;

public class qwv
{
  public float a;
  public int a;
  public long a;
  public Long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public boolean e;
  public int f;
  public long f;
  public String f;
  public boolean f;
  public int g;
  public long g;
  public String g;
  public boolean g;
  public int h;
  public long h;
  public String h;
  public boolean h;
  public int i;
  public long i;
  public String i;
  public boolean i;
  public int j;
  public long j;
  public String j;
  public boolean j;
  public int k;
  public long k;
  public String k;
  public boolean k;
  public int l;
  public long l;
  public String l;
  public boolean l;
  public int m;
  public long m;
  public String m;
  public int n;
  public long n;
  public String n;
  public int o;
  public long o;
  public String o;
  public int p;
  public long p;
  public String p;
  public int q;
  public long q;
  public int r;
  public long r;
  public int s;
  public long s;
  public int t;
  public long t;
  public long u;
  public long v;
  public long w;
  
  public qwv()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = 0;
    this.jdField_o_of_type_Long = -1L;
    this.jdField_h_of_type_Int = -1;
    this.jdField_i_of_type_Int = -1;
    this.jdField_n_of_type_Int = 0;
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_s_of_type_Int = -1;
    this.jdField_t_of_type_Int = -1;
  }
  
  private String a()
  {
    if (((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 6)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      return this.jdField_e_of_type_JavaLangString;
    }
    if ((this.jdField_q_of_type_Long == 0L) || (this.jdField_s_of_type_Long == 0L)) {
      return "0";
    }
    return String.valueOf(this.jdField_q_of_type_Long * 8L / (this.jdField_s_of_type_Long * 1024L));
  }
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", ozs.a());
    localHashMap.put("param_articleID", String.valueOf(this.jdField_a_of_type_JavaLangLong));
    localHashMap.put("param_vid", this.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_busiType", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_success", String.valueOf(this.jdField_a_of_type_Boolean).toLowerCase());
    localHashMap.put("param_playDuration", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("param_prepareDuration", String.valueOf(this.jdField_d_of_type_Long));
    localHashMap.put("param_bufferTime", String.valueOf(this.jdField_f_of_type_Long));
    localHashMap.put("param_errCode", this.jdField_c_of_type_JavaLangString);
    localHashMap.put("param_playCompleteRate", String.valueOf(this.jdField_a_of_type_Float));
    localHashMap.put("param_bufferCount", String.valueOf(this.jdField_c_of_type_Int));
    localHashMap.put("param_sceneType", String.valueOf(this.jdField_d_of_type_Int));
    localHashMap.put("param_httpDNSTime", String.valueOf(this.jdField_g_of_type_Long));
    localHashMap.put("param_httpRedirectTime", String.valueOf(this.jdField_h_of_type_Long));
    localHashMap.put("param_cacheFrameTime", String.valueOf(this.jdField_i_of_type_Long));
    localHashMap.put("param_vid2UrlTime", String.valueOf(this.jdField_j_of_type_Long));
    localHashMap.put("param_firstRecvTime", String.valueOf(this.jdField_k_of_type_Long));
    localHashMap.put("param_mp4HeaderTime", String.valueOf(this.jdField_l_of_type_Long));
    localHashMap.put("param_httpConnectTime", String.valueOf(this.jdField_m_of_type_Long));
    localHashMap.put("param_secondBufferTime", String.valueOf(this.jdField_n_of_type_Long));
    localHashMap.put("param_secondBufferCount", String.valueOf(this.jdField_f_of_type_Int));
    localHashMap.put("param_videoFormat", String.valueOf(this.jdField_g_of_type_Int));
    localHashMap.put("param_isHitCache", String.valueOf(this.jdField_c_of_type_Boolean));
    localHashMap.put("param_errDetailInfo", this.jdField_d_of_type_JavaLangString);
    localHashMap.put("param_scrollInterval", String.valueOf(this.jdField_o_of_type_Long));
    localHashMap.put("param_jumpFromScene", String.valueOf(this.jdField_h_of_type_Int));
    localHashMap.put("param_index", String.valueOf(this.jdField_i_of_type_Int));
    localHashMap.put("param_videoBitRate", String.valueOf(this.jdField_p_of_type_Long));
    localHashMap.put("param_fileSize", String.valueOf(this.jdField_q_of_type_Long));
    localHashMap.put("param_downloadedDuration", String.valueOf(this.jdField_r_of_type_Long));
    localHashMap.put("param_width", String.valueOf(this.jdField_l_of_type_Int));
    localHashMap.put("param_height", String.valueOf(this.jdField_m_of_type_Int));
    localHashMap.put("param_totalDuration", String.valueOf(this.jdField_s_of_type_Long));
    localHashMap.put("param_videoCodeFormat", String.valueOf(this.jdField_d_of_type_Boolean));
    localHashMap.put("param_fileBitRate", a());
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (String str = "";; str = this.jdField_a_of_type_JavaLangString)
    {
      localHashMap.put("param_rowKey", str);
      localHashMap.put("param_preloadStatus", String.valueOf(this.jdField_n_of_type_Int));
      if (this.jdField_a_of_type_Int == 2)
      {
        localHashMap.put("param_skipFramesErrorCount", String.valueOf(this.jdField_o_of_type_Int));
        localHashMap.put("param_device_info", rne.a());
      }
      localHashMap.put("param_DeviceOS", String.valueOf(Build.VERSION.SDK_INT));
      if (this.jdField_a_of_type_Int == 2)
      {
        localHashMap.put("param_isHWCodecFailed", String.valueOf(this.jdField_f_of_type_Boolean));
        localHashMap.put("param_isHWCodec", String.valueOf(this.jdField_e_of_type_Boolean));
        localHashMap.put("param_HWCodecErrorCode", String.valueOf(this.jdField_f_of_type_JavaLangString));
      }
      localHashMap.put("param_connectQualityReport", this.jdField_g_of_type_JavaLangString);
      localHashMap.put("param_ABRReportInfo", this.jdField_j_of_type_JavaLangString);
      if (this.jdField_a_of_type_Int == 2)
      {
        localHashMap.put("param_videoUrlDomain", this.jdField_h_of_type_JavaLangString);
        localHashMap.put("param_ipAddressCnt", String.valueOf(this.jdField_r_of_type_Int));
        localHashMap.put("param_ipAddressList", this.jdField_i_of_type_JavaLangString);
        localHashMap.put("param_skipFramesTotalCount", String.valueOf(this.jdField_p_of_type_Int));
        localHashMap.put("param_skipFramesFinalCount", String.valueOf(this.jdField_q_of_type_Int));
      }
      localHashMap.put("param_version", "8.4.5.4745");
      localHashMap.put("param_subversion", "8.4.5");
      localHashMap.put("param_isChangeHWBackup", String.valueOf(this.jdField_g_of_type_Boolean));
      localHashMap.put("param_continuousPlay", String.valueOf(this.jdField_s_of_type_Int));
      localHashMap.put("param_hasHWBackup", String.valueOf(this.jdField_h_of_type_Boolean));
      localHashMap.put("param_isPreOutputFirstFrame", String.valueOf(this.jdField_i_of_type_Boolean));
      localHashMap.put("param_preparePerformanceJson", this.jdField_l_of_type_JavaLangString);
      localHashMap.put("param_prepareOptimizeConfigJson", ozs.m());
      localHashMap.put("param_httpbuffertime_for_playpreload", String.valueOf(bnrf.f()));
      localHashMap.put("param_dynamic_buffer_switch", String.valueOf(bnrf.g()));
      localHashMap.put("param_dynamic_buffer_config_json", bnrf.c());
      localHashMap.put("param_bandwidth", String.valueOf(this.jdField_t_of_type_Long));
      localHashMap.put("param_http_buffer_range_tag", this.jdField_m_of_type_JavaLangString);
      localHashMap.put("param_loop_count", String.valueOf(this.jdField_b_of_type_Int));
      localHashMap.put("param_hardwareLevel", String.valueOf(HardwareUtil.judgeDeviceLevel(BaseApplication.getContext())));
      localHashMap.put("param_deviceInfoJson", HardwareUtil.getDeviceInfoJson());
      localHashMap.put("param_videoCodecEnable", String.valueOf(this.jdField_j_of_type_Boolean));
      localHashMap.put("param_videoCodecReused", String.valueOf(this.jdField_k_of_type_Boolean));
      localHashMap.put("param_videoTotalCodecDuration", String.valueOf(this.u));
      localHashMap.put("param_videoCodecJson", String.valueOf(this.jdField_n_of_type_JavaLangString));
      localHashMap.put("param_isSuperPlayer", String.valueOf(sac.a.a()));
      localHashMap.put("param_isSeamlessPlay", String.valueOf(this.jdField_l_of_type_Boolean));
      localHashMap.put("param_renderDuration", String.valueOf(this.v));
      localHashMap.put("param_realRenderDuration", String.valueOf(this.w));
      localHashMap.put("param_codecReuseConfigVersion", String.valueOf(rle.a.a()));
      localHashMap.put("param_codecReuseDeviceSupport", String.valueOf(rle.a.a()));
      localHashMap.put("param_codecErrorCodeList", this.jdField_o_of_type_JavaLangString);
      localHashMap.put("param_codecErrorMsgList", this.jdField_p_of_type_JavaLangString);
      localHashMap.put("param_videoFrameCheckCode", String.valueOf(this.jdField_t_of_type_Int));
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyVideoReportData", 2, "视频性能上报 map = " + localHashMap.toString());
      }
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qwv
 * JD-Core Version:    0.7.0.1
 */