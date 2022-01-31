import UserGrowth.stLinkStragegyArgs;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiLinkUtil.1;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiLinkUtil.2;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiLinkUtil.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import cooperation.qzone.LocalMultiProcConfig;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class snc
{
  private static int a()
  {
    if (!a(b(), c(), 0)) {
      return 0;
    }
    return LocalMultiProcConfig.getInt("weishi_usergrowth", b(), 0);
  }
  
  public static stLinkStragegyArgs a()
  {
    stLinkStragegyArgs localstLinkStragegyArgs = new stLinkStragegyArgs();
    localstLinkStragegyArgs.hasInstalledWeish = vzw.a(BaseApplicationImpl.getApplication().getApplicationContext());
    localstLinkStragegyArgs.todayClickCount = b();
    localstLinkStragegyArgs.todayEnterCount = a();
    localstLinkStragegyArgs.todayLastLinkId = c();
    return localstLinkStragegyArgs;
  }
  
  public static void a()
  {
    a(b(), c());
  }
  
  public static void a(int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new WeishiLinkUtil.1(paramInt));
  }
  
  private static void a(String paramString1, String paramString2)
  {
    ThreadManager.getSubThreadHandler().post(new WeishiLinkUtil.2(paramString1, paramString2));
  }
  
  private static boolean a(String paramString1, String paramString2, int paramInt)
  {
    long l = LocalMultiProcConfig.getLong("weishi_usergrowth", paramString2, 0L);
    boolean bool = bhof.a(System.currentTimeMillis(), l);
    if (!bool) {
      ThreadManager.getSubThreadHandler().post(new WeishiLinkUtil.3(paramString1, paramInt, paramString2));
    }
    return bool;
  }
  
  private static int b()
  {
    if (!a(d(), e(), 0)) {
      return 0;
    }
    return LocalMultiProcConfig.getInt("weishi_usergrowth", d(), 0);
  }
  
  private static String b()
  {
    return "key_open_recommend_page_count_" + h();
  }
  
  public static void b()
  {
    a(d(), e());
  }
  
  private static int c()
  {
    if (!a(f(), g(), -1)) {
      return -1;
    }
    return LocalMultiProcConfig.getInt("weishi_usergrowth", f(), -1);
  }
  
  private static String c()
  {
    return "key_open_recommend_page_time_" + h();
  }
  
  private static String d()
  {
    return "key_click_recommend_card_count_" + h();
  }
  
  private static String e()
  {
    return "key_click_recommend_card_time_" + h();
  }
  
  private static String f()
  {
    return "key_last_link_type_" + h();
  }
  
  private static String g()
  {
    return "key_last_link_time_" + h();
  }
  
  private static String h()
  {
    String str2 = "";
    String str3 = DeviceUtils.getVersionName(BaseApplicationImpl.getContext());
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str1 = str2;
    if (localAppRuntime != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(localAppRuntime.getAccount())) {
        str1 = bdij.a(localAppRuntime.getAccount());
      }
    }
    return str1 + "_" + str3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     snc
 * JD-Core Version:    0.7.0.1
 */