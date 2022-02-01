package com.tencent.mobileqq.kandian.glue.baseconfig;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.base.bandwidth.BandWidthConfig;
import com.tencent.mobileqq.kandian.base.bandwidth.BandWidthConfig.PreloadStrategy;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.config.ISuperPlayerOptionConfig;
import com.tencent.mobileqq.kandian.base.video.player.config.QuicConfig;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJVideoSdkConfigSp;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/baseconfig/VideoConfig;", "Lcom/tencent/mobileqq/kandian/glue/baseconfig/IConfig;", "()V", "CONFIG_KEY_VIDEO_LOCALDNS_BLACK_DOMAIN_LIST", "", "CONFIG_KEY_VIDEO_LOCALDNS_ENABLE", "getVideoLocalDnsBlackDomainList", "", "initConfig", "", "isVideoLocalDnsEnable", "", "updateConfig", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoConfig
  implements IConfig
{
  public static final VideoConfig a = new VideoConfig();
  
  private final Set<String> c()
  {
    Object localObject1 = Aladdin.getConfig(314);
    HashSet localHashSet = new HashSet();
    if (localObject1 != null)
    {
      Object localObject2 = ((AladdinConfig)localObject1).getString("video_localdns_black_domain_list", "");
      localObject1 = (Collection)localHashSet;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "value");
      localObject2 = (CharSequence)localObject2;
      localObject2 = ((Collection)new Regex("|").split((CharSequence)localObject2, 0)).toArray(new String[0]);
      if (localObject2 != null)
      {
        localObject2 = (String[])localObject2;
        Collections.addAll((Collection)localObject1, (String[])Arrays.copyOf((Object[])localObject2, localObject2.length));
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getVideoLocalDnsBlackDomainList(), result = ");
      ((StringBuilder)localObject1).append(localHashSet);
      QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, ((StringBuilder)localObject1).toString());
    }
    return (Set)localHashSet;
  }
  
  private final boolean d()
  {
    Object localObject = Aladdin.getConfig(314);
    int i;
    if (localObject != null)
    {
      int j = ((AladdinConfig)localObject).getIntegerFromString("video_localdns_enable", 1);
      i = j;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isVideoLocalDnsEnable(), value = ");
        ((StringBuilder)localObject).append(j);
        QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, ((StringBuilder)localObject).toString());
        i = j;
      }
    }
    else
    {
      i = 1;
    }
    return i == 1;
  }
  
  public void a() {}
  
  public void b()
  {
    ThirdVideoManager.a().a(d(), c());
    VideoPlayerWrapper.a((ISuperPlayerOptionConfig)new SuperPlayerOptionConfig());
    VideoPlayerWrapper.c(RIJVideoSdkConfigSp.a());
    VideoPlayerWrapper.j(VideoVolumeControl.getInstance().shouldMute());
    BandWidthConfig.a.a(Aladdin.getConfig(288).getString("buffer_range_report_tag", ""));
    BandWidthConfig.a.a(Aladdin.getConfig(230).getIntegerFromString("reset_time_threshold_wifi", 3600));
    BandWidthConfig.a.b(Aladdin.getConfig(230).getIntegerFromString("reset_time_threshold_xg", 600));
    BandWidthConfig.a.c(RIJVideoSdkConfigSp.a());
    BandWidthConfig.a.a((BandWidthConfig.PreloadStrategy)new VideoConfig.updateConfig.1());
    BandWidthConfig.a.a(Aladdin.getConfig(298).getFloatFromString("bitrate_weight", 2.0F));
    BandWidthConfig.a.d(Aladdin.getConfig(298).getIntegerFromString("idle_bandwith_threshold", 1500));
    BandWidthConfig.a.e(Aladdin.getConfig(298).getIntegerFromString("default_predownload_count", 4));
    BandWidthConfig.a.f(Aladdin.getConfig(298).getIntegerFromString("max_predownload_count", 4));
    QuicConfig.a.a(Aladdin.getConfig(395).getIntegerFromString("wifi_enable_quic", 0));
    QuicConfig.a.b(Aladdin.getConfig(395).getIntegerFromString("xg_enable_quic", 0));
    QuicConfig localQuicConfig = QuicConfig.a;
    int i = Aladdin.getConfig(395).getIntegerFromString("enable_plain_text", 0);
    boolean bool2 = true;
    boolean bool1;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localQuicConfig.a(bool1);
    localQuicConfig = QuicConfig.a;
    if (Aladdin.getConfig(395).getIntegerFromString("enable_connection_migration", 0) == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localQuicConfig.b(bool1);
    QuicConfig.a.c(Aladdin.getConfig(395).getIntegerFromString("quic_congestion_type", 0));
    localQuicConfig = QuicConfig.a;
    String str = Aladdin.getConfig(395).getString("quic_host_list", "");
    Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…ing(\"quic_host_list\", \"\")");
    localQuicConfig.a(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.baseconfig.VideoConfig
 * JD-Core Version:    0.7.0.1
 */