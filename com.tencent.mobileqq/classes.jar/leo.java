import com.tencent.qphone.base.util.Cryptor;
import org.json.JSONObject;

public class leo
{
  public final String a = "uid";
  public final String b = "ukey";
  public final String c = "^%QAI$I+j{2HuP0L";
  public String d;
  public String e;
  
  public static leo a(String paramString)
  {
    leo localleo = new leo();
    if (localleo.a(paramString)) {
      return localleo;
    }
    return null;
  }
  
  private boolean a(String paramString)
  {
    try
    {
      paramString = bdfr.decode(paramString, 0);
      paramString = new JSONObject(new String(new Cryptor().decrypt(paramString, "^%QAI$I+j{2HuP0L".getBytes())));
      if (paramString.has("uid")) {
        this.d = paramString.getString("uid");
      }
      for (int i = 1; (i != 0) && (paramString.has("ukey")); i = 0)
      {
        this.e = paramString.getString("ukey");
        return true;
      }
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     leo
 * JD-Core Version:    0.7.0.1
 */