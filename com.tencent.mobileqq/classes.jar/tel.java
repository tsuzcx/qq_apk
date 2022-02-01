import org.json.JSONException;
import org.json.JSONObject;

public class tel
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
  
  public static pbg a(int paramInt)
  {
    return new pbg().b().a(paramInt);
  }
  
  public static pbg a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    localpbg = a(paramInt);
    try
    {
      paramString1 = localpbg.b(paramString1).a("URL", paramString2);
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramString1 = paramString1.a("ad_page", paramInt);
        return paramString1;
      }
      return localpbg;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, rft paramrft)
  {
    if ((paramrft instanceof rfv)) {}
    for (String str = ((rfv)paramrft).f;; str = "0")
    {
      odq.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt3), String.valueOf(paramInt1), String.valueOf(paramrft.jdField_a_of_type_Int), a(paramInt2, paramrft.e, str, paramrft.jdField_a_of_type_Boolean).a(), false);
      return;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    pbg localpbg = a(paramInt1);
    if (paramBoolean) {
      paramInt1 = 1;
    }
    try
    {
      for (;;)
      {
        localpbg.a("ad_page_include", paramInt1);
        odq.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt2), "", "", localpbg.a(), false);
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
  
  public static void a(String paramString, int paramInt, rft paramrft)
  {
    if ((paramrft instanceof rfv)) {}
    for (paramrft = ((rfv)paramrft).f;; paramrft = "0")
    {
      odq.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt), "", "", a(paramInt, paramrft), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tel
 * JD-Core Version:    0.7.0.1
 */