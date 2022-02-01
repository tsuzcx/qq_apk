package kotlin.reflect.jvm.internal.calls;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "", "invoke"}, k=3, mv={1, 1, 16})
final class AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2
  extends Lambda
  implements Function0<Integer>
{
  AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2(Map paramMap)
  {
    super(0);
  }
  
  public final int invoke()
  {
    Iterator localIterator = ((Iterable)this.$values.entrySet()).iterator();
    int j = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      int i;
      if ((localObject instanceof boolean[])) {
        i = Arrays.hashCode((boolean[])localObject);
      } else if ((localObject instanceof char[])) {
        i = Arrays.hashCode((char[])localObject);
      } else if ((localObject instanceof byte[])) {
        i = Arrays.hashCode((byte[])localObject);
      } else if ((localObject instanceof short[])) {
        i = Arrays.hashCode((short[])localObject);
      } else if ((localObject instanceof int[])) {
        i = Arrays.hashCode((int[])localObject);
      } else if ((localObject instanceof float[])) {
        i = Arrays.hashCode((float[])localObject);
      } else if ((localObject instanceof long[])) {
        i = Arrays.hashCode((long[])localObject);
      } else if ((localObject instanceof double[])) {
        i = Arrays.hashCode((double[])localObject);
      } else if ((localObject instanceof Object[])) {
        i = Arrays.hashCode((Object[])localObject);
      } else {
        i = localObject.hashCode();
      }
      j += (i ^ str.hashCode() * 127);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance.hashCode.2
 * JD-Core Version:    0.7.0.1
 */