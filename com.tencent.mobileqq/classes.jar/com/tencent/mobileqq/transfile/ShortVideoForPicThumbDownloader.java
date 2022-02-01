package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class ShortVideoForPicThumbDownloader
  extends AbsDownloader
{
  public static final String PROTOCOL_SHORT_VIDEO_FOR_PIC_THUMB = "shortvideoforpicthumb";
  private static final String TAG = "ShortVideoForPicThumbDownloader";
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = 160;
    localOptions.inTargetDensity = 160;
    localOptions.inScreenDensity = 160;
    localOptions.inJustDecodeBounds = false;
    String str = paramFile.getAbsolutePath();
    if (!FileUtils.fileExistsAndNotEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForPicThumbDownloader", 2, "decodeFile file not exits. just return");
      }
      return null;
    }
    paramURLDrawableHandler = SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
    SafeBitmapFactory.decodeFile(str, localOptions);
    paramDownloadParams = ShortVideoUtils.resizeAndClipBitmap(paramURLDrawableHandler, paramDownloadParams, CommonImgThumbHelper.getThumbWidthHeightDP(false), false);
    if (!paramURLDrawableHandler.equals(paramDownloadParams.mBitmap)) {
      paramURLDrawableHandler.recycle();
    }
    paramFile = new RoundRectBitmap(((IPicUtil)QRoute.api(IPicUtil.class)).getExifBitmap(paramFile.getAbsolutePath(), paramDownloadParams.mBitmap), paramDownloadParams.mCornerRadius, paramDownloadParams.mBoardColor, paramDownloadParams.mBorderWidth);
    paramFile.mDisplayWidth = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    paramFile.mDisplayHeight = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().heightPixels;
    return paramFile;
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(paramDownloadParams.url.getFile());
  }
  
  public boolean useDiskCache()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoForPicThumbDownloader
 * JD-Core Version:    0.7.0.1
 */