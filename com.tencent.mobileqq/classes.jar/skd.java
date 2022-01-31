import org.json.JSONObject;

public class skd
  extends sjx
{
  public String a;
  
  public skd(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static skd a(JSONObject paramJSONObject)
  {
    return new skd(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.a = paramJSONObject.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     skd
 * JD-Core Version:    0.7.0.1
 */