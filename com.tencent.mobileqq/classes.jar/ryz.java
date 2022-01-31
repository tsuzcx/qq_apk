import org.json.JSONObject;

public class ryz
{
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  
  public ryz() {}
  
  public ryz(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      if (paramJSONObject.has("busiType")) {
        this.jdField_a_of_type_Int = paramJSONObject.getInt("busiType");
      }
      if (paramJSONObject.has("vid")) {
        this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("vid");
      }
      if (paramJSONObject.has("width")) {
        this.jdField_b_of_type_Int = paramJSONObject.getInt("width");
      }
      if (paramJSONObject.has("height")) {
        this.jdField_c_of_type_Int = paramJSONObject.getInt("height");
      }
      if (paramJSONObject.has("duration")) {
        this.jdField_d_of_type_Int = paramJSONObject.getInt("duration");
      }
      if (paramJSONObject.has("poster")) {
        this.jdField_b_of_type_JavaLangString = paramJSONObject.getString("poster");
      }
      if (paramJSONObject.has("title")) {
        this.jdField_c_of_type_JavaLangString = paramJSONObject.getString("title");
      }
      if (paramJSONObject.has("xgFileSize")) {
        this.jdField_a_of_type_Long = paramJSONObject.getLong("xgFileSize");
      }
    } while (!paramJSONObject.has("videoUrl"));
    this.jdField_d_of_type_JavaLangString = paramJSONObject.getString("videoUrl");
  }
  
  public String toString()
  {
    return "VideoInfo{busiType=" + this.jdField_a_of_type_Int + ", vid='" + this.jdField_a_of_type_JavaLangString + '\'' + ", width=" + this.jdField_b_of_type_Int + ", height=" + this.jdField_c_of_type_Int + ", duration=" + this.jdField_d_of_type_Int + ", coverUrl='" + this.jdField_b_of_type_JavaLangString + '\'' + ", title='" + this.jdField_c_of_type_JavaLangString + '\'' + ", XGFileSize=" + this.jdField_a_of_type_Long + ", videoUrl='" + this.jdField_d_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ryz
 * JD-Core Version:    0.7.0.1
 */