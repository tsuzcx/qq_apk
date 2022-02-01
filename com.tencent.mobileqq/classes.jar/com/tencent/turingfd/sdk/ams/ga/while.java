package com.tencent.turingfd.sdk.ams.ga;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.List;

public class while
{
  public static final String ic = const.get(const.sa);
  public static final String pc = const.get(const.ta);
  public static final String qc = const.get(const.ua);
  public static final String rc = const.get(const.va);
  public static final String sc = const.get(const.wa);
  public static long tc = 0L;
  public static final String[] uc = { "^/data/user/\\d+$", "^/data/data$" };
  
  public static String G()
  {
    StringBuilder localStringBuilder = do.b("");
    localStringBuilder.append(tc);
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
  
  public static String b(Context paramContext, String paramString)
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
      localStringBuilder.append((String)goto.a(new File(paramContext)).get(0));
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
  public static String m(Context paramContext)
  {
    // Byte code:
    //   0: new 71	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   7: astore 12
    //   9: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   12: lstore_3
    //   13: new 159	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 160	java/util/ArrayList:<init>	()V
    //   20: astore 13
    //   22: aload_0
    //   23: invokevirtual 164	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   26: invokevirtual 168	android/content/Context:getFilesDir	()Ljava/io/File;
    //   29: invokevirtual 171	java/io/File:getParentFile	()Ljava/io/File;
    //   32: astore 7
    //   34: aload 7
    //   36: ifnonnull +18 -> 54
    //   39: new 173	com/tencent/turingfd/sdk/ams/ga/while$do
    //   42: dup
    //   43: iconst_0
    //   44: ldc 63
    //   46: invokespecial 176	com/tencent/turingfd/sdk/ams/ga/while$do:<init>	(ZLjava/lang/String;)V
    //   49: astore 7
    //   51: goto +238 -> 289
    //   54: aload 7
    //   56: invokevirtual 171	java/io/File:getParentFile	()Ljava/io/File;
    //   59: astore 8
    //   61: aload 8
    //   63: ifnonnull +18 -> 81
    //   66: new 173	com/tencent/turingfd/sdk/ams/ga/while$do
    //   69: dup
    //   70: iconst_0
    //   71: ldc 63
    //   73: invokespecial 176	com/tencent/turingfd/sdk/ams/ga/while$do:<init>	(ZLjava/lang/String;)V
    //   76: astore 7
    //   78: goto +211 -> 289
    //   81: getstatic 58	com/tencent/turingfd/sdk/ams/ga/while:uc	[Ljava/lang/String;
    //   84: astore 9
    //   86: aload 9
    //   88: arraylength
    //   89: istore_2
    //   90: iconst_0
    //   91: istore_1
    //   92: iload_1
    //   93: iload_2
    //   94: if_icmpge +37 -> 131
    //   97: aload 9
    //   99: iload_1
    //   100: aaload
    //   101: invokestatic 182	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   104: aload 8
    //   106: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   109: invokevirtual 189	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   112: invokevirtual 194	java/util/regex/Matcher:find	()Z
    //   115: ifeq +9 -> 124
    //   118: iconst_0
    //   119: istore 5
    //   121: goto +13 -> 134
    //   124: iload_1
    //   125: iconst_1
    //   126: iadd
    //   127: istore_1
    //   128: goto -36 -> 92
    //   131: iconst_1
    //   132: istore 5
    //   134: aload 7
    //   136: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   139: astore 9
    //   141: aload_0
    //   142: invokevirtual 197	android/content/Context:getPackageName	()Ljava/lang/String;
    //   145: astore 8
    //   147: aload 9
    //   149: ldc 199
    //   151: bipush 6
    //   153: invokevirtual 203	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   156: astore 10
    //   158: aload 9
    //   160: ldc 205
    //   162: invokevirtual 209	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   165: ifeq +29 -> 194
    //   168: aload 10
    //   170: arraylength
    //   171: iconst_4
    //   172: if_icmplt +22 -> 194
    //   175: aload 10
    //   177: iconst_3
    //   178: aaload
    //   179: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   182: ifne +12 -> 194
    //   185: aload 10
    //   187: iconst_3
    //   188: aaload
    //   189: astore 7
    //   191: goto +48 -> 239
    //   194: aload 8
    //   196: astore 7
    //   198: aload 9
    //   200: ldc 211
    //   202: invokevirtual 209	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   205: ifeq +34 -> 239
    //   208: aload 8
    //   210: astore 7
    //   212: aload 10
    //   214: arraylength
    //   215: iconst_5
    //   216: if_icmplt +23 -> 239
    //   219: aload 8
    //   221: astore 7
    //   223: aload 10
    //   225: iconst_4
    //   226: aaload
    //   227: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   230: ifne +9 -> 239
    //   233: aload 10
    //   235: iconst_4
    //   236: aaload
    //   237: astore 7
    //   239: iload 5
    //   241: ifeq +35 -> 276
    //   244: aload 7
    //   246: aload_0
    //   247: invokevirtual 197	android/content/Context:getPackageName	()Ljava/lang/String;
    //   250: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   253: ifne +23 -> 276
    //   256: new 173	com/tencent/turingfd/sdk/ams/ga/while$do
    //   259: dup
    //   260: iload 5
    //   262: aload_0
    //   263: aload 7
    //   265: invokestatic 217	com/tencent/turingfd/sdk/ams/ga/while:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   268: invokespecial 176	com/tencent/turingfd/sdk/ams/ga/while$do:<init>	(ZLjava/lang/String;)V
    //   271: astore 7
    //   273: goto +16 -> 289
    //   276: new 173	com/tencent/turingfd/sdk/ams/ga/while$do
    //   279: dup
    //   280: iload 5
    //   282: ldc 63
    //   284: invokespecial 176	com/tencent/turingfd/sdk/ams/ga/while$do:<init>	(ZLjava/lang/String;)V
    //   287: astore 7
    //   289: aload 7
    //   291: getfield 221	com/tencent/turingfd/sdk/ams/ga/while$do:match	Z
    //   294: ifeq +88 -> 382
    //   297: aload 7
    //   299: getfield 224	com/tencent/turingfd/sdk/ams/ga/while$do:oc	Ljava/lang/String;
    //   302: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   305: ifne +77 -> 382
    //   308: iconst_0
    //   309: iconst_1
    //   310: iconst_0
    //   311: invokestatic 227	com/tencent/turingfd/sdk/ams/ga/goto:a	(IZI)I
    //   314: istore_1
    //   315: new 229	com/tencent/turingfd/sdk/ams/ga/strictfp
    //   318: dup
    //   319: invokespecial 230	com/tencent/turingfd/sdk/ams/ga/strictfp:<init>	()V
    //   322: astore 8
    //   324: new 71	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   331: astore 9
    //   333: aload 9
    //   335: getstatic 28	com/tencent/turingfd/sdk/ams/ga/while:ic	Ljava/lang/String;
    //   338: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload 9
    //   344: getstatic 38	com/tencent/turingfd/sdk/ams/ga/while:qc	Ljava/lang/String;
    //   347: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload 8
    //   353: aload 9
    //   355: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: putfield 232	com/tencent/turingfd/sdk/ams/ga/strictfp:m	Ljava/lang/String;
    //   361: aload 8
    //   363: aload 7
    //   365: getfield 224	com/tencent/turingfd/sdk/ams/ga/while$do:oc	Ljava/lang/String;
    //   368: putfield 235	com/tencent/turingfd/sdk/ams/ga/strictfp:n	Ljava/lang/String;
    //   371: aload 13
    //   373: aload 8
    //   375: invokevirtual 238	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   378: pop
    //   379: goto +10 -> 389
    //   382: iconst_0
    //   383: iconst_0
    //   384: iconst_0
    //   385: invokestatic 227	com/tencent/turingfd/sdk/ams/ga/goto:a	(IZI)I
    //   388: istore_1
    //   389: aload_0
    //   390: invokevirtual 164	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   393: astore 14
    //   395: aload 14
    //   397: ifnonnull +18 -> 415
    //   400: new 173	com/tencent/turingfd/sdk/ams/ga/while$do
    //   403: dup
    //   404: iconst_0
    //   405: ldc 63
    //   407: invokespecial 176	com/tencent/turingfd/sdk/ams/ga/while$do:<init>	(ZLjava/lang/String;)V
    //   410: astore 7
    //   412: goto +680 -> 1092
    //   415: new 240	java/io/FileReader
    //   418: dup
    //   419: ldc 242
    //   421: invokespecial 243	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   424: astore 7
    //   426: new 245	java/io/BufferedReader
    //   429: dup
    //   430: aload 7
    //   432: invokespecial 248	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   435: astore 10
    //   437: aload 7
    //   439: astore 8
    //   441: aload 10
    //   443: astore 9
    //   445: aload 10
    //   447: invokevirtual 251	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   450: astore 11
    //   452: aload 11
    //   454: ifnull +383 -> 837
    //   457: aload 7
    //   459: astore 8
    //   461: aload 10
    //   463: astore 9
    //   465: aload 11
    //   467: bipush 47
    //   469: invokevirtual 255	java/lang/String:indexOf	(I)I
    //   472: istore_2
    //   473: iload_2
    //   474: iconst_m1
    //   475: if_icmpne +6 -> 481
    //   478: goto -41 -> 437
    //   481: aload 7
    //   483: astore 8
    //   485: aload 10
    //   487: astore 9
    //   489: aload 11
    //   491: iload_2
    //   492: invokevirtual 259	java/lang/String:substring	(I)Ljava/lang/String;
    //   495: invokevirtual 262	java/lang/String:trim	()Ljava/lang/String;
    //   498: astore 11
    //   500: aload 7
    //   502: astore 8
    //   504: aload 10
    //   506: astore 9
    //   508: getstatic 268	android/os/Build$VERSION:SDK_INT	I
    //   511: istore_2
    //   512: iload_2
    //   513: bipush 23
    //   515: if_icmpge +232 -> 747
    //   518: aload 7
    //   520: astore 8
    //   522: aload 10
    //   524: astore 9
    //   526: aload 11
    //   528: ldc_w 270
    //   531: invokevirtual 209	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   534: istore 5
    //   536: iload 5
    //   538: ifne +6 -> 544
    //   541: goto +229 -> 770
    //   544: aload 7
    //   546: astore 8
    //   548: aload 10
    //   550: astore 9
    //   552: aload 11
    //   554: ldc_w 272
    //   557: invokevirtual 275	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   560: ifne +6 -> 566
    //   563: goto +207 -> 770
    //   566: aload 7
    //   568: astore 8
    //   570: aload 10
    //   572: astore 9
    //   574: aload 11
    //   576: bipush 47
    //   578: invokevirtual 278	java/lang/String:lastIndexOf	(I)I
    //   581: istore_2
    //   582: iload_2
    //   583: iconst_m1
    //   584: if_icmpne +6 -> 590
    //   587: goto +183 -> 770
    //   590: aload 7
    //   592: astore 8
    //   594: aload 10
    //   596: astore 9
    //   598: aload 11
    //   600: iload_2
    //   601: aload 11
    //   603: invokevirtual 280	java/lang/String:length	()I
    //   606: bipush 12
    //   608: isub
    //   609: invokevirtual 283	java/lang/String:substring	(II)Ljava/lang/String;
    //   612: bipush 64
    //   614: bipush 47
    //   616: invokevirtual 287	java/lang/String:replace	(CC)Ljava/lang/String;
    //   619: astore 11
    //   621: aload 7
    //   623: astore 8
    //   625: aload 10
    //   627: astore 9
    //   629: aload 11
    //   631: ldc_w 289
    //   634: invokevirtual 209	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   637: ifne +6 -> 643
    //   640: goto +130 -> 770
    //   643: aload 7
    //   645: astore 8
    //   647: aload 10
    //   649: astore 9
    //   651: new 118	java/io/File
    //   654: dup
    //   655: aload 11
    //   657: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   660: astore 11
    //   662: aload 7
    //   664: astore 8
    //   666: aload 10
    //   668: astore 9
    //   670: ldc_w 291
    //   673: aload 11
    //   675: invokevirtual 294	java/io/File:getName	()Ljava/lang/String;
    //   678: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   681: ifeq +44 -> 725
    //   684: aload 7
    //   686: astore 8
    //   688: aload 10
    //   690: astore 9
    //   692: aload 11
    //   694: invokevirtual 171	java/io/File:getParentFile	()Ljava/io/File;
    //   697: ifnull +140 -> 837
    //   700: aload 7
    //   702: astore 8
    //   704: aload 10
    //   706: astore 9
    //   708: aload 11
    //   710: invokevirtual 171	java/io/File:getParentFile	()Ljava/io/File;
    //   713: invokevirtual 294	java/io/File:getName	()Ljava/lang/String;
    //   716: astore 11
    //   718: aload 11
    //   720: astore 8
    //   722: goto +112 -> 834
    //   725: aload 7
    //   727: astore 8
    //   729: aload 10
    //   731: astore 9
    //   733: aload 11
    //   735: invokevirtual 294	java/io/File:getName	()Ljava/lang/String;
    //   738: astore 11
    //   740: aload 11
    //   742: astore 8
    //   744: goto +90 -> 834
    //   747: aload 7
    //   749: astore 8
    //   751: aload 10
    //   753: astore 9
    //   755: aload 11
    //   757: ldc_w 289
    //   760: invokevirtual 209	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   763: istore 5
    //   765: iload 5
    //   767: ifne +6 -> 773
    //   770: goto -333 -> 437
    //   773: aload 7
    //   775: astore 8
    //   777: aload 10
    //   779: astore 9
    //   781: aload 11
    //   783: ldc_w 296
    //   786: invokevirtual 275	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   789: ifne +6 -> 795
    //   792: goto -22 -> 770
    //   795: aload 7
    //   797: astore 8
    //   799: aload 10
    //   801: astore 9
    //   803: aload 11
    //   805: ldc 199
    //   807: invokevirtual 299	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   810: astore 11
    //   812: aload 7
    //   814: astore 8
    //   816: aload 10
    //   818: astore 9
    //   820: aload 11
    //   822: arraylength
    //   823: bipush 7
    //   825: if_icmplt -55 -> 770
    //   828: aload 11
    //   830: iconst_3
    //   831: aaload
    //   832: astore 8
    //   834: goto +6 -> 840
    //   837: aconst_null
    //   838: astore 8
    //   840: aload 7
    //   842: invokestatic 302	com/tencent/turingfd/sdk/ams/ga/goto:a	(Ljava/io/Closeable;)V
    //   845: aload 10
    //   847: invokestatic 302	com/tencent/turingfd/sdk/ams/ga/goto:a	(Ljava/io/Closeable;)V
    //   850: aload 8
    //   852: astore 7
    //   854: goto +65 -> 919
    //   857: astore 11
    //   859: goto +34 -> 893
    //   862: astore_0
    //   863: goto +12 -> 875
    //   866: astore 8
    //   868: goto +18 -> 886
    //   871: astore_0
    //   872: aconst_null
    //   873: astore 7
    //   875: aconst_null
    //   876: astore 9
    //   878: goto +924 -> 1802
    //   881: astore 8
    //   883: aconst_null
    //   884: astore 7
    //   886: aconst_null
    //   887: astore 10
    //   889: aload 8
    //   891: astore 11
    //   893: aload 7
    //   895: astore 8
    //   897: aload 10
    //   899: astore 9
    //   901: aload 11
    //   903: invokevirtual 305	java/lang/Throwable:printStackTrace	()V
    //   906: aload 7
    //   908: invokestatic 302	com/tencent/turingfd/sdk/ams/ga/goto:a	(Ljava/io/Closeable;)V
    //   911: aload 10
    //   913: invokestatic 302	com/tencent/turingfd/sdk/ams/ga/goto:a	(Ljava/io/Closeable;)V
    //   916: aconst_null
    //   917: astore 7
    //   919: aload 14
    //   921: invokevirtual 197	android/content/Context:getPackageName	()Ljava/lang/String;
    //   924: astore 8
    //   926: aload 7
    //   928: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   931: ifne +116 -> 1047
    //   934: aload 7
    //   936: ldc_w 307
    //   939: invokevirtual 310	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   942: istore_2
    //   943: iload_2
    //   944: iconst_m1
    //   945: if_icmpne +6 -> 951
    //   948: goto +99 -> 1047
    //   951: aload 7
    //   953: iconst_0
    //   954: iload_2
    //   955: invokevirtual 283	java/lang/String:substring	(II)Ljava/lang/String;
    //   958: astore 7
    //   960: aload 7
    //   962: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   965: ifeq +6 -> 971
    //   968: goto +79 -> 1047
    //   971: new 71	java/lang/StringBuilder
    //   974: dup
    //   975: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   978: astore 9
    //   980: aload 9
    //   982: ldc 205
    //   984: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: aload 9
    //   990: aload 7
    //   992: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: pop
    //   996: new 118	java/io/File
    //   999: dup
    //   1000: aload 9
    //   1002: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1005: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   1008: astore 9
    //   1010: aload 9
    //   1012: invokevirtual 143	java/io/File:exists	()Z
    //   1015: ifeq +14 -> 1029
    //   1018: aload 9
    //   1020: invokevirtual 313	java/io/File:canWrite	()Z
    //   1023: ifeq +6 -> 1029
    //   1026: goto +7 -> 1033
    //   1029: aload 8
    //   1031: astore 7
    //   1033: aload 8
    //   1035: aload 7
    //   1037: invokestatic 316	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1040: iconst_1
    //   1041: ixor
    //   1042: istore 5
    //   1044: goto +10 -> 1054
    //   1047: iconst_0
    //   1048: istore 5
    //   1050: aload 8
    //   1052: astore 7
    //   1054: iload 5
    //   1056: ifeq +23 -> 1079
    //   1059: new 173	com/tencent/turingfd/sdk/ams/ga/while$do
    //   1062: dup
    //   1063: iload 5
    //   1065: aload_0
    //   1066: aload 7
    //   1068: invokestatic 217	com/tencent/turingfd/sdk/ams/ga/while:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   1071: invokespecial 176	com/tencent/turingfd/sdk/ams/ga/while$do:<init>	(ZLjava/lang/String;)V
    //   1074: astore 7
    //   1076: goto +16 -> 1092
    //   1079: new 173	com/tencent/turingfd/sdk/ams/ga/while$do
    //   1082: dup
    //   1083: iload 5
    //   1085: ldc 63
    //   1087: invokespecial 176	com/tencent/turingfd/sdk/ams/ga/while$do:<init>	(ZLjava/lang/String;)V
    //   1090: astore 7
    //   1092: iload_1
    //   1093: aload 7
    //   1095: getfield 221	com/tencent/turingfd/sdk/ams/ga/while$do:match	Z
    //   1098: iconst_1
    //   1099: invokestatic 227	com/tencent/turingfd/sdk/ams/ga/goto:a	(IZI)I
    //   1102: istore_1
    //   1103: aload 7
    //   1105: getfield 221	com/tencent/turingfd/sdk/ams/ga/while$do:match	Z
    //   1108: ifeq +67 -> 1175
    //   1111: new 229	com/tencent/turingfd/sdk/ams/ga/strictfp
    //   1114: dup
    //   1115: invokespecial 230	com/tencent/turingfd/sdk/ams/ga/strictfp:<init>	()V
    //   1118: astore 8
    //   1120: new 71	java/lang/StringBuilder
    //   1123: dup
    //   1124: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1127: astore 9
    //   1129: aload 9
    //   1131: getstatic 28	com/tencent/turingfd/sdk/ams/ga/while:ic	Ljava/lang/String;
    //   1134: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: pop
    //   1138: aload 9
    //   1140: getstatic 43	com/tencent/turingfd/sdk/ams/ga/while:rc	Ljava/lang/String;
    //   1143: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: pop
    //   1147: aload 8
    //   1149: aload 9
    //   1151: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1154: putfield 232	com/tencent/turingfd/sdk/ams/ga/strictfp:m	Ljava/lang/String;
    //   1157: aload 8
    //   1159: aload 7
    //   1161: getfield 224	com/tencent/turingfd/sdk/ams/ga/while$do:oc	Ljava/lang/String;
    //   1164: putfield 235	com/tencent/turingfd/sdk/ams/ga/strictfp:n	Ljava/lang/String;
    //   1167: aload 13
    //   1169: aload 8
    //   1171: invokevirtual 238	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1174: pop
    //   1175: getstatic 268	android/os/Build$VERSION:SDK_INT	I
    //   1178: bipush 17
    //   1180: if_icmpge +17 -> 1197
    //   1183: new 173	com/tencent/turingfd/sdk/ams/ga/while$do
    //   1186: dup
    //   1187: iconst_0
    //   1188: ldc 63
    //   1190: invokespecial 176	com/tencent/turingfd/sdk/ams/ga/while$do:<init>	(ZLjava/lang/String;)V
    //   1193: astore_0
    //   1194: goto +375 -> 1569
    //   1197: new 71	java/lang/StringBuilder
    //   1200: dup
    //   1201: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1204: astore 7
    //   1206: ldc_w 318
    //   1209: getstatic 323	android/os/Build:BRAND	Ljava/lang/String;
    //   1212: invokevirtual 326	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1215: ifeq +162 -> 1377
    //   1218: ldc_w 328
    //   1221: invokestatic 334	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1224: astore 8
    //   1226: aload_0
    //   1227: invokevirtual 338	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1230: astore 9
    //   1232: aload 9
    //   1234: ldc_w 340
    //   1237: invokevirtual 344	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   1240: astore 9
    //   1242: aload 9
    //   1244: iconst_1
    //   1245: invokevirtual 350	java/lang/reflect/Field:setAccessible	(Z)V
    //   1248: aload_0
    //   1249: aload 9
    //   1251: aload_0
    //   1252: invokevirtual 353	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1255: checkcast 52	java/lang/String
    //   1258: invokevirtual 357	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1261: astore_0
    //   1262: aload_0
    //   1263: ifnonnull +6 -> 1269
    //   1266: goto +48 -> 1314
    //   1269: aload 8
    //   1271: ldc_w 359
    //   1274: iconst_0
    //   1275: anewarray 330	java/lang/Class
    //   1278: invokevirtual 363	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1281: astore 8
    //   1283: aload 8
    //   1285: ifnonnull +6 -> 1291
    //   1288: goto -22 -> 1266
    //   1291: aload 8
    //   1293: iconst_1
    //   1294: invokevirtual 366	java/lang/reflect/Method:setAccessible	(Z)V
    //   1297: aload 8
    //   1299: aload_0
    //   1300: iconst_0
    //   1301: anewarray 4	java/lang/Object
    //   1304: invokevirtual 370	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1307: checkcast 52	java/lang/String
    //   1310: astore_0
    //   1311: goto +6 -> 1317
    //   1314: ldc 63
    //   1316: astore_0
    //   1317: iconst_1
    //   1318: istore 5
    //   1320: new 52	java/lang/String
    //   1323: dup
    //   1324: ldc_w 372
    //   1327: iconst_0
    //   1328: invokestatic 378	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   1331: invokespecial 381	java/lang/String:<init>	([B)V
    //   1334: astore 8
    //   1336: aload_0
    //   1337: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1340: ifne +211 -> 1551
    //   1343: aload 8
    //   1345: aload_0
    //   1346: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1349: istore 6
    //   1351: iload 6
    //   1353: ifeq +198 -> 1551
    //   1356: aload 7
    //   1358: ldc_w 383
    //   1361: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: pop
    //   1365: goto +189 -> 1554
    //   1368: iconst_1
    //   1369: istore 5
    //   1371: goto +177 -> 1548
    //   1374: goto +171 -> 1545
    //   1377: iconst_1
    //   1378: istore 5
    //   1380: ldc_w 385
    //   1383: getstatic 323	android/os/Build:BRAND	Ljava/lang/String;
    //   1386: invokevirtual 326	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1389: ifeq +21 -> 1410
    //   1392: invokestatic 387	com/tencent/turingfd/sdk/ams/ga/while:H	()Z
    //   1395: ifeq +156 -> 1551
    //   1398: aload 7
    //   1400: ldc_w 389
    //   1403: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1406: pop
    //   1407: goto +147 -> 1554
    //   1410: ldc_w 391
    //   1413: getstatic 323	android/os/Build:BRAND	Ljava/lang/String;
    //   1416: invokevirtual 326	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1419: ifeq +21 -> 1440
    //   1422: invokestatic 387	com/tencent/turingfd/sdk/ams/ga/while:H	()Z
    //   1425: ifeq +126 -> 1551
    //   1428: aload 7
    //   1430: ldc_w 393
    //   1433: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: pop
    //   1437: goto +117 -> 1554
    //   1440: ldc_w 395
    //   1443: getstatic 323	android/os/Build:BRAND	Ljava/lang/String;
    //   1446: invokevirtual 326	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1449: ifeq +102 -> 1551
    //   1452: invokestatic 387	com/tencent/turingfd/sdk/ams/ga/while:H	()Z
    //   1455: ifeq +15 -> 1470
    //   1458: aload 7
    //   1460: ldc_w 397
    //   1463: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: pop
    //   1467: goto +87 -> 1554
    //   1470: new 52	java/lang/String
    //   1473: dup
    //   1474: ldc_w 399
    //   1477: invokestatic 405	com/tencent/turingfd/sdk/ams/ga/package:f	(Ljava/lang/String;)[B
    //   1480: invokespecial 381	java/lang/String:<init>	([B)V
    //   1483: astore 8
    //   1485: new 71	java/lang/StringBuilder
    //   1488: dup
    //   1489: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1492: astore 9
    //   1494: aload 9
    //   1496: aload_0
    //   1497: invokevirtual 164	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   1500: invokevirtual 197	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1503: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1506: pop
    //   1507: aload 9
    //   1509: ldc_w 407
    //   1512: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1515: pop
    //   1516: aload 8
    //   1518: aload 9
    //   1520: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1523: invokevirtual 410	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1526: istore 6
    //   1528: iload 6
    //   1530: ifeq +21 -> 1551
    //   1533: aload 7
    //   1535: ldc_w 412
    //   1538: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1541: pop
    //   1542: goto +12 -> 1554
    //   1545: iconst_0
    //   1546: istore 5
    //   1548: goto +6 -> 1554
    //   1551: iconst_0
    //   1552: istore 5
    //   1554: new 173	com/tencent/turingfd/sdk/ams/ga/while$do
    //   1557: dup
    //   1558: iload 5
    //   1560: aload 7
    //   1562: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1565: invokespecial 176	com/tencent/turingfd/sdk/ams/ga/while$do:<init>	(ZLjava/lang/String;)V
    //   1568: astore_0
    //   1569: iload_1
    //   1570: aload_0
    //   1571: getfield 221	com/tencent/turingfd/sdk/ams/ga/while$do:match	Z
    //   1574: iconst_2
    //   1575: invokestatic 227	com/tencent/turingfd/sdk/ams/ga/goto:a	(IZI)I
    //   1578: istore_1
    //   1579: aload_0
    //   1580: getfield 221	com/tencent/turingfd/sdk/ams/ga/while$do:match	Z
    //   1583: ifeq +66 -> 1649
    //   1586: new 229	com/tencent/turingfd/sdk/ams/ga/strictfp
    //   1589: dup
    //   1590: invokespecial 230	com/tencent/turingfd/sdk/ams/ga/strictfp:<init>	()V
    //   1593: astore 7
    //   1595: new 71	java/lang/StringBuilder
    //   1598: dup
    //   1599: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1602: astore 8
    //   1604: aload 8
    //   1606: getstatic 28	com/tencent/turingfd/sdk/ams/ga/while:ic	Ljava/lang/String;
    //   1609: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: pop
    //   1613: aload 8
    //   1615: getstatic 48	com/tencent/turingfd/sdk/ams/ga/while:sc	Ljava/lang/String;
    //   1618: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1621: pop
    //   1622: aload 7
    //   1624: aload 8
    //   1626: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1629: putfield 232	com/tencent/turingfd/sdk/ams/ga/strictfp:m	Ljava/lang/String;
    //   1632: aload 7
    //   1634: aload_0
    //   1635: getfield 224	com/tencent/turingfd/sdk/ams/ga/while$do:oc	Ljava/lang/String;
    //   1638: putfield 235	com/tencent/turingfd/sdk/ams/ga/strictfp:n	Ljava/lang/String;
    //   1641: aload 13
    //   1643: aload 7
    //   1645: invokevirtual 238	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1648: pop
    //   1649: iload_1
    //   1650: ifle +64 -> 1714
    //   1653: new 229	com/tencent/turingfd/sdk/ams/ga/strictfp
    //   1656: dup
    //   1657: invokespecial 230	com/tencent/turingfd/sdk/ams/ga/strictfp:<init>	()V
    //   1660: astore_0
    //   1661: new 71	java/lang/StringBuilder
    //   1664: dup
    //   1665: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1668: astore 7
    //   1670: aload 7
    //   1672: getstatic 28	com/tencent/turingfd/sdk/ams/ga/while:ic	Ljava/lang/String;
    //   1675: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1678: pop
    //   1679: aload 7
    //   1681: getstatic 33	com/tencent/turingfd/sdk/ams/ga/while:pc	Ljava/lang/String;
    //   1684: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1687: pop
    //   1688: aload_0
    //   1689: aload 7
    //   1691: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1694: putfield 232	com/tencent/turingfd/sdk/ams/ga/strictfp:m	Ljava/lang/String;
    //   1697: aload_0
    //   1698: ldc 63
    //   1700: iload_1
    //   1701: invokestatic 415	com/tencent/turingfd/sdk/ams/ga/do:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   1704: putfield 235	com/tencent/turingfd/sdk/ams/ga/strictfp:n	Ljava/lang/String;
    //   1707: aload 13
    //   1709: aload_0
    //   1710: invokevirtual 238	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1713: pop
    //   1714: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   1717: lload_3
    //   1718: lsub
    //   1719: putstatic 50	com/tencent/turingfd/sdk/ams/ga/while:tc	J
    //   1722: aload 13
    //   1724: invokevirtual 419	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1727: astore_0
    //   1728: aload_0
    //   1729: invokeinterface 424 1 0
    //   1734: ifeq +57 -> 1791
    //   1737: aload_0
    //   1738: invokeinterface 428 1 0
    //   1743: checkcast 229	com/tencent/turingfd/sdk/ams/ga/strictfp
    //   1746: astore 7
    //   1748: aload 12
    //   1750: aload 7
    //   1752: getfield 232	com/tencent/turingfd/sdk/ams/ga/strictfp:m	Ljava/lang/String;
    //   1755: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1758: pop
    //   1759: aload 12
    //   1761: ldc_w 430
    //   1764: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1767: pop
    //   1768: aload 12
    //   1770: aload 7
    //   1772: getfield 235	com/tencent/turingfd/sdk/ams/ga/strictfp:n	Ljava/lang/String;
    //   1775: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1778: pop
    //   1779: aload 12
    //   1781: ldc_w 432
    //   1784: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1787: pop
    //   1788: goto -60 -> 1728
    //   1791: aload 12
    //   1793: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1796: areturn
    //   1797: astore_0
    //   1798: aload 8
    //   1800: astore 7
    //   1802: aload 7
    //   1804: invokestatic 302	com/tencent/turingfd/sdk/ams/ga/goto:a	(Ljava/io/Closeable;)V
    //   1807: aload 9
    //   1809: invokestatic 302	com/tencent/turingfd/sdk/ams/ga/goto:a	(Ljava/io/Closeable;)V
    //   1812: goto +5 -> 1817
    //   1815: aload_0
    //   1816: athrow
    //   1817: goto -2 -> 1815
    //   1820: astore_0
    //   1821: goto -447 -> 1374
    //   1824: astore_0
    //   1825: goto -559 -> 1266
    //   1828: astore_0
    //   1829: goto -515 -> 1314
    //   1832: astore_0
    //   1833: goto -288 -> 1545
    //   1836: astore_0
    //   1837: goto -469 -> 1368
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1840	0	paramContext	Context
    //   91	1610	1	i	int
    //   89	866	2	j	int
    //   12	1706	3	l	long
    //   119	1440	5	bool1	boolean
    //   1349	180	6	bool2	boolean
    //   32	1771	7	localObject1	Object
    //   59	792	8	localObject2	Object
    //   866	1	8	localThrowable1	Throwable
    //   881	9	8	localThrowable2	Throwable
    //   895	904	8	localObject3	Object
    //   84	1724	9	localObject4	Object
    //   156	756	10	localObject5	Object
    //   450	379	11	localObject6	Object
    //   857	1	11	localThrowable3	Throwable
    //   891	11	11	localThrowable4	Throwable
    //   7	1785	12	localStringBuilder	StringBuilder
    //   20	1703	13	localArrayList	java.util.ArrayList
    //   393	527	14	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   445	452	857	java/lang/Throwable
    //   465	473	857	java/lang/Throwable
    //   489	500	857	java/lang/Throwable
    //   508	512	857	java/lang/Throwable
    //   526	536	857	java/lang/Throwable
    //   552	563	857	java/lang/Throwable
    //   574	582	857	java/lang/Throwable
    //   598	621	857	java/lang/Throwable
    //   629	640	857	java/lang/Throwable
    //   651	662	857	java/lang/Throwable
    //   670	684	857	java/lang/Throwable
    //   692	700	857	java/lang/Throwable
    //   708	718	857	java/lang/Throwable
    //   733	740	857	java/lang/Throwable
    //   755	765	857	java/lang/Throwable
    //   781	792	857	java/lang/Throwable
    //   803	812	857	java/lang/Throwable
    //   820	828	857	java/lang/Throwable
    //   426	437	862	finally
    //   426	437	866	java/lang/Throwable
    //   415	426	871	finally
    //   415	426	881	java/lang/Throwable
    //   445	452	1797	finally
    //   465	473	1797	finally
    //   489	500	1797	finally
    //   508	512	1797	finally
    //   526	536	1797	finally
    //   552	563	1797	finally
    //   574	582	1797	finally
    //   598	621	1797	finally
    //   629	640	1797	finally
    //   651	662	1797	finally
    //   670	684	1797	finally
    //   692	700	1797	finally
    //   708	718	1797	finally
    //   733	740	1797	finally
    //   755	765	1797	finally
    //   781	792	1797	finally
    //   803	812	1797	finally
    //   820	828	1797	finally
    //   901	906	1797	finally
    //   1218	1232	1824	java/lang/Throwable
    //   1232	1262	1824	java/lang/Throwable
    //   1269	1283	1824	java/lang/Throwable
    //   1291	1311	1828	java/lang/Throwable
    //   1320	1351	1832	java/lang/Throwable
    //   1470	1507	1832	java/lang/Throwable
    //   1507	1528	1832	java/lang/Throwable
    //   1356	1365	1836	java/lang/Throwable
    //   1533	1542	1836	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.while
 * JD-Core Version:    0.7.0.1
 */