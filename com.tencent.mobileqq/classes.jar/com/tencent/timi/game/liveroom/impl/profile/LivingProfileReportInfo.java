package com.tencent.timi.game.liveroom.impl.profile;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/profile/LivingProfileReportInfo;", "", "pageId", "", "elementId", "paramMap", "", "equipStatus", "pageParamMap", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;)V", "getElementId", "()Ljava/lang/String;", "setElementId", "(Ljava/lang/String;)V", "getEquipStatus", "setEquipStatus", "getPageId", "setPageId", "pageParam", "getPageParam", "()Ljava/util/Map;", "setPageParam", "(Ljava/util/Map;)V", "getParamMap", "setParamMap", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingProfileReportInfo
{
  @NotNull
  private String a;
  @NotNull
  private String b;
  @NotNull
  private Map<String, String> c;
  @NotNull
  private String d = "";
  @NotNull
  private Map<String, String> e;
  
  public LivingProfileReportInfo(@NotNull String paramString1, @NotNull String paramString2, @NotNull Map<String, String> paramMap1, @NotNull String paramString3, @NotNull Map<String, String> paramMap2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramMap1;
    this.d = paramString3;
    this.e = paramMap2;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public final Map<String, String> c()
  {
    return this.c;
  }
  
  @NotNull
  public final String d()
  {
    return this.d;
  }
  
  @NotNull
  public final Map<String, String> e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.profile.LivingProfileReportInfo
 * JD-Core Version:    0.7.0.1
 */