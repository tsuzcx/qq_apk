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
  public static int a;
  public static long a;
  public static Context a;
  public static String a;
  public static final int[] a;
  public static int b;
  private static String b;
  public static final int[] b;
  public static int c;
  private static String c;
  public static final int[] c;
  public static int d;
  private static String d;
  public static final int[] d;
  private static String e;
  public static final int[] e;
  private static String f;
  public static final int[] f;
  public static final int[] g = { 1280, 800 };
  public static final int[] h = { 720, 480 };
  
  static
  {
    jdField_a_of_type_AndroidContentContext = VideoEnvironment.getContext();
    jdField_a_of_type_Long = -1L;
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 640;
    jdField_d_of_type_Int = 480;
    jdField_a_of_type_ArrayOfInt = new int[] { 960, 640 };
    jdField_b_of_type_ArrayOfInt = new int[] { 720, 480 };
    jdField_c_of_type_ArrayOfInt = new int[] { 720, 540, 640, 480, 480, 360, 320, 240 };
    jdField_d_of_type_ArrayOfInt = new int[] { 1, 1, 0 };
    jdField_e_of_type_ArrayOfInt = new int[] { 1, 0, 0 };
    jdField_f_of_type_ArrayOfInt = new int[] { 1, 1, 0 };
  }
  
  public static String a()
  {
    return jdField_c_of_type_JavaLangString;
  }
  
  public static void a()
  {
    try
    {
      AudioManager localAudioManager = (AudioManager)VideoEnvironment.getContext().getSystemService("audio");
      int j = localAudioManager.requestAudioFocus(null, 3, 2);
      int i = j;
      if (j == 0) {
        i = localAudioManager.requestAudioFocus(null, 3, 1);
      }
      if (i == 0)
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
    paramContext = StorageManager.a().jdField_b_of_type_JavaLangString;
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
      jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      localObject = new File(jdField_a_of_type_JavaLangString);
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
      jdField_e_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("/Material");
      jdField_d_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject).append("/ProcessedMaterial");
      jdField_f_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("/log.txt");
      jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("Source");
      jdField_c_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      paramContext = new File(jdField_c_of_type_JavaLangString);
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
    long l = jdField_a_of_type_Long;
    if ((l > 0L) && ((paramLong <= 0L) || (l == paramLong)))
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("GloableValue[init]sUin=");
        paramContext.append(jdField_a_of_type_Long);
        paramContext.append("uin=");
        paramContext.append(paramLong);
        QLog.e("GloableValue", 2, paramContext.toString());
      }
      return true;
    }
    jdField_a_of_type_Long = paramLong;
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
    //   0: invokestatic 105	com/tencent/mobileqq/shortvideo/util/storage/StorageManager:a	()Lcom/tencent/mobileqq/shortvideo/util/storage/StorageManager;
    //   3: getfield 107	com/tencent/mobileqq/shortvideo/util/storage/StorageManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6: astore 9
    //   8: new 207	com/tencent/maxvideo/common/MessageStruct
    //   11: dup
    //   12: bipush 6
    //   14: invokespecial 210	com/tencent/maxvideo/common/MessageStruct:<init>	(I)V
    //   17: astore 4
    //   19: new 117	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   26: astore 5
    //   28: aload 5
    //   30: ldc 212
    //   32: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 5
    //   38: aload_0
    //   39: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 5
    //   45: ldc 214
    //   47: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 5
    //   53: aload 9
    //   55: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 5
    //   61: ldc 216
    //   63: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 5
    //   69: getstatic 173	com/tencent/mobileqq/shortvideo/common/GloableValue:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   72: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 5
    //   78: ldc 218
    //   80: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 5
    //   86: getstatic 62	com/tencent/mobileqq/shortvideo/common/GloableValue:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   89: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 5
    //   95: ldc 220
    //   97: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 5
    //   103: getstatic 162	com/tencent/mobileqq/shortvideo/common/GloableValue:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   106: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 5
    //   112: ldc 222
    //   114: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 5
    //   120: getstatic 166	com/tencent/mobileqq/shortvideo/common/GloableValue:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   123: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 5
    //   129: ldc 224
    //   131: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 5
    //   137: getstatic 170	com/tencent/mobileqq/shortvideo/common/GloableValue:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   140: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 5
    //   146: ldc 226
    //   148: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 5
    //   154: getstatic 231	com/tencent/mobileqq/editor/composite/CodecParam:RECORD_MAX_TIME	I
    //   157: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 5
    //   163: ldc 236
    //   165: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 5
    //   171: getstatic 239	com/tencent/mobileqq/editor/composite/CodecParam:VIDEO_FPS	I
    //   174: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 5
    //   180: ldc 241
    //   182: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 5
    //   188: iload_2
    //   189: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 5
    //   195: ldc 243
    //   197: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 5
    //   203: iload_3
    //   204: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 5
    //   210: ldc 245
    //   212: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 5
    //   218: iconst_0
    //   219: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 5
    //   225: ldc 247
    //   227: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 4
    //   233: aload 5
    //   235: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: putfield 251	com/tencent/maxvideo/common/MessageStruct:mObj0	Ljava/lang/Object;
    //   241: aconst_null
    //   242: astore 6
    //   244: aconst_null
    //   245: astore 7
    //   247: aconst_null
    //   248: astore 8
    //   250: aconst_null
    //   251: astore 5
    //   253: aload 4
    //   255: aconst_null
    //   256: aconst_null
    //   257: invokestatic 257	com/tencent/maxvideo/common/GlobalInit:nativeSyncProcessMsg	(Lcom/tencent/maxvideo/common/MessageStruct;Lcom/tencent/maxvideo/common/MessageStruct;Ljava/lang/Object;)Z
    //   260: pop
    //   261: aload_1
    //   262: invokevirtual 261	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   265: ldc_w 262
    //   268: invokevirtual 268	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   271: astore 4
    //   273: aload 4
    //   275: invokevirtual 274	java/io/InputStream:available	()I
    //   278: newarray byte
    //   280: astore 10
    //   282: aload 4
    //   284: aload 10
    //   286: invokevirtual 278	java/io/InputStream:read	([B)I
    //   289: pop
    //   290: new 117	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   297: astore_0
    //   298: aload_0
    //   299: aload 9
    //   301: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload_0
    //   306: ldc_w 280
    //   309: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: new 282	java/io/FileOutputStream
    //   316: dup
    //   317: new 129	java/io/File
    //   320: dup
    //   321: aload_0
    //   322: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   328: invokespecial 285	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   331: astore_0
    //   332: aload_0
    //   333: aload 10
    //   335: invokevirtual 289	java/io/FileOutputStream:write	([B)V
    //   338: aload_0
    //   339: astore 5
    //   341: aload 4
    //   343: ifnull +11 -> 354
    //   346: aload 4
    //   348: invokevirtual 292	java/io/InputStream:close	()V
    //   351: aload_0
    //   352: astore 5
    //   354: aload 5
    //   356: invokevirtual 293	java/io/FileOutputStream:close	()V
    //   359: goto +109 -> 468
    //   362: astore 5
    //   364: aload_0
    //   365: astore_1
    //   366: aload 5
    //   368: astore_0
    //   369: goto +27 -> 396
    //   372: astore_0
    //   373: aload 5
    //   375: astore_1
    //   376: goto +20 -> 396
    //   379: aconst_null
    //   380: astore_0
    //   381: goto +41 -> 422
    //   384: aconst_null
    //   385: astore_0
    //   386: goto +62 -> 448
    //   389: astore_0
    //   390: aconst_null
    //   391: astore 4
    //   393: aload 5
    //   395: astore_1
    //   396: aload 4
    //   398: ifnull +8 -> 406
    //   401: aload 4
    //   403: invokevirtual 292	java/io/InputStream:close	()V
    //   406: aload_1
    //   407: ifnull +7 -> 414
    //   410: aload_1
    //   411: invokevirtual 293	java/io/FileOutputStream:close	()V
    //   414: aload_0
    //   415: athrow
    //   416: aconst_null
    //   417: astore 4
    //   419: aload 4
    //   421: astore_0
    //   422: aload 4
    //   424: ifnull +8 -> 432
    //   427: aload 4
    //   429: invokevirtual 292	java/io/InputStream:close	()V
    //   432: aload_0
    //   433: ifnull +35 -> 468
    //   436: aload_0
    //   437: astore 5
    //   439: goto -85 -> 354
    //   442: aconst_null
    //   443: astore 4
    //   445: aload 4
    //   447: astore_0
    //   448: aload 4
    //   450: ifnull +8 -> 458
    //   453: aload 4
    //   455: invokevirtual 292	java/io/InputStream:close	()V
    //   458: aload_0
    //   459: ifnull +9 -> 468
    //   462: aload_0
    //   463: astore 5
    //   465: goto -111 -> 354
    //   468: aload_1
    //   469: invokevirtual 261	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   472: ldc_w 294
    //   475: invokevirtual 268	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   478: astore_0
    //   479: aload_0
    //   480: invokevirtual 274	java/io/InputStream:available	()I
    //   483: newarray byte
    //   485: astore 4
    //   487: aload_0
    //   488: aload 4
    //   490: invokevirtual 278	java/io/InputStream:read	([B)I
    //   493: pop
    //   494: new 117	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   501: astore_1
    //   502: aload_1
    //   503: aload 9
    //   505: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload_1
    //   510: ldc_w 296
    //   513: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: new 282	java/io/FileOutputStream
    //   520: dup
    //   521: new 129	java/io/File
    //   524: dup
    //   525: aload_1
    //   526: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   532: invokespecial 285	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   535: astore_1
    //   536: aload_1
    //   537: aload 4
    //   539: invokevirtual 289	java/io/FileOutputStream:write	([B)V
    //   542: aload_0
    //   543: ifnull +7 -> 550
    //   546: aload_0
    //   547: invokevirtual 292	java/io/InputStream:close	()V
    //   550: aload_1
    //   551: invokevirtual 293	java/io/FileOutputStream:close	()V
    //   554: goto +105 -> 659
    //   557: astore 4
    //   559: aload_0
    //   560: astore 5
    //   562: aload 4
    //   564: astore_0
    //   565: goto +30 -> 595
    //   568: goto +52 -> 620
    //   571: goto +73 -> 644
    //   574: astore 4
    //   576: aload 6
    //   578: astore_1
    //   579: aload_0
    //   580: astore 5
    //   582: aload 4
    //   584: astore_0
    //   585: goto +10 -> 595
    //   588: astore_0
    //   589: aconst_null
    //   590: astore 5
    //   592: aload 6
    //   594: astore_1
    //   595: aload 5
    //   597: ifnull +8 -> 605
    //   600: aload 5
    //   602: invokevirtual 292	java/io/InputStream:close	()V
    //   605: aload_1
    //   606: ifnull +7 -> 613
    //   609: aload_1
    //   610: invokevirtual 293	java/io/FileOutputStream:close	()V
    //   613: aload_0
    //   614: athrow
    //   615: aconst_null
    //   616: astore_0
    //   617: aload 7
    //   619: astore_1
    //   620: aload_0
    //   621: ifnull +7 -> 628
    //   624: aload_0
    //   625: invokevirtual 292	java/io/InputStream:close	()V
    //   628: aload_1
    //   629: ifnull +30 -> 659
    //   632: aload_1
    //   633: invokevirtual 293	java/io/FileOutputStream:close	()V
    //   636: goto +23 -> 659
    //   639: aconst_null
    //   640: astore_0
    //   641: aload 8
    //   643: astore_1
    //   644: aload_0
    //   645: ifnull +7 -> 652
    //   648: aload_0
    //   649: invokevirtual 292	java/io/InputStream:close	()V
    //   652: aload_1
    //   653: ifnull +6 -> 659
    //   656: goto -24 -> 632
    //   659: iconst_1
    //   660: ireturn
    //   661: astore_0
    //   662: goto -220 -> 442
    //   665: astore_0
    //   666: goto -250 -> 416
    //   669: astore_0
    //   670: goto -286 -> 384
    //   673: astore_0
    //   674: goto -295 -> 379
    //   677: astore 5
    //   679: goto -231 -> 448
    //   682: astore 5
    //   684: goto -262 -> 422
    //   687: astore 4
    //   689: aload_0
    //   690: astore 5
    //   692: goto -338 -> 354
    //   695: astore_0
    //   696: goto -228 -> 468
    //   699: astore 4
    //   701: goto -295 -> 406
    //   704: astore_1
    //   705: goto -291 -> 414
    //   708: astore 4
    //   710: goto -278 -> 432
    //   713: astore 4
    //   715: goto -257 -> 458
    //   718: astore_0
    //   719: goto -80 -> 639
    //   722: astore_0
    //   723: goto -108 -> 615
    //   726: astore_1
    //   727: aload 8
    //   729: astore_1
    //   730: goto -86 -> 644
    //   733: astore_1
    //   734: aload 7
    //   736: astore_1
    //   737: goto -117 -> 620
    //   740: astore 4
    //   742: goto -171 -> 571
    //   745: astore 4
    //   747: goto -179 -> 568
    //   750: astore_0
    //   751: goto -201 -> 550
    //   754: astore_0
    //   755: goto -96 -> 659
    //   758: astore 4
    //   760: goto -155 -> 605
    //   763: astore_1
    //   764: goto -151 -> 613
    //   767: astore_0
    //   768: goto -140 -> 628
    //   771: astore_0
    //   772: goto -120 -> 652
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	775	0	paramString	String
    //   0	775	1	paramContext	Context
    //   0	775	2	paramInt1	int
    //   0	775	3	paramInt2	int
    //   17	521	4	localObject1	Object
    //   557	6	4	localObject2	Object
    //   574	9	4	localObject3	Object
    //   687	1	4	localIOException1	java.io.IOException
    //   699	1	4	localIOException2	java.io.IOException
    //   708	1	4	localIOException3	java.io.IOException
    //   713	1	4	localIOException4	java.io.IOException
    //   740	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   745	1	4	localIOException5	java.io.IOException
    //   758	1	4	localIOException6	java.io.IOException
    //   26	329	5	localObject4	Object
    //   362	32	5	localObject5	Object
    //   437	164	5	str1	String
    //   677	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   682	1	5	localIOException7	java.io.IOException
    //   690	1	5	str2	String
    //   242	351	6	localObject6	Object
    //   245	490	7	localObject7	Object
    //   248	480	8	localObject8	Object
    //   6	498	9	str3	String
    //   280	54	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   332	338	362	finally
    //   273	332	372	finally
    //   261	273	389	finally
    //   536	542	557	finally
    //   479	536	574	finally
    //   468	479	588	finally
    //   261	273	661	java/io/FileNotFoundException
    //   261	273	665	java/io/IOException
    //   273	332	669	java/io/FileNotFoundException
    //   273	332	673	java/io/IOException
    //   332	338	677	java/io/FileNotFoundException
    //   332	338	682	java/io/IOException
    //   346	351	687	java/io/IOException
    //   354	359	695	java/io/IOException
    //   401	406	699	java/io/IOException
    //   410	414	704	java/io/IOException
    //   427	432	708	java/io/IOException
    //   453	458	713	java/io/IOException
    //   468	479	718	java/io/FileNotFoundException
    //   468	479	722	java/io/IOException
    //   479	536	726	java/io/FileNotFoundException
    //   479	536	733	java/io/IOException
    //   536	542	740	java/io/FileNotFoundException
    //   536	542	745	java/io/IOException
    //   546	550	750	java/io/IOException
    //   550	554	754	java/io/IOException
    //   632	636	754	java/io/IOException
    //   600	605	758	java/io/IOException
    //   609	613	763	java/io/IOException
    //   624	628	767	java/io/IOException
    //   648	652	771	java/io/IOException
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
  
  public static void c()
  {
    GlobalInit.nativeSyncProcessMsg(new MessageStruct(7), null, null);
    jdField_a_of_type_Long = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.common.GloableValue
 * JD-Core Version:    0.7.0.1
 */