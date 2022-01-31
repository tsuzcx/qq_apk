import android.text.TextUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class npo
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
  
  public npo() {}
  
  public npo(mobileqq_mp.ConfigInfo paramConfigInfo)
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
  
  public static npo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    npo localnpo;
    for (;;)
    {
      return paramJSONObject;
      localnpo = new npo();
      try
      {
        localnpo.jdField_a_of_type_Int = paramJSONObject.optInt("type");
        localnpo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title");
        localnpo.jdField_b_of_type_JavaLangString = paramJSONObject.optString("content");
        localnpo.jdField_b_of_type_Int = paramJSONObject.optInt("follow_handle");
        localnpo.jdField_c_of_type_Int = paramJSONObject.optInt("event_id");
        localnpo.jdField_d_of_type_Int = paramJSONObject.optInt("state");
        localnpo.jdField_e_of_type_Int = paramJSONObject.optInt("state_id");
        localnpo.jdField_c_of_type_JavaLangString = paramJSONObject.optString("url");
        localnpo.jdField_f_of_type_Int = paramJSONObject.optInt("confirm_flag");
        localnpo.jdField_d_of_type_JavaLangString = paramJSONObject.optString("confirm_tips");
        localnpo.jdField_e_of_type_JavaLangString = paramJSONObject.optString("pic_url");
        localnpo.jdField_f_of_type_JavaLangString = paramJSONObject.optString("lng");
        localnpo.jdField_g_of_type_JavaLangString = paramJSONObject.optString("lat");
        localnpo.jdField_h_of_type_JavaLangString = paramJSONObject.optString("phone_number");
        localnpo.jdField_g_of_type_Int = paramJSONObject.optInt("width");
        localnpo.jdField_h_of_type_Int = paramJSONObject.optInt("height");
        localnpo.i = paramJSONObject.optString("icon");
        localnpo.j = paramJSONObject.optString("vid");
        paramJSONObject = localnpo;
        if (localnpo.jdField_a_of_type_Int == 3)
        {
          paramJSONObject = localnpo;
          if (localnpo.jdField_c_of_type_Int == 23)
          {
            paramJSONObject = localnpo;
            if (!TextUtils.isEmpty(localnpo.jdField_b_of_type_JavaLangString))
            {
              nhq localnhq = new nhq();
              localnhq.a(localnpo.jdField_b_of_type_JavaLangString);
              if ((TextUtils.isEmpty(localnpo.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(localnhq.jdField_a_of_type_Nht.jdField_a_of_type_JavaLangString))) {
                localnpo.jdField_e_of_type_JavaLangString = localnhq.jdField_a_of_type_Nht.jdField_a_of_type_JavaLangString;
              }
              paramJSONObject = localnpo;
              if (TextUtils.isEmpty(localnpo.jdField_a_of_type_JavaLangString))
              {
                paramJSONObject = localnpo;
                if (!TextUtils.isEmpty(localnhq.jdField_a_of_type_JavaLangString))
                {
                  localnpo.jdField_a_of_type_JavaLangString = localnhq.jdField_a_of_type_JavaLangString;
                  return localnpo;
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
    return localnpo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     npo
 * JD-Core Version:    0.7.0.1
 */