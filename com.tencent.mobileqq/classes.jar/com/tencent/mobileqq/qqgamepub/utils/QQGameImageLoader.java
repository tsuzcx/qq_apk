package com.tencent.mobileqq.qqgamepub.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.base.img.ImageCache;

public class QQGameImageLoader
{
  protected static QQGameImageLoader a;
  protected static final byte[] a;
  protected LruCache<String, Bitmap> a;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected QQGameImageLoader()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
  }
  
  /* Error */
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: ifnull +244 -> 248
    //   7: new 31	android/graphics/BitmapFactory$Options
    //   10: dup
    //   11: invokespecial 32	android/graphics/BitmapFactory$Options:<init>	()V
    //   14: astore 8
    //   16: aload 8
    //   18: iconst_1
    //   19: putfield 36	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   22: new 38	java/io/BufferedInputStream
    //   25: dup
    //   26: new 40	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 43	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   34: invokespecial 46	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore 6
    //   39: aload 6
    //   41: astore 5
    //   43: aload 6
    //   45: aconst_null
    //   46: aload 8
    //   48: invokestatic 52	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   51: pop
    //   52: aload 6
    //   54: astore 5
    //   56: aload 8
    //   58: getfield 56	android/graphics/BitmapFactory$Options:outWidth	I
    //   61: istore_3
    //   62: aload 6
    //   64: astore 5
    //   66: aload 8
    //   68: getfield 59	android/graphics/BitmapFactory$Options:outHeight	I
    //   71: istore 4
    //   73: aload 6
    //   75: astore 5
    //   77: new 31	android/graphics/BitmapFactory$Options
    //   80: dup
    //   81: invokespecial 32	android/graphics/BitmapFactory$Options:<init>	()V
    //   84: astore 8
    //   86: aload 6
    //   88: astore 5
    //   90: aload 8
    //   92: iload_3
    //   93: iload_1
    //   94: idiv
    //   95: iload 4
    //   97: iload_2
    //   98: idiv
    //   99: invokestatic 65	java/lang/Math:max	(II)I
    //   102: putfield 68	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   105: aload 6
    //   107: astore 5
    //   109: aload 8
    //   111: iconst_0
    //   112: putfield 36	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   115: aload 6
    //   117: astore 5
    //   119: aload 8
    //   121: iconst_1
    //   122: putfield 71	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   125: aload 6
    //   127: astore 5
    //   129: aload 6
    //   131: invokevirtual 76	java/io/InputStream:close	()V
    //   134: aload 6
    //   136: astore 5
    //   138: new 38	java/io/BufferedInputStream
    //   141: dup
    //   142: new 40	java/io/FileInputStream
    //   145: dup
    //   146: aload_0
    //   147: invokespecial 43	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   150: invokespecial 46	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   153: astore_0
    //   154: aload_0
    //   155: aconst_null
    //   156: aload 8
    //   158: invokestatic 52	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   161: astore 6
    //   163: aload 6
    //   165: astore 5
    //   167: aload_0
    //   168: invokevirtual 76	java/io/InputStream:close	()V
    //   171: aload 6
    //   173: areturn
    //   174: astore 6
    //   176: aload_0
    //   177: astore 5
    //   179: aload 6
    //   181: astore_0
    //   182: goto +54 -> 236
    //   185: astore 6
    //   187: goto +26 -> 213
    //   190: astore 5
    //   192: aload 6
    //   194: astore_0
    //   195: aload 5
    //   197: astore 6
    //   199: goto +14 -> 213
    //   202: astore_0
    //   203: aconst_null
    //   204: astore 5
    //   206: goto +30 -> 236
    //   209: astore 6
    //   211: aconst_null
    //   212: astore_0
    //   213: aload_0
    //   214: astore 5
    //   216: aload 6
    //   218: invokevirtual 79	java/lang/Throwable:printStackTrace	()V
    //   221: aload_0
    //   222: ifnull +11 -> 233
    //   225: aload 7
    //   227: astore 5
    //   229: aload_0
    //   230: invokevirtual 76	java/io/InputStream:close	()V
    //   233: aconst_null
    //   234: areturn
    //   235: astore_0
    //   236: aload 5
    //   238: ifnull +8 -> 246
    //   241: aload 5
    //   243: invokevirtual 76	java/io/InputStream:close	()V
    //   246: aload_0
    //   247: athrow
    //   248: aconst_null
    //   249: areturn
    //   250: astore_0
    //   251: aload 5
    //   253: areturn
    //   254: astore 5
    //   256: goto -10 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	paramString	String
    //   0	259	1	paramInt1	int
    //   0	259	2	paramInt2	int
    //   61	34	3	i	int
    //   71	28	4	j	int
    //   41	137	5	localObject1	Object
    //   190	6	5	localThrowable1	java.lang.Throwable
    //   204	48	5	localObject2	Object
    //   254	1	5	localIOException	java.io.IOException
    //   37	135	6	localObject3	Object
    //   174	6	6	localObject4	Object
    //   185	8	6	localThrowable2	java.lang.Throwable
    //   197	1	6	localObject5	Object
    //   209	8	6	localThrowable3	java.lang.Throwable
    //   1	225	7	localObject6	Object
    //   14	143	8	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   154	163	174	finally
    //   154	163	185	java/lang/Throwable
    //   43	52	190	java/lang/Throwable
    //   56	62	190	java/lang/Throwable
    //   66	73	190	java/lang/Throwable
    //   77	86	190	java/lang/Throwable
    //   90	105	190	java/lang/Throwable
    //   109	115	190	java/lang/Throwable
    //   119	125	190	java/lang/Throwable
    //   129	134	190	java/lang/Throwable
    //   138	154	190	java/lang/Throwable
    //   7	39	202	finally
    //   7	39	209	java/lang/Throwable
    //   43	52	235	finally
    //   56	62	235	finally
    //   66	73	235	finally
    //   77	86	235	finally
    //   90	105	235	finally
    //   109	115	235	finally
    //   119	125	235	finally
    //   129	134	235	finally
    //   138	154	235	finally
    //   216	221	235	finally
    //   167	171	250	java/io/IOException
    //   229	233	250	java/io/IOException
    //   241	246	254	java/io/IOException
  }
  
  public static QQGameImageLoader a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameImageLoader == null) {
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameImageLoader == null) {
          jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameImageLoader = new QQGameImageLoader();
        }
      }
    }
    return jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsQQGameImageLoader;
  }
  
  public Bitmap a(String arg1)
  {
    if (TextUtils.isEmpty(???)) {
      return null;
    }
    Object localObject1 = MD5Utils.encodeHexStr(???);
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      localObject1 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localObject1);
      return localObject1;
    }
  }
  
  public void a(String paramString, QQGameImageLoader.ImageLoadListener paramImageLoadListener, int paramInt1, int paramInt2)
  {
    ImageCache.a("app", paramString, new QQGameImageLoader.1(this, paramInt1, paramInt2, paramImageLoadListener, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.utils.QQGameImageLoader
 * JD-Core Version:    0.7.0.1
 */