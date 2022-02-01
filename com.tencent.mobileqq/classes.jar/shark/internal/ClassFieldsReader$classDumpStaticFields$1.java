package shark.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import shark.HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/util/ArrayList;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "Lkotlin/collections/ArrayList;", "Lshark/internal/ClassFieldsReader$ReadInFlight;", "Lshark/internal/ClassFieldsReader;", "invoke"}, k=3, mv={1, 4, 1})
final class ClassFieldsReader$classDumpStaticFields$1
  extends Lambda
  implements Function1<ClassFieldsReader.ReadInFlight, ArrayList<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord>>
{
  public static final 1 INSTANCE = new 1();
  
  ClassFieldsReader$classDumpStaticFields$1()
  {
    super(1);
  }
  
  @NotNull
  public final ArrayList<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord> invoke(@NotNull ClassFieldsReader.ReadInFlight paramReadInFlight)
  {
    Intrinsics.checkParameterIsNotNull(paramReadInFlight, "$receiver");
    int j = paramReadInFlight.g();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      long l = paramReadInFlight.i();
      int k = paramReadInFlight.h();
      localArrayList.add(new HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord(l, k, paramReadInFlight.b(k)));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.ClassFieldsReader.classDumpStaticFields.1
 * JD-Core Version:    0.7.0.1
 */