import org.json.JSONObject;

public class nmn
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("adDownloadApiUrl");
      this.b = paramJSONObject.optString("pkg_name");
      this.c = paramJSONObject.optString("appid");
      this.d = paramJSONObject.optString("appname");
      this.e = paramJSONObject.optString("pkgurl");
      this.jdField_a_of_type_Int = paramJSONObject.optInt("business_type", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nmn
 * JD-Core Version:    0.7.0.1
 */