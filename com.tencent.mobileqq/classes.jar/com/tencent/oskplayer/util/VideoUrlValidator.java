package com.tencent.oskplayer.util;

import com.tencent.oskplayer.model.SegmentVideoInfo.SegmentInfo;
import com.tencent.oskplayer.model.SegmentVideoInfo.StreamInfo;
import com.tencent.oskplayer.util.apache.UrlValidator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VideoUrlValidator
  extends UrlValidator
{
  public static final String LOG_TAG = "UrlValidator";
  private static ConcurrentHashMap<String, Boolean> sUrlValidateResultCache = new ConcurrentHashMap();
  private final String INSTRICT_INVALID_PARAM_REGEX = "[\\Q[\\E\\Q]\\E<>\\Q{\\E\\Q}\\E\\Q\\E\\Q^\\E\\Q~\\E`;?@=&$+\"]";
  private final Pattern PATTERN_INVALID_PARAM = Pattern.compile("[\\Q[\\E\\Q]\\E<>\\Q{\\E\\Q}\\E\\Q\\E\\Q^\\E\\Q~\\E`;?@=&$+\"]");
  private final String STRICT_INVALID_PARAM_REGEX = "[\\Q[\\E\\Q]\\E<>\\Q{\\E\\Q}\\E\\Q\\E\\Q^\\E\\Q~\\E`;/?@=&$+\"]";
  
  public VideoUrlValidator()
  {
    super(null, null, 1L);
  }
  
  public VideoUrlValidator(String[] paramArrayOfString)
  {
    super(paramArrayOfString);
  }
  
  public boolean isValid(SegmentVideoInfo.StreamInfo paramStreamInfo)
  {
    int i = 0;
    while (i < paramStreamInfo.getCount())
    {
      if (!isValid(paramStreamInfo.getSegment(i).url)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public boolean isValid(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isValid ");
    localStringBuilder.append(paramString);
    PlayerUtils.log(4, "UrlValidator", localStringBuilder.toString());
    if (sUrlValidateResultCache.containsKey(paramString)) {
      return ((Boolean)sUrlValidateResultCache.get(paramString)).booleanValue();
    }
    boolean bool = super.isValid(paramString);
    sUrlValidateResultCache.put(paramString, Boolean.valueOf(bool));
    return bool;
  }
  
  protected boolean isValidQuery(String paramString)
  {
    if (paramString == null) {
      return true;
    }
    paramString = paramString.split("&");
    int i = 0;
    while (i < paramString.length)
    {
      Object localObject = paramString[i].split("=");
      if (localObject.length == 2)
      {
        if (this.PATTERN_INVALID_PARAM.matcher(localObject[0]).find())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("invalid query string detected ");
          ((StringBuilder)localObject).append(paramString[i]);
          PlayerUtils.log(5, "UrlValidator", ((StringBuilder)localObject).toString());
          return false;
        }
        if (this.PATTERN_INVALID_PARAM.matcher(localObject[1]).find())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("invalid query string detected ");
          ((StringBuilder)localObject).append(paramString[i]);
          PlayerUtils.log(5, "UrlValidator", ((StringBuilder)localObject).toString());
          return false;
        }
      }
      else if ((localObject.length == 1) && (paramString[i].indexOf('=') == paramString[i].length() - 1))
      {
        if (this.PATTERN_INVALID_PARAM.matcher(localObject[0]).find())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("invalid query string detected ");
          ((StringBuilder)localObject).append(paramString[i]);
          PlayerUtils.log(5, "UrlValidator", ((StringBuilder)localObject).toString());
          return false;
        }
      }
      else if (localObject.length > 2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("invalid query string detected ");
        ((StringBuilder)localObject).append(paramString[i]);
        PlayerUtils.log(5, "UrlValidator", ((StringBuilder)localObject).toString());
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  protected boolean isValidScheme(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "file";
    }
    return super.isValidScheme(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.util.VideoUrlValidator
 * JD-Core Version:    0.7.0.1
 */