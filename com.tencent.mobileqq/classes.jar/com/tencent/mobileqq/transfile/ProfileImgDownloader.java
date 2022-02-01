package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory.Options;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import java.io.File;
import java.io.OutputStream;

public class ProfileImgDownloader
  extends AbsDownloader
{
  public static final String PROTOCOL_PROFILE_IMG_BIG = "profile_img_big";
  public static final String PROTOCOL_PROFILE_IMG_BIG_FHD = "profile_img_big_fhd";
  public static final String PROTOCOL_PROFILE_IMG_ICON = "profile_img_icon";
  public static final String PROTOCOL_PROFILE_IMG_THUMB = "profile_img_thumb";
  protected static final String TAG = "ProfileImgDownloader";
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 == -1) {
            return 1;
          }
          j = paramOptions.outHeight;
          int k = paramOptions.outWidth;
          for (;;)
          {
            if (j <= paramInt2)
            {
              m = i;
              if (k <= paramInt1) {
                break;
              }
            }
            int n = Math.round(j / paramInt2);
            m = Math.round(k / paramInt1);
            if (n <= m) {
              n = m;
            }
            m = i;
            if (n < 2) {
              break;
            }
            k /= 2;
            j /= 2;
            i *= 2;
          }
        }
      }
    }
    return m;
  }
  
  /* Error */
  public java.lang.Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +59 -> 62
    //   6: new 56	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc 59
    //   19: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 4
    //   25: aload_2
    //   26: getfield 69	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   29: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 4
    //   35: ldc 74
    //   37: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 4
    //   43: aload_1
    //   44: invokevirtual 80	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   47: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: ldc 20
    //   53: iconst_2
    //   54: aload 4
    //   56: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 87	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: ldc 17
    //   64: aload_2
    //   65: getfield 69	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   68: invokevirtual 92	java/net/URL:getProtocol	()Ljava/lang/String;
    //   71: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   74: ifeq +231 -> 305
    //   77: aconst_null
    //   78: astore 7
    //   80: aconst_null
    //   81: astore 5
    //   83: aload 5
    //   85: astore 4
    //   87: new 29	android/graphics/BitmapFactory$Options
    //   90: dup
    //   91: invokespecial 99	android/graphics/BitmapFactory$Options:<init>	()V
    //   94: astore 6
    //   96: aload 5
    //   98: astore 4
    //   100: aload 6
    //   102: iconst_1
    //   103: putfield 103	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   106: aload 5
    //   108: astore 4
    //   110: aload_1
    //   111: invokevirtual 80	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   114: aload 6
    //   116: invokestatic 108	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   119: pop
    //   120: aload 5
    //   122: astore 4
    //   124: aload 6
    //   126: aload 6
    //   128: sipush 160
    //   131: sipush 160
    //   134: invokestatic 110	com/tencent/mobileqq/transfile/ProfileImgDownloader:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   137: putfield 113	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   140: aload 5
    //   142: astore 4
    //   144: aload 6
    //   146: iconst_0
    //   147: putfield 103	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   150: aload 5
    //   152: astore 4
    //   154: new 115	java/io/BufferedInputStream
    //   157: dup
    //   158: new 117	java/io/FileInputStream
    //   161: dup
    //   162: aload_1
    //   163: invokevirtual 80	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   166: invokespecial 120	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   169: invokespecial 123	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   172: astore 5
    //   174: aload 5
    //   176: aconst_null
    //   177: aload 6
    //   179: invokestatic 127	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   182: astore 4
    //   184: aload 5
    //   186: invokevirtual 132	java/io/InputStream:close	()V
    //   189: aload 4
    //   191: areturn
    //   192: astore_1
    //   193: aload 5
    //   195: astore 4
    //   197: goto +96 -> 293
    //   200: astore 6
    //   202: goto +13 -> 215
    //   205: astore_1
    //   206: goto +87 -> 293
    //   209: astore 6
    //   211: aload 7
    //   213: astore 5
    //   215: aload 5
    //   217: astore 4
    //   219: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq +58 -> 280
    //   225: aload 5
    //   227: astore 4
    //   229: new 56	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   236: astore 7
    //   238: aload 5
    //   240: astore 4
    //   242: aload 7
    //   244: ldc 134
    //   246: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 5
    //   252: astore 4
    //   254: aload 7
    //   256: aload 6
    //   258: invokevirtual 137	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   261: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 5
    //   267: astore 4
    //   269: ldc 20
    //   271: iconst_2
    //   272: aload 7
    //   274: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: aload 5
    //   282: ifnull +23 -> 305
    //   285: aload 5
    //   287: invokevirtual 132	java/io/InputStream:close	()V
    //   290: goto +15 -> 305
    //   293: aload 4
    //   295: ifnull +8 -> 303
    //   298: aload 4
    //   300: invokevirtual 132	java/io/InputStream:close	()V
    //   303: aload_1
    //   304: athrow
    //   305: aload_0
    //   306: aload_1
    //   307: aload_2
    //   308: aload_3
    //   309: invokespecial 142	com/tencent/mobileqq/transfile/AbsDownloader:decodeFile	(Ljava/io/File;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/lang/Object;
    //   312: areturn
    //   313: astore_1
    //   314: aload 4
    //   316: areturn
    //   317: astore 4
    //   319: goto -14 -> 305
    //   322: astore_2
    //   323: goto -20 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	this	ProfileImgDownloader
    //   0	326	1	paramFile	File
    //   0	326	2	paramDownloadParams	DownloadParams
    //   0	326	3	paramURLDrawableHandler	URLDrawableHandler
    //   13	302	4	localObject1	java.lang.Object
    //   317	1	4	localIOException	java.io.IOException
    //   81	205	5	localObject2	java.lang.Object
    //   94	84	6	localOptions	BitmapFactory.Options
    //   200	1	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   209	48	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   78	195	7	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   174	184	192	finally
    //   174	184	200	java/lang/OutOfMemoryError
    //   87	96	205	finally
    //   100	106	205	finally
    //   110	120	205	finally
    //   124	140	205	finally
    //   144	150	205	finally
    //   154	174	205	finally
    //   219	225	205	finally
    //   229	238	205	finally
    //   242	250	205	finally
    //   254	265	205	finally
    //   269	280	205	finally
    //   87	96	209	java/lang/OutOfMemoryError
    //   100	106	209	java/lang/OutOfMemoryError
    //   110	120	209	java/lang/OutOfMemoryError
    //   124	140	209	java/lang/OutOfMemoryError
    //   144	150	209	java/lang/OutOfMemoryError
    //   154	174	209	java/lang/OutOfMemoryError
    //   184	189	313	java/io/IOException
    //   285	290	317	java/io/IOException
    //   298	303	322	java/io/IOException
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean useDiskCache()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ProfileImgDownloader
 * JD-Core Version:    0.7.0.1
 */