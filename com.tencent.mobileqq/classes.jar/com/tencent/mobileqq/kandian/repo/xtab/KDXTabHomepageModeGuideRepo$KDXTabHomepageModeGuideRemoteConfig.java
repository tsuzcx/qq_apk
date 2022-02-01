package com.tencent.mobileqq.kandian.repo.xtab;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/xtab/KDXTabHomepageModeGuideRepo$KDXTabHomepageModeGuideRemoteConfig;", "", "()V", "duration", "", "getDuration", "()I", "enable", "", "getEnable", "()Z", "guideText", "", "getGuideText", "()Ljava/lang/String;", "jumpUrl", "getJumpUrl", "timestamp", "", "getTimestamp", "()J", "isValid", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KDXTabHomepageModeGuideRepo$KDXTabHomepageModeGuideRemoteConfig
{
  public final boolean a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(534);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("feeds_style_guide_switch", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public final int b()
  {
    return Aladdin.getConfig(534).getIntegerFromString("feeds_style_guide_duration", 10);
  }
  
  public final long c()
  {
    return Aladdin.getConfig(534).getLongFromString("feeds_style_guide_timestamp", -1L);
  }
  
  @NotNull
  public final String d()
  {
    String str = Aladdin.getConfig(534).getString("feeds_style_guide_text", "点击切换「广场」样式");
    Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(CONFIG…uide_text\", \"点击切换「广场」样式\")");
    return str;
  }
  
  @NotNull
  public final String e()
  {
    String str = URLDecoder.decode(Aladdin.getConfig(534).getString("feeds_style_guide_settingUrl", ""), "UTF-8");
    Intrinsics.checkExpressionValueIsNotNull(str, "URLDecoder.decode(encodedJumpUrl, \"UTF-8\")");
    return str;
  }
  
  public final boolean f()
  {
    return (c() != -1L) && ((StringsKt.isBlank((CharSequence)d()) ^ true)) && ((StringsKt.isBlank((CharSequence)e()) ^ true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.xtab.KDXTabHomepageModeGuideRepo.KDXTabHomepageModeGuideRemoteConfig
 * JD-Core Version:    0.7.0.1
 */