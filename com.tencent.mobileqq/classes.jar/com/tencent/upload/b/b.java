package com.tencent.upload.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.image.ImageProcessUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import java.io.File;

public class b
{
  public static IUploadConfig.UploadImageSize a(AbstractUploadTask paramAbstractUploadTask, int paramInt)
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
      com.tencent.upload.common.b.e("ImageProcessor", "getUploadImageSize size illegal. path=" + paramAbstractUploadTask);
      return null;
    }
    if (bool) {}
    for (int i = UploadConfiguration.getPictureQuality(paramAbstractUploadTask);; i = 100)
    {
      int j = i;
      if (i <= 0) {
        j = 100;
      }
      IUploadConfig localIUploadConfig = com.tencent.upload.common.a.b();
      localObject = new IUploadConfig.UploadImageSize(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight, 100);
      paramAbstractUploadTask = localIUploadConfig.getUploadImageSize((IUploadConfig.UploadImageSize)localObject, paramInt, new ImageUploadTask(false, paramAbstractUploadTask));
      com.tencent.upload.common.b.b("ImageProcessor", "getUploadImageSize size=" + localObject + " targetSize=" + paramAbstractUploadTask + " q:" + j + " jpg:" + bool);
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
  
  public static final void a(AbstractUploadTask paramAbstractUploadTask)
  {
    boolean bool = true;
    int i = UploadConfiguration.getCurrentNetworkCategory();
    long l = new File(paramAbstractUploadTask.getFilePath()).length();
    com.tencent.upload.common.b.c("ImageProcessor", "processGif, networkType:" + i + " length:" + l + " flowId:" + paramAbstractUploadTask.flowId);
    if (l < UploadConfiguration.getGifUploadLimit(i))
    {
      com.tencent.upload.common.b.a("ImageProcessor", "processGif() 满足上传原图条件 flowId=" + paramAbstractUploadTask.flowId);
      if (b(paramAbstractUploadTask))
      {
        i = 2;
        if ((i != 2) && (i != 3) && (i != 5)) {
          break label314;
        }
        i = 1;
        label132:
        if (i != 0) {
          break label319;
        }
      }
    }
    for (;;)
    {
      paramAbstractUploadTask.keepTmpFile(bool);
      return;
      i = 1;
      break;
      Object localObject = com.tencent.upload.e.a.a();
      localObject = ImageProcessUtil.decodeFileWithRetry(paramAbstractUploadTask.getFilePath(), (BitmapFactory.Options)localObject);
      String str = FileUtils.getTempFilePath(com.tencent.upload.common.a.a(), paramAbstractUploadTask.getFilePath(), paramAbstractUploadTask.md5, paramAbstractUploadTask.flowId);
      int j;
      if ((localObject != null) && (str != null) && (ImageProcessUtil.bitmapToFile((Bitmap)localObject, str, 80, false, false, null)))
      {
        paramAbstractUploadTask.uploadFilePath = str;
        ((Bitmap)localObject).recycle();
        com.tencent.upload.common.b.a("ImageProcessor", "processGif() 取第一帧上传 flowId=" + paramAbstractUploadTask.flowId);
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
      com.tencent.upload.common.b.a("ImageProcessor", "processGif() 上传原图 flowId=" + paramAbstractUploadTask.flowId);
      if (b(paramAbstractUploadTask)) {}
      for (i = 5;; i = 4)
      {
        j = i;
        break;
      }
      label314:
      i = 0;
      break label132;
      label319:
      bool = false;
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!new File(paramString).exists()) {
      return false;
    }
    return "image/gif".equalsIgnoreCase(ImageProcessUtil.decodeBitmapOptions(paramString).outMimeType);
  }
  
  public static final boolean b(AbstractUploadTask paramAbstractUploadTask)
  {
    String str = FileUtils.getTempFilePath(com.tencent.upload.common.a.a(), paramAbstractUploadTask.getFilePath(), paramAbstractUploadTask.md5, paramAbstractUploadTask.flowId);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.b.b
 * JD-Core Version:    0.7.0.1
 */