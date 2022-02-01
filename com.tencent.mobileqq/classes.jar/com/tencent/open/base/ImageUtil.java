package com.tencent.open.base;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.open.base.img.ImageCache;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class ImageUtil
{
  public static Bitmap a(String paramString)
  {
    String str = a(paramString, 100);
    Object localObject = ImageCache.a("app", str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("100_url:");
    localStringBuilder.append(str);
    localStringBuilder.append(" icon_path=");
    localStringBuilder.append((String)localObject);
    LogUtility.b("ImageUtil", localStringBuilder.toString());
    if (new File((String)localObject).exists()) {
      return BitmapUtil.a((String)localObject, 72, 72, false);
    }
    paramString = a(paramString, 75);
    str = ImageCache.a("app", paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("75_url:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" icon_path=");
    ((StringBuilder)localObject).append(str);
    LogUtility.b("ImageUtil", ((StringBuilder)localObject).toString());
    if (new File(str).exists()) {
      return BitmapUtil.a(str, 72, 72, false);
    }
    return null;
  }
  
  @TargetApi(8)
  public static String a(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT <= 7) {
      return "";
    }
    paramDrawable = b(paramDrawable);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramDrawable.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 0);
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("00000000");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    localObject = ((String)localObject).substring(((String)localObject).length() - 8);
    paramString = String.format("https://i.gtimg.cn/open/app_icon/%s/%s/%s/%s/%s_%d_m.png", new Object[] { ((String)localObject).substring(0, 2), ((String)localObject).substring(2, 4), ((String)localObject).substring(4, 6), ((String)localObject).substring(6, 8), paramString, Integer.valueOf(paramInt) });
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(">>iconUrl=");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.b("opensdk", ((StringBuilder)localObject).toString());
    return paramString;
  }
  
  public static Bitmap b(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {
      localObject = Bitmap.Config.ARGB_8888;
    } else {
      localObject = Bitmap.Config.RGB_565;
    }
    Object localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    paramDrawable.draw(localCanvas);
    return localObject;
  }
  
  public static Bitmap c(Drawable paramDrawable)
  {
    return b(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.ImageUtil
 * JD-Core Version:    0.7.0.1
 */