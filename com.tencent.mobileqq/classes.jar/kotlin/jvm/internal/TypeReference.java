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
    Object localObject1 = getClassifier();
    boolean bool = localObject1 instanceof KClass;
    String str = null;
    if (!bool) {
      localObject1 = null;
    }
    Object localObject2 = (KClass)localObject1;
    localObject1 = str;
    if (localObject2 != null) {
      localObject1 = JvmClassMappingKt.getJavaClass((KClass)localObject2);
    }
    if (localObject1 == null) {
      localObject1 = getClassifier().toString();
    } else if (((Class)localObject1).isArray()) {
      localObject1 = getArrayClassName((Class)localObject1);
    } else {
      localObject1 = ((Class)localObject1).getName();
    }
    bool = getArguments().isEmpty();
    localObject2 = "";
    if (bool) {
      str = "";
    } else {
      str = CollectionsKt.joinToString$default((Iterable)getArguments(), (CharSequence)", ", (CharSequence)"<", (CharSequence)">", 0, null, (Function1)new TypeReference.asString.args.1(this), 24, null);
    }
    if (isMarkedNullable()) {
      localObject2 = "?";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(str);
    localStringBuilder.append((String)localObject2);
    return localStringBuilder.toString();
  }
  
  private final String asString(@NotNull KTypeProjection paramKTypeProjection)
  {
    if (paramKTypeProjection.getVariance() == null) {
      return "*";
    }
    KType localKType = paramKTypeProjection.getType();
    Object localObject = localKType;
    if (!(localKType instanceof TypeReference)) {
      localObject = null;
    }
    localObject = (TypeReference)localObject;
    if (localObject != null)
    {
      localObject = ((TypeReference)localObject).asString();
      if (localObject != null) {}
    }
    else
    {
      localObject = String.valueOf(paramKTypeProjection.getType());
    }
    paramKTypeProjection = paramKTypeProjection.getVariance();
    if (paramKTypeProjection != null)
    {
      int i = TypeReference.WhenMappings.$EnumSwitchMapping$0[paramKTypeProjection.ordinal()];
      paramKTypeProjection = (KTypeProjection)localObject;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            paramKTypeProjection = new StringBuilder();
            paramKTypeProjection.append("out ");
            paramKTypeProjection.append((String)localObject);
            return paramKTypeProjection.toString();
          }
        }
        else
        {
          paramKTypeProjection = new StringBuilder();
          paramKTypeProjection.append("in ");
          paramKTypeProjection.append((String)localObject);
          paramKTypeProjection = paramKTypeProjection.toString();
        }
      }
      else {
        return paramKTypeProjection;
      }
    }
    throw new NoWhenBranchMatchedException();
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
    if ((paramObject instanceof TypeReference))
    {
      KClassifier localKClassifier = getClassifier();
      paramObject = (TypeReference)paramObject;
      if ((Intrinsics.areEqual(localKClassifier, paramObject.getClassifier())) && (Intrinsics.areEqual(getArguments(), paramObject.getArguments())) && (isMarkedNullable() == paramObject.isMarkedNullable())) {
        return true;
      }
    }
    return false;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(asString());
    localStringBuilder.append(" (Kotlin reflection is not available)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.jvm.internal.TypeReference
 * JD-Core Version:    0.7.0.1
 */