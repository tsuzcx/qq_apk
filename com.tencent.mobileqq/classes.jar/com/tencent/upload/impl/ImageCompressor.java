package com.tencent.upload.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.image.ImageProcessUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import com.tencent.upload.utils.BitmapUtils;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import java.io.File;

public class ImageCompressor
{
  public static final int GIF_COPY_SATISFY = 2;
  public static final int GIF_COPY_UNSATISFY = 5;
  public static final int GIF_ONESHOT_COPY = 3;
  public static final int GIF_ORIGINAL_SATISFY = 1;
  public static final int GIF_ORIGINAL_UNSATISFY = 4;
  private static final String TAG = "ImageProcessor";
  
  private static final void abortTask(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramAbstractUploadTask.uploadTaskCallback != null)
    {
      paramAbstractUploadTask.uploadTaskCallback.onUploadError(paramAbstractUploadTask, paramInt, paramString2);
      paramAbstractUploadTask.uploadTaskCallback.onUploadStateChange(paramAbstractUploadTask, 5);
      UploadLog.v("ImageProcessor", "abortTask flowId:" + paramAbstractUploadTask.flowId);
    }
    UploadLog.w("ImageProcessor", paramString1);
  }
  
  public static final boolean copyTaskFile(AbstractUploadTask paramAbstractUploadTask)
  {
    String str = FileUtils.getTempFilePath(UploadGlobalConfig.getContext(), paramAbstractUploadTask.getFilePath(), paramAbstractUploadTask.md5, paramAbstractUploadTask.flowId);
    boolean bool1;
    if (TextUtils.isEmpty(str)) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = FileUtils.copyFile(paramAbstractUploadTask.getFilePath(), str);
      bool1 = bool2;
    } while (!bool2);
    paramAbstractUploadTask.setTmpFilePath(str);
    return bool2;
  }
  
  public static String getTaskTempFile(AbstractUploadTask paramAbstractUploadTask, Context paramContext)
  {
    return FileUtils.getTempFilePath(paramContext, paramAbstractUploadTask.uploadFilePath, paramAbstractUploadTask.md5, paramAbstractUploadTask.flowId);
  }
  
  public static IUploadConfig.UploadImageSize getUploadImageSize(AbstractUploadTask paramAbstractUploadTask, int paramInt)
  {
    int k = 0;
    paramAbstractUploadTask = paramAbstractUploadTask.getFilePath();
    if (!new File(paramAbstractUploadTask).exists()) {
      return null;
    }
    Object localObject = ImageProcessUtil.decodeBitmapOptions(paramAbstractUploadTask);
    boolean bool = "image/jpeg".equalsIgnoreCase(((BitmapFactory.Options)localObject).outMimeType);
    if ((((BitmapFactory.Options)localObject).outWidth == 0) && (((BitmapFactory.Options)localObject).outHeight == 0))
    {
      UploadLog.e("ImageProcessor", "getUploadImageSize size illegal. path=" + paramAbstractUploadTask);
      return null;
    }
    if (bool) {}
    for (int i = UploadConfiguration.getPictureQuality(paramAbstractUploadTask);; i = 100)
    {
      int j = i;
      if (i <= 0) {
        j = 100;
      }
      IUploadConfig localIUploadConfig = UploadGlobalConfig.getConfig();
      localObject = new IUploadConfig.UploadImageSize(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight, 100);
      paramAbstractUploadTask = localIUploadConfig.getUploadImageSize((IUploadConfig.UploadImageSize)localObject, paramInt, new ImageUploadTask(false, paramAbstractUploadTask));
      UploadLog.d("ImageProcessor", "getUploadImageSize size=" + localObject + " targetSize=" + paramAbstractUploadTask + " q:" + j + " jpg:" + bool);
      if ((paramAbstractUploadTask != null) && (paramAbstractUploadTask.height > 0) && (paramAbstractUploadTask.width > 0))
      {
        paramInt = k;
        if (paramAbstractUploadTask.quality > 0) {}
      }
      else
      {
        paramInt = 1;
      }
      if ((paramInt != 0) || ((((IUploadConfig.UploadImageSize)localObject).width <= paramAbstractUploadTask.width) && (((IUploadConfig.UploadImageSize)localObject).height <= paramAbstractUploadTask.height) && (j <= paramAbstractUploadTask.quality))) {
        return localObject;
      }
      if (j < paramAbstractUploadTask.quality) {
        paramAbstractUploadTask.quality = j;
      }
      return paramAbstractUploadTask;
    }
  }
  
  public static boolean isGifPicture(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!new File(paramString).exists()) {
      return false;
    }
    return "image/gif".equalsIgnoreCase(ImageProcessUtil.decodeBitmapOptions(paramString).outMimeType);
  }
  
  public static final void processGif(AbstractUploadTask paramAbstractUploadTask)
  {
    boolean bool = true;
    int i = UploadConfiguration.getCurrentNetworkCategory();
    long l = new File(paramAbstractUploadTask.getFilePath()).length();
    UploadLog.i("ImageProcessor", "processGif, networkType:" + i + " length:" + l + " flowId:" + paramAbstractUploadTask.flowId);
    if (l < UploadConfiguration.getGifUploadLimit(i))
    {
      UploadLog.v("ImageProcessor", "processGif() 满足上传原图条件 flowId=" + paramAbstractUploadTask.flowId);
      if (copyTaskFile(paramAbstractUploadTask))
      {
        i = 2;
        if ((i != 2) && (i != 3) && (i != 5)) {
          break label316;
        }
        i = 1;
        label132:
        if (i != 0) {
          break label321;
        }
      }
    }
    for (;;)
    {
      paramAbstractUploadTask.keepTmpFile(bool);
      return;
      i = 1;
      break;
      Object localObject = BitmapUtils.getOptions();
      localObject = ImageProcessUtil.decodeFileWithRetry(paramAbstractUploadTask.getFilePath(), (BitmapFactory.Options)localObject);
      String str = FileUtils.getTempFilePath(UploadGlobalConfig.getContext(), paramAbstractUploadTask.getFilePath(), paramAbstractUploadTask.md5, paramAbstractUploadTask.flowId);
      int j;
      if ((localObject != null) && (str != null) && (ImageProcessUtil.bitmapToFile((Bitmap)localObject, str, 80, false, false, null)))
      {
        paramAbstractUploadTask.uploadFilePath = str;
        ((Bitmap)localObject).recycle();
        UploadLog.v("ImageProcessor", "processGif() 取第一帧上传 flowId=" + paramAbstractUploadTask.flowId);
        localObject = null;
        j = 3;
        i = j;
        if (localObject == null) {
          break;
        }
        ((Bitmap)localObject).recycle();
        i = j;
        break;
      }
      UploadLog.v("ImageProcessor", "processGif() 上传原图 flowId=" + paramAbstractUploadTask.flowId);
      if (copyTaskFile(paramAbstractUploadTask)) {}
      for (i = 5;; i = 4)
      {
        j = i;
        break;
      }
      label316:
      i = 0;
      break label132;
      label321:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.upload.impl.ImageCompressor
 * JD-Core Version:    0.7.0.1
 */