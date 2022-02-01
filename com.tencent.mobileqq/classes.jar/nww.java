import android.text.TextUtils;
import org.json.JSONObject;

public class nww
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
  
  public static nww a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      nww localnww = new nww();
      paramString = new JSONObject(paramString);
      localnww.jdField_a_of_type_Int = paramString.optInt("bannerType");
      localnww.jdField_a_of_type_JavaLangString = paramString.optString("iconUrl");
      localnww.jdField_b_of_type_JavaLangString = paramString.optString("abstractText");
      localnww.jdField_b_of_type_Int = paramString.optInt("jumpType");
      localnww.c = paramString.optString("linkUrl");
      localnww.d = paramString.optString("appid");
      localnww.e = paramString.optString("scheme");
      localnww.f = paramString.optString("packagename");
      localnww.g = paramString.optString("androidDownloadUrl");
      localnww.h = paramString.optString("iOSDownloadUrl");
      localnww.i = paramString.optString("appName");
      localnww.j = paramString.optString("apkUrl");
      return localnww;
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
 * Qualified Name:     nww
 * JD-Core Version:    0.7.0.1
 */