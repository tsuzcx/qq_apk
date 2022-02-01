package shark;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ObjectInspectors;", "", "Lshark/ObjectInspector;", "(Ljava/lang/String;I)V", "leakingObjectFilter", "Lkotlin/Function1;", "Lshark/HeapObject;", "Lkotlin/ParameterName;", "name", "heapObject", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "KEYED_WEAK_REFERENCE", "CLASSLOADER", "CLASS", "ANONYMOUS_CLASS", "THREAD", "Companion", "shark"}, k=1, mv={1, 4, 1})
public enum ObjectInspectors
  implements ObjectInspector
{
  private static final String ANONYMOUS_CLASS_NAME_PATTERN = "^.+\\$\\d+$";
  private static final Regex ANONYMOUS_CLASS_NAME_PATTERN_REGEX;
  @NotNull
  public static final ObjectInspectors.Companion Companion;
  @NotNull
  private static final List<FilteringLeakingObjectFinder.LeakingObjectFilter> jdkLeakingObjectFilters;
  @Nullable
  private final Function1<HeapObject, Boolean> leakingObjectFilter;
  
  static
  {
    Object localObject1 = new ObjectInspectors.KEYED_WEAK_REFERENCE("KEYED_WEAK_REFERENCE", 0);
    KEYED_WEAK_REFERENCE = (ObjectInspectors)localObject1;
    Object localObject2 = new ObjectInspectors.CLASSLOADER("CLASSLOADER", 1);
    CLASSLOADER = (ObjectInspectors)localObject2;
    ObjectInspectors.CLASS localCLASS = new ObjectInspectors.CLASS("CLASS", 2);
    CLASS = localCLASS;
    ObjectInspectors.ANONYMOUS_CLASS localANONYMOUS_CLASS = new ObjectInspectors.ANONYMOUS_CLASS("ANONYMOUS_CLASS", 3);
    ANONYMOUS_CLASS = localANONYMOUS_CLASS;
    ObjectInspectors.THREAD localTHREAD = new ObjectInspectors.THREAD("THREAD", 4);
    THREAD = localTHREAD;
    $VALUES = new ObjectInspectors[] { localObject1, localObject2, localCLASS, localANONYMOUS_CLASS, localTHREAD };
    Companion = new ObjectInspectors.Companion(null);
    ANONYMOUS_CLASS_NAME_PATTERN_REGEX = new Regex("^.+\\$\\d+$");
    localObject1 = Companion;
    localObject2 = EnumSet.allOf(ObjectInspectors.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "EnumSet.allOf(ObjectInspectors::class.java)");
    jdkLeakingObjectFilters = ((ObjectInspectors.Companion)localObject1).a((Set)localObject2);
  }
  
  private ObjectInspectors() {}
  
  @Nullable
  public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark()
  {
    return this.leakingObjectFilter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ObjectInspectors
 * JD-Core Version:    0.7.0.1
 */