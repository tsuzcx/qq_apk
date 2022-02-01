package cooperation.ilive.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.avgame.business.AvGameManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.IliveLaunchFragment;
import cooperation.ilive.config.IliveManagerCfgBean;
import cooperation.ilive.config.IliveManagerConfProcessor;
import cooperation.ilive.entity.IliveJumpParams;
import cooperation.ilive.lite.IliveLiteHelper;
import cooperation.ilive.manager.IliveDbManager;
import java.util.HashMap;
import java.util.List;

public class IliveEntranceUtil
{
  private static long a;
  public static boolean a;
  private static long b;
  public static boolean b;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    QLog.e("IliveEntranceUtil", 1, "liveAnchorEntranceJump source = " + paramString);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("page_type", 1);
    localBundle.putString("source", paramString);
    localBundle.putBoolean("isDebugVersion", false);
    localBundle.putString("qqVersion", AppSetting.jdField_a_of_type_JavaLangString);
    localBundle.putLong("start_time", System.currentTimeMillis());
    localIntent.putExtra("KEY_EXTRAS", localBundle);
    localIntent.putExtra("KEY_IS_START_LIVE", true);
    IliveLaunchFragment.startSelf(paramContext, localIntent);
    VasStatisticCollector.a("anchor_enter_count", null, 0L);
  }
  
  public static void a(IliveJumpParams paramIliveJumpParams)
  {
    if (paramIliveJumpParams == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramIliveJumpParams.c)) {}
    try
    {
      paramIliveJumpParams.c = Uri.decode(paramIliveJumpParams.c);
      if (TextUtils.isEmpty(paramIliveJumpParams.e)) {}
    }
    catch (Exception localException2)
    {
      try
      {
        paramIliveJumpParams.e = Uri.decode(paramIliveJumpParams.e);
        if (TextUtils.isEmpty(paramIliveJumpParams.g)) {}
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            paramIliveJumpParams.g = Uri.decode(paramIliveJumpParams.g);
            QLog.e("IliveEntranceUtil", 1, "liveWatchEntranceJump source = " + paramIliveJumpParams.jdField_a_of_type_JavaLangString + " roomID = " + paramIliveJumpParams.b + " retain = " + paramIliveJumpParams.jdField_a_of_type_Boolean + " sIsAnchorIsLive = " + jdField_a_of_type_Boolean + " sIsAudienceIsLive = " + jdField_b_of_type_Boolean);
            if (QLog.isColorLevel()) {
              QLog.i("IliveEntranceUtil", 2, " rtmp = " + paramIliveJumpParams.c + " closeJump = " + paramIliveJumpParams.e + " traceInfo = " + paramIliveJumpParams.f);
            }
            if (TextUtils.isEmpty(paramIliveJumpParams.b)) {
              paramIliveJumpParams.b = "-1";
            }
            if (paramIliveJumpParams.g == null) {
              paramIliveJumpParams.g = "";
            }
            Object localObject = IliveManagerConfProcessor.a();
            if ((localObject == null) || (!((IliveManagerCfgBean)localObject).b())) {
              break;
            }
            IliveLiteHelper.a().a();
            localObject = LiteLiveSDKFactory.a().a();
            if ((localObject != null) && (((BusinessConfig)localObject).jdField_a_of_type_JavaLangString.equals("1037")))
            {
              ((BusinessConfig)localObject).jdField_a_of_type_JavaUtilHashMap.put("recom_info", paramIliveJumpParams.g);
              ((BusinessConfig)localObject).jdField_a_of_type_JavaUtilHashMap.put("closejump", paramIliveJumpParams.e);
            }
            LiteLiveSDKFactory.a().b((BusinessConfig)localObject);
            IliveLiteHelper.a().a(paramIliveJumpParams);
            return;
            localException1 = localException1;
            localException1.printStackTrace();
          }
          localException2 = localException2;
          localException2.printStackTrace();
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            localException3.printStackTrace();
          }
          if ((jdField_a_of_type_Boolean) && (b(paramIliveJumpParams.jdField_a_of_type_AndroidContentContext)))
          {
            QLog.e("IliveEntranceUtil", 1, "sIsAnchorIsLive current anchor is live stop jump");
            return;
          }
          jdField_a_of_type_Boolean = false;
          VasStatisticCollector.a("watch_enter_count", null, 0L);
          Intent localIntent = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putInt("page_type", 3);
          localBundle.putString("source", paramIliveJumpParams.jdField_a_of_type_JavaLangString);
          localBundle.putString("room_id", paramIliveJumpParams.b);
          localBundle.putString("rtmp_Url", paramIliveJumpParams.c);
          localBundle.putString("cover_url", paramIliveJumpParams.d);
          localBundle.putString("trace_info", paramIliveJumpParams.f);
          localBundle.putLong("start_time", System.currentTimeMillis());
          localBundle.putStringArrayList("playlist", paramIliveJumpParams.jdField_a_of_type_JavaUtilArrayList);
          localBundle.putInt("from", paramIliveJumpParams.jdField_a_of_type_Int);
          localBundle.putBoolean("retaion", paramIliveJumpParams.jdField_a_of_type_Boolean);
          localBundle.putString("close_jump", paramIliveJumpParams.e);
          localBundle.putBoolean("isDebugVersion", false);
          localBundle.putString("qqVersion", AppSetting.jdField_a_of_type_JavaLangString);
          localIntent.putExtra("KEY_EXTRAS", localBundle);
          localIntent.putExtra("KEY_IS_START_LIVE", false);
          IliveLaunchFragment.startSelf(paramIliveJumpParams.jdField_a_of_type_AndroidContentContext, localIntent);
        }
      }
    }
  }
  
  public static boolean a()
  {
    return (b(BaseApplicationImpl.getContext())) && ((jdField_a_of_type_Boolean) || (jdField_b_of_type_Boolean));
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = true;
    jdField_b_of_type_Long = System.currentTimeMillis();
    QLog.i("IliveEntranceUtil", 1, " offest = " + (jdField_b_of_type_Long - jdField_a_of_type_Long));
    if (jdField_b_of_type_Long - jdField_a_of_type_Long > paramInt) {}
    for (;;)
    {
      jdField_a_of_type_Long = jdField_b_of_type_Long;
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (c())
    {
      a(paramContext, "qzone");
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        ElapseStat.a("IliveEntranceUtilisServiceExisted");
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647);
        if (paramContext == null) {
          break label102;
        }
        if (paramContext.size() != 0) {
          break label104;
        }
      }
      catch (Throwable paramContext)
      {
        Object localObject;
        paramContext.printStackTrace();
        continue;
      }
      if (i < paramContext.size())
      {
        localObject = (ActivityManager.RunningServiceInfo)paramContext.get(i);
        if (localObject != null)
        {
          localObject = ((ActivityManager.RunningServiceInfo)localObject).service;
          if ((localObject != null) && (((ComponentName)localObject).getClassName().equals(paramString))) {
            return true;
          }
        }
      }
      else
      {
        ElapseStat.b("IliveEntranceUtilisServiceExisted");
        return false;
        label102:
        return false;
        label104:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  public static boolean a(boolean paramBoolean)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
      localObject = (AvGameManager)localQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
      if ((localObject != null) && (((AvGameManager)localObject).a()))
      {
        b(localQQAppInterface.getApp().getBaseContext(), "进入直播间失败");
        return false;
      }
      if (paramBoolean) {}
      for (localObject = "通话中，不可发起直播"; localQQAppInterface.getAVNotifyCenter().a(); localObject = "通话中，不可进入直播间")
      {
        b(localQQAppInterface.getApp().getBaseContext(), (String)localObject);
        QLog.e("IliveEntranceUtil", 2, "isBusinessEnableEnterLive isPhoneCalling");
        return false;
      }
      if (localQQAppInterface.getAVNotifyCenter().b())
      {
        b(localQQAppInterface.getApp().getBaseContext(), (String)localObject);
        QLog.e("IliveEntranceUtil", 2, "isBusinessEnableEnterLive isAvChating");
        return false;
      }
    }
    return true;
  }
  
  private static void b(Context paramContext, String paramString)
  {
    ThreadManagerV2.getUIHandlerV2().post(new IliveEntranceUtil.1(paramContext, paramString));
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= QVipSDKProcessor.c().a();
  }
  
  private static boolean b(Context paramContext)
  {
    boolean bool = a(paramContext, "com.tencent.proxyinner.plugin.loader.PluginToolProcessService");
    QLog.e("IliveEntranceUtil", 1, "isIlivePluginsServiceExisted : " + bool);
    return bool;
  }
  
  public static boolean c()
  {
    return IliveDbManager.getIliveSwitch(1) == 1;
  }
  
  public static boolean d()
  {
    return IliveDbManager.getIliveSwitch(2) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.util.IliveEntranceUtil
 * JD-Core Version:    0.7.0.1
 */