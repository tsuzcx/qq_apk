package com.tencent.mobileqq.theme.diy;

import acuv;
import akvu;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import bbql;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ThemeBackground
{
  public static final int BG_TYPE_AIO = 2;
  public static final int BG_TYPE_CONVERSATION = 1;
  public static final int BG_TYPE_DYNAMIC = 4;
  public static final int BG_TYPE_FRIEND = 3;
  public static final int BG_TYPE_SETTING = 0;
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
  
  public static void applyThemeBg(AppRuntime paramAppRuntime, View paramView, int paramInt1, int paramInt2, String paramString)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ThemeBackground", 2, "applyThemeBg view is null,  animateName:" + paramString + " byType:" + paramInt1);
      }
      return;
    }
    ThreadManager.post(new ThemeBackground.1(paramAppRuntime, paramInt1, paramString, paramView, paramInt2), 8, null, true);
  }
  
  public static void clear(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    paramContext = getSharedPreferences(paramContext, paramString2, 4).edit();
    paramContext.putString(paramString1, "null");
    paramContext.putBoolean(paramString1 + "_from", false);
    paramContext.commit();
  }
  
  public static boolean getMarkOfAioBgFromDiy(Context paramContext, String paramString1, String paramString2)
  {
    String str;
    if ((!TextUtils.isEmpty(paramString1)) && ("theme_bg_aio_path".equals(paramString1)))
    {
      str = acuv.a(paramContext, paramString2, 0).getString("chat_uniform_bg", "null");
      if (!TextUtils.isEmpty(str)) {
        break label41;
      }
    }
    label41:
    do
    {
      return false;
      paramContext = getSharedPreferences(paramContext, paramString2, 0);
      paramString2 = paramContext.getString(paramString1, null);
    } while ((TextUtils.isEmpty(paramString2)) || (!str.equals(paramString2)));
    return paramContext.getBoolean(paramString1 + "_from", false);
  }
  
  public static SharedPreferences getSharedPreferences(Context paramContext, String paramString, int paramInt)
  {
    int i = 0;
    paramContext = paramContext.getSharedPreferences("theme_background_path_" + paramString, paramInt);
    if (paramContext.getInt("theme_background_version", 0) < 1)
    {
      SharedPreferences.Editor localEditor = paramContext.edit();
      String[] arrayOfString = new String[5];
      arrayOfString[0] = "theme_bg_message_path";
      arrayOfString[1] = "theme_bg_message_path_png";
      arrayOfString[2] = "theme_bg_aio_path";
      arrayOfString[3] = "theme_bg_setting_path";
      arrayOfString[4] = "theme_bg_setting_path_png";
      int j = arrayOfString.length;
      paramInt = i;
      while (paramInt < j)
      {
        String str1 = arrayOfString[paramInt];
        String str2 = paramContext.getString(str1, null);
        if ((str2 != null) && (str2.contains("custom_background/" + paramString + "/"))) {
          localEditor.putString(str1, str2.replace("custom_background/" + paramString + "/", "custom_background/" + akvu.a(paramString) + "/"));
        }
        paramInt += 1;
      }
      localEditor.putInt("theme_background_version", 1).commit();
    }
    return paramContext;
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
    //   11: ldc 27
    //   13: iconst_2
    //   14: ldc 195
    //   16: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: iconst_0
    //   20: istore 6
    //   22: ldc 2
    //   24: monitorexit
    //   25: iload 6
    //   27: ireturn
    //   28: aload_0
    //   29: aload_2
    //   30: iconst_4
    //   31: invokestatic 90	com/tencent/mobileqq/theme/diy/ThemeBackground:getSharedPreferences	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   34: astore 10
    //   36: aload 10
    //   38: aload_1
    //   39: ldc 98
    //   41: invokeinterface 140 3 0
    //   46: astore 9
    //   48: aload 9
    //   50: ifnull +26 -> 76
    //   53: aload 9
    //   55: ldc 200
    //   57: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: ifeq +16 -> 76
    //   63: aload_3
    //   64: aload_0
    //   65: invokevirtual 204	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   68: ldc 205
    //   70: invokevirtual 211	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   73: putfield 213	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   76: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +84 -> 163
    //   82: new 53	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   89: ldc 215
    //   91: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_1
    //   95: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 217
    //   100: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload 9
    //   105: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 219
    //   110: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_3
    //   114: getfield 42	com/tencent/mobileqq/theme/diy/ThemeBackground:isNeedImg	Z
    //   117: invokevirtual 222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   120: ldc 224
    //   122: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_3
    //   126: getfield 226	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   129: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 228
    //   134: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: astore_2
    //   138: aload_3
    //   139: getfield 213	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   142: ifnonnull +503 -> 645
    //   145: iconst_1
    //   146: istore 6
    //   148: ldc 27
    //   150: iconst_2
    //   151: aload_2
    //   152: iload 6
    //   154: invokevirtual 222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   157: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aload_3
    //   164: getfield 226	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   167: ifnull +22 -> 189
    //   170: aload_3
    //   171: getfield 226	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   174: aload 9
    //   176: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   179: ifeq +10 -> 189
    //   182: aload_3
    //   183: getfield 213	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   186: ifnonnull +2556 -> 2742
    //   189: aload 9
    //   191: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   194: ifne +23 -> 217
    //   197: ldc 98
    //   199: aload 9
    //   201: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   204: ifne +13 -> 217
    //   207: ldc 230
    //   209: aload 9
    //   211: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   214: ifeq +437 -> 651
    //   217: aload_3
    //   218: ldc 98
    //   220: putfield 226	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   223: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   226: ifeq +38 -> 264
    //   229: ldc 27
    //   231: iconst_2
    //   232: new 53	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   239: ldc 232
    //   241: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_1
    //   245: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc 234
    //   250: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 9
    //   255: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: aload_3
    //   265: getfield 236	com/tencent/mobileqq/theme/diy/ThemeBackground:isDecodeInDiy	Z
    //   268: ifne +371 -> 639
    //   271: aload_3
    //   272: getfield 213	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   275: ifnonnull +364 -> 639
    //   278: ldc 165
    //   280: aload_1
    //   281: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   284: ifeq +355 -> 639
    //   287: invokestatic 242	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeInfo	()Landroid/os/Bundle;
    //   290: astore_1
    //   291: aload_1
    //   292: ldc 244
    //   294: invokevirtual 248	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   297: astore 10
    //   299: aload_1
    //   300: ldc 250
    //   302: invokevirtual 248	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   305: astore 11
    //   307: aconst_null
    //   308: astore 9
    //   310: aconst_null
    //   311: astore 8
    //   313: aload 8
    //   315: astore_2
    //   316: aload 9
    //   318: astore_1
    //   319: ldc 252
    //   321: aload 10
    //   323: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   326: ifeq +2170 -> 2496
    //   329: aload 8
    //   331: astore_2
    //   332: aload 9
    //   334: astore_1
    //   335: aload 11
    //   337: invokestatic 258	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   340: ldc_w 260
    //   343: invokestatic 258	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   346: if_icmpge +2150 -> 2496
    //   349: iconst_1
    //   350: istore 7
    //   352: goto +2476 -> 2828
    //   355: aload 8
    //   357: astore_2
    //   358: aload 9
    //   360: astore_1
    //   361: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   364: ifeq +2475 -> 2839
    //   367: aload 8
    //   369: astore_2
    //   370: aload 9
    //   372: astore_1
    //   373: ldc 27
    //   375: iconst_2
    //   376: new 53	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   383: ldc_w 262
    //   386: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: iload 7
    //   391: invokevirtual 222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   394: ldc_w 264
    //   397: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: iload 6
    //   402: invokevirtual 222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   405: ldc_w 266
    //   408: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload 10
    //   413: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: ldc_w 268
    //   419: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload 11
    //   424: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: goto +2406 -> 2839
    //   436: aload 8
    //   438: astore_2
    //   439: aload 9
    //   441: astore_1
    //   442: invokestatic 274	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   445: invokevirtual 277	com/tencent/theme/SkinEngine:getSkinRootPath	()Ljava/lang/String;
    //   448: astore 10
    //   450: aload 8
    //   452: astore_2
    //   453: aload 9
    //   455: astore_1
    //   456: new 279	java/io/File
    //   459: dup
    //   460: new 53	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   467: aload 10
    //   469: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: ldc_w 281
    //   475: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokespecial 284	java/io/File:<init>	(Ljava/lang/String;)V
    //   484: astore 10
    //   486: aload 8
    //   488: astore_2
    //   489: aload 9
    //   491: astore_1
    //   492: aload 10
    //   494: invokevirtual 287	java/io/File:exists	()Z
    //   497: ifeq +17 -> 514
    //   500: aload 8
    //   502: astore_2
    //   503: aload 9
    //   505: astore_1
    //   506: aload 10
    //   508: invokevirtual 290	java/io/File:isFile	()Z
    //   511: ifne +2124 -> 2635
    //   514: aload 8
    //   516: astore_2
    //   517: aload 9
    //   519: astore_1
    //   520: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   523: ifeq +18 -> 541
    //   526: aload 8
    //   528: astore_2
    //   529: aload 9
    //   531: astore_1
    //   532: ldc 27
    //   534: iconst_2
    //   535: ldc_w 292
    //   538: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   541: aload 8
    //   543: astore_2
    //   544: aload 9
    //   546: astore_1
    //   547: aload_0
    //   548: invokevirtual 204	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   551: invokevirtual 296	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   554: ldc_w 298
    //   557: invokevirtual 304	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   560: astore 8
    //   562: aload 8
    //   564: astore_2
    //   565: aload 8
    //   567: astore_1
    //   568: aload 8
    //   570: invokestatic 310	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   573: astore 9
    //   575: aload 9
    //   577: ifnull +1964 -> 2541
    //   580: aload 8
    //   582: astore_2
    //   583: aload 8
    //   585: astore_1
    //   586: aload_3
    //   587: new 312	android/graphics/drawable/BitmapDrawable
    //   590: dup
    //   591: aload_0
    //   592: invokevirtual 204	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   595: aload 9
    //   597: invokespecial 315	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   600: putfield 213	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   603: aload 8
    //   605: astore_2
    //   606: aload 8
    //   608: astore_1
    //   609: aload_3
    //   610: ldc_w 317
    //   613: putfield 226	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   616: aload 8
    //   618: astore_2
    //   619: aload 8
    //   621: astore_1
    //   622: aload 8
    //   624: invokevirtual 322	java/io/InputStream:close	()V
    //   627: iconst_0
    //   628: ifeq +11 -> 639
    //   631: new 324	java/lang/NullPointerException
    //   634: dup
    //   635: invokespecial 325	java/lang/NullPointerException:<init>	()V
    //   638: athrow
    //   639: iconst_1
    //   640: istore 6
    //   642: goto -620 -> 22
    //   645: iconst_0
    //   646: istore 6
    //   648: goto -500 -> 148
    //   651: aload_3
    //   652: getfield 42	com/tencent/mobileqq/theme/diy/ThemeBackground:isNeedImg	Z
    //   655: istore 6
    //   657: iload 6
    //   659: ifeq +1822 -> 2481
    //   662: getstatic 331	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   665: aload 9
    //   667: invokevirtual 337	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   670: ifnull +794 -> 1464
    //   673: getstatic 331	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   676: aload 9
    //   678: invokevirtual 337	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   681: checkcast 339	android/graphics/Bitmap
    //   684: astore_2
    //   685: aload_2
    //   686: ifnonnull +2178 -> 2864
    //   689: new 279	java/io/File
    //   692: dup
    //   693: aload 9
    //   695: invokespecial 284	java/io/File:<init>	(Ljava/lang/String;)V
    //   698: astore 8
    //   700: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   703: ifeq +67 -> 770
    //   706: ldc 27
    //   708: iconst_2
    //   709: new 53	java/lang/StringBuilder
    //   712: dup
    //   713: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   716: ldc_w 341
    //   719: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: aload_1
    //   723: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: ldc 234
    //   728: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: aload 9
    //   733: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: ldc_w 343
    //   739: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: aload 8
    //   744: invokevirtual 287	java/io/File:exists	()Z
    //   747: invokevirtual 222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   750: ldc_w 345
    //   753: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: aload 8
    //   758: invokevirtual 290	java/io/File:isFile	()Z
    //   761: invokevirtual 222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   764: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   770: aload 8
    //   772: invokevirtual 287	java/io/File:exists	()Z
    //   775: ifeq +1050 -> 1825
    //   778: aload 8
    //   780: invokevirtual 290	java/io/File:isFile	()Z
    //   783: ifeq +1042 -> 1825
    //   786: new 347	android/graphics/BitmapFactory$Options
    //   789: dup
    //   790: invokespecial 348	android/graphics/BitmapFactory$Options:<init>	()V
    //   793: astore 11
    //   795: ldc_w 350
    //   798: getstatic 355	android/os/Build:BRAND	Ljava/lang/String;
    //   801: invokevirtual 359	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   804: ifeq +665 -> 1469
    //   807: aload 11
    //   809: getstatic 365	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   812: putfield 368	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   815: aload 9
    //   817: aload 11
    //   819: invokestatic 373	bawu:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lbawv;
    //   822: astore 8
    //   824: aload 8
    //   826: getfield 378	bawv:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   829: astore_2
    //   830: aload_2
    //   831: ifnull +11 -> 842
    //   834: aload 8
    //   836: getfield 380	bawv:jdField_a_of_type_Int	I
    //   839: ifeq +757 -> 1596
    //   842: new 53	java/lang/StringBuilder
    //   845: dup
    //   846: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   849: ldc_w 382
    //   852: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: aload_1
    //   856: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: ldc 234
    //   861: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: aload 9
    //   866: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: ldc_w 384
    //   872: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: aload 8
    //   877: getfield 380	bawv:jdField_a_of_type_Int	I
    //   880: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   883: ldc_w 386
    //   886: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: astore 12
    //   891: aload_2
    //   892: ifnull +698 -> 1590
    //   895: iconst_1
    //   896: istore 6
    //   898: ldc 27
    //   900: iconst_2
    //   901: aload 12
    //   903: iload 6
    //   905: invokevirtual 222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   908: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   911: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   914: new 388	java/util/HashMap
    //   917: dup
    //   918: invokespecial 389	java/util/HashMap:<init>	()V
    //   921: astore 12
    //   923: aload 12
    //   925: ldc_w 391
    //   928: new 53	java/lang/StringBuilder
    //   931: dup
    //   932: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   935: ldc_w 393
    //   938: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: aload 8
    //   943: getfield 380	bawv:jdField_a_of_type_Int	I
    //   946: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   949: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   952: invokevirtual 397	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   955: pop
    //   956: aload 12
    //   958: ldc_w 399
    //   961: aload_1
    //   962: invokevirtual 397	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   965: pop
    //   966: aload 12
    //   968: ldc_w 401
    //   971: invokestatic 404	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   974: invokevirtual 397	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   977: pop
    //   978: aload_0
    //   979: invokestatic 409	axrl:a	(Landroid/content/Context;)Laxrl;
    //   982: astore 13
    //   984: getstatic 413	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   987: invokevirtual 417	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   990: checkcast 419	com/tencent/mobileqq/app/QQAppInterface
    //   993: invokevirtual 422	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   996: astore 14
    //   998: aload_2
    //   999: ifnull +794 -> 1793
    //   1002: iconst_1
    //   1003: istore 6
    //   1005: aload 13
    //   1007: aload 14
    //   1009: ldc_w 424
    //   1012: iload 6
    //   1014: lconst_1
    //   1015: lconst_0
    //   1016: aload 12
    //   1018: ldc 200
    //   1020: iconst_0
    //   1021: invokevirtual 427	axrl:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1024: aload 8
    //   1026: getfield 380	bawv:jdField_a_of_type_Int	I
    //   1029: iconst_1
    //   1030: if_icmpne +1795 -> 2825
    //   1033: iconst_2
    //   1034: istore 4
    //   1036: iload 4
    //   1038: bipush 32
    //   1040: if_icmpgt +131 -> 1171
    //   1043: aload 11
    //   1045: iload 4
    //   1047: putfield 430	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1050: aload 9
    //   1052: aload 11
    //   1054: invokestatic 373	bawu:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lbawv;
    //   1057: astore 8
    //   1059: aload 8
    //   1061: getfield 378	bawv:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1064: astore_2
    //   1065: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1068: ifne +7 -> 1075
    //   1071: aload_2
    //   1072: ifnonnull +86 -> 1158
    //   1075: new 53	java/lang/StringBuilder
    //   1078: dup
    //   1079: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1082: ldc_w 432
    //   1085: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: aload_1
    //   1089: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: ldc 234
    //   1094: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: aload 9
    //   1099: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1102: ldc_w 434
    //   1105: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: iload 4
    //   1110: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1113: ldc_w 436
    //   1116: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: astore 12
    //   1121: aload_2
    //   1122: ifnull +677 -> 1799
    //   1125: iconst_1
    //   1126: istore 6
    //   1128: ldc 27
    //   1130: iconst_2
    //   1131: aload 12
    //   1133: iload 6
    //   1135: invokevirtual 222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1138: ldc_w 438
    //   1141: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: aload 8
    //   1146: getfield 380	bawv:jdField_a_of_type_Int	I
    //   1149: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1152: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1155: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1158: aload 8
    //   1160: getfield 380	bawv:jdField_a_of_type_Int	I
    //   1163: istore 5
    //   1165: iload 5
    //   1167: iconst_1
    //   1168: if_icmpeq +637 -> 1805
    //   1171: new 388	java/util/HashMap
    //   1174: dup
    //   1175: invokespecial 389	java/util/HashMap:<init>	()V
    //   1178: astore 11
    //   1180: aload 11
    //   1182: ldc_w 391
    //   1185: new 53	java/lang/StringBuilder
    //   1188: dup
    //   1189: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1192: ldc_w 440
    //   1195: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: aload 8
    //   1200: getfield 380	bawv:jdField_a_of_type_Int	I
    //   1203: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1206: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1209: invokevirtual 397	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1212: pop
    //   1213: aload 11
    //   1215: ldc_w 401
    //   1218: invokestatic 404	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   1221: invokevirtual 397	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1224: pop
    //   1225: aload_0
    //   1226: invokestatic 409	axrl:a	(Landroid/content/Context;)Laxrl;
    //   1229: astore 12
    //   1231: getstatic 413	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1234: invokevirtual 417	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1237: checkcast 419	com/tencent/mobileqq/app/QQAppInterface
    //   1240: invokevirtual 422	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1243: astore 8
    //   1245: aload_2
    //   1246: ifnull +568 -> 1814
    //   1249: iconst_1
    //   1250: istore 6
    //   1252: aload 12
    //   1254: aload 8
    //   1256: ldc_w 424
    //   1259: iload 6
    //   1261: lconst_1
    //   1262: lconst_0
    //   1263: aload 11
    //   1265: ldc 200
    //   1267: iconst_0
    //   1268: invokevirtual 427	axrl:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1271: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1274: ifeq +61 -> 1335
    //   1277: new 53	java/lang/StringBuilder
    //   1280: dup
    //   1281: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1284: ldc_w 442
    //   1287: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: aload_1
    //   1291: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1294: ldc_w 386
    //   1297: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: astore 8
    //   1302: aload_2
    //   1303: ifnull +1564 -> 2867
    //   1306: iconst_1
    //   1307: istore 6
    //   1309: ldc 27
    //   1311: iconst_2
    //   1312: aload 8
    //   1314: iload 6
    //   1316: invokevirtual 222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1319: ldc 234
    //   1321: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: aload 9
    //   1326: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1329: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1332: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1335: aload_2
    //   1336: ifnull +900 -> 2236
    //   1339: ldc 161
    //   1341: aload_1
    //   1342: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1345: ifeq +13 -> 1358
    //   1348: getstatic 331	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   1351: aload 9
    //   1353: aload_2
    //   1354: invokevirtual 443	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1357: pop
    //   1358: aload_3
    //   1359: aload 9
    //   1361: putfield 226	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   1364: ldc 165
    //   1366: aload_1
    //   1367: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1370: ifeq +839 -> 2209
    //   1373: aload_3
    //   1374: new 312	android/graphics/drawable/BitmapDrawable
    //   1377: dup
    //   1378: aload_0
    //   1379: invokevirtual 204	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1382: aload_2
    //   1383: invokespecial 315	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   1386: putfield 213	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   1389: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1392: ifeq -1128 -> 264
    //   1395: new 53	java/lang/StringBuilder
    //   1398: dup
    //   1399: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1402: ldc 215
    //   1404: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1407: aload_1
    //   1408: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1411: ldc_w 445
    //   1414: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: aload_3
    //   1418: getfield 226	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   1421: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1424: ldc 228
    //   1426: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1429: astore_2
    //   1430: aload_3
    //   1431: getfield 213	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   1434: ifnonnull +1056 -> 2490
    //   1437: iconst_1
    //   1438: istore 6
    //   1440: ldc 27
    //   1442: iconst_2
    //   1443: aload_2
    //   1444: iload 6
    //   1446: invokevirtual 222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1449: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1452: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1455: goto -1191 -> 264
    //   1458: astore_0
    //   1459: ldc 2
    //   1461: monitorexit
    //   1462: aload_0
    //   1463: athrow
    //   1464: aconst_null
    //   1465: astore_2
    //   1466: goto -781 -> 685
    //   1469: aload 11
    //   1471: getstatic 448	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   1474: putfield 368	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   1477: goto -662 -> 815
    //   1480: astore_2
    //   1481: ldc 27
    //   1483: iconst_1
    //   1484: new 53	java/lang/StringBuilder
    //   1487: dup
    //   1488: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1491: ldc_w 450
    //   1494: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: aload_2
    //   1498: invokevirtual 453	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1501: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1504: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1507: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1510: aload_3
    //   1511: aconst_null
    //   1512: putfield 213	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   1515: new 388	java/util/HashMap
    //   1518: dup
    //   1519: invokespecial 389	java/util/HashMap:<init>	()V
    //   1522: astore_2
    //   1523: aload_2
    //   1524: ldc_w 391
    //   1527: ldc_w 455
    //   1530: invokevirtual 397	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1533: pop
    //   1534: aload_2
    //   1535: ldc_w 399
    //   1538: aload_1
    //   1539: invokevirtual 397	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1542: pop
    //   1543: aload_2
    //   1544: ldc_w 401
    //   1547: invokestatic 404	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   1550: invokevirtual 397	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1553: pop
    //   1554: aload_0
    //   1555: invokestatic 409	axrl:a	(Landroid/content/Context;)Laxrl;
    //   1558: getstatic 413	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1561: invokevirtual 417	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1564: checkcast 419	com/tencent/mobileqq/app/QQAppInterface
    //   1567: invokevirtual 422	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1570: ldc_w 424
    //   1573: iconst_0
    //   1574: lconst_1
    //   1575: lconst_0
    //   1576: aload_2
    //   1577: ldc 200
    //   1579: iconst_0
    //   1580: invokevirtual 427	axrl:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1583: goto -194 -> 1389
    //   1586: astore_2
    //   1587: goto -198 -> 1389
    //   1590: iconst_0
    //   1591: istore 6
    //   1593: goto -695 -> 898
    //   1596: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1599: ifeq -685 -> 914
    //   1602: new 53	java/lang/StringBuilder
    //   1605: dup
    //   1606: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1609: ldc_w 457
    //   1612: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: aload_1
    //   1616: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1619: ldc 234
    //   1621: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1624: aload 9
    //   1626: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1629: ldc_w 384
    //   1632: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1635: aload 8
    //   1637: getfield 380	bawv:jdField_a_of_type_Int	I
    //   1640: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1643: ldc_w 386
    //   1646: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1649: astore 12
    //   1651: aload_2
    //   1652: ifnull +135 -> 1787
    //   1655: iconst_1
    //   1656: istore 6
    //   1658: ldc 27
    //   1660: iconst_2
    //   1661: aload 12
    //   1663: iload 6
    //   1665: invokevirtual 222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1668: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1671: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1674: goto -760 -> 914
    //   1677: astore_2
    //   1678: ldc 27
    //   1680: iconst_1
    //   1681: new 53	java/lang/StringBuilder
    //   1684: dup
    //   1685: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1688: ldc_w 459
    //   1691: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1694: aload_2
    //   1695: invokevirtual 460	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1698: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1701: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1704: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1707: aload_3
    //   1708: aconst_null
    //   1709: putfield 213	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   1712: new 388	java/util/HashMap
    //   1715: dup
    //   1716: invokespecial 389	java/util/HashMap:<init>	()V
    //   1719: astore_2
    //   1720: aload_2
    //   1721: ldc_w 391
    //   1724: ldc_w 462
    //   1727: invokevirtual 397	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1730: pop
    //   1731: aload_2
    //   1732: ldc_w 399
    //   1735: aload_1
    //   1736: invokevirtual 397	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1739: pop
    //   1740: aload_2
    //   1741: ldc_w 401
    //   1744: invokestatic 404	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   1747: invokevirtual 397	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1750: pop
    //   1751: aload_0
    //   1752: invokestatic 409	axrl:a	(Landroid/content/Context;)Laxrl;
    //   1755: getstatic 413	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1758: invokevirtual 417	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1761: checkcast 419	com/tencent/mobileqq/app/QQAppInterface
    //   1764: invokevirtual 422	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1767: ldc_w 424
    //   1770: iconst_0
    //   1771: lconst_1
    //   1772: lconst_0
    //   1773: aload_2
    //   1774: ldc 200
    //   1776: iconst_0
    //   1777: invokevirtual 427	axrl:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1780: goto -391 -> 1389
    //   1783: astore_2
    //   1784: goto -395 -> 1389
    //   1787: iconst_0
    //   1788: istore 6
    //   1790: goto -132 -> 1658
    //   1793: iconst_0
    //   1794: istore 6
    //   1796: goto -791 -> 1005
    //   1799: iconst_0
    //   1800: istore 6
    //   1802: goto -674 -> 1128
    //   1805: iload 4
    //   1807: iconst_2
    //   1808: imul
    //   1809: istore 4
    //   1811: goto -775 -> 1036
    //   1814: iconst_0
    //   1815: istore 6
    //   1817: goto -565 -> 1252
    //   1820: astore 8
    //   1822: goto -551 -> 1271
    //   1825: new 279	java/io/File
    //   1828: dup
    //   1829: aload 8
    //   1831: invokestatic 467	bfki:a	(Ljava/io/File;)Ljava/lang/String;
    //   1834: invokespecial 284	java/io/File:<init>	(Ljava/lang/String;)V
    //   1837: astore 11
    //   1839: aload 11
    //   1841: invokevirtual 287	java/io/File:exists	()Z
    //   1844: ifeq +326 -> 2170
    //   1847: aload_0
    //   1848: invokestatic 470	bfki:a	(Landroid/content/Context;)Z
    //   1851: istore 6
    //   1853: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1856: ifne +8 -> 1864
    //   1859: iload 6
    //   1861: ifne +50 -> 1911
    //   1864: ldc 27
    //   1866: iconst_2
    //   1867: new 53	java/lang/StringBuilder
    //   1870: dup
    //   1871: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1874: ldc_w 472
    //   1877: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1880: aload_1
    //   1881: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1884: ldc 234
    //   1886: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1889: aload 9
    //   1891: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1894: ldc_w 474
    //   1897: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1900: iload 6
    //   1902: invokevirtual 222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1905: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1908: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1911: aload_2
    //   1912: astore 8
    //   1914: iload 6
    //   1916: ifeq +80 -> 1996
    //   1919: aload 11
    //   1921: invokevirtual 477	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1924: invokestatic 483	com/tencent/sharpP/SharpPUtil:decodeSharpPByFilePath	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1927: astore 8
    //   1929: aload 8
    //   1931: astore_2
    //   1932: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1935: ifne +10 -> 1945
    //   1938: aload_2
    //   1939: astore 8
    //   1941: aload_2
    //   1942: ifnonnull +54 -> 1996
    //   1945: new 53	java/lang/StringBuilder
    //   1948: dup
    //   1949: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1952: ldc_w 485
    //   1955: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1958: astore 8
    //   1960: aload_2
    //   1961: ifnull +41 -> 2002
    //   1964: iconst_1
    //   1965: istore 6
    //   1967: ldc 27
    //   1969: iconst_2
    //   1970: aload 8
    //   1972: iload 6
    //   1974: invokevirtual 222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1977: ldc 234
    //   1979: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1982: aload 9
    //   1984: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1987: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1990: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1993: aload_2
    //   1994: astore 8
    //   1996: aload 8
    //   1998: astore_2
    //   1999: goto -728 -> 1271
    //   2002: iconst_0
    //   2003: istore 6
    //   2005: goto -38 -> 1967
    //   2008: astore 8
    //   2010: ldc 27
    //   2012: iconst_1
    //   2013: new 53	java/lang/StringBuilder
    //   2016: dup
    //   2017: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   2020: ldc_w 487
    //   2023: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2026: aload 8
    //   2028: invokevirtual 488	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   2031: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2034: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2037: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2040: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2043: ifne +10 -> 2053
    //   2046: aload_2
    //   2047: astore 8
    //   2049: aload_2
    //   2050: ifnonnull -54 -> 1996
    //   2053: new 53	java/lang/StringBuilder
    //   2056: dup
    //   2057: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   2060: ldc_w 485
    //   2063: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2066: astore 8
    //   2068: aload_2
    //   2069: ifnull +783 -> 2852
    //   2072: iconst_1
    //   2073: istore 6
    //   2075: ldc 27
    //   2077: iconst_2
    //   2078: aload 8
    //   2080: iload 6
    //   2082: invokevirtual 222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2085: ldc 234
    //   2087: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2090: aload 9
    //   2092: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2095: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2098: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2101: aload_2
    //   2102: astore 8
    //   2104: goto -108 -> 1996
    //   2107: astore 8
    //   2109: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2112: ifne +7 -> 2119
    //   2115: aload_2
    //   2116: ifnonnull +51 -> 2167
    //   2119: new 53	java/lang/StringBuilder
    //   2122: dup
    //   2123: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   2126: ldc_w 485
    //   2129: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2132: astore 10
    //   2134: aload_2
    //   2135: ifnull +723 -> 2858
    //   2138: iconst_1
    //   2139: istore 6
    //   2141: ldc 27
    //   2143: iconst_2
    //   2144: aload 10
    //   2146: iload 6
    //   2148: invokevirtual 222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2151: ldc 234
    //   2153: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2156: aload 9
    //   2158: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2161: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2164: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2167: aload 8
    //   2169: athrow
    //   2170: ldc 27
    //   2172: iconst_2
    //   2173: new 53	java/lang/StringBuilder
    //   2176: dup
    //   2177: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   2180: ldc_w 490
    //   2183: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2186: aload_1
    //   2187: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2190: ldc 234
    //   2192: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2195: aload 9
    //   2197: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2200: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2203: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2206: goto +658 -> 2864
    //   2209: new 492	anot
    //   2212: dup
    //   2213: aload_0
    //   2214: invokevirtual 204	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2217: aload_2
    //   2218: invokespecial 493	anot:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   2221: astore_2
    //   2222: aload_2
    //   2223: bipush 48
    //   2225: invokevirtual 497	anot:setGravity	(I)V
    //   2228: aload_3
    //   2229: aload_2
    //   2230: putfield 213	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   2233: goto -844 -> 1389
    //   2236: aload 10
    //   2238: new 53	java/lang/StringBuilder
    //   2241: dup
    //   2242: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   2245: aload_1
    //   2246: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2249: ldc_w 499
    //   2252: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2255: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2258: aconst_null
    //   2259: invokeinterface 140 3 0
    //   2264: astore 8
    //   2266: aload 8
    //   2268: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2271: ifne +165 -> 2436
    //   2274: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2277: ifeq +50 -> 2327
    //   2280: ldc 27
    //   2282: iconst_2
    //   2283: new 53	java/lang/StringBuilder
    //   2286: dup
    //   2287: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   2290: ldc_w 501
    //   2293: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2296: aload_1
    //   2297: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2300: ldc_w 503
    //   2303: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2306: aload 8
    //   2308: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2311: ldc 234
    //   2313: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2316: aload 9
    //   2318: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2321: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2324: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2327: new 505	com/tencent/mobileqq/theme/diy/ResData
    //   2330: dup
    //   2331: invokespecial 506	com/tencent/mobileqq/theme/diy/ResData:<init>	()V
    //   2334: astore_2
    //   2335: aload_2
    //   2336: aload 9
    //   2338: putfield 507	com/tencent/mobileqq/theme/diy/ResData:path	Ljava/lang/String;
    //   2341: aload_2
    //   2342: aload 8
    //   2344: putfield 510	com/tencent/mobileqq/theme/diy/ResData:url	Ljava/lang/String;
    //   2347: aload_3
    //   2348: getfield 236	com/tencent/mobileqq/theme/diy/ThemeBackground:isDecodeInDiy	Z
    //   2351: ifne +26 -> 2377
    //   2354: ldc 165
    //   2356: aload_1
    //   2357: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2360: ifne +12 -> 2372
    //   2363: ldc 163
    //   2365: aload_1
    //   2366: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2369: ifeq +59 -> 2428
    //   2372: aload_2
    //   2373: iconst_1
    //   2374: putfield 513	com/tencent/mobileqq/theme/diy/ResData:loadingType	I
    //   2377: aload_3
    //   2378: getfield 515	com/tencent/mobileqq/theme/diy/ThemeBackground:pageIndex	I
    //   2381: bipush 100
    //   2383: if_icmpne +20 -> 2403
    //   2386: aload_3
    //   2387: getfield 515	com/tencent/mobileqq/theme/diy/ThemeBackground:pageIndex	I
    //   2390: bipush 100
    //   2392: if_icmpne +481 -> 2873
    //   2395: iconst_1
    //   2396: istore 6
    //   2398: iload 6
    //   2400: putstatic 517	com/tencent/mobileqq/theme/diy/ThemeBackground:needUpdateThemeForBg	Z
    //   2403: aload_3
    //   2404: aload_0
    //   2405: aload_2
    //   2406: iconst_0
    //   2407: iconst_0
    //   2408: aload_3
    //   2409: getfield 515	com/tencent/mobileqq/theme/diy/ThemeBackground:pageIndex	I
    //   2412: iconst_1
    //   2413: invokestatic 523	com/tencent/mobileqq/theme/diy/DIYThemeUtils:getDIYDrawable	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/diy/ResData;IIIZ)Landroid/graphics/drawable/Drawable;
    //   2416: putfield 213	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   2419: aload_3
    //   2420: aload 9
    //   2422: putfield 226	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   2425: goto -1036 -> 1389
    //   2428: aload_2
    //   2429: iconst_2
    //   2430: putfield 513	com/tencent/mobileqq/theme/diy/ResData:loadingType	I
    //   2433: goto -56 -> 2377
    //   2436: ldc 27
    //   2438: iconst_2
    //   2439: new 53	java/lang/StringBuilder
    //   2442: dup
    //   2443: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   2446: ldc_w 525
    //   2449: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2452: aload_1
    //   2453: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2456: ldc 234
    //   2458: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2461: aload 9
    //   2463: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2466: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2469: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2472: aload_3
    //   2473: ldc 98
    //   2475: putfield 226	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   2478: goto -1089 -> 1389
    //   2481: aload_3
    //   2482: aload 9
    //   2484: putfield 226	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   2487: goto -1098 -> 1389
    //   2490: iconst_0
    //   2491: istore 6
    //   2493: goto -1053 -> 1440
    //   2496: iconst_0
    //   2497: istore 7
    //   2499: goto +329 -> 2828
    //   2502: aload 8
    //   2504: astore_2
    //   2505: aload 9
    //   2507: astore_1
    //   2508: ldc 252
    //   2510: aload 10
    //   2512: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2515: ifne +364 -> 2879
    //   2518: aload 8
    //   2520: astore_2
    //   2521: aload 9
    //   2523: astore_1
    //   2524: aload 10
    //   2526: invokestatic 258	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2529: sipush 5010
    //   2532: if_icmpge +347 -> 2879
    //   2535: iconst_1
    //   2536: istore 6
    //   2538: goto -2183 -> 355
    //   2541: aload 8
    //   2543: astore_2
    //   2544: aload 8
    //   2546: astore_1
    //   2547: ldc 27
    //   2549: iconst_1
    //   2550: ldc_w 527
    //   2553: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2556: goto -1940 -> 616
    //   2559: astore_0
    //   2560: aload_2
    //   2561: astore_1
    //   2562: ldc 27
    //   2564: iconst_1
    //   2565: new 53	java/lang/StringBuilder
    //   2568: dup
    //   2569: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   2572: ldc_w 529
    //   2575: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2578: aload_0
    //   2579: invokevirtual 460	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2582: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2585: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2588: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2591: aload_2
    //   2592: ifnull -1953 -> 639
    //   2595: aload_2
    //   2596: invokevirtual 322	java/io/InputStream:close	()V
    //   2599: goto -1960 -> 639
    //   2602: astore_0
    //   2603: ldc 27
    //   2605: iconst_1
    //   2606: new 53	java/lang/StringBuilder
    //   2609: dup
    //   2610: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   2613: ldc_w 531
    //   2616: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2619: aload_0
    //   2620: invokevirtual 460	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2623: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2626: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2629: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2632: goto -1993 -> 639
    //   2635: aload 8
    //   2637: astore_2
    //   2638: aload 9
    //   2640: astore_1
    //   2641: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2644: ifeq -2017 -> 627
    //   2647: aload 8
    //   2649: astore_2
    //   2650: aload 9
    //   2652: astore_1
    //   2653: ldc 27
    //   2655: iconst_2
    //   2656: ldc_w 533
    //   2659: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2662: goto -2035 -> 627
    //   2665: astore_0
    //   2666: aload_1
    //   2667: ifnull +7 -> 2674
    //   2670: aload_1
    //   2671: invokevirtual 322	java/io/InputStream:close	()V
    //   2674: aload_0
    //   2675: athrow
    //   2676: astore_0
    //   2677: ldc 27
    //   2679: iconst_1
    //   2680: new 53	java/lang/StringBuilder
    //   2683: dup
    //   2684: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   2687: ldc_w 531
    //   2690: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2693: aload_0
    //   2694: invokevirtual 460	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2697: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2700: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2703: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2706: goto -2067 -> 639
    //   2709: astore_1
    //   2710: ldc 27
    //   2712: iconst_1
    //   2713: new 53	java/lang/StringBuilder
    //   2716: dup
    //   2717: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   2720: ldc_w 531
    //   2723: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2726: aload_1
    //   2727: invokevirtual 460	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2730: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2733: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2736: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2739: goto -65 -> 2674
    //   2742: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2745: ifeq +63 -> 2808
    //   2748: new 53	java/lang/StringBuilder
    //   2751: dup
    //   2752: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   2755: ldc 215
    //   2757: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2760: aload_1
    //   2761: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2764: ldc_w 535
    //   2767: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2770: aload_3
    //   2771: getfield 226	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   2774: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2777: ldc 228
    //   2779: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2782: astore_0
    //   2783: aload_3
    //   2784: getfield 213	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   2787: ifnonnull +27 -> 2814
    //   2790: iconst_1
    //   2791: istore 6
    //   2793: ldc 27
    //   2795: iconst_2
    //   2796: aload_0
    //   2797: iload 6
    //   2799: invokevirtual 222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2802: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2805: invokestatic 538	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2808: iconst_0
    //   2809: istore 6
    //   2811: goto -2789 -> 22
    //   2814: iconst_0
    //   2815: istore 6
    //   2817: goto -24 -> 2793
    //   2820: astore 12
    //   2822: goto -1798 -> 1024
    //   2825: goto -1554 -> 1271
    //   2828: iload 7
    //   2830: ifeq -328 -> 2502
    //   2833: iconst_0
    //   2834: istore 6
    //   2836: goto -2481 -> 355
    //   2839: iload 7
    //   2841: ifne -2405 -> 436
    //   2844: iload 6
    //   2846: ifeq -2219 -> 627
    //   2849: goto -2413 -> 436
    //   2852: iconst_0
    //   2853: istore 6
    //   2855: goto -780 -> 2075
    //   2858: iconst_0
    //   2859: istore 6
    //   2861: goto -720 -> 2141
    //   2864: goto -1593 -> 1271
    //   2867: iconst_0
    //   2868: istore 6
    //   2870: goto -1561 -> 1309
    //   2873: iconst_0
    //   2874: istore 6
    //   2876: goto -478 -> 2398
    //   2879: iconst_0
    //   2880: istore 6
    //   2882: goto -2527 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2885	0	paramContext	Context
    //   0	2885	1	paramString1	String
    //   0	2885	2	paramString2	String
    //   0	2885	3	paramThemeBackground	ThemeBackground
    //   1034	776	4	i	int
    //   1163	6	5	j	int
    //   20	2861	6	bool1	boolean
    //   350	2490	7	bool2	boolean
    //   311	1325	8	localObject1	Object
    //   1820	10	8	localException1	java.lang.Exception
    //   1912	85	8	localObject2	Object
    //   2008	19	8	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   2047	56	8	localObject3	Object
    //   2107	61	8	localObject4	Object
    //   2264	384	8	str1	String
    //   46	2605	9	localObject5	Object
    //   34	2491	10	localObject6	Object
    //   305	1615	11	localObject7	Object
    //   889	773	12	localObject8	Object
    //   2820	1	12	localException2	java.lang.Exception
    //   982	24	13	localaxrl	axrl
    //   996	12	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   11	19	1458	finally
    //   28	48	1458	finally
    //   53	76	1458	finally
    //   76	145	1458	finally
    //   148	163	1458	finally
    //   163	189	1458	finally
    //   189	217	1458	finally
    //   217	264	1458	finally
    //   264	307	1458	finally
    //   631	639	1458	finally
    //   651	657	1458	finally
    //   662	685	1458	finally
    //   689	770	1458	finally
    //   770	815	1458	finally
    //   815	830	1458	finally
    //   834	842	1458	finally
    //   842	891	1458	finally
    //   898	914	1458	finally
    //   914	998	1458	finally
    //   1005	1024	1458	finally
    //   1024	1033	1458	finally
    //   1043	1071	1458	finally
    //   1075	1121	1458	finally
    //   1128	1158	1458	finally
    //   1158	1165	1458	finally
    //   1171	1245	1458	finally
    //   1252	1271	1458	finally
    //   1271	1302	1458	finally
    //   1309	1335	1458	finally
    //   1339	1358	1458	finally
    //   1358	1389	1458	finally
    //   1389	1437	1458	finally
    //   1440	1455	1458	finally
    //   1469	1477	1458	finally
    //   1481	1515	1458	finally
    //   1515	1583	1458	finally
    //   1596	1651	1458	finally
    //   1658	1674	1458	finally
    //   1678	1712	1458	finally
    //   1712	1780	1458	finally
    //   1825	1859	1458	finally
    //   1864	1911	1458	finally
    //   1932	1938	1458	finally
    //   1945	1960	1458	finally
    //   1967	1993	1458	finally
    //   2040	2046	1458	finally
    //   2053	2068	1458	finally
    //   2075	2101	1458	finally
    //   2109	2115	1458	finally
    //   2119	2134	1458	finally
    //   2141	2167	1458	finally
    //   2167	2170	1458	finally
    //   2170	2206	1458	finally
    //   2209	2233	1458	finally
    //   2236	2327	1458	finally
    //   2327	2372	1458	finally
    //   2372	2377	1458	finally
    //   2377	2395	1458	finally
    //   2398	2403	1458	finally
    //   2403	2425	1458	finally
    //   2428	2433	1458	finally
    //   2436	2478	1458	finally
    //   2481	2487	1458	finally
    //   2595	2599	1458	finally
    //   2603	2632	1458	finally
    //   2670	2674	1458	finally
    //   2674	2676	1458	finally
    //   2677	2706	1458	finally
    //   2710	2739	1458	finally
    //   2742	2790	1458	finally
    //   2793	2808	1458	finally
    //   662	685	1480	java/lang/OutOfMemoryError
    //   689	770	1480	java/lang/OutOfMemoryError
    //   770	815	1480	java/lang/OutOfMemoryError
    //   815	830	1480	java/lang/OutOfMemoryError
    //   834	842	1480	java/lang/OutOfMemoryError
    //   842	891	1480	java/lang/OutOfMemoryError
    //   898	914	1480	java/lang/OutOfMemoryError
    //   914	998	1480	java/lang/OutOfMemoryError
    //   1005	1024	1480	java/lang/OutOfMemoryError
    //   1024	1033	1480	java/lang/OutOfMemoryError
    //   1043	1071	1480	java/lang/OutOfMemoryError
    //   1075	1121	1480	java/lang/OutOfMemoryError
    //   1128	1158	1480	java/lang/OutOfMemoryError
    //   1158	1165	1480	java/lang/OutOfMemoryError
    //   1171	1245	1480	java/lang/OutOfMemoryError
    //   1252	1271	1480	java/lang/OutOfMemoryError
    //   1271	1302	1480	java/lang/OutOfMemoryError
    //   1309	1335	1480	java/lang/OutOfMemoryError
    //   1339	1358	1480	java/lang/OutOfMemoryError
    //   1358	1389	1480	java/lang/OutOfMemoryError
    //   1469	1477	1480	java/lang/OutOfMemoryError
    //   1596	1651	1480	java/lang/OutOfMemoryError
    //   1658	1674	1480	java/lang/OutOfMemoryError
    //   1825	1859	1480	java/lang/OutOfMemoryError
    //   1864	1911	1480	java/lang/OutOfMemoryError
    //   1932	1938	1480	java/lang/OutOfMemoryError
    //   1945	1960	1480	java/lang/OutOfMemoryError
    //   1967	1993	1480	java/lang/OutOfMemoryError
    //   2040	2046	1480	java/lang/OutOfMemoryError
    //   2053	2068	1480	java/lang/OutOfMemoryError
    //   2075	2101	1480	java/lang/OutOfMemoryError
    //   2109	2115	1480	java/lang/OutOfMemoryError
    //   2119	2134	1480	java/lang/OutOfMemoryError
    //   2141	2167	1480	java/lang/OutOfMemoryError
    //   2167	2170	1480	java/lang/OutOfMemoryError
    //   2170	2206	1480	java/lang/OutOfMemoryError
    //   2209	2233	1480	java/lang/OutOfMemoryError
    //   2236	2327	1480	java/lang/OutOfMemoryError
    //   2327	2372	1480	java/lang/OutOfMemoryError
    //   2372	2377	1480	java/lang/OutOfMemoryError
    //   2377	2395	1480	java/lang/OutOfMemoryError
    //   2398	2403	1480	java/lang/OutOfMemoryError
    //   2403	2425	1480	java/lang/OutOfMemoryError
    //   2428	2433	1480	java/lang/OutOfMemoryError
    //   2436	2478	1480	java/lang/OutOfMemoryError
    //   1515	1583	1586	java/lang/Exception
    //   662	685	1677	java/lang/Exception
    //   689	770	1677	java/lang/Exception
    //   770	815	1677	java/lang/Exception
    //   815	830	1677	java/lang/Exception
    //   834	842	1677	java/lang/Exception
    //   842	891	1677	java/lang/Exception
    //   898	914	1677	java/lang/Exception
    //   1024	1033	1677	java/lang/Exception
    //   1043	1071	1677	java/lang/Exception
    //   1075	1121	1677	java/lang/Exception
    //   1128	1158	1677	java/lang/Exception
    //   1158	1165	1677	java/lang/Exception
    //   1271	1302	1677	java/lang/Exception
    //   1309	1335	1677	java/lang/Exception
    //   1339	1358	1677	java/lang/Exception
    //   1358	1389	1677	java/lang/Exception
    //   1469	1477	1677	java/lang/Exception
    //   1596	1651	1677	java/lang/Exception
    //   1658	1674	1677	java/lang/Exception
    //   1825	1859	1677	java/lang/Exception
    //   1864	1911	1677	java/lang/Exception
    //   1932	1938	1677	java/lang/Exception
    //   1945	1960	1677	java/lang/Exception
    //   1967	1993	1677	java/lang/Exception
    //   2040	2046	1677	java/lang/Exception
    //   2053	2068	1677	java/lang/Exception
    //   2075	2101	1677	java/lang/Exception
    //   2109	2115	1677	java/lang/Exception
    //   2119	2134	1677	java/lang/Exception
    //   2141	2167	1677	java/lang/Exception
    //   2167	2170	1677	java/lang/Exception
    //   2170	2206	1677	java/lang/Exception
    //   2209	2233	1677	java/lang/Exception
    //   2236	2327	1677	java/lang/Exception
    //   2327	2372	1677	java/lang/Exception
    //   2372	2377	1677	java/lang/Exception
    //   2377	2395	1677	java/lang/Exception
    //   2398	2403	1677	java/lang/Exception
    //   2403	2425	1677	java/lang/Exception
    //   2428	2433	1677	java/lang/Exception
    //   2436	2478	1677	java/lang/Exception
    //   1712	1780	1783	java/lang/Exception
    //   1171	1245	1820	java/lang/Exception
    //   1252	1271	1820	java/lang/Exception
    //   1919	1929	2008	java/lang/UnsatisfiedLinkError
    //   1919	1929	2107	finally
    //   2010	2040	2107	finally
    //   319	329	2559	java/lang/Exception
    //   335	349	2559	java/lang/Exception
    //   361	367	2559	java/lang/Exception
    //   373	433	2559	java/lang/Exception
    //   442	450	2559	java/lang/Exception
    //   456	486	2559	java/lang/Exception
    //   492	500	2559	java/lang/Exception
    //   506	514	2559	java/lang/Exception
    //   520	526	2559	java/lang/Exception
    //   532	541	2559	java/lang/Exception
    //   547	562	2559	java/lang/Exception
    //   568	575	2559	java/lang/Exception
    //   586	603	2559	java/lang/Exception
    //   609	616	2559	java/lang/Exception
    //   622	627	2559	java/lang/Exception
    //   2508	2518	2559	java/lang/Exception
    //   2524	2535	2559	java/lang/Exception
    //   2547	2556	2559	java/lang/Exception
    //   2641	2647	2559	java/lang/Exception
    //   2653	2662	2559	java/lang/Exception
    //   2595	2599	2602	java/lang/Exception
    //   319	329	2665	finally
    //   335	349	2665	finally
    //   361	367	2665	finally
    //   373	433	2665	finally
    //   442	450	2665	finally
    //   456	486	2665	finally
    //   492	500	2665	finally
    //   506	514	2665	finally
    //   520	526	2665	finally
    //   532	541	2665	finally
    //   547	562	2665	finally
    //   568	575	2665	finally
    //   586	603	2665	finally
    //   609	616	2665	finally
    //   622	627	2665	finally
    //   2508	2518	2665	finally
    //   2524	2535	2665	finally
    //   2547	2556	2665	finally
    //   2562	2591	2665	finally
    //   2641	2647	2665	finally
    //   2653	2662	2665	finally
    //   631	639	2676	java/lang/Exception
    //   2670	2674	2709	java/lang/Exception
    //   914	998	2820	java/lang/Exception
    //   1005	1024	2820	java/lang/Exception
  }
  
  public static boolean getThemeBackgroundEnable()
  {
    return ThemeUtil.getIsDIYTheme(null);
  }
  
  public static String getThemeBackgroundId(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    return getSharedPreferences(paramContext, paramString2, 0).getString(paramString1 + "_id", "0");
  }
  
  public static String getThemeBackgroundPathByType(Context paramContext, String paramString1, String paramString2)
  {
    return getSharedPreferences(paramContext, paramString2, 0).getString(paramString1, "null");
  }
  
  public static String getThemeBackgroundUrl(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    return getSharedPreferences(paramContext, paramString2, 0).getString(paramString1 + "_url", "");
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
      if (localThemeBackground.img != null)
      {
        localThemeBackground.img = new LayerDrawable(new Drawable[] { localThemeBackground.img, paramAppRuntime.getApplication().getApplicationContext().getResources().getDrawable(2130846557) });
        continue;
        getThemeBackground(paramContext, "theme_bg_message_path_png", paramAppRuntime.getAccount(), localThemeBackground);
        continue;
        getThemeBackground(paramContext, "theme_bg_friend_path_png", paramAppRuntime.getAccount(), localThemeBackground);
        if (localThemeBackground.img == null)
        {
          getThemeBackground(paramContext, "theme_bg_message_path_png", paramAppRuntime.getAccount(), localThemeBackground);
          continue;
          getThemeBackground(paramContext, "theme_bg_dynamic_path_png", paramAppRuntime.getAccount(), localThemeBackground);
          if (localThemeBackground.img == null)
          {
            getThemeBackground(paramContext, "theme_bg_message_path_png", paramAppRuntime.getAccount(), localThemeBackground);
            continue;
            if (ThemeUtil.isNowThemeIsAnimate())
            {
              localThemeBackground.isAnimateBg = true;
              switch (paramInt)
              {
              case 2: 
              default: 
                break;
              case 0: 
                localThemeBackground.path = ThemeUtil.getAnimatePathByTag(1);
                paramContext = paramContext.getResources().getDrawable(2130845200);
                localThemeBackground.img = bbql.a(paramAppRuntime, localThemeBackground.path, "-setting-", paramContext, new int[] { 1 }, paramString, null);
                break;
              case 1: 
              case 3: 
              case 4: 
                Bundle localBundle = new Bundle();
                localBundle.putBoolean("key_use_rect", true);
                localThemeBackground.path = ThemeUtil.getAnimatePathByTag(2);
                paramContext = paramContext.getResources().getDrawable(2130838515);
                localThemeBackground.img = bbql.a(paramAppRuntime, localThemeBackground.path, "-conversation-", paramContext, bbql.a, paramString, localBundle);
              }
            }
          }
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
    paramContext = getSharedPreferences(paramContext, paramString2, 4).edit();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeBackground
 * JD-Core Version:    0.7.0.1
 */