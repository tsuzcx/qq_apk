import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.util.HashMap;
import org.json.JSONObject;

public class sic
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString = "";
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString = "";
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString = "";
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString = "";
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString = "";
  private String g;
  
  private static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("short_v");
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static sic a(VideoInfo paramVideoInfo)
  {
    sic localsic = new sic();
    if (paramVideoInfo == null) {
      return localsic;
    }
    localsic.jdField_c_of_type_JavaLangString = paramVideoInfo.jdField_a_of_type_JavaLangString;
    localsic.jdField_e_of_type_JavaLangString = paramVideoInfo.j;
    localsic.jdField_a_of_type_Long = 409409L;
    localsic.jdField_c_of_type_Int = a(paramVideoInfo.y);
    localsic.jdField_d_of_type_JavaLangString = paramVideoInfo.g;
    localsic.jdField_b_of_type_Int = paramVideoInfo.c();
    localsic.jdField_a_of_type_Int = paramVideoInfo.b();
    localsic.g = paramVideoInfo.y;
    return localsic;
  }
  
  public static sic a(sdg paramsdg)
  {
    sic localsic = new sic();
    if (paramsdg == null) {}
    do
    {
      return localsic;
      localsic.jdField_e_of_type_JavaLangString = paramsdg.k;
      localsic.jdField_c_of_type_JavaLangString = paramsdg.jdField_c_of_type_JavaLangString;
      if (paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
      {
        localsic.jdField_a_of_type_Long = paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID;
        localsic.jdField_c_of_type_Int = a(paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo);
        localsic.g = paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo;
      }
    } while (paramsdg.jdField_a_of_type_Rdt == null);
    localsic.jdField_d_of_type_JavaLangString = paramsdg.jdField_a_of_type_Rdt.jdField_a_of_type_JavaLangString;
    localsic.jdField_b_of_type_Int = paramsdg.jdField_a_of_type_Rdt.k;
    localsic.jdField_a_of_type_Int = paramsdg.jdField_a_of_type_Rdt.j;
    return localsic;
  }
  
  public HashMap<String, Object> a()
  {
    int i = 1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", pik.jdField_a_of_type_JavaLangString);
    localHashMap.put("dt_pgid", this.jdField_b_of_type_JavaLangString);
    localHashMap.put("channel_id", Long.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("vid", this.jdField_c_of_type_JavaLangString);
    localHashMap.put("rowkey", this.jdField_d_of_type_JavaLangString);
    localHashMap.put("cid", "");
    localHashMap.put("cmsid", "");
    localHashMap.put("puin", this.jdField_e_of_type_JavaLangString);
    localHashMap.put("video_static_duration", Long.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("video_height", Integer.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("video_width", Integer.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("is_short", Integer.valueOf(this.jdField_c_of_type_Int));
    localHashMap.put("play_sessionid", this.jdField_f_of_type_JavaLangString);
    localHashMap.put("play_type", Integer.valueOf(this.jdField_d_of_type_Int));
    localHashMap.put("play_loop_type", Integer.valueOf(this.jdField_e_of_type_Int));
    localHashMap.put("play_start_time", Long.valueOf(this.jdField_c_of_type_Long));
    localHashMap.put("play_end_time", Long.valueOf(this.jdField_d_of_type_Long));
    localHashMap.put("play_lvtm", Long.valueOf(this.jdField_e_of_type_Long));
    localHashMap.put("play_loop_times", Integer.valueOf(this.jdField_f_of_type_Int));
    localHashMap.put("backend_info", this.g);
    if (this.jdField_c_of_type_Int == 1) {}
    for (;;)
    {
      localHashMap.put("content_type", Integer.valueOf(i));
      return localHashMap;
      i = 6;
    }
  }
  
  public sic a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public sic a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
    return this;
  }
  
  public sic a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public sic a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_d_of_type_Int = i;
      return this;
    }
  }
  
  public sic b(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    return this;
  }
  
  public sic b(long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
    return this;
  }
  
  public sic b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public sic c(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    return this;
  }
  
  public sic c(long paramLong)
  {
    this.jdField_e_of_type_Long = paramLong;
    return this;
  }
  
  public sic c(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    return this;
  }
  
  public sic d(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public sic d(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public sic d(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    return this;
  }
  
  public sic e(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public sic e(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    return this;
  }
  
  public sic e(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sic
 * JD-Core Version:    0.7.0.1
 */