package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.List;

public class class
{
  public static final String lb = else.get(else.F);
  public static final String ub = else.get(else.G);
  public static final String vb = else.get(else.H);
  public static final String wb = else.get(else.I);
  public static final String xb = else.get(else.J);
  public static long yb = 0L;
  public static final String[] zb = { "^/data/user/\\d+$", "^/data/data$" };
  
  public static String a(Context paramContext, String paramString)
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
          localStringBuilder.append((String)for.b(new File(paramContext)).get(0));
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
    //   0: new 66	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   7: astore 12
    //   9: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   12: lstore_3
    //   13: new 151	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 152	java/util/ArrayList:<init>	()V
    //   20: astore 13
    //   22: aload_0
    //   23: invokevirtual 156	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   26: invokevirtual 160	android/content/Context:getFilesDir	()Ljava/io/File;
    //   29: invokevirtual 163	java/io/File:getParentFile	()Ljava/io/File;
    //   32: astore 7
    //   34: aload 7
    //   36: ifnonnull +423 -> 459
    //   39: new 165	com/tencent/turingfd/sdk/xq/class$do
    //   42: dup
    //   43: iconst_0
    //   44: ldc 142
    //   46: invokespecial 168	com/tencent/turingfd/sdk/xq/class$do:<init>	(ZLjava/lang/String;)V
    //   49: astore 7
    //   51: aload 7
    //   53: getfield 172	com/tencent/turingfd/sdk/xq/class$do:match	Z
    //   56: ifeq +642 -> 698
    //   59: aload 7
    //   61: getfield 175	com/tencent/turingfd/sdk/xq/class$do:tb	Ljava/lang/String;
    //   64: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifne +631 -> 698
    //   70: iconst_0
    //   71: iconst_1
    //   72: iconst_0
    //   73: invokestatic 178	com/tencent/turingfd/sdk/xq/for:a	(IZI)I
    //   76: istore_1
    //   77: new 180	com/tencent/turingfd/sdk/xq/import
    //   80: dup
    //   81: invokespecial 181	com/tencent/turingfd/sdk/xq/import:<init>	()V
    //   84: astore 8
    //   86: aload 8
    //   88: new 66	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   95: getstatic 28	com/tencent/turingfd/sdk/xq/class:lb	Ljava/lang/String;
    //   98: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: getstatic 38	com/tencent/turingfd/sdk/xq/class:vb	Ljava/lang/String;
    //   104: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: putfield 184	com/tencent/turingfd/sdk/xq/import:Nb	Ljava/lang/String;
    //   113: aload 8
    //   115: aload 7
    //   117: getfield 175	com/tencent/turingfd/sdk/xq/class$do:tb	Ljava/lang/String;
    //   120: putfield 187	com/tencent/turingfd/sdk/xq/import:Ob	Ljava/lang/String;
    //   123: aload 13
    //   125: aload 8
    //   127: invokevirtual 191	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   130: pop
    //   131: aload_0
    //   132: invokevirtual 156	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   135: astore 14
    //   137: aload 14
    //   139: ifnonnull +569 -> 708
    //   142: new 165	com/tencent/turingfd/sdk/xq/class$do
    //   145: dup
    //   146: iconst_0
    //   147: ldc 142
    //   149: invokespecial 168	com/tencent/turingfd/sdk/xq/class$do:<init>	(ZLjava/lang/String;)V
    //   152: astore 7
    //   154: iload_1
    //   155: aload 7
    //   157: getfield 172	com/tencent/turingfd/sdk/xq/class$do:match	Z
    //   160: iconst_1
    //   161: invokestatic 178	com/tencent/turingfd/sdk/xq/for:a	(IZI)I
    //   164: istore_1
    //   165: aload 7
    //   167: getfield 172	com/tencent/turingfd/sdk/xq/class$do:match	Z
    //   170: ifeq +57 -> 227
    //   173: new 180	com/tencent/turingfd/sdk/xq/import
    //   176: dup
    //   177: invokespecial 181	com/tencent/turingfd/sdk/xq/import:<init>	()V
    //   180: astore 8
    //   182: aload 8
    //   184: new 66	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   191: getstatic 28	com/tencent/turingfd/sdk/xq/class:lb	Ljava/lang/String;
    //   194: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: getstatic 43	com/tencent/turingfd/sdk/xq/class:wb	Ljava/lang/String;
    //   200: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: putfield 184	com/tencent/turingfd/sdk/xq/import:Nb	Ljava/lang/String;
    //   209: aload 8
    //   211: aload 7
    //   213: getfield 175	com/tencent/turingfd/sdk/xq/class$do:tb	Ljava/lang/String;
    //   216: putfield 187	com/tencent/turingfd/sdk/xq/import:Ob	Ljava/lang/String;
    //   219: aload 13
    //   221: aload 8
    //   223: invokevirtual 191	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   226: pop
    //   227: getstatic 196	android/os/Build$VERSION:SDK_INT	I
    //   230: bipush 17
    //   232: if_icmpge +997 -> 1229
    //   235: new 165	com/tencent/turingfd/sdk/xq/class$do
    //   238: dup
    //   239: iconst_0
    //   240: ldc 142
    //   242: invokespecial 168	com/tencent/turingfd/sdk/xq/class$do:<init>	(ZLjava/lang/String;)V
    //   245: astore_0
    //   246: iload_1
    //   247: aload_0
    //   248: getfield 172	com/tencent/turingfd/sdk/xq/class$do:match	Z
    //   251: iconst_2
    //   252: invokestatic 178	com/tencent/turingfd/sdk/xq/for:a	(IZI)I
    //   255: istore_1
    //   256: aload_0
    //   257: getfield 172	com/tencent/turingfd/sdk/xq/class$do:match	Z
    //   260: ifeq +56 -> 316
    //   263: new 180	com/tencent/turingfd/sdk/xq/import
    //   266: dup
    //   267: invokespecial 181	com/tencent/turingfd/sdk/xq/import:<init>	()V
    //   270: astore 7
    //   272: aload 7
    //   274: new 66	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   281: getstatic 28	com/tencent/turingfd/sdk/xq/class:lb	Ljava/lang/String;
    //   284: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: getstatic 47	com/tencent/turingfd/sdk/xq/class:xb	Ljava/lang/String;
    //   290: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: putfield 184	com/tencent/turingfd/sdk/xq/import:Nb	Ljava/lang/String;
    //   299: aload 7
    //   301: aload_0
    //   302: getfield 175	com/tencent/turingfd/sdk/xq/class$do:tb	Ljava/lang/String;
    //   305: putfield 187	com/tencent/turingfd/sdk/xq/import:Ob	Ljava/lang/String;
    //   308: aload 13
    //   310: aload 7
    //   312: invokevirtual 191	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   315: pop
    //   316: iload_1
    //   317: ifle +67 -> 384
    //   320: new 180	com/tencent/turingfd/sdk/xq/import
    //   323: dup
    //   324: invokespecial 181	com/tencent/turingfd/sdk/xq/import:<init>	()V
    //   327: astore_0
    //   328: aload_0
    //   329: new 66	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   336: getstatic 28	com/tencent/turingfd/sdk/xq/class:lb	Ljava/lang/String;
    //   339: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: getstatic 33	com/tencent/turingfd/sdk/xq/class:ub	Ljava/lang/String;
    //   345: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: putfield 184	com/tencent/turingfd/sdk/xq/import:Nb	Ljava/lang/String;
    //   354: aload_0
    //   355: new 66	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   362: ldc 142
    //   364: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: iload_1
    //   368: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: putfield 187	com/tencent/turingfd/sdk/xq/import:Ob	Ljava/lang/String;
    //   377: aload 13
    //   379: aload_0
    //   380: invokevirtual 191	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   383: pop
    //   384: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   387: lload_3
    //   388: lsub
    //   389: putstatic 49	com/tencent/turingfd/sdk/xq/class:yb	J
    //   392: aload 13
    //   394: invokevirtual 200	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   397: astore_0
    //   398: aload_0
    //   399: invokeinterface 205 1 0
    //   404: ifeq +1181 -> 1585
    //   407: aload_0
    //   408: invokeinterface 209 1 0
    //   413: checkcast 180	com/tencent/turingfd/sdk/xq/import
    //   416: astore 7
    //   418: aload 12
    //   420: aload 7
    //   422: getfield 184	com/tencent/turingfd/sdk/xq/import:Nb	Ljava/lang/String;
    //   425: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 12
    //   431: ldc 211
    //   433: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload 12
    //   439: aload 7
    //   441: getfield 187	com/tencent/turingfd/sdk/xq/import:Ob	Ljava/lang/String;
    //   444: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload 12
    //   450: ldc 213
    //   452: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: goto -58 -> 398
    //   459: aload 7
    //   461: invokevirtual 163	java/io/File:getParentFile	()Ljava/io/File;
    //   464: astore 8
    //   466: aload 8
    //   468: ifnonnull +18 -> 486
    //   471: new 165	com/tencent/turingfd/sdk/xq/class$do
    //   474: dup
    //   475: iconst_0
    //   476: ldc 142
    //   478: invokespecial 168	com/tencent/turingfd/sdk/xq/class$do:<init>	(ZLjava/lang/String;)V
    //   481: astore 7
    //   483: goto -432 -> 51
    //   486: iconst_1
    //   487: istore 6
    //   489: getstatic 57	com/tencent/turingfd/sdk/xq/class:zb	[Ljava/lang/String;
    //   492: astore 9
    //   494: aload 9
    //   496: arraylength
    //   497: istore_2
    //   498: iconst_0
    //   499: istore_1
    //   500: iload 6
    //   502: istore 5
    //   504: iload_1
    //   505: iload_2
    //   506: if_icmpge +27 -> 533
    //   509: aload 9
    //   511: iload_1
    //   512: aaload
    //   513: invokestatic 219	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   516: aload 8
    //   518: invokevirtual 222	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   521: invokevirtual 226	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   524: invokevirtual 231	java/util/regex/Matcher:find	()Z
    //   527: ifeq +100 -> 627
    //   530: iconst_0
    //   531: istore 5
    //   533: aload 7
    //   535: invokevirtual 222	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   538: astore 9
    //   540: aload_0
    //   541: invokevirtual 234	android/content/Context:getPackageName	()Ljava/lang/String;
    //   544: astore 8
    //   546: aload 9
    //   548: ldc 236
    //   550: bipush 6
    //   552: invokevirtual 240	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   555: astore 10
    //   557: aload 9
    //   559: ldc 242
    //   561: invokevirtual 246	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   564: ifeq +70 -> 634
    //   567: aload 10
    //   569: arraylength
    //   570: iconst_4
    //   571: if_icmplt +63 -> 634
    //   574: aload 10
    //   576: iconst_3
    //   577: aaload
    //   578: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   581: ifne +53 -> 634
    //   584: aload 10
    //   586: iconst_3
    //   587: aaload
    //   588: astore 7
    //   590: iload 5
    //   592: ifeq +90 -> 682
    //   595: aload 7
    //   597: aload_0
    //   598: invokevirtual 234	android/content/Context:getPackageName	()Ljava/lang/String;
    //   601: invokevirtual 249	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   604: ifne +78 -> 682
    //   607: new 165	com/tencent/turingfd/sdk/xq/class$do
    //   610: dup
    //   611: iload 5
    //   613: aload_0
    //   614: aload 7
    //   616: invokestatic 251	com/tencent/turingfd/sdk/xq/class:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   619: invokespecial 168	com/tencent/turingfd/sdk/xq/class$do:<init>	(ZLjava/lang/String;)V
    //   622: astore 7
    //   624: goto -573 -> 51
    //   627: iload_1
    //   628: iconst_1
    //   629: iadd
    //   630: istore_1
    //   631: goto -131 -> 500
    //   634: aload 8
    //   636: astore 7
    //   638: aload 9
    //   640: ldc 253
    //   642: invokevirtual 246	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   645: ifeq -55 -> 590
    //   648: aload 8
    //   650: astore 7
    //   652: aload 10
    //   654: arraylength
    //   655: iconst_5
    //   656: if_icmplt -66 -> 590
    //   659: aload 8
    //   661: astore 7
    //   663: aload 10
    //   665: iconst_4
    //   666: aaload
    //   667: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   670: ifne -80 -> 590
    //   673: aload 10
    //   675: iconst_4
    //   676: aaload
    //   677: astore 7
    //   679: goto -89 -> 590
    //   682: new 165	com/tencent/turingfd/sdk/xq/class$do
    //   685: dup
    //   686: iload 5
    //   688: ldc 142
    //   690: invokespecial 168	com/tencent/turingfd/sdk/xq/class$do:<init>	(ZLjava/lang/String;)V
    //   693: astore 7
    //   695: goto -644 -> 51
    //   698: iconst_0
    //   699: iconst_0
    //   700: iconst_0
    //   701: invokestatic 178	com/tencent/turingfd/sdk/xq/for:a	(IZI)I
    //   704: istore_1
    //   705: goto -574 -> 131
    //   708: aconst_null
    //   709: astore 7
    //   711: aconst_null
    //   712: astore 10
    //   714: aconst_null
    //   715: astore 11
    //   717: new 255	java/io/FileReader
    //   720: dup
    //   721: ldc_w 257
    //   724: invokespecial 258	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   727: astore 8
    //   729: new 260	java/io/BufferedReader
    //   732: dup
    //   733: aload 8
    //   735: invokespecial 263	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   738: astore 9
    //   740: aload 9
    //   742: invokevirtual 266	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   745: astore 15
    //   747: aload 11
    //   749: astore 7
    //   751: aload 15
    //   753: ifnull +157 -> 910
    //   756: aload 15
    //   758: bipush 47
    //   760: invokevirtual 270	java/lang/String:indexOf	(I)I
    //   763: istore_2
    //   764: iload_2
    //   765: iconst_m1
    //   766: if_icmpeq -26 -> 740
    //   769: aload 15
    //   771: iload_2
    //   772: invokevirtual 274	java/lang/String:substring	(I)Ljava/lang/String;
    //   775: invokevirtual 277	java/lang/String:trim	()Ljava/lang/String;
    //   778: astore 7
    //   780: getstatic 196	android/os/Build$VERSION:SDK_INT	I
    //   783: istore_2
    //   784: iload_2
    //   785: bipush 23
    //   787: if_icmpge +204 -> 991
    //   790: aload 7
    //   792: ldc_w 279
    //   795: invokevirtual 246	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   798: istore 5
    //   800: iload 5
    //   802: ifeq -62 -> 740
    //   805: aload 7
    //   807: ldc_w 281
    //   810: invokevirtual 284	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   813: ifeq -73 -> 740
    //   816: aload 7
    //   818: bipush 47
    //   820: invokevirtual 287	java/lang/String:lastIndexOf	(I)I
    //   823: istore_2
    //   824: iload_2
    //   825: iconst_m1
    //   826: if_icmpeq -86 -> 740
    //   829: aload 7
    //   831: iload_2
    //   832: aload 7
    //   834: invokevirtual 289	java/lang/String:length	()I
    //   837: bipush 12
    //   839: isub
    //   840: invokevirtual 292	java/lang/String:substring	(II)Ljava/lang/String;
    //   843: bipush 64
    //   845: bipush 47
    //   847: invokevirtual 296	java/lang/String:replace	(CC)Ljava/lang/String;
    //   850: astore 7
    //   852: aload 7
    //   854: ldc_w 298
    //   857: invokevirtual 246	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   860: ifeq -120 -> 740
    //   863: new 94	java/io/File
    //   866: dup
    //   867: aload 7
    //   869: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   872: astore 15
    //   874: ldc_w 300
    //   877: aload 15
    //   879: invokevirtual 303	java/io/File:getName	()Ljava/lang/String;
    //   882: invokevirtual 249	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   885: ifeq +96 -> 981
    //   888: aload 11
    //   890: astore 7
    //   892: aload 15
    //   894: invokevirtual 163	java/io/File:getParentFile	()Ljava/io/File;
    //   897: ifnull +13 -> 910
    //   900: aload 15
    //   902: invokevirtual 163	java/io/File:getParentFile	()Ljava/io/File;
    //   905: invokevirtual 303	java/io/File:getName	()Ljava/lang/String;
    //   908: astore 7
    //   910: aload 8
    //   912: invokestatic 306	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   915: aload 9
    //   917: invokestatic 306	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   920: aload 14
    //   922: invokevirtual 234	android/content/Context:getPackageName	()Ljava/lang/String;
    //   925: astore 8
    //   927: aload 7
    //   929: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   932: ifne +17 -> 949
    //   935: aload 7
    //   937: ldc_w 308
    //   940: invokevirtual 311	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   943: istore_2
    //   944: iload_2
    //   945: iconst_m1
    //   946: if_icmpne +184 -> 1130
    //   949: iconst_0
    //   950: istore 5
    //   952: aload 8
    //   954: astore 7
    //   956: iload 5
    //   958: ifeq +255 -> 1213
    //   961: new 165	com/tencent/turingfd/sdk/xq/class$do
    //   964: dup
    //   965: iload 5
    //   967: aload_0
    //   968: aload 7
    //   970: invokestatic 251	com/tencent/turingfd/sdk/xq/class:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   973: invokespecial 168	com/tencent/turingfd/sdk/xq/class$do:<init>	(ZLjava/lang/String;)V
    //   976: astore 7
    //   978: goto -824 -> 154
    //   981: aload 15
    //   983: invokevirtual 303	java/io/File:getName	()Ljava/lang/String;
    //   986: astore 7
    //   988: goto -78 -> 910
    //   991: aload 7
    //   993: ldc_w 298
    //   996: invokevirtual 246	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   999: istore 5
    //   1001: iload 5
    //   1003: ifeq -263 -> 740
    //   1006: aload 7
    //   1008: ldc_w 313
    //   1011: invokevirtual 284	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1014: istore 5
    //   1016: iload 5
    //   1018: ifeq -278 -> 740
    //   1021: aload 7
    //   1023: ldc 236
    //   1025: invokevirtual 316	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1028: astore 7
    //   1030: aload 7
    //   1032: arraylength
    //   1033: bipush 7
    //   1035: if_icmplt -295 -> 740
    //   1038: aload 7
    //   1040: iconst_3
    //   1041: aaload
    //   1042: astore 7
    //   1044: goto -134 -> 910
    //   1047: astore_0
    //   1048: aload 9
    //   1050: astore 7
    //   1052: aload_0
    //   1053: astore 9
    //   1055: aload 8
    //   1057: astore_0
    //   1058: aload 9
    //   1060: astore 8
    //   1062: aload_0
    //   1063: invokestatic 306	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   1066: aload 7
    //   1068: invokestatic 306	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   1071: aload 8
    //   1073: athrow
    //   1074: astore 7
    //   1076: aload 9
    //   1078: astore 7
    //   1080: aload 8
    //   1082: invokestatic 306	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   1085: aload 7
    //   1087: invokestatic 306	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   1090: aload 10
    //   1092: astore 7
    //   1094: goto -174 -> 920
    //   1097: astore 9
    //   1099: aconst_null
    //   1100: astore 7
    //   1102: aload 8
    //   1104: astore_0
    //   1105: aload 9
    //   1107: astore 8
    //   1109: goto -47 -> 1062
    //   1112: astore 8
    //   1114: aconst_null
    //   1115: astore 7
    //   1117: aconst_null
    //   1118: astore_0
    //   1119: goto -57 -> 1062
    //   1122: astore 8
    //   1124: aconst_null
    //   1125: astore 8
    //   1127: goto -47 -> 1080
    //   1130: aload 7
    //   1132: iconst_0
    //   1133: iload_2
    //   1134: invokevirtual 292	java/lang/String:substring	(II)Ljava/lang/String;
    //   1137: astore 7
    //   1139: aload 7
    //   1141: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1144: ifne -195 -> 949
    //   1147: new 94	java/io/File
    //   1150: dup
    //   1151: new 66	java/lang/StringBuilder
    //   1154: dup
    //   1155: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1158: ldc 242
    //   1160: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1163: aload 7
    //   1165: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1171: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   1174: astore 9
    //   1176: aload 9
    //   1178: invokevirtual 120	java/io/File:exists	()Z
    //   1181: ifeq +25 -> 1206
    //   1184: aload 9
    //   1186: invokevirtual 319	java/io/File:canWrite	()Z
    //   1189: ifeq +17 -> 1206
    //   1192: aload 8
    //   1194: aload 7
    //   1196: invokestatic 322	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1199: iconst_1
    //   1200: ixor
    //   1201: istore 5
    //   1203: goto -247 -> 956
    //   1206: aload 8
    //   1208: astore 7
    //   1210: goto -18 -> 1192
    //   1213: new 165	com/tencent/turingfd/sdk/xq/class$do
    //   1216: dup
    //   1217: iload 5
    //   1219: ldc 142
    //   1221: invokespecial 168	com/tencent/turingfd/sdk/xq/class$do:<init>	(ZLjava/lang/String;)V
    //   1224: astore 7
    //   1226: goto -1072 -> 154
    //   1229: new 66	java/lang/StringBuilder
    //   1232: dup
    //   1233: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1236: astore 7
    //   1238: ldc_w 324
    //   1241: getstatic 329	android/os/Build:BRAND	Ljava/lang/String;
    //   1244: invokevirtual 332	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1247: ifeq +162 -> 1409
    //   1250: ldc_w 334
    //   1253: invokestatic 340	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1256: astore 8
    //   1258: aload_0
    //   1259: invokevirtual 344	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1262: astore 9
    //   1264: aload 9
    //   1266: ldc_w 346
    //   1269: invokevirtual 350	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   1272: astore 9
    //   1274: aload 9
    //   1276: iconst_1
    //   1277: invokevirtual 356	java/lang/reflect/Field:setAccessible	(Z)V
    //   1280: aload_0
    //   1281: aload 9
    //   1283: aload_0
    //   1284: invokevirtual 359	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1287: checkcast 51	java/lang/String
    //   1290: invokevirtual 363	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1293: astore_0
    //   1294: aload_0
    //   1295: ifnonnull +72 -> 1367
    //   1298: ldc 142
    //   1300: astore_0
    //   1301: new 51	java/lang/String
    //   1304: dup
    //   1305: ldc_w 365
    //   1308: iconst_0
    //   1309: invokestatic 371	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   1312: invokespecial 374	java/lang/String:<init>	([B)V
    //   1315: astore 8
    //   1317: aload_0
    //   1318: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1321: ifne +286 -> 1607
    //   1324: aload 8
    //   1326: aload_0
    //   1327: invokevirtual 249	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1330: istore 5
    //   1332: iload 5
    //   1334: ifeq +273 -> 1607
    //   1337: iconst_1
    //   1338: istore 5
    //   1340: aload 7
    //   1342: ldc_w 376
    //   1345: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: pop
    //   1349: new 165	com/tencent/turingfd/sdk/xq/class$do
    //   1352: dup
    //   1353: iload 5
    //   1355: aload 7
    //   1357: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1360: invokespecial 168	com/tencent/turingfd/sdk/xq/class$do:<init>	(ZLjava/lang/String;)V
    //   1363: astore_0
    //   1364: goto -1118 -> 246
    //   1367: aload 8
    //   1369: ldc_w 378
    //   1372: iconst_0
    //   1373: anewarray 336	java/lang/Class
    //   1376: invokevirtual 382	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1379: astore 8
    //   1381: aload 8
    //   1383: ifnull -85 -> 1298
    //   1386: aload 8
    //   1388: iconst_1
    //   1389: invokevirtual 385	java/lang/reflect/Method:setAccessible	(Z)V
    //   1392: aload 8
    //   1394: aload_0
    //   1395: iconst_0
    //   1396: anewarray 4	java/lang/Object
    //   1399: invokevirtual 389	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1402: checkcast 51	java/lang/String
    //   1405: astore_0
    //   1406: goto -105 -> 1301
    //   1409: ldc_w 391
    //   1412: getstatic 329	android/os/Build:BRAND	Ljava/lang/String;
    //   1415: invokevirtual 332	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1418: ifeq +24 -> 1442
    //   1421: invokestatic 394	com/tencent/turingfd/sdk/xq/class:q	()Z
    //   1424: ifeq +183 -> 1607
    //   1427: iconst_1
    //   1428: istore 5
    //   1430: aload 7
    //   1432: ldc_w 396
    //   1435: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1438: pop
    //   1439: goto -90 -> 1349
    //   1442: ldc_w 398
    //   1445: getstatic 329	android/os/Build:BRAND	Ljava/lang/String;
    //   1448: invokevirtual 332	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1451: ifeq +24 -> 1475
    //   1454: invokestatic 394	com/tencent/turingfd/sdk/xq/class:q	()Z
    //   1457: ifeq +150 -> 1607
    //   1460: iconst_1
    //   1461: istore 5
    //   1463: aload 7
    //   1465: ldc_w 400
    //   1468: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1471: pop
    //   1472: goto -123 -> 1349
    //   1475: ldc_w 402
    //   1478: getstatic 329	android/os/Build:BRAND	Ljava/lang/String;
    //   1481: invokevirtual 332	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1484: ifeq +123 -> 1607
    //   1487: invokestatic 394	com/tencent/turingfd/sdk/xq/class:q	()Z
    //   1490: ifeq +18 -> 1508
    //   1493: iconst_1
    //   1494: istore 5
    //   1496: aload 7
    //   1498: ldc_w 404
    //   1501: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1504: pop
    //   1505: goto -156 -> 1349
    //   1508: new 51	java/lang/String
    //   1511: dup
    //   1512: ldc_w 406
    //   1515: invokestatic 409	com/tencent/turingfd/sdk/xq/for:b	(Ljava/lang/String;)[B
    //   1518: invokespecial 374	java/lang/String:<init>	([B)V
    //   1521: astore 8
    //   1523: new 66	java/lang/StringBuilder
    //   1526: dup
    //   1527: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1530: aload_0
    //   1531: invokevirtual 156	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   1534: invokevirtual 234	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1537: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1540: astore_0
    //   1541: aload 8
    //   1543: aload_0
    //   1544: ldc_w 411
    //   1547: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1553: invokevirtual 414	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1556: istore 5
    //   1558: iload 5
    //   1560: ifeq +47 -> 1607
    //   1563: iconst_1
    //   1564: istore 5
    //   1566: aload 7
    //   1568: ldc_w 416
    //   1571: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1574: pop
    //   1575: goto -226 -> 1349
    //   1578: iconst_1
    //   1579: istore 5
    //   1581: astore_0
    //   1582: goto -233 -> 1349
    //   1585: aload 12
    //   1587: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1590: areturn
    //   1591: astore_0
    //   1592: iconst_0
    //   1593: istore 5
    //   1595: goto -246 -> 1349
    //   1598: astore_0
    //   1599: goto -301 -> 1298
    //   1602: astore 9
    //   1604: goto -524 -> 1080
    //   1607: iconst_0
    //   1608: istore 5
    //   1610: goto -261 -> 1349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1613	0	paramContext	Context
    //   76	629	1	i	int
    //   497	637	2	j	int
    //   12	376	3	l	long
    //   502	1107	5	bool1	boolean
    //   487	14	6	bool2	boolean
    //   32	1035	7	localObject1	Object
    //   1074	1	7	localThrowable1	Throwable
    //   1078	489	7	localObject2	Object
    //   84	1024	8	localObject3	Object
    //   1112	1	8	localObject4	Object
    //   1122	1	8	localThrowable2	Throwable
    //   1125	417	8	localObject5	Object
    //   492	585	9	localObject6	Object
    //   1097	9	9	localObject7	Object
    //   1174	108	9	localObject8	Object
    //   1602	1	9	localThrowable3	Throwable
    //   555	536	10	arrayOfString	String[]
    //   715	174	11	localObject9	Object
    //   7	1579	12	localStringBuilder	StringBuilder
    //   20	373	13	localArrayList	java.util.ArrayList
    //   135	786	14	localContext	Context
    //   745	237	15	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   740	747	1047	finally
    //   756	764	1047	finally
    //   769	784	1047	finally
    //   790	800	1047	finally
    //   805	824	1047	finally
    //   829	852	1047	finally
    //   852	874	1047	finally
    //   874	888	1047	finally
    //   892	910	1047	finally
    //   981	988	1047	finally
    //   991	1001	1047	finally
    //   1006	1016	1047	finally
    //   1021	1038	1047	finally
    //   740	747	1074	java/lang/Throwable
    //   756	764	1074	java/lang/Throwable
    //   769	784	1074	java/lang/Throwable
    //   790	800	1074	java/lang/Throwable
    //   805	824	1074	java/lang/Throwable
    //   829	852	1074	java/lang/Throwable
    //   852	874	1074	java/lang/Throwable
    //   874	888	1074	java/lang/Throwable
    //   892	910	1074	java/lang/Throwable
    //   981	988	1074	java/lang/Throwable
    //   991	1001	1074	java/lang/Throwable
    //   1006	1016	1074	java/lang/Throwable
    //   1021	1038	1074	java/lang/Throwable
    //   729	740	1097	finally
    //   717	729	1112	finally
    //   717	729	1122	java/lang/Throwable
    //   1340	1349	1578	java/lang/Throwable
    //   1566	1575	1578	java/lang/Throwable
    //   1301	1332	1591	java/lang/Throwable
    //   1508	1541	1591	java/lang/Throwable
    //   1541	1558	1591	java/lang/Throwable
    //   1250	1264	1598	java/lang/Throwable
    //   1264	1294	1598	java/lang/Throwable
    //   1367	1381	1598	java/lang/Throwable
    //   1386	1406	1598	java/lang/Throwable
    //   729	740	1602	java/lang/Throwable
  }
  
  public static String p()
  {
    return "" + yb;
  }
  
  public static boolean q()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.class
 * JD-Core Version:    0.7.0.1
 */