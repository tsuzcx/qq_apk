package com.tencent.mobileqq.winkpublish.util;

import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.winkpublish.uploader.AUploadImageSizeStrategy;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import cooperation.qqcircle.utils.NetworkState;
import java.io.File;

public class ImageUtil
{
  public static float a(String paramString, int paramInt)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    float f1 = 0.0F;
    if (bool) {
      return 0.0F;
    }
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      return 0.0F;
    }
    float f2 = (float)localFile.length();
    if (paramInt == 3) {
      return f2;
    }
    if ("image/gif".equalsIgnoreCase(a(localFile.getAbsolutePath())))
    {
      int i = NetworkState.getNetworkType();
      if (((i == 1) && (localFile.length() < 5242880L)) || ((i == 2) && (localFile.length() < 819200L)) || ((i == 3) && (localFile.length() < 2097152L))) {
        return f2;
      }
    }
    paramString = c(paramString);
    if (paramString != null)
    {
      long l1 = paramString.b;
      long l2 = paramString.a;
      paramString = AUploadImageSizeStrategy.a(paramString, paramInt, false);
      f1 = (float)(paramString.height * 1L * paramString.width) / (float)(l1 * 1L * l2) * (float)localFile.length() * paramString.quality / 100.0F;
    }
    return f1;
  }
  
  /* Error */
  public static android.graphics.Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 6
    //   12: aload_1
    //   13: ifnull +75 -> 88
    //   16: aload 7
    //   18: astore_2
    //   19: aload_1
    //   20: getfield 99	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   23: ifeq +65 -> 88
    //   26: aload 7
    //   28: astore_2
    //   29: new 101	java/io/FileInputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   37: astore_0
    //   38: new 104	java/io/BufferedInputStream
    //   41: dup
    //   42: aload_0
    //   43: sipush 8192
    //   46: invokespecial 107	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   49: aconst_null
    //   50: aload_1
    //   51: invokestatic 113	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   54: astore_2
    //   55: aload_0
    //   56: astore_3
    //   57: goto +138 -> 195
    //   60: astore_1
    //   61: aload_0
    //   62: astore_2
    //   63: aload_1
    //   64: astore_0
    //   65: goto +217 -> 282
    //   68: astore_3
    //   69: aconst_null
    //   70: astore_2
    //   71: aload_0
    //   72: astore_1
    //   73: aload_2
    //   74: astore_0
    //   75: goto +140 -> 215
    //   78: astore_3
    //   79: aconst_null
    //   80: astore_2
    //   81: aload_0
    //   82: astore_1
    //   83: aload_2
    //   84: astore_0
    //   85: goto +167 -> 252
    //   88: aload 7
    //   90: astore_2
    //   91: new 19	java/io/File
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: invokestatic 119	com/tencent/sharpP/SharpPUtils:isSharpP	(Ljava/io/File;)Z
    //   102: ifeq +64 -> 166
    //   105: aload 7
    //   107: astore_2
    //   108: aload_0
    //   109: invokestatic 123	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   112: astore_0
    //   113: aload 6
    //   115: astore_3
    //   116: aload_0
    //   117: astore_2
    //   118: aload_0
    //   119: ifnull +76 -> 195
    //   122: aload 7
    //   124: astore_2
    //   125: aload_1
    //   126: aload_0
    //   127: invokevirtual 128	android/graphics/Bitmap:getHeight	()I
    //   130: putfield 131	android/graphics/BitmapFactory$Options:outHeight	I
    //   133: aload 7
    //   135: astore_2
    //   136: aload_1
    //   137: aload_0
    //   138: invokevirtual 134	android/graphics/Bitmap:getWidth	()I
    //   141: putfield 137	android/graphics/BitmapFactory$Options:outWidth	I
    //   144: aload 6
    //   146: astore_3
    //   147: aload_0
    //   148: astore_2
    //   149: goto +46 -> 195
    //   152: astore_3
    //   153: aload 4
    //   155: astore_1
    //   156: goto +59 -> 215
    //   159: astore_3
    //   160: aload 5
    //   162: astore_1
    //   163: goto +89 -> 252
    //   166: aload 7
    //   168: astore_2
    //   169: invokestatic 143	com/tencent/component/media/image/ImageManager:getInstance	()Lcom/tencent/component/media/image/ImageManager;
    //   172: invokevirtual 147	com/tencent/component/media/image/ImageManager:getDecoder	()Lcom/tencent/component/media/image/IDecoder;
    //   175: new 19	java/io/File
    //   178: dup
    //   179: aload_0
    //   180: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   183: aload_1
    //   184: invokeinterface 153 3 0
    //   189: astore_0
    //   190: aload_0
    //   191: astore_2
    //   192: aload 6
    //   194: astore_3
    //   195: aload_3
    //   196: ifnull +7 -> 203
    //   199: aload_3
    //   200: invokevirtual 158	java/io/InputStream:close	()V
    //   203: aload_2
    //   204: areturn
    //   205: astore_0
    //   206: goto +76 -> 282
    //   209: astore_3
    //   210: aconst_null
    //   211: astore_0
    //   212: aload 4
    //   214: astore_1
    //   215: aload_1
    //   216: astore_2
    //   217: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq +14 -> 234
    //   223: aload_1
    //   224: astore_2
    //   225: ldc 165
    //   227: iconst_2
    //   228: ldc 167
    //   230: aload_3
    //   231: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   234: aload_0
    //   235: astore_2
    //   236: aload_1
    //   237: ifnull +43 -> 280
    //   240: aload_1
    //   241: invokevirtual 158	java/io/InputStream:close	()V
    //   244: aload_0
    //   245: areturn
    //   246: astore_3
    //   247: aconst_null
    //   248: astore_0
    //   249: aload 5
    //   251: astore_1
    //   252: aload_1
    //   253: astore_2
    //   254: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq +14 -> 271
    //   260: aload_1
    //   261: astore_2
    //   262: ldc 165
    //   264: iconst_2
    //   265: ldc 167
    //   267: aload_3
    //   268: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   271: aload_0
    //   272: astore_2
    //   273: aload_1
    //   274: ifnull +6 -> 280
    //   277: goto -37 -> 240
    //   280: aload_2
    //   281: areturn
    //   282: aload_2
    //   283: ifnull +7 -> 290
    //   286: aload_2
    //   287: invokevirtual 158	java/io/InputStream:close	()V
    //   290: goto +5 -> 295
    //   293: aload_0
    //   294: athrow
    //   295: goto -2 -> 293
    //   298: astore_0
    //   299: goto -96 -> 203
    //   302: astore_1
    //   303: aload_0
    //   304: areturn
    //   305: astore_1
    //   306: goto -16 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	paramString	String
    //   0	309	1	paramOptions	BitmapFactory.Options
    //   18	269	2	localObject1	Object
    //   56	1	3	str	String
    //   68	1	3	localException1	java.lang.Exception
    //   78	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   115	32	3	localObject2	Object
    //   152	1	3	localException2	java.lang.Exception
    //   159	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   194	6	3	localObject3	Object
    //   209	22	3	localException3	java.lang.Exception
    //   246	22	3	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   4	209	4	localObject4	Object
    //   7	243	5	localObject5	Object
    //   10	183	6	localObject6	Object
    //   1	166	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   38	55	60	finally
    //   38	55	68	java/lang/Exception
    //   38	55	78	java/lang/OutOfMemoryError
    //   125	133	152	java/lang/Exception
    //   136	144	152	java/lang/Exception
    //   125	133	159	java/lang/OutOfMemoryError
    //   136	144	159	java/lang/OutOfMemoryError
    //   19	26	205	finally
    //   29	38	205	finally
    //   91	105	205	finally
    //   108	113	205	finally
    //   125	133	205	finally
    //   136	144	205	finally
    //   169	190	205	finally
    //   217	223	205	finally
    //   225	234	205	finally
    //   254	260	205	finally
    //   262	271	205	finally
    //   19	26	209	java/lang/Exception
    //   29	38	209	java/lang/Exception
    //   91	105	209	java/lang/Exception
    //   108	113	209	java/lang/Exception
    //   169	190	209	java/lang/Exception
    //   19	26	246	java/lang/OutOfMemoryError
    //   29	38	246	java/lang/OutOfMemoryError
    //   91	105	246	java/lang/OutOfMemoryError
    //   108	113	246	java/lang/OutOfMemoryError
    //   169	190	246	java/lang/OutOfMemoryError
    //   199	203	298	java/io/IOException
    //   240	244	302	java/io/IOException
    //   286	290	305	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (!new File(paramString).exists()) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    a(paramString, localOptions);
    return localOptions.outMimeType;
  }
  
  public static int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    int i = JpegExifReader.readOrientation(paramString);
    if (i != 3)
    {
      if (i != 6)
      {
        if (i != 8) {
          return 0;
        }
        return 270;
      }
      return 90;
    }
    return 180;
  }
  
  public static ImageUtil.Size c(String paramString)
  {
    if (!new File(paramString).exists()) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    a(paramString, localOptions);
    localOptions.inJustDecodeBounds = false;
    return new ImageUtil.Size(localOptions.outWidth, localOptions.outHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.util.ImageUtil
 * JD-Core Version:    0.7.0.1
 */