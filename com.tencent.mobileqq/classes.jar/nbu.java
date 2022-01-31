import android.text.TextUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class nbu
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
  
  public nbu() {}
  
  public nbu(mobileqq_mp.ConfigInfo paramConfigInfo)
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
  
  public static nbu a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    nbu localnbu;
    for (;;)
    {
      return paramJSONObject;
      localnbu = new nbu();
      try
      {
        localnbu.jdField_a_of_type_Int = paramJSONObject.optInt("type");
        localnbu.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title");
        localnbu.jdField_b_of_type_JavaLangString = paramJSONObject.optString("content");
        localnbu.jdField_b_of_type_Int = paramJSONObject.optInt("follow_handle");
        localnbu.jdField_c_of_type_Int = paramJSONObject.optInt("event_id");
        localnbu.jdField_d_of_type_Int = paramJSONObject.optInt("state");
        localnbu.jdField_e_of_type_Int = paramJSONObject.optInt("state_id");
        localnbu.jdField_c_of_type_JavaLangString = paramJSONObject.optString("url");
        localnbu.jdField_f_of_type_Int = paramJSONObject.optInt("confirm_flag");
        localnbu.jdField_d_of_type_JavaLangString = paramJSONObject.optString("confirm_tips");
        localnbu.jdField_e_of_type_JavaLangString = paramJSONObject.optString("pic_url");
        localnbu.jdField_f_of_type_JavaLangString = paramJSONObject.optString("lng");
        localnbu.jdField_g_of_type_JavaLangString = paramJSONObject.optString("lat");
        localnbu.jdField_h_of_type_JavaLangString = paramJSONObject.optString("phone_number");
        localnbu.jdField_g_of_type_Int = paramJSONObject.optInt("width");
        localnbu.jdField_h_of_type_Int = paramJSONObject.optInt("height");
        localnbu.i = paramJSONObject.optString("icon");
        localnbu.j = paramJSONObject.optString("vid");
        paramJSONObject = localnbu;
        if (localnbu.jdField_a_of_type_Int == 3)
        {
          paramJSONObject = localnbu;
          if (localnbu.jdField_c_of_type_Int == 23)
          {
            paramJSONObject = localnbu;
            if (!TextUtils.isEmpty(localnbu.jdField_b_of_type_JavaLangString))
            {
              mtw localmtw = new mtw();
              localmtw.a(localnbu.jdField_b_of_type_JavaLangString);
              if ((TextUtils.isEmpty(localnbu.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(localmtw.jdField_a_of_type_Mtz.jdField_a_of_type_JavaLangString))) {
                localnbu.jdField_e_of_type_JavaLangString = localmtw.jdField_a_of_type_Mtz.jdField_a_of_type_JavaLangString;
              }
              paramJSONObject = localnbu;
              if (TextUtils.isEmpty(localnbu.jdField_a_of_type_JavaLangString))
              {
                paramJSONObject = localnbu;
                if (!TextUtils.isEmpty(localmtw.jdField_a_of_type_JavaLangString))
                {
                  localnbu.jdField_a_of_type_JavaLangString = localmtw.jdField_a_of_type_JavaLangString;
                  return localnbu;
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
    return localnbu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbu
 * JD-Core Version:    0.7.0.1
 */