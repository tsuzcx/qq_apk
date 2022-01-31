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
    //   38: astore 7
    //   40: new 49	java/io/File
    //   43: dup
    //   44: new 54	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   51: aload 7
    //   53: invokevirtual 59	java/io/File:getParent	()Ljava/lang/String;
    //   56: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: getstatic 66	java/io/File:separator	Ljava/lang/String;
    //   62: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   68: invokevirtual 75	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   71: ldc 77
    //   73: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_0
    //   77: invokevirtual 81	java/lang/Object:hashCode	()I
    //   80: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: astore 8
    //   91: ldc 8
    //   93: new 54	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   100: ldc 89
    //   102: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload 8
    //   107: invokevirtual 92	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   110: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 36	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: iload_3
    //   120: ifeq +236 -> 356
    //   123: getstatic 98	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   126: astore_1
    //   127: aload 5
    //   129: ifnull +234 -> 363
    //   132: aload 5
    //   134: ldc 100
    //   136: invokevirtual 106	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   139: ifne +13 -> 152
    //   142: aload 5
    //   144: ldc 108
    //   146: invokevirtual 106	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   149: ifeq +214 -> 363
    //   152: iconst_1
    //   153: istore 6
    //   155: aload_1
    //   156: astore 5
    //   158: getstatic 114	android/os/Build$VERSION:SDK_INT	I
    //   161: bipush 14
    //   163: if_icmplt +53 -> 216
    //   166: aload_1
    //   167: astore 5
    //   169: iload 6
    //   171: ifeq +45 -> 216
    //   174: aload_1
    //   175: astore 5
    //   177: iload 4
    //   179: ifeq +37 -> 216
    //   182: ldc 94
    //   184: ldc 116
    //   186: invokevirtual 122	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   189: aconst_null
    //   190: invokevirtual 128	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   193: astore 5
    //   195: aload 5
    //   197: instanceof 94
    //   200: ifeq +424 -> 624
    //   203: aload 5
    //   205: checkcast 94	android/graphics/Bitmap$CompressFormat
    //   208: astore 5
    //   210: aload 5
    //   212: astore_1
    //   213: aload_1
    //   214: astore 5
    //   216: ldc 8
    //   218: new 54	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   225: ldc 130
    //   227: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload 5
    //   232: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 136	com/tencent/upload/utils/UploadLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: new 138	java/io/BufferedOutputStream
    //   244: dup
    //   245: new 140	java/io/FileOutputStream
    //   248: dup
    //   249: aload 8
    //   251: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   254: invokespecial 146	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   257: astore_1
    //   258: aload_0
    //   259: aload 5
    //   261: iload_2
    //   262: aload_1
    //   263: invokevirtual 152	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   266: istore 4
    //   268: aload_1
    //   269: invokevirtual 155	java/io/BufferedOutputStream:flush	()V
    //   272: iload 4
    //   274: istore_3
    //   275: aload_1
    //   276: ifnull +10 -> 286
    //   279: aload_1
    //   280: invokevirtual 158	java/io/BufferedOutputStream:close	()V
    //   283: iload 4
    //   285: istore_3
    //   286: ldc 8
    //   288: ldc 160
    //   290: invokestatic 136	com/tencent/upload/utils/UploadLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: iload_3
    //   294: ifeq +284 -> 578
    //   297: aload 8
    //   299: aload 7
    //   301: invokevirtual 164	java/io/File:renameTo	(Ljava/io/File;)Z
    //   304: ifne +50 -> 354
    //   307: aload 8
    //   309: invokevirtual 168	java/io/File:delete	()Z
    //   312: pop
    //   313: new 54	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   320: ldc 170
    //   322: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload 7
    //   327: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: putstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   336: ldc 8
    //   338: getstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   341: invokestatic 36	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: getstatic 40	com/tencent/upload/image/ImageProcessService:MILESTONE	Lcom/tencent/upload/image/Milestone;
    //   347: ldc 171
    //   349: invokevirtual 47	com/tencent/upload/image/Milestone:enable	(I)V
    //   352: iconst_0
    //   353: istore_3
    //   354: iload_3
    //   355: ireturn
    //   356: getstatic 174	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   359: astore_1
    //   360: goto -233 -> 127
    //   363: iconst_0
    //   364: istore 6
    //   366: goto -211 -> 155
    //   369: astore_0
    //   370: new 54	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   377: ldc 176
    //   379: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_0
    //   383: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   386: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: putstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   395: ldc 8
    //   397: getstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   400: invokestatic 36	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: getstatic 40	com/tencent/upload/image/ImageProcessService:MILESTONE	Lcom/tencent/upload/image/Milestone;
    //   406: ldc 180
    //   408: invokevirtual 47	com/tencent/upload/image/Milestone:enable	(I)V
    //   411: iconst_0
    //   412: istore_3
    //   413: goto -127 -> 286
    //   416: astore_1
    //   417: aconst_null
    //   418: astore_0
    //   419: new 54	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   426: ldc 182
    //   428: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aload_1
    //   432: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   435: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: putstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   444: ldc 8
    //   446: getstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   449: invokestatic 36	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: getstatic 40	com/tencent/upload/image/ImageProcessService:MILESTONE	Lcom/tencent/upload/image/Milestone;
    //   455: ldc 183
    //   457: invokevirtual 47	com/tencent/upload/image/Milestone:enable	(I)V
    //   460: aload_0
    //   461: ifnull +158 -> 619
    //   464: aload_0
    //   465: invokevirtual 158	java/io/BufferedOutputStream:close	()V
    //   468: iconst_0
    //   469: istore_3
    //   470: goto -184 -> 286
    //   473: astore_0
    //   474: new 54	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   481: ldc 176
    //   483: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload_0
    //   487: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   490: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: putstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   499: ldc 8
    //   501: getstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   504: invokestatic 36	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: getstatic 40	com/tencent/upload/image/ImageProcessService:MILESTONE	Lcom/tencent/upload/image/Milestone;
    //   510: ldc 180
    //   512: invokevirtual 47	com/tencent/upload/image/Milestone:enable	(I)V
    //   515: iconst_0
    //   516: istore_3
    //   517: goto -231 -> 286
    //   520: astore_1
    //   521: aconst_null
    //   522: astore_0
    //   523: aload_0
    //   524: ifnull +7 -> 531
    //   527: aload_0
    //   528: invokevirtual 158	java/io/BufferedOutputStream:close	()V
    //   531: aload_1
    //   532: athrow
    //   533: astore_0
    //   534: new 54	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   541: ldc 176
    //   543: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: aload_0
    //   547: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   550: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: putstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   559: ldc 8
    //   561: getstatic 30	com/tencent/upload/image/ImageProcessService:sMsg	Ljava/lang/String;
    //   564: invokestatic 36	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   567: getstatic 40	com/tencent/upload/image/ImageProcessService:MILESTONE	Lcom/tencent/upload/image/Milestone;
    //   570: ldc 180
    //   572: invokevirtual 47	com/tencent/upload/image/Milestone:enable	(I)V
    //   575: goto -44 -> 531
    //   578: aload 8
    //   580: invokevirtual 168	java/io/File:delete	()Z
    //   583: pop
    //   584: goto -230 -> 354
    //   587: astore 5
    //   589: aload_1
    //   590: astore_0
    //   591: aload 5
    //   593: astore_1
    //   594: goto -71 -> 523
    //   597: astore_1
    //   598: goto -75 -> 523
    //   601: astore 5
    //   603: aload_1
    //   604: astore_0
    //   605: aload 5
    //   607: astore_1
    //   608: goto -189 -> 419
    //   611: astore 5
    //   613: aload_1
    //   614: astore 5
    //   616: goto -400 -> 216
    //   619: iconst_0
    //   620: istore_3
    //   621: goto -335 -> 286
    //   624: goto -411 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	627	0	paramBitmap	Bitmap
    //   0	627	1	paramString1	String
    //   0	627	2	paramInt	int
    //   0	627	3	paramBoolean1	boolean
    //   0	627	4	paramBoolean2	boolean
    //   0	627	5	paramString2	String
    //   153	212	6	i	int
    //   38	288	7	localFile1	java.io.File
    //   89	490	8	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   279	283	369	java/lang/Exception
    //   241	258	416	java/lang/Exception
    //   464	468	473	java/lang/Exception
    //   241	258	520	finally
    //   527	531	533	java/lang/Exception
    //   258	272	587	finally
    //   419	460	597	finally
    //   258	272	601	java/lang/Exception
    //   182	210	611	java/lang/Exception
  }
  
  private static int calculateRotateDegree(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      switch (paramString.getAttributeInt("Orientation", 0))
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      }
    }
    catch (IOException paramString)
    {
      ImageProcessService.MILESTONE.enable(2048);
      UploadLog.w("ImageProcessUtil", "calculateRotateDegree() EXIF_NULL " + paramString.getMessage());
      return 0;
    }
    return 90;
    return 180;
    return 270;
  }
  
  public static String compressFile(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    ImageProcessService.MILESTONE.enable(1);
    BitmapFactory.Options localOptions = decodeBitmapOptions(paramString1);
    boolean bool2 = "image/png".equalsIgnoreCase(localOptions.outMimeType);
    Object localObject1 = new IUploadConfig.UploadImageSize(localOptions.outWidth, localOptions.outHeight, 100);
    if ((((IUploadConfig.UploadImageSize)localObject1).width == 0) || (((IUploadConfig.UploadImageSize)localObject1).height == 0))
    {
      ImageProcessService.MILESTONE.enable(2);
      ImageProcessService.sMsg = "decodeBitmapSize=0";
      UploadLog.w("ImageProcessUtil", ImageProcessService.sMsg);
      return null;
    }
    int j = Math.min(((IUploadConfig.UploadImageSize)localObject1).width / paramInt1, ((IUploadConfig.UploadImageSize)localObject1).height / paramInt2);
    int i = j;
    if (j < 1) {
      i = 1;
    }
    ImageProcessService.MILESTONE.enable(4);
    Object localObject3 = BitmapUtils.getOptions();
    ((BitmapFactory.Options)localObject3).inSampleSize = i;
    UploadLog.v("ImageProcessUtil", "decodeFileWithRetry sampleSize=" + i);
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
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    if (f1 > 1.0F) {
      f1 = 1.0F;
    }
    for (;;)
    {
      if (f2 > 1.0F) {
        f2 = 1.0F;
      }
      for (;;)
      {
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
        boolean bool1 = false;
        paramBoolean1 = bool1;
        if (bool2)
        {
          paramBoolean1 = bool1;
          if (isAlphaChanelOpen(paramString1)) {
            paramBoolean1 = true;
          }
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
        UploadLog.v("ImageProcessUtil", "transformBitmap scaleWidth=" + f1 + " scaleHeight=" + f2);
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
    }
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
        if (Reflect.on(paramString1).get("mAttributes").getClass().isArray())
        {
          paramString1 = (HashMap[])Reflect.on(paramString1).get("mAttributes");
          Reflect.on(paramString2).set("mAttributes", paramString1);
          paramString2.setAttribute("Orientation", String.valueOf(0));
          i = 0;
          if (i < paramString1.length)
          {
            if (paramString1[i].get("DateTime") == null) {
              break label249;
            }
            i = 1;
            if (i == 0) {
              paramString2.setAttribute("DateTime", String.valueOf("00000"));
            }
            paramString2.saveAttributes();
          }
        }
        else
        {
          paramString1 = (HashMap)Reflect.on(paramString1).get("mAttributes");
          Reflect.on(paramString2).set("mAttributes", paramString1);
          paramString2.setAttribute("Orientation", String.valueOf(0));
          if (!TextUtils.isEmpty((CharSequence)paramString1.get("DateTime"))) {
            continue;
          }
          paramString2.setAttribute("DateTime", String.valueOf("00000"));
          continue;
        }
        i = 0;
      }
      catch (Throwable paramString1)
      {
        UploadLog.e("ImageProcessUtil", "exif copy failed!!,e:" + Log.getStackTraceString(paramString1));
        return;
      }
      continue;
      label249:
      i += 1;
    }
  }
  
  /* Error */
  public static BitmapFactory.Options decodeBitmapOptions(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 243	com/tencent/upload/utils/BitmapUtils:getOptions	()Landroid/graphics/BitmapFactory$Options;
    //   5: astore_3
    //   6: aload_3
    //   7: iconst_1
    //   8: putfield 377	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   11: new 379	java/io/BufferedInputStream
    //   14: dup
    //   15: new 381	java/io/FileInputStream
    //   18: dup
    //   19: new 49	java/io/File
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: invokespecial 382	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: sipush 8192
    //   33: invokespecial 385	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   36: astore_1
    //   37: aload_1
    //   38: astore_0
    //   39: aload_1
    //   40: aconst_null
    //   41: aload_3
    //   42: invokestatic 391	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   45: pop
    //   46: aload_1
    //   47: astore_0
    //   48: aload_1
    //   49: invokevirtual 392	java/io/BufferedInputStream:close	()V
    //   52: aload_1
    //   53: ifnull +7 -> 60
    //   56: aload_1
    //   57: invokevirtual 392	java/io/BufferedInputStream:close	()V
    //   60: aload_3
    //   61: areturn
    //   62: astore_0
    //   63: aload_0
    //   64: invokevirtual 395	java/lang/Exception:printStackTrace	()V
    //   67: aload_3
    //   68: areturn
    //   69: astore_2
    //   70: aconst_null
    //   71: astore_1
    //   72: aload_1
    //   73: astore_0
    //   74: ldc 8
    //   76: ldc_w 397
    //   79: aload_2
    //   80: invokestatic 400	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: aload_1
    //   84: ifnull -24 -> 60
    //   87: aload_1
    //   88: invokevirtual 392	java/io/BufferedInputStream:close	()V
    //   91: aload_3
    //   92: areturn
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 395	java/lang/Exception:printStackTrace	()V
    //   98: aload_3
    //   99: areturn
    //   100: astore_0
    //   101: aload_2
    //   102: astore_1
    //   103: aload_1
    //   104: ifnull +7 -> 111
    //   107: aload_1
    //   108: invokevirtual 392	java/io/BufferedInputStream:close	()V
    //   111: aload_0
    //   112: athrow
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 395	java/lang/Exception:printStackTrace	()V
    //   118: goto -7 -> 111
    //   121: astore_2
    //   122: aload_0
    //   123: astore_1
    //   124: aload_2
    //   125: astore_0
    //   126: goto -23 -> 103
    //   129: astore_2
    //   130: goto -58 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramString	String
    //   36	72	1	localObject1	Object
    //   113	2	1	localException	java.lang.Exception
    //   123	1	1	str	String
    //   1	1	2	localObject2	Object
    //   69	33	2	localThrowable1	Throwable
    //   121	4	2	localObject3	Object
    //   129	1	2	localThrowable2	Throwable
    //   5	94	3	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   56	60	62	java/lang/Exception
    //   11	37	69	java/lang/Throwable
    //   87	91	93	java/lang/Exception
    //   11	37	100	finally
    //   107	111	113	java/lang/Exception
    //   39	46	121	finally
    //   48	52	121	finally
    //   74	83	121	finally
    //   39	46	129	java/lang/Throwable
    //   48	52	129	java/lang/Throwable
  }
  
  public static IUploadConfig.UploadImageSize decodeBitmapSize(String paramString)
  {
    paramString = decodeBitmapOptions(paramString);
    return new IUploadConfig.UploadImageSize(paramString.outWidth, paramString.outHeight, 100);
  }
  
  public static Bitmap decodeFileWithRetry(String paramString, BitmapFactory.Options paramOptions)
  {
    ImageProcessService.MILESTONE.enable(8);
    String str = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ImageProcessService.sMsg = "decodeFile=oom";
      UploadLog.w("ImageProcessUtil", ImageProcessService.sMsg);
      ImageProcessService.MILESTONE.enable(16);
      System.gc();
      System.gc();
    }
    try
    {
      Thread.sleep(1000L);
      try
      {
        paramString = BitmapFactory.decodeFile(paramString, paramOptions);
        str = paramString;
        ImageProcessService.MILESTONE.enable(32);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        ImageProcessService.sMsg = "decodeFile2=oom";
        UploadLog.w("ImageProcessUtil", ImageProcessService.sMsg);
        ImageProcessService.MILESTONE.enable(64);
        System.gc();
        System.gc();
        try
        {
          Thread.sleep(1000L);
          return str;
        }
        catch (InterruptedException paramString)
        {
          UploadLog.e("ImageProcessUtil", "decodeFileWithRetry", paramString);
          return str;
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        UploadLog.e("ImageProcessUtil", "decodeFileWithRetry", localInterruptedException);
      }
    }
  }
  
  public static boolean isAlphaChanelOpen(String paramString)
  {
    return new PNGReader().isTransparentPng(paramString);
  }
  
  public static Bitmap transformBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, Matrix paramMatrix)
  {
    ImageProcessService.MILESTONE.enable(8192);
    Object localObject1 = null;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt1, paramInt2, paramMatrix, true);
      ImageProcessService.sMsg = "createBitmap=oom" + localThrowable2.toString();
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        ImageProcessService.MILESTONE.enable(16384);
        return localBitmap;
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          Object localObject2 = localThrowable2;
          Object localObject3 = localThrowable3;
        }
      }
      localThrowable2 = localThrowable2;
    }
    UploadLog.w("ImageProcessUtil", ImageProcessService.sMsg);
    ImageProcessService.MILESTONE.enable(32768);
    System.gc();
    System.gc();
    for (;;)
    {
      try
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt1, paramInt2, paramMatrix, true);
      }
      catch (Throwable paramBitmap)
      {
        paramMatrix = localThrowable1;
        localObject2 = paramBitmap;
        continue;
      }
      try
      {
        ImageProcessService.MILESTONE.enable(65536);
        return paramBitmap;
      }
      catch (Throwable localThrowable1)
      {
        paramMatrix = paramBitmap;
        ImageProcessService.sMsg = "createBitmap2=oom" + localThrowable1.toString();
        UploadLog.w("ImageProcessUtil", ImageProcessService.sMsg);
        ImageProcessService.MILESTONE.enable(131072);
        System.gc();
        return paramMatrix;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.image.ImageProcessUtil
 * JD-Core Version:    0.7.0.1
 */