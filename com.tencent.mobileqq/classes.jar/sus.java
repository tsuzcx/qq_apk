import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.util.HashMap;
import org.json.JSONObject;

public class sus
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
  
  public static sus a(VideoInfo paramVideoInfo)
  {
    sus localsus = new sus();
    if (paramVideoInfo == null) {
      return localsus;
    }
    localsus.jdField_c_of_type_JavaLangString = paramVideoInfo.jdField_a_of_type_JavaLangString;
    localsus.jdField_e_of_type_JavaLangString = paramVideoInfo.j;
    localsus.jdField_a_of_type_Long = 409409L;
    localsus.jdField_c_of_type_Int = a(paramVideoInfo.w);
    localsus.jdField_d_of_type_JavaLangString = paramVideoInfo.g;
    localsus.jdField_b_of_type_Int = paramVideoInfo.c();
    localsus.jdField_a_of_type_Int = paramVideoInfo.b();
    localsus.g = paramVideoInfo.w;
    return localsus;
  }
  
  public static sus a(spk paramspk)
  {
    sus localsus = new sus();
    if (paramspk == null) {}
    do
    {
      return localsus;
      localsus.jdField_e_of_type_JavaLangString = paramspk.k;
      localsus.jdField_c_of_type_JavaLangString = paramspk.jdField_c_of_type_JavaLangString;
      if (paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
      {
        localsus.jdField_a_of_type_Long = paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID;
        localsus.jdField_c_of_type_Int = a(paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo);
        localsus.g = paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo;
      }
    } while (paramspk.jdField_a_of_type_Rqa == null);
    localsus.jdField_d_of_type_JavaLangString = paramspk.jdField_a_of_type_Rqa.jdField_a_of_type_JavaLangString;
    localsus.jdField_b_of_type_Int = paramspk.jdField_a_of_type_Rqa.k;
    localsus.jdField_a_of_type_Int = paramspk.jdField_a_of_type_Rqa.j;
    return localsus;
  }
  
  public HashMap<String, Object> a()
  {
    int i = 1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", pth.jdField_a_of_type_JavaLangString);
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
  
  public sus a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public sus a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
    return this;
  }
  
  public sus a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public sus a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_d_of_type_Int = i;
      return this;
    }
  }
  
  public sus b(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    return this;
  }
  
  public sus b(long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
    return this;
  }
  
  public sus b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public sus c(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    return this;
  }
  
  public sus c(long paramLong)
  {
    this.jdField_e_of_type_Long = paramLong;
    return this;
  }
  
  public sus c(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    return this;
  }
  
  public sus d(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public sus d(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public sus d(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    return this;
  }
  
  public sus e(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public sus e(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    return this;
  }
  
  public sus e(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sus
 * JD-Core Version:    0.7.0.1
 */