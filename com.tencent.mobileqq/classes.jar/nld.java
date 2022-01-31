import android.text.TextUtils;
import org.json.JSONObject;

public class nld
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
  
  public static nld a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      nld localnld = new nld();
      paramString = new JSONObject(paramString);
      localnld.jdField_a_of_type_Int = paramString.optInt("bannerType");
      localnld.jdField_a_of_type_JavaLangString = paramString.optString("iconUrl");
      localnld.jdField_b_of_type_JavaLangString = paramString.optString("abstractText");
      localnld.jdField_b_of_type_Int = paramString.optInt("jumpType");
      localnld.c = paramString.optString("linkUrl");
      localnld.d = paramString.optString("appid");
      localnld.e = paramString.optString("scheme");
      localnld.f = paramString.optString("packagename");
      localnld.g = paramString.optString("androidDownloadUrl");
      localnld.h = paramString.optString("iOSDownloadUrl");
      localnld.i = paramString.optString("appName");
      localnld.j = paramString.optString("apkUrl");
      return localnld;
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
 * Qualified Name:     nld
 * JD-Core Version:    0.7.0.1
 */