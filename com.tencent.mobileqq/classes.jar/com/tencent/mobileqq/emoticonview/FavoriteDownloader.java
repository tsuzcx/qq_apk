package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import java.net.MalformedURLException;
import java.net.URL;

public class FavoriteDownloader
  extends AlbumThumbDownloader
{
  public static final String PROTOCOL_FAVORITE = "favorite";
  public static final String TAG = "FavoriteDownloader";
  
  public static URL generateURL(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("favorite");
    localStringBuilder.append("://");
    localStringBuilder.append(paramString1);
    if (paramString2 != null)
    {
      localStringBuilder.append("#");
      localStringBuilder.append(paramString2);
    }
    try
    {
      paramString1 = new URL(localStringBuilder.toString());
      return paramString1;
    }
    catch (MalformedURLException paramString1)
    {
      label54:
      break label54;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FavoriteDownloader
 * JD-Core Version:    0.7.0.1
 */