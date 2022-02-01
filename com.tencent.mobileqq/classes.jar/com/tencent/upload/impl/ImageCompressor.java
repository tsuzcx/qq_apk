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
      paramString2 = new StringBuilder();
      paramString2.append("abortTask flowId:");
      paramString2.append(paramAbstractUploadTask.flowId);
      UploadLog.v("ImageProcessor", paramString2.toString());
    }
    UploadLog.w("ImageProcessor", paramString1);
  }
  
  public static final boolean copyTaskFile(AbstractUploadTask paramAbstractUploadTask)
  {
    String str = FileUtils.getTempFilePath(UploadGlobalConfig.getContext(), paramAbstractUploadTask.getFilePath(), paramAbstractUploadTask.md5, paramAbstractUploadTask.flowId);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    boolean bool = FileUtils.copyFile(paramAbstractUploadTask.getFilePath(), str);
    if (bool) {
      paramAbstractUploadTask.setTmpFilePath(str);
    }
    return bool;
  }
  
  public static String getTaskTempFile(AbstractUploadTask paramAbstractUploadTask, Context paramContext)
  {
    return FileUtils.getTempFilePath(paramContext, paramAbstractUploadTask.uploadFilePath, paramAbstractUploadTask.md5, paramAbstractUploadTask.flowId);
  }
  
  public static IUploadConfig.UploadImageSize getUploadImageSize(AbstractUploadTask paramAbstractUploadTask, int paramInt)
  {
    paramAbstractUploadTask = paramAbstractUploadTask.getFilePath();
    if (!new File(paramAbstractUploadTask).exists()) {
      return null;
    }
    Object localObject1 = ImageProcessUtil.decodeBitmapOptions(paramAbstractUploadTask);
    boolean bool = "image/jpeg".equalsIgnoreCase(((BitmapFactory.Options)localObject1).outMimeType);
    if ((((BitmapFactory.Options)localObject1).outWidth == 0) && (((BitmapFactory.Options)localObject1).outHeight == 0))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getUploadImageSize size illegal. path=");
      ((StringBuilder)localObject1).append(paramAbstractUploadTask);
      UploadLog.e("ImageProcessor", ((StringBuilder)localObject1).toString());
      return null;
    }
    if (bool) {
      i = UploadConfiguration.getPictureQuality(paramAbstractUploadTask);
    } else {
      i = 100;
    }
    int j = i;
    if (i <= 0) {
      j = 100;
    }
    Object localObject2 = UploadGlobalConfig.getConfig();
    localObject1 = new IUploadConfig.UploadImageSize(((BitmapFactory.Options)localObject1).outWidth, ((BitmapFactory.Options)localObject1).outHeight, 100);
    int i = 0;
    paramAbstractUploadTask = ((IUploadConfig)localObject2).getUploadImageSize((IUploadConfig.UploadImageSize)localObject1, paramInt, new ImageUploadTask(false, paramAbstractUploadTask));
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getUploadImageSize size=");
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append(" targetSize=");
    ((StringBuilder)localObject2).append(paramAbstractUploadTask);
    ((StringBuilder)localObject2).append(" q:");
    ((StringBuilder)localObject2).append(j);
    ((StringBuilder)localObject2).append(" jpg:");
    ((StringBuilder)localObject2).append(bool);
    UploadLog.d("ImageProcessor", ((StringBuilder)localObject2).toString());
    if ((paramAbstractUploadTask != null) && (paramAbstractUploadTask.height > 0) && (paramAbstractUploadTask.width > 0))
    {
      paramInt = i;
      if (paramAbstractUploadTask.quality > 0) {}
    }
    else
    {
      paramInt = 1;
    }
    if (paramInt == 0)
    {
      if ((((IUploadConfig.UploadImageSize)localObject1).width <= paramAbstractUploadTask.width) && (((IUploadConfig.UploadImageSize)localObject1).height <= paramAbstractUploadTask.height) && (j <= paramAbstractUploadTask.quality)) {
        return localObject1;
      }
      if (j < paramAbstractUploadTask.quality) {
        paramAbstractUploadTask.quality = j;
      }
      return paramAbstractUploadTask;
    }
    return localObject1;
  }
  
  public static boolean isGifPicture(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!new File(paramString).exists()) {
      return false;
    }
    return "image/gif".equalsIgnoreCase(ImageProcessUtil.decodeBitmapOptions(paramString).outMimeType);
  }
  
  public static final void processGif(AbstractUploadTask paramAbstractUploadTask)
  {
    int i = UploadConfiguration.getCurrentNetworkCategory();
    long l = new File(paramAbstractUploadTask.getFilePath()).length();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("processGif, networkType:");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(" length:");
    ((StringBuilder)localObject1).append(l);
    ((StringBuilder)localObject1).append(" flowId:");
    ((StringBuilder)localObject1).append(paramAbstractUploadTask.flowId);
    UploadLog.i("ImageProcessor", ((StringBuilder)localObject1).toString());
    if (l < UploadConfiguration.getGifUploadLimit(i))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("processGif() 满足上传原图条件 flowId=");
      ((StringBuilder)localObject1).append(paramAbstractUploadTask.flowId);
      UploadLog.v("ImageProcessor", ((StringBuilder)localObject1).toString());
      if (copyTaskFile(paramAbstractUploadTask)) {
        i = 2;
      } else {
        i = 1;
      }
    }
    else
    {
      localObject1 = BitmapUtils.getOptions();
      localObject1 = ImageProcessUtil.decodeFileWithRetry(paramAbstractUploadTask.getFilePath(), (BitmapFactory.Options)localObject1);
      Object localObject2 = FileUtils.getTempFilePath(UploadGlobalConfig.getContext(), paramAbstractUploadTask.getFilePath(), paramAbstractUploadTask.md5, paramAbstractUploadTask.flowId);
      if ((localObject1 != null) && (localObject2 != null) && (ImageProcessUtil.bitmapToFile((Bitmap)localObject1, (String)localObject2, 80, false, false, null)))
      {
        paramAbstractUploadTask.uploadFilePath = ((String)localObject2);
        ((Bitmap)localObject1).recycle();
        localObject1 = null;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("processGif() 取第一帧上传 flowId=");
        ((StringBuilder)localObject2).append(paramAbstractUploadTask.flowId);
        UploadLog.v("ImageProcessor", ((StringBuilder)localObject2).toString());
        i = 3;
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("processGif() 上传原图 flowId=");
        ((StringBuilder)localObject2).append(paramAbstractUploadTask.flowId);
        UploadLog.v("ImageProcessor", ((StringBuilder)localObject2).toString());
        if (copyTaskFile(paramAbstractUploadTask)) {
          i = 5;
        } else {
          i = 4;
        }
      }
      if (localObject1 != null) {
        ((Bitmap)localObject1).recycle();
      }
    }
    if ((i != 2) && (i != 3) && (i != 5)) {
      i = 0;
    } else {
      i = 1;
    }
    paramAbstractUploadTask.keepTmpFile(i ^ 0x1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.impl.ImageCompressor
 * JD-Core Version:    0.7.0.1
 */