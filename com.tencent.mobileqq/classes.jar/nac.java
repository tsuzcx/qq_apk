import android.text.TextUtils;
import org.json.JSONObject;

public class nac
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
  
  public static nac a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      nac localnac = new nac();
      paramString = new JSONObject(paramString);
      localnac.jdField_a_of_type_Int = paramString.optInt("bannerType");
      localnac.jdField_a_of_type_JavaLangString = paramString.optString("iconUrl");
      localnac.jdField_b_of_type_JavaLangString = paramString.optString("abstractText");
      localnac.jdField_b_of_type_Int = paramString.optInt("jumpType");
      localnac.c = paramString.optString("linkUrl");
      localnac.d = paramString.optString("appid");
      localnac.e = paramString.optString("scheme");
      localnac.f = paramString.optString("packagename");
      localnac.g = paramString.optString("androidDownloadUrl");
      localnac.h = paramString.optString("iOSDownloadUrl");
      localnac.i = paramString.optString("appName");
      localnac.j = paramString.optString("apkUrl");
      return localnac;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nac
 * JD-Core Version:    0.7.0.1
 */