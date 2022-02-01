package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "isMarkedNullable", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "annotations", "", "getAnnotations", "()Ljava/util/List;", "getArguments", "getClassifier", "()Lkotlin/reflect/KClassifier;", "()Z", "arrayClassName", "", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "asString", "equals", "other", "", "hashCode", "", "toString", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.4")
public final class TypeReference
  implements KType
{
  @NotNull
  private final List<KTypeProjection> arguments;
  @NotNull
  private final KClassifier classifier;
  private final boolean isMarkedNullable;
  
  public TypeReference(@NotNull KClassifier paramKClassifier, @NotNull List<KTypeProjection> paramList, boolean paramBoolean)
  {
    this.classifier = paramKClassifier;
    this.arguments = paramList;
    this.isMarkedNullable = paramBoolean;
  }
  
  private final String asString()
  {
    Object localObject2 = getClassifier();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof KClass)) {
      localObject1 = null;
    }
    localObject1 = (KClass)localObject1;
    if (localObject1 != null)
    {
      localObject1 = JvmClassMappingKt.getJavaClass((KClass)localObject1);
      if (localObject1 != null) {
        break label95;
      }
      localObject1 = getClassifier().toString();
      label42:
      if (!getArguments().isEmpty()) {
        break label119;
      }
      localObject2 = "";
      label57:
      if (!isMarkedNullable()) {
        break label164;
      }
    }
    label164:
    for (String str = "?";; str = "")
    {
      return (String)localObject1 + (String)localObject2 + str;
      localObject1 = null;
      break;
      label95:
      if (((Class)localObject1).isArray())
      {
        localObject1 = getArrayClassName((Class)localObject1);
        break label42;
      }
      localObject1 = ((Class)localObject1).getName();
      break label42;
      label119:
      localObject2 = CollectionsKt.joinToString$default((Iterable)getArguments(), (CharSequence)", ", (CharSequence)"<", (CharSequence)">", 0, null, (Function1)new TypeReference.asString.args.1(this), 24, null);
      break label57;
    }
  }
  
  private final String asString(@NotNull KTypeProjection paramKTypeProjection)
  {
    if (paramKTypeProjection.getVariance() == null)
    {
      paramKTypeProjection = "*";
      return paramKTypeProjection;
    }
    Object localObject2 = paramKTypeProjection.getType();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof TypeReference)) {
      localObject1 = null;
    }
    localObject1 = (TypeReference)localObject1;
    if (localObject1 != null)
    {
      localObject1 = ((TypeReference)localObject1).asString();
      if (localObject1 != null)
      {
        localObject2 = paramKTypeProjection.getVariance();
        if (localObject2 != null) {
          break label74;
        }
      }
    }
    for (;;)
    {
      throw new NoWhenBranchMatchedException();
      localObject1 = String.valueOf(paramKTypeProjection.getType());
      break;
      label74:
      paramKTypeProjection = (KTypeProjection)localObject1;
      switch (TypeReference.WhenMappings.$EnumSwitchMapping$0[localObject2.ordinal()])
      {
      }
    }
    return "in " + (String)localObject1;
    return "out " + (String)localObject1;
  }
  
  private final String getArrayClassName(@NotNull Class<?> paramClass)
  {
    if (Intrinsics.areEqual(paramClass, [Z.class)) {
      return "kotlin.BooleanArray";
    }
    if (Intrinsics.areEqual(paramClass, [C.class)) {
      return "kotlin.CharArray";
    }
    if (Intrinsics.areEqual(paramClass, [B.class)) {
      return "kotlin.ByteArray";
    }
    if (Intrinsics.areEqual(paramClass, [S.class)) {
      return "kotlin.ShortArray";
    }
    if (Intrinsics.areEqual(paramClass, [I.class)) {
      return "kotlin.IntArray";
    }
    if (Intrinsics.areEqual(paramClass, [F.class)) {
      return "kotlin.FloatArray";
    }
    if (Intrinsics.areEqual(paramClass, [J.class)) {
      return "kotlin.LongArray";
    }
    if (Intrinsics.areEqual(paramClass, [D.class)) {
      return "kotlin.DoubleArray";
    }
    return "kotlin.Array";
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof TypeReference)) && (Intrinsics.areEqual(getClassifier(), ((TypeReference)paramObject).getClassifier())) && (Intrinsics.areEqual(getArguments(), ((TypeReference)paramObject).getArguments())) && (isMarkedNullable() == ((TypeReference)paramObject).isMarkedNullable());
  }
  
  @NotNull
  public List<Annotation> getAnnotations()
  {
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public List<KTypeProjection> getArguments()
  {
    return this.arguments;
  }
  
  @NotNull
  public KClassifier getClassifier()
  {
    return this.classifier;
  }
  
  public int hashCode()
  {
    return (getClassifier().hashCode() * 31 + getArguments().hashCode()) * 31 + Boolean.valueOf(isMarkedNullable()).hashCode();
  }
  
  public boolean isMarkedNullable()
  {
    return this.isMarkedNullable;
  }
  
  @NotNull
  public String toString()
  {
    return asString() + " (Kotlin reflection is not available)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.jvm.internal.TypeReference
 * JD-Core Version:    0.7.0.1
 */