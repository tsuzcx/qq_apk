package cooperation.qzone.util;

import anaq;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.component.network.utils.Base64;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin;
import cooperation.qzone.webviewplugin.QzoneOfflinePluginJsForQQ;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

public class GifCoder
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int = gifCoderWnsConfig.b();
  private long jdField_a_of_type_Long;
  private GifCoder.EncodingType jdField_a_of_type_CooperationQzoneUtilGifCoder$EncodingType = GifCoder.EncodingType.ENCODING_TYPE_SIMPLE_FAST;
  private final int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int = 1;
  private boolean jdField_c_of_type_Boolean;
  private final int jdField_d_of_type_Int = 2;
  private boolean jdField_d_of_type_Boolean = true;
  private int e = 0;
  
  static {}
  
  static int a(Bitmap.Config paramConfig)
  {
    int j = 2;
    int i;
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      i = 4;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramConfig == Bitmap.Config.RGB_565);
      i = j;
    } while (paramConfig == Bitmap.Config.ARGB_4444);
    if (paramConfig == Bitmap.Config.ALPHA_8) {
      return 1;
    }
    return 1;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap;
    if (paramBitmap == null) {
      localBitmap = null;
    }
    int i;
    int j;
    do
    {
      return localBitmap;
      i = paramBitmap.getWidth();
      j = paramBitmap.getHeight();
      if (i <= j)
      {
        if ((this.e == 1) || (this.e == 0))
        {
          this.e = 1;
          return paramBitmap;
        }
        return null;
      }
      localBitmap = paramBitmap;
    } while (i <= j);
    if ((this.e == 2) || (this.e == 0))
    {
      this.e = 2;
      return paramBitmap;
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, double paramDouble1, double paramDouble2, int paramInt, boolean paramBoolean)
  {
    Bitmap localBitmap;
    if (paramBitmap == null)
    {
      QLog.i("GifCoder", 1, "need zoom bgimage is null");
      localBitmap = null;
      return localBitmap;
    }
    f3 = paramBitmap.getWidth();
    f4 = paramBitmap.getHeight();
    localMatrix = new Matrix();
    float f1 = (float)paramDouble1 / f3;
    float f2 = (float)paramDouble2 / f4;
    if (paramBoolean) {
      if (f1 > f2) {
        f1 = f2;
      }
    }
    while (f1 > f2) {
      for (;;)
      {
        localMatrix.postScale(f1, f1);
        localMatrix.postRotate(paramInt);
        paramInt = (int)f3;
        i = (int)f4;
        try
        {
          localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt, i, localMatrix, true);
          paramBitmap = localBitmap;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            System.gc();
            paramInt = (int)f3;
            i = (int)f4;
            try
            {
              paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt, i, localMatrix, true);
            }
            catch (Throwable paramBitmap)
            {
              QLog.i("GifCoder", 1, "zoomImage happen exception");
              paramBitmap = null;
              System.gc();
            }
          }
        }
        localBitmap = paramBitmap;
        if (!a(paramBitmap)) {
          break;
        }
        return a(paramBitmap, 100);
      }
    }
    for (;;)
    {
      f1 = f2;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    int i = 0;
    if (paramBitmap == null) {
      return null;
    }
    int[] arrayOfInt = new int[paramBitmap.getWidth() * paramBitmap.getHeight()];
    paramBitmap.getPixels(arrayOfInt, 0, paramBitmap.getWidth(), 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    int j = paramInt * 255 / 100;
    paramInt = i;
    while (paramInt < arrayOfInt.length)
    {
      i = arrayOfInt[paramInt];
      int k = arrayOfInt[paramInt];
      k = arrayOfInt[paramInt];
      int m = arrayOfInt[paramInt] >> 16 & 0xFF;
      if ((m == 0) && ((k >> 8 & 0xFF) == 0) && (m == 0) && ((i >> 24 & 0xFF) == 0))
      {
        arrayOfInt[paramInt] = 16777215;
        arrayOfInt[paramInt] = (j << 24 | arrayOfInt[paramInt] & 0xFFFFFF);
      }
      paramInt += 1;
    }
    return Bitmap.createBitmap(arrayOfInt, paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
  }
  
  private static Bitmap a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, Bitmap paramBitmap)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() <= 0)) {}
    while (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = Base64.a(paramString, 0);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
        localOptions.inJustDecodeBounds = false;
        if ((paramInt1 != 0) && (paramInt2 != 0)) {
          if (paramBoolean)
          {
            i = Math.max(localOptions.outWidth / paramInt1, localOptions.outHeight / paramInt2);
            break label223;
            localOptions.inSampleSize = j;
            localOptions.inMutable = true;
            if ((Build.VERSION.SDK_INT >= 11) && (a(paramBitmap, localOptions))) {
              localOptions.inBitmap = paramBitmap;
            }
            return BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
          }
          else
          {
            i = Math.min(localOptions.outWidth / paramInt1, localOptions.outHeight / paramInt2);
          }
        }
      }
      catch (IllegalArgumentException paramBitmap)
      {
        QLog.w("GifCoder", 1, "", paramBitmap);
        return a(paramString, paramInt1, paramInt2, paramBoolean, null);
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.e("GifCoder", 1, "", paramString);
        return null;
      }
      catch (Throwable paramString)
      {
        QLog.e("GifCoder", 1, "", paramString);
        return null;
      }
      int i = 1;
      label223:
      int j = i;
      if (i < 1) {
        j = 1;
      }
    }
  }
  
  private String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    int i;
    do
    {
      do
      {
        do
        {
          return str;
          str = paramString;
        } while (!paramString.startsWith("data:image"));
        i = paramString.indexOf("base64,");
        str = paramString;
      } while (i < 0);
      str = paramString;
    } while ("base64,".length() + i >= paramString.length());
    return paramString.substring("base64,".length() + i);
  }
  
  public static void a()
  {
    if (AlbumLibDownloaderUtil.a().a(AlbumLibDownloaderUtil.a, true))
    {
      a(AlbumLibDownloaderUtil.a().b(AlbumLibDownloaderUtil.a));
      return;
    }
    AlbumLibDownloaderUtil.a().a();
  }
  
  private static boolean a()
  {
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    AlbumLibDownloaderUtil.a().b(new anaq(arrayOfBoolean, localCountDownLatch));
    try
    {
      localCountDownLatch.await(30L, TimeUnit.SECONDS);
      return arrayOfBoolean[0];
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        arrayOfBoolean[0] = false;
      }
    }
  }
  
  public static boolean a(Bitmap paramBitmap)
  {
    boolean bool = true;
    if ((paramBitmap == null) || (paramBitmap.getWidth() <= 2) || (paramBitmap.getHeight() <= 2)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        int i = paramBitmap.getPixel(1, 1);
        int j = paramBitmap.getPixel(paramBitmap.getWidth() - 2, paramBitmap.getHeight() - 2);
        if ((i >> 24 != 0) || (j >> 24 != 0)) {
          return false;
        }
      }
      catch (Exception paramBitmap) {}
    }
    return true;
  }
  
  @TargetApi(19)
  static boolean a(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    boolean bool = true;
    if ((paramBitmap == null) || (!paramBitmap.isMutable()) || (paramBitmap.isRecycled())) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (Build.VERSION.SDK_INT < 19) {
          break;
        }
      } while (paramOptions.outWidth / paramOptions.inSampleSize * (paramOptions.outHeight / paramOptions.inSampleSize) * a(paramBitmap.getConfig()) <= paramBitmap.getAllocationByteCount());
      return false;
    } while ((paramBitmap.getWidth() == paramOptions.outWidth) && (paramBitmap.getHeight() == paramOptions.outHeight) && (paramOptions.inSampleSize == 1));
    return false;
  }
  
  private static boolean a(String paramString)
  {
    try
    {
      QLog.i("GifCoder", 1, "gif lib start load");
      System.load(paramString);
      QLog.i("GifCoder", 1, "gif lib load success");
      jdField_a_of_type_Boolean = true;
      boolean bool = jdField_a_of_type_Boolean;
      return bool;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        jdField_a_of_type_Boolean = false;
        QLog.i("GifCoder", 1, "gif lib load happen Exception");
      }
    }
    finally {}
  }
  
  private native boolean nativeEncodeFrame(long paramLong, Bitmap paramBitmap, int paramInt);
  
  private native void nativeEncoderClose(long paramLong);
  
  private native long nativeEncoderInit(int paramInt1, int paramInt2, String paramString, int paramInt3);
  
  private native void nativeEncoderSetDither(long paramLong, boolean paramBoolean);
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, GifCoder.EncodingType paramEncodingType)
  {
    if (!jdField_a_of_type_Boolean)
    {
      a();
      if (!jdField_a_of_type_Boolean) {
        return;
      }
    }
    if (0L != this.jdField_a_of_type_Long) {
      b();
    }
    QLog.i("GifCoder", 1, "start nativeEncoderInit");
    this.jdField_a_of_type_Long = nativeEncoderInit(paramInt1, paramInt2, paramString, paramEncodingType.ordinal());
    QLog.i("GifCoder", 1, "nativeEncoderInit success");
    if (0L == this.jdField_a_of_type_Long) {
      throw new FileNotFoundException();
    }
    QLog.i("GifCoder", 1, "start nativeEncoderSetDither");
    nativeEncoderSetDither(this.jdField_a_of_type_Long, this.jdField_d_of_type_Boolean);
    QLog.i("GifCoder", 1, "nativeEncoderSetDither success");
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(Bitmap paramBitmap, int paramInt)
  {
    if (!jdField_a_of_type_Boolean) {}
    while (0L == this.jdField_a_of_type_Long) {
      return false;
    }
    QLog.i("GifCoder", 1, "start encodeFrame");
    nativeEncodeFrame(this.jdField_a_of_type_Long, paramBitmap, paramInt);
    QLog.i("GifCoder", 1, "encodeFrame success");
    return true;
  }
  
  public boolean a(Bitmap paramBitmap, String paramString, int paramInt)
  {
    return a(paramBitmap, paramString, paramInt, false);
  }
  
  public boolean a(Bitmap paramBitmap, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return false;
    }
    if (!jdField_a_of_type_Boolean)
    {
      if (paramBoolean) {
        if (a()) {
          a();
        }
      }
      while (!jdField_a_of_type_Boolean)
      {
        QLog.w("GifCoder", 1, "gif lib loaded failed 1");
        return false;
        a();
      }
    }
    if (this.jdField_c_of_type_Boolean)
    {
      localBitmap = paramBitmap;
      if (!a(paramBitmap)) {}
    }
    for (Bitmap localBitmap = a(paramBitmap, 100);; localBitmap = a(paramBitmap, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, 0, this.jdField_b_of_type_Boolean))
    {
      if (this.jdField_a_of_type_Long == 0L) {}
      try
      {
        a(localBitmap.getWidth(), localBitmap.getHeight(), paramString, this.jdField_a_of_type_CooperationQzoneUtilGifCoder$EncodingType);
        QLog.i("GifCoder", 1, "encode gif ,frame time  = " + paramInt);
        return a(localBitmap, paramInt);
      }
      catch (Throwable paramBitmap)
      {
        paramBitmap.printStackTrace();
        paramBitmap = new File(paramString);
        if (!paramBitmap.exists()) {
          break;
        }
        paramBitmap.delete();
        QLog.i("GifCoder", 1, "initEncoder happen exception");
      }
    }
    return false;
  }
  
  public boolean a(String paramString, ArrayList paramArrayList, int paramInt)
  {
    return a(paramString, paramArrayList, paramInt, false);
  }
  
  public boolean a(String paramString, ArrayList paramArrayList, int paramInt, boolean paramBoolean)
  {
    if (!jdField_a_of_type_Boolean)
    {
      if (paramBoolean) {
        if (a()) {
          a();
        }
      }
      while (!jdField_a_of_type_Boolean)
      {
        QLog.w("GifCoder", 1, "gif lib loaded failed 3");
        return false;
        a();
      }
    }
    this.e = 0;
    Iterator localIterator = paramArrayList.iterator();
    Object localObject1 = null;
    int i = 0;
    String str;
    Object localObject2;
    if (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (this.jdField_c_of_type_Boolean)
      {
        localObject2 = PhotoUtils.a(str, (Bitmap)localObject1);
        label98:
        if (localObject1 != null) {
          break label361;
        }
        localObject1 = localObject2;
      }
    }
    label361:
    for (;;)
    {
      int j = PhotoUtils.a(str);
      if (this.jdField_c_of_type_Boolean) {}
      for (;;)
      {
        localObject2 = a((Bitmap)localObject2);
        if (localObject2 != null) {
          break label238;
        }
        localObject2 = new File(paramString);
        if (((File)localObject2).exists()) {
          ((File)localObject2).delete();
        }
        QLog.i("GifCoder", 1, "decode bitmap is NULL,decode pic = " + str);
        break;
        localObject2 = PhotoUtils.a(str, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, (Bitmap)localObject1);
        break label98;
        localObject2 = a((Bitmap)localObject2, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, j, this.jdField_b_of_type_Boolean);
      }
      label238:
      if (i == 0) {}
      for (;;)
      {
        try
        {
          a(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), paramString, this.jdField_a_of_type_CooperationQzoneUtilGifCoder$EncodingType);
          i = 1;
          QLog.i("GifCoder", 1, "encode gif ,frame time  = " + paramInt + ",pics = " + paramArrayList.size());
          a((Bitmap)localObject2, paramInt);
        }
        catch (Exception paramArrayList)
        {
          paramArrayList.printStackTrace();
          paramString = new File(paramString);
          if (paramString.exists()) {
            paramString.delete();
          }
          QLog.i("GifCoder", 1, "initEncoder happen exception");
          return false;
        }
        b();
        return true;
      }
    }
  }
  
  public boolean a(String paramString, JSONArray paramJSONArray, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!jdField_a_of_type_Boolean)
    {
      a();
      if (!jdField_a_of_type_Boolean)
      {
        QLog.w("GifCoder", 1, "gif lib loaded failed 2");
        return false;
      }
    }
    QLog.i("GifCoder", 1, "saxon gif mUserOrignalBitmap=" + paramBoolean1 + ",perFrameTime=" + paramInt);
    this.e = 0;
    Object localObject1 = null;
    int k = 0;
    int i = 0;
    Object localObject2;
    Object localObject3;
    if (i < paramJSONArray.length()) {
      if (paramBoolean2)
      {
        localObject2 = paramJSONArray.optString(i);
        if (!QZoneSharePictureJsPlugin.a((String)localObject2))
        {
          QLog.e("GifCoder", 1, "file name is invalid. name=" + (String)localObject2);
          return false;
        }
        localObject2 = CacheManager.b().a((String)localObject2);
        localObject3 = new File((String)localObject2);
        if (!((File)localObject3).exists())
        {
          QLog.e("GifCoder", 1, "file not exist: " + (String)localObject2);
          return false;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = QzoneOfflinePluginJsForQQ.a((File)localObject3);
        if ((localObject3 == null) || (((String)localObject3).length() == 0))
        {
          QLog.e("GifCoder", 1, "file is empty: " + (String)localObject2);
          return false;
        }
        QLog.i("GifCoder", 1, "saxon gif read filePath:" + (String)localObject2 + ",content len=" + ((String)localObject3).length());
        localObject3 = a((String)localObject3);
        if (!paramBoolean1) {
          break label531;
        }
        localObject2 = a((String)localObject3, 0, 0, this.jdField_b_of_type_Boolean, (Bitmap)localObject1);
        j = k;
        if (k == 0)
        {
          j = k;
          if (localObject2 == null) {}
        }
      }
      catch (IOException paramString)
      {
        try
        {
          a(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), paramString, this.jdField_a_of_type_CooperationQzoneUtilGifCoder$EncodingType);
          int j = 1;
          if (localObject2 != null) {
            break label588;
          }
          bool = true;
          if (localObject2 != null) {
            break label594;
          }
          k = 0;
          if (localObject2 != null) {
            break label604;
          }
          m = 0;
          QLog.i("GifCoder", 1, "saxon gif i=" + i + ",bitmapIsNull= " + bool + ",width=" + k + ",height=" + m + ", base64 len=" + ((String)localObject3).length());
          if (localObject2 == null) {
            break label614;
          }
          a((Bitmap)localObject2, paramInt);
          if (localObject1 != null) {
            break label632;
          }
          i += 1;
          localObject1 = localObject2;
          k = j;
        }
        catch (Exception paramJSONArray)
        {
          paramString = new File(paramString);
          if (!paramString.exists()) {
            break label577;
          }
          paramString.delete();
          QLog.i("GifCoder", 1, "initEncoder happen exception");
          return false;
        }
        paramString = paramString;
        QLog.e("GifCoder", 1, "read file error: " + (String)localObject2, paramString);
        return false;
      }
      localObject3 = a(paramJSONArray.optString(i));
      continue;
      label531:
      localObject2 = a((String)localObject3, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, (Bitmap)localObject1);
      continue;
      label577:
      label588:
      boolean bool = false;
      continue;
      label594:
      k = ((Bitmap)localObject2).getWidth();
      continue;
      label604:
      int m = ((Bitmap)localObject2).getHeight();
      continue;
      label614:
      QLog.e("GifCoder", 1, "bitmap is null, not call encodeFrame");
      continue;
      b();
      return true;
      label632:
      localObject2 = localObject1;
    }
  }
  
  public void b()
  {
    if ((!jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Long == 0L)) {
      return;
    }
    QLog.i("GifCoder", 1, "start close gifEncoder");
    nativeEncoderClose(this.jdField_a_of_type_Long);
    QLog.i("GifCoder", 1, "close gifEncoder success");
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.GifCoder
 * JD-Core Version:    0.7.0.1
 */