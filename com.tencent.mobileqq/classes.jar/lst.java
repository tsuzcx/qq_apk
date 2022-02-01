import org.json.JSONObject;

public class lst
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  public int b;
  public int c = 7000;
  public int d = 1000;
  public int e = 0;
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("result");
      this.jdField_a_of_type_Int = paramString.optInt("rsptype", 0);
      this.b = paramString.optInt("retcode", -1);
      this.jdField_a_of_type_JavaLangString = paramString.optString("errmsg");
      this.jdField_a_of_type_OrgJsonJSONObject = paramString.optJSONObject("rspbody");
      paramString = paramString.optString("remain");
      try
      {
        this.e = Integer.valueOf(paramString).intValue();
        return;
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      this.b = 14;
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lst
 * JD-Core Version:    0.7.0.1
 */