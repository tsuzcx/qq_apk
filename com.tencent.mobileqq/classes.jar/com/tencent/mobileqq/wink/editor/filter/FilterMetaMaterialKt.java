package com.tencent.mobileqq.wink.editor.filter;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.editor.MetaMaterialKt;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"DEFAULT_SLIDING_VALUE", "", "value", "", "", "adjustParams", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getAdjustParams", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/util/Map;", "setAdjustParams", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/util/Map;)V", "adjustValue", "getAdjustValue", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)I", "setAdjustValue", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;I)V", "", "defaultEffectAlpha", "getDefaultEffectAlpha", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)F", "setDefaultEffectAlpha", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;F)V", "Lcom/tencent/mobileqq/wink/editor/filter/EffectType;", "effectType", "getEffectType", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Lcom/tencent/mobileqq/wink/editor/filter/EffectType;", "setEffectType", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Lcom/tencent/mobileqq/wink/editor/filter/EffectType;)V", "filterSlidingValue", "getFilterSlidingValue", "setFilterSlidingValue", "glowStrength", "getGlowStrength", "setGlowStrength", "imageShowLevel", "getImageShowLevel", "setImageShowLevel", "intensity", "getIntensity", "setIntensity", "", "isDisableForImage", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Z", "setDisableForImage", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Z)V", "isDisableForVideo", "setDisableForVideo", "isEffectExtendReady", "setEffectExtendReady", "isFilterReady", "setFilterReady", "localLutPath", "getLocalLutPath", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/lang/String;", "setLocalLutPath", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;)V", "lutID", "getLutID", "setLutID", "motionID", "getMotionID", "setMotionID", "videoShowLevel", "getVideoShowLevel", "setVideoShowLevel", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class FilterMetaMaterialKt
{
  public static final float a(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$intensity");
    float f = MetaMaterialKt.a(paramMetaMaterial, "intensity", -1.0F);
    if (f == -1.0F)
    {
      f = b(paramMetaMaterial) / 100.0F;
      a(paramMetaMaterial, f);
      return f;
    }
    return f;
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$intensity");
    MetaMaterialKt.a(paramMetaMaterial, "intensity", (Number)Float.valueOf(paramFloat));
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$adjustValue");
    MetaMaterialKt.a(paramMetaMaterial, "adjustValue", (Number)Integer.valueOf(paramInt));
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$lutID");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "lutID", paramString);
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, @Nullable Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$adjustParams");
    MetaMaterialKt.a(paramMetaMaterial, "adjustParams", paramMap);
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static final int b(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$filterSlidingValue");
    return MetaMaterialKt.a(paramMetaMaterial, "filter_sliding_value", 80);
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$defaultEffectAlpha");
    MetaMaterialKt.a(paramMetaMaterial, "defaultEffectAlpha", (Number)Float.valueOf(paramFloat));
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$motionID");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "motionID", paramString);
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static final void c(@NotNull MetaMaterial paramMetaMaterial, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$glowStrength");
    MetaMaterialKt.a(paramMetaMaterial, "glowStrength", (Number)Float.valueOf(paramFloat));
  }
  
  public static final void c(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$localLutPath");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "localLutPath", paramString);
  }
  
  public static final boolean c(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isFilterReady");
    return MetaMaterialKt.g(paramMetaMaterial, "exFilterReady") == 1;
  }
  
  public static final boolean d(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isEffectExtendReady");
    return MetaMaterialKt.g(paramMetaMaterial, "isEffectExtendReady") == 1;
  }
  
  @NotNull
  public static final EffectType e(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$effectType");
    try
    {
      paramMetaMaterial = MetaMaterialKt.f(paramMetaMaterial, "effectType");
      Locale localLocale = Locale.getDefault();
      Intrinsics.checkExpressionValueIsNotNull(localLocale, "Locale.getDefault()");
      if (paramMetaMaterial != null)
      {
        paramMetaMaterial = paramMetaMaterial.toUpperCase(localLocale);
        Intrinsics.checkExpressionValueIsNotNull(paramMetaMaterial, "(this as java.lang.String).toUpperCase(locale)");
        return EffectType.valueOf(paramMetaMaterial);
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    catch (Exception paramMetaMaterial)
    {
      label54:
      break label54;
    }
    return EffectType.CLIENT;
  }
  
  public static final boolean f(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isDisableForImage");
    return MetaMaterialKt.g(paramMetaMaterial, "disableForImage") == 1;
  }
  
  public static final boolean g(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isDisableForVideo");
    return MetaMaterialKt.g(paramMetaMaterial, "disableForVideo") == 1;
  }
  
  public static final int h(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$imageShowLevel");
    return MetaMaterialKt.g(paramMetaMaterial, "imageShowLevel");
  }
  
  public static final int i(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$videoShowLevel");
    return MetaMaterialKt.g(paramMetaMaterial, "videoShowLevel");
  }
  
  @NotNull
  public static final String j(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$lutID");
    return MetaMaterialKt.f(paramMetaMaterial, "lutID");
  }
  
  @NotNull
  public static final String k(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$localLutPath");
    return MetaMaterialKt.f(paramMetaMaterial, "localLutPath");
  }
  
  public static final int l(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$adjustValue");
    return MetaMaterialKt.a(paramMetaMaterial, "adjustValue", -999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.filter.FilterMetaMaterialKt
 * JD-Core Version:    0.7.0.1
 */