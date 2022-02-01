package io.flutter.plugin.common;

import androidx.annotation.Nullable;
import java.util.Map;
import org.json.JSONObject;

public final class MethodCall
{
  public final Object arguments;
  public final String method;
  
  public MethodCall(String paramString, Object paramObject)
  {
    this.method = paramString;
    this.arguments = paramObject;
  }
  
  @Nullable
  public <T> T argument(String paramString)
  {
    Object localObject = this.arguments;
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof Map)) {
      return ((Map)localObject).get(paramString);
    }
    if ((localObject instanceof JSONObject)) {
      return ((JSONObject)localObject).opt(paramString);
    }
    throw new ClassCastException();
  }
  
  public <T> T arguments()
  {
    return this.arguments;
  }
  
  public boolean hasArgument(String paramString)
  {
    Object localObject = this.arguments;
    if (localObject == null) {
      return false;
    }
    if ((localObject instanceof Map)) {
      return ((Map)localObject).containsKey(paramString);
    }
    if ((localObject instanceof JSONObject)) {
      return ((JSONObject)localObject).has(paramString);
    }
    throw new ClassCastException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.common.MethodCall
 * JD-Core Version:    0.7.0.1
 */