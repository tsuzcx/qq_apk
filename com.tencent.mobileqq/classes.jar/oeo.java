import org.json.JSONException;
import org.json.JSONObject;

public class oeo
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c = "";
  
  public oeo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static oeo a(String paramString)
  {
    oeo localoeo = new oeo();
    if (!bgsp.a(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      localoeo.jdField_a_of_type_Int = paramString.optInt("minus_view_switch");
      localoeo.jdField_a_of_type_JavaLangString = paramString.optString("minus_view_titie");
      localoeo.jdField_b_of_type_JavaLangString = paramString.optString("recommend_title");
      localoeo.c = paramString.optString("btn_jump_url");
      localoeo.jdField_b_of_type_Int = paramString.optInt("max_open_cnt", 2);
      if (localoeo.jdField_b_of_type_Int <= 0) {
        localoeo.jdField_b_of_type_Int = 2;
      }
      return localoeo;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localoeo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oeo
 * JD-Core Version:    0.7.0.1
 */