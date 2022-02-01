package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.KParameter.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "R", "invoke"}, k=3, mv={1, 1, 16})
final class KCallableImpl$_parameters$1
  extends Lambda
  implements Function0<ArrayList<KParameter>>
{
  KCallableImpl$_parameters$1(KCallableImpl paramKCallableImpl)
  {
    super(0);
  }
  
  @NotNull
  public final ArrayList<KParameter> invoke()
  {
    Object localObject1 = this.this$0.getDescriptor();
    ArrayList localArrayList = new ArrayList();
    boolean bool = this.this$0.isBound();
    int k = 0;
    int i;
    if (!bool)
    {
      localObject2 = UtilKt.getInstanceReceiverParameter((CallableDescriptor)localObject1);
      if (localObject2 != null)
      {
        localArrayList.add(new KParameterImpl(this.this$0, 0, KParameter.Kind.INSTANCE, (Function0)new KCallableImpl._parameters.1.1((ReceiverParameterDescriptor)localObject2)));
        j = 1;
      }
      else
      {
        j = 0;
      }
      localObject2 = ((CallableMemberDescriptor)localObject1).getExtensionReceiverParameter();
      i = j;
      if (localObject2 != null)
      {
        localArrayList.add(new KParameterImpl(this.this$0, j, KParameter.Kind.EXTENSION_RECEIVER, (Function0)new KCallableImpl._parameters.1.2((ReceiverParameterDescriptor)localObject2)));
        i = j + 1;
      }
    }
    else
    {
      i = 0;
    }
    Object localObject2 = ((CallableMemberDescriptor)localObject1).getValueParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "descriptor.valueParameters");
    int m = ((Collection)localObject2).size();
    int j = k;
    while (j < m)
    {
      localArrayList.add(new KParameterImpl(this.this$0, i, KParameter.Kind.VALUE, (Function0)new KCallableImpl._parameters.1.3((CallableMemberDescriptor)localObject1, j)));
      j += 1;
      i += 1;
    }
    if ((this.this$0.isAnnotationConstructor()) && ((localObject1 instanceof JavaCallableMemberDescriptor)))
    {
      localObject1 = (List)localArrayList;
      if (((List)localObject1).size() > 1) {
        CollectionsKt.sortWith((List)localObject1, (Comparator)new KCallableImpl._parameters.1..special..inlined.sortBy.1());
      }
    }
    localArrayList.trimToSize();
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KCallableImpl._parameters.1
 * JD-Core Version:    0.7.0.1
 */