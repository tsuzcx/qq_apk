import java.util.Comparator;
import org.json.JSONObject;

public class nvm
  implements Comparator<JSONObject>
{
  String a;
  
  public nvm(String paramString)
  {
    this.a = paramString;
  }
  
  public int a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    long l = paramJSONObject1.optLong(this.a);
    return (int)(paramJSONObject2.optLong(this.a) - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nvm
 * JD-Core Version:    0.7.0.1
 */