package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class NameAndSignature
{
  @NotNull
  private final Name name;
  @NotNull
  private final String signature;
  
  public NameAndSignature(@NotNull Name paramName, @NotNull String paramString)
  {
    this.name = paramName;
    this.signature = paramString;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof NameAndSignature))
      {
        paramObject = (NameAndSignature)paramObject;
        if ((Intrinsics.areEqual(this.name, paramObject.name)) && (Intrinsics.areEqual(this.signature, paramObject.signature))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final Name getName()
  {
    return this.name;
  }
  
  @NotNull
  public final String getSignature()
  {
    return this.signature;
  }
  
  public int hashCode()
  {
    Object localObject = this.name;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.signature;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NameAndSignature(name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", signature=");
    localStringBuilder.append(this.signature);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.NameAndSignature
 * JD-Core Version:    0.7.0.1
 */