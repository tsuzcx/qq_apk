package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import org.json.JSONObject;

public class InfomationFacePackage$Item
{
  public int a;
  public String a;
  public final boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f;
  public String g = "";
  public String h;
  
  public InfomationFacePackage$Item(JSONObject paramJSONObject)
  {
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("poster_name");
    this.jdField_a_of_type_Int = paramJSONObject.getInt("poster_type");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.getString("thumb_url");
    this.jdField_b_of_type_Int = paramJSONObject.optInt("predownload", 0);
    this.c = paramJSONObject.getString("static_url");
    paramJSONObject = paramJSONObject.getJSONObject("resource");
    this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("resurl", "");
    this.jdField_e_of_type_JavaLangString = paramJSONObject.optString("md5", "");
    this.f = paramJSONObject.getString("name");
    this.jdField_a_of_type_Boolean = InformationFaceConstant.a(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item
 * JD-Core Version:    0.7.0.1
 */