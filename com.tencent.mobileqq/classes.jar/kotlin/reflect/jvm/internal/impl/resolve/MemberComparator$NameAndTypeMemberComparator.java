package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Comparator;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.Nullable;

public class MemberComparator$NameAndTypeMemberComparator
  implements Comparator<DeclarationDescriptor>
{
  public static final NameAndTypeMemberComparator INSTANCE = new NameAndTypeMemberComparator();
  
  @Nullable
  private static Integer compareInternal(DeclarationDescriptor paramDeclarationDescriptor1, DeclarationDescriptor paramDeclarationDescriptor2)
  {
    int i = getDeclarationPriority(paramDeclarationDescriptor2) - getDeclarationPriority(paramDeclarationDescriptor1);
    if (i != 0) {
      return Integer.valueOf(i);
    }
    if ((DescriptorUtils.isEnumEntry(paramDeclarationDescriptor1)) && (DescriptorUtils.isEnumEntry(paramDeclarationDescriptor2))) {
      return Integer.valueOf(0);
    }
    i = paramDeclarationDescriptor1.getName().compareTo(paramDeclarationDescriptor2.getName());
    if (i != 0) {
      return Integer.valueOf(i);
    }
    return null;
  }
  
  private static int getDeclarationPriority(DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (DescriptorUtils.isEnumEntry(paramDeclarationDescriptor)) {
      return 8;
    }
    if ((paramDeclarationDescriptor instanceof ConstructorDescriptor)) {
      return 7;
    }
    if ((paramDeclarationDescriptor instanceof PropertyDescriptor))
    {
      if (((PropertyDescriptor)paramDeclarationDescriptor).getExtensionReceiverParameter() == null) {
        return 6;
      }
      return 5;
    }
    if ((paramDeclarationDescriptor instanceof FunctionDescriptor))
    {
      if (((FunctionDescriptor)paramDeclarationDescriptor).getExtensionReceiverParameter() == null) {
        return 4;
      }
      return 3;
    }
    if ((paramDeclarationDescriptor instanceof ClassDescriptor)) {
      return 2;
    }
    if ((paramDeclarationDescriptor instanceof TypeAliasDescriptor)) {
      return 1;
    }
    return 0;
  }
  
  public int compare(DeclarationDescriptor paramDeclarationDescriptor1, DeclarationDescriptor paramDeclarationDescriptor2)
  {
    paramDeclarationDescriptor1 = compareInternal(paramDeclarationDescriptor1, paramDeclarationDescriptor2);
    if (paramDeclarationDescriptor1 != null) {
      return paramDeclarationDescriptor1.intValue();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.MemberComparator.NameAndTypeMemberComparator
 * JD-Core Version:    0.7.0.1
 */