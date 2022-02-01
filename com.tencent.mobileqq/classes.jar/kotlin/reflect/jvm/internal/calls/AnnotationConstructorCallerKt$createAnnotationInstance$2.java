package kotlin.reflect.jvm.internal.calls;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"equals", "", "T", "", "other", "invoke"}, k=3, mv={1, 1, 16})
final class AnnotationConstructorCallerKt$createAnnotationInstance$2
  extends Lambda
  implements Function1<Object, Boolean>
{
  AnnotationConstructorCallerKt$createAnnotationInstance$2(Class paramClass, List paramList, Map paramMap)
  {
    super(1);
  }
  
  public final boolean invoke(@Nullable Object paramObject)
  {
    boolean bool = paramObject instanceof Annotation;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    } else {
      localObject1 = paramObject;
    }
    Object localObject3 = (Annotation)localObject1;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = JvmClassMappingKt.getAnnotationClass((Annotation)localObject3);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = JvmClassMappingKt.getJavaClass((KClass)localObject3);
      }
    }
    if (Intrinsics.areEqual(localObject1, this.$annotationClass))
    {
      localObject1 = (Iterable)this.$methods;
      if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {}
      do
      {
        while (!((Iterator)localObject1).hasNext())
        {
          i = 1;
          break;
          localObject1 = ((Iterable)localObject1).iterator();
        }
        localObject2 = (Method)((Iterator)localObject1).next();
        localObject3 = this.$values.get(((Method)localObject2).getName());
        localObject2 = ((Method)localObject2).invoke(paramObject, new Object[0]);
        if ((localObject3 instanceof boolean[]))
        {
          localObject3 = (boolean[])localObject3;
          if (localObject2 != null) {
            bool = Arrays.equals((boolean[])localObject3, (boolean[])localObject2);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.BooleanArray");
          }
        }
        else if ((localObject3 instanceof char[]))
        {
          localObject3 = (char[])localObject3;
          if (localObject2 != null) {
            bool = Arrays.equals((char[])localObject3, (char[])localObject2);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharArray");
          }
        }
        else if ((localObject3 instanceof byte[]))
        {
          localObject3 = (byte[])localObject3;
          if (localObject2 != null) {
            bool = Arrays.equals((byte[])localObject3, (byte[])localObject2);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.ByteArray");
          }
        }
        else if ((localObject3 instanceof short[]))
        {
          localObject3 = (short[])localObject3;
          if (localObject2 != null) {
            bool = Arrays.equals((short[])localObject3, (short[])localObject2);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.ShortArray");
          }
        }
        else if ((localObject3 instanceof int[]))
        {
          localObject3 = (int[])localObject3;
          if (localObject2 != null) {
            bool = Arrays.equals((int[])localObject3, (int[])localObject2);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.IntArray");
          }
        }
        else if ((localObject3 instanceof float[]))
        {
          localObject3 = (float[])localObject3;
          if (localObject2 != null) {
            bool = Arrays.equals((float[])localObject3, (float[])localObject2);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.FloatArray");
          }
        }
        else if ((localObject3 instanceof long[]))
        {
          localObject3 = (long[])localObject3;
          if (localObject2 != null) {
            bool = Arrays.equals((long[])localObject3, (long[])localObject2);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.LongArray");
          }
        }
        else if ((localObject3 instanceof double[]))
        {
          localObject3 = (double[])localObject3;
          if (localObject2 != null) {
            bool = Arrays.equals((double[])localObject3, (double[])localObject2);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.DoubleArray");
          }
        }
        else if ((localObject3 instanceof Object[]))
        {
          localObject3 = (Object[])localObject3;
          if (localObject2 != null) {
            bool = Arrays.equals((Object[])localObject3, (Object[])localObject2);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
          }
        }
        else
        {
          bool = Intrinsics.areEqual(localObject3, localObject2);
        }
      } while (bool);
      int i = 0;
      if (i != 0) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance.2
 * JD-Core Version:    0.7.0.1
 */