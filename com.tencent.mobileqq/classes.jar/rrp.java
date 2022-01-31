import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;

public class rrp
{
  private static final String jdField_a_of_type_JavaLangString = rrp.class.getName();
  private static rrp jdField_a_of_type_Rrp;
  private Gson jdField_a_of_type_ComGoogleGsonGson = new GsonBuilder().serializeSpecialFloatingPointValues().setLongSerializationPolicy(LongSerializationPolicy.STRING).create();
  
  public static rrp a()
  {
    if (jdField_a_of_type_Rrp == null) {
      jdField_a_of_type_Rrp = new rrp();
    }
    return jdField_a_of_type_Rrp;
  }
  
  public <T> T a(String paramString, Class<T> paramClass)
  {
    if (paramString == null) {}
    try
    {
      return paramClass.newInstance();
    }
    catch (JsonSyntaxException paramString)
    {
      Log.e(jdField_a_of_type_JavaLangString, "form json error.");
      return null;
    }
    catch (InstantiationException paramString)
    {
      for (;;)
      {
        Log.e(jdField_a_of_type_JavaLangString, paramClass.getName() + "clazz new instance instantiation error.");
      }
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        Log.e(jdField_a_of_type_JavaLangString, paramClass.getName() + "clazz IllegalAccessException error.");
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        Log.e(jdField_a_of_type_JavaLangString, paramClass.getName() + "clazz NumberFormatException error.");
      }
    }
    paramString = this.jdField_a_of_type_ComGoogleGsonGson.fromJson(paramString, paramClass);
    return paramString;
  }
  
  public String a(Object paramObject)
  {
    return this.jdField_a_of_type_ComGoogleGsonGson.toJson(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rrp
 * JD-Core Version:    0.7.0.1
 */