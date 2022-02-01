import org.json.JSONObject;

public class ols
{
  private static String d;
  public float a;
  public int a;
  public String a;
  public float b;
  public String b = jdField_d_of_type_JavaLangString;
  public float c;
  public String c;
  public float d;
  public float e;
  public float f;
  public float g;
  public float h;
  public float i;
  public float j;
  public float k;
  public float l;
  
  static
  {
    jdField_d_of_type_JavaLangString = "#40A0FF";
  }
  
  public ols()
  {
    this.jdField_a_of_type_JavaLangString = jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_Int = 14;
    this.jdField_c_of_type_JavaLangString = jdField_d_of_type_JavaLangString;
  }
  
  public static ols a(JSONObject paramJSONObject)
  {
    ols localols = new ols();
    if (paramJSONObject == null) {
      return localols;
    }
    localols.jdField_a_of_type_JavaLangString = nya.a(paramJSONObject, "buttonTextColor", jdField_d_of_type_JavaLangString);
    localols.b = paramJSONObject.optString("buttonBorderColor");
    localols.jdField_c_of_type_JavaLangString = paramJSONObject.optString("buttonBackgroundColor");
    localols.jdField_a_of_type_Int = nya.a(paramJSONObject.optString("buttonTextSize"), 14);
    localols.jdField_a_of_type_Float = nya.a(paramJSONObject.optString("buttonTextBold"), 0.0F);
    localols.jdField_c_of_type_Float = nya.a(paramJSONObject.optString("buttonBorderSize"), 0.0F);
    localols.jdField_d_of_type_Float = nya.a(paramJSONObject.optString("buttonCornerSize"), 0.0F);
    localols.e = nya.a(paramJSONObject.optString("buttonHorizontalPadding"), 0.0F);
    localols.f = nya.a(paramJSONObject.optString("buttonVerticalPadding"), 0.0F);
    localols.g = nya.a(paramJSONObject.optString("drawablePadding"), 0.0F);
    localols.h = nya.a(paramJSONObject.optString("iconSize"), 0.0F);
    localols.i = nya.a(paramJSONObject.optString("buttonAlignment"), 0.0F);
    localols.i = nya.a(paramJSONObject.optString("showBunttonLeftIconOrNot"), 0.0F);
    localols.k = nya.a(paramJSONObject.optString("buttonWidth"), 0.0F);
    localols.l = nya.a(paramJSONObject.optString("buttonHeight"), 0.0F);
    localols.j = nya.a(paramJSONObject.optString("width"), 0.0F);
    return localols;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ols
 * JD-Core Version:    0.7.0.1
 */