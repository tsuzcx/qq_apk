package com.tencent.mobileqq.kandian.glue.baseconfig;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.base.bandwidth.BandwidthMonitor;
import com.tencent.mobileqq.kandian.base.video.player.config.ISuperPlayerOptionConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.tmediacodec.TCodecManager;
import com.tencent.tmediacodec.util.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/baseconfig/SuperPlayerOptionConfig;", "Lcom/tencent/mobileqq/kandian/base/video/player/config/ISuperPlayerOptionConfig;", "()V", "config", "", "option", "Lcom/tencent/superplayer/api/SuperPlayerOption;", "isAD", "", "configTMediaCodec", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SuperPlayerOptionConfig
  implements ISuperPlayerOptionConfig
{
  private final void a(SuperPlayerOption paramSuperPlayerOption)
  {
    LogUtils.setLogEnable(QLog.isColorLevel());
    paramSuperPlayerOption = Aladdin.getConfig(490);
    boolean bool2 = true;
    boolean bool1;
    if (paramSuperPlayerOption.getIntegerFromString("leakfixed", 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    TCodecManager.setLeakFixed(bool1);
    if (Aladdin.getConfig(490).getIntegerFromString("forceCodecRelease", 1) == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder.forceRelease = bool1;
  }
  
  public void a(@NotNull SuperPlayerOption paramSuperPlayerOption, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramSuperPlayerOption, "option");
    Object localObject = Aladdin.getConfig(357);
    paramSuperPlayerOption.bufferPacketMinTotalDurationMs = ((AladdinConfig)localObject).getIntegerFromString("bufferPacketMinTotalDurationMs", 0);
    paramSuperPlayerOption.preloadPacketDurationMs = ((AladdinConfig)localObject).getIntegerFromString("preloadPacketDurationMs", 0);
    paramSuperPlayerOption.minBufferingPacketDurationMs = ((AladdinConfig)localObject).getIntegerFromString("minBufferingPacketDurationMs", 0);
    localObject = paramSuperPlayerOption.superPlayerDownOption;
    boolean bool;
    if (Aladdin.getConfig(392).getIntegerFromString("enable_p2p", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((SuperPlayerDownOption)localObject).enableP2P = bool;
    localObject = paramSuperPlayerOption.superPlayerDownOption;
    if (Aladdin.getConfig(392).getIntegerFromString("enable_pcdn", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((SuperPlayerDownOption)localObject).enablePcdn = bool;
    if ((paramBoolean) && (Aladdin.getConfig(392).getIntegerFromString("ad_force_close_pcdn", 0) == 1)) {
      paramSuperPlayerOption.superPlayerDownOption.enablePcdn = false;
    }
    paramSuperPlayerOption.accurateSeekOnOpen = true;
    paramSuperPlayerOption.enableListenerPlayerBuffer = Aladdin.getConfig(422).getBooleanFromString("enableListenerPlayerBuffer", false);
    if (paramBoolean) {
      paramSuperPlayerOption.enableBandwidthStats = BandwidthMonitor.INSTANCE.isADEnable();
    } else {
      paramSuperPlayerOption.enableBandwidthStats = BandwidthMonitor.INSTANCE.getEnable();
    }
    a(paramSuperPlayerOption);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.baseconfig.SuperPlayerOptionConfig
 * JD-Core Version:    0.7.0.1
 */