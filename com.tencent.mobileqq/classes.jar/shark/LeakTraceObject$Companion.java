package shark;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/LeakTraceObject$Companion;", "", "()V", "serialVersionUID", "", "humanReadableByteCount", "", "bytes", "shark"}, k=1, mv={1, 4, 1})
public final class LeakTraceObject$Companion
{
  private final String a(long paramLong)
  {
    if (paramLong < 1000)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" B");
      return ((StringBuilder)localObject).toString();
    }
    double d1 = paramLong;
    double d2 = Math.log(d1);
    double d3 = 1000;
    int i = (int)(d2 / Math.log(d3));
    char c = "kMGTPE".charAt(i - 1);
    Object localObject = StringCompanionObject.INSTANCE;
    localObject = new Object[2];
    d2 = Math.pow(d3, i);
    Double.isNaN(d1);
    localObject[0] = Double.valueOf(d1 / d2);
    localObject[1] = Character.valueOf(c);
    localObject = String.format("%.1f %sB", Arrays.copyOf((Object[])localObject, localObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.LeakTraceObject.Companion
 * JD-Core Version:    0.7.0.1
 */