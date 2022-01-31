package com.tencent.oskplayer.util;

import android.text.TextUtils;
import com.tencent.oskplayer.PlayerConfig;
import java.util.Iterator;
import java.util.List;

public class PassOnVideoType
  implements Predicate<String>
{
  public static final String TAG = "PassOnVideoType";
  
  public boolean evaluate(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.toLowerCase();
      Iterator localIterator = PlayerConfig.g().getContentTypeList().iterator();
      do
      {
        String str;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          str = (String)localIterator.next();
        } while (TextUtils.isEmpty(str));
        if (paramString.startsWith(str.toLowerCase())) {
          return true;
        }
        if (paramString.startsWith("video")) {
          return true;
        }
      } while (!paramString.startsWith("audio"));
      return true;
    }
    PlayerUtils.log(5, "PassOnVideoType", "contentType is null");
    return false;
  }
  
  public boolean evaluate(byte[] paramArrayOfByte)
  {
    return !PlayerUtils.isContentHtml(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.util.PassOnVideoType
 * JD-Core Version:    0.7.0.1
 */