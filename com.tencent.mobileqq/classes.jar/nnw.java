import android.text.TextUtils;
import org.json.JSONObject;

public class nnw
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
  
  public static nnw a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      nnw localnnw = new nnw();
      paramString = new JSONObject(paramString);
      localnnw.jdField_a_of_type_Int = paramString.optInt("bannerType");
      localnnw.jdField_a_of_type_JavaLangString = paramString.optString("iconUrl");
      localnnw.jdField_b_of_type_JavaLangString = paramString.optString("abstractText");
      localnnw.jdField_b_of_type_Int = paramString.optInt("jumpType");
      localnnw.c = paramString.optString("linkUrl");
      localnnw.d = paramString.optString("appid");
      localnnw.e = paramString.optString("scheme");
      localnnw.f = paramString.optString("packagename");
      localnnw.g = paramString.optString("androidDownloadUrl");
      localnnw.h = paramString.optString("iOSDownloadUrl");
      localnnw.i = paramString.optString("appName");
      localnnw.j = paramString.optString("apkUrl");
      return localnnw;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nnw
 * JD-Core Version:    0.7.0.1
 */