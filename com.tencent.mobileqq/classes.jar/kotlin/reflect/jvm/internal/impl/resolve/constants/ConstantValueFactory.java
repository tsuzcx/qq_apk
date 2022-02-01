package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ConstantValueFactory
{
  public static final ConstantValueFactory INSTANCE = new ConstantValueFactory();
  
  private final ArrayValue createArrayValue(List<?> paramList, PrimitiveType paramPrimitiveType)
  {
    Object localObject1 = (Iterable)CollectionsKt.toList((Iterable)paramList);
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      localObject2 = ((ConstantValueFactory)this).createConstantValue(localObject2);
      if (localObject2 != null) {
        paramList.add(localObject2);
      }
    }
    return new ArrayValue((List)paramList, (Function1)new ConstantValueFactory.createArrayValue.3(paramPrimitiveType));
  }
  
  @NotNull
  public final ArrayValue createArrayValue(@NotNull List<? extends ConstantValue<?>> paramList, @NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "value");
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "type");
    return new ArrayValue(paramList, (Function1)new ConstantValueFactory.createArrayValue.1(paramKotlinType));
  }
  
  @Nullable
  public final ConstantValue<?> createConstantValue(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Byte)) {
      return (ConstantValue)new ByteValue(((Number)paramObject).byteValue());
    }
    if ((paramObject instanceof Short)) {
      return (ConstantValue)new ShortValue(((Number)paramObject).shortValue());
    }
    if ((paramObject instanceof Integer)) {
      return (ConstantValue)new IntValue(((Number)paramObject).intValue());
    }
    if ((paramObject instanceof Long)) {
      return (ConstantValue)new LongValue(((Number)paramObject).longValue());
    }
    if ((paramObject instanceof Character)) {
      return (ConstantValue)new CharValue(((Character)paramObject).charValue());
    }
    if ((paramObject instanceof Float)) {
      return (ConstantValue)new FloatValue(((Number)paramObject).floatValue());
    }
    if ((paramObject instanceof Double)) {
      return (ConstantValue)new DoubleValue(((Number)paramObject).doubleValue());
    }
    if ((paramObject instanceof Boolean)) {
      return (ConstantValue)new BooleanValue(((Boolean)paramObject).booleanValue());
    }
    if ((paramObject instanceof String)) {
      return (ConstantValue)new StringValue((String)paramObject);
    }
    if ((paramObject instanceof byte[])) {
      return (ConstantValue)createArrayValue(ArraysKt.toList((byte[])paramObject), PrimitiveType.BYTE);
    }
    if ((paramObject instanceof short[])) {
      return (ConstantValue)createArrayValue(ArraysKt.toList((short[])paramObject), PrimitiveType.SHORT);
    }
    if ((paramObject instanceof int[])) {
      return (ConstantValue)createArrayValue(ArraysKt.toList((int[])paramObject), PrimitiveType.INT);
    }
    if ((paramObject instanceof long[])) {
      return (ConstantValue)createArrayValue(ArraysKt.toList((long[])paramObject), PrimitiveType.LONG);
    }
    if ((paramObject instanceof char[])) {
      return (ConstantValue)createArrayValue(ArraysKt.toList((char[])paramObject), PrimitiveType.CHAR);
    }
    if ((paramObject instanceof float[])) {
      return (ConstantValue)createArrayValue(ArraysKt.toList((float[])paramObject), PrimitiveType.FLOAT);
    }
    if ((paramObject instanceof double[])) {
      return (ConstantValue)createArrayValue(ArraysKt.toList((double[])paramObject), PrimitiveType.DOUBLE);
    }
    if ((paramObject instanceof boolean[])) {
      return (ConstantValue)createArrayValue(ArraysKt.toList((boolean[])paramObject), PrimitiveType.BOOLEAN);
    }
    if (paramObject == null) {
      return (ConstantValue)new NullValue();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory
 * JD-Core Version:    0.7.0.1
 */