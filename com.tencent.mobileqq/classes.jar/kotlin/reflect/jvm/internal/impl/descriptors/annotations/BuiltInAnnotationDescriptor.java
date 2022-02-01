package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class BuiltInAnnotationDescriptor
  implements AnnotationDescriptor
{
  @NotNull
  private final Map<Name, ConstantValue<?>> allValueArguments;
  private final KotlinBuiltIns builtIns;
  @NotNull
  private final FqName fqName;
  @NotNull
  private final Lazy type$delegate;
  
  public BuiltInAnnotationDescriptor(@NotNull KotlinBuiltIns paramKotlinBuiltIns, @NotNull FqName paramFqName, @NotNull Map<Name, ? extends ConstantValue<?>> paramMap)
  {
    this.builtIns = paramKotlinBuiltIns;
    this.fqName = paramFqName;
    this.allValueArguments = paramMap;
    this.type$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new BuiltInAnnotationDescriptor.type.2(this));
  }
  
  @NotNull
  public Map<Name, ConstantValue<?>> getAllValueArguments()
  {
    return this.allValueArguments;
  }
  
  @NotNull
  public FqName getFqName()
  {
    return this.fqName;
  }
  
  @NotNull
  public SourceElement getSource()
  {
    SourceElement localSourceElement = SourceElement.NO_SOURCE;
    Intrinsics.checkExpressionValueIsNotNull(localSourceElement, "SourceElement.NO_SOURCE");
    return localSourceElement;
  }
  
  @NotNull
  public KotlinType getType()
  {
    return (KotlinType)this.type$delegate.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor
 * JD-Core Version:    0.7.0.1
 */