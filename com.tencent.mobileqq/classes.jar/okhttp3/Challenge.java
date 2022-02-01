package okhttp3;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

public final class Challenge
{
  private final Map<String, String> authParams;
  private final String scheme;
  
  public Challenge(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 != null)
      {
        this.scheme = paramString1;
        this.authParams = Collections.singletonMap("realm", paramString2);
        return;
      }
      throw new NullPointerException("realm == null");
    }
    throw new NullPointerException("scheme == null");
  }
  
  public Challenge(String paramString, Map<String, String> paramMap)
  {
    if (paramString != null)
    {
      if (paramMap != null)
      {
        this.scheme = paramString;
        LinkedHashMap localLinkedHashMap = new LinkedHashMap();
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          if (localEntry.getKey() == null) {
            paramString = null;
          } else {
            paramString = ((String)localEntry.getKey()).toLowerCase(Locale.US);
          }
          localLinkedHashMap.put(paramString, localEntry.getValue());
        }
        this.authParams = Collections.unmodifiableMap(localLinkedHashMap);
        return;
      }
      throw new NullPointerException("authParams == null");
    }
    paramString = new NullPointerException("scheme == null");
    for (;;)
    {
      throw paramString;
    }
  }
  
  public Map<String, String> authParams()
  {
    return this.authParams;
  }
  
  public Charset charset()
  {
    Object localObject = (String)this.authParams.get("charset");
    if (localObject != null) {}
    try
    {
      localObject = Charset.forName((String)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      label26:
      break label26;
    }
    return Util.ISO_8859_1;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Challenge))
    {
      paramObject = (Challenge)paramObject;
      if ((paramObject.scheme.equals(this.scheme)) && (paramObject.authParams.equals(this.authParams))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return (899 + this.scheme.hashCode()) * 31 + this.authParams.hashCode();
  }
  
  public String realm()
  {
    return (String)this.authParams.get("realm");
  }
  
  public String scheme()
  {
    return this.scheme;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.scheme);
    localStringBuilder.append(" authParams=");
    localStringBuilder.append(this.authParams);
    return localStringBuilder.toString();
  }
  
  public Challenge withCharset(Charset paramCharset)
  {
    if (paramCharset != null)
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.authParams);
      localLinkedHashMap.put("charset", paramCharset.name());
      return new Challenge(this.scheme, localLinkedHashMap);
    }
    throw new NullPointerException("charset == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.Challenge
 * JD-Core Version:    0.7.0.1
 */