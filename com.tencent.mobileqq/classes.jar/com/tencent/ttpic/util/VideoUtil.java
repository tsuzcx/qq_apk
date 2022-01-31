package com.tencent.ttpic.util;

import android.graphics.PointF;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.util.LogUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

public class VideoUtil
{
  public static final String[] GPU_GL_ONE_THREAD = { "PowerVR SGX 544MP", "Adreno (TM) 306" };
  public static final String RES_PREFIX_ASSETS = "assets://";
  public static final String RES_PREFIX_HTTP = "http://";
  public static final String RES_PREFIX_HTTPS = "https://";
  public static final String RES_PREFIX_STORAGE = "/";
  private static final String TAG = VideoUtil.class.getSimpleName();
  public static final String THREAD_NAME_MEM = "mMemThread";
  
  public static List<Float> arrayToList(float[] paramArrayOfFloat)
  {
    ArrayList localArrayList = new ArrayList();
    if (isEmpty(paramArrayOfFloat)) {}
    for (;;)
    {
      return localArrayList;
      int j = paramArrayOfFloat.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(Float.valueOf(paramArrayOfFloat[i]));
        i += 1;
      }
    }
  }
  
  public static List<Integer> arrayToList(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (isEmpty(paramArrayOfInt)) {}
    for (;;)
    {
      return localArrayList;
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
    }
  }
  
  public static int daysBetween(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new SimpleDateFormat("yyyy-MM-dd");
      paramString1 = ((SimpleDateFormat)localObject).parse(paramString1);
      paramString2 = ((SimpleDateFormat)localObject).parse(paramString2);
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTime(paramString1);
      long l = ((Calendar)localObject).getTimeInMillis();
      ((Calendar)localObject).setTime(paramString2);
      l = (((Calendar)localObject).getTimeInMillis() - l) / 86400000L;
      return (int)l;
    }
    catch (Exception paramString1)
    {
      LogUtil.e(TAG, paramString1.getMessage());
    }
    return 0;
  }
  
  public static float getFaceAngle(List<PointF> paramList)
  {
    if (isEmpty(paramList))
    {
      f1 = 0.0F;
      return f1;
    }
    PointF localPointF = (PointF)paramList.get(0);
    paramList = (PointF)paramList.get(18);
    float f1 = paramList.x - localPointF.x;
    float f2 = paramList.x - localPointF.x;
    float f3 = paramList.y - localPointF.y;
    f2 = (f1 * f2 + 0.0F * f3) / ((float)Math.sqrt(f1 * f1 + 0.0F * 0.0F) * (float)Math.sqrt(f2 * f2 + f3 * f3));
    if ((f2 < -1.0F) && (f2 > -2.0F)) {
      f1 = -1.0F;
    }
    for (;;)
    {
      f2 = (float)Math.acos(f1);
      f1 = f2;
      if (localPointF.y >= paramList.y) {
        break;
      }
      return -f2;
      f1 = f2;
      if (f2 > 1.0F)
      {
        f1 = f2;
        if (f2 < 2.0F) {
          f1 = 1.0F;
        }
      }
    }
  }
  
  public static String getRealPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.startsWith("assets://")) {
      return paramString;
    }
    return paramString.substring("assets://".length());
  }
  
  public static boolean hasHoneycomb()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean hasJellyBeanMR1()
  {
    return Build.VERSION.SDK_INT >= 17;
  }
  
  public static boolean hasJellyBeanMR2()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
  
  public static boolean hasKitKat()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public static boolean indexOutOfBounds(Collection paramCollection, int paramInt)
  {
    return (paramCollection == null) || (paramInt < 0) || (paramInt >= paramCollection.size());
  }
  
  public static boolean indexOutOfBounds(FaceStatus[] paramArrayOfFaceStatus, int paramInt)
  {
    return (paramArrayOfFaceStatus == null) || (paramInt < 0) || (paramInt >= paramArrayOfFaceStatus.length);
  }
  
  public static boolean isEmpty(Collection paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
  
  private static boolean isEmpty(float[] paramArrayOfFloat)
  {
    return (paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0);
  }
  
  private static boolean isEmpty(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt == null) || (paramArrayOfInt.length == 0);
  }
  
  public static boolean isInOneGLThreadBlackList()
  {
    boolean bool2 = false;
    Object localObject = VideoDeviceUtil.getGPUInfo().split(";");
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (localObject.length > 0)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(localObject[0]))
      {
        localObject = localObject[0].trim().toLowerCase();
        arrayOfString = GPU_GL_ONE_THREAD;
        j = arrayOfString.length;
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (((String)localObject).equals(arrayOfString[i].toLowerCase())) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static void printLength(BaseFilter paramBaseFilter)
  {
    int i = 0;
    while (paramBaseFilter != null)
    {
      i += 1;
      paramBaseFilter = paramBaseFilter.getmNextFilter();
    }
    Log.d(TAG, "[Length] filter : " + i);
  }
  
  public static void printLength(Frame paramFrame)
  {
    int i = 0;
    while ((paramFrame != null) && (paramFrame.getTextureId() != 0))
    {
      i += 1;
      paramFrame = paramFrame.nextFrame;
    }
    Log.d(TAG, "[Length] frame : " + i);
  }
  
  /* Error */
  public static String unZip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: istore_3
    //   8: iload_3
    //   9: ifeq +10 -> 19
    //   12: aconst_null
    //   13: astore_1
    //   14: ldc 2
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: new 255	java/io/File
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 256	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore_0
    //   28: aload_0
    //   29: invokevirtual 259	java/io/File:exists	()Z
    //   32: ifne +8 -> 40
    //   35: aconst_null
    //   36: astore_1
    //   37: goto -23 -> 14
    //   40: new 255	java/io/File
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 256	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore 4
    //   50: aload 4
    //   52: invokevirtual 259	java/io/File:exists	()Z
    //   55: ifne +9 -> 64
    //   58: aload 4
    //   60: invokevirtual 262	java/io/File:mkdirs	()Z
    //   63: pop
    //   64: aconst_null
    //   65: astore 7
    //   67: aconst_null
    //   68: astore 8
    //   70: aconst_null
    //   71: astore 5
    //   73: aconst_null
    //   74: astore 9
    //   76: aconst_null
    //   77: astore 6
    //   79: aconst_null
    //   80: astore 4
    //   82: new 264	java/io/FileInputStream
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 267	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   90: astore_0
    //   91: new 269	java/util/zip/ZipInputStream
    //   94: dup
    //   95: new 271	java/io/BufferedInputStream
    //   98: dup
    //   99: aload_0
    //   100: invokespecial 274	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   103: invokespecial 275	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   106: astore 5
    //   108: aconst_null
    //   109: astore 4
    //   111: aconst_null
    //   112: astore 6
    //   114: aload 8
    //   116: astore 7
    //   118: aload 5
    //   120: invokevirtual 279	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   123: astore 9
    //   125: aload 9
    //   127: ifnull +375 -> 502
    //   130: aload 9
    //   132: invokevirtual 284	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   135: astore 10
    //   137: aload 7
    //   139: astore 8
    //   141: aload 10
    //   143: ldc_w 286
    //   146: invokevirtual 289	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   149: ifne -35 -> 114
    //   152: aload 9
    //   154: invokevirtual 292	java/util/zip/ZipEntry:isDirectory	()Z
    //   157: ifeq +73 -> 230
    //   160: new 255	java/io/File
    //   163: dup
    //   164: new 219	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   171: aload_1
    //   172: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: getstatic 295	java/io/File:separator	Ljava/lang/String;
    //   178: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 10
    //   183: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokespecial 256	java/io/File:<init>	(Ljava/lang/String;)V
    //   192: astore 9
    //   194: aload 9
    //   196: invokevirtual 259	java/io/File:exists	()Z
    //   199: ifne +9 -> 208
    //   202: aload 9
    //   204: invokevirtual 262	java/io/File:mkdirs	()Z
    //   207: pop
    //   208: aload 7
    //   210: astore 8
    //   212: aload 7
    //   214: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   217: ifeq -103 -> 114
    //   220: aload 9
    //   222: invokevirtual 298	java/io/File:getPath	()Ljava/lang/String;
    //   225: astore 8
    //   227: goto -113 -> 114
    //   230: sipush 4096
    //   233: newarray byte
    //   235: astore 9
    //   237: new 255	java/io/File
    //   240: dup
    //   241: new 219	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   248: aload_1
    //   249: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: getstatic 295	java/io/File:separator	Ljava/lang/String;
    //   255: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload 10
    //   260: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokespecial 256	java/io/File:<init>	(Ljava/lang/String;)V
    //   269: astore 8
    //   271: new 300	java/io/FileOutputStream
    //   274: dup
    //   275: aload 8
    //   277: invokespecial 301	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   280: astore 8
    //   282: new 303	java/io/BufferedOutputStream
    //   285: dup
    //   286: aload 8
    //   288: sipush 4096
    //   291: invokespecial 306	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   294: astore 6
    //   296: aload 5
    //   298: aload 9
    //   300: invokevirtual 310	java/util/zip/ZipInputStream:read	([B)I
    //   303: istore_2
    //   304: iload_2
    //   305: iconst_m1
    //   306: if_icmpeq +72 -> 378
    //   309: aload 6
    //   311: aload 9
    //   313: iconst_0
    //   314: iload_2
    //   315: invokevirtual 314	java/io/BufferedOutputStream:write	([BII)V
    //   318: goto -22 -> 296
    //   321: astore 4
    //   323: aload 6
    //   325: astore 4
    //   327: aload 4
    //   329: ifnull +8 -> 337
    //   332: aload 4
    //   334: invokevirtual 317	java/io/BufferedOutputStream:close	()V
    //   337: aload 4
    //   339: astore 10
    //   341: aload 8
    //   343: astore 9
    //   345: aload 8
    //   347: ifnull +16 -> 363
    //   350: aload 8
    //   352: invokevirtual 318	java/io/FileOutputStream:close	()V
    //   355: aload 8
    //   357: astore 9
    //   359: aload 4
    //   361: astore 10
    //   363: aload 10
    //   365: astore 4
    //   367: aload 9
    //   369: astore 6
    //   371: aload 7
    //   373: astore 8
    //   375: goto -261 -> 114
    //   378: aload 6
    //   380: invokevirtual 321	java/io/BufferedOutputStream:flush	()V
    //   383: aload 6
    //   385: ifnull +8 -> 393
    //   388: aload 6
    //   390: invokevirtual 317	java/io/BufferedOutputStream:close	()V
    //   393: aload 6
    //   395: astore 10
    //   397: aload 8
    //   399: astore 9
    //   401: aload 8
    //   403: ifnull -40 -> 363
    //   406: aload 8
    //   408: invokevirtual 318	java/io/FileOutputStream:close	()V
    //   411: aload 6
    //   413: astore 10
    //   415: aload 8
    //   417: astore 9
    //   419: goto -56 -> 363
    //   422: astore 4
    //   424: aload 6
    //   426: astore 10
    //   428: aload 8
    //   430: astore 9
    //   432: goto -69 -> 363
    //   435: astore_1
    //   436: aload 6
    //   438: astore 8
    //   440: aload 4
    //   442: astore 6
    //   444: aload 6
    //   446: ifnull +8 -> 454
    //   449: aload 6
    //   451: invokevirtual 317	java/io/BufferedOutputStream:close	()V
    //   454: aload 8
    //   456: ifnull +8 -> 464
    //   459: aload 8
    //   461: invokevirtual 318	java/io/FileOutputStream:close	()V
    //   464: aload_1
    //   465: athrow
    //   466: astore_1
    //   467: aload 5
    //   469: astore_1
    //   470: aload_1
    //   471: ifnull +7 -> 478
    //   474: aload_1
    //   475: invokevirtual 322	java/util/zip/ZipInputStream:close	()V
    //   478: aload 7
    //   480: astore_1
    //   481: aload_0
    //   482: ifnull -468 -> 14
    //   485: aload_0
    //   486: invokevirtual 323	java/io/FileInputStream:close	()V
    //   489: aload 7
    //   491: astore_1
    //   492: goto -478 -> 14
    //   495: astore_0
    //   496: aload 7
    //   498: astore_1
    //   499: goto -485 -> 14
    //   502: aload 5
    //   504: ifnull +8 -> 512
    //   507: aload 5
    //   509: invokevirtual 322	java/util/zip/ZipInputStream:close	()V
    //   512: aload_0
    //   513: ifnull +7 -> 520
    //   516: aload_0
    //   517: invokevirtual 323	java/io/FileInputStream:close	()V
    //   520: aload 7
    //   522: astore_1
    //   523: goto -509 -> 14
    //   526: astore_0
    //   527: aload 7
    //   529: astore_1
    //   530: goto -516 -> 14
    //   533: astore_1
    //   534: aload 6
    //   536: astore 4
    //   538: aload 5
    //   540: astore_0
    //   541: aload 4
    //   543: ifnull +8 -> 551
    //   546: aload 4
    //   548: invokevirtual 322	java/util/zip/ZipInputStream:close	()V
    //   551: aload_0
    //   552: ifnull +7 -> 559
    //   555: aload_0
    //   556: invokevirtual 323	java/io/FileInputStream:close	()V
    //   559: aload_1
    //   560: athrow
    //   561: astore_0
    //   562: ldc 2
    //   564: monitorexit
    //   565: aload_0
    //   566: athrow
    //   567: astore_0
    //   568: goto -9 -> 559
    //   571: astore_1
    //   572: aload 6
    //   574: astore 4
    //   576: goto -35 -> 541
    //   579: astore_1
    //   580: aload 5
    //   582: astore 4
    //   584: goto -43 -> 541
    //   587: astore_1
    //   588: aload 5
    //   590: astore 4
    //   592: goto -51 -> 541
    //   595: astore_0
    //   596: aload 9
    //   598: astore_0
    //   599: aload 4
    //   601: astore_1
    //   602: goto -132 -> 470
    //   605: astore_1
    //   606: aload 4
    //   608: astore_1
    //   609: goto -139 -> 470
    //   612: astore_1
    //   613: aload 5
    //   615: astore_1
    //   616: goto -146 -> 470
    //   619: astore 4
    //   621: goto -157 -> 464
    //   624: astore_1
    //   625: aload 4
    //   627: astore 6
    //   629: goto -185 -> 444
    //   632: astore_1
    //   633: goto -189 -> 444
    //   636: astore 6
    //   638: aload 4
    //   640: astore 10
    //   642: aload 8
    //   644: astore 9
    //   646: goto -283 -> 363
    //   649: astore 8
    //   651: aload 6
    //   653: astore 8
    //   655: goto -328 -> 327
    //   658: astore 6
    //   660: goto -333 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	663	0	paramString1	String
    //   0	663	1	paramString2	String
    //   303	12	2	i	int
    //   7	2	3	bool	boolean
    //   48	62	4	localFile	java.io.File
    //   321	1	4	localIOException1	java.io.IOException
    //   325	41	4	localObject1	Object
    //   422	19	4	localIOException2	java.io.IOException
    //   536	71	4	localObject2	Object
    //   619	20	4	localIOException3	java.io.IOException
    //   71	543	5	localZipInputStream	java.util.zip.ZipInputStream
    //   77	551	6	localObject3	Object
    //   636	16	6	localIOException4	java.io.IOException
    //   658	1	6	localIOException5	java.io.IOException
    //   65	463	7	localObject4	Object
    //   68	575	8	localObject5	Object
    //   649	1	8	localIOException6	java.io.IOException
    //   653	1	8	localObject6	Object
    //   74	571	9	localObject7	Object
    //   135	506	10	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   296	304	321	java/io/IOException
    //   309	318	321	java/io/IOException
    //   378	383	321	java/io/IOException
    //   388	393	422	java/io/IOException
    //   406	411	422	java/io/IOException
    //   271	282	435	finally
    //   464	466	466	java/io/IOException
    //   474	478	495	java/io/IOException
    //   485	489	495	java/io/IOException
    //   507	512	526	java/io/IOException
    //   516	520	526	java/io/IOException
    //   82	91	533	finally
    //   3	8	561	finally
    //   19	35	561	finally
    //   40	64	561	finally
    //   474	478	561	finally
    //   485	489	561	finally
    //   507	512	561	finally
    //   516	520	561	finally
    //   546	551	561	finally
    //   555	559	561	finally
    //   559	561	561	finally
    //   546	551	567	java/io/IOException
    //   555	559	567	java/io/IOException
    //   91	108	571	finally
    //   118	125	579	finally
    //   130	137	579	finally
    //   141	208	579	finally
    //   212	227	579	finally
    //   230	271	579	finally
    //   332	337	587	finally
    //   350	355	587	finally
    //   388	393	587	finally
    //   406	411	587	finally
    //   449	454	587	finally
    //   459	464	587	finally
    //   464	466	587	finally
    //   82	91	595	java/io/IOException
    //   91	108	605	java/io/IOException
    //   118	125	612	java/io/IOException
    //   130	137	612	java/io/IOException
    //   141	208	612	java/io/IOException
    //   212	227	612	java/io/IOException
    //   230	271	612	java/io/IOException
    //   449	454	619	java/io/IOException
    //   459	464	619	java/io/IOException
    //   282	296	624	finally
    //   296	304	632	finally
    //   309	318	632	finally
    //   378	383	632	finally
    //   332	337	636	java/io/IOException
    //   350	355	636	java/io/IOException
    //   271	282	649	java/io/IOException
    //   282	296	658	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoUtil
 * JD-Core Version:    0.7.0.1
 */