package com.tencent.qqmini.sdk.manager;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class GameGrowthGuardianManager
{
  private static final String ENABLE_HEART_BEAT_APPID_WHITELIST;
  private static final String ENABLE_HEART_BEAT_SCENE_WHITELIST;
  private static final String ENABLE_HEART_BEAT_VIA_WHITELIST;
  private static final int GUARD_INSTRUCTION_TYPE_REAL_NAME_AUTHENTICATE = 7;
  private static final int JUDGE_TIMING_REQUEST_BEGIN_DELAY = WnsConfig.getConfig("qqminiapp", "mini_game_judge_timing_request_begin_delay", 1000);
  private static final int JUDGE_TIMING_REQUEST_FACT_TYPE_BEGIN = 11;
  private static final int JUDGE_TIMING_REQUEST_FACT_TYPE_END = 13;
  private static final int JUDGE_TIMING_REQUEST_FACT_TYPE_HEARTBEAT = 12;
  private static final String TAG = "GameGrowthGuardianManager";
  private static long beginExecuteMillis;
  private static Runnable heartBeatRunnable = null;
  private static boolean isForeground;
  private static COMM.StCommonExt previousExtInfo;
  private static GameGrowthGuardianManager.OnStopCallback sOnStopCallback;
  
  static
  {
    ENABLE_HEART_BEAT_SCENE_WHITELIST = WnsConfig.getConfig("qqminiapp", "enable_heart_beat_scene_whitelist", "");
    ENABLE_HEART_BEAT_APPID_WHITELIST = WnsConfig.getConfig("qqminiapp", "enable_heart_beat_appid_whitelist", "");
    ENABLE_HEART_BEAT_VIA_WHITELIST = WnsConfig.getConfig("qqminiapp", "enable_heart_beat_via_whitelist", "");
    previousExtInfo = null;
    isForeground = false;
    beginExecuteMillis = 0L;
    sOnStopCallback = null;
  }
  
  private static void doJuddgeTiming(Context paramContext, MiniAppInfo paramMiniAppInfo, @GameGrowthGuardianManager.JudgeTimingRequestFactType int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, String paramString3)
  {
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    long l = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    String str = "";
    if (paramString1 == null) {
      paramString1 = "";
    }
    if (paramMiniAppInfo.via != null) {
      str = paramMiniAppInfo.via;
    }
    localChannelProxy.judgeTiming(paramString2, paramInt2, paramInt3, paramInt1, l, paramInt4, paramString1, 0, str, paramMiniAppInfo.gameAdsTotalTime, previousExtInfo, paramMiniAppInfo.customInfo, paramString3, new GameGrowthGuardianManager.2(paramMiniAppInfo, paramContext, paramInt1));
  }
  
  private static boolean enableHeartBeatAppIdWhiteList(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.appId != null) && (!TextUtils.isEmpty(ENABLE_HEART_BEAT_APPID_WHITELIST)))
    {
      String[] arrayOfString = ENABLE_HEART_BEAT_APPID_WHITELIST.split(",");
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (paramMiniAppInfo.appId.equals(str)) {
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  private static boolean enableHeartBeatCheck(MiniAppInfo paramMiniAppInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMiniAppInfo != null)
    {
      if (paramMiniAppInfo.isEngineTypeMiniGame()) {
        return true;
      }
      bool1 = bool2;
      if (!paramMiniAppInfo.isEngineTypeMiniGame())
      {
        bool1 = bool2;
        if (enableHeartBeatForMiniApp(paramMiniAppInfo)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static boolean enableHeartBeatForMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    int j = 9999;
    String str = null;
    int i = j;
    if (paramMiniAppInfo != null) {
      i = j;
    }
    try
    {
      if (paramMiniAppInfo.launchParam != null) {
        i = paramMiniAppInfo.launchParam.scene;
      }
      if (paramMiniAppInfo != null) {
        str = paramMiniAppInfo.via;
      }
      if (isFromQQXMAN(i, str)) {
        return true;
      }
      if (enableHeartBeatSceneWhiteList(i)) {
        return true;
      }
      if (enableHeartBeatAppIdWhiteList(paramMiniAppInfo)) {
        return true;
      }
      boolean bool = enableHeartBeatViaWhiteList(str);
      if (!bool) {
        break label92;
      }
      return true;
    }
    catch (Exception paramMiniAppInfo)
    {
      label84:
      break label84;
    }
    QMLog.e("GameGrowthGuardianManager", "enableHeartBeatForLaunchScene", paramMiniAppInfo);
    label92:
    return false;
  }
  
  private static boolean enableHeartBeatSceneWhiteList(int paramInt)
  {
    if (!TextUtils.isEmpty(ENABLE_HEART_BEAT_SCENE_WHITELIST))
    {
      String[] arrayOfString = ENABLE_HEART_BEAT_SCENE_WHITELIST.split(",");
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (paramInt == Integer.parseInt(arrayOfString[i])) {
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  private static boolean enableHeartBeatViaWhiteList(String paramString)
  {
    if (!TextUtils.isEmpty(ENABLE_HEART_BEAT_VIA_WHITELIST))
    {
      String[] arrayOfString = ENABLE_HEART_BEAT_VIA_WHITELIST.split(",");
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if ((str != null) && (str.equals(paramString))) {
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  private static void execute(Context paramContext, MiniAppInfo paramMiniAppInfo, @GameGrowthGuardianManager.JudgeTimingRequestFactType int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void executeBegin(Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    isForeground = true;
    ThreadManager.getUIHandler().postDelayed(new GameGrowthGuardianManager.1(paramMiniAppInfo, paramContext), JUDGE_TIMING_REQUEST_BEGIN_DELAY);
  }
  
  public static void executeEnd(Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    isForeground = false;
    execute(paramContext, paramMiniAppInfo, 13);
    if (heartBeatRunnable != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(heartBeatRunnable);
      heartBeatRunnable = null;
    }
    paramContext = sOnStopCallback;
    if (paramContext != null) {
      paramContext.onStop();
    }
  }
  
  private static boolean isFromQQXMAN(int paramInt, String paramString)
  {
    return (paramInt == 2093) || ("2016_4".equals(paramString));
  }
  
  public static void registerActivityOnStopCallback(GameGrowthGuardianManager.OnStopCallback paramOnStopCallback)
  {
    sOnStopCallback = paramOnStopCallback;
  }
  
  private static void reportInstructionExecuteResult(MiniAppInfo paramMiniAppInfo, INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp, INTERFACE.GuardInstruction paramGuardInstruction)
  {
    if (paramMiniAppInfo != null)
    {
      if (paramStJudgeTimingRsp == null) {
        return;
      }
      if ((paramGuardInstruction != null) && (paramGuardInstruction.type.get() == 7)) {
        paramStJudgeTimingRsp = paramStJudgeTimingRsp.loginTraceId.get();
      } else {
        paramStJudgeTimingRsp = paramStJudgeTimingRsp.timingTraceId.get();
      }
      ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      String str = paramMiniAppInfo.appId;
      int i = (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
      if (paramGuardInstruction != null) {
        paramMiniAppInfo = paramGuardInstruction.ruleName.get();
      } else {
        paramMiniAppInfo = "";
      }
      localChannelProxy.reportExecute(str, i, paramStJudgeTimingRsp, paramMiniAppInfo, new GameGrowthGuardianManager.3());
    }
  }
  
  private static INTERFACE.StJudgeTimingRsp testForIncomeTips()
  {
    INTERFACE.GuardInstruction localGuardInstruction = new INTERFACE.GuardInstruction();
    localGuardInstruction.type.set(6);
    localGuardInstruction.ruleName.set("INCOME_TIPS");
    localGuardInstruction.title.set("Test Income Tips dialog title");
    localGuardInstruction.msg.set("Test Income dialog message");
    INTERFACE.StJudgeTimingRsp localStJudgeTimingRsp = new INTERFACE.StJudgeTimingRsp();
    localStJudgeTimingRsp.nextDuration.set(30);
    localStJudgeTimingRsp.timingTraceId.set(UUID.randomUUID().toString());
    localStJudgeTimingRsp.timingInstructions.add(localGuardInstruction);
    return localStJudgeTimingRsp;
  }
  
  private static INTERFACE.StJudgeTimingRsp testForLogoutDialog()
  {
    INTERFACE.GuardInstruction localGuardInstruction = new INTERFACE.GuardInstruction();
    localGuardInstruction.type.set(2);
    localGuardInstruction.title.set("Logout dialog title");
    localGuardInstruction.msg.set("Logout dialog message");
    localGuardInstruction.ruleName.set("LOGOUT");
    INTERFACE.StJudgeTimingRsp localStJudgeTimingRsp = new INTERFACE.StJudgeTimingRsp();
    localStJudgeTimingRsp.timingTraceId.set(UUID.randomUUID().toString());
    localStJudgeTimingRsp.nextDuration.set(60);
    localStJudgeTimingRsp.timingInstructions.add(localGuardInstruction);
    return localStJudgeTimingRsp;
  }
  
  private static INTERFACE.StJudgeTimingRsp testForMultipleInstructions()
  {
    INTERFACE.GuardInstruction localGuardInstruction1 = new INTERFACE.GuardInstruction();
    localGuardInstruction1.type.set(1);
    localGuardInstruction1.title.set("First instruction dialog title");
    localGuardInstruction1.msg.set("First instruction dialog message");
    localGuardInstruction1.ruleName.set("FIRST");
    INTERFACE.GuardInstruction localGuardInstruction2 = new INTERFACE.GuardInstruction();
    localGuardInstruction2.type.set(3);
    localGuardInstruction2.title.set("Second instruction dialog title");
    localGuardInstruction2.msg.set("Second instruction dialog message");
    localGuardInstruction2.url.set("https://www.qq.com");
    localGuardInstruction2.ruleName.set("SECOND");
    INTERFACE.StJudgeTimingRsp localStJudgeTimingRsp = new INTERFACE.StJudgeTimingRsp();
    localStJudgeTimingRsp.timingTraceId.set(UUID.randomUUID().toString());
    localStJudgeTimingRsp.nextDuration.set(30);
    localStJudgeTimingRsp.timingInstructions.add(localGuardInstruction1);
    localStJudgeTimingRsp.timingInstructions.add(localGuardInstruction2);
    return localStJudgeTimingRsp;
  }
  
  private static INTERFACE.StJudgeTimingRsp testForOpenUrlDialog()
  {
    INTERFACE.GuardInstruction localGuardInstruction = new INTERFACE.GuardInstruction();
    localGuardInstruction.type.set(3);
    localGuardInstruction.title.set("Test OpenUrl dialog title");
    localGuardInstruction.msg.set("Test OpenUrl dialog message");
    localGuardInstruction.url.set("https://www.qq.com");
    localGuardInstruction.ruleName.set("OPENURL");
    INTERFACE.StJudgeTimingRsp localStJudgeTimingRsp = new INTERFACE.StJudgeTimingRsp();
    localStJudgeTimingRsp.timingTraceId.set(UUID.randomUUID().toString());
    localStJudgeTimingRsp.nextDuration.set(180);
    localStJudgeTimingRsp.timingInstructions.add(localGuardInstruction);
    return localStJudgeTimingRsp;
  }
  
  private static INTERFACE.StJudgeTimingRsp testForRealNameAuthentication()
  {
    Object localObject = new INTERFACE.GuardInstruction();
    ((INTERFACE.GuardInstruction)localObject).type.set(7);
    ((INTERFACE.GuardInstruction)localObject).title.set("Real name dialog title");
    ((INTERFACE.GuardInstruction)localObject).msg.set("Real name dialog message");
    ((INTERFACE.GuardInstruction)localObject).url.set("https://www.qq.com");
    ((INTERFACE.GuardInstruction)localObject).ruleName.set("REALNAME");
    INTERFACE.StJudgeTimingRsp localStJudgeTimingRsp = new INTERFACE.StJudgeTimingRsp();
    localStJudgeTimingRsp.loginInstructions.add((MessageMicro)localObject);
    localStJudgeTimingRsp.loginTraceId.set(UUID.randomUUID().toString());
    localStJudgeTimingRsp.nextDuration.set(120);
    if (!localStJudgeTimingRsp.loginInstructions.isEmpty())
    {
      localObject = localStJudgeTimingRsp.loginInstructions.get().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((INTERFACE.GuardInstruction)((Iterator)localObject).next()).type.set(7);
      }
      localStJudgeTimingRsp.timingInstructions.get().addAll(0, localStJudgeTimingRsp.loginInstructions.get());
    }
    return localStJudgeTimingRsp;
  }
  
  private static INTERFACE.StJudgeTimingRsp testForTipsDialog()
  {
    INTERFACE.GuardInstruction localGuardInstruction = new INTERFACE.GuardInstruction();
    localGuardInstruction.type.set(1);
    localGuardInstruction.title.set("Tips dialog title");
    localGuardInstruction.msg.set("Tips dialog message");
    localGuardInstruction.ruleName.set("TIPS");
    INTERFACE.StJudgeTimingRsp localStJudgeTimingRsp = new INTERFACE.StJudgeTimingRsp();
    localStJudgeTimingRsp.timingTraceId.set(UUID.randomUUID().toString());
    localStJudgeTimingRsp.nextDuration.set(120);
    localStJudgeTimingRsp.timingInstructions.add(localGuardInstruction);
    return localStJudgeTimingRsp;
  }
  
  public static void unregisterActivityOnStopCallback()
  {
    sOnStopCallback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager
 * JD-Core Version:    0.7.0.1
 */