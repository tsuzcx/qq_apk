package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.DeprecationLevel;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.VersionKind;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class VersionRequirement
{
  public static final VersionRequirement.Companion Companion = new VersionRequirement.Companion(null);
  @Nullable
  private final Integer errorCode;
  @NotNull
  private final ProtoBuf.VersionRequirement.VersionKind kind;
  @NotNull
  private final DeprecationLevel level;
  @Nullable
  private final String message;
  @NotNull
  private final VersionRequirement.Version version;
  
  public VersionRequirement(@NotNull VersionRequirement.Version paramVersion, @NotNull ProtoBuf.VersionRequirement.VersionKind paramVersionKind, @NotNull DeprecationLevel paramDeprecationLevel, @Nullable Integer paramInteger, @Nullable String paramString)
  {
    this.version = paramVersion;
    this.kind = paramVersionKind;
    this.level = paramDeprecationLevel;
    this.errorCode = paramInteger;
    this.message = paramString;
  }
  
  @NotNull
  public final ProtoBuf.VersionRequirement.VersionKind getKind()
  {
    return this.kind;
  }
  
  @NotNull
  public final VersionRequirement.Version getVersion()
  {
    return this.version;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("since ");
    localStringBuilder.append(this.version);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.level);
    Object localObject = this.errorCode;
    String str = "";
    if (localObject != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" error ");
      ((StringBuilder)localObject).append(this.errorCode);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localObject = str;
    if (this.message != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(": ");
      ((StringBuilder)localObject).append(this.message);
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement
 * JD-Core Version:    0.7.0.1
 */