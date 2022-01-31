package com.tencent.mobileqq.startup.step;

import aifo;
import aifp;
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
    //   4: ifeq +46 -> 50
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
    //   38: aload 23
    //   40: ifnull +8 -> 48
    //   43: aload 22
    //   45: ifnonnull +40 -> 85
    //   48: lconst_0
    //   49: lreturn
    //   50: aload_0
    //   51: ldc 77
    //   53: invokevirtual 94	android/app/Activity:setContentView	(I)V
    //   56: goto -40 -> 16
    //   59: astore_1
    //   60: aload_1
    //   61: invokestatic 100	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   64: astore_1
    //   65: ldc 102
    //   67: iconst_1
    //   68: aload_1
    //   69: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_0
    //   73: ldc 110
    //   75: aload_1
    //   76: invokestatic 116	com/tencent/mobileqq/app/InjectUtils:uploadInjectFailure	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_0
    //   80: invokevirtual 119	android/app/Activity:finish	()V
    //   83: lconst_0
    //   84: lreturn
    //   85: aload_0
    //   86: invokestatic 125	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;)Ljava/lang/String;
    //   89: astore 18
    //   91: aload_0
    //   92: invokevirtual 129	android/app/Activity:getFilesDir	()Ljava/io/File;
    //   95: astore 19
    //   97: aload 19
    //   99: ifnull +658 -> 757
    //   102: aload 19
    //   104: invokevirtual 134	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   107: astore 20
    //   109: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +29 -> 141
    //   115: ldc 140
    //   117: iconst_2
    //   118: new 25	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   125: aload 18
    //   127: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload 19
    //   132: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 146	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload 19
    //   143: ifnull +1287 -> 1430
    //   146: aload 18
    //   148: ldc 148
    //   150: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   153: ifne +1277 -> 1430
    //   156: aload 18
    //   158: invokestatic 156	com/tencent/mobileqq/startup/step/SetSplash:a	(Ljava/lang/String;)I
    //   161: ifne +1269 -> 1430
    //   164: new 25	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   171: aload 20
    //   173: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc 158
    //   178: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_0
    //   182: invokestatic 160	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   185: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: ldc 158
    //   190: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc 162
    //   195: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: astore 18
    //   203: new 131	java/io/File
    //   206: dup
    //   207: aload 18
    //   209: invokespecial 163	java/io/File:<init>	(Ljava/lang/String;)V
    //   212: astore 19
    //   214: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   217: ifeq +37 -> 254
    //   220: ldc 140
    //   222: iconst_2
    //   223: new 25	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   230: aload 18
    //   232: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc 165
    //   237: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 19
    //   242: invokevirtual 168	java/io/File:exists	()Z
    //   245: invokevirtual 171	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   248: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: aload 19
    //   256: invokevirtual 168	java/io/File:exists	()Z
    //   259: ifeq +1171 -> 1430
    //   262: new 173	android/graphics/drawable/BitmapDrawable
    //   265: dup
    //   266: aload_0
    //   267: invokevirtual 177	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   270: aload 18
    //   272: invokestatic 182	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   275: invokespecial 185	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   278: astore 18
    //   280: aload_1
    //   281: ifnull +10 -> 291
    //   284: aload_1
    //   285: ldc2_w 186
    //   288: putfield 192	com/tencent/mobileqq/startup/director/StartupDirector:jdField_a_of_type_Long	J
    //   291: aload 18
    //   293: ifnull +1130 -> 1423
    //   296: invokestatic 194	com/tencent/mobileqq/startup/step/SetSplash:a	()V
    //   299: aload 18
    //   301: astore 19
    //   303: aload 19
    //   305: astore 18
    //   307: aload 19
    //   309: ifnonnull +25 -> 334
    //   312: aload 19
    //   314: astore 18
    //   316: invokestatic 200	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   319: invokestatic 203	com/tencent/mobileqq/startup/step/SetSplash:a	(Landroid/content/Context;)Z
    //   322: ifeq +12 -> 334
    //   325: invokestatic 200	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   328: aload_1
    //   329: invokestatic 206	com/tencent/mobileqq/startup/step/SetSplash:a	(Landroid/content/Context;Lcom/tencent/mobileqq/startup/director/StartupDirector;)Landroid/graphics/drawable/AnimationDrawable;
    //   332: astore 18
    //   334: aload 18
    //   336: astore 19
    //   338: aload 18
    //   340: ifnonnull +1076 -> 1416
    //   343: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   346: ifeq +11 -> 357
    //   349: ldc 208
    //   351: iconst_2
    //   352: ldc 210
    //   354: invokestatic 146	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: new 25	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   364: aload 20
    //   366: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: ldc 212
    //   371: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: astore 24
    //   379: new 131	java/io/File
    //   382: dup
    //   383: new 25	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   390: aload 20
    //   392: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: ldc 214
    //   397: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokespecial 163	java/io/File:<init>	(Ljava/lang/String;)V
    //   406: astore 25
    //   408: lconst_0
    //   409: lstore 10
    //   411: lconst_0
    //   412: lstore 12
    //   414: aconst_null
    //   415: astore 21
    //   417: aconst_null
    //   418: astore 19
    //   420: aload 21
    //   422: astore 20
    //   424: aload 25
    //   426: ifnull +447 -> 873
    //   429: aload 21
    //   431: astore 20
    //   433: aload 25
    //   435: invokevirtual 168	java/io/File:exists	()Z
    //   438: ifeq +435 -> 873
    //   441: aload 21
    //   443: astore 20
    //   445: aload 25
    //   447: invokevirtual 217	java/io/File:isDirectory	()Z
    //   450: ifeq +423 -> 873
    //   453: aload 25
    //   455: invokevirtual 221	java/io/File:listFiles	()[Ljava/io/File;
    //   458: astore 25
    //   460: aload 25
    //   462: arraylength
    //   463: istore 4
    //   465: iconst_0
    //   466: istore_3
    //   467: aload 19
    //   469: astore 20
    //   471: iload_3
    //   472: iload 4
    //   474: if_icmpge +399 -> 873
    //   477: aload 25
    //   479: iload_3
    //   480: aaload
    //   481: astore 26
    //   483: aload 19
    //   485: astore 21
    //   487: lload 12
    //   489: lstore 14
    //   491: lload 10
    //   493: lstore 16
    //   495: aload 26
    //   497: ifnull +241 -> 738
    //   500: aload 26
    //   502: invokevirtual 224	java/io/File:getName	()Ljava/lang/String;
    //   505: astore 27
    //   507: aload 27
    //   509: ldc 226
    //   511: invokevirtual 230	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   514: astore 28
    //   516: aload 19
    //   518: astore 21
    //   520: lload 12
    //   522: lstore 14
    //   524: lload 10
    //   526: lstore 16
    //   528: aload 28
    //   530: ifnull +208 -> 738
    //   533: aload 19
    //   535: astore 21
    //   537: lload 12
    //   539: lstore 14
    //   541: lload 10
    //   543: lstore 16
    //   545: aload 28
    //   547: arraylength
    //   548: iconst_3
    //   549: if_icmpne +189 -> 738
    //   552: aload 28
    //   554: iconst_0
    //   555: aaload
    //   556: astore 20
    //   558: lload 12
    //   560: lstore 6
    //   562: lload 10
    //   564: lstore 8
    //   566: aload 20
    //   568: ifnull +60 -> 628
    //   571: lload 12
    //   573: lstore 6
    //   575: lload 10
    //   577: lstore 8
    //   579: aload 20
    //   581: invokevirtual 233	java/lang/String:trim	()Ljava/lang/String;
    //   584: ldc 148
    //   586: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   589: ifne +39 -> 628
    //   592: aload 20
    //   594: ldc 235
    //   596: invokevirtual 238	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   599: istore 5
    //   601: aload 20
    //   603: iconst_0
    //   604: iload 5
    //   606: invokevirtual 242	java/lang/String:substring	(II)Ljava/lang/String;
    //   609: invokestatic 248	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   612: lstore 8
    //   614: aload 20
    //   616: iload 5
    //   618: iconst_1
    //   619: iadd
    //   620: invokevirtual 251	java/lang/String:substring	(I)Ljava/lang/String;
    //   623: invokestatic 248	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   626: lstore 6
    //   628: lload 8
    //   630: lload 6
    //   632: invokestatic 256	com/tencent/mobileqq/util/CommonUtil:a	(JJ)Z
    //   635: ifeq +171 -> 806
    //   638: aload 19
    //   640: astore 20
    //   642: aload 19
    //   644: ifnonnull +34 -> 678
    //   647: new 131	java/io/File
    //   650: dup
    //   651: new 25	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   658: aload 24
    //   660: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: aload 28
    //   665: iconst_1
    //   666: aaload
    //   667: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokespecial 163	java/io/File:<init>	(Ljava/lang/String;)V
    //   676: astore 20
    //   678: aload 20
    //   680: astore 21
    //   682: lload 6
    //   684: lstore 14
    //   686: lload 8
    //   688: lstore 16
    //   690: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   693: ifeq +45 -> 738
    //   696: ldc 208
    //   698: iconst_2
    //   699: new 25	java/lang/StringBuilder
    //   702: dup
    //   703: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   706: ldc_w 258
    //   709: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: aload 26
    //   714: invokevirtual 134	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   717: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   723: invokestatic 146	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   726: lload 8
    //   728: lstore 16
    //   730: lload 6
    //   732: lstore 14
    //   734: aload 20
    //   736: astore 21
    //   738: iload_3
    //   739: iconst_1
    //   740: iadd
    //   741: istore_3
    //   742: aload 21
    //   744: astore 19
    //   746: lload 14
    //   748: lstore 12
    //   750: lload 16
    //   752: lstore 10
    //   754: goto -287 -> 467
    //   757: ldc_w 260
    //   760: astore 20
    //   762: goto -653 -> 109
    //   765: astore 19
    //   767: aconst_null
    //   768: astore 18
    //   770: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   773: ifeq +14 -> 787
    //   776: ldc 140
    //   778: iconst_2
    //   779: ldc_w 262
    //   782: aload 19
    //   784: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   787: aload 19
    //   789: invokevirtual 268	java/lang/Throwable:printStackTrace	()V
    //   792: goto -501 -> 291
    //   795: astore 20
    //   797: lconst_0
    //   798: lstore 8
    //   800: lconst_0
    //   801: lstore 6
    //   803: goto -175 -> 628
    //   806: aload 19
    //   808: astore 20
    //   810: lload 6
    //   812: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   815: lcmp
    //   816: ifge -138 -> 678
    //   819: new 131	java/io/File
    //   822: dup
    //   823: new 25	java/lang/StringBuilder
    //   826: dup
    //   827: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   830: aload 24
    //   832: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: aload 27
    //   837: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokespecial 163	java/io/File:<init>	(Ljava/lang/String;)V
    //   846: astore 21
    //   848: aload 19
    //   850: astore 20
    //   852: aload 21
    //   854: invokevirtual 168	java/io/File:exists	()Z
    //   857: ifeq -179 -> 678
    //   860: aload 21
    //   862: invokevirtual 276	java/io/File:delete	()Z
    //   865: pop
    //   866: aload 19
    //   868: astore 20
    //   870: goto -192 -> 678
    //   873: aload 18
    //   875: astore 19
    //   877: aload 20
    //   879: ifnull +537 -> 1416
    //   882: aload 18
    //   884: astore 19
    //   886: aload 20
    //   888: invokevirtual 168	java/io/File:exists	()Z
    //   891: ifeq +525 -> 1416
    //   894: aload 18
    //   896: astore 19
    //   898: aload 20
    //   900: invokevirtual 279	java/io/File:isFile	()Z
    //   903: ifeq +513 -> 1416
    //   906: new 173	android/graphics/drawable/BitmapDrawable
    //   909: dup
    //   910: aload_0
    //   911: invokevirtual 177	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   914: aload 20
    //   916: invokevirtual 134	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   919: invokestatic 182	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   922: invokespecial 185	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   925: astore 19
    //   927: aload_1
    //   928: ifnull +10 -> 938
    //   931: aload_1
    //   932: ldc2_w 280
    //   935: putfield 192	com/tencent/mobileqq/startup/director/StartupDirector:jdField_a_of_type_Long	J
    //   938: aload 19
    //   940: astore_1
    //   941: aload_1
    //   942: astore 19
    //   944: aload_1
    //   945: ifnull +471 -> 1416
    //   948: invokestatic 194	com/tencent/mobileqq/startup/step/SetSplash:a	()V
    //   951: aload_1
    //   952: astore 18
    //   954: aload 18
    //   956: ifnonnull +455 -> 1411
    //   959: new 173	android/graphics/drawable/BitmapDrawable
    //   962: dup
    //   963: aload_0
    //   964: invokevirtual 177	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   967: aload_0
    //   968: invokevirtual 285	android/app/Activity:getAssets	()Landroid/content/res/AssetManager;
    //   971: ldc_w 287
    //   974: invokevirtual 293	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   977: invokespecial 296	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Ljava/io/InputStream;)V
    //   980: astore 18
    //   982: new 173	android/graphics/drawable/BitmapDrawable
    //   985: dup
    //   986: aload_0
    //   987: invokevirtual 177	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   990: aload_0
    //   991: invokevirtual 285	android/app/Activity:getAssets	()Landroid/content/res/AssetManager;
    //   994: ldc_w 298
    //   997: invokevirtual 293	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1000: invokespecial 296	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Ljava/io/InputStream;)V
    //   1003: astore_1
    //   1004: aload 18
    //   1006: ifnull +41 -> 1047
    //   1009: aload 23
    //   1011: aload 18
    //   1013: invokevirtual 302	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1016: aload 18
    //   1018: instanceof 304
    //   1021: ifeq +26 -> 1047
    //   1024: aload 18
    //   1026: checkcast 304	android/graphics/drawable/AnimationDrawable
    //   1029: astore 18
    //   1031: aload 18
    //   1033: ifnull +14 -> 1047
    //   1036: aload 18
    //   1038: iconst_0
    //   1039: invokevirtual 308	android/graphics/drawable/AnimationDrawable:setOneShot	(Z)V
    //   1042: aload 18
    //   1044: invokevirtual 311	android/graphics/drawable/AnimationDrawable:start	()V
    //   1047: aload 23
    //   1049: invokevirtual 315	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   1052: astore 18
    //   1054: aload 18
    //   1056: ifnull +107 -> 1163
    //   1059: aload 18
    //   1061: instanceof 173
    //   1064: ifne +19 -> 1083
    //   1067: aload 18
    //   1069: instanceof 317
    //   1072: ifne +11 -> 1083
    //   1075: aload 18
    //   1077: instanceof 304
    //   1080: ifeq +83 -> 1163
    //   1083: aload_0
    //   1084: invokevirtual 177	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1087: invokevirtual 323	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1090: getfield 329	android/util/DisplayMetrics:widthPixels	I
    //   1093: istore_3
    //   1094: aload_0
    //   1095: invokevirtual 177	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1098: invokevirtual 323	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1101: getfield 332	android/util/DisplayMetrics:heightPixels	I
    //   1104: istore 4
    //   1106: aload 18
    //   1108: invokevirtual 338	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   1111: iload_3
    //   1112: imul
    //   1113: aload 18
    //   1115: invokevirtual 341	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   1118: idiv
    //   1119: istore 5
    //   1121: aload 23
    //   1123: invokevirtual 345	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1126: astore 18
    //   1128: aload 18
    //   1130: iload_3
    //   1131: putfield 350	android/view/ViewGroup$LayoutParams:width	I
    //   1134: aload 18
    //   1136: iload 5
    //   1138: putfield 353	android/view/ViewGroup$LayoutParams:height	I
    //   1141: aload 23
    //   1143: aload 18
    //   1145: invokevirtual 357	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1148: iload 5
    //   1150: iload 4
    //   1152: if_icmpgt +187 -> 1339
    //   1155: aload 23
    //   1157: getstatic 363	android/widget/ImageView$ScaleType:FIT_XY	Landroid/widget/ImageView$ScaleType;
    //   1160: invokevirtual 367	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1163: aload 22
    //   1165: ifnull +115 -> 1280
    //   1168: aload_1
    //   1169: ifnull +111 -> 1280
    //   1172: aload 22
    //   1174: aload_1
    //   1175: invokevirtual 302	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1178: aload_0
    //   1179: invokevirtual 177	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1182: invokevirtual 323	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1185: getfield 329	android/util/DisplayMetrics:widthPixels	I
    //   1188: istore_3
    //   1189: aload_1
    //   1190: invokevirtual 341	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   1193: i2f
    //   1194: aload_1
    //   1195: invokevirtual 338	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   1198: i2f
    //   1199: fdiv
    //   1200: fstore_2
    //   1201: ldc_w 368
    //   1204: iload_3
    //   1205: i2f
    //   1206: fmul
    //   1207: f2i
    //   1208: istore 4
    //   1210: iload 4
    //   1212: i2f
    //   1213: fload_2
    //   1214: fdiv
    //   1215: f2i
    //   1216: istore 5
    //   1218: aload 22
    //   1220: invokevirtual 345	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1223: checkcast 370	android/view/ViewGroup$MarginLayoutParams
    //   1226: astore_0
    //   1227: aload_0
    //   1228: iload 4
    //   1230: putfield 371	android/view/ViewGroup$MarginLayoutParams:width	I
    //   1233: aload_0
    //   1234: iload 5
    //   1236: putfield 372	android/view/ViewGroup$MarginLayoutParams:height	I
    //   1239: aload_0
    //   1240: iload_3
    //   1241: iload 4
    //   1243: isub
    //   1244: iconst_2
    //   1245: idiv
    //   1246: putfield 375	android/view/ViewGroup$MarginLayoutParams:leftMargin	I
    //   1249: aload_0
    //   1250: ldc_w 376
    //   1253: iload 5
    //   1255: i2f
    //   1256: fmul
    //   1257: f2i
    //   1258: putfield 379	android/view/ViewGroup$MarginLayoutParams:bottomMargin	I
    //   1261: aload_0
    //   1262: getfield 375	android/view/ViewGroup$MarginLayoutParams:leftMargin	I
    //   1265: ifle +102 -> 1367
    //   1268: aload 22
    //   1270: aload_0
    //   1271: invokevirtual 357	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1274: aload 22
    //   1276: iconst_0
    //   1277: invokevirtual 382	android/widget/ImageView:setVisibility	(I)V
    //   1280: lconst_0
    //   1281: lreturn
    //   1282: astore 19
    //   1284: aload 18
    //   1286: astore_1
    //   1287: aload 19
    //   1289: astore 18
    //   1291: ldc 140
    //   1293: iconst_1
    //   1294: ldc 148
    //   1296: aload 18
    //   1298: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1301: goto -360 -> 941
    //   1304: astore 18
    //   1306: aconst_null
    //   1307: astore_1
    //   1308: ldc 140
    //   1310: iconst_1
    //   1311: ldc 148
    //   1313: aload 18
    //   1315: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1318: aconst_null
    //   1319: astore 18
    //   1321: goto -317 -> 1004
    //   1324: astore 18
    //   1326: ldc 140
    //   1328: iconst_1
    //   1329: ldc 148
    //   1331: aload 18
    //   1333: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1336: goto -289 -> 1047
    //   1339: iload 5
    //   1341: iload 4
    //   1343: if_icmple -180 -> 1163
    //   1346: aload 23
    //   1348: getstatic 385	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   1351: invokevirtual 367	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1354: goto -191 -> 1163
    //   1357: astore 18
    //   1359: aload 18
    //   1361: invokevirtual 268	java/lang/Throwable:printStackTrace	()V
    //   1364: goto -201 -> 1163
    //   1367: aload 22
    //   1369: bipush 8
    //   1371: invokevirtual 382	android/widget/ImageView:setVisibility	(I)V
    //   1374: goto -94 -> 1280
    //   1377: astore_0
    //   1378: aload 22
    //   1380: bipush 8
    //   1382: invokevirtual 382	android/widget/ImageView:setVisibility	(I)V
    //   1385: ldc 140
    //   1387: iconst_1
    //   1388: ldc_w 387
    //   1391: aload_0
    //   1392: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1395: goto -115 -> 1280
    //   1398: astore 18
    //   1400: aload 19
    //   1402: astore_1
    //   1403: goto -112 -> 1291
    //   1406: astore 19
    //   1408: goto -638 -> 770
    //   1411: aconst_null
    //   1412: astore_1
    //   1413: goto -409 -> 1004
    //   1416: aload 19
    //   1418: astore 18
    //   1420: goto -466 -> 954
    //   1423: aload 18
    //   1425: astore 19
    //   1427: goto -1124 -> 303
    //   1430: aconst_null
    //   1431: astore 19
    //   1433: goto -1130 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1436	0	paramActivity	android.app.Activity
    //   0	1436	1	paramStartupDirector	StartupDirector
    //   1200	14	2	f	float
    //   466	778	3	i	int
    //   463	881	4	j	int
    //   599	745	5	k	int
    //   560	251	6	l1	long
    //   564	235	8	l2	long
    //   409	344	10	l3	long
    //   412	337	12	l4	long
    //   489	258	14	l5	long
    //   493	258	16	l6	long
    //   89	1208	18	localObject1	Object
    //   1304	10	18	localThrowable1	Throwable
    //   1319	1	18	localObject2	Object
    //   1324	8	18	localThrowable2	Throwable
    //   1357	3	18	localThrowable3	Throwable
    //   1398	1	18	localThrowable4	Throwable
    //   1418	6	18	localObject3	Object
    //   95	650	19	localObject4	Object
    //   765	102	19	localThrowable5	Throwable
    //   875	68	19	localObject5	Object
    //   1282	119	19	localThrowable6	Throwable
    //   1406	11	19	localThrowable7	Throwable
    //   1425	7	19	localObject6	Object
    //   107	654	20	localObject7	Object
    //   795	1	20	localException	Exception
    //   808	107	20	localThrowable8	Throwable
    //   415	446	21	localObject8	Object
    //   36	1343	22	localImageView1	android.widget.ImageView
    //   25	1322	23	localImageView2	android.widget.ImageView
    //   377	454	24	str1	String
    //   406	72	25	localObject9	Object
    //   481	232	26	localObject10	Object
    //   505	331	27	str2	String
    //   514	150	28	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   0	16	59	android/content/res/Resources$NotFoundException
    //   50	56	59	android/content/res/Resources$NotFoundException
    //   262	280	765	java/lang/Throwable
    //   592	628	795	java/lang/Exception
    //   906	927	1282	java/lang/Throwable
    //   959	1004	1304	java/lang/Throwable
    //   1024	1031	1324	java/lang/Throwable
    //   1036	1047	1324	java/lang/Throwable
    //   1047	1054	1357	java/lang/Throwable
    //   1059	1083	1357	java/lang/Throwable
    //   1083	1148	1357	java/lang/Throwable
    //   1155	1163	1357	java/lang/Throwable
    //   1346	1354	1357	java/lang/Throwable
    //   1172	1201	1377	java/lang/Throwable
    //   1210	1280	1377	java/lang/Throwable
    //   1367	1374	1377	java/lang/Throwable
    //   931	938	1398	java/lang/Throwable
    //   284	291	1406	java/lang/Throwable
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
            ThreadManager.post(new aifp(), 5, null, false);
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
    ThreadManager.getFileThreadHandler().postDelayed(new aifo(), 5000L);
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