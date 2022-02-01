package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmMemberSignature$Field
  extends JvmMemberSignature
{
  @NotNull
  private final String desc;
  @NotNull
  private final String name;
  
  public JvmMemberSignature$Field(@NotNull String paramString1, @NotNull String paramString2)
  {
    super(null);
    this.name = paramString1;
    this.desc = paramString2;
  }
  
  @NotNull
  public String asString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getName());
    localStringBuilder.append(':');
    localStringBuilder.append(getDesc());
    return localStringBuilder.toString();
  }
  
  @NotNull
  public final String component1()
  {
    return getName();
  }
  
  @NotNull
  public final String component2()
  {
    return getDesc();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Field))
      {
        paramObject = (Field)paramObject;
        if ((Intrinsics.areEqual(getName(), paramObject.getName())) && (Intrinsics.areEqual(getDesc(), paramObject.getDesc()))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public String getDesc()
  {
    return this.desc;
  }
  
  @NotNull
  public String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    String str = getName();
    int j = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = getDesc();
    if (str != null) {
      j = str.hashCode();
    }
    return i * 31 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field
 * JD-Core Version:    0.7.0.1
 */