package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lshark/internal/ClassFieldsReader$ReadInFlight;", "Lshark/internal/ClassFieldsReader;", "invoke"}, k=3, mv={1, 4, 1})
final class ClassFieldsReader$classDumpHasReferenceFields$1
  extends Lambda
  implements Function1<ClassFieldsReader.ReadInFlight, Boolean>
{
  ClassFieldsReader$classDumpHasReferenceFields$1(ClassFieldsReader paramClassFieldsReader)
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull ClassFieldsReader.ReadInFlight paramReadInFlight)
  {
    Intrinsics.checkParameterIsNotNull(paramReadInFlight, "$receiver");
    paramReadInFlight.b();
    int j = paramReadInFlight.g();
    int i = 0;
    while (i < j)
    {
      paramReadInFlight.a(paramReadInFlight.a() + ClassFieldsReader.a(this.this$0));
      if (paramReadInFlight.h() == 2) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.ClassFieldsReader.classDumpHasReferenceFields.1
 * JD-Core Version:    0.7.0.1
 */