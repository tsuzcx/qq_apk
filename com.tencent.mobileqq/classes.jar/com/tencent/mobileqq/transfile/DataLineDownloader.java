package com.tencent.mobileqq.transfile;

import aipc;
import aipd;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class DataLineDownloader
  extends AbsDownloader
  implements ProtocolDownloaderConstants
{
  protected BaseApplicationImpl a;
  
  public DataLineDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.a = paramBaseApplicationImpl;
  }
  
  private Bitmap a(aipc paramaipc)
  {
    int j = 0;
    Object localObject2;
    if (paramaipc == null) {
      localObject2 = null;
    }
    for (;;)
    {
      return localObject2;
      int i = paramaipc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbWidth;
      int k = paramaipc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbHeight;
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        localOptions.inDensity = 160;
        localOptions.inTargetDensity = 160;
        localOptions.inScreenDensity = 160;
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramaipc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path, localOptions);
        localOptions.inJustDecodeBounds = false;
        localOptions.inSampleSize = a(localOptions, i, k);
        Object localObject1 = FilePicURLDrawlableHelper.a(paramaipc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path, localOptions);
        k = AIOUtils.a(135.0F, BaseApplicationImpl.getContext().getResources());
        if (localOptions.outHeight > localOptions.outWidth * 2.0F)
        {
          i = (int)((localOptions.outHeight - localOptions.outWidth * 2.0F) / 2.0F);
          localOptions.outHeight = ((int)(localOptions.outWidth * 2.0F));
        }
        for (;;)
        {
          localObject2 = Bitmap.createBitmap((Bitmap)localObject1, j, i, localOptions.outWidth, localOptions.outHeight);
          if (localOptions.outWidth <= k)
          {
            localObject1 = localObject2;
            if (localOptions.outHeight <= k) {}
          }
          else
          {
            localObject1 = ImageUtil.a((Bitmap)localObject2, k);
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            break;
          }
          return new ExifBitmapCreator(paramaipc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path).a((Bitmap)localObject1);
          if (localOptions.outWidth <= localOptions.outHeight * 2.0F) {
            break label361;
          }
          j = (int)((localOptions.outWidth - localOptions.outHeight * 2.0F) / 2.0F);
          localOptions.outWidth = ((int)(localOptions.outHeight * 2.0F));
          i = 0;
        }
      }
      catch (Exception paramaipc)
      {
        if (QLog.isColorLevel()) {
          QLog.d("_dataline_file", 2, "make Thumb ", paramaipc);
        }
        return null;
      }
      catch (OutOfMemoryError paramaipc)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("_dataline_file", 2, "make Thumb OOM ", paramaipc);
            continue;
            label361:
            i = 0;
          }
        }
      }
    }
  }
  
  public int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt1 == -1) || (paramInt2 == -1)) {
      if (paramOptions.outWidth * paramOptions.outHeight > 5000000)
      {
        if (QLog.isColorLevel()) {
          QLog.d("_dataline_file", 2, "calculateInSampleSize options.outWidth*options.outHeight=" + paramOptions.outWidth * paramOptions.outHeight);
        }
        j = 2;
      }
    }
    int k;
    int m;
    label95:
    do
    {
      do
      {
        return j;
        k = paramOptions.outHeight;
        m = paramOptions.outWidth;
        j = i;
      } while (k <= paramInt2);
      j = i;
    } while (m <= paramInt1);
    int n = Math.round(k / paramInt2);
    j = Math.round(m / paramInt1);
    if (n < j) {}
    for (;;)
    {
      j = i;
      if (n < 2) {
        break;
      }
      m /= 2;
      k /= 2;
      i *= 2;
      break label95;
      n = j;
    }
  }
  
  public aipc a(URL paramURL)
  {
    try
    {
      aipc localaipc = new aipc(this);
      paramURL = paramURL.getFile().split("\\|");
      localaipc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
      localaipc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = paramURL[0];
      localaipc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbWidth = Integer.parseInt(paramURL[1]);
      localaipc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbHeight = Integer.parseInt(paramURL[2]);
      localaipc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.modifiedDate = Long.parseLong(paramURL[3]);
      localaipc.jdField_a_of_type_Boolean = Boolean.parseBoolean(paramURL[4]);
      return localaipc;
    }
    catch (Exception paramURL) {}
    return null;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = a(paramDownloadParams.url);
    if (paramOutputStream != null) {
      return new File(paramOutputStream.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path);
    }
    return new File(AppConstants.aI);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramFile = AlbumThumbManager.a(BaseApplicationImpl.getContext());
    paramURLDrawableHandler = new aipd(this);
    paramFile = paramFile.a(paramDownloadParams.url, paramURLDrawableHandler);
    if (paramFile == null) {
      return null;
    }
    paramDownloadParams = a(paramDownloadParams.url);
    if ((paramDownloadParams != null) && (paramDownloadParams.jdField_a_of_type_Boolean))
    {
      paramDownloadParams = ImageUtil.a(paramFile, AIOUtils.a(12.0F, BaseApplicationImpl.getContext().getResources()));
      paramFile.recycle();
      return paramDownloadParams;
    }
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.DataLineDownloader
 * JD-Core Version:    0.7.0.1
 */