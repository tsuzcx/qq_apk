package com.tencent.mobileqq.transfile;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Thumbnails;
import android.text.TextUtils;
import aszt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DeviceMsgThumbDownloader
  extends AbsDownloader
{
  private static final String FILE_URL_PREFIX = "file://";
  private static final String[] PROJECTION_VIDEO = { "DISTINCT _id", "_data" };
  public static final String PROTOCOL_DEVICE_MSG_THUMB = "devicemsgthumb";
  private static final String TAG = "DeviceMsgThumbDownloader";
  private static final int THUMBNAIL_KIND = 1;
  
  public static URL getUrl(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    try
    {
      paramString1 = new URL("devicemsgthumb", "", localStringBuilder.toString());
      return paramString1;
    }
    catch (MalformedURLException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceMsgThumbDownloader", 2, paramString1.getMessage(), paramString1);
      }
    }
    return null;
  }
  
  public static String processPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.startsWith("file://")) {
        str = paramString.substring("file://".length());
      }
      paramString = str;
    } while (str.startsWith(File.separator));
    return File.separator + str;
  }
  
  @SuppressLint({"NewApi"})
  public Bitmap createVideoThumbnail(String paramString)
  {
    if (Build.VERSION.SDK_INT < 8) {
      return null;
    }
    return ThumbnailUtils.createVideoThumbnail(paramString, 1);
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramFile = parseUrl(paramDownloadParams.url);
    if (paramFile == null) {}
    do
    {
      return null;
      if (FileUtils.fileExistsAndNotEmpty(paramFile.path)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DeviceMsgThumbDownloader", 2, "decodeFile file not exits. just return");
    return null;
    paramURLDrawableHandler = BaseApplicationImpl.getContext();
    if (aszt.a(paramFile.path) == 2) {}
    for (paramFile = new DeviceMsgThumbDownloader.DeviceVideoBitmapDecoder(this);; paramFile = new DeviceMsgThumbDownloader.DeviceImgBitmapDecoder(this)) {
      return AlbumThumbManager.getInstance(paramURLDrawableHandler).getThumb(paramDownloadParams.url, paramFile);
    }
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(AppConstants.SDCARD_ROOT);
  }
  
  public LocalMediaInfo parseUrl(URL paramURL)
  {
    try
    {
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      paramURL = paramURL.getFile().split("\\|");
      localLocalMediaInfo.path = paramURL[0];
      localLocalMediaInfo.thumbWidth = Integer.parseInt(paramURL[1]);
      localLocalMediaInfo.thumbHeight = Integer.parseInt(paramURL[2]);
      return localLocalMediaInfo;
    }
    catch (Exception paramURL) {}
    return null;
  }
  
  public Cursor queryVideoCursor(String paramString)
  {
    paramString = "_data='" + processPath(paramString) + "' COLLATE NOCASE";
    return BaseApplicationImpl.getContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PROJECTION_VIDEO, paramString, null, null);
  }
  
  public Bitmap queryVideoThumbnail(String paramString)
  {
    Object localObject = null;
    Cursor localCursor = null;
    if (Build.VERSION.SDK_INT < 5)
    {
      localObject = localCursor;
      label17:
      return localObject;
    }
    try
    {
      localCursor = queryVideoCursor(paramString);
      paramString = (String)localObject;
      if (localCursor != null) {
        paramString = (String)localObject;
      }
    }
    finally
    {
      try
      {
        if (localCursor.getCount() > 0)
        {
          long l = localCursor.getLong(localCursor.getColumnIndexOrThrow("_id"));
          paramString = (String)localObject;
          if (localCursor.moveToFirst()) {
            paramString = MediaStore.Video.Thumbnails.getThumbnail(BaseApplicationImpl.getContext().getContentResolver(), l, 1, null);
          }
        }
        localObject = paramString;
        if (localCursor == null) {
          break label17;
        }
        localCursor.close();
        return paramString;
      }
      finally
      {
        break label112;
      }
      paramString = finally;
      localCursor = null;
    }
    label112:
    if (localCursor != null) {
      localCursor.close();
    }
    throw paramString;
  }
  
  public boolean useDiskCache()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.DeviceMsgThumbDownloader
 * JD-Core Version:    0.7.0.1
 */