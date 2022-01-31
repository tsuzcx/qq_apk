import com.tencent.common.app.BaseApplicationImpl;
import org.json.JSONException;
import org.json.JSONObject;

public class ohg
{
  private JSONObject a = new JSONObject();
  
  public String a()
  {
    return this.a.toString();
  }
  
  public ohg a()
  {
    try
    {
      this.a.put("network", opn.a(BaseApplicationImpl.getApplication().getApplicationContext()));
      this.a.put("version", ntd.a);
      this.a.put("os", "1");
      this.a.put("uin", ors.a());
      this.a.put("city", opn.b());
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public ohg a(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ohg
 * JD-Core Version:    0.7.0.1
 */