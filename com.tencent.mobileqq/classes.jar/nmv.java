import android.text.TextUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class nmv
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
  
  public nmv() {}
  
  public nmv(mobileqq_mp.ConfigInfo paramConfigInfo)
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
  
  public static nmv a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    nmv localnmv;
    for (;;)
    {
      return paramJSONObject;
      localnmv = new nmv();
      try
      {
        localnmv.jdField_a_of_type_Int = paramJSONObject.optInt("type");
        localnmv.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title");
        localnmv.jdField_b_of_type_JavaLangString = paramJSONObject.optString("content");
        localnmv.jdField_b_of_type_Int = paramJSONObject.optInt("follow_handle");
        localnmv.jdField_c_of_type_Int = paramJSONObject.optInt("event_id");
        localnmv.jdField_d_of_type_Int = paramJSONObject.optInt("state");
        localnmv.jdField_e_of_type_Int = paramJSONObject.optInt("state_id");
        localnmv.jdField_c_of_type_JavaLangString = paramJSONObject.optString("url");
        localnmv.jdField_f_of_type_Int = paramJSONObject.optInt("confirm_flag");
        localnmv.jdField_d_of_type_JavaLangString = paramJSONObject.optString("confirm_tips");
        localnmv.jdField_e_of_type_JavaLangString = paramJSONObject.optString("pic_url");
        localnmv.jdField_f_of_type_JavaLangString = paramJSONObject.optString("lng");
        localnmv.jdField_g_of_type_JavaLangString = paramJSONObject.optString("lat");
        localnmv.jdField_h_of_type_JavaLangString = paramJSONObject.optString("phone_number");
        localnmv.jdField_g_of_type_Int = paramJSONObject.optInt("width");
        localnmv.jdField_h_of_type_Int = paramJSONObject.optInt("height");
        localnmv.i = paramJSONObject.optString("icon");
        localnmv.j = paramJSONObject.optString("vid");
        paramJSONObject = localnmv;
        if (localnmv.jdField_a_of_type_Int == 3)
        {
          paramJSONObject = localnmv;
          if (localnmv.jdField_c_of_type_Int == 23)
          {
            paramJSONObject = localnmv;
            if (!TextUtils.isEmpty(localnmv.jdField_b_of_type_JavaLangString))
            {
              nex localnex = new nex();
              localnex.a(localnmv.jdField_b_of_type_JavaLangString);
              if ((TextUtils.isEmpty(localnmv.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(localnex.jdField_a_of_type_Nfa.jdField_a_of_type_JavaLangString))) {
                localnmv.jdField_e_of_type_JavaLangString = localnex.jdField_a_of_type_Nfa.jdField_a_of_type_JavaLangString;
              }
              paramJSONObject = localnmv;
              if (TextUtils.isEmpty(localnmv.jdField_a_of_type_JavaLangString))
              {
                paramJSONObject = localnmv;
                if (!TextUtils.isEmpty(localnex.jdField_a_of_type_JavaLangString))
                {
                  localnmv.jdField_a_of_type_JavaLangString = localnex.jdField_a_of_type_JavaLangString;
                  return localnmv;
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
    return localnmv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nmv
 * JD-Core Version:    0.7.0.1
 */