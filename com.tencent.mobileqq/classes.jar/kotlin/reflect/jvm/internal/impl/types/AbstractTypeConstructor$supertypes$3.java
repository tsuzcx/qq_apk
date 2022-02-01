package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import org.jetbrains.annotations.NotNull;

final class AbstractTypeConstructor$supertypes$3
  extends Lambda
  implements Function1<AbstractTypeConstructor.Supertypes, Unit>
{
  AbstractTypeConstructor$supertypes$3(AbstractTypeConstructor paramAbstractTypeConstructor)
  {
    super(1);
  }
  
  public final void invoke(@NotNull AbstractTypeConstructor.Supertypes paramSupertypes)
  {
    Intrinsics.checkParameterIsNotNull(paramSupertypes, "supertypes");
    Object localObject1 = this.this$0.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect((TypeConstructor)this.this$0, paramSupertypes.getAllSupertypes(), (Function1)new AbstractTypeConstructor.supertypes.3.resultWithoutCycles.1(this), (Function1)new AbstractTypeConstructor.supertypes.3.resultWithoutCycles.2(this));
    boolean bool = ((Collection)localObject1).isEmpty();
    Object localObject2 = null;
    if (bool)
    {
      localObject1 = this.this$0.defaultSupertypeIfEmpty();
      if (localObject1 != null) {
        localObject1 = CollectionsKt.listOf(localObject1);
      } else {
        localObject1 = null;
      }
      if (localObject1 == null) {
        localObject1 = CollectionsKt.emptyList();
      }
      localObject1 = (Collection)localObject1;
    }
    this.this$0.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect((TypeConstructor)this.this$0, (Collection)localObject1, (Function1)new AbstractTypeConstructor.supertypes.3.2(this), (Function1)new AbstractTypeConstructor.supertypes.3.3(this));
    if ((localObject1 instanceof List)) {
      localObject2 = localObject1;
    }
    localObject2 = (List)localObject2;
    if (localObject2 != null) {
      localObject1 = localObject2;
    } else {
      localObject1 = CollectionsKt.toList((Iterable)localObject1);
    }
    paramSupertypes.setSupertypesWithoutCycles((List)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.supertypes.3
 * JD-Core Version:    0.7.0.1
 */