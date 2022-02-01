package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import org.jetbrains.annotations.NotNull;

public abstract class FlexibleType
  extends UnwrappedType
  implements SubtypingRepresentatives, FlexibleTypeMarker
{
  @NotNull
  private final SimpleType lowerBound;
  @NotNull
  private final SimpleType upperBound;
  
  public FlexibleType(@NotNull SimpleType paramSimpleType1, @NotNull SimpleType paramSimpleType2)
  {
    super(null);
    this.lowerBound = paramSimpleType1;
    this.upperBound = paramSimpleType2;
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    return getDelegate().getAnnotations();
  }
  
  @NotNull
  public List<TypeProjection> getArguments()
  {
    return getDelegate().getArguments();
  }
  
  @NotNull
  public TypeConstructor getConstructor()
  {
    return getDelegate().getConstructor();
  }
  
  @NotNull
  public abstract SimpleType getDelegate();
  
  @NotNull
  public final SimpleType getLowerBound()
  {
    return this.lowerBound;
  }
  
  @NotNull
  public MemberScope getMemberScope()
  {
    return getDelegate().getMemberScope();
  }
  
  @NotNull
  public KotlinType getSubTypeRepresentative()
  {
    return (KotlinType)this.lowerBound;
  }
  
  @NotNull
  public KotlinType getSuperTypeRepresentative()
  {
    return (KotlinType)this.upperBound;
  }
  
  @NotNull
  public final SimpleType getUpperBound()
  {
    return this.upperBound;
  }
  
  public boolean isMarkedNullable()
  {
    return getDelegate().isMarkedNullable();
  }
  
  @NotNull
  public abstract String render(@NotNull DescriptorRenderer paramDescriptorRenderer, @NotNull DescriptorRendererOptions paramDescriptorRendererOptions);
  
  public boolean sameTypeConstructor(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "type");
    return false;
  }
  
  @NotNull
  public String toString()
  {
    return DescriptorRenderer.DEBUG_TEXT.renderType((KotlinType)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.FlexibleType
 * JD-Core Version:    0.7.0.1
 */