package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class DeviceMsgThumbDownloader$DeviceVideoBitmapDecoder
  implements BitmapDecoder
{
  DeviceMsgThumbDownloader$DeviceVideoBitmapDecoder(DeviceMsgThumbDownloader paramDeviceMsgThumbDownloader) {}
  
  public Bitmap getBitmap(URL paramURL)
  {
    paramURL = this.this$0.parseUrl(paramURL);
    if (paramURL == null) {
      paramURL = null;
    }
    for (;;)
    {
      return paramURL;
      String str = paramURL.path;
      if (TextUtils.isEmpty(str)) {
        return null;
      }
      try
      {
        Bitmap localBitmap = this.this$0.createVideoThumbnail(str);
        paramURL = localBitmap;
        if (localBitmap == null)
        {
          paramURL = this.this$0.queryVideoThumbnail(str);
          return paramURL;
        }
      }
      catch (Throwable paramURL)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VIdeoThumbDownloader", 2, "getBitmap", paramURL);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.DeviceMsgThumbDownloader.DeviceVideoBitmapDecoder
 * JD-Core Version:    0.7.0.1
 */