package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class ErrorUtils$2
  implements TypeConstructor
{
  ErrorUtils$2(ErrorUtils.ErrorClassDescriptor paramErrorClassDescriptor, String paramString) {}
  
  @NotNull
  public KotlinBuiltIns getBuiltIns()
  {
    DefaultBuiltIns localDefaultBuiltIns = DefaultBuiltIns.getInstance();
    if (localDefaultBuiltIns == null) {
      $$$reportNull$$$0(2);
    }
    return localDefaultBuiltIns;
  }
  
  @Nullable
  public ClassifierDescriptor getDeclarationDescriptor()
  {
    return this.val$errorClass;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getParameters()
  {
    List localList = CollectionsKt.emptyList();
    if (localList == null) {
      $$$reportNull$$$0(0);
    }
    return localList;
  }
  
  @NotNull
  public Collection<KotlinType> getSupertypes()
  {
    List localList = CollectionsKt.emptyList();
    if (localList == null) {
      $$$reportNull$$$0(1);
    }
    return localList;
  }
  
  public boolean isDenotable()
  {
    return false;
  }
  
  @NotNull
  public TypeConstructor refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    if (paramKotlinTypeRefiner == null) {
      $$$reportNull$$$0(3);
    }
    return this;
  }
  
  public String toString()
  {
    return this.val$debugName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.ErrorUtils.2
 * JD-Core Version:    0.7.0.1
 */