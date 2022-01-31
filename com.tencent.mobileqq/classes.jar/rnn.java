import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class rnn
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public rnn(@NonNull String paramString1, @NonNull JSONObject paramJSONObject, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && ((this.jdField_a_of_type_JavaLangString.contains("v_present=1")) || (this.jdField_a_of_type_JavaLangString.contains("v_present=2")))) {
      this.jdField_a_of_type_Int = 1;
    }
    paramString1 = (QQAppInterface)obz.a();
    if (paramString1 != null) {
      this.c = paramString1.getAccount();
    }
  }
  
  public rnn(@NonNull String paramString1, @NonNull JSONObject paramJSONObject, String paramString2, int paramInt)
  {
    this(paramString1, paramJSONObject, paramString2);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public String a()
  {
    return a().toString();
  }
  
  public JSONObject a()
  {
    int i = 0;
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("url", this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_OrgJsonJSONObject != null)
      {
        JSONObject localJSONObject2 = this.jdField_a_of_type_OrgJsonJSONObject;
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
          i = 1;
        }
        localJSONObject2.put("isNightMode", i);
      }
      localJSONObject1.put("param", this.jdField_a_of_type_OrgJsonJSONObject);
      localJSONObject1.put("cache", this.jdField_b_of_type_JavaLangString);
      localJSONObject1.put("uin", this.c);
      localJSONObject1.put("isPresent", this.jdField_a_of_type_Int);
      localJSONObject1.put("isChannel", this.jdField_b_of_type_Int);
      return localJSONObject1;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ViolaCreactPageObject : url:");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      str = "null";
      localStringBuilder.append(str);
      localStringBuilder.append("; ");
      if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
        break label100;
      }
      str = "null";
      label51:
      localStringBuilder.append(str);
      localStringBuilder.append("; ");
      if (this.jdField_b_of_type_JavaLangString != null) {
        break label111;
      }
    }
    label100:
    label111:
    for (String str = "null";; str = this.jdField_b_of_type_JavaLangString.toString())
    {
      localStringBuilder.append(str);
      localStringBuilder.append("; ");
      return localStringBuilder.toString();
      str = this.jdField_a_of_type_JavaLangString;
      break;
      str = this.jdField_a_of_type_OrgJsonJSONObject.toString();
      break label51;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rnn
 * JD-Core Version:    0.7.0.1
 */