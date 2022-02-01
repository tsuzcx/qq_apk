package com.tencent.mobileqq.minigame.manager;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingReq;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import NS_MINI_INTERFACE.INTERFACE.StReportExecuteReq;
import NS_MINI_INTERFACE.INTERFACE.StReportExecuteRsp;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

public class GameGrowthGuardianManager
{
  private static final String ENABLE_HEART_BEAT_APPID_WHITELIST = QzoneConfig.getInstance().getConfig("qqminiapp", "enable_heart_beat_appid_whitelist", "");
  private static final String ENABLE_HEART_BEAT_SCENE_WHITELIST;
  private static final String ENABLE_HEART_BEAT_VIA_WHITELIST = QzoneConfig.getInstance().getConfig("qqminiapp", "enable_heart_beat_via_whitelist", "");
  private static final int GUARD_INSTRUCTION_TYPE_REAL_NAME_AUTHENTICATE = 7;
  private static final int JUDGE_TIMING_REQUEST_BEGIN_DELAY = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_judge_timing_request_begin_delay", 1000);
  private static final int JUDGE_TIMING_REQUEST_FACT_TYPE_BEGIN = 11;
  private static final int JUDGE_TIMING_REQUEST_FACT_TYPE_END = 13;
  private static final int JUDGE_TIMING_REQUEST_FACT_TYPE_HEARTBEAT = 12;
  private static final String TAG = "GameGrowthGuardianManag";
  private static long beginExecuteMillis;
  private static Runnable heartBeatRunnable;
  private static boolean isForeground;
  private static COMM.StCommonExt previousExtInfo;
  
  static
  {
    ENABLE_HEART_BEAT_SCENE_WHITELIST = QzoneConfig.getInstance().getConfig("qqminiapp", "enable_heart_beat_scene_whitelist", "");
  }
  
  private static boolean enableHeartBeatCheck(MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig != null)
    {
      if (paramMiniAppConfig.isEngineTypeMiniGame()) {}
      while ((!paramMiniAppConfig.isEngineTypeMiniGame()) && (enableHeartBeatForMiniApp(paramMiniAppConfig))) {
        return true;
      }
      return false;
    }
    return false;
  }
  
  private static boolean enableHeartBeatForMiniApp(MiniAppConfig paramMiniAppConfig)
  {
    boolean bool2 = false;
    if (paramMiniAppConfig != null) {}
    for (;;)
    {
      int j;
      try
      {
        if (paramMiniAppConfig.launchParam == null) {
          break label284;
        }
        i = paramMiniAppConfig.launchParam.scene;
        if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null))
        {
          str1 = paramMiniAppConfig.config.via;
          if ((i == 2093) || ("2016_4".equals(str1))) {
            break label291;
          }
          if (!TextUtils.isEmpty(ENABLE_HEART_BEAT_SCENE_WHITELIST))
          {
            arrayOfString = ENABLE_HEART_BEAT_SCENE_WHITELIST.split(",");
            if (arrayOfString != null)
            {
              int k = arrayOfString.length;
              j = 0;
              if (j < k)
              {
                if (i != Integer.parseInt(arrayOfString[j])) {
                  break label297;
                }
                return true;
              }
            }
          }
          if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (paramMiniAppConfig.config.appId != null) && (!TextUtils.isEmpty(ENABLE_HEART_BEAT_APPID_WHITELIST)))
          {
            arrayOfString = ENABLE_HEART_BEAT_APPID_WHITELIST.split(",");
            if (arrayOfString != null)
            {
              j = arrayOfString.length;
              i = 0;
              if (i < j)
              {
                String str2 = arrayOfString[i];
                if (!paramMiniAppConfig.config.appId.equals(str2)) {
                  break label304;
                }
                return true;
              }
            }
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(ENABLE_HEART_BEAT_VIA_WHITELIST)) {
            break label294;
          }
          paramMiniAppConfig = ENABLE_HEART_BEAT_VIA_WHITELIST.split(",");
          bool1 = bool2;
          if (paramMiniAppConfig == null) {
            break label294;
          }
          j = paramMiniAppConfig.length;
          i = 0;
          bool1 = bool2;
          if (i >= j) {
            break label294;
          }
          String[] arrayOfString = paramMiniAppConfig[i];
          if (arrayOfString != null)
          {
            bool1 = arrayOfString.equals(str1);
            if (bool1) {
              return true;
            }
          }
          i += 1;
          continue;
        }
        String str1 = null;
      }
      catch (Exception paramMiniAppConfig)
      {
        QLog.e("GameGrowthGuardianManag", 1, "enableHeartBeatForLaunchScene", paramMiniAppConfig);
        return false;
      }
      continue;
      label284:
      int i = 9999;
      continue;
      label291:
      boolean bool1 = true;
      label294:
      return bool1;
      label297:
      j += 1;
      continue;
      label304:
      i += 1;
    }
  }
  
  private static void execute(Context paramContext, MiniAppConfig paramMiniAppConfig, @GameGrowthGuardianManager.JudgeTimingRequestFactType int paramInt)
  {
    int j = 0;
    if ((paramContext == null) || (paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {}
    do
    {
      return;
      if ((!isForeground) && ((paramInt == 11) || (paramInt == 12)))
      {
        QLog.e("GameGrowthGuardianManag", 1, "not in foreground, not allowed to send begin or heartbeat protocol");
        return;
      }
    } while (!enableHeartBeatCheck(paramMiniAppConfig));
    GameRuntimeLoader localGameRuntimeLoader = GameRuntimeLoaderManager.g().getBindRuntimeLoader(paramContext);
    Object localObject2 = MiniProgramReportHelper.launchIdForMiniAppConfig(paramMiniAppConfig);
    INTERFACE.StJudgeTimingReq localStJudgeTimingReq = new INTERFACE.StJudgeTimingReq();
    PBStringField localPBStringField = localStJudgeTimingReq.appid;
    int i;
    if ((paramMiniAppConfig.config != null) && (paramMiniAppConfig.config.appId != null))
    {
      localObject1 = paramMiniAppConfig.config.appId;
      localPBStringField.set((String)localObject1);
      localObject1 = localStJudgeTimingReq.appType;
      if (!paramMiniAppConfig.isEngineTypeMiniGame()) {
        break label432;
      }
      i = 1;
      label133:
      ((PBInt32Field)localObject1).set(i);
      localObject1 = localStJudgeTimingReq.scene;
      if (paramMiniAppConfig.launchParam == null) {
        break label437;
      }
      i = paramMiniAppConfig.launchParam.scene;
      label161:
      ((PBInt32Field)localObject1).set(i);
      localStJudgeTimingReq.factType.set(paramInt);
      localStJudgeTimingReq.reportTime.set(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
      if ((paramMiniAppConfig.launchParam != null) && (paramMiniAppConfig.launchParam.entryModel != null) && (1 == paramMiniAppConfig.launchParam.entryModel.type)) {
        localStJudgeTimingReq.sourceID.set(String.valueOf(paramMiniAppConfig.launchParam.entryModel.uin));
      }
      if (previousExtInfo != null) {
        localStJudgeTimingReq.extInfo.set(previousExtInfo);
      }
      if (paramInt != 11) {
        break label442;
      }
      localStJudgeTimingReq.totalTime.set(0);
      label277:
      localPBStringField = localStJudgeTimingReq.launchId;
      if (localObject2 == null) {
        break label467;
      }
      localObject1 = localObject2;
      label293:
      localPBStringField.set((String)localObject1);
      localStJudgeTimingReq.afterCertify.set(0);
      localObject2 = localStJudgeTimingReq.via;
      if ((paramMiniAppConfig.config == null) || (paramMiniAppConfig.config.via == null)) {
        break label474;
      }
    }
    label432:
    label437:
    label442:
    label467:
    label474:
    for (Object localObject1 = paramMiniAppConfig.config.via;; localObject1 = "")
    {
      ((PBStringField)localObject2).set((String)localObject1);
      localObject1 = localStJudgeTimingReq.AdsTotalTime;
      i = j;
      if (localGameRuntimeLoader != null)
      {
        i = j;
        if (localGameRuntimeLoader.getGameInfoManager().getMiniAppConfig() != null) {
          i = localGameRuntimeLoader.getGameInfoManager().getMiniAppConfig().gameAdsTotalTime;
        }
      }
      ((PBInt32Field)localObject1).set(i);
      MiniAppSSOCmdHelper.sendSSOCmdRequest("LightAppSvc.mini_app_growguard.JudgeTiming", paramMiniAppConfig.config.appId, localStJudgeTimingReq, INTERFACE.StJudgeTimingRsp.class, new GameGrowthGuardianManager.2(paramMiniAppConfig, paramContext, paramInt));
      return;
      localObject1 = "";
      break;
      i = 0;
      break label133;
      i = 0;
      break label161;
      localStJudgeTimingReq.totalTime.set((int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - beginExecuteMillis));
      break label277;
      localObject1 = "";
      break label293;
    }
  }
  
  public static void executeBegin(Context paramContext, MiniAppConfig paramMiniAppConfig)
  {
    isForeground = true;
    ThreadManagerV2.getUIHandlerV2().post(new GameGrowthGuardianManager.1(paramContext, paramMiniAppConfig));
  }
  
  public static void executeEnd(Context paramContext, MiniAppConfig paramMiniAppConfig)
  {
    isForeground = false;
    execute(paramContext, paramMiniAppConfig, 13);
    if (heartBeatRunnable != null)
    {
      ThreadManagerV2.getUIHandlerV2().removeCallbacks(heartBeatRunnable);
      heartBeatRunnable = null;
    }
  }
  
  private static void reportInstructionExecuteResult(MiniAppConfig paramMiniAppConfig, INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp, INTERFACE.GuardInstruction paramGuardInstruction)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config != null) || (paramStJudgeTimingRsp == null)) {
      return;
    }
    INTERFACE.StReportExecuteReq localStReportExecuteReq = new INTERFACE.StReportExecuteReq();
    localStReportExecuteReq.execTime.set((int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
    localStReportExecuteReq.appid.set(paramMiniAppConfig.config.appId);
    PBStringField localPBStringField;
    if ((paramGuardInstruction != null) && (paramGuardInstruction.type.get() == 7))
    {
      localStReportExecuteReq.instrTraceId.set(paramStJudgeTimingRsp.loginTraceId.get());
      localPBStringField = localStReportExecuteReq.ruleName;
      if (paramGuardInstruction == null) {
        break label151;
      }
    }
    label151:
    for (paramStJudgeTimingRsp = paramGuardInstruction.ruleName.get();; paramStJudgeTimingRsp = "")
    {
      localPBStringField.set(paramStJudgeTimingRsp);
      MiniAppSSOCmdHelper.sendSSOCmdRequest("LightAppSvc.mini_app_growguard.ReportExecute", paramMiniAppConfig.config.appId, localStReportExecuteReq, INTERFACE.StReportExecuteRsp.class, new GameGrowthGuardianManager.3());
      return;
      localStReportExecuteReq.instrTraceId.set(paramStJudgeTimingRsp.timingTraceId.get());
      break;
    }
  }
  
  @NotNull
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
  
  @NotNull
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
  
  @NotNull
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
  
  @NotNull
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
  
  @NotNull
  private static INTERFACE.StJudgeTimingRsp testForRealNameAuthentication()
  {
    INTERFACE.StJudgeTimingRsp localStJudgeTimingRsp = new INTERFACE.StJudgeTimingRsp();
    Object localObject = new INTERFACE.GuardInstruction();
    ((INTERFACE.GuardInstruction)localObject).type.set(7);
    ((INTERFACE.GuardInstruction)localObject).title.set("Real name dialog title");
    ((INTERFACE.GuardInstruction)localObject).msg.set("Real name dialog message");
    ((INTERFACE.GuardInstruction)localObject).url.set("https://www.qq.com");
    ((INTERFACE.GuardInstruction)localObject).ruleName.set("REALNAME");
    localStJudgeTimingRsp.loginInstructions.add((MessageMicro)localObject);
    localStJudgeTimingRsp.loginTraceId.set(UUID.randomUUID().toString());
    localStJudgeTimingRsp.nextDuration.set(120);
    if ((localStJudgeTimingRsp != null) && (!localStJudgeTimingRsp.loginInstructions.isEmpty()))
    {
      localObject = localStJudgeTimingRsp.loginInstructions.get().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((INTERFACE.GuardInstruction)((Iterator)localObject).next()).type.set(7);
      }
      localStJudgeTimingRsp.timingInstructions.get().addAll(0, localStJudgeTimingRsp.loginInstructions.get());
    }
    return localStJudgeTimingRsp;
  }
  
  @NotNull
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager
 * JD-Core Version:    0.7.0.1
 */