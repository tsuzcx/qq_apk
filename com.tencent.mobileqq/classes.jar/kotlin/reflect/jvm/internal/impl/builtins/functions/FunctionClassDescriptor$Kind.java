package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypesKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import org.jetbrains.annotations.NotNull;

public enum FunctionClassDescriptor$Kind
{
  public static final FunctionClassDescriptor.Kind.Companion Companion = new FunctionClassDescriptor.Kind.Companion(null);
  @NotNull
  private final String classNamePrefix;
  @NotNull
  private final FqName packageFqName;
  
  static
  {
    Object localObject1 = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BUILT_INS_PACKAGE_FQ_NAME");
    localObject1 = new Kind("Function", 0, (FqName)localObject1, "Function");
    Function = (Kind)localObject1;
    Object localObject2 = DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME_RELEASE;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "COROUTINES_PACKAGE_FQ_NAME_RELEASE");
    localObject2 = new Kind("SuspendFunction", 1, (FqName)localObject2, "SuspendFunction");
    SuspendFunction = (Kind)localObject2;
    Kind localKind1 = new Kind("KFunction", 2, ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME(), "KFunction");
    KFunction = localKind1;
    Kind localKind2 = new Kind("KSuspendFunction", 3, ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME(), "KSuspendFunction");
    KSuspendFunction = localKind2;
    $VALUES = new Kind[] { localObject1, localObject2, localKind1, localKind2 };
  }
  
  private FunctionClassDescriptor$Kind(FqName paramFqName, String paramString)
  {
    this.packageFqName = paramFqName;
    this.classNamePrefix = paramString;
  }
  
  @NotNull
  public final String getClassNamePrefix()
  {
    return this.classNamePrefix;
  }
  
  @NotNull
  public final FqName getPackageFqName()
  {
    return this.packageFqName;
  }
  
  @NotNull
  public final Name numberedClassName(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.classNamePrefix);
    ((StringBuilder)localObject).append(paramInt);
    localObject = Name.identifier(((StringBuilder)localObject).toString());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Name.identifier(\"$classNamePrefix$arity\")");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Kind
 * JD-Core Version:    0.7.0.1
 */