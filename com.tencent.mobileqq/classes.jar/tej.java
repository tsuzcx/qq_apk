import org.json.JSONObject;

public class tej
  extends ted
{
  public String a;
  
  public tej(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static tej a(JSONObject paramJSONObject)
  {
    return new tej(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.a = paramJSONObject.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tej
 * JD-Core Version:    0.7.0.1
 */