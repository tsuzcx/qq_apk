package shark.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/internal/ClassFieldsReader$readInFlightThreadLocal$1", "Ljava/lang/ThreadLocal;", "Lshark/internal/ClassFieldsReader$ReadInFlight;", "Lshark/internal/ClassFieldsReader;", "initialValue", "shark-graph"}, k=1, mv={1, 4, 1})
public final class ClassFieldsReader$readInFlightThreadLocal$1
  extends ThreadLocal<ClassFieldsReader.ReadInFlight>
{
  @NotNull
  protected ClassFieldsReader.ReadInFlight a()
  {
    return new ClassFieldsReader.ReadInFlight(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.ClassFieldsReader.readInFlightThreadLocal.1
 * JD-Core Version:    0.7.0.1
 */