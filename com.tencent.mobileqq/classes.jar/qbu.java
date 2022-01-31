import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class qbu
{
  public long A;
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
  public int k;
  public long k;
  public String k;
  public int l;
  public long l;
  public String l;
  public int m;
  public long m;
  public String m;
  public int n;
  public long n;
  public int o;
  public long o;
  public int p;
  public long p;
  public int q;
  public long q;
  public int r;
  public long r;
  public long s;
  public long t = -1L;
  public long u = -1L;
  public long v;
  public long w;
  public long x;
  public long y;
  public long z;
  
  public qbu()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = 0;
    this.jdField_n_of_type_Long = -1L;
    this.jdField_g_of_type_Int = -1;
    this.jdField_h_of_type_Int = -1;
    this.jdField_m_of_type_Int = 0;
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_r_of_type_Int = -1;
  }
  
  private String a()
  {
    if (((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 6)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      return this.jdField_e_of_type_JavaLangString;
    }
    if ((this.jdField_p_of_type_Long == 0L) || (this.s == 0L)) {
      return "0";
    }
    return String.valueOf(this.jdField_p_of_type_Long * 8L / (this.s * 1024L));
  }
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_articleID", String.valueOf(this.jdField_a_of_type_JavaLangLong));
    localHashMap.put("param_vid", this.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_busiType", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_success", String.valueOf(this.jdField_a_of_type_Boolean).toLowerCase());
    localHashMap.put("param_playDuration", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("param_prepareDuration", String.valueOf(this.jdField_c_of_type_Long));
    localHashMap.put("param_bufferTime", String.valueOf(this.jdField_e_of_type_Long));
    localHashMap.put("param_errCode", this.jdField_c_of_type_JavaLangString);
    localHashMap.put("param_playCompleteRate", String.valueOf(this.jdField_a_of_type_Float));
    localHashMap.put("param_bufferCount", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("param_sceneType", String.valueOf(this.jdField_c_of_type_Int));
    localHashMap.put("param_httpDNSTime", String.valueOf(this.jdField_f_of_type_Long));
    localHashMap.put("param_httpRedirectTime", String.valueOf(this.jdField_g_of_type_Long));
    localHashMap.put("param_cacheFrameTime", String.valueOf(this.jdField_h_of_type_Long));
    localHashMap.put("param_vid2UrlTime", String.valueOf(this.jdField_i_of_type_Long));
    localHashMap.put("param_firstRecvTime", String.valueOf(this.jdField_j_of_type_Long));
    localHashMap.put("param_mp4HeaderTime", String.valueOf(this.jdField_k_of_type_Long));
    localHashMap.put("param_httpConnectTime", String.valueOf(this.jdField_l_of_type_Long));
    localHashMap.put("param_secondBufferTime", String.valueOf(this.jdField_m_of_type_Long));
    localHashMap.put("param_secondBufferCount", String.valueOf(this.jdField_e_of_type_Int));
    localHashMap.put("param_videoFormat", String.valueOf(this.jdField_f_of_type_Int));
    localHashMap.put("param_isHitCache", String.valueOf(this.jdField_c_of_type_Boolean));
    localHashMap.put("param_errDetailInfo", this.jdField_d_of_type_JavaLangString);
    localHashMap.put("param_scrollInterval", String.valueOf(this.jdField_n_of_type_Long));
    localHashMap.put("param_jumpFromScene", String.valueOf(this.jdField_g_of_type_Int));
    localHashMap.put("param_index", String.valueOf(this.jdField_h_of_type_Int));
    localHashMap.put("param_videoBitRate", String.valueOf(this.jdField_o_of_type_Long));
    localHashMap.put("param_fileSize", String.valueOf(this.jdField_p_of_type_Long));
    localHashMap.put("param_downloadedDuration", String.valueOf(this.jdField_r_of_type_Long));
    localHashMap.put("param_width", String.valueOf(this.jdField_k_of_type_Int));
    localHashMap.put("param_height", String.valueOf(this.jdField_l_of_type_Int));
    localHashMap.put("param_totalDuration", String.valueOf(this.s));
    localHashMap.put("param_videoCodeFormat", String.valueOf(this.jdField_d_of_type_Boolean));
    localHashMap.put("param_listSpeedKBS", this.jdField_f_of_type_JavaLangString);
    if (this.jdField_q_of_type_Long >= 0L) {
      localHashMap.put("param_averageSpeedKBS", String.valueOf(this.jdField_q_of_type_Long));
    }
    if (this.t >= 0L) {
      localHashMap.put("param_maxSpeedKBS", String.valueOf(this.t));
    }
    if (this.u >= 0L) {
      localHashMap.put("param_minSpeedKBS", String.valueOf(this.u));
    }
    localHashMap.put("param_fileBitRate", a());
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (String str = "";; str = this.jdField_a_of_type_JavaLangString)
    {
      localHashMap.put("param_rowKey", str);
      localHashMap.put("param_preloadStatus", String.valueOf(this.jdField_m_of_type_Int));
      if (this.jdField_a_of_type_Int == 2)
      {
        localHashMap.put("param_skipFramesErrorCount", String.valueOf(this.jdField_n_of_type_Int));
        localHashMap.put("param_device_info", qkx.a(false));
      }
      localHashMap.put("param_DeviceOS", String.valueOf(Build.VERSION.SDK_INT));
      if (this.jdField_a_of_type_Int == 2)
      {
        localHashMap.put("param_isHWCodecFailed", String.valueOf(this.jdField_f_of_type_Boolean));
        localHashMap.put("param_isHWCodec", String.valueOf(this.jdField_e_of_type_Boolean));
        localHashMap.put("param_HWCodecErrorCode", String.valueOf(this.jdField_g_of_type_JavaLangString));
      }
      localHashMap.put("param_connectQualityReport", this.jdField_h_of_type_JavaLangString);
      localHashMap.put("param_ABRReportInfo", this.jdField_k_of_type_JavaLangString);
      if (this.jdField_a_of_type_Int == 2)
      {
        localHashMap.put("param_videoUrlDomain", this.jdField_i_of_type_JavaLangString);
        localHashMap.put("param_ipAddressCnt", String.valueOf(this.jdField_q_of_type_Int));
        localHashMap.put("param_ipAddressList", this.jdField_j_of_type_JavaLangString);
        localHashMap.put("param_skipFramesTotalCount", String.valueOf(this.jdField_o_of_type_Int));
        localHashMap.put("param_skipFramesFinalCount", String.valueOf(this.jdField_p_of_type_Int));
      }
      localHashMap.put("param_version", "8.3.0.4480");
      localHashMap.put("param_subversion", "8.3.0");
      localHashMap.put("param_speedList", this.jdField_l_of_type_JavaLangString);
      localHashMap.put("param_isChangeHWBackup", String.valueOf(this.jdField_g_of_type_Boolean));
      localHashMap.put("param_continuousPlay", String.valueOf(this.jdField_r_of_type_Int));
      localHashMap.put("param_hasHWBackup", String.valueOf(this.jdField_h_of_type_Boolean));
      localHashMap.put("param_isPreOutputFirstFrame", String.valueOf(this.jdField_i_of_type_Boolean));
      localHashMap.put("param_preparePerformanceJson", this.jdField_m_of_type_JavaLangString);
      localHashMap.put("param_prepareOptimizeConfigJson", onh.j());
      localHashMap.put("param_httpbuffertime_for_playpreload", String.valueOf(bhvy.f()));
      localHashMap.put("param_dynamic_buffer_switch", String.valueOf(bhvy.g()));
      localHashMap.put("param_dynamic_buffer_config_json", bhvy.b());
      localHashMap.put("param_bandwidth", String.valueOf(this.v));
      localHashMap.put("param_exoBandwidth", String.valueOf(this.w));
      localHashMap.put("param_doubleMoveAvgBandwidth", String.valueOf(this.x));
      localHashMap.put("param_doubleExponentialBandwidth", String.valueOf(this.y));
      localHashMap.put("param_maxBandwidth", String.valueOf(this.z));
      localHashMap.put("param_avgBandwidth", String.valueOf(this.A));
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyVideoReportData", 2, "视频性能上报 map = " + localHashMap.toString());
      }
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qbu
 * JD-Core Version:    0.7.0.1
 */