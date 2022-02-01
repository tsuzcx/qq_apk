package com.tencent.oskplayer.util.apache;

import android.text.TextUtils;
import com.tencent.oskplayer.util.PlayerUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlValidator
  implements Serializable
{
  public static final long ALLOW_2_SLASHES = 2L;
  public static final long ALLOW_ALL_SCHEMES = 1L;
  public static final long ALLOW_LOCAL_URLS = 8L;
  private static final Pattern ASCII_PATTERN;
  private static final String AUTHORITY_CHARS_REGEX = "\\p{Alnum}\\-\\.";
  private static final Pattern AUTHORITY_PATTERN;
  private static final String AUTHORITY_REGEX = "^([\\p{Alnum}\\-\\.]*)(:\\d*)?(.*)?";
  private static final String[] DEFAULT_SCHEMES = { "http", "https", "ftp" };
  private static final UrlValidator DEFAULT_URL_VALIDATOR = new UrlValidator();
  private static final String LEGAL_ASCII_REGEX = "^\\p{ASCII}+$";
  public static final long NO_FRAGMENTS = 4L;
  private static final int PARSE_AUTHORITY_EXTRA = 3;
  private static final int PARSE_AUTHORITY_HOST_IP = 1;
  private static final int PARSE_AUTHORITY_PORT = 2;
  private static final int PARSE_URL_AUTHORITY = 4;
  private static final int PARSE_URL_FRAGMENT = 9;
  private static final int PARSE_URL_PATH = 5;
  private static final int PARSE_URL_QUERY = 7;
  private static final int PARSE_URL_SCHEME = 2;
  private static final Pattern PATH_PATTERN;
  private static final String PATH_REGEX = "^(/[-\\w:@&?=+,.!/~*'%$_;\\(\\)]*)?$";
  private static final Pattern PORT_PATTERN;
  private static final String PORT_REGEX = "^:(\\d{1,5})$";
  private static final Pattern QUERY_PATTERN;
  private static final String QUERY_REGEX = "^(.*)$";
  private static final Pattern SCHEME_PATTERN;
  private static final String SCHEME_REGEX = "^\\p{Alpha}[\\p{Alnum}\\+\\-\\.]*";
  private static final Pattern URL_PATTERN = Pattern.compile("^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?");
  private static final String URL_REGEX = "^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?";
  private static final long serialVersionUID = 7557161713937335013L;
  private final Set allowedSchemes;
  private final RegexValidator authorityValidator;
  private final long options;
  
  static
  {
    SCHEME_PATTERN = Pattern.compile("^\\p{Alpha}[\\p{Alnum}\\+\\-\\.]*");
    AUTHORITY_PATTERN = Pattern.compile("^([\\p{Alnum}\\-\\.]*)(:\\d*)?(.*)?");
    PATH_PATTERN = Pattern.compile("^(/[-\\w:@&?=+,.!/~*'%$_;\\(\\)]*)?$");
    QUERY_PATTERN = Pattern.compile("^(.*)$");
    ASCII_PATTERN = Pattern.compile("^\\p{ASCII}+$");
    PORT_PATTERN = Pattern.compile("^:(\\d{1,5})$");
  }
  
  public UrlValidator()
  {
    this(null);
  }
  
  public UrlValidator(long paramLong)
  {
    this(null, null, paramLong);
  }
  
  public UrlValidator(RegexValidator paramRegexValidator, long paramLong)
  {
    this(null, paramRegexValidator, paramLong);
  }
  
  public UrlValidator(String[] paramArrayOfString)
  {
    this(paramArrayOfString, 0L);
  }
  
  public UrlValidator(String[] paramArrayOfString, long paramLong)
  {
    this(paramArrayOfString, null, paramLong);
  }
  
  public UrlValidator(String[] paramArrayOfString, RegexValidator paramRegexValidator, long paramLong)
  {
    this.options = paramLong;
    if (isOn(1L)) {
      this.allowedSchemes = Collections.EMPTY_SET;
    }
    for (;;)
    {
      this.authorityValidator = paramRegexValidator;
      return;
      String[] arrayOfString = paramArrayOfString;
      if (paramArrayOfString == null) {
        arrayOfString = DEFAULT_SCHEMES;
      }
      this.allowedSchemes = new HashSet();
      this.allowedSchemes.addAll(Arrays.asList(arrayOfString));
    }
  }
  
  public static UrlValidator getInstance()
  {
    return DEFAULT_URL_VALIDATOR;
  }
  
  private boolean isOff(long paramLong)
  {
    return (this.options & paramLong) == 0L;
  }
  
  private boolean isOn(long paramLong)
  {
    return (this.options & paramLong) > 0L;
  }
  
  protected int countToken(String paramString1, String paramString2)
  {
    int j = 0;
    int i = 0;
    while (i != -1)
    {
      int k = paramString2.indexOf(paramString1, i);
      i = k;
      if (k > -1)
      {
        i = k + 1;
        j += 1;
      }
    }
    return j;
  }
  
  public boolean isValid(String paramString)
  {
    if (paramString == null) {}
    String str2;
    do
    {
      while ((!isValidPath(paramString.group(5))) || (!isValidQuery(paramString.group(7))) || (!isValidFragment(paramString.group(9))))
      {
        String str1;
        do
        {
          do
          {
            do
            {
              return false;
              if (PlayerUtils.isLocalFile(paramString)) {
                return true;
              }
            } while (!ASCII_PATTERN.matcher(paramString).matches());
            paramString = URL_PATTERN.matcher(paramString);
          } while (!paramString.matches());
          str1 = paramString.group(2);
        } while (!isValidScheme(str1));
        str2 = paramString.group(4);
        if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2))) {
          break;
        }
      }
      return true;
    } while (isValidAuthority(str2));
    return false;
  }
  
  protected boolean isValidAuthority(String paramString)
  {
    if (paramString == null) {}
    do
    {
      String str;
      do
      {
        do
        {
          do
          {
            return false;
            if ((this.authorityValidator != null) && (this.authorityValidator.isValid(paramString))) {
              return true;
            }
            paramString = AUTHORITY_PATTERN.matcher(paramString);
          } while (!paramString.matches());
          str = paramString.group(1);
        } while ((!DomainValidator.getInstance(isOn(8L)).isValid(str)) && (!InetAddressValidator.getInstance().isValid(str)));
        str = paramString.group(2);
      } while ((str != null) && (!PORT_PATTERN.matcher(str).matches()));
      paramString = paramString.group(3);
    } while ((paramString != null) && (paramString.trim().length() > 0));
    return true;
  }
  
  protected boolean isValidFragment(String paramString)
  {
    if (paramString == null) {
      return true;
    }
    return isOff(4L);
  }
  
  protected boolean isValidPath(String paramString)
  {
    if (paramString == null) {}
    int i;
    int j;
    int k;
    do
    {
      do
      {
        do
        {
          return false;
        } while (!PATH_PATTERN.matcher(paramString).matches());
        i = countToken("//", paramString);
      } while ((isOff(2L)) && (i > 0));
      j = countToken("/", paramString);
      k = countToken("..", paramString);
    } while ((k > 0) && (j - i - 1 <= k));
    return true;
  }
  
  protected boolean isValidQuery(String paramString)
  {
    if (paramString == null) {
      return true;
    }
    return QUERY_PATTERN.matcher(paramString).matches();
  }
  
  protected boolean isValidScheme(String paramString)
  {
    if (paramString == null) {}
    while ((!SCHEME_PATTERN.matcher(paramString).matches()) || ((isOff(1L)) && (!this.allowedSchemes.contains(paramString)))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.util.apache.UrlValidator
 * JD-Core Version:    0.7.0.1
 */