package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

final class SourceElement$1
  implements SourceElement
{
  @NotNull
  public SourceFile getContainingFile()
  {
    SourceFile localSourceFile = SourceFile.NO_SOURCE_FILE;
    if (localSourceFile == null) {
      $$$reportNull$$$0(0);
    }
    return localSourceFile;
  }
  
  public String toString()
  {
    return "NO_SOURCE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.1
 * JD-Core Version:    0.7.0.1
 */