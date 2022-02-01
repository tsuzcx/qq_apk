package com.tencent.mobileqq.qroute.route;

import android.content.Context;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

public class URIRequest
{
  protected final Context context;
  protected final HashMap<String, Object> fields;
  protected final Uri uri;
  
  public URIRequest(Context paramContext, Uri paramUri, Map<String, Object> paramMap)
  {
    this.context = paramContext;
    this.uri = paramUri;
    this.fields = new HashMap();
    if (paramMap != null) {
      this.fields.putAll(paramMap);
    }
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public <T> T getField(Class<T> paramClass, String paramString)
  {
    return getField(paramClass, paramString, null);
  }
  
  public <T> T getField(Class<T> paramClass, String paramString, T paramT)
  {
    paramString = this.fields.get(paramString);
    if (paramString == null) {
      return paramT;
    }
    try
    {
      paramClass = paramClass.cast(paramString);
      return paramClass;
    }
    catch (ClassCastException paramClass)
    {
      Logger.warning(paramClass.toString());
    }
    return paramT;
  }
  
  public HashMap<String, Object> getFields()
  {
    return this.fields;
  }
  
  public Uri getURI()
  {
    return this.uri;
  }
  
  public boolean hasField(String paramString)
  {
    return this.fields.containsKey(paramString);
  }
  
  public <T> URIRequest putField(String paramString, T paramT)
  {
    if (paramString == null)
    {
      Logger.warning("put field for empty key");
      return this;
    }
    this.fields.put(paramString, paramT);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.URIRequest
 * JD-Core Version:    0.7.0.1
 */