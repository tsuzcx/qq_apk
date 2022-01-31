import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.VasShieldFont.1;
import com.etrump.mixlayout.VasShieldFont.2;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class gh
{
  public static int a;
  public static Typeface a;
  public static final String a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static boolean jdField_a_of_type_Boolean;
  public static int b;
  private static Typeface jdField_b_of_type_AndroidGraphicsTypeface;
  public static String b;
  private static AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public static int c;
  private static String jdField_c_of_type_JavaLangString;
  private static AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "default_font" + File.separator;
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_JavaLangString = "";
    jdField_b_of_type_Int = -1;
    jdField_c_of_type_Int = -1;
    d = -1;
    jdField_a_of_type_Boolean = true;
  }
  
  public static int a()
  {
    if (d < 0) {
      d = BaseApplicationImpl.getApplication().getRuntime().getPreferences().getInt("keySysFontSetting", 0);
    }
    return d;
  }
  
  public static Typeface a()
  {
    if ((jdField_c_of_type_Int != 0) || (d > 0) || (jdField_b_of_type_Int < 1)) {
      return jdField_a_of_type_AndroidGraphicsTypeface;
    }
    return jdField_b_of_type_AndroidGraphicsTypeface;
  }
  
  public static Typeface a(MessageRecord paramMessageRecord)
  {
    if ((jdField_b_of_type_Int < 1) || (paramMessageRecord == null)) {
      return null;
    }
    if ((paramMessageRecord.isSend()) && (d > 0)) {
      return jdField_a_of_type_AndroidGraphicsTypeface;
    }
    return jdField_b_of_type_AndroidGraphicsTypeface;
  }
  
  public static Typeface a(String paramString)
  {
    if (jdField_b_of_type_Int < 1) {
      return null;
    }
    return jdField_b_of_type_AndroidGraphicsTypeface;
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(jdField_c_of_type_JavaLangString)) {
      jdField_c_of_type_JavaLangString = bajo.a() + jdField_a_of_type_JavaLangString + "default.ttf";
    }
    return jdField_c_of_type_JavaLangString;
  }
  
  public static void a()
  {
    jdField_b_of_type_AndroidGraphicsTypeface = null;
    jdField_b_of_type_JavaLangString = "";
    jdField_a_of_type_Int = -1;
    d = -1;
    jdField_c_of_type_Int = -1;
    int i = a();
    jdField_a_of_type_Boolean = BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean("keySysFontGrayTip", true);
    if (QLog.isColorLevel()) {
      QLog.d("VasShieldFont", 2, "resetData: sysFontSetting=" + i + " showGrayTip=" + jdField_a_of_type_Boolean);
    }
  }
  
  public static void a(TextView paramTextView)
  {
    int m = 1;
    if (jdField_b_of_type_Int < 0) {}
    for (;;)
    {
      int i;
      try
      {
        paramTextView.setDrawingCacheEnabled(true);
        Bitmap localBitmap = paramTextView.getDrawingCache();
        jdField_a_of_type_AndroidGraphicsTypeface = paramTextView.getTypeface();
        int n = paramTextView.getCurrentTextColor();
        if (localBitmap == null) {
          break label234;
        }
        if (localBitmap.isRecycled())
        {
          break label234;
          jdField_b_of_type_Int = i;
          if (QLog.isColorLevel()) {
            QLog.d("VasShieldFont", 2, "checkColorFont: sSysColorFont=" + jdField_b_of_type_Int);
          }
          paramTextView.setDrawingCacheEnabled(false);
          if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
            break;
          }
          ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getHandler(Conversation.class).sendEmptyMessage(1060);
          return;
        }
        i = localBitmap.getWidth();
        int j = localBitmap.getHeight();
        int[] arrayOfInt = new int[i * j];
        localBitmap.getPixels(arrayOfInt, 0, i, 0, 0, i, j);
        j = 0;
        i = 0;
        k = i;
        if (j >= arrayOfInt.length) {
          break label236;
        }
        k = arrayOfInt[j];
        int i1 = k & 0xFFFFFF;
        k = i;
        if (i1 != 0)
        {
          k = i;
          if (i1 != (n & 0xFFFFFF)) {
            k = 1;
          }
        }
        j += 1;
        i = k;
        continue;
        i = 0;
        continue;
        paramTextView.setVisibility(8);
      }
      catch (Exception paramTextView)
      {
        QLog.e("VasShieldFont", 2, "checkSysColorFont: ", paramTextView);
        return;
      }
      return;
      label234:
      int k = 0;
      label236:
      if (k != 0) {
        i = m;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    String str;
    if (paramInt == 0)
    {
      str = fv.jdField_a_of_type_JavaLangString + File.separator + "default.zip";
      if (!apdh.a(str)) {}
    }
    try
    {
      bace.a(str, bajo.a() + jdField_a_of_type_JavaLangString, false);
      a(paramQQAppInterface);
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.e("VasShieldFont", 2, "uncompress zip failed", localIOException);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MqqHandler paramMqqHandler, SessionInfo paramSessionInfo)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return;
        if (jdField_b_of_type_Int >= 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VasShieldFont", 2, "loadDefaultFont: user not uses color font.");
      return;
      if (jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        ThreadManager.excute(new VasShieldFont.1(paramQQAppInterface, paramMqqHandler), 64, null, true);
      }
    } while ((paramMqqHandler == null) || (paramSessionInfo == null) || (!jdField_a_of_type_Boolean) || (jdField_b_of_type_Int <= 0) || (jdField_a_of_type_Int <= 1) || (jdField_c_of_type_Int != 0));
    if (QLog.isColorLevel()) {
      QLog.d("VasShieldFont", 2, "loadDefaultFont: ShowGrayTip: sSysColorFont=" + jdField_b_of_type_Int + " sDefaultFontType=" + jdField_a_of_type_Int);
    }
    paramMqqHandler.removeMessages(87);
    paramMqqHandler.sendEmptyMessage(87);
    ThreadManager.getTimer().schedule(new VasShieldFont.2(paramQQAppInterface, paramSessionInfo), 2000L);
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt > -1)
    {
      d = paramInt;
      b();
      return BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt("keySysFontSetting", paramInt).commit();
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    if (jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return false;
    }
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (!ETEngine.getInstance().isEngineInited.get())
    {
      paramQQAppInterface = (fv)paramQQAppInterface.getManager(42);
      if (paramQQAppInterface != null)
      {
        QLog.d("VasShieldFont", 2, "initHYEngine: ");
        paramQQAppInterface.d();
      }
    }
    if (ETEngine.getInstance().isEngineReady.get()) {
      ETEngine.getInstance().native_loadFont(a(), 9999, true);
    }
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    return true;
  }
  
  public static int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasShieldFont", 2, "hasSysColorFont: defaultFontType=" + jdField_a_of_type_Int + " sysColorFont=" + jdField_b_of_type_Int + " sUserFontId=" + jdField_c_of_type_Int);
    }
    if ((jdField_a_of_type_Int > 1) && (jdField_c_of_type_Int == 0)) {
      return jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public static void b()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      bajo.a((AppInterface)localObject);
      localObject = ((QQAppInterface)localObject).getHandler(ChatActivity.class);
      if (localObject != null)
      {
        ((MqqHandler)localObject).removeMessages(87);
        ((MqqHandler)localObject).sendEmptyMessage(87);
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      return;
    }
    QLog.d("VasShieldFont", 2, "refreshAIO: " + BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject = ajjy.a(2131650259);
    int i = ((String)localObject).length();
    paramString = new aqax(paramString, jdField_b_of_type_JavaLangString, (String)localObject, paramInt, -5020, 1179653, awao.a());
    paramString.b = new int[] { 1179653 };
    localObject = new Bundle();
    ((Bundle)localObject).putInt("key_action", 1);
    ((Bundle)localObject).putString("key_action_DATA", bant.a("myFont"));
    paramString.a(i - 7, i - 3, (Bundle)localObject);
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramString);
    aqay.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
  }
  
  private static void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    while (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (QLog.isColorLevel()) {
      QLog.d("VasShieldFont", 2, "downloadDefaultFont");
    }
    ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).downloadItem(1004L, "defaultFont_775", "defaultFont");
  }
  
  /* Error */
  private static boolean c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore 9
    //   14: new 17	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   21: invokestatic 113	bajo:a	()Ljava/lang/String;
    //   24: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: getstatic 37	gh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   30: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 10
    //   38: new 28	java/io/File
    //   41: dup
    //   42: new 17	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   49: aload 10
    //   51: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc_w 420
    //   57: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokespecial 423	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: astore 12
    //   68: new 28	java/io/File
    //   71: dup
    //   72: invokestatic 319	gh:a	()Ljava/lang/String;
    //   75: invokespecial 423	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore 11
    //   80: ldc 41
    //   82: astore_3
    //   83: aload 12
    //   85: invokevirtual 426	java/io/File:exists	()Z
    //   88: ifeq +616 -> 704
    //   91: aload 12
    //   93: invokevirtual 429	java/io/File:isFile	()Z
    //   96: ifeq +608 -> 704
    //   99: new 431	java/io/InputStreamReader
    //   102: dup
    //   103: new 433	java/io/FileInputStream
    //   106: dup
    //   107: aload 12
    //   109: invokespecial 436	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   112: ldc_w 438
    //   115: invokespecial 441	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   118: astore_3
    //   119: new 443	java/io/BufferedReader
    //   122: dup
    //   123: aload_3
    //   124: invokespecial 446	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   127: astore_1
    //   128: aload_1
    //   129: astore 5
    //   131: aload_3
    //   132: astore 7
    //   134: aload_1
    //   135: invokevirtual 449	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   138: astore_2
    //   139: aload_2
    //   140: astore 4
    //   142: aload_1
    //   143: astore_2
    //   144: aload_3
    //   145: astore_1
    //   146: aload 4
    //   148: invokestatic 109	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   151: ifeq +88 -> 239
    //   154: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   157: ifeq +47 -> 204
    //   160: ldc 131
    //   162: iconst_2
    //   163: new 17	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 451
    //   173: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 12
    //   178: invokevirtual 426	java/io/File:exists	()Z
    //   181: invokevirtual 141	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   184: ldc_w 453
    //   187: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload 12
    //   192: invokevirtual 429	java/io/File:isFile	()Z
    //   195: invokevirtual 141	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   198: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload 10
    //   206: invokestatic 455	bace:a	(Ljava/lang/String;)V
    //   209: aload_2
    //   210: ifnull +7 -> 217
    //   213: aload_2
    //   214: invokevirtual 458	java/io/BufferedReader:close	()V
    //   217: aload_1
    //   218: ifnull +7 -> 225
    //   221: aload_1
    //   222: invokevirtual 459	java/io/InputStreamReader:close	()V
    //   225: iconst_0
    //   226: ifeq +11 -> 237
    //   229: new 461	java/lang/NullPointerException
    //   232: dup
    //   233: invokespecial 462	java/lang/NullPointerException:<init>	()V
    //   236: athrow
    //   237: iload_0
    //   238: ireturn
    //   239: aload 11
    //   241: invokevirtual 426	java/io/File:exists	()Z
    //   244: ifeq +153 -> 397
    //   247: aload 11
    //   249: invokevirtual 429	java/io/File:isFile	()Z
    //   252: ifeq +145 -> 397
    //   255: new 433	java/io/FileInputStream
    //   258: dup
    //   259: aload 11
    //   261: invokespecial 436	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   264: astore_3
    //   265: aload_3
    //   266: aload 11
    //   268: invokevirtual 464	java/io/File:length	()J
    //   271: invokestatic 470	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   274: invokestatic 475	com/tencent/mobileqq/transfile/StructLongMessageDownloadProcessor:a	([B)Ljava/lang/String;
    //   277: astore 5
    //   279: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +41 -> 323
    //   285: ldc 131
    //   287: iconst_2
    //   288: new 17	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   295: ldc_w 477
    //   298: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload 5
    //   303: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: ldc_w 479
    //   309: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload 4
    //   314: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: aload 5
    //   325: aload 4
    //   327: invokevirtual 483	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   330: istore_0
    //   331: iload_0
    //   332: ifeq +34 -> 366
    //   335: iconst_1
    //   336: istore_0
    //   337: aload_2
    //   338: ifnull +7 -> 345
    //   341: aload_2
    //   342: invokevirtual 458	java/io/BufferedReader:close	()V
    //   345: aload_1
    //   346: ifnull +7 -> 353
    //   349: aload_1
    //   350: invokevirtual 459	java/io/InputStreamReader:close	()V
    //   353: aload_3
    //   354: ifnull -117 -> 237
    //   357: aload_3
    //   358: invokevirtual 484	java/io/FileInputStream:close	()V
    //   361: iconst_1
    //   362: ireturn
    //   363: astore_1
    //   364: iconst_1
    //   365: ireturn
    //   366: aload_2
    //   367: ifnull +7 -> 374
    //   370: aload_2
    //   371: invokevirtual 458	java/io/BufferedReader:close	()V
    //   374: aload_1
    //   375: ifnull +7 -> 382
    //   378: aload_1
    //   379: invokevirtual 459	java/io/InputStreamReader:close	()V
    //   382: aload_3
    //   383: ifnull +7 -> 390
    //   386: aload_3
    //   387: invokevirtual 484	java/io/FileInputStream:close	()V
    //   390: aload 10
    //   392: invokestatic 455	bace:a	(Ljava/lang/String;)V
    //   395: iconst_0
    //   396: ireturn
    //   397: aload 9
    //   399: astore_3
    //   400: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq -37 -> 366
    //   406: ldc 131
    //   408: iconst_2
    //   409: new 17	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   416: ldc_w 486
    //   419: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload 11
    //   424: invokevirtual 426	java/io/File:exists	()Z
    //   427: invokevirtual 141	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   430: ldc_w 453
    //   433: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload 11
    //   438: invokevirtual 429	java/io/File:isFile	()Z
    //   441: invokevirtual 141	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   444: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: aload 9
    //   452: astore_3
    //   453: goto -87 -> 366
    //   456: astore 4
    //   458: aload_1
    //   459: astore_3
    //   460: aload_2
    //   461: astore_1
    //   462: aload 4
    //   464: astore_2
    //   465: aload 6
    //   467: astore 4
    //   469: aload_1
    //   470: astore 5
    //   472: aload_3
    //   473: astore 7
    //   475: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq +23 -> 501
    //   481: aload 6
    //   483: astore 4
    //   485: aload_1
    //   486: astore 5
    //   488: aload_3
    //   489: astore 7
    //   491: ldc 131
    //   493: iconst_2
    //   494: ldc_w 488
    //   497: aload_2
    //   498: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   501: aload_1
    //   502: ifnull +7 -> 509
    //   505: aload_1
    //   506: invokevirtual 458	java/io/BufferedReader:close	()V
    //   509: aload_3
    //   510: ifnull +7 -> 517
    //   513: aload_3
    //   514: invokevirtual 459	java/io/InputStreamReader:close	()V
    //   517: aload 6
    //   519: ifnull -129 -> 390
    //   522: aload 6
    //   524: invokevirtual 484	java/io/FileInputStream:close	()V
    //   527: goto -137 -> 390
    //   530: astore_1
    //   531: goto -141 -> 390
    //   534: astore_3
    //   535: aconst_null
    //   536: astore_2
    //   537: aconst_null
    //   538: astore_1
    //   539: aload 8
    //   541: astore 4
    //   543: aload_2
    //   544: ifnull +7 -> 551
    //   547: aload_2
    //   548: invokevirtual 458	java/io/BufferedReader:close	()V
    //   551: aload_1
    //   552: ifnull +7 -> 559
    //   555: aload_1
    //   556: invokevirtual 459	java/io/InputStreamReader:close	()V
    //   559: aload 4
    //   561: ifnull +8 -> 569
    //   564: aload 4
    //   566: invokevirtual 484	java/io/FileInputStream:close	()V
    //   569: aload_3
    //   570: athrow
    //   571: astore_2
    //   572: goto -355 -> 217
    //   575: astore_1
    //   576: goto -351 -> 225
    //   579: astore_1
    //   580: iconst_0
    //   581: ireturn
    //   582: astore_2
    //   583: goto -238 -> 345
    //   586: astore_1
    //   587: goto -234 -> 353
    //   590: astore_2
    //   591: goto -217 -> 374
    //   594: astore_1
    //   595: goto -213 -> 382
    //   598: astore_1
    //   599: goto -209 -> 390
    //   602: astore_1
    //   603: goto -94 -> 509
    //   606: astore_1
    //   607: goto -90 -> 517
    //   610: astore_2
    //   611: goto -60 -> 551
    //   614: astore_1
    //   615: goto -56 -> 559
    //   618: astore_1
    //   619: goto -50 -> 569
    //   622: astore 4
    //   624: aload_3
    //   625: astore_1
    //   626: aconst_null
    //   627: astore_2
    //   628: aload 4
    //   630: astore_3
    //   631: aload 8
    //   633: astore 4
    //   635: goto -92 -> 543
    //   638: astore_3
    //   639: aload 7
    //   641: astore_1
    //   642: aload 5
    //   644: astore_2
    //   645: goto -102 -> 543
    //   648: astore_3
    //   649: aload 8
    //   651: astore 4
    //   653: goto -110 -> 543
    //   656: astore 5
    //   658: aload_3
    //   659: astore 4
    //   661: aload 5
    //   663: astore_3
    //   664: goto -121 -> 543
    //   667: astore_2
    //   668: aconst_null
    //   669: astore_1
    //   670: aconst_null
    //   671: astore_3
    //   672: goto -207 -> 465
    //   675: astore_2
    //   676: aconst_null
    //   677: astore_1
    //   678: goto -213 -> 465
    //   681: astore_2
    //   682: goto -217 -> 465
    //   685: astore 5
    //   687: aload_3
    //   688: astore 6
    //   690: aload_2
    //   691: astore 4
    //   693: aload_1
    //   694: astore_3
    //   695: aload 5
    //   697: astore_2
    //   698: aload 4
    //   700: astore_1
    //   701: goto -236 -> 465
    //   704: aconst_null
    //   705: astore_2
    //   706: aconst_null
    //   707: astore_1
    //   708: aload_3
    //   709: astore 4
    //   711: goto -565 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	336	0	bool	boolean
    //   127	223	1	localObject1	Object
    //   363	96	1	localException1	Exception
    //   461	45	1	localObject2	Object
    //   530	1	1	localException2	Exception
    //   538	18	1	localObject3	Object
    //   575	1	1	localException3	Exception
    //   579	1	1	localException4	Exception
    //   586	1	1	localException5	Exception
    //   594	1	1	localException6	Exception
    //   598	1	1	localException7	Exception
    //   602	1	1	localException8	Exception
    //   606	1	1	localException9	Exception
    //   614	1	1	localException10	Exception
    //   618	1	1	localException11	Exception
    //   625	83	1	localObject4	Object
    //   138	410	2	localObject5	Object
    //   571	1	2	localException12	Exception
    //   582	1	2	localException13	Exception
    //   590	1	2	localException14	Exception
    //   610	1	2	localException15	Exception
    //   627	18	2	localObject6	Object
    //   667	1	2	localException16	Exception
    //   675	1	2	localException17	Exception
    //   681	10	2	localException18	Exception
    //   697	9	2	localException19	Exception
    //   82	432	3	localObject7	Object
    //   534	91	3	localObject8	Object
    //   630	1	3	localObject9	Object
    //   638	1	3	localObject10	Object
    //   648	11	3	localObject11	Object
    //   663	46	3	localObject12	Object
    //   9	317	4	localObject13	Object
    //   456	7	4	localException20	Exception
    //   467	98	4	localObject14	Object
    //   622	7	4	localObject15	Object
    //   633	77	4	localObject16	Object
    //   129	514	5	localObject17	Object
    //   656	6	5	localObject18	Object
    //   685	11	5	localException21	Exception
    //   3	686	6	localObject19	Object
    //   132	508	7	localObject20	Object
    //   6	644	8	localObject21	Object
    //   12	439	9	localObject22	Object
    //   36	355	10	str	String
    //   78	359	11	localFile1	File
    //   66	125	12	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   357	361	363	java/lang/Exception
    //   146	204	456	java/lang/Exception
    //   204	209	456	java/lang/Exception
    //   239	265	456	java/lang/Exception
    //   400	450	456	java/lang/Exception
    //   522	527	530	java/lang/Exception
    //   38	80	534	finally
    //   83	119	534	finally
    //   213	217	571	java/lang/Exception
    //   221	225	575	java/lang/Exception
    //   229	237	579	java/lang/Exception
    //   341	345	582	java/lang/Exception
    //   349	353	586	java/lang/Exception
    //   370	374	590	java/lang/Exception
    //   378	382	594	java/lang/Exception
    //   386	390	598	java/lang/Exception
    //   505	509	602	java/lang/Exception
    //   513	517	606	java/lang/Exception
    //   547	551	610	java/lang/Exception
    //   555	559	614	java/lang/Exception
    //   564	569	618	java/lang/Exception
    //   119	128	622	finally
    //   134	139	638	finally
    //   475	481	638	finally
    //   491	501	638	finally
    //   146	204	648	finally
    //   204	209	648	finally
    //   239	265	648	finally
    //   400	450	648	finally
    //   265	323	656	finally
    //   323	331	656	finally
    //   38	80	667	java/lang/Exception
    //   83	119	667	java/lang/Exception
    //   119	128	675	java/lang/Exception
    //   134	139	681	java/lang/Exception
    //   265	323	685	java/lang/Exception
    //   323	331	685	java/lang/Exception
  }
  
  private static void d()
  {
    if (apdh.a(a())) {}
    switch (jdField_a_of_type_Int)
    {
    case 4: 
    default: 
      return;
    }
    try
    {
      jdField_b_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(a());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("VasShieldFont", 2, "createFromFile:", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     gh
 * JD-Core Version:    0.7.0.1
 */