import com.tencent.qphone.base.util.Cryptor;
import org.json.JSONObject;

public class lbg
{
  public final String a = "uid";
  public final String b = "ukey";
  public final String c = "^%QAI$I+j{2HuP0L";
  public String d;
  public String e;
  
  public static lbg a(String paramString)
  {
    lbg locallbg = new lbg();
    if (locallbg.a(paramString)) {
      return locallbg;
    }
    return null;
  }
  
  private boolean a(String paramString)
  {
    try
    {
      paramString = bgku.decode(paramString, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lbg
 * JD-Core Version:    0.7.0.1
 */