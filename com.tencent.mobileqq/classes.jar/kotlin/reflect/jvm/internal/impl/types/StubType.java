package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.StubTypeMarker;
import org.jetbrains.annotations.NotNull;

public final class StubType
  extends SimpleType
  implements StubTypeMarker
{
  @NotNull
  private final TypeConstructor constructor;
  private final boolean isMarkedNullable;
  @NotNull
  private final MemberScope memberScope;
  private final TypeConstructor originalTypeVariable;
  
  public StubType(@NotNull TypeConstructor paramTypeConstructor1, boolean paramBoolean, @NotNull TypeConstructor paramTypeConstructor2, @NotNull MemberScope paramMemberScope)
  {
    this.originalTypeVariable = paramTypeConstructor1;
    this.isMarkedNullable = paramBoolean;
    this.constructor = paramTypeConstructor2;
    this.memberScope = paramMemberScope;
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    return Annotations.Companion.getEMPTY();
  }
  
  @NotNull
  public List<TypeProjection> getArguments()
  {
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public TypeConstructor getConstructor()
  {
    return this.constructor;
  }
  
  @NotNull
  public MemberScope getMemberScope()
  {
    return this.memberScope;
  }
  
  public boolean isMarkedNullable()
  {
    return this.isMarkedNullable;
  }
  
  @NotNull
  public SimpleType makeNullableAsSpecified(boolean paramBoolean)
  {
    if (paramBoolean == isMarkedNullable()) {
      return (SimpleType)this;
    }
    return (SimpleType)new StubType(this.originalTypeVariable, paramBoolean, getConstructor(), getMemberScope());
  }
  
  @NotNull
  public StubType refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    return this;
  }
  
  @NotNull
  public SimpleType replaceAnnotations(@NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "newAnnotations");
    return (SimpleType)this;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NonFixed: ");
    localStringBuilder.append(this.originalTypeVariable);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.StubType
 * JD-Core Version:    0.7.0.1
 */