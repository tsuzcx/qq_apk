package shark;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shark.internal.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/LeakTraceObject;", "Ljava/io/Serializable;", "type", "Lshark/LeakTraceObject$ObjectType;", "className", "", "labels", "", "leakingStatus", "Lshark/LeakTraceObject$LeakingStatus;", "leakingStatusReason", "retainedHeapByteSize", "", "retainedObjectCount", "(Lshark/LeakTraceObject$ObjectType;Ljava/lang/String;Ljava/util/Set;Lshark/LeakTraceObject$LeakingStatus;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getClassName", "()Ljava/lang/String;", "classSimpleName", "getClassSimpleName", "getLabels", "()Ljava/util/Set;", "getLeakingStatus", "()Lshark/LeakTraceObject$LeakingStatus;", "getLeakingStatusReason", "getRetainedHeapByteSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRetainedObjectCount", "getType", "()Lshark/LeakTraceObject$ObjectType;", "typeName", "getTypeName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lshark/LeakTraceObject$ObjectType;Ljava/lang/String;Ljava/util/Set;Lshark/LeakTraceObject$LeakingStatus;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lshark/LeakTraceObject;", "equals", "", "other", "", "hashCode", "toString", "firstLinePrefix", "additionalLinesPrefix", "showLeakingStatus", "toString$shark", "Companion", "LeakingStatus", "ObjectType", "shark"}, k=1, mv={1, 4, 1})
public final class LeakTraceObject
  implements Serializable
{
  @NotNull
  public static final LeakTraceObject.Companion Companion = new LeakTraceObject.Companion(null);
  private static final long serialVersionUID = -3616216391305196341L;
  @NotNull
  private final String className;
  @NotNull
  private final Set<String> labels;
  @NotNull
  private final LeakTraceObject.LeakingStatus leakingStatus;
  @NotNull
  private final String leakingStatusReason;
  @Nullable
  private final Integer retainedHeapByteSize;
  @Nullable
  private final Integer retainedObjectCount;
  @NotNull
  private final LeakTraceObject.ObjectType type;
  
  public LeakTraceObject(@NotNull LeakTraceObject.ObjectType paramObjectType, @NotNull String paramString1, @NotNull Set<String> paramSet, @NotNull LeakTraceObject.LeakingStatus paramLeakingStatus, @NotNull String paramString2, @Nullable Integer paramInteger1, @Nullable Integer paramInteger2)
  {
    this.type = paramObjectType;
    this.className = paramString1;
    this.labels = paramSet;
    this.leakingStatus = paramLeakingStatus;
    this.leakingStatusReason = paramString2;
    this.retainedHeapByteSize = paramInteger1;
    this.retainedObjectCount = paramInteger2;
  }
  
  @NotNull
  public final LeakTraceObject.ObjectType component1()
  {
    return this.type;
  }
  
  @NotNull
  public final String component2()
  {
    return this.className;
  }
  
  @NotNull
  public final Set<String> component3()
  {
    return this.labels;
  }
  
  @NotNull
  public final LeakTraceObject.LeakingStatus component4()
  {
    return this.leakingStatus;
  }
  
  @NotNull
  public final String component5()
  {
    return this.leakingStatusReason;
  }
  
  @Nullable
  public final Integer component6()
  {
    return this.retainedHeapByteSize;
  }
  
  @Nullable
  public final Integer component7()
  {
    return this.retainedObjectCount;
  }
  
  @NotNull
  public final LeakTraceObject copy(@NotNull LeakTraceObject.ObjectType paramObjectType, @NotNull String paramString1, @NotNull Set<String> paramSet, @NotNull LeakTraceObject.LeakingStatus paramLeakingStatus, @NotNull String paramString2, @Nullable Integer paramInteger1, @Nullable Integer paramInteger2)
  {
    Intrinsics.checkParameterIsNotNull(paramObjectType, "type");
    Intrinsics.checkParameterIsNotNull(paramString1, "className");
    Intrinsics.checkParameterIsNotNull(paramSet, "labels");
    Intrinsics.checkParameterIsNotNull(paramLeakingStatus, "leakingStatus");
    Intrinsics.checkParameterIsNotNull(paramString2, "leakingStatusReason");
    return new LeakTraceObject(paramObjectType, paramString1, paramSet, paramLeakingStatus, paramString2, paramInteger1, paramInteger2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LeakTraceObject))
      {
        paramObject = (LeakTraceObject)paramObject;
        if ((Intrinsics.areEqual(this.type, paramObject.type)) && (Intrinsics.areEqual(this.className, paramObject.className)) && (Intrinsics.areEqual(this.labels, paramObject.labels)) && (Intrinsics.areEqual(this.leakingStatus, paramObject.leakingStatus)) && (Intrinsics.areEqual(this.leakingStatusReason, paramObject.leakingStatusReason)) && (Intrinsics.areEqual(this.retainedHeapByteSize, paramObject.retainedHeapByteSize)) && (Intrinsics.areEqual(this.retainedObjectCount, paramObject.retainedObjectCount))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getClassName()
  {
    return this.className;
  }
  
  @NotNull
  public final String getClassSimpleName()
  {
    return StringsKt.a(this.className, '.');
  }
  
  @NotNull
  public final Set<String> getLabels()
  {
    return this.labels;
  }
  
  @NotNull
  public final LeakTraceObject.LeakingStatus getLeakingStatus()
  {
    return this.leakingStatus;
  }
  
  @NotNull
  public final String getLeakingStatusReason()
  {
    return this.leakingStatusReason;
  }
  
  @Nullable
  public final Integer getRetainedHeapByteSize()
  {
    return this.retainedHeapByteSize;
  }
  
  @Nullable
  public final Integer getRetainedObjectCount()
  {
    return this.retainedObjectCount;
  }
  
  @NotNull
  public final LeakTraceObject.ObjectType getType()
  {
    return this.type;
  }
  
  @NotNull
  public final String getTypeName()
  {
    String str = this.type.name();
    Locale localLocale = Locale.US;
    Intrinsics.checkExpressionValueIsNotNull(localLocale, "Locale.US");
    if (str != null)
    {
      str = str.toLowerCase(localLocale);
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).toLowerCase(locale)");
      return str;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public int hashCode()
  {
    Object localObject = this.type;
    int i2 = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.className;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.labels;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.leakingStatus;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.leakingStatusReason;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.retainedHeapByteSize;
    int i1;
    if (localObject != null) {
      i1 = localObject.hashCode();
    } else {
      i1 = 0;
    }
    localObject = this.retainedObjectCount;
    if (localObject != null) {
      i2 = localObject.hashCode();
    }
    return (((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2;
  }
  
  @NotNull
  public String toString()
  {
    return toString$shark$default(this, "", "​  ", true, null, 8, null);
  }
  
  @NotNull
  public final String toString$shark(@NotNull String paramString1, @NotNull String paramString2, boolean paramBoolean, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "firstLinePrefix");
    Intrinsics.checkParameterIsNotNull(paramString2, "additionalLinesPrefix");
    Intrinsics.checkParameterIsNotNull(paramString3, "typeName");
    Object localObject = this.leakingStatus;
    int i = LeakTraceObject.WhenMappings.$EnumSwitchMapping$0[localObject.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("YES (");
          ((StringBuilder)localObject).append(this.leakingStatusReason);
          ((StringBuilder)localObject).append(')');
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          throw new NoWhenBranchMatchedException();
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("NO (");
        ((StringBuilder)localObject).append(this.leakingStatusReason);
        ((StringBuilder)localObject).append(')');
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    else {
      localObject = "UNKNOWN";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(this.className);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString3);
    paramString3 = localStringBuilder.toString();
    paramString1 = paramString3;
    if (paramBoolean)
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString3);
      paramString1.append('\n');
      paramString1.append(paramString2);
      paramString1.append("Leaking: ");
      paramString1.append((String)localObject);
      paramString1 = paramString1.toString();
    }
    localObject = this.retainedHeapByteSize;
    paramString3 = paramString1;
    if (localObject != null)
    {
      paramString3 = LeakTraceObject.Companion.a(Companion, ((Integer)localObject).intValue());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append('\n');
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("Retaining ");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(" in ");
      ((StringBuilder)localObject).append(this.retainedObjectCount);
      ((StringBuilder)localObject).append(" objects");
      paramString3 = ((StringBuilder)localObject).toString();
    }
    paramString1 = this.labels.iterator();
    while (paramString1.hasNext())
    {
      localObject = (String)paramString1.next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString3);
      localStringBuilder.append('\n');
      localStringBuilder.append(paramString2);
      localStringBuilder.append((String)localObject);
      paramString3 = localStringBuilder.toString();
    }
    return paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.LeakTraceObject
 * JD-Core Version:    0.7.0.1
 */