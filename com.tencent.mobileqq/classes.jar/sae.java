import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class sae
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 1;
  private String jdField_c_of_type_JavaLangString;
  private String d = "120";
  
  public sae(@NonNull String paramString1, @NonNull JSONObject paramJSONObject, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && ((this.jdField_a_of_type_JavaLangString.contains("v_present=1")) || (this.jdField_a_of_type_JavaLangString.contains("v_present=2")))) {
      this.jdField_a_of_type_Int = 1;
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("v_present_auto_top=1"))) {
      this.jdField_c_of_type_Int = 1;
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("v_present_top"))) {
      this.d = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("v_present_top");
    }
    paramString1 = (QQAppInterface)onk.a();
    if (paramString1 != null) {
      this.jdField_c_of_type_JavaLangString = paramString1.getAccount();
    }
  }
  
  public sae(@NonNull String paramString1, @NonNull JSONObject paramJSONObject, String paramString2, int paramInt)
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
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("param", this.jdField_a_of_type_OrgJsonJSONObject);
      localJSONObject.put("cache", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("uin", this.jdField_c_of_type_JavaLangString);
      localJSONObject.put("isPresent", this.jdField_a_of_type_Int);
      localJSONObject.put("isChannel", this.jdField_b_of_type_Int);
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        i = 1;
      }
      localJSONObject.put("isNightMode", i);
      localJSONObject.put("isAutoTop", this.jdField_c_of_type_Int);
      localJSONObject.put("presentMarginTop", this.d);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
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
 * Qualified Name:     sae
 * JD-Core Version:    0.7.0.1
 */