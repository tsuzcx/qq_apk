package shark;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ObjectInspectors$ANONYMOUS_CLASS;", "Lshark/ObjectInspectors;", "inspect", "", "reporter", "Lshark/ObjectReporter;", "shark"}, k=1, mv={1, 4, 1})
final class ObjectInspectors$ANONYMOUS_CLASS
  extends ObjectInspectors
{
  ObjectInspectors$ANONYMOUS_CLASS()
  {
    super(str, i, null);
  }
  
  public void inspect(@NotNull ObjectReporter paramObjectReporter)
  {
    Intrinsics.checkParameterIsNotNull(paramObjectReporter, "reporter");
    Object localObject1 = paramObjectReporter.d();
    Object localObject2;
    if ((localObject1 instanceof HeapObject.HeapInstance))
    {
      localObject2 = ((HeapObject.HeapInstance)localObject1).k();
      localObject1 = (CharSequence)((HeapObject.HeapClass)localObject2).h();
      if (ObjectInspectors.access$getANONYMOUS_CLASS_NAME_PATTERN_REGEX$cp().matches((CharSequence)localObject1))
      {
        localObject1 = ((HeapObject.HeapClass)localObject2).m();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        if (!Intrinsics.areEqual(((HeapObject.HeapClass)localObject1).h(), "java.lang.Object")) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = Class.forName(((HeapObject.HeapClass)localObject2).h());
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "actualClass");
        localObject2 = ((Class)localObject1).getInterfaces();
        localObject1 = (Collection)paramObjectReporter.a();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "interfaces");
        if (localObject2.length != 0) {
          break label230;
        }
        i = 1;
        if ((i ^ 0x1) == 0) {
          break label235;
        }
        paramObjectReporter = localObject2[0];
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Anonymous class implementing ");
        Intrinsics.checkExpressionValueIsNotNull(paramObjectReporter, "implementedInterface");
        ((StringBuilder)localObject2).append(paramObjectReporter.getName());
        paramObjectReporter = ((StringBuilder)localObject2).toString();
        ((Collection)localObject1).add(paramObjectReporter);
        return;
      }
      catch (ClassNotFoundException paramObjectReporter)
      {
        return;
      }
      paramObjectReporter = (Collection)paramObjectReporter.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Anonymous subclass of ");
      ((StringBuilder)localObject2).append(((HeapObject.HeapClass)localObject1).h());
      paramObjectReporter.add(((StringBuilder)localObject2).toString());
      return;
      label230:
      int i = 0;
      continue;
      label235:
      paramObjectReporter = "Anonymous subclass of java.lang.Object";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ObjectInspectors.ANONYMOUS_CLASS
 * JD-Core Version:    0.7.0.1
 */