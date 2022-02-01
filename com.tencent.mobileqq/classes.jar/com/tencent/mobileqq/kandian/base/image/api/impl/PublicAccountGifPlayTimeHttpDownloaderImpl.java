package com.tencent.mobileqq.kandian.base.image.api.impl;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.LooperGifImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountGifPlayTimeHttpDownloader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

public class PublicAccountGifPlayTimeHttpDownloaderImpl
  extends PublicAccountHttpDownloaderImpl
  implements IPublicAccountGifPlayTimeHttpDownloader
{
  final int playTime = 3;
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (GifDrawable.isGifFile(paramFile))
    {
      boolean bool = paramDownloadParams.mExtraInfo instanceof JSONObject;
      int i = 3;
      if (bool) {
        i = ((JSONObject)paramDownloadParams.mExtraInfo).optInt("gifPlayCount", 3);
      }
      return new LooperGifImage(paramFile, true, i);
    }
    return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
  }
  
  public URL getPubURL(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new URL("pubaccountimage_gifplaytime", null, paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      QLog.e("PubAccountHttpDownloader", 2, "getPubURL urlString", paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.api.impl.PublicAccountGifPlayTimeHttpDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */