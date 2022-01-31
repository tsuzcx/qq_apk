import org.json.JSONException;
import org.json.JSONObject;

public class ria
{
  public static String a(int paramInt, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", paramString);
      localJSONObject.put("num", paramInt);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static ocg a(int paramInt)
  {
    return new ocg().b().a(paramInt);
  }
  
  public static ocg a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    localocg = a(paramInt);
    try
    {
      paramString1 = localocg.b(paramString1).a("URL", paramString2);
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramString1 = paramString1.a("ad_page", paramInt);
        return paramString1;
      }
      return localocg;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, pro parampro)
  {
    if ((parampro instanceof prq)) {}
    for (String str = ((prq)parampro).f;; str = "0")
    {
      ndn.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt3), String.valueOf(paramInt1), String.valueOf(parampro.jdField_a_of_type_Int), a(paramInt2, parampro.e, str, parampro.jdField_a_of_type_Boolean).a(), false);
      return;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ocg localocg = a(paramInt1);
    if (paramBoolean) {
      paramInt1 = 1;
    }
    try
    {
      for (;;)
      {
        localocg.a("ad_page_include", paramInt1);
        ndn.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt2), "", "", localocg.a(), false);
        return;
        paramInt1 = 0;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static void a(String paramString, int paramInt, pro parampro)
  {
    if ((parampro instanceof prq)) {}
    for (parampro = ((prq)parampro).f;; parampro = "0")
    {
      ndn.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt), "", "", a(paramInt, parampro), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ria
 * JD-Core Version:    0.7.0.1
 */