package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "", "kotlin.jvm.PlatformType", "T", "invoke"}, k=3, mv={1, 1, 16})
final class KClassImpl$Data$nestedClasses$2
  extends Lambda
  implements Function0<List<? extends KClassImpl<? extends Object>>>
{
  KClassImpl$Data$nestedClasses$2(KClassImpl.Data paramData)
  {
    super(0);
  }
  
  @NotNull
  public final List<KClassImpl<? extends Object>> invoke()
  {
    Object localObject2 = (Iterable)ResolutionScope.DefaultImpls.getContributedDescriptors$default(this.this$0.getDescriptor().getUnsubstitutedInnerClassesScope(), null, null, 3, null);
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (!DescriptorUtils.isEnumEntry((DeclarationDescriptor)localObject3)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList();
    Object localObject3 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (DeclarationDescriptor)((Iterator)localObject3).next();
      if (localObject1 != null)
      {
        localObject1 = UtilKt.toJavaClass((ClassDescriptor)localObject1);
        if (localObject1 != null) {
          localObject1 = new KClassImpl((Class)localObject1);
        } else {
          localObject1 = null;
        }
        if (localObject1 != null) {
          ((Collection)localObject2).add(localObject1);
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      }
    }
    return (List)localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KClassImpl.Data.nestedClasses.2
 * JD-Core Version:    0.7.0.1
 */