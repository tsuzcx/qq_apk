import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class qzd
{
  private JSONObject a;
  
  public qzd(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.a = new JSONObject();
        return;
      }
      this.a = new JSONObject(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public qzd(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = new JSONObject();
    npx.a(paramString1, paramString2, paramString3, paramString4, this.a);
  }
  
  public qzd(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1);
    npx.a(paramString2, paramString3, paramString4, paramString5, this.a);
  }
  
  public String a()
  {
    return this.a.toString();
  }
  
  protected void a(String paramString, Object paramObject)
  {
    try
    {
      this.a.put(paramString, paramObject);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qzd
 * JD-Core Version:    0.7.0.1
 */