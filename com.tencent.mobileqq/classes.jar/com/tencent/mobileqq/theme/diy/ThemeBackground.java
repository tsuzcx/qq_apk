package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ThemeBackground
{
  public static final int BG_TYPE_CONVERSATION = 2;
  public static final int BG_TYPE_SETTING = 1;
  public static final String DIY_DEFAULT_BG_ID = "100";
  public static final String DIY_UPLOAD_BG_ID = "99";
  public static final int PAGE_INDEX_MSG = 100;
  static final String TAG = "ThemeBackground";
  public static boolean needUpdateThemeForBg;
  public Drawable img;
  public boolean isAnimateBg;
  public boolean isDecodeInDiy;
  public boolean isNeedImg = true;
  public int pageIndex;
  public String path;
  
  public static void clear(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("theme_background_path_" + paramString2, 0).edit();
    paramContext.putString(paramString1, "null");
    paramContext.putBoolean(paramString1 + "_from", false);
    paramContext.commit();
  }
  
  public static boolean getMarkOfAioBgFromDiy(Context paramContext, String paramString1, String paramString2)
  {
    String str;
    if ((!TextUtils.isEmpty(paramString1)) && ("theme_bg_aio_path".equals(paramString1)))
    {
      str = paramContext.getSharedPreferences("chat_background_path_" + paramString2, 0).getString("chat_uniform_bg", "null");
      if (!TextUtils.isEmpty(str)) {
        break label59;
      }
    }
    label59:
    do
    {
      return false;
      paramContext = paramContext.getSharedPreferences("theme_background_path_" + paramString2, 0);
      paramString2 = paramContext.getString(paramString1, null);
    } while ((TextUtils.isEmpty(paramString2)) || (!str.equals(paramString2)));
    return paramContext.getBoolean(paramString1 + "_from", false);
  }
  
  /* Error */
  public static boolean getThemeBackground(Context paramContext, String paramString1, String paramString2, ThemeBackground paramThemeBackground)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_3
    //   4: ifnull +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +20 -> 28
    //   11: ldc 21
    //   13: iconst_2
    //   14: ldc 120
    //   16: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: iconst_0
    //   20: istore 6
    //   22: ldc 2
    //   24: monitorexit
    //   25: iload 6
    //   27: ireturn
    //   28: aload_0
    //   29: new 41	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   36: ldc 44
    //   38: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_2
    //   42: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: iconst_0
    //   49: invokevirtual 58	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   52: astore 10
    //   54: aload 10
    //   56: aload_1
    //   57: ldc 66
    //   59: invokeinterface 106 3 0
    //   64: astore 9
    //   66: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +84 -> 153
    //   72: new 41	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   79: ldc 131
    //   81: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_1
    //   85: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc 133
    //   90: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload 9
    //   95: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 135
    //   100: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_3
    //   104: getfield 36	com/tencent/mobileqq/theme/diy/ThemeBackground:isNeedImg	Z
    //   107: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   110: ldc 140
    //   112: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_3
    //   116: getfield 142	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   119: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 144
    //   124: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: astore_2
    //   128: aload_3
    //   129: getfield 146	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   132: ifnonnull +494 -> 626
    //   135: iconst_1
    //   136: istore 6
    //   138: ldc 21
    //   140: iconst_2
    //   141: aload_2
    //   142: iload 6
    //   144: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   147: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload_3
    //   154: getfield 142	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   157: ifnull +22 -> 179
    //   160: aload_3
    //   161: getfield 142	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   164: aload 9
    //   166: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifeq +10 -> 179
    //   172: aload_3
    //   173: getfield 146	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   176: ifnonnull +2553 -> 2729
    //   179: aload 9
    //   181: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   184: ifne +23 -> 207
    //   187: ldc 66
    //   189: aload 9
    //   191: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifne +13 -> 207
    //   197: ldc 148
    //   199: aload 9
    //   201: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   204: ifeq +428 -> 632
    //   207: aload_3
    //   208: ldc 66
    //   210: putfield 142	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   213: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +38 -> 254
    //   219: ldc 21
    //   221: iconst_2
    //   222: new 41	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   229: ldc 150
    //   231: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_1
    //   235: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc 152
    //   240: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload 9
    //   245: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: aload_3
    //   255: getfield 154	com/tencent/mobileqq/theme/diy/ThemeBackground:isDecodeInDiy	Z
    //   258: ifne +362 -> 620
    //   261: aload_3
    //   262: getfield 146	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   265: ifnonnull +355 -> 620
    //   268: ldc 156
    //   270: aload_1
    //   271: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   274: ifeq +346 -> 620
    //   277: invokestatic 162	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeInfo	()Landroid/os/Bundle;
    //   280: astore_1
    //   281: aload_1
    //   282: ldc 164
    //   284: invokevirtual 169	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   287: astore 10
    //   289: aload_1
    //   290: ldc 171
    //   292: invokevirtual 169	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   295: astore 11
    //   297: aconst_null
    //   298: astore 8
    //   300: aconst_null
    //   301: astore 9
    //   303: aload 9
    //   305: astore_2
    //   306: aload 8
    //   308: astore_1
    //   309: ldc 173
    //   311: aload 10
    //   313: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   316: ifeq +2167 -> 2483
    //   319: aload 9
    //   321: astore_2
    //   322: aload 8
    //   324: astore_1
    //   325: aload 11
    //   327: invokestatic 179	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   330: ldc 181
    //   332: invokestatic 179	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   335: if_icmpge +2148 -> 2483
    //   338: iconst_1
    //   339: istore 7
    //   341: goto +2474 -> 2815
    //   344: aload 9
    //   346: astore_2
    //   347: aload 8
    //   349: astore_1
    //   350: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +2473 -> 2826
    //   356: aload 9
    //   358: astore_2
    //   359: aload 8
    //   361: astore_1
    //   362: ldc 21
    //   364: iconst_2
    //   365: new 41	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   372: ldc 183
    //   374: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: iload 7
    //   379: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   382: ldc 185
    //   384: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: iload 6
    //   389: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   392: ldc 187
    //   394: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload 10
    //   399: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: ldc 189
    //   404: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload 11
    //   409: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: goto +2408 -> 2826
    //   421: aload 9
    //   423: astore_2
    //   424: aload 8
    //   426: astore_1
    //   427: invokestatic 195	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   430: invokevirtual 198	com/tencent/theme/SkinEngine:getSkinRootPath	()Ljava/lang/String;
    //   433: astore 10
    //   435: aload 9
    //   437: astore_2
    //   438: aload 8
    //   440: astore_1
    //   441: new 200	java/io/File
    //   444: dup
    //   445: new 41	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   452: aload 10
    //   454: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: ldc 202
    //   459: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokespecial 205	java/io/File:<init>	(Ljava/lang/String;)V
    //   468: astore 10
    //   470: aload 9
    //   472: astore_2
    //   473: aload 8
    //   475: astore_1
    //   476: aload 10
    //   478: invokevirtual 208	java/io/File:exists	()Z
    //   481: ifeq +17 -> 498
    //   484: aload 9
    //   486: astore_2
    //   487: aload 8
    //   489: astore_1
    //   490: aload 10
    //   492: invokevirtual 211	java/io/File:isFile	()Z
    //   495: ifne +2127 -> 2622
    //   498: aload 9
    //   500: astore_2
    //   501: aload 8
    //   503: astore_1
    //   504: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   507: ifeq +17 -> 524
    //   510: aload 9
    //   512: astore_2
    //   513: aload 8
    //   515: astore_1
    //   516: ldc 21
    //   518: iconst_2
    //   519: ldc 213
    //   521: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: aload 9
    //   526: astore_2
    //   527: aload 8
    //   529: astore_1
    //   530: aload_0
    //   531: invokevirtual 217	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   534: invokevirtual 223	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   537: ldc 225
    //   539: invokevirtual 231	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   542: astore 8
    //   544: aload 8
    //   546: astore_2
    //   547: aload 8
    //   549: astore_1
    //   550: aload 8
    //   552: invokestatic 237	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   555: astore 9
    //   557: aload 9
    //   559: ifnull +1969 -> 2528
    //   562: aload 8
    //   564: astore_2
    //   565: aload 8
    //   567: astore_1
    //   568: aload_3
    //   569: new 239	android/graphics/drawable/BitmapDrawable
    //   572: dup
    //   573: aload_0
    //   574: invokevirtual 217	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   577: aload 9
    //   579: invokespecial 242	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   582: putfield 146	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   585: aload 8
    //   587: astore_2
    //   588: aload 8
    //   590: astore_1
    //   591: aload_3
    //   592: ldc 244
    //   594: putfield 142	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   597: aload 8
    //   599: astore_2
    //   600: aload 8
    //   602: astore_1
    //   603: aload 8
    //   605: invokevirtual 249	java/io/InputStream:close	()V
    //   608: iconst_0
    //   609: ifeq +11 -> 620
    //   612: new 251	java/lang/NullPointerException
    //   615: dup
    //   616: invokespecial 252	java/lang/NullPointerException:<init>	()V
    //   619: athrow
    //   620: iconst_1
    //   621: istore 6
    //   623: goto -601 -> 22
    //   626: iconst_0
    //   627: istore 6
    //   629: goto -491 -> 138
    //   632: aload_3
    //   633: getfield 36	com/tencent/mobileqq/theme/diy/ThemeBackground:isNeedImg	Z
    //   636: istore 6
    //   638: iload 6
    //   640: ifeq +1828 -> 2468
    //   643: getstatic 258	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   646: aload 9
    //   648: invokevirtual 264	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   651: ifnull +797 -> 1448
    //   654: getstatic 258	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   657: aload 9
    //   659: invokevirtual 264	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   662: checkcast 266	android/graphics/Bitmap
    //   665: astore_2
    //   666: aload_2
    //   667: ifnonnull +2184 -> 2851
    //   670: new 200	java/io/File
    //   673: dup
    //   674: aload 9
    //   676: invokespecial 205	java/io/File:<init>	(Ljava/lang/String;)V
    //   679: astore 8
    //   681: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   684: ifeq +67 -> 751
    //   687: ldc 21
    //   689: iconst_2
    //   690: new 41	java/lang/StringBuilder
    //   693: dup
    //   694: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   697: ldc_w 268
    //   700: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: aload_1
    //   704: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: ldc 152
    //   709: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: aload 9
    //   714: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: ldc_w 270
    //   720: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: aload 8
    //   725: invokevirtual 208	java/io/File:exists	()Z
    //   728: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   731: ldc_w 272
    //   734: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: aload 8
    //   739: invokevirtual 211	java/io/File:isFile	()Z
    //   742: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   745: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   751: aload 8
    //   753: invokevirtual 208	java/io/File:exists	()Z
    //   756: ifeq +1055 -> 1811
    //   759: aload 8
    //   761: invokevirtual 211	java/io/File:isFile	()Z
    //   764: ifeq +1047 -> 1811
    //   767: new 274	android/graphics/BitmapFactory$Options
    //   770: dup
    //   771: invokespecial 275	android/graphics/BitmapFactory$Options:<init>	()V
    //   774: astore 11
    //   776: ldc_w 277
    //   779: getstatic 282	android/os/Build:BRAND	Ljava/lang/String;
    //   782: invokevirtual 286	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   785: ifeq +668 -> 1453
    //   788: aload 11
    //   790: getstatic 292	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   793: putfield 295	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   796: aload 9
    //   798: aload 11
    //   800: invokestatic 301	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;
    //   803: astore 8
    //   805: aload 8
    //   807: getfield 306	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   810: astore_2
    //   811: aload_2
    //   812: ifnull +11 -> 823
    //   815: aload 8
    //   817: getfield 308	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   820: ifeq +761 -> 1581
    //   823: new 41	java/lang/StringBuilder
    //   826: dup
    //   827: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   830: ldc_w 310
    //   833: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: aload_1
    //   837: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: ldc 152
    //   842: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: aload 9
    //   847: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: ldc_w 312
    //   853: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: aload 8
    //   858: getfield 308	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   861: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   864: ldc_w 317
    //   867: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: astore 12
    //   872: aload_2
    //   873: ifnull +702 -> 1575
    //   876: iconst_1
    //   877: istore 6
    //   879: ldc 21
    //   881: iconst_2
    //   882: aload 12
    //   884: iload 6
    //   886: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   889: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   892: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   895: new 322	java/util/HashMap
    //   898: dup
    //   899: invokespecial 323	java/util/HashMap:<init>	()V
    //   902: astore 14
    //   904: aload 14
    //   906: ldc_w 325
    //   909: new 41	java/lang/StringBuilder
    //   912: dup
    //   913: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   916: ldc_w 327
    //   919: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: aload 8
    //   924: getfield 308	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   927: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   930: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   933: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   936: pop
    //   937: aload 14
    //   939: ldc_w 333
    //   942: aload_1
    //   943: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   946: pop
    //   947: aload 14
    //   949: ldc_w 335
    //   952: invokestatic 338	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   955: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   958: pop
    //   959: aload_0
    //   960: invokestatic 343	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   963: astore 13
    //   965: getstatic 347	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   968: invokevirtual 351	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   971: checkcast 353	com/tencent/mobileqq/app/QQAppInterface
    //   974: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   977: astore 12
    //   979: aload_2
    //   980: ifnull +799 -> 1779
    //   983: iconst_1
    //   984: istore 6
    //   986: aload 13
    //   988: aload 12
    //   990: ldc_w 358
    //   993: iload 6
    //   995: lconst_1
    //   996: lconst_0
    //   997: aload 14
    //   999: ldc_w 360
    //   1002: iconst_0
    //   1003: invokevirtual 363	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1006: aload 8
    //   1008: getfield 308	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   1011: iconst_1
    //   1012: if_icmpne +1800 -> 2812
    //   1015: iconst_2
    //   1016: istore 4
    //   1018: iload 4
    //   1020: bipush 32
    //   1022: if_icmpgt +131 -> 1153
    //   1025: aload 11
    //   1027: iload 4
    //   1029: putfield 366	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1032: aload 9
    //   1034: aload 11
    //   1036: invokestatic 301	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;
    //   1039: astore 8
    //   1041: aload 8
    //   1043: getfield 306	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1046: astore_2
    //   1047: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1050: ifne +7 -> 1057
    //   1053: aload_2
    //   1054: ifnonnull +86 -> 1140
    //   1057: new 41	java/lang/StringBuilder
    //   1060: dup
    //   1061: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1064: ldc_w 368
    //   1067: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: aload_1
    //   1071: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: ldc 152
    //   1076: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1079: aload 9
    //   1081: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: ldc_w 370
    //   1087: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: iload 4
    //   1092: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1095: ldc_w 372
    //   1098: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: astore 12
    //   1103: aload_2
    //   1104: ifnull +681 -> 1785
    //   1107: iconst_1
    //   1108: istore 6
    //   1110: ldc 21
    //   1112: iconst_2
    //   1113: aload 12
    //   1115: iload 6
    //   1117: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1120: ldc_w 374
    //   1123: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: aload 8
    //   1128: getfield 308	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   1131: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1134: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1137: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1140: aload 8
    //   1142: getfield 308	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   1145: istore 5
    //   1147: iload 5
    //   1149: iconst_1
    //   1150: if_icmpeq +641 -> 1791
    //   1153: new 322	java/util/HashMap
    //   1156: dup
    //   1157: invokespecial 323	java/util/HashMap:<init>	()V
    //   1160: astore 11
    //   1162: aload 11
    //   1164: ldc_w 325
    //   1167: new 41	java/lang/StringBuilder
    //   1170: dup
    //   1171: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1174: ldc_w 376
    //   1177: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1180: aload 8
    //   1182: getfield 308	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   1185: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1188: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1191: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1194: pop
    //   1195: aload 11
    //   1197: ldc_w 335
    //   1200: invokestatic 338	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   1203: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1206: pop
    //   1207: aload_0
    //   1208: invokestatic 343	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1211: astore 8
    //   1213: getstatic 347	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1216: invokevirtual 351	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1219: checkcast 353	com/tencent/mobileqq/app/QQAppInterface
    //   1222: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1225: astore 12
    //   1227: aload_2
    //   1228: ifnull +572 -> 1800
    //   1231: iconst_1
    //   1232: istore 6
    //   1234: aload 8
    //   1236: aload 12
    //   1238: ldc_w 358
    //   1241: iload 6
    //   1243: lconst_1
    //   1244: lconst_0
    //   1245: aload 11
    //   1247: ldc_w 360
    //   1250: iconst_0
    //   1251: invokevirtual 363	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1254: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1257: ifeq +61 -> 1318
    //   1260: new 41	java/lang/StringBuilder
    //   1263: dup
    //   1264: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1267: ldc_w 378
    //   1270: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: aload_1
    //   1274: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: ldc_w 317
    //   1280: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: astore 8
    //   1285: aload_2
    //   1286: ifnull +1568 -> 2854
    //   1289: iconst_1
    //   1290: istore 6
    //   1292: ldc 21
    //   1294: iconst_2
    //   1295: aload 8
    //   1297: iload 6
    //   1299: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1302: ldc 152
    //   1304: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: aload 9
    //   1309: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1315: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1318: aload_2
    //   1319: ifnull +903 -> 2222
    //   1322: ldc_w 380
    //   1325: aload_1
    //   1326: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1329: ifeq +13 -> 1342
    //   1332: getstatic 258	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   1335: aload 9
    //   1337: aload_2
    //   1338: invokevirtual 381	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1341: pop
    //   1342: aload_3
    //   1343: aload 9
    //   1345: putfield 142	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   1348: ldc 156
    //   1350: aload_1
    //   1351: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1354: ifeq +841 -> 2195
    //   1357: aload_3
    //   1358: new 239	android/graphics/drawable/BitmapDrawable
    //   1361: dup
    //   1362: aload_0
    //   1363: invokevirtual 217	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1366: aload_2
    //   1367: invokespecial 242	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   1370: putfield 146	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   1373: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1376: ifeq -1122 -> 254
    //   1379: new 41	java/lang/StringBuilder
    //   1382: dup
    //   1383: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1386: ldc 131
    //   1388: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: aload_1
    //   1392: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1395: ldc_w 383
    //   1398: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1401: aload_3
    //   1402: getfield 142	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   1405: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1408: ldc 144
    //   1410: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: astore_2
    //   1414: aload_3
    //   1415: getfield 146	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   1418: ifnonnull +1059 -> 2477
    //   1421: iconst_1
    //   1422: istore 6
    //   1424: ldc 21
    //   1426: iconst_2
    //   1427: aload_2
    //   1428: iload 6
    //   1430: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1433: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1436: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1439: goto -1185 -> 254
    //   1442: astore_0
    //   1443: ldc 2
    //   1445: monitorexit
    //   1446: aload_0
    //   1447: athrow
    //   1448: aconst_null
    //   1449: astore_2
    //   1450: goto -784 -> 666
    //   1453: aload 11
    //   1455: getstatic 386	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   1458: putfield 295	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   1461: goto -665 -> 796
    //   1464: astore_2
    //   1465: ldc 21
    //   1467: iconst_1
    //   1468: new 41	java/lang/StringBuilder
    //   1471: dup
    //   1472: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1475: ldc_w 388
    //   1478: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1481: aload_2
    //   1482: invokevirtual 391	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1485: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1491: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1494: aload_3
    //   1495: aconst_null
    //   1496: putfield 146	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   1499: new 322	java/util/HashMap
    //   1502: dup
    //   1503: invokespecial 323	java/util/HashMap:<init>	()V
    //   1506: astore_2
    //   1507: aload_2
    //   1508: ldc_w 325
    //   1511: ldc_w 393
    //   1514: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1517: pop
    //   1518: aload_2
    //   1519: ldc_w 333
    //   1522: aload_1
    //   1523: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1526: pop
    //   1527: aload_2
    //   1528: ldc_w 335
    //   1531: invokestatic 338	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   1534: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1537: pop
    //   1538: aload_0
    //   1539: invokestatic 343	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1542: getstatic 347	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1545: invokevirtual 351	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1548: checkcast 353	com/tencent/mobileqq/app/QQAppInterface
    //   1551: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1554: ldc_w 358
    //   1557: iconst_0
    //   1558: lconst_1
    //   1559: lconst_0
    //   1560: aload_2
    //   1561: ldc_w 360
    //   1564: iconst_0
    //   1565: invokevirtual 363	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1568: goto -195 -> 1373
    //   1571: astore_2
    //   1572: goto -199 -> 1373
    //   1575: iconst_0
    //   1576: istore 6
    //   1578: goto -699 -> 879
    //   1581: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1584: ifeq -689 -> 895
    //   1587: new 41	java/lang/StringBuilder
    //   1590: dup
    //   1591: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1594: ldc_w 395
    //   1597: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: aload_1
    //   1601: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1604: ldc 152
    //   1606: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1609: aload 9
    //   1611: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1614: ldc_w 312
    //   1617: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1620: aload 8
    //   1622: getfield 308	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   1625: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1628: ldc_w 317
    //   1631: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1634: astore 12
    //   1636: aload_2
    //   1637: ifnull +136 -> 1773
    //   1640: iconst_1
    //   1641: istore 6
    //   1643: ldc 21
    //   1645: iconst_2
    //   1646: aload 12
    //   1648: iload 6
    //   1650: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1653: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1656: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1659: goto -764 -> 895
    //   1662: astore_2
    //   1663: ldc 21
    //   1665: iconst_1
    //   1666: new 41	java/lang/StringBuilder
    //   1669: dup
    //   1670: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1673: ldc_w 397
    //   1676: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1679: aload_2
    //   1680: invokevirtual 398	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1683: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1686: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1689: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1692: aload_3
    //   1693: aconst_null
    //   1694: putfield 146	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   1697: new 322	java/util/HashMap
    //   1700: dup
    //   1701: invokespecial 323	java/util/HashMap:<init>	()V
    //   1704: astore_2
    //   1705: aload_2
    //   1706: ldc_w 325
    //   1709: ldc_w 400
    //   1712: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1715: pop
    //   1716: aload_2
    //   1717: ldc_w 333
    //   1720: aload_1
    //   1721: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1724: pop
    //   1725: aload_2
    //   1726: ldc_w 335
    //   1729: invokestatic 338	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   1732: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1735: pop
    //   1736: aload_0
    //   1737: invokestatic 343	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1740: getstatic 347	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1743: invokevirtual 351	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1746: checkcast 353	com/tencent/mobileqq/app/QQAppInterface
    //   1749: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1752: ldc_w 358
    //   1755: iconst_0
    //   1756: lconst_1
    //   1757: lconst_0
    //   1758: aload_2
    //   1759: ldc_w 360
    //   1762: iconst_0
    //   1763: invokevirtual 363	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1766: goto -393 -> 1373
    //   1769: astore_2
    //   1770: goto -397 -> 1373
    //   1773: iconst_0
    //   1774: istore 6
    //   1776: goto -133 -> 1643
    //   1779: iconst_0
    //   1780: istore 6
    //   1782: goto -796 -> 986
    //   1785: iconst_0
    //   1786: istore 6
    //   1788: goto -678 -> 1110
    //   1791: iload 4
    //   1793: iconst_2
    //   1794: imul
    //   1795: istore 4
    //   1797: goto -779 -> 1018
    //   1800: iconst_0
    //   1801: istore 6
    //   1803: goto -569 -> 1234
    //   1806: astore 8
    //   1808: goto -554 -> 1254
    //   1811: new 200	java/io/File
    //   1814: dup
    //   1815: aload 8
    //   1817: invokestatic 405	com/tencent/qqsharpP/QQSharpPUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   1820: invokespecial 205	java/io/File:<init>	(Ljava/lang/String;)V
    //   1823: astore 11
    //   1825: aload 11
    //   1827: invokevirtual 208	java/io/File:exists	()Z
    //   1830: ifeq +326 -> 2156
    //   1833: aload_0
    //   1834: invokestatic 408	com/tencent/qqsharpP/QQSharpPUtil:a	(Landroid/content/Context;)Z
    //   1837: istore 6
    //   1839: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1842: ifne +8 -> 1850
    //   1845: iload 6
    //   1847: ifne +50 -> 1897
    //   1850: ldc 21
    //   1852: iconst_2
    //   1853: new 41	java/lang/StringBuilder
    //   1856: dup
    //   1857: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1860: ldc_w 410
    //   1863: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1866: aload_1
    //   1867: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1870: ldc 152
    //   1872: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1875: aload 9
    //   1877: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1880: ldc_w 412
    //   1883: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1886: iload 6
    //   1888: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1891: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1894: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1897: aload_2
    //   1898: astore 8
    //   1900: iload 6
    //   1902: ifeq +80 -> 1982
    //   1905: aload 11
    //   1907: invokevirtual 415	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1910: invokestatic 421	com/tencent/sharpP/SharpPUtil:decodeSharpPByFilePath	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1913: astore 8
    //   1915: aload 8
    //   1917: astore_2
    //   1918: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1921: ifne +10 -> 1931
    //   1924: aload_2
    //   1925: astore 8
    //   1927: aload_2
    //   1928: ifnonnull +54 -> 1982
    //   1931: new 41	java/lang/StringBuilder
    //   1934: dup
    //   1935: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1938: ldc_w 423
    //   1941: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1944: astore 8
    //   1946: aload_2
    //   1947: ifnull +41 -> 1988
    //   1950: iconst_1
    //   1951: istore 6
    //   1953: ldc 21
    //   1955: iconst_2
    //   1956: aload 8
    //   1958: iload 6
    //   1960: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1963: ldc 152
    //   1965: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1968: aload 9
    //   1970: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1973: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1976: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1979: aload_2
    //   1980: astore 8
    //   1982: aload 8
    //   1984: astore_2
    //   1985: goto -731 -> 1254
    //   1988: iconst_0
    //   1989: istore 6
    //   1991: goto -38 -> 1953
    //   1994: astore 8
    //   1996: ldc 21
    //   1998: iconst_1
    //   1999: new 41	java/lang/StringBuilder
    //   2002: dup
    //   2003: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   2006: ldc_w 425
    //   2009: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2012: aload 8
    //   2014: invokevirtual 426	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   2017: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2020: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2023: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2026: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2029: ifne +10 -> 2039
    //   2032: aload_2
    //   2033: astore 8
    //   2035: aload_2
    //   2036: ifnonnull -54 -> 1982
    //   2039: new 41	java/lang/StringBuilder
    //   2042: dup
    //   2043: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   2046: ldc_w 423
    //   2049: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2052: astore 8
    //   2054: aload_2
    //   2055: ifnull +784 -> 2839
    //   2058: iconst_1
    //   2059: istore 6
    //   2061: ldc 21
    //   2063: iconst_2
    //   2064: aload 8
    //   2066: iload 6
    //   2068: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2071: ldc 152
    //   2073: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2076: aload 9
    //   2078: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2081: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2084: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2087: aload_2
    //   2088: astore 8
    //   2090: goto -108 -> 1982
    //   2093: astore 8
    //   2095: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2098: ifne +7 -> 2105
    //   2101: aload_2
    //   2102: ifnonnull +51 -> 2153
    //   2105: new 41	java/lang/StringBuilder
    //   2108: dup
    //   2109: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   2112: ldc_w 423
    //   2115: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2118: astore 10
    //   2120: aload_2
    //   2121: ifnull +724 -> 2845
    //   2124: iconst_1
    //   2125: istore 6
    //   2127: ldc 21
    //   2129: iconst_2
    //   2130: aload 10
    //   2132: iload 6
    //   2134: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2137: ldc 152
    //   2139: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2142: aload 9
    //   2144: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2147: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2150: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2153: aload 8
    //   2155: athrow
    //   2156: ldc 21
    //   2158: iconst_2
    //   2159: new 41	java/lang/StringBuilder
    //   2162: dup
    //   2163: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   2166: ldc_w 428
    //   2169: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2172: aload_1
    //   2173: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2176: ldc 152
    //   2178: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2181: aload 9
    //   2183: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2186: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2189: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2192: goto +659 -> 2851
    //   2195: new 430	com/tencent/mobileqq/drawable/ChatBackgroundDrawable
    //   2198: dup
    //   2199: aload_0
    //   2200: invokevirtual 217	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2203: aload_2
    //   2204: invokespecial 431	com/tencent/mobileqq/drawable/ChatBackgroundDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   2207: astore_2
    //   2208: aload_2
    //   2209: bipush 48
    //   2211: invokevirtual 435	com/tencent/mobileqq/drawable/ChatBackgroundDrawable:setGravity	(I)V
    //   2214: aload_3
    //   2215: aload_2
    //   2216: putfield 146	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   2219: goto -846 -> 1373
    //   2222: aload 10
    //   2224: new 41	java/lang/StringBuilder
    //   2227: dup
    //   2228: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   2231: aload_1
    //   2232: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2235: ldc_w 437
    //   2238: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2241: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2244: aconst_null
    //   2245: invokeinterface 106 3 0
    //   2250: astore 8
    //   2252: aload 8
    //   2254: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2257: ifne +166 -> 2423
    //   2260: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2263: ifeq +50 -> 2313
    //   2266: ldc 21
    //   2268: iconst_2
    //   2269: new 41	java/lang/StringBuilder
    //   2272: dup
    //   2273: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   2276: ldc_w 439
    //   2279: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2282: aload_1
    //   2283: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2286: ldc_w 441
    //   2289: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2292: aload 8
    //   2294: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2297: ldc 152
    //   2299: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2302: aload 9
    //   2304: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2307: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2310: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2313: new 443	com/tencent/mobileqq/theme/diy/ResData
    //   2316: dup
    //   2317: invokespecial 444	com/tencent/mobileqq/theme/diy/ResData:<init>	()V
    //   2320: astore_2
    //   2321: aload_2
    //   2322: aload 9
    //   2324: putfield 445	com/tencent/mobileqq/theme/diy/ResData:path	Ljava/lang/String;
    //   2327: aload_2
    //   2328: aload 8
    //   2330: putfield 448	com/tencent/mobileqq/theme/diy/ResData:url	Ljava/lang/String;
    //   2333: aload_3
    //   2334: getfield 154	com/tencent/mobileqq/theme/diy/ThemeBackground:isDecodeInDiy	Z
    //   2337: ifne +27 -> 2364
    //   2340: ldc 156
    //   2342: aload_1
    //   2343: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2346: ifne +13 -> 2359
    //   2349: ldc_w 450
    //   2352: aload_1
    //   2353: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2356: ifeq +59 -> 2415
    //   2359: aload_2
    //   2360: iconst_1
    //   2361: putfield 453	com/tencent/mobileqq/theme/diy/ResData:loadingType	I
    //   2364: aload_3
    //   2365: getfield 455	com/tencent/mobileqq/theme/diy/ThemeBackground:pageIndex	I
    //   2368: bipush 100
    //   2370: if_icmpne +20 -> 2390
    //   2373: aload_3
    //   2374: getfield 455	com/tencent/mobileqq/theme/diy/ThemeBackground:pageIndex	I
    //   2377: bipush 100
    //   2379: if_icmpne +481 -> 2860
    //   2382: iconst_1
    //   2383: istore 6
    //   2385: iload 6
    //   2387: putstatic 457	com/tencent/mobileqq/theme/diy/ThemeBackground:needUpdateThemeForBg	Z
    //   2390: aload_3
    //   2391: aload_0
    //   2392: aload_2
    //   2393: iconst_0
    //   2394: iconst_0
    //   2395: aload_3
    //   2396: getfield 455	com/tencent/mobileqq/theme/diy/ThemeBackground:pageIndex	I
    //   2399: iconst_1
    //   2400: invokestatic 463	com/tencent/mobileqq/theme/diy/DIYThemeUtils:getDIYDrawable	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/diy/ResData;IIIZ)Landroid/graphics/drawable/Drawable;
    //   2403: putfield 146	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   2406: aload_3
    //   2407: aload 9
    //   2409: putfield 142	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   2412: goto -1039 -> 1373
    //   2415: aload_2
    //   2416: iconst_2
    //   2417: putfield 453	com/tencent/mobileqq/theme/diy/ResData:loadingType	I
    //   2420: goto -56 -> 2364
    //   2423: ldc 21
    //   2425: iconst_2
    //   2426: new 41	java/lang/StringBuilder
    //   2429: dup
    //   2430: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   2433: ldc_w 465
    //   2436: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2439: aload_1
    //   2440: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2443: ldc 152
    //   2445: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2448: aload 9
    //   2450: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2453: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2456: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2459: aload_3
    //   2460: ldc 66
    //   2462: putfield 142	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   2465: goto -1092 -> 1373
    //   2468: aload_3
    //   2469: aload 9
    //   2471: putfield 142	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   2474: goto -1101 -> 1373
    //   2477: iconst_0
    //   2478: istore 6
    //   2480: goto -1056 -> 1424
    //   2483: iconst_0
    //   2484: istore 7
    //   2486: goto +329 -> 2815
    //   2489: aload 9
    //   2491: astore_2
    //   2492: aload 8
    //   2494: astore_1
    //   2495: ldc 173
    //   2497: aload 10
    //   2499: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2502: ifne +364 -> 2866
    //   2505: aload 9
    //   2507: astore_2
    //   2508: aload 8
    //   2510: astore_1
    //   2511: aload 10
    //   2513: invokestatic 179	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2516: sipush 5010
    //   2519: if_icmpge +347 -> 2866
    //   2522: iconst_1
    //   2523: istore 6
    //   2525: goto -2181 -> 344
    //   2528: aload 8
    //   2530: astore_2
    //   2531: aload 8
    //   2533: astore_1
    //   2534: ldc 21
    //   2536: iconst_1
    //   2537: ldc_w 467
    //   2540: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2543: goto -1946 -> 597
    //   2546: astore_0
    //   2547: aload_2
    //   2548: astore_1
    //   2549: ldc 21
    //   2551: iconst_1
    //   2552: new 41	java/lang/StringBuilder
    //   2555: dup
    //   2556: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   2559: ldc_w 469
    //   2562: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2565: aload_0
    //   2566: invokevirtual 398	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2569: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2572: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2575: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2578: aload_2
    //   2579: ifnull -1959 -> 620
    //   2582: aload_2
    //   2583: invokevirtual 249	java/io/InputStream:close	()V
    //   2586: goto -1966 -> 620
    //   2589: astore_0
    //   2590: ldc 21
    //   2592: iconst_1
    //   2593: new 41	java/lang/StringBuilder
    //   2596: dup
    //   2597: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   2600: ldc_w 471
    //   2603: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2606: aload_0
    //   2607: invokevirtual 398	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2610: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2613: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2616: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2619: goto -1999 -> 620
    //   2622: aload 9
    //   2624: astore_2
    //   2625: aload 8
    //   2627: astore_1
    //   2628: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2631: ifeq -2023 -> 608
    //   2634: aload 9
    //   2636: astore_2
    //   2637: aload 8
    //   2639: astore_1
    //   2640: ldc 21
    //   2642: iconst_2
    //   2643: ldc_w 473
    //   2646: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2649: goto -2041 -> 608
    //   2652: astore_0
    //   2653: aload_1
    //   2654: ifnull +7 -> 2661
    //   2657: aload_1
    //   2658: invokevirtual 249	java/io/InputStream:close	()V
    //   2661: aload_0
    //   2662: athrow
    //   2663: astore_0
    //   2664: ldc 21
    //   2666: iconst_1
    //   2667: new 41	java/lang/StringBuilder
    //   2670: dup
    //   2671: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   2674: ldc_w 471
    //   2677: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2680: aload_0
    //   2681: invokevirtual 398	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2684: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2687: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2690: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2693: goto -2073 -> 620
    //   2696: astore_1
    //   2697: ldc 21
    //   2699: iconst_1
    //   2700: new 41	java/lang/StringBuilder
    //   2703: dup
    //   2704: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   2707: ldc_w 471
    //   2710: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2713: aload_1
    //   2714: invokevirtual 398	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2717: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2720: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2723: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2726: goto -65 -> 2661
    //   2729: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2732: ifeq +63 -> 2795
    //   2735: new 41	java/lang/StringBuilder
    //   2738: dup
    //   2739: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   2742: ldc 131
    //   2744: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2747: aload_1
    //   2748: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2751: ldc_w 475
    //   2754: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2757: aload_3
    //   2758: getfield 142	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   2761: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2764: ldc 144
    //   2766: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2769: astore_0
    //   2770: aload_3
    //   2771: getfield 146	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   2774: ifnonnull +27 -> 2801
    //   2777: iconst_1
    //   2778: istore 6
    //   2780: ldc 21
    //   2782: iconst_2
    //   2783: aload_0
    //   2784: iload 6
    //   2786: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2789: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2792: invokestatic 478	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2795: iconst_0
    //   2796: istore 6
    //   2798: goto -2776 -> 22
    //   2801: iconst_0
    //   2802: istore 6
    //   2804: goto -24 -> 2780
    //   2807: astore 12
    //   2809: goto -1803 -> 1006
    //   2812: goto -1558 -> 1254
    //   2815: iload 7
    //   2817: ifeq -328 -> 2489
    //   2820: iconst_0
    //   2821: istore 6
    //   2823: goto -2479 -> 344
    //   2826: iload 7
    //   2828: ifne -2407 -> 421
    //   2831: iload 6
    //   2833: ifeq -2225 -> 608
    //   2836: goto -2415 -> 421
    //   2839: iconst_0
    //   2840: istore 6
    //   2842: goto -781 -> 2061
    //   2845: iconst_0
    //   2846: istore 6
    //   2848: goto -721 -> 2127
    //   2851: goto -1597 -> 1254
    //   2854: iconst_0
    //   2855: istore 6
    //   2857: goto -1565 -> 1292
    //   2860: iconst_0
    //   2861: istore 6
    //   2863: goto -478 -> 2385
    //   2866: iconst_0
    //   2867: istore 6
    //   2869: goto -2525 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2872	0	paramContext	Context
    //   0	2872	1	paramString1	String
    //   0	2872	2	paramString2	String
    //   0	2872	3	paramThemeBackground	ThemeBackground
    //   1016	780	4	i	int
    //   1145	6	5	j	int
    //   20	2848	6	bool1	boolean
    //   339	2488	7	bool2	boolean
    //   298	1323	8	localObject1	Object
    //   1806	10	8	localException1	java.lang.Exception
    //   1898	85	8	localObject2	Object
    //   1994	19	8	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   2033	56	8	localObject3	Object
    //   2093	61	8	localObject4	Object
    //   2250	388	8	str	String
    //   64	2571	9	localObject5	Object
    //   52	2460	10	localObject6	Object
    //   295	1611	11	localObject7	Object
    //   870	777	12	localObject8	Object
    //   2807	1	12	localException2	java.lang.Exception
    //   963	24	13	localStatisticCollector	com.tencent.mobileqq.statistics.StatisticCollector
    //   902	96	14	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   11	19	1442	finally
    //   28	135	1442	finally
    //   138	153	1442	finally
    //   153	179	1442	finally
    //   179	207	1442	finally
    //   207	254	1442	finally
    //   254	297	1442	finally
    //   612	620	1442	finally
    //   632	638	1442	finally
    //   643	666	1442	finally
    //   670	751	1442	finally
    //   751	796	1442	finally
    //   796	811	1442	finally
    //   815	823	1442	finally
    //   823	872	1442	finally
    //   879	895	1442	finally
    //   895	979	1442	finally
    //   986	1006	1442	finally
    //   1006	1015	1442	finally
    //   1025	1053	1442	finally
    //   1057	1103	1442	finally
    //   1110	1140	1442	finally
    //   1140	1147	1442	finally
    //   1153	1227	1442	finally
    //   1234	1254	1442	finally
    //   1254	1285	1442	finally
    //   1292	1318	1442	finally
    //   1322	1342	1442	finally
    //   1342	1373	1442	finally
    //   1373	1421	1442	finally
    //   1424	1439	1442	finally
    //   1453	1461	1442	finally
    //   1465	1499	1442	finally
    //   1499	1568	1442	finally
    //   1581	1636	1442	finally
    //   1643	1659	1442	finally
    //   1663	1697	1442	finally
    //   1697	1766	1442	finally
    //   1811	1845	1442	finally
    //   1850	1897	1442	finally
    //   1918	1924	1442	finally
    //   1931	1946	1442	finally
    //   1953	1979	1442	finally
    //   2026	2032	1442	finally
    //   2039	2054	1442	finally
    //   2061	2087	1442	finally
    //   2095	2101	1442	finally
    //   2105	2120	1442	finally
    //   2127	2153	1442	finally
    //   2153	2156	1442	finally
    //   2156	2192	1442	finally
    //   2195	2219	1442	finally
    //   2222	2313	1442	finally
    //   2313	2359	1442	finally
    //   2359	2364	1442	finally
    //   2364	2382	1442	finally
    //   2385	2390	1442	finally
    //   2390	2412	1442	finally
    //   2415	2420	1442	finally
    //   2423	2465	1442	finally
    //   2468	2474	1442	finally
    //   2582	2586	1442	finally
    //   2590	2619	1442	finally
    //   2657	2661	1442	finally
    //   2661	2663	1442	finally
    //   2664	2693	1442	finally
    //   2697	2726	1442	finally
    //   2729	2777	1442	finally
    //   2780	2795	1442	finally
    //   643	666	1464	java/lang/OutOfMemoryError
    //   670	751	1464	java/lang/OutOfMemoryError
    //   751	796	1464	java/lang/OutOfMemoryError
    //   796	811	1464	java/lang/OutOfMemoryError
    //   815	823	1464	java/lang/OutOfMemoryError
    //   823	872	1464	java/lang/OutOfMemoryError
    //   879	895	1464	java/lang/OutOfMemoryError
    //   895	979	1464	java/lang/OutOfMemoryError
    //   986	1006	1464	java/lang/OutOfMemoryError
    //   1006	1015	1464	java/lang/OutOfMemoryError
    //   1025	1053	1464	java/lang/OutOfMemoryError
    //   1057	1103	1464	java/lang/OutOfMemoryError
    //   1110	1140	1464	java/lang/OutOfMemoryError
    //   1140	1147	1464	java/lang/OutOfMemoryError
    //   1153	1227	1464	java/lang/OutOfMemoryError
    //   1234	1254	1464	java/lang/OutOfMemoryError
    //   1254	1285	1464	java/lang/OutOfMemoryError
    //   1292	1318	1464	java/lang/OutOfMemoryError
    //   1322	1342	1464	java/lang/OutOfMemoryError
    //   1342	1373	1464	java/lang/OutOfMemoryError
    //   1453	1461	1464	java/lang/OutOfMemoryError
    //   1581	1636	1464	java/lang/OutOfMemoryError
    //   1643	1659	1464	java/lang/OutOfMemoryError
    //   1811	1845	1464	java/lang/OutOfMemoryError
    //   1850	1897	1464	java/lang/OutOfMemoryError
    //   1918	1924	1464	java/lang/OutOfMemoryError
    //   1931	1946	1464	java/lang/OutOfMemoryError
    //   1953	1979	1464	java/lang/OutOfMemoryError
    //   2026	2032	1464	java/lang/OutOfMemoryError
    //   2039	2054	1464	java/lang/OutOfMemoryError
    //   2061	2087	1464	java/lang/OutOfMemoryError
    //   2095	2101	1464	java/lang/OutOfMemoryError
    //   2105	2120	1464	java/lang/OutOfMemoryError
    //   2127	2153	1464	java/lang/OutOfMemoryError
    //   2153	2156	1464	java/lang/OutOfMemoryError
    //   2156	2192	1464	java/lang/OutOfMemoryError
    //   2195	2219	1464	java/lang/OutOfMemoryError
    //   2222	2313	1464	java/lang/OutOfMemoryError
    //   2313	2359	1464	java/lang/OutOfMemoryError
    //   2359	2364	1464	java/lang/OutOfMemoryError
    //   2364	2382	1464	java/lang/OutOfMemoryError
    //   2385	2390	1464	java/lang/OutOfMemoryError
    //   2390	2412	1464	java/lang/OutOfMemoryError
    //   2415	2420	1464	java/lang/OutOfMemoryError
    //   2423	2465	1464	java/lang/OutOfMemoryError
    //   1499	1568	1571	java/lang/Exception
    //   643	666	1662	java/lang/Exception
    //   670	751	1662	java/lang/Exception
    //   751	796	1662	java/lang/Exception
    //   796	811	1662	java/lang/Exception
    //   815	823	1662	java/lang/Exception
    //   823	872	1662	java/lang/Exception
    //   879	895	1662	java/lang/Exception
    //   1006	1015	1662	java/lang/Exception
    //   1025	1053	1662	java/lang/Exception
    //   1057	1103	1662	java/lang/Exception
    //   1110	1140	1662	java/lang/Exception
    //   1140	1147	1662	java/lang/Exception
    //   1254	1285	1662	java/lang/Exception
    //   1292	1318	1662	java/lang/Exception
    //   1322	1342	1662	java/lang/Exception
    //   1342	1373	1662	java/lang/Exception
    //   1453	1461	1662	java/lang/Exception
    //   1581	1636	1662	java/lang/Exception
    //   1643	1659	1662	java/lang/Exception
    //   1811	1845	1662	java/lang/Exception
    //   1850	1897	1662	java/lang/Exception
    //   1918	1924	1662	java/lang/Exception
    //   1931	1946	1662	java/lang/Exception
    //   1953	1979	1662	java/lang/Exception
    //   2026	2032	1662	java/lang/Exception
    //   2039	2054	1662	java/lang/Exception
    //   2061	2087	1662	java/lang/Exception
    //   2095	2101	1662	java/lang/Exception
    //   2105	2120	1662	java/lang/Exception
    //   2127	2153	1662	java/lang/Exception
    //   2153	2156	1662	java/lang/Exception
    //   2156	2192	1662	java/lang/Exception
    //   2195	2219	1662	java/lang/Exception
    //   2222	2313	1662	java/lang/Exception
    //   2313	2359	1662	java/lang/Exception
    //   2359	2364	1662	java/lang/Exception
    //   2364	2382	1662	java/lang/Exception
    //   2385	2390	1662	java/lang/Exception
    //   2390	2412	1662	java/lang/Exception
    //   2415	2420	1662	java/lang/Exception
    //   2423	2465	1662	java/lang/Exception
    //   1697	1766	1769	java/lang/Exception
    //   1153	1227	1806	java/lang/Exception
    //   1234	1254	1806	java/lang/Exception
    //   1905	1915	1994	java/lang/UnsatisfiedLinkError
    //   1905	1915	2093	finally
    //   1996	2026	2093	finally
    //   309	319	2546	java/lang/Exception
    //   325	338	2546	java/lang/Exception
    //   350	356	2546	java/lang/Exception
    //   362	418	2546	java/lang/Exception
    //   427	435	2546	java/lang/Exception
    //   441	470	2546	java/lang/Exception
    //   476	484	2546	java/lang/Exception
    //   490	498	2546	java/lang/Exception
    //   504	510	2546	java/lang/Exception
    //   516	524	2546	java/lang/Exception
    //   530	544	2546	java/lang/Exception
    //   550	557	2546	java/lang/Exception
    //   568	585	2546	java/lang/Exception
    //   591	597	2546	java/lang/Exception
    //   603	608	2546	java/lang/Exception
    //   2495	2505	2546	java/lang/Exception
    //   2511	2522	2546	java/lang/Exception
    //   2534	2543	2546	java/lang/Exception
    //   2628	2634	2546	java/lang/Exception
    //   2640	2649	2546	java/lang/Exception
    //   2582	2586	2589	java/lang/Exception
    //   309	319	2652	finally
    //   325	338	2652	finally
    //   350	356	2652	finally
    //   362	418	2652	finally
    //   427	435	2652	finally
    //   441	470	2652	finally
    //   476	484	2652	finally
    //   490	498	2652	finally
    //   504	510	2652	finally
    //   516	524	2652	finally
    //   530	544	2652	finally
    //   550	557	2652	finally
    //   568	585	2652	finally
    //   591	597	2652	finally
    //   603	608	2652	finally
    //   2495	2505	2652	finally
    //   2511	2522	2652	finally
    //   2534	2543	2652	finally
    //   2549	2578	2652	finally
    //   2628	2634	2652	finally
    //   2640	2649	2652	finally
    //   612	620	2663	java/lang/Exception
    //   2657	2661	2696	java/lang/Exception
    //   895	979	2807	java/lang/Exception
    //   986	1006	2807	java/lang/Exception
  }
  
  public static boolean getThemeBackgroundEnable()
  {
    return ThemeUtil.getIsDIYTheme(null);
  }
  
  public static ThemeBackground getThemeBgObj(AppRuntime paramAppRuntime, Context paramContext, int paramInt, String paramString)
  {
    ThemeBackground localThemeBackground = new ThemeBackground();
    if ((paramAppRuntime == null) || (paramContext == null))
    {
      QLog.i("ThemeBackground", 2, "getThemeBgObj app,context = null; animateName=" + paramString + ", app=" + paramAppRuntime + ", context=" + paramContext);
      return localThemeBackground;
    }
    if (ThemeUtil.isNowThemeIsDIY()) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      return localThemeBackground;
      getThemeBackground(paramContext, "theme_bg_setting_path_png", paramAppRuntime.getAccount(), localThemeBackground);
      continue;
      getThemeBackground(paramContext, "theme_bg_message_path_png", paramAppRuntime.getAccount(), localThemeBackground);
      continue;
      if (ThemeUtil.isNowThemeIsAnimate())
      {
        localThemeBackground.isAnimateBg = true;
        switch (paramInt)
        {
        default: 
          break;
        case 1: 
          localThemeBackground.path = ThemeUtil.getAnimatePathByTag(1);
          paramContext = paramContext.getResources().getDrawable(2130843283);
          localThemeBackground.img = VasApngUtil.a(paramAppRuntime, localThemeBackground.path, "-setting-", paramContext, new int[] { 1 }, paramString, null);
          break;
        case 2: 
          localThemeBackground.path = ThemeUtil.getAnimatePathByTag(2);
          paramContext = paramContext.getResources().getDrawable(2130845807);
          localThemeBackground.img = VasApngUtil.a(paramAppRuntime, localThemeBackground.path, "-conversation-", paramContext, VasApngUtil.a, paramString, null);
        }
      }
    }
  }
  
  public static void setThemeBackgroundPic(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeBackground", 2, "setThemeBackgroundPic, bgType=" + paramString1 + ", url=" + paramString4 + ", path=" + paramString3 + ", id=" + paramString5 + ", name=" + paramString6 + ", feetype=" + paramInt + ", isDiy=" + paramBoolean);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("theme_background_path_" + paramString2, 0).edit();
    paramContext.putString(paramString1, paramString3);
    paramContext.putString(paramString1 + "_url", paramString4);
    paramContext.putString(paramString1 + "_id", paramString5);
    paramContext.putBoolean(paramString1 + "_from", paramBoolean);
    if (paramString6 != null) {
      paramContext.putString(paramString1 + "_name", paramString6);
    }
    paramContext.putInt(paramString1 + "_feetype", paramInt);
    if (paramString7 != null) {
      paramContext.putString(paramString1 + "_thum", paramString7);
    }
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeBackground
 * JD-Core Version:    0.7.0.1
 */