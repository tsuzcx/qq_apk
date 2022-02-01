import java.util.Comparator;
import org.json.JSONObject;

public class oic
  implements Comparator<JSONObject>
{
  String a;
  
  public oic(String paramString)
  {
    this.a = paramString;
  }
  
  public int a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    long l = paramJSONObject1.optLong(this.a);
    return (int)(paramJSONObject2.optLong(this.a) - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oic
 * JD-Core Version:    0.7.0.1
 */