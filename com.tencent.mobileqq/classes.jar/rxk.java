import org.json.JSONObject;

public class rxk
  extends rxe
{
  public String a;
  
  public rxk(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static rxk a(JSONObject paramJSONObject)
  {
    return new rxk(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.a = paramJSONObject.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxk
 * JD-Core Version:    0.7.0.1
 */