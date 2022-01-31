package com.tencent.mobileqq.startup.step;

import ahrl;
import ahrm;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;

public class SetSplash
  extends Step
{
  private static int a(String paramString)
  {
    int i = Calendar.getInstance().get(1);
    paramString = i + "-" + paramString;
    Object localObject = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      paramString = ((SimpleDateFormat)localObject).parse(paramString);
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTime(paramString);
      ((Calendar)localObject).set(11, 0);
      ((Calendar)localObject).set(12, 0);
      ((Calendar)localObject).set(13, 0);
      ((Calendar)localObject).set(14, 0);
      paramString = ((Calendar)localObject).getTime();
      localObject = Calendar.getInstance();
      ((Calendar)localObject).set(11, 0);
      ((Calendar)localObject).set(12, 0);
      ((Calendar)localObject).set(13, 0);
      ((Calendar)localObject).set(14, 0);
      localObject = ((Calendar)localObject).getTime();
      long l = (paramString.getTime() - ((Date)localObject).getTime()) / 86400000L;
      return (int)l;
    }
    catch (Exception paramString) {}
    return -1;
  }
  
  /* Error */
  public static long a(android.app.Activity paramActivity, StartupDirector paramStartupDirector)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 76
    //   4: ifeq +705 -> 709
    //   7: aload_0
    //   8: checkcast 76	com/tencent/mobileqq/app/IphoneTitleBarActivity
    //   11: ldc 77
    //   13: invokevirtual 81	com/tencent/mobileqq/app/IphoneTitleBarActivity:setContentViewNoTitle	(I)V
    //   16: aload_0
    //   17: ldc 82
    //   19: invokevirtual 88	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   22: checkcast 90	android/widget/ImageView
    //   25: astore 23
    //   27: aload_0
    //   28: ldc 91
    //   30: invokevirtual 88	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   33: checkcast 90	android/widget/ImageView
    //   36: astore 22
    //   38: aload_0
    //   39: invokestatic 97	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;)Ljava/lang/String;
    //   42: astore 18
    //   44: aload_0
    //   45: invokevirtual 101	android/app/Activity:getFilesDir	()Ljava/io/File;
    //   48: astore 19
    //   50: aload 19
    //   52: ifnull +692 -> 744
    //   55: aload 19
    //   57: invokevirtual 106	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   60: astore 20
    //   62: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq +29 -> 94
    //   68: ldc 114
    //   70: iconst_2
    //   71: new 25	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   78: aload 18
    //   80: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload 19
    //   85: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 121	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload 19
    //   96: ifnull +1321 -> 1417
    //   99: aload 18
    //   101: ldc 123
    //   103: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   106: ifne +1311 -> 1417
    //   109: aload 18
    //   111: invokestatic 131	com/tencent/mobileqq/startup/step/SetSplash:a	(Ljava/lang/String;)I
    //   114: ifne +1303 -> 1417
    //   117: new 25	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   124: aload 20
    //   126: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc 133
    //   131: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_0
    //   135: invokestatic 135	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   138: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 133
    //   143: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc 137
    //   148: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: astore 18
    //   156: new 103	java/io/File
    //   159: dup
    //   160: aload 18
    //   162: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   165: astore 19
    //   167: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +37 -> 207
    //   173: ldc 114
    //   175: iconst_2
    //   176: new 25	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   183: aload 18
    //   185: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: ldc 140
    //   190: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload 19
    //   195: invokevirtual 143	java/io/File:exists	()Z
    //   198: invokevirtual 146	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   201: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 149	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload 19
    //   209: invokevirtual 143	java/io/File:exists	()Z
    //   212: ifeq +1205 -> 1417
    //   215: new 151	android/graphics/drawable/BitmapDrawable
    //   218: dup
    //   219: aload_0
    //   220: invokevirtual 155	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   223: aload 18
    //   225: invokestatic 160	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   228: invokespecial 163	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   231: astore 18
    //   233: aload_1
    //   234: ifnull +10 -> 244
    //   237: aload_1
    //   238: ldc2_w 164
    //   241: putfield 170	com/tencent/mobileqq/startup/director/StartupDirector:jdField_a_of_type_Long	J
    //   244: aload 18
    //   246: ifnull +1164 -> 1410
    //   249: invokestatic 172	com/tencent/mobileqq/startup/step/SetSplash:a	()V
    //   252: aload 18
    //   254: astore 19
    //   256: aload 19
    //   258: astore 18
    //   260: aload 19
    //   262: ifnonnull +25 -> 287
    //   265: aload 19
    //   267: astore 18
    //   269: invokestatic 178	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   272: invokestatic 181	com/tencent/mobileqq/startup/step/SetSplash:a	(Landroid/content/Context;)Z
    //   275: ifeq +12 -> 287
    //   278: invokestatic 178	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   281: aload_1
    //   282: invokestatic 184	com/tencent/mobileqq/startup/step/SetSplash:a	(Landroid/content/Context;Lcom/tencent/mobileqq/startup/director/StartupDirector;)Landroid/graphics/drawable/AnimationDrawable;
    //   285: astore 18
    //   287: aload 18
    //   289: astore 19
    //   291: aload 18
    //   293: ifnonnull +1110 -> 1403
    //   296: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +11 -> 310
    //   302: ldc 186
    //   304: iconst_2
    //   305: ldc 188
    //   307: invokestatic 121	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   310: new 25	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   317: aload 20
    //   319: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: ldc 190
    //   324: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: astore 24
    //   332: new 103	java/io/File
    //   335: dup
    //   336: new 25	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   343: aload 20
    //   345: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: ldc 192
    //   350: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   359: astore 25
    //   361: lconst_0
    //   362: lstore 10
    //   364: lconst_0
    //   365: lstore 12
    //   367: aconst_null
    //   368: astore 21
    //   370: aconst_null
    //   371: astore 19
    //   373: aload 21
    //   375: astore 20
    //   377: aload 25
    //   379: ifnull +481 -> 860
    //   382: aload 21
    //   384: astore 20
    //   386: aload 25
    //   388: invokevirtual 143	java/io/File:exists	()Z
    //   391: ifeq +469 -> 860
    //   394: aload 21
    //   396: astore 20
    //   398: aload 25
    //   400: invokevirtual 195	java/io/File:isDirectory	()Z
    //   403: ifeq +457 -> 860
    //   406: aload 25
    //   408: invokevirtual 199	java/io/File:listFiles	()[Ljava/io/File;
    //   411: astore 25
    //   413: aload 25
    //   415: arraylength
    //   416: istore 4
    //   418: iconst_0
    //   419: istore_3
    //   420: aload 19
    //   422: astore 20
    //   424: iload_3
    //   425: iload 4
    //   427: if_icmpge +433 -> 860
    //   430: aload 25
    //   432: iload_3
    //   433: aaload
    //   434: astore 26
    //   436: aload 19
    //   438: astore 21
    //   440: lload 12
    //   442: lstore 14
    //   444: lload 10
    //   446: lstore 16
    //   448: aload 26
    //   450: ifnull +240 -> 690
    //   453: aload 26
    //   455: invokevirtual 202	java/io/File:getName	()Ljava/lang/String;
    //   458: astore 27
    //   460: aload 27
    //   462: ldc 204
    //   464: invokevirtual 208	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   467: astore 28
    //   469: aload 19
    //   471: astore 21
    //   473: lload 12
    //   475: lstore 14
    //   477: lload 10
    //   479: lstore 16
    //   481: aload 28
    //   483: ifnull +207 -> 690
    //   486: aload 19
    //   488: astore 21
    //   490: lload 12
    //   492: lstore 14
    //   494: lload 10
    //   496: lstore 16
    //   498: aload 28
    //   500: arraylength
    //   501: iconst_3
    //   502: if_icmpne +188 -> 690
    //   505: aload 28
    //   507: iconst_0
    //   508: aaload
    //   509: astore 20
    //   511: lload 12
    //   513: lstore 6
    //   515: lload 10
    //   517: lstore 8
    //   519: aload 20
    //   521: ifnull +60 -> 581
    //   524: lload 12
    //   526: lstore 6
    //   528: lload 10
    //   530: lstore 8
    //   532: aload 20
    //   534: invokevirtual 211	java/lang/String:trim	()Ljava/lang/String;
    //   537: ldc 123
    //   539: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   542: ifne +39 -> 581
    //   545: aload 20
    //   547: ldc 213
    //   549: invokevirtual 216	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   552: istore 5
    //   554: aload 20
    //   556: iconst_0
    //   557: iload 5
    //   559: invokevirtual 220	java/lang/String:substring	(II)Ljava/lang/String;
    //   562: invokestatic 226	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   565: lstore 8
    //   567: aload 20
    //   569: iload 5
    //   571: iconst_1
    //   572: iadd
    //   573: invokevirtual 229	java/lang/String:substring	(I)Ljava/lang/String;
    //   576: invokestatic 226	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   579: lstore 6
    //   581: lload 8
    //   583: lload 6
    //   585: invokestatic 234	com/tencent/mobileqq/util/CommonUtil:a	(JJ)Z
    //   588: ifeq +205 -> 793
    //   591: aload 19
    //   593: astore 20
    //   595: aload 19
    //   597: ifnonnull +34 -> 631
    //   600: new 103	java/io/File
    //   603: dup
    //   604: new 25	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   611: aload 24
    //   613: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: aload 28
    //   618: iconst_1
    //   619: aaload
    //   620: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   629: astore 20
    //   631: aload 20
    //   633: astore 21
    //   635: lload 6
    //   637: lstore 14
    //   639: lload 8
    //   641: lstore 16
    //   643: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   646: ifeq +44 -> 690
    //   649: ldc 186
    //   651: iconst_2
    //   652: new 25	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   659: ldc 236
    //   661: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: aload 26
    //   666: invokevirtual 106	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   669: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 121	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   678: lload 8
    //   680: lstore 16
    //   682: lload 6
    //   684: lstore 14
    //   686: aload 20
    //   688: astore 21
    //   690: iload_3
    //   691: iconst_1
    //   692: iadd
    //   693: istore_3
    //   694: aload 21
    //   696: astore 19
    //   698: lload 14
    //   700: lstore 12
    //   702: lload 16
    //   704: lstore 10
    //   706: goto -286 -> 420
    //   709: aload_0
    //   710: ldc 77
    //   712: invokevirtual 239	android/app/Activity:setContentView	(I)V
    //   715: goto -699 -> 16
    //   718: astore_1
    //   719: aload_1
    //   720: invokestatic 245	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   723: astore_1
    //   724: ldc 247
    //   726: iconst_1
    //   727: aload_1
    //   728: invokestatic 149	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   731: aload_0
    //   732: ldc 249
    //   734: aload_1
    //   735: invokestatic 255	com/tencent/mobileqq/app/InjectUtils:uploadInjectFailure	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   738: aload_0
    //   739: invokevirtual 258	android/app/Activity:finish	()V
    //   742: lconst_0
    //   743: lreturn
    //   744: ldc_w 260
    //   747: astore 20
    //   749: goto -687 -> 62
    //   752: astore 19
    //   754: aconst_null
    //   755: astore 18
    //   757: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   760: ifeq +14 -> 774
    //   763: ldc 114
    //   765: iconst_2
    //   766: ldc_w 262
    //   769: aload 19
    //   771: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   774: aload 19
    //   776: invokevirtual 268	java/lang/Throwable:printStackTrace	()V
    //   779: goto -535 -> 244
    //   782: astore 20
    //   784: lconst_0
    //   785: lstore 8
    //   787: lconst_0
    //   788: lstore 6
    //   790: goto -209 -> 581
    //   793: aload 19
    //   795: astore 20
    //   797: lload 6
    //   799: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   802: lcmp
    //   803: ifge -172 -> 631
    //   806: new 103	java/io/File
    //   809: dup
    //   810: new 25	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   817: aload 24
    //   819: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: aload 27
    //   824: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   833: astore 21
    //   835: aload 19
    //   837: astore 20
    //   839: aload 21
    //   841: invokevirtual 143	java/io/File:exists	()Z
    //   844: ifeq -213 -> 631
    //   847: aload 21
    //   849: invokevirtual 276	java/io/File:delete	()Z
    //   852: pop
    //   853: aload 19
    //   855: astore 20
    //   857: goto -226 -> 631
    //   860: aload 18
    //   862: astore 19
    //   864: aload 20
    //   866: ifnull +537 -> 1403
    //   869: aload 18
    //   871: astore 19
    //   873: aload 20
    //   875: invokevirtual 143	java/io/File:exists	()Z
    //   878: ifeq +525 -> 1403
    //   881: aload 18
    //   883: astore 19
    //   885: aload 20
    //   887: invokevirtual 279	java/io/File:isFile	()Z
    //   890: ifeq +513 -> 1403
    //   893: new 151	android/graphics/drawable/BitmapDrawable
    //   896: dup
    //   897: aload_0
    //   898: invokevirtual 155	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   901: aload 20
    //   903: invokevirtual 106	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   906: invokestatic 160	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   909: invokespecial 163	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   912: astore 19
    //   914: aload_1
    //   915: ifnull +10 -> 925
    //   918: aload_1
    //   919: ldc2_w 280
    //   922: putfield 170	com/tencent/mobileqq/startup/director/StartupDirector:jdField_a_of_type_Long	J
    //   925: aload 19
    //   927: astore_1
    //   928: aload_1
    //   929: astore 19
    //   931: aload_1
    //   932: ifnull +471 -> 1403
    //   935: invokestatic 172	com/tencent/mobileqq/startup/step/SetSplash:a	()V
    //   938: aload_1
    //   939: astore 18
    //   941: aload 18
    //   943: ifnonnull +455 -> 1398
    //   946: new 151	android/graphics/drawable/BitmapDrawable
    //   949: dup
    //   950: aload_0
    //   951: invokevirtual 155	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   954: aload_0
    //   955: invokevirtual 285	android/app/Activity:getAssets	()Landroid/content/res/AssetManager;
    //   958: ldc_w 287
    //   961: invokevirtual 293	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   964: invokespecial 296	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Ljava/io/InputStream;)V
    //   967: astore 18
    //   969: new 151	android/graphics/drawable/BitmapDrawable
    //   972: dup
    //   973: aload_0
    //   974: invokevirtual 155	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   977: aload_0
    //   978: invokevirtual 285	android/app/Activity:getAssets	()Landroid/content/res/AssetManager;
    //   981: ldc_w 298
    //   984: invokevirtual 293	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   987: invokespecial 296	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Ljava/io/InputStream;)V
    //   990: astore_1
    //   991: aload 18
    //   993: ifnull +41 -> 1034
    //   996: aload 23
    //   998: aload 18
    //   1000: invokevirtual 302	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1003: aload 18
    //   1005: instanceof 304
    //   1008: ifeq +26 -> 1034
    //   1011: aload 18
    //   1013: checkcast 304	android/graphics/drawable/AnimationDrawable
    //   1016: astore 18
    //   1018: aload 18
    //   1020: ifnull +14 -> 1034
    //   1023: aload 18
    //   1025: iconst_0
    //   1026: invokevirtual 308	android/graphics/drawable/AnimationDrawable:setOneShot	(Z)V
    //   1029: aload 18
    //   1031: invokevirtual 311	android/graphics/drawable/AnimationDrawable:start	()V
    //   1034: aload 23
    //   1036: invokevirtual 315	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   1039: astore 18
    //   1041: aload 18
    //   1043: ifnull +107 -> 1150
    //   1046: aload 18
    //   1048: instanceof 151
    //   1051: ifne +19 -> 1070
    //   1054: aload 18
    //   1056: instanceof 317
    //   1059: ifne +11 -> 1070
    //   1062: aload 18
    //   1064: instanceof 304
    //   1067: ifeq +83 -> 1150
    //   1070: aload_0
    //   1071: invokevirtual 155	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1074: invokevirtual 323	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1077: getfield 329	android/util/DisplayMetrics:widthPixels	I
    //   1080: istore_3
    //   1081: aload_0
    //   1082: invokevirtual 155	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1085: invokevirtual 323	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1088: getfield 332	android/util/DisplayMetrics:heightPixels	I
    //   1091: istore 4
    //   1093: aload 18
    //   1095: invokevirtual 338	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   1098: iload_3
    //   1099: imul
    //   1100: aload 18
    //   1102: invokevirtual 341	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   1105: idiv
    //   1106: istore 5
    //   1108: aload 23
    //   1110: invokevirtual 345	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1113: astore 18
    //   1115: aload 18
    //   1117: iload_3
    //   1118: putfield 350	android/view/ViewGroup$LayoutParams:width	I
    //   1121: aload 18
    //   1123: iload 5
    //   1125: putfield 353	android/view/ViewGroup$LayoutParams:height	I
    //   1128: aload 23
    //   1130: aload 18
    //   1132: invokevirtual 357	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1135: iload 5
    //   1137: iload 4
    //   1139: if_icmpgt +187 -> 1326
    //   1142: aload 23
    //   1144: getstatic 363	android/widget/ImageView$ScaleType:FIT_XY	Landroid/widget/ImageView$ScaleType;
    //   1147: invokevirtual 367	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1150: aload 22
    //   1152: ifnull +115 -> 1267
    //   1155: aload_1
    //   1156: ifnull +111 -> 1267
    //   1159: aload 22
    //   1161: aload_1
    //   1162: invokevirtual 302	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1165: aload_0
    //   1166: invokevirtual 155	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1169: invokevirtual 323	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1172: getfield 329	android/util/DisplayMetrics:widthPixels	I
    //   1175: istore_3
    //   1176: aload_1
    //   1177: invokevirtual 341	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   1180: i2f
    //   1181: aload_1
    //   1182: invokevirtual 338	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   1185: i2f
    //   1186: fdiv
    //   1187: fstore_2
    //   1188: ldc_w 368
    //   1191: iload_3
    //   1192: i2f
    //   1193: fmul
    //   1194: f2i
    //   1195: istore 4
    //   1197: iload 4
    //   1199: i2f
    //   1200: fload_2
    //   1201: fdiv
    //   1202: f2i
    //   1203: istore 5
    //   1205: aload 22
    //   1207: invokevirtual 345	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1210: checkcast 370	android/view/ViewGroup$MarginLayoutParams
    //   1213: astore_0
    //   1214: aload_0
    //   1215: iload 4
    //   1217: putfield 371	android/view/ViewGroup$MarginLayoutParams:width	I
    //   1220: aload_0
    //   1221: iload 5
    //   1223: putfield 372	android/view/ViewGroup$MarginLayoutParams:height	I
    //   1226: aload_0
    //   1227: iload_3
    //   1228: iload 4
    //   1230: isub
    //   1231: iconst_2
    //   1232: idiv
    //   1233: putfield 375	android/view/ViewGroup$MarginLayoutParams:leftMargin	I
    //   1236: aload_0
    //   1237: ldc_w 376
    //   1240: iload 5
    //   1242: i2f
    //   1243: fmul
    //   1244: f2i
    //   1245: putfield 379	android/view/ViewGroup$MarginLayoutParams:bottomMargin	I
    //   1248: aload_0
    //   1249: getfield 375	android/view/ViewGroup$MarginLayoutParams:leftMargin	I
    //   1252: ifle +102 -> 1354
    //   1255: aload 22
    //   1257: aload_0
    //   1258: invokevirtual 357	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1261: aload 22
    //   1263: iconst_0
    //   1264: invokevirtual 382	android/widget/ImageView:setVisibility	(I)V
    //   1267: lconst_0
    //   1268: lreturn
    //   1269: astore 19
    //   1271: aload 18
    //   1273: astore_1
    //   1274: aload 19
    //   1276: astore 18
    //   1278: ldc 114
    //   1280: iconst_1
    //   1281: ldc 123
    //   1283: aload 18
    //   1285: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1288: goto -360 -> 928
    //   1291: astore 18
    //   1293: aconst_null
    //   1294: astore_1
    //   1295: ldc 114
    //   1297: iconst_1
    //   1298: ldc 123
    //   1300: aload 18
    //   1302: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1305: aconst_null
    //   1306: astore 18
    //   1308: goto -317 -> 991
    //   1311: astore 18
    //   1313: ldc 114
    //   1315: iconst_1
    //   1316: ldc 123
    //   1318: aload 18
    //   1320: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1323: goto -289 -> 1034
    //   1326: iload 5
    //   1328: iload 4
    //   1330: if_icmple -180 -> 1150
    //   1333: aload 23
    //   1335: getstatic 385	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   1338: invokevirtual 367	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1341: goto -191 -> 1150
    //   1344: astore 18
    //   1346: aload 18
    //   1348: invokevirtual 268	java/lang/Throwable:printStackTrace	()V
    //   1351: goto -201 -> 1150
    //   1354: aload 22
    //   1356: bipush 8
    //   1358: invokevirtual 382	android/widget/ImageView:setVisibility	(I)V
    //   1361: goto -94 -> 1267
    //   1364: astore_0
    //   1365: aload 22
    //   1367: bipush 8
    //   1369: invokevirtual 382	android/widget/ImageView:setVisibility	(I)V
    //   1372: ldc 114
    //   1374: iconst_1
    //   1375: ldc_w 387
    //   1378: aload_0
    //   1379: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1382: goto -115 -> 1267
    //   1385: astore 18
    //   1387: aload 19
    //   1389: astore_1
    //   1390: goto -112 -> 1278
    //   1393: astore 19
    //   1395: goto -638 -> 757
    //   1398: aconst_null
    //   1399: astore_1
    //   1400: goto -409 -> 991
    //   1403: aload 19
    //   1405: astore 18
    //   1407: goto -466 -> 941
    //   1410: aload 18
    //   1412: astore 19
    //   1414: goto -1158 -> 256
    //   1417: aconst_null
    //   1418: astore 19
    //   1420: goto -1164 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1423	0	paramActivity	android.app.Activity
    //   0	1423	1	paramStartupDirector	StartupDirector
    //   1187	14	2	f	float
    //   419	812	3	i	int
    //   416	915	4	j	int
    //   552	779	5	k	int
    //   513	285	6	l1	long
    //   517	269	8	l2	long
    //   362	343	10	l3	long
    //   365	336	12	l4	long
    //   442	257	14	l5	long
    //   446	257	16	l6	long
    //   42	1242	18	localObject1	Object
    //   1291	10	18	localThrowable1	Throwable
    //   1306	1	18	localObject2	Object
    //   1311	8	18	localThrowable2	Throwable
    //   1344	3	18	localThrowable3	Throwable
    //   1385	1	18	localThrowable4	Throwable
    //   1405	6	18	localObject3	Object
    //   48	649	19	localObject4	Object
    //   752	102	19	localThrowable5	Throwable
    //   862	68	19	localObject5	Object
    //   1269	119	19	localThrowable6	Throwable
    //   1393	11	19	localThrowable7	Throwable
    //   1412	7	19	localObject6	Object
    //   60	688	20	localObject7	Object
    //   782	1	20	localException	Exception
    //   795	107	20	localThrowable8	Throwable
    //   368	480	21	localObject8	Object
    //   36	1330	22	localImageView1	android.widget.ImageView
    //   25	1309	23	localImageView2	android.widget.ImageView
    //   330	488	24	str1	String
    //   359	72	25	localObject9	Object
    //   434	231	26	localObject10	Object
    //   458	365	27	str2	String
    //   467	150	28	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   0	16	718	android/content/res/Resources$NotFoundException
    //   709	715	718	android/content/res/Resources$NotFoundException
    //   215	233	752	java/lang/Throwable
    //   545	581	782	java/lang/Exception
    //   893	914	1269	java/lang/Throwable
    //   946	991	1291	java/lang/Throwable
    //   1011	1018	1311	java/lang/Throwable
    //   1023	1034	1311	java/lang/Throwable
    //   1034	1041	1344	java/lang/Throwable
    //   1046	1070	1344	java/lang/Throwable
    //   1070	1135	1344	java/lang/Throwable
    //   1142	1150	1344	java/lang/Throwable
    //   1333	1341	1344	java/lang/Throwable
    //   1159	1188	1364	java/lang/Throwable
    //   1197	1267	1364	java/lang/Throwable
    //   1354	1361	1364	java/lang/Throwable
    //   918	925	1385	java/lang/Throwable
    //   237	244	1393	java/lang/Throwable
  }
  
  private static AnimationDrawable a(Context paramContext, StartupDirector paramStartupDirector)
  {
    for (;;)
    {
      int k;
      int m;
      int n;
      try
      {
        Object localObject1 = PreferenceManager.getDefaultSharedPreferences(paramContext);
        String str = ((SharedPreferences)localObject1).getString("dynamic_splash_config_md5", null);
        k = ((SharedPreferences)localObject1).getInt("dynamic_splash_config_play_times", -1);
        m = ((SharedPreferences)localObject1).getInt("dynamic_splash_config_play_internal", -1);
        if ((!TextUtils.isEmpty(str)) && (k > 0) && (m > 0))
        {
          localObject1 = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + "/dynamicSplash";
          str = (String)localObject1 + "/" + str;
          localObject1 = new File(str);
          if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
          {
            localObject1 = ((File)localObject1).listFiles();
            if (localObject1 == null) {
              return null;
            }
            n = localObject1.length - 1;
            if (n <= 0) {
              return null;
            }
            localObject1 = new AnimationDrawable();
            BitmapFactory.Options localOptions = new BitmapFactory.Options();
            localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
            j = 0;
            i = 1;
            if (i > n) {
              break label441;
            }
            Object localObject2 = new File(str + "/" + String.valueOf(i) + ".png");
            if ((!((File)localObject2).exists()) || (((File)localObject2).length() <= 0L)) {
              break label432;
            }
            localObject2 = BitmapManager.a(((File)localObject2).getAbsolutePath(), localOptions);
            if (localObject2 == null) {
              break label434;
            }
            j = 1;
            ((AnimationDrawable)localObject1).addFrame(new BitmapDrawable(paramContext.getResources(), (Bitmap)localObject2), m);
            break label434;
            if (QLog.isColorLevel()) {
              QLog.d("SetSplash", 2, "getDynamicSplashDrawable() playTimes=" + k + ", playInterval=" + m + ", totalFilesCount=" + n + ", totalPlayTime=" + i);
            }
            ThreadManager.post(new ahrm(), 5, null, false);
            if (paramStartupDirector != null) {
              paramStartupDirector.jdField_a_of_type_Long = i;
            }
            return localObject1;
          }
          return null;
        }
      }
      catch (Throwable paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SetSplash", 2, "", paramContext);
        }
        return null;
      }
      return null;
      label432:
      return null;
      label434:
      i += 1;
      continue;
      label441:
      if (j == 0) {
        return null;
      }
      int j = k * m * n;
      if (j <= 0) {
        return null;
      }
      int i = j;
      if (j > 5000) {
        i = 5000;
      }
    }
  }
  
  private static void a()
  {
    ThreadManager.getFileThreadHandler().postDelayed(new ahrl(), 5000L);
  }
  
  private static boolean a(Context paramContext)
  {
    try
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
      String str2 = localSharedPreferences.getString("dynamic_splash_config_effective_time", null);
      paramContext = localSharedPreferences.getString("dynamic_splash_config_md5", null);
      long l3 = localSharedPreferences.getLong("dynamic_splash_config_folder_modify_time", -1L);
      if (localSharedPreferences.getInt("dynamic_splash_config_show_times", -1) <= 0) {
        return false;
      }
      boolean bool = TextUtils.isEmpty(str2);
      if (!bool) {}
      int i;
      long l2;
      long l1;
      String str1;
      return false;
    }
    catch (Throwable paramContext)
    {
      try
      {
        i = str2.indexOf("|");
        l2 = Long.parseLong(str2.substring(0, i));
        l1 = Long.parseLong(str2.substring(i + 1));
        if (!CommonUtil.a(l2, l1))
        {
          if (!QLog.isColorLevel()) {
            break label307;
          }
          QLog.d("SetSplash", 2, "needShowDynamicSplash() the current time is not effective");
          return false;
          paramContext = paramContext;
          if (!QLog.isColorLevel()) {
            break label307;
          }
          QLog.d("SetSplash", 2, "needShowDynamicSplash() ERROR msg=" + paramContext.getMessage());
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          l1 = 0L;
          l2 = 0L;
        }
        if ((l3 >= 0L) && (!TextUtils.isEmpty(paramContext)))
        {
          str1 = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + "/dynamicSplash";
          paramContext = new File(str1 + "/" + paramContext);
          if ((paramContext.exists()) && (paramContext.isDirectory()) && (l3 == paramContext.lastModified()) && (DeviceInfoUtil.e() >= 805306368L)) {
            return true;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SetSplash", 2, "needShowDynamicSplash() the folder of splash is modified, NOT show");
          }
        }
      }
    }
  }
  
  public static boolean b()
  {
    long l1 = BaseApplicationImpl.getApplication().getSharedPreferences("banner_and_splash", 0).getLong("splashshowtime", 0L);
    long l2 = System.currentTimeMillis();
    if ((l2 > l1) && (l2 <= 86400000L + l1)) {
      return false;
    }
    if (l2 > l1 + 86400000L)
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
      Object localObject1 = localBaseApplicationImpl.getFilesDir();
      long l3;
      long l4;
      int j;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((File)localObject1).getAbsolutePath();
        localObject2 = new File((String)localObject1 + "/splashpic");
        l3 = 0L;
        l4 = 0L;
        if ((localObject2 != null) && (((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
        {
          localObject2 = ((File)localObject2).listFiles();
          if (localObject2 != null)
          {
            j = localObject2.length;
            i = 0;
          }
        }
      }
      else
      {
        for (;;)
        {
          long l5;
          long l6;
          for (;;)
          {
            if (i >= j) {
              break label339;
            }
            Object localObject3 = localObject2[i];
            l5 = l4;
            l6 = l3;
            if (localObject3 != null)
            {
              localObject3 = ((File)localObject3).getName().split("_");
              l5 = l4;
              l6 = l3;
              if (localObject3 != null)
              {
                l5 = l4;
                l6 = l3;
                if (localObject3.length == 3)
                {
                  localObject3 = localObject3[0];
                  l1 = l4;
                  l2 = l3;
                  if (localObject3 != null)
                  {
                    l1 = l4;
                    l2 = l3;
                    if (((String)localObject3).trim().equals("")) {}
                  }
                  try
                  {
                    int k = ((String)localObject3).indexOf("|");
                    l2 = Long.parseLong(((String)localObject3).substring(0, k));
                    l1 = Long.parseLong(((String)localObject3).substring(k + 1));
                    l5 = l1;
                    l6 = l2;
                    if (CommonUtil.a(l2, l1))
                    {
                      return true;
                      localObject1 = "/data/data/com.tencent.mobileqq/files";
                    }
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      l2 = 0L;
                      l1 = 0L;
                    }
                  }
                }
              }
            }
          }
          i += 1;
          l4 = l5;
          l3 = l6;
        }
      }
      label339:
      Object localObject2 = SharedPreUtils.b(BaseApplicationImpl.getContext());
      if (QLog.isColorLevel()) {
        QLog.i("SetSplash", 2, "bir = " + (String)localObject2);
      }
      if ((!((String)localObject2).equals("")) && (a((String)localObject2) == 0))
      {
        localObject1 = new File((String)localObject1 + "/" + SharedPreUtils.a(localBaseApplicationImpl) + "/" + "birthdayflashlogo.png");
        if ((localObject1 != null) && (((File)localObject1).exists()) && (((File)localObject1).length() > 1L)) {
          return true;
        }
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SetSplash", 2, "now time less than last show time");
    }
    return false;
  }
  
  protected boolean a()
  {
    AppActivity localAppActivity = this.a.jdField_a_of_type_MqqAppAppActivity;
    try
    {
      boolean bool = localAppActivity.showPreview();
      if (!bool) {
        break label35;
      }
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label35:
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("SetSplash", 2, "", localNotFoundException);
        }
      } while (a(localAppActivity, this.a) <= 0L);
      BaseApplicationImpl.sLaunchTime = 0L;
      BaseApplicationImpl.sShowTime = 0L;
      BaseApplicationImpl.appStartTime = 0L;
      this.a.b = 0L;
    }
    return true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash
 * JD-Core Version:    0.7.0.1
 */