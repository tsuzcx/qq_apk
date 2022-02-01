import android.text.TextUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class obr
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
  
  public obr() {}
  
  public obr(mobileqq_mp.ConfigInfo paramConfigInfo)
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
  
  public static obr a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    obr localobr;
    for (;;)
    {
      return paramJSONObject;
      localobr = new obr();
      try
      {
        localobr.jdField_a_of_type_Int = paramJSONObject.optInt("type");
        localobr.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title");
        localobr.jdField_b_of_type_JavaLangString = paramJSONObject.optString("content");
        localobr.jdField_b_of_type_Int = paramJSONObject.optInt("follow_handle");
        localobr.jdField_c_of_type_Int = paramJSONObject.optInt("event_id");
        localobr.jdField_d_of_type_Int = paramJSONObject.optInt("state");
        localobr.jdField_e_of_type_Int = paramJSONObject.optInt("state_id");
        localobr.jdField_c_of_type_JavaLangString = paramJSONObject.optString("url");
        localobr.jdField_f_of_type_Int = paramJSONObject.optInt("confirm_flag");
        localobr.jdField_d_of_type_JavaLangString = paramJSONObject.optString("confirm_tips");
        localobr.jdField_e_of_type_JavaLangString = paramJSONObject.optString("pic_url");
        localobr.jdField_f_of_type_JavaLangString = paramJSONObject.optString("lng");
        localobr.jdField_g_of_type_JavaLangString = paramJSONObject.optString("lat");
        localobr.jdField_h_of_type_JavaLangString = paramJSONObject.optString("phone_number");
        localobr.jdField_g_of_type_Int = paramJSONObject.optInt("width");
        localobr.jdField_h_of_type_Int = paramJSONObject.optInt("height");
        localobr.i = paramJSONObject.optString("icon");
        localobr.j = paramJSONObject.optString("vid");
        paramJSONObject = localobr;
        if (localobr.jdField_a_of_type_Int == 3)
        {
          paramJSONObject = localobr;
          if (localobr.jdField_c_of_type_Int == 23)
          {
            paramJSONObject = localobr;
            if (!TextUtils.isEmpty(localobr.jdField_b_of_type_JavaLangString))
            {
              nto localnto = new nto();
              localnto.a(localobr.jdField_b_of_type_JavaLangString);
              if ((TextUtils.isEmpty(localobr.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(localnto.jdField_a_of_type_Ntr.jdField_a_of_type_JavaLangString))) {
                localobr.jdField_e_of_type_JavaLangString = localnto.jdField_a_of_type_Ntr.jdField_a_of_type_JavaLangString;
              }
              paramJSONObject = localobr;
              if (TextUtils.isEmpty(localobr.jdField_a_of_type_JavaLangString))
              {
                paramJSONObject = localobr;
                if (!TextUtils.isEmpty(localnto.jdField_a_of_type_JavaLangString))
                {
                  localobr.jdField_a_of_type_JavaLangString = localnto.jdField_a_of_type_JavaLangString;
                  return localobr;
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
    return localobr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     obr
 * JD-Core Version:    0.7.0.1
 */