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
    if (((Matcher)localObject1).lookingAt())
    {
      String str1 = ((Matcher)localObject1).group(1).toLowerCase(Locale.US);
      String str2 = ((Matcher)localObject1).group(2).toLowerCase(Locale.US);
      Object localObject2 = null;
      Matcher localMatcher = PARAMETER.matcher(paramString);
      int i = ((Matcher)localObject1).end();
      while (i < paramString.length())
      {
        localMatcher.region(i, paramString.length());
        if (localMatcher.lookingAt())
        {
          Object localObject3 = localMatcher.group(1);
          localObject1 = localObject2;
          if (localObject3 != null) {
            if (!((String)localObject3).equalsIgnoreCase("charset"))
            {
              localObject1 = localObject2;
            }
            else
            {
              localObject3 = localMatcher.group(2);
              if (localObject3 != null)
              {
                localObject1 = localObject3;
                if (((String)localObject3).startsWith("'"))
                {
                  localObject1 = localObject3;
                  if (((String)localObject3).endsWith("'"))
                  {
                    localObject1 = localObject3;
                    if (((String)localObject3).length() > 2) {
                      localObject1 = ((String)localObject3).substring(1, ((String)localObject3).length() - 1);
                    }
                  }
                }
              }
              else
              {
                localObject1 = localMatcher.group(3);
              }
              if ((localObject2 != null) && (!((String)localObject1).equalsIgnoreCase((String)localObject2)))
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("Multiple charsets defined: \"");
                ((StringBuilder)localObject3).append((String)localObject2);
                ((StringBuilder)localObject3).append("\" and: \"");
                ((StringBuilder)localObject3).append((String)localObject1);
                ((StringBuilder)localObject3).append("\" for: \"");
                ((StringBuilder)localObject3).append(paramString);
                ((StringBuilder)localObject3).append('"');
                throw new IllegalArgumentException(((StringBuilder)localObject3).toString());
              }
            }
          }
          i = localMatcher.end();
          localObject2 = localObject1;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Parameter is not formatted correctly: \"");
          ((StringBuilder)localObject1).append(paramString.substring(i));
          ((StringBuilder)localObject1).append("\" for: \"");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append('"');
          throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
        }
      }
      return new MediaType(paramString, str1, str2, (String)localObject2);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("No subtype found for: \"");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append('"');
    paramString = new IllegalArgumentException(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw paramString;
    }
  }
  
  @Nullable
  public static MediaType parse(String paramString)
  {
    try
    {
      paramString = get(paramString);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      label7:
      break label7;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.MediaType
 * JD-Core Version:    0.7.0.1
 */