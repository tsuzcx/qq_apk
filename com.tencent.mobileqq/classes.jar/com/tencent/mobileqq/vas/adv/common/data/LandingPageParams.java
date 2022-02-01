package com.tencent.mobileqq.vas.adv.common.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/common/data/LandingPageParams;", "", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "sceneId", "", "componentId", "autoDownloadApp", "", "srcId", "", "(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;IIZLjava/lang/String;)V", "getAdInfo", "()Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "setAdInfo", "(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V", "getAutoDownloadApp", "()Z", "setAutoDownloadApp", "(Z)V", "getComponentId", "()I", "setComponentId", "(I)V", "getSceneId", "setSceneId", "getSrcId", "()Ljava/lang/String;", "setSrcId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public final class LandingPageParams
{
  @NotNull
  private qq_ad_get.QQAdGetRsp.AdInfo adInfo;
  private boolean autoDownloadApp;
  private int componentId;
  private int sceneId;
  @NotNull
  private String srcId;
  
  public LandingPageParams(@NotNull qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, int paramInt1, int paramInt2, boolean paramBoolean, @NotNull String paramString)
  {
    this.adInfo = paramAdInfo;
    this.sceneId = paramInt1;
    this.componentId = paramInt2;
    this.autoDownloadApp = paramBoolean;
    this.srcId = paramString;
  }
  
  @NotNull
  public final qq_ad_get.QQAdGetRsp.AdInfo component1()
  {
    return this.adInfo;
  }
  
  public final int component2()
  {
    return this.sceneId;
  }
  
  public final int component3()
  {
    return this.componentId;
  }
  
  public final boolean component4()
  {
    return this.autoDownloadApp;
  }
  
  @NotNull
  public final String component5()
  {
    return this.srcId;
  }
  
  @NotNull
  public final LandingPageParams copy(@NotNull qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, int paramInt1, int paramInt2, boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramAdInfo, "adInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "srcId");
    return new LandingPageParams(paramAdInfo, paramInt1, paramInt2, paramBoolean, paramString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LandingPageParams))
      {
        paramObject = (LandingPageParams)paramObject;
        if ((Intrinsics.areEqual(this.adInfo, paramObject.adInfo)) && (this.sceneId == paramObject.sceneId) && (this.componentId == paramObject.componentId) && (this.autoDownloadApp == paramObject.autoDownloadApp) && (Intrinsics.areEqual(this.srcId, paramObject.srcId))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final qq_ad_get.QQAdGetRsp.AdInfo getAdInfo()
  {
    return this.adInfo;
  }
  
  public final boolean getAutoDownloadApp()
  {
    return this.autoDownloadApp;
  }
  
  public final int getComponentId()
  {
    return this.componentId;
  }
  
  public final int getSceneId()
  {
    return this.sceneId;
  }
  
  @NotNull
  public final String getSrcId()
  {
    return this.srcId;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void setAdInfo(@NotNull qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAdInfo, "<set-?>");
    this.adInfo = paramAdInfo;
  }
  
  public final void setAutoDownloadApp(boolean paramBoolean)
  {
    this.autoDownloadApp = paramBoolean;
  }
  
  public final void setComponentId(int paramInt)
  {
    this.componentId = paramInt;
  }
  
  public final void setSceneId(int paramInt)
  {
    this.sceneId = paramInt;
  }
  
  public final void setSrcId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.srcId = paramString;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LandingPageParams(adInfo=");
    localStringBuilder.append(this.adInfo);
    localStringBuilder.append(", sceneId=");
    localStringBuilder.append(this.sceneId);
    localStringBuilder.append(", componentId=");
    localStringBuilder.append(this.componentId);
    localStringBuilder.append(", autoDownloadApp=");
    localStringBuilder.append(this.autoDownloadApp);
    localStringBuilder.append(", srcId=");
    localStringBuilder.append(this.srcId);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.common.data.LandingPageParams
 * JD-Core Version:    0.7.0.1
 */