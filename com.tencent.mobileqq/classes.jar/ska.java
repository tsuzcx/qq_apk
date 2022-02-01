import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.util.HashMap;
import org.json.JSONObject;

public class ska
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
  private int f;
  
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
  
  public static ska a(VideoInfo paramVideoInfo)
  {
    ska localska = new ska();
    if (paramVideoInfo == null) {
      return localska;
    }
    localska.jdField_d_of_type_JavaLangString = paramVideoInfo.j;
    localska.jdField_a_of_type_Long = 409409L;
    localska.jdField_c_of_type_Int = a(paramVideoInfo.B);
    localska.jdField_c_of_type_JavaLangString = paramVideoInfo.g;
    localska.jdField_b_of_type_Int = paramVideoInfo.c();
    localska.jdField_a_of_type_Int = paramVideoInfo.b();
    return localska;
  }
  
  public static ska a(sey paramsey)
  {
    ska localska = new ska();
    if (paramsey == null) {}
    do
    {
      return localska;
      localska.jdField_d_of_type_JavaLangString = paramsey.k;
      if (paramsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
      {
        localska.jdField_a_of_type_Long = paramsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID;
        localska.jdField_c_of_type_Int = a(paramsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo);
      }
    } while (paramsey.jdField_a_of_type_Rgc == null);
    localska.jdField_c_of_type_JavaLangString = paramsey.jdField_a_of_type_Rgc.jdField_a_of_type_JavaLangString;
    localska.jdField_b_of_type_Int = paramsey.jdField_a_of_type_Rgc.k;
    localska.jdField_a_of_type_Int = paramsey.jdField_a_of_type_Rgc.j;
    return localska;
  }
  
  public HashMap<String, Object> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", "00000T4FEU34A5O9");
    localHashMap.put("dt_pgid", this.jdField_b_of_type_JavaLangString);
    localHashMap.put("channel_id", Long.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("rowkey", this.jdField_c_of_type_JavaLangString);
    localHashMap.put("puin", this.jdField_d_of_type_JavaLangString);
    localHashMap.put("video_static_duration", Long.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("video_height", Integer.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("video_width", Integer.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("is_short", Integer.valueOf(this.jdField_c_of_type_Int));
    localHashMap.put("play_sessionid", this.jdField_e_of_type_JavaLangString);
    localHashMap.put("play_type", Integer.valueOf(this.jdField_d_of_type_Int));
    localHashMap.put("play_loop_type", Integer.valueOf(this.jdField_e_of_type_Int));
    localHashMap.put("play_start_time", Long.valueOf(this.jdField_c_of_type_Long));
    localHashMap.put("play_end_time", Long.valueOf(this.jdField_d_of_type_Long));
    localHashMap.put("play_lvtm", Long.valueOf(this.jdField_e_of_type_Long));
    localHashMap.put("play_loop_times", Integer.valueOf(this.f));
    return localHashMap;
  }
  
  public ska a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public ska a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
    return this;
  }
  
  public ska a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ska a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_d_of_type_Int = i;
      return this;
    }
  }
  
  public ska b(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    return this;
  }
  
  public ska b(long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
    return this;
  }
  
  public ska b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ska c(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public ska c(long paramLong)
  {
    this.jdField_e_of_type_Long = paramLong;
    return this;
  }
  
  public ska c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ska d(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public ska d(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public ska d(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ska e(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public ska e(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    return this;
  }
  
  public ska e(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ska
 * JD-Core Version:    0.7.0.1
 */