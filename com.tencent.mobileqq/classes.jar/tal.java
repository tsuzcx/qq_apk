import org.json.JSONException;
import org.json.JSONObject;

public class tal
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
  
  public static paa a(int paramInt)
  {
    return new paa().b().a(paramInt);
  }
  
  public static paa a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    localpaa = a(paramInt);
    try
    {
      paramString1 = localpaa.b(paramString1).a("URL", paramString2);
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramString1 = paramString1.a("ad_page", paramInt);
        return paramString1;
      }
      return localpaa;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, qyu paramqyu)
  {
    if ((paramqyu instanceof qyw)) {}
    for (String str = ((qyw)paramqyu).f;; str = "0")
    {
      ocd.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt3), String.valueOf(paramInt1), String.valueOf(paramqyu.jdField_a_of_type_Int), a(paramInt2, paramqyu.e, str, paramqyu.jdField_a_of_type_Boolean).a(), false);
      return;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paa localpaa = a(paramInt1);
    if (paramBoolean) {
      paramInt1 = 1;
    }
    try
    {
      for (;;)
      {
        localpaa.a("ad_page_include", paramInt1);
        ocd.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt2), "", "", localpaa.a(), false);
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
  
  public static void a(String paramString, int paramInt, qyu paramqyu)
  {
    if ((paramqyu instanceof qyw)) {}
    for (paramqyu = ((qyw)paramqyu).f;; paramqyu = "0")
    {
      ocd.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt), "", "", a(paramInt, paramqyu), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tal
 * JD-Core Version:    0.7.0.1
 */