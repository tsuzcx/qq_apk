package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public class TypeUtils$SpecialType
  extends DelegatingSimpleType
{
  private final String name;
  
  public TypeUtils$SpecialType(String paramString)
  {
    this.name = paramString;
  }
  
  @NotNull
  protected SimpleType getDelegate()
  {
    throw new IllegalStateException(this.name);
  }
  
  @NotNull
  public SimpleType makeNullableAsSpecified(boolean paramBoolean)
  {
    throw new IllegalStateException(this.name);
  }
  
  @NotNull
  public SpecialType refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    if (paramKotlinTypeRefiner == null) {
      $$$reportNull$$$0(3);
    }
    return this;
  }
  
  @NotNull
  public SimpleType replaceAnnotations(@NotNull Annotations paramAnnotations)
  {
    if (paramAnnotations == null) {
      $$$reportNull$$$0(0);
    }
    throw new IllegalStateException(this.name);
  }
  
  @NotNull
  public DelegatingSimpleType replaceDelegate(@NotNull SimpleType paramSimpleType)
  {
    if (paramSimpleType == null) {
      $$$reportNull$$$0(2);
    }
    throw new IllegalStateException(this.name);
  }
  
  @NotNull
  public String toString()
  {
    String str = this.name;
    if (str == null) {
      $$$reportNull$$$0(1);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeUtils.SpecialType
 * JD-Core Version:    0.7.0.1
 */