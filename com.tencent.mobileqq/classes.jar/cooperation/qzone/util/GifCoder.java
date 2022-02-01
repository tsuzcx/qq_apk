package cooperation.qzone.util;

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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;

public class GifCoder
{
  private static final String TAG = "GifCoder";
  public static final String TEMP_FILE_NAME_PREFIX = "tempfile_";
  private static boolean mNativeLibLoaded = false;
  private int GIFPicSize = gifCoderWnsConfig.getCurrentDeviceGifSize();
  private final int HORIZONAL = 2;
  private final int NONE = 0;
  private final int VERTICAL = 1;
  private GifCoder.OnEncodeGifFinishedListener callBack;
  private long instance = 0L;
  private GifCoder.EncodingType mEncodingType = GifCoder.EncodingType.ENCODING_TYPE_SIMPLE_FAST;
  private boolean mIsSetDither = true;
  private int mLastPicOrientation = 0;
  private boolean mPicSizeForLongEdge = false;
  private boolean mUserOrignalBitmap = false;
  
  static {}
  
  private Bitmap bitMapIsSameOrientation(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (i <= j)
    {
      i = this.mLastPicOrientation;
      if ((i != 1) && (i != 0)) {
        return null;
      }
      this.mLastPicOrientation = 1;
      return paramBitmap;
    }
    if (i > j)
    {
      i = this.mLastPicOrientation;
      if ((i != 2) && (i != 0)) {
        return null;
      }
      this.mLastPicOrientation = 2;
    }
    return paramBitmap;
  }
  
  @TargetApi(19)
  static boolean canUseForInBitmap(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramBitmap != null)
    {
      bool1 = bool3;
      if (paramBitmap.isMutable())
      {
        if (paramBitmap.isRecycled()) {
          return false;
        }
        if (Build.VERSION.SDK_INT >= 19)
        {
          bool1 = bool2;
          if (paramOptions.outWidth / paramOptions.inSampleSize * (paramOptions.outHeight / paramOptions.inSampleSize) * getBytesPerPixel(paramBitmap.getConfig()) <= paramBitmap.getAllocationByteCount()) {
            bool1 = true;
          }
          return bool1;
        }
        bool1 = bool3;
        if (paramBitmap.getWidth() == paramOptions.outWidth)
        {
          bool1 = bool3;
          if (paramBitmap.getHeight() == paramOptions.outHeight)
          {
            bool1 = bool3;
            if (paramOptions.inSampleSize == 1) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean checkIsValidTempFileName(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (paramString.length() > 50) {
      return false;
    }
    if (!paramString.startsWith("tempfile_")) {
      return false;
    }
    return Pattern.compile("[a-zA-Z0-9_]+").matcher(paramString).matches();
  }
  
  private String cutHeadIfNeeded(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = paramString;
    if (paramString.startsWith("data:image"))
    {
      int i = paramString.indexOf("base64,");
      str = paramString;
      if (i >= 0)
      {
        i += 7;
        str = paramString;
        if (i < paramString.length()) {
          str = paramString.substring(i);
        }
      }
    }
    return str;
  }
  
  private static Bitmap decodeBitmapFromBase64(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, Bitmap paramBitmap)
  {
    BitmapFactory.Options localOptions = null;
    Object localObject = localOptions;
    if (paramString != null)
    {
      localObject = localOptions;
      if (!"".equals(paramString))
      {
        if (paramString.length() <= 0) {
          return null;
        }
        if (TextUtils.isEmpty(paramString)) {
          return null;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = Base64.decode(paramString, 0);
        localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length, localOptions);
        localOptions.inJustDecodeBounds = false;
        if ((paramInt1 == 0) || (paramInt2 == 0)) {
          break label241;
        }
        if (paramBoolean) {
          i = Math.max(localOptions.outWidth / paramInt1, localOptions.outHeight / paramInt2);
        } else {
          i = Math.min(localOptions.outWidth / paramInt1, localOptions.outHeight / paramInt2);
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("GifCoder", 1, "", paramString);
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.e("GifCoder", 1, "", paramString);
        return null;
      }
      catch (IllegalArgumentException paramBitmap)
      {
        QLog.w("GifCoder", 1, "", paramBitmap);
        localObject = decodeBitmapFromBase64(paramString, paramInt1, paramInt2, paramBoolean, null);
      }
      localOptions.inSampleSize = j;
      localOptions.inMutable = true;
      if ((Build.VERSION.SDK_INT >= 11) && (canUseForInBitmap(paramBitmap, localOptions))) {
        localOptions.inBitmap = paramBitmap;
      }
      paramBitmap = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length, localOptions);
      return paramBitmap;
      return localObject;
      label241:
      int i = 1;
      int j = i;
      if (i < 1) {
        j = 1;
      }
    }
  }
  
  static int getBytesPerPixel(Bitmap.Config paramConfig)
  {
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      return 4;
    }
    if (paramConfig == Bitmap.Config.RGB_565) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ARGB_4444) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ALPHA_8) {}
    return 1;
  }
  
  public static Bitmap getTransparentBitmap(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return null;
    }
    int[] arrayOfInt = new int[paramBitmap.getWidth() * paramBitmap.getHeight()];
    paramBitmap.getPixels(arrayOfInt, 0, paramBitmap.getWidth(), 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    int i = paramInt * 255 / 100;
    paramInt = 0;
    while (paramInt < arrayOfInt.length)
    {
      int j = arrayOfInt[paramInt];
      int k = arrayOfInt[paramInt];
      k = arrayOfInt[paramInt];
      int m = arrayOfInt[paramInt] >> 16 & 0xFF;
      if ((m == 0) && ((k >> 8 & 0xFF) == 0) && (m == 0) && ((j >> 24 & 0xFF) == 0))
      {
        arrayOfInt[paramInt] = 16777215;
        arrayOfInt[paramInt] = (0xFFFFFF & arrayOfInt[paramInt] | i << 24);
      }
      paramInt += 1;
    }
    return Bitmap.createBitmap(arrayOfInt, paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
  }
  
  public static boolean isFullTransBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramBitmap.getWidth() > 2)) {
      if (paramBitmap.getHeight() <= 2) {
        return false;
      }
    }
    try
    {
      int i = paramBitmap.getPixel(1, 1);
      int j = paramBitmap.getPixel(paramBitmap.getWidth() - 2, paramBitmap.getHeight() - 2);
      return (i >> 24 == 0) && (j >> 24 == 0);
    }
    catch (Exception paramBitmap) {}
    return false;
    return true;
  }
  
  private static boolean loadNativeLib(String paramString)
  {
    try
    {
      try
      {
        QLog.i("GifCoder", 1, "gif lib start load");
        System.load(paramString);
        QLog.i("GifCoder", 1, "gif lib load success");
        mNativeLibLoaded = true;
      }
      finally
      {
        break label58;
      }
    }
    catch (Throwable paramString)
    {
      label36:
      boolean bool;
      label58:
      break label36;
    }
    mNativeLibLoaded = false;
    QLog.i("GifCoder", 1, "gif lib load happen Exception");
    bool = mNativeLibLoaded;
    return bool;
    throw paramString;
  }
  
  private native boolean nativeEncodeFrame(long paramLong, Bitmap paramBitmap, int paramInt);
  
  private native void nativeEncoderClose(long paramLong);
  
  private native long nativeEncoderInit(int paramInt1, int paramInt2, String paramString, int paramInt3);
  
  private native void nativeEncoderSetDither(long paramLong, boolean paramBoolean);
  
  /* Error */
  public static String readFile(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_3
    //   4: new 289	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 292	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: astore_0
    //   13: aload_0
    //   14: invokevirtual 295	java/io/FileInputStream:available	()I
    //   17: iconst_1
    //   18: iadd
    //   19: newarray byte
    //   21: astore_1
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 299	java/io/FileInputStream:read	([B)I
    //   27: pop
    //   28: new 123	java/lang/String
    //   31: dup
    //   32: aload_1
    //   33: ldc_w 301
    //   36: invokespecial 304	java/lang/String:<init>	([BLjava/lang/String;)V
    //   39: astore_1
    //   40: aload_0
    //   41: invokevirtual 307	java/io/FileInputStream:close	()V
    //   44: aload_1
    //   45: areturn
    //   46: goto +32 -> 78
    //   49: astore_2
    //   50: goto +11 -> 61
    //   53: aload_1
    //   54: astore_0
    //   55: goto +23 -> 78
    //   58: astore_2
    //   59: aload_3
    //   60: astore_0
    //   61: aload_0
    //   62: astore_1
    //   63: aload_2
    //   64: invokevirtual 310	java/lang/Exception:printStackTrace	()V
    //   67: aload_0
    //   68: ifnull +7 -> 75
    //   71: aload_0
    //   72: invokevirtual 307	java/io/FileInputStream:close	()V
    //   75: ldc 170
    //   77: areturn
    //   78: aload_0
    //   79: ifnull +7 -> 86
    //   82: aload_0
    //   83: invokevirtual 307	java/io/FileInputStream:close	()V
    //   86: ldc 170
    //   88: areturn
    //   89: astore_0
    //   90: goto -37 -> 53
    //   93: astore_1
    //   94: goto -48 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	paramFile	File
    //   1	62	1	localObject1	Object
    //   93	1	1	localObject2	Object
    //   49	1	2	localException1	Exception
    //   58	6	2	localException2	Exception
    //   3	57	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   13	40	49	java/lang/Exception
    //   4	13	58	java/lang/Exception
    //   4	13	89	finally
    //   63	67	89	finally
    //   13	40	93	finally
  }
  
  private static boolean tryToLoadGifEncoderSo()
  {
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    AlbumLibDownloaderUtil.getInstance().forceDownloadGifEncoderSo(new GifCoder.1(arrayOfBoolean, localCountDownLatch));
    try
    {
      localCountDownLatch.await(30L, TimeUnit.SECONDS);
    }
    catch (InterruptedException localInterruptedException)
    {
      label46:
      break label46;
    }
    arrayOfBoolean[0] = false;
    return arrayOfBoolean[0];
  }
  
  public static void tryToLoadGifLib()
  {
    if (AlbumLibDownloaderUtil.getInstance().vertifySoIsOK(AlbumLibDownloaderUtil.GIF_SO_LIB_NAME, true))
    {
      try
      {
        System.loadLibrary("c++_shared");
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GifCoder", 1, "tryToLoad c++_shared fail", localThrowable);
      }
      loadNativeLib(AlbumLibDownloaderUtil.getInstance().getLibPath(AlbumLibDownloaderUtil.GIF_SO_LIB_NAME));
      return;
    }
    AlbumLibDownloaderUtil.getInstance().downloadGifEncoderSo();
  }
  
  public static Bitmap zoomImage(Bitmap paramBitmap, double paramDouble1, double paramDouble2, int paramInt, boolean paramBoolean)
  {
    Bitmap localBitmap1 = null;
    if (paramBitmap == null)
    {
      QLog.i("GifCoder", 1, "need zoom bgimage is null");
      return null;
    }
    float f4 = paramBitmap.getWidth();
    float f5 = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    float f2 = (float)paramDouble1 / f4;
    float f3 = (float)paramDouble2 / f5;
    float f1;
    if (paramBoolean)
    {
      f1 = f2;
      if (f2 <= f3) {}
    }
    else
    {
      while (f2 <= f3)
      {
        f1 = f3;
        break;
      }
      f1 = f2;
    }
    localMatrix.postScale(f1, f1);
    localMatrix.postRotate(paramInt);
    paramInt = (int)f4;
    int i = (int)f5;
    try
    {
      Bitmap localBitmap2 = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt, i, localMatrix, true);
      paramBitmap = localBitmap2;
    }
    catch (Throwable localThrowable)
    {
      label141:
      label161:
      break label141;
    }
    System.gc();
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt, i, localMatrix, true);
    }
    catch (Throwable paramBitmap)
    {
      break label161;
    }
    QLog.i("GifCoder", 1, "zoomImage happen exception");
    System.gc();
    paramBitmap = localBitmap1;
    localBitmap1 = paramBitmap;
    if (isFullTransBitmap(paramBitmap)) {
      localBitmap1 = getTransparentBitmap(paramBitmap, 100);
    }
    return localBitmap1;
  }
  
  public void closeEncoder()
  {
    if (mNativeLibLoaded)
    {
      if (this.instance == 0L) {
        return;
      }
      QLog.i("GifCoder", 1, "start close gifEncoder");
      nativeEncoderClose(this.instance);
      QLog.i("GifCoder", 1, "close gifEncoder success");
      this.instance = 0L;
    }
  }
  
  public boolean encodeFrame(Bitmap paramBitmap, int paramInt)
  {
    if (!mNativeLibLoaded) {
      return false;
    }
    if (0L == this.instance) {
      return false;
    }
    QLog.i("GifCoder", 1, "start encodeFrame");
    nativeEncodeFrame(this.instance, paramBitmap, paramInt);
    QLog.i("GifCoder", 1, "encodeFrame success");
    return true;
  }
  
  public boolean encodeGif(Bitmap paramBitmap, String paramString, int paramInt)
  {
    return encodeGif(paramBitmap, paramString, paramInt, false);
  }
  
  public boolean encodeGif(Bitmap paramBitmap, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return false;
    }
    if (!mNativeLibLoaded)
    {
      if (paramBoolean)
      {
        if (tryToLoadGifEncoderSo()) {
          tryToLoadGifLib();
        }
      }
      else {
        tryToLoadGifLib();
      }
      if (!mNativeLibLoaded)
      {
        QLog.w("GifCoder", 1, "gif lib loaded failed 1");
        return false;
      }
    }
    Bitmap localBitmap;
    if (this.mUserOrignalBitmap)
    {
      localBitmap = paramBitmap;
      if (isFullTransBitmap(paramBitmap)) {
        localBitmap = getTransparentBitmap(paramBitmap, 100);
      }
    }
    else
    {
      int i = this.GIFPicSize;
      localBitmap = zoomImage(paramBitmap, i, i, 0, this.mPicSizeForLongEdge);
    }
    if (this.instance == 0L) {
      try
      {
        initEncoder(localBitmap.getWidth(), localBitmap.getHeight(), paramString, this.mEncodingType);
      }
      catch (Throwable paramBitmap)
      {
        paramBitmap.printStackTrace();
        paramBitmap = new File(paramString);
        if (paramBitmap.exists()) {
          paramBitmap.delete();
        }
        QLog.i("GifCoder", 1, "initEncoder happen exception");
        return false;
      }
    }
    paramBitmap = new StringBuilder();
    paramBitmap.append("encode gif ,frame time  = ");
    paramBitmap.append(paramInt);
    QLog.i("GifCoder", 1, paramBitmap.toString());
    return encodeFrame(localBitmap, paramInt);
  }
  
  public boolean encodeGif(String paramString, ArrayList<String> paramArrayList, int paramInt)
  {
    return encodeGif(paramString, paramArrayList, paramInt, false);
  }
  
  public boolean encodeGif(String paramString, ArrayList<String> paramArrayList, int paramInt, boolean paramBoolean)
  {
    if (!mNativeLibLoaded)
    {
      if (paramBoolean)
      {
        if (tryToLoadGifEncoderSo()) {
          tryToLoadGifLib();
        }
      }
      else {
        tryToLoadGifLib();
      }
      if (!mNativeLibLoaded)
      {
        QLog.w("GifCoder", 1, "gif lib loaded failed 3");
        return false;
      }
    }
    this.mLastPicOrientation = 0;
    Object localObject3 = null;
    Iterator localIterator = paramArrayList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.mUserOrignalBitmap)
      {
        localObject1 = PhotoUtils.decodeBitmapFromFile(str, (Bitmap)localObject3);
      }
      else
      {
        j = this.GIFPicSize;
        localObject1 = PhotoUtils.decodeBitmapFromFile(str, j, j, this.mPicSizeForLongEdge, (Bitmap)localObject3);
      }
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = localObject1;
      }
      int j = PhotoUtils.getPicRotate(str);
      if (!this.mUserOrignalBitmap)
      {
        int k = this.GIFPicSize;
        localObject1 = zoomImage((Bitmap)localObject1, k, k, j, this.mPicSizeForLongEdge);
      }
      Object localObject1 = bitMapIsSameOrientation((Bitmap)localObject1);
      if (localObject1 == null)
      {
        localObject1 = new File(paramString);
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("decode bitmap is NULL,decode pic = ");
        ((StringBuilder)localObject1).append(str);
        QLog.i("GifCoder", 1, ((StringBuilder)localObject1).toString());
        localObject3 = localObject2;
      }
      else
      {
        j = i;
        if (i == 0) {
          try
          {
            initEncoder(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), paramString, this.mEncodingType);
            j = 1;
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
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("encode gif ,frame time  = ");
        ((StringBuilder)localObject3).append(paramInt);
        ((StringBuilder)localObject3).append(",pics = ");
        ((StringBuilder)localObject3).append(paramArrayList.size());
        QLog.i("GifCoder", 1, ((StringBuilder)localObject3).toString());
        encodeFrame((Bitmap)localObject1, paramInt);
        localObject3 = localObject2;
        i = j;
      }
    }
    closeEncoder();
    return true;
  }
  
  public boolean encodeGifFromBase64(String paramString, JSONArray paramJSONArray, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!mNativeLibLoaded)
    {
      tryToLoadGifLib();
      if (!mNativeLibLoaded)
      {
        QLog.w("GifCoder", 1, "gif lib loaded failed 2");
        return false;
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("saxon gif mUserOrignalBitmap=");
    ((StringBuilder)localObject1).append(paramBoolean1);
    ((StringBuilder)localObject1).append(",perFrameTime=");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.i("GifCoder", 1, ((StringBuilder)localObject1).toString());
    this.mLastPicOrientation = 0;
    Object localObject2 = null;
    int i = 0;
    int k = 0;
    while (i < paramJSONArray.length())
    {
      if (paramBoolean2)
      {
        localObject1 = paramJSONArray.optString(i);
        if (!checkIsValidTempFileName((String)localObject1))
        {
          paramString = new StringBuilder();
          paramString.append("file name is invalid. name=");
          paramString.append((String)localObject1);
          QLog.e("GifCoder", 1, paramString.toString());
          return false;
        }
        localObject1 = CacheManager.getWebviewOfflineFileCacheService().getPath((String)localObject1);
        localObject3 = new File((String)localObject1);
        if (!((File)localObject3).exists())
        {
          paramString = new StringBuilder();
          paramString.append("file not exist: ");
          paramString.append((String)localObject1);
          QLog.e("GifCoder", 1, paramString.toString());
          return false;
        }
        try
        {
          localObject3 = readFile((File)localObject3);
          if ((localObject3 != null) && (((String)localObject3).length() != 0))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("saxon gif read filePath:");
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(",content len=");
            localStringBuilder.append(((String)localObject3).length());
            QLog.i("GifCoder", 1, localStringBuilder.toString());
            localObject3 = cutHeadIfNeeded((String)localObject3);
            break label397;
          }
          paramString = new StringBuilder();
          paramString.append("file is empty: ");
          paramString.append((String)localObject1);
          QLog.e("GifCoder", 1, paramString.toString());
          return false;
        }
        catch (IOException paramString)
        {
          paramJSONArray = new StringBuilder();
          paramJSONArray.append("read file error: ");
          paramJSONArray.append((String)localObject1);
          QLog.e("GifCoder", 1, paramJSONArray.toString(), paramString);
          return false;
        }
      }
      else
      {
        localObject3 = cutHeadIfNeeded(paramJSONArray.optString(i));
      }
      label397:
      if (paramBoolean1)
      {
        localObject1 = decodeBitmapFromBase64((String)localObject3, 0, 0, this.mPicSizeForLongEdge, (Bitmap)localObject2);
      }
      else
      {
        j = this.GIFPicSize;
        localObject1 = decodeBitmapFromBase64((String)localObject3, j, j, this.mPicSizeForLongEdge, (Bitmap)localObject2);
      }
      int j = k;
      if (k == 0)
      {
        j = k;
        if (localObject1 == null) {}
      }
      try
      {
        initEncoder(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), paramString, this.mEncodingType);
        j = 1;
      }
      catch (Exception paramJSONArray)
      {
        label486:
        boolean bool;
        int m;
        break label486;
      }
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      QLog.i("GifCoder", 1, "initEncoder happen exception");
      return false;
      if (localObject1 == null) {
        bool = true;
      } else {
        bool = false;
      }
      if (localObject1 == null) {
        k = 0;
      } else {
        k = ((Bitmap)localObject1).getWidth();
      }
      if (localObject1 == null) {
        m = 0;
      } else {
        m = ((Bitmap)localObject1).getHeight();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saxon gif i=");
      localStringBuilder.append(i);
      localStringBuilder.append(",bitmapIsNull= ");
      localStringBuilder.append(bool);
      localStringBuilder.append(",width=");
      localStringBuilder.append(k);
      localStringBuilder.append(",height=");
      localStringBuilder.append(m);
      localStringBuilder.append(", base64 len=");
      localStringBuilder.append(((String)localObject3).length());
      QLog.i("GifCoder", 1, localStringBuilder.toString());
      if (localObject1 != null) {
        encodeFrame((Bitmap)localObject1, paramInt);
      } else {
        QLog.e("GifCoder", 1, "bitmap is null, not call encodeFrame");
      }
      Object localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = localObject1;
      }
      i += 1;
      k = j;
      localObject2 = localObject3;
    }
    closeEncoder();
    return true;
  }
  
  public void initEncoder(int paramInt1, int paramInt2, String paramString)
  {
    if (!mNativeLibLoaded)
    {
      tryToLoadGifLib();
      if (!mNativeLibLoaded) {
        return;
      }
    }
    initEncoder(paramInt1, paramInt2, paramString, GifCoder.EncodingType.ENCODING_TYPE_SIMPLE_FAST);
  }
  
  public void initEncoder(int paramInt1, int paramInt2, String paramString, GifCoder.EncodingType paramEncodingType)
  {
    if (!mNativeLibLoaded)
    {
      tryToLoadGifLib();
      if (!mNativeLibLoaded) {
        return;
      }
    }
    if (0L != this.instance) {
      closeEncoder();
    }
    QLog.i("GifCoder", 1, "start nativeEncoderInit");
    this.instance = nativeEncoderInit(paramInt1, paramInt2, paramString, paramEncodingType.ordinal());
    QLog.i("GifCoder", 1, "nativeEncoderInit success");
    if (0L != this.instance)
    {
      QLog.i("GifCoder", 1, "start nativeEncoderSetDither");
      nativeEncoderSetDither(this.instance, this.mIsSetDither);
      QLog.i("GifCoder", 1, "nativeEncoderSetDither success");
      return;
    }
    throw new FileNotFoundException();
  }
  
  public void setEncoderDither(boolean paramBoolean)
  {
    if (!mNativeLibLoaded) {
      return;
    }
    this.mIsSetDither = paramBoolean;
  }
  
  public void setEncoderGifPicSizeForLongEdge(boolean paramBoolean)
  {
    this.mPicSizeForLongEdge = paramBoolean;
  }
  
  public void setEncoderGifSize(int paramInt)
  {
    this.GIFPicSize = paramInt;
  }
  
  public void setEncodingType(GifCoder.EncodingType paramEncodingType)
  {
    this.mEncodingType = paramEncodingType;
  }
  
  public void setUseOrignalBitmap(boolean paramBoolean)
  {
    this.mUserOrignalBitmap = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.GifCoder
 * JD-Core Version:    0.7.0.1
 */