package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import java.net.URL;

class DataLineDownloader$VideoBitmapDecoder
  implements BitmapDecoder
{
  public DataLineDownloader.DatalineDownLoadInfo downloadInfo;
  
  DataLineDownloader$VideoBitmapDecoder(DataLineDownloader paramDataLineDownloader) {}
  
  public Bitmap getBitmap(URL paramURL)
  {
    this.downloadInfo = this.this$0.parseUrl(paramURL);
    return DataLineDownloader.access$000(this.this$0, this.downloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.DataLineDownloader.VideoBitmapDecoder
 * JD-Core Version:    0.7.0.1
 */