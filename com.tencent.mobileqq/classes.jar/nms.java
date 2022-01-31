import android.text.TextUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class nms
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
  
  public nms() {}
  
  public nms(mobileqq_mp.ConfigInfo paramConfigInfo)
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
  
  public static nms a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    nms localnms;
    for (;;)
    {
      return paramJSONObject;
      localnms = new nms();
      try
      {
        localnms.jdField_a_of_type_Int = paramJSONObject.optInt("type");
        localnms.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title");
        localnms.jdField_b_of_type_JavaLangString = paramJSONObject.optString("content");
        localnms.jdField_b_of_type_Int = paramJSONObject.optInt("follow_handle");
        localnms.jdField_c_of_type_Int = paramJSONObject.optInt("event_id");
        localnms.jdField_d_of_type_Int = paramJSONObject.optInt("state");
        localnms.jdField_e_of_type_Int = paramJSONObject.optInt("state_id");
        localnms.jdField_c_of_type_JavaLangString = paramJSONObject.optString("url");
        localnms.jdField_f_of_type_Int = paramJSONObject.optInt("confirm_flag");
        localnms.jdField_d_of_type_JavaLangString = paramJSONObject.optString("confirm_tips");
        localnms.jdField_e_of_type_JavaLangString = paramJSONObject.optString("pic_url");
        localnms.jdField_f_of_type_JavaLangString = paramJSONObject.optString("lng");
        localnms.jdField_g_of_type_JavaLangString = paramJSONObject.optString("lat");
        localnms.jdField_h_of_type_JavaLangString = paramJSONObject.optString("phone_number");
        localnms.jdField_g_of_type_Int = paramJSONObject.optInt("width");
        localnms.jdField_h_of_type_Int = paramJSONObject.optInt("height");
        localnms.i = paramJSONObject.optString("icon");
        localnms.j = paramJSONObject.optString("vid");
        paramJSONObject = localnms;
        if (localnms.jdField_a_of_type_Int == 3)
        {
          paramJSONObject = localnms;
          if (localnms.jdField_c_of_type_Int == 23)
          {
            paramJSONObject = localnms;
            if (!TextUtils.isEmpty(localnms.jdField_b_of_type_JavaLangString))
            {
              neu localneu = new neu();
              localneu.a(localnms.jdField_b_of_type_JavaLangString);
              if ((TextUtils.isEmpty(localnms.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(localneu.jdField_a_of_type_Nex.jdField_a_of_type_JavaLangString))) {
                localnms.jdField_e_of_type_JavaLangString = localneu.jdField_a_of_type_Nex.jdField_a_of_type_JavaLangString;
              }
              paramJSONObject = localnms;
              if (TextUtils.isEmpty(localnms.jdField_a_of_type_JavaLangString))
              {
                paramJSONObject = localnms;
                if (!TextUtils.isEmpty(localneu.jdField_a_of_type_JavaLangString))
                {
                  localnms.jdField_a_of_type_JavaLangString = localneu.jdField_a_of_type_JavaLangString;
                  return localnms;
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
    return localnms;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nms
 * JD-Core Version:    0.7.0.1
 */