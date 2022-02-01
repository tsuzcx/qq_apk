package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import org.jetbrains.annotations.NotNull;

final class PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$8
  extends Lambda
  implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>
{
  PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$8(SignatureBuildingComponents paramSignatureBuildingComponents, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    super(1);
  }
  
  public final void invoke(@NotNull SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder paramFunctionEnhancementBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionEnhancementBuilder, "$receiver");
    paramFunctionEnhancementBuilder.parameter(this.$JLObject$inlined, new JavaTypeQualifiers[] { PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p() });
    paramFunctionEnhancementBuilder.parameter(this.$JLObject$inlined, new JavaTypeQualifiers[] { PredefinedEnhancementInfoKt.access$getNOT_PLATFORM$p() });
    paramFunctionEnhancementBuilder.returns(this.$JLObject$inlined, new JavaTypeQualifiers[] { PredefinedEnhancementInfoKt.access$getNULLABLE$p() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt..special..inlined.enhancement.lambda.8
 * JD-Core Version:    0.7.0.1
 */