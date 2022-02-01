package shark;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapAnalysisException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "cause", "", "(Ljava/lang/Throwable;)V", "toString", "", "Companion", "shark"}, k=1, mv={1, 4, 1})
public final class HeapAnalysisException
  extends RuntimeException
{
  @NotNull
  public static final HeapAnalysisException.Companion Companion = new HeapAnalysisException.Companion(null);
  private static final long serialVersionUID = -2522323377375290608L;
  
  public HeapAnalysisException(@NotNull Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  @NotNull
  public String toString()
  {
    Object localObject = new StringWriter();
    Throwable localThrowable = getCause();
    if (localThrowable == null) {
      Intrinsics.throwNpe();
    }
    localThrowable.printStackTrace(new PrintWriter((Writer)localObject));
    localObject = ((StringWriter)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "stringWriter.toString()");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapAnalysisException
 * JD-Core Version:    0.7.0.1
 */