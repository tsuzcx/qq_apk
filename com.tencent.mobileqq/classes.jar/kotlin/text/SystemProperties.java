package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/SystemProperties;", "", "()V", "LINE_SEPARATOR", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class SystemProperties
{
  public static final SystemProperties INSTANCE = new SystemProperties();
  @JvmField
  @NotNull
  public static final String LINE_SEPARATOR;
  
  static
  {
    String str = System.getProperty("line.separator");
    if (str == null) {
      Intrinsics.throwNpe();
    }
    LINE_SEPARATOR = str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.SystemProperties
 * JD-Core Version:    0.7.0.1
 */