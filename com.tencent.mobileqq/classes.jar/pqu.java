import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting.1;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting.2;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting.3;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class pqu
{
  public static int a;
  private static long a;
  public static Object a;
  public static String a;
  public static Map<String, MessageForStructing> a;
  public static volatile boolean a;
  private static int jdField_b_of_type_Int;
  public static String b;
  private static volatile boolean jdField_b_of_type_Boolean = true;
  private static int c;
  public static String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "0";
    jdField_b_of_type_JavaLangString = "1";
    jdField_c_of_type_JavaLangString = "2";
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 3;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  public static MessageForStructing a(QQAppInterface paramQQAppInterface)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)jdField_a_of_type_JavaUtilMap.get(paramQQAppInterface.getCurrentAccountUin());
      jdField_a_of_type_JavaUtilMap.remove(paramQQAppInterface.getCurrentAccountUin());
      return localMessageForStructing;
    }
  }
  
  public static SystemBarCompact a(Activity paramActivity)
  {
    return new SystemBarCompact(paramActivity, true, -1);
  }
  
  public static String a()
  {
    return a(-1L);
  }
  
  public static String a(long paramLong)
  {
    boolean bool;
    String str;
    int i;
    if (a() == 6)
    {
      bool = true;
      str = jdField_b_of_type_JavaLangString;
      if (paramLong != 1004L) {
        break label92;
      }
      if (!bool) {
        break label78;
      }
      i = bmhv.b(BaseApplicationImpl.getApplication().getRuntime(), 0);
      label38:
      if (i != 0) {
        break label122;
      }
      str = jdField_c_of_type_JavaLangString;
    }
    for (;;)
    {
      localObject = bmhv.a(pnn.a(), true, false);
      if (localObject != null) {
        break label148;
      }
      QLog.d("RIJAppSetting", 1, "getVideoAutoPlaySetting failed to get sp");
      return str;
      bool = false;
      break;
      label78:
      i = bmhv.a(BaseApplicationImpl.getApplication().getRuntime(), 0);
      break label38;
      label92:
      if (bool)
      {
        i = bmhv.c(BaseApplicationImpl.getApplication().getRuntime());
        break label38;
      }
      i = bmhv.b(BaseApplicationImpl.getApplication().getRuntime());
      break label38;
      label122:
      if (i == 1) {
        str = jdField_b_of_type_JavaLangString;
      } else if (i == 2) {
        str = jdField_a_of_type_JavaLangString;
      }
    }
    label148:
    if (bool) {}
    for (Object localObject = ((SharedPreferences)localObject).getString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_VIDEO_FLOW_SETTING", str);; localObject = ((SharedPreferences)localObject).getString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_SETTING", str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJAppSetting", 2, "getVideoAutoPlaySetting(),isVideoFlowEnter = " + bool + ", autoSetting = " + (String)localObject + ",localSettingDefaultValue=" + str + ", remoteSettingDefaultValue=" + i + " channelFrom:" + paramLong);
      }
      return localObject;
    }
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (paramString.length() < 8) {
      return paramString + "|" + paramString.length();
    }
    return paramString.substring(0, 8) + "|" + paramString.length();
  }
  
  /* Error */
  public static String a(java.lang.Throwable paramThrowable)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 183	java/io/StringWriter
    //   5: dup
    //   6: invokespecial 184	java/io/StringWriter:<init>	()V
    //   9: astore_1
    //   10: new 186	java/io/PrintWriter
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 189	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   18: astore_3
    //   19: aload_0
    //   20: aload_3
    //   21: invokevirtual 195	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   24: aload_3
    //   25: invokevirtual 198	java/io/PrintWriter:flush	()V
    //   28: aload_1
    //   29: invokevirtual 199	java/io/StringWriter:flush	()V
    //   32: aload_1
    //   33: ifnull +7 -> 40
    //   36: aload_1
    //   37: invokevirtual 202	java/io/StringWriter:close	()V
    //   40: aload_3
    //   41: ifnull +7 -> 48
    //   44: aload_3
    //   45: invokevirtual 203	java/io/PrintWriter:close	()V
    //   48: aload_1
    //   49: invokevirtual 204	java/io/StringWriter:toString	()Ljava/lang/String;
    //   52: areturn
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   58: goto -18 -> 40
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_2
    //   65: ifnull +7 -> 72
    //   68: aload_2
    //   69: invokevirtual 202	java/io/StringWriter:close	()V
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 203	java/io/PrintWriter:close	()V
    //   80: aload_0
    //   81: athrow
    //   82: astore_2
    //   83: aload_2
    //   84: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   87: goto -15 -> 72
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_3
    //   93: aload_1
    //   94: astore_2
    //   95: aload_3
    //   96: astore_1
    //   97: goto -33 -> 64
    //   100: astore_0
    //   101: aload_1
    //   102: astore_2
    //   103: aload_3
    //   104: astore_1
    //   105: goto -41 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramThrowable	java.lang.Throwable
    //   9	96	1	localObject1	Object
    //   1	68	2	localObject2	Object
    //   82	2	2	localIOException	java.io.IOException
    //   94	9	2	localObject3	Object
    //   18	86	3	localPrintWriter	java.io.PrintWriter
    // Exception table:
    //   from	to	target	type
    //   36	40	53	java/io/IOException
    //   2	10	61	finally
    //   68	72	82	java/io/IOException
    //   10	19	90	finally
    //   19	32	100	finally
  }
  
  public static void a()
  {
    AppRuntime localAppRuntime = pnn.a();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      if (!((QQAppInterface)localAppRuntime).mAutomator.b()) {
        pwb.f();
      }
    }
    else {
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new RIJAppSetting.2(), 500L);
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  @TargetApi(23)
  public static void a(Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, SystemBarCompact paramSystemBarCompact)
  {
    if ((paramActivity == null) || (paramSystemBarCompact == null)) {}
    while ((!paramBoolean) || (ImmersiveUtils.isSupporImmersive() != 1)) {
      return;
    }
    paramActivity.getWindow().addFlags(67108864);
    paramSystemBarCompact.init();
    if (ThemeUtil.isNowThemeIsNight(pnn.a(), false, null))
    {
      if ((!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme()))
      {
        paramSystemBarCompact.setStatusBarColor(-7829368);
        return;
      }
      paramSystemBarCompact.setStatusBarColor(-7829368);
      paramSystemBarCompact.setStatusBarDarkMode(true);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme()))
    {
      a(paramActivity, true);
      paramSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!SystemUtil.isFlyme())
    {
      paramSystemBarCompact.setStatusBarColor(-2368549);
      return;
    }
    paramSystemBarCompact.setStatusBarColor(-1);
    paramSystemBarCompact.setStatusBarDarkMode(true);
  }
  
  public static void a(View paramView)
  {
    if (paramView != null)
    {
      paramView.setBackgroundResource(0);
      if (ThemeUtil.isNowThemeIsNight(pnn.a(), false, null)) {
        paramView.setBackgroundColor(Color.parseColor("#888888"));
      }
    }
    else
    {
      return;
    }
    paramView.setBackgroundColor(-1);
  }
  
  public static void a(BaseActivity paramBaseActivity)
  {
    a(paramBaseActivity, -1);
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBaseActivity.getWindow().addFlags(67108864);
      ImmersiveUtils.a(paramBaseActivity.getWindow(), true);
      if (paramBaseActivity.mSystemBarComp == null) {
        paramBaseActivity.mSystemBarComp = new SystemBarCompact(paramBaseActivity, true, -1);
      }
      paramBaseActivity.mSystemBarComp.init();
      if ((Build.VERSION.SDK_INT < 23) || (SystemUtil.isMIUI()) || (SystemUtil.isFlyme())) {
        break label116;
      }
      paramBaseActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
      if (ThemeUtil.isInNightMode(paramBaseActivity.app)) {
        paramBaseActivity.mSystemBarComp.setStatusBarColor(1996488704);
      }
    }
    else
    {
      return;
    }
    paramBaseActivity.mSystemBarComp.setStatusBarColor(paramInt);
    return;
    label116:
    if (!SystemUtil.isFlyme())
    {
      paramBaseActivity.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    paramBaseActivity.mSystemBarComp.setStatusBarColor(paramInt);
    paramBaseActivity.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new RIJAppSetting.1(paramQQAppInterface), 8, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      SettingCloneUtil.writeValue(localMobileQQ, paramQQAppInterface, null, "qqsetting_kandian_key", paramBoolean);
      return;
    }
  }
  
  public static void a(String paramString)
  {
    Object localObject = bmhv.a(pnn.a(), true, false);
    if (localObject == null)
    {
      QLog.d("RIJAppSetting", 1, "updateVideoAutoPlaySetting failed to get sp");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (a() == 6) {
      ((SharedPreferences.Editor)localObject).putString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_VIDEO_FLOW_SETTING", paramString);
    }
    for (;;)
    {
      bmhv.a((SharedPreferences.Editor)localObject, true);
      return;
      ((SharedPreferences.Editor)localObject).putString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_SETTING", paramString);
    }
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(paramString1, paramInt, paramString2);
    long l = bmhv.a();
    if ((l != -1L) && (System.currentTimeMillis() - l < 600000L)) {}
  }
  
  public static boolean a()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    return (localBaseActivity != null) && (((localBaseActivity instanceof ReadInJoyNewFeedsActivity)) || (localBaseActivity.getClass().getSimpleName().toLowerCase().contains("kandian")) || (localBaseActivity.getClass().getSimpleName().toLowerCase().contains("readinjoy")));
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 9999;
  }
  
  public static boolean a(long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = System.currentTimeMillis();
    }
    paramLong = l - bmhv.a((QQAppInterface)pnn.a());
    if (QLog.isColorLevel()) {
      if (paramLong >= pjt.jdField_a_of_type_Int) {
        break label90;
      }
    }
    label90:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("RIJAppSetting", 2, new Object[] { "isNeedToRememberHistoryPos, timeInterval = ", Long.valueOf(paramLong), " , isNeedToRemember = ", Boolean.valueOf(bool) });
      if (paramLong >= pjt.jdField_a_of_type_Int) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = pnn.a();
    if (paramContext == null) {}
    while ((paramContext.isBackgroundPause) || (paramContext.isBackgroundStop)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    if (!SettingCloneUtil.readValue(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentUin(), null, "qqsetting_kandian_key", true)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJAppSetting", 2, "isDeleteNewKandian, flag = " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public static String b()
  {
    Object localObject;
    if (jdField_b_of_type_Int >= 10) {
      localObject = "null";
    }
    String str;
    do
    {
      return localObject;
      str = QQDeviceInfo.getIMEI("d059d3", 5);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    jdField_b_of_type_Int += 1;
    return "null";
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      MessageForStructing localMessageForStructing;
      QQMessageFacade localQQMessageFacade;
      do
      {
        do
        {
          return;
          localMessageForStructing = a(paramQQAppInterface);
        } while ((a(paramQQAppInterface)) || (localMessageForStructing == null));
        localQQMessageFacade = paramQQAppInterface.getMessageFacade();
      } while (localQQMessageFacade == null);
      localMessageForStructing.time = NetConnInfoCenter.getServerTime();
      MessageRecord localMessageRecord = ((KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(localMessageForStructing);
      if (localMessageRecord != null) {
        localQQMessageFacade.addMessage(localMessageRecord, paramQQAppInterface.getCurrentUin());
      }
      localQQMessageFacade.addMessage(localMessageForStructing, paramQQAppInterface.getCurrentUin());
    } while (!QLog.isColorLevel());
    QLog.d("RIJAppSetting", 2, "notifyXinKandianMsg");
  }
  
  public static boolean b()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (!(localBaseActivity instanceof SplashActivity)) {
      return false;
    }
    if (((SplashActivity)localBaseActivity).a() == MainFragment.h) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    KeyguardManager localKeyguardManager = (KeyguardManager)BaseApplicationImpl.getContext().getApplicationContext().getSystemService("keyguard");
    return (paramQQAppInterface.isBackgroundPause) || (paramQQAppInterface.isBackgroundStop) || (localKeyguardManager.inKeyguardRestrictedInputMode());
  }
  
  public static String c()
  {
    Object localObject;
    if (jdField_c_of_type_Int >= 10) {
      localObject = "null";
    }
    String str;
    do
    {
      return localObject;
      str = QQDeviceInfo.getIMSI("d059d3", 5);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    jdField_c_of_type_Int += 1;
    return "null";
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    if (jdField_b_of_type_Boolean)
    {
      jdField_b_of_type_Boolean = false;
      a();
    }
    if (bmhv.n())
    {
      pvj.a().d(0);
      pvj.a().d(56);
      pvj.a().e(40677);
      if (plm.b(plm.b())) {
        pvj.a().d(plm.b());
      }
    }
    jdField_a_of_type_Boolean = true;
    ThreadManager.post(new RIJAppSetting.3(paramQQAppInterface), 8, null, false);
  }
  
  public static boolean c()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (!(localBaseActivity instanceof PublicFragmentActivity)) {
      return false;
    }
    return ((PublicFragmentActivity)localBaseActivity).a() instanceof ReadInJoyDailyFragment;
  }
  
  public static boolean d()
  {
    return (a()) || (b());
  }
  
  public static boolean e()
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long <= 200L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJAppSetting", 2, "click too fast");
      }
      jdField_a_of_type_Long = l;
      return true;
    }
    jdField_a_of_type_Long = l;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqu
 * JD-Core Version:    0.7.0.1
 */