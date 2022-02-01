import android.text.TextUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class oag
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
  
  public oag() {}
  
  public oag(mobileqq_mp.ConfigInfo paramConfigInfo)
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
  
  public static oag a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    oag localoag;
    for (;;)
    {
      return paramJSONObject;
      localoag = new oag();
      try
      {
        localoag.jdField_a_of_type_Int = paramJSONObject.optInt("type");
        localoag.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title");
        localoag.jdField_b_of_type_JavaLangString = paramJSONObject.optString("content");
        localoag.jdField_b_of_type_Int = paramJSONObject.optInt("follow_handle");
        localoag.jdField_c_of_type_Int = paramJSONObject.optInt("event_id");
        localoag.jdField_d_of_type_Int = paramJSONObject.optInt("state");
        localoag.jdField_e_of_type_Int = paramJSONObject.optInt("state_id");
        localoag.jdField_c_of_type_JavaLangString = paramJSONObject.optString("url");
        localoag.jdField_f_of_type_Int = paramJSONObject.optInt("confirm_flag");
        localoag.jdField_d_of_type_JavaLangString = paramJSONObject.optString("confirm_tips");
        localoag.jdField_e_of_type_JavaLangString = paramJSONObject.optString("pic_url");
        localoag.jdField_f_of_type_JavaLangString = paramJSONObject.optString("lng");
        localoag.jdField_g_of_type_JavaLangString = paramJSONObject.optString("lat");
        localoag.jdField_h_of_type_JavaLangString = paramJSONObject.optString("phone_number");
        localoag.jdField_g_of_type_Int = paramJSONObject.optInt("width");
        localoag.jdField_h_of_type_Int = paramJSONObject.optInt("height");
        localoag.i = paramJSONObject.optString("icon");
        localoag.j = paramJSONObject.optString("vid");
        paramJSONObject = localoag;
        if (localoag.jdField_a_of_type_Int == 3)
        {
          paramJSONObject = localoag;
          if (localoag.jdField_c_of_type_Int == 23)
          {
            paramJSONObject = localoag;
            if (!TextUtils.isEmpty(localoag.jdField_b_of_type_JavaLangString))
            {
              nsf localnsf = new nsf();
              localnsf.a(localoag.jdField_b_of_type_JavaLangString);
              if ((TextUtils.isEmpty(localoag.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(localnsf.jdField_a_of_type_Nsi.jdField_a_of_type_JavaLangString))) {
                localoag.jdField_e_of_type_JavaLangString = localnsf.jdField_a_of_type_Nsi.jdField_a_of_type_JavaLangString;
              }
              paramJSONObject = localoag;
              if (TextUtils.isEmpty(localoag.jdField_a_of_type_JavaLangString))
              {
                paramJSONObject = localoag;
                if (!TextUtils.isEmpty(localnsf.jdField_a_of_type_JavaLangString))
                {
                  localoag.jdField_a_of_type_JavaLangString = localnsf.jdField_a_of_type_JavaLangString;
                  return localoag;
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
    return localoag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oag
 * JD-Core Version:    0.7.0.1
 */