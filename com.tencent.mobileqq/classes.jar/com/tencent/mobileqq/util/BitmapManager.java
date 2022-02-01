package com.tencent.mobileqq.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build;
import com.tencent.image.SafeBitmapFactory;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BitmapManager
{
  private static Map<String, BitmapManager.MonitorReference<Bitmap>> a = Collections.synchronizedMap(new HashMap());
  private static ReferenceQueue<Bitmap> b = new ReferenceQueue();
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    if ((i <= paramInt2) && (j <= paramInt1)) {
      return 1;
    }
    if (j > i) {
      return Math.round(i / paramInt2);
    }
    return Math.round(j / paramInt1);
  }
  
  public static Bitmap a(Resources paramResources, int paramInt)
  {
    a();
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    try
    {
      localObject = new BitmapFactory.Options();
      if ((("Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.MODEL.toUpperCase().startsWith("MI 2"))) || (("BBK".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.MODEL.toUpperCase().startsWith("VIVO")))) {
        ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
      } else {
        ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      }
      localBitmapDecodeResult.a = BitmapFactory.decodeResource(paramResources, paramInt, (BitmapFactory.Options)localObject);
    }
    catch (OutOfMemoryError paramResources)
    {
      Object localObject;
      break label107;
    }
    catch (Throwable paramResources)
    {
      label99:
      break label99;
    }
    localBitmapDecodeResult.b = 3;
    break label112;
    label107:
    localBitmapDecodeResult.b = 1;
    label112:
    if (localBitmapDecodeResult.a != null)
    {
      localBitmapDecodeResult.b = 0;
      paramResources = String.valueOf(localBitmapDecodeResult.a.hashCode());
      localObject = new BitmapManager.MonitorReference(paramResources, localBitmapDecodeResult.a, b);
      a.put(paramResources, localObject);
    }
    return localBitmapDecodeResult.a;
  }
  
  public static Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, paramInt2, paramInt3);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    paramResources = BitmapFactory.decodeResource(paramResources, paramInt1, (BitmapFactory.Options)localObject);
    if (paramResources != null)
    {
      localObject = String.valueOf(paramResources.hashCode());
      BitmapManager.MonitorReference localMonitorReference = new BitmapManager.MonitorReference((String)localObject, paramResources, b);
      a.put(localObject, localMonitorReference);
    }
    return paramResources;
  }
  
  public static Bitmap a(InputStream paramInputStream, Rect paramRect, int paramInt1, int paramInt2)
  {
    
    if (paramInputStream.markSupported()) {
      paramInputStream.mark(8092);
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
    SafeBitmapFactory.decodeStream(paramInputStream, paramRect, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, paramInt1, paramInt2);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    try
    {
      paramInputStream.reset();
      paramInputStream = SafeBitmapFactory.decodeStream(paramInputStream, paramRect, (BitmapFactory.Options)localObject);
      if (paramInputStream != null)
      {
        paramRect = String.valueOf(paramInputStream.hashCode());
        localObject = new BitmapManager.MonitorReference(paramRect, paramInputStream, b);
        a.put(paramRect, localObject);
      }
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
    return null;
  }
  
  public static Bitmap a(String paramString)
  {
    return a(paramString, null);
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    a();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, paramInt1, paramInt2);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    paramString = SafeBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    if (paramString != null)
    {
      localObject = String.valueOf(paramString.hashCode());
      BitmapManager.MonitorReference localMonitorReference = new BitmapManager.MonitorReference((String)localObject, paramString, b);
      a.put(localObject, localMonitorReference);
    }
    return paramString;
  }
  
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    a(paramString, paramOptions, localBitmapDecodeResult);
    return localBitmapDecodeResult.a;
  }
  
  public static Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a();
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      if (("Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.MODEL.toUpperCase().startsWith("MI 2"))) {
        localObject = Bitmap.Config.ARGB_8888;
      } else {
        localObject = Bitmap.Config.RGB_565;
      }
      localOptions.inPreferredConfig = ((Bitmap.Config)localObject);
      localBitmapDecodeResult.a = SafeBitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, localOptions);
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      Object localObject;
      break label88;
    }
    catch (Throwable paramArrayOfByte)
    {
      label79:
      break label79;
    }
    localBitmapDecodeResult.b = 3;
    break label94;
    label88:
    localBitmapDecodeResult.b = 1;
    label94:
    if (localBitmapDecodeResult.a != null)
    {
      localBitmapDecodeResult.b = 0;
      paramArrayOfByte = String.valueOf(localBitmapDecodeResult.a.hashCode());
      localObject = new BitmapManager.MonitorReference(paramArrayOfByte, localBitmapDecodeResult.a, b);
      a.put(paramArrayOfByte, localObject);
    }
    return localBitmapDecodeResult.a;
  }
  
  private static void a()
  {
    for (;;)
    {
      BitmapManager.MonitorReference localMonitorReference = (BitmapManager.MonitorReference)b.poll();
      if (localMonitorReference == null) {
        break;
      }
      a.remove(BitmapManager.MonitorReference.a(localMonitorReference));
    }
  }
  
  /* Error */
  public static void a(String paramString, BitmapFactory.Options paramOptions, BitmapManager.BitmapDecodeResult paramBitmapDecodeResult)
  {
    // Byte code:
    //   0: invokestatic 55	com/tencent/mobileqq/util/BitmapManager:a	()V
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 9
    //   15: aconst_null
    //   16: astore 10
    //   18: aconst_null
    //   19: astore 11
    //   21: aconst_null
    //   22: astore 12
    //   24: aconst_null
    //   25: astore 5
    //   27: new 197	java/io/File
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 200	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 13
    //   37: aload 13
    //   39: invokevirtual 203	java/io/File:exists	()Z
    //   42: ifne +9 -> 51
    //   45: aload_2
    //   46: iconst_2
    //   47: putfield 112	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:b	I
    //   50: return
    //   51: new 205	java/io/BufferedInputStream
    //   54: dup
    //   55: new 207	java/io/FileInputStream
    //   58: dup
    //   59: aload 13
    //   61: invokespecial 210	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: invokespecial 213	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: astore 4
    //   69: aload 5
    //   71: astore 6
    //   73: aload 10
    //   75: astore 7
    //   77: aload 11
    //   79: astore 8
    //   81: aload 12
    //   83: astore 9
    //   85: aload 13
    //   87: invokevirtual 217	java/io/File:length	()J
    //   90: l2i
    //   91: istore_3
    //   92: aload 5
    //   94: astore 6
    //   96: aload 10
    //   98: astore 7
    //   100: aload 11
    //   102: astore 8
    //   104: aload 12
    //   106: astore 9
    //   108: invokestatic 223	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   111: iload_3
    //   112: invokevirtual 227	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   115: astore 5
    //   117: aload 5
    //   119: astore 6
    //   121: aload 5
    //   123: astore 7
    //   125: aload 5
    //   127: astore 8
    //   129: aload 5
    //   131: astore 9
    //   133: iload_3
    //   134: aload 4
    //   136: aload 5
    //   138: invokevirtual 231	java/io/InputStream:read	([B)I
    //   141: if_icmpeq +43 -> 184
    //   144: aload 5
    //   146: astore 6
    //   148: aload 5
    //   150: astore 7
    //   152: aload 5
    //   154: astore 8
    //   156: aload 5
    //   158: astore 9
    //   160: aload_2
    //   161: iconst_3
    //   162: putfield 112	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:b	I
    //   165: aload 4
    //   167: invokevirtual 234	java/io/InputStream:close	()V
    //   170: aload 5
    //   172: ifnull +11 -> 183
    //   175: invokestatic 223	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   178: aload 5
    //   180: invokevirtual 238	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   183: return
    //   184: aload 5
    //   186: astore 6
    //   188: aload 5
    //   190: astore 7
    //   192: aload 5
    //   194: astore 8
    //   196: aload 5
    //   198: astore 9
    //   200: aload_2
    //   201: aload 5
    //   203: iconst_0
    //   204: aload 5
    //   206: arraylength
    //   207: aload_1
    //   208: invokestatic 182	com/tencent/image/SafeBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   211: putfield 110	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:a	Landroid/graphics/Bitmap;
    //   214: aload 4
    //   216: invokevirtual 234	java/io/InputStream:close	()V
    //   219: aload 5
    //   221: ifnull +205 -> 426
    //   224: invokestatic 223	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   227: aload 5
    //   229: invokevirtual 238	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   232: goto +194 -> 426
    //   235: astore_0
    //   236: aload 4
    //   238: astore_1
    //   239: aload 6
    //   241: astore 4
    //   243: goto +224 -> 467
    //   246: aload 9
    //   248: astore 5
    //   250: aload 4
    //   252: astore 6
    //   254: goto +38 -> 292
    //   257: aload 8
    //   259: astore 5
    //   261: aload 4
    //   263: astore 6
    //   265: goto +75 -> 340
    //   268: aload 7
    //   270: astore 5
    //   272: aload 4
    //   274: astore 6
    //   276: goto +112 -> 388
    //   279: astore_0
    //   280: aconst_null
    //   281: astore 4
    //   283: aload 9
    //   285: astore_1
    //   286: goto +181 -> 467
    //   289: aconst_null
    //   290: astore 5
    //   292: aload 6
    //   294: astore_1
    //   295: aload 5
    //   297: astore 4
    //   299: aload_2
    //   300: iconst_3
    //   301: putfield 112	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:b	I
    //   304: aload 6
    //   306: ifnull +11 -> 317
    //   309: aload 6
    //   311: invokevirtual 234	java/io/InputStream:close	()V
    //   314: goto +3 -> 317
    //   317: aload 5
    //   319: ifnull +107 -> 426
    //   322: invokestatic 223	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   325: aload 5
    //   327: invokevirtual 238	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   330: goto +96 -> 426
    //   333: aconst_null
    //   334: astore 5
    //   336: aload 7
    //   338: astore 6
    //   340: aload 6
    //   342: astore_1
    //   343: aload 5
    //   345: astore 4
    //   347: aload_2
    //   348: iconst_1
    //   349: putfield 112	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:b	I
    //   352: aload 6
    //   354: ifnull +11 -> 365
    //   357: aload 6
    //   359: invokevirtual 234	java/io/InputStream:close	()V
    //   362: goto +3 -> 365
    //   365: aload 5
    //   367: ifnull +59 -> 426
    //   370: invokestatic 223	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   373: aload 5
    //   375: invokevirtual 238	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   378: goto +48 -> 426
    //   381: aconst_null
    //   382: astore 5
    //   384: aload 8
    //   386: astore 6
    //   388: aload 6
    //   390: astore_1
    //   391: aload 5
    //   393: astore 4
    //   395: aload_2
    //   396: iconst_2
    //   397: putfield 112	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:b	I
    //   400: aload 6
    //   402: ifnull +11 -> 413
    //   405: aload 6
    //   407: invokevirtual 234	java/io/InputStream:close	()V
    //   410: goto +3 -> 413
    //   413: aload 5
    //   415: ifnull +11 -> 426
    //   418: invokestatic 223	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   421: aload 5
    //   423: invokevirtual 238	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   426: aload_2
    //   427: getfield 110	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:a	Landroid/graphics/Bitmap;
    //   430: ifnull +35 -> 465
    //   433: aload_2
    //   434: iconst_0
    //   435: putfield 112	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:b	I
    //   438: new 122	com/tencent/mobileqq/util/BitmapManager$MonitorReference
    //   441: dup
    //   442: aload_0
    //   443: aload_2
    //   444: getfield 110	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:a	Landroid/graphics/Bitmap;
    //   447: getstatic 30	com/tencent/mobileqq/util/BitmapManager:b	Ljava/lang/ref/ReferenceQueue;
    //   450: invokespecial 125	com/tencent/mobileqq/util/BitmapManager$MonitorReference:<init>	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ref/ReferenceQueue;)V
    //   453: astore_1
    //   454: getstatic 25	com/tencent/mobileqq/util/BitmapManager:a	Ljava/util/Map;
    //   457: aload_0
    //   458: aload_1
    //   459: invokeinterface 131 3 0
    //   464: pop
    //   465: return
    //   466: astore_0
    //   467: aload_1
    //   468: ifnull +10 -> 478
    //   471: aload_1
    //   472: invokevirtual 234	java/io/InputStream:close	()V
    //   475: goto +3 -> 478
    //   478: aload 4
    //   480: ifnull +11 -> 491
    //   483: invokestatic 223	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   486: aload 4
    //   488: invokevirtual 238	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   491: aload_0
    //   492: athrow
    //   493: astore_1
    //   494: goto -113 -> 381
    //   497: astore_1
    //   498: goto -165 -> 333
    //   501: astore_1
    //   502: goto -213 -> 289
    //   505: astore_1
    //   506: goto -238 -> 268
    //   509: astore_1
    //   510: goto -253 -> 257
    //   513: astore_1
    //   514: goto -268 -> 246
    //   517: astore_0
    //   518: goto -348 -> 170
    //   521: astore_1
    //   522: goto -303 -> 219
    //   525: astore_1
    //   526: goto -209 -> 317
    //   529: astore_1
    //   530: goto -165 -> 365
    //   533: astore_1
    //   534: goto -121 -> 413
    //   537: astore_1
    //   538: goto -60 -> 478
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	541	0	paramString	String
    //   0	541	1	paramOptions	BitmapFactory.Options
    //   0	541	2	paramBitmapDecodeResult	BitmapManager.BitmapDecodeResult
    //   91	51	3	i	int
    //   67	420	4	localObject1	Object
    //   25	397	5	localObject2	Object
    //   4	402	6	localObject3	Object
    //   7	330	7	localObject4	Object
    //   10	375	8	localObject5	Object
    //   13	271	9	localObject6	Object
    //   16	81	10	localObject7	Object
    //   19	82	11	localObject8	Object
    //   22	83	12	localObject9	Object
    //   35	51	13	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   85	92	235	finally
    //   108	117	235	finally
    //   133	144	235	finally
    //   160	165	235	finally
    //   200	214	235	finally
    //   27	50	279	finally
    //   51	69	279	finally
    //   299	304	466	finally
    //   347	352	466	finally
    //   395	400	466	finally
    //   27	50	493	java/io/FileNotFoundException
    //   51	69	493	java/io/FileNotFoundException
    //   27	50	497	java/lang/OutOfMemoryError
    //   51	69	497	java/lang/OutOfMemoryError
    //   27	50	501	java/lang/Throwable
    //   51	69	501	java/lang/Throwable
    //   85	92	505	java/io/FileNotFoundException
    //   108	117	505	java/io/FileNotFoundException
    //   133	144	505	java/io/FileNotFoundException
    //   160	165	505	java/io/FileNotFoundException
    //   200	214	505	java/io/FileNotFoundException
    //   85	92	509	java/lang/OutOfMemoryError
    //   108	117	509	java/lang/OutOfMemoryError
    //   133	144	509	java/lang/OutOfMemoryError
    //   160	165	509	java/lang/OutOfMemoryError
    //   200	214	509	java/lang/OutOfMemoryError
    //   85	92	513	java/lang/Throwable
    //   108	117	513	java/lang/Throwable
    //   133	144	513	java/lang/Throwable
    //   160	165	513	java/lang/Throwable
    //   200	214	513	java/lang/Throwable
    //   165	170	517	java/io/IOException
    //   214	219	521	java/io/IOException
    //   309	314	525	java/io/IOException
    //   357	362	529	java/io/IOException
    //   405	410	533	java/io/IOException
    //   471	475	537	java/io/IOException
  }
  
  public static Bitmap b(Resources paramResources, int paramInt)
  {
    a();
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    try
    {
      localBitmapDecodeResult.a = BitmapFactory.decodeResource(paramResources, paramInt, new BitmapFactory.Options());
    }
    catch (OutOfMemoryError paramResources)
    {
      BitmapManager.MonitorReference localMonitorReference;
      break label38;
    }
    catch (Throwable paramResources)
    {
      label30:
      break label30;
    }
    localBitmapDecodeResult.b = 3;
    break label43;
    label38:
    localBitmapDecodeResult.b = 1;
    label43:
    if (localBitmapDecodeResult.a != null)
    {
      localBitmapDecodeResult.b = 0;
      paramResources = String.valueOf(localBitmapDecodeResult.a.hashCode());
      localMonitorReference = new BitmapManager.MonitorReference(paramResources, localBitmapDecodeResult.a, b);
      a.put(paramResources, localMonitorReference);
    }
    return localBitmapDecodeResult.a;
  }
  
  public static BitmapManager.BitmapDecodeResult b(String paramString, BitmapFactory.Options paramOptions)
  {
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    a(paramString, paramOptions, localBitmapDecodeResult);
    return localBitmapDecodeResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.BitmapManager
 * JD-Core Version:    0.7.0.1
 */