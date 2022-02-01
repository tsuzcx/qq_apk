import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class sut
{
  private JSONObject a;
  
  public sut(String paramString)
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
  
  public sut(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = new JSONObject();
    omx.a(paramString1, paramString2, paramString3, paramString4, this.a);
  }
  
  public sut(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1);
    omx.a(paramString2, paramString3, paramString4, paramString5, this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sut
 * JD-Core Version:    0.7.0.1
 */