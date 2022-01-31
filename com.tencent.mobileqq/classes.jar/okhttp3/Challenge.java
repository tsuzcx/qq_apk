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
    if (paramString1 == null) {
      throw new NullPointerException("scheme == null");
    }
    if (paramString2 == null) {
      throw new NullPointerException("realm == null");
    }
    this.scheme = paramString1;
    this.authParams = Collections.singletonMap("realm", paramString2);
  }
  
  public Challenge(String paramString, Map<String, String> paramMap)
  {
    if (paramString == null) {
      throw new NullPointerException("scheme == null");
    }
    if (paramMap == null) {
      throw new NullPointerException("authParams == null");
    }
    this.scheme = paramString;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    if (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localEntry.getKey() == null) {}
      for (paramString = null;; paramString = ((String)localEntry.getKey()).toLowerCase(Locale.US))
      {
        localLinkedHashMap.put(paramString, localEntry.getValue());
        break;
      }
    }
    this.authParams = Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  public Map<String, String> authParams()
  {
    return this.authParams;
  }
  
  public Charset charset()
  {
    Object localObject = (String)this.authParams.get("charset");
    if (localObject != null) {
      try
      {
        localObject = Charset.forName((String)localObject);
        return localObject;
      }
      catch (Exception localException) {}
    }
    return Util.ISO_8859_1;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof Challenge)) && (((Challenge)paramObject).scheme.equals(this.scheme)) && (((Challenge)paramObject).authParams.equals(this.authParams));
  }
  
  public int hashCode()
  {
    return (this.scheme.hashCode() + 899) * 31 + this.authParams.hashCode();
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
    return this.scheme + " authParams=" + this.authParams;
  }
  
  public Challenge withCharset(Charset paramCharset)
  {
    if (paramCharset == null) {
      throw new NullPointerException("charset == null");
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.authParams);
    localLinkedHashMap.put("charset", paramCharset.name());
    return new Challenge(this.scheme, localLinkedHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.Challenge
 * JD-Core Version:    0.7.0.1
 */