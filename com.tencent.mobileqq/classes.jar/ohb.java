import android.text.TextUtils;
import org.json.JSONObject;

public class ohb
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
  
  public static ohb a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      ohb localohb = new ohb();
      paramString = new JSONObject(paramString);
      localohb.jdField_a_of_type_Int = paramString.optInt("bannerType");
      localohb.jdField_a_of_type_JavaLangString = paramString.optString("iconUrl");
      localohb.jdField_b_of_type_JavaLangString = paramString.optString("abstractText");
      localohb.jdField_b_of_type_Int = paramString.optInt("jumpType");
      localohb.c = paramString.optString("linkUrl");
      localohb.d = paramString.optString("appid");
      localohb.e = paramString.optString("scheme");
      localohb.f = paramString.optString("packagename");
      localohb.g = paramString.optString("androidDownloadUrl");
      localohb.h = paramString.optString("iOSDownloadUrl");
      localohb.i = paramString.optString("appName");
      localohb.j = paramString.optString("apkUrl");
      return localohb;
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
 * Qualified Name:     ohb
 * JD-Core Version:    0.7.0.1
 */