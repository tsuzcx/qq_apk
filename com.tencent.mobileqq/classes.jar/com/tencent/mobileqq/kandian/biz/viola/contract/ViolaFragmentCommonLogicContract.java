package com.tencent.mobileqq.kandian.biz.viola.contract;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.playfeeds.MultiVideoHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.glue.video.VideoResumeManager;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.aladdin.config.QQAladdinUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.MultiVideoConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.VDynamicConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJBarrageConfigSp;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJViolaSusAutoPlayConfigSp;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.viola.utils.ViolaUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/contract/ViolaFragmentCommonLogicContract;", "Lcom/tencent/mobileqq/kandian/biz/viola/contract/IViolaFragmentCommonContract;", "()V", "pageName", "", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "scene", "initPageName", "", "url", "needAddVideoConfig", "", "param", "Lorg/json/JSONObject;", "onScrollStateChange", "state", "", "openFrameDropUpload", "tryAddVideoConfig", "paramJSON", "tryInitAladdin", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaFragmentCommonLogicContract
  implements IViolaFragmentCommonContract
{
  private String a;
  @NotNull
  private String b = "";
  
  private final boolean b(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.opt("need_add_aladdin_config");
    } else {
      paramJSONObject = null;
    }
    return Intrinsics.areEqual(paramJSONObject, Boolean.valueOf(true));
  }
  
  @NotNull
  public final String a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    String str = this.a;
    if (str != null)
    {
      if (paramInt == 0)
      {
        DropFrameMonitor.b().a(str, false);
        return;
      }
      DropFrameMonitor.b().a(str);
    }
  }
  
  public final void a(@Nullable String paramString)
  {
    if (paramString != null)
    {
      paramString = ViolaUtils.getPageName(paramString);
      if (paramString != null) {
        this.b = paramString;
      }
    }
  }
  
  public final void a(@Nullable JSONObject paramJSONObject)
  {
    if ((b(paramJSONObject)) && (paramJSONObject != null))
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("stickySpeed", MultiVideoConfigHandler.a());
      localJSONObject.put("maskLighteness", MultiVideoConfigHandler.c());
      localJSONObject.put("topBarTitle", MultiVideoConfigHandler.b());
      localJSONObject.put("autoPlayForLockScreen", Aladdin.getConfig(271).getIntegerFromString("auto_play", 1));
      localJSONObject.put("videoRewardConfig", MultiVideoHelper.a(372));
      localJSONObject.put("rewardPrivilegeConfig", RIJUserLevelModule.getInstance().getCacheUserLevel(5));
      localJSONObject.put("barrageConfig", RIJBarrageConfigSp.a());
      localJSONObject.put("videoBarrageConfig", RIJBarrageConfigSp.c());
      localJSONObject.put("resumeEnable", VideoResumeManager.a.a());
      localJSONObject.put("interactAreaConfig", MultiVideoHelper.a(154));
      localJSONObject.put("dynamicVersionALDConfig", MultiVideoHelper.a(346));
      MultiVideoHelper.a(localJSONObject);
      localJSONObject.put("sanlianSwitch", MultiVideoHelper.b());
      paramJSONObject.put("aladingConfig", localJSONObject);
      localJSONObject = paramJSONObject.optJSONObject("reportConfig");
      if (localJSONObject != null)
      {
        localJSONObject.put("kandian_mode_new", VideoReporter.c());
        localJSONObject.put("kandian_mode", RIJAppSetting.b());
      }
      paramJSONObject.put("dynamicAladdinConfig", VDynamicConfigHandler.c());
      paramJSONObject.put("xgAladdinConfig", VDynamicConfigHandler.b());
      paramJSONObject.put("protocolExtralParam", MultiVideoHelper.c());
      paramJSONObject.put("autoPlayDisable", RIJViolaSusAutoPlayConfigSp.a());
      paramJSONObject.put("userHeadUrl", MultiVideoHelper.d());
      paramJSONObject.remove("need_add_aladdin_config");
    }
  }
  
  public final void b()
  {
    if (!QQAladdinUtils.b) {
      QQAladdinUtils.a();
    }
  }
  
  public void openFrameDropUpload(@Nullable String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.contract.ViolaFragmentCommonLogicContract
 * JD-Core Version:    0.7.0.1
 */