package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Comparator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.Companion;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class MemberComparator
  implements Comparator<DeclarationDescriptor>
{
  public static final MemberComparator INSTANCE = new MemberComparator();
  private static final DescriptorRenderer RENDERER = DescriptorRenderer.Companion.withOptions(new MemberComparator.1());
  
  public int compare(DeclarationDescriptor paramDeclarationDescriptor1, DeclarationDescriptor paramDeclarationDescriptor2)
  {
    Object localObject1 = MemberComparator.NameAndTypeMemberComparator.access$000(paramDeclarationDescriptor1, paramDeclarationDescriptor2);
    if (localObject1 != null) {
      return ((Integer)localObject1).intValue();
    }
    Object localObject2;
    if (((paramDeclarationDescriptor1 instanceof TypeAliasDescriptor)) && ((paramDeclarationDescriptor2 instanceof TypeAliasDescriptor)))
    {
      localObject1 = (TypeAliasDescriptor)paramDeclarationDescriptor1;
      localObject2 = (TypeAliasDescriptor)paramDeclarationDescriptor2;
      i = RENDERER.renderType(((TypeAliasDescriptor)localObject1).getUnderlyingType()).compareTo(RENDERER.renderType(((TypeAliasDescriptor)localObject2).getUnderlyingType()));
      if (i != 0) {
        return i;
      }
    }
    else if (((paramDeclarationDescriptor1 instanceof CallableDescriptor)) && ((paramDeclarationDescriptor2 instanceof CallableDescriptor)))
    {
      localObject2 = (CallableDescriptor)paramDeclarationDescriptor1;
      localObject1 = (CallableDescriptor)paramDeclarationDescriptor2;
      Object localObject3 = ((CallableDescriptor)localObject2).getExtensionReceiverParameter();
      Object localObject4 = ((CallableDescriptor)localObject1).getExtensionReceiverParameter();
      if (localObject3 != null)
      {
        i = RENDERER.renderType(((ReceiverParameterDescriptor)localObject3).getType()).compareTo(RENDERER.renderType(((ReceiverParameterDescriptor)localObject4).getType()));
        if (i != 0) {
          return i;
        }
      }
      localObject3 = ((CallableDescriptor)localObject2).getValueParameters();
      localObject4 = ((CallableDescriptor)localObject1).getValueParameters();
      i = 0;
      int j;
      while (i < Math.min(((List)localObject3).size(), ((List)localObject4).size()))
      {
        j = RENDERER.renderType(((ValueParameterDescriptor)((List)localObject3).get(i)).getType()).compareTo(RENDERER.renderType(((ValueParameterDescriptor)((List)localObject4).get(i)).getType()));
        if (j != 0) {
          return j;
        }
        i += 1;
      }
      i = ((List)localObject3).size() - ((List)localObject4).size();
      if (i != 0) {
        return i;
      }
      localObject3 = ((CallableDescriptor)localObject2).getTypeParameters();
      localObject4 = ((CallableDescriptor)localObject1).getTypeParameters();
      i = 0;
      while (i < Math.min(((List)localObject3).size(), ((List)localObject4).size()))
      {
        List localList1 = ((TypeParameterDescriptor)((List)localObject3).get(i)).getUpperBounds();
        List localList2 = ((TypeParameterDescriptor)((List)localObject4).get(i)).getUpperBounds();
        j = localList1.size() - localList2.size();
        if (j != 0) {
          return j;
        }
        j = 0;
        while (j < localList1.size())
        {
          int k = RENDERER.renderType((KotlinType)localList1.get(j)).compareTo(RENDERER.renderType((KotlinType)localList2.get(j)));
          if (k != 0) {
            return k;
          }
          j += 1;
        }
        i += 1;
      }
      i = ((List)localObject3).size() - ((List)localObject4).size();
      if (i != 0) {
        return i;
      }
      if (((localObject2 instanceof CallableMemberDescriptor)) && ((localObject1 instanceof CallableMemberDescriptor)))
      {
        localObject2 = ((CallableMemberDescriptor)localObject2).getKind();
        localObject1 = ((CallableMemberDescriptor)localObject1).getKind();
        i = ((CallableMemberDescriptor.Kind)localObject2).ordinal() - ((CallableMemberDescriptor.Kind)localObject1).ordinal();
        if (i != 0) {
          return i;
        }
      }
    }
    else
    {
      if ((!(paramDeclarationDescriptor1 instanceof ClassDescriptor)) || (!(paramDeclarationDescriptor2 instanceof ClassDescriptor))) {
        break label702;
      }
      localObject1 = (ClassDescriptor)paramDeclarationDescriptor1;
      localObject2 = (ClassDescriptor)paramDeclarationDescriptor2;
      if (((ClassDescriptor)localObject1).getKind().ordinal() != ((ClassDescriptor)localObject2).getKind().ordinal()) {
        return ((ClassDescriptor)localObject1).getKind().ordinal() - ((ClassDescriptor)localObject2).getKind().ordinal();
      }
      if (((ClassDescriptor)localObject1).isCompanionObject() != ((ClassDescriptor)localObject2).isCompanionObject())
      {
        if (((ClassDescriptor)localObject1).isCompanionObject()) {
          return 1;
        }
        return -1;
      }
    }
    int i = RENDERER.render(paramDeclarationDescriptor1).compareTo(RENDERER.render(paramDeclarationDescriptor2));
    if (i != 0) {
      return i;
    }
    return DescriptorUtils.getContainingModule(paramDeclarationDescriptor1).getName().compareTo(DescriptorUtils.getContainingModule(paramDeclarationDescriptor2).getName());
    label702:
    paramDeclarationDescriptor1 = new AssertionError(String.format("Unsupported pair of descriptors:\n'%s' Class: %s\n%s' Class: %s", new Object[] { paramDeclarationDescriptor1, paramDeclarationDescriptor1.getClass(), paramDeclarationDescriptor2, paramDeclarationDescriptor2.getClass() }));
    for (;;)
    {
      throw paramDeclarationDescriptor1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.MemberComparator
 * JD-Core Version:    0.7.0.1
 */