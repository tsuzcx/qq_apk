package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public final class MediaType
{
  private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  private static final String QUOTED = "\"([^\"]*)\"";
  private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
  private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
  @Nullable
  private final String charset;
  private final String mediaType;
  private final String subtype;
  private final String type;
  
  private MediaType(String paramString1, String paramString2, String paramString3, @Nullable String paramString4)
  {
    this.mediaType = paramString1;
    this.type = paramString2;
    this.subtype = paramString3;
    this.charset = paramString4;
  }
  
  public static MediaType get(String paramString)
  {
    Object localObject1 = TYPE_SUBTYPE.matcher(paramString);
    if (!((Matcher)localObject1).lookingAt()) {
      throw new IllegalArgumentException("No subtype found for: \"" + paramString + '"');
    }
    String str2 = ((Matcher)localObject1).group(1).toLowerCase(Locale.US);
    String str3 = ((Matcher)localObject1).group(2).toLowerCase(Locale.US);
    Matcher localMatcher = PARAMETER.matcher(paramString);
    int i = ((Matcher)localObject1).end();
    Object localObject2 = null;
    if (i < paramString.length())
    {
      localMatcher.region(i, paramString.length());
      if (!localMatcher.lookingAt()) {
        throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + paramString.substring(i) + "\" for: \"" + paramString + '"');
      }
      String str1 = localMatcher.group(1);
      localObject1 = localObject2;
      if (str1 != null)
      {
        if (str1.equalsIgnoreCase("charset")) {
          break label199;
        }
        localObject1 = localObject2;
      }
      for (;;)
      {
        i = localMatcher.end();
        localObject2 = localObject1;
        break;
        label199:
        str1 = localMatcher.group(2);
        if (str1 != null)
        {
          localObject1 = str1;
          if (str1.startsWith("'"))
          {
            localObject1 = str1;
            if (str1.endsWith("'"))
            {
              localObject1 = str1;
              if (str1.length() <= 2) {}
            }
          }
        }
        for (localObject1 = str1.substring(1, str1.length() - 1); (localObject2 != null) && (!((String)localObject1).equalsIgnoreCase(localObject2)); localObject1 = localMatcher.group(3)) {
          throw new IllegalArgumentException("Multiple charsets defined: \"" + localObject2 + "\" and: \"" + (String)localObject1 + "\" for: \"" + paramString + '"');
        }
      }
    }
    return new MediaType(paramString, str2, str3, localObject2);
  }
  
  @Nullable
  public static MediaType parse(String paramString)
  {
    try
    {
      paramString = get(paramString);
      return paramString;
    }
    catch (IllegalArgumentException paramString) {}
    return null;
  }
  
  @Nullable
  public Charset charset()
  {
    return charset(null);
  }
  
  @Nullable
  public Charset charset(@Nullable Charset paramCharset)
  {
    Charset localCharset = paramCharset;
    try
    {
      if (this.charset != null) {
        localCharset = Charset.forName(this.charset);
      }
      return localCharset;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
    return paramCharset;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof MediaType)) && (((MediaType)paramObject).mediaType.equals(this.mediaType));
  }
  
  public int hashCode()
  {
    return this.mediaType.hashCode();
  }
  
  public String subtype()
  {
    return this.subtype;
  }
  
  public String toString()
  {
    return this.mediaType;
  }
  
  public String type()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.MediaType
 * JD-Core Version:    0.7.0.1
 */