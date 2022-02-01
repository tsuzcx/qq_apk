import android.text.TextUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class nyl
{
  public static final Map<Class<?>, Integer> a;
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public String i;
  public String j;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilMap.put(Boolean.TYPE, Integer.valueOf(1));
    jdField_a_of_type_JavaUtilMap.put(Integer.TYPE, Integer.valueOf(2));
    jdField_a_of_type_JavaUtilMap.put(Long.TYPE, Integer.valueOf(3));
    jdField_a_of_type_JavaUtilMap.put(String.class, Integer.valueOf(4));
    jdField_a_of_type_JavaUtilMap.put(Double.TYPE, Integer.valueOf(5));
  }
  
  public nyl() {}
  
  public nyl(mobileqq_mp.ConfigInfo paramConfigInfo)
  {
    this.jdField_a_of_type_Int = paramConfigInfo.type.get();
    this.jdField_a_of_type_JavaLangString = paramConfigInfo.title.get();
    this.jdField_b_of_type_JavaLangString = paramConfigInfo.content.get();
    this.jdField_c_of_type_Int = paramConfigInfo.event_id.get();
    this.jdField_c_of_type_JavaLangString = paramConfigInfo.url.get();
    this.jdField_d_of_type_Int = paramConfigInfo.state.get();
    this.jdField_e_of_type_Int = paramConfigInfo.state_id.get();
    this.jdField_f_of_type_Int = paramConfigInfo.confirm_flag.get();
    this.jdField_d_of_type_JavaLangString = paramConfigInfo.confirm_tips.get();
  }
  
  public static nyl a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    nyl localnyl;
    for (;;)
    {
      return paramJSONObject;
      localnyl = new nyl();
      try
      {
        localnyl.jdField_a_of_type_Int = paramJSONObject.optInt("type");
        localnyl.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title");
        localnyl.jdField_b_of_type_JavaLangString = paramJSONObject.optString("content");
        localnyl.jdField_b_of_type_Int = paramJSONObject.optInt("follow_handle");
        localnyl.jdField_c_of_type_Int = paramJSONObject.optInt("event_id");
        localnyl.jdField_d_of_type_Int = paramJSONObject.optInt("state");
        localnyl.jdField_e_of_type_Int = paramJSONObject.optInt("state_id");
        localnyl.jdField_c_of_type_JavaLangString = paramJSONObject.optString("url");
        localnyl.jdField_f_of_type_Int = paramJSONObject.optInt("confirm_flag");
        localnyl.jdField_d_of_type_JavaLangString = paramJSONObject.optString("confirm_tips");
        localnyl.jdField_e_of_type_JavaLangString = paramJSONObject.optString("pic_url");
        localnyl.jdField_f_of_type_JavaLangString = paramJSONObject.optString("lng");
        localnyl.jdField_g_of_type_JavaLangString = paramJSONObject.optString("lat");
        localnyl.jdField_h_of_type_JavaLangString = paramJSONObject.optString("phone_number");
        localnyl.jdField_g_of_type_Int = paramJSONObject.optInt("width");
        localnyl.jdField_h_of_type_Int = paramJSONObject.optInt("height");
        localnyl.i = paramJSONObject.optString("icon");
        localnyl.j = paramJSONObject.optString("vid");
        paramJSONObject = localnyl;
        if (localnyl.jdField_a_of_type_Int == 3)
        {
          paramJSONObject = localnyl;
          if (localnyl.jdField_c_of_type_Int == 23)
          {
            paramJSONObject = localnyl;
            if (!TextUtils.isEmpty(localnyl.jdField_b_of_type_JavaLangString))
            {
              nqh localnqh = new nqh();
              localnqh.a(localnyl.jdField_b_of_type_JavaLangString);
              if ((TextUtils.isEmpty(localnyl.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(localnqh.jdField_a_of_type_Nqk.jdField_a_of_type_JavaLangString))) {
                localnyl.jdField_e_of_type_JavaLangString = localnqh.jdField_a_of_type_Nqk.jdField_a_of_type_JavaLangString;
              }
              paramJSONObject = localnyl;
              if (TextUtils.isEmpty(localnyl.jdField_a_of_type_JavaLangString))
              {
                paramJSONObject = localnyl;
                if (!TextUtils.isEmpty(localnqh.jdField_a_of_type_JavaLangString))
                {
                  localnyl.jdField_a_of_type_JavaLangString = localnqh.jdField_a_of_type_JavaLangString;
                  return localnyl;
                }
              }
            }
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return localnyl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nyl
 * JD-Core Version:    0.7.0.1
 */