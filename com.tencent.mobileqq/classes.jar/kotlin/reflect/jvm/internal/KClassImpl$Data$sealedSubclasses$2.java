package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"}, k=3, mv={1, 1, 16})
final class KClassImpl$Data$sealedSubclasses$2
  extends Lambda
  implements Function0<List<? extends KClassImpl<? extends T>>>
{
  KClassImpl$Data$sealedSubclasses$2(KClassImpl.Data paramData)
  {
    super(0);
  }
  
  @NotNull
  public final List<KClassImpl<? extends T>> invoke()
  {
    Object localObject = this.this$0.getDescriptor().getSealedSubclasses();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "descriptor.sealedSubclasses");
    localObject = (Iterable)localObject;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = ((Iterable)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (ClassDescriptor)localIterator.next();
      if (localObject != null)
      {
        localObject = UtilKt.toJavaClass((ClassDescriptor)localObject);
        if (localObject != null) {
          localObject = new KClassImpl((Class)localObject);
        } else {
          localObject = null;
        }
        if (localObject != null) {
          localCollection.add(localObject);
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      }
    }
    return (List)localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KClassImpl.Data.sealedSubclasses.2
 * JD-Core Version:    0.7.0.1
 */