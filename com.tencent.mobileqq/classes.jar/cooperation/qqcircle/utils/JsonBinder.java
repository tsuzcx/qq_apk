package cooperation.qqcircle.utils;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonBinder
{
  private static final String TAG = "cooperation.qqcircle.utils.JsonBinder";
  private static JsonBinder jsonBinder;
  private Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().setLongSerializationPolicy(LongSerializationPolicy.STRING).create();
  
  public static JsonBinder getInstance()
  {
    if (jsonBinder == null) {
      jsonBinder = new JsonBinder();
    }
    return jsonBinder;
  }
  
  public <T> T fromJson(String paramString, Class<T> paramClass)
  {
    if (paramString == null) {}
    try
    {
      return paramClass.newInstance();
    }
    catch (JsonSyntaxException paramString)
    {
      StringBuilder localStringBuilder;
      break label141;
    }
    catch (InstantiationException paramString)
    {
      break label101;
    }
    catch (IllegalAccessException paramString)
    {
      break label61;
    }
    catch (NumberFormatException paramString)
    {
      break label21;
    }
    paramString = this.gson.fromJson(paramString, paramClass);
    return paramString;
    label21:
    paramString = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramClass.getName());
    localStringBuilder.append("clazz NumberFormatException error.");
    Log.e(paramString, localStringBuilder.toString());
    break label150;
    label61:
    paramString = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramClass.getName());
    localStringBuilder.append("clazz IllegalAccessException error.");
    Log.e(paramString, localStringBuilder.toString());
    break label150;
    label101:
    paramString = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramClass.getName());
    localStringBuilder.append("clazz new instance instantiation error.");
    Log.e(paramString, localStringBuilder.toString());
    break label150;
    label141:
    Log.e(TAG, "form json error.");
    label150:
    return null;
  }
  
  public <T> List<T> fromJson(String paramString, Type paramType)
  {
    if (paramString == null) {
      return new ArrayList();
    }
    try
    {
      paramString = (List)this.gson.fromJson(paramString, paramType);
      return paramString;
    }
    catch (JsonSyntaxException paramString)
    {
      label27:
      break label27;
    }
    Log.e(TAG, "form json error.");
    return new ArrayList();
  }
  
  public <T> T generticfromJson(String paramString, Type paramType)
  {
    try
    {
      paramString = this.gson.fromJson(paramString, paramType);
      return paramString;
    }
    catch (JsonSyntaxException paramString)
    {
      label12:
      break label12;
    }
    Log.e(TAG, "form json error.");
    return null;
  }
  
  public String toJson(Object paramObject)
  {
    return this.gson.toJson(paramObject);
  }
  
  public <T> String toJson(List<T> paramList)
  {
    return this.gson.toJson(paramList, new JsonBinder.1(this).getType());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.utils.JsonBinder
 * JD-Core Version:    0.7.0.1
 */