import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class obo
{
  public int a;
  public String a;
  public Pattern a;
  public JSONObject a;
  public String b = "";
  public String c = "";
  
  public obo(ProteusInnerData paramProteusInnerData, int paramInt, String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject, Pattern paramPattern)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramInt;
    if (!TextUtils.isEmpty(paramString1)) {
      this.jdField_a_of_type_JavaLangString = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.b = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      this.c = paramString3;
    }
    if (paramJSONObject != null) {
      this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    }
    if (paramPattern != null) {
      this.jdField_a_of_type_JavaUtilRegexPattern = paramPattern;
    }
  }
  
  public String toString()
  {
    return "InnerFormItem[" + this.jdField_a_of_type_Int + ", " + this.jdField_a_of_type_JavaLangString + ", " + this.b + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     obo
 * JD-Core Version:    0.7.0.1
 */