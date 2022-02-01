package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "T", "", "invoke"}, k=3, mv={1, 1, 16})
final class KClassImpl$Data$supertypes$2
  extends Lambda
  implements Function0<List<? extends KTypeImpl>>
{
  KClassImpl$Data$supertypes$2(KClassImpl.Data paramData)
  {
    super(0);
  }
  
  @NotNull
  public final List<KTypeImpl> invoke()
  {
    Object localObject1 = this.this$0.getDescriptor().getTypeConstructor();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "descriptor.typeConstructor");
    Object localObject2 = ((TypeConstructor)localObject1).getSupertypes();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "descriptor.typeConstructor.supertypes");
    localObject1 = new ArrayList(((Collection)localObject2).size());
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject4;
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = ((Iterator)localObject2).next();
      localObject3 = (Collection)localObject1;
      localObject4 = (KotlinType)localObject4;
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "kotlinType");
      ((Collection)localObject3).add(new KTypeImpl((KotlinType)localObject4, (Function0)new KClassImpl.Data.supertypes.2..special..inlined.mapTo.lambda.1((KotlinType)localObject4, this)));
    }
    localObject2 = (Collection)localObject1;
    if (!KotlinBuiltIns.isSpecialClassWithNoSupertypes(this.this$0.getDescriptor()))
    {
      localObject3 = (Iterable)localObject1;
      boolean bool = localObject3 instanceof Collection;
      int j = 1;
      int i;
      if ((bool) && (((Collection)localObject3).isEmpty()))
      {
        i = j;
      }
      else
      {
        localObject3 = ((Iterable)localObject3).iterator();
        do
        {
          i = j;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = DescriptorUtils.getClassDescriptorForType(((KTypeImpl)((Iterator)localObject3).next()).getType());
          Intrinsics.checkExpressionValueIsNotNull(localObject4, "DescriptorUtils.getClassDescriptorForType(it.type)");
          localObject4 = ((ClassDescriptor)localObject4).getKind();
          Intrinsics.checkExpressionValueIsNotNull(localObject4, "DescriptorUtils.getClass…ptorForType(it.type).kind");
          if ((localObject4 != ClassKind.INTERFACE) && (localObject4 != ClassKind.ANNOTATION_CLASS)) {
            i = 0;
          } else {
            i = 1;
          }
        } while (i != 0);
        i = 0;
      }
      if (i != 0)
      {
        localObject3 = DescriptorUtilsKt.getBuiltIns((DeclarationDescriptor)this.this$0.getDescriptor()).getAnyType();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "descriptor.builtIns.anyType");
        ((Collection)localObject2).add(new KTypeImpl((KotlinType)localObject3, (Function0)KClassImpl.Data.supertypes.2.3.INSTANCE));
      }
    }
    return CollectionsKt.compact((ArrayList)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KClassImpl.Data.supertypes.2
 * JD-Core Version:    0.7.0.1
 */