package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

class KotlinBuiltIns$2
  implements Function0<KotlinBuiltIns.Primitives>
{
  KotlinBuiltIns$2(KotlinBuiltIns paramKotlinBuiltIns) {}
  
  public KotlinBuiltIns.Primitives invoke()
  {
    EnumMap localEnumMap = new EnumMap(PrimitiveType.class);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    PrimitiveType[] arrayOfPrimitiveType = PrimitiveType.values();
    int j = arrayOfPrimitiveType.length;
    int i = 0;
    while (i < j)
    {
      PrimitiveType localPrimitiveType = arrayOfPrimitiveType[i];
      SimpleType localSimpleType1 = KotlinBuiltIns.access$200(this.this$0, localPrimitiveType.getTypeName().asString());
      SimpleType localSimpleType2 = KotlinBuiltIns.access$200(this.this$0, localPrimitiveType.getArrayTypeName().asString());
      localEnumMap.put(localPrimitiveType, localSimpleType2);
      localHashMap1.put(localSimpleType1, localSimpleType2);
      localHashMap2.put(localSimpleType2, localSimpleType1);
      i += 1;
    }
    return new KotlinBuiltIns.Primitives(localEnumMap, localHashMap1, localHashMap2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.2
 * JD-Core Version:    0.7.0.1
 */