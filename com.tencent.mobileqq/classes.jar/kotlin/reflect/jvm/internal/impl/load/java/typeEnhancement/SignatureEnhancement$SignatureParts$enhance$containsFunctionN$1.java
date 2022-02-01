package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

final class SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1
  extends Lambda
  implements Function1<UnwrappedType, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1()
  {
    super(1);
  }
  
  public final boolean invoke(UnwrappedType paramUnwrappedType)
  {
    paramUnwrappedType = paramUnwrappedType.getConstructor().getDeclarationDescriptor();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramUnwrappedType != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramUnwrappedType, "it.constructor.declarati… ?: return@contains false");
      bool1 = bool2;
      if (Intrinsics.areEqual(paramUnwrappedType.getName(), JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME().shortName()))
      {
        bool1 = bool2;
        if (Intrinsics.areEqual(DescriptorUtilsKt.fqNameOrNull((DeclarationDescriptor)paramUnwrappedType), JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.enhance.containsFunctionN.1
 * JD-Core Version:    0.7.0.1
 */