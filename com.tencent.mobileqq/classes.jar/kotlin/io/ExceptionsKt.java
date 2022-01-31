package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"constructMessage", "", "file", "Ljava/io/File;", "other", "reason", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class ExceptionsKt
{
  private static final String constructMessage(File paramFile1, File paramFile2, String paramString)
  {
    paramFile1 = new StringBuilder(paramFile1.toString());
    if (paramFile2 != null) {
      paramFile1.append(" -> " + paramFile2);
    }
    if (paramString != null) {
      paramFile1.append(": " + paramString);
    }
    paramFile1 = paramFile1.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramFile1, "sb.toString()");
    return paramFile1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.io.ExceptionsKt
 * JD-Core Version:    0.7.0.1
 */