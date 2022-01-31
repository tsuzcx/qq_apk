import org.json.JSONException;
import org.json.JSONObject;

public class sla
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
  
  public static orz a(int paramInt)
  {
    return new orz().b().a(paramInt);
  }
  
  public static orz a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    localorz = a(paramInt);
    try
    {
      paramString1 = localorz.b(paramString1).a("URL", paramString2);
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramString1 = paramString1.a("ad_page", paramInt);
        return paramString1;
      }
      return localorz;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, qnf paramqnf)
  {
    if ((paramqnf instanceof qnh)) {}
    for (String str = ((qnh)paramqnf).f;; str = "0")
    {
      nrt.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt3), String.valueOf(paramInt1), String.valueOf(paramqnf.jdField_a_of_type_Int), a(paramInt2, paramqnf.e, str, paramqnf.jdField_a_of_type_Boolean).a(), false);
      return;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    orz localorz = a(paramInt1);
    if (paramBoolean) {
      paramInt1 = 1;
    }
    try
    {
      for (;;)
      {
        localorz.a("ad_page_include", paramInt1);
        nrt.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt2), "", "", localorz.a(), false);
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
  
  public static void a(String paramString, int paramInt, qnf paramqnf)
  {
    if ((paramqnf instanceof qnh)) {}
    for (paramqnf = ((qnh)paramqnf).f;; paramqnf = "0")
    {
      nrt.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt), "", "", a(paramInt, paramqnf), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sla
 * JD-Core Version:    0.7.0.1
 */