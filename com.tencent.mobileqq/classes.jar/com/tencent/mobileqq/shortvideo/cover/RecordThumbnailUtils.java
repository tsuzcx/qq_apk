package com.tencent.mobileqq.shortvideo.cover;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import java.io.File;

public class RecordThumbnailUtils
{
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static String a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    // Byte code:
    //   0: iload_2
    //   1: iload_3
    //   2: imul
    //   3: iconst_3
    //   4: imul
    //   5: iconst_2
    //   6: idiv
    //   7: newarray byte
    //   9: astore 11
    //   11: iload_2
    //   12: iload_3
    //   13: imul
    //   14: newarray int
    //   16: astore 12
    //   18: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +28 -> 49
    //   24: ldc 49
    //   26: iconst_2
    //   27: new 51	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   34: ldc 54
    //   36: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_1
    //   40: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: new 68	java/io/File
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore 10
    //   59: aload 10
    //   61: invokevirtual 74	java/io/File:exists	()Z
    //   64: ifeq +11 -> 75
    //   67: aload 10
    //   69: invokevirtual 77	java/io/File:isDirectory	()Z
    //   72: ifne +32 -> 104
    //   75: ldc 49
    //   77: iconst_2
    //   78: new 51	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   85: ldc 79
    //   87: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_1
    //   91: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 82	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aconst_null
    //   101: astore_1
    //   102: aload_1
    //   103: areturn
    //   104: aload 10
    //   106: invokevirtual 86	java/io/File:list	()[Ljava/lang/String;
    //   109: astore 10
    //   111: aload 10
    //   113: ifnull +9 -> 122
    //   116: aload 10
    //   118: arraylength
    //   119: ifgt +30 -> 149
    //   122: ldc 49
    //   124: iconst_2
    //   125: new 51	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   132: ldc 88
    //   134: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 82	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: aconst_null
    //   148: areturn
    //   149: aload 10
    //   151: arraylength
    //   152: istore 7
    //   154: iconst_0
    //   155: istore 6
    //   157: iload 6
    //   159: iload 7
    //   161: if_icmpge +452 -> 613
    //   164: aload 10
    //   166: iload 6
    //   168: aaload
    //   169: astore 13
    //   171: aload 13
    //   173: ldc 90
    //   175: invokevirtual 96	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   178: ifeq +62 -> 240
    //   181: new 51	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   188: aload_1
    //   189: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: getstatic 100	java/io/File:separator	Ljava/lang/String;
    //   195: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload 13
    //   200: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: astore 10
    //   208: aload 10
    //   210: ifnonnull +39 -> 249
    //   213: ldc 49
    //   215: iconst_2
    //   216: new 51	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   223: ldc 102
    //   225: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_1
    //   229: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 82	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aconst_null
    //   239: areturn
    //   240: iload 6
    //   242: iconst_1
    //   243: iadd
    //   244: istore 6
    //   246: goto -89 -> 157
    //   249: aload 10
    //   251: invokestatic 108	com/tencent/maxvideo/activity/CoverNative:openFile	(Ljava/lang/String;)J
    //   254: lstore 8
    //   256: lload 8
    //   258: lconst_0
    //   259: lcmp
    //   260: ifne +31 -> 291
    //   263: ldc 49
    //   265: iconst_2
    //   266: new 51	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   273: ldc 110
    //   275: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 10
    //   280: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 82	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aconst_null
    //   290: areturn
    //   291: lload 8
    //   293: aconst_null
    //   294: iload_0
    //   295: aload 11
    //   297: iload_2
    //   298: iload_3
    //   299: invokestatic 114	com/tencent/maxvideo/activity/CoverNative:getFrameYuv	(JLjava/lang/String;I[BII)Z
    //   302: ifne +31 -> 333
    //   305: ldc 49
    //   307: iconst_2
    //   308: new 51	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   315: ldc 116
    //   317: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload 10
    //   322: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 82	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: aconst_null
    //   332: areturn
    //   333: lload 8
    //   335: invokestatic 120	com/tencent/maxvideo/activity/CoverNative:closeFile	(J)V
    //   338: aload 12
    //   340: aload 11
    //   342: iload_2
    //   343: iload_3
    //   344: invokestatic 125	com/tencent/mobileqq/shortvideo/util/ImageUtil:a	([I[BII)V
    //   347: aload 12
    //   349: iload_2
    //   350: iload_3
    //   351: getstatic 131	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   354: invokestatic 134	android/graphics/Bitmap:createBitmap	([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   357: astore_1
    //   358: aload_1
    //   359: ifnull +211 -> 570
    //   362: aload_1
    //   363: astore 11
    //   365: iload 5
    //   367: ifeq +22 -> 389
    //   370: aload_1
    //   371: astore 11
    //   373: iload 5
    //   375: invokestatic 139	com/tencent/mobileqq/activity/richmedia/view/CameraFilterGLView:a	(I)Z
    //   378: ifne +11 -> 389
    //   381: aload_1
    //   382: iload 5
    //   384: invokestatic 141	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   387: astore 11
    //   389: new 68	java/io/File
    //   392: dup
    //   393: aload 4
    //   395: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   398: astore_1
    //   399: new 143	java/io/BufferedOutputStream
    //   402: dup
    //   403: new 145	java/io/FileOutputStream
    //   406: dup
    //   407: aload_1
    //   408: invokespecial 148	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   411: invokespecial 151	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   414: astore 10
    //   416: aload 11
    //   418: ifnull +27 -> 445
    //   421: aload 10
    //   423: astore_1
    //   424: aload 11
    //   426: getstatic 157	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   429: bipush 60
    //   431: aload 10
    //   433: invokevirtual 161	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   436: pop
    //   437: aload 10
    //   439: astore_1
    //   440: aload 10
    //   442: invokevirtual 164	java/io/BufferedOutputStream:flush	()V
    //   445: aload 4
    //   447: astore_1
    //   448: aload 10
    //   450: ifnull -348 -> 102
    //   453: aload 10
    //   455: invokevirtual 167	java/io/BufferedOutputStream:close	()V
    //   458: aload 4
    //   460: areturn
    //   461: astore_1
    //   462: aload 4
    //   464: areturn
    //   465: astore_1
    //   466: ldc 49
    //   468: iconst_2
    //   469: new 51	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   476: ldc 169
    //   478: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: aload 10
    //   483: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokestatic 82	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   492: aconst_null
    //   493: areturn
    //   494: astore 11
    //   496: aconst_null
    //   497: astore 10
    //   499: aload 10
    //   501: astore_1
    //   502: ldc 49
    //   504: iconst_2
    //   505: new 51	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   512: ldc 171
    //   514: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload 4
    //   519: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: ldc 173
    //   524: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload 11
    //   529: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   532: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   538: aconst_null
    //   539: astore_1
    //   540: aload 10
    //   542: ifnull -440 -> 102
    //   545: aload 10
    //   547: invokevirtual 167	java/io/BufferedOutputStream:close	()V
    //   550: aconst_null
    //   551: areturn
    //   552: astore_1
    //   553: aconst_null
    //   554: areturn
    //   555: astore 4
    //   557: aconst_null
    //   558: astore_1
    //   559: aload_1
    //   560: ifnull +7 -> 567
    //   563: aload_1
    //   564: invokevirtual 167	java/io/BufferedOutputStream:close	()V
    //   567: aload 4
    //   569: athrow
    //   570: ldc 49
    //   572: iconst_2
    //   573: new 51	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   580: ldc 181
    //   582: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload 10
    //   587: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokestatic 82	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   596: aload 4
    //   598: areturn
    //   599: astore_1
    //   600: goto -33 -> 567
    //   603: astore 4
    //   605: goto -46 -> 559
    //   608: astore 11
    //   610: goto -111 -> 499
    //   613: aconst_null
    //   614: astore 10
    //   616: goto -408 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	paramInt1	int
    //   0	619	1	paramString1	String
    //   0	619	2	paramInt2	int
    //   0	619	3	paramInt3	int
    //   0	619	4	paramString2	String
    //   0	619	5	paramInt4	int
    //   155	90	6	i	int
    //   152	10	7	j	int
    //   254	80	8	l	long
    //   57	558	10	localObject1	Object
    //   9	416	11	localObject2	Object
    //   494	34	11	localIOException1	java.io.IOException
    //   608	1	11	localIOException2	java.io.IOException
    //   16	332	12	arrayOfInt	int[]
    //   169	30	13	str	String
    // Exception table:
    //   from	to	target	type
    //   453	458	461	java/io/IOException
    //   347	358	465	java/lang/Throwable
    //   399	416	494	java/io/IOException
    //   545	550	552	java/io/IOException
    //   399	416	555	finally
    //   563	567	599	java/io/IOException
    //   424	437	603	finally
    //   440	445	603	finally
    //   502	538	603	finally
    //   424	437	608	java/io/IOException
    //   440	445	608	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      Object localObject = new File(paramString);
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
      {
        localObject = ((File)localObject).list();
        if (localObject != null)
        {
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            String str = localObject[i];
            if (str.endsWith(".vf")) {
              return paramString + File.separator + str;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, int paramInt3, Bitmap.Config paramConfig)
  {
    File localFile = new File(paramString);
    return a(paramString, paramInt1, paramInt2, GloableValue.b + File.separator + VidUtil.a(localFile) + ".jpg", paramInt3, paramConfig);
  }
  
  /* Error */
  public static String a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iload_1
    //   7: iload_2
    //   8: aload 5
    //   10: invokestatic 209	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   13: astore 5
    //   15: aload 5
    //   17: iload_1
    //   18: iload_2
    //   19: invokestatic 213	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:nativeGenCover	(Landroid/graphics/Bitmap;II)I
    //   22: istore 6
    //   24: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +39 -> 66
    //   30: ldc 49
    //   32: iconst_2
    //   33: new 51	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   40: ldc 215
    //   42: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload 6
    //   47: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: ldc 220
    //   52: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload 5
    //   57: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: iload 6
    //   68: ifeq +78 -> 146
    //   71: iconst_0
    //   72: aload_0
    //   73: iload_1
    //   74: iload_2
    //   75: aload_3
    //   76: iload 4
    //   78: invokestatic 222	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:a	(ILjava/lang/String;IILjava/lang/String;I)Ljava/lang/String;
    //   81: astore_0
    //   82: aload_0
    //   83: areturn
    //   84: astore_0
    //   85: ldc 49
    //   87: iconst_2
    //   88: ldc 224
    //   90: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: invokestatic 229	com/tencent/image/URLDrawable:clearMemoryCache	()V
    //   96: invokestatic 234	java/lang/System:gc	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: ldc 49
    //   104: iconst_2
    //   105: ldc 236
    //   107: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aconst_null
    //   111: areturn
    //   112: astore 9
    //   114: ldc 49
    //   116: iconst_2
    //   117: new 51	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   124: ldc 236
    //   126: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload 9
    //   131: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: iconst_m1
    //   141: istore 6
    //   143: goto -119 -> 24
    //   146: aload 5
    //   148: ifnull +205 -> 353
    //   151: iload 4
    //   153: ifeq +237 -> 390
    //   156: iload 4
    //   158: invokestatic 139	com/tencent/mobileqq/activity/richmedia/view/CameraFilterGLView:a	(I)Z
    //   161: ifne +229 -> 390
    //   164: aload 5
    //   166: iload 4
    //   168: invokestatic 141	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   171: astore 5
    //   173: new 68	java/io/File
    //   176: dup
    //   177: aload_3
    //   178: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   181: astore 9
    //   183: aload 7
    //   185: astore_0
    //   186: new 143	java/io/BufferedOutputStream
    //   189: dup
    //   190: new 145	java/io/FileOutputStream
    //   193: dup
    //   194: aload 9
    //   196: invokespecial 148	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   199: invokespecial 151	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   202: astore 7
    //   204: aload 5
    //   206: ifnull +21 -> 227
    //   209: aload 5
    //   211: getstatic 157	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   214: bipush 60
    //   216: aload 7
    //   218: invokevirtual 161	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   221: pop
    //   222: aload 7
    //   224: invokevirtual 164	java/io/BufferedOutputStream:flush	()V
    //   227: aload 7
    //   229: ifnull +8 -> 237
    //   232: aload 7
    //   234: invokevirtual 167	java/io/BufferedOutputStream:close	()V
    //   237: aload_3
    //   238: astore_0
    //   239: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq -160 -> 82
    //   245: ldc 49
    //   247: iconst_2
    //   248: new 51	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   255: ldc 238
    //   257: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_3
    //   261: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc 240
    //   266: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_3
    //   270: invokestatic 244	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   273: invokevirtual 247	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   276: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aload_3
    //   283: areturn
    //   284: astore 7
    //   286: aload 8
    //   288: astore 5
    //   290: aload 5
    //   292: astore_0
    //   293: ldc 49
    //   295: iconst_2
    //   296: new 51	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   303: ldc 249
    //   305: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload 7
    //   310: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 82	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload 5
    //   321: ifnull -84 -> 237
    //   324: aload 5
    //   326: invokevirtual 167	java/io/BufferedOutputStream:close	()V
    //   329: goto -92 -> 237
    //   332: astore_0
    //   333: goto -96 -> 237
    //   336: astore 5
    //   338: aload_0
    //   339: astore_3
    //   340: aload 5
    //   342: astore_0
    //   343: aload_3
    //   344: ifnull +7 -> 351
    //   347: aload_3
    //   348: invokevirtual 167	java/io/BufferedOutputStream:close	()V
    //   351: aload_0
    //   352: athrow
    //   353: ldc 49
    //   355: iconst_2
    //   356: ldc 251
    //   358: invokestatic 82	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: goto -124 -> 237
    //   364: astore_0
    //   365: goto -128 -> 237
    //   368: astore_3
    //   369: goto -18 -> 351
    //   372: astore_0
    //   373: aload 7
    //   375: astore_3
    //   376: goto -33 -> 343
    //   379: astore_0
    //   380: aload 7
    //   382: astore 5
    //   384: aload_0
    //   385: astore 7
    //   387: goto -97 -> 290
    //   390: goto -217 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	paramString1	String
    //   0	393	1	paramInt1	int
    //   0	393	2	paramInt2	int
    //   0	393	3	paramString2	String
    //   0	393	4	paramInt3	int
    //   0	393	5	paramConfig	Bitmap.Config
    //   22	120	6	i	int
    //   1	232	7	localBufferedOutputStream	java.io.BufferedOutputStream
    //   284	97	7	localIOException	java.io.IOException
    //   385	1	7	str	String
    //   4	283	8	localObject	Object
    //   112	18	9	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   181	14	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   6	15	84	java/lang/OutOfMemoryError
    //   6	15	101	java/lang/Throwable
    //   15	24	112	java/lang/UnsatisfiedLinkError
    //   186	204	284	java/io/IOException
    //   324	329	332	java/io/IOException
    //   186	204	336	finally
    //   293	319	336	finally
    //   232	237	364	java/io/IOException
    //   347	351	368	java/io/IOException
    //   209	227	372	finally
    //   209	227	379	java/io/IOException
  }
  
  public static String b(String paramString, int paramInt1, int paramInt2, int paramInt3, Bitmap.Config paramConfig)
  {
    paramConfig = new File(paramString);
    return a(0, paramString, paramInt1, paramInt2, GloableValue.b + File.separator + VidUtil.a(paramConfig) + ".jpg", paramInt3);
  }
  
  private static native int nativeGenCover(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public static native int nativeSetLastFrameCover(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.cover.RecordThumbnailUtils
 * JD-Core Version:    0.7.0.1
 */