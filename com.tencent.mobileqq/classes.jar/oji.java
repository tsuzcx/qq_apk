import android.text.TextUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class oji
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
  
  public oji() {}
  
  public oji(mobileqq_mp.ConfigInfo paramConfigInfo)
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
  
  public static oji a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    oji localoji;
    for (;;)
    {
      return paramJSONObject;
      localoji = new oji();
      try
      {
        localoji.jdField_a_of_type_Int = paramJSONObject.optInt("type");
        localoji.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title");
        localoji.jdField_b_of_type_JavaLangString = paramJSONObject.optString("content");
        localoji.jdField_b_of_type_Int = paramJSONObject.optInt("follow_handle");
        localoji.jdField_c_of_type_Int = paramJSONObject.optInt("event_id");
        localoji.jdField_d_of_type_Int = paramJSONObject.optInt("state");
        localoji.jdField_e_of_type_Int = paramJSONObject.optInt("state_id");
        localoji.jdField_c_of_type_JavaLangString = paramJSONObject.optString("url");
        localoji.jdField_f_of_type_Int = paramJSONObject.optInt("confirm_flag");
        localoji.jdField_d_of_type_JavaLangString = paramJSONObject.optString("confirm_tips");
        localoji.jdField_e_of_type_JavaLangString = paramJSONObject.optString("pic_url");
        localoji.jdField_f_of_type_JavaLangString = paramJSONObject.optString("lng");
        localoji.jdField_g_of_type_JavaLangString = paramJSONObject.optString("lat");
        localoji.jdField_h_of_type_JavaLangString = paramJSONObject.optString("phone_number");
        localoji.jdField_g_of_type_Int = paramJSONObject.optInt("width");
        localoji.jdField_h_of_type_Int = paramJSONObject.optInt("height");
        localoji.i = paramJSONObject.optString("icon");
        localoji.j = paramJSONObject.optString("vid");
        paramJSONObject = localoji;
        if (localoji.jdField_a_of_type_Int == 3)
        {
          paramJSONObject = localoji;
          if (localoji.jdField_c_of_type_Int == 23)
          {
            paramJSONObject = localoji;
            if (!TextUtils.isEmpty(localoji.jdField_b_of_type_JavaLangString))
            {
              oap localoap = new oap();
              localoap.a(localoji.jdField_b_of_type_JavaLangString);
              if ((TextUtils.isEmpty(localoji.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(localoap.jdField_a_of_type_Oas.jdField_a_of_type_JavaLangString))) {
                localoji.jdField_e_of_type_JavaLangString = localoap.jdField_a_of_type_Oas.jdField_a_of_type_JavaLangString;
              }
              paramJSONObject = localoji;
              if (TextUtils.isEmpty(localoji.jdField_a_of_type_JavaLangString))
              {
                paramJSONObject = localoji;
                if (!TextUtils.isEmpty(localoap.jdField_a_of_type_JavaLangString))
                {
                  localoji.jdField_a_of_type_JavaLangString = localoap.jdField_a_of_type_JavaLangString;
                  return localoji;
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
    return localoji;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oji
 * JD-Core Version:    0.7.0.1
 */