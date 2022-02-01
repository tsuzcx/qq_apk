package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MemberSignature
{
  public static final MemberSignature.Companion Companion = new MemberSignature.Companion(null);
  @NotNull
  private final String signature;
  
  private MemberSignature(String paramString)
  {
    this.signature = paramString;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MemberSignature))
      {
        paramObject = (MemberSignature)paramObject;
        if (Intrinsics.areEqual(this.signature, paramObject.signature)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getSignature$descriptors_jvm()
  {
    return this.signature;
  }
  
  public int hashCode()
  {
    String str = this.signature;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MemberSignature(signature=");
    localStringBuilder.append(this.signature);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature
 * JD-Core Version:    0.7.0.1
 */