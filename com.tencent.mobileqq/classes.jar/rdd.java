import org.json.JSONObject;

public class rdd
{
  public long a;
  public String a;
  public String b;
  public String c;
  
  rdd(rcz paramrcz, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("sActivityId");
    this.b = paramJSONObject.optString("sGiftName");
    this.c = paramJSONObject.optString("sNeedRole");
    this.jdField_a_of_type_Long = paramJSONObject.optInt("iGiftId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rdd
 * JD-Core Version:    0.7.0.1
 */