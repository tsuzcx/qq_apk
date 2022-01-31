import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import org.json.JSONException;
import org.json.JSONObject;

public class tem
{
  @vyj(a="gametype")
  public int a;
  @vyj(a="gameid")
  public String a;
  @vyj(a="name")
  public String b;
  @vyj(a="result")
  public String c;
  
  public static tem a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = (tem)JsonORM.a(new JSONObject(paramString), tem.class);
      return paramString;
    }
    catch (JsonORM.JsonParseException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tem
 * JD-Core Version:    0.7.0.1
 */