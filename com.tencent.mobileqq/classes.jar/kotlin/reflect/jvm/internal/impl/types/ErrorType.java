package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public class ErrorType
  extends SimpleType
{
  @NotNull
  private final List<TypeProjection> arguments;
  @NotNull
  private final TypeConstructor constructor;
  private final boolean isMarkedNullable;
  @NotNull
  private final MemberScope memberScope;
  @NotNull
  private final String presentableName;
  
  @JvmOverloads
  public ErrorType(@NotNull TypeConstructor paramTypeConstructor, @NotNull MemberScope paramMemberScope)
  {
    this(paramTypeConstructor, paramMemberScope, null, false, null, 28, null);
  }
  
  @JvmOverloads
  public ErrorType(@NotNull TypeConstructor paramTypeConstructor, @NotNull MemberScope paramMemberScope, @NotNull List<? extends TypeProjection> paramList, boolean paramBoolean)
  {
    this(paramTypeConstructor, paramMemberScope, paramList, paramBoolean, null, 16, null);
  }
  
  @JvmOverloads
  public ErrorType(@NotNull TypeConstructor paramTypeConstructor, @NotNull MemberScope paramMemberScope, @NotNull List<? extends TypeProjection> paramList, boolean paramBoolean, @NotNull String paramString)
  {
    this.constructor = paramTypeConstructor;
    this.memberScope = paramMemberScope;
    this.arguments = paramList;
    this.isMarkedNullable = paramBoolean;
    this.presentableName = paramString;
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    return Annotations.Companion.getEMPTY();
  }
  
  @NotNull
  public List<TypeProjection> getArguments()
  {
    return this.arguments;
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
  
  @NotNull
  public String getPresentableName()
  {
    return this.presentableName;
  }
  
  public boolean isMarkedNullable()
  {
    return this.isMarkedNullable;
  }
  
  @NotNull
  public SimpleType makeNullableAsSpecified(boolean paramBoolean)
  {
    return (SimpleType)new ErrorType(getConstructor(), getMemberScope(), getArguments(), paramBoolean, null, 16, null);
  }
  
  @NotNull
  public ErrorType refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
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
    localStringBuilder.append(getConstructor().toString());
    String str;
    if (getArguments().isEmpty()) {
      str = "";
    } else {
      str = CollectionsKt.joinToString((Iterable)getArguments(), (CharSequence)", ", (CharSequence)"<", (CharSequence)">", -1, (CharSequence)"...", null);
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.ErrorType
 * JD-Core Version:    0.7.0.1
 */