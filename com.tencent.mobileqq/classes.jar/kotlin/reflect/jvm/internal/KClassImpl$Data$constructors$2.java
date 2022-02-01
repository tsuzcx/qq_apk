package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/KFunction;", "T", "", "invoke"}, k=3, mv={1, 1, 16})
final class KClassImpl$Data$constructors$2
  extends Lambda
  implements Function0<List<? extends KFunction<? extends T>>>
{
  KClassImpl$Data$constructors$2(KClassImpl.Data paramData)
  {
    super(0);
  }
  
  @NotNull
  public final List<KFunction<T>> invoke()
  {
    Object localObject = (Iterable)this.this$0.this$0.getConstructorDescriptors();
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ConstructorDescriptor localConstructorDescriptor = (ConstructorDescriptor)((Iterator)localObject).next();
      localCollection.add((KFunction)new KFunctionImpl((KDeclarationContainerImpl)this.this$0.this$0, (FunctionDescriptor)localConstructorDescriptor));
    }
    return (List)localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KClassImpl.Data.constructors.2
 * JD-Core Version:    0.7.0.1
 */