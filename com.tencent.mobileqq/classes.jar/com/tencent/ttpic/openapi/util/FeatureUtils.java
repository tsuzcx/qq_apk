package com.tencent.ttpic.openapi.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal;

public class FeatureUtils
{
  public static final String ASSETS_PATH = "assets://";
  
  public static Bitmap getEncryptedBitmap(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = getEncryptedBitmapInDefaultPath(paramString2, paramString3);
    }
    Bitmap localBitmap;
    do
    {
      return paramString1;
      if (!paramString1.startsWith("assets://")) {
        return null;
      }
      localBitmap = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(FileUtils.genSeperateFileDir(paramString1) + paramString3);
      paramString1 = localBitmap;
    } while (localBitmap != null);
    return getEncryptedBitmapInDefaultPath(paramString2, paramString3);
  }
  
  public static Bitmap getEncryptedBitmapInDefaultPath(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    return TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(FileUtils.genSeperateFileDir(paramString1) + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.FeatureUtils
 * JD-Core Version:    0.7.0.1
 */