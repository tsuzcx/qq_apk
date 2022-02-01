package cooperation.qqreader.net;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class QueryUserIdentityTask
  extends BaseCgiTask
{
  protected BaseCgiTask.RequestType a()
  {
    return BaseCgiTask.RequestType.POST;
  }
  
  protected String a()
  {
    return "https://app.books.qq.com/webapp/json/reader_webapp_newuser/GetUserIdentity";
  }
  
  protected HashMap<String, String> a()
  {
    return b();
  }
  
  protected byte[] a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("origin", 1);
      return localJSONObject.toString().getBytes();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.net.QueryUserIdentityTask
 * JD-Core Version:    0.7.0.1
 */