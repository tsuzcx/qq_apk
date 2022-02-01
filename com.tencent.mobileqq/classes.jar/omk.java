import com.tencent.common.app.BaseApplicationImpl;
import org.json.JSONException;
import org.json.JSONObject;

public class omk
{
  private JSONObject a = new JSONObject();
  
  public String a()
  {
    return this.a.toString();
  }
  
  public omk a()
  {
    try
    {
      this.a.put("network", oxw.a(BaseApplicationImpl.getApplication().getApplicationContext()));
      this.a.put("version", odr.a);
      this.a.put("os", "1");
      this.a.put("uin", ozs.a());
      this.a.put("city", oxw.b());
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public omk a(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     omk
 * JD-Core Version:    0.7.0.1
 */