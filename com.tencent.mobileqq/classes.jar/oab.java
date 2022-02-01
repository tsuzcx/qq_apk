import android.text.TextUtils;
import org.json.JSONObject;

public class oab
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
  
  public static oab a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      oab localoab = new oab();
      paramString = new JSONObject(paramString);
      localoab.jdField_a_of_type_Int = paramString.optInt("bannerType");
      localoab.jdField_a_of_type_JavaLangString = paramString.optString("iconUrl");
      localoab.jdField_b_of_type_JavaLangString = paramString.optString("abstractText");
      localoab.jdField_b_of_type_Int = paramString.optInt("jumpType");
      localoab.c = paramString.optString("linkUrl");
      localoab.d = paramString.optString("appid");
      localoab.e = paramString.optString("scheme");
      localoab.f = paramString.optString("packagename");
      localoab.g = paramString.optString("androidDownloadUrl");
      localoab.h = paramString.optString("iOSDownloadUrl");
      localoab.i = paramString.optString("appName");
      localoab.j = paramString.optString("apkUrl");
      return localoab;
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
 * Qualified Name:     oab
 * JD-Core Version:    0.7.0.1
 */