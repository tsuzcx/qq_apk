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
    if (this.arguments == null) {
      return null;
    }
    if ((this.arguments instanceof Map)) {
      return ((Map)this.arguments).get(paramString);
    }
    if ((this.arguments instanceof JSONObject)) {
      return ((JSONObject)this.arguments).opt(paramString);
    }
    throw new ClassCastException();
  }
  
  public <T> T arguments()
  {
    return this.arguments;
  }
  
  public boolean hasArgument(String paramString)
  {
    if (this.arguments == null) {
      return false;
    }
    if ((this.arguments instanceof Map)) {
      return ((Map)this.arguments).containsKey(paramString);
    }
    if ((this.arguments instanceof JSONObject)) {
      return ((JSONObject)this.arguments).has(paramString);
    }
    throw new ClassCastException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.common.MethodCall
 * JD-Core Version:    0.7.0.1
 */