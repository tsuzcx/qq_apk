package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

final class NewCapturedTypeConstructor$refine$$inlined$let$lambda$1
  extends Lambda
  implements Function0<List<? extends UnwrappedType>>
{
  NewCapturedTypeConstructor$refine$$inlined$let$lambda$1(NewCapturedTypeConstructor paramNewCapturedTypeConstructor, KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    super(0);
  }
  
  @NotNull
  public final List<UnwrappedType> invoke()
  {
    Object localObject = (Iterable)this.this$0.getSupertypes();
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((UnwrappedType)((Iterator)localObject).next()).refine(this.$kotlinTypeRefiner$inlined));
    }
    return (List)localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor.refine..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */