package com.tencent.mobileqq.shortvideo.common;

import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class GloableValue
{
  public static Context a = ;
  public static String b;
  public static long c = -1L;
  public static int d = 1;
  public static int e = 1;
  public static int f = 640;
  public static int g = 480;
  public static final int[] h = { 960, 640 };
  public static final int[] i = { 720, 480 };
  public static final int[] j = { 720, 540, 640, 480, 480, 360, 320, 240 };
  public static final int[] k = { 1, 1, 0 };
  public static final int[] l = { 1, 0, 0 };
  public static final int[] m = { 1, 1, 0 };
  public static final int[] n = { 1280, 800 };
  public static final int[] o = { 720, 480 };
  private static String p;
  private static String q;
  private static String r;
  private static String s;
  private static String t;
  
  public static void a()
  {
    try
    {
      AudioManager localAudioManager = (AudioManager)VideoEnvironment.getContext().getSystemService("audio");
      int i2 = localAudioManager.requestAudioFocus(null, 3, 2);
      int i1 = i2;
      if (i2 == 0) {
        i1 = localAudioManager.requestAudioFocus(null, 3, 1);
      }
      if (i1 == 0)
      {
        localAudioManager.requestAudioFocus(null, 3, 3);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static boolean a(long paramLong, Context paramContext)
  {
    if (paramLong <= 0L) {
      return false;
    }
    boolean bool1 = FileUtils.hasSDCardAndWritable();
    if (!bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("initDirs", 2, "hasSDCardAndWritable = false");
      }
      return bool1;
    }
    paramContext = StorageManager.a().e;
    if (TextUtils.isEmpty(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.e("initDirs", 2, "sdcardDirPath = empty");
      }
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sdcardDirPath:storeVideoPath=");
      ((StringBuilder)localObject).append(paramContext);
      QLog.e("initDirs", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new File(paramContext);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()) && (((File)localObject).canWrite()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("trimvideo");
      b = ((StringBuilder)localObject).toString();
      localObject = new File(b);
      bool1 = ((File)localObject).mkdirs();
      boolean bool2 = ((File)localObject).isDirectory();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("trimVideoFilesDirPath:mkd=");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(" isdir=");
        ((StringBuilder)localObject).append(bool2);
        QLog.e("initDirs", 2, ((StringBuilder)localObject).toString());
      }
      if ((!bool1) && (!bool2)) {
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("/Product");
      s = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("/Material");
      r = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(r);
      ((StringBuilder)localObject).append("/ProcessedMaterial");
      t = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("/log.txt");
      p = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("Source");
      q = ((StringBuilder)localObject).toString();
      paramContext = new File(q);
      bool1 = paramContext.mkdirs();
      bool2 = paramContext.isDirectory();
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("avSourceFilesDirPath:mkd=");
        paramContext.append(bool1);
        paramContext.append(" isdir=");
        paramContext.append(bool2);
        QLog.e("initDirs", 2, paramContext.toString());
      }
      return (bool1) || (bool2);
    }
    if (QLog.isColorLevel()) {
      QLog.e("initDirs", 2, "exists OR isDirectory OR canWrite = false");
    }
    return false;
  }
  
  public static boolean a(long paramLong, Context paramContext, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder;
    if (paramContext == null)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("GloableValue[init]context=");
        localStringBuilder.append(paramContext);
        QLog.e("GloableValue", 2, localStringBuilder.toString());
      }
      return false;
    }
    long l1 = c;
    if ((l1 > 0L) && ((paramLong <= 0L) || (l1 == paramLong)))
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("GloableValue[init]sUin=");
        paramContext.append(c);
        paramContext.append("uin=");
        paramContext.append(paramLong);
        QLog.e("GloableValue", 2, paramContext.toString());
      }
      return true;
    }
    c = paramLong;
    if (a(paramLong, paramContext))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append("");
      if (a(localStringBuilder.toString(), paramContext, paramInt1, paramInt2)) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public static boolean a(String paramString, Context paramContext, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 114	com/tencent/mobileqq/shortvideo/util/storage/StorageManager:a	()Lcom/tencent/mobileqq/shortvideo/util/storage/StorageManager;
    //   3: getfield 116	com/tencent/mobileqq/shortvideo/util/storage/StorageManager:e	Ljava/lang/String;
    //   6: astore 9
    //   8: new 220	com/tencent/maxvideo/common/MessageStruct
    //   11: dup
    //   12: bipush 6
    //   14: invokespecial 223	com/tencent/maxvideo/common/MessageStruct:<init>	(I)V
    //   17: astore 4
    //   19: new 126	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   26: astore 5
    //   28: aload 5
    //   30: ldc 225
    //   32: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 5
    //   38: aload_0
    //   39: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 5
    //   45: ldc 227
    //   47: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 5
    //   53: aload 9
    //   55: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 5
    //   61: ldc 229
    //   63: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 5
    //   69: getstatic 184	com/tencent/mobileqq/shortvideo/common/GloableValue:p	Ljava/lang/String;
    //   72: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 5
    //   78: ldc 231
    //   80: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 5
    //   86: getstatic 188	com/tencent/mobileqq/shortvideo/common/GloableValue:q	Ljava/lang/String;
    //   89: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 5
    //   95: ldc 233
    //   97: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 5
    //   103: getstatic 172	com/tencent/mobileqq/shortvideo/common/GloableValue:s	Ljava/lang/String;
    //   106: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 5
    //   112: ldc 235
    //   114: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 5
    //   120: getstatic 176	com/tencent/mobileqq/shortvideo/common/GloableValue:r	Ljava/lang/String;
    //   123: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 5
    //   129: ldc 237
    //   131: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 5
    //   137: getstatic 180	com/tencent/mobileqq/shortvideo/common/GloableValue:t	Ljava/lang/String;
    //   140: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 5
    //   146: ldc 239
    //   148: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 5
    //   154: getstatic 244	com/tencent/mobileqq/editor/composite/CodecParam:RECORD_MAX_TIME	I
    //   157: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 5
    //   163: ldc 249
    //   165: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 5
    //   171: getstatic 252	com/tencent/mobileqq/editor/composite/CodecParam:VIDEO_FPS	I
    //   174: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 5
    //   180: ldc 254
    //   182: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 5
    //   188: iload_2
    //   189: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 5
    //   195: ldc_w 256
    //   198: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 5
    //   204: iload_3
    //   205: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 5
    //   211: ldc_w 258
    //   214: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 5
    //   220: iconst_0
    //   221: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 5
    //   227: ldc_w 260
    //   230: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 4
    //   236: aload 5
    //   238: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: putfield 264	com/tencent/maxvideo/common/MessageStruct:mObj0	Ljava/lang/Object;
    //   244: aconst_null
    //   245: astore 6
    //   247: aconst_null
    //   248: astore 7
    //   250: aconst_null
    //   251: astore 8
    //   253: aconst_null
    //   254: astore 5
    //   256: aload 4
    //   258: aconst_null
    //   259: aconst_null
    //   260: invokestatic 270	com/tencent/maxvideo/common/GlobalInit:nativeSyncProcessMsg	(Lcom/tencent/maxvideo/common/MessageStruct;Lcom/tencent/maxvideo/common/MessageStruct;Ljava/lang/Object;)Z
    //   263: pop
    //   264: aload_1
    //   265: invokevirtual 274	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   268: ldc_w 275
    //   271: invokevirtual 281	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   274: astore 4
    //   276: aload 4
    //   278: invokevirtual 287	java/io/InputStream:available	()I
    //   281: newarray byte
    //   283: astore 10
    //   285: aload 4
    //   287: aload 10
    //   289: invokevirtual 291	java/io/InputStream:read	([B)I
    //   292: pop
    //   293: new 126	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   300: astore_0
    //   301: aload_0
    //   302: aload 9
    //   304: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload_0
    //   309: ldc_w 293
    //   312: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: new 295	java/io/FileOutputStream
    //   319: dup
    //   320: new 139	java/io/File
    //   323: dup
    //   324: aload_0
    //   325: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   331: invokespecial 298	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   334: astore_0
    //   335: aload_0
    //   336: aload 10
    //   338: invokevirtual 302	java/io/FileOutputStream:write	([B)V
    //   341: aload_0
    //   342: astore 5
    //   344: aload 4
    //   346: ifnull +11 -> 357
    //   349: aload 4
    //   351: invokevirtual 305	java/io/InputStream:close	()V
    //   354: aload_0
    //   355: astore 5
    //   357: aload 5
    //   359: invokevirtual 306	java/io/FileOutputStream:close	()V
    //   362: goto +109 -> 471
    //   365: astore 5
    //   367: aload_0
    //   368: astore_1
    //   369: aload 5
    //   371: astore_0
    //   372: goto +27 -> 399
    //   375: astore_0
    //   376: aload 5
    //   378: astore_1
    //   379: goto +20 -> 399
    //   382: aconst_null
    //   383: astore_0
    //   384: goto +41 -> 425
    //   387: aconst_null
    //   388: astore_0
    //   389: goto +62 -> 451
    //   392: astore_0
    //   393: aconst_null
    //   394: astore 4
    //   396: aload 5
    //   398: astore_1
    //   399: aload 4
    //   401: ifnull +8 -> 409
    //   404: aload 4
    //   406: invokevirtual 305	java/io/InputStream:close	()V
    //   409: aload_1
    //   410: ifnull +7 -> 417
    //   413: aload_1
    //   414: invokevirtual 306	java/io/FileOutputStream:close	()V
    //   417: aload_0
    //   418: athrow
    //   419: aconst_null
    //   420: astore 4
    //   422: aload 4
    //   424: astore_0
    //   425: aload 4
    //   427: ifnull +8 -> 435
    //   430: aload 4
    //   432: invokevirtual 305	java/io/InputStream:close	()V
    //   435: aload_0
    //   436: ifnull +35 -> 471
    //   439: aload_0
    //   440: astore 5
    //   442: goto -85 -> 357
    //   445: aconst_null
    //   446: astore 4
    //   448: aload 4
    //   450: astore_0
    //   451: aload 4
    //   453: ifnull +8 -> 461
    //   456: aload 4
    //   458: invokevirtual 305	java/io/InputStream:close	()V
    //   461: aload_0
    //   462: ifnull +9 -> 471
    //   465: aload_0
    //   466: astore 5
    //   468: goto -111 -> 357
    //   471: aload_1
    //   472: invokevirtual 274	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   475: ldc_w 307
    //   478: invokevirtual 281	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   481: astore_0
    //   482: aload_0
    //   483: invokevirtual 287	java/io/InputStream:available	()I
    //   486: newarray byte
    //   488: astore 4
    //   490: aload_0
    //   491: aload 4
    //   493: invokevirtual 291	java/io/InputStream:read	([B)I
    //   496: pop
    //   497: new 126	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   504: astore_1
    //   505: aload_1
    //   506: aload 9
    //   508: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: aload_1
    //   513: ldc_w 309
    //   516: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: new 295	java/io/FileOutputStream
    //   523: dup
    //   524: new 139	java/io/File
    //   527: dup
    //   528: aload_1
    //   529: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   535: invokespecial 298	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   538: astore_1
    //   539: aload_1
    //   540: aload 4
    //   542: invokevirtual 302	java/io/FileOutputStream:write	([B)V
    //   545: aload_0
    //   546: ifnull +7 -> 553
    //   549: aload_0
    //   550: invokevirtual 305	java/io/InputStream:close	()V
    //   553: aload_1
    //   554: invokevirtual 306	java/io/FileOutputStream:close	()V
    //   557: goto +105 -> 662
    //   560: astore 4
    //   562: aload_0
    //   563: astore 5
    //   565: aload 4
    //   567: astore_0
    //   568: goto +30 -> 598
    //   571: goto +52 -> 623
    //   574: goto +73 -> 647
    //   577: astore 4
    //   579: aload 6
    //   581: astore_1
    //   582: aload_0
    //   583: astore 5
    //   585: aload 4
    //   587: astore_0
    //   588: goto +10 -> 598
    //   591: astore_0
    //   592: aconst_null
    //   593: astore 5
    //   595: aload 6
    //   597: astore_1
    //   598: aload 5
    //   600: ifnull +8 -> 608
    //   603: aload 5
    //   605: invokevirtual 305	java/io/InputStream:close	()V
    //   608: aload_1
    //   609: ifnull +7 -> 616
    //   612: aload_1
    //   613: invokevirtual 306	java/io/FileOutputStream:close	()V
    //   616: aload_0
    //   617: athrow
    //   618: aconst_null
    //   619: astore_0
    //   620: aload 7
    //   622: astore_1
    //   623: aload_0
    //   624: ifnull +7 -> 631
    //   627: aload_0
    //   628: invokevirtual 305	java/io/InputStream:close	()V
    //   631: aload_1
    //   632: ifnull +30 -> 662
    //   635: aload_1
    //   636: invokevirtual 306	java/io/FileOutputStream:close	()V
    //   639: goto +23 -> 662
    //   642: aconst_null
    //   643: astore_0
    //   644: aload 8
    //   646: astore_1
    //   647: aload_0
    //   648: ifnull +7 -> 655
    //   651: aload_0
    //   652: invokevirtual 305	java/io/InputStream:close	()V
    //   655: aload_1
    //   656: ifnull +6 -> 662
    //   659: goto -24 -> 635
    //   662: iconst_1
    //   663: ireturn
    //   664: astore_0
    //   665: goto -220 -> 445
    //   668: astore_0
    //   669: goto -250 -> 419
    //   672: astore_0
    //   673: goto -286 -> 387
    //   676: astore_0
    //   677: goto -295 -> 382
    //   680: astore 5
    //   682: goto -231 -> 451
    //   685: astore 5
    //   687: goto -262 -> 425
    //   690: astore 4
    //   692: aload_0
    //   693: astore 5
    //   695: goto -338 -> 357
    //   698: astore_0
    //   699: goto -228 -> 471
    //   702: astore 4
    //   704: goto -295 -> 409
    //   707: astore_1
    //   708: goto -291 -> 417
    //   711: astore 4
    //   713: goto -278 -> 435
    //   716: astore 4
    //   718: goto -257 -> 461
    //   721: astore_0
    //   722: goto -80 -> 642
    //   725: astore_0
    //   726: goto -108 -> 618
    //   729: astore_1
    //   730: aload 8
    //   732: astore_1
    //   733: goto -86 -> 647
    //   736: astore_1
    //   737: aload 7
    //   739: astore_1
    //   740: goto -117 -> 623
    //   743: astore 4
    //   745: goto -171 -> 574
    //   748: astore 4
    //   750: goto -179 -> 571
    //   753: astore_0
    //   754: goto -201 -> 553
    //   757: astore_0
    //   758: goto -96 -> 662
    //   761: astore 4
    //   763: goto -155 -> 608
    //   766: astore_1
    //   767: goto -151 -> 616
    //   770: astore_0
    //   771: goto -140 -> 631
    //   774: astore_0
    //   775: goto -120 -> 655
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	778	0	paramString	String
    //   0	778	1	paramContext	Context
    //   0	778	2	paramInt1	int
    //   0	778	3	paramInt2	int
    //   17	524	4	localObject1	Object
    //   560	6	4	localObject2	Object
    //   577	9	4	localObject3	Object
    //   690	1	4	localIOException1	java.io.IOException
    //   702	1	4	localIOException2	java.io.IOException
    //   711	1	4	localIOException3	java.io.IOException
    //   716	1	4	localIOException4	java.io.IOException
    //   743	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   748	1	4	localIOException5	java.io.IOException
    //   761	1	4	localIOException6	java.io.IOException
    //   26	332	5	localObject4	Object
    //   365	32	5	localObject5	Object
    //   440	164	5	str1	String
    //   680	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   685	1	5	localIOException7	java.io.IOException
    //   693	1	5	str2	String
    //   245	351	6	localObject6	Object
    //   248	490	7	localObject7	Object
    //   251	480	8	localObject8	Object
    //   6	501	9	str3	String
    //   283	54	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   335	341	365	finally
    //   276	335	375	finally
    //   264	276	392	finally
    //   539	545	560	finally
    //   482	539	577	finally
    //   471	482	591	finally
    //   264	276	664	java/io/FileNotFoundException
    //   264	276	668	java/io/IOException
    //   276	335	672	java/io/FileNotFoundException
    //   276	335	676	java/io/IOException
    //   335	341	680	java/io/FileNotFoundException
    //   335	341	685	java/io/IOException
    //   349	354	690	java/io/IOException
    //   357	362	698	java/io/IOException
    //   404	409	702	java/io/IOException
    //   413	417	707	java/io/IOException
    //   430	435	711	java/io/IOException
    //   456	461	716	java/io/IOException
    //   471	482	721	java/io/FileNotFoundException
    //   471	482	725	java/io/IOException
    //   482	539	729	java/io/FileNotFoundException
    //   482	539	736	java/io/IOException
    //   539	545	743	java/io/FileNotFoundException
    //   539	545	748	java/io/IOException
    //   549	553	753	java/io/IOException
    //   553	557	757	java/io/IOException
    //   635	639	757	java/io/IOException
    //   603	608	761	java/io/IOException
    //   612	616	766	java/io/IOException
    //   627	631	770	java/io/IOException
    //   651	655	774	java/io/IOException
  }
  
  public static void b()
  {
    try
    {
      ((AudioManager)VideoEnvironment.getContext().getSystemService("audio")).abandonAudioFocus(null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static String c()
  {
    return q;
  }
  
  public static void d()
  {
    GlobalInit.nativeSyncProcessMsg(new MessageStruct(7), null, null);
    c = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.common.GloableValue
 * JD-Core Version:    0.7.0.1
 */