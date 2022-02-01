package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DescriptorSubstitutor
{
  @NotNull
  public static TypeSubstitutor substituteTypeParameters(@NotNull List<TypeParameterDescriptor> paramList1, @NotNull TypeSubstitution paramTypeSubstitution, @NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull List<TypeParameterDescriptor> paramList2)
  {
    if (paramList1 == null) {
      $$$reportNull$$$0(0);
    }
    if (paramTypeSubstitution == null) {
      $$$reportNull$$$0(1);
    }
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(2);
    }
    if (paramList2 == null) {
      $$$reportNull$$$0(3);
    }
    paramList1 = substituteTypeParameters(paramList1, paramTypeSubstitution, paramDeclarationDescriptor, paramList2, null);
    if (paramList1 != null)
    {
      if (paramList1 == null) {
        $$$reportNull$$$0(4);
      }
      return paramList1;
    }
    throw new AssertionError("Substitution failed");
  }
  
  @Nullable
  public static TypeSubstitutor substituteTypeParameters(@NotNull List<TypeParameterDescriptor> paramList1, @NotNull TypeSubstitution paramTypeSubstitution, @NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull List<TypeParameterDescriptor> paramList2, @Nullable boolean[] paramArrayOfBoolean)
  {
    if (paramList1 == null) {
      $$$reportNull$$$0(5);
    }
    if (paramTypeSubstitution == null) {
      $$$reportNull$$$0(6);
    }
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(7);
    }
    if (paramList2 == null) {
      $$$reportNull$$$0(8);
    }
    Object localObject1 = new HashMap();
    HashMap localHashMap = new HashMap();
    Object localObject2 = paramList1.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      TypeParameterDescriptor localTypeParameterDescriptor = (TypeParameterDescriptor)((Iterator)localObject2).next();
      TypeParameterDescriptorImpl localTypeParameterDescriptorImpl = TypeParameterDescriptorImpl.createForFurtherModification(paramDeclarationDescriptor, localTypeParameterDescriptor.getAnnotations(), localTypeParameterDescriptor.isReified(), localTypeParameterDescriptor.getVariance(), localTypeParameterDescriptor.getName(), i, SourceElement.NO_SOURCE, localTypeParameterDescriptor.getStorageManager());
      ((Map)localObject1).put(localTypeParameterDescriptor.getTypeConstructor(), new TypeProjectionImpl(localTypeParameterDescriptorImpl.getDefaultType()));
      localHashMap.put(localTypeParameterDescriptor, localTypeParameterDescriptorImpl);
      paramList2.add(localTypeParameterDescriptorImpl);
      i += 1;
    }
    paramTypeSubstitution = TypeSubstitutor.createChainedSubstitutor(paramTypeSubstitution, TypeConstructorSubstitution.createByConstructorsMap((Map)localObject1));
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (TypeParameterDescriptor)paramList1.next();
      paramDeclarationDescriptor = (TypeParameterDescriptorImpl)localHashMap.get(paramList2);
      paramList2 = paramList2.getUpperBounds().iterator();
      while (paramList2.hasNext())
      {
        localObject1 = (KotlinType)paramList2.next();
        localObject2 = paramTypeSubstitution.substitute((KotlinType)localObject1, Variance.IN_VARIANCE);
        if (localObject2 == null) {
          return null;
        }
        if ((localObject2 != localObject1) && (paramArrayOfBoolean != null)) {
          paramArrayOfBoolean[0] = true;
        }
        paramDeclarationDescriptor.addUpperBound((KotlinType)localObject2);
      }
      paramDeclarationDescriptor.setInitialized();
    }
    return paramTypeSubstitution;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor
 * JD-Core Version:    0.7.0.1
 */