package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class double
{
  public static final String If = final.get(final.Qd);
  public static final String Jf = final.get(final.Rd);
  public static final String Kf = final.get(final.Sd);
  public static final String Lf = final.get(final.Td);
  public static long Mf = 0L;
  public static final String[] Nf = { "^/data/user/\\d+$", "^/data/data$" };
  public static final String vf = final.get(final.Pd);
  
  public static String G()
  {
    StringBuilder localStringBuilder = do.b("");
    localStringBuilder.append(Mf);
    return localStringBuilder.toString();
  }
  
  public static boolean H()
  {
    try
    {
      int i = Process.myUid() / 100000;
      if (999 == i) {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      label16:
      break label16;
    }
    return false;
  }
  
  public static String d(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getApplicationInfo(paramString, 0).sourceDir;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label42:
      break label42;
    }
    paramContext = "";
    try
    {
      localStringBuilder.append((String)void.a(new File(paramContext)).get(0));
    }
    catch (Throwable paramString)
    {
      label74:
      long l2;
      long l1;
      break label74;
    }
    localStringBuilder.append("");
    localStringBuilder.append("_");
    l2 = -1L;
    l1 = l2;
    if (!TextUtils.isEmpty(paramContext))
    {
      paramContext = new File(paramContext);
      l1 = l2;
      if (paramContext.exists()) {
        l1 = paramContext.length();
      }
    }
    localStringBuilder.append(l1);
    localStringBuilder.append("_");
    localStringBuilder.append(Process.myUid());
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static ArrayList<Hydra> q(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 158	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: new 160	java/util/ArrayList
    //   7: dup
    //   8: invokespecial 161	java/util/ArrayList:<init>	()V
    //   11: astore 12
    //   13: aload_0
    //   14: invokevirtual 165	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   17: invokevirtual 169	android/content/Context:getFilesDir	()Ljava/io/File;
    //   20: invokevirtual 172	java/io/File:getParentFile	()Ljava/io/File;
    //   23: astore 7
    //   25: aload 7
    //   27: ifnonnull +18 -> 45
    //   30: new 174	com/tencent/turingfd/sdk/xq/double$do
    //   33: dup
    //   34: iconst_0
    //   35: ldc 63
    //   37: invokespecial 177	com/tencent/turingfd/sdk/xq/double$do:<init>	(ZLjava/lang/String;)V
    //   40: astore 7
    //   42: goto +238 -> 280
    //   45: aload 7
    //   47: invokevirtual 172	java/io/File:getParentFile	()Ljava/io/File;
    //   50: astore 8
    //   52: aload 8
    //   54: ifnonnull +18 -> 72
    //   57: new 174	com/tencent/turingfd/sdk/xq/double$do
    //   60: dup
    //   61: iconst_0
    //   62: ldc 63
    //   64: invokespecial 177	com/tencent/turingfd/sdk/xq/double$do:<init>	(ZLjava/lang/String;)V
    //   67: astore 7
    //   69: goto +211 -> 280
    //   72: getstatic 58	com/tencent/turingfd/sdk/xq/double:Nf	[Ljava/lang/String;
    //   75: astore 9
    //   77: aload 9
    //   79: arraylength
    //   80: istore_2
    //   81: iconst_0
    //   82: istore_1
    //   83: iload_1
    //   84: iload_2
    //   85: if_icmpge +37 -> 122
    //   88: aload 9
    //   90: iload_1
    //   91: aaload
    //   92: invokestatic 183	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   95: aload 8
    //   97: invokevirtual 186	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   100: invokevirtual 190	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   103: invokevirtual 195	java/util/regex/Matcher:find	()Z
    //   106: ifeq +9 -> 115
    //   109: iconst_0
    //   110: istore 5
    //   112: goto +13 -> 125
    //   115: iload_1
    //   116: iconst_1
    //   117: iadd
    //   118: istore_1
    //   119: goto -36 -> 83
    //   122: iconst_1
    //   123: istore 5
    //   125: aload 7
    //   127: invokevirtual 186	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   130: astore 9
    //   132: aload_0
    //   133: invokevirtual 198	android/content/Context:getPackageName	()Ljava/lang/String;
    //   136: astore 8
    //   138: aload 9
    //   140: ldc 200
    //   142: bipush 6
    //   144: invokevirtual 204	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   147: astore 10
    //   149: aload 9
    //   151: ldc 206
    //   153: invokevirtual 210	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   156: ifeq +29 -> 185
    //   159: aload 10
    //   161: arraylength
    //   162: iconst_4
    //   163: if_icmplt +22 -> 185
    //   166: aload 10
    //   168: iconst_3
    //   169: aaload
    //   170: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   173: ifne +12 -> 185
    //   176: aload 10
    //   178: iconst_3
    //   179: aaload
    //   180: astore 7
    //   182: goto +48 -> 230
    //   185: aload 8
    //   187: astore 7
    //   189: aload 9
    //   191: ldc 212
    //   193: invokevirtual 210	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   196: ifeq +34 -> 230
    //   199: aload 8
    //   201: astore 7
    //   203: aload 10
    //   205: arraylength
    //   206: iconst_5
    //   207: if_icmplt +23 -> 230
    //   210: aload 8
    //   212: astore 7
    //   214: aload 10
    //   216: iconst_4
    //   217: aaload
    //   218: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   221: ifne +9 -> 230
    //   224: aload 10
    //   226: iconst_4
    //   227: aaload
    //   228: astore 7
    //   230: iload 5
    //   232: ifeq +35 -> 267
    //   235: aload 7
    //   237: aload_0
    //   238: invokevirtual 198	android/content/Context:getPackageName	()Ljava/lang/String;
    //   241: invokevirtual 216	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   244: ifne +23 -> 267
    //   247: new 174	com/tencent/turingfd/sdk/xq/double$do
    //   250: dup
    //   251: iload 5
    //   253: aload_0
    //   254: aload 7
    //   256: invokestatic 218	com/tencent/turingfd/sdk/xq/double:d	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   259: invokespecial 177	com/tencent/turingfd/sdk/xq/double$do:<init>	(ZLjava/lang/String;)V
    //   262: astore 7
    //   264: goto +16 -> 280
    //   267: new 174	com/tencent/turingfd/sdk/xq/double$do
    //   270: dup
    //   271: iload 5
    //   273: ldc 63
    //   275: invokespecial 177	com/tencent/turingfd/sdk/xq/double$do:<init>	(ZLjava/lang/String;)V
    //   278: astore 7
    //   280: aload 7
    //   282: getfield 221	com/tencent/turingfd/sdk/xq/double$do:jdField_a_of_type_Boolean	Z
    //   285: ifeq +88 -> 373
    //   288: aload 7
    //   290: getfield 223	com/tencent/turingfd/sdk/xq/double$do:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   293: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   296: ifne +77 -> 373
    //   299: iconst_0
    //   300: iconst_1
    //   301: iconst_0
    //   302: invokestatic 226	com/tencent/turingfd/sdk/xq/void:a	(IZI)I
    //   305: istore_1
    //   306: new 228	com/tencent/turingfd/sdk/xq/Hydra
    //   309: dup
    //   310: invokespecial 229	com/tencent/turingfd/sdk/xq/Hydra:<init>	()V
    //   313: astore 8
    //   315: new 71	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   322: astore 9
    //   324: aload 9
    //   326: getstatic 28	com/tencent/turingfd/sdk/xq/double:vf	Ljava/lang/String;
    //   329: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload 9
    //   335: getstatic 38	com/tencent/turingfd/sdk/xq/double:Jf	Ljava/lang/String;
    //   338: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload 8
    //   344: aload 9
    //   346: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: putfield 231	com/tencent/turingfd/sdk/xq/Hydra:G	Ljava/lang/String;
    //   352: aload 8
    //   354: aload 7
    //   356: getfield 223	com/tencent/turingfd/sdk/xq/double$do:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   359: putfield 233	com/tencent/turingfd/sdk/xq/Hydra:H	Ljava/lang/String;
    //   362: aload 12
    //   364: aload 8
    //   366: invokevirtual 236	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   369: pop
    //   370: goto +10 -> 380
    //   373: iconst_0
    //   374: iconst_0
    //   375: iconst_0
    //   376: invokestatic 226	com/tencent/turingfd/sdk/xq/void:a	(IZI)I
    //   379: istore_1
    //   380: aload_0
    //   381: invokevirtual 165	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   384: astore 13
    //   386: aload 13
    //   388: ifnonnull +18 -> 406
    //   391: new 174	com/tencent/turingfd/sdk/xq/double$do
    //   394: dup
    //   395: iconst_0
    //   396: ldc 63
    //   398: invokespecial 177	com/tencent/turingfd/sdk/xq/double$do:<init>	(ZLjava/lang/String;)V
    //   401: astore 7
    //   403: goto +680 -> 1083
    //   406: new 238	java/io/FileReader
    //   409: dup
    //   410: ldc 240
    //   412: invokespecial 241	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   415: astore 7
    //   417: new 243	java/io/BufferedReader
    //   420: dup
    //   421: aload 7
    //   423: invokespecial 246	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   426: astore 10
    //   428: aload 7
    //   430: astore 8
    //   432: aload 10
    //   434: astore 9
    //   436: aload 10
    //   438: invokevirtual 249	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   441: astore 11
    //   443: aload 11
    //   445: ifnull +383 -> 828
    //   448: aload 7
    //   450: astore 8
    //   452: aload 10
    //   454: astore 9
    //   456: aload 11
    //   458: bipush 47
    //   460: invokevirtual 253	java/lang/String:indexOf	(I)I
    //   463: istore_2
    //   464: iload_2
    //   465: iconst_m1
    //   466: if_icmpne +6 -> 472
    //   469: goto -41 -> 428
    //   472: aload 7
    //   474: astore 8
    //   476: aload 10
    //   478: astore 9
    //   480: aload 11
    //   482: iload_2
    //   483: invokevirtual 257	java/lang/String:substring	(I)Ljava/lang/String;
    //   486: invokevirtual 260	java/lang/String:trim	()Ljava/lang/String;
    //   489: astore 11
    //   491: aload 7
    //   493: astore 8
    //   495: aload 10
    //   497: astore 9
    //   499: getstatic 266	android/os/Build$VERSION:SDK_INT	I
    //   502: istore_2
    //   503: iload_2
    //   504: bipush 23
    //   506: if_icmpge +232 -> 738
    //   509: aload 7
    //   511: astore 8
    //   513: aload 10
    //   515: astore 9
    //   517: aload 11
    //   519: ldc_w 268
    //   522: invokevirtual 210	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   525: istore 5
    //   527: iload 5
    //   529: ifne +6 -> 535
    //   532: goto +229 -> 761
    //   535: aload 7
    //   537: astore 8
    //   539: aload 10
    //   541: astore 9
    //   543: aload 11
    //   545: ldc_w 270
    //   548: invokevirtual 273	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   551: ifne +6 -> 557
    //   554: goto +207 -> 761
    //   557: aload 7
    //   559: astore 8
    //   561: aload 10
    //   563: astore 9
    //   565: aload 11
    //   567: bipush 47
    //   569: invokevirtual 276	java/lang/String:lastIndexOf	(I)I
    //   572: istore_2
    //   573: iload_2
    //   574: iconst_m1
    //   575: if_icmpne +6 -> 581
    //   578: goto +183 -> 761
    //   581: aload 7
    //   583: astore 8
    //   585: aload 10
    //   587: astore 9
    //   589: aload 11
    //   591: iload_2
    //   592: aload 11
    //   594: invokevirtual 278	java/lang/String:length	()I
    //   597: bipush 12
    //   599: isub
    //   600: invokevirtual 281	java/lang/String:substring	(II)Ljava/lang/String;
    //   603: bipush 64
    //   605: bipush 47
    //   607: invokevirtual 285	java/lang/String:replace	(CC)Ljava/lang/String;
    //   610: astore 11
    //   612: aload 7
    //   614: astore 8
    //   616: aload 10
    //   618: astore 9
    //   620: aload 11
    //   622: ldc_w 287
    //   625: invokevirtual 210	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   628: ifne +6 -> 634
    //   631: goto +130 -> 761
    //   634: aload 7
    //   636: astore 8
    //   638: aload 10
    //   640: astore 9
    //   642: new 119	java/io/File
    //   645: dup
    //   646: aload 11
    //   648: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
    //   651: astore 11
    //   653: aload 7
    //   655: astore 8
    //   657: aload 10
    //   659: astore 9
    //   661: ldc_w 289
    //   664: aload 11
    //   666: invokevirtual 292	java/io/File:getName	()Ljava/lang/String;
    //   669: invokevirtual 216	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   672: ifeq +44 -> 716
    //   675: aload 7
    //   677: astore 8
    //   679: aload 10
    //   681: astore 9
    //   683: aload 11
    //   685: invokevirtual 172	java/io/File:getParentFile	()Ljava/io/File;
    //   688: ifnull +140 -> 828
    //   691: aload 7
    //   693: astore 8
    //   695: aload 10
    //   697: astore 9
    //   699: aload 11
    //   701: invokevirtual 172	java/io/File:getParentFile	()Ljava/io/File;
    //   704: invokevirtual 292	java/io/File:getName	()Ljava/lang/String;
    //   707: astore 11
    //   709: aload 11
    //   711: astore 8
    //   713: goto +112 -> 825
    //   716: aload 7
    //   718: astore 8
    //   720: aload 10
    //   722: astore 9
    //   724: aload 11
    //   726: invokevirtual 292	java/io/File:getName	()Ljava/lang/String;
    //   729: astore 11
    //   731: aload 11
    //   733: astore 8
    //   735: goto +90 -> 825
    //   738: aload 7
    //   740: astore 8
    //   742: aload 10
    //   744: astore 9
    //   746: aload 11
    //   748: ldc_w 287
    //   751: invokevirtual 210	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   754: istore 5
    //   756: iload 5
    //   758: ifne +6 -> 764
    //   761: goto -333 -> 428
    //   764: aload 7
    //   766: astore 8
    //   768: aload 10
    //   770: astore 9
    //   772: aload 11
    //   774: ldc_w 294
    //   777: invokevirtual 273	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   780: ifne +6 -> 786
    //   783: goto -22 -> 761
    //   786: aload 7
    //   788: astore 8
    //   790: aload 10
    //   792: astore 9
    //   794: aload 11
    //   796: ldc 200
    //   798: invokevirtual 297	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   801: astore 11
    //   803: aload 7
    //   805: astore 8
    //   807: aload 10
    //   809: astore 9
    //   811: aload 11
    //   813: arraylength
    //   814: bipush 7
    //   816: if_icmplt -55 -> 761
    //   819: aload 11
    //   821: iconst_3
    //   822: aaload
    //   823: astore 8
    //   825: goto +6 -> 831
    //   828: aconst_null
    //   829: astore 8
    //   831: aload 7
    //   833: invokestatic 300	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   836: aload 10
    //   838: invokestatic 300	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   841: aload 8
    //   843: astore 7
    //   845: goto +65 -> 910
    //   848: astore 11
    //   850: goto +34 -> 884
    //   853: astore_0
    //   854: goto +12 -> 866
    //   857: astore 8
    //   859: goto +18 -> 877
    //   862: astore_0
    //   863: aconst_null
    //   864: astore 7
    //   866: aconst_null
    //   867: astore 9
    //   869: goto +852 -> 1721
    //   872: astore 8
    //   874: aconst_null
    //   875: astore 7
    //   877: aconst_null
    //   878: astore 10
    //   880: aload 8
    //   882: astore 11
    //   884: aload 7
    //   886: astore 8
    //   888: aload 10
    //   890: astore 9
    //   892: aload 11
    //   894: invokevirtual 303	java/lang/Throwable:printStackTrace	()V
    //   897: aload 7
    //   899: invokestatic 300	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   902: aload 10
    //   904: invokestatic 300	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   907: aconst_null
    //   908: astore 7
    //   910: aload 13
    //   912: invokevirtual 198	android/content/Context:getPackageName	()Ljava/lang/String;
    //   915: astore 8
    //   917: aload 7
    //   919: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   922: ifne +116 -> 1038
    //   925: aload 7
    //   927: ldc_w 305
    //   930: invokevirtual 308	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   933: istore_2
    //   934: iload_2
    //   935: iconst_m1
    //   936: if_icmpne +6 -> 942
    //   939: goto +99 -> 1038
    //   942: aload 7
    //   944: iconst_0
    //   945: iload_2
    //   946: invokevirtual 281	java/lang/String:substring	(II)Ljava/lang/String;
    //   949: astore 7
    //   951: aload 7
    //   953: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   956: ifeq +6 -> 962
    //   959: goto +79 -> 1038
    //   962: new 71	java/lang/StringBuilder
    //   965: dup
    //   966: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   969: astore 9
    //   971: aload 9
    //   973: ldc 206
    //   975: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: pop
    //   979: aload 9
    //   981: aload 7
    //   983: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: pop
    //   987: new 119	java/io/File
    //   990: dup
    //   991: aload 9
    //   993: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   996: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
    //   999: astore 9
    //   1001: aload 9
    //   1003: invokevirtual 144	java/io/File:exists	()Z
    //   1006: ifeq +14 -> 1020
    //   1009: aload 9
    //   1011: invokevirtual 311	java/io/File:canWrite	()Z
    //   1014: ifeq +6 -> 1020
    //   1017: goto +7 -> 1024
    //   1020: aload 8
    //   1022: astore 7
    //   1024: aload 8
    //   1026: aload 7
    //   1028: invokestatic 314	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1031: iconst_1
    //   1032: ixor
    //   1033: istore 5
    //   1035: goto +10 -> 1045
    //   1038: iconst_0
    //   1039: istore 5
    //   1041: aload 8
    //   1043: astore 7
    //   1045: iload 5
    //   1047: ifeq +23 -> 1070
    //   1050: new 174	com/tencent/turingfd/sdk/xq/double$do
    //   1053: dup
    //   1054: iload 5
    //   1056: aload_0
    //   1057: aload 7
    //   1059: invokestatic 218	com/tencent/turingfd/sdk/xq/double:d	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   1062: invokespecial 177	com/tencent/turingfd/sdk/xq/double$do:<init>	(ZLjava/lang/String;)V
    //   1065: astore 7
    //   1067: goto +16 -> 1083
    //   1070: new 174	com/tencent/turingfd/sdk/xq/double$do
    //   1073: dup
    //   1074: iload 5
    //   1076: ldc 63
    //   1078: invokespecial 177	com/tencent/turingfd/sdk/xq/double$do:<init>	(ZLjava/lang/String;)V
    //   1081: astore 7
    //   1083: iload_1
    //   1084: aload 7
    //   1086: getfield 221	com/tencent/turingfd/sdk/xq/double$do:jdField_a_of_type_Boolean	Z
    //   1089: iconst_1
    //   1090: invokestatic 226	com/tencent/turingfd/sdk/xq/void:a	(IZI)I
    //   1093: istore_1
    //   1094: aload 7
    //   1096: getfield 221	com/tencent/turingfd/sdk/xq/double$do:jdField_a_of_type_Boolean	Z
    //   1099: ifeq +67 -> 1166
    //   1102: new 228	com/tencent/turingfd/sdk/xq/Hydra
    //   1105: dup
    //   1106: invokespecial 229	com/tencent/turingfd/sdk/xq/Hydra:<init>	()V
    //   1109: astore 8
    //   1111: new 71	java/lang/StringBuilder
    //   1114: dup
    //   1115: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1118: astore 9
    //   1120: aload 9
    //   1122: getstatic 28	com/tencent/turingfd/sdk/xq/double:vf	Ljava/lang/String;
    //   1125: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1128: pop
    //   1129: aload 9
    //   1131: getstatic 43	com/tencent/turingfd/sdk/xq/double:Kf	Ljava/lang/String;
    //   1134: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: pop
    //   1138: aload 8
    //   1140: aload 9
    //   1142: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1145: putfield 231	com/tencent/turingfd/sdk/xq/Hydra:G	Ljava/lang/String;
    //   1148: aload 8
    //   1150: aload 7
    //   1152: getfield 223	com/tencent/turingfd/sdk/xq/double$do:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1155: putfield 233	com/tencent/turingfd/sdk/xq/Hydra:H	Ljava/lang/String;
    //   1158: aload 12
    //   1160: aload 8
    //   1162: invokevirtual 236	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1165: pop
    //   1166: getstatic 266	android/os/Build$VERSION:SDK_INT	I
    //   1169: bipush 17
    //   1171: if_icmpge +17 -> 1188
    //   1174: new 174	com/tencent/turingfd/sdk/xq/double$do
    //   1177: dup
    //   1178: iconst_0
    //   1179: ldc 63
    //   1181: invokespecial 177	com/tencent/turingfd/sdk/xq/double$do:<init>	(ZLjava/lang/String;)V
    //   1184: astore_0
    //   1185: goto +375 -> 1560
    //   1188: new 71	java/lang/StringBuilder
    //   1191: dup
    //   1192: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1195: astore 7
    //   1197: ldc_w 316
    //   1200: getstatic 321	android/os/Build:BRAND	Ljava/lang/String;
    //   1203: invokevirtual 324	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1206: ifeq +162 -> 1368
    //   1209: ldc_w 326
    //   1212: invokestatic 332	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1215: astore 8
    //   1217: aload_0
    //   1218: invokevirtual 336	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1221: astore 9
    //   1223: aload 9
    //   1225: ldc_w 338
    //   1228: invokevirtual 342	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   1231: astore 9
    //   1233: aload 9
    //   1235: iconst_1
    //   1236: invokevirtual 348	java/lang/reflect/Field:setAccessible	(Z)V
    //   1239: aload_0
    //   1240: aload 9
    //   1242: aload_0
    //   1243: invokevirtual 351	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1246: checkcast 52	java/lang/String
    //   1249: invokevirtual 355	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1252: astore_0
    //   1253: aload_0
    //   1254: ifnonnull +6 -> 1260
    //   1257: goto +48 -> 1305
    //   1260: aload 8
    //   1262: ldc_w 357
    //   1265: iconst_0
    //   1266: anewarray 328	java/lang/Class
    //   1269: invokevirtual 361	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1272: astore 8
    //   1274: aload 8
    //   1276: ifnonnull +6 -> 1282
    //   1279: goto -22 -> 1257
    //   1282: aload 8
    //   1284: iconst_1
    //   1285: invokevirtual 364	java/lang/reflect/Method:setAccessible	(Z)V
    //   1288: aload 8
    //   1290: aload_0
    //   1291: iconst_0
    //   1292: anewarray 4	java/lang/Object
    //   1295: invokevirtual 368	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1298: checkcast 52	java/lang/String
    //   1301: astore_0
    //   1302: goto +6 -> 1308
    //   1305: ldc 63
    //   1307: astore_0
    //   1308: iconst_1
    //   1309: istore 5
    //   1311: new 52	java/lang/String
    //   1314: dup
    //   1315: ldc_w 370
    //   1318: iconst_0
    //   1319: invokestatic 376	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   1322: invokespecial 379	java/lang/String:<init>	([B)V
    //   1325: astore 8
    //   1327: aload_0
    //   1328: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1331: ifne +211 -> 1542
    //   1334: aload 8
    //   1336: aload_0
    //   1337: invokevirtual 216	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1340: istore 6
    //   1342: iload 6
    //   1344: ifeq +198 -> 1542
    //   1347: aload 7
    //   1349: ldc_w 381
    //   1352: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: pop
    //   1356: goto +189 -> 1545
    //   1359: iconst_1
    //   1360: istore 5
    //   1362: goto +177 -> 1539
    //   1365: goto +171 -> 1536
    //   1368: iconst_1
    //   1369: istore 5
    //   1371: ldc_w 383
    //   1374: getstatic 321	android/os/Build:BRAND	Ljava/lang/String;
    //   1377: invokevirtual 324	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1380: ifeq +21 -> 1401
    //   1383: invokestatic 385	com/tencent/turingfd/sdk/xq/double:H	()Z
    //   1386: ifeq +156 -> 1542
    //   1389: aload 7
    //   1391: ldc_w 387
    //   1394: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: pop
    //   1398: goto +147 -> 1545
    //   1401: ldc_w 389
    //   1404: getstatic 321	android/os/Build:BRAND	Ljava/lang/String;
    //   1407: invokevirtual 324	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1410: ifeq +21 -> 1431
    //   1413: invokestatic 385	com/tencent/turingfd/sdk/xq/double:H	()Z
    //   1416: ifeq +126 -> 1542
    //   1419: aload 7
    //   1421: ldc_w 391
    //   1424: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: pop
    //   1428: goto +117 -> 1545
    //   1431: ldc_w 393
    //   1434: getstatic 321	android/os/Build:BRAND	Ljava/lang/String;
    //   1437: invokevirtual 324	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1440: ifeq +102 -> 1542
    //   1443: invokestatic 385	com/tencent/turingfd/sdk/xq/double:H	()Z
    //   1446: ifeq +15 -> 1461
    //   1449: aload 7
    //   1451: ldc_w 395
    //   1454: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: pop
    //   1458: goto +87 -> 1545
    //   1461: new 52	java/lang/String
    //   1464: dup
    //   1465: ldc_w 397
    //   1468: invokestatic 403	com/tencent/turingfd/sdk/xq/abstract:i	(Ljava/lang/String;)[B
    //   1471: invokespecial 379	java/lang/String:<init>	([B)V
    //   1474: astore 8
    //   1476: new 71	java/lang/StringBuilder
    //   1479: dup
    //   1480: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1483: astore 9
    //   1485: aload 9
    //   1487: aload_0
    //   1488: invokevirtual 165	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   1491: invokevirtual 198	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1494: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: pop
    //   1498: aload 9
    //   1500: ldc_w 405
    //   1503: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1506: pop
    //   1507: aload 8
    //   1509: aload 9
    //   1511: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1514: invokevirtual 408	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1517: istore 6
    //   1519: iload 6
    //   1521: ifeq +21 -> 1542
    //   1524: aload 7
    //   1526: ldc_w 410
    //   1529: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: pop
    //   1533: goto +12 -> 1545
    //   1536: iconst_0
    //   1537: istore 5
    //   1539: goto +6 -> 1545
    //   1542: iconst_0
    //   1543: istore 5
    //   1545: new 174	com/tencent/turingfd/sdk/xq/double$do
    //   1548: dup
    //   1549: iload 5
    //   1551: aload 7
    //   1553: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1556: invokespecial 177	com/tencent/turingfd/sdk/xq/double$do:<init>	(ZLjava/lang/String;)V
    //   1559: astore_0
    //   1560: iload_1
    //   1561: aload_0
    //   1562: getfield 221	com/tencent/turingfd/sdk/xq/double$do:jdField_a_of_type_Boolean	Z
    //   1565: iconst_2
    //   1566: invokestatic 226	com/tencent/turingfd/sdk/xq/void:a	(IZI)I
    //   1569: istore_1
    //   1570: aload_0
    //   1571: getfield 221	com/tencent/turingfd/sdk/xq/double$do:jdField_a_of_type_Boolean	Z
    //   1574: ifeq +66 -> 1640
    //   1577: new 228	com/tencent/turingfd/sdk/xq/Hydra
    //   1580: dup
    //   1581: invokespecial 229	com/tencent/turingfd/sdk/xq/Hydra:<init>	()V
    //   1584: astore 7
    //   1586: new 71	java/lang/StringBuilder
    //   1589: dup
    //   1590: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1593: astore 8
    //   1595: aload 8
    //   1597: getstatic 28	com/tencent/turingfd/sdk/xq/double:vf	Ljava/lang/String;
    //   1600: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1603: pop
    //   1604: aload 8
    //   1606: getstatic 48	com/tencent/turingfd/sdk/xq/double:Lf	Ljava/lang/String;
    //   1609: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: pop
    //   1613: aload 7
    //   1615: aload 8
    //   1617: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1620: putfield 231	com/tencent/turingfd/sdk/xq/Hydra:G	Ljava/lang/String;
    //   1623: aload 7
    //   1625: aload_0
    //   1626: getfield 223	com/tencent/turingfd/sdk/xq/double$do:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1629: putfield 233	com/tencent/turingfd/sdk/xq/Hydra:H	Ljava/lang/String;
    //   1632: aload 12
    //   1634: aload 7
    //   1636: invokevirtual 236	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1639: pop
    //   1640: iload_1
    //   1641: ifle +64 -> 1705
    //   1644: new 228	com/tencent/turingfd/sdk/xq/Hydra
    //   1647: dup
    //   1648: invokespecial 229	com/tencent/turingfd/sdk/xq/Hydra:<init>	()V
    //   1651: astore_0
    //   1652: new 71	java/lang/StringBuilder
    //   1655: dup
    //   1656: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1659: astore 7
    //   1661: aload 7
    //   1663: getstatic 28	com/tencent/turingfd/sdk/xq/double:vf	Ljava/lang/String;
    //   1666: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1669: pop
    //   1670: aload 7
    //   1672: getstatic 33	com/tencent/turingfd/sdk/xq/double:If	Ljava/lang/String;
    //   1675: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1678: pop
    //   1679: aload_0
    //   1680: aload 7
    //   1682: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1685: putfield 231	com/tencent/turingfd/sdk/xq/Hydra:G	Ljava/lang/String;
    //   1688: aload_0
    //   1689: ldc 63
    //   1691: iload_1
    //   1692: invokestatic 413	com/tencent/turingfd/sdk/xq/do:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   1695: putfield 233	com/tencent/turingfd/sdk/xq/Hydra:H	Ljava/lang/String;
    //   1698: aload 12
    //   1700: aload_0
    //   1701: invokevirtual 236	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1704: pop
    //   1705: invokestatic 158	java/lang/System:currentTimeMillis	()J
    //   1708: lload_3
    //   1709: lsub
    //   1710: putstatic 50	com/tencent/turingfd/sdk/xq/double:Mf	J
    //   1713: aload 12
    //   1715: areturn
    //   1716: astore_0
    //   1717: aload 8
    //   1719: astore 7
    //   1721: aload 7
    //   1723: invokestatic 300	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   1726: aload 9
    //   1728: invokestatic 300	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   1731: goto +5 -> 1736
    //   1734: aload_0
    //   1735: athrow
    //   1736: goto -2 -> 1734
    //   1739: astore_0
    //   1740: goto -375 -> 1365
    //   1743: astore_0
    //   1744: goto -487 -> 1257
    //   1747: astore_0
    //   1748: goto -443 -> 1305
    //   1751: astore_0
    //   1752: goto -216 -> 1536
    //   1755: astore_0
    //   1756: goto -397 -> 1359
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1759	0	paramContext	Context
    //   82	1610	1	i	int
    //   80	866	2	j	int
    //   3	1706	3	l	long
    //   110	1440	5	bool1	boolean
    //   1340	180	6	bool2	boolean
    //   23	1699	7	localObject1	Object
    //   50	792	8	localObject2	Object
    //   857	1	8	localThrowable1	Throwable
    //   872	9	8	localThrowable2	Throwable
    //   886	832	8	localObject3	Object
    //   75	1652	9	localObject4	Object
    //   147	756	10	localObject5	Object
    //   441	379	11	localObject6	Object
    //   848	1	11	localThrowable3	Throwable
    //   882	11	11	localThrowable4	Throwable
    //   11	1703	12	localArrayList	ArrayList
    //   384	527	13	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   436	443	848	java/lang/Throwable
    //   456	464	848	java/lang/Throwable
    //   480	491	848	java/lang/Throwable
    //   499	503	848	java/lang/Throwable
    //   517	527	848	java/lang/Throwable
    //   543	554	848	java/lang/Throwable
    //   565	573	848	java/lang/Throwable
    //   589	612	848	java/lang/Throwable
    //   620	631	848	java/lang/Throwable
    //   642	653	848	java/lang/Throwable
    //   661	675	848	java/lang/Throwable
    //   683	691	848	java/lang/Throwable
    //   699	709	848	java/lang/Throwable
    //   724	731	848	java/lang/Throwable
    //   746	756	848	java/lang/Throwable
    //   772	783	848	java/lang/Throwable
    //   794	803	848	java/lang/Throwable
    //   811	819	848	java/lang/Throwable
    //   417	428	853	finally
    //   417	428	857	java/lang/Throwable
    //   406	417	862	finally
    //   406	417	872	java/lang/Throwable
    //   436	443	1716	finally
    //   456	464	1716	finally
    //   480	491	1716	finally
    //   499	503	1716	finally
    //   517	527	1716	finally
    //   543	554	1716	finally
    //   565	573	1716	finally
    //   589	612	1716	finally
    //   620	631	1716	finally
    //   642	653	1716	finally
    //   661	675	1716	finally
    //   683	691	1716	finally
    //   699	709	1716	finally
    //   724	731	1716	finally
    //   746	756	1716	finally
    //   772	783	1716	finally
    //   794	803	1716	finally
    //   811	819	1716	finally
    //   892	897	1716	finally
    //   1209	1223	1743	java/lang/Throwable
    //   1223	1253	1743	java/lang/Throwable
    //   1260	1274	1743	java/lang/Throwable
    //   1282	1302	1747	java/lang/Throwable
    //   1311	1342	1751	java/lang/Throwable
    //   1461	1498	1751	java/lang/Throwable
    //   1498	1519	1751	java/lang/Throwable
    //   1347	1356	1755	java/lang/Throwable
    //   1524	1533	1755	java/lang/Throwable
  }
  
  public static String r(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramContext = q(paramContext).iterator();
    while (paramContext.hasNext())
    {
      Hydra localHydra = (Hydra)paramContext.next();
      localStringBuilder.append(localHydra.G);
      localStringBuilder.append(":");
      localStringBuilder.append(localHydra.H);
      localStringBuilder.append(",");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.double
 * JD-Core Version:    0.7.0.1
 */