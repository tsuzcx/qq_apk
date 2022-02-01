package com.tencent.oskplayer.proxy;

import android.webkit.URLUtil;
import com.tencent.oskplayer.util.MD5;
import com.tencent.oskplayer.util.PlayerUtils;
import java.net.MalformedURLException;
import java.net.URL;

public class DefaultVideoKeyGenerator
  implements VideoKeyGenerator
{
  public String generate(String paramString)
  {
    if (!URLUtil.isNetworkUrl(paramString)) {
      return paramString;
    }
    Object localObject;
    try
    {
      URL localURL = new URL(paramString);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      PlayerUtils.log(6, "DefaultVideoKeyGenerator", PlayerUtils.getPrintableStackTrace(localMalformedURLException));
      localObject = null;
    }
    if (localObject != null) {
      return MD5.md5(paramString).substring(0, 20);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.DefaultVideoKeyGenerator
 * JD-Core Version:    0.7.0.1
 */