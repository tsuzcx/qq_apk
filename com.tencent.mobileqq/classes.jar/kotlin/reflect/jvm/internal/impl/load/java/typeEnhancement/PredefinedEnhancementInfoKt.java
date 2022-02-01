package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import org.jetbrains.annotations.NotNull;

public final class PredefinedEnhancementInfoKt
{
  private static final JavaTypeQualifiers NOT_NULLABLE;
  private static final JavaTypeQualifiers NOT_PLATFORM;
  private static final JavaTypeQualifiers NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NULLABLE, null, false, false, 8, null);
  @NotNull
  private static final Map<String, PredefinedFunctionEnhancementInfo> PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
  
  static
  {
    NOT_PLATFORM = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, null, false, false, 8, null);
    NOT_NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, null, true, false, 8, null);
    SignatureBuildingComponents localSignatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
    String str1 = localSignatureBuildingComponents.javaLang("Object");
    String str2 = localSignatureBuildingComponents.javaFunction("Predicate");
    String str3 = localSignatureBuildingComponents.javaFunction("Function");
    String str4 = localSignatureBuildingComponents.javaFunction("Consumer");
    String str5 = localSignatureBuildingComponents.javaFunction("BiFunction");
    String str6 = localSignatureBuildingComponents.javaFunction("BiConsumer");
    String str7 = localSignatureBuildingComponents.javaFunction("UnaryOperator");
    String str8 = localSignatureBuildingComponents.javaUtil("stream/Stream");
    String str9 = localSignatureBuildingComponents.javaUtil("Optional");
    SignatureEnhancementBuilder localSignatureEnhancementBuilder = new SignatureEnhancementBuilder();
    new SignatureEnhancementBuilder.ClassEnhancementBuilder(localSignatureEnhancementBuilder, localSignatureBuildingComponents.javaUtil("Iterator")).function("forEachRemaining", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.1(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new SignatureEnhancementBuilder.ClassEnhancementBuilder(localSignatureEnhancementBuilder, localSignatureBuildingComponents.javaLang("Iterable")).function("spliterator", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.2(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    SignatureEnhancementBuilder.ClassEnhancementBuilder localClassEnhancementBuilder = new SignatureEnhancementBuilder.ClassEnhancementBuilder(localSignatureEnhancementBuilder, localSignatureBuildingComponents.javaUtil("Collection"));
    localClassEnhancementBuilder.function("removeIf", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.3(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    localClassEnhancementBuilder.function("stream", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.4(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    localClassEnhancementBuilder.function("parallelStream", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.5(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new SignatureEnhancementBuilder.ClassEnhancementBuilder(localSignatureEnhancementBuilder, localSignatureBuildingComponents.javaUtil("List")).function("replaceAll", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.6(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    localClassEnhancementBuilder = new SignatureEnhancementBuilder.ClassEnhancementBuilder(localSignatureEnhancementBuilder, localSignatureBuildingComponents.javaUtil("Map"));
    localClassEnhancementBuilder.function("forEach", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.7(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    localClassEnhancementBuilder.function("putIfAbsent", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.8(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    localClassEnhancementBuilder.function("replace", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.9(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    localClassEnhancementBuilder.function("replace", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.10(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    localClassEnhancementBuilder.function("replaceAll", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.11(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    localClassEnhancementBuilder.function("compute", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.12(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    localClassEnhancementBuilder.function("computeIfAbsent", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.13(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    localClassEnhancementBuilder.function("computeIfPresent", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.14(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    localClassEnhancementBuilder.function("merge", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.15(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    localClassEnhancementBuilder = new SignatureEnhancementBuilder.ClassEnhancementBuilder(localSignatureEnhancementBuilder, str9);
    localClassEnhancementBuilder.function("empty", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.16(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    localClassEnhancementBuilder.function("of", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.17(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    localClassEnhancementBuilder.function("ofNullable", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.18(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    localClassEnhancementBuilder.function("get", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.19(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    localClassEnhancementBuilder.function("ifPresent", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.20(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new SignatureEnhancementBuilder.ClassEnhancementBuilder(localSignatureEnhancementBuilder, localSignatureBuildingComponents.javaLang("ref/Reference")).function("get", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.21(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new SignatureEnhancementBuilder.ClassEnhancementBuilder(localSignatureEnhancementBuilder, str2).function("test", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.22(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new SignatureEnhancementBuilder.ClassEnhancementBuilder(localSignatureEnhancementBuilder, localSignatureBuildingComponents.javaFunction("BiPredicate")).function("test", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.23(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new SignatureEnhancementBuilder.ClassEnhancementBuilder(localSignatureEnhancementBuilder, str4).function("accept", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.24(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new SignatureEnhancementBuilder.ClassEnhancementBuilder(localSignatureEnhancementBuilder, str6).function("accept", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.25(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new SignatureEnhancementBuilder.ClassEnhancementBuilder(localSignatureEnhancementBuilder, str3).function("apply", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.26(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new SignatureEnhancementBuilder.ClassEnhancementBuilder(localSignatureEnhancementBuilder, str5).function("apply", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.27(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new SignatureEnhancementBuilder.ClassEnhancementBuilder(localSignatureEnhancementBuilder, localSignatureBuildingComponents.javaFunction("Supplier")).function("get", (Function1)new PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.28(localSignatureBuildingComponents, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE = localSignatureEnhancementBuilder.build();
  }
  
  @NotNull
  public static final Map<String, PredefinedFunctionEnhancementInfo> getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE()
  {
    return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt
 * JD-Core Version:    0.7.0.1
 */