package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KotlinClassFinder$Result$ClassFileContent
  extends KotlinClassFinder.Result
{
  @NotNull
  private final byte[] content;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ClassFileContent))
      {
        paramObject = (ClassFileContent)paramObject;
        if (Intrinsics.areEqual(this.content, paramObject.content)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final byte[] getContent()
  {
    return this.content;
  }
  
  public int hashCode()
  {
    byte[] arrayOfByte = this.content;
    if (arrayOfByte != null) {
      return Arrays.hashCode(arrayOfByte);
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ClassFileContent(content=");
    localStringBuilder.append(Arrays.toString(this.content));
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result.ClassFileContent
 * JD-Core Version:    0.7.0.1
 */