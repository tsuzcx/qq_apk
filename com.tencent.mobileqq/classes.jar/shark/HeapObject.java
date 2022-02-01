package shark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapObject;", "", "()V", "asClass", "Lshark/HeapObject$HeapClass;", "getAsClass", "()Lshark/HeapObject$HeapClass;", "asInstance", "Lshark/HeapObject$HeapInstance;", "getAsInstance", "()Lshark/HeapObject$HeapInstance;", "asObjectArray", "Lshark/HeapObject$HeapObjectArray;", "getAsObjectArray", "()Lshark/HeapObject$HeapObjectArray;", "asPrimitiveArray", "Lshark/HeapObject$HeapPrimitiveArray;", "getAsPrimitiveArray", "()Lshark/HeapObject$HeapPrimitiveArray;", "graph", "Lshark/HeapGraph;", "getGraph", "()Lshark/HeapGraph;", "objectId", "", "getObjectId", "()J", "objectIndex", "", "getObjectIndex", "()I", "recordSize", "getRecordSize", "readRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "Companion", "HeapClass", "HeapInstance", "HeapObjectArray", "HeapPrimitiveArray", "shark-graph"}, k=1, mv={1, 4, 1})
public abstract class HeapObject
{
  @NotNull
  public static final HeapObject.Companion a = new HeapObject.Companion(null);
  @NotNull
  private static final Map<String, PrimitiveType> b;
  private static final Set<String> c;
  
  static
  {
    Object localObject1 = PrimitiveType.values();
    Object localObject2 = (Collection)new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      localObject4 = new StringBuilder();
      str1 = ((PrimitiveType)localObject3).name();
      localObject5 = Locale.US;
      Intrinsics.checkExpressionValueIsNotNull(localObject5, "Locale.US");
      if (str1 != null)
      {
        str1 = str1.toLowerCase((Locale)localObject5);
        Intrinsics.checkExpressionValueIsNotNull(str1, "(this as java.lang.String).toLowerCase(locale)");
        ((StringBuilder)localObject4).append(str1);
        ((StringBuilder)localObject4).append("[]");
        ((Collection)localObject2).add(TuplesKt.to(((StringBuilder)localObject4).toString(), localObject3));
        i += 1;
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    b = MapsKt.toMap((Iterable)localObject2);
    localObject1 = Boolean.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "Boolean::class.javaObjectType.name");
    localObject2 = Character.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "Char::class.javaObjectType.name");
    Object localObject3 = Float.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "Float::class.javaObjectType.name");
    Object localObject4 = Double.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "Double::class.javaObjectType.name");
    String str1 = Byte.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str1, "Byte::class.javaObjectType.name");
    Object localObject5 = Short.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject5, "Short::class.javaObjectType.name");
    String str2 = Integer.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str2, "Int::class.javaObjectType.name");
    String str3 = Long.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str3, "Long::class.javaObjectType.name");
    c = SetsKt.setOf(new String[] { localObject1, localObject2, localObject3, localObject4, str1, localObject5, str2, str3 });
  }
  
  @NotNull
  public abstract HeapGraph a();
  
  public abstract long b();
  
  @NotNull
  public abstract HprofRecord.HeapDumpRecord.ObjectRecord c();
  
  public abstract int d();
  
  @Nullable
  public final HeapObject.HeapClass e()
  {
    if ((this instanceof HeapObject.HeapClass)) {
      return (HeapObject.HeapClass)this;
    }
    return null;
  }
  
  @Nullable
  public final HeapObject.HeapInstance f()
  {
    if ((this instanceof HeapObject.HeapInstance)) {
      return (HeapObject.HeapInstance)this;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapObject
 * JD-Core Version:    0.7.0.1
 */