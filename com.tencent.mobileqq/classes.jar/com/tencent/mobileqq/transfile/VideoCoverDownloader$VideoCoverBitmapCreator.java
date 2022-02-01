package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import java.net.URL;

class VideoCoverDownloader$VideoCoverBitmapCreator
  implements BitmapDecoder
{
  VideoCoverDownloader$VideoCoverBitmapCreator(VideoCoverDownloader paramVideoCoverDownloader) {}
  
  public Bitmap getBitmap(URL paramURL)
  {
    return ShortVideoUtils.getVideoThumbnail(null, paramURL.getPath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VideoCoverDownloader.VideoCoverBitmapCreator
 * JD-Core Version:    0.7.0.1
 */