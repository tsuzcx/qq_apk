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
      return getEncryptedBitmapInDefaultPath(paramString2, paramString3);
    }
    if (!paramString1.startsWith("assets://")) {
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FileUtils.genSeperateFileDir(paramString1));
    ((StringBuilder)localObject).append(paramString3);
    localObject = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(((StringBuilder)localObject).toString());
    paramString1 = (String)localObject;
    if (localObject == null) {
      paramString1 = getEncryptedBitmapInDefaultPath(paramString2, paramString3);
    }
    return paramString1;
  }
  
  public static Bitmap getEncryptedBitmapInDefaultPath(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FileUtils.genSeperateFileDir(paramString1));
    localStringBuilder.append(paramString2);
    return TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.FeatureUtils
 * JD-Core Version:    0.7.0.1
 */