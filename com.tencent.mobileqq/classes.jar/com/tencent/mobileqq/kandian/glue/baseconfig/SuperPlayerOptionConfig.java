package com.tencent.mobileqq.kandian.glue.baseconfig;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.base.video.player.config.ISuperPlayerOptionConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.tmediacodec.util.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/baseconfig/SuperPlayerOptionConfig;", "Lcom/tencent/mobileqq/kandian/base/video/player/config/ISuperPlayerOptionConfig;", "()V", "config", "", "option", "Lcom/tencent/superplayer/api/SuperPlayerOption;", "configTMediaCodec", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SuperPlayerOptionConfig
  implements ISuperPlayerOptionConfig
{
  private final void b(SuperPlayerOption paramSuperPlayerOption)
  {
    LogUtils.setLogEnable(QLog.isColorLevel());
  }
  
  public void a(@NotNull SuperPlayerOption paramSuperPlayerOption)
  {
    Intrinsics.checkParameterIsNotNull(paramSuperPlayerOption, "option");
    Object localObject = Aladdin.getConfig(357);
    boolean bool2 = false;
    paramSuperPlayerOption.bufferPacketMinTotalDurationMs = ((AladdinConfig)localObject).getIntegerFromString("bufferPacketMinTotalDurationMs", 0);
    paramSuperPlayerOption.preloadPacketDurationMs = ((AladdinConfig)localObject).getIntegerFromString("preloadPacketDurationMs", 0);
    paramSuperPlayerOption.minBufferingPacketDurationMs = ((AladdinConfig)localObject).getIntegerFromString("minBufferingPacketDurationMs", 0);
    localObject = paramSuperPlayerOption.superPlayerDownOption;
    if (Aladdin.getConfig(392).getIntegerFromString("enable_p2p", 0) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((SuperPlayerDownOption)localObject).enableP2P = bool1;
    localObject = paramSuperPlayerOption.superPlayerDownOption;
    boolean bool1 = bool2;
    if (Aladdin.getConfig(392).getIntegerFromString("enable_pcdn", 0) == 1) {
      bool1 = true;
    }
    ((SuperPlayerDownOption)localObject).enablePcdn = bool1;
    paramSuperPlayerOption.accurateSeekOnOpen = true;
    b(paramSuperPlayerOption);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.baseconfig.SuperPlayerOptionConfig
 * JD-Core Version:    0.7.0.1
 */