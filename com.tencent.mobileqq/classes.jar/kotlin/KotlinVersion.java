package kotlin;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/KotlinVersion;", "", "major", "", "minor", "(II)V", "patch", "(III)V", "getMajor", "()I", "getMinor", "getPatch", "version", "compareTo", "other", "equals", "", "", "hashCode", "isAtLeast", "toString", "", "versionOf", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public final class KotlinVersion
  implements Comparable<KotlinVersion>
{
  @JvmField
  @NotNull
  public static final KotlinVersion CURRENT = new KotlinVersion(1, 3, 72);
  public static final KotlinVersion.Companion Companion = new KotlinVersion.Companion(null);
  public static final int MAX_COMPONENT_VALUE = 255;
  private final int major;
  private final int minor;
  private final int patch;
  private final int version;
  
  public KotlinVersion(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 0);
  }
  
  public KotlinVersion(int paramInt1, int paramInt2, int paramInt3)
  {
    this.major = paramInt1;
    this.minor = paramInt2;
    this.patch = paramInt3;
    this.version = versionOf(this.major, this.minor, this.patch);
  }
  
  private final int versionOf(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((paramInt1 >= 0) && (255 >= paramInt1) && (paramInt2 >= 0) && (255 >= paramInt2) && (paramInt3 >= 0) && (255 >= paramInt3)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return (paramInt1 << 16) + (paramInt2 << 8) + paramInt3;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Version components are out of range: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append('.');
    localStringBuilder.append(paramInt2);
    localStringBuilder.append('.');
    localStringBuilder.append(paramInt3);
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
  }
  
  public int compareTo(@NotNull KotlinVersion paramKotlinVersion)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinVersion, "other");
    return this.version - paramKotlinVersion.version;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((KotlinVersion)this == paramObject) {
      return true;
    }
    Object localObject = paramObject;
    if (!(paramObject instanceof KotlinVersion)) {
      localObject = null;
    }
    paramObject = (KotlinVersion)localObject;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if (this.version == paramObject.version) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final int getMajor()
  {
    return this.major;
  }
  
  public final int getMinor()
  {
    return this.minor;
  }
  
  public final int getPatch()
  {
    return this.patch;
  }
  
  public int hashCode()
  {
    return this.version;
  }
  
  public final boolean isAtLeast(int paramInt1, int paramInt2)
  {
    int i = this.major;
    return (i > paramInt1) || ((i == paramInt1) && (this.minor >= paramInt2));
  }
  
  public final boolean isAtLeast(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.major;
    if (i <= paramInt1) {
      if (i == paramInt1)
      {
        paramInt1 = this.minor;
        if ((paramInt1 > paramInt2) || ((paramInt1 == paramInt2) && (this.patch >= paramInt3))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.major);
    localStringBuilder.append('.');
    localStringBuilder.append(this.minor);
    localStringBuilder.append('.');
    localStringBuilder.append(this.patch);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.KotlinVersion
 * JD-Core Version:    0.7.0.1
 */