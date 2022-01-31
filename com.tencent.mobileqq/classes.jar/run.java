import org.json.JSONException;
import org.json.JSONObject;

public class run
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
  
  public static ono a(int paramInt)
  {
    return new ono().b().a(paramInt);
  }
  
  public static ono a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    localono = a(paramInt);
    try
    {
      paramString1 = localono.b(paramString1).a("URL", paramString2);
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramString1 = paramString1.a("ad_page", paramInt);
        return paramString1;
      }
      return localono;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, qdj paramqdj)
  {
    if ((paramqdj instanceof qdl)) {}
    for (String str = ((qdl)paramqdj).f;; str = "0")
    {
      nol.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt3), String.valueOf(paramInt1), String.valueOf(paramqdj.jdField_a_of_type_Int), a(paramInt2, paramqdj.e, str, paramqdj.jdField_a_of_type_Boolean).a(), false);
      return;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ono localono = a(paramInt1);
    if (paramBoolean) {
      paramInt1 = 1;
    }
    try
    {
      for (;;)
      {
        localono.a("ad_page_include", paramInt1);
        nol.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt2), "", "", localono.a(), false);
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
  
  public static void a(String paramString, int paramInt, qdj paramqdj)
  {
    if ((paramqdj instanceof qdl)) {}
    for (paramqdj = ((qdl)paramqdj).f;; paramqdj = "0")
    {
      nol.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt), "", "", a(paramInt, paramqdj), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     run
 * JD-Core Version:    0.7.0.1
 */