import com.tencent.common.app.BaseApplicationImpl;
import org.json.JSONException;
import org.json.JSONObject;

public class nse
{
  private JSONObject a = new JSONObject();
  
  public String a()
  {
    return this.a.toString();
  }
  
  public nse a()
  {
    try
    {
      this.a.put("network", nzv.a(BaseApplicationImpl.getApplication().getApplicationContext()));
      this.a.put("version", new.a);
      this.a.put("os", "1");
      this.a.put("uin", obz.a());
      this.a.put("city", nzv.b());
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public nse a(int paramInt)
  {
    int i = 0;
    if (paramInt == 41516) {
      i = 3;
    }
    for (;;)
    {
      try
      {
        this.a.put("source", i);
        return this;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (paramInt == 41522) {
        i = 16;
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nse
 * JD-Core Version:    0.7.0.1
 */