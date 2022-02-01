package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BinaryVersion
{
  public static final BinaryVersion.Companion Companion = new BinaryVersion.Companion(null);
  private final int major;
  private final int minor;
  private final int[] numbers;
  private final int patch;
  @NotNull
  private final List<Integer> rest;
  
  public BinaryVersion(@NotNull int... paramVarArgs)
  {
    this.numbers = paramVarArgs;
    paramVarArgs = ArraysKt.getOrNull(this.numbers, 0);
    int j = -1;
    if (paramVarArgs != null) {
      i = paramVarArgs.intValue();
    } else {
      i = -1;
    }
    this.major = i;
    paramVarArgs = ArraysKt.getOrNull(this.numbers, 1);
    if (paramVarArgs != null) {
      i = paramVarArgs.intValue();
    } else {
      i = -1;
    }
    this.minor = i;
    paramVarArgs = ArraysKt.getOrNull(this.numbers, 2);
    int i = j;
    if (paramVarArgs != null) {
      i = paramVarArgs.intValue();
    }
    this.patch = i;
    paramVarArgs = this.numbers;
    if (paramVarArgs.length > 3) {
      paramVarArgs = CollectionsKt.toList((Iterable)ArraysKt.asList(paramVarArgs).subList(3, this.numbers.length));
    } else {
      paramVarArgs = CollectionsKt.emptyList();
    }
    this.rest = paramVarArgs;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject != null) && (Intrinsics.areEqual(getClass(), paramObject.getClass())))
    {
      int i = this.major;
      paramObject = (BinaryVersion)paramObject;
      if ((i == paramObject.major) && (this.minor == paramObject.minor) && (this.patch == paramObject.patch) && (Intrinsics.areEqual(this.rest, paramObject.rest))) {
        return true;
      }
    }
    return false;
  }
  
  public final int getMajor()
  {
    return this.major;
  }
  
  public final int getMinor()
  {
    return this.minor;
  }
  
  public int hashCode()
  {
    int i = this.major;
    i += i * 31 + this.minor;
    i += i * 31 + this.patch;
    return i + (i * 31 + this.rest.hashCode());
  }
  
  public final boolean isAtLeast(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.major;
    if (i > paramInt1) {
      return true;
    }
    if (i < paramInt1) {
      return false;
    }
    paramInt1 = this.minor;
    if (paramInt1 > paramInt2) {
      return true;
    }
    if (paramInt1 < paramInt2) {
      return false;
    }
    return this.patch >= paramInt3;
  }
  
  public final boolean isAtLeast(@NotNull BinaryVersion paramBinaryVersion)
  {
    Intrinsics.checkParameterIsNotNull(paramBinaryVersion, "version");
    return isAtLeast(paramBinaryVersion.major, paramBinaryVersion.minor, paramBinaryVersion.patch);
  }
  
  protected final boolean isCompatibleTo(@NotNull BinaryVersion paramBinaryVersion)
  {
    Intrinsics.checkParameterIsNotNull(paramBinaryVersion, "ourVersion");
    int i = this.major;
    if (i == 0)
    {
      if ((paramBinaryVersion.major == 0) && (this.minor == paramBinaryVersion.minor)) {
        return true;
      }
    }
    else if ((i == paramBinaryVersion.major) && (this.minor <= paramBinaryVersion.minor)) {
      return true;
    }
    return false;
  }
  
  @NotNull
  public final int[] toArray()
  {
    return this.numbers;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject = toArray();
    ArrayList localArrayList = new ArrayList();
    int k = localObject.length;
    int i = 0;
    while (i < k)
    {
      int m = localObject[i];
      int j;
      if (m != -1) {
        j = 1;
      } else {
        j = 0;
      }
      if (j == 0) {
        break;
      }
      localArrayList.add(Integer.valueOf(m));
      i += 1;
    }
    localObject = (List)localArrayList;
    if (((List)localObject).isEmpty()) {
      return "unknown";
    }
    return CollectionsKt.joinToString$default((Iterable)localObject, (CharSequence)".", null, null, 0, null, null, 62, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion
 * JD-Core Version:    0.7.0.1
 */