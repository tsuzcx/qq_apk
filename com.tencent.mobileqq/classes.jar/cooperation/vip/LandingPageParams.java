package cooperation.vip;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/LandingPageParams;", "", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "sceneId", "", "componentId", "autoDownloadApp", "", "srcId", "", "(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;IIZLjava/lang/String;)V", "getAdInfo", "()Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "setAdInfo", "(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V", "getAutoDownloadApp", "()Z", "setAutoDownloadApp", "(Z)V", "getComponentId", "()I", "setComponentId", "(I)V", "getSceneId", "setSceneId", "getSrcId", "()Ljava/lang/String;", "setSrcId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class LandingPageParams
{
  private int jdField_a_of_type_Int;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private qq_ad_get.QQAdGetRsp.AdInfo jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public LandingPageParams(@NotNull qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, int paramInt1, int paramInt2, boolean paramBoolean, @NotNull String paramString)
  {
    this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = paramAdInfo;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final qq_ad_get.QQAdGetRsp.AdInfo a()
  {
    return this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof LandingPageParams))
      {
        paramObject = (LandingPageParams)paramObject;
        if ((!Intrinsics.areEqual(this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo, paramObject.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo)) || (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (this.b != paramObject.b) || (this.jdField_a_of_type_Boolean != paramObject.jdField_a_of_type_Boolean) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    return "LandingPageParams(adInfo=" + this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo + ", sceneId=" + this.jdField_a_of_type_Int + ", componentId=" + this.b + ", autoDownloadApp=" + this.jdField_a_of_type_Boolean + ", srcId=" + this.jdField_a_of_type_JavaLangString + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.LandingPageParams
 * JD-Core Version:    0.7.0.1
 */