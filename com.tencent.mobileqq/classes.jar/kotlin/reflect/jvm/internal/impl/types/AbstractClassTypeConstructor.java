package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractClassTypeConstructor
  extends AbstractTypeConstructor
  implements TypeConstructor
{
  private int hashCode = 0;
  
  public AbstractClassTypeConstructor(@NotNull StorageManager paramStorageManager)
  {
    super(paramStorageManager);
  }
  
  private static boolean areFqNamesEqual(ClassDescriptor paramClassDescriptor1, ClassDescriptor paramClassDescriptor2)
  {
    if (!paramClassDescriptor1.getName().equals(paramClassDescriptor2.getName())) {
      return false;
    }
    DeclarationDescriptor localDeclarationDescriptor = paramClassDescriptor1.getContainingDeclaration();
    paramClassDescriptor1 = paramClassDescriptor2.getContainingDeclaration();
    paramClassDescriptor2 = localDeclarationDescriptor;
    while ((paramClassDescriptor2 != null) && (paramClassDescriptor1 != null))
    {
      if ((paramClassDescriptor2 instanceof ModuleDescriptor)) {
        return paramClassDescriptor1 instanceof ModuleDescriptor;
      }
      if ((paramClassDescriptor1 instanceof ModuleDescriptor)) {
        return false;
      }
      if ((paramClassDescriptor2 instanceof PackageFragmentDescriptor)) {
        return ((paramClassDescriptor1 instanceof PackageFragmentDescriptor)) && (((PackageFragmentDescriptor)paramClassDescriptor2).getFqName().equals(((PackageFragmentDescriptor)paramClassDescriptor1).getFqName()));
      }
      if ((paramClassDescriptor1 instanceof PackageFragmentDescriptor)) {
        return false;
      }
      if (!paramClassDescriptor2.getName().equals(paramClassDescriptor1.getName())) {
        return false;
      }
      paramClassDescriptor2 = paramClassDescriptor2.getContainingDeclaration();
      paramClassDescriptor1 = paramClassDescriptor1.getContainingDeclaration();
    }
    return true;
  }
  
  private static boolean hasMeaningfulFqName(@NotNull ClassifierDescriptor paramClassifierDescriptor)
  {
    if (paramClassifierDescriptor == null) {
      $$$reportNull$$$0(2);
    }
    return (!ErrorUtils.isError(paramClassifierDescriptor)) && (!DescriptorUtils.isLocal(paramClassifierDescriptor));
  }
  
  @Nullable
  protected KotlinType defaultSupertypeIfEmpty()
  {
    if (KotlinBuiltIns.isSpecialClassWithNoSupertypes(getDeclarationDescriptor())) {
      return null;
    }
    return getBuiltIns().getAnyType();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof TypeConstructor)) {
      return false;
    }
    if (paramObject.hashCode() != hashCode()) {
      return false;
    }
    Object localObject = (TypeConstructor)paramObject;
    if (((TypeConstructor)localObject).getParameters().size() != getParameters().size()) {
      return false;
    }
    paramObject = getDeclarationDescriptor();
    localObject = ((TypeConstructor)localObject).getDeclarationDescriptor();
    if (hasMeaningfulFqName(paramObject))
    {
      if ((localObject != null) && (!hasMeaningfulFqName((ClassifierDescriptor)localObject))) {
        return false;
      }
      if ((localObject instanceof ClassDescriptor)) {
        return areFqNamesEqual((ClassDescriptor)paramObject, (ClassDescriptor)localObject);
      }
    }
    return false;
  }
  
  @NotNull
  protected Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean paramBoolean)
  {
    Object localObject2 = getDeclarationDescriptor().getContainingDeclaration();
    if (!(localObject2 instanceof ClassDescriptor))
    {
      localObject1 = Collections.emptyList();
      if (localObject1 == null) {
        $$$reportNull$$$0(3);
      }
      return localObject1;
    }
    Object localObject1 = new SmartList();
    localObject2 = (ClassDescriptor)localObject2;
    ((Collection)localObject1).add(((ClassDescriptor)localObject2).getDefaultType());
    localObject2 = ((ClassDescriptor)localObject2).getCompanionObjectDescriptor();
    if ((paramBoolean) && (localObject2 != null)) {
      ((Collection)localObject1).add(((ClassDescriptor)localObject2).getDefaultType());
    }
    return localObject1;
  }
  
  @NotNull
  public KotlinBuiltIns getBuiltIns()
  {
    KotlinBuiltIns localKotlinBuiltIns = DescriptorUtilsKt.getBuiltIns(getDeclarationDescriptor());
    if (localKotlinBuiltIns == null) {
      $$$reportNull$$$0(1);
    }
    return localKotlinBuiltIns;
  }
  
  @NotNull
  public abstract ClassDescriptor getDeclarationDescriptor();
  
  public final int hashCode()
  {
    int i = this.hashCode;
    if (i != 0) {
      return i;
    }
    ClassDescriptor localClassDescriptor = getDeclarationDescriptor();
    if (hasMeaningfulFqName(localClassDescriptor)) {
      i = DescriptorUtils.getFqName(localClassDescriptor).hashCode();
    } else {
      i = System.identityHashCode(this);
    }
    this.hashCode = i;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor
 * JD-Core Version:    0.7.0.1
 */