package com.tencent.upload.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.upload.utils.BitmapUtils;
import com.tencent.upload.utils.UploadLog;
import com.tencent.upload.utils.reflection.Reflect;
import java.io.IOException;
import java.util.HashMap;

public class ImageProcessUtil
{
  private static final String TAG = "ImageProcessUtil";
  
  /* Error */
  public static boolean bitmapToFile(Bitmap paramBitmap, String paramString1, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +26 -> 30
    //   7: ldc 25
    //   9: putstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   12: ldc 8
    //   14: getstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   17: invokestatic 36	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: getstatic 40	com/tencent/upload/image/ImageProcessService:MILESTONE	Lcom/tencent/upload/image/Milestone;
    //   23: ldc 41
    //   25: invokevirtual 47	com/tencent/upload/image/Milestone:enable	(I)V
    //   28: iconst_0
    //   29: ireturn
    //   30: new 49	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore 10
    //   40: new 54	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   47: astore_1
    //   48: aload_1
    //   49: aload 10
    //   51: invokevirtual 59	java/io/File:getParent	()Ljava/lang/String;
    //   54: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_1
    //   59: getstatic 66	java/io/File:separator	Ljava/lang/String;
    //   62: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_1
    //   67: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   70: invokevirtual 75	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_1
    //   75: ldc 77
    //   77: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_1
    //   82: aload_0
    //   83: invokevirtual 81	java/lang/Object:hashCode	()I
    //   86: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: new 49	java/io/File
    //   93: dup
    //   94: aload_1
    //   95: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: astore 11
    //   103: new 54	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   110: astore_1
    //   111: aload_1
    //   112: ldc 89
    //   114: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_1
    //   119: aload 11
    //   121: invokevirtual 92	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   124: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: ldc 8
    //   130: aload_1
    //   131: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 36	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: iload_3
    //   138: ifeq +10 -> 148
    //   141: getstatic 98	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   144: astore_1
    //   145: goto +7 -> 152
    //   148: getstatic 101	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   151: astore_1
    //   152: aload 5
    //   154: ifnull +29 -> 183
    //   157: aload 5
    //   159: ldc 103
    //   161: invokevirtual 109	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   164: ifne +13 -> 177
    //   167: aload 5
    //   169: ldc 111
    //   171: invokevirtual 109	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   174: ifeq +9 -> 183
    //   177: iconst_1
    //   178: istore 6
    //   180: goto +6 -> 186
    //   183: iconst_0
    //   184: istore 6
    //   186: getstatic 117	android/os/Build$VERSION:SDK_INT	I
    //   189: istore 7
    //   191: aconst_null
    //   192: astore 9
    //   194: aconst_null
    //   195: astore 8
    //   197: aload_1
    //   198: astore 5
    //   200: iload 7
    //   202: bipush 14
    //   204: if_icmplt +50 -> 254
    //   207: aload_1
    //   208: astore 5
    //   210: iload 6
    //   212: ifeq +42 -> 254
    //   215: aload_1
    //   216: astore 5
    //   218: iload 4
    //   220: ifeq +34 -> 254
    //   223: ldc 94
    //   225: ldc 119
    //   227: invokevirtual 125	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   230: aconst_null
    //   231: invokevirtual 131	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   234: astore 12
    //   236: aload_1
    //   237: astore 5
    //   239: aload 12
    //   241: instanceof 94
    //   244: ifeq +10 -> 254
    //   247: aload 12
    //   249: checkcast 94	android/graphics/Bitmap$CompressFormat
    //   252: astore 5
    //   254: new 54	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   261: astore_1
    //   262: aload_1
    //   263: ldc 133
    //   265: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_1
    //   270: aload 5
    //   272: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: ldc 8
    //   278: aload_1
    //   279: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 139	com/tencent/upload/utils/UploadLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload 8
    //   287: astore_1
    //   288: new 141	java/io/BufferedOutputStream
    //   291: dup
    //   292: new 143	java/io/FileOutputStream
    //   295: dup
    //   296: aload 11
    //   298: invokespecial 146	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   301: invokespecial 149	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   304: astore 8
    //   306: aload_0
    //   307: aload 5
    //   309: iload_2
    //   310: aload 8
    //   312: invokevirtual 155	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   315: istore_3
    //   316: aload 8
    //   318: invokevirtual 158	java/io/BufferedOutputStream:flush	()V
    //   321: aload 8
    //   323: invokevirtual 161	java/io/BufferedOutputStream:close	()V
    //   326: goto +167 -> 493
    //   329: astore_0
    //   330: new 54	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   337: astore_1
    //   338: aload_1
    //   339: ldc 163
    //   341: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload_1
    //   346: aload_0
    //   347: invokevirtual 166	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   350: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload_1
    //   355: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: putstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   361: ldc 8
    //   363: getstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   366: invokestatic 36	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: getstatic 40	com/tencent/upload/image/ImageProcessService:MILESTONE	Lcom/tencent/upload/image/Milestone;
    //   372: ldc 167
    //   374: invokevirtual 47	com/tencent/upload/image/Milestone:enable	(I)V
    //   377: iconst_0
    //   378: istore_3
    //   379: goto +114 -> 493
    //   382: astore_0
    //   383: aload 8
    //   385: astore_1
    //   386: goto +189 -> 575
    //   389: astore 5
    //   391: aload 8
    //   393: astore_0
    //   394: goto +12 -> 406
    //   397: astore_0
    //   398: goto +177 -> 575
    //   401: astore 5
    //   403: aload 9
    //   405: astore_0
    //   406: aload_0
    //   407: astore_1
    //   408: new 54	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   415: astore 8
    //   417: aload_0
    //   418: astore_1
    //   419: aload 8
    //   421: ldc 169
    //   423: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload_0
    //   428: astore_1
    //   429: aload 8
    //   431: aload 5
    //   433: invokevirtual 166	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   436: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: aload_0
    //   441: astore_1
    //   442: aload 8
    //   444: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: putstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   450: aload_0
    //   451: astore_1
    //   452: ldc 8
    //   454: getstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   457: invokestatic 36	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   460: aload_0
    //   461: astore_1
    //   462: getstatic 40	com/tencent/upload/image/ImageProcessService:MILESTONE	Lcom/tencent/upload/image/Milestone;
    //   465: ldc 170
    //   467: invokevirtual 47	com/tencent/upload/image/Milestone:enable	(I)V
    //   470: aload_0
    //   471: ifnull -94 -> 377
    //   474: aload_0
    //   475: invokevirtual 161	java/io/BufferedOutputStream:close	()V
    //   478: goto -101 -> 377
    //   481: astore_0
    //   482: new 54	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   489: astore_1
    //   490: goto -152 -> 338
    //   493: ldc 8
    //   495: ldc 172
    //   497: invokestatic 139	com/tencent/upload/utils/UploadLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: iload_3
    //   501: ifeq +66 -> 567
    //   504: aload 11
    //   506: aload 10
    //   508: invokevirtual 176	java/io/File:renameTo	(Ljava/io/File;)Z
    //   511: ifne +62 -> 573
    //   514: aload 11
    //   516: invokevirtual 180	java/io/File:delete	()Z
    //   519: pop
    //   520: new 54	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   527: astore_0
    //   528: aload_0
    //   529: ldc 182
    //   531: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload_0
    //   536: aload 10
    //   538: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload_0
    //   543: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: putstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   549: ldc 8
    //   551: getstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   554: invokestatic 36	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   557: getstatic 40	com/tencent/upload/image/ImageProcessService:MILESTONE	Lcom/tencent/upload/image/Milestone;
    //   560: ldc 183
    //   562: invokevirtual 47	com/tencent/upload/image/Milestone:enable	(I)V
    //   565: iconst_0
    //   566: ireturn
    //   567: aload 11
    //   569: invokevirtual 180	java/io/File:delete	()Z
    //   572: pop
    //   573: iload_3
    //   574: ireturn
    //   575: aload_1
    //   576: ifnull +62 -> 638
    //   579: aload_1
    //   580: invokevirtual 161	java/io/BufferedOutputStream:close	()V
    //   583: goto +55 -> 638
    //   586: astore_1
    //   587: new 54	java/lang/StringBuilder
    //   590: dup
    //   591: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   594: astore 5
    //   596: aload 5
    //   598: ldc 163
    //   600: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: pop
    //   604: aload 5
    //   606: aload_1
    //   607: invokevirtual 166	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   610: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload 5
    //   616: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: putstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   622: ldc 8
    //   624: getstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   627: invokestatic 36	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   630: getstatic 40	com/tencent/upload/image/ImageProcessService:MILESTONE	Lcom/tencent/upload/image/Milestone;
    //   633: ldc 167
    //   635: invokevirtual 47	com/tencent/upload/image/Milestone:enable	(I)V
    //   638: goto +5 -> 643
    //   641: aload_0
    //   642: athrow
    //   643: goto -2 -> 641
    //   646: astore 5
    //   648: aload_1
    //   649: astore 5
    //   651: goto -397 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	654	0	paramBitmap	Bitmap
    //   0	654	1	paramString1	String
    //   0	654	2	paramInt	int
    //   0	654	3	paramBoolean1	boolean
    //   0	654	4	paramBoolean2	boolean
    //   0	654	5	paramString2	String
    //   178	33	6	i	int
    //   189	16	7	j	int
    //   195	248	8	localObject1	Object
    //   192	212	9	localObject2	Object
    //   38	499	10	localFile1	java.io.File
    //   101	467	11	localFile2	java.io.File
    //   234	14	12	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   321	326	329	java/lang/Exception
    //   306	321	382	finally
    //   306	321	389	java/lang/Exception
    //   288	306	397	finally
    //   408	417	397	finally
    //   419	427	397	finally
    //   429	440	397	finally
    //   442	450	397	finally
    //   452	460	397	finally
    //   462	470	397	finally
    //   288	306	401	java/lang/Exception
    //   474	478	481	java/lang/Exception
    //   579	583	586	java/lang/Exception
    //   223	236	646	java/lang/Exception
    //   239	254	646	java/lang/Exception
  }
  
  private static int calculateRotateDegree(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      int i = paramString.getAttributeInt("Orientation", 0);
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
    catch (IOException paramString)
    {
      ImageProcessService.MILESTONE.enable(2048);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("calculateRotateDegree() EXIF_NULL ");
      localStringBuilder.append(paramString.getMessage());
      UploadLog.w("ImageProcessUtil", localStringBuilder.toString());
    }
    return 0;
  }
  
  public static String compressFile(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    ImageProcessService.MILESTONE.enable(1);
    BitmapFactory.Options localOptions = decodeBitmapOptions(paramString1);
    boolean bool = "image/png".equalsIgnoreCase(localOptions.outMimeType);
    Object localObject1 = new IUploadConfig.UploadImageSize(localOptions.outWidth, localOptions.outHeight, 100);
    if ((((IUploadConfig.UploadImageSize)localObject1).width != 0) && (((IUploadConfig.UploadImageSize)localObject1).height != 0))
    {
      int j = Math.min(((IUploadConfig.UploadImageSize)localObject1).width / paramInt1, ((IUploadConfig.UploadImageSize)localObject1).height / paramInt2);
      int i = j;
      if (j < 1) {
        i = 1;
      }
      ImageProcessService.MILESTONE.enable(4);
      Object localObject3 = BitmapUtils.getOptions();
      ((BitmapFactory.Options)localObject3).inSampleSize = i;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decodeFileWithRetry sampleSize=");
      ((StringBuilder)localObject1).append(i);
      UploadLog.v("ImageProcessUtil", ((StringBuilder)localObject1).toString());
      Object localObject2 = decodeFileWithRetry(paramString1, (BitmapFactory.Options)localObject3);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        ImageProcessService.MILESTONE.enable(128);
        ImageProcessService.MILESTONE.disableAll(new int[] { 8, 16, 32, 64 });
        ((BitmapFactory.Options)localObject3).inSampleSize += 1;
        localObject1 = decodeFileWithRetry(paramString1, (BitmapFactory.Options)localObject3);
        UploadLog.i("ImageProcessUtil", "re decodeFileWithRetry");
      }
      ImageProcessService.MILESTONE.enable(256);
      if (localObject1 == null)
      {
        ImageProcessService.sMsg = "decodeFileWithRetry=null";
        UploadLog.w("ImageProcessUtil", ImageProcessService.sMsg);
        ImageProcessService.MILESTONE.enable(512);
        return null;
      }
      i = ((Bitmap)localObject1).getWidth();
      j = ((Bitmap)localObject1).getHeight();
      float f2 = paramInt1 / i;
      float f3 = paramInt2 / j;
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      f2 = f3;
      if (f3 > 1.0F) {
        f2 = 1.0F;
      }
      localObject2 = new Matrix();
      ((Matrix)localObject2).postScale(f1, f2);
      if (paramBoolean1)
      {
        ImageProcessService.MILESTONE.enable(1024);
        int k = calculateRotateDegree(paramString1);
        if (k != 0)
        {
          ((Matrix)localObject2).postRotate(k, paramInt1 / 2, paramInt2 / 2);
          ImageProcessService.MILESTONE.enable(4096);
        }
      }
      if ((bool) && (isAlphaChanelOpen(paramString1))) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      localObject3 = transformBitmap((Bitmap)localObject1, i, j, (Matrix)localObject2);
      ImageProcessService.MILESTONE.enable(262144);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        ImageProcessService.MILESTONE.enable(524288);
        localObject2 = localObject1;
      }
      if (localObject2 != localObject1) {
        ((Bitmap)localObject1).recycle();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("transformBitmap scaleWidth=");
      ((StringBuilder)localObject1).append(f1);
      ((StringBuilder)localObject1).append(" scaleHeight=");
      ((StringBuilder)localObject1).append(f2);
      UploadLog.v("ImageProcessUtil", ((StringBuilder)localObject1).toString());
      paramBoolean1 = bitmapToFile((Bitmap)localObject2, paramString2, paramInt3, paramBoolean1, paramBoolean2, localOptions.outMimeType);
      ((Bitmap)localObject2).recycle();
      if (paramBoolean1)
      {
        ImageProcessService.MILESTONE.enable(8388608);
        copyAllExif(paramString1, paramString2);
        return paramString2;
      }
      ImageProcessService.sMsg = "bitmapToFile=false";
      UploadLog.w("ImageProcessUtil", ImageProcessService.sMsg);
      ImageProcessService.MILESTONE.enable(16777216);
      return null;
    }
    ImageProcessService.MILESTONE.enable(2);
    ImageProcessService.sMsg = "decodeBitmapSize=0";
    UploadLog.w("ImageProcessUtil", ImageProcessService.sMsg);
    return null;
  }
  
  public static void copyAllExif(String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString2 = new ExifInterface(paramString2);
        paramString1 = new ExifInterface(paramString1);
        if (Build.VERSION.SDK_INT >= 24) {
          Reflect.on(paramString2).set("mExifByteOrder", Reflect.on(paramString1).get("mExifByteOrder"));
        }
        boolean bool = Reflect.on(paramString1).get("mAttributes").getClass().isArray();
        int k = 0;
        if (bool)
        {
          paramString1 = (HashMap[])Reflect.on(paramString1).get("mAttributes");
          Reflect.on(paramString2).set("mAttributes", paramString1);
          paramString2.setAttribute("Orientation", String.valueOf(0));
          i = 0;
          int j = k;
          if (i < paramString1.length)
          {
            if (paramString1[i].get("DateTime") == null) {
              break label257;
            }
            j = 1;
          }
          if (j == 0) {
            paramString2.setAttribute("DateTime", "00000");
          }
        }
        else
        {
          paramString1 = (HashMap)Reflect.on(paramString1).get("mAttributes");
          Reflect.on(paramString2).set("mAttributes", paramString1);
          paramString2.setAttribute("Orientation", String.valueOf(0));
          if (TextUtils.isEmpty((CharSequence)paramString1.get("DateTime"))) {
            paramString2.setAttribute("DateTime", "00000");
          }
        }
        paramString2.saveAttributes();
        return;
      }
      catch (Throwable paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("exif copy failed!!,e:");
        paramString2.append(Log.getStackTraceString(paramString1));
        UploadLog.e("ImageProcessUtil", paramString2.toString());
        return;
      }
      label257:
      i += 1;
    }
  }
  
  /* Error */
  public static BitmapFactory.Options decodeBitmapOptions(String paramString)
  {
    // Byte code:
    //   0: invokestatic 241	com/tencent/upload/utils/BitmapUtils:getOptions	()Landroid/graphics/BitmapFactory$Options;
    //   3: astore 4
    //   5: aload 4
    //   7: iconst_1
    //   8: putfield 374	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   11: aconst_null
    //   12: astore_3
    //   13: aconst_null
    //   14: astore_1
    //   15: new 376	java/io/BufferedInputStream
    //   18: dup
    //   19: new 378	java/io/FileInputStream
    //   22: dup
    //   23: new 49	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: invokespecial 379	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: sipush 8192
    //   37: invokespecial 382	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   40: astore_0
    //   41: aload_0
    //   42: aconst_null
    //   43: aload 4
    //   45: invokestatic 388	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   48: pop
    //   49: aload_0
    //   50: invokevirtual 389	java/io/BufferedInputStream:close	()V
    //   53: aload_0
    //   54: invokevirtual 389	java/io/BufferedInputStream:close	()V
    //   57: aload 4
    //   59: areturn
    //   60: astore_2
    //   61: aload_0
    //   62: astore_1
    //   63: aload_2
    //   64: astore_0
    //   65: goto +44 -> 109
    //   68: astore_2
    //   69: goto +10 -> 79
    //   72: astore_0
    //   73: goto +36 -> 109
    //   76: astore_2
    //   77: aload_3
    //   78: astore_0
    //   79: aload_0
    //   80: astore_1
    //   81: ldc 8
    //   83: ldc_w 391
    //   86: aload_2
    //   87: invokestatic 394	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: aload_0
    //   91: ifnull +15 -> 106
    //   94: aload_0
    //   95: invokevirtual 389	java/io/BufferedInputStream:close	()V
    //   98: aload 4
    //   100: areturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 397	java/lang/Exception:printStackTrace	()V
    //   106: aload 4
    //   108: areturn
    //   109: aload_1
    //   110: ifnull +15 -> 125
    //   113: aload_1
    //   114: invokevirtual 389	java/io/BufferedInputStream:close	()V
    //   117: goto +8 -> 125
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 397	java/lang/Exception:printStackTrace	()V
    //   125: aload_0
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramString	String
    //   14	100	1	str	String
    //   120	2	1	localException	java.lang.Exception
    //   60	4	2	localObject1	Object
    //   68	1	2	localThrowable1	Throwable
    //   76	11	2	localThrowable2	Throwable
    //   12	66	3	localObject2	Object
    //   3	104	4	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   41	53	60	finally
    //   41	53	68	java/lang/Throwable
    //   15	41	72	finally
    //   81	90	72	finally
    //   15	41	76	java/lang/Throwable
    //   53	57	101	java/lang/Exception
    //   94	98	101	java/lang/Exception
    //   113	117	120	java/lang/Exception
  }
  
  public static IUploadConfig.UploadImageSize decodeBitmapSize(String paramString)
  {
    paramString = decodeBitmapOptions(paramString);
    return new IUploadConfig.UploadImageSize(paramString.outWidth, paramString.outHeight, 100);
  }
  
  public static Bitmap decodeFileWithRetry(String paramString, BitmapFactory.Options paramOptions)
  {
    ImageProcessService.MILESTONE.enable(8);
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label16:
      break label16;
    }
    ImageProcessService.sMsg = "decodeFile=oom";
    UploadLog.w("ImageProcessUtil", ImageProcessService.sMsg);
    ImageProcessService.MILESTONE.enable(16);
    System.gc();
    System.gc();
    try
    {
      Thread.sleep(1000L);
    }
    catch (InterruptedException localInterruptedException)
    {
      UploadLog.e("ImageProcessUtil", "decodeFileWithRetry", localInterruptedException);
    }
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, paramOptions);
    }
    catch (OutOfMemoryError paramString)
    {
      label79:
      label81:
      break label79;
    }
    try
    {
      ImageProcessService.MILESTONE.enable(32);
      return paramString;
    }
    catch (OutOfMemoryError paramOptions)
    {
      break label81;
    }
    paramString = null;
    ImageProcessService.sMsg = "decodeFile2=oom";
    UploadLog.w("ImageProcessUtil", ImageProcessService.sMsg);
    ImageProcessService.MILESTONE.enable(64);
    System.gc();
    System.gc();
    try
    {
      Thread.sleep(1000L);
      return paramString;
    }
    catch (InterruptedException paramOptions)
    {
      UploadLog.e("ImageProcessUtil", "decodeFileWithRetry", paramOptions);
      return paramString;
    }
  }
  
  public static boolean isAlphaChanelOpen(String paramString)
  {
    return new PNGReader().isTransparentPng(paramString);
  }
  
  public static Bitmap transformBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, Matrix paramMatrix)
  {
    ImageProcessService.MILESTONE.enable(8192);
    Bitmap localBitmap;
    try
    {
      localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt1, paramInt2, paramMatrix, true);
      try
      {
        ImageProcessService.MILESTONE.enable(16384);
        return localBitmap;
      }
      catch (Throwable localThrowable1) {}
      localStringBuilder = new StringBuilder();
    }
    catch (Throwable localThrowable2)
    {
      localBitmap = null;
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("createBitmap=oom");
    localStringBuilder.append(localThrowable2.toString());
    ImageProcessService.sMsg = localStringBuilder.toString();
    UploadLog.w("ImageProcessUtil", ImageProcessService.sMsg);
    ImageProcessService.MILESTONE.enable(32768);
    System.gc();
    System.gc();
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt1, paramInt2, paramMatrix, true);
      localBitmap = paramBitmap;
      ImageProcessService.MILESTONE.enable(65536);
      return paramBitmap;
    }
    catch (Throwable paramBitmap)
    {
      paramMatrix = new StringBuilder();
      paramMatrix.append("createBitmap2=oom");
      paramMatrix.append(paramBitmap.toString());
      ImageProcessService.sMsg = paramMatrix.toString();
      UploadLog.w("ImageProcessUtil", ImageProcessService.sMsg);
      ImageProcessService.MILESTONE.enable(131072);
      System.gc();
    }
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.image.ImageProcessUtil
 * JD-Core Version:    0.7.0.1
 */