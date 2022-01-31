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
  public static final KotlinVersion CURRENT = new KotlinVersion(1, 3, 70);
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
    if (paramInt1 < 0) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        break label98;
      }
      throw ((Throwable)new IllegalArgumentException(("Version components are out of range: " + paramInt1 + '.' + paramInt2 + '.' + paramInt3).toString()));
      if ((255 < paramInt1) || (paramInt2 < 0) || (255 < paramInt2) || (paramInt3 < 0) || (255 < paramInt3)) {
        break;
      }
    }
    label98:
    return (paramInt1 << 16) + (paramInt2 << 8) + paramInt3;
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
    if (!(paramObject instanceof KotlinVersion)) {
      paramObject = null;
    }
    for (;;)
    {
      paramObject = (KotlinVersion)paramObject;
      if (paramObject != null) {
        if (this.version != paramObject.version) {
          break label45;
        }
      }
      label45:
      for (boolean bool = true;; bool = false)
      {
        return bool;
        return false;
      }
    }
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
    return (this.major > paramInt1) || ((this.major == paramInt1) && (this.minor >= paramInt2));
  }
  
  public final boolean isAtLeast(int paramInt1, int paramInt2, int paramInt3)
  {
    return (this.major > paramInt1) || ((this.major == paramInt1) && ((this.minor > paramInt2) || ((this.minor == paramInt2) && (this.patch >= paramInt3))));
  }
  
  @NotNull
  public String toString()
  {
    return this.major + '.' + this.minor + '.' + this.patch;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.KotlinVersion
 * JD-Core Version:    0.7.0.1
 */