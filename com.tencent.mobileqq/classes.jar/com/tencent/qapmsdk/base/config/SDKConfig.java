package com.tencent.qapmsdk.base.config;

import com.tencent.qapmsdk.base.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/SDKConfig;", "", "()V", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class SDKConfig
{
  public static final SDKConfig.Companion Companion = new SDKConfig.Companion(null);
  private static int MAX_AUSTERITY_REPORT_NUM = 100;
  private static int MAX_LOOSE_REPORT_NUM = 100;
  @JvmField
  public static final boolean PURE_QAPM = BuildConfig.SPECIAL_MODE.booleanValue() ^ true;
  @JvmField
  public static int RES_TYPE = 2;
  @NotNull
  public static final String SDK_VER = "4.0.2.3.2021062111-PCG";
  private static float USER_SAMPLE_RATIO = 1.0F;
  private static int VER_TYPE;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.config.SDKConfig
 * JD-Core Version:    0.7.0.1
 */