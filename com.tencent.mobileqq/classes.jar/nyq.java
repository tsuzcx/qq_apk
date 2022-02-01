import android.text.TextUtils;
import org.json.JSONObject;

public class nyq
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  
  public static nyq a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      nyq localnyq = new nyq();
      paramString = new JSONObject(paramString);
      localnyq.jdField_a_of_type_Int = paramString.optInt("bannerType");
      localnyq.jdField_a_of_type_JavaLangString = paramString.optString("iconUrl");
      localnyq.jdField_b_of_type_JavaLangString = paramString.optString("abstractText");
      localnyq.jdField_b_of_type_Int = paramString.optInt("jumpType");
      localnyq.c = paramString.optString("linkUrl");
      localnyq.d = paramString.optString("appid");
      localnyq.e = paramString.optString("scheme");
      localnyq.f = paramString.optString("packagename");
      localnyq.g = paramString.optString("androidDownloadUrl");
      localnyq.h = paramString.optString("iOSDownloadUrl");
      localnyq.i = paramString.optString("appName");
      localnyq.j = paramString.optString("apkUrl");
      return localnyq;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public boolean a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {}
    while (((this.jdField_a_of_type_Int == 2) && (TextUtils.isEmpty(this.c))) || ((this.jdField_a_of_type_Int == 1) && ((TextUtils.isEmpty(this.f)) || (TextUtils.isEmpty(this.j))))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nyq
 * JD-Core Version:    0.7.0.1
 */