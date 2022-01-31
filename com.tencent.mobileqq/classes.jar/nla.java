import android.text.TextUtils;
import org.json.JSONObject;

public class nla
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
  
  public static nla a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      nla localnla = new nla();
      paramString = new JSONObject(paramString);
      localnla.jdField_a_of_type_Int = paramString.optInt("bannerType");
      localnla.jdField_a_of_type_JavaLangString = paramString.optString("iconUrl");
      localnla.jdField_b_of_type_JavaLangString = paramString.optString("abstractText");
      localnla.jdField_b_of_type_Int = paramString.optInt("jumpType");
      localnla.c = paramString.optString("linkUrl");
      localnla.d = paramString.optString("appid");
      localnla.e = paramString.optString("scheme");
      localnla.f = paramString.optString("packagename");
      localnla.g = paramString.optString("androidDownloadUrl");
      localnla.h = paramString.optString("iOSDownloadUrl");
      localnla.i = paramString.optString("appName");
      localnla.j = paramString.optString("apkUrl");
      return localnla;
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
 * Qualified Name:     nla
 * JD-Core Version:    0.7.0.1
 */