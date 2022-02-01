import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.util.HashMap;
import org.json.JSONObject;

public class sbe
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
  
  public static sbe a(VideoInfo paramVideoInfo)
  {
    sbe localsbe = new sbe();
    if (paramVideoInfo == null) {
      return localsbe;
    }
    localsbe.jdField_d_of_type_JavaLangString = paramVideoInfo.j;
    localsbe.jdField_a_of_type_Long = 409409L;
    localsbe.jdField_c_of_type_Int = a(paramVideoInfo.z);
    localsbe.jdField_c_of_type_JavaLangString = paramVideoInfo.g;
    localsbe.jdField_b_of_type_Int = paramVideoInfo.c();
    localsbe.jdField_a_of_type_Int = paramVideoInfo.b();
    return localsbe;
  }
  
  public static sbe a(rwc paramrwc)
  {
    sbe localsbe = new sbe();
    if (paramrwc == null) {}
    do
    {
      return localsbe;
      localsbe.jdField_d_of_type_JavaLangString = paramrwc.k;
      if (paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
      {
        localsbe.jdField_a_of_type_Long = paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID;
        localsbe.jdField_c_of_type_Int = a(paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo);
      }
    } while (paramrwc.jdField_a_of_type_Qwv == null);
    localsbe.jdField_c_of_type_JavaLangString = paramrwc.jdField_a_of_type_Qwv.jdField_a_of_type_JavaLangString;
    localsbe.jdField_b_of_type_Int = paramrwc.jdField_a_of_type_Qwv.k;
    localsbe.jdField_a_of_type_Int = paramrwc.jdField_a_of_type_Qwv.j;
    return localsbe;
  }
  
  public HashMap<String, Object> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", pcz.jdField_a_of_type_JavaLangString);
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
  
  public sbe a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public sbe a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
    return this;
  }
  
  public sbe a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public sbe a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_d_of_type_Int = i;
      return this;
    }
  }
  
  public sbe b(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    return this;
  }
  
  public sbe b(long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
    return this;
  }
  
  public sbe b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public sbe c(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public sbe c(long paramLong)
  {
    this.jdField_e_of_type_Long = paramLong;
    return this;
  }
  
  public sbe c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public sbe d(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public sbe d(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public sbe d(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    return this;
  }
  
  public sbe e(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public sbe e(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    return this;
  }
  
  public sbe e(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbe
 * JD-Core Version:    0.7.0.1
 */