package com.tencent.mobileqq.transfile;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Thumbnails;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.OutputStream;

public class VideoThumbDownloader
  extends AbsDownloader
{
  private static final String FILE_URL_PREFIX = "file://";
  private static final String[] PROJECTION_VIDEO = { "DISTINCT _id", "_data" };
  private static final int THUMBNAIL_KIND = 1;
  
  @SuppressLint({"NewApi"})
  private Bitmap createVideoThumbnail(String paramString)
  {
    if (Build.VERSION.SDK_INT < 8) {
      return null;
    }
    return ThumbnailUtils.createVideoThumbnail(paramString, 1);
  }
  
  private Bitmap queryVideoThumbnail(String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = null;
    if (i < 5) {
      return null;
    }
    try
    {
      localCursor = queryVideoCursor(paramString);
      paramString = localObject;
      if (localCursor != null)
      {
        paramString = localObject;
        try
        {
          if (localCursor.getCount() > 0)
          {
            long l = localCursor.getLong(localCursor.getColumnIndexOrThrow("_id"));
            paramString = localObject;
            if (localCursor.moveToFirst()) {
              paramString = MediaStore.Video.Thumbnails.getThumbnail(BaseApplicationImpl.getContext().getContentResolver(), l, 1, null);
            }
          }
        }
        finally
        {
          break label110;
        }
      }
      if (localCursor != null) {
        localCursor.close();
      }
      return paramString;
    }
    finally
    {
      Cursor localCursor = null;
      label110:
      if (localCursor != null) {
        localCursor.close();
      }
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return AlbumThumbManager.getInstance(BaseApplicationImpl.getContext()).getThumb(paramDownloadParams.url, new VideoThumbDownloader.VideoBitmapCreator(this));
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(AppConstants.SDCARD_ROOT);
  }
  
  public Cursor queryVideoCursor(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_data='");
    localStringBuilder.append(DeviceMsgThumbDownloader.processPath(paramString));
    localStringBuilder.append("' COLLATE NOCASE");
    paramString = localStringBuilder.toString();
    return BaseApplicationImpl.getContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PROJECTION_VIDEO, paramString, null, null);
  }
  
  public boolean useDiskCache()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VideoThumbDownloader
 * JD-Core Version:    0.7.0.1
 */