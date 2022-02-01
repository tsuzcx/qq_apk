import java.util.Iterator;
import org.json.JSONObject;

public class nzw
{
  private static JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 != null) && (paramJSONObject2 != null)) {
      try
      {
        Iterator localIterator = paramJSONObject2.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramJSONObject1.put(str, paramJSONObject2.get(str));
        }
        return paramJSONObject1;
      }
      catch (Exception paramJSONObject2) {}
    }
    while (paramJSONObject1 != null) {}
    if (paramJSONObject2 != null) {
      return paramJSONObject2;
    }
    return new JSONObject();
  }
  
  public static JSONObject a(JSONObject... paramVarArgs)
  {
    JSONObject localJSONObject = new JSONObject();
    new JSONObject();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localJSONObject = a(localJSONObject, paramVarArgs[i]);
      i += 1;
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzw
 * JD-Core Version:    0.7.0.1
 */