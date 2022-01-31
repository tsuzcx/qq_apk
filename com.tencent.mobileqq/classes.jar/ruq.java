import org.json.JSONException;
import org.json.JSONObject;

public class ruq
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
  
  public static onr a(int paramInt)
  {
    return new onr().b().a(paramInt);
  }
  
  public static onr a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    localonr = a(paramInt);
    try
    {
      paramString1 = localonr.b(paramString1).a("URL", paramString2);
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramString1 = paramString1.a("ad_page", paramInt);
        return paramString1;
      }
      return localonr;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, qdm paramqdm)
  {
    if ((paramqdm instanceof qdo)) {}
    for (String str = ((qdo)paramqdm).f;; str = "0")
    {
      noo.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt3), String.valueOf(paramInt1), String.valueOf(paramqdm.jdField_a_of_type_Int), a(paramInt2, paramqdm.e, str, paramqdm.jdField_a_of_type_Boolean).a(), false);
      return;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    onr localonr = a(paramInt1);
    if (paramBoolean) {
      paramInt1 = 1;
    }
    try
    {
      for (;;)
      {
        localonr.a("ad_page_include", paramInt1);
        noo.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt2), "", "", localonr.a(), false);
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
  
  public static void a(String paramString, int paramInt, qdm paramqdm)
  {
    if ((paramqdm instanceof qdo)) {}
    for (paramqdm = ((qdo)paramqdm).f;; paramqdm = "0")
    {
      noo.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt), "", "", a(paramInt, paramqdm), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ruq
 * JD-Core Version:    0.7.0.1
 */