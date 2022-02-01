package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class VersionRequirement$Version
{
  public static final VersionRequirement.Version.Companion Companion = new VersionRequirement.Version.Companion(null);
  @JvmField
  @NotNull
  public static final Version INFINITY = new Version(256, 256, 256);
  private final int major;
  private final int minor;
  private final int patch;
  
  public VersionRequirement$Version(int paramInt1, int paramInt2, int paramInt3)
  {
    this.major = paramInt1;
    this.minor = paramInt2;
    this.patch = paramInt3;
  }
  
  @NotNull
  public final String asString()
  {
    StringBuilder localStringBuilder;
    int i;
    if (this.patch == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.major);
      localStringBuilder.append('.');
      i = this.minor;
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.major);
      localStringBuilder.append('.');
      localStringBuilder.append(this.minor);
      localStringBuilder.append('.');
      i = this.patch;
    }
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Version))
      {
        paramObject = (Version)paramObject;
        if ((this.major == paramObject.major) && (this.minor == paramObject.minor) && (this.patch == paramObject.patch)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    return (this.major * 31 + this.minor) * 31 + this.patch;
  }
  
  @NotNull
  public String toString()
  {
    return asString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version
 * JD-Core Version:    0.7.0.1
 */