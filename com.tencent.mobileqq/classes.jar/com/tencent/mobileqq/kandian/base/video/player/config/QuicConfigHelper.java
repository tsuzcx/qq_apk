package com.tencent.mobileqq.kandian.base.video.player.config;

import com.tencent.thumbplayer.api.TPPlayerMsg.TPProtocolInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/config/QuicConfigHelper;", "", "()V", "hasUseQuic", "", "getHasUseQuic", "()Z", "setHasUseQuic", "(Z)V", "nowProto", "", "getNowProto", "()Ljava/lang/String;", "setNowProto", "(Ljava/lang/String;)V", "quicEnable", "getQuicEnable", "setQuicEnable", "getProtoDebugInfo", "updateProtocol", "", "protocolInfo", "Lcom/tencent/thumbplayer/api/TPPlayerMsg$TPProtocolInfo;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class QuicConfigHelper
{
  public static final QuicConfigHelper.Companion a;
  @NotNull
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerConfigQuicConfigHelper$Companion = new QuicConfigHelper.Companion(null);
  }
  
  public final void a(@NotNull TPPlayerMsg.TPProtocolInfo paramTPProtocolInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTPProtocolInfo, "protocolInfo");
    paramTPProtocolInfo = paramTPProtocolInfo.protocolName;
    Intrinsics.checkExpressionValueIsNotNull(paramTPProtocolInfo, "protocolInfo.protocolName");
    this.jdField_a_of_type_JavaLangString = paramTPProtocolInfo;
    if (Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, "quic")) {
      this.b = true;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.config.QuicConfigHelper
 * JD-Core Version:    0.7.0.1
 */