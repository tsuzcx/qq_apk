package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class DeviceMsgThumbDownloader$DeviceImgBitmapDecoder
  implements BitmapDecoder
{
  DeviceMsgThumbDownloader$DeviceImgBitmapDecoder(DeviceMsgThumbDownloader paramDeviceMsgThumbDownloader) {}
  
  public Bitmap getBitmap(URL paramURL)
  {
    LocalMediaInfo localLocalMediaInfo = this.this$0.parseUrl(paramURL);
    if (localLocalMediaInfo == null) {
      return null;
    }
    paramURL = new BitmapFactory.Options();
    paramURL.inDensity = 160;
    paramURL.inTargetDensity = 160;
    paramURL.inScreenDensity = 160;
    try
    {
      paramURL = BitmapFactory.decodeFile(localLocalMediaInfo.path, paramURL);
    }
    catch (OutOfMemoryError paramURL)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VIdeoThumbDownloader", 2, "DeviceImgBitmapDecoder getBitmap", paramURL);
      }
      paramURL = null;
    }
    if (paramURL != null) {
      return ThumbnailUtils.extractThumbnail(paramURL, localLocalMediaInfo.thumbWidth, localLocalMediaInfo.thumbHeight, 2);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.DeviceMsgThumbDownloader.DeviceImgBitmapDecoder
 * JD-Core Version:    0.7.0.1
 */