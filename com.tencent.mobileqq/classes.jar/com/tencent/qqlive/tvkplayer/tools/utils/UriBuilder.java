package com.tencent.qqlive.tvkplayer.tools.utils;

import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class UriBuilder
{
  private StringBuffer mUri = new StringBuffer();
  
  public UriBuilder addParam(String paramString1, String paramString2)
  {
    if (this.mUri.toString().contains("?")) {}
    for (String str = "&";; str = "?")
    {
      this.mUri.append(str);
      this.mUri.append(paramString1 + "=" + paramString2);
      return this;
    }
  }
  
  public UriBuilder addParam(@NonNull Map<String, String> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      addParam((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    return this;
  }
  
  public String buildUri()
  {
    return this.mUri.toString();
  }
  
  public UriBuilder setUrl(@NonNull String paramString)
  {
    int i = this.mUri.length();
    this.mUri.delete(0, i);
    this.mUri.append(paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.UriBuilder
 * JD-Core Version:    0.7.0.1
 */