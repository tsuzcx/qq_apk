package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import java.net.URL;

class FileAssistantDownloader$VideoBitmapCreator
  implements BitmapDecoder
{
  FileAssistantDownloader$VideoBitmapCreator(FileAssistantDownloader paramFileAssistantDownloader) {}
  
  public Bitmap getBitmap(URL paramURL)
  {
    paramURL = this.this$0.parseUrl(paramURL);
    if (paramURL == null) {
      return null;
    }
    return ShortVideoUtils.getVideoThumbnail(null, paramURL.path);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FileAssistantDownloader.VideoBitmapCreator
 * JD-Core Version:    0.7.0.1
 */