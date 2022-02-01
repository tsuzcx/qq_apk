package com.tencent.mobileqq.transfile;

import android.app.Application;
import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.NewRegionalThumbDecoder;
import com.tencent.mobileqq.activity.photo.RegionalThumbDecoder;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class RegionalThumbDownloader
  extends ProtocolDownloader.Adapter
{
  public RegionalThumbDownloader(Application paramApplication) {}
  
  public static URL generateURL(String paramString, int paramInt1, int paramInt2)
  {
    return generateURL(paramString, paramInt1, paramInt2, false);
  }
  
  public static URL generateURL(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.path = paramString;
    paramString = new File(paramString);
    if (paramString.exists()) {
      localLocalMediaInfo.modifiedDate = paramString.lastModified();
    }
    localLocalMediaInfo.thumbWidth = paramInt1;
    localLocalMediaInfo.thumbHeight = paramInt2;
    localLocalMediaInfo.isRegionThumbUseNewDecoder = paramBoolean;
    try
    {
      paramString = new URL("regionalthumb", null, LocalMediaInfo.getUrl(localLocalMediaInfo));
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      label82:
      break label82;
    }
    return null;
  }
  
  public static URL generateURLForNew(String paramString, int paramInt1, int paramInt2)
  {
    return generateURL(paramString, paramInt1, paramInt2, true);
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramFile = LocalMediaInfo.parseUrl(paramDownloadParams.url);
    if (paramFile != null)
    {
      if (paramFile.isRegionThumbUseNewDecoder) {
        paramFile = new NewRegionalThumbDecoder();
      } else {
        paramFile = new RegionalThumbDecoder();
      }
      paramURLDrawableHandler = paramFile.getBitmap(paramDownloadParams.url);
      paramFile = paramURLDrawableHandler;
      if (paramURLDrawableHandler != null)
      {
        paramDownloadParams.outWidth = paramURLDrawableHandler.getWidth();
        paramDownloadParams.outHeight = paramURLDrawableHandler.getHeight();
        return paramURLDrawableHandler;
      }
    }
    else
    {
      paramFile = null;
    }
    return paramFile;
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    paramDownloadParams = LocalMediaInfo.parseUrl(paramDownloadParams.url);
    return (paramDownloadParams != null) && (new File(paramDownloadParams.path).exists());
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = LocalMediaInfo.parseUrl(paramDownloadParams.url);
    if (paramDownloadParams != null)
    {
      paramDownloadParams = new File(paramDownloadParams.path);
      if (paramDownloadParams.exists()) {
        return paramDownloadParams;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.RegionalThumbDownloader
 * JD-Core Version:    0.7.0.1
 */