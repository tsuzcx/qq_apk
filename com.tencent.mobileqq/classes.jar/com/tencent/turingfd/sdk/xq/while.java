package com.tencent.turingfd.sdk.xq;

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
  public static final String lf = const.get(const.Hd);
  public static final String sf = const.get(const.Id);
  public static final String tf = const.get(const.Jd);
  public static final String uf = const.get(const.Kd);
  public static final String vf = const.get(const.Ld);
  public static long wf = 0L;
  public static final String[] xf = { "^/data/user/\\d+$", "^/data/data$" };
  
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
      try
      {
        for (;;)
        {
          localStringBuilder.append((String)this.a(new File(paramContext)).get(0));
          localStringBuilder.append("_");
          long l2 = -1L;
          long l1 = l2;
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
          paramContext = paramContext;
          paramContext = "";
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          localStringBuilder.append("");
        }
      }
    }
  }
  
  /* Error */
  public static String h(Context paramContext)
  {
    // Byte code:
    //   0: new 67	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   7: astore 13
    //   9: invokestatic 150	java/lang/System:currentTimeMillis	()J
    //   12: lstore_3
    //   13: new 152	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 153	java/util/ArrayList:<init>	()V
    //   20: astore 14
    //   22: aload_0
    //   23: invokevirtual 157	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   26: invokevirtual 161	android/content/Context:getFilesDir	()Ljava/io/File;
    //   29: invokevirtual 164	java/io/File:getParentFile	()Ljava/io/File;
    //   32: astore 7
    //   34: aload 7
    //   36: ifnonnull +410 -> 446
    //   39: new 166	com/tencent/turingfd/sdk/xq/while$do
    //   42: dup
    //   43: iconst_0
    //   44: ldc 143
    //   46: invokespecial 169	com/tencent/turingfd/sdk/xq/while$do:<init>	(ZLjava/lang/String;)V
    //   49: astore 7
    //   51: aload 7
    //   53: getfield 173	com/tencent/turingfd/sdk/xq/while$do:match	Z
    //   56: ifeq +630 -> 686
    //   59: aload 7
    //   61: getfield 176	com/tencent/turingfd/sdk/xq/while$do:rf	Ljava/lang/String;
    //   64: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifne +619 -> 686
    //   70: iconst_0
    //   71: iconst_1
    //   72: iconst_0
    //   73: invokestatic 179	com/tencent/turingfd/sdk/xq/this:a	(IZI)I
    //   76: istore_1
    //   77: new 181	com/tencent/turingfd/sdk/xq/Ara
    //   80: dup
    //   81: invokespecial 182	com/tencent/turingfd/sdk/xq/Ara:<init>	()V
    //   84: astore 8
    //   86: aload 8
    //   88: new 67	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   95: getstatic 28	com/tencent/turingfd/sdk/xq/while:lf	Ljava/lang/String;
    //   98: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: getstatic 38	com/tencent/turingfd/sdk/xq/while:tf	Ljava/lang/String;
    //   104: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: putfield 185	com/tencent/turingfd/sdk/xq/Ara:A	Ljava/lang/String;
    //   113: aload 8
    //   115: aload 7
    //   117: getfield 176	com/tencent/turingfd/sdk/xq/while$do:rf	Ljava/lang/String;
    //   120: putfield 188	com/tencent/turingfd/sdk/xq/Ara:B	Ljava/lang/String;
    //   123: aload 14
    //   125: aload 8
    //   127: invokevirtual 192	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   130: pop
    //   131: aload_0
    //   132: invokevirtual 157	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   135: astore 15
    //   137: aload 15
    //   139: ifnonnull +557 -> 696
    //   142: new 166	com/tencent/turingfd/sdk/xq/while$do
    //   145: dup
    //   146: iconst_0
    //   147: ldc 143
    //   149: invokespecial 169	com/tencent/turingfd/sdk/xq/while$do:<init>	(ZLjava/lang/String;)V
    //   152: astore 7
    //   154: iload_1
    //   155: aload 7
    //   157: getfield 173	com/tencent/turingfd/sdk/xq/while$do:match	Z
    //   160: iconst_1
    //   161: invokestatic 179	com/tencent/turingfd/sdk/xq/this:a	(IZI)I
    //   164: istore_1
    //   165: aload 7
    //   167: getfield 173	com/tencent/turingfd/sdk/xq/while$do:match	Z
    //   170: ifeq +57 -> 227
    //   173: new 181	com/tencent/turingfd/sdk/xq/Ara
    //   176: dup
    //   177: invokespecial 182	com/tencent/turingfd/sdk/xq/Ara:<init>	()V
    //   180: astore 8
    //   182: aload 8
    //   184: new 67	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   191: getstatic 28	com/tencent/turingfd/sdk/xq/while:lf	Ljava/lang/String;
    //   194: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: getstatic 43	com/tencent/turingfd/sdk/xq/while:uf	Ljava/lang/String;
    //   200: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: putfield 185	com/tencent/turingfd/sdk/xq/Ara:A	Ljava/lang/String;
    //   209: aload 8
    //   211: aload 7
    //   213: getfield 176	com/tencent/turingfd/sdk/xq/while$do:rf	Ljava/lang/String;
    //   216: putfield 188	com/tencent/turingfd/sdk/xq/Ara:B	Ljava/lang/String;
    //   219: aload 14
    //   221: aload 8
    //   223: invokevirtual 192	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   226: pop
    //   227: getstatic 198	android/os/Build$VERSION:SDK_INT	I
    //   230: bipush 17
    //   232: if_icmpge +992 -> 1224
    //   235: new 166	com/tencent/turingfd/sdk/xq/while$do
    //   238: dup
    //   239: iconst_0
    //   240: ldc 143
    //   242: invokespecial 169	com/tencent/turingfd/sdk/xq/while$do:<init>	(ZLjava/lang/String;)V
    //   245: astore_0
    //   246: iload_1
    //   247: aload_0
    //   248: getfield 173	com/tencent/turingfd/sdk/xq/while$do:match	Z
    //   251: iconst_2
    //   252: invokestatic 179	com/tencent/turingfd/sdk/xq/this:a	(IZI)I
    //   255: istore_1
    //   256: aload_0
    //   257: getfield 173	com/tencent/turingfd/sdk/xq/while$do:match	Z
    //   260: ifeq +56 -> 316
    //   263: new 181	com/tencent/turingfd/sdk/xq/Ara
    //   266: dup
    //   267: invokespecial 182	com/tencent/turingfd/sdk/xq/Ara:<init>	()V
    //   270: astore 7
    //   272: aload 7
    //   274: new 67	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   281: getstatic 28	com/tencent/turingfd/sdk/xq/while:lf	Ljava/lang/String;
    //   284: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: getstatic 48	com/tencent/turingfd/sdk/xq/while:vf	Ljava/lang/String;
    //   290: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: putfield 185	com/tencent/turingfd/sdk/xq/Ara:A	Ljava/lang/String;
    //   299: aload 7
    //   301: aload_0
    //   302: getfield 176	com/tencent/turingfd/sdk/xq/while$do:rf	Ljava/lang/String;
    //   305: putfield 188	com/tencent/turingfd/sdk/xq/Ara:B	Ljava/lang/String;
    //   308: aload 14
    //   310: aload 7
    //   312: invokevirtual 192	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   315: pop
    //   316: iload_1
    //   317: ifle +54 -> 371
    //   320: new 181	com/tencent/turingfd/sdk/xq/Ara
    //   323: dup
    //   324: invokespecial 182	com/tencent/turingfd/sdk/xq/Ara:<init>	()V
    //   327: astore_0
    //   328: aload_0
    //   329: new 67	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   336: getstatic 28	com/tencent/turingfd/sdk/xq/while:lf	Ljava/lang/String;
    //   339: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: getstatic 33	com/tencent/turingfd/sdk/xq/while:sf	Ljava/lang/String;
    //   345: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: putfield 185	com/tencent/turingfd/sdk/xq/Ara:A	Ljava/lang/String;
    //   354: aload_0
    //   355: ldc 143
    //   357: iload_1
    //   358: invokestatic 203	com/tencent/turingfd/sdk/xq/do:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   361: putfield 188	com/tencent/turingfd/sdk/xq/Ara:B	Ljava/lang/String;
    //   364: aload 14
    //   366: aload_0
    //   367: invokevirtual 192	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   370: pop
    //   371: invokestatic 150	java/lang/System:currentTimeMillis	()J
    //   374: lload_3
    //   375: lsub
    //   376: putstatic 50	com/tencent/turingfd/sdk/xq/while:wf	J
    //   379: aload 14
    //   381: invokevirtual 207	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   384: astore_0
    //   385: aload_0
    //   386: invokeinterface 212 1 0
    //   391: ifeq +1189 -> 1580
    //   394: aload_0
    //   395: invokeinterface 216 1 0
    //   400: checkcast 181	com/tencent/turingfd/sdk/xq/Ara
    //   403: astore 7
    //   405: aload 13
    //   407: aload 7
    //   409: getfield 185	com/tencent/turingfd/sdk/xq/Ara:A	Ljava/lang/String;
    //   412: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload 13
    //   418: ldc 218
    //   420: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload 13
    //   426: aload 7
    //   428: getfield 188	com/tencent/turingfd/sdk/xq/Ara:B	Ljava/lang/String;
    //   431: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload 13
    //   437: ldc 220
    //   439: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: goto -58 -> 385
    //   446: aload 7
    //   448: invokevirtual 164	java/io/File:getParentFile	()Ljava/io/File;
    //   451: astore 8
    //   453: aload 8
    //   455: ifnonnull +18 -> 473
    //   458: new 166	com/tencent/turingfd/sdk/xq/while$do
    //   461: dup
    //   462: iconst_0
    //   463: ldc 143
    //   465: invokespecial 169	com/tencent/turingfd/sdk/xq/while$do:<init>	(ZLjava/lang/String;)V
    //   468: astore 7
    //   470: goto -419 -> 51
    //   473: iconst_1
    //   474: istore 6
    //   476: getstatic 58	com/tencent/turingfd/sdk/xq/while:xf	[Ljava/lang/String;
    //   479: astore 9
    //   481: aload 9
    //   483: arraylength
    //   484: istore_2
    //   485: iconst_0
    //   486: istore_1
    //   487: iload 6
    //   489: istore 5
    //   491: iload_1
    //   492: iload_2
    //   493: if_icmpge +27 -> 520
    //   496: aload 9
    //   498: iload_1
    //   499: aaload
    //   500: invokestatic 226	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   503: aload 8
    //   505: invokevirtual 229	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   508: invokevirtual 233	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   511: invokevirtual 238	java/util/regex/Matcher:find	()Z
    //   514: ifeq +100 -> 614
    //   517: iconst_0
    //   518: istore 5
    //   520: aload 7
    //   522: invokevirtual 229	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   525: astore 9
    //   527: aload_0
    //   528: invokevirtual 241	android/content/Context:getPackageName	()Ljava/lang/String;
    //   531: astore 8
    //   533: aload 9
    //   535: ldc 243
    //   537: bipush 6
    //   539: invokevirtual 247	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   542: astore 10
    //   544: aload 9
    //   546: ldc 249
    //   548: invokevirtual 253	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   551: ifeq +70 -> 621
    //   554: aload 10
    //   556: arraylength
    //   557: iconst_4
    //   558: if_icmplt +63 -> 621
    //   561: aload 10
    //   563: iconst_3
    //   564: aaload
    //   565: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   568: ifne +53 -> 621
    //   571: aload 10
    //   573: iconst_3
    //   574: aaload
    //   575: astore 7
    //   577: iload 5
    //   579: ifeq +91 -> 670
    //   582: aload 7
    //   584: aload_0
    //   585: invokevirtual 241	android/content/Context:getPackageName	()Ljava/lang/String;
    //   588: invokevirtual 256	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   591: ifne +79 -> 670
    //   594: new 166	com/tencent/turingfd/sdk/xq/while$do
    //   597: dup
    //   598: iload 5
    //   600: aload_0
    //   601: aload 7
    //   603: invokestatic 258	com/tencent/turingfd/sdk/xq/while:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   606: invokespecial 169	com/tencent/turingfd/sdk/xq/while$do:<init>	(ZLjava/lang/String;)V
    //   609: astore 7
    //   611: goto -560 -> 51
    //   614: iload_1
    //   615: iconst_1
    //   616: iadd
    //   617: istore_1
    //   618: goto -131 -> 487
    //   621: aload 8
    //   623: astore 7
    //   625: aload 9
    //   627: ldc_w 260
    //   630: invokevirtual 253	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   633: ifeq -56 -> 577
    //   636: aload 8
    //   638: astore 7
    //   640: aload 10
    //   642: arraylength
    //   643: iconst_5
    //   644: if_icmplt -67 -> 577
    //   647: aload 8
    //   649: astore 7
    //   651: aload 10
    //   653: iconst_4
    //   654: aaload
    //   655: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   658: ifne -81 -> 577
    //   661: aload 10
    //   663: iconst_4
    //   664: aaload
    //   665: astore 7
    //   667: goto -90 -> 577
    //   670: new 166	com/tencent/turingfd/sdk/xq/while$do
    //   673: dup
    //   674: iload 5
    //   676: ldc 143
    //   678: invokespecial 169	com/tencent/turingfd/sdk/xq/while$do:<init>	(ZLjava/lang/String;)V
    //   681: astore 7
    //   683: goto -632 -> 51
    //   686: iconst_0
    //   687: iconst_0
    //   688: iconst_0
    //   689: invokestatic 179	com/tencent/turingfd/sdk/xq/this:a	(IZI)I
    //   692: istore_1
    //   693: goto -562 -> 131
    //   696: aconst_null
    //   697: astore 7
    //   699: aconst_null
    //   700: astore 10
    //   702: aconst_null
    //   703: astore 11
    //   705: aconst_null
    //   706: astore 12
    //   708: new 262	java/io/FileReader
    //   711: dup
    //   712: ldc_w 264
    //   715: invokespecial 265	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   718: astore 8
    //   720: new 267	java/io/BufferedReader
    //   723: dup
    //   724: aload 8
    //   726: invokespecial 270	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   729: astore 9
    //   731: aload 9
    //   733: invokevirtual 273	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   736: astore 10
    //   738: aload 12
    //   740: astore 7
    //   742: aload 10
    //   744: ifnull +157 -> 901
    //   747: aload 10
    //   749: bipush 47
    //   751: invokevirtual 277	java/lang/String:indexOf	(I)I
    //   754: istore_2
    //   755: iload_2
    //   756: iconst_m1
    //   757: if_icmpeq -26 -> 731
    //   760: aload 10
    //   762: iload_2
    //   763: invokevirtual 281	java/lang/String:substring	(I)Ljava/lang/String;
    //   766: invokevirtual 284	java/lang/String:trim	()Ljava/lang/String;
    //   769: astore 7
    //   771: getstatic 198	android/os/Build$VERSION:SDK_INT	I
    //   774: istore_2
    //   775: iload_2
    //   776: bipush 23
    //   778: if_icmpge +204 -> 982
    //   781: aload 7
    //   783: ldc_w 286
    //   786: invokevirtual 253	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   789: istore 5
    //   791: iload 5
    //   793: ifeq -62 -> 731
    //   796: aload 7
    //   798: ldc_w 288
    //   801: invokevirtual 291	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   804: ifeq -73 -> 731
    //   807: aload 7
    //   809: bipush 47
    //   811: invokevirtual 294	java/lang/String:lastIndexOf	(I)I
    //   814: istore_2
    //   815: iload_2
    //   816: iconst_m1
    //   817: if_icmpeq -86 -> 731
    //   820: aload 7
    //   822: iload_2
    //   823: aload 7
    //   825: invokevirtual 296	java/lang/String:length	()I
    //   828: bipush 12
    //   830: isub
    //   831: invokevirtual 299	java/lang/String:substring	(II)Ljava/lang/String;
    //   834: bipush 64
    //   836: bipush 47
    //   838: invokevirtual 303	java/lang/String:replace	(CC)Ljava/lang/String;
    //   841: astore 7
    //   843: aload 7
    //   845: ldc_w 305
    //   848: invokevirtual 253	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   851: ifeq -120 -> 731
    //   854: new 95	java/io/File
    //   857: dup
    //   858: aload 7
    //   860: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   863: astore 10
    //   865: ldc_w 307
    //   868: aload 10
    //   870: invokevirtual 310	java/io/File:getName	()Ljava/lang/String;
    //   873: invokevirtual 256	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   876: ifeq +96 -> 972
    //   879: aload 12
    //   881: astore 7
    //   883: aload 10
    //   885: invokevirtual 164	java/io/File:getParentFile	()Ljava/io/File;
    //   888: ifnull +13 -> 901
    //   891: aload 10
    //   893: invokevirtual 164	java/io/File:getParentFile	()Ljava/io/File;
    //   896: invokevirtual 310	java/io/File:getName	()Ljava/lang/String;
    //   899: astore 7
    //   901: aload 8
    //   903: invokestatic 313	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   906: aload 9
    //   908: invokestatic 313	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   911: aload 15
    //   913: invokevirtual 241	android/content/Context:getPackageName	()Ljava/lang/String;
    //   916: astore 8
    //   918: aload 7
    //   920: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   923: ifne +17 -> 940
    //   926: aload 7
    //   928: ldc_w 315
    //   931: invokevirtual 318	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   934: istore_2
    //   935: iload_2
    //   936: iconst_m1
    //   937: if_icmpne +188 -> 1125
    //   940: iconst_0
    //   941: istore 5
    //   943: aload 8
    //   945: astore 7
    //   947: iload 5
    //   949: ifeq +259 -> 1208
    //   952: new 166	com/tencent/turingfd/sdk/xq/while$do
    //   955: dup
    //   956: iload 5
    //   958: aload_0
    //   959: aload 7
    //   961: invokestatic 258	com/tencent/turingfd/sdk/xq/while:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   964: invokespecial 169	com/tencent/turingfd/sdk/xq/while$do:<init>	(ZLjava/lang/String;)V
    //   967: astore 7
    //   969: goto -815 -> 154
    //   972: aload 10
    //   974: invokevirtual 310	java/io/File:getName	()Ljava/lang/String;
    //   977: astore 7
    //   979: goto -78 -> 901
    //   982: aload 7
    //   984: ldc_w 305
    //   987: invokevirtual 253	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   990: istore 5
    //   992: iload 5
    //   994: ifeq -263 -> 731
    //   997: aload 7
    //   999: ldc_w 320
    //   1002: invokevirtual 291	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1005: istore 5
    //   1007: iload 5
    //   1009: ifeq -278 -> 731
    //   1012: aload 7
    //   1014: ldc 243
    //   1016: invokevirtual 323	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1019: astore 7
    //   1021: aload 7
    //   1023: arraylength
    //   1024: bipush 7
    //   1026: if_icmplt -295 -> 731
    //   1029: aload 7
    //   1031: iconst_3
    //   1032: aaload
    //   1033: astore 7
    //   1035: goto -134 -> 901
    //   1038: astore 10
    //   1040: aload 8
    //   1042: astore 7
    //   1044: aload 9
    //   1046: astore 8
    //   1048: aload 10
    //   1050: astore 9
    //   1052: aload 9
    //   1054: invokevirtual 326	java/lang/Throwable:printStackTrace	()V
    //   1057: aload 7
    //   1059: invokestatic 313	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   1062: aload 8
    //   1064: invokestatic 313	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   1067: aload 11
    //   1069: astore 7
    //   1071: goto -160 -> 911
    //   1074: astore 7
    //   1076: aconst_null
    //   1077: astore 9
    //   1079: aload 8
    //   1081: astore_0
    //   1082: aload 7
    //   1084: astore 8
    //   1086: aload 9
    //   1088: astore 7
    //   1090: aload_0
    //   1091: invokestatic 313	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   1094: aload 7
    //   1096: invokestatic 313	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   1099: aload 8
    //   1101: athrow
    //   1102: astore 9
    //   1104: aload 8
    //   1106: astore 7
    //   1108: aload 10
    //   1110: astore 8
    //   1112: goto -60 -> 1052
    //   1115: astore 8
    //   1117: aconst_null
    //   1118: astore 7
    //   1120: aconst_null
    //   1121: astore_0
    //   1122: goto -32 -> 1090
    //   1125: aload 7
    //   1127: iconst_0
    //   1128: iload_2
    //   1129: invokevirtual 299	java/lang/String:substring	(II)Ljava/lang/String;
    //   1132: astore 7
    //   1134: aload 7
    //   1136: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1139: ifne -199 -> 940
    //   1142: new 95	java/io/File
    //   1145: dup
    //   1146: new 67	java/lang/StringBuilder
    //   1149: dup
    //   1150: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   1153: ldc 249
    //   1155: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: aload 7
    //   1160: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1163: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1166: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   1169: astore 9
    //   1171: aload 9
    //   1173: invokevirtual 121	java/io/File:exists	()Z
    //   1176: ifeq +25 -> 1201
    //   1179: aload 9
    //   1181: invokevirtual 329	java/io/File:canWrite	()Z
    //   1184: ifeq +17 -> 1201
    //   1187: aload 8
    //   1189: aload 7
    //   1191: invokestatic 332	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1194: iconst_1
    //   1195: ixor
    //   1196: istore 5
    //   1198: goto -251 -> 947
    //   1201: aload 8
    //   1203: astore 7
    //   1205: goto -18 -> 1187
    //   1208: new 166	com/tencent/turingfd/sdk/xq/while$do
    //   1211: dup
    //   1212: iload 5
    //   1214: ldc 143
    //   1216: invokespecial 169	com/tencent/turingfd/sdk/xq/while$do:<init>	(ZLjava/lang/String;)V
    //   1219: astore 7
    //   1221: goto -1067 -> 154
    //   1224: new 67	java/lang/StringBuilder
    //   1227: dup
    //   1228: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   1231: astore 7
    //   1233: ldc_w 334
    //   1236: getstatic 339	android/os/Build:BRAND	Ljava/lang/String;
    //   1239: invokevirtual 342	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1242: ifeq +162 -> 1404
    //   1245: ldc_w 344
    //   1248: invokestatic 350	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1251: astore 8
    //   1253: aload_0
    //   1254: invokevirtual 354	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1257: astore 9
    //   1259: aload 9
    //   1261: ldc_w 356
    //   1264: invokevirtual 360	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   1267: astore 9
    //   1269: aload 9
    //   1271: iconst_1
    //   1272: invokevirtual 366	java/lang/reflect/Field:setAccessible	(Z)V
    //   1275: aload_0
    //   1276: aload 9
    //   1278: aload_0
    //   1279: invokevirtual 369	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1282: checkcast 52	java/lang/String
    //   1285: invokevirtual 373	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1288: astore_0
    //   1289: aload_0
    //   1290: ifnonnull +72 -> 1362
    //   1293: ldc 143
    //   1295: astore_0
    //   1296: new 52	java/lang/String
    //   1299: dup
    //   1300: ldc_w 375
    //   1303: iconst_0
    //   1304: invokestatic 381	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   1307: invokespecial 384	java/lang/String:<init>	([B)V
    //   1310: astore 8
    //   1312: aload_0
    //   1313: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1316: ifne +324 -> 1640
    //   1319: aload 8
    //   1321: aload_0
    //   1322: invokevirtual 256	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1325: istore 5
    //   1327: iload 5
    //   1329: ifeq +311 -> 1640
    //   1332: iconst_1
    //   1333: istore 5
    //   1335: aload 7
    //   1337: ldc_w 386
    //   1340: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: pop
    //   1344: new 166	com/tencent/turingfd/sdk/xq/while$do
    //   1347: dup
    //   1348: iload 5
    //   1350: aload 7
    //   1352: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1355: invokespecial 169	com/tencent/turingfd/sdk/xq/while$do:<init>	(ZLjava/lang/String;)V
    //   1358: astore_0
    //   1359: goto -1113 -> 246
    //   1362: aload 8
    //   1364: ldc_w 388
    //   1367: iconst_0
    //   1368: anewarray 346	java/lang/Class
    //   1371: invokevirtual 392	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1374: astore 8
    //   1376: aload 8
    //   1378: ifnull -85 -> 1293
    //   1381: aload 8
    //   1383: iconst_1
    //   1384: invokevirtual 395	java/lang/reflect/Method:setAccessible	(Z)V
    //   1387: aload 8
    //   1389: aload_0
    //   1390: iconst_0
    //   1391: anewarray 4	java/lang/Object
    //   1394: invokevirtual 399	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1397: checkcast 52	java/lang/String
    //   1400: astore_0
    //   1401: goto -105 -> 1296
    //   1404: ldc_w 401
    //   1407: getstatic 339	android/os/Build:BRAND	Ljava/lang/String;
    //   1410: invokevirtual 342	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1413: ifeq +24 -> 1437
    //   1416: invokestatic 404	com/tencent/turingfd/sdk/xq/while:w	()Z
    //   1419: ifeq +221 -> 1640
    //   1422: iconst_1
    //   1423: istore 5
    //   1425: aload 7
    //   1427: ldc_w 406
    //   1430: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1433: pop
    //   1434: goto -90 -> 1344
    //   1437: ldc_w 408
    //   1440: getstatic 339	android/os/Build:BRAND	Ljava/lang/String;
    //   1443: invokevirtual 342	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1446: ifeq +24 -> 1470
    //   1449: invokestatic 404	com/tencent/turingfd/sdk/xq/while:w	()Z
    //   1452: ifeq +188 -> 1640
    //   1455: iconst_1
    //   1456: istore 5
    //   1458: aload 7
    //   1460: ldc_w 410
    //   1463: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: pop
    //   1467: goto -123 -> 1344
    //   1470: ldc_w 412
    //   1473: getstatic 339	android/os/Build:BRAND	Ljava/lang/String;
    //   1476: invokevirtual 342	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1479: ifeq +161 -> 1640
    //   1482: invokestatic 404	com/tencent/turingfd/sdk/xq/while:w	()Z
    //   1485: ifeq +18 -> 1503
    //   1488: iconst_1
    //   1489: istore 5
    //   1491: aload 7
    //   1493: ldc_w 414
    //   1496: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: pop
    //   1500: goto -156 -> 1344
    //   1503: new 52	java/lang/String
    //   1506: dup
    //   1507: ldc_w 416
    //   1510: invokestatic 421	com/tencent/turingfd/sdk/xq/extends:h	(Ljava/lang/String;)[B
    //   1513: invokespecial 384	java/lang/String:<init>	([B)V
    //   1516: astore 8
    //   1518: new 67	java/lang/StringBuilder
    //   1521: dup
    //   1522: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   1525: aload_0
    //   1526: invokevirtual 157	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   1529: invokevirtual 241	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1532: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: astore_0
    //   1536: aload 8
    //   1538: aload_0
    //   1539: ldc_w 423
    //   1542: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1545: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1548: invokevirtual 426	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1551: istore 5
    //   1553: iload 5
    //   1555: ifeq +85 -> 1640
    //   1558: iconst_1
    //   1559: istore 5
    //   1561: aload 7
    //   1563: ldc_w 428
    //   1566: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1569: pop
    //   1570: goto -226 -> 1344
    //   1573: iconst_1
    //   1574: istore 5
    //   1576: astore_0
    //   1577: goto -233 -> 1344
    //   1580: aload 13
    //   1582: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1585: areturn
    //   1586: astore_0
    //   1587: aload 9
    //   1589: astore 7
    //   1591: aload_0
    //   1592: astore 9
    //   1594: aload 8
    //   1596: astore_0
    //   1597: aload 9
    //   1599: astore 8
    //   1601: goto -511 -> 1090
    //   1604: astore 9
    //   1606: aload 7
    //   1608: astore_0
    //   1609: aload 8
    //   1611: astore 7
    //   1613: aload 9
    //   1615: astore 8
    //   1617: goto -527 -> 1090
    //   1620: astore_0
    //   1621: iconst_0
    //   1622: istore 5
    //   1624: goto -280 -> 1344
    //   1627: astore_0
    //   1628: goto -335 -> 1293
    //   1631: astore 9
    //   1633: aload 10
    //   1635: astore 8
    //   1637: goto -585 -> 1052
    //   1640: iconst_0
    //   1641: istore 5
    //   1643: goto -299 -> 1344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1646	0	paramContext	Context
    //   76	617	1	i	int
    //   484	645	2	j	int
    //   12	363	3	l	long
    //   489	1153	5	bool1	boolean
    //   474	14	6	bool2	boolean
    //   32	1038	7	localObject1	Object
    //   1074	9	7	localObject2	Object
    //   1088	524	7	localObject3	Object
    //   84	1027	8	localObject4	Object
    //   1115	87	8	localCharSequence	java.lang.CharSequence
    //   1251	385	8	localObject5	Object
    //   479	608	9	localObject6	Object
    //   1102	1	9	localThrowable1	Throwable
    //   1169	429	9	localObject7	Object
    //   1604	10	9	localObject8	Object
    //   1631	1	9	localThrowable2	Throwable
    //   542	431	10	localObject9	Object
    //   1038	596	10	localThrowable3	Throwable
    //   703	365	11	localObject10	Object
    //   706	174	12	localObject11	Object
    //   7	1574	13	localStringBuilder	StringBuilder
    //   20	360	14	localArrayList	java.util.ArrayList
    //   135	777	15	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   731	738	1038	java/lang/Throwable
    //   747	755	1038	java/lang/Throwable
    //   760	775	1038	java/lang/Throwable
    //   781	791	1038	java/lang/Throwable
    //   796	815	1038	java/lang/Throwable
    //   820	843	1038	java/lang/Throwable
    //   843	865	1038	java/lang/Throwable
    //   865	879	1038	java/lang/Throwable
    //   883	901	1038	java/lang/Throwable
    //   972	979	1038	java/lang/Throwable
    //   982	992	1038	java/lang/Throwable
    //   997	1007	1038	java/lang/Throwable
    //   1012	1029	1038	java/lang/Throwable
    //   720	731	1074	finally
    //   720	731	1102	java/lang/Throwable
    //   708	720	1115	finally
    //   1335	1344	1573	java/lang/Throwable
    //   1561	1570	1573	java/lang/Throwable
    //   731	738	1586	finally
    //   747	755	1586	finally
    //   760	775	1586	finally
    //   781	791	1586	finally
    //   796	815	1586	finally
    //   820	843	1586	finally
    //   843	865	1586	finally
    //   865	879	1586	finally
    //   883	901	1586	finally
    //   972	979	1586	finally
    //   982	992	1586	finally
    //   997	1007	1586	finally
    //   1012	1029	1586	finally
    //   1052	1057	1604	finally
    //   1296	1327	1620	java/lang/Throwable
    //   1503	1536	1620	java/lang/Throwable
    //   1536	1553	1620	java/lang/Throwable
    //   1245	1259	1627	java/lang/Throwable
    //   1259	1289	1627	java/lang/Throwable
    //   1362	1376	1627	java/lang/Throwable
    //   1381	1401	1627	java/lang/Throwable
    //   708	720	1631	java/lang/Throwable
  }
  
  public static String v()
  {
    return wf;
  }
  
  public static boolean w()
  {
    try
    {
      int i = Process.myUid() / 100000;
      if (999 == i) {
        return true;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.while
 * JD-Core Version:    0.7.0.1
 */