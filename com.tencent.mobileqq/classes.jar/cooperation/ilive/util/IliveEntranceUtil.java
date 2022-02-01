package cooperation.ilive.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.IliveLaunchFragment;
import cooperation.ilive.config.IliveManagerCfgBean;
import cooperation.ilive.config.IliveManagerConfProcessor;
import cooperation.ilive.entity.IliveJumpParams;
import cooperation.ilive.lite.IliveLiteHelper;
import cooperation.ilive.lite.IliveLiteMonitorUtil;
import cooperation.ilive.manager.IliveDbManager;
import java.util.HashMap;
import java.util.List;

public class IliveEntranceUtil
{
  public static boolean a = false;
  public static boolean b = false;
  private static long c;
  private static long d;
  
  public static void a(Context paramContext, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("liveAnchorEntranceJump source = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("IliveEntranceUtil", 1, ((StringBuilder)localObject).toString());
    localObject = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("page_type", 1);
    localBundle.putString("source", paramString);
    localBundle.putBoolean("isDebugVersion", false);
    localBundle.putBoolean("useNewGiftSDK", true);
    localBundle.putString("qqVersion", AppSetting.b);
    localBundle.putLong("start_time", System.currentTimeMillis());
    ((Intent)localObject).putExtra("KEY_EXTRAS", localBundle);
    ((Intent)localObject).putExtra("KEY_IS_START_LIVE", true);
    IliveLaunchFragment.startSelf(paramContext, (Intent)localObject);
    VasStatisticCollector.a("anchor_enter_count", null, 0L);
  }
  
  public static void a(IliveJumpParams paramIliveJumpParams)
  {
    if (paramIliveJumpParams == null) {
      return;
    }
    if ((!e()) && (!b(paramIliveJumpParams))) {
      return;
    }
    if (!TextUtils.isEmpty(paramIliveJumpParams.d)) {
      try
      {
        paramIliveJumpParams.d = Uri.decode(paramIliveJumpParams.d);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
    if (!TextUtils.isEmpty(paramIliveJumpParams.h)) {
      try
      {
        paramIliveJumpParams.h = Uri.decode(paramIliveJumpParams.h);
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    if (!TextUtils.isEmpty(paramIliveJumpParams.l)) {
      try
      {
        paramIliveJumpParams.l = Uri.decode(paramIliveJumpParams.l);
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("liveWatchEntranceJump source = ");
    ((StringBuilder)localObject1).append(paramIliveJumpParams.b);
    ((StringBuilder)localObject1).append(" roomID = ");
    ((StringBuilder)localObject1).append(paramIliveJumpParams.c);
    ((StringBuilder)localObject1).append(" retain = ");
    ((StringBuilder)localObject1).append(paramIliveJumpParams.f);
    ((StringBuilder)localObject1).append(" sIsAnchorIsLive = ");
    ((StringBuilder)localObject1).append(a);
    ((StringBuilder)localObject1).append(" sIsAudienceIsLive = ");
    ((StringBuilder)localObject1).append(b);
    QLog.e("IliveEntranceUtil", 1, ((StringBuilder)localObject1).toString());
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" rtmp = ");
      ((StringBuilder)localObject1).append(paramIliveJumpParams.d);
      ((StringBuilder)localObject1).append(" closeJump = ");
      ((StringBuilder)localObject1).append(paramIliveJumpParams.h);
      ((StringBuilder)localObject1).append(" traceInfo = ");
      ((StringBuilder)localObject1).append(paramIliveJumpParams.j);
      QLog.i("IliveEntranceUtil", 2, ((StringBuilder)localObject1).toString());
    }
    if (TextUtils.isEmpty(paramIliveJumpParams.c)) {
      paramIliveJumpParams.c = "-1";
    }
    if (paramIliveJumpParams.l == null) {
      paramIliveJumpParams.l = "";
    }
    c(paramIliveJumpParams);
    localObject1 = IliveManagerConfProcessor.a();
    if ((localObject1 != null) && (((IliveManagerCfgBean)localObject1).d()))
    {
      IliveLiteHelper.a().b();
      localObject2 = LiteLiveSDKFactory.a().b();
      if ((localObject2 != null) && (((BusinessConfig)localObject2).a.equals("1037")))
      {
        ((BusinessConfig)localObject2).m.put("recom_info", paramIliveJumpParams.l);
        ((BusinessConfig)localObject2).m.put("closejump", paramIliveJumpParams.h);
        ((BusinessConfig)localObject2).m.put("enter_room", "1");
        HashMap localHashMap = ((BusinessConfig)localObject2).m;
        boolean bool = TextUtils.isEmpty(paramIliveJumpParams.d);
        String str = "0";
        if (!bool) {
          localObject1 = "1";
        } else {
          localObject1 = "0";
        }
        localHashMap.put("has_rtmp", localObject1);
        localHashMap = ((BusinessConfig)localObject2).m;
        localObject1 = str;
        if (IliveLiteMonitorUtil.f()) {
          localObject1 = "1";
        }
        localHashMap.put("is_process_launch", localObject1);
        localObject1 = localObject2;
      }
      else
      {
        QLog.e("IliveEntranceUtil", 1, "enter init businessConfig = null");
        localObject1 = new BusinessConfig();
        ((BusinessConfig)localObject1).m.put("enter_room", "1");
      }
      LiteLiveSDKFactory.a().b((BusinessConfig)localObject1);
      IliveLiteHelper.a().a(paramIliveJumpParams);
      return;
    }
    if ((a) && (b(paramIliveJumpParams.a)))
    {
      QLog.e("IliveEntranceUtil", 1, "sIsAnchorIsLive current anchor is live stop jump");
      return;
    }
    a = false;
    VasStatisticCollector.a("watch_enter_count", null, 0L);
    localObject1 = new Intent();
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("page_type", 3);
    ((Bundle)localObject2).putString("source", paramIliveJumpParams.b);
    ((Bundle)localObject2).putString("room_id", paramIliveJumpParams.c);
    ((Bundle)localObject2).putString("rtmp_Url", paramIliveJumpParams.d);
    ((Bundle)localObject2).putString("cover_url", paramIliveJumpParams.e);
    ((Bundle)localObject2).putString("trace_info", paramIliveJumpParams.j);
    ((Bundle)localObject2).putLong("start_time", System.currentTimeMillis());
    ((Bundle)localObject2).putStringArrayList("playlist", paramIliveJumpParams.g);
    ((Bundle)localObject2).putInt("from", paramIliveJumpParams.i);
    ((Bundle)localObject2).putBoolean("retaion", paramIliveJumpParams.f);
    ((Bundle)localObject2).putString("close_jump", paramIliveJumpParams.h);
    ((Bundle)localObject2).putBoolean("isDebugVersion", false);
    ((Bundle)localObject2).putString("qqVersion", AppSetting.b);
    ((Intent)localObject1).putExtra("KEY_EXTRAS", (Bundle)localObject2);
    ((Intent)localObject1).putExtra("KEY_IS_START_LIVE", false);
    IliveLaunchFragment.startSelf(paramIliveJumpParams.a, (Intent)localObject1);
  }
  
  public static boolean a()
  {
    return (b(BaseApplicationImpl.getContext())) && ((a) || (b));
  }
  
  public static boolean a(int paramInt)
  {
    d = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" offest = ");
    ((StringBuilder)localObject).append(d - c);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.i("IliveEntranceUtil", 1, (String)localObject);
    if (d - c <= paramInt) {
      bool = false;
    }
    c = d;
    return bool;
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
  
  public static boolean a(boolean paramBoolean)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
      localObject = (IAvGameManager)localQQAppInterface.getRuntimeService(IAvGameManager.class, "");
      if ((localObject != null) && (((IAvGameManager)localObject).isAvGameRoomExist()))
      {
        c(localQQAppInterface.getApp().getBaseContext(), "进入直播间失败");
        return false;
      }
      if (paramBoolean) {
        localObject = "通话中，不可发起直播";
      } else {
        localObject = "通话中，不可进入直播间";
      }
      if (localQQAppInterface.getAVNotifyCenter().c())
      {
        c(localQQAppInterface.getApp().getBaseContext(), (String)localObject);
        QLog.e("IliveEntranceUtil", 2, "isBusinessEnableEnterLive isPhoneCalling");
        return false;
      }
      if (localQQAppInterface.getAVNotifyCenter().d())
      {
        c(localQQAppInterface.getApp().getBaseContext(), (String)localObject);
        QLog.e("IliveEntranceUtil", 2, "isBusinessEnableEnterLive isAvChating");
        return false;
      }
    }
    return true;
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= QVipSDKProcessor.e().e();
  }
  
  private static boolean b(Context paramContext)
  {
    boolean bool = b(paramContext, "com.tencent.proxyinner.plugin.loader.PluginToolProcessService");
    paramContext = new StringBuilder();
    paramContext.append("isIlivePluginsServiceExisted : ");
    paramContext.append(bool);
    QLog.e("IliveEntranceUtil", 1, paramContext.toString());
    return bool;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        ElapseStat.a("IliveEntranceUtilisServiceExisted");
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647);
        if (paramContext != null)
        {
          if (paramContext.size() == 0)
          {
            return false;
            if (i < paramContext.size())
            {
              Object localObject = (ActivityManager.RunningServiceInfo)paramContext.get(i);
              if (localObject == null) {
                break label107;
              }
              localObject = ((ActivityManager.RunningServiceInfo)localObject).service;
              if ((localObject == null) || (!((ComponentName)localObject).getClassName().equals(paramString))) {
                break label107;
              }
              return true;
            }
            ElapseStat.b("IliveEntranceUtilisServiceExisted");
            return false;
          }
        }
        else {
          return false;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
      int i = 0;
      continue;
      label107:
      i += 1;
    }
  }
  
  private static boolean b(IliveJumpParams paramIliveJumpParams)
  {
    if (paramIliveJumpParams != null)
    {
      if (paramIliveJumpParams.a == null) {
        return true;
      }
      Object localObject = AVBizModuleFactory.getModuleByName("QQ直播");
      paramIliveJumpParams = paramIliveJumpParams.a;
      localObject = ((IModule)localObject).checkAVFocus();
      if (!"true".equals(localObject))
      {
        String str = String.format(paramIliveJumpParams.getResources().getString(2131887170), new Object[] { localObject });
        ThreadManagerV2.getUIHandlerV2().post(new IliveEntranceUtil.2(paramIliveJumpParams, str));
        paramIliveJumpParams = new StringBuilder();
        paramIliveJumpParams.append("preCheckIsUserGamePlaying, res[");
        paramIliveJumpParams.append((String)localObject);
        paramIliveJumpParams.append("]");
        QLog.e("IliveEntranceUtil", 1, paramIliveJumpParams.toString());
        return false;
      }
    }
    return true;
  }
  
  private static void c(Context paramContext, String paramString)
  {
    ThreadManagerV2.getUIHandlerV2().post(new IliveEntranceUtil.1(paramContext, paramString));
  }
  
  private static void c(IliveJumpParams paramIliveJumpParams)
  {
    IliveLiteMonitorUtil.a(TextUtils.isEmpty(paramIliveJumpParams.d) ^ true, paramIliveJumpParams.i);
    IliveLiteMonitorUtil.a(paramIliveJumpParams.i);
    IliveLiteMonitorUtil.h();
    IliveLiteMonitorUtil.a("live_on_bind");
    IliveLiteMonitorUtil.d(String.valueOf(System.currentTimeMillis()));
    IliveLiteMonitorUtil.k();
  }
  
  public static boolean c()
  {
    return IliveDbManager.getIliveSwitch(1) == 1;
  }
  
  public static boolean d()
  {
    return IliveDbManager.getIliveSwitch(2) == 1;
  }
  
  private static boolean e()
  {
    Object localObject = AVBizModuleFactory.getModuleByName("QQ直播").getFocusBusiness();
    if (localObject != null)
    {
      boolean bool = ((HashMap)localObject).containsValue("游戏组队");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("is isTimiGameFocusAV ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("IliveEntranceUtil", 1, ((StringBuilder)localObject).toString());
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.util.IliveEntranceUtil
 * JD-Core Version:    0.7.0.1
 */